export class Event {
  constructor(public eventId: string,
              public eventName: string,
              public locality: string,
              public user: User,
              public eventDetails: EventDetails,
              public additionalCostList: AdditionalCost[],
              public created: Date,
              public eventCategory: string) {
  }
}

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

export class User {
  constructor(public userId: string,
              public email: string,
              public password: string,
              public lastLoginDate: string,
              public serviceOwner: string,
              public userDetails: UserDetails) {
  }
}

export class UserDetails {
  constructor(public userDetailsId: string,
              public firstName: string,
              public lastName: string,
              public registrationDate: Date,
              public birthDay: Date,
              public preferences: string,
              public addressList: Address[],
              public contact: Contact) {
  }
}

export class Address {
  constructor(public addressId: string,
              public houseNumber: string,
              public streetName: string,
              public city: string,
              public state: string,
              public zipCode: string,
              public country: string) {
  }
}

export class Contact {
  constructor(public contactId: string,
              public name: string,
              public phoneNumber: string,
              public email: string,
              public facebookLink: string) {
  }
}

export class AdditionalCost {
  constructor(public additionalCostId: string,
              public price: number,
              public name: string,
              public  description: string,
              public  date: Date) {
  }
}


