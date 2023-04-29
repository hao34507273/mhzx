/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ 
/*    */ public class ROnRoleOffLine extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     new RoleLogOff(((Long)this.arg).longValue()).call();
/*    */     
/* 12 */     if (GameServerInfoManager.isRoamServer()) {
/* 13 */       new ClearRoleData(((Long)this.arg).longValue()).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\ROnRoleOffLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */