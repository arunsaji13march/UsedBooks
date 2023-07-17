import { Component, OnInit } from '@angular/core';

import { FormGroup } from '@angular/forms';

import { Router } from '@angular/router';

import { Reg } from '../Model/Reg';

import { RegserviceService } from '../service/regservice.service';




@Component({

  selector: 'app-userdashboard',

  templateUrl: './userdashboard.component.html',

  styleUrls: ['./userdashboard.component.css']

})

export class UserdashboardComponent implements OnInit {

  reglist!: Reg[];
  myForm!: FormGroup;
  Obj!: Reg;
  userId:any;

  constructor(private regservice: RegserviceService, private router: Router) {
    this.reglist = []

  }

  ngOnInit(): any {
    this.userId=localStorage.getItem('userId');
    this.regservice.getUserbyId(this.userId).subscribe(
      (res: any) => {
        this.Obj=res
        this.reglist.push(res)
        console.log(this.reglist)
      },
      err => console.log(err)
    )

  }

  orders() {
    this.router.navigate(['/orderHistory'])
  }

  cart() {
    this.router.navigate(['cart'])
  }

  edit() {
    this.router.navigate(['update'])
  }

  sellhistory() {
    this.router.navigate(['sellhistory'])
  }

  get userEmail() {
    return this.myForm.get('userEmail');
  }


  get userFirstName() {
    return this.myForm.get('userFirstName')
  }

  get userLastName() {
    return this.myForm.get('userLastName')
  }

  get userDob() {
    return this.myForm.get('userDob')
  }


  get userGender() {
    return this.myForm.get('userGender')

  }

  get userMobile() {
    return this.myForm.get('userMobile')

  }

  get userAddress() {
    return this.myForm.get('userAddress')

  }

  get userPassword() {

    return this.myForm.get('userPassword')
  }

}