package com.dm.ecommerce.user_service.repository;

import com.dm.ecommerce.user_service.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
}
