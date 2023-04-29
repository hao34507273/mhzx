/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.DoubleTime;
/*    */ import xbean.Pod;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ import xtable.Doubletime;
/*    */ 
/*    */ 
/*    */ 
/*    */ class OfferDoublePointObserver
/*    */   extends DateObserver
/*    */ {
/*    */   OfferDoublePointObserver(int timeCommonCfgId)
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
/*    */       
/* 52 */       DoubleTime doubleTime = Doubletime.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */       
/* 54 */       if (doubleTime == null)
/*    */       {
/* 56 */         doubleTime = Pod.newDoubleTime();
/* 57 */         doubleTime.setItemcountcleartime(cur);
/* 58 */         Doubletime.insert(Long.valueOf(GameServerInfoManager.getLocalId()), doubleTime);
/*    */       }
/*    */       
/* 61 */       doubleTime.setPointoffertime(cur);
/*    */       
/* 63 */       Xdb.executor().execute(new OfferDoublePointObserver.OffDoublePointRunnable(cur));
/*    */       
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private static class OffDoublePointRunnable
/*    */     extends LogicRunnable
/*    */   {
/*    */     private final long cur;
/*    */     
/*    */ 
/*    */     public OffDoublePointRunnable(long cur)
/*    */     {
/* 78 */       this.cur = cur;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 84 */       List<Long> roleList = OnlineManager.getInstance().getAllRolesInWorld();
/* 85 */       Iterator<Long> iterator = roleList.iterator();
/* 86 */       while (iterator.hasNext())
/*    */       {
/* 88 */         long roleId = ((Long)iterator.next()).longValue();
/* 89 */         new POfferPoint(roleId, this.cur).call();
/* 90 */         iterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\OfferDoublePointObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */