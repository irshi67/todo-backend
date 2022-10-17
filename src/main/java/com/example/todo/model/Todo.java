package com.example.todo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "todos")
@TypeAlias("Todo")
@Accessors(chain = true)
public class Todo {
    @Id
    String id;
    String title;
    Status status;
}
