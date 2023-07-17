import { Component,OnInit } from '@angular/core';
import { BookServiceService } from '../service/book-service.service';
import { Books } from '../Model/Books';
import { Route, Router } from '@angular/router';
import { CartService } from '../service/cart.service';
import { Cart } from '../Model/Cart';
import { LoginService } from '../service/login.service';
import { AuthService } from '../service/auth.service';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  
    books:Books;
    booksList:Books[];
    bookId:string='';
    userId:any;
    cartItems: Cart[];
  constructor(private bookService:BookServiceService, private router:Router,private cartService:CartService,private loginService:LoginService, private authService:AuthService, private notifyService:NotificationService){
    this.books=new Books();
    this.booksList=[];
    this.cartItems=[];
  }

  ngOnInit(): void {
    this.bookService.getBooksByStatus("Available").subscribe(
      bookData=>{this.booksList=bookData,
      console.log(this.booksList)},
      err=>console.log(err)
    )
  }

  

goToProduct(bookId:string, event: Event) {
  if (!(event.target as HTMLElement).classList.contains('btn')) {
    this.router.navigate(['../product/',bookId]);
  }
}

addToCart(book: Books, event: Event) {
  event.stopPropagation();

  if (!(event.target as HTMLElement).classList.contains('btn')) {
    this.userId = this.loginService.getUserId();
    if (this.userId != null) {
      this.cartService.getCartItemByUserId(this.loginService.getUserId()).subscribe(
        resp => {
          console.log(resp);
          this.cartItems = resp;
          console.log(this.cartItems);

          const isBookInCart = this.cartItems.some(item => item.bookId === book.bookId);
          console.log(isBookInCart);

          if (isBookInCart) {
            this.notifyService.showInfo("", "Item Already Added to Cart");
          } else {
            console.log(this.userId);
            let cartobj = new Cart();
            cartobj.bookId = book.bookId;
            cartobj.bookName = book.bookName;
            cartobj.userId = this.userId;
            cartobj.image = book.image;
            cartobj.price = book.price;

            this.cartService.addCartItem(cartobj).subscribe(
              res => {
                console.log(res);
                this.notifyService.showSuccess("", "Added to Cart");
              },
              err => {
                console.log(err);
              }
            );
          }
        },
        err => console.log(err)
      );
    } else {
      this.router.navigate(['/login']);
    }
  }
}

}
