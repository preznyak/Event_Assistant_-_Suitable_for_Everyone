export class EventDetails {
  constructor(public eventDetailsId: string,
              public description: string,
              public startTime: Date,
              public endTime: Date,
              public guestList: Guest[]) {
  }
}

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
