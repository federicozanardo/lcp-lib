package lcp.lib.communication.module.channel;

import lcp.lib.communication.module.Module;
import lcp.lib.exceptions.communication.module.RegisterModuleException;

public interface Mediator {
    void registerModule(Module module) throws RegisterModuleException;

    void send(ChannelMessage message);

    ChannelMessage sendAndReceive(ChannelMessage message);
}
