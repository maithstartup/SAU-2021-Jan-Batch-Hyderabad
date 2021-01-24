import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-name-editor',
  templateUrl: './name-editor.component.html',
  styleUrls: ['./name-editor.component.css']
})
export class NameEditorComponent {
  name = new FormControl('');
  storename =new FormControl('');

  updateName() {
    this.name.setValue('harish');
  }

  storeName()
  {
    sessionStorage.setItem('currentUser', JSON.stringify(this.name.value));
  }
  showStorageName()
  {
    console.log(sessionStorage.getItem('currentUser'))
    this.storename.setValue(sessionStorage.getItem('currentUser'));
  }
}
