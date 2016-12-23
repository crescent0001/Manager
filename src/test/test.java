package test;

import database.SqlDDL;
import database.SqlUpdateData;
import email.RetriveEmail;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by hehef on 12/18/2016.
 */
public class test {
    public static void main(String[] args) {
        RetriveEmail re=new RetriveEmail("160244J","hhfxyjshehefei9");
        re.openConnection();
        Message[] emails=re.retriveEmail();
        if(emails!=null){
            int i=0;
            for(Message m:emails){
                try {
                    System.out.println("Printing individual messages");
                    System.out.println("No# " + (i + 1));
                    System.out.println("Email Subject: " + m.getSubject());
                    System.out.println("Sender: " + m.getFrom()[0]);
                    System.out.println("Content: " + m.getContent().toString());
                }catch(MessagingException e){
                    e.printStackTrace();;
                }catch(IOException e){
                    e.printStackTrace();

                }

            }

        }
    }
}
