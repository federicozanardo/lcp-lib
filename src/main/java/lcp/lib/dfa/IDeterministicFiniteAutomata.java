package lcp.lib.dfa;

import lcp.lib.dfa.states.DfaState;

import java.util.ArrayList;

public interface IDeterministicFiniteAutomata {
    /**
     * Check if the given state is the next state of the current state, given a party, a function name and a list of argument types.
     *
     * @param party:              the party that made the request.
     * @param functionName:       the name of the function called.
     * @param candidateNextState: state to check if it is the next state of the current state.
     * @param argumentTypes:      the argument types of the function called.
     * @return true, if the given state is the next state of the current state; false, otherwise.
     */
    boolean isNextState(String party, String functionName, DfaState candidateNextState, ArrayList<String> argumentTypes);

    /**
     * Check if the given state is the next state of the current state, given an obligation function name.
     *
     * @param obligationFunctionName: obligation to call.
     * @param candidateNextState:     state to check if it is the next state of the current state.
     * @return true, if the given state is the next state of the current state; false, otherwise.
     */
    boolean isNextState(String obligationFunctionName, DfaState candidateNextState);

    /**
     * Update the state machine, given a party, a function name and a list of argument types.
     *
     * @param party:         the party that made the request.
     * @param functionName:  the name of the function called.
     * @param argumentTypes: the argument types of the function called.
     */
    void nextState(String party, String functionName, ArrayList<String> argumentTypes);

    /**
     * Update the state machine, given an obligation function name.
     *
     * @param obligationFunctionName: the name of the obligation function called.
     */
    void nextState(String obligationFunctionName);
}
