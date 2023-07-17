import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Reg } from '../Model/Reg';
import { LoginService } from './login.service';
import { TotalUsers } from '../Model/TotalUsers';

@Injectable({
  providedIn: 'root',
})
export class RegserviceService {
  authurl = 'http://localhost:8080/users/v1/getuserbyid';

  authurl1 = 'http://localhost:8080/users/v1/updateuser';
  authurl2 = 'http://localhost:8080/users/v1/getuserbyuserEmail'; 
  authurl3 = 'http://localhost:8080/users/v1/deleteUser';

  constructor(private http: HttpClient, private loginService: LoginService) {}

  getUsers(): Observable<Reg[]> {
    return this.http.get<Reg[]>('http://localhost:8080/users/v1/getAllUsers', {
      headers: new HttpHeaders().set(
        'Authorization',
        `Bearer ${this.loginService.getBearerToken()}`
      ),
    });
  }

  saveUser(regobj: Reg): Observable<Reg> {
    return this.http.post<Reg>(
      'http://localhost:8080/users/v1/register',
      regobj,
      {
        headers: new HttpHeaders().set(
          'Authorization',
          `Bearer ${this.loginService.getBearerToken()}`
        ),
      }
    );
  }

  getUserbyId(userId: string): Observable<Reg> {
    return this.http.get<Reg>(`${this.authurl}/${userId}`, {
      headers: new HttpHeaders().set(
        'Authorization',
        `Bearer ${this.loginService.getBearerToken()}`
      ),
    });
  }

  setUserId(userId: string) {
    localStorage.setItem('userId', userId);
  }

  getUserId(): any {
    return localStorage.getItem('userId');
  }

  updateUserbyUserId(userId: String, Obj: Reg): Observable<Reg> {
    return this.http.put<Reg>(`${this.authurl1}/${userId}`, Obj, {
      headers: new HttpHeaders().set(
        'Authorization',
        `Bearer ${this.loginService.getBearerToken()}`
      ),
    });
  }

  finduserbyEmail(userEmail: string): Observable<Reg> {
    return this.http.get<Reg>(`${this.authurl2}/${userEmail}`);
  }
  deleteUser(userId: string): Observable<TotalUsers> {
    return this.http.delete<TotalUsers>(`${this.authurl3}/${userId}`);
  }
}
