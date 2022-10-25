import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { Buybook } from '../buybook';
import { BookService } from '../book.service';

@Component({
  selector: 'app-buybook',
  templateUrl: './buybook.component.html',
  styleUrls: ['./buybook.component.scss']
})
export class BuybookComponent implements OnInit {
  book:Buybook=new Buybook();
 
  constructor(private bookService : BookService, private router : Router) { }
  ngOnInit(): void {
  }
  buyBook()
  {
    console.log(this.book);
     this.bookService.buyBook(this.book).subscribe({
       next: (res:any)=>{
         console.log("You have purchased book successfully" ,res);
         this.router.navigate(["home"]);
  },
    error: (err:any)=>{
      console.log(err);
     
  }
    })
  }
}