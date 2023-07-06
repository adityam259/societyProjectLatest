
//Get The Branch Name.
function getBranchName(){
	
//	alert("hi")
  
  			$.ajax({
            type:"get",
            contentType: "application/json",
            url: 'getAllBranch',
            asynch: false,
            success: function(data) {

            var appenddata1 = "";
                    //var jsonData1 = JSON.parse(data1.d);
                    for (var i = 0; i < data.length; i++) {
                         appenddata1 += "<option value ='"+data[i].name+"'>"+data[i].name +"</option>";
                    }
                    $("#branchName").append(appenddata1);
                    
            
               
            } ,
    	    error: function(){
    	    	alert("Device control failed");
    	    }
        });
 
}



//Get The Table Through Branch Name.
function getTableBranchName(){
	
var branchName = document.getElementById("branchName");
var fDate = document.getElementById("fDate");
var tDate = document.getElementById("tDate");
		var input1 = {
                     "branchName": branchName.value,
                     "fDate": fDate.value,
                     "tDate": tDate.value
             }
             
             	var input2 = {
                   
                     "fDate": fDate.value,
                     "tDate": tDate.value
             }

  			$.ajax({
            type:"post",
            contentType: "application/json",
             data: JSON.stringify(input1),
            url: 'searchByBranchName',
            asynch: false,
            success: function(response) {

   		 for (var i = 0; i < response.data.length; i++){
				//alert(data[i].branchName)
				//var j=1;
				const tableData1 = response.data.map(function (value) {
					return (
						`<tr>
                         <td>${value.id}</td> 
                         <td>${value.address}</td>
                         <td>${value.branchName}</td>
						 
                         </tr>`
					);
				}).join('');
				const tableBody1 = document.querySelector("#tableBody");
				tableBody1.innerHTML = tableData1;
			}
            
               
            } ,
    	    error: function(){
    	    	alert("Device control failed");
    	    }
        });
        
        
        
        $.ajax({
            type:"post",
            contentType: "application/json",
             data: JSON.stringify(input2),
            url: 'searchByDate',
            asynch: false,
            success: function(response) {

   		 for (var i = 0; i < response.data.length; i++){
				//alert(data[i].branchName)
				//var j=1;
				const tableData1 = response.data.map(function (value) {
					return (
						`<tr>
                         <td>${value.id}</td> 
                         <td>${value.address}</td>
                         <td>${value.branchName}</td>
						 
                         </tr>`
					);
				}).join('');
				const tableBody1 = document.querySelector("#tableBody");
				tableBody1.innerHTML = tableData1;
			}
            
               
            } ,
    	    error: function(){
    	    	alert("Device control failed");
    	    }
        });
 
}