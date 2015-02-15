package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.model.URLData;

public class URLDataExtractor implements ResultSetExtractor{
	public URLData extractData(ResultSet result) throws SQLException,
			DataAccessException {
		
		URLData urlData = new URLData();
		urlData.setUrlDataId(result.getInt(1));
		urlData.setEnvName(result.getString(2));
		urlData.setProjectName(result.getString(3));
		urlData.setModuleName(result.getString(4));
		urlData.setModuleLink(result.getString(5));
		
		return urlData;
	}
}
