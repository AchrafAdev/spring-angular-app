import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  public cliente : Cliente =  new Cliente();

  constructor(private clienteService : ClienteService, private router: Router, private activatedRouter : ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarCliente()
  }

  public create(): void{
    this.clienteService.create(this.cliente).subscribe(
      response => {
      this.router.navigate(['/clientes'])
      swal.fire({
        title: 'Nuevo cliente',
        text: `El cliente ${response.nombre} ha sido creado de manera correcta`,
        icon: 'success',
        confirmButtonText: 'De acuerdo'

      })
      }
    );

  }

  cargarCliente(): void{
  
    this.activatedRouter.params.subscribe(params => {
      let id = params['id']

      if(id){
        this.clienteService.getCliente(id).subscribe(
          response => this.cliente = response
        )
      }
    })
  
  }

  update() : void{
    this.clienteService.update(this.cliente).subscribe(
      response =>{
      this.router.navigate(['/clientes'])
      swal.fire({
        title: 'Cliente editado',
        text: `El cliente ${response.nombre} ha sido editado de manera correcta`,
        icon: 'success',
        confirmButtonText: 'De acuerdo'
      })
      });
  }

}
