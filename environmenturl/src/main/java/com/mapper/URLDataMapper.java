package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.URLData;

public class URLDataMapper implements RowMapper{

	public URLData mapRow(ResultSet result, int line) throws SQLException {
		URLDataExtractor urlDataExtractor = new URLDataExtractor();
		return urlDataExtractor.extractData(result);
	}

}
