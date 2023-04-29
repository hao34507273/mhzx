/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.CombineGangsInfo;
/*    */ import xbean.CombiningGangsKey;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ class GangDayUpdateObserver
/*    */   extends DateObserver
/*    */ {
/*    */   public GangDayUpdateObserver(int timeCommonCfgId)
/*    */   {
/* 17 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 22 */     NoneRealTimeTaskManager.getInstance().addTask(new RDayUpdate(null));
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private static class RDayUpdate extends LogicRunnable
/*    */   {
/*    */     public void process() throws Exception
/*    */     {
/* 30 */       GangGlobal xGlobal = GangManager.getXGlobal(false);
/* 31 */       if (xGlobal == null) {
/* 32 */         return;
/*    */       }
/*    */       
/* 35 */       for (Long gangId : xGlobal.getAllgangids()) {
/* 36 */         new RSystemClearGangMember(gangId.longValue()).run();
/* 37 */         new PGangDayUpdate(gangId.longValue()).call();
/*    */       }
/*    */       
/* 40 */       for (Map.Entry<CombiningGangsKey, CombineGangsInfo> entry : xGlobal.getCombine().entrySet()) {
/* 41 */         CombiningGangsKey cCombineKey = (CombiningGangsKey)entry.getKey();
/* 42 */         CombineGangsInfo xInfo = (CombineGangsInfo)entry.getValue();
/* 43 */         if (xInfo.getIscombining()) {
/* 44 */           new RCombine(cCombineKey).run();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangDayUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */