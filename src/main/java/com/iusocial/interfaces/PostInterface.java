package com.iusocial.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.iusocial.model.Posts;

public interface PostInterface extends CrudRepository<Posts,Integer>{

}
