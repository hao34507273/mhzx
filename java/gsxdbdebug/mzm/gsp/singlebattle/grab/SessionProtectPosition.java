/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGrabData;
/*    */ import xbean.GrabPositionData;
/*    */ import xtable.Grabposition;
/*    */ 
/*    */ 
/*    */ public class SessionProtectPosition
/*    */   extends Session
/*    */ {
/*    */   private final int positionId;
/*    */   private final long battleId;
/*    */   
/*    */   public SessionProtectPosition(long interval, long battleId, int positionId)
/*    */   {
/* 21 */     super(interval, battleId);
/* 22 */     this.battleId = battleId;
/* 23 */     this.positionId = positionId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     new AfterProtectEnd(null).execute();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private class AfterProtectEnd
/*    */     extends LogicProcedure
/*    */   {
/*    */     private AfterProtectEnd() {}
/*    */     
/*    */ 
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(SessionProtectPosition.this.battleId));
/* 46 */       if (xBattleGrabData == null)
/*    */       {
/* 48 */         GameServer.logger().error(String.format("[grab]AfterProtectEnd.processImp@ no grab position data! |positionId=%d|battleId=%d", new Object[] { Integer.valueOf(SessionProtectPosition.this.positionId), Long.valueOf(SessionProtectPosition.this.battleId) }));
/*    */         
/*    */ 
/* 51 */         return false;
/*    */       }
/*    */       
/* 54 */       GrabPositionData xGrabPositionData = (GrabPositionData)xBattleGrabData.getPositiondatas().get(Integer.valueOf(SessionProtectPosition.this.positionId));
/*    */       
/* 56 */       if (xGrabPositionData == null)
/*    */       {
/* 58 */         return false;
/*    */       }
/*    */       
/* 61 */       GrabPositionManager.setPositionState(SessionProtectPosition.this.battleId, xGrabPositionData, 1, SessionProtectPosition.this.positionId);
/*    */       
/* 63 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\SessionProtectPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */