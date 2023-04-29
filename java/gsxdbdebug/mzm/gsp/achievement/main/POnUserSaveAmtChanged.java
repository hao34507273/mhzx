/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractAccumulate.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ 
/*    */ public class POnUserSaveAmtChanged
/*    */   extends SaveAmtChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     String userId = ((SaveAmtChangedArg)this.arg).userid;
/* 17 */     long roleId = QingfuInterface.getSuitableRoleId(userId);
/*    */     
/*    */ 
/* 20 */     AchievementManager.updateGoalTypeState(roleId, 4600, Integer.valueOf(1), "POnUserSaveAmtChanged.processImp@handle ROLE_BUY_YUAN_BAO success");
/*    */     
/*    */ 
/*    */ 
/* 24 */     AbstractAccumulate.Context context = new AbstractAccumulate.Context((int)((SaveAmtChangedArg)this.arg).oldSaveAmt, (int)(((SaveAmtChangedArg)this.arg).currSaveAmt - ((SaveAmtChangedArg)this.arg).oldSaveAmt));
/*    */     
/* 26 */     AchievementManager.updateGoalTypeState(roleId, 4601, context, "POnUserSaveAmtChanged.processImp@handle ACCUMULAT_BUY_YUAN_BAO success");
/*    */     
/*    */ 
/*    */ 
/* 30 */     int nowYuanBao = (int)QingfuInterface.getBalance(((SaveAmtChangedArg)this.arg).userid, true);
/* 31 */     AbstractConditionalValueChange.Context context1 = new AbstractConditionalValueChange.Context(1, nowYuanBao);
/*    */     
/* 33 */     AchievementManager.updateGoalTypeState(roleId, 4702, context1, "POnUserSaveAmtChanged.processImp@handle OWN_MONEY finish");
/*    */     
/*    */ 
/*    */ 
/* 37 */     int changeYuanBao = (int)(((SaveAmtChangedArg)this.arg).currSaveAmt - ((SaveAmtChangedArg)this.arg).oldSaveAmt);
/* 38 */     AbstractConditionalDoneOneEventTimes.Context context2 = new AbstractConditionalDoneOneEventTimes.Context(1, changeYuanBao);
/*    */     
/*    */ 
/* 41 */     AchievementManager.updateGoalTypeState(roleId, 4705, context2, "POnUserSaveAmtChanged.processImp@handle ACCUMULAT_GET_MONEY finish");
/*    */     
/*    */ 
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */