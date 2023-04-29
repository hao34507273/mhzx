/*     */ package mzm.gsp.christmasstocking.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingTreePosCfg;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasHiddenStockingAdd;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasHiddenStockingAddArg;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasHiddenStockingRemove;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasHiddenStockingRemoveArg;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasStockingTreeAdd;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasStockingTreeAddArg;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasStockingTreeRemove;
/*     */ import mzm.gsp.christmasstocking.event.ChristmasStockingTreeRemoveArg;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChristmasTreePositionInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2ChristmasStockingInfo;
/*     */ import xtable.Role2christmasstockinginfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ChristmasStockingManager
/*     */ {
/*     */   static Role2ChristmasStockingInfo getRole2ChristmasStockingInfo(long roleId)
/*     */   {
/*  52 */     Role2ChristmasStockingInfo xRole2ChristmasStockingInfo = Role2christmasstockinginfo.get(Long.valueOf(roleId));
/*  53 */     if (null == xRole2ChristmasStockingInfo)
/*     */     {
/*  55 */       xRole2ChristmasStockingInfo = Pod.newRole2ChristmasStockingInfo();
/*  56 */       Role2christmasstockinginfo.add(Long.valueOf(roleId), xRole2ChristmasStockingInfo);
/*     */     }
/*  58 */     return xRole2ChristmasStockingInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isChristmasStockingOpen(long roleId)
/*     */   {
/*  69 */     if (!OpenInterface.getOpenStatus(582))
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     if (OpenInterface.isBanPlay(roleId, 582))
/*     */     {
/*  75 */       OpenInterface.sendBanPlayMsg(roleId, 582);
/*  76 */       return false;
/*     */     }
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isChristmasStockingHidingOpen(long roleId)
/*     */   {
/*  89 */     if (!OpenInterface.getOpenStatus(583))
/*     */     {
/*  91 */       return false;
/*     */     }
/*  93 */     if (OpenInterface.isBanPlay(roleId, 583))
/*     */     {
/*  95 */       OpenInterface.sendBanPlayMsg(roleId, 583);
/*  96 */       return false;
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerTreeAddEvent()
/*     */   {
/* 107 */     ChristmasStockingTreeAddArg arg = new ChristmasStockingTreeAddArg();
/* 108 */     TriggerEventsManger.getInstance().triggerEvent(new ChristmasStockingTreeAdd(), arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerTreeRemoveEvent()
/*     */   {
/* 117 */     ChristmasStockingTreeRemoveArg arg = new ChristmasStockingTreeRemoveArg();
/* 118 */     TriggerEventsManger.getInstance().triggerEvent(new ChristmasStockingTreeRemove(), arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerStockingAddEvent()
/*     */   {
/* 127 */     ChristmasHiddenStockingAddArg arg = new ChristmasHiddenStockingAddArg();
/* 128 */     TriggerEventsManger.getInstance().triggerEvent(new ChristmasHiddenStockingAdd(), arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerStockingRemoveEvent()
/*     */   {
/* 137 */     ChristmasHiddenStockingRemoveArg arg = new ChristmasHiddenStockingRemoveArg();
/* 138 */     TriggerEventsManger.getInstance().triggerEvent(new ChristmasHiddenStockingRemove(), arg);
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
/*     */   static boolean tryOfferChristmasStockingAward(long roleId, Role2ChristmasStockingInfo xRole2ChristmasStockingInfo, boolean updateMapEntity)
/*     */   {
/* 153 */     if (!isActivityOpenOrNeedRetain())
/*     */     {
/* 155 */       return false;
/*     */     }
/* 157 */     boolean updated = false;
/* 158 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 159 */     int offerAwardCommonTimeCfgId = SChristmasStockingConsts.getInstance().OFFER_AWARD_COMMON_TIME_CFG_ID;
/* 160 */     STimeCommonCfg sTimeCommonCfg = STimeCommonCfg.get(offerAwardCommonTimeCfgId);
/* 161 */     for (ChristmasTreePositionInfo xChristmasTreePositionInfo : xRole2ChristmasStockingInfo.getChristmastreepositionindex2info().values())
/*     */     {
/* 163 */       boolean needUpdate = DateTimeUtils.needDailyReset(xChristmasTreePositionInfo.getHangtime(), currentTimeMillis, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute);
/*     */       
/* 165 */       if ((needUpdate) && (!xChristmasTreePositionInfo.getCanaward()))
/*     */       {
/* 167 */         updated = true;
/* 168 */         xChristmasTreePositionInfo.setCanaward(true);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 173 */     if ((updated) && (updateMapEntity))
/*     */     {
/* 175 */       Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 176 */       for (int i = 1; i <= SChristmasStockingConsts.getInstance().TREE_HANG_MAX_NUM; i++)
/*     */       {
/* 178 */         int extraInfoType = 1900 + i - 1;
/*     */         
/* 180 */         ChristmasTreePositionInfo xTreePositionInfo = (ChristmasTreePositionInfo)xRole2ChristmasStockingInfo.getChristmastreepositionindex2info().get(Integer.valueOf(i));
/*     */         int state;
/* 182 */         int state; if (null == xTreePositionInfo)
/*     */         {
/* 184 */           state = 1;
/*     */         } else { int state;
/* 186 */           if (xTreePositionInfo.getCanaward())
/*     */           {
/* 188 */             state = 3;
/*     */           }
/*     */           else
/*     */           {
/* 192 */             state = 2; }
/*     */         }
/* 194 */         intExtraInfoEntries.put(Integer.valueOf(extraInfoType), Integer.valueOf(state));
/*     */       }
/*     */       
/* 197 */       MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CHRISTMAS_STOCKING, roleId, intExtraInfoEntries, null, null, null, null);
/*     */     }
/*     */     
/*     */ 
/* 201 */     return updated;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void updateMapEntityPositionState(long roleId, int position, int state)
/*     */   {
/* 213 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 214 */     int extraInfoType = 1900 + position - 1;
/* 215 */     intExtraInfoEntries.put(Integer.valueOf(extraInfoType), Integer.valueOf(state));
/* 216 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CHRISTMAS_STOCKING, roleId, intExtraInfoEntries, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isActivityOpenOrNeedRetain()
/*     */   {
/* 228 */     int activityCfgId = SChristmasStockingConsts.getInstance().ACTIVITY_ID;
/* 229 */     if (ActivityInterface.isActivityOpen(activityCfgId))
/*     */     {
/* 231 */       return true;
/*     */     }
/* 233 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityCfgId);
/* 234 */     long activityStartTime = TimeCommonUtil.getLimitTimeBegin(sActivityCfg.activityLimitTimeid);
/* 235 */     long activityEndTime = TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/* 236 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 237 */     long retainMilliSecs = SChristmasStockingConsts.getInstance().AFTER_ACTIVITY_RETAIN_MINUTES * 60000L;
/*     */     
/* 239 */     long activityAlreadyEndTime = currentTime - activityEndTime;
/* 240 */     return (currentTime >= activityStartTime) && (activityAlreadyEndTime < retainMilliSecs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTotalHangNum(Role2ChristmasStockingInfo xRole2StockingInfo)
/*     */   {
/* 251 */     int totalNum = 0;
/* 252 */     for (Iterator i$ = xRole2StockingInfo.getTargetroleid2selfhangnum().values().iterator(); i$.hasNext();) { int singleNum = ((Integer)i$.next()).intValue();
/*     */       
/* 254 */       totalNum += singleNum;
/*     */     }
/* 256 */     return totalNum;
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
/*     */   static void addTreeForRole(long ownerRoleId, long homelandWorldId, int courtyardMapCfgId, int courtyardLevel)
/*     */   {
/* 273 */     if (!isChristmasStockingOpen(ownerRoleId))
/*     */     {
/* 275 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 281 */     SChristmasStockingTreePosCfg sTreePosCfg = SChristmasStockingTreePosCfg.get(courtyardLevel);
/* 282 */     int posY; int posX; int posY; if (HomelandInterface.isCurrentHomeCreator(ownerRoleId))
/*     */     {
/* 284 */       int posX = sTreePosCfg.tree1PosX;
/* 285 */       posY = sTreePosCfg.tree1PosY;
/*     */     }
/*     */     else
/*     */     {
/* 289 */       posX = sTreePosCfg.tree2PosX;
/* 290 */       posY = sTreePosCfg.tree2PosY;
/*     */     }
/*     */     
/*     */ 
/* 294 */     Role2ChristmasStockingInfo xRole2ChristmasStockingInfo = getRole2ChristmasStockingInfo(ownerRoleId);
/* 295 */     tryOfferChristmasStockingAward(ownerRoleId, xRole2ChristmasStockingInfo, false);
/*     */     
/*     */ 
/* 298 */     Map<Integer, Integer> extraInfoIntMap = new HashMap();
/* 299 */     for (int i = 1; i <= SChristmasStockingConsts.getInstance().TREE_HANG_MAX_NUM; i++)
/*     */     {
/* 301 */       int extraInfoType = 1900 + i - 1;
/*     */       
/* 303 */       ChristmasTreePositionInfo xTreePositionInfo = (ChristmasTreePositionInfo)xRole2ChristmasStockingInfo.getChristmastreepositionindex2info().get(Integer.valueOf(i));
/*     */       int state;
/* 305 */       int state; if (null == xTreePositionInfo)
/*     */       {
/* 307 */         state = 1;
/*     */       } else { int state;
/* 309 */         if (xTreePositionInfo.getCanaward())
/*     */         {
/* 311 */           state = 3;
/*     */         }
/*     */         else
/*     */         {
/* 315 */           state = 2; }
/*     */       }
/* 317 */       extraInfoIntMap.put(Integer.valueOf(extraInfoType), Integer.valueOf(state));
/*     */     }
/* 319 */     Map<Integer, Long> extraInfoLongMap = new HashMap();
/* 320 */     extraInfoLongMap.put(Integer.valueOf(1920), Long.valueOf(ownerRoleId));
/* 321 */     Map<Integer, String> extraInfoStringMap = new HashMap();
/* 322 */     extraInfoStringMap.put(Integer.valueOf(1921), RoleInterface.getName(ownerRoleId));
/*     */     
/*     */ 
/* 325 */     MapInterface.addMapEntity(MapEntityType.MET_CHRISTMAS_STOCKING, ownerRoleId, homelandWorldId, courtyardMapCfgId, posX, posY, -1, extraInfoIntMap, extraInfoLongMap, extraInfoStringMap, null);
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
/*     */   static void addStockingToCourtyard(long ownerRoleId, long partnerRoleId, long homelandWorldId)
/*     */   {
/* 339 */     int spawnNum = 0;
/* 340 */     Role2ChristmasStockingInfo xOwner2StockingInfo = getRole2ChristmasStockingInfo(ownerRoleId);
/* 341 */     spawnNum = canGetStockingHidingAward(xOwner2StockingInfo) ? spawnNum + 1 : spawnNum;
/*     */     
/* 343 */     if (partnerRoleId > 0L)
/*     */     {
/* 345 */       Role2ChristmasStockingInfo xPartner2StockingInfo = getRole2ChristmasStockingInfo(partnerRoleId);
/* 346 */       spawnNum = canGetStockingHidingAward(xPartner2StockingInfo) ? spawnNum + 1 : spawnNum;
/*     */     }
/*     */     
/* 349 */     if (spawnNum == 0)
/*     */     {
/* 351 */       return;
/*     */     }
/*     */     
/* 354 */     int controllerId = SChristmasStockingHidingConsts.getInstance().CONTROLLER_ID;
/* 355 */     ControllerInterface.collectWorldController(homelandWorldId, controllerId);
/* 356 */     ControllerInterface.triggerWorldControllerWithMaxSpawnNum(homelandWorldId, controllerId, spawnNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendStokingHidingNotifyMail(long roleId)
/*     */   {
/* 368 */     Role2ChristmasStockingInfo xRole2StockingInfo = getRole2ChristmasStockingInfo(roleId);
/* 369 */     if (xRole2StockingInfo.getHasgotstockinghidingmail())
/*     */     {
/* 371 */       return;
/*     */     }
/* 373 */     int mailCfgId = SChristmasStockingHidingConsts.getInstance().NOTIFY_MAIL_CFG_ID;
/* 374 */     TLogArg tLogArg = new TLogArg(LogReason.CHRISTMAS_STOCKING_HIDING_NOTIFY_MAIL);
/* 375 */     SendMailRet ret = MailInterface.synBuildAndSendMail(roleId, mailCfgId, null, null, tLogArg);
/* 376 */     if (ret.isOK())
/*     */     {
/* 378 */       xRole2StockingInfo.setHasgotstockinghidingmail(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canGetStockingHidingAward(Role2ChristmasStockingInfo xRole2StockingInfo)
/*     */   {
/* 390 */     return xRole2StockingInfo.getGetstockinghidingawardnum() == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendAwardBulletin(long roleId, int itemId, int itemNum)
/*     */   {
/* 402 */     if (ItemBulletinInterface.needBulletin(itemId))
/*     */     {
/* 404 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 405 */       bulletinInfo.bulletintype = 53;
/* 406 */       bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleId));
/* 407 */       bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemId));
/* 408 */       bulletinInfo.params.put(Integer.valueOf(15), String.valueOf(itemNum));
/* 409 */       BulletinInterface.sendBulletin(bulletinInfo);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\ChristmasStockingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */