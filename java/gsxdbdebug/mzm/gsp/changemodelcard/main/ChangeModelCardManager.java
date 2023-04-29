/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.changemodelcard.CardInfo;
/*     */ import mzm.gsp.changemodelcard.SNotifyCardExpireSoon;
/*     */ import mzm.gsp.changemodelcard.SNotifyCardRemove;
/*     */ import mzm.gsp.changemodelcard.SSynCardInfo;
/*     */ import mzm.gsp.changemodelcard.SSynRoleCardInfo;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelCfg;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardCfg;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateAdd;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateArg;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateRemove;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardUnlock;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardUnlockArg;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardVisibleChange;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardSessionInfo;
/*     */ import xtable.Role2changemodelcard;
/*     */ import xtable.Role2changemodelcardsessioninfo;
/*     */ 
/*     */ class ChangeModelCardManager
/*     */ {
/*     */   public static enum RemoveCardReason
/*     */   {
/*  41 */     REACH_MAX_USE_COUNT(1),  LEVEL_UP(2),  DECOMPOSE(3),  IDIP(4);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private RemoveCardReason(int value)
/*     */     {
/*  47 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum RemoveCardStateReason
/*     */   {
/*  56 */     TIME_OUT(1),  REACH_MAX_PVP_COUNT(2),  ACTIVE_CANCEL(3),  REPLACE(4),  IDIP(5);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private RemoveCardStateReason(int value)
/*     */     {
/*  62 */       this.value = value;
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
/*     */   static boolean checkRoleLevel(long roleId)
/*     */   {
/*  75 */     int roleLevel = RoleInterface.getLevel(roleId);
/*  76 */     return roleLevel >= SChangeModelCardConsts.getInstance().OPEN_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isChangeModelCardOpen(long roleId)
/*     */   {
/*  88 */     if (!OpenInterface.getOpenStatus(510))
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     if (OpenInterface.isBanPlay(roleId, 510))
/*     */     {
/*  94 */       OpenInterface.sendBanPlayMsg(roleId, 510);
/*  95 */       return false;
/*     */     }
/*  97 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Role2ChangeModelCardInfo getRole2CardInfo(long roleId)
/*     */   {
/* 109 */     Role2ChangeModelCardInfo xRole2CardInfo = Role2changemodelcard.get(Long.valueOf(roleId));
/* 110 */     if (null == xRole2CardInfo)
/*     */     {
/* 112 */       xRole2CardInfo = Pod.newRole2ChangeModelCardInfo();
/* 113 */       Role2changemodelcard.add(Long.valueOf(roleId), xRole2CardInfo);
/*     */     }
/* 115 */     return xRole2CardInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Role2ChangeModelCardSessionInfo getRole2CardSessionInfo(long roleId)
/*     */   {
/* 126 */     Role2ChangeModelCardSessionInfo xRole2CardSessionInfo = Role2changemodelcardsessioninfo.get(Long.valueOf(roleId));
/* 127 */     if (null == xRole2CardSessionInfo)
/*     */     {
/* 129 */       xRole2CardSessionInfo = Pod.newRole2ChangeModelCardSessionInfo();
/* 130 */       Role2changemodelcardsessioninfo.add(Long.valueOf(roleId), xRole2CardSessionInfo);
/*     */     }
/* 132 */     return xRole2CardSessionInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initRole2CardInfo(Role2ChangeModelCardInfo xRole2CardInfo)
/*     */   {
/* 142 */     xRole2CardInfo.setCurrent_card_cfg_id(0);
/* 143 */     xRole2CardInfo.setCurrent_card_level(0);
/* 144 */     xRole2CardInfo.setFight_count(0);
/* 145 */     xRole2CardInfo.setOverlay_count(0);
/* 146 */     xRole2CardInfo.setStart_time(0L);
/* 147 */     xRole2CardInfo.setVisible(true);
/* 148 */     xRole2CardInfo.setActivated_in_fight(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isChangeModelCardActivated(Role2ChangeModelCardInfo xRole2CardInfo)
/*     */   {
/* 158 */     return xRole2CardInfo.getCurrent_card_cfg_id() > 0;
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
/*     */   static long addChangeModelCard(long roleId, Role2ChangeModelCardInfo xRole2ChangeModelCardInfo, int cardCfgId, int cardLevel)
/*     */   {
/* 173 */     SCardLevelCfg sCardLevelCfg = SCardLevelCfg.get(cardCfgId);
/* 174 */     if (null == sCardLevelCfg)
/*     */     {
/*     */ 
/* 177 */       return 0L;
/*     */     }
/* 179 */     if (!sCardLevelCfg.level2Bean.containsKey(Integer.valueOf(cardLevel)))
/*     */     {
/*     */ 
/* 182 */       return 0L;
/*     */     }
/*     */     
/*     */ 
/* 186 */     ChangeModelCardInfo xChangeModelCardInfo = Pod.newChangeModelCardInfo();
/* 187 */     xChangeModelCardInfo.setCard_cfg_id(cardCfgId);
/* 188 */     xChangeModelCardInfo.setLevel(cardLevel);
/* 189 */     long cardId = xRole2ChangeModelCardInfo.getNext_card_id();
/* 190 */     xRole2ChangeModelCardInfo.setNext_card_id(cardId + 1L);
/* 191 */     xRole2ChangeModelCardInfo.getCardid2info().put(Long.valueOf(cardId), xChangeModelCardInfo);
/*     */     
/*     */ 
/* 194 */     ChangeModelCardTLogManager.addChangeModelCardAddTlog(roleId, cardId, cardCfgId, cardLevel);
/*     */     
/*     */ 
/* 197 */     ChangeModelCardUnlockArg arg = new ChangeModelCardUnlockArg(roleId, cardCfgId, cardLevel);
/* 198 */     TriggerEventsManger.getInstance().triggerEvent(new ChangeModelCardUnlock(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/* 201 */     return cardId;
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
/*     */   static boolean removeChangeModelCard(long roleId, Role2ChangeModelCardInfo xRole2ChangeModelCardInfo, Collection<Long> cardIds, RemoveCardReason reason)
/*     */   {
/* 218 */     for (Iterator i$ = cardIds.iterator(); i$.hasNext();) { long cardId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 221 */       ChangeModelCardInfo xCardInfo = (ChangeModelCardInfo)xRole2ChangeModelCardInfo.getCardid2info().remove(Long.valueOf(cardId));
/* 222 */       if (null == xCardInfo)
/*     */       {
/*     */ 
/* 225 */         String logstr = String.format("[changemodelcard]ChangeModelCardManager.removeChangeModelCard@card not exist!|roleId=%d,cardId=%d,xRole2ChangeModelCardInfo=%s", new Object[] { Long.valueOf(roleId), Long.valueOf(cardId), xRole2ChangeModelCardInfo });
/*     */         
/*     */ 
/* 228 */         mzm.gsp.GameServer.logger().warn(logstr);
/* 229 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 233 */       int cardCfgId = xCardInfo.getCard_cfg_id();
/* 234 */       int cardLevel = xCardInfo.getLevel();
/*     */       
/* 236 */       ChangeModelCardTLogManager.addChangeModelCardRemoveTlog(roleId, cardId, cardCfgId, cardLevel, reason);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 241 */     SNotifyCardRemove proto = new SNotifyCardRemove();
/* 242 */     proto.card_ids.addAll(cardIds);
/* 243 */     OnlineManager.getInstance().send(roleId, proto);
/*     */     
/* 245 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static CardInfo packageCardInfoBean(ChangeModelCardInfo xCardInfo)
/*     */   {
/* 256 */     CardInfo bean = new CardInfo();
/* 257 */     bean.card_cfg_id = xCardInfo.getCard_cfg_id();
/* 258 */     bean.level = xCardInfo.getLevel();
/* 259 */     bean.exp = xCardInfo.getExp();
/* 260 */     bean.use_count = xCardInfo.getUse_count();
/*     */     
/* 262 */     return bean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synRoleCardInfo(long roleId, Role2ChangeModelCardInfo xRole2CardInfo)
/*     */   {
/* 273 */     SSynCardInfo proto = new SSynCardInfo();
/* 274 */     proto.current_card_cfg_id = xRole2CardInfo.getCurrent_card_cfg_id();
/* 275 */     proto.current_card_level = xRole2CardInfo.getCurrent_card_level();
/* 276 */     proto.fight_count = xRole2CardInfo.getFight_count();
/* 277 */     proto.overlay_count = xRole2CardInfo.getOverlay_count();
/* 278 */     proto.start_time = xRole2CardInfo.getStart_time();
/* 279 */     proto.visible = ((byte)(xRole2CardInfo.getVisible() ? 1 : 0));
/*     */     
/* 281 */     for (Map.Entry<Long, ChangeModelCardInfo> entry : xRole2CardInfo.getCardid2info().entrySet())
/*     */     {
/* 283 */       ChangeModelCardInfo xCardInfo = (ChangeModelCardInfo)entry.getValue();
/* 284 */       CardInfo cardInfoBean = packageCardInfoBean(xCardInfo);
/* 285 */       proto.card_info_map.put(entry.getKey(), cardInfoBean);
/*     */     }
/* 287 */     OnlineManager.getInstance().send(roleId, proto);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synRoleCardInfoChange(long roleId, Role2ChangeModelCardInfo xRole2CardInfo)
/*     */   {
/* 298 */     SSynRoleCardInfo sSynRoleCardInfo = new SSynRoleCardInfo();
/* 299 */     sSynRoleCardInfo.current_card_cfg_id = xRole2CardInfo.getCurrent_card_cfg_id();
/* 300 */     sSynRoleCardInfo.current_card_level = xRole2CardInfo.getCurrent_card_level();
/* 301 */     sSynRoleCardInfo.fight_count = xRole2CardInfo.getFight_count();
/* 302 */     sSynRoleCardInfo.overlay_count = xRole2CardInfo.getOverlay_count();
/* 303 */     sSynRoleCardInfo.start_time = xRole2CardInfo.getStart_time();
/* 304 */     sSynRoleCardInfo.visible = ((byte)(xRole2CardInfo.getVisible() ? 1 : 0));
/*     */     
/* 306 */     OnlineManager.getInstance().send(roleId, sSynRoleCardInfo);
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
/*     */   static boolean addChangeModelState(long roleId, Role2ChangeModelCardInfo xRole2CardInfo, SCardLevelBean sCardLevelBean, SChangeModelCardCfg sChangeModelCardCfg)
/*     */   {
/* 320 */     int oldCardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/* 321 */     int oldCardLevel = xRole2CardInfo.getCurrent_card_level();
/*     */     
/*     */     int newOverlayCount;
/* 324 */     if ((oldCardCfgId == sCardLevelBean.cardCfgId) && (oldCardLevel == sCardLevelBean.level))
/*     */     {
/* 326 */       int currentOverlayCount = xRole2CardInfo.getOverlay_count();
/*     */       
/* 328 */       if (currentOverlayCount >= SChangeModelCardConsts.getInstance().MAX_OVERLAY_COUNT)
/*     */       {
/* 330 */         return false;
/*     */       }
/*     */       
/* 333 */       int newOverlayCount = currentOverlayCount + 1;
/* 334 */       xRole2CardInfo.setOverlay_count(newOverlayCount);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 339 */       tryRemoveChangeModelState(roleId, xRole2CardInfo, RemoveCardStateReason.REPLACE);
/*     */       
/*     */ 
/* 342 */       newOverlayCount = 1;
/* 343 */       long newStartTime = DateTimeUtils.getCurrTimeInMillis();
/* 344 */       xRole2CardInfo.setCurrent_card_cfg_id(sCardLevelBean.cardCfgId);
/* 345 */       xRole2CardInfo.setCurrent_card_level(sCardLevelBean.level);
/* 346 */       xRole2CardInfo.setOverlay_count(newOverlayCount);
/* 347 */       xRole2CardInfo.setFight_count(0);
/* 348 */       xRole2CardInfo.setStart_time(newStartTime);
/* 349 */       xRole2CardInfo.setVisible(true);
/*     */       
/* 351 */       if (mzm.gsp.status.main.RoleStatusInterface.containsAny(roleId, java.util.Collections.singleton(Integer.valueOf(0)), true))
/*     */       {
/* 353 */         xRole2CardInfo.setActivated_in_fight(true);
/*     */       }
/*     */       else
/*     */       {
/* 357 */         xRole2CardInfo.setActivated_in_fight(false);
/*     */       }
/*     */       
/*     */ 
/* 361 */       long mainIntervalSec = sCardLevelBean.effectPersistMinute * 60L;
/* 362 */       long mainSessionId = new ChangeModelCardExpireSession(newStartTime, mainIntervalSec, roleId).getSessionId();
/* 363 */       Role2ChangeModelCardSessionInfo xCardSessionInfo = getRole2CardSessionInfo(roleId);
/* 364 */       xCardSessionInfo.setMain_session_id(mainSessionId);
/*     */       
/* 366 */       long notifyRemainSec = SChangeModelCardConsts.getInstance().EXPIRE_NOTIFY_REMAIN_MINUTES * 60L;
/*     */       
/* 368 */       long notifyIntervalSec = mainIntervalSec - notifyRemainSec;
/* 369 */       if (notifyIntervalSec <= 0L)
/*     */       {
/* 371 */         notifyIntervalSec = notifyIntervalSec % mainIntervalSec + mainIntervalSec;
/*     */       }
/* 373 */       long newNotifySessionId = new ChangeModelCardExpireNotifySession(notifyIntervalSec, roleId).getSessionId();
/* 374 */       xCardSessionInfo.setExpire_notify_session_id(newNotifySessionId);
/*     */       
/*     */ 
/* 377 */       TriggerEventsManger.getInstance().triggerEvent(new ChangeModelCardStateAdd(), new ChangeModelCardStateArg(roleId, sCardLevelBean.cardCfgId, sCardLevelBean.level, xRole2CardInfo.getVisible()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 385 */     synRoleCardInfoChange(roleId, xRole2CardInfo);
/*     */     
/*     */ 
/* 388 */     ChangeModelCardTLogManager.addChangeModelCardStateAddTlog(roleId, sCardLevelBean.cardCfgId, sCardLevelBean.level, newOverlayCount);
/*     */     
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
/*     */ 
/*     */ 
/*     */   static void tryRemoveChangeModelState(long roleId, Role2ChangeModelCardInfo xRole2CardInfo, RemoveCardStateReason reason)
/*     */   {
/* 407 */     if (!isChangeModelCardActivated(xRole2CardInfo))
/*     */     {
/* 409 */       return;
/*     */     }
/*     */     
/*     */ 
/* 413 */     ChangeModelCardTLogManager.addChangeModelCardStateRemoveTlog(roleId, xRole2CardInfo.getCurrent_card_cfg_id(), xRole2CardInfo.getCurrent_card_level(), reason);
/*     */     
/*     */ 
/*     */ 
/* 417 */     initRole2CardInfo(xRole2CardInfo);
/*     */     
/* 419 */     if (reason != RemoveCardStateReason.REPLACE)
/*     */     {
/*     */ 
/* 422 */       synRoleCardInfoChange(roleId, xRole2CardInfo);
/*     */       
/*     */ 
/* 425 */       ChangeModelCardStateArg arg = new ChangeModelCardStateArg(roleId, xRole2CardInfo.getCurrent_card_cfg_id(), xRole2CardInfo.getCurrent_card_level(), xRole2CardInfo.getVisible());
/*     */       
/*     */ 
/* 428 */       TriggerEventsManger.getInstance().triggerEvent(new ChangeModelCardStateRemove(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 433 */     Role2ChangeModelCardSessionInfo xCardSessionInfo = getRole2CardSessionInfo(roleId);
/* 434 */     ChangeModelCardExpireSession.removeSession(xCardSessionInfo.getMain_session_id());
/* 435 */     ChangeModelCardExpireSession.removeSession(xCardSessionInfo.getExpire_notify_session_id());
/* 436 */     xCardSessionInfo.setMain_session_id(0L);
/* 437 */     xCardSessionInfo.setExpire_notify_session_id(0L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerVisibleChangeEvent(long roleId, Role2ChangeModelCardInfo xRole2CardInfo)
/*     */   {
/* 448 */     ChangeModelCardStateArg arg = new ChangeModelCardStateArg(roleId, xRole2CardInfo.getCurrent_card_cfg_id(), xRole2CardInfo.getCurrent_card_level(), xRole2CardInfo.getVisible());
/*     */     
/*     */ 
/* 451 */     TriggerEventsManger.getInstance().triggerEvent(new ChangeModelCardVisibleChange(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
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
/*     */   static void consumePVPFightCount(long roleId, int count)
/*     */   {
/* 464 */     if (count <= 0)
/*     */     {
/* 466 */       return;
/*     */     }
/* 468 */     Role2ChangeModelCardInfo xRole2CardInfo = getRole2CardInfo(roleId);
/*     */     
/* 470 */     if (!isChangeModelCardActivated(xRole2CardInfo))
/*     */     {
/* 472 */       return;
/*     */     }
/*     */     
/* 475 */     if (checkActivatedInFight(xRole2CardInfo))
/*     */     {
/* 477 */       return;
/*     */     }
/*     */     
/* 480 */     int cardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/* 481 */     int cardLevel = xRole2CardInfo.getCurrent_card_level();
/* 482 */     SCardLevelBean sCardLevelCfg = ChangeModelCardCfgManager.getCardLevelCfg(cardCfgId, cardLevel);
/*     */     
/* 484 */     int newPvpFightCount = xRole2CardInfo.getFight_count() + count;
/*     */     
/* 486 */     if (null == sCardLevelCfg)
/*     */     {
/* 488 */       tryRemoveChangeModelState(roleId, xRole2CardInfo, RemoveCardStateReason.REACH_MAX_PVP_COUNT);
/* 489 */       return;
/*     */     }
/*     */     
/* 492 */     int oldFightCount = xRole2CardInfo.getFight_count();
/* 493 */     int oldOverlayCount = xRole2CardInfo.getOverlay_count();
/* 494 */     int needOverlayCount = newPvpFightCount / sCardLevelCfg.effectPersistPVPFight;
/*     */     
/* 496 */     if (needOverlayCount >= xRole2CardInfo.getOverlay_count())
/*     */     {
/* 498 */       tryRemoveChangeModelState(roleId, xRole2CardInfo, RemoveCardStateReason.REACH_MAX_PVP_COUNT);
/*     */ 
/*     */     }
/* 501 */     else if (needOverlayCount >= 1)
/*     */     {
/* 503 */       int newOverlayCount = xRole2CardInfo.getOverlay_count() - needOverlayCount;
/* 504 */       xRole2CardInfo.setOverlay_count(newOverlayCount);
/* 505 */       xRole2CardInfo.setFight_count(newPvpFightCount - sCardLevelCfg.effectPersistPVPFight * needOverlayCount);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 511 */       xRole2CardInfo.setFight_count(newPvpFightCount);
/*     */     }
/*     */     
/* 514 */     synRoleCardInfoChange(roleId, xRole2CardInfo);
/*     */     
/* 516 */     int needNotifyPvpCount = SChangeModelCardConsts.getInstance().EXPIRE_NOTIFY_REMAIN_PVP_COUNT;
/* 517 */     if ((xRole2CardInfo.getOverlay_count() * sCardLevelCfg.effectPersistPVPFight - xRole2CardInfo.getFight_count() <= needNotifyPvpCount) && (oldOverlayCount * sCardLevelCfg.effectPersistPVPFight - oldFightCount > needNotifyPvpCount))
/*     */     {
/*     */ 
/* 520 */       sendExpireNotifyProto(roleId, 2);
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
/*     */   static boolean addCardExp(ChangeModelCardInfo xCardInfo, int exp)
/*     */   {
/* 533 */     SCardLevelBean sCardLevelCfg = ChangeModelCardCfgManager.getCardLevelCfg(xCardInfo.getCard_cfg_id(), xCardInfo.getLevel());
/*     */     
/*     */ 
/* 536 */     if (sCardLevelCfg.upgradeExp <= 0)
/*     */     {
/* 538 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 542 */     xCardInfo.setExp(xCardInfo.getExp() + exp);
/*     */     
/*     */ 
/* 545 */     checkCardUpgrade(xCardInfo);
/*     */     
/* 547 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkCardUpgrade(ChangeModelCardInfo xCardInfo)
/*     */   {
/* 557 */     SCardLevelBean sCardLevelCfg = ChangeModelCardCfgManager.getCardLevelCfg(xCardInfo.getCard_cfg_id(), xCardInfo.getLevel());
/*     */     
/* 559 */     int needExp = sCardLevelCfg.upgradeExp;
/* 560 */     if ((needExp > 0) && (xCardInfo.getExp() >= needExp))
/*     */     {
/* 562 */       xCardInfo.setLevel(xCardInfo.getLevel() + 1);
/* 563 */       xCardInfo.setExp(xCardInfo.getExp() - needExp);
/* 564 */       checkCardUpgrade(xCardInfo);
/* 565 */       return true;
/*     */     }
/* 567 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkActivatedInFight(Role2ChangeModelCardInfo xRole2ChangeModelCardInfo)
/*     */   {
/* 578 */     boolean result = xRole2ChangeModelCardInfo.getActivated_in_fight();
/* 579 */     if (result)
/*     */     {
/* 581 */       xRole2ChangeModelCardInfo.setActivated_in_fight(false);
/*     */     }
/* 583 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendExpireNotifyProto(long roleId, int type)
/*     */   {
/* 594 */     SNotifyCardExpireSoon proto = new SNotifyCardExpireSoon();
/* 595 */     proto.notify_type = type;
/* 596 */     OnlineManager.getInstance().send(roleId, proto);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\ChangeModelCardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */