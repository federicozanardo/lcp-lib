package lcp.lib.communication.module.channel;

import lcp.lib.communication.module.Module;
import lcp.lib.exceptions.communication.module.RegisterModuleException;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ModuleChannel implements Mediator {
    @Getter
    private String channelId;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final List<Module> modules = new ArrayList<>();

    public void registerModule(Module module) throws RegisterModuleException {
        if (modules.size() < 2) {
            if (modules.isEmpty()) {
                modules.add(module);
            } else {
                if (!modules.get(0).getId().equals(module.getId())) {
                    modules.add(module);
                    channelId = buildChannelId(modules.get(0).getId(), modules.get(1).getId());
                    logger.debug("New channelId: {}", channelId);
                } else {
                    logger.error("Impossible to add the same module twice!");
                    throw new RegisterModuleException("Impossible to add the same module twice!");
                }
            }
        } else {
            logger.error("Impossible to register more than 2 modules!");
            throw new RegisterModuleException("Impossible to register more than 2 modules!");
        }
    }

    public static String buildChannelId(String firstModuleId, String secondModuleId) {
        return firstModuleId + "-" + secondModuleId;
    }

    @Override
    public void send(ChannelMessage message) {
        logger.debug("[{}] from: {}, payload: {}", new Object(){}.getClass().getEnclosingMethod().getName(), message.getSenderModuleId(), message.getChannelMessagePayload());

        for (Module module : modules) {
            if (!module.getId().equals(message.getSenderModuleId())) {
                module.receive(message);
            }
        }
    }

    @Override
    public ChannelMessage sendAndReceive(ChannelMessage message) {
        logger.debug("[{}] from: {}, payload: {}", new Object(){}.getClass().getEnclosingMethod().getName(), message.getSenderModuleId(), message.getChannelMessagePayload());
        ChannelMessage result = null;

        for (Module module : modules) {
            if (!module.getId().equals(message.getSenderModuleId())) {
                result = module.receiveAndResponse(message);
            }
        }

        return result;
    }
}
