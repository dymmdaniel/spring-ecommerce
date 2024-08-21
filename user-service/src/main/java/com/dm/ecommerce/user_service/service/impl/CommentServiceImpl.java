package com.dm.ecommerce.user_service.service.impl;

import com.dm.ecommerce.common_service.service.impl.CommonMongoServiceImpl;
import com.dm.ecommerce.user_service.model.Comment;
import com.dm.ecommerce.user_service.repository.CommentRepository;
import com.dm.ecommerce.user_service.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends CommonMongoServiceImpl<Comment, CommentRepository> implements CommentService {
}
