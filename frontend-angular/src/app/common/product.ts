
export class Product {

  constructor(

       public  sku: String,

       public name:String,

        public description: String,

      public  unitPrice: number,

      public  imageUrl: String,

       public  active: boolean,

       public unitsInStock:number,

      public createdDate: Date,

       public lastUpdated : Date
  ){}
}


