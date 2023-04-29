/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactCfg;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactClassTable;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactConsts;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactPropertyTable;
/*     */ import mzm.gsp.item.confbean.SFabaoArtifactItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ import xbean.FabaoArtifactSessionInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2fabao_artifact;
/*     */ import xtable.Role2fabao_artifact_session;
/*     */ 
/*     */ class FabaoArtifactManager
/*     */ {
/*  31 */   private static final Logger logger = Logger.getLogger("fabaolingqi");
/*     */   private static final String TLOG_UNLOCK = "UnlockFabaoArtifact";
/*     */   
/*  34 */   static void info(String str, Object... args) { logger.info(String.format("[FabaoArtifact]" + str, args)); }
/*     */   
/*     */   static void error(String str, Object... args)
/*     */   {
/*  38 */     logger.error(String.format("[FabaoArtifact]" + str, args));
/*     */   }
/*     */   
/*     */   private static final String TLOG_EXTEND = "ExtendFabaoArtifact";
/*     */   private static final String TLOG_EXPIRE = "FabaoArtifactExpired";
/*     */   private static final String TLOG_EQUIP = "EquipFabaoArtifact";
/*     */   static boolean isEnable()
/*     */   {
/*  46 */     return OpenInterface.getOpenStatus(358);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void tlog(long roleId, String logName, Object... args)
/*     */   {
/*  54 */     String userId = RoleInterface.getUserId(roleId);
/*  55 */     if (userId == null)
/*  56 */       return;
/*  57 */     List<Object> list = new ArrayList();
/*  58 */     list.add(mzm.gsp.GameServerInfoManager.getHostIP());
/*  59 */     list.add(userId);
/*  60 */     list.add(Long.valueOf(roleId));
/*  61 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/*  62 */     Collections.addAll(list, args);
/*  63 */     TLogManager.getInstance().addLog(userId, logName, list.toArray());
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogUnlock(long roleId, int artifactClassId, int artifactLevel)
/*     */   {
/*  69 */     tlog(roleId, "UnlockFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(artifactLevel) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogExtend(long roleId, int artifactClassId, int duration, int expireTime)
/*     */   {
/*  75 */     tlog(roleId, "ExtendFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(duration), Integer.valueOf(expireTime) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogExpire(long roleId, int artifactClassId, int expireTime)
/*     */   {
/*  81 */     tlog(roleId, "FabaoArtifactExpired", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(expireTime) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogEquip(long roleId, int artifactClassId)
/*     */   {
/*  87 */     tlog(roleId, "EquipFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogUnequip(long roleId, int artifactClassId)
/*     */   {
/*  93 */     tlog(roleId, "UnequipFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogImprove(long roleId, int artifactClassId, int propertyType, int propertyValue)
/*     */   {
/*  99 */     tlog(roleId, "ImproveFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(propertyType), Integer.valueOf(propertyValue) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogUpgrade(long roleId, int artifactClassId, int artifactLevel, int artifactExp)
/*     */   {
/* 105 */     tlog(roleId, "UpgradeFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(artifactExp) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogRemove(long roleId, int artifactClassId, int duration, int exp)
/*     */   {
/* 111 */     tlog(roleId, "RemoveFabaoArtifact", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(duration), Integer.valueOf(exp) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void setTlogRemoveProperty(long roleId, int artifactClassId, int propertyType, int oldValue, int newValue)
/*     */   {
/* 118 */     tlog(roleId, "RemoveFabaoArtifactProperty", new Object[] { Integer.valueOf(artifactClassId), Integer.valueOf(propertyType), Integer.valueOf(oldValue), Integer.valueOf(newValue) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SFabaoArtifactCfg getArtifactCfg(int artifactClassId, int artifactLevel)
/*     */   {
/* 126 */     SFabaoArtifactClassTable classTable = SFabaoArtifactClassTable.get(artifactClassId);
/* 127 */     if (classTable == null)
/* 128 */       return null;
/* 129 */     Integer artifactCfgId = (Integer)classTable.level2cfgId.get(Integer.valueOf(artifactLevel));
/* 130 */     if (artifactCfgId == null)
/* 131 */       return null;
/* 132 */     return SFabaoArtifactCfg.get(artifactCfgId.intValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTotalUpgradeExp(int artifactClassId, int artifactLevel)
/*     */   {
/* 140 */     SFabaoArtifactClassTable classTable = SFabaoArtifactClassTable.get(artifactClassId);
/* 141 */     if (classTable == null)
/* 142 */       return -1;
/* 143 */     Integer totalExp = (Integer)classTable.level2exp.get(Integer.valueOf(artifactLevel));
/* 144 */     return totalExp == null ? 0 : totalExp.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTopLevelUpgradeExp(int artifactClassId)
/*     */   {
/* 152 */     Map<Integer, Integer> level2exp = getLevel2upgradeExpMap(artifactClassId);
/* 153 */     if (level2exp == null) {
/* 154 */       return 0;
/*     */     }
/* 156 */     if (!level2exp.containsKey(Integer.valueOf(1))) {
/* 157 */       return 0;
/*     */     }
/* 159 */     int i = 1;
/* 160 */     while (level2exp.containsKey(Integer.valueOf(i + 1)))
/* 161 */       i++;
/* 162 */     return ((Integer)level2exp.get(Integer.valueOf(i))).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getLevel2cfgIdMap(int artifactClassId)
/*     */   {
/* 170 */     SFabaoArtifactClassTable classTable = SFabaoArtifactClassTable.get(artifactClassId);
/* 171 */     return classTable == null ? null : classTable.level2cfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getLevel2upgradeExpMap(int artifactClassId)
/*     */   {
/* 179 */     SFabaoArtifactClassTable classTable = SFabaoArtifactClassTable.get(artifactClassId);
/* 180 */     return classTable == null ? null : classTable.level2exp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getLevelAfterUpgraded(int artifactClassId, int exp)
/*     */   {
/* 188 */     Map<Integer, Integer> level2exp = getLevel2upgradeExpMap(artifactClassId);
/* 189 */     if (level2exp == null) {
/* 190 */       return 0;
/*     */     }
/* 192 */     int i = 0;
/* 193 */     while ((level2exp.containsKey(Integer.valueOf(i + 1))) && (exp >= ((Integer)level2exp.get(Integer.valueOf(i + 1))).intValue()))
/* 194 */       i++;
/* 195 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SFabaoArtifactPropertyTable getPropertyTable(int artifactClassId, int artifactLevel)
/*     */   {
/* 203 */     Map<Integer, Integer> level2cfgId = getLevel2cfgIdMap(artifactClassId);
/* 204 */     if (level2cfgId == null)
/* 205 */       return null;
/* 206 */     Integer artifactCfgId = (Integer)level2cfgId.get(Integer.valueOf(artifactLevel));
/* 207 */     if (artifactCfgId == null)
/* 208 */       return null;
/* 209 */     return SFabaoArtifactPropertyTable.get(artifactCfgId.intValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static FabaoArtifactRecords getRecords(long roleId, boolean holdRolelock)
/*     */   {
/* 217 */     return holdRolelock ? Role2fabao_artifact.get(Long.valueOf(roleId)) : Role2fabao_artifact.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static FabaoArtifactRecords getOrCreateRecords(long roleId)
/*     */   {
/* 225 */     FabaoArtifactRecords xRecords = Role2fabao_artifact.get(Long.valueOf(roleId));
/* 226 */     if (xRecords != null)
/* 227 */       return xRecords;
/* 228 */     xRecords = Pod.newFabaoArtifactRecords();
/* 229 */     xRecords.setEquipped_artifact_class(0);
/* 230 */     Role2fabao_artifact.insert(Long.valueOf(roleId), xRecords);
/* 231 */     return xRecords;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static FabaoArtifactSessionInfo getSessionInfo(long roleId, boolean holdRolelock)
/*     */   {
/* 239 */     return holdRolelock ? Role2fabao_artifact_session.get(Long.valueOf(roleId)) : Role2fabao_artifact_session.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static FabaoArtifactSessionInfo getOrCreateSessionInfo(long roleId)
/*     */   {
/* 247 */     FabaoArtifactSessionInfo xSessionInfo = Role2fabao_artifact_session.get(Long.valueOf(roleId));
/* 248 */     if (xSessionInfo != null)
/* 249 */       return xSessionInfo;
/* 250 */     xSessionInfo = Pod.newFabaoArtifactSessionInfo();
/* 251 */     Role2fabao_artifact_session.insert(Long.valueOf(roleId), xSessionInfo);
/* 252 */     return xSessionInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean hasArtifact(FabaoArtifactRecords xRecords, int artifactClassId)
/*     */   {
/* 260 */     return (xRecords != null) && (xRecords.getRecords().containsKey(Integer.valueOf(artifactClassId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeExpiredArtifacts(long roleId, FabaoArtifactRecords xRecords)
/*     */   {
/* 268 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 269 */     HashMap<Integer, FabaoArtifactRecord> removedRecords = new HashMap();
/*     */     
/* 271 */     for (Map.Entry<Integer, FabaoArtifactRecord> e : xRecords.getRecords().entrySet())
/* 272 */       if ((((FabaoArtifactRecord)e.getValue()).getExpire_time() != 0) && (((FabaoArtifactRecord)e.getValue()).getExpire_time() <= now))
/* 273 */         removedRecords.put(e.getKey(), e.getValue());
/* 274 */     if (removedRecords.size() == 0) {
/* 275 */       return;
/*     */     }
/* 277 */     for (Map.Entry<Integer, FabaoArtifactRecord> e : removedRecords.entrySet())
/*     */     {
/* 279 */       xRecords.getRecords().remove(e.getKey());
/* 280 */       tlogExpire(roleId, ((Integer)e.getKey()).intValue(), ((FabaoArtifactRecord)e.getValue()).getExpire_time());
/*     */     }
/*     */     
/* 283 */     if (removedRecords.keySet().contains(Integer.valueOf(xRecords.getEquipped_artifact_class())))
/*     */     {
/* 285 */       xRecords.setEquipped_artifact_class(0);
/* 286 */       FabaoArtifactEvents.triggerEquipArtifactEvent(roleId, false, true);
/*     */     }
/*     */     
/* 289 */     for (Map.Entry<Integer, FabaoArtifactRecord> e : removedRecords.entrySet())
/* 290 */       sendExpireMail(roleId, ((Integer)e.getKey()).intValue(), ((FabaoArtifactRecord)e.getValue()).getExpire_time());
/* 291 */     FabaoArtifactEvents.triggerArtifactExpireEvent(roleId, removedRecords.keySet());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendExpireMail(long roleId, int artifactCfgId, int expireTime)
/*     */   {
/* 299 */     SFabaoArtifactCfg artifactCfg = SFabaoArtifactCfg.get(artifactCfgId);
/* 300 */     if (artifactCfg == null)
/* 301 */       return;
/* 302 */     int mailId = SFabaoArtifactConsts.getInstance().EXPIRE_MAIL_ID;
/* 303 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.FABAO_ARTIFACT_EXPIRED);
/* 304 */     ArrayList<String> contentArgs = new ArrayList();
/* 305 */     contentArgs.add(artifactCfg.name);
/* 306 */     StringBuilder sb = new StringBuilder(DateTimeUtils.formatTimestamp(expireTime * 1000L));
/* 307 */     contentArgs.add(sb.substring(0, 4));
/* 308 */     contentArgs.add(sb.substring(4, 6));
/* 309 */     contentArgs.add(sb.substring(6, 8));
/* 310 */     contentArgs.add(sb.substring(8, 10));
/* 311 */     contentArgs.add(sb.substring(10, 12));
/* 312 */     contentArgs.add(sb.substring(12, 14));
/* 313 */     mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(roleId, mailId, null, contentArgs, tLogArg);
/*     */   }
/*     */   
/*     */   private static final String TLOG_UNEQUIP = "UnequipFabaoArtifact";
/*     */   private static final String TLOG_IMPROVE = "ImproveFabaoArtifact";
/*     */   private static final String TLOG_UPGRADE = "UpgradeFabaoArtifact";
/*     */   private static final String TLOG_REMOVE = "RemoveFabaoArtifact";
/*     */   private static final String TLOG_REMOVE_PROPERTY = "RemoveFabaoArtifactProperty";
/*     */   @Deprecated
/*     */   static int removeArtifactByItem(long roleId, int artifactItemId)
/*     */   {
/* 324 */     SFabaoArtifactItemCfg artifactItemCfg = SFabaoArtifactItemCfg.get(artifactItemId);
/* 325 */     if (artifactItemCfg == null)
/*     */     {
/* 327 */       return -1;
/*     */     }
/* 329 */     SFabaoArtifactCfg artifactCfg = SFabaoArtifactCfg.get(artifactItemCfg.artifactCfgId);
/* 330 */     if (artifactCfg == null)
/*     */     {
/* 332 */       return -1;
/*     */     }
/* 334 */     FabaoArtifactRecords xRecords = getRecords(roleId, true);
/* 335 */     if (xRecords == null)
/*     */     {
/* 337 */       return -1;
/*     */     }
/* 339 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(artifactCfg.classId));
/* 340 */     if (xRecord == null)
/*     */     {
/* 342 */       return -1;
/*     */     }
/*     */     boolean changeExpireTimeOnly;
/*     */     boolean changeExpireTimeOnly;
/* 346 */     if (artifactItemCfg.validDuration != 0)
/*     */     {
/* 348 */       int newExpireTime = xRecord.getExpire_time() - (int)(artifactItemCfg.validDuration * 3600L);
/*     */       
/* 350 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 351 */       changeExpireTimeOnly = newExpireTime > now;
/*     */     }
/*     */     else
/*     */     {
/* 355 */       changeExpireTimeOnly = false;
/*     */     }
/*     */     
/* 358 */     if (changeExpireTimeOnly)
/*     */     {
/* 360 */       int newExpireTime = xRecord.getExpire_time() - (int)(artifactItemCfg.validDuration * 3600L);
/*     */       
/* 362 */       xRecord.setExpire_time(newExpireTime);
/* 363 */       FabaoArtifactSessionInfo xSessionInfo = getOrCreateSessionInfo(roleId);
/* 364 */       FabaoArtifactExpireSession.restartSession(roleId, xSessionInfo, artifactCfg.classId, newExpireTime);
/*     */     }
/*     */     else
/*     */     {
/* 368 */       xRecords.getRecords().remove(Integer.valueOf(artifactCfg.classId));
/* 369 */       if (artifactCfg.classId == xRecords.getEquipped_artifact_class())
/*     */       {
/* 371 */         xRecords.setEquipped_artifact_class(0);
/* 372 */         FabaoArtifactEvents.triggerEquipArtifactEvent(roleId, false, true);
/*     */       }
/* 374 */       FabaoArtifactSessionInfo xSessionInfo = getSessionInfo(roleId, true);
/* 375 */       FabaoArtifactExpireSession.removeSession(roleId, xSessionInfo, artifactCfg.classId);
/*     */     }
/*     */     
/* 378 */     int cutDuration = changeExpireTimeOnly ? artifactItemCfg.validDuration : 0;
/* 379 */     tlogRemove(roleId, artifactCfg.classId, cutDuration, 0);
/* 380 */     OnlineManager.getInstance().forceReconnect(roleId);
/* 381 */     return cutDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static FabaoArtifactRemoveResult removeArtifactDuration(long roleId, int classId, int duration)
/*     */   {
/* 389 */     FabaoArtifactRecords xRecords = getRecords(roleId, true);
/* 390 */     if (xRecords == null)
/*     */     {
/* 392 */       return FabaoArtifactRemoveResult.ROLE_ARTIFACT_NOT_FOUND;
/*     */     }
/* 394 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(classId));
/* 395 */     if (xRecord == null)
/*     */     {
/* 397 */       return FabaoArtifactRemoveResult.ROLE_ARTIFACT_NOT_FOUND;
/*     */     }
/*     */     
/* 400 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 401 */     int newExpireTime = xRecord.getExpire_time() - (int)(duration * 3600L);
/* 402 */     FabaoArtifactSessionInfo xSessionInfo = getOrCreateSessionInfo(roleId);
/* 403 */     if (newExpireTime > now)
/*     */     {
/* 405 */       xRecord.setExpire_time(newExpireTime);
/* 406 */       FabaoArtifactExpireSession.restartSession(roleId, xSessionInfo, classId, newExpireTime);
/* 407 */       tlogRemove(roleId, classId, newExpireTime, 0);
/* 408 */       OnlineManager.getInstance().forceReconnect(roleId);
/* 409 */       return FabaoArtifactRemoveResult.DURATION_CUT;
/*     */     }
/*     */     
/*     */ 
/* 413 */     xRecords.getRecords().remove(Integer.valueOf(classId));
/* 414 */     if (xRecords.getEquipped_artifact_class() == classId)
/*     */     {
/* 416 */       xRecords.setEquipped_artifact_class(0);
/* 417 */       FabaoArtifactEvents.triggerEquipArtifactEvent(roleId, false, true);
/*     */     }
/* 419 */     FabaoArtifactExpireSession.removeSession(roleId, xSessionInfo, classId);
/* 420 */     FabaoArtifactEvents.triggerArtifactExpireEvent(roleId, Collections.singleton(Integer.valueOf(classId)));
/* 421 */     tlogRemove(roleId, classId, 0, 0);
/* 422 */     OnlineManager.getInstance().forceReconnect(roleId);
/* 423 */     return FabaoArtifactRemoveResult.REMOVED;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FabaoArtifactRemoveResult removeArtifactUpgradeExp(long roleId, int classId, int exp)
/*     */   {
/* 432 */     FabaoArtifactRecords xRecords = getRecords(roleId, true);
/* 433 */     if (xRecords == null)
/*     */     {
/* 435 */       return FabaoArtifactRemoveResult.ROLE_ARTIFACT_NOT_FOUND;
/*     */     }
/* 437 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(classId));
/* 438 */     if (xRecord == null)
/*     */     {
/* 440 */       return FabaoArtifactRemoveResult.ROLE_ARTIFACT_NOT_FOUND;
/*     */     }
/*     */     
/* 443 */     int newUpgradeExp = xRecord.getUpgrade_exp() - exp;
/* 444 */     if (newUpgradeExp < 0)
/*     */     {
/* 446 */       xRecords.getRecords().remove(Integer.valueOf(classId));
/* 447 */       if (xRecords.getEquipped_artifact_class() == classId)
/*     */       {
/* 449 */         xRecords.setEquipped_artifact_class(0);
/* 450 */         FabaoArtifactEvents.triggerEquipArtifactEvent(roleId, false, true);
/*     */       }
/* 452 */       FabaoArtifactEvents.triggerArtifactExpireEvent(roleId, Collections.singleton(Integer.valueOf(classId)));
/* 453 */       tlogRemove(roleId, classId, 0, newUpgradeExp);
/* 454 */       OnlineManager.getInstance().forceReconnect(roleId);
/* 455 */       return FabaoArtifactRemoveResult.REMOVED;
/*     */     }
/*     */     
/* 458 */     xRecord.setUpgrade_exp(newUpgradeExp);
/* 459 */     SFabaoArtifactClassTable classTable = SFabaoArtifactClassTable.get(classId);
/* 460 */     if (classTable == null)
/*     */     {
/* 462 */       return FabaoArtifactRemoveResult.UNKNOWN;
/*     */     }
/* 464 */     int currentLevel = xRecord.getLevel();
/* 465 */     Integer currentLevelRequiredExp = (Integer)classTable.level2exp.get(Integer.valueOf(currentLevel));
/* 466 */     if (currentLevelRequiredExp == null)
/*     */     {
/* 468 */       return FabaoArtifactRemoveResult.UNKNOWN;
/*     */     }
/* 470 */     if (newUpgradeExp < currentLevelRequiredExp.intValue())
/*     */     {
/*     */ 
/*     */ 
/* 474 */       for (int newLevel = currentLevel - 1; newLevel >= 1; newLevel--)
/*     */       {
/* 476 */         Integer newLevelRequiredExp = (Integer)classTable.level2exp.get(Integer.valueOf(newLevel));
/* 477 */         if (newLevelRequiredExp == null)
/*     */         {
/* 479 */           return FabaoArtifactRemoveResult.UNKNOWN;
/*     */         }
/* 481 */         if (newUpgradeExp >= newLevelRequiredExp.intValue()) {
/*     */           break;
/*     */         }
/*     */       }
/*     */       
/* 486 */       xRecord.setLevel(newLevel);
/*     */       
/*     */ 
/* 489 */       Integer artifactCfgId = (Integer)classTable.level2cfgId.get(Integer.valueOf(newLevel));
/* 490 */       if (artifactCfgId == null)
/*     */       {
/* 492 */         return FabaoArtifactRemoveResult.UNKNOWN;
/*     */       }
/* 494 */       FabaoArtifactPropertyCfg artifactPropertyCfg = FabaoArtifactPropertyCfg.get(artifactCfgId.intValue());
/* 495 */       if (artifactPropertyCfg == null)
/*     */       {
/* 497 */         return FabaoArtifactRemoveResult.UNKNOWN;
/*     */       }
/* 499 */       for (int i = 0; i < artifactPropertyCfg.propertyTypes.size(); i++)
/*     */       {
/* 501 */         int propertyType = ((Integer)artifactPropertyCfg.propertyTypes.get(i)).intValue();
/* 502 */         int maxValue = ((Integer)artifactPropertyCfg.finalValues.get(i)).intValue();
/* 503 */         Integer currentValue = (Integer)xRecord.getProperties().get(Integer.valueOf(propertyType));
/* 504 */         if (currentValue != null)
/*     */         {
/* 506 */           int newValue = Math.min(maxValue, currentValue.intValue());
/* 507 */           if (newValue != currentValue.intValue())
/*     */           {
/* 509 */             xRecord.getProperties().put(Integer.valueOf(propertyType), Integer.valueOf(newValue));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 514 */     tlogRemove(roleId, classId, 0, newUpgradeExp);
/* 515 */     OnlineManager.getInstance().forceReconnect(roleId);
/* 516 */     return FabaoArtifactRemoveResult.UPGRADE_EXP_CUT;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\FabaoArtifactManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */