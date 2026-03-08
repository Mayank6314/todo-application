package com.example.TODO_Application.repository;

import com.example.TODO_Application.entities.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TODORepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Todo> findAll(){
        TypedQuery<Todo> typedQuery = entityManager.createQuery("from Todo", Todo.class);
        return typedQuery.getResultList();
    }

    @Transactional
    public void save(Todo todo){
        entityManager.persist(todo);
    }
}
