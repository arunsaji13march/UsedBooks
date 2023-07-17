import { CanActivateFn, Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../service/login.service';
import { inject } from '@angular/core';

export const canactivateGuard: CanActivateFn = (route, state):Observable<boolean | UrlTree>|Promise<boolean | UrlTree>|boolean|UrlTree => {
  
  var myStatus:boolean = false;
  const loginService:LoginService= inject(LoginService);
  const router:Router = inject(Router);
  const bearerToken =loginService.getBearerToken();
  if(bearerToken!=null){
    // const authStatus:boolean = loginService.isUserAuthenticated(bearerToken);
    // console.log("Auth Status in Guard" + authStatus);
    // if(authStatus){
    // console.log("Data...");
    myStatus = true;
  }else{
    router.navigate(['/login']);
    myStatus=false;
  }

  
  console.log(myStatus);
  return myStatus;
}
