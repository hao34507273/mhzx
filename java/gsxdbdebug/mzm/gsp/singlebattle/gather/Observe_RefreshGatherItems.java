/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.singlebattle.confbean.SBattleGatherPlayCfg;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGatherData;
/*    */ 
/*    */ 
/*    */ public class Observe_RefreshGatherItems
/*    */   extends Observer
/*    */ {
/*    */   private final long battleId;
/*    */   
/*    */   public Observe_RefreshGatherItems(long intervalSeconds, long battleId)
/*    */   {
/* 20 */     super(intervalSeconds);
/* 21 */     this.battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     new RefreshGatherItems(this).execute();
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   private class RefreshGatherItems extends LogicProcedure
/*    */   {
/*    */     private final Observer obsever;
/*    */     
/*    */     RefreshGatherItems(Observer obsever)
/*    */     {
/* 37 */       this.obsever = obsever;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(Observe_RefreshGatherItems.this.battleId, true);
/* 45 */       if (globalInfo == null)
/*    */       {
/* 47 */         this.obsever.stopTimer();
/* 48 */         GameServer.logger().error(String.format("[battlegather]RefreshGatherItems.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(Observe_RefreshGatherItems.this.battleId) }));
/*    */         
/* 50 */         return false;
/*    */       }
/* 52 */       if ((globalInfo.getStage() == 3) || (globalInfo.getStage() == 4))
/*    */       {
/*    */ 
/* 55 */         this.obsever.stopTimer();
/* 56 */         GameServer.logger().info(String.format("[singlebattle]RefreshGatherItems.processImp@ clean stage, stop timer! |battleId=%d", new Object[] { Long.valueOf(Observe_RefreshGatherItems.this.battleId) }));
/*    */         
/*    */ 
/* 59 */         return false;
/*    */       }
/* 61 */       int playCfgId = globalInfo.getPlayCfgId(4);
/* 62 */       SBattleGatherPlayCfg playCfg = SBattleGatherPlayCfg.get(playCfgId);
/* 63 */       if (playCfg == null)
/*    */       {
/* 65 */         GameServer.logger().error(String.format("[battlegather]RefreshGatherItems.processImp@ playCfg is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(Observe_RefreshGatherItems.this.battleId), Integer.valueOf(playCfgId) }));
/*    */         
/*    */ 
/* 68 */         return false;
/*    */       }
/* 70 */       BattleGatherData xBattleGatherData = BattleGatherManager.getXBattleGatherDataIfAbsence(Observe_RefreshGatherItems.this.battleId);
/*    */       
/* 72 */       BattleGatherManager.removeOriginalGatherItems(Observe_RefreshGatherItems.this.battleId, xBattleGatherData, MapCallBack_RemoveMapEntity.RemoveGatherItemReason.OTHER);
/*    */       
/* 74 */       BattleGatherManager.refreshGatherItems(xBattleGatherData, Observe_RefreshGatherItems.this.battleId, playCfgId, globalInfo.getBattleWorldId(), globalInfo.getBattleMapId());
/*    */       
/*    */ 
/* 77 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\Observe_RefreshGatherItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */