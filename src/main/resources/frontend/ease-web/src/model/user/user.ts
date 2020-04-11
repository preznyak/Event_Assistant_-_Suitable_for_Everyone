import {UserDetails} from "./user-details";

export class User {
  userId: string;
  email: string;
  password: string;
  lastLoginDate: string;
  serviceOwner: string;
  userDetails: UserDetails;
}
