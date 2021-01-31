import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { ListClientes } from './clientes.json';


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
}
