import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserListComponent} from "../components/user-list/user-list.component";
import {ServiceListComponent} from "../components/service-list/service-list.component";
import {EventListComponent} from "../components/event-list/event-list.component";


const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'events', component: ServiceListComponent },
  { path: 'services', component: EventListComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
