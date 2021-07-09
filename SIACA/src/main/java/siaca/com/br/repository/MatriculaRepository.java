package siaca.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import siaca.com.br.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
