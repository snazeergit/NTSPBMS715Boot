package com.nt.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLType;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import oracle.jdbc.internal.OracleTypes;

@Component
public class CallingPL_SQLFunctionTestRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		//Unwrap Session object
		Session session = manager.unwrap(Session.class);

		//Use Work(I) callback interface to get the JDBC Connection object and to write CallableStatement object based logic
		//Call the PL/SQL procedure to function
		session.doWork(con -> {
			//Create CallableStatement object having query
			CallableStatement cs = con.prepareCall("{?=call FX_GET_ACTORS_DATA_BY_PHONES(?,?)}");

			//Register return, out param with JDBC type(IN params need not to register)
			cs.registerOutParameter(1, OracleTypes.CURSOR); //ojdbc8 dependancy scope shows runtime but we need it from compile time onwards so we remove the scope.

			//Set values to IN params
			cs.setLong(2, 9999l);
			cs.setLong(3, 8888l);

			//Call PL/SQL function
			cs.execute();

			//Gather results
			ResultSet rs = (ResultSet) cs.getObject(1);

			//Process the ResultSet object
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getLong(3));
			}
		});

	}

}
