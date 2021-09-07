import { Component, Input, OnInit } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { ActivatedRoute, Router } from "@angular/router";
import { Order } from "@app/_models/order";
import { OrderProductService } from "@app/_services/order.product.service";

@Component({
    selector: 'order-component',
    templateUrl: 'order.component.html',
  })
export class OrderComponent implements OnInit{

    displayedColumns: string[] = ['id', 'status', 'orderDate', 'tax','totalAmount'];
    dataSource = new MatTableDataSource<Order>();
    clickedRows = new Set<Order>();
    isDataLoaded : boolean = false;
    userId : string;

    constructor(private orderProdservice : OrderProductService,
        private route: ActivatedRoute,
        private router : Router) { }

    ngOnInit() {
        this.userId = this.route.snapshot.paramMap.get('userId');
        this.orderProdservice.getAllOrdersByUserId(this.userId).subscribe(orderList => {
            this.dataSource.data = orderList;
            this.isDataLoaded = true;
        })
    }

    public doFilter = (value: string) => {
        this.dataSource.filter = value.trim().toLocaleLowerCase();
      }

      naviagteToOrderPage(orderId : number){
        const url :string = '/osummary/' + orderId;
        this.router.navigate([url]);
      }
}