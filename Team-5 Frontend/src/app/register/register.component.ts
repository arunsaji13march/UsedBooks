import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Reg } from '../Model/Reg';
import { RegserviceService } from '../service/regservice.service';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  public myForm!: FormGroup;
  regobj: Reg;
  reglist: Reg[];


  
  constructor(private formbuilder: FormBuilder,  private router: Router, private http:HttpClient, private regservice:RegserviceService,private notifyService:NotificationService) {
    this.regobj = new Reg();
    this.reglist = [];
  }



  ngOnInit(): void {
    this.myForm = this.formbuilder.group({
      userEmail: ['', Validators.required],
      userFirstName: ['', Validators.required],
      userLastName: ['', Validators.required],
      userDob: ['', Validators.required],
      userGender: ['', Validators.required],
      userMobile: ['', Validators.required],
      userAddress: ['', Validators.required],
      userPassword:['', Validators.required]

    })

  }



route()
{
  this.router.navigate(['login'])
}
register(myForm: any)
{
  this.regobj = this.myForm.value;
  this.regservice.saveUser(this.regobj).subscribe(
    data => {console.log(data)
      this.notifyService.showSuccess("","Registration Successfully")
      this.router.navigate(['login']);
    },
    err => {console.log(err)
      this.notifyService.showError("","User Already Exists")
    }
  )
  // alert("Registration Completed")
  
  
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
