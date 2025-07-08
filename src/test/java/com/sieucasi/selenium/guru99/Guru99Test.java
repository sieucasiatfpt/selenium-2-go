/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sieucasi.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author SieuCaSi
 */
public class Guru99Test {

    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";

    @BeforeAll
    public static void setUpClass() {
        //chuẩn bị value cho các biến, khởi động trình duyệt
        System.setProperty("webdriver.chrome.driver", driverPath);

        myBrowser = new ChromeDriver(); //dùng thêm class ChromOptions để mở ẩn danh, ngôn ngữ...

        myBrowser.manage().window().maximize();
    }

    @Test
    public void testLoginGivenRightAccountSayHelloUserName() throws InterruptedException { 
        
        //tham số hóa qua mảng user/pass
        String userName = "mngr626980"; 
        String pass = "tYvEzez";
        
        myBrowser.get("https://demo.guru99.com/V4"); //duyệt trang trên object trình duyệt vừa new 

        //tìm thẻ username và password qua: CSS Selector, JQuery, xPath, name, id, class...
        //chính là 1 dạng câu query/SQL áp dụng cho tìm data thẻ phía sau trình duyệt
        //xPath, CSS Selector ~~~ SQL
        //trang Web/browser   ~~~ CSDL
        // đưa câu query xPath cho myBrowser, tìm thẻ giúp giống F12, Ctrl-F 
        //nếu tìm thấy thẻ, là 1 object trả về, thuộc class WebElement
        WebElement userTag = myBrowser.findElement(By.xpath("(//input[@name='uid'])[1]"));
        userTag.sendKeys(userName); //gõ text nếu tìm thấy thẻ/tag 

        WebElement passTag = myBrowser.findElement(By.cssSelector("input[name='password']"));
        passTag.sendKeys(pass); //gõ text nếu tìm thấy thẻ/tag 

        WebElement loginTag = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));
        loginTag.click(); //bấm vào button nếu tìm thấy thẻ/tag 
        
        Thread.sleep(3000); //cần chờ chuyển trang xong
                            //do mạng, do kĩ thuật Front-end nhanh hay chậm
                            //ép code mình dừng/chờ/wait để đồng bộ
                            //tốc độ render ra trang mới. Tìm ngay tag
                            //ở trang mới 99% Exception
                            //do tìm thẻ mới ở trang cũ, trang mới chưa kịp render
        //Wait khi chuyển trang! 
        
        WebElement helloTag = myBrowser.findElement(By.xpath("(//td[normalize-space()='Manger Id : mngr626980'])[1]"));
        //lấy đc cái <td> chứa câu xin chào, in thử
        System.out.println("Hello message after login successfully: " + 
                            helloTag.getText());
        String actualHelloMsg = helloTag.getText();
        assertEquals("Manger Id : " + userName, actualHelloMsg);
//        helloTag.click(); //bấm vào button nếu tìm thấy thẻ/tag
        
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit(); //dọn dẹp rác, undo khi @Test đã chạy, đã làm thay đổi hiện trạng nào đó, ví dụ DB có rác do chạy test CRUD
    }

}
