/**
 * 
 */

 
 // this is the major ajax function to sent the data to server
 
 	function ins_staff(task){


		//alert("Inside  ajax");
		var form=document.getElementsByTagName("form")[0];
		//alert(form);
		var xhr =new XMLHttpRequest();
		
		xhr.onreadystatechange=function(){
			
			if (this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
			
			if(task='updatestaff'&& String(this.responseText).includes("success"))
			   location.reload();
			}
		}
		xhr.open('POST',"http://localhost:8080/Employee/home?task="+task+"&name="+getFormValues(form));
		xhr.send();
	}
	
	function ins_delete(task,id){


		//alert("Inside  ajax");
		var form=document.getElementsByTagName("form")[0];
		//alert(form);
		var xhr =new XMLHttpRequest();
		
		xhr.onreadystatechange=function(){
			
			if (this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
			
			if(task='deletestaff'&& String(this.responseText).includes("success"))
			   location.reload();
			}
		}
		xhr.open('POST',"http://localhost:8080/Employee/home?task="+task+"&id="+id+"");
		xhr.send();
	}
	
	
	//this function use to fetch the form data and sent it with ajaxfunction
	function getFormValues(fobj) { 
   var str = "&"; 
   for(var i in  fobj.elements) { 
	   switch(fobj.elements[i].type) { 
		case "text": 
//			if(validate_elements_text(fobj.elements[i].value,fobj.elements[i].name)){
		   str += fobj.elements[i].name +"="+encodeURIComponent(fobj.elements[i].value) + "&"; 
//			}
		break; 
		
		case "date": 
//			if(validate_elements_text(fobj.elements[i].value,fobj.elements[i].name)){
		   str += fobj.elements[i].name +"="+encodeURIComponent(fobj.elements[i].value) + "&"; 
//			}
		break; 
		
		case "password": 
//			if(validate_elements_password(fobj.elements[i].value,fobj.elements[i].name)){
			str += fobj.elements[i].name +"="+ encodeURIComponent(fobj.elements[i].value) + "&"; 
//			}
		break; 
		
		case "textarea": 
//			if(validate_elements_textarea(fobj.elements[i].value,fobj.elements[i].name)){
			str += fobj.elements[i].name +"="+ encodeURIComponent(fobj.elements[i].value) + "&"; 
//			}
		break; 
		
		case "radio": 
			if(fobj.elements[i].checked)
				 str += fobj.elements[i].name +"="+ encodeURIComponent(fobj.elements[i].value)+ "&";
		break; 
		
		case "checkbox": 
			if(fobj.elements[i].checked)
				str += fobj.elements[i].name +"="+ encodeURIComponent(fobj.elements[i].value)+ "&"; 
		break; 
		
		case "hidden": 
//			if(validate_elements_hidden(fobj.elements[i].value,fobj.elements[i].name)){
			str += fobj.elements[i].name + "=" + encodeURIComponent(fobj.elements[i].value) + "&";
//			}
		break; 
		
		case "select-one":
			str += fobj.elements[i].name +"=" + encodeURIComponent(fobj.elements[i].options[fobj.elements[i].selectedIndex].value) + "&"; 
		break;
		
		case "select":
			str += fobj.elements[i].name +"=" + encodeURIComponent(fobj.elements[i].options[fobj.elements[i].selectedIndex].value) + "&"; 
		break;
		case "option":
			str += fobj.elements[i].name +"=" + encodeURIComponent(fobj.elements[i].options[fobj.elements[i].selectedIndex].value) + "&"; 
		break;
		
       } 
   } 
   str = str.substr(0,(str.length - 1)); 
   return str;
}
	
 
 
 
 
 
 
 //document.getElementByIdaddEventListener()
 
 
 
 
 //this function fetch the values from tr tag and set the values to respective id s of my form when calling open form the update form will popup with values 
 
 var stupdate=(element,id)=>{
	 closeForm();
	 let cells =element.closest("tr").querySelectorAll("td");
	 
	 
	 	document.getElementById("id").value= id;

	document.getElementById("dep").value= cells[2].textContent;
	document.getElementById("des").value= cells[3].textContent;
	document.getElementById("sal").value= cells[4].textContent;
	 openForm();
	 
 }
 


var openForm=() => document.getElementById("myForm").style.display = "block";


var closeForm=() => document.getElementById("myForm").style.display = "none";

		//this will route the upadte request to home servlet
var updateDetails=(element)=>{
	ins_staff('updatestaff');
	
	
	
}

var stdelete=(id)=>{
	if(confirm("Are You Sure Delete This Staff")){
	
	ins_delete('deletestaff',id);
	}
}

var call_task=(task)=>{
		var form=document.createElement("form");
		form.method='POST';
		form.action="/Employee/home";
		let  input =document.createElement("input");
		input.setAttribute("name","task");
		input.setAttribute("value",task);
		input.setAttribute("type","hidden");
		form.appendChild(input);
		document.body.append(form);
		form.submit();
			document.body.remove(form);	
		
	}
		

	
		