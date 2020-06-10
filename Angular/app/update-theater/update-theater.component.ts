import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-theater',
  templateUrl: './update-theater.component.html',
  styleUrls: ['./update-theater.component.css']
})
export class UpdateTheaterComponent implements OnInit {
  id1;
  theaterName1;
  theaterCity1;
  managerName1;
  managerContact1;
  formDetails;
  constructor(private adminService: AdminService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      this.id1 = data.id;
      console.log(this.id1);
    });
    activatedRoute.queryParams.subscribe(data => {
      this.theaterCity1 = data.theaterCity;
      this.theaterName1=data.theaterName;
      this.managerName1 = data.managerName;
      this.managerContact1 = data.managerContact;
      this.formDetails = data;
    });
  }

  ngOnInit() {
  }
  updateTheater(form: NgForm) {
    this.adminService.updateTheater(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 200) {
        this.router.navigateByUrl('/getAllTheaters');
      }
      form.reset();
    }, error => {
      console.log(error);
    });
  }
}
