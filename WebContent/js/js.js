/**
 * 
 */
'use strict';
var camposedit="",
tredit="",
newtd = "";
$(function(){
	'use strict';
	$("#sfa").click(function(e){
		'use strict';
		e.preventDefault();
		
	});
	$("#formadd").submit(function(e){
		'use strict';
		e.preventDefault();
		var data = "",
			i=1,
			opcion=$("#opcion").data("op");
		
		$("#formadd div input").each(function(){
			if(i===1){
				data += '{"' + $(this).attr("name") + '":"' + $(this).val() + '",';
			}else{
				data += '"' + $(this).attr("name") + '":"' + $(this).val() + '",';
			}
			i++;
			
		});
		data = data.substring(0,data.length-1) + "}";
		console.log("SS" + opcion)
		$.post("admin/guardarregistro",{data,opcion:opcion},function(e){
			
		}).done(function(data2) {
			$("tbody").append("<tr></tr>");
			var tr = $("tbody tr").last();
			var ob= JSON.parse(data2);
			for (var key in ob) {
			    if (ob.hasOwnProperty(key)) {
			    	console.log(ob);
			    	console.log(key + " -> " + ob[key]);
			    	tr.append("<td>" + ob[key] + "</td");
			    		
			    }
			}
			tr.append('<td><a href="#" class="btn btn-warning" onclick="editRegistro(event,this)" data-toggle="modal" data-target="#myModalEdit"><i class="fas fa-edit"></i></a> <a href="#" class="btn btn-danger" onclick="deleteregistro(event,this);"> <i class="fas fa-trash"></i></a></td>');
			$("#formadd")[0].reset();
		}).fail(function() {
		    console.log("Campos vacios");
		}).always(function(){
			  $(".modal-footer .btn-danger").click();
		});
	});
	/*
	 * $(".deleteregistro").click(function(e){ e.preventDefault(); if
	 * (window.confirm("Estas seguro que deseas borrar el registro?")) { var
	 * padre = $(this).parent().parent(), // tr i=0, campos="";
	 * padre.find("td:not(:last-child)").each(function(){ if(i===0){
	 * campos+="campo" + i +"=" + $(this).text(); }else{ campos+="&campo" + i
	 * +"=" + $(this).text(); } i++; });
	 * $.post("deleteregistro",{data:campos,opcion:$("#opcion").data("op")},function(e){
	 * 
	 * }).done(function(data) { padre.remove(); }) .fail(function() {
	 * console.log("Campos vacios"); }).always(function(){ $(".modal-footer
	 * .btn-danger").click(); }); } });
	 */
	
	$("#formedit").submit(function(e){
		'use strict';
		e.preventDefault();
		var data = "",
			i=1,
		dataold = camposedit,
		opcion=$("#opcion").data("op");
		$("#formedit div input").each(function(){
			if(i===1){
				data += '{"' + $(this).attr("name") + '":"' + $(this).val() + '",';
			}else{
				data += '"' + $(this).attr("name") + '":"' + $(this).val() + '",';
			}
			i++;
			
		});
		data = data.substring(0,data.length-1);
		data += '}';
// if(opcion==="usuarios"){
// data = '{"usuario":"' + $("#formedit #usuario2").val() + '","password":"' +
// $("#formedit #password2").val() + '"}';
//			
// }else if(opcion==="productos"){
// data = '{"id":' + $("#formedit #id2").val() + ',"nombre":"' + $("#formedit
// #nombre2").val() + '","codigo":"' + $("#formedit #codigo2").val() +
// '","precio":"' + $("#formedit #precio2").val() + '"}';
//			
// }else{
//			
// }
		$.post("admin/editarregistro",{dataold,data,opcion},function(e){
			
		}).done(function(data2) {
			
			var ob= JSON.parse(data2),
				i=1;
			for (var key in ob) {
			    if (ob.hasOwnProperty(key)) {
			    	tredit.find("td:nth-child(" + i + ")").each(function(){
			    		$(this).text(ob[key]);
			    	});
			    	i++;
			    }
			}
			
		}).fail(function() {
		    console.log("Campos vacios");
		}).always(function(){
			  $(".modal-footer .btn-danger").click();
		 });
		
	});
});
function deleteregistro(e,t){
	'use strict';
	e.preventDefault();
	if (window.confirm("Estas seguro que deseas borrar el registro?")) { 
		var padre = $(t).parent().parent(), // tr
			i=1,
			data="";
		
		padre.find("td:not(:last-child)").each(function(){
    	    if(i===1){
				data += '{"' + $(this).attr("name2") + '":"' + $(this).text() + '",';
			}else{
				data += '"' + $(this).attr("name2") + '":"' + $(this).text() + '",';
			}
			i++;
    	});
		data = data.substring(0,data.length-1) + "}";
		console.log(data);
		$.post("admin/deleteregistro",{data,opcion:$("#opcion").data("op")},function(e){
			
		}).done(function(data2) {
			padre.remove();
		    
		  })
		  .fail(function() {
		    console.log("Campos vacios");
		  }).always(function(){
			  $(".modal-footer .btn-danger").click();
		  });
	}
}

function editRegistro(e,t){
	'use strict';
	e.preventDefault();
	var padre = $(t).parent().parent(), // tr
	i=1;
	camposedit="";
	padre.find("td:not(:last-child)").each(function(){
	    	$("#formedit div:nth-child(" + i + ") input").val($(this).html());
	    	if(i===1){
	    		camposedit+='{"' +$("#formedit div:nth-child(" + i + ") input").attr("name") + '":"' + $(this).html() + '",';
	    	}else{
	    		camposedit+='"' + $("#formedit div:nth-child(" + i + ") input").attr("name") + '":"' + $(this).html() + '",';
	    	}
	    	i++;
	});
	tredit = padre;
	camposedit = camposedit.substring(0,camposedit.length-1);
	camposedit+="}";
	console.log(camposedit);
}

