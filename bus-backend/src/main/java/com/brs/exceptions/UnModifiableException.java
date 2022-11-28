package com.brs.exceptions;

public class UnModifiableException extends RuntimeException{
  public  UnModifiableException(String message)
  {
      super(message);
  }
}
