/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.level.LevelGuideHandle;
/*     */ import mzm.gsp.grow.main.GrowInterface;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*     */ import xbean.LevelGuideInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleLevelGuidesInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LevelGuideManager
/*     */ {
/*  24 */   private static Map<Integer, List<Integer>> type2goalIds = new HashMap();
/*  25 */   private static Set<Integer> functionIds = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void levelGuideInit()
/*     */   {
/*  32 */     for (SLevelTargetCfg sg : SLevelTargetCfg.getAll().values())
/*     */     {
/*  34 */       int goalType = sg.goalType;
/*  35 */       List<Integer> goals = (List)type2goalIds.get(Integer.valueOf(goalType));
/*  36 */       if (goals == null)
/*     */       {
/*  38 */         goals = new ArrayList();
/*  39 */         type2goalIds.put(Integer.valueOf(goalType), goals);
/*     */       }
/*  41 */       goals.add(Integer.valueOf(sg.id));
/*     */       
/*  43 */       if (sg.moduleType == 2)
/*     */       {
/*  45 */         functionIds.add(Integer.valueOf(sg.id));
/*     */       }
/*     */     }
/*  48 */     GrowInterface.registerTarget(1, LevelGuideHandle.getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getFunctionIds()
/*     */   {
/*  56 */     return functionIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void createRoleXData(RoleLevelGuidesInfo roleLevelGuidesInfo)
/*     */   {
/*  66 */     if (roleLevelGuidesInfo == null)
/*     */     {
/*  68 */       return;
/*     */     }
/*  70 */     for (SLevelTargetCfg sg : SLevelTargetCfg.getAll().values())
/*     */     {
/*  72 */       LevelGuideInfo levelGuideInfo = Pod.newLevelGuideInfo();
/*  73 */       levelGuideInfo.setTargetid(sg.id);
/*  74 */       levelGuideInfo.setTargetparam(0);
/*  75 */       levelGuideInfo.setTargetstate(1);
/*     */       
/*  77 */       roleLevelGuidesInfo.getTargets().put(Integer.valueOf(sg.id), levelGuideInfo);
/*     */     }
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
/*     */   static List<Integer> getGoalIdsByType(int goalType)
/*     */   {
/*  91 */     List<Integer> goals = (List)type2goalIds.get(Integer.valueOf(goalType));
/*  92 */     if (goals == null)
/*     */     {
/*  94 */       return new ArrayList();
/*     */     }
/*  96 */     return goals;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGoalCfgExist(int goalId)
/*     */   {
/* 108 */     return SLevelTargetCfg.get(goalId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SLevelTargetCfg getGoalCfg(int goalId)
/*     */   {
/* 119 */     return SLevelTargetCfg.get(goalId);
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
/*     */   static int getGoalType(int goalId)
/*     */   {
/* 132 */     SLevelTargetCfg cfg = getGoalCfg(goalId);
/* 133 */     if (cfg == null)
/*     */     {
/* 135 */       return -1;
/*     */     }
/* 137 */     return cfg.moduleType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getGoalAwardId(int goalId)
/*     */   {
/* 149 */     SLevelTargetCfg sg = SLevelTargetCfg.get(goalId);
/* 150 */     if (sg == null)
/*     */     {
/* 152 */       return -1;
/*     */     }
/* 154 */     return sg.fixAwardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isNeedRoleFinishGoal(RoleLevelGuidesInfo xGuidesInfo, int goalId)
/*     */   {
/* 166 */     if (xGuidesInfo == null)
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     LevelGuideInfo xLevelGuideInfo = (LevelGuideInfo)xGuidesInfo.getTargets().get(Integer.valueOf(goalId));
/* 171 */     if ((xLevelGuideInfo == null) || (xLevelGuideInfo.getTargetstate() != 1))
/*     */     {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean CanGetGoalAward(RoleLevelGuidesInfo xGuidesInfo, int goalId)
/*     */   {
/* 187 */     if (xGuidesInfo == null)
/*     */     {
/* 189 */       return false;
/*     */     }
/* 191 */     LevelGuideInfo xLevelGuideInfo = (LevelGuideInfo)xGuidesInfo.getTargets().get(Integer.valueOf(goalId));
/* 192 */     if ((xLevelGuideInfo == null) || (xLevelGuideInfo.getTargetstate() != 2))
/*     */     {
/* 194 */       return false;
/*     */     }
/* 196 */     return true;
/*     */   }
/*     */   
/*     */   static void checkExtendPetBag()
/*     */   {
/* 201 */     int goalType = 5;
/* 202 */     List<Integer> goals = getGoalIdsByType(goalType);
/* 203 */     if ((goals == null) || (goals.size() != 1))
/*     */     {
/* 205 */       throw new RuntimeException("5601_升级指引总表，[扩充宠物栏]配置的参数不正确！");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getPetTypes(SLevelTargetCfg cfg)
/*     */   {
/* 217 */     List<Integer> petTypes = new ArrayList();
/* 218 */     if (cfg.goalType != 2)
/*     */     {
/* 220 */       return null;
/*     */     }
/*     */     
/* 223 */     List<GoalParameter> parameters = cfg.goalParameters;
/* 224 */     if ((parameters == null) || (parameters.size() == 0))
/*     */     {
/* 226 */       return null;
/*     */     }
/*     */     
/* 229 */     int petType = ((GoalParameter)parameters.get(0)).parameter;
/* 230 */     if ((petType <= 0) || (petType >= 32))
/*     */     {
/* 232 */       return null;
/*     */     }
/*     */     
/* 235 */     if (4 == (0x4 & petType))
/*     */     {
/* 237 */       petTypes.add(Integer.valueOf(2));
/*     */     }
/* 239 */     if (2 == (0x2 & petType))
/*     */     {
/* 241 */       petTypes.add(Integer.valueOf(1));
/*     */     }
/* 243 */     if (1 == (0x1 & petType))
/*     */     {
/* 245 */       petTypes.add(Integer.valueOf(0));
/*     */     }
/* 247 */     if (16 == (0x10 & petType))
/*     */     {
/* 249 */       petTypes.add(Integer.valueOf(3));
/*     */     }
/* 251 */     if (8 == (0x8 & petType))
/*     */     {
/* 253 */       petTypes.add(Integer.valueOf(4));
/*     */     }
/*     */     
/* 256 */     return petTypes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean finishActivity(long roleId, int activityId)
/*     */   {
/* 265 */     return finishActivity(roleId, activityId, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean finishActivity(long roleId, int activityId, int dieMonsterNum)
/*     */   {
/* 274 */     int goalType = 2400;
/* 275 */     List<Integer> goals = getGoalIdsByType(goalType);
/* 276 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/* 278 */       return false;
/*     */     }
/* 280 */     Set<Integer> checkGoals = new HashSet();
/* 281 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId_temp = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 284 */       SLevelTargetCfg cfg_temp = getGoalCfg(goalId_temp);
/* 285 */       if (cfg_temp.goalParameters == null)
/*     */       {
/* 287 */         return false;
/*     */       }
/* 289 */       GoalParameter parameter = (GoalParameter)cfg_temp.goalParameters.get(0);
/* 290 */       if (parameter == null)
/*     */       {
/* 292 */         return false;
/*     */       }
/* 294 */       int activityId_temp = parameter.parameter;
/*     */       
/* 296 */       int instanceId = -1;
/* 297 */       GoalParameter parameter_3 = (GoalParameter)cfg_temp.goalParameters.get(3);
/* 298 */       if (parameter_3 != null)
/*     */       {
/* 300 */         instanceId = parameter_3.parameter;
/*     */       }
/*     */       
/* 303 */       if ((activityId_temp == activityId) || (instanceId == activityId))
/*     */       {
/* 305 */         checkGoals.add(Integer.valueOf(goalId_temp));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 310 */     if (checkGoals.size() == 0)
/*     */     {
/* 312 */       return false;
/*     */     }
/*     */     
/* 315 */     for (Iterator i$ = checkGoals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/* 317 */       new PActivityGoal(roleId, goalId, activityId, dieMonsterNum).execute();
/*     */     }
/* 319 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean shengChanPro(LifeSkillArg arg, int type)
/*     */   {
/* 329 */     int goalType = 1802;
/* 330 */     List<Integer> goals = getGoalIdsByType(goalType);
/* 331 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/* 333 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 386 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/* 388 */       new PShengChanGoal(arg.roleId, goalId, arg, type).execute();
/*     */     }
/*     */     
/* 391 */     return true;
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
/*     */ 
/*     */   static boolean checkLevel(int levelCfg, int level)
/*     */   {
/* 405 */     if ((levelCfg == 0) || (level >= levelCfg))
/*     */     {
/* 407 */       return true;
/*     */     }
/* 409 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static LevelGuideInfo getXInfo(int goalId, RoleLevelGuidesInfo xGuidesInfo)
/*     */   {
/* 421 */     LevelGuideInfo xInfo = (LevelGuideInfo)xGuidesInfo.getTargets().get(Integer.valueOf(goalId));
/* 422 */     if (xInfo == null)
/*     */     {
/* 424 */       xInfo = Pod.newLevelGuideInfo();
/* 425 */       xInfo.setTargetid(goalId);
/* 426 */       xInfo.setTargetstate(1);
/* 427 */       xGuidesInfo.getTargets().put(Integer.valueOf(goalId), xInfo);
/*     */     }
/* 429 */     return xInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\LevelGuideManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */