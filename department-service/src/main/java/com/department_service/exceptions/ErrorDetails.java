package com.department_service.exceptions;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private String message;
	private String path;
	private String errorcode;

}
