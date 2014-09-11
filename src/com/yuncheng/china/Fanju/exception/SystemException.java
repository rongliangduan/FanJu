package com.yuncheng.china.Fanju.exception;

/**
 * Created by agonyice on 14-9-11.
 */
public class SystemException extends RuntimeException {
	public SystemException(){

	}
	public SystemException(String detailMessage){
		super(detailMessage);
	}
	public SystemException(String detailMessage,Throwable throwable){
		super(detailMessage,throwable);
	}
	public SystemException(Throwable throwable){
		super(throwable);
	}

}
