import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UserListComponent} from "../components/user-list/user-list.component";
import {UserService} from "../service/user/user.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {EventListComponent} from '../components/event-list/event-list.component';
import {ServiceListComponent} from '../components/service-list/service-list.component';
import {EventService} from "../service/event/event.service";
import {ServiceService} from "../service/service/service.service";
import {UserCreateComponent} from "../components/user-create/user-create.component";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    EventListComponent,
    ServiceListComponent,
    UserCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, EventService, ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
