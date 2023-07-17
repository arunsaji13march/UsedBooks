import { Component,OnInit } from '@angular/core';
import { TotalUsers } from '../Model/TotalUsers';
import { RegserviceService } from '../service/regservice.service';

@Component({
  selector: 'app-totalusers',
  templateUrl: './totalusers.component.html',
  styleUrls: ['./totalusers.component.css']
})
export class TotalusersComponent implements OnInit {
  regObj!:TotalUsers;
  reglist!:TotalUsers[];
  constructor(private regService:RegserviceService){
    this.regObj= new TotalUsers;
    this.reglist=[];
  }
  ngOnInit(): void {
    this.regService.getUsers().subscribe(
      (res:any)=>{
        this.reglist=res
        console.log(this.reglist)
      },
      err=>console.log(err)
    )
  }
delete(userId:any){
  this.regService.deleteUser(userId).subscribe(
    (res:any)=>{
      console.log(res)
      this.ngOnInit()
  },
  err=>console.log(err))
}
}