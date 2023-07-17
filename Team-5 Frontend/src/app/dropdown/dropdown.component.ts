import { Component } from '@angular/core';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent {

  constructor(private router:Router){

  }
  selectedCategory: string = 'All';

getBooksByCategory(category: string) {
  this.selectedCategory = category;
  // Perform additional actions for fetching books by the selected category
  this.router.navigate(["/category",this.selectedCategory])
}


  getAll(){
    this.router.navigate(['/home'])

  }
  getFiction(){
    this.router.navigate(['/category',"Fiction" ]);
  }
  getNovel(){
    this.router.navigate(['/category',"Novel" ]);


  }
  getChildren(){
    this.router.navigate(['/category',"Children" ]);

  }
  getHealth(){
    this.router.navigate(['/category',"Health" ]);


  }
  getRomance(){
    this.router.navigate(['/category',"Romance" ]);    

  }
  getEducation(){
    this.router.navigate(['/category',"Education" ]);


  }
  getHistory(){
    this.router.navigate(['/search',"Hisory" ]);


  }
  getBiography(){
    this.router.navigate(['/search',"Biography" ]);

  }

}
