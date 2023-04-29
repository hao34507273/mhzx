/*    */ package mzm.gsp.alllotto.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SendAwardSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   
/*    */   public SendAwardSession(long interval, long roleid, int activityCfgid, int turn)
/*    */   {
/* 17 */     super(interval, roleid);
/* 18 */     this.activityCfgid = activityCfgid;
/* 19 */     this.turn = turn;
/* 20 */     GameServer.logger().info(String.format("[alllotto]SendAwardSession@start send award session|interval=%d|roleid=%d|activity_cfg_id=%d|turn=%d", new Object[] { Long.valueOf(interval), Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(turn) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     new PSendAward(getOwerId(), this.activityCfgid, this.turn).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\SendAwardSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */