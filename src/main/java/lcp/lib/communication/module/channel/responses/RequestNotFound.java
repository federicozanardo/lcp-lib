package lcp.lib.communication.module.channel.responses;

import lcp.lib.communication.module.channel.ChannelMessagePayload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class RequestNotFound extends ChannelMessagePayload {
    private final String request;
}
