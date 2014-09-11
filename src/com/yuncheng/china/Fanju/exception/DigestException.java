package com.yuncheng.china.Fanju.exception;

/**
 * Created by agonyice on 14-9-11.
 */
public class DigestException extends SystemException {
	public DigestException() {

	}

	public DigestException(String detailMessage) {
		super(detailMessage);
	}
	public DigestException(String detailMessage,Throwable throwable){
		super(detailMessage,throwable);
	}
	public DigestException(Throwable throwable){
		super(throwable);
	}

}
