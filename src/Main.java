import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PostgreConn db = new PostgreConn();
        Connection conn = db.connect_to_db("testdb", "postgres", "12345");//connection with our Postgresql server

        System.out.println("Welcome:)");
        System.out.println("1.Client menu");
        System.out.println("2.Employee menu");
        //for console

        int f_menu = sc.nextInt();//for choosing menu
        switch (f_menu) {
            case 1://for clients
                String menu_name="client_menu";
                menu menu1 = new menu();
                menu1.show_client_menu(conn,menu_name);
                //1.medicine
                //2.orthopedics
                //3.hygiene

                int type_ID = sc.nextInt();//choosing type (medicine or ort or hygiene)

                Type_menus type_menus = new Type_menus();
                type_menus.show_applies(conn,menu_name,type_ID);
                //==1:medicine   ==2:orthopedics ==3:hygiene
                //1.cold         //1.crutches   //antiseptics
                //2.allergies    //2.corsets    //condoms
                //3.for eyes


                int apply = sc.nextInt();//choose applies

                if(type_ID==1 && apply==1){//for medicine->cold
                    System.out.println("[If you need medicine for cold,");
                    System.out.println("you have to input your age!!!]");
                    int age = sc.nextInt();
                    sc.hasNextLine();
                    String str;
                    if(age<18){
                        str = "childrens";
                    }
                    else{
                        str = "adult";
                    }
                    ch_or_ad forms = new ch_or_ad();
                    forms.show_forms(conn,str);

                    int dd = sc.nextInt();
                    form_data show = new form_data();
                    show.show_capsules_eliksires(conn,str,dd);
                }

                else {//for every applies except cold
                    applies_menu applies = new applies_menu();
                    applies.show_allergies_medicine(conn,menu_name,apply,type_ID);
                }
                break;

            case 2://for employee
                String str2 = "employee_menu";
                menu menu_2=new menu();
                menu_2.show_client_menu(conn,str2);

                type_ID= sc.nextInt();
                if(type_ID==3){
                    special_equipment sp=new special_equipment();
                    sp.show_special_equipment(conn,str2);
                }
                else {
                    Type_menus type_menus2 = new Type_menus();
                    type_menus2.show_applies(conn, str2, type_ID);
                    int tt= sc.nextInt();
                    if(type_ID==2){
                        special_for_rehabilition ssq=new special_for_rehabilition();
                        ssq.show_rehabiltion(conn,str2,tt);
                    }
                    else {
                        if(tt==1){
                            System.out.println("1.syringes");
                            System.out.println("2.clothes");
                            int qq= sc.nextInt();
                            if(qq==1){
                                System.out.println("what type of syringes do you need?");
                                System.out.println("2ml | 5ml | 10ml | 15ml | 50ml");
                                System.out.println("input ml!");
                                int ml= sc.nextInt();
                                special_for_syringes rt=new special_for_syringes();
                                rt.show_syringes(conn,str2,ml);
                            }
                            else {
                                System.out.println("types of medicine clothes");
                                System.out.println("1.med masks  2.med headdress  3.med gloves");
                                System.out.println("input id!");
                                int yu= sc.nextInt();
                                special_for_gl_mask qe=new special_for_gl_mask();
                                qe.show_syringes(conn,str2,yu);
                            }
                        }

                    }
                }

        }


    }
}