import { Component } from '@angular/core';
import { Order } from './order';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { OrderService } from '../service/order.service';
import {Location} from '@angular/common'
import { BookServiceService } from '../service/book-service.service';
import { Books } from '../Model/Books';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-orderdelivery',
  templateUrl: './orderdelivery.component.html',
  styleUrls: ['./orderdelivery.component.css']
})
export class OrderdeliveryComponent {
  oObj:Order;
  userIdDemo:any="";
  book:Books;
  bookIdDemo:string="";


  constructor(private orderService:OrderService, private router:Router, private route:ActivatedRoute, private location: Location,private bookService:BookServiceService, private notifyService:NotificationService){
    this.oObj = new Order();
    this.book=new Books();
  }

  ngOnInit(): void {
    this.userIdDemo = localStorage.getItem('userId');
    this.route.queryParams.subscribe(
      params => {
        this.bookIdDemo=params['bookId'];
      }
    )
    console.log(this.oObj.bookId);
  }

  
  placingOrder(orderForm:NgForm){
    if(orderForm.valid){
    this.oObj = orderForm.value;
    this.oObj.userId=this.userIdDemo;
    console.log(this.userIdDemo)
    this.oObj.bookId = this.bookIdDemo;
    console.log(this.bookIdDemo);
    this.orderService.addOrder(this.oObj).subscribe(
      (resp:any)=>{
        console.log(resp)
        console.log(resp.orderId);
        
        this.notifyService.showSuccess("Thank You!!", "Order Placed Successfull");
        // this.changeStatus(this.bookIdDemo);
        this.book.status='Sold';
        this.bookService.updateBookStatus(this.bookIdDemo,this.book).subscribe(
          resp=>{console.log(resp)
            // this.notifyService.showSuccess("Successfully", "Order Deleted");
          },
          err=>console.log(err)
        )

        this.router.navigate(['/paymentSuccess']);

      },
      (err:any)=>{console.log(err)}
    )
    }
  }
  goBack(){
    this.location.back();
  }

  


  updateBookStatus(bookId: string, book:Books) {
    this.bookService.updateBookStatus(bookId, this.book).subscribe(
      (response: any) => {
        // Handle successful update, if needed
        console.log('Book status updated successfully', response);
      },
      (error: any) => {
        // Handle error during update, if needed
        console.error('Failed to update book status', error);
      }
    );
  }
}
