package com.brs.advice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.ErrorDetails;
import com.brs.exceptions.FeedbackNotFoundException;
import com.brs.exceptions.MethodErrorDetails;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ExceptionController {
	@ResponseStatus(code =HttpStatus.BAD_REQUEST )
	@ExceptionHandler(ReservationNotFoundException.class)
	public ResponseEntity<?> handleReservationException(ReservationNotFoundException ex , WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage() ,request.getDescription(false));

		return new  ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	


	@ResponseStatus(code =HttpStatus.BAD_REQUEST )
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUsersException(UserNotFoundException ex ,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage() ,request.getDescription(false));

		return new  ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);	

	}

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgsNotValidException(MethodArgumentNotValidException ex, WebRequest request){

		Map<String,String> resp= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage(); 
			resp.put(fieldName, message);
		});
		MethodErrorDetails methodErrorDetails=new MethodErrorDetails(new Date(),resp,request.getDescription(false));
		
		
		return new ResponseEntity<>(methodErrorDetails, HttpStatus.BAD_REQUEST);
	}
	


	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<?> handleRouteNotFoundException(RouteNotFoundException rex ,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),rex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<?> handleBusNotFoundException(BusNotFoundException rex ,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),rex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<?> FeedbackNotFoundException(FeedbackNotFoundException rex ,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),rex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralException(Exception e , WebRequest request)

	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),e.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
