import { Component } from '@angular/core';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
    books: Books[] = [];
    pattern: string ="";
    loggedIn=false;
    constructor(private bookService: BookServiceService, private router:Router, private authservice:AuthService,private loginService:LoginService) {  }

    ngOnInit() {
      // this.authservice.isLoggedIn$.subscribe((loggedIn: boolean) => {
      //   this.loggedIn = loggedIn;
    
    }

    
    profile(){
      window.alert("Going to dashboard")
      this.router.navigate(['/userdashboard'])
    }
    cart(){
      this.router.navigate(['/cart']);
    }


    searchBooks() {
      // console.log("clicked search ");
      // console.log(this.pattern);
      // this.bookService.searchBooksByName(this.pattern)
      //   .subscribe((result: Books[]) => {
      //     this.books = result;
      //     console.log(this.books)
      //   });
      // this.router.navigate(['/search/'])
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
        localStorage.clear()
        this.ngOnInit()
        this.authservice.setLoggedIn(false);
        this.router.navigate(['/home'])
    }
    

}
