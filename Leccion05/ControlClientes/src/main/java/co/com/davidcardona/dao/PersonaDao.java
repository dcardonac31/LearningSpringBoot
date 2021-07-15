
package co.com.davidcardona.dao;

import co.com.davidcardona.domain.Persona;
import org.springframework.data.repository.CrudRepository;


public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
