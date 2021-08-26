import {Component, OnInit} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Tabledata } from '@app/model/table.data';


const ELEMENT_DATA: Tabledata[] = [
  {position: 1, name: 'Crocin 500 MG', price: 20, brand: 'GSK LABS', availablequantity: 500},
  {position: 2, name: 'Pudin Hara', price: 25, brand: 'Dabur', availablequantity: 100},
  {position: 3, name: 'Okacet', price: 22, brand: 'Cipla', availablequantity: 67},
  {position: 4, name: 'Favipiravir', price: 1800, brand: 'Cipla', availablequantity: 80},
  {position: 5, name: 'LimCee', price: 22.93, brand: 'Abbot', availablequantity: 564},
  {position: 6, name: 'Cheston Cold', price: 39, brand: 'Cipla', availablequantity: 450}
];

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

  constructor() { }

  ngOnInit() {
    this.dataSource.data = ELEMENT_DATA;
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
}
