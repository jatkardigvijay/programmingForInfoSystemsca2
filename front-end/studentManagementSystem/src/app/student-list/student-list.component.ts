import { Component, OnInit } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{


  students:Student[];
  constructor(){}
  ngOnInit(): void {
      this.students=[{
        "studentId":1,
        "firstName":"febin",
        "lastName":"babu",
        "emailId":"febse@gmail.com",
        "studentAge":12,
        "contactNumber":112334
      }]
  }
}
