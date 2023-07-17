import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookServiceService } from '../service/book-service.service';
import { Books } from '../Model/Books';
import { Router } from '@angular/router';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit{

  bookForm!: FormGroup;
  bookobj:Books;
  existingBook:Books;
  sellerId=localStorage.getItem('userId');

  constructor(private formBuilder: FormBuilder,private bookSerice:BookServiceService, private router:Router, private notifyService:NotificationService) { 
    this.bookobj=new Books();
    this.existingBook=new Books();
  }


  ngOnInit() {
    this.ngOnInit

    this.bookForm = this.formBuilder.group({
      sellerId: [this.sellerId],
      bookName: ['', Validators.required],
      price: ['', Validators.required],
      authorName: ['', Validators.required],
      bookDetails: ['', Validators.required],
      bookLanguage: ['', Validators.required],
      category:['',Validators.required],
      bookCondition: ['', Validators.required],
      status: ['', Validators.required],
      image: ['', Validators.required],
      pickUpAddress: ['', Validators.required]
    });
  }
  
  onSubmit() {
    console.log(this.bookForm.valid)
    if (this.bookForm.valid) {
      // Perform form submission or API call here
      this.bookobj=this.bookForm.value;
      console.log("form value")
      console.log(this.bookobj);
      console.log(this.bookobj.sellerId);

      this.bookSerice.addBook(this.bookobj).subscribe(
        data=>{console.log(data)
          this.ngOnInit
        // console.log("Sucessfully added")
        // this.notifyService.showSuccess("", "Book Added Successfully");
      },
        
        err=>{console.log(err)}
      )
      
      this.bookobj=new Books;
      // window.alert("book Added Successfully");
      this.notifyService.showSuccess("", "Book Added Successfully");
      this.router.navigate(['/home'])


    }
  }

 
  
  get bookName() {
    return this.bookForm.get('bookName');
  }
  
  get price() {
    return this.bookForm.get('price');
  }
  
  get authorName() {
    return this.bookForm.get('authorName');
  }
  
  get bookDetails() {
    return this.bookForm.get('bookDetails');
  }
  
  get bookLanguage() {
    return this.bookForm.get('bookLanguage');
  }
  
  get category() {
    return this.bookForm.get('category');
  }
  
  get bookCondition() {
    return this.bookForm.get('bookCondition');
  }
  
  get status() {
    return this.bookForm.get('status');
  }
  
  get image() {
    return this.bookForm.get('image');
  }
  
  get pickUpAddress() {
    return this.bookForm.get('pickUpAddress');
  }
  
}
