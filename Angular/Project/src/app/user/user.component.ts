import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { User } from '../user';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  users: User[]=[];
  constructor(private userservice:UserserviceService) { }

  ngOnInit(): void {
    this.userservice.getAuthors().subscribe((data: User[]) => {
      console.log(data);
      this.users = data;
  });
  }
}
