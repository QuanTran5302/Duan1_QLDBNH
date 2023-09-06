/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Helper.DateHelper;
import Helper.DialogHelper;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author Hi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        String time = "22/10/2010";

//SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
        java.util.Date date = new java.util.Date();
//        String ht = DateHelper.timetoString(date);
//        String gio = (String) cbo.getSelectedItem();
        System.out.println(date);
        String ngaydat = DateHelper.toString(date);
        System.out.println(ngaydat);
        String gio = " 18:00:00";
        String ngaygio = ngaydat+gio;
        System.out.println(ngaygio);
        String giodat = "18:29:58";
        String ht = "19:33:43";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(giodat);
            d2 = format.parse(ht);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time in hours: " + diffHours + " hours.");
        
//        long diffSeconds = diff / 1000 % 60;
        //long diffMinutes = diff / (60 * 1000) % 60;
//        long diffHours = diff / (60 * 60 * 1000) % 24;
//        long diffDays = diff / (24 * 60 * 60 * 1000);
//        long diffYears = diffDays / 365;
        if (diffMinutes >= 60) {

            //return true;
        } else {
            System.out.println(diffMinutes);
            System.out.println("Giờ đặt phải trước giờ hiện tại một tiếng");
            //return false;
        }

        //SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat date_fm = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date = new java.util.Date();
//        Date date3 =  date_fm.parse(time);
//
//
//        long diff = date.getTime() - date3.getTime();
//        long diffSeconds = diff / 1000 % 60;
//        long diffMinutes = diff / (60 * 1000) % 60;
//        long diffHours = diff / (60 * 60 * 1000) % 24;
//        long diffDays = diff / (24 * 60 * 60 * 1000);
//        long diffYears = diffDays / 365;
//
//        if (diffYears > 16 ) {
//            //DialogHelper.alert(this, "Đổi thành công");
//            System.out.println("OK");
//        } else{
//            //DialogHelper.alert(this, "Tuổi phải lớn hơn 16 tuổi");
//            System.out.println("KO");
//        }
    }

}
