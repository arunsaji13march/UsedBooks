import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Login } from '../Model/Login';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private authurl:string

  loggedIn:boolean=false;


  constructor(private http:HttpClient, private router:Router, private authService:AuthService) {
    this.authurl="http://localhost:8084/path/login"
    
  }

authenticateUser(uObj:Login)
{
  return this.http.post(this.authurl,uObj);
}

setBearerToken(token:string)
{
  localStorage.setItem('bearerToken',token)
}
setUserId(id:string){
  localStorage.setItem('userId',id);
}
getUserId(){
  return localStorage.getItem('userId');
}

getBearerToken()
{
  return localStorage.getItem('bearerToken')
}

isUserAuthenticated(token:string){
  let status:boolean = true;
  this.http.post(`${this.authurl}/isAuthenticated`,{},{
    headers: new HttpHeaders().set('Authorization',`Bearer${token}`)
  }).pipe(map((res:any)=>{
    res['isAuthenticated']
  }));
  return status;

}

setUserEmail(email:string){
  localStorage.setItem('email',email)

}
getUserEmail(email:string){
  return localStorage.getItem('email')
}
setRole(role:string){
  localStorage.setItem('roleOfUser',role);
}
getRole(){
  return localStorage.getItem('roleOfUser');
}


}
