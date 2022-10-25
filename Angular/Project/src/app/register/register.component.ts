import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from '../book.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  users: User=new User();
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    role: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });
  constructor(private bookService: BookService,public router:Router ,private formBuilder:FormBuilder) { 
    this.form = this.formBuilder.group(
      {
        username: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(20)
          ]
        ],
        email: ['', [Validators.required, Validators.email]],
        password: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(40)
          ]
        ],
        role:['',Validators.required]
      },
    );
  }

  ngOnInit(): void {
  }
  

  register(){
    console.log("register started"+this.users);
    this.bookService.register(this.users).subscribe((data) => {
      console.log(data);
      alert("Registration Success, Please login")
      this.router.navigateByUrl('/login');
  }
    );
}
}
