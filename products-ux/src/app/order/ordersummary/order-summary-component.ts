import { Component, Input, OnInit } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { ActivatedRoute } from "@angular/router";
import { OrderSummaryItemData } from "@app/_models/order.summary.items";
import { OrderSummaryData } from "@app/_models/order.summary.data";
import { OrderProductService } from "@app/_services/order.product.service";

@Component({
    selector: 'order-summary-component',
    templateUrl: 'order.summary.component.html',
  })
export class OrderSummaryComponent implements OnInit{

    displayedColumns: string[] = ['sno', 'itemdesc', 'rate', 'quantity','price'];
    dataSource = new MatTableDataSource<OrderSummaryItemData>();
    clickedRows = new Set<OrderSummaryItemData>();
    isDataLoaded : boolean = false;
    orderId : number;
    data : OrderSummaryData;

    constructor(private orderProdservice : OrderProductService,
        private route: ActivatedRoute) {
            this.data = {
                tax : null,
                totalPrice : null,
                items : []
            }
         }

    ngOnInit() {
        this.orderId = Number.parseInt(this.route.snapshot.paramMap.get('orderId'));
        this.orderProdservice.getOrderSummary(this.orderId).subscribe(order => {
            this.data.tax = order.tax;
            this.data.totalPrice = order.totalAmount;
            order.orderDetailList.forEach((element,i) => {
                const itemData = {
                    sno : i+1,
                    itemdesc : element.description,
                    quantity : element.quantity,
                    rate : element.price,
                    price : element.quantity * element.price
                };
                this.data.items.push(itemData);
            });
            this.dataSource.data = this.data.items;
            this.isDataLoaded = true;
        })
    }

    public doFilter = (value: string) => {
        this.dataSource.filter = value.trim().toLocaleLowerCase();
      }
}