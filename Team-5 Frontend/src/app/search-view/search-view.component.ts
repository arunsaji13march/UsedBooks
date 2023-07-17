import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';

@Component({
  selector: 'app-search-view',
  templateUrl: './search-view.component.html',
  styleUrls: ['./search-view.component.css']
})
export class SearchViewComponent  implements OnInit {

  books: Books[] = [];
  pattern: string ="";
  status:string="Available";

  constructor(private router:Router,private bookService:BookServiceService, private activateRoute:ActivatedRoute){
    
  }
  ngOnInit(): void {
    this.activateRoute.params.subscribe(params => {
      this.pattern = params['pattern'];
      console.log("hello  search books")});  
    this.bookService.searchBooksByNameAndStatus(this.pattern,this.status)
      .subscribe((result: Books[]) => {
        this.books = result;
        console.log(this.books)
      });
  }

  // selectBook(bookId: any){
  //   this.router.navigate(['/product',bookId]);
  //   console.log(bookId);
    
  // }

  


}

