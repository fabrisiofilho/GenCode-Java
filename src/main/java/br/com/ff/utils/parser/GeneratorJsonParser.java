package br.com.ff.utils.parser;

import br.com.ff.utils.required.RequiredValidation;
import com.google.gson.Gson;

public class GeneratorJsonParser {

    public static ParsedData parseJson(String json) {
        Gson gson = new Gson();
        ParsedData parsedData = gson.fromJson(json, ParsedData.class);
        RequiredValidation.validateRequiredFields(parsedData);
        return parsedData;
    }

}
