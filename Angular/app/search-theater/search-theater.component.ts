import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-theater',
  templateUrl: './search-theater.component.html',
  styleUrls: ['./search-theater.component.css']
})
export class SearchTheaterComponent implements OnInit {
message: string;
theaters;
  constructor(private adminService: AdminService,
              private router:Router) { }

  ngOnInit() {
  }
  searchTheater(form: NgForm) {
    console.log('df');
    console.log(form.value);
    this.adminService.searchTheater(form.value).subscribe(response => {
      console.log(response);
      this.theaters = response.beans;
      this.message = response.description;
      setTimeout(() => {
        this.message = null;
      }, 3000);
    });
  }
}
