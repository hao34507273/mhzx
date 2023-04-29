/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetColorEquipment
/*     */   extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  21 */     return 3004;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*     */   {
/*  35 */     List<Integer> colorList = getNeedEquipmentColor(sAchievementGoalCfg);
/*  36 */     if (colorList == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     int roleEquipCount = ItemInterface.getEquipCoulorCount(roleId, colorList, true);
/*     */     
/*  42 */     int goalEquipCount = ((Integer)goalParameters.get(0)).intValue();
/*  43 */     int oldEquipCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  44 */     if (oldEquipCount == roleEquipCount)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (oldEquipCount < roleEquipCount)
/*     */     {
/*  50 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalEquipCount, roleEquipCount)));
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*     */   {
/*  60 */     Context context = (Context)ctx;
/*  61 */     int validNum = context.getValidEquipNum(sAchievementGoalCfg);
/*  62 */     if (validNum == 0)
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  68 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  69 */     int newTimes = oldTimes + validNum;
/*  70 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalTimes, newTimes)));
/*     */     
/*  72 */     return true;
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
/*     */   public static List<Integer> getNeedEquipmentColor(SAchievementGoalCfg cfg)
/*     */   {
/*  85 */     List<Integer> itemTypes = new ArrayList();
/*  86 */     if (cfg.goalType != 3004)
/*     */     {
/*  88 */       return null;
/*     */     }
/*     */     
/*  91 */     List<GoalParameter> parameters = cfg.goalParameters;
/*  92 */     if ((parameters == null) || (parameters.size() == 0))
/*     */     {
/*  94 */       return null;
/*     */     }
/*     */     
/*  97 */     int equipmentColor = ((GoalParameter)parameters.get(0)).parameter;
/*  98 */     if ((equipmentColor <= 0) || (equipmentColor >= 32))
/*     */     {
/* 100 */       return null;
/*     */     }
/*     */     
/* 103 */     if (1 == (0x1 & equipmentColor))
/*     */     {
/* 105 */       itemTypes.add(Integer.valueOf(1));
/*     */     }
/*     */     
/* 108 */     if (2 == (0x2 & equipmentColor))
/*     */     {
/* 110 */       itemTypes.add(Integer.valueOf(2));
/*     */     }
/*     */     
/* 113 */     if (4 == (0x4 & equipmentColor))
/*     */     {
/* 115 */       itemTypes.add(Integer.valueOf(3));
/*     */     }
/*     */     
/* 118 */     if (8 == (0x8 & equipmentColor))
/*     */     {
/* 120 */       itemTypes.add(Integer.valueOf(4));
/*     */     }
/*     */     
/* 123 */     if (16 == (0x10 & equipmentColor))
/*     */     {
/* 125 */       itemTypes.add(Integer.valueOf(5));
/*     */     }
/*     */     
/* 128 */     return itemTypes;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class Context
/*     */   {
/*     */     private final Map<Integer, Integer> itemChangeMap;
/*     */     
/*     */     public Context(Map<Integer, Integer> itemChangeMap)
/*     */     {
/* 138 */       this.itemChangeMap = itemChangeMap;
/*     */     }
/*     */     
/*     */     public int getValidEquipNum(SAchievementGoalCfg cfg)
/*     */     {
/* 143 */       int result = 0;
/* 144 */       for (Map.Entry<Integer, Integer> item2NumEntry : this.itemChangeMap.entrySet())
/*     */       {
/* 146 */         int itemid = ((Integer)item2NumEntry.getKey()).intValue();
/* 147 */         if ((ItemInterface.isEquipItem(itemid)) && (GetColorEquipment.getNeedEquipmentColor(cfg).contains(Integer.valueOf(ItemInterface.getColor(itemid)))))
/*     */         {
/* 149 */           result += ((Integer)item2NumEntry.getValue()).intValue();
/*     */         }
/*     */       }
/* 152 */       return result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\GetColorEquipment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */