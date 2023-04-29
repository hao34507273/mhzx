/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.qingfu.event.CostYuanbaoArg;
/*    */ import mzm.gsp.qingfu.event.CostYuanbaoProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnUserCostYuanbao
/*    */   extends CostYuanbaoProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     String userId = RoleInterface.getUserId(((CostYuanbaoArg)this.arg).roleid);
/* 17 */     long nowYuanBao = QingfuInterface.getBalance(userId, true);
/* 18 */     AbstractConditionalValueChange.Context context1 = new AbstractConditionalValueChange.Context(1, (int)nowYuanBao);
/*    */     
/* 20 */     AchievementManager.updateGoalTypeState(((CostYuanbaoArg)this.arg).roleid, 4702, context1, "POnUserCostYuanbao.processImp@handle OWN_MONEY finish");
/*    */     
/*    */ 
/*    */ 
/* 24 */     AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(1, (int)(((CostYuanbaoArg)this.arg).cost + ((CostYuanbaoArg)this.arg).costBind));
/* 25 */     AchievementManager.updateGoalTypeState(((CostYuanbaoArg)this.arg).roleid, 4701, context, "POnUserCostYuanbao.processImp@handle ACCUMULAT_COST_MONEY finish");
/*    */     
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnUserCostYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */