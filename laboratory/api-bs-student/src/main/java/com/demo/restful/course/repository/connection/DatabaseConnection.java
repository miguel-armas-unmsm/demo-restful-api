package com.demo.restful.course.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

  private static Connection instance;

  public static Connection getConnection(){
    try{
      if(instance == null) {
        Runtime.getRuntime().addShutdownHook(new ClosingHook());

        String url = "jdbc:sqlserver://unmsmserver.database.windows.net:1433;databaseName=unmsmdatabase";
        String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String username = "miguelarmas";
        String password = "l21m01j16M01L13";

        Class.forName(driverClassName);
        instance = DriverManager.getConnection(url, username, password);
      }
      return instance;
    }
    catch(Exception ex){
      ex.printStackTrace();
      throw new RuntimeException("Error al conectarse con la base de datos.");
    }
  }

  static class ClosingHook extends Thread{
    public void run(){
      try{
        Connection connection = getConnection();
        connection.close();
      }
      catch(Exception ex){
        ex.printStackTrace();
        throw new RuntimeException();
      }
    }
  }
  
}
