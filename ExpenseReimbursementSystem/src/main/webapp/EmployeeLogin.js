window.onload = function(){
   document.getElementById("submitLoginRequest").onclick=function(){
      sendAjaxPost(80871/ExpenseReimbursementSystem/login/test.html,returnResponse);
   };
}

//Call AJAX
function sendAjaxPost(url,func){

   //get that XHR object
   let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");

   //define the onreadystatechange
   xhr.onreadystatechange = function(){
      if(this.readyState == 4 && this.status == 200){
         func(this);
      }
   }

   //prepare the request(true for enabling threading(async))
   xhr.open("POST",url,true);
   //send it 
   xhr.send();
}

function returnResponse(xhr){
   let responseObject = JSON.parse(xhr.responseText);
   console.log(responseObject);
   
}