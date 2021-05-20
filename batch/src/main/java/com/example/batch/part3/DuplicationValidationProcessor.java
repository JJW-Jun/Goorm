package com.example.batch.part3;

import javax.batch.api.chunk.ItemProcessor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DuplicationValidationProcessor<T> implements ItemProcessor{

    private final Map<String, Object> keyPool = new ConcurrentHashMap<>();
    private final Function<T, String> keyExtractor;
    private final boolean allowDuplicates;

    DuplicationValidationProcessor(Function<T, String> keyExtractor, boolean allowDuplicates) {
        this.keyExtractor = keyExtractor;
        this.allowDuplicates = allowDuplicates;
    }

    public T process(T item) throws Exception {
        if (allowDuplicates) {
            return item;
        }

        String key = keyExtractor.apply(item);
        if (keyPool.containsKey(key)) {
            return null;
        }

        keyPool.put(key, key);
        return item;
    }


    @Override
    public Object processItem(Object item) throws Exception {
        return null;
    }
}
