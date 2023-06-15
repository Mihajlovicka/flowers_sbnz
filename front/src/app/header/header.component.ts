import {Component, ElementRef, AfterViewInit, Renderer2} from '@angular/core';
import { Location } from '@angular/common';
import {Router} from "@angular/router";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements AfterViewInit {
  constructor(private elementRef: ElementRef,
              private renderer: Renderer2,
              private location: Location,
              private router:Router,
              public service:UserService) {}

  ngAfterViewInit() {
    const currentUrl = this.location.path();
    if (currentUrl === '') {
      const toolbarElement = this.elementRef.nativeElement.querySelector('.transparent-toolbar');
      this.renderer.setStyle(toolbarElement, 'color', 'white');
    }
  }

  home(){
    this.router.navigate(['']);
  }

  login(){
    this.router.navigate(['login']);
  }

  logout(){
    this.service.logOut()
    this.router.navigate(['']);
  }

  register(){
    this.router.navigate(['register']);
  }

  myFlower() {
    this.router.navigate(['profile']);
  }

  myData() {
    this.router.navigate(['profile-data']);
  }
}
