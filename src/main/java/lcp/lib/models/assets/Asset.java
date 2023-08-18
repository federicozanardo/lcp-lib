package lcp.lib.models.assets;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Asset implements Serializable {
    /**
     * It consists of an alphanumeric string to uniquely refer to an asset.
     */
    private final String id;

    /**
     * Asset configuration.
     */
    private final AssetConfig asset;

    public Asset(String id, AssetConfig asset) {
        this.id = id;
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id='" + id + '\'' +
                ", asset=" + asset +
                '}';
    }
}
