package services;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends Exception {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 3115170269354647662L;
	private int errorCode = 0;
	    private List<String> errorMessages = new ArrayList<String>();

	    public ServiceException() {
	        super();
	    }
	    
	    ServiceException(String string) {
	        super(string);
	    }

	    ServiceException(List<String> string) {
	        super();
	        this.errorMessages = string;
	    }

	    public List<String> getErrorMessages() {
	        return errorMessages;
	    }

	    public ServiceException setErrorMessages(List<String> errorMessages) {
	        this.errorMessages = errorMessages;
	        return this;
	    }

	    public ServiceException addErrorMessage(String string) {
	        this.getErrorMessages().add(string);
	        return this;
	    }

	    public int getErrorCode() {
	        return this.errorCode;
	    }
	    
	    public ServiceException setErrorCode(int errorCode) {
	        this.errorCode = errorCode;
	        return this;
	    }
	    
	    public boolean isError() {
	        return this.getErrorMessages().size() > 0;
	    }

}
