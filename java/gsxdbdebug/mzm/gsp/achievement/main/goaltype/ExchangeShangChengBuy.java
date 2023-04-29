/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExchangeShangChengBuy
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 1505;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 24 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 32 */     Context context = (Context)ctx;
/* 33 */     int goalMallType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 34 */     int mallType = getAchievementMallType(context.mallType);
/* 35 */     if ((goalMallType & mallType) == 0)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 42 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 43 */     int newTimes = oldTimes + 1;
/* 44 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalTimes, newTimes)));
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   private final int getAchievementMallType(int mallType)
/*    */   {
/* 50 */     switch (mallType)
/*    */     {
/*    */     case 1: 
/* 53 */       return 1;
/*    */     case 2: 
/* 55 */       return 2;
/*    */     case 3: 
/* 57 */       return 4;
/*    */     case 4: 
/* 59 */       return 8;
/*    */     }
/* 61 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int mallType;
/*    */     
/*    */     public final int num;
/*    */     
/*    */ 
/*    */     public Context(int mallType, int num)
/*    */     {
/* 75 */       this.mallType = mallType;
/* 76 */       this.num = num;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ExchangeShangChengBuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */