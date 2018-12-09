/*



 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.util.ArrayList;

/**
 *
 * @author wj
 */
public class Status {
    ArrayList<Message> statusItems;
    
    Status(ArrayList<Message> statusItems) {
        this.statusItems = statusItems;
    }
    int addStatusItem(DatabaseEngine databaseObject, Message newItem) {
        return 0;
    }
}
