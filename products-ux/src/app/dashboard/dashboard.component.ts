import {Component, OnInit} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Tabledata } from '@app/_models/table.data';
import { OrderProductService } from '@app/_services/order.product.service';


/**
 * @title Binding event handlers and properties to the table rows.
 */
@Component({
  selector: 'dashboard-component',
  templateUrl: 'dashboard.component.html',
})
export class DashboardComponent implements OnInit{
  displayedColumns: string[] = ['position', 'name', 'brand', 'price','availablequantity'];
  dataSource = new MatTableDataSource<Tabledata>();
  clickedRows = new Set<Tabledata>();
  ELEMENT_DATA : Tabledata[] = [];
  isDataLoaded : boolean = false;

  constructor(private orderProdservice : OrderProductService) { }

  ngOnInit() {
    this.orderProdservice.getAllProducts().subscribe(prods =>{
      prods.forEach((p,i) => {
        const data  = {
          position : i+1,
	        name: p.name,
	        brand: p.company,
	        //description: p.description,
	        price: p.price,
	        availablequantity: p.quantity
        }
        this.ELEMENT_DATA.push(data)});
        this.isDataLoaded = true        
      this.dataSource.data = this.ELEMENT_DATA;
    })
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
}
