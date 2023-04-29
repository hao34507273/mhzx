/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg;
/*    */ import mzm.gsp.qingyunzhi.main.QingInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingYunZhiPass
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 5132;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 28 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 35 */     Context context = (Context)ctx;
/* 36 */     int goalQingId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 37 */     SQingYunZhiCfg qingCfg = SQingYunZhiCfg.get(goalQingId);
/* 38 */     if ((context.type != qingCfg.challengeType) || (context.section != qingCfg.sectionNum) || (context.chapter != qingCfg.chapterNum))
/*    */     {
/*    */ 
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 45 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 46 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 55 */     int goalQingId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 56 */     if (!QingInterface.isPassed(roleId, goalQingId, true))
/*    */     {
/* 58 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 62 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 63 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.max(oldCount, 1)));
/*    */     
/* 65 */     return true;
/*    */   }
/*    */   
/*    */   public static class Context
/*    */   {
/*    */     public final int type;
/*    */     public final int chapter;
/*    */     public final int section;
/*    */     
/*    */     public Context(int type, int chapter, int section)
/*    */     {
/* 76 */       this.type = type;
/* 77 */       this.chapter = chapter;
/* 78 */       this.section = section;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\QingYunZhiPass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */