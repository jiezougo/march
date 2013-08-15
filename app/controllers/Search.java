package controllers;

import java.util.List;

import javax.persistence.Query;

import form.ClaimAsOwnerForm;
import form.SigninForm;

import model.Business;
import model.User;
import model.UserBizMap;
import model.UserBizMap.ID;

import play.data.Form;
import play.db.jpa.JPA;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.search.*;
import model.Business;

public class Search extends Controller{
	@play.db.jpa.Transactional(readOnly = true)
	  public static Result index() {
		  /*
		   * get the destination geo from client browser
		   */
		   double myLati=37.7886;
		   double myLongi=-122.394;
		   //10 miles
		   double distance=10.0;
		   double la1=myLati-(distance/69.0);
		   double la2=myLati+(distance/69.0);
		   
		   double lo1=myLongi-distance/(Math.cos(Math.abs(myLati*Math.PI/180))*69.0);
		   double lo2=myLongi+distance/(Math.cos(Math.abs(myLati*Math.PI/180))*69.0);
		  //to do by distance,search
		   Query q=JPA.em().createQuery("from Business where latitude between ? and ? and longitude between ? and ?");
		   q.setParameter(1, la1);
		   q.setParameter(2, la2);
		   q.setParameter(3, lo1);
		   q.setParameter(4, lo2);
		    List<model.Business> bs=q.getResultList();
		    if (bs !=null && bs.size()>0){
		    	for (Business aBs: bs){
		    		aBs.dist=(getDistance(myLati, myLongi, aBs.latitude, aBs.longitude));
		    	}
		    }
	        return ok(search.render(bs));
	    }
	
	private static double getDistance(double myLati, double myLongi,
			Double latitude, Double longitude) {
		// TODO Auto-generated method stub
		double a=Math.pow(Math.sin((latitude-myLati)*Math.PI/180/2),2);
		double b=Math.cos(latitude*Math.PI/180)*Math.cos(myLati*Math.PI/180)*Math.pow(Math.sin((longitude-myLongi)*Math.PI/180/2),2);
		double c=Math.sqrt(a+b);
		double d=Math.asin(c)*2*3956;
		return d;
	}

	@play.db.jpa.Transactional(readOnly = true)
	  public static Result showBizDetail() {
		  long id=Long.parseLong(request().getQueryString("id"));
		   Business bz=JPA.em().find(Business.class, id);
	       return ok(bizDetail.render(bz));
	    }
	
	 @play.db.jpa.Transactional(readOnly = true)
	  public static Result showClaimAsOwner() {
		  long id=Long.parseLong(request().getQueryString("id"));
		   Business bz=JPA.em().find(Business.class, id);
	       return ok(claimAsOwner.render(bz));
	    }
	 @play.db.jpa.Transactional
	 public static Result claimAsOwner(){
		 Form<ClaimAsOwnerForm> form=new Form(ClaimAsOwnerForm.class).bindFromRequest();
		 ClaimAsOwnerForm cForm=form.get();
		 String cUserId=(session().get(util.Constants.SESSION_USERID));
		 if (cUserId!=null){
			 UserBizMap aMap=new UserBizMap();
			 UserBizMap.ID aId=new UserBizMap.ID();
			 aMap.Id=aId;
			 aMap.Id.uId=Long.parseLong(cUserId);
			 aMap.Id.bId=Long.parseLong(cForm.bId);
			 aMap.note=cForm.note;
			 JPA.em().persist(aMap);
			 return redirect("/myBiz");
		 }else{
			 return redirect("/");
			 
		 }
	 }
}
