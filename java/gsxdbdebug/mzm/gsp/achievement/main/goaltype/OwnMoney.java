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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OwnMoney
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 4702;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 30 */     int moneyType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*    */     long nowAmount;
/* 32 */     switch (moneyType)
/*    */     {
/*    */     case 1: 
/* 35 */       String userId = RoleInterface.getUserId(roleId);
/* 36 */       if (null == userId)
/*    */       {
/* 38 */         return false;
/*    */       }
/* 40 */       nowAmount = QingfuInterface.getBalance(userId, true);
/* 41 */       break;
/*    */     case 2: 
/* 43 */       nowAmount = RoleInterface.getGold(roleId);
/* 44 */       break;
/*    */     case 3: 
/* 46 */       nowAmount = RoleInterface.getSilver(roleId);
/* 47 */       break;
/*    */     case 4: 
/* 49 */       nowAmount = GangInterface.getBangGong(roleId);
/* 50 */       break;
/*    */     case 5: 
/* 52 */       nowAmount = RoleInterface.getGoldIngot(roleId);
/* 53 */       break;
/*    */     default: 
/* 55 */       return false;
/*    */     }
/*    */     
/*    */     
/* 59 */     int oldAmount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 60 */     if (oldAmount == nowAmount)
/*    */     {
/* 62 */       return false;
/*    */     }
/* 64 */     int goalAmount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 65 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf((int)Math.min(goalAmount, nowAmount)));
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\OwnMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */