import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

import { Login } from '../interfaces/login';
import { AuthService } from '../services/auth.service';

@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    let loginData: Login = this.authService.loginData
    //console.dir(request);
    //let headers = request.headers;
    //headers['authorization'] = "asd";

    let basicString = "Basic " + window.btoa(loginData.login + ":" + loginData.password);
    //request.headers.set("authorization", basicString);
    //request.headers['authorization'] =
    //console.log(this.authService.loginData);

    request = request.clone({ setHeaders: { Authorization: `Basic ` + window.btoa(loginData.login + ":" + loginData.password) } });

    return next.handle(request);
  }
}
