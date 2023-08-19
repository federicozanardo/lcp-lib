package lcp.lib.datastructures;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Pair<K, V> implements Serializable {
    private final K first;
    private final V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
