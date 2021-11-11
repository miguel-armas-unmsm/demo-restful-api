package com.demo.restful.course.repository.impl;

import static com.demo.restful.course.util.constant.SqlStatementConstant.*;

import com.demo.restful.course.model.entity.Student;
import com.demo.restful.course.model.entity.ScoreFromCourse;
import com.demo.restful.course.repository.StudentRepository;
import com.demo.restful.course.repository.connection.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet;

  @Override
  public List<Student> findAll() {
    List<Student> courseList = new ArrayList<>();

    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Student student = Student.builder()
            .code(resultSet.getLong("code"))
            .name(resultSet.getString("name"))
            .lastName(resultSet.getString("last_name"))
            .build();

        courseList.add(student);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

    return courseList;
  }

  @Override
  public List<ScoreFromCourse> findScores(Long studentCode) {
    List<ScoreFromCourse> details = new ArrayList<>();

    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      preparedStatement = connection.prepareStatement(SELECT_STUDENT_COURSE);
      preparedStatement.setLong(1, studentCode);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        ScoreFromCourse detail = ScoreFromCourse.builder()
            .code(resultSet.getString("code"))
            .course(resultSet.getString("course"))
            .score(resultSet.getInt("score"))
            .build();

        details.add(detail);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

    return details;
  }

  @Override
  public Student findByCode(Long code) {
    Student student = null;

    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_CODE);
      preparedStatement.setLong(1, code);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        student = Student.builder()
            .code(resultSet.getLong("code"))
            .name(resultSet.getString("name"))
            .lastName(resultSet.getString("last_name"))
            .build();
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

    return student;
  }

  private void rollback() {
    try {
      if (connection != null) {
        connection.rollback();
      }
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
