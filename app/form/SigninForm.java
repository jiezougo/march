package form;

public class SigninForm {
	public String email;
	public String pwd;
	public String emailError;
	public String pwdError;
	public String authError;
	
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
		return valid;
	}
}
