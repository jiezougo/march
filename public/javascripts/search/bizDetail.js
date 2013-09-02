var bizDetail={
	biz: null,
	id: null,
	init: function(){
		 this.id=$("#bizId").val();
		 $.ajax({
            method:"get",
  			dataType: "json",
  			// url:"http://localhost:8080/bizwise/business/bizlist",
  			url: "/bizDetailJSON?id="+this.id,
  			success: function(rs){
  				bizDetail.biz=rs;
  			    bizDetail.renderMap();
  			    bizDetail.renderDetail();
  			    bizDetail.renderRating();
  			    $("#bizDetailUL").listview('refresh');
  			}
		});
		
	},
	renderDetail : function(){
		var html='';
		var appliedDate=new Date(this.biz.dateApplied);
		var y=appliedDate.getFullYear();
		var m=appliedDate.getMonth()+1;
		var d=appliedDate.getDate();
		var fDate=y+'-'+m+'-'+d;
		html+='<img src="/assets/images/3.jpg"/>'
		html+='<h4>'+this.biz.bizName+'</h4>';
    	html+='<p>'+this.biz.address+'</p>';
    	html+='<p>'+this.biz.city+', '+this.biz.state+' '+this.biz.postCode+'</p>';
    	html+='<p>&nbsp;</p>';
    	html+='<p>Owned by </p>';
    	html+='<p>Established on '+fDate+'</p>';
    	html+='<p><a href="tel:111-1111-111">'+'111-1111-111'+'</a></p>';
    	$("#bizDetailLi").empty().append(html);
	},
	
	renderMap: function() {
    	var myLatlng=new google.maps.LatLng(this.biz.latitude,this.biz.longitude);
        var mapOptions = {
          center: myLatlng,
          zoom: 18,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map($("#map-canvas")[0],
            mapOptions);
        var marker = new google.maps.Marker({
            position: myLatlng,
            title:this.biz.bizName
        });

        // To add the marker to the map, call setMap();
        marker.setMap(map);
      },
      
      renderRating: function(){
      	$("#yelpRating").raty({ score: this.biz.yelpRating,number:5,path:'assets/javascripts/raty/img' });
      }
	
}


      $("#bizDetailPage").on( "pageinit", function( event ) {
    	  //console.dir('here');
    	  bizDetail.init();
       });