package com.demo.restful.course.util.constant;

public class SqlStatementConstant {

  public static final String SELECT_STUDENT_COURSE = "SELECT \n" +
      "\tc.code as code,\n" +
      "\tc.name as course, \n" +
      "\tsc.score as score\n" +
      "\tFROM [dbo].[course] as c\n" +
      "\tJOIN [dbo].[student_course] as sc\n" +
      "\tON c.code = sc.course_code\n" +
      "\tWHERE sc.student_code = ?";

  public static final String SELECT_STUDENT_BY_CODE = "SELECT code, name, last_name FROM [dbo].[student] WHERE code = ?";

  public static final String SELECT_ALL_STUDENTS = "SELECT code, name, last_name FROM [dbo].[student]";
}
