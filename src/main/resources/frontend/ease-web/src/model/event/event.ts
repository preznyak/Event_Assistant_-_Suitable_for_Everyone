import {User} from "../user/user";

export class Event {
  eventName: string;
  locality: string;
  user: User;
  created: Date;
}
