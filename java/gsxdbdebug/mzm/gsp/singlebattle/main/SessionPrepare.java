/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.singlebattle.SSynBattleStage;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SessionPrepare
/*    */   extends Session
/*    */ {
/*    */   private final long _battleId;
/*    */   
/*    */   SessionPrepare(long battleId, int second)
/*    */   {
/* 22 */     super(second, battleId);
/* 23 */     this._battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(this._battleId), new PPrepareEnd(null));
/*    */   }
/*    */   
/*    */   private class PPrepareEnd extends LogicProcedure
/*    */   {
/*    */     private PPrepareEnd() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 38 */       GameServer.logger().info(String.format("[singlebattle]PPrepareEnd.processImp@ try over prepare!|battleId=%d", new Object[] { Long.valueOf(SessionPrepare.this._battleId) }));
/*    */       
/*    */ 
/*    */ 
/* 42 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(SessionPrepare.this._battleId, true);
/* 43 */       if (globalInfo == null)
/*    */       {
/* 45 */         GameServer.logger().error(String.format("[singlebattle]PPrepareEnd.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(SessionPrepare.this._battleId) }));
/*    */         
/* 47 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 51 */       globalInfo.setStage(2);
/*    */       
/* 53 */       globalInfo.battleBro(new SSynBattleStage(2), true);
/*    */       
/* 55 */       for (Iterator i$ = globalInfo.getAllMembers().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 57 */         MapInterface.setLimitPolygonMovementStatus(roleId, false, null);
/*    */       }
/*    */       
/* 60 */       SingleBattleManager.onStageChange(SessionPrepare.this._battleId, globalInfo.getBattleCfg(), 2);
/*    */       
/* 62 */       GameServer.logger().info(String.format("[singlebattle]PPrepareEnd.processImp@ over prepare!|battleId=%d", new Object[] { Long.valueOf(SessionPrepare.this._battleId) }));
/*    */       
/* 64 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SessionPrepare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */