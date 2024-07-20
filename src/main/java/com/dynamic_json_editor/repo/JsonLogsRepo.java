package com.dynamic_json_editor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynamic_json_editor.entity.JsonLogs;

@Repository
public interface JsonLogsRepo extends JpaRepository<JsonLogs, Long> {
	
	

}
