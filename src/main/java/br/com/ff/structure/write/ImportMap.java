package br.com.ff.structure.write;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportMap {

    public static final Map<String, String> IMPORTS = new HashMap<>();

    static {
        IMPORTS.put("lombok", "import lombok.*;");
        IMPORTS.put("jakartaPersistence", "import jakarta.persistence.*;");
        IMPORTS.put("serializable", "import java.io.Serializable;");
    }

    public static List<String> getImportsByKeys(List<String> keys) {
        List<String> importsList = new ArrayList<>();
        for (String key : keys) {
            if (IMPORTS.containsKey(key)) {
                importsList.add(IMPORTS.get(key));
            }
        }
        return importsList;
    }

}
