package pe.edu.cibertec.Juegos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.Juegos.model.bd.Juego;
import pe.edu.cibertec.Juegos.request.JuegoRequest;
import pe.edu.cibertec.Juegos.response.ResultadoResponse;
import pe.edu.cibertec.Juegos.service.JuegoService;

@Controller
@RequestMapping("/juego")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;
	
	
	@GetMapping("/frmjuego")
	public String frmMantJuego(Model model) {
		model.addAttribute("listajuegos", juegoService.listarJuegos());
		return "juego/frmjuego";
	}
	
	
	@PostMapping("/registrarJuego")
	@ResponseBody
	public ResultadoResponse registrarJuego(@RequestBody JuegoRequest juegoRequest) {
		String mensaje = "Juego registrado correctamente";
		Boolean respuesta = true;
		
		try {
			Juego objJuego = new Juego();
			if(juegoRequest.getId_game() > 0) {
				objJuego.setId_game(juegoRequest.getId_game());
			}
			objJuego.setName_game(juegoRequest.getName_game());
			objJuego.setDescription(juegoRequest.getDescription());
			
			
			juegoService.registrarJuego(objJuego);
		
		} catch (Exception ex) {
			 mensaje = "Juego no registrado :c ";
			 respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
	}

	
	/*
	 * @PostMapping("/registrarSala")
	@ResponseBody
	public ResultadoResponse registrarSala( @RequestBody SalaRequest salaRequest) {
		String mensaje ="Sala registrada correctamente";
		Boolean respuesta = true;
		try {			
			//Se puede aplicar el patrón Builder en estos objetos
			Sala objSala = new Sala();
			if(salaRequest.getIdsala() > 0) {
				objSala.setIdsala(salaRequest.getIdsala());
			}
			objSala.setDescsala(salaRequest.getDescsala());
			objSala.setAsientos(salaRequest.getAsientos());
			
			Estado objEstado = new Estado();
			objEstado.setIdestado(salaRequest.getIdestado());
			
			
			objSala.setEstado(objEstado);
			salaService.registrarSala(objSala);
		}catch(Exception ex) {
			mensaje = "Sala no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	 * 
	 * 
	 * 
	 */
	
	
	@DeleteMapping("/eliminarJuego")
	@ResponseBody
	public ResultadoResponse eliminarJuego(@RequestBody JuegoRequest juegoRequest) {
		String mensaje = "Juego eliminado correctamente";
		Boolean respuesta = true;
		
		try {
			juegoService.eliminarJuego(juegoRequest.getId_game());
		} catch (Exception e) {
			 mensaje = "Juego no eliminado ";
			 respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();		
	}
	
	
	@GetMapping("/listarJuegos")
	@ResponseBody
	public List<Juego> listarJuegos(){
		return juegoService.listarJuegos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
