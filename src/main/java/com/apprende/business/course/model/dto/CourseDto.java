package com.apprende.business.course.model.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ModuleDto.
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable {

  private Integer id;

  private Integer gradeId;

  @Pattern(regexp = "^([.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ´‘-]+\\s)*[.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ‘´-]+$") @Size(min = 5, max = 300)
  private String name;

  @Pattern(regexp = "^([.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ´‘-]+\\s)*[.0-9a-zA-ZŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÒÓÔÕÖ×ØÙÚÛÜÝàáâãäåæçèéêëìíîïòóôõöùúûüýÿÑñáéíóúÁÉÍÓÚ‘´-]+$") @Size(min = 5, max = 300)
  private String courseCode;

  private String imageResource;
}
