import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../Model/Books';
import { BookServiceService } from '../service/book-service.service';
import { switchMap } from 'rxjs';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {


  books: Books[] = [];
  category: string = "";
  status:string="Available";

  constructor(
    private bookService: BookServiceService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activateRoute.params.pipe(
      switchMap(params => {
        this.category = params['category'];
        console.log(this.category);
        return this.bookService.getBooksByCategoryAndStatus(this.category,this.status);
      })
    ).subscribe((result: Books[]) => {
      this.books = result;
    });
  }




}

