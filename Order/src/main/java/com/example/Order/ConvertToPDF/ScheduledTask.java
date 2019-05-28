package com.example.Order.ConvertToPDF;


import com.example.Order.Controller.MainController;
import com.example.Order.Services.OrderServiceImpl.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

@Configuration
@EnableScheduling
public class ScheduledTask {

    @Autowired
    private OrderServiceImplementation service;

    @Scheduled(fixedDelay = 1000)
    public void executeTask1()
    {
        System.out.println(Thread.currentThread().getName()+" The Task1 executed at "+ new Date());
        MainController mainController = new MainController();

        if(mainController.mailqueue.size()>0)
        {
            for(Iterator<HashMap.Entry<String, String>> it = mainController.mailqueue.entrySet().iterator(); it.hasNext(); )
            {
                HashMap.Entry<String, String> entry = it.next();
                service.sendEmail(entry.getKey(),entry.getValue());
                //System.out.println(entry.getKey()+entry.getValue());
                it.remove();
            }
        }
        try
        {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}