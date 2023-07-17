import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paymentsuccess',
  templateUrl: './paymentsuccess.component.html',
  styleUrls: ['./paymentsuccess.component.css']
})
export class PaymentsuccessComponent  implements OnInit {

  constructor(private router:Router){}
  showText = false;

  ngOnInit() {
    setTimeout(() => {
      this.showText = true;
    }, 2000); // Delay of 2000 milliseconds (2 seconds)

    setTimeout(() => {
      this.router.navigate(['/orderHistory']); // Replace '/another-page' with the route you want to navigate to
    }, 4000); 
  }
}
