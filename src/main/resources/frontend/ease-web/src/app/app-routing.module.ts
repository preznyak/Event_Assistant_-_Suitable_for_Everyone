import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserListComponent} from "../components/user-list/user-list.component";
import {ServiceListComponent} from "../components/service-list/service-list.component";
import {EventListComponent} from "../components/event-list/event-list.component";
import {UserCreateComponent} from "../components/user-create/user-create.component";


const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'events', component: EventListComponent},
  {path: 'services', component: ServiceListComponent},
  {path: 'create-user', component: UserCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
