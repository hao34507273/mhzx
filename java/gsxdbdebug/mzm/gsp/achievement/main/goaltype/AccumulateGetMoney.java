/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class AccumulateGetMoney
/*    */   extends AbstractConditionalDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 4705;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 25 */     int moneyType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*    */     long nowAmount;
/* 27 */     switch (moneyType)
/*    */     {
/*    */     case 1: 
/* 30 */       String userId = RoleInterface.getUserId(roleId);
/* 31 */       if (null == userId)
/*    */       {
/* 33 */         return false;
/*    */       }
/* 35 */       long ownYuanbao = QingfuInterface.getBalance(userId, true);
/* 36 */       long totalSaveAmt = QingfuInterface.getSaveAmt(userId, true);
/* 37 */       nowAmount = Math.max(ownYuanbao, totalSaveAmt);
/* 38 */       break;
/*    */     case 2: 
/* 40 */       nowAmount = RoleInterface.getGold(roleId);
/* 41 */       break;
/*    */     case 3: 
/* 43 */       nowAmount = RoleInterface.getSilver(roleId);
/* 44 */       break;
/*    */     case 4: 
/* 46 */       nowAmount = GangInterface.getHistoryBangGong(roleId);
/* 47 */       break;
/*    */     case 5: 
/* 49 */       nowAmount = RoleInterface.getGoldIngot(roleId);
/* 50 */       break;
/*    */     default: 
/* 52 */       return false;
/*    */     }
/*    */     
/*    */     
/* 56 */     int oldAmount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 57 */     if (oldAmount >= nowAmount)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     int goalAmount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 62 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf((int)Math.min(goalAmount, nowAmount)));
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AccumulateGetMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */