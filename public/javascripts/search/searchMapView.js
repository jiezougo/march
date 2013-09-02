  var searchMapView={
   
    bizs:[],
    markers:null,
    map: null,
    mapInflow :null,
    
    onGeoSucceed:function(position){
    	searchMapView.init(position);
    },
    
    onGeoFail:function(error){
    	searchMapView.init();
    },
    
    renderMap: function(searchText){
    	// take markers out of map
    	if (this.markers !=null){
        for(var j=0;j<this.markers.length;j++){
        	this.markers[j].setMap(null);
        }
    	}
        this.markers=[];
     	for (var i=0;i<this.bizs.length;i++){
     		
     		if (searchText==null || ((this.bizs[i].bizName).toUpperCase()).indexOf(searchText.toUpperCase())>=0
     		|| ((this.bizs[i].address).toUpperCase()).indexOf(searchText.toUpperCase())>=0
     		|| ((this.bizs[i].city).toUpperCase()).indexOf(searchText.toUpperCase())>=0
     		|| ((this.bizs[i].state).toUpperCase()).indexOf(searchText.toUpperCase())>=0
     		|| ((this.bizs[i].zipCode).toUpperCase()).indexOf(searchText.toUpperCase())>=0
     		){
     			// console.log(searchText);
     		    // console.log(this.bizs[i].bizName);
     			    // console.log(his.bizs[i].latitude);
  					 var marker = new google.maps.Marker({
            		position: new google.maps.LatLng(this.bizs[i].latitude, this.bizs[i].longitude),
            		map:this.map
        			});
        			
        			  google.maps.event.addListener(marker, 'click', (function(marker,i) {
        			  	    return function() {
        			  	    var b=searchMapView.bizs[i];
        			  	    var content='<a href="/bizDetail?id='+b.id+'"><h4>'+b.bizName+'</h4></a><p>'+b.address+'</p><p>'+b.city+', '+ b.state+' '+b.zipCode+'</p>';
          					searchMapView.mapInflow.setContent(content);
          					searchMapView.mapInflow.open(searchMapView.map, marker);
        			  	    }
        			  })(marker,i));
        		this.markers.push(marker);
     		}
     	}
     	

    },
  
    init: function(position) {
     var lat=37.783333;
     var lon= -122.416667;
     //alert(position);
     //alert(position.coords);
      if (position){
      	lat=position.coords.latitude; 
  		lon=position.coords.longitude;
      }
      var myLatlng = new google.maps.LatLng(lat,lon);
        var mapOptions = {
          center: myLatlng,
          zoom: 14,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        this.map = new google.maps.Map($("#search-map-canvas")[0],
            mapOptions);
        this.mapInflow = new google.maps.InfoWindow();
        $.ajax({
            method:"get",
  			dataType: "json",
  			// url:"http://localhost:8080/bizwise/business/bizlist",
  			url: "/searchResultJSON",
  			success: function(rs){
  			    searchMapView.bizs=rs;
  				searchMapView.renderMap(null);
  			}
		});
		
		// search
		// console.dir($("#mapViewSearchInput"));
		$("#mapViewSearchInput").keyup(function(){
			// console.log('here');
     	var st=$(this).val();
     	if (st && st.length>0){
     		searchMapView.renderMap(st);
     	}
     });
    }
   };
    
 $("#searchMapViewPage").on( "pageinit", function( event ) {
 	 console.dir('heremap');
 	      if (navigator.geolocation)
    		{
    			navigator.geolocation.getCurrentPosition(searchMapView.onGeoSucceed,searchMapView.onGeoFail);
    		}
    	else{
    		 searchMapView.init();
    	}
 });