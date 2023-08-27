package lcp.lib.models.assets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class Asset implements Serializable {
    /**
     * It consists of an alphanumeric string to uniquely refer to an asset.
     */
    private final String id;

    /**
     * Asset configuration.
     */
    @JsonProperty("config")
    private final AssetConfig config;
}
