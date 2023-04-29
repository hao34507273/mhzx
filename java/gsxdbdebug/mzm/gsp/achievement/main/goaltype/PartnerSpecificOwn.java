/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class PartnerSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 603;
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
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 31 */     List<Integer> goalPartnerIds = new LinkedList();
/* 32 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 34 */       int parameter = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 35 */       if (parameter != 0)
/*    */       {
/* 37 */         goalPartnerIds.add(Integer.valueOf(parameter));
/*    */       }
/*    */     }
/*    */     
/* 41 */     if (!goalPartnerIds.contains((Integer)context))
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 47 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 55 */     List<Integer> goalPartnerIds = new LinkedList();
/* 56 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 58 */       int parameter = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 59 */       if (parameter != 0)
/*    */       {
/* 61 */         goalPartnerIds.add(Integer.valueOf(parameter));
/*    */       }
/*    */     }
/* 64 */     int nowCount = getOwnPartnerCount(roleId, goalPartnerIds);
/* 65 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/*    */     
/* 67 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(nowCount, goalCount)));
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   private int getOwnPartnerCount(long roleId, Collection<Integer> goalPartnerIds)
/*    */   {
/* 73 */     int res = 0;
/* 74 */     for (Iterator i$ = goalPartnerIds.iterator(); i$.hasNext();) { int partnerCfgId = ((Integer)i$.next()).intValue();
/*    */       
/* 76 */       if (PartnerInterface.ownPartner(roleId, partnerCfgId))
/*    */       {
/* 78 */         res++;
/*    */       }
/*    */     }
/* 81 */     return res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PartnerSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */