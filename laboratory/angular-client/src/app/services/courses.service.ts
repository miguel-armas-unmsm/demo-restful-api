import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { CommonService } from './common.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CoursesService extends CommonService<Course> {

  override baseUrl = '/demo/business/v1/courses';

  constructor(http: HttpClient) {
    super(http);
   }

}
