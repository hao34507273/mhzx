/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGatherData;
/*    */ import xtable.Battlegather;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Session_ClearGather
/*    */   extends Session
/*    */ {
/*    */   private final long battleId;
/*    */   private final int playCfgId;
/*    */   
/*    */   public Session_ClearGather(long interval, long battleId, int playCfgId)
/*    */   {
/* 22 */     super(interval, battleId);
/* 23 */     this.battleId = battleId;
/* 24 */     this.playCfgId = playCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 30 */     new ClearGahter(null).execute();
/*    */   }
/*    */   
/*    */   private final class ClearGahter extends LogicProcedure
/*    */   {
/*    */     private ClearGahter() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 39 */       GameServer.logger().info(String.format("[battlegather]ClearGahter.processImp@ try to clean gather items!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(Session_ClearGather.this.battleId), Integer.valueOf(Session_ClearGather.this.playCfgId) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       BattleGatherData xBattleGatherData = Battlegather.get(Long.valueOf(Session_ClearGather.this.battleId));
/* 44 */       if (xBattleGatherData == null)
/*    */       {
/* 46 */         GameServer.logger().info(String.format("[battlegather]ClearGahter.processImp@ xBattleGatherData is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(Session_ClearGather.this.battleId), Integer.valueOf(Session_ClearGather.this.playCfgId) }));
/*    */         
/*    */ 
/*    */ 
/* 50 */         return false;
/*    */       }
/* 52 */       BattleGatherManager.removeOriginalGatherItems(Session_ClearGather.this.battleId, xBattleGatherData, MapCallBack_RemoveMapEntity.RemoveGatherItemReason.TIME_OUT);
/*    */       
/* 54 */       GameServer.logger().info(String.format("[battlegather]ClearGahter.processImp@ clean gather end!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(Session_ClearGather.this.battleId), Integer.valueOf(Session_ClearGather.this.playCfgId) }));
/*    */       
/*    */ 
/* 57 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\Session_ClearGather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */