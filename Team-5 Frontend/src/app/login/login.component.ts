import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../Model/Login';
import { LoginService } from '../service/login.service';
import { AuthService } from '../service/auth.service';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  uObj: Login;
  loginForm!: NgForm;
  registeredUsers: Login[];


  constructor(private router:Router, private http:HttpClient, private logService:LoginService, private authservice:AuthService, private notifyService:NotificationService){
    this.uObj = new Login();
    this.registeredUsers = [];
  }
  // ngOnInit(): void {
  // }


route()
{
  this.router.navigate(['register'])
}
Login(loginForm:NgForm){
  this.uObj=loginForm.value

this.logService.setUserEmail(this.uObj.userEmail)

this.logService.authenticateUser(this.uObj).subscribe(
  (res:any)=>{
    const num:string=res["userId"].replace("userId","");
    
    this.logService.setUserId(num);
    console.log(this.logService.getUserId())
    this.logService.setRole(res["roleOfUser"])
    this.logService.setBearerToken(res["token"]);
    if(this.logService.getRole()=="user"){
    this.router.navigate(['home'])}
    else if(this.logService.getRole()=="admin"){
      this.router.navigate(['admin'])
    }
    // window.alert("Welcome to the dashboard ")
    this.notifyService.showSuccess("Welcome to Dashboard !!", "Login Successfull");
    this.authservice.setLoggedIn(true);
    

  },
  err=>{console.log(err)
    // window.alert("Wrong Credentials")
    this.notifyService.showError("Wrong Credentials","Login Failed");
  })
  
  

}

}
