
package com.api.v1.ema_h2.repo;

import com.api.v1.ema_h2.model.Log;
import org.springframework.data.repository.CrudRepository;


public interface LogRepository extends CrudRepository<Log, Long>{
    
}
