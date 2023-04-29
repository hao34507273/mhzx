/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.grow.LevelGuide.LevelGuideManager;
/*    */ import mzm.gsp.grow.confbean.GoalParameter;
/*    */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*    */ import mzm.gsp.grow.hand.TargetHandle;
/*    */ import mzm.gsp.grow.hand.TargetRegManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLvUp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int oldLv;
/*    */   private final int newLv;
/*    */   private final int goalId;
/*    */   
/*    */   public POnRoleLvUp(long roleId, int oldLv, int newLv, int goalId)
/*    */   {
/* 31 */     this.roleId = roleId;
/* 32 */     this.oldLv = oldLv;
/* 33 */     this.newLv = newLv;
/* 34 */     this.goalId = goalId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     new PRoleLvUp(this.roleId, this.oldLv, this.newLv).execute();
/*    */     
/* 42 */     int realAdd = this.newLv - this.oldLv;
/* 43 */     if (realAdd <= 0)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     String userId = RoleInterface.getUserId(this.roleId);
/* 49 */     lock(Lockeys.get(User.getTable(), userId));
/* 50 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 51 */     SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 52 */     if (cfg == null)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     if (cfg.moduleType != 4)
/*    */     {
/* 58 */       return false;
/*    */     }
/* 60 */     TargetHandle handler = TargetRegManager.getHanler(cfg.moduleType);
/* 61 */     if (handler == null)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     if (!handler.isGoalValid(this.roleId, this.goalId))
/*    */     {
/* 67 */       return false;
/*    */     }
/* 69 */     int xLvAdd = handler.getParam(this.roleId, this.goalId);
/* 70 */     if (xLvAdd < 0)
/*    */     {
/* 72 */       return false;
/*    */     }
/* 74 */     handler.setParam(this.roleId, this.goalId, xLvAdd + realAdd);
/* 75 */     List<GoalParameter> goalParameters = cfg.goalParameters;
/* 76 */     if (goalParameters.size() < 1)
/*    */     {
/* 78 */       return false;
/*    */     }
/* 80 */     int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 81 */     if (count < 0)
/*    */     {
/* 83 */       return false;
/*    */     }
/* 85 */     if (xLvAdd + realAdd >= count)
/*    */     {
/* 87 */       if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*    */       {
/* 89 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\POnRoleLvUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */