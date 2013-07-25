package form;

import org.apache.commons.lang3.StringUtils;

public class SignupForm {
	public String email;
	public String pwd;
	public String cpwd;
	public String fname;
	public String lname;
	public String tcheck;
	
	public String emailError;
	public String fNameError;
	public String lNameError;
	public String pwdError;
	public String cpwdError;
	public String tCheckError;
	
	public String pwdNotMatchError;
	public String userExistError;
	
	public boolean fValidate(){
		boolean valid=true;
		if (this.email==null || this.email.trim().length()<=0){
			this.emailError="Email is required.";
			valid=false;
		}

		if (this.pwd==null || this.pwd.trim().length()<=0){
			this.pwdError="Password is required";
			valid=false;
		}
		
		if (this.fname==null || this.fname.trim().length()<=0){
			this.fNameError="First name is required";
			valid=false;
		}
		
		if (this.lname==null || this.lname.trim().length()<=0){
			this.lNameError="Last name is required";
			valid=false;
		}
		
		if (this.cpwd==null || this.cpwd.trim().length()<=0){
			this.cpwdError="Confirm password is required";
			valid=false;
		}
		
		if (! StringUtils.isEmpty(this.pwd) && ! StringUtils.isEmpty(this.cpwd) && ! this.pwd.equals(this.cpwd)){
			this.pwdNotMatchError="Passwords do not match";
			valid=false;
		}
		
		if (StringUtils.isEmpty(this.tcheck)){
			this.tCheckError="You need read and agree the term";
			valid=false;
		}
		return valid;
	}

}
