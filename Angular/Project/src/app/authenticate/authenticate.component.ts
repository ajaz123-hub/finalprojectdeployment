import { Component, OnInit } from '@angular/core';
import { Authenticate } from '../authenticate';
import { BookService } from '../book.service';

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.scss']
})
export class AuthenticateComponent implements OnInit {
  auth:Authenticate=new Authenticate();
  constructor(private books:BookService) { }

  ngOnInit(): void {
  }

  GetToken(){

    console.log(this.auth);   

   this.books.GetToken(this.auth).subscribe({

    next: (res:any)=>{

      localStorage.clear()

      localStorage.setItem("token",res.token)

      // console.log("Book created successfully" ,res);

      // alert("Book saved successfully")

  },

  error: (err:any)=>{

    console.log(err);

   

}

  })

 

  }

}
