package com.AppDirect.exceptions;

public class PathNotFoundException extends Exception{

   private static final long serialVersionUID = 1L;

   public PathNotFoundException(String message) {
      super(message);
  }
}
