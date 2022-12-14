import { Component, OnInit } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  student:Student=new Student();
  constructor(){}
  ngOnInit(): void {
      
  }
  onSubmit(){
      console.log(this.student);
  }
}
