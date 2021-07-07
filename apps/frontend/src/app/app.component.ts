import { Component, OnInit } from '@angular/core';
import { Todo } from './Todo.interface';
import { TodoService } from './Todo.service';

@Component({
  selector: 'monorepos-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})


export class AppComponent implements OnInit{
  todos:  Todo[] = [];

  constructor(private todoService:TodoService){}

  ngOnInit(){
    this.todoService.getAllTodos()
    .subscribe(res => this.todos = res);
  }


}
