/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CombineGangsInfo;
/*    */ import xbean.CombiningGangsKey;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ 
/*    */ 
/*    */ class RInitCombine
/*    */   extends LogicRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     GangGlobal xGlobal = GangManager.getXGlobal(false);
/*    */     
/* 22 */     if (xGlobal == null) {
/* 23 */       return;
/*    */     }
/* 25 */     for (Map.Entry<CombiningGangsKey, CombineGangsInfo> entry : xGlobal.getCombine().entrySet()) {
/* 26 */       CombiningGangsKey cCombineKey = (CombiningGangsKey)entry.getKey();
/* 27 */       CombineGangsInfo xInfo = (CombineGangsInfo)entry.getValue();
/*    */       
/* 29 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 30 */       if (!xInfo.getIscombining())
/*    */       {
/*    */ 
/* 33 */         int leftSeconds = (int)TimeUnit.SECONDS.convert(now - xInfo.getTimestamp(), TimeUnit.MILLISECONDS);
/* 34 */         if (leftSeconds > 0) {
/* 35 */           leftSeconds = 0;
/*    */         }
/* 37 */         GangManager.startApplyCombineSession(cCombineKey, leftSeconds);
/*    */ 
/*    */ 
/*    */       }
/* 41 */       else if (!DateTimeUtils.isInSameDay(now, xInfo.getTimestamp()))
/*    */       {
/* 43 */         new RCombine(cCombineKey).run();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RInitCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */