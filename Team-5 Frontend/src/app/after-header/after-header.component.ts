import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Books } from '../Model/Books';
import { AuthService } from '../service/auth.service';
import { BookServiceService } from '../service/book-service.service';
import { LoginService } from '../service/login.service';
import { NotificationDialogComponent } from '../notification-dialog/notification-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-after-header',
  templateUrl: './after-header.component.html',
  styleUrls: ['./after-header.component.css']
})
export class AfterHeaderComponent {

  books: Books[] = [];
  pattern: string ="";
  loggedIn=false;
  flag:boolean=false;
  constructor(private bookService: BookServiceService, private router:Router, private authservice:AuthService, private loginService: LoginService,private dialog:MatDialog) {  }

  ngOnInit() {
    this.authservice.isLoggedIn$.subscribe((loggedIn: boolean) => {
      this.loggedIn = loggedIn;
    });
  }

  
  // profile(){
  //   window.alert("Going to dashboard")
  //   this.router.navigate(['/userdashboard'])
  // }
  // cart(){
  //   this.router.navigate(['/cart']);
  // }


  searchBooks() {

    this.router.navigate(['/search',this.pattern ]);
    console.log(this.pattern);
  } 
  goToLogin(){
    this.router.navigate(["/login"]);
  }

  // selectBook(bookId: any){
  //   this.router.navigate(['/product',bookId]);
  //   console.log(bookId);
    
  // }

  logout(){
    // this.flag=confirm("Are You sure you want logout");
    const dialogRef = this.dialog.open(NotificationDialogComponent, {
      width: '400px',
      data: {
        title: 'Logout',
        message: 'Are you sure?'
      }
    });
    dialogRef.afterClosed().subscribe((result: string) => {
      if (result === 'ok') {
        this.flag = true;
      } else if (result === 'cancel') {
        this.flag = false;
      }
    if(this.flag){
      localStorage.clear();
      this.ngOnInit
      this.authservice.setLoggedIn(false);
      this.router.navigate(["/home"])
    }
    else{
      
    }
  });
          
  }
  

}
