package com.apprende.business.course.model.entity;

import lombok.*;
import javax.persistence.*;

/**
 * Module.
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "grade_id")
  private Integer gradeId;

  @Column(name = "name")
  private String name;

  @Column(name = "course_code")
  private String courseCode;

  @Column(name = "image_resource")
  private String imageResource;
}
