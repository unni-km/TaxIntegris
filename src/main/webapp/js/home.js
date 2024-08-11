/**
 * 
 */

	
	
	
// this is the major function this will create a form elemt by using dom and sent the request to home servlet
	
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
	
	
	
	
