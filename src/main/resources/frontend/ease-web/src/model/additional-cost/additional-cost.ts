export class AdditionalCost {
  constructor(public additionalCostId: string,
              public price: number,
              public name: string,
              public  description: string,
              public  date: Date) {
  }
}
