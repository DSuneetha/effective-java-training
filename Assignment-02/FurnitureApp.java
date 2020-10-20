
class FurnitureApp{

    public static void main(String []args){

        furnitures.livingroom.Chair livingRoomChair=new furnitures.livingroom.Chair();  //Living room chair
        furnitures.livingroom.Table livingRoomTable=new furnitures.livingroom.Table(); //living room table
       furnitures.bedroom.Bed bed=new furnitures.bedroom.Bed();       //Bedroom Bed

       
       furnitures.office.Table officeTable=new furnitures.office.Table();
       furnitures.office.Chair officeChair=new furnitures.office.Chair();

        data.List list=new data.List();
        data.Table Table=new data.Table();
        System.out.printf("The price of %s is %d\n",bed, bed.price());

        System.out.printf("The price of %s is %d\n",livingRoomChair, livingRoomChair.price());
        System.out.printf("The price of %s is %d\n",livingRoomTable, livingRoomTable.price());
        System.out.printf("The price of %s is %d\n",officeChair, officeChair.price());
        System.out.printf("The price of %s is %d\n",officeTable, officeTable.price());
        System.out.println("list is "+list);
        System.out.println("table is"+Table);
    }
}