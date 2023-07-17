import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  bookForm!: FormGroup;
  existingbook: Books;
  bookId: string='';

  constructor(
    private formBuilder: FormBuilder,
    private activeRoute: ActivatedRoute,
    private bookService: BookServiceService,
    private notifyService:NotificationService,
    private router:Router
  ) {
    this.existingbook = new Books();
  }

  ngOnInit(): void {
    this.activeRoute.params.subscribe(params => {
      this.bookId = params['bookId'];
      console.log(this.bookId);
    });

    this.bookService.getBookById(this.bookId).subscribe(
      (bookData: Books) => {
        this.existingbook = bookData;
        this.bookForm.patchValue(this.existingbook);
      },
      (error: any) => {
        console.error('Failed to get book data', error);
      }
    );

    this.bookForm = this.formBuilder.group({
      bookName: ['', Validators.required],
      price: ['', Validators.required],
      authorName: ['', Validators.required],
      bookDetails: ['', Validators.required],
      bookLanguage: ['', Validators.required],
      category: ['', Validators.required],
      bookCondition: ['', Validators.required],
      status: ['', Validators.required],
      image: ['', Validators.required],
      pickUpAddress: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.bookForm.valid) {
      const updatedBook: Books = this.bookForm.value;
      this.bookService.updateBook(this.bookId, updatedBook).subscribe(
        (data: Books) => {
          console.log('Book updated successfully:', data);
          this.notifyService.showSuccess("update Sucessfull", "");
        },
        (error: any) => {
          console.error('Failed to update book', error);
        }
      );
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
