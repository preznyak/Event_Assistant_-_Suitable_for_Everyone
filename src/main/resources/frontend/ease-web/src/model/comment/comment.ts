export class Comment {
  constructor(public commentId: bigint,
              public commenter: User,
              public message: string,
              public date: Date) {
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


