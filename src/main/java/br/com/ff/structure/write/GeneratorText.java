package br.com.ff.structure.write;

import br.com.ff.structure.write.template.Template;

import java.util.Map;

public class GeneratorText {

    public static String processTemplate(Template template, Map<String, String> values) {
        String result = template.getRequiredTemplate();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            result = result.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return result;
    }

}
