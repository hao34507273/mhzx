/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.TreasureBoxAwardInfo;
/*    */ import xtable.Treasureboxaward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAutoGetTreasureAwardBox
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     long localId = GameServerInfoManager.getLocalId();
/* 29 */     TreasureBoxAwardInfo xTreasureBoxInfo = Treasureboxaward.get(Long.valueOf(localId));
/* 30 */     if ((xTreasureBoxInfo != null) && (xTreasureBoxInfo.getRoleidset().size() > 0)) {
/* 31 */       Set<Long> roleIdSet = new HashSet();
/* 32 */       roleIdSet.addAll(xTreasureBoxInfo.getRoleidset());
/* 33 */       NoneRealTimeTaskManager.getInstance().addTask(new RAutoGetTreasureAwardBox(roleIdSet));
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\PAutoGetTreasureAwardBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */