package br.com.ff.structure.write.template.child;

import br.com.ff.structure.write.template.Template;

public class InterfaceServiceTemplate extends Template {

    private static final String TEMPLATE =
        """
        package {{PACKAGE}};
    
        {{IMPORTS}}
        
        public interface {{CLASS_NAME}} {
                
        {{METHODS}}
        
        }
        """;

    private static final String SUFFIX =
        """
        Service
        """;

    public InterfaceServiceTemplate() {
        super(TEMPLATE, null, SUFFIX);
    }

}
