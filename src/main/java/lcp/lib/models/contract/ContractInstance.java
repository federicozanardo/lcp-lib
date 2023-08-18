package lcp.lib.models.contract;

import lcp.lib.dfa.DeterministicFiniteAutomata;
import lcp.lib.models.party.Party;
import lcp.lib.models.vm.Type;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;

@Getter
public class ContractInstance implements Serializable {
    private final String contractId;
    private final DeterministicFiniteAutomata stateMachine;
    private final HashMap<String, Party> parties;
    private final HashMap<String, Type> globalSpace;

    public ContractInstance(String contractId, DeterministicFiniteAutomata stateMachine, HashMap<String, Party> parties) {
        this.contractId = contractId;
        this.parties = parties;
        this.stateMachine = stateMachine;
        this.globalSpace = new HashMap<>();
    }

    @Override
    public String toString() {
        return "ContractInstance{" +
                "contractId='" + contractId + '\'' +
                ", stateMachine=" + stateMachine +
                ", parties=" + parties +
                ", globalSpace=" + globalSpace +
                '}';
    }
}
