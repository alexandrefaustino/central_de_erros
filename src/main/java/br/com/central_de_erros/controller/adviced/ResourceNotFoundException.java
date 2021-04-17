package br.com.central_de_erros.controller.adviced;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String resourceName){
    super("Resource: " + resourceName);
  }
}