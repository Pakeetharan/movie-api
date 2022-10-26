/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String msg) { super(msg);}
}
