import { Component, OnInit } from '@angular/core';
import {Contact, User, UserDetails, Address} from "../../model/user/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../service/user/user.service";

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent{

  user: User;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User("","","","","",
      new UserDetails("","","",null,null,"",null,null));
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

}
