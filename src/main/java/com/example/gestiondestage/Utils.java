package com.example.gestiondestage;

import java.util.Map;

public class Utils {
    public static String getParamFromParameterMap(final Map<String, String[]> params, final String paramName) {
        return params.containsKey(paramName) ? params.get(paramName)[0] : "";
    }
}
