export class Guest {
  constructor(public guestId: string,
              public firstName: string,
              public  lastName: string,
              public contact: Contact,
              public isInvitationAccepted: boolean) {
  }
}

export class Contact {
  constructor(public contactId: string,
              public name: string,
              public phoneNumber: string,
              public  email: string,
              public  facebookLink: string) {
  }
}
