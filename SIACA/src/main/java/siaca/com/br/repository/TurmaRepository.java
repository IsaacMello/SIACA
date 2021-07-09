package siaca.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import siaca.com.br.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

		   

}