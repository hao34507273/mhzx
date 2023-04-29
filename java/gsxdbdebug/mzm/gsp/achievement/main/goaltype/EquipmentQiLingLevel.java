/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentQiLingLevel
/*    */   extends AbstractDoneOneEventLevelTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 3005;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 27 */     List<Integer> xQiLinGoalParameter = xAchievementInfo.getGoal_parameters();
/* 28 */     int qiLinGoaLevel = ((Integer)goalParameters.get(1)).intValue();
/*    */     
/* 30 */     Map<Long, Integer> qiLinInfoMap = ItemInterface.getUuid2QiLinLevel(roleId, 1, true);
/*    */     
/* 32 */     int maxQiLinLevel = 0;
/* 33 */     int qiLinsize = 0;
/* 34 */     for (Map.Entry<Long, Integer> entry : qiLinInfoMap.entrySet())
/*    */     {
/* 36 */       int qiLinLevel = ((Integer)entry.getValue()).intValue();
/* 37 */       if (qiLinLevel > maxQiLinLevel)
/*    */       {
/* 39 */         maxQiLinLevel = qiLinLevel > qiLinGoaLevel ? qiLinGoaLevel : qiLinLevel;
/*    */       }
/* 41 */       if (((Integer)entry.getValue()).intValue() >= qiLinLevel)
/*    */       {
/* 43 */         qiLinsize++;
/*    */       }
/*    */     }
/* 46 */     int goalQiLinSize = ((Integer)goalParameters.get(0)).intValue();
/* 47 */     if (qiLinsize > ((Integer)xQiLinGoalParameter.get(0)).intValue())
/*    */     {
/* 49 */       xQiLinGoalParameter.set(0, Integer.valueOf(qiLinsize > goalQiLinSize ? goalQiLinSize : qiLinsize));
/*    */     }
/* 51 */     if (maxQiLinLevel > ((Integer)xQiLinGoalParameter.get(1)).intValue())
/*    */     {
/* 53 */       xQiLinGoalParameter.set(1, Integer.valueOf(maxQiLinLevel));
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\EquipmentQiLingLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */