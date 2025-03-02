package br.com.ff.utils.imports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeImportMap {

    public static final Map<String, String> TYPE_IMPORTS = new HashMap<>();

    static {
        TYPE_IMPORTS.put("String", "import lombok.*;");
    }

    public static List<String> getTypesByKeys(List<String> keys) {
        List<String> importsList = new ArrayList<>();
        for (String key : keys) {
            if (TYPE_IMPORTS.containsKey(key)) {
                importsList.add(TYPE_IMPORTS.get(key));
            }
        }
        return importsList;
    }

}
