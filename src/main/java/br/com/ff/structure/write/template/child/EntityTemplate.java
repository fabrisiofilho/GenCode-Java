package br.com.ff.structure.write.template.child;

import br.com.ff.structure.write.template.Template;

public class EntityTemplate extends Template {

    private static final String TEMPLATE =
        """
        package {{PACKAGE}};
        
        {{IMPORTS}}
        
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public class {{CLASS_NAME}} {
        
            {{FIELDS}}
        
        }
        """;

    private static final String SUFFIX =
        """
        Entity
        """;

    public EntityTemplate() {
        super(TEMPLATE, null, SUFFIX);
    }
}
