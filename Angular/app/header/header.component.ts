import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userDetails;
  constructor(private router:Router) { }

  ngOnInit() {
  }
  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.beans[0].userName === 'Dilip') {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn() {
    let UserDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (UserDetails) {
      //this.router.navigateByUrl('/');
      return true;
    } else {
      return false;
    }
  }

  logOut() {
    localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/');
  }
}
