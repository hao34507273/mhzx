/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     long roleid = ((Long)this.arg).longValue();
/*  8 */     xtable.Gmstatus.remove(Long.valueOf(roleid));
/*    */     
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */