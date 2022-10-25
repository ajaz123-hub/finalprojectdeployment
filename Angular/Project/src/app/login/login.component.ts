import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from '../book.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  users: User=new User();
  constructor(private bookService: BookService,public router:Router ,private formBuilder:FormBuilder) { 
  }  
  ngOnInit(): void {
  }
  login(){
    console.log("register started"+this.users);
    this.bookService.login(this.users).subscribe((data) => {
      console.log(data);
      alert("Login Success")
      this.router.navigate(["home"]);
  }
    );
}

}
