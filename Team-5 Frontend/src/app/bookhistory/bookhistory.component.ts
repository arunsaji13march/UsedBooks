import { Component, OnInit } from '@angular/core';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { NotificationDialogComponent } from '../notification-dialog/notification-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-bookhistory',
  templateUrl: './bookhistory.component.html',
  styleUrls: ['./bookhistory.component.css']

})

export class BookhistoryComponent implements OnInit {

  bookId:string | undefined;
  sellItems!:Books[];
  flag:boolean=false;

  constructor(private bookservice:BookServiceService,private router:Router, private logService:LoginService, private dialog:MatDialog, private notifyService:NotificationService){  }

  ngOnInit(): void{

    this.bookservice.getBooksBySellerId(this.logService.getUserId()).subscribe(
      (res:any)=>{
        this.sellItems=res
        console.log(this.sellItems)
      },
      (err:any)=>console.log(err)

    )
  }

  continueShopping(){
    this.router.navigate(['/home'])
  }

  editBook(bookId: any){

      this.router.navigate(['../editBook/',bookId]);

  }
  deleteBook(bookId: string) {
    console.log(bookId);
    // this.flag = confirm("Do you want to delete?");
    const dialogRef = this.dialog.open(NotificationDialogComponent, {
      width: '400px',
      data: {
        title: 'Notification',
        message: 'This is a notification message.'
      }
    });
    dialogRef.afterClosed().subscribe((result: string) => {
      if (result === 'ok') {
        this.flag = true;
      } else if (result === 'cancel') {
        this.flag = false;
      }
    
    if (this.flag) {
      this.bookservice.deleteBooks(bookId).subscribe(
        (response: any) => {
          // Handle successful deletion, if needed
          // console.log('Book deleted successfully', response);
          this.notifyService.showSuccess("Successfully !!", "Book Deleted");
          this.ngOnInit();
        },
        (error: any) => {
          // Handle error during deletion, if needed
          // console.error('Failed to delete book', error);
          this.notifyService.showSuccess("Successfully !!", "Book Deleted");
          this.ngOnInit();
        }
      );
    }
  })
  }
}