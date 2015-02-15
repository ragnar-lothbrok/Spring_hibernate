package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.model.TomcatData;

public class TomcatDataMapper implements RowMapper{

	public TomcatData mapRow(ResultSet result, int line) throws SQLException {
		TomcatDataExtractor tomcatDataExtractor = new TomcatDataExtractor();
		return tomcatDataExtractor.extractData(result);
	}

}
