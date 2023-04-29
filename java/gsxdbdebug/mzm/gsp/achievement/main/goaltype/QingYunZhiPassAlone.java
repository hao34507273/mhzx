/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingYunZhiPassAlone
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 5110;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 34 */     Context context = (Context)ctx;
/* 35 */     int goalQingId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 36 */     SQingYunZhiCfg qingCfg = SQingYunZhiCfg.get(goalQingId);
/* 37 */     if ((context.type != qingCfg.challengeType) || (context.section != qingCfg.sectionNum) || (context.chapter != qingCfg.chapterNum))
/*    */     {
/*    */ 
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 45 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 47 */     return true;
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
/* 58 */       this.type = type;
/* 59 */       this.chapter = chapter;
/* 60 */       this.section = section;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\QingYunZhiPassAlone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */