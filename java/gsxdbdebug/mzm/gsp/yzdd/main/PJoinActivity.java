/*    */ package mzm.gsp.yzdd.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.PCActivityStageEndTime;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.main.PKStatusManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.yzdd.SSynStageChange;
/*    */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*    */ 
/*    */ public class PJoinActivity extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PJoinActivity(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     if (!ActivityInterface.isActivityOpen(YzddConsts.getInstance().ActivityId)) {
/* 25 */       return false;
/*    */     }
/* 27 */     if (TeamInterface.isRoleInTeam(this.roleId, false)) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     MapInterface.transferToScene(this.roleId, YzddManager.getInstance().getWorldId().longValue(), YzddConsts.getInstance().PerpareMapId);
/* 32 */     SSynStageChange synStageChange = new SSynStageChange();
/* 33 */     int stage = ActivityInterface.getActivityStage(YzddConsts.getInstance().ActivityId);
/* 34 */     synStageChange.stage = stage;
/* 35 */     OnlineManager.getInstance().sendAtOnce(this.roleId, synStageChange);
/*    */     
/* 37 */     PKStatusManager.setPKEnabled(this.roleId);
/* 38 */     xdb.Procedure.execute(new PCActivityStageEndTime(this.roleId, YzddConsts.getInstance().ActivityId, stage));
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\main\PJoinActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */