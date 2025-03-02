package br.com.ff.structure.write.template.child;

import br.com.ff.structure.write.template.Template;

public class ControllerTemplate extends Template {

    private static final String TEMPLATE =
        """
        package {{PACKAGE}};
    
        {{IMPORTS}}
        
        @RestController
        @RequestMapping("{{PATH}}")
        @RequiredArgsConstructor
        public class {{CLASS_NAME}} {
        
        {{METHODS}}
        
        }
        """;

    private static final String SUFFIX =
        """
        Controller
        """;

    public ControllerTemplate() {
        super(TEMPLATE, null, SUFFIX);
    }
}
