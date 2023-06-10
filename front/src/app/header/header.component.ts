import {Component, ElementRef, AfterViewInit, Renderer2} from '@angular/core';
import { Location } from '@angular/common';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements AfterViewInit {
  constructor(private elementRef: ElementRef,
              private renderer: Renderer2,
              private location: Location,
              private router:Router) {}

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

}
