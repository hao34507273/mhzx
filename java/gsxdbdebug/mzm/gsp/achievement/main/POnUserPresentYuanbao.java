/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.qingfu.event.PresentYuanbaoArg;
/*    */ import mzm.gsp.qingfu.event.PresentYuanbaoProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnUserPresentYuanbao
/*    */   extends PresentYuanbaoProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     String userId = RoleInterface.getUserId(((PresentYuanbaoArg)this.arg).roleid);
/* 17 */     long nowYuanBao = QingfuInterface.getBalance(userId, true);
/* 18 */     AbstractConditionalValueChange.Context context1 = new AbstractConditionalValueChange.Context(1, (int)nowYuanBao);
/*    */     
/* 20 */     AchievementManager.updateGoalTypeState(((PresentYuanbaoArg)this.arg).roleid, 4702, context1, "POnUserPresentYuanbao.processImp@handle OWN_MONEY finish");
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 25 */     int changeYuanBao = (int)(((PresentYuanbaoArg)this.arg).present - ((PresentYuanbaoArg)this.arg).oldTotalPresent + (((PresentYuanbaoArg)this.arg).presentBind - ((PresentYuanbaoArg)this.arg).oldTotalPresentBind));
/* 26 */     AbstractConditionalDoneOneEventTimes.Context context2 = new AbstractConditionalDoneOneEventTimes.Context(1, changeYuanBao);
/*    */     
/*    */ 
/* 29 */     AchievementManager.updateGoalTypeState(((PresentYuanbaoArg)this.arg).roleid, 4705, context2, "POnUserPresentYuanbao.processImp@handle ACCUMULAT_GET_MONEY finish");
/*    */     
/*    */ 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnUserPresentYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */