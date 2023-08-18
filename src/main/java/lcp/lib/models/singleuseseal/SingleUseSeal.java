package lcp.lib.models.singleuseseal;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SingleUseSeal implements Serializable {
    private final String assetId;
    private final Amount amount;
    private final String lockScript;

    public SingleUseSeal(String assetId, Amount amount, String publicKeyHash) {
        this.assetId = assetId;
        this.amount = amount;
        this.lockScript = "DUP\nSHA256\nPUSH str " + publicKeyHash + "\nEQUAL\nCHECKSIG\nHALT\n";
    }

    @Override
    public String toString() {
        return "SingleUseSeal{" +
                "assetId='" + assetId + '\'' +
                ", amount=" + amount +
                ", lockScript='" + lockScript + '\'' +
                '}';
    }
}