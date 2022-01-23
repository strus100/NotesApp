import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { AuthGuard } from '../guards/auth.guard';
import { Router } from '@angular/router';
import { Login } from '../interfaces/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    login: '',
    password: ''
  });

  registerForm = this.formBuilder.group({
    userName: '',
    password: '',
    passwordRepeat: ''
  });

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private authGuard: AuthGuard,
    private router: Router
  ) { }

  ngOnInit(): void {
    if(this.authGuard.isLoggedIn()){
      this.router.navigate(['/notes']);
    }
  }

  onLoginSubmit(): void{
    let loginData: Login = {
      login: this.loginForm.value.login,
      password: this.loginForm.value.password
    };

    this.authService.login(loginData).subscribe((data: Login) => { console.log(data); });
  }

  onRegisterSubmit(): void{
    console.log("register sent")
  }
}
