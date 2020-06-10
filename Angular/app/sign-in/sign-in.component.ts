import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
message: string;
error:string;
  constructor(private adminService:AdminService,
              private router: Router) { }

  ngOnInit() {
  }
  loginUser(form: NgForm) {
    return this.adminService.adminUser(form.value).subscribe(res => {
      console.log('ddc');
      console.log(form.value);
      if (res.statusCode === 200) {
        console.log(res);
        localStorage.setItem('userDetails', JSON.stringify(res));
        console.log('user details are stored');
        this.message = res.description;
        this.router.navigateByUrl('');
         form.reset();
        setInterval(() => {
          this.message = null;
        }, 3000);
      } else {
        this.error = res.description;
        console.log(this.error);
        setInterval(() => {
          this.error = null;
        }, 5000);
      }
    });
  }
}
