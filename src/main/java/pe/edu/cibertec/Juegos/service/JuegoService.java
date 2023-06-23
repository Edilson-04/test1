package pe.edu.cibertec.Juegos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.Juegos.model.bd.Juego;
import pe.edu.cibertec.Juegos.repository.JuegoRepository;

@Service
public class JuegoService {
	
	@Autowired
	private JuegoRepository juegoRepository;
	
	
	
	public List<Juego> listarJuegos(){
		return juegoRepository.findAll();
	}
	
	
	public void registrarJuego(Juego juego) {
		juegoRepository.save(juego);
	}
	
	
	public void eliminarJuego(Integer id_game) {
		juegoRepository.deleteById(id_game);
	}
	

}
