/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetLearnSkill
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 6;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 23 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 30 */     int skillBookCfgId = ((Integer)context).intValue();
/* 31 */     int bookPhase = SPetSkillBookCfg.get(skillBookCfgId).itemPhase;
/* 32 */     int goalPhase = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 33 */     if ((goalPhase != 0) && (bookPhase != goalPhase))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 39 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetLearnSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */