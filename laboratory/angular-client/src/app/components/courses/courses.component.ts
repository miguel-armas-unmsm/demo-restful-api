import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { CoursesService } from '../../services/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  displayedColumns: string[] = ['name', 'academicYear', 'credits'];
  courseList: Course[] = [];

  constructor(
    private courseService: CoursesService
  ) { }

  ngOnInit(): void {
    this.refreshList();
  }

  refreshList(): void {
    this.courseService.findAll().subscribe(courses => {
      this.courseList = courses;
    });
  }

}
