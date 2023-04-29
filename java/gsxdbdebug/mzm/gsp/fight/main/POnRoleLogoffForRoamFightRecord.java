/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogoffForRoamFightRecord extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     long observerid = ((Long)this.arg).longValue();
/*    */     
/* 10 */     RoamFightRecorderManager.getInstance().removeObserverRecorder(observerid);
/*    */     
/* 12 */     RoamFightRecorderCacheManager.getInstance().removeObserverRecorderCache(observerid);
/*    */     
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnRoleLogoffForRoamFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */