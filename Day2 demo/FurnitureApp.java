import data.*;
import furnitures.bedroom.*;
import furnitures.livingroom.*;
import furnitures.office.*;
import data.Table;


class FurnitureApp{

    public static void main(String []args){

        Chair livingRoomChair=new Chair();  //Living room chair
        Table livingRoomTable=new Table(); //living room table
        Bed bed=new Bed();       //Bedroom Bed

       
       Table officeTable=new Table();
       Chair officeChair=new Chair();

        List list=new List();
       Table Table=new Table();
        System.out.printf("The price of %s is %d\n",bed, bed.price());

        System.out.printf("The price of %s is %d\n",livingRoomChair, livingRoomChair.price());
        System.out.printf("The price of %s is %d\n",livingRoomTable, livingRoomTable.price());
        System.out.printf("The price of %s is %d\n",officeChair, officeChair.price());
        System.out.printf("The price of %s is %d\n",officeTable, officeTable.price());
        System.out.println("list is "+list);
        System.out.println("table is"+Table);
    }
}