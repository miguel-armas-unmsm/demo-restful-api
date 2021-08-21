package com.apprende.business.course.util.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {

    private LocalDateTime date;
    private String message;
    private String detail;
}
