/*     */ package mzm.gsp.grow.daytarget;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grow.SSynTargetInfo;
/*     */ import mzm.gsp.grow.SSynTargetSchedule;
/*     */ import mzm.gsp.grow.TargetInfo;
/*     */ import mzm.gsp.grow.confbean.SDayTargetCfg;
/*     */ import mzm.gsp.grow.confbean.STDayTargetCfg;
/*     */ import mzm.gsp.grow.confbean.STDayTargetData;
/*     */ import mzm.gsp.grow.confbean.TargetConsts;
/*     */ import mzm.gsp.grow.main.GrowInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TargetData;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DayTargetManager
/*     */ {
/*     */   public static void init() {}
/*     */   
/*     */   static void registerGrow()
/*     */   {
/*  46 */     GrowInterface.registerTarget(4, DayTargetHandle.getInstance());
/*  47 */     ActivityInterface.registerActivityByLogicType(50, new DayTargetActivityHandler());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean validTarget(RoleDayInfo roleDayInfo, int targetId)
/*     */   {
/*  59 */     int state = roleDayInfo.getTargetState(targetId);
/*  60 */     return state == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getTargetParam(RoleDayInfo roleDayInfo, int targetId)
/*     */   {
/*  72 */     return roleDayInfo.getTargetParam(targetId);
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
/*     */   public static boolean setParam(RoleDayInfo roleDayInfo, int targetId, int param)
/*     */   {
/*  85 */     int state = roleDayInfo.getTargetState(targetId);
/*  86 */     if (state != 1)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     if (!roleDayInfo.changeTarget(targetId, state, param))
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     if (!afterSetParam(roleDayInfo, targetId, param, state))
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     return true;
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
/*     */   static boolean afterSetParam(RoleDayInfo roleDayInfo, int targetId, int param, int state)
/*     */   {
/* 112 */     synTargetInfo(roleDayInfo.getRoleId(), targetId, state, param);
/* 113 */     return true;
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
/*     */   static void synTargetInfo(long roleId, int targetId, int state, int param)
/*     */   {
/* 126 */     int showParam = getFinalShowParam(targetId, param);
/* 127 */     if (showParam < 0)
/*     */     {
/* 129 */       return;
/*     */     }
/* 131 */     SSynTargetSchedule pro = new SSynTargetSchedule();
/* 132 */     pro.targetid = targetId;
/* 133 */     pro.targetstate = state;
/* 134 */     pro.targetparam = showParam;
/* 135 */     OnlineManager.getInstance().send(roleId, pro);
/* 136 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 138 */       GameServer.logger().debug(String.format("[dayTarget]DayTargetManager.synTargetInfo@pro info:|roleId=%d|targetId=%d|state=%d|param=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(targetId), Integer.valueOf(state), Integer.valueOf(pro.targetparam) }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getFinalShowParam(int targetId, int xParam)
/*     */   {
/* 156 */     SDayTargetCfg cfg = SDayTargetCfg.get(targetId);
/* 157 */     if (cfg == null)
/*     */     {
/* 159 */       return -1;
/*     */     }
/* 161 */     int num = cfg.num;
/* 162 */     if (xParam < 0)
/*     */     {
/* 164 */       return 0;
/*     */     }
/* 166 */     if (xParam > num)
/*     */     {
/* 168 */       return num;
/*     */     }
/* 170 */     return xParam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAwardId(int targetId)
/*     */   {
/* 181 */     SDayTargetCfg cfg = SDayTargetCfg.get(targetId);
/* 182 */     if (cfg == null)
/*     */     {
/* 184 */       return -1;
/*     */     }
/* 186 */     return cfg.awardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synAllTargets(RoleDayInfo roleDayInfo)
/*     */   {
/* 196 */     SSynTargetInfo pro = new SSynTargetInfo();
/* 197 */     fillPTargets(roleDayInfo.getRoleId(), pro.targets, roleDayInfo.getAllTarget());
/* 198 */     if (pro.targets.size() == 0)
/*     */     {
/* 200 */       return;
/*     */     }
/* 202 */     OnlineManager.getInstance().send(roleDayInfo.getRoleId(), pro);
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
/*     */ 
/*     */ 
/*     */   static void fillPTargets(long roleId, Map<Integer, TargetInfo> pTargets, Map<Integer, TargetData> xTargets)
/*     */   {
/* 218 */     for (TargetData xData : xTargets.values())
/*     */     {
/* 220 */       int showParam = getFinalShowParam(xData.getTargetid(), xData.getTargetparam());
/* 221 */       if (showParam < 0)
/*     */       {
/* 223 */         GameServer.logger().error(String.format("[dayTarget]DayTargetManager.fillPTargets@ get showParam failed!|roleId=%d|targetId=%d|xParam=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xData.getTargetid()), Integer.valueOf(xData.getTargetparam()) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 229 */         TargetInfo pInfo = new TargetInfo();
/* 230 */         pInfo.targetid = xData.getTargetid();
/* 231 */         pInfo.targetparam = showParam;
/* 232 */         pInfo.targetstate = xData.getTargetstate();
/*     */         
/* 234 */         AwardReason reason = new AwardReason(LogReason.EVERY_DAY_TARGET_CHECK_AWARD);
/* 235 */         reason.setJustQuery(true);
/* 236 */         AwardModel awardModel = AwardInterface.getRoleAwardModel(getAwardId(pInfo.targetid), roleId, -1, reason);
/* 237 */         if (awardModel != null)
/*     */         {
/* 239 */           AwardInterface.fillAwardInfoBean(awardModel, pInfo.targetawardbean);
/*     */         }
/*     */         else
/*     */         {
/* 243 */           GameServer.logger().error(String.format("[dayTarget]DayTargetManager.fillPTargets@ no award model!|awardId=%d|roleId=%d|level=%d", new Object[] { Integer.valueOf(getAwardId(pInfo.targetid)), Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 249 */         pTargets.put(Integer.valueOf(pInfo.targetid), pInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void flushNewTargets(RoleDayInfo roleDayInfo, int state)
/*     */   {
/* 260 */     rmXStateTargets(roleDayInfo, state);
/*     */     
/* 262 */     getNewTargets(roleDayInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void getNewTargets(RoleDayInfo roleDayInfo)
/*     */   {
/* 272 */     Map<Integer, TargetData> xTargets = roleDayInfo.getAllTarget();
/* 273 */     int needNum = TargetConsts.getInstance().FLUSH_NUM;
/* 274 */     Iterator i$; if (xTargets.size() < needNum)
/*     */     {
/* 276 */       int flushNum = needNum - xTargets.size();
/* 277 */       List<Integer> newTargets = flushNewTargets(new ArrayList(xTargets.keySet()), RoleInterface.getLevel(roleDayInfo.getRoleId()), flushNum);
/*     */       
/*     */ 
/* 280 */       for (i$ = newTargets.iterator(); i$.hasNext();) { int targetId = ((Integer)i$.next()).intValue();
/*     */         
/* 282 */         roleDayInfo.addTarget(targetId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void rmXStateTargets(RoleDayInfo roleDayInfo, int state)
/*     */   {
/* 289 */     Map<Integer, TargetData> xTargets = roleDayInfo.getAllTarget();
/* 290 */     Iterator<Map.Entry<Integer, TargetData>> it = xTargets.entrySet().iterator();
/* 291 */     while (it.hasNext())
/*     */     {
/* 293 */       Map.Entry<Integer, TargetData> entry = (Map.Entry)it.next();
/* 294 */       TargetData xData = (TargetData)entry.getValue();
/* 295 */       if (xData.getTargetstate() == state)
/*     */       {
/* 297 */         it.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static List<Integer> flushNewTargets(List<Integer> ownIds, int level, int needNum)
/*     */   {
/* 304 */     List<Integer> lastTargets = new ArrayList();
/* 305 */     STDayTargetData cfgData = getLevel2Cfg(level);
/* 306 */     if (cfgData == null)
/*     */     {
/* 308 */       GameServer.logger().error(String.format("[dayTarget]DayTargetManager.flushNewTargets@ no STDayTargetData!|level=%d", new Object[] { Integer.valueOf(level) }));
/*     */       
/* 310 */       return lastTargets;
/*     */     }
/*     */     
/* 313 */     lastTargets.addAll(ranNewTargets(ownIds, needNum, cfgData));
/* 314 */     return lastTargets;
/*     */   }
/*     */   
/*     */   private static List<Integer> ranNewTargets(List<Integer> ownIds, int needNum, STDayTargetData cfgData)
/*     */   {
/* 319 */     List<Integer> lastTargets = new ArrayList();
/* 320 */     int weightSum = initWeightSum(ownIds, cfgData);
/*     */     
/* 322 */     List<Integer> libCopy = new ArrayList(cfgData.cfgIds);
/* 323 */     for (Iterator i$ = ownIds.iterator(); i$.hasNext();) { int ownId = ((Integer)i$.next()).intValue();
/*     */       
/* 325 */       if (libCopy.contains(Integer.valueOf(ownId)))
/*     */       {
/* 327 */         libCopy.remove(new Integer(ownId));
/*     */       }
/*     */     }
/*     */     
/* 331 */     for (int i = 0; i < needNum; i++)
/*     */     {
/* 333 */       if (weightSum <= 0) {
/*     */         break;
/*     */       }
/*     */       
/* 337 */       Random random = Xdb.random();
/* 338 */       int ran = random.nextInt(weightSum);
/* 339 */       int sum = 0;
/*     */       
/* 341 */       Iterator<Integer> it = libCopy.iterator();
/* 342 */       while (it.hasNext())
/*     */       {
/* 344 */         int tarId = ((Integer)it.next()).intValue();
/* 345 */         int weight = SDayTargetCfg.get(tarId).weight;
/* 346 */         sum += weight;
/* 347 */         if (sum > ran)
/*     */         {
/* 349 */           lastTargets.add(Integer.valueOf(tarId));
/* 350 */           weightSum -= weight;
/* 351 */           it.remove();
/* 352 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 356 */     return lastTargets;
/*     */   }
/*     */   
/*     */   static int initWeightSum(List<Integer> ownIds, STDayTargetData cfgData)
/*     */   {
/* 361 */     int weightSum = cfgData.weightSum;
/*     */     
/* 363 */     for (Iterator i$ = ownIds.iterator(); i$.hasNext();) { int tarId_0 = ((Integer)i$.next()).intValue();
/*     */       
/* 365 */       if (cfgData.cfgIds.contains(Integer.valueOf(tarId_0)))
/*     */       {
/*     */ 
/*     */ 
/* 369 */         int weight = SDayTargetCfg.get(tarId_0).weight;
/* 370 */         weightSum -= weight;
/*     */       } }
/* 372 */     return weightSum;
/*     */   }
/*     */   
/*     */   static STDayTargetData getLevel2Cfg(int level)
/*     */   {
/* 377 */     STDayTargetData cfgData = null;
/* 378 */     for (STDayTargetCfg cfg : STDayTargetCfg.getAll().values())
/*     */     {
/* 380 */       int lvLow = cfg.levelLow;
/* 381 */       if (level >= lvLow)
/*     */       {
/*     */ 
/*     */ 
/* 385 */         int lvUp = -1;
/* 386 */         Map<Integer, STDayTargetData> lvUp2Data = cfg.lvUp2Data;
/* 387 */         for (Iterator i$ = lvUp2Data.keySet().iterator(); i$.hasNext();) { int lvUpTmp = ((Integer)i$.next()).intValue();
/*     */           
/* 389 */           if (level <= lvUpTmp)
/*     */           {
/*     */ 
/*     */ 
/* 393 */             lvUp = lvUpTmp;
/*     */           }
/*     */         }
/* 396 */         cfgData = (STDayTargetData)cfg.lvUp2Data.get(Integer.valueOf(lvUp));
/*     */       }
/*     */     }
/* 399 */     return cfgData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getDayTargetOpenLv()
/*     */   {
/* 409 */     return TargetConsts.getInstance().OPEN_LEVEL;
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
/*     */   static boolean needOpenDayTarget(int newLv, int oldLv)
/*     */   {
/* 423 */     int openLv = getDayTargetOpenLv();
/* 424 */     if (newLv < openLv)
/*     */     {
/* 426 */       return false;
/*     */     }
/* 428 */     if (oldLv > openLv)
/*     */     {
/* 430 */       return false;
/*     */     }
/* 432 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isDayTargetOpen(long roleId, boolean isSend)
/*     */   {
/* 442 */     if (!OpenInterface.getOpenStatus(134))
/*     */     {
/* 444 */       if (isSend)
/*     */       {
/* 446 */         OpenInterface.sendCloseProtocol(roleId, 134, null);
/*     */       }
/* 448 */       return false;
/*     */     }
/* 450 */     if (OpenInterface.isBanPlay(roleId, 134))
/*     */     {
/* 452 */       if (isSend)
/*     */       {
/* 454 */         OpenInterface.sendBanPlayMsg(roleId, 134);
/*     */       }
/* 456 */       return false;
/*     */     }
/* 458 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\DayTargetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */