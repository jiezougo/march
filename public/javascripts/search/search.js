var searchListView={
	bizs:null,
	
	onGeoSucceed: function(){
		searchListView.init();
	},
	
	onGeoFail: function(){
		searchListView.init();
	},
	
	renderList: function(){
		var html='',b,ul=$('#bizListUL');
		for (var i=0;i<this.bizs.length;i++){
			b=this.bizs[i];
			html+='<li><a data-ajax="false" href="/bizDetail?id='+b.id+'"><img src="/assets/images/3.jpg"/><h4>'+b.bizName+'</h4><p>'+b.address+' '+b.city+', '+b.state+' '+ b.zipCode+'</p></a><span class="ui-li-count">'+'0 mi.</span></li>';
		}
		//console.log(html);
		ul.empty().append(html);
		ul.listview('refresh');
	},
	
	init: function(){
		 $.ajax({
            method:"get",
  			dataType: "json",
  			// url:"http://localhost:8080/bizwise/business/bizlist",
  			url: "/searchResultJSON",
  			success: function(rs){
  			    searchListView.bizs=rs;
  				searchListView.renderList(null);
  			}
		});
		
	}
}


$("#searchListPage").on( "pageinit", function( event ) {
	      console.dir('here');
 	      if (navigator.geolocation)
    		{
    			navigator.geolocation.getCurrentPosition(searchListView.onGeoSucceed,searchListView.onGeoFail);
    		}
    	else{
    		 searchListView.init();
    	}
 });