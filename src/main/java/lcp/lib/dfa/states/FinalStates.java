package lcp.lib.dfa.states;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashSet;

@AllArgsConstructor
@Getter
public class FinalStates implements Serializable {
    private final HashSet<DfaState> acceptanceStates;
    private final HashSet<DfaState> failingStates;

    public boolean isStateInFinalStates(DfaState state) {
        return (acceptanceStates.contains(state) || failingStates.contains(state));
    }

    public boolean isStateInAcceptanceStates(DfaState state) {
        return acceptanceStates.contains(state);
    }

    public boolean isStateInFailingStates(DfaState state) {
        return failingStates.contains(state);
    }

    @Override
    public String toString() {
        return "FinalStates{" +
                "acceptanceStates=" + acceptanceStates +
                ", failingStates=" + failingStates +
                '}';
    }
}
