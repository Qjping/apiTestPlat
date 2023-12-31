package apiTestPlat.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <K, T> Map<K, T> emptyMap() {
        return new HashMap<>();
    }

    public static <V> Set<V> emptySet() {
        return new HashSet<>();
    }

    public static <V> List<V> emptyList() {
        return new ArrayList<>();
    }

    public static <K, T> Map<K, T> toMap(Collection<T> collection, Function<T, K> key) {
        if (isEmpty(collection)) {
            return emptyMap();
        }
        return collection.parallelStream().collect(Collectors.toMap(key, Function.identity(), (K1, K2) -> K2));
    }

    public static <V, T> Set<V> toSet(Collection<T> collection, Function<T, V> value) {
        if (isEmpty(collection)) {
            return emptySet();
        }
        return collection.parallelStream().map(value).collect(Collectors.toSet());
    }

}
