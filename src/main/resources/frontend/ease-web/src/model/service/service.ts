import {User} from "../user/user";
import {ServiceDetails} from "./service-details";
import {Contact} from "../contact/contact";
import {Address} from "../address/address";

export class Service {
  serviceId: string;
  name: string;
  description: string;
  homePage: string;
  user: User;
  serviceDetails: ServiceDetails;
  contacts: Contact[];
  serviceCategory: string;
  addresses: Address[];
}
