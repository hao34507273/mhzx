/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class WeekBeginRemindObserver
/*    */   extends DateObserver
/*    */ {
/*    */   WeekBeginRemindObserver()
/*    */   {
/* 21 */     super(SFactionPVEConsts.getInstance().WeekBeginTime);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 26 */     NoneRealTimeTaskManager.getInstance().addTask(new RWeekBeginRemind());
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   static class RWeekBeginRemind
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process() throws Exception
/*    */     {
/* 35 */       Collection<Long> factions = GangInterface.getAllGangIdSet();
/* 36 */       TLogArg tlogArg = new TLogArg(LogReason.FACTION_PVE_WEEK_BEGIN_MAIL);
/* 37 */       for (Iterator i$ = factions.iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/*    */         
/* 39 */         GangInterface.sendGangMailSync(factionid, SFactionPVEConsts.getInstance().WeekBeginMail, null, null, tlogArg);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\WeekBeginRemindObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */