import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-get-books',
  templateUrl: './get-books.component.html',
  styleUrls: ['./get-books.component.scss']
})
export class GetBooksComponent implements OnInit {
  books: Book[]=[];
  constructor(private bookservice:BookService) { }

  ngOnInit(): void {
    this.bookservice.getBooks().subscribe((data: Book[]) => {
      console.log(data);
      this.books = data;
  });
  }
  
}
