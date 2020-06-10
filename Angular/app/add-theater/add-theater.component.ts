import { Component, OnInit } from '@angular/core';
import { TheaterService } from '../theater.service';
import {NgForm} from '@angular/forms';
import { AdminService } from '../admin.service';
@Component({
  selector: 'app-add-theater',
  templateUrl: './add-theater.component.html',
  styleUrls: ['./add-theater.component.css']
})
export class AddTheaterComponent implements OnInit {
message: string;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  addTheater(form: NgForm) {
    this.adminService.addTheater(form.value).subscribe(data => {
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
