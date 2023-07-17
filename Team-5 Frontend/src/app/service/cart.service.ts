import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Cart } from '../Model/Cart';
import { Books } from '../Model/Books';
import { LoginComponent } from '../login/login.component';
import { LoginService } from './login.service';




@Injectable({

  providedIn: 'root'

})

export class CartService {

  authurl!:string;

  authurl1!:string;

  bookurl!:string;




  constructor(private http: HttpClient,private loginService:LoginService) {

    this.authurl="http://localhost:8082/cart/getByUserId"

    this.authurl1="http://localhost:8082/cart/delCartById"

    this.bookurl="http://localhost:8085/books/v1/getBooksById"

  }




  getCartItems(): Observable<any> {

    return this.http.get("http://localhost:8082/cart/getAllCartItems",{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });

  }

  addCartItem(cartObj:Cart):Observable<any>{
    return this.http.post("http://localhost:8082/cart/addToCart",cartObj,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });
  }


  getCartItemByUserId(userId:string|null):Observable<any>{

    return this.http.get(`${this.authurl}/${userId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    })

  }

  deleteCartItemById(cartId:number):Observable<any>{

    return this.http.delete(`${this.authurl1}/${cartId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    })




  }

}
