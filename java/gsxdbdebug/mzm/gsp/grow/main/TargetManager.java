/*     */ package mzm.gsp.grow.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grow.SSynTargetInfo;
/*     */ import mzm.gsp.grow.SSynTargetSchedule;
/*     */ import mzm.gsp.grow.confbean.SEveryDayTargetCfg;
/*     */ import mzm.gsp.grow.confbean.TargetConsts;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DayTargetInfo;
/*     */ import xbean.Pod;
/*     */ 
/*     */ public class TargetManager
/*     */ {
/*  28 */   static Logger logger = Logger.getLogger("target");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  33 */   private static Map<Integer, SEveryDayTargetCfg> target2cfg = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  38 */   private static Map<Integer, Integer> target2activityId = new HashMap();
/*     */   
/*     */   public static Map<Integer, SEveryDayTargetCfg> getTarget2cfg() {
/*  41 */     return target2cfg;
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> getTarget2activityId() {
/*  45 */     return target2activityId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static TargetConsts getTargetConsts()
/*     */   {
/*  53 */     return TargetConsts.getInstance();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initSEveryDayTargetCfg()
/*     */   {
/*  61 */     for (SEveryDayTargetCfg sCfg : SEveryDayTargetCfg.getAll().values()) {
/*  62 */       if (target2cfg.get(Integer.valueOf(sCfg.targetType)) != null) {
/*  63 */         throw new RuntimeException("5600_每日阶段总表，配置了相同的目标任务！");
/*     */       }
/*  65 */       target2cfg.put(Integer.valueOf(sCfg.targetType), sCfg);
/*     */     }
/*     */     
/*  68 */     SEveryDayTargetCfg.getAll().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void check()
/*     */   {
/*  75 */     for (SEveryDayTargetCfg sCfg : target2cfg.values()) {
/*  76 */       int activityId = sCfg.activityId;
/*  77 */       if (activityId > 0)
/*     */       {
/*     */ 
/*  80 */         if (!AwardInterface.hasAwardId(sCfg.awardId)) {
/*  81 */           throw new RuntimeException("5600_每日阶段总表:模板id[" + sCfg.id + "]下 awardId[" + sCfg.awardId + "]不存在！");
/*     */         }
/*  83 */         mzm.gsp.activity.confbean.SActivityCfg aCfg = ActivityInterface.getActivityCfg(activityId);
/*  84 */         if (aCfg == null) {
/*  85 */           throw new RuntimeException("5600_每日阶段总表:模板id[" + sCfg.id + "]下 activityId[" + activityId + "]不存在！");
/*     */         }
/*  87 */         target2activityId.put(Integer.valueOf(sCfg.targetType), Integer.valueOf(activityId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void postinit()
/*     */     throws Exception
/*     */   {}
/*     */   
/*     */ 
/*     */   static int getTargetWeight(int targetType)
/*     */   {
/* 101 */     SEveryDayTargetCfg sCfg = (SEveryDayTargetCfg)target2cfg.get(Integer.valueOf(targetType));
/* 102 */     if (sCfg == null) {
/* 103 */       return -1;
/*     */     }
/* 105 */     return sCfg.weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getTargetAwardIds(int targetType)
/*     */   {
/* 114 */     List<Integer> awardIds = new ArrayList();
/* 115 */     SEveryDayTargetCfg sCfg = (SEveryDayTargetCfg)target2cfg.get(Integer.valueOf(targetType));
/* 116 */     if (sCfg == null) {
/* 117 */       return awardIds;
/*     */     }
/* 119 */     awardIds.add(Integer.valueOf(sCfg.awardId));
/* 120 */     return awardIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTargetNumCfg(int targetType)
/*     */   {
/* 129 */     SEveryDayTargetCfg sCfg = (SEveryDayTargetCfg)target2cfg.get(Integer.valueOf(targetType));
/* 130 */     if (sCfg == null) {
/* 131 */       return -1;
/*     */     }
/* 133 */     return sCfg.num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getRoleCanGetTargets(long roleId)
/*     */   {
/* 143 */     List<Integer> targets = new ArrayList();
/* 144 */     int level = RoleInterface.getLevel(roleId);
/*     */     
/* 146 */     for (SEveryDayTargetCfg sCfg : target2cfg.values()) {
/* 147 */       if ((sCfg.activityId > 0) || (
/*     */       
/* 149 */         (level >= sCfg.levelLow) && (level <= sCfg.levelUp)))
/*     */       {
/*     */ 
/*     */ 
/* 153 */         targets.add(Integer.valueOf(sCfg.targetType)); }
/*     */     }
/* 155 */     return targets;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> ranTargets(List<Integer> ownTaIntegers)
/*     */   {
/* 164 */     if (ownTaIntegers.size() <= getTargetConsts().FLUSH_NUM) {
/* 165 */       return ownTaIntegers;
/*     */     }
/*     */     
/* 168 */     List<Integer> targets = new ArrayList(ownTaIntegers);
/*     */     for (;;) {
/* 170 */       int seed = getTargetSeed(targets);
/* 171 */       if (seed < 0) {
/* 172 */         return null;
/*     */       }
/* 174 */       Random r = xdb.Xdb.random();
/* 175 */       int ran = r.nextInt(seed);
/* 176 */       int targetSelected = selectOneTarget(targets, ran);
/* 177 */       if (targetSelected < 0) {
/* 178 */         return null;
/*     */       }
/* 180 */       Integer needRmTarget = new Integer(targetSelected);
/* 181 */       targets.remove(needRmTarget);
/* 182 */       if (targets.size() == getTargetConsts().FLUSH_NUM) {
/*     */         break;
/*     */       }
/*     */     }
/* 186 */     return targets;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTargetSeed(List<Integer> targets)
/*     */   {
/* 195 */     int seed = 0;
/* 196 */     for (Iterator i$ = targets.iterator(); i$.hasNext();) { int targetType = ((Integer)i$.next()).intValue();
/* 197 */       int single = getTargetWeight(targetType);
/* 198 */       if (single < 0) {
/* 199 */         logger.error("[！不应该出现 ！]不能识别的目标类型：" + targetType);
/*     */       }
/*     */       else
/* 202 */         seed += single;
/*     */     }
/* 204 */     if (seed < 0) {
/* 205 */       logger.error("[！不应该出现 ！]获取目标种子数出错：" + seed);
/*     */     }
/* 207 */     return seed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int selectOneTarget(List<Integer> targets, int ran)
/*     */   {
/* 217 */     int targetSelected = -1;
/* 218 */     int sum = 0;
/* 219 */     for (Iterator i$ = targets.iterator(); i$.hasNext();) { int targetType = ((Integer)i$.next()).intValue();
/* 220 */       int single = getTargetWeight(targetType);
/* 221 */       if (single < 0) {
/* 222 */         logger.error("[！不应该出现 ！]不能识别的目标类型：" + targetType);
/*     */       }
/*     */       else {
/* 225 */         sum += single;
/* 226 */         if (sum >= ran) {
/* 227 */           targetSelected = targetType;
/* 228 */           break;
/*     */         }
/*     */       } }
/* 231 */     if (targetSelected < 0) {
/* 232 */       logger.error("[！不应该出现 ！]随机目标时出错！");
/* 233 */       return -1;
/*     */     }
/* 235 */     return targetSelected;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synTargetSchedule(long roleId, xbean.TargetInfo xTargetInfo)
/*     */   {
/* 244 */     SSynTargetSchedule pro = new SSynTargetSchedule();
/* 245 */     pro.targetparam = xTargetInfo.getTargetparam();
/* 246 */     pro.targetstate = xTargetInfo.getTargetstate();
/*     */     
/*     */ 
/* 249 */     OnlineManager.getInstance().send(roleId, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static DayTargetInfo createXTargetInfo(long roleId, DayTargetInfo xDayTargetInfo)
/*     */   {
/* 259 */     if (xDayTargetInfo != null) {
/* 260 */       return xDayTargetInfo;
/*     */     }
/* 262 */     xDayTargetInfo = Pod.newDayTargetInfo();
/* 263 */     xtable.Role2daytargetinfo.insert(Long.valueOf(roleId), xDayTargetInfo);
/*     */     
/* 265 */     flushNewTarget(roleId, xDayTargetInfo);
/*     */     
/* 267 */     return xDayTargetInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void flushNewTarget(long roleId, DayTargetInfo xDayTargetInfo)
/*     */   {
/* 276 */     xDayTargetInfo.getTargets().clear();
/* 277 */     List<Integer> canGetTargets = getRoleCanGetTargets(roleId);
/* 278 */     if ((canGetTargets == null) || (canGetTargets.size() == 0)) {
/* 279 */       return;
/*     */     }
/* 281 */     List<Integer> realTargets = ranTargets(canGetTargets);
/* 282 */     if ((realTargets == null) || (realTargets.size() == 0)) {
/* 283 */       return;
/*     */     }
/* 285 */     for (Iterator i$ = realTargets.iterator(); i$.hasNext();) { int target = ((Integer)i$.next()).intValue();
/* 286 */       xbean.TargetInfo xTargetInfo = Pod.newTargetInfo();
/* 287 */       xTargetInfo.setTargetparam(0);
/* 288 */       xTargetInfo.setTargetstate(1);
/* 289 */       xTargetInfo.setTargettype(target);
/*     */       
/* 291 */       xDayTargetInfo.getTargets().put(Integer.valueOf(target), xTargetInfo);
/*     */     }
/* 293 */     xDayTargetInfo.setLastcleartime(DateTimeUtils.getCurrTimeInMillis());
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
/*     */   static boolean changeTargetInfo(long roleId, int targetType, xbean.TargetInfo xTargetInfo, int addNum)
/*     */   {
/* 306 */     if ((xTargetInfo.getTargetstate() == 3) || (xTargetInfo.getTargetstate() == 2))
/*     */     {
/* 308 */       return false;
/*     */     }
/*     */     
/* 311 */     int ownNum = xTargetInfo.getTargetparam() + addNum;
/*     */     
/* 313 */     int numCfg = getTargetNumCfg(targetType);
/* 314 */     if (ownNum >= numCfg) {
/* 315 */       ownNum = numCfg;
/* 316 */       xTargetInfo.setTargetstate(2);
/*     */     }
/* 318 */     xTargetInfo.setTargetparam(ownNum);
/*     */     
/* 320 */     synTargetSchedule(roleId, xTargetInfo);
/* 321 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synTargetInfo(long roleId, DayTargetInfo xDayTargetInfo)
/*     */   {
/* 332 */     SSynTargetInfo pro = new SSynTargetInfo();
/* 333 */     for (xbean.TargetInfo xTargetInfo : xDayTargetInfo.getTargets().values()) {
/* 334 */       mzm.gsp.grow.TargetInfo pTargetInfo = new mzm.gsp.grow.TargetInfo();
/* 335 */       pTargetInfo.targetparam = xTargetInfo.getTargetparam();
/* 336 */       pTargetInfo.targetstate = xTargetInfo.getTargetstate();
/*     */       
/*     */ 
/*     */ 
/* 340 */       SEveryDayTargetCfg sCfg = (SEveryDayTargetCfg)getTarget2cfg().get(Integer.valueOf(xTargetInfo.getTargettype()));
/* 341 */       AwardReason reason = new AwardReason(LogReason.EVERY_DAY_TARGET_CHECK_AWARD);
/* 342 */       reason.setJustQuery(true);
/* 343 */       AwardModel awardModel = AwardInterface.getRoleAwardModel(sCfg.awardId, roleId, -1, reason);
/* 344 */       if (awardModel == null) {
/* 345 */         logger.error("玩家[" + RoleInterface.getName(roleId) + "]," + "等级为[" + RoleInterface.getLevel(roleId) + "]获取奖励id[" + sCfg.awardId + "]出错！");
/*     */         
/* 347 */         return;
/*     */       }
/* 349 */       AwardInterface.fillAwardInfoBean(awardModel, pTargetInfo.targetawardbean);
/* 350 */       pro.targets.put(Integer.valueOf(xTargetInfo.getTargettype()), pTargetInfo);
/*     */     }
/* 352 */     OnlineManager.getInstance().send(roleId, pro);
/*     */   }
/*     */   
/*     */   static boolean fillAttach(AwardModel awardModel, MailAttachment attachment) {
/* 356 */     if ((awardModel == null) || (attachment == null)) {
/* 357 */       return false;
/*     */     }
/* 359 */     attachment.setGold((int)awardModel.getGold());
/* 360 */     attachment.setPetExp(awardModel.getPetExp());
/* 361 */     attachment.setRoleExp(awardModel.getRoleExp());
/* 362 */     attachment.setSilver((int)awardModel.getSilver());
/* 363 */     attachment.setBindYuanBao((int)awardModel.getYuanbao());
/* 364 */     attachment.setXiuLianExp(awardModel.getXiuLianExp());
/*     */     
/* 366 */     attachment.addItemMap(awardModel.getItemMap());
/* 367 */     attachment.addTokeMap(awardModel.getTokenMap());
/* 368 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AwardReason getAwardReason(int targetType)
/*     */   {
/* 378 */     return new AwardReason(LogReason.EVERY_DAY_TARGET_AWARD);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\TargetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */