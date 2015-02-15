package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.model.TomcatData;

public class TomcatDataExtractor implements ResultSetExtractor{

	public TomcatData extractData(ResultSet result) throws SQLException,
			DataAccessException {
		
		TomcatData tomcatData = new TomcatData();
		tomcatData.setTomcatDataId(result.getInt(1));
		tomcatData.setTomcatName(result.getString(2));
		tomcatData.setTomcatPort(result.getString(3));
		tomcatData.setEnvName(result.getString(4));
		
		return tomcatData;
	}
}
