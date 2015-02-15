package com.api;

import java.util.List;

import com.model.DatabaseCredential;

public interface DatabaseCredentialApi {
	List<DatabaseCredential> getAlldatabaseCredentials();
	void adddatabaseCredential(DatabaseCredential databaseCredential);
	void updatedatabaseCredential(DatabaseCredential databaseCredential);
	void deletedatabaseCredential(DatabaseCredential databaseCredential);
}
