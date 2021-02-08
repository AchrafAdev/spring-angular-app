import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: [],
})
export class ClientesComponent implements OnInit {
  clientes: Cliente[];

  constructor(private clienteService: ClienteService) {}

  ngOnInit() {
   this.clienteService.getClientes().subscribe(
    clientes => this.clientes = clientes
   );
  }

  delete(cliente : Cliente ) : void {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Deseas eliminar al cliente?',
      text: "Esta acción no se podrá deshacer",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'SI',
      cancelButtonText: 'No, cancelar',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {

        this.clienteService.delete(cliente.id).subscribe(
          response =>{
            this.clientes = this.clientes.filter(cli => cli !== cliente)
          })
        

        swalWithBootstrapButtons.fire(
          'Eliminado!',
          'Tu cliente ha sido eliminado',
          'success'
        )
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {

        
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'Tu cliente no ha sido eliminado',
          'error'
        )
      }
    })
  }
}
