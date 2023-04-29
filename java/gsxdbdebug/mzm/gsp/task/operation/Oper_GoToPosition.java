/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.task.confbean.STaskOperGoToPosition;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class Oper_GoToPosition
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_GoToPosition(int operId, STaskOperGoToPosition gotoPosition, int taskId)
/*    */   {
/* 16 */     super(operId, gotoPosition.operType, gotoPosition.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperGoToPosition getSTaskOperGoToPosition()
/*    */   {
/* 21 */     return STaskOperGoToPosition.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 33 */     doTransform(roleId, getSTaskOperGoToPosition());
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   private final void doTransform(final long roleId, STaskOperGoToPosition cfg)
/*    */   {
/* 39 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 46 */         if (canTransform(roleId))
/*    */         {
/* 48 */           MapInterface.transferToScene(roleId, this.val$cfg.mapID, this.val$cfg.positionX, this.val$cfg.positionY);
/*    */         }
/* 50 */         return true;
/*    */       }
/*    */       
/*    */ 
/*    */       private boolean canTransform(long roleId)
/*    */       {
/* 56 */         TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(roleId);
/* 57 */         return (teamInfo == null) || (teamInfo.getMemberStatus(roleId) == 1) || (teamInfo.isLeader(roleId));
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_GoToPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */