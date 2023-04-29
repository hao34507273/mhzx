/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.singlebattle.confbean.SBattleGatherPlayCfg;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGatherData;
/*    */ 
/*    */ public class Session_StartOutputGather extends Session
/*    */ {
/*    */   private final long battleId;
/*    */   
/*    */   public Session_StartOutputGather(long interval, long battleId)
/*    */   {
/* 18 */     super(interval, battleId);
/* 19 */     this.battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     new StartOutputGather(null).execute();
/*    */   }
/*    */   
/*    */   private class StartOutputGather
/*    */     extends LogicProcedure
/*    */   {
/*    */     private StartOutputGather() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 35 */       SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(Session_StartOutputGather.this.battleId, true);
/* 36 */       if (globalInfo == null)
/*    */       {
/* 38 */         GameServer.logger().error(String.format("[battlegather]StartOutputGather.processImp@ globalInfo is null!|battleId=%d", new Object[] { Long.valueOf(Session_StartOutputGather.this.battleId) }));
/*    */         
/* 40 */         return false;
/*    */       }
/* 42 */       int playCfgId = globalInfo.getPlayCfgId(4);
/* 43 */       SBattleGatherPlayCfg playCfg = SBattleGatherPlayCfg.get(playCfgId);
/* 44 */       if (playCfg == null)
/*    */       {
/* 46 */         GameServer.logger().error(String.format("[battlegather]StartOutputGather.processImp@ playCfg is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(Session_StartOutputGather.this.battleId), Integer.valueOf(playCfgId) }));
/*    */         
/*    */ 
/* 49 */         return false;
/*    */       }
/* 51 */       BattleGatherData xBattleGatherData = BattleGatherManager.getXBattleGatherDataIfAbsence(Session_StartOutputGather.this.battleId);
/*    */       
/* 53 */       BattleGatherManager.removeOriginalGatherItems(Session_StartOutputGather.this.battleId, xBattleGatherData, MapCallBack_RemoveMapEntity.RemoveGatherItemReason.OTHER);
/*    */       
/* 55 */       BattleGatherManager.refreshGatherItems(xBattleGatherData, Session_StartOutputGather.this.battleId, playCfgId, globalInfo.getBattleWorldId(), globalInfo.getBattleMapId());
/*    */       
/*    */ 
/* 58 */       new Observe_RefreshGatherItems(playCfg.refreshInterval, Session_StartOutputGather.this.battleId);
/* 59 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\Session_StartOutputGather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */