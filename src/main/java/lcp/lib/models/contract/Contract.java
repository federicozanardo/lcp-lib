package lcp.lib.models.contract;

import lcp.lib.datastructures.Triple;
import lcp.lib.dfa.states.DfaState;
import lcp.lib.dfa.states.FinalStates;
import lcp.lib.dfa.transitions.TransitionData;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
public class Contract implements Serializable {
    private final String sourceCode;
    private final String bytecode;
    private final DfaState initialState;
    private final FinalStates finalStates;
    private final ArrayList<Triple<DfaState, DfaState, TransitionData>> transitions;

    public Contract(String sourceCode,
                    String bytecode,
                    DfaState initialState,
                    FinalStates finalStates,
                    ArrayList<Triple<DfaState, DfaState, TransitionData>> transitions
    ) {
        this.sourceCode = sourceCode;
        this.bytecode = bytecode;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "sourceCode='" + sourceCode + '\'' +
                ", bytecode='" + bytecode + '\'' +
                ", initialState=" + initialState +
                ", finalStates=" + finalStates +
                ", transitions=" + transitions +
                '}';
    }
}
