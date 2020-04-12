import {Component, OnInit} from '@angular/core';
import {Event} from '../../model/event/event';
import {EventService} from "../../service/event/event.service";

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  events: Event[];

  constructor(private eventService: EventService) {
  }

  ngOnInit() {
    this.eventService.findAll().subscribe(data => {
      this.events = data;
    });
  }

}
