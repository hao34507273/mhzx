/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.SkillMirrorFighterInfo;
/*    */ import xbean.SkillMirrorInfo;
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillOneFightMirrorOccupationNum
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5135;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 30 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 38 */     if (null == context)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 44 */     SkillResult skillResultData = (SkillResult)context;
/* 45 */     SkillMirrorInfo xSkillMirrorInfo = (SkillMirrorInfo)skillResultData.getSkillmirrorinfoinfight().get(Integer.valueOf(goalSkillId));
/* 46 */     if (null == xSkillMirrorInfo)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     Set<Integer> mirrorOccupations = new HashSet(8);
/* 52 */     for (SkillMirrorFighterInfo xSkillMirrorFighterInfo : xSkillMirrorInfo.getTargets())
/*    */     {
/* 54 */       mirrorOccupations.add(Integer.valueOf(xSkillMirrorFighterInfo.getOcp()));
/*    */     }
/*    */     
/* 57 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 58 */     if (mirrorOccupations.size() < goalNum)
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 64 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldNum + 1));
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightMirrorOccupationNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */