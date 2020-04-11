import {Service} from "../service/service";

export class Offer {
  offerId: string;
  event: Event;
  service: Service;
  description: string;
  price: number;
  deposit: number;
  pricePaymentTime: Date;
  depositPaymentTime: Date;
  paymentMethod: string;
  isOfferAccepted: boolean;
}
