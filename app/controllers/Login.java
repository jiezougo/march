package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.login.*;

public class Login extends Controller{
	public static Result index(){
		return ok(index.render());
	}

}
