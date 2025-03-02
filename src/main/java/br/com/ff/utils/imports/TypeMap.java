package br.com.ff.utils.imports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeMap {

    public static final Map<String, String> TYPES = new HashMap<>();

    static {
        TYPES.put("String", "import lombok.*;");
    }

    public static List<String> getTypesByKeys(List<String> keys) {
        List<String> importsList = new ArrayList<>();
        for (String key : keys) {
            if (TYPES.containsKey(key)) {
                importsList.add(TYPES.get(key));
            }
        }
        return importsList;
    }

}
