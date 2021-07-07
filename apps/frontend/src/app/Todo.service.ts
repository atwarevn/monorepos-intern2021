import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from './Todo.interface';

const baseUrl = 'http://localhost:8080/api/todos'

@Injectable({
  providedIn: 'root',
})
export class TodoService {

  constructor(private http: HttpClient) {  }

  getAllTodos() : Observable<Todo[]>{
      return this.http.get<Todo[]>(baseUrl);
  }
  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

}
