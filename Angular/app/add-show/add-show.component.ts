import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-show',
  templateUrl: './add-show.component.html',
  styleUrls: ['./add-show.component.css']
})
export class AddShowComponent implements OnInit {
message:string;
  constructor(private adminService:AdminService) { }

  ngOnInit() {
  }
  addShow(form: NgForm) {
    this.adminService.addShow(form.value).subscribe(data => {
        console.log(data);
        this.message = data.message;
        setTimeout(() => {
          this.message = null;
        },2000);
        form.reset();
      }, err => {
        console.log(err);
      });
    }
}
