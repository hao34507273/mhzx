/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.SSyncTreasureBoxActivityStartRes;
/*    */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.TreasureBoxAwardInfo;
/*    */ import xtable.Treasureboxaward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTreasureRawardBox
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     List<Long> onlineRoles = OnlineTreasureBoxManager.getOnlineReceiverRoleId();
/*    */     
/*    */ 
/* 31 */     long localId = GameServerInfoManager.getLocalId();
/* 32 */     TreasureBoxAwardInfo xTreasureBoxAwardInfo = Treasureboxaward.get(Long.valueOf(localId));
/* 33 */     xTreasureBoxAwardInfo.getRoleidset().clear();
/* 34 */     xTreasureBoxAwardInfo.getRoleidset().addAll(onlineRoles);
/*    */     
/*    */ 
/* 37 */     SSyncTreasureBoxActivityStartRes sSyncTreasureBoxActivityStartRes = new SSyncTreasureBoxActivityStartRes();
/* 38 */     OnlineManager.getInstance().sendMulti(sSyncTreasureBoxActivityStartRes, onlineRoles);
/*    */     
/*    */ 
/* 41 */     new AutoGetTreasureAwardBoxObserver(OnlineTreasureBoxActivityConst.getInstance().serverEndGetAwardBoxTime);
/* 42 */     OnlineTreasureBoxManager.LOGGER.info("PTreasureRawardBox.processImp@ activity treasurebox show to online player!");
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\PTreasureRawardBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */