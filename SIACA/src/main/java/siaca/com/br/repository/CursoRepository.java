package siaca.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import siaca.com.br.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
