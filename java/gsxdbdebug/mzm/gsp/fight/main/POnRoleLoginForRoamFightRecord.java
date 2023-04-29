/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLoginForRoamFightRecord extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     long observerid = ((Long)this.arg).longValue();
/*    */     
/* 10 */     RoamFightRecorder recorder = RoamFightRecorderManager.getInstance().getObserverRecorder(observerid);
/* 11 */     if (recorder != null)
/*    */     {
/* 13 */       recorder.onRoleLogin(observerid);
/*    */     }
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnRoleLoginForRoamFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */