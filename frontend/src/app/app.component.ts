import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent implements OnInit{

  constructor(private router: Router){}

  isVideoSessionUrl(){
    return (this.router.url.substring(0, '/session/'.length) === '/session/');
  }

  ngOnInit(): void {
  }

}
