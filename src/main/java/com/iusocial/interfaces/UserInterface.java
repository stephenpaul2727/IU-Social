package com.iusocial.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.iusocial.model.User;

public interface UserInterface extends CrudRepository<User,Integer>{

	
}
