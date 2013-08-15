package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.mybiz.*;

public class MyBiz extends Controller{
	public static Result index(){
		return ok(index.render());
	}
	
	public static Result advice(){
		return ok(myAdvice.render());
	}
	
	public static Result action(){
		return ok(myAction.render());
	}
}
