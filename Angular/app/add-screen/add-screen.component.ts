import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-screen',
  templateUrl: './add-screen.component.html',
  styleUrls: ['./add-screen.component.css']
})
export class AddScreenComponent implements OnInit {
message: string;
  constructor(private adminService:AdminService) { }

  ngOnInit() {
  }
  addScreen(form: NgForm) {
    this.adminService.addScreen(form.value).subscribe(data => {
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
