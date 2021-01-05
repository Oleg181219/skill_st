package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.ToDo;

import java.util.List;

@RestController
public class ToDoController {
    /**
     *
     * @return весь список
     */
    @GetMapping("/todo")
    public List<ToDo> list() {
        return StorageToDo.getAllToDo();
    }
    /**
     *
     * @return вносит 1 дело
     */
    @PostMapping("/todo")
    public int add(ToDo toDo) {
        return StorageToDo.addToDo(toDo);
    }
    /**
     *
     * @return дело по id
     */
    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable int id) {
        ToDo toDo = StorageToDo.getToDo(id);
        if (toDo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(toDo, HttpStatus.OK);
    }
    /**
     *
     * удаление 1 по id
     */
    @DeleteMapping("/todo/{id}")
    public ResponseEntity deleteTodoById(@PathVariable int id) {
        ToDo toDo = StorageToDo.getToDo(id);
        if (toDo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        StorageToDo.deleteToDo(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    /**
     *
     * очистить весь список
     */
    @DeleteMapping("/todo")
    public ResponseEntity deleteAllToDo(){
        if(StorageToDo.getToDoList().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        StorageToDo.deleteAllToDo();
        return new ResponseEntity(HttpStatus.OK);
    }

}
