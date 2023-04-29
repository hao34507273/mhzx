/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.TreasureBoxAwardInfo;
/*    */ import xbean.TreasureBoxExpInfo;
/*    */ import xtable.Treasureboxaward;
/*    */ import xtable.Treasureboxexp;
/*    */ 
/*    */ 
/*    */ public class POnEndOnlineTreasureBox
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     OnlineTreasureBoxManager.onlineTreasureBoxActionEnum = OnlineTreasureBoxActionEnum.CLOSE_STAGE;
/*    */     
/* 29 */     OnlineTreasureBoxManager.TREASUREBOX_ACTIVITY_END_TIME = 0L;
/* 30 */     OnlineTreasureBoxManager.TREASUREBOX_BROADCAST_TIME = 0L;
/*    */     
/*    */ 
/* 33 */     List<Long> onlineRoles = OnlineManager.getInstance().getAllRolesInWorld();
/*    */     
/* 35 */     NoneRealTimeTaskManager.getInstance().addTask(new ROnlineTreasureBuffChange(onlineRoles, false));
/*    */     
/*    */ 
/* 38 */     long localId = GameServerInfoManager.getLocalId();
/*    */     
/* 40 */     TreasureBoxExpInfo xTreasureBoxExpInfo = Treasureboxexp.get(Long.valueOf(localId));
/* 41 */     if (xTreasureBoxExpInfo != null) {
/* 42 */       xTreasureBoxExpInfo.getRoleid2getexptime().clear();
/*    */     }
/*    */     
/* 45 */     TreasureBoxAwardInfo xTreasureBoxAwardInfo = Treasureboxaward.get(Long.valueOf(localId));
/* 46 */     if (xTreasureBoxAwardInfo != null) {
/* 47 */       xTreasureBoxAwardInfo.getRoleidset().clear();
/*    */     }
/*    */     
/* 50 */     OnlineTreasureBoxManager.LOGGER.info("POnEndOnlineTreasureBox.processImp@ onlinetreasure activity end clear data");
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\POnEndOnlineTreasureBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */