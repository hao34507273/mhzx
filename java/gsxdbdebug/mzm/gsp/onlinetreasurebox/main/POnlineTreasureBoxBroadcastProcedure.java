/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.SSyncTreasureBoxActivityLeftTime;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnlineTreasureBoxBroadcastProcedure
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long broadcastEndTime;
/*    */   private long endTime;
/*    */   
/*    */   public POnlineTreasureBoxBroadcastProcedure(long broadcastEndTime, long endTime)
/*    */   {
/* 21 */     this.broadcastEndTime = broadcastEndTime;
/* 22 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     SSyncTreasureBoxActivityLeftTime sSyncTreasureBoxActivityLeftTime = new SSyncTreasureBoxActivityLeftTime();
/* 34 */     sSyncTreasureBoxActivityLeftTime.startlefttime = ((int)this.broadcastEndTime);
/* 35 */     sSyncTreasureBoxActivityLeftTime.endlefttime = ((int)this.endTime);
/* 36 */     List<Long> receiverSet = OnlineTreasureBoxManager.getOnlineReceiverRoleId();
/* 37 */     OnlineManager.getInstance().sendMulti(sSyncTreasureBoxActivityLeftTime, receiverSet);
/*    */     
/* 39 */     OnlineTreasureBoxManager.LOGGER.info("POnlineTreasureBoxBroadcastProcedure.processImp@ broadcast activity start!");
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\POnlineTreasureBoxBroadcastProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */