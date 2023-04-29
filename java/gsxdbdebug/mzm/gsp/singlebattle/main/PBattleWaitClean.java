/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.singlebattle.SSynBattleStage;
/*    */ import mzm.gsp.singlebattle.SynBattleMatchEnd;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBattleWaitClean
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long _battleId;
/*    */   private final int _reason;
/*    */   
/*    */   public PBattleWaitClean(long battleId, int reason)
/*    */   {
/* 22 */     this._battleId = battleId;
/* 23 */     this._reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     GameServer.logger().info(String.format("[singlebattle]PBattleWaitClean.processImp@ try enter waiting clean up stage!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*    */     
/*    */ 
/*    */ 
/* 33 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(this._battleId, true);
/* 34 */     if (globalInfo == null)
/*    */     {
/* 36 */       GameServer.logger().error(String.format("[singlebattle]PBattleWaitClean.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*    */       
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if ((globalInfo.getStage() == 3) || (globalInfo.getStage() == 4))
/*    */     {
/*    */ 
/* 44 */       GameServer.logger().error(String.format("[singlebattle]PBattleWaitClean.processImp@ not int match stage!|battleId=%d|stage=%d", new Object[] { Long.valueOf(this._battleId), Integer.valueOf(globalInfo.getStage()) }));
/*    */       
/*    */ 
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     GameServer.logger().info(String.format("[singlebattle]PBattleWaitClean.processImp@ begin waiting clean up stage!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*    */     
/*    */ 
/*    */ 
/* 54 */     globalInfo.setStage(3);
/*    */     
/* 56 */     globalInfo.battleBro(new SSynBattleStage(3), true);
/*    */     
/* 58 */     new SessionBattleWaitCleanEnd(this._battleId, SingleBattleManager.getBattleWaitCleanInterval(globalInfo.getBattleCfg()));
/*    */     
/* 60 */     SingleBattleManager.onStageChange(this._battleId, globalInfo.getBattleCfg(), 3);
/*    */     
/* 62 */     for (Iterator i$ = globalInfo.getAllFightIds().iterator(); i$.hasNext();) { long fightId = ((Long)i$.next()).longValue();
/*    */       
/* 64 */       FightInterface.endFight(fightId);
/*    */     }
/*    */     
/* 67 */     globalInfo.battleBro(new SynBattleMatchEnd(this._reason), true);
/*    */     
/* 69 */     GameServer.logger().info(String.format("[singlebattle]PBattleWaitClean.processImp@ over match!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PBattleWaitClean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */