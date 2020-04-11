import {Contact} from "../contact/contact";

export class Guest {
  guestId: string;
  firstName: string;
  lastName: string;
  contact: Contact;
  isInvitationAccepted: boolean;
}
