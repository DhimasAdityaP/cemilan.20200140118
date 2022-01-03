/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cemilan8.cemilan.java8;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dimas
 */
@Controller
public class APKController {
    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model discountprocess){
        
        String inputname = data.getParameter("var_name");
        
        String inputprice = data.getParameter("var_price");
        
        String inputquantity = data.getParameter("var_quantity");
        
        String inputuang = data.getParameter("var_money");
        
        String diskon = "";
        
        Double iPrice = Double.valueOf(inputprice);
        Double iTotal = Double.valueOf(inputquantity);
        Double iMoney = Double.valueOf(inputuang);
        Double PriceTotal = iPrice * iTotal;
        Double getTotal = null;
        
        if (PriceTotal < 16000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskon = "0%";
        }
        else if (PriceTotal >= 16000 && PriceTotal < 25000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            diskon = "10%";
        }
        else if (PriceTotal >= 25000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            diskon = "15%";
        }
        
        Double change = iMoney - getTotal;
        
        discountprocess.addAttribute("name", inputname);
        discountprocess.addAttribute("price", inputprice);
        discountprocess.addAttribute("quantity", inputquantity);
        discountprocess.addAttribute("total", getTotal);
        discountprocess.addAttribute("diskon", diskon);
        discountprocess.addAttribute("bayar", inputuang);
        discountprocess.addAttribute("change", change);
        
        
        return "viewer";
    }    
}
    

