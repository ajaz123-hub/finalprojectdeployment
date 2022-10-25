import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../book';
@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.scss']
})
export class CreateBookComponent implements OnInit {
  book:Book=new Book();
  constructor(private bookService : BookService, private router : Router) { }

  ngOnInit(): void {
  }
  
  
  createBook(){
    console.log(this.book); 
   
   this.bookService.createBook(this.book).subscribe({
    next: (res:any)=>{
      console.log("Book created successfully" ,res);
      alert("Book saved successfully");
      this.router.navigate(["home"]);
      
  },
  error: (err:any)=>{
    console.log(err);
   
}
  })
  
  }


}
