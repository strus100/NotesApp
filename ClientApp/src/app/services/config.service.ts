import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  loginUrl = "http://localhost:4200/login";
  apiUrl = "http://localhost:4200/api";

  constructor() { }
}
