import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-searchbooks',
  templateUrl: './searchbooks.component.html',
  styleUrls: ['./searchbooks.component.scss']
})
export class SearchbooksComponent implements OnInit {
  books!: Book;
  // book: Book[]=[];
  category = ''

  authorName = ''

  price= 0

  publisher=''
  constructor(private bookService : BookService,private router:Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  SearchBook()

  {

    console.log(this.category,this.authorName,this.price,this.publisher);

    this.bookService.searchBook(this.category,this.authorName,this.price,this.publisher).subscribe((data: Book) => {

      console.log(data);   

      this.books = data;

      //this.router.navigate(["/SearchResponse"]);

  });

 

   

  }
}
