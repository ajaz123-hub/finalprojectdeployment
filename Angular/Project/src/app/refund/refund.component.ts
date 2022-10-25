import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Buybook } from '../buybook';

@Component({
  selector: 'app-refund',
  templateUrl: './refund.component.html',
  styleUrls: ['./refund.component.scss']
})
export class RefundComponent implements OnInit {

  bookId =''

  emailId=''

bookRefund:Buybook=new Buybook();

  constructor(private bookService : BookService) { }

  ngOnInit(): void {
  }

  refund()

  {

    console.log(this.bookId,this.emailId);

     this.bookService.refund(this.bookId,this.emailId).subscribe({

       next: (res:any)=>{

         console.log("Refund Success" ,res);

         alert("Refund Success");

  },

    error: (err:any)=>{

      console.log(err);

     

  }

    })

}

}
