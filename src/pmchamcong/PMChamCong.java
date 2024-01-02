/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pmchamcong;
import connect.*;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author vuqua
 */
public class PMChamCong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Connection connection = DatabaseConnection.connect();

        // Kiểm tra kết nối
        if (connection != null) {
            // Nếu kết nối thành công, bạn có thể thực hiện các thao tác với cơ sở dữ liệu ở đây

            // Ví dụ: In ra thông báo
            System.out.println("Connection successful.");

            // Đóng kết nối sau khi sử dụng
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection failed.");
        }
    }
}
    

