package com.yuncheng.china.Fanju.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by agonyice on 14-9-9.
 */
public class CollectionUtil {
    public static <E> boolean isEmpty(Collection<E> collection) {
        return collection == null || collection.isEmpty();

    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
