import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { ListClientes } from './clientes.json';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient } from '@angular/common/http'

@Injectable()
export class ClienteService {

  private urlEndPoint: string = "http://localhost:8080/api/clientes";
  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]> {
    //return of(ListClientes);
    return this.http.get<Cliente[]>(this.urlEndPoint)
  }
}
