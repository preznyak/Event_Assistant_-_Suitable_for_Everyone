import {Address} from "../address/address";
import {Contact} from "../contact/contact";

export class UserDetails {
  userDetailsId: string;
  firstName: string;
  lastName: string;
  registrationDate: Date;
  birthDay: Date;
  preferences: string;
  addressList: Address[];
  contact: Contact;
}
