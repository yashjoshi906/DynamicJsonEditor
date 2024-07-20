package com.dynamic_json_editor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


@Component
public class StringOps {
	
	public Map<String, String> strToMap(String val) {
		String regex1 =  "\"([^\"]+)\":::\"([^\",]+)\",?";
		//String regex2 =  "\"([^\"]+)\"\\s*:::\\s*\"([^\",]+)\"";

		Pattern pattern = Pattern.compile(regex1);
		
		Matcher matcher = pattern.matcher(val);
		Map<String, String> keyValueMap = new HashMap<>();
		 while (matcher.find()) {
		        String key = matcher.group(1);
		        String value = matcher.group(2);

		        // Store key-value pairs in the map
		        keyValueMap.put(key, value);
		        
		    }
		
		return keyValueMap;
		
	}
	
	 public String replaceSubstrings(String input, Map<String, String> replacements) {
	        // Iterate over the map entries
	        for (Map.Entry<String, String> entry : replacements.entrySet()) {
	            String match = entry.getKey();
	            String replace = entry.getValue();
	            // Replace all occurrences of the match with the replace value
	            input = input.replace(match, replace);
	        }
	        return input;
	    }

}
