/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.fabao.main.FabaoInterface;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FaBaoSpecificStar
/*     */   extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  28 */     return 4203;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  34 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*     */   {
/*  42 */     int goalFabaoType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  43 */     int goalStarRank = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  44 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/*     */     
/*     */ 
/*  47 */     int nowCount = 0;
/*  48 */     Map<Integer, Integer> fabaoCfgMap = FabaoInterface.getEquipFabaoCfgIds(roleId, true);
/*  49 */     for (Iterator i$ = fabaoCfgMap.values().iterator(); i$.hasNext();) { int fabaoCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  51 */       if (isValidFabao(goalFabaoType, goalStarRank, fabaoCfgId))
/*     */       {
/*  53 */         nowCount++;
/*     */       }
/*     */     }
/*  56 */     RoleItemBag fabaoBag = ItemInterface.getRoleFaBaoBag(roleId);
/*  57 */     if (null == fabaoBag)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     Map<Integer, BasicItem> itemMap = fabaoBag.getAllItems(false);
/*  62 */     for (BasicItem item : itemMap.values())
/*     */     {
/*  64 */       if (isValidFabao(goalFabaoType, goalStarRank, item.getCfgId()))
/*     */       {
/*  66 */         nowCount++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  71 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  72 */     if (oldCount == nowCount)
/*     */     {
/*  74 */       return false;
/*     */     }
/*  76 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, nowCount)));
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*     */   {
/*  85 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isValidFabao(int goalFabaoType, int goalFabaoRank, int fabaoCfgId)
/*     */   {
/*  98 */     SFabaoItem fabaoCfg = SFabaoItem.get(fabaoCfgId);
/*     */     
/* 100 */     if (null == fabaoCfg)
/*     */     {
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if ((goalFabaoType != 0) && (goalFabaoType != fabaoCfg.classid))
/*     */     {
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (goalFabaoRank > fabaoCfg.rank)
/*     */     {
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FaBaoSpecificStar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */