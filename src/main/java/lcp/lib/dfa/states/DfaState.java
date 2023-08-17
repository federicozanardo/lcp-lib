package lcp.lib.dfa.states;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class DfaState implements Serializable {
    private final String name;

    @Override
    public String toString() {
        return "DfaState{" +
                "name='" + name + '\'' +
                '}';
    }
}
