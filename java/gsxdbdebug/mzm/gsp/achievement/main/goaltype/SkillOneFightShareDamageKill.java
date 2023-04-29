/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.SkillResult;
/*    */ import xbean.SkillShareDamageKillInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillOneFightShareDamageKill
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 5134;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 29 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 36 */     if (null == context)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     int targetOccupation = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(3)).parameter;
/* 42 */     if (targetOccupation != RoleInterface.getOccupationId(roleId))
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     SkillResult skillResultData = (SkillResult)context;
/* 48 */     int targetShareDamageType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 49 */     int killNum = 0;
/* 50 */     for (SkillShareDamageKillInfo xSkillShareDamageKillInfo : skillResultData.getSkillandsharedamagekillinfight())
/*    */     {
/* 52 */       if (xSkillShareDamageKillInfo.getSharedamagetype() == targetShareDamageType)
/*    */       {
/* 54 */         killNum++;
/*    */       }
/*    */     }
/*    */     
/* 58 */     int targetNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 59 */     if (targetNum > killNum)
/*    */     {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 65 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldNum + 1));
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightShareDamageKill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */