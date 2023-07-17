import { Component, OnInit } from '@angular/core';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../service/cart.service';
import { LoginService } from '../service/login.service';
import { Cart } from '../Model/Cart';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  books:any;  
  bookId:string='';
  userId:any;
  cartItems:Cart[];
  constructor(private bookService:BookServiceService, private cartService: CartService, private router:ActivatedRoute,private loginService:LoginService, private router1:Router,private notifyService:NotificationService ){
    this.cartItems=[];
  
  
  }
  ngOnInit(): void {
    this.router.params.subscribe(params => {
      this.bookId = params['bookId'];
      console.log(this.bookId)});
    this.bookService.getBookById(this.bookId).subscribe(
      (result: Books) => {
        this.books = result;
      },
      (error) => {
        console.error('Error occurred while getting book by ID:', error);
      }
    );

    }
      addToCart(book:Books){
        
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
      this.router1.navigate(['/login']);
    }
  }
    
      
    
}

