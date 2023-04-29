/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.singlebattle.confbean.SBattleGatherPlayCfg;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGatherData;
/*    */ 
/*    */ public class PGM_RefreshItem extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_RefreshItem(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long battleId = SingleBattleInterface.getBattleId(this.roleId, false);
/*    */     
/* 26 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleId, true);
/* 27 */     if (globalInfo == null)
/*    */     {
/* 29 */       GameServer.logger().error(String.format("[battlegather]PGM_RefreshItem.processImp@ globalInfo is null!|battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*    */       
/* 31 */       return false;
/*    */     }
/* 33 */     int playCfgId = globalInfo.getPlayCfgId(4);
/* 34 */     SBattleGatherPlayCfg playCfg = SBattleGatherPlayCfg.get(playCfgId);
/* 35 */     if (playCfg == null)
/*    */     {
/* 37 */       GameServer.logger().error(String.format("[battlegather]PGM_RefreshItem.processImp@ playCfg is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*    */       
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     BattleGatherData xBattleGatherData = BattleGatherManager.getXBattleGatherDataIfAbsence(battleId);
/*    */     
/* 44 */     BattleGatherManager.removeOriginalGatherItems(battleId, xBattleGatherData, MapCallBack_RemoveMapEntity.RemoveGatherItemReason.OTHER);
/*    */     
/* 46 */     BattleGatherManager.refreshGatherItems(xBattleGatherData, battleId, playCfgId, globalInfo.getBattleWorldId(), globalInfo.getBattleMapId());
/*    */     
/* 48 */     GmManager.getInstance().sendResultToGM(this.roleId, "操作成功");
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\PGM_RefreshItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */