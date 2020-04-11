import {Service} from "../service/service";

export class Contract {
  contractId: string;
  price: number;
  deposit: number;
  description: string;
  pricePaymentTime: Date;
  depositPaymentTime: Date;
  isDepositPayed: boolean;
  isPricePayed: boolean;
  paymentMethod: string;
  event: Event;
  service: Service;
  serviceStartTime: Date;
  serviceEndTime: Date;
}
