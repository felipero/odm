package net.fratech.odm.exceptions

class ODMException extends RuntimeException {
  String explanation
  
  ODMException(String message, String explanation){
    super(message + " - " + explanation)
    this.explanation = explanation
  }
}