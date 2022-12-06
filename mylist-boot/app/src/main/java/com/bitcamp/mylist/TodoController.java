package com.bitcamp.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  @GetMapping("/todo/list")
  public Object list() {
    return ArrayList2.toArray();
  }

  @GetMapping("/todo/add")
  public Object add(Todo todo) {
    ArrayList2.add(todo);
    return ArrayList2.size;
  }

  @GetMapping("/todo/get")
  public Object get(int index) {
    if(index < 0 || index >= ArrayList2.size) {
      return "";
    }
    return ArrayList2.list[index];
  }

  @GetMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if(index < 0 || index >= ArrayList2.size) {
      return 0;
    }
    return ArrayList2.set(index, todo) == null ? 0 : 1;
  }

  @GetMapping("/todo/delet")
  public Object delet(int index) {
    if(index < 0 || index >= ArrayList2.size) {
      return 0;
    }
    ArrayList2.remove(index);
    return 1;
  }
}
