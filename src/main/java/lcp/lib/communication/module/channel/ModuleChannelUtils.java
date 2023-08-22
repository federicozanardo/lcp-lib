package lcp.lib.communication.module.channel;

import lcp.lib.communication.module.Module;
import lcp.lib.exceptions.communication.module.RegisterModuleException;
import lcp.lib.exceptions.communication.module.channel.RegisterChannelException;

public class ModuleChannelUtils {
    public static void setupChannel(Module firstModule, Module secondModule) throws RegisterModuleException, RegisterChannelException {
        ModuleChannel channel = createChannel(firstModule, secondModule);
        firstModule.registerChannel(channel);
        secondModule.registerChannel(channel);
    }

    private static ModuleChannel createChannel(Module firstModule, Module secondModule) throws RegisterModuleException {
        ModuleChannel channel = new ModuleChannel();
        channel.registerModule(firstModule);
        channel.registerModule(secondModule);
        return channel;
    }
}
