package pe.edu.cibertec.Juegos.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_game")
public class Juego {
	@Id
	private Integer id_game;
	@Column(name = "name_game")
	private String name_game;
	@Column(name = "description")
	private String description;

}
