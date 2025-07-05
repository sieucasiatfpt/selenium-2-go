/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sieucasi.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
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
        myBrowser.get("https://demo.guru99.com/V4"); //duyệt trang trên object trình duyệt vừa new 
        Thread.sleep(5000);
        
    }

    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit(); //dọn dẹp rác, undo khi @Test đã chạy, đã làm thay đổi hiện trạng nào đó, ví dụ DB có rác do chạy test CRUD
    }

}
