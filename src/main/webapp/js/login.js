/**
 * 
 */
function getXML(file,str, ins_handleFN) { 
   http.open("POST", file, true); 
   http.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8"); 
   http.onreadystatechange = function(){ ins_handleFN();};// if(http.readyState == 4) document.getElementById('popup').style.display = 'none';};
   http.send(str);
   return http;
}


function ajax_post(p_form, p_servlet,p_handelFN,arr_fieldname,arr_fieldvalue) { 
	showLoading();
	var str=null;
	str = callform_values(p_form);	
	str = add_fieldname(str,arr_fieldname,arr_fieldvalue);
	xmlReq = getXML(p_servlet,str,p_handelFN);
	hideLoading(); 
}


function ajax_post_div(p_form, p_servlet,p_handelFN,arr_fieldname,arr_fieldvalue,p_divid) {
	resultDiv 	= p_divid;
	ajax_post(p_form, p_servlet,p_handelFN,arr_fieldname,arr_fieldvalue);
	return;
}


function callform_values(ins_form) { 
   var str = getFormValues(ins_form); 
   return str;
}


function getFormValues(fobj) { 
   var str = ""; 
   for(var i = 0;i < fobj.elements.length;i++) { 
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
       } 
   } 
   str = str.substr(0,(str.length - 1)); 
   return str;
}





function bud_alert(str, options) {
	if(options =='V'){
		 Valert(str); 
		 return false;
	}
	else if(options =='N'){
		 Nalert(str); 
	 return false;
	}
	else if(options =='L'){
		 Lalert(str); 
	 return false;
	}
	else if(options =='C'){
		Calert(str); 
	}
}


function Valert(message) {
	main_alert("<div class='heading error'><span class='alerts error'></span><h3><b>BMS</b> Alert</h3></div><p>"+ message+ "</p>", "OK");

}

function Nalert(message){
	main_alert("<div class='heading notification'><span class='alerts notification'></span><h3><b>BMS</b> Alert</h3></div><p>"+ message+ "</p>", "OK");
	
}

function Calert(message) {
	bud_confirm(message);
};

function Lalert(message){
	main_alert_login("<div class='heading notification'><span class='alerts notification'></span><h3><b>BMS</b> Alert</h3></div><p>"+ message+ "</p>","OK" );
	
}





