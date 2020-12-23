import { Component, Inject, Injectable, OnInit } from '@angular/core';
import { AppName, AppNameInjectionToken } from '@monorepos/utils';

@Component({
  selector: 'monorepos-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss'],
})
export class UserListComponent implements OnInit {
  constructor(@Inject(AppNameInjectionToken) public appName: AppName) {}

  ngOnInit(): void {}
}
