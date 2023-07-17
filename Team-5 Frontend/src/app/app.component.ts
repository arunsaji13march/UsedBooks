import { Component } from '@angular/core';
import { AuthService } from './service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BookStore';


 

  constructor(private headerService:AuthService,private router:Router) {}

  ngOnInit() {
    
    }
check(){
  if(localStorage?.getItem("bearerToken")!=null){
    return true
  }
return false

}
    logOut(){

      localStorage.clear();
      // this.router.navigate(['/login'])
      
    }
  }
