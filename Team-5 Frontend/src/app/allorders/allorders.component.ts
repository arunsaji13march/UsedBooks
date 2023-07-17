import { Component, OnInit } from '@angular/core';
import { Order } from '../orderdelivery/order';
import { BookServiceService } from '../service/book-service.service';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-allorders',
  templateUrl: './allorders.component.html',
  styleUrls: ['./allorders.component.css']
})
export class AllordersComponent implements OnInit{
  orderObj!:Order;
  orderlist!:Order[];

  constructor(private orderService:OrderService, private bookService:BookServiceService){
    this.orderObj=new Order()
    this.orderlist=[]

  }


  ngOnInit(): void {
    this.orderService.getOrders().subscribe(
      (res:any)=>{
        console.log(res)
        this.orderlist=res

      },
      err=>console.log(err)
    )
  }

  deliver(orderId:number,Delivered:string){
    this.orderObj.orderStatus="Delivered";
    console.log(orderId)
    console.log(this.orderObj);
    this.orderService.editOrderStatus(orderId,this.orderObj).subscribe(
     
      (res:any)=>{console.log(res)
        console.log("hi")
        this.ngOnInit()
      },
      err=>console.log(err)
      )
  }
    
  }
