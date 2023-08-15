package lcp.lib.communication.module.channel;

public record ChannelMessage(String senderModuleId, ChannelMessagePayload channelMessagePayload) {
}
