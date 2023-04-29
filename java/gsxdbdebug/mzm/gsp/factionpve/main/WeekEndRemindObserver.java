/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.FactionPVE;
/*    */ import xtable.Factionpve;
/*    */ 
/*    */ 
/*    */ class WeekEndRemindObserver
/*    */   extends DateObserver
/*    */ {
/*    */   WeekEndRemindObserver()
/*    */   {
/* 22 */     super(SFactionPVEConsts.getInstance().WeekEndTime);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 28 */     NoneRealTimeTaskManager.getInstance().addTask(new RWeekEndRemind());
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   static class RWeekEndRemind
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 38 */       Collection<Long> factions = GangInterface.getAllGangIdSet();
/* 39 */       TLogArg tlogArg = new TLogArg(LogReason.FACTION_PVE_WEEK_END_MAIL);
/*    */       
/* 41 */       long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*    */       
/*    */ 
/* 44 */       for (Iterator i$ = factions.iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/*    */         
/*    */ 
/* 47 */         FactionPVE xFactionPVE = Factionpve.select(Long.valueOf(factionid));
/* 48 */         if ((xFactionPVE == null) || 
/* 49 */           (xFactionPVE.getStart_timestamp() <= activityStartTime))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 55 */           GangInterface.sendGangMailSync(factionid, SFactionPVEConsts.getInstance().WeekEndMail, null, null, tlogArg);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\WeekEndRemindObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */