package pe.edu.cibertec.Juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.Juegos.model.bd.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer>{

}
