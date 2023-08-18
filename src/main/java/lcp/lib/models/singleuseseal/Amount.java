package lcp.lib.models.singleuseseal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
@Getter
@ToString
public class Amount implements Serializable {
    private final Integer value;
    private final int decimals;

    public Amount() {
        this.value = 0;
        this.decimals = 2;
    }

    public Amount(Integer value) {
        this.value = value;
        this.decimals = 2;
    }

    public BigDecimal getValueComputed() {
        BigDecimal d = new BigDecimal(this.value / Math.pow(10, this.decimals));
        return d.setScale(this.decimals, RoundingMode.CEILING);
    }
}
