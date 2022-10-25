import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../book';

@Component({
  selector: 'app-searchbooksres',
  templateUrl: './searchbooksres.component.html',
  styleUrls: ['./searchbooksres.component.scss']
})
export class SearchbooksresComponent implements OnInit {
  @Input() 
  // book: Book[]=[];
  book!:Book;
  constructor() { }

  ngOnInit(): void {
  }

}
