import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Books } from '../Model/Books';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root'
})
export class BookServiceService {
  authurl:string;
  authurl1:string;
  constructor(private httpClient:HttpClient, private loginService:LoginService) { 
    this.authurl="http://localhost:8085/books/v1/user"
    this.authurl1="http://localhost:8085/books/v1/deleteBooks"
    
  }

  getBooks():Observable<Books[]>{
    return this.httpClient.get<Books[]>("http://localhost:8085/books/v1/getAllBooks",{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });

  }

  getBookById(bookId: string): Observable<Books> {
    return this.httpClient.get<Books>( `http://localhost:8085/books/v1/getBooksById/${bookId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });
  }

  addBook(book: Books):Observable<Books>{
    const url="http://localhost:8085/books/v1/addBook";
    console.log("book adding service");
    console.log(book);
    return this.httpClient.post<Books>(url,book,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });
  }

  searchBooksByName(pattern: string): Observable<Books[]> {
    const params = new HttpParams().set('pattern', pattern);
    return this.httpClient.get<Books[]>("http://localhost:8085/books/v1/search", {headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`),params});
  }

  searchBooksByNameAndStatus(name: string, status: string): Observable<Books[]> {
    const params=new HttpParams().set('name',name).set('status',status);
    return this.httpClient.get<Books[]>("http://localhost:8085/books/v1/searchbyNameAndStatus",{headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`),params})
  }


  getBooksByCategoryAndStatus(category:string,status:string):Observable<Books[]>{
    const params=new HttpParams().set('category',category).set('status',status);
    return this.httpClient.get<Books[]>("http://localhost:8085/books/v1/getBooksByCategoryAndStatus",{headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`),params})
  }
  
  getBooksByStatus(status:string):Observable<Books[]>{
    const params=new HttpParams().set('status',status);
    return this.httpClient.get<Books[]>("http://localhost:8085/books/v1/getBooksByStatus",{headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`),params})
  }
  getBooksBySellerId(userId:any):Observable<Books[]>{

    return this.httpClient.get<Books[]>(`${this.authurl}/${userId}`,{headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)})

  }

  deleteBooks(bookId:string):Observable<Books>{
    return this.httpClient.delete<Books>(`${this.authurl1}/${bookId}`,{headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)})
  }

  // const url = "http://localhost:8085/books/v1/updateBookStatus";
  
  // updateBookStatus(bookId: string, status: string): Observable<any> {
  //   const url = "http://localhost:8085/books/v1/updateBookStatus";
  //   const params = { bookId: bookId, status: status };
    
  //   return this.httpClient.patch(url,{params});
  // }
  // updateBookStatus(bookId: string, status: string): Observable<any> {
  //   const url = `http://localhost:8085/books/v1/updateBookStatus/${bookId}`;
  //   const params = { status: status };
  //   const headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');

  //   return this.httpClient.patch(url, null, { headers, params });
  // }

  updateBookStatus(bookId:string,data:Books):Observable<Books>{
    return this.httpClient.patch<Books>(`http://localhost:8085/books/v1/updateBookStatus/${bookId}`,data,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.loginService.getBearerToken()}`)
    });
   }


  updateBook(bookId: string, book: Books): Observable<Books> {
    return this.httpClient.post<Books>(`http://localhost:8085/books/v1/updateBook/${bookId}`, book);
  }


  

  
}
