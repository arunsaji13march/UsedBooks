import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service';
import { Order } from '../orderdelivery/order';
import { LoginService } from '../service/login.service';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';
import { NotificationService } from '../service/notification.service';
import { NotificationDialogComponent } from '../notification-dialog/notification-dialog.component';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent implements OnInit {
  userId:any;
  orders:Order[];
  bookId:string='';
  book:Books;
  constructor(private orderService:OrderService, private loginService: LoginService, private bookService:BookServiceService, private notifyService:NotificationService,private dialog:MatDialog){
    this.orders=[];
    this.book = new Books;
  }
  ngOnInit(): void {
    // this.userId =1;
    this.userId = this.loginService.getUserId();
    this.orderService.getOrdersByUserId(this.userId).subscribe(
      resp=>{
        this.orders = resp;
        console.log(this.orders)
        this.fetchBookDetailsForOrders();
      }
    )
  }
  fetchBookDetailsForOrders(){
    this.orders.forEach(
      order=>{
        this.bookService.getBookById(order.bookId).subscribe(
          book=>{
            order.bookName=book.bookName
            order.bookPrice=book.price
          }
        )
      }
    )
  }
  cancelOrder(order:any){
    const dialogRef = this.dialog.open(NotificationDialogComponent, {
      width: '400px',
      data: {
        title: 'Order Cancellation',
        message: 'Do you really want to cancel this Order?'
      }
    });
    dialogRef.afterClosed().subscribe((result: string) => {
      if (result === 'ok') {
        order.orderStatus='Canceled';
    this.orderService.editOrderStatus(order.orderId,order).subscribe(
      resp=>{console.log(resp)

        this.notifyService.showSuccess("Successfully", "Order Cancelled");

        this.book.status='Available';
        this.bookService.updateBookStatus(order.bookId,this.book).subscribe(
          resp=>{console.log(resp)
            this.notifyService.showSuccess("Successfully", "Order Deleted");
          },
          err=>console.log(err)
        )





      },
      err=>console.log(err)
    )
        
      } else if (result === 'cancel') {
        
      }
    })
    
  }
}