/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.DoubleTime;
/*    */ import xbean.Pod;
/*    */ import xtable.Doubletime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DoubleitemClearObserver
/*    */   extends DateObserver
/*    */ {
/*    */   DoubleitemClearObserver(int timeCommonCfgId)
/*    */   {
/* 26 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 34 */     new TimeOutPro(null).execute();
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   private static class TimeOutPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       long now = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.MINUTES.toMillis(1L);
/* 45 */       Calendar cal = DateTimeUtils.getCalendar();
/* 46 */       cal.setTimeInMillis(now);
/* 47 */       cal.set(14, 0);
/* 48 */       cal.set(13, 0);
/* 49 */       cal.set(12, 0);
/* 50 */       long cur = cal.getTimeInMillis();
/* 51 */       DoubleTime doubleTime = Doubletime.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */       
/* 53 */       if (doubleTime == null) {
/* 54 */         doubleTime = Pod.newDoubleTime();
/* 55 */         doubleTime.setPointoffertime(cur);
/* 56 */         Doubletime.insert(Long.valueOf(GameServerInfoManager.getLocalId()), doubleTime);
/*    */       }
/*    */       
/* 59 */       doubleTime.setItemcountcleartime(cur);
/*    */       
/* 61 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 63 */         NoneRealTimeTaskManager.getInstance().addTask(new PResetItemUseTimes(roleId, cur));
/*    */       }
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\DoubleitemClearObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */