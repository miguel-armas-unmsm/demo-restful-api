package com.demo.restful.course.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Student {

  private Long code;

  private String name;

  private String lastName;
}
