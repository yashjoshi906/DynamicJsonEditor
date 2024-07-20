package com.dynamic_json_editor.validator;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class JsonLogValidator {
	
	
	public Boolean validateInputCount(Map<String, String> valMap) {
		
		return valMap.isEmpty() || valMap.size() > 3 ? false : true; 
	}

	public boolean validateKeys(String jsonModel, Map<String, String> valMap) {

		int count = 0;

		for (String key : valMap.keySet()) {
			if (jsonModel.contains(key)) {
				count++;
			}

		}

		return count == valMap.size() ? true : false;
	}

}
