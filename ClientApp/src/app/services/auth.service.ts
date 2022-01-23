import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ConfigService } from './config.service';
import { HttpClient } from '@angular/common/http';
import { Login } from '../interfaces/login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public loginData: Login = { login: '', password: '' };

  constructor(
    private configService: ConfigService,
    private router: Router,
    private http: HttpClient
  ) {}

  logout(): void{
    localStorage.setItem("isLoggedIn", 'false');
    localStorage.removeItem("token");
  }

  login(loginData: Login): any{
    console.dir(loginData);
    this.loginData = loginData;

    //let basicString = "Basic " + window.btoa(loginData.login + ":" + loginData.password);

    return this.http.get<Login>(this.configService.apiUrl + "/notes/");
  }
}
