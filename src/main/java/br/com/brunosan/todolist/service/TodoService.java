package br.com.brunosan.todolist.service;

import br.com.brunosan.todolist.entity.Todo;
import br.com.brunosan.todolist.repository.ITodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final ITodoRepository iTodoRepository;

    public TodoService(ITodoRepository iTodoRepository) {
        this.iTodoRepository = iTodoRepository;
    }

    public List<Todo> create(Todo todo) {
        iTodoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return iTodoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        iTodoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        iTodoRepository.deleteById(id);
        return list();
    }
}
