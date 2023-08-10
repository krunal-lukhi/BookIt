package fwk.common;

import fwk.search.model.Filter;
import fwk.search.model.FilterBuilder;
import fwk.search.model.FilterType;

import java.util.*;

/**
 * @author Krunal Lukhi
 * @since 10/08/23
 */
public class CollectionUtils {
    public static boolean isEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Object[] array){
        if(array == null){
            return  true;
        }
        return Arrays.stream(array).noneMatch(Objects::nonNull);
    }

    public static <T> List<T> toList(T... array){
        if(isEmpty(array)){
            return new ArrayList<>();
        }
        return Arrays.asList(array);
    }

}
