package lcp.lib.communication.module.channel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ChannelMessage {
    private final String senderModuleId;
    private final ChannelMessagePayload payload;
}
