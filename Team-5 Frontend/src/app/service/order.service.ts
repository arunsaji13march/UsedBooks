import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../orderdelivery/order';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  authUrl:string;
  authUrl1:string;
  authUrl2:string
  constructor(private httpclient: HttpClient, private loginService:LoginService) {
    this.authUrl="http://localhost:8083/orders/api/getOrderByOrderId";
    this.authUrl1="http://localhost:8083/orders/api/getOrdersById"
    this.authUrl2="http://localhost:8083/orders/api/editOrderStatus"
   }
   addOrder(data:Order):Observable<Order>{
      return this.httpclient.post<Order>("http://localhost:8083/orders/api/addOrder",data,{
        headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
      });
   }
   
   getOrderByOrderId(orderId: number):Observable<Order>{
    return this.httpclient.get<Order>(`${this.authUrl}/${orderId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });
   }

   getOrdersByUserId(userId:number):Observable<Order[]>{
    return this.httpclient.get<Order[]>(`${this.authUrl1}/${userId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    })
   }
   editOrderStatus(orderId:number,data:Order):Observable<Order>{
    return this.httpclient.patch<Order>(`${this.authUrl2}/${orderId}`,data,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });
   }

   getOrders():Observable<Order[]>{
    return this.httpclient.get<Order[]>("http://localhost:8083/orders/api/getAllOrder");
  }
}
