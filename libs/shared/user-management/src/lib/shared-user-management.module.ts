import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListComponent } from './user-list/user-list.component';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([
      {
        path: 'list',
        component: UserListComponent,
      },
    ]),
  ],
  declarations: [UserListComponent],
})
export class SharedUserManagementModule {}
