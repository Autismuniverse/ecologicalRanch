package com.ecologicalRanch.stepCounting.service;//package com.ecologicalRanch.stepCounting.service;
//
//import com.ecologicalRanch.stepCounting.CronTestConfiguration;
//import com.ecologicalRanch.stepCounting.Timing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.Trigger;
//import org.springframework.scheduling.TriggerContext;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.concurrent.ScheduledFuture;
//
//@Service
//public class ScheduledFutureServiceImpl implements IScheduledFutureService{
//
//    @Autowired
//    private CronTestConfiguration cronTestConfiguration;
//    @Autowired
//    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
//
//    /**
//     * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
//     * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，
//     * Runnable（线程接口类） 和CronTrigger（定时任务触发器）
//     * YouXinConfiguration：自定义读取yml文件中数据的类，通过该类读取yml文件中cron时间表达式，从而可以达到定时时间可配置的效果。
//     * MyRunnable1与MyRunnable2类：这两个类都是实现了Runnable接口，重写了run方法，定时任务的逻辑代码就是在其中实现。
//     */
//    @Override
//    public ScheduledFuture scheduledStart(){
//        ScheduledFuture future1 = threadPoolTaskScheduler.schedule(new Timing(), new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                return new CronTrigger(cronTestConfiguration.getCron2()).nextExecutionTime(triggerContext);
//            }
//            }
//        });
//        return future1;
//    }
//
//    @Override
//    public void scheduledClose(ScheduledFuture future1){
//        if (future1 != null) {
//            future1.cancel(true);
//        }
//    }
//}
