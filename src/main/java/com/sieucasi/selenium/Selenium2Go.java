/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sieucasi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author SieuCaSi
 */
public class Selenium2Go {

    public static void main(String[] args) throws InterruptedException {
        searchGoogleV2();
    }
    public static void searchGoogleV2() throws InterruptedException{
        //1. Khai báo biến đại diện/trỏ đến trình duyệt sẽ đc mở/đc new
        WebDriver myBrowser; //biến object thuộc bộ thư viện Selinium
                             //thằng này sẽ trỏ đến cái trình duyệt khi được new
                             //mỗi lần new là 1 trình duyệt đc mở ra
                             //1 object Trình Duyệt đc new trong HEAP
        //2. Khai báo người emm song sinh, gã sẽ điều khiển trình duyệt
        // nó luôn đc phát hành song song với phiên bản trình duyệt đang xài
        // tương thích version với trình duyệt đang xài! BẮT BUỘC!
        // WebDriver là tên gọi của người ae song sinh, là file .exe/.dll
        String driverPath = "chromedriver.exe";
        
        
        //3. new Trình Duyệt (mở trình duyệt) gắn kết với người em song sinh
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giải thích: báo với máy ảo Java rằng, có 1 thằng .exe muốn tham gia vào
        //danh sách class mà JVM quản lý
        //.EXE .DLL, xả 1 đống class điều khiển trình duyệt vào trong JVM lúc run-time
        //và gọi nhóm class nfy là webdriver.chrome.driver -> hằng số quy ước sẵn
        //code Selenium qua class WebDriver, ChromeDriver sẽ xài ở dưới đây
        //biết cách chơi với các class của .exe vừa rồi, vì chúng đang cùng trong máy ảo
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang-vi"); //-vi tiếng Việt, en-GB: tiếng Anh; =zh-cn: tiếng Trung
        
        myBrowser = new ChromeDriver(opt);
        
        //4. Viết code dùng Selenium nói chuyện với người song sinh - driver
        //   driver biết cách nói chuyện với trình duyệt thật đã new!
        //   trình duyệt sẵn sàng thông qua người em đưa hết data (trang web trong ram)
        //   cho mình dưới dạng cây DOM - Document Object Model 
        //   trang HTML trả về trong RAM của mình trình duyệt đc xem là 1 cây các object 
        //   node/tag đc xem là 1 object thuộc nhóm WebElement 
        
        myBrowser.get("https://google.com"); //duyệt trang trên object trình duyệt vừa new 
        
        myBrowser.manage().window().maximize();
        
        Thread.sleep(3000); //app nghỉ 3s rồi chạy tiếp lệnh sau
        
        myBrowser.quit();
    }
    
    public static void searchGoogle(){
        //1. Khai báo biến đại diện/trỏ đến trình duyệt sẽ đc mở/đc new
        WebDriver myBrowser; //biến object thuộc bộ thư viện Selinium
                             //thằng này sẽ trỏ đến cái trình duyệt khi được new
                             //mỗi lần new là 1 trình duyệt đc mở ra
                             //1 object Trình Duyệt đc new trong HEAP
        //2. Khai báo người emm song sinh, gã sẽ điều khiển trình duyệt
        // nó luôn đc phát hành song song với phiên bản trình duyệt đang xài
        // tương thích version với trình duyệt đang xài! BẮT BUỘC!
        // WebDriver là tên gọi của người ae song sinh, là file .exe/.dll
        String driverPath = "chromedriver.exe";
        
        
        //3. new Trình Duyệt (mở trình duyệt) gắn kết với người em song sinh
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giải thích: báo với máy ảo Java rằng, có 1 thằng .exe muốn tham gia vào
        //danh sách class mà JVM quản lý
        //.EXE .DLL, xả 1 đống class điều khiển trình duyệt vào trong JVM lúc run-time
        //và gọi nhóm class nfy là webdriver.chrome.driver -> hằng số quy ước sẵn
        //code Selenium qua class WebDriver, ChromeDriver sẽ xài ở dưới đây
        //biết cách chơi với các class của .exe vừa rồi, vì chúng đang cùng trong máy ảo
        
        myBrowser = new ChromeDriver();
        
        //4. Viết code dùng Selenium nói chuyện với người song sinh - driver
        //   driver biết cách nói chuyện với trình duyệt thật đã new!
        //   trình duyệt sẵn sàng thông qua người em đưa hết data (trang web trong ram)
        //   cho mình dưới dạng cây DOM - Document Object Model 
        //   trang HTML trả về trong RAM của mình trình duyệt đc xem là 1 cây các object 
        //   node/tag đc xem là 1 object thuộc nhóm WebElement 
        
        myBrowser.get("https://google.com"); //duyệt trang trên object trình duyệt vừa new 
        
        myBrowser.manage().window().maximize();
        
        //ta sẽ đi tìm các tag, và hành sửa trên các tag. Các tag này là object
        //nằm trong object bự là my Browser (là field/đặc tính của object bự)
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        //lấy đc ô search dưới dạng object
        searchBox.sendKeys("Gét Gô");
        searchBox.submit();
        
    }

}
