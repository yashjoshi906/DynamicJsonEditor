package com.dynamic_json_editor.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic_json_editor.dto.JsonModelDTO;
import com.dynamic_json_editor.entity.JsonLogs;
import com.dynamic_json_editor.exception.BusinessException;
import com.dynamic_json_editor.repo.JsonLogsRepo;
import com.dynamic_json_editor.util.StringOps;
import com.dynamic_json_editor.validator.JsonLogValidator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonLogsServiceImpl implements JsonLogsService {

	StringOps stringOps;

	JsonLogValidator jsonLogValidator;

	ObjectMapper objectMapper;
	
	JsonLogs jsonLogs;
	
	
	@Autowired
	JsonLogsRepo jsonLogsRepo;

	public JsonLogsServiceImpl(StringOps ops, JsonLogValidator jsonLogValidator, ObjectMapper objectMapper) {

		stringOps = ops;
		this.jsonLogValidator = jsonLogValidator;
		this.objectMapper = objectMapper;
		

	}

	String sample_jsonString = "{\"menu\": {\r\n" + "\"id\": \"file\",\r\n" + "\"value\": \"File\",\r\n"
			+ "\"popup\": {\r\n" + "\"menuitem\": [\r\n" + "{\"value\": \"New\", \"onclick\": \"CreateDoc()\"},\r\n"
			+ "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
			+ "{\"value\": \"Save\", \"onclick\": \"SaveDoc()\"}\r\n" + "]\r\n" + "}\r\n" + "}}";

	@Override
	public JsonModelDTO updateJsonModel(String values) {

		JsonModelDTO jsonModelDTO = new JsonModelDTO();
		
		jsonLogs = new JsonLogs();

		Map<String, String> valMap = stringOps.strToMap(values);

		if (validateJson(valMap)) {
			String jsonlogString = stringOps.replaceSubstrings(sample_jsonString, valMap);

			try {
				jsonModelDTO = objectMapper.readValue(jsonlogString, JsonModelDTO.class);
				jsonLogs.setJson_model(objectMapper.writeValueAsString(jsonModelDTO));
				jsonLogsRepo.save(jsonLogs);
				
			} catch (Exception e) {
				throw new BusinessException("invalid input");
			}
		}
		 

		
		return jsonModelDTO;

	}

	Boolean validateJson(Map<String, String> valMap) {
		Boolean valid = false;

		if (jsonLogValidator.validateInputCount(valMap)) {

			if (jsonLogValidator.validateKeys(sample_jsonString, valMap)) {
				valid = true;
			}

			else {
				throw new BusinessException("invalid key");
			}
		} else {
			throw new BusinessException("max input length allowed is 3");
		}

		return valid;
	}

}
