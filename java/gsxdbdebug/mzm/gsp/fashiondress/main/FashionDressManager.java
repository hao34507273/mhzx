/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.fashiondress.SSelectPropertySuccess;
/*     */ import mzm.gsp.fashiondress.SSyncFashionDressInfo;
/*     */ import mzm.gsp.fashiondress.SSyncThemeFashionDressInfo;
/*     */ import mzm.gsp.fashiondress.SSyncThemeFashionDressUpdateInfo;
/*     */ import mzm.gsp.fashiondress.SUnLockFashionDressSuccess;
/*     */ import mzm.gsp.fashiondress.confbean.FashionDressConsts;
/*     */ import mzm.gsp.fashiondress.confbean.GenderFashionDressList;
/*     */ import mzm.gsp.fashiondress.confbean.MenPaiFashionDressMap;
/*     */ import mzm.gsp.fashiondress.confbean.SConditionFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressTypeCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressUnLockConditionCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockTypeCfg;
/*     */ import mzm.gsp.fashiondress.confbean.STimeLimitedThemeFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.event.FashionDressModelArg;
/*     */ import mzm.gsp.fashiondress.event.FashionDressModelChange;
/*     */ import mzm.gsp.fashiondress.event.FashionDressObserverArg;
/*     */ import mzm.gsp.fashiondress.event.FashionDressPassiveSkillChange;
/*     */ import mzm.gsp.fashiondress.event.PassiveSkillChangeArg;
/*     */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChange;
/*     */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeArg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleInterface.DefaultColorInfo;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ClothColor;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.RoleClothes;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xbean.TransferOccupationRoleClothes;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2fashiondress;
/*     */ import xtable.Roleclothes;
/*     */ 
/*     */ class FashionDressManager
/*     */ {
/*     */   static Set<Integer> newYearFashionDressCfgIdSet;
/*     */   static final int ACTION_UNLOCK = 1;
/*     */   static final int ACTION_LOCK = 2;
/*     */   
/*     */   static void postInit()
/*     */   {
/*  76 */     postInitFlag = true;
/*     */   }
/*     */   
/*     */   static void triggerPassiveSkillChangeEvent(PassiveSkillChangeArg paramPassiveSkillChangeArg) {
/*  80 */     TriggerEventsManger.getInstance().triggerEvent(new FashionDressPassiveSkillChange(), paramPassiveSkillChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramPassiveSkillChangeArg.getRoleId())));
/*     */   }
/*     */   
/*     */   static void triggerModelChangeEvent(FashionDressModelArg paramFashionDressModelArg) {
/*  84 */     TriggerEventsManger.getInstance().triggerEvent(new FashionDressModelChange(), paramFashionDressModelArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramFashionDressModelArg.roleId)));
/*     */   }
/*     */   
/*     */   static void triggerFashionDressObserverEvent(FashionDressObserverArg paramFashionDressObserverArg) {
/*  88 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fashiondress.event.FashionDressObserver(), paramFashionDressObserverArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramFashionDressObserverArg.roleId)));
/*     */   }
/*     */   
/*     */   static boolean checkGoalUnLockFashionDress(long paramLong1, long paramLong2, int paramInt, String paramString, FashionDressTLogEnum paramFashionDressTLogEnum) {
/*  92 */     Role localRole = RoleInterface.getRole(paramLong1, true);
/*  93 */     int i = localRole.getOccupationId();
/*  94 */     int j = localRole.getGender();
/*  95 */     List localList = getFashionDressList(paramInt, i, j, paramString);
/*  96 */     if (localList == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong1));
/* 100 */     Map localMap = null;
/* 101 */     Set localSet = null;
/* 102 */     if (localRole2FashionDressInfo != null) {
/* 103 */       localMap = localRole2FashionDressInfo.getFashion_dress_map();
/* 104 */       localSet = localRole2FashionDressInfo.getActivate_property_set();
/*     */     }
/* 106 */     for (Integer localInteger : localList) {
/* 107 */       SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(localInteger.intValue());
/* 108 */       SFashionDressUnLockConditionCfg localSFashionDressUnLockConditionCfg = SFashionDressUnLockConditionCfg.get(localSFashionDressCfg.unlockConditionId);
/* 109 */       if ((!localMap.containsKey(localInteger)) && (paramLong2 >= localSFashionDressUnLockConditionCfg.conditionValue)) {
/* 110 */         if ((localMap == null) || (localSet == null)) {
/* 111 */           localRole2FashionDressInfo = Pod.newRole2FashionDressInfo();
/* 112 */           localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 113 */           Role2fashiondress.add(Long.valueOf(paramLong1), localRole2FashionDressInfo);
/* 114 */           localMap = localRole2FashionDressInfo.getFashion_dress_map();
/* 115 */           localSet = localRole2FashionDressInfo.getActivate_property_set();
/*     */         }
/* 117 */         if ((localSet.size() == 0) && (!localSFashionDressCfg.propertySkillList.isEmpty())) {
/* 118 */           localSet.add(localInteger);
/* 119 */           localObject = new SSelectPropertySuccess();
/* 120 */           ((SSelectPropertySuccess)localObject).fashiondresscfgid = localInteger.intValue();
/* 121 */           OnlineManager.getInstance().send(paramLong1, (Protocol)localObject);
/*     */         }
/* 123 */         Object localObject = Pod.newFashionDressInfo();
/* 124 */         ((FashionDressInfo)localObject).setStart_time(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 125 */         localMap.put(localInteger, localObject);
/* 126 */         if (localSFashionDressCfg.effectTime > 0) {
/* 127 */           triggerFashionDressObserverEvent(new FashionDressObserverArg(paramLong1, localSFashionDressCfg.effectTime * 3600L, localInteger.intValue()));
/*     */         }
/* 129 */         tlogFashionDressOperator(localRole.getUserId(), paramLong1, localInteger.intValue(), FashionDressTLogEnum.LEVEL_UNLOCK);
/* 130 */         SUnLockFashionDressSuccess localSUnLockFashionDressSuccess = new SUnLockFashionDressSuccess();
/* 131 */         localSUnLockFashionDressSuccess.fashiondresscfgid = localInteger.intValue();
/* 132 */         OnlineManager.getInstance().send(paramLong1, localSUnLockFashionDressSuccess);
/* 133 */         GameServer.logger().info(String.format("[fashiondress]%s@fashion dress unlock success|role_id=%d|fashion_dress_cfg_id=%d|new_value=%d|men_pai=%d", new Object[] { paramString, Long.valueOf(paramLong1), localInteger, Long.valueOf(paramLong2), Integer.valueOf(i) }));
/*     */       }
/*     */     }
/* 136 */     triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(paramLong1));
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private static List<Integer> getFashionDressList(int paramInt1, int paramInt2, int paramInt3, String paramString) {
/* 141 */     SConditionFashionDressCfg localSConditionFashionDressCfg = (SConditionFashionDressCfg)SConditionFashionDressCfg.getAll().get(Integer.valueOf(paramInt1));
/* 142 */     if (localSConditionFashionDressCfg == null) {
/* 143 */       return null;
/*     */     }
/* 145 */     MenPaiFashionDressMap localMenPaiFashionDressMap = (MenPaiFashionDressMap)localSConditionFashionDressCfg.conditionIdMap.get(Integer.valueOf(paramInt2));
/* 146 */     if (localMenPaiFashionDressMap == null) {
/* 147 */       return null;
/*     */     }
/* 149 */     GenderFashionDressList localGenderFashionDressList = (GenderFashionDressList)localMenPaiFashionDressMap.menPaiFashionDressMap.get(Integer.valueOf(paramInt3));
/* 150 */     if (localGenderFashionDressList == null) {
/* 151 */       return null;
/*     */     }
/* 153 */     return localGenderFashionDressList.genderFashionDressList;
/*     */   }
/*     */   
/*     */   static boolean isFashionDressSwitchOpen(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 157 */     if (!OpenInterface.getOpenStatus(110)) {
/* 158 */       if (paramBoolean1) {
/* 159 */         GameServer.logger().info(String.format("[fashiondress]%s@fashion dress system switch closed|role_id=%d", new Object[] { paramString, Long.valueOf(paramLong) }));
/*     */       }
/* 161 */       return false;
/*     */     }
/* 163 */     if (OpenInterface.isBanPlay(paramLong, 110)) {
/* 164 */       if (paramBoolean1) {
/* 165 */         GameServer.logger().info(String.format("[fashiondress]%s@fashion dress is ban play|role_id=%d", new Object[] { paramString, Long.valueOf(paramLong) }));
/*     */       }
/* 167 */       if (paramBoolean2) {
/* 168 */         OpenInterface.sendBanPlayMsg(paramLong, 110);
/*     */       }
/* 170 */       return false;
/*     */     }
/* 172 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isThemeFashionDressSwitchOpenForRole(long paramLong) {
/* 176 */     if (!OpenInterface.getOpenStatus(328)) {
/* 177 */       return false;
/*     */     }
/* 179 */     if (OpenInterface.isBanPlay(paramLong, 328)) {
/* 180 */       OpenInterface.sendBanPlayMsg(paramLong, 328);
/* 181 */       return false;
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isTimeLimitedThemeFashionDressSwitchOpenForRole(long paramLong) {
/* 187 */     if (!OpenInterface.getOpenStatus(328)) {
/* 188 */       return false;
/*     */     }
/* 190 */     if (!OpenInterface.getOpenStatus(464)) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (OpenInterface.isBanPlay(paramLong, 328)) {
/* 194 */       OpenInterface.sendBanPlayMsg(paramLong, 328);
/* 195 */       return false;
/*     */     }
/* 197 */     if (OpenInterface.isBanPlay(paramLong, 464)) {
/* 198 */       OpenInterface.sendBanPlayMsg(paramLong, 464);
/* 199 */       return false;
/*     */     }
/* 201 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isLevelOpen(long paramLong, String paramString, boolean paramBoolean) {
/* 205 */     int i = RoleInterface.getLevel(paramLong);
/* 206 */     if (i < FashionDressConsts.getInstance().openLevel) {
/* 207 */       if (paramBoolean) {
/* 208 */         GameServer.logger().error(String.format("[fashiondress]%s@fashion dress function level not enough|role_id=%d|role_level=%d|need_level=%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(FashionDressConsts.getInstance().openLevel) }));
/*     */       }
/* 210 */       return false;
/*     */     }
/* 212 */     return true;
/*     */   }
/*     */   
/*     */   static List<Integer> getFashionDressPassiveSkillIdList(long paramLong, boolean paramBoolean) {
/* 216 */     ArrayList localArrayList = new ArrayList();
/* 217 */     Role2FashionDressInfo localRole2FashionDressInfo = null;
/* 218 */     if (paramBoolean) {
/* 219 */       localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/*     */     }
/*     */     else {
/* 222 */       localRole2FashionDressInfo = Role2fashiondress.select(Long.valueOf(paramLong));
/*     */     }
/* 224 */     if (localRole2FashionDressInfo == null) {
/* 225 */       return localArrayList;
/*     */     }
/* 227 */     Map localMap = localRole2FashionDressInfo.getFashion_dress_map();
/* 228 */     for (Object localObject = localMap.keySet().iterator(); ((Iterator)localObject).hasNext();) { int i = ((Integer)((Iterator)localObject).next()).intValue();
/* 229 */       SFashionDressCfg localSFashionDressCfg1 = SFashionDressCfg.get(i);
/* 230 */       if (localSFashionDressCfg1 != null)
/*     */       {
/*     */ 
/* 233 */         localArrayList.addAll(localSFashionDressCfg1.effectSkillList); }
/*     */     }
/* 235 */     localObject = localRole2FashionDressInfo.getActivate_property_set();
/* 236 */     for (Iterator localIterator = ((Set)localObject).iterator(); localIterator.hasNext();) { int j = ((Integer)localIterator.next()).intValue();
/* 237 */       SFashionDressCfg localSFashionDressCfg2 = SFashionDressCfg.get(j);
/* 238 */       if (localSFashionDressCfg2 != null)
/*     */       {
/*     */ 
/* 241 */         localArrayList.addAll(localSFashionDressCfg2.propertySkillList); }
/*     */     }
/* 243 */     return localArrayList;
/*     */   }
/*     */   
/*     */   static void checkWearFashionDressExpired(long paramLong, Role2FashionDressInfo paramRole2FashionDressInfo, int paramInt) {
/* 247 */     if (paramRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id() == paramInt) {
/* 248 */       paramRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 249 */       FashionDressInterface.changeRoleClothAndModel(paramLong, -1);
/*     */     }
/*     */   }
/*     */   
/*     */   static void tlogUnlockThemeFashionTypeId(String paramString, long paramLong, int paramInt1, int paramInt2) {
/* 254 */     int i = RoleInterface.getLevel(paramLong);
/* 255 */     StringBuilder localStringBuilder = new StringBuilder();
/* 256 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 257 */     localStringBuilder.append(paramString).append('|');
/* 258 */     localStringBuilder.append(paramLong).append('|');
/* 259 */     localStringBuilder.append(i).append('|');
/* 260 */     localStringBuilder.append(paramInt1).append('|');
/* 261 */     localStringBuilder.append(paramInt2);
/* 262 */     TLogManager.getInstance().addLog(paramLong, "UnlockThemeFashionDressType", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static void tlogFashionDressOperator(String paramString, long paramLong, int paramInt, FashionDressTLogEnum paramFashionDressTLogEnum) {
/* 266 */     int i = RoleInterface.getLevel(paramLong);
/* 267 */     StringBuilder localStringBuilder = new StringBuilder();
/* 268 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 269 */     localStringBuilder.append(paramString).append('|');
/* 270 */     localStringBuilder.append(paramLong).append('|');
/* 271 */     localStringBuilder.append(i).append('|');
/* 272 */     localStringBuilder.append(paramInt).append('|');
/* 273 */     localStringBuilder.append(paramFashionDressTLogEnum.getOperator());
/* 274 */     TLogManager.getInstance().addLog(paramLong, "FashionDressOperator", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static void tlogForeverNewYearFashionDressRepaire(String paramString, long paramLong, int paramInt1, int paramInt2) {
/* 278 */     int i = RoleInterface.getLevel(paramLong);
/* 279 */     StringBuilder localStringBuilder = new StringBuilder();
/* 280 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 281 */     localStringBuilder.append(paramString).append('|');
/* 282 */     localStringBuilder.append(paramLong).append('|');
/* 283 */     localStringBuilder.append(i).append('|');
/* 284 */     localStringBuilder.append(paramInt1).append('|');
/* 285 */     localStringBuilder.append(paramInt2);
/* 286 */     TLogManager.getInstance().addLog(paramLong, "ForeverNewYearFashionDressRepaire", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static void tlogThreeDayNewYearFashionDressRepaire(String paramString, long paramLong, int paramInt1, int paramInt2) {
/* 290 */     int i = RoleInterface.getLevel(paramLong);
/* 291 */     StringBuilder localStringBuilder = new StringBuilder();
/* 292 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 293 */     localStringBuilder.append(paramString).append('|');
/* 294 */     localStringBuilder.append(paramLong).append('|');
/* 295 */     localStringBuilder.append(i).append('|');
/* 296 */     localStringBuilder.append(paramInt1).append('|');
/* 297 */     localStringBuilder.append(paramInt2);
/* 298 */     TLogManager.getInstance().addLog(paramLong, "ThreeDayNewYearFashionDressRepaire", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static void sendFashionDressExpiredMail(long paramLong, SFashionDressCfg paramSFashionDressCfg) {
/* 302 */     triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(paramLong));
/* 303 */     ArrayList localArrayList = new ArrayList();
/* 304 */     localArrayList.add(paramSFashionDressCfg.fashionDressName);
/* 305 */     SendMailRet localSendMailRet = MailInterface.synBuildAndSendMail(paramLong, FashionDressConsts.getInstance().timeOutMailId, new ArrayList(), localArrayList, new MailAttachment(), new TLogArg(LogReason.FSHION_DRESS_EXPIRED));
/* 306 */     if (!localSendMailRet.isOK()) {
/* 307 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.sendFashionDressExpiredMail@send mail failed|role_id=%d|fashion_dress_cfg_id=%d|ret=%d|ret_msg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramSFashionDressCfg.id), Integer.valueOf(localSendMailRet.getRetEnum().ret), localSendMailRet.getRetEnum().retMsg }));
/*     */     }
/*     */   }
/*     */   
/*     */   static int getNewOccupationFashionDress(int paramInt1, int paramInt2, int paramInt3) {
/* 312 */     SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(paramInt1);
/* 313 */     if (localSFashionDressCfg == null) {
/* 314 */       return -1;
/*     */     }
/* 316 */     SFashionDressTypeCfg localSFashionDressTypeCfg = SFashionDressTypeCfg.get(localSFashionDressCfg.fashionDressType);
/* 317 */     Iterator localIterator; int i; if (localSFashionDressCfg.fashionShowType == 2) {
/* 318 */       for (localIterator = localSFashionDressTypeCfg.fashionDressCfgIdList.iterator(); localIterator.hasNext();) { i = ((Integer)localIterator.next()).intValue();
/* 319 */         localSFashionDressCfg = SFashionDressCfg.get(i);
/* 320 */         if ((localSFashionDressCfg.gender == paramInt3) || (localSFashionDressCfg.gender == 0)) {
/* 321 */           return localSFashionDressCfg.id;
/*     */         }
/*     */         
/*     */       }
/*     */     } else {
/* 326 */       for (localIterator = localSFashionDressTypeCfg.fashionDressCfgIdList.iterator(); localIterator.hasNext();) { i = ((Integer)localIterator.next()).intValue();
/* 327 */         localSFashionDressCfg = SFashionDressCfg.get(i);
/* 328 */         if ((localSFashionDressCfg.menpai == paramInt2) && (localSFashionDressCfg.gender == paramInt3)) {
/* 329 */           return localSFashionDressCfg.id;
/*     */         }
/*     */       }
/*     */     }
/* 333 */     return -1;
/*     */   }
/*     */   
/*     */   static void clearTransferOccupationFashionDress(long paramLong, int paramInt, Role2FashionDressInfo paramRole2FashionDressInfo) {
/* 337 */     Map localMap = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 338 */     if (localMap.isEmpty()) {
/* 339 */       return;
/*     */     }
/* 341 */     int i = RoleInterface.getGender(paramLong);
/* 342 */     for (Map.Entry localEntry : localMap.entrySet()) {
/* 343 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 344 */       if (j > 100)
/*     */       {
/* 346 */         i = j % 100;
/* 347 */         j /= 100;
/*     */       }
/* 349 */       int k = getNewOccupationFashionDress(paramInt, j, i);
/* 350 */       if (k > 0)
/*     */       {
/*     */ 
/* 353 */         TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 354 */         localTransferOccupationFashionDress.getFashion_dress_map().remove(Integer.valueOf(k));
/* 355 */         localTransferOccupationFashionDress.getActivate_property_set().remove(Integer.valueOf(k));
/* 356 */         if (localTransferOccupationFashionDress.getCurrent_fashion_dress_cfg_id() == k)
/*     */         {
/*     */ 
/* 359 */           localTransferOccupationFashionDress.setCurrent_fashion_dress_cfg_id(-1); }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 364 */   static void onRoleLogin(String paramString, long paramLong) { SSyncFashionDressInfo localSSyncFashionDressInfo = new SSyncFashionDressInfo();
/* 365 */     SSyncThemeFashionDressInfo localSSyncThemeFashionDressInfo = new SSyncThemeFashionDressInfo();
/* 366 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/* 367 */     if (localRole2FashionDressInfo == null) {
/* 368 */       localSSyncFashionDressInfo.currentfashiondresscfgid = -1;
/* 369 */       OnlineManager.getInstance().send(paramLong, localSSyncFashionDressInfo);
/* 370 */       OnlineManager.getInstance().send(paramLong, localSSyncThemeFashionDressInfo);
/* 371 */       return;
/*     */     }
/* 373 */     boolean bool = localRole2FashionDressInfo.getNew_year_fashion_dress_is_repaired();
/* 374 */     if (!bool) {
/* 375 */       localMap = localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 376 */       if (!localMap.isEmpty()) {
/* 377 */         CheckResult localCheckResult = checkForeverNewYearFashionDress(localRole2FashionDressInfo);
/* 378 */         if (localCheckResult.isContainForeverNewYearFashionDress) {
/* 379 */           repaireForeverNewYearFashionDress(paramString, paramLong, localRole2FashionDressInfo, localCheckResult);
/*     */         }
/*     */       }
/* 382 */       localRole2FashionDressInfo.setNew_year_fashion_dress_is_repaired(true);
/*     */     }
/* 384 */     Map localMap = localRole2FashionDressInfo.getFashion_dress_map();
/* 385 */     long l1 = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 386 */     ArrayList localArrayList = new ArrayList();
/* 387 */     Iterator localIterator1 = localRole2FashionDressInfo.getActivate_property_set().iterator();
/* 388 */     while (localIterator1.hasNext()) {
/* 389 */       int i = ((Integer)localIterator1.next()).intValue();
/* 390 */       if (!localMap.containsKey(Integer.valueOf(i))) {
/* 391 */         localIterator1.remove();
/*     */       }
/*     */       else {
/* 394 */         localObject1 = SFashionDressCfg.get(i);
/* 395 */         if ((localObject1 != null) && (((SFashionDressCfg)localObject1).propertySkillList.isEmpty()))
/*     */         {
/*     */ 
/* 398 */           localIterator1.remove(); }
/*     */       }
/*     */     }
/* 401 */     Iterator localIterator2 = localMap.entrySet().iterator();
/* 402 */     while (localIterator2.hasNext()) {
/* 403 */       localObject1 = (Map.Entry)localIterator2.next();
/* 404 */       int j = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
/* 405 */       localObject2 = (FashionDressInfo)((Map.Entry)localObject1).getValue();
/* 406 */       SFashionDressCfg localSFashionDressCfg1 = SFashionDressCfg.get(j);
/* 407 */       if (localSFashionDressCfg1 == null) {
/* 408 */         localIterator2.remove();
/* 409 */         checkWearFashionDressExpired(paramLong, localRole2FashionDressInfo, j);
/* 410 */         GameServer.logger().warn(String.format("[fashiondress]POnRoleLogin.processImp@fashion dress cfg not exist,may be cfg data changes|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j) }));
/*     */       }
/* 412 */       else if (localSFashionDressCfg1.effectTime <= 0) {
/* 413 */         localSSyncFashionDressInfo.fashiondressinfomap.put(Integer.valueOf(j), Long.valueOf(-1L));
/*     */       }
/*     */       else {
/* 416 */         long l2 = localSFashionDressCfg1.effectTime * 3600L + ((FashionDressInfo)localObject2).getExtend_time();
/* 417 */         long l3 = l1 - ((FashionDressInfo)localObject2).getStart_time();
/* 418 */         long l4 = l2 - l3;
/* 419 */         if (l4 <= 0L) {
/* 420 */           localIterator2.remove();
/* 421 */           clearTransferOccupationFashionDress(paramLong, j, localRole2FashionDressInfo);
/* 422 */           checkWearFashionDressExpired(paramLong, localRole2FashionDressInfo, j);
/* 423 */           sendFashionDressExpiredMail(paramLong, localSFashionDressCfg1);
/* 424 */           localRole2FashionDressInfo.getActivate_property_set().remove(Integer.valueOf(j));
/* 425 */           GameServer.logger().info(String.format("[fashiondress]POnRoleLogin.processImp@fashion dress expired,remove from xdb|role_id=%d|fashion_dress_cfg_id=%d|start_time=%d|current_time=%d|effect_time=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j), Long.valueOf(((FashionDressInfo)localObject2).getStart_time()), Long.valueOf(l1), Integer.valueOf(localSFashionDressCfg1.effectTime) }));
/*     */         }
/*     */         else {
/* 428 */           localSSyncFashionDressInfo.fashiondressinfomap.put(Integer.valueOf(j), Long.valueOf(l4));
/* 429 */           localArrayList.add(new FashionDressObserverArg(paramLong, l4, j));
/*     */         }
/*     */       }
/*     */     }
/* 433 */     localSSyncFashionDressInfo.currentfashiondresscfgid = localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id();
/* 434 */     localSSyncFashionDressInfo.activatepropertylist.addAll(localRole2FashionDressInfo.getActivate_property_set());
/* 435 */     OnlineManager.getInstance().send(paramLong, localSSyncFashionDressInfo);
/* 436 */     Object localObject1 = new HashSet();
/* 437 */     ((Set)localObject1).addAll(localRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set());
/* 438 */     HashSet localHashSet = new HashSet();
/* 439 */     for (Object localObject2 = localRole2FashionDressInfo.getFashion_dress_map().keySet().iterator(); ((Iterator)localObject2).hasNext();) { int k = ((Integer)((Iterator)localObject2).next()).intValue();
/* 440 */       localSFashionDressCfg2 = SFashionDressCfg.get(k);
/* 441 */       if (localSFashionDressCfg2 != null)
/*     */       {
/*     */ 
/* 444 */         for (SThemeFashionDressUnlockTypeCfg localSThemeFashionDressUnlockTypeCfg : SThemeFashionDressUnlockTypeCfg.getAll().values()) {
/* 445 */           int i1 = localSThemeFashionDressUnlockTypeCfg.unlock_fashion_dress_type_Id;
/* 446 */           if ((localSThemeFashionDressUnlockTypeCfg.type_list.contains(Integer.valueOf(localSFashionDressCfg2.fashionDressType))) && (!localHashSet.contains(Integer.valueOf(i1))))
/* 447 */             localHashSet.add(Integer.valueOf(i1));
/*     */         } }
/*     */     }
/*     */     SFashionDressCfg localSFashionDressCfg2;
/* 451 */     localObject2 = new HashSet();
/* 452 */     ((HashSet)localObject2).addAll(localHashSet);
/* 453 */     ((HashSet)localObject2).removeAll((Collection)localObject1);
/* 454 */     for (Object localObject3 = ((HashSet)localObject2).iterator(); ((Iterator)localObject3).hasNext();) { int m = ((Integer)((Iterator)localObject3).next()).intValue();
/* 455 */       tlogUnlockThemeFashionTypeId(paramString, paramLong, 1, m);
/*     */     }
/* 457 */     localObject3 = new HashSet();
/* 458 */     ((HashSet)localObject3).addAll((Collection)localObject1);
/* 459 */     ((HashSet)localObject3).removeAll(localHashSet);
/* 460 */     for (Iterator localIterator3 = ((HashSet)localObject3).iterator(); localIterator3.hasNext();) { int n = ((Integer)localIterator3.next()).intValue();
/* 461 */       tlogUnlockThemeFashionTypeId(paramString, paramLong, 2, n);
/*     */     }
/* 463 */     localRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set().clear();
/* 464 */     localRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set().addAll(localHashSet);
/* 465 */     localSSyncThemeFashionDressInfo.unlock_theme_fashion_dress_type_id_set.addAll(localRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set());
/* 466 */     OnlineManager.getInstance().send(paramLong, localSSyncThemeFashionDressInfo);
/* 467 */     TriggerEventsManger.getInstance().triggerEvent(new ThemeFashionDressPropertyChange(), new ThemeFashionDressPropertyChangeArg(paramLong, localHashSet), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramLong)));
/* 468 */     refreshTimeLimitedThemeFashionDressBuff(paramLong);
/* 469 */     for (FashionDressObserverArg localFashionDressObserverArg : localArrayList) {
/* 470 */       triggerFashionDressObserverEvent(localFashionDressObserverArg);
/*     */     }
/* 472 */     checkNewYearFashionDressThree(paramString, paramLong, localRole2FashionDressInfo);
/*     */   }
/*     */   
/*     */   static CheckResult checkForeverNewYearFashionDress(Role2FashionDressInfo paramRole2FashionDressInfo) {
/* 476 */     CheckResult localCheckResult = new CheckResult(null);
/* 477 */     Map localMap1 = paramRole2FashionDressInfo.getFashion_dress_map();
/* 478 */     for (Object localObject1 = localMap1.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/* 479 */       int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
/* 480 */       if (newYearFashionDressCfgIdSet.contains(Integer.valueOf(i))) {
/* 481 */         localCheckResult.setContainForevenNewYearFashionDress(true);
/* 482 */         localObject3 = (FashionDressInfo)((Map.Entry)localObject2).getValue();
/* 483 */         localCheckResult.setForeverNewYearFashionDressBuyTime(((FashionDressInfo)localObject3).getStart_time());
/*     */       } }
/*     */     Object localObject3;
/* 486 */     localObject1 = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 487 */     for (Object localObject2 = ((Map)localObject1).entrySet().iterator(); ((Iterator)localObject2).hasNext();) { Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
/* 488 */       localObject3 = (TransferOccupationFashionDress)localEntry1.getValue();
/* 489 */       Map localMap2 = ((TransferOccupationFashionDress)localObject3).getFashion_dress_map();
/* 490 */       for (Map.Entry localEntry2 : localMap2.entrySet()) {
/* 491 */         int j = ((Integer)localEntry2.getKey()).intValue();
/* 492 */         if (newYearFashionDressCfgIdSet.contains(Integer.valueOf(j))) {
/* 493 */           localCheckResult.setContainForevenNewYearFashionDress(true);
/* 494 */           FashionDressInfo localFashionDressInfo = (FashionDressInfo)localEntry2.getValue();
/* 495 */           localCheckResult.setForeverNewYearFashionDressBuyTime(localFashionDressInfo.getStart_time());
/*     */         }
/*     */       }
/*     */     }
/* 499 */     return localCheckResult;
/*     */   }
/*     */   
/*     */   static void checkNewYearFashionDressThree(String paramString, long paramLong, Role2FashionDressInfo paramRole2FashionDressInfo) {
/* 503 */     SFashionDressTypeCfg localSFashionDressTypeCfg = SFashionDressTypeCfg.get(18);
/* 504 */     if (localSFashionDressTypeCfg == null) {
/* 505 */       return;
/*     */     }
/* 507 */     Map localMap1 = paramRole2FashionDressInfo.getFashion_dress_map();
/* 508 */     for (Object localObject1 = localMap1.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/* 509 */       int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
/* 510 */       if (localSFashionDressTypeCfg.fashionDressCfgIdList.contains(Integer.valueOf(i))) {
/* 511 */         return;
/*     */       }
/*     */     }
/* 514 */     localObject1 = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 515 */     for (Object localObject2 = ((Map)localObject1).entrySet().iterator(); ((Iterator)localObject2).hasNext();) { Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
/* 516 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry1.getValue();
/* 517 */       Map localMap2 = localTransferOccupationFashionDress.getFashion_dress_map();
/* 518 */       Iterator localIterator = localMap2.entrySet().iterator();
/* 519 */       while (localIterator.hasNext()) {
/* 520 */         Map.Entry localEntry2 = (Map.Entry)localIterator.next();
/* 521 */         int j = ((Integer)localEntry2.getKey()).intValue();
/* 522 */         if (localSFashionDressTypeCfg.fashionDressCfgIdList.contains(Integer.valueOf(j))) {
/* 523 */           tlogThreeDayNewYearFashionDressRepaire(paramString, paramLong, j, ((Integer)localEntry1.getKey()).intValue());
/* 524 */           localIterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void repaireForeverNewYearFashionDress(String paramString, long paramLong, Role2FashionDressInfo paramRole2FashionDressInfo, CheckResult paramCheckResult) {
/* 531 */     if (!paramCheckResult.isContainForeverNewYearFashionDress) {
/* 532 */       return;
/*     */     }
/* 534 */     int i = RoleInterface.getGender(paramLong);
/* 535 */     int j = RoleInterface.getOccupationId(paramLong);
/* 536 */     int k = getNewOccupationFashionDress(860000208, j, i);
/* 537 */     Map localMap1 = paramRole2FashionDressInfo.getFashion_dress_map();
/* 538 */     FashionDressInfo localFashionDressInfo1 = (FashionDressInfo)localMap1.get(Integer.valueOf(k));
/* 539 */     if (localFashionDressInfo1 == null) {
/* 540 */       localFashionDressInfo1 = Pod.newFashionDressInfo();
/* 541 */       localMap1.put(Integer.valueOf(k), localFashionDressInfo1);
/* 542 */       localFashionDressInfo1.setStart_time(paramCheckResult.foreverNewYearFashionDressBuyTime);
/* 543 */       tlogForeverNewYearFashionDressRepaire(paramString, paramLong, k, j);
/*     */     }
/* 545 */     Map localMap2 = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 546 */     for (Map.Entry localEntry : localMap2.entrySet()) {
/* 547 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 548 */       int m = ((Integer)localEntry.getKey()).intValue();
/* 549 */       if (m > 100)
/*     */       {
/* 551 */         i = m % 100;
/* 552 */         m /= 100;
/*     */       }
/* 554 */       Map localMap3 = localTransferOccupationFashionDress.getFashion_dress_map();
/* 555 */       int n = getNewOccupationFashionDress(860000208, m, i);
/* 556 */       FashionDressInfo localFashionDressInfo2 = (FashionDressInfo)localMap3.get(Integer.valueOf(n));
/* 557 */       if (localFashionDressInfo2 == null) {
/* 558 */         localFashionDressInfo2 = Pod.newFashionDressInfo();
/* 559 */         localMap3.put(Integer.valueOf(n), localFashionDressInfo2);
/* 560 */         localFashionDressInfo2.setStart_time(paramCheckResult.foreverNewYearFashionDressBuyTime);
/* 561 */         tlogForeverNewYearFashionDressRepaire(paramString, paramLong, n, m);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean checkMutexStatus(long paramLong) {
/* 567 */     if (!RoleStatusInterface.checkCanSetStatus(paramLong, 82, true)) {
/* 568 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(paramLong) }));
/* 569 */       return false;
/*     */     }
/* 571 */     return true;
/*     */   }
/*     */   
/*     */   static int getActiveTimeLimitedThemeFashionDressStartTimestamp(long paramLong) {
/* 575 */     int i = (int)(paramLong / 1000L);
/* 576 */     TreeMap localTreeMap = (TreeMap)STimeLimitedThemeFashionDressCfg.getAll();
/* 577 */     Map.Entry localEntry = localTreeMap.floorEntry(Integer.valueOf(i));
/* 578 */     if (localEntry == null) {
/* 579 */       return -1;
/*     */     }
/* 581 */     if (i >= ((STimeLimitedThemeFashionDressCfg)localEntry.getValue()).end_timestamp) {
/* 582 */       return -1;
/*     */     }
/* 584 */     return ((Integer)localEntry.getKey()).intValue();
/*     */   }
/*     */   
/*     */   static int getCurrentActiveTimeLimitedThemeFashionDressStartTimestamp() {
/* 588 */     return getActiveTimeLimitedThemeFashionDressStartTimestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   static boolean checkRoleHaveEntireThemeFashionDress(long paramLong, int paramInt) {
/* 592 */     SThemeFashionDressCfg localSThemeFashionDressCfg = SThemeFashionDressCfg.get(paramInt);
/* 593 */     if (localSThemeFashionDressCfg == null) {
/* 594 */       return false;
/*     */     }
/* 596 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/* 597 */     if (localRole2FashionDressInfo == null) {
/* 598 */       return false;
/*     */     }
/* 600 */     for (Iterator localIterator = localSThemeFashionDressCfg.unlock_theme_fashion_dress_type_list.iterator(); localIterator.hasNext();) { int i = ((Integer)localIterator.next()).intValue();
/* 601 */       if (!localRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set().contains(Integer.valueOf(i))) {
/* 602 */         return false;
/*     */       }
/*     */     }
/* 605 */     return true;
/*     */   }
/*     */   
/*     */   static void refreshTimeLimitedThemeFashionDressBuff(long paramLong) {
/* 609 */     List localList = BuffInterface.contains(paramLong, FashionDressCfgManager.getAllTimeLimitedThemeFashionDressBuffCfgid(), true);
/* 610 */     int i = -1;
/* 611 */     int j = getCurrentActiveTimeLimitedThemeFashionDressStartTimestamp();
/* 612 */     if ((j > 0) && (isTimeLimitedThemeFashionDressSwitchOpenForRole(paramLong))) {
/* 613 */       localObject = STimeLimitedThemeFashionDressCfg.get(j);
/* 614 */       if (localObject == null) {
/* 615 */         return;
/*     */       }
/* 617 */       if (checkRoleHaveEntireThemeFashionDress(paramLong, ((STimeLimitedThemeFashionDressCfg)localObject).theme_fashion_dress_cfg_id)) {
/* 618 */         i = ((STimeLimitedThemeFashionDressCfg)localObject).buff_cfg_id;
/*     */       }
/*     */     }
/* 621 */     for (Object localObject = localList.iterator(); ((Iterator)localObject).hasNext();) { int k = ((Integer)((Iterator)localObject).next()).intValue();
/* 622 */       if (k != i) {
/* 623 */         BuffInterface.uninstallBuf(paramLong, k);
/*     */       }
/*     */     }
/* 626 */     if ((i > 0) && (!BuffInterface.isContainBuff(paramLong, i))) {
/* 627 */       BuffInterface.installBuff(paramLong, i);
/*     */     }
/* 629 */     GameServer.logger().info(String.format("[fashiondress]FashionDressManager.refreshTimeLimitedThemeFashionDressBuff@refresh time limited theme fashion dress buff|roleid=%d|all_buff_cfg_ids=%s|curr_buff_cfg_id=%d", new Object[] { Long.valueOf(paramLong), localList.toString(), Integer.valueOf(i) }));
/*     */   }
/*     */   
/*     */   static void onTimeLimitedThemeFashionDressStart(int paramInt) {
/* 633 */     GameServer.logger().info(String.format("[fashiondress]FashionDressManager.onTimeLimitedThemeFashionDressStart@time limited theme fashion dress start|start_timestamp=%d", new Object[] { Integer.valueOf(paramInt) }));
/* 634 */     STimeLimitedThemeFashionDressCfg localSTimeLimitedThemeFashionDressCfg = STimeLimitedThemeFashionDressCfg.get(paramInt);
/* 635 */     if (localSTimeLimitedThemeFashionDressCfg == null)
/*     */       return;
/*     */     Iterator localIterator;
/* 638 */     if ((OpenInterface.getOpenStatus(328)) && (OpenInterface.getOpenStatus(464))) {
/* 639 */       for (localIterator = OnlineManager.getInstance().getAllRolesInWorld().iterator(); localIterator.hasNext();) { long l2 = ((Long)localIterator.next()).longValue();
/* 640 */         NoneRealTimeTaskManager.getInstance().addTask(new PRefreshBuff(l2));
/*     */       }
/*     */     }
/* 643 */     long l1 = DateTimeUtils.getCurrTimeInMillis();
/* 644 */     long l3 = localSTimeLimitedThemeFashionDressCfg.end_timestamp - l1 / 1000L;
/* 645 */     if (l3 > 0L) {
/* 646 */       TimeLimitedThemeFashionDressSessionManager.getInstance().setEndSession(l3, paramInt);
/*     */     }
/*     */     else {
/* 649 */       onTimeLimitedThemeFashionDressEnd(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   static void onTimeLimitedThemeFashionDressEnd(int paramInt) {
/* 654 */     GameServer.logger().info(String.format("[fashiondress]FashionDressManager.onTimeLimitedThemeFashionDressEnd@time limited theme fashion dress end|start_timestamp=%d", new Object[] { Integer.valueOf(paramInt) }));
/* 655 */     STimeLimitedThemeFashionDressCfg localSTimeLimitedThemeFashionDressCfg1 = STimeLimitedThemeFashionDressCfg.get(paramInt);
/* 656 */     if (localSTimeLimitedThemeFashionDressCfg1 == null) {
/* 657 */       return;
/*     */     }
/* 659 */     if ((OpenInterface.getOpenStatus(328)) && (OpenInterface.getOpenStatus(464))) {
/* 660 */       for (localObject = OnlineManager.getInstance().getAllRolesInWorld().iterator(); ((Iterator)localObject).hasNext();) { long l1 = ((Long)((Iterator)localObject).next()).longValue();
/* 661 */         NoneRealTimeTaskManager.getInstance().addTask(new PRefreshBuff(l1));
/*     */       }
/*     */     }
/* 664 */     Object localObject = (TreeMap)STimeLimitedThemeFashionDressCfg.getAll();
/* 665 */     Integer localInteger = (Integer)((TreeMap)localObject).higherKey(Integer.valueOf(paramInt));
/* 666 */     if (localInteger != null) {
/* 667 */       STimeLimitedThemeFashionDressCfg localSTimeLimitedThemeFashionDressCfg2 = STimeLimitedThemeFashionDressCfg.get(localInteger.intValue());
/* 668 */       if (localSTimeLimitedThemeFashionDressCfg2 == null) {
/* 669 */         return;
/*     */       }
/* 671 */       long l2 = DateTimeUtils.getCurrTimeInMillis();
/* 672 */       long l3 = localSTimeLimitedThemeFashionDressCfg2.start_timestamp - l2 / 1000L;
/* 673 */       if (l3 > 0L) {
/* 674 */         TimeLimitedThemeFashionDressSessionManager.getInstance().setStartSession(l3, paramInt);
/*     */       }
/*     */       else {
/* 677 */         onTimeLimitedThemeFashionDressStart(localInteger.intValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static Set<Integer> getOwnFashionDressTypeSet(long paramLong, boolean paramBoolean) {
/* 683 */     Role2FashionDressInfo localRole2FashionDressInfo = null;
/* 684 */     if (paramBoolean) {
/* 685 */       localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/*     */     }
/*     */     else {
/* 688 */       localRole2FashionDressInfo = Role2fashiondress.select(Long.valueOf(paramLong));
/*     */     }
/* 690 */     if (localRole2FashionDressInfo == null) {
/* 691 */       return null;
/*     */     }
/* 693 */     HashSet localHashSet = null;
/* 694 */     for (Integer localInteger : localRole2FashionDressInfo.getFashion_dress_map().keySet()) {
/* 695 */       SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(localInteger.intValue());
/* 696 */       if (localSFashionDressCfg != null)
/*     */       {
/*     */ 
/* 699 */         if (localHashSet == null) {
/* 700 */           localHashSet = new HashSet();
/*     */         }
/* 702 */         localHashSet.add(Integer.valueOf(localSFashionDressCfg.fashionDressType));
/*     */       } }
/* 704 */     return localHashSet;
/*     */   }
/*     */   
/*     */   static int removeFashionDress(long paramLong, int paramInt) {
/* 708 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/* 709 */     if (localRole2FashionDressInfo == null) {
/* 710 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.removeFashionDress@role fashion dress data is null|roleid=%d|fashion_dress_item_cfgid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/* 711 */       return 64116;
/*     */     }
/* 713 */     if (mzm.gsp.item.confbean.SItemCfg.get(paramInt) == null) {
/* 714 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.removeFashionDress@item not exist|roleid=%d|fashion_dress_item_cfgid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/* 715 */       return 64115;
/*     */     }
/* 717 */     HashSet localHashSet = new HashSet();
/* 718 */     for (Object localObject = SFashionDressCfg.getAll().values().iterator(); ((Iterator)localObject).hasNext();) { SFashionDressCfg localSFashionDressCfg = (SFashionDressCfg)((Iterator)localObject).next();
/* 719 */       if (localSFashionDressCfg.costItemId == paramInt) {
/* 720 */         localHashSet.add(Integer.valueOf(localSFashionDressCfg.id));
/*     */       }
/*     */     }
/* 723 */     if (localHashSet.isEmpty()) {
/* 724 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.removeFashionDress@this is not a fashion dress item|roleid=%d|fashion_dress_item_cfgid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/* 725 */       return 64114;
/*     */     }
/* 727 */     localObject = xtable.Basic.get(Long.valueOf(paramLong));
/* 728 */     if (localObject == null) {
/* 729 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.removeFashionDress@role data null|roleid=%d|fashion_dress_item_cfgid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/* 730 */       return 64113;
/*     */     }
/* 732 */     int i = 0;
/* 733 */     int j = ((xbean.Basic)localObject).getGender();
/* 734 */     for (Iterator localIterator1 = localHashSet.iterator(); localIterator1.hasNext();) { localInteger = (Integer)localIterator1.next();
/* 735 */       if (localRole2FashionDressInfo.getFashion_dress_map().remove(localInteger) != null) {
/* 736 */         GameServer.logger().info(String.format("[fashiondress]FashionDressManager.removeFashionDress@remove fashion dress|roleid=%d|fashion_dress_item_cfgid=%d|cfgid=%d|is_transfer_occupation=%b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), localInteger, Boolean.valueOf(false) }));
/* 737 */         tlogRemoveFashionDress(((xbean.Basic)localObject).getUser_id(), paramLong, localInteger.intValue(), ((xbean.Basic)localObject).getOccupationid());
/* 738 */         triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(paramLong));
/* 739 */         onFashionDressExpired(((xbean.Basic)localObject).getUser_id(), paramLong, localRole2FashionDressInfo, localInteger.intValue());
/* 740 */         if (i == 0) {
/* 741 */           i = 1;
/*     */         }
/*     */       }
/* 744 */       localRole2FashionDressInfo.getActivate_property_set().remove(localInteger);
/* 745 */       if (localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id() == localInteger.intValue()) {
/* 746 */         localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 747 */         if (localObject != null) {
/* 748 */           handleDyeDataOnRemoveFashionDress(paramLong, -1, ((xbean.Basic)localObject).getOccupationid(), j, false);
/*     */         }
/* 750 */         triggerModelChangeEvent(new FashionDressModelArg(paramLong));
/*     */       }
/* 752 */       for (Map.Entry localEntry : localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map().entrySet()) {
/* 753 */         int k = ((Integer)localEntry.getKey()).intValue();
/* 754 */         if (k > 100)
/*     */         {
/* 756 */           j = k % 100;
/* 757 */           k /= 100;
/*     */         }
/* 759 */         TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 760 */         if (localTransferOccupationFashionDress.getFashion_dress_map().remove(localInteger) != null) {
/* 761 */           GameServer.logger().info(String.format("[fashiondress]FashionDressManager.removeFashionDress@remove fashion dress|roleid=%d|fashion_dress_item_cfgid=%d|cfgid=%d|is_transfer_occupation=%b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), localInteger, Boolean.valueOf(true) }));
/* 762 */           tlogRemoveFashionDress(((xbean.Basic)localObject).getUser_id(), paramLong, localInteger.intValue(), k);
/* 763 */           if (i == 0) {
/* 764 */             i = 1;
/*     */           }
/*     */         }
/* 767 */         localTransferOccupationFashionDress.getActivate_property_set().remove(localInteger);
/* 768 */         if (localTransferOccupationFashionDress.getCurrent_fashion_dress_cfg_id() == localInteger.intValue()) {
/* 769 */           localTransferOccupationFashionDress.setCurrent_fashion_dress_cfg_id(-1);
/* 770 */           if (localObject != null)
/*     */           {
/*     */ 
/* 773 */             handleDyeDataOnRemoveFashionDress(paramLong, -1, k, j, true); }
/*     */         }
/*     */       } }
/*     */     Integer localInteger;
/* 777 */     if (i == 0) {
/* 778 */       GameServer.logger().error(String.format("[fashiondress]FashionDressManager.removeFashionDress@remove fashion dress fail,not own the fashiondress|roleid=%d|fashion_dress_item_cfgid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/* 779 */       return 64112;
/*     */     }
/* 781 */     OnlineManager.getInstance().forceReconnect(paramLong);
/* 782 */     return 0;
/*     */   }
/*     */   
/*     */   static void handleDyeDataOnRemoveFashionDress(long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 786 */     RoleClothes localRoleClothes = Roleclothes.get(Long.valueOf(paramLong));
/* 787 */     if (localRoleClothes == null) {
/* 788 */       return;
/*     */     }
/* 790 */     ClothColor localClothColor1 = null;
/* 791 */     Object localObject; if (paramBoolean) {
/* 792 */       localObject = (TransferOccupationRoleClothes)localRoleClothes.getTransfer_occupation_role_clothes().get(Integer.valueOf(paramInt2));
/* 793 */       if (localObject == null) {
/* 794 */         localObject = (TransferOccupationRoleClothes)localRoleClothes.getTransfer_occupation_role_clothes().get(Integer.valueOf(paramInt2 * 100 + paramInt3));
/*     */       }
/* 796 */       if (localObject == null) {
/* 797 */         return;
/*     */       }
/* 799 */       ClothColor localClothColor2 = getFavorColorByFashionDressCfgId(localRoleClothes, paramInt2, paramInt3, paramInt1, paramBoolean);
/* 800 */       if (localClothColor2 == null) {
/* 801 */         ((TransferOccupationRoleClothes)localObject).setCurid(((TransferOccupationRoleClothes)localObject).getDefid());
/*     */       }
/*     */       else {
/* 804 */         ((TransferOccupationRoleClothes)localObject).setCurid(localClothColor2.getId());
/*     */       }
/* 806 */       localClothColor1 = (ClothColor)((TransferOccupationRoleClothes)localObject).getClothes().get(((TransferOccupationRoleClothes)localObject).getDefid());
/*     */     }
/*     */     else {
/* 809 */       localObject = getFavorColorByFashionDressCfgId(localRoleClothes, paramInt2, paramInt3, paramInt1, paramBoolean);
/* 810 */       if (localObject == null) {
/* 811 */         localRoleClothes.setCurid(localRoleClothes.getDefid());
/*     */       }
/*     */       else {
/* 814 */         localRoleClothes.setCurid(((ClothColor)localObject).getId());
/*     */       }
/* 816 */       localClothColor1 = (ClothColor)localRoleClothes.getClothes().get(localRoleClothes.getDefid());
/*     */     }
/* 818 */     if (localClothColor1 == null) {
/* 819 */       return;
/*     */     }
/* 821 */     if (paramInt1 == -1) {
/* 822 */       localObject = RoleInterface.getRoleColorInfo(paramInt2, paramInt3);
/* 823 */       if (localObject != null) {
/* 824 */         localClothColor1.setCloth(((RoleInterface.DefaultColorInfo)localObject).getClothColorId());
/* 825 */         localClothColor1.setHair(((RoleInterface.DefaultColorInfo)localObject).getHairColorId());
/*     */       }
/*     */     }
/*     */     else {
/* 829 */       localObject = SFashionDressCfg.get(paramInt1);
/* 830 */       if (localObject != null) {
/* 831 */         localClothColor1.setCloth(((SFashionDressCfg)localObject).defaultClothDyeId);
/* 832 */         localClothColor1.setHair(((SFashionDressCfg)localObject).defaultHairDyeId);
/*     */       }
/*     */     }
/* 835 */     localClothColor1.setFashion_dress_cfg_id(paramInt1);
/*     */   }
/*     */   
/*     */   static ClothColor getFavorColorByFashionDressCfgId(RoleClothes paramRoleClothes, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 839 */     int i = 0;
/* 840 */     Object localObject1; if (paramInt3 == -1) {
/* 841 */       i = -1;
/*     */     }
/*     */     else {
/* 844 */       localObject1 = SFashionDressCfg.get(paramInt3);
/* 845 */       if (localObject1 == null) {
/* 846 */         return null;
/*     */       }
/* 848 */       i = ((SFashionDressCfg)localObject1).clothesPressType; }
/*     */     Object localObject2;
/* 850 */     Object localObject3; if (paramBoolean) {
/* 851 */       localObject1 = (TransferOccupationRoleClothes)paramRoleClothes.getTransfer_occupation_role_clothes().get(Integer.valueOf(paramInt1));
/* 852 */       if (localObject1 == null) {
/* 853 */         localObject1 = (TransferOccupationRoleClothes)paramRoleClothes.getTransfer_occupation_role_clothes().get(Integer.valueOf(paramInt1 * 100 + paramInt2));
/*     */       }
/* 855 */       if (localObject1 == null) {
/* 856 */         return null;
/*     */       }
/* 858 */       localObject2 = (Integer)((TransferOccupationRoleClothes)localObject1).getFashion_dress_cloth_map().get(Integer.valueOf(i));
/* 859 */       if (localObject2 == null) {
/* 860 */         return null;
/*     */       }
/* 862 */       for (localObject3 = ((TransferOccupationRoleClothes)localObject1).getClothes().iterator(); ((Iterator)localObject3).hasNext();) { ClothColor localClothColor = (ClothColor)((Iterator)localObject3).next();
/* 863 */         if (localClothColor.getId() == ((Integer)localObject2).intValue()) {
/* 864 */           return localClothColor;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 869 */       localObject1 = (Integer)paramRoleClothes.getFashion_dress_cloth_map().get(Integer.valueOf(i));
/* 870 */       if (localObject1 == null) {
/* 871 */         return null;
/*     */       }
/* 873 */       for (localObject2 = paramRoleClothes.getClothes().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (ClothColor)((Iterator)localObject2).next();
/* 874 */         if (((ClothColor)localObject3).getId() == ((Integer)localObject1).intValue()) {
/* 875 */           return (ClothColor)localObject3;
/*     */         }
/*     */       }
/*     */     }
/* 879 */     return null;
/*     */   }
/*     */   
/*     */   static void tlogRemoveFashionDress(String paramString, long paramLong, int paramInt1, int paramInt2) {
/* 883 */     int i = RoleInterface.getLevel(paramLong);
/* 884 */     StringBuilder localStringBuilder = new StringBuilder();
/* 885 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 886 */     localStringBuilder.append(paramString).append('|');
/* 887 */     localStringBuilder.append(paramLong).append('|');
/* 888 */     localStringBuilder.append(i).append('|');
/* 889 */     localStringBuilder.append(paramInt1).append('|');
/* 890 */     localStringBuilder.append(paramInt2);
/* 891 */     TLogManager.getInstance().addLog(paramLong, "FashionDressDelete", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static void onUnlockFashionDress(String paramString, long paramLong, Role2FashionDressInfo paramRole2FashionDressInfo, int paramInt) {
/* 895 */     SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(paramInt);
/* 896 */     if (localSFashionDressCfg == null) {
/* 897 */       return;
/*     */     }
/* 899 */     if (paramRole2FashionDressInfo == null) {
/* 900 */       return;
/*     */     }
/* 902 */     int i = localSFashionDressCfg.fashionDressType;
/* 903 */     Set localSet = paramRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set();
/* 904 */     HashSet localHashSet = new HashSet();
/* 905 */     for (Object localObject = SThemeFashionDressUnlockTypeCfg.getAll().values().iterator(); ((Iterator)localObject).hasNext();) { SThemeFashionDressUnlockTypeCfg localSThemeFashionDressUnlockTypeCfg = (SThemeFashionDressUnlockTypeCfg)((Iterator)localObject).next();
/* 906 */       int j = localSThemeFashionDressUnlockTypeCfg.unlock_fashion_dress_type_Id;
/* 907 */       if ((localSThemeFashionDressUnlockTypeCfg.type_list.contains(Integer.valueOf(i))) && (!localSet.contains(Integer.valueOf(j)))) {
/* 908 */         localSet.add(Integer.valueOf(j));
/* 909 */         localHashSet.add(Integer.valueOf(j));
/* 910 */         tlogUnlockThemeFashionTypeId(paramString, paramLong, 1, j);
/*     */       }
/*     */     }
/* 913 */     if (!localHashSet.isEmpty()) {
/* 914 */       if (isThemeFashionDressSwitchOpenForRole(paramLong)) {
/* 915 */         TriggerEventsManger.getInstance().triggerEvent(new ThemeFashionDressPropertyChange(), new ThemeFashionDressPropertyChangeArg(paramLong, localSet), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramLong)));
/* 916 */         refreshTimeLimitedThemeFashionDressBuff(paramLong);
/*     */       }
/* 918 */       localObject = new SSyncThemeFashionDressUpdateInfo();
/* 919 */       ((SSyncThemeFashionDressUpdateInfo)localObject).add_set.addAll(localHashSet);
/* 920 */       OnlineManager.getInstance().send(paramLong, (Protocol)localObject);
/*     */     }
/*     */   }
/*     */   
/*     */   static void onFashionDressExpired(String paramString, long paramLong, Role2FashionDressInfo paramRole2FashionDressInfo, int paramInt) {
/* 925 */     SFashionDressCfg localSFashionDressCfg1 = SFashionDressCfg.get(paramInt);
/* 926 */     if (localSFashionDressCfg1 == null) {
/* 927 */       return;
/*     */     }
/* 929 */     if (paramRole2FashionDressInfo == null) {
/* 930 */       return;
/*     */     }
/* 932 */     int i = localSFashionDressCfg1.fashionDressType;
/* 933 */     Set localSet = paramRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set();
/* 934 */     HashSet localHashSet = new HashSet();
/* 935 */     for (Object localObject = SThemeFashionDressUnlockTypeCfg.getAll().values().iterator(); ((Iterator)localObject).hasNext();) { SThemeFashionDressUnlockTypeCfg localSThemeFashionDressUnlockTypeCfg = (SThemeFashionDressUnlockTypeCfg)((Iterator)localObject).next();
/* 936 */       int j = localSThemeFashionDressUnlockTypeCfg.unlock_fashion_dress_type_Id;
/* 937 */       if ((localSThemeFashionDressUnlockTypeCfg.type_list.contains(Integer.valueOf(i))) && (localSet.contains(Integer.valueOf(j)))) {
/* 938 */         int k = 1;
/* 939 */         for (Iterator localIterator = paramRole2FashionDressInfo.getFashion_dress_map().keySet().iterator(); localIterator.hasNext();) { int m = ((Integer)localIterator.next()).intValue();
/* 940 */           SFashionDressCfg localSFashionDressCfg2 = SFashionDressCfg.get(m);
/* 941 */           if (localSFashionDressCfg2 != null)
/*     */           {
/*     */ 
/* 944 */             if (localSThemeFashionDressUnlockTypeCfg.type_list.contains(Integer.valueOf(localSFashionDressCfg2.fashionDressType))) {
/* 945 */               k = 0;
/* 946 */               break;
/*     */             } }
/*     */         }
/* 949 */         if (k != 0)
/*     */         {
/*     */ 
/* 952 */           localSet.remove(Integer.valueOf(j));
/* 953 */           localHashSet.add(Integer.valueOf(j));
/* 954 */           tlogUnlockThemeFashionTypeId(paramString, paramLong, 2, j);
/*     */         }
/*     */       } }
/* 957 */     if (!localHashSet.isEmpty()) {
/* 958 */       if (isThemeFashionDressSwitchOpenForRole(paramLong)) {
/* 959 */         TriggerEventsManger.getInstance().triggerEvent(new ThemeFashionDressPropertyChange(), new ThemeFashionDressPropertyChangeArg(paramLong, localSet), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramLong)));
/* 960 */         refreshTimeLimitedThemeFashionDressBuff(paramLong);
/*     */       }
/* 962 */       localObject = new SSyncThemeFashionDressUpdateInfo();
/* 963 */       ((SSyncThemeFashionDressUpdateInfo)localObject).delete_set.addAll(localHashSet);
/* 964 */       OnlineManager.getInstance().send(paramLong, (Protocol)localObject);
/*     */     }
/*     */   }
/*     */   
/*     */   static {
/* 969 */     (newYearFashionDressCfgIdSet = new HashSet()).add(Integer.valueOf(860000208));
/* 970 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000209));
/* 971 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000210));
/* 972 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000211));
/* 973 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000212));
/* 974 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000213));
/* 975 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000214));
/* 976 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000215));
/* 977 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000216));
/* 978 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000217));
/* 979 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000218));
/* 980 */     newYearFashionDressCfgIdSet.add(Integer.valueOf(860000219)); }
/* 981 */   static volatile boolean postInitFlag = false;
/*     */   
/*     */   private static class CheckResult
/*     */   {
/*     */     private boolean isContainForeverNewYearFashionDress;
/*     */     private long foreverNewYearFashionDressBuyTime;
/*     */     
/*     */     private CheckResult()
/*     */     {
/* 990 */       this.isContainForeverNewYearFashionDress = false;
/* 991 */       this.foreverNewYearFashionDressBuyTime = 0L;
/*     */     }
/*     */     
/*     */     public void setContainForevenNewYearFashionDress(boolean paramBoolean) {
/* 995 */       this.isContainForeverNewYearFashionDress = paramBoolean;
/*     */     }
/*     */     
/*     */     public void setForeverNewYearFashionDressBuyTime(long paramLong) {
/* 999 */       this.foreverNewYearFashionDressBuyTime = paramLong;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\FashionDressManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */