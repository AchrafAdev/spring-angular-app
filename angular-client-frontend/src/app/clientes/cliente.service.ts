import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { catchError } from 'rxjs/operators';
import { from, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import Swal from 'sweetalert2';
import{Router} from '@angular/router'
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Injectable()
export class ClienteService {

  private urlEndPoint: string = "http://localhost:8080/api/clientes";
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient, private router:Router) { }



  getClientes(): Observable<Cliente[]> {
    //return of(ListClientes);
    return this.http.get<Cliente[]>(this.urlEndPoint)
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.urlEndPoint, cliente,{headers: this.httpHeaders}).pipe(
      catchError(e =>{
        console.error(e.error.mensaje);
        Swal.fire('Error al crear el cliente', e.error.message, 'error');
        return throwError(e);
      })
    );
  }

  getCliente(id : Number): Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/clientes']);
        console.log(e.error.message);
        Swal.fire('Error al editar', e.error.message, 'error');
        return throwError(e);
        
      })
    );
  }

  update(cliente : Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`, cliente,{headers: this.httpHeaders})
  }

  delete(id : Number): Observable<Cliente> {
   return this.http.delete<Cliente>(`${this.urlEndPoint}/${id}`)
 }

  redirect_404(){
    let reg = new RegExp('^[0-9]+$');
    let urlBanned = this.router.url.split("/");
    if (urlBanned.length == 3 && urlBanned[2].match(reg)) {
      this.router.navigate(['/clientes']);
      Swal.fire('Error al acceder','Esa funcionalidad aun no se encuentra disponible', 'error');
    }
  }
}
