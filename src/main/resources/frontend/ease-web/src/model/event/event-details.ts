import {Guest} from "../guest/guest";

export class EventDetails {
  eventDetailsId: string;
  description: string;
  startTime: Date;
  endTime: Date;
  guestList: Guest[];
}
