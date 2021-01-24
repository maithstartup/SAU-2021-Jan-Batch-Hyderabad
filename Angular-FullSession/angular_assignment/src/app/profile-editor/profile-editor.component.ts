import { Component ,OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.css']
})
export class ProfileEditorComponent implements OnInit {
  profileForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    houseAddress:['']
  });
  // storename =new FormControl('');
  expenseGroups: any;

  columnsToDisplay = ['firstName', 'lastName','houseAddress'];


  constructor(private fb: FormBuilder) { }



  storeProfile() {
    let arr=sessionStorage.getItem('userProfile')
    if(arr)
    {
    const temp=JSON.parse(arr);
    temp.push(this.profileForm.value)
    sessionStorage.setItem("userProfile",JSON.stringify(temp));
    }
    else{
    //const temparr={count:[{firstName:this.profileForm.value.firstName,lastName:this.profileForm.value.lastName}]}
      sessionStorage.setItem("userProfile",JSON.stringify([this.profileForm.value]));
    }
  
 
  }
  showProfile(){
    const data=sessionStorage.getItem('userProfile');
    console.log(data)
    this.expenseGroups = new MatTableDataSource(JSON.parse(data))
  }

  

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.profileForm.value);
  }
  ngOnInit(){
    
    
  }
}
