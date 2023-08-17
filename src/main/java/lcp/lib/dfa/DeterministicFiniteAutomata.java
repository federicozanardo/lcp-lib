package lcp.lib.dfa;

import lcp.lib.datastructures.Triple;
import lcp.lib.dfa.states.DfaState;
import lcp.lib.dfa.states.FinalStates;
import lcp.lib.dfa.transitions.TransitionData;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class DeterministicFiniteAutomata implements IDeterministicFiniteAutomata, Serializable {
    @Getter
    private DfaState currentState;
    @Getter
    private final DfaState initialState;
    private final FinalStates finalStates;
    private final ArrayList<Triple<DfaState, DfaState, TransitionData>> transitions;

    public DeterministicFiniteAutomata(
            DfaState initialState,
            FinalStates finalStates,
            ArrayList<Triple<DfaState, DfaState, TransitionData>> transitions
    ) {
        this.initialState = initialState;
        this.currentState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
    }

    /**
     * Check if the current state belongs to the end-states set.
     *
     * @return true, if the current state belongs to the end-states set; false otherwise.
     */
    public boolean isCurrentStateEndState() {
        return finalStates.isStateInFinalStates(currentState);
    }

    /**
     * Check if the state, given in input, belongs to the end-states set.
     *
     * @param state: the state to check if it belongs to the end-states set.
     * @return true, if the given state belongs to the end-states set; false otherwise.
     */
    public boolean isEndState(DfaState state) {
        return finalStates.isStateInFinalStates(state);
    }

    @Override
    public String toString() {
        return "DeterministicFiniteAutomata{" +
                "currentState=" + currentState +
                ", initialState=" + initialState +
                ", finalStates=" + finalStates +
                ", transitions=" + transitions +
                '}';
    }
}
