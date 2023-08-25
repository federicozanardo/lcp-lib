package lcp.lib.communication.module;

import lcp.lib.communication.module.channel.ChannelMessage;
import lcp.lib.communication.module.channel.ChannelMessagePayload;
import lcp.lib.communication.module.channel.ModuleChannel;
import lcp.lib.exceptions.communication.module.channel.RegisterChannelException;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Getter
    private final String id = this.getClass().getSimpleName();
    protected final List<ModuleChannel> channels = new ArrayList<>();

    public void registerChannel(ModuleChannel channel) throws RegisterChannelException {
        for (ModuleChannel moduleChannel : channels) {
            if (moduleChannel.getChannelId().equals(channel.getChannelId())) {
                logger.error("Already added this channel!");
                throw new RegisterChannelException("Already added this channel!");
            }
        }

        logger.debug("Add new channel: {}", channel.getChannelId());
        channels.add(channel);
    }

    public ModuleChannel findChannel(String senderModuleId, String receiverModuleId) {
        String channelId = ModuleChannel.buildChannelId(senderModuleId, receiverModuleId);

        for (ModuleChannel channel : channels) {
            if (channel.getChannelId().equals(channelId)) {
                return channel;
            }
        }

        channelId = ModuleChannel.buildChannelId(receiverModuleId, senderModuleId);

        for (ModuleChannel channel : channels) {
            if (channel.getChannelId().equals(channelId)) {
                return channel;
            }
        }

        return null;
    }

    public void send(String receiverModuleId, ChannelMessagePayload payload) {
        logger.debug("[{}] payload: {}", new Object() {
        }.getClass().getEnclosingMethod().getName(), payload);
        ModuleChannel channel = this.findChannel(this.getId(), receiverModuleId);

        if (channel != null) {
            channel.send(new ChannelMessage(this.getId(), payload));
        } else {
            logger.error("Impossible to find a channel with {}!", receiverModuleId);
        }
    }

    public abstract void receive(ChannelMessage message);

    public ChannelMessage sendAndReceive(String receiverModuleId, ChannelMessagePayload payload) {
        logger.debug("[{}] payload: {}", new Object() {
        }.getClass().getEnclosingMethod().getName(), payload);
        ModuleChannel channel = this.findChannel(this.getId(), receiverModuleId);

        if (channel != null) {
            return channel.sendAndReceive(new ChannelMessage(this.getId(), payload));
        } else {
            logger.error("Impossible to find a channel with {}!", receiverModuleId);
            return null;
        }
    }

    public abstract ChannelMessage receiveAndResponse(ChannelMessage message);

}
