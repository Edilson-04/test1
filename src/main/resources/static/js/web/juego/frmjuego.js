$(document).on("click", "#btnagregar", function(){
	$("#txtidjuego").val("");
	$("#txtnombrejuego").val("");
	$("#txtdescripcion").val("");
	$("#hddidregistrojuego").val("0");
	$("#modalJuego").modal("show");
});



$(document).on("click", ".btnactualizar", function(){
	$("#txtidjuego").val($(this).attr("data-id_game"));
	$("#txtnombrejuego").val($(this).attr("data-name_game"));
	$("#txtdescripcion").val($(this).attr("data-description"));
	$("#hddidregistrojuego").val($(this).attr("data-id_game"));	
	$("#modalJuego").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/juego/registrarJuego",
		contentType: "application/json",
		data: JSON.stringify({
			id_game: $("#txtidjuego").val(),
			name_game: $("#txtnombrejuego").val(),
			description: $("#txtdescripcion").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarJuegos();
		}
	});
	$("#modalJuego").modal("hide");
})



$(document).on("click", ".btneliminarjuego", function(){
	$("#hddideliminarjuego").val("");
	$("#hddideliminarjuego").val($(this).attr("data-id_game"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar "+ 
			$(this).attr("data-name_game")+"?");
	$("#modalEliminarJuego").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/juego/eliminarJuego",
		data: JSON.stringify({
			id_game: $("#hddideliminarjuego").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarJuegos();
		}
	})
	$("#modalEliminarJuego").modal("hide");
})

function ListarJuegos(){
	$.ajax({
		type: "GET",
		url: "/juego/listarJuegos",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tbljuego > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tbljuego > tbody").append("<tr>"+
						"<td>"+value.id_game+"</td>"+
						"<td>"+value.name_game+"</td>"+
						"<td>"+value.description+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_game='"+value.id_game+"'"+
							" data-name_game='"+value.name_game+"'"+
							" data-description='"+value.description+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarjuego'"+	
							" data-id_game='"+value.id_game+"'"+
							" data-name_game='"+value.name_game+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}



