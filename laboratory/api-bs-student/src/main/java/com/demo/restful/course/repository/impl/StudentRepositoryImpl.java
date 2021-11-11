package com.demo.jdbc.course.repository.impl;

import com.demo.jdbc.course.model.entity.Course;
import com.demo.jdbc.course.repository.CourseRepository;
import com.demo.jdbc.course.repository.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepository {

  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet;

  @Override
  public List<Course> findAll() {
    List<Course> courseList = new ArrayList<>();

    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "SELECT id, name, academic_year, credits FROM [dbo].[course];";
      preparedStatement = connection.prepareStatement(sqlStatement);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Course course = Course.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .academicYear(resultSet.getInt("academic_year"))
            .credits(resultSet.getInt("credits"))
            .build();

        courseList.add(course);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

    return courseList;
  }

  @Override
  public Optional<Course> findById(Long id) {
    Course course = null;

    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "SELECT id, name, academic_year, credits FROM [dbo].[course] "
          .concat("WHERE id = ?");
      preparedStatement = connection.prepareStatement(sqlStatement);
      preparedStatement.setLong(1, id);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        course = Course.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .academicYear(resultSet.getInt("academic_year"))
            .credits(resultSet.getInt("credits"))
            .build();
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

    return Optional.ofNullable(course);
  }

  @Override
  public Course save(Course course) {
    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "INSERT INTO [dbo].[course] (name, academic_year, credits) "
          .concat("VALUES (?, ?, ?);");
      preparedStatement = connection.prepareStatement(sqlStatement);
      preparedStatement.setString(1, course.getName());
      preparedStatement.setInt(2, course.getAcademicYear());
      preparedStatement.setInt(3, course.getCredits());

      int insertedRows = preparedStatement.executeUpdate();
      if (insertedRows == 1) {
        connection.commit();
      } else {
        throw new RuntimeException("Error al insertar");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

    return course;
  }

  @Override
  public void deleteById(Long id) {

    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "DELETE FROM [dbo].[course] WHERE id = ?";
      preparedStatement = connection.prepareStatement(sqlStatement);
      preparedStatement.setLong(1, id);

      int deletedRows = preparedStatement.executeUpdate();
      if (deletedRows == 1) {
        connection.commit();
      } else {
        throw new RuntimeException("Error al eliminar");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      rollback();
    }

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
