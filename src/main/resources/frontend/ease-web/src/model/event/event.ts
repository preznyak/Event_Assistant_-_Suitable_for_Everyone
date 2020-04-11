import {User} from "../user/user";
import {EventDetails} from "./event-details";
import {AdditionalCost} from "../additional-cost/additional-cost";

export class Event {
  eventId: string;
  eventName: string;
  locality: string;
  user: User;
  eventDetails: EventDetails;
  additionalCostList: AdditionalCost[];
  created: Date;
  eventCategory: string;
}
