import { Component, OnInit } from '@angular/core';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';

@Component({
  selector: 'app-totalbooks',
  templateUrl: './totalbooks.component.html',
  styleUrls: ['./totalbooks.component.css']
})
export class TotalbooksComponent  implements OnInit{
  bookObj!:Books;
  booklist!:Books[];
  constructor(private bookService:BookServiceService){
    this.bookObj= new Books();
    this.booklist=[]
  }
  ngOnInit(): void {
    this.bookService.getBooks().subscribe(
      (res:any)=>{
        console.log(res)
        this.booklist=res
      },
      err=>console.log(err)
    )
  }
delete(bookId:string){
  this.bookService.deleteBooks(bookId).subscribe(
    (res:any)=>{
      console.log(res)
      console.log("deleted")
    },
    err=>console.log(err)
  )
}
}
