package lcp.lib.models.ownership;

import lcp.lib.models.singleuseseal.SingleUseSeal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class Ownership implements Serializable {
    private final String id;
    private final SingleUseSeal singleUseSeal;
    @Setter
    private String unlockScript;
    @Setter
    private String contractInstanceId;

    public Ownership(String id, SingleUseSeal singleUseSeal) {
        this.id = id;
        this.singleUseSeal = singleUseSeal;
        this.unlockScript = "";
        this.contractInstanceId = "";
    }

    @Override
    public String toString() {
        return "Ownership{" +
                "id='" + id + '\'' +
                ", singleUseSeal=" + singleUseSeal +
                ", unlockScript='" + unlockScript + '\'' +
                ", contractInstanceId='" + contractInstanceId + '\'' +
                '}';
    }
}
