/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnStartOnlineTreasureBox
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     OnlineTreasureBoxManager.onlineTreasureBoxActionEnum = OnlineTreasureBoxActionEnum.START_STAGE;
/*    */     
/*    */ 
/* 31 */     List<Long> receiverSet = OnlineTreasureBoxManager.getOnlineReceiverRoleId();
/*    */     
/*    */ 
/* 34 */     int count = OnlineTreasureBoxActivityConst.getInstance().activityIntervalTime / OnlineTreasureBoxActivityConst.getInstance().boxAwardIntervalTime;
/* 35 */     new OnlineTreasureRawardBoxObserver(TimeUnit.MINUTES.toSeconds(OnlineTreasureBoxActivityConst.getInstance().boxAwardIntervalTime), count);
/*    */     
/* 37 */     NoneRealTimeTaskManager.getInstance().addTask(new ROnlineTreasureBuffChange(receiverSet, true));
/*    */     
/* 39 */     OnlineTreasureBoxManager.LOGGER.info("POnStartOnlineTreasureBox.processImp@ activity start add exp buff to online player!");
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\POnStartOnlineTreasureBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */