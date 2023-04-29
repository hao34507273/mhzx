/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnRoleLogoff
/*    */   extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 13 */     new PReportRoleBetRankInfo(((Long)this.arg).longValue()).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\ROnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */