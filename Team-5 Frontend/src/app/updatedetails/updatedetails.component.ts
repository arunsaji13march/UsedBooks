import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Reg } from '../Model/Reg';

import { RegserviceService } from '../service/regservice.service';
import { Router } from '@angular/router';
import { NotificationService } from '../service/notification.service';




@Component({

  selector: 'app-updatedetails',

  templateUrl: './updatedetails.component.html',

  styleUrls: ['./updatedetails.component.css']

})

export class UpdatedetailsComponent  implements OnInit{




  public myForm!: FormGroup;

  uObj!: Reg;

  updatelist!:any;





constructor(private regService:RegserviceService,private router:Router, private formbuilder:FormBuilder,private notifyService:NotificationService){

  this.updatelist=[]




}






ngOnInit(): any {
  
  this.regService.getUserbyId(this.regService.getUserId()).subscribe(
    res=>{
      this.uObj=res,
      this.updatelist={...this.uObj}
    console.log(this.uObj)
  },

  err=>console.log(err)

)






  this.myForm = this.formbuilder.group({

    userEmail:['',Validators.required],

    userFirstName: ['', Validators.required],

    userLastName: ['', Validators.required],

    userDob: ['', Validators.required],

    userMobile: ['', Validators.required],

    userAddress: ['', Validators.required],

    userPassword:['', Validators.required]




  },

 

 

  )

}






update(myForm:FormGroup){

  this.uObj= myForm.value

  this.regService.updateUserbyUserId(this.regService.getUserId(),this.uObj).subscribe(

    (res:any)=>{

      console.log(res)
      this.notifyService.showSuccess("Updated Successfully", "User Details");
      this.router.navigate(['userdashboard'])

    },err=>console.log(err)

  )

 

}





  get userEmail() {

    return this.myForm.get('userEmail');

  }

 

  get userFirstName()

  {

    return this.myForm.get('userFirstName')

  }

  get userLastName()

  {

    return this.myForm.get('userLastName')

  }

 

  get userDob()

  {

    return this.myForm.get('userDob')

  }

 

  get userGender()

  {

    return this.myForm.get('userGender')

  }

 

  get userMobile()

  {

    return this.myForm.get('userMobile')

  }

 

  get userAddress()

  {

    return this.myForm.get('userAddress')

  }

 

  get userPassword()

  {

    return this.myForm.get('userPassword')

  }




}