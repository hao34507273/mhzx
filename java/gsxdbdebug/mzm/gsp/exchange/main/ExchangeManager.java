/*     */ package mzm.gsp.exchange.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.exchange.SExchangeAwardFail;
/*     */ import mzm.gsp.exchange.SExchangeAwardSuccess;
/*     */ import mzm.gsp.exchange.SSyncExchangeInfo;
/*     */ import mzm.gsp.exchange.confbean.NeedItemInfo;
/*     */ import mzm.gsp.exchange.confbean.SExchangeCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ExchangeInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2exchangeinfo;
/*     */ 
/*     */ 
/*     */ public class ExchangeManager
/*     */ {
/*  38 */   static Logger logger = Logger.getLogger("exchange");
/*     */   
/*     */   static void init()
/*     */   {
/*  42 */     ExchangeActivityHandler handler = new ExchangeActivityHandler();
/*  43 */     ActivityInterface.registerActivityByLogicType(46, handler);
/*  44 */     regesiterActivityAwardAccess();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final void regesiterActivityAwardAccess()
/*     */   {
/*  52 */     for (Iterator i$ = SExchangeCfg.getAll().values().iterator(); i$.hasNext();) { exchangeCfg = (SExchangeCfg)i$.next();
/*     */       
/*  54 */       for (mzm.gsp.exchange.confbean.ExchangeAwardInfo exchangeAwardInfo : exchangeCfg.exchange_award_info_map.values())
/*     */       {
/*  56 */         ItemAccessManager.registerActivityFixReward(exchangeCfg.id, exchangeAwardInfo.award_cfg_id);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     SExchangeCfg exchangeCfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static final boolean onRoleLogin(String userid, long roleid)
/*     */   {
/*  72 */     ExchangeInfo xExchangeInfo = Role2exchangeinfo.get(Long.valueOf(roleid));
/*  73 */     if (xExchangeInfo == null)
/*     */     {
/*  75 */       xExchangeInfo = Pod.newExchangeInfo();
/*  76 */       Role2exchangeinfo.insert(Long.valueOf(roleid), xExchangeInfo);
/*     */     }
/*     */     
/*  79 */     Map<Long, String> roleidToUserid = new HashMap();
/*  80 */     roleidToUserid.put(Long.valueOf(roleid), userid);
/*     */     
/*  82 */     SSyncExchangeInfo protocol = new SSyncExchangeInfo();
/*  83 */     for (SExchangeCfg exchangeCfg : SExchangeCfg.getAll().values())
/*     */     {
/*  85 */       int activityCfgid = exchangeCfg.id;
/*  86 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(roleid) }), activityCfgid);
/*     */       
/*  88 */       if (activityJoinResult.isCanJoin())
/*     */       {
/*  90 */         mzm.gsp.exchange.ExchangeActivityInfo exchangeActivityInfo = new mzm.gsp.exchange.ExchangeActivityInfo();
/*  91 */         boxExchangeInfo(roleid, activityCfgid, xExchangeInfo, exchangeActivityInfo);
/*  92 */         protocol.exchange_activity_infos.put(Integer.valueOf(activityCfgid), exchangeActivityInfo);
/*     */       }
/*     */     }
/*  95 */     OnlineManager.getInstance().send(roleid, protocol);
/*  96 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static final void boxExchangeInfo(long roleid, int activityCfgid, ExchangeInfo xExchangeInfo, mzm.gsp.exchange.ExchangeActivityInfo exchangeActivityInfo)
/*     */   {
/* 102 */     xbean.ExchangeActivityInfo xExchangeActivityInfo = (xbean.ExchangeActivityInfo)xExchangeInfo.getExchange_activity_infos().get(Integer.valueOf(activityCfgid));
/* 103 */     if (xExchangeActivityInfo == null)
/*     */     {
/* 105 */       return;
/*     */     }
/* 107 */     for (Map.Entry<Integer, xbean.ExchangeAwardInfo> entry : xExchangeActivityInfo.getExchange_award_infos().entrySet())
/*     */     {
/* 109 */       exchangeActivityInfo.exchange_award_infos.put(entry.getKey(), Integer.valueOf(((xbean.ExchangeAwardInfo)entry.getValue()).getExchange_times()));
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
/*     */   static boolean isExchangeSwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/* 122 */     if (!OpenInterface.getOpenStatus(121))
/*     */     {
/* 124 */       return false;
/*     */     }
/* 126 */     SExchangeCfg cfg = SExchangeCfg.get(activityCfgid);
/* 127 */     if (cfg == null)
/*     */     {
/* 129 */       return false;
/*     */     }
/* 131 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 133 */       return false;
/*     */     }
/* 135 */     if (OpenInterface.isBanPlay(roleid, 121))
/*     */     {
/* 137 */       OpenInterface.sendBanPlayMsg(roleid, 121);
/* 138 */       return false;
/*     */     }
/* 140 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/* 142 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkRoleStatus(long roleid)
/*     */   {
/* 156 */     return RoleStatusInterface.checkCanSetStatus(roleid, 68, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkActivityIdandSortId(int activityCfgid, int sortid)
/*     */   {
/* 168 */     SExchangeCfg exchangeCfg = (SExchangeCfg)SExchangeCfg.getAll().get(Integer.valueOf(activityCfgid));
/* 169 */     if (exchangeCfg == null)
/*     */     {
/* 171 */       return false;
/*     */     }
/* 173 */     return exchangeCfg.exchange_award_info_map.containsKey(Integer.valueOf(sortid));
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
/*     */   static int getRoleExchangeTimes(int activityCfgid, int sortid, ExchangeInfo xExchangeInfo)
/*     */   {
/* 187 */     xbean.ExchangeActivityInfo xExchangeActivityInfo = (xbean.ExchangeActivityInfo)xExchangeInfo.getExchange_activity_infos().get(Integer.valueOf(activityCfgid));
/* 188 */     if (xExchangeActivityInfo == null)
/*     */     {
/* 190 */       xExchangeActivityInfo = Pod.newExchangeActivityInfo();
/* 191 */       xExchangeInfo.getExchange_activity_infos().put(Integer.valueOf(activityCfgid), xExchangeActivityInfo);
/* 192 */       return 0;
/*     */     }
/*     */     
/* 195 */     xbean.ExchangeAwardInfo xExchangeAwardInfo = (xbean.ExchangeAwardInfo)xExchangeActivityInfo.getExchange_award_infos().get(Integer.valueOf(sortid));
/* 196 */     if (xExchangeAwardInfo == null)
/*     */     {
/* 198 */       return 0;
/*     */     }
/*     */     
/* 201 */     return xExchangeAwardInfo.getExchange_times();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxExchangeNum(int activityCfgid, int sortid)
/*     */   {
/* 213 */     SExchangeCfg exchangeCfg = (SExchangeCfg)SExchangeCfg.getAll().get(Integer.valueOf(activityCfgid));
/* 214 */     if (exchangeCfg == null)
/*     */     {
/* 216 */       return -1;
/*     */     }
/* 218 */     mzm.gsp.exchange.confbean.ExchangeAwardInfo exchangeAwardInfo = (mzm.gsp.exchange.confbean.ExchangeAwardInfo)exchangeCfg.exchange_award_info_map.get(Integer.valueOf(sortid));
/* 219 */     if (exchangeAwardInfo == null)
/*     */     {
/* 221 */       return -1;
/*     */     }
/* 223 */     return exchangeAwardInfo.max_exchange_num;
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
/*     */   static final boolean cutAllNeedItem(long roleid, int activityCfgid, int sortid, int exchangeTimes)
/*     */   {
/* 237 */     SExchangeCfg exchangeCfg = (SExchangeCfg)SExchangeCfg.getAll().get(Integer.valueOf(activityCfgid));
/* 238 */     if (exchangeCfg == null)
/*     */     {
/* 240 */       return false;
/*     */     }
/* 242 */     mzm.gsp.exchange.confbean.ExchangeAwardInfo exchangeAwardInfo = (mzm.gsp.exchange.confbean.ExchangeAwardInfo)exchangeCfg.exchange_award_info_map.get(Integer.valueOf(sortid));
/* 243 */     if (exchangeAwardInfo == null)
/*     */     {
/* 245 */       return false;
/*     */     }
/* 247 */     for (NeedItemInfo needItemInfo : exchangeAwardInfo.need_item_info_map.values())
/*     */     {
/* 249 */       if (exchangeAwardInfo.exchange_type == 1)
/*     */       {
/* 251 */         if (!cutNeedItemByItemid(roleid, needItemInfo.item_id, needItemInfo.item_num * exchangeTimes))
/*     */         {
/* 253 */           logger.info(String.format("[exchange]ExchangeManager.cutAllNeedItem@cut item error|roleid=%d|activityCfgid=%d|sortid=%d|itemId=%d|itemNum=%d|exchange_times=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(needItemInfo.item_id), Integer.valueOf(needItemInfo.item_num), Integer.valueOf(exchangeTimes) }));
/*     */           
/*     */ 
/* 256 */           return false;
/*     */         }
/*     */       }
/* 259 */       else if (exchangeAwardInfo.exchange_type == 2)
/*     */       {
/* 261 */         if (!cutNeedItemBySamePriceItemid(roleid, needItemInfo.item_id, needItemInfo.item_num * exchangeTimes))
/*     */         {
/* 263 */           logger.info(String.format("[exchange]ExchangeManager.cutAllNeedItem@cut item error|roleid=%d|activity_cfg_id=%d|sortid=%d|same_price_item_id=%d|item_num=%d|exchange_times=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(needItemInfo.item_id), Integer.valueOf(needItemInfo.item_num), Integer.valueOf(exchangeTimes) }));
/*     */           
/*     */ 
/* 266 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/* 271 */         return false;
/*     */       }
/*     */     }
/* 274 */     return true;
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
/*     */   private static final boolean cutNeedItemByItemid(long roleid, int itemid, int number)
/*     */   {
/* 287 */     return ItemInterface.removeItemsWithBindFirst(roleid, itemid, number, new TLogArg(LogReason.EXCHANGE_NEED_ITEM_REM)).success();
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
/*     */   private static final boolean cutNeedItemBySamePriceItemid(long roleid, int samePriceItemid, int number)
/*     */   {
/* 300 */     int CutNum = 0;
/* 301 */     List<Integer> itemids = ItemInterface.getSamePriceItems(samePriceItemid);
/* 302 */     List<Integer> proprietaryItemids = new ArrayList();
/* 303 */     List<Integer> noProprietaryItemids = new ArrayList();
/* 304 */     for (Iterator i$ = itemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 306 */       if (SItemCfg.get(itemid) != null)
/*     */       {
/*     */ 
/*     */ 
/* 310 */         if (SItemCfg.get(itemid).isProprietary)
/*     */         {
/* 312 */           proprietaryItemids.add(Integer.valueOf(itemid));
/*     */         }
/*     */         else
/*     */         {
/* 316 */           noProprietaryItemids.add(Integer.valueOf(itemid)); }
/*     */       }
/*     */     }
/* 319 */     for (Iterator i$ = proprietaryItemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 321 */       while (ItemInterface.removeItemsWithBindFirst(roleid, itemid, 1, new TLogArg(LogReason.EXCHANGE_NEED_ITEM_REM)).success())
/*     */       {
/* 323 */         CutNum++; if (CutNum >= number)
/*     */           break;
/*     */       }
/* 326 */       if (CutNum >= number)
/*     */         break;
/*     */     }
/* 329 */     if (CutNum >= number)
/*     */     {
/* 331 */       return true;
/*     */     }
/* 333 */     for (Iterator i$ = noProprietaryItemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 335 */       while (ItemInterface.removeItemsWithBindFirst(roleid, itemid, 1, new TLogArg(LogReason.EXCHANGE_NEED_ITEM_REM)).success())
/*     */       {
/* 337 */         CutNum++; if (CutNum >= number)
/*     */           break;
/*     */       }
/* 340 */       if (CutNum >= number)
/*     */         break;
/*     */     }
/* 343 */     if (CutNum < number)
/*     */     {
/* 345 */       return false;
/*     */     }
/* 347 */     return true;
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
/*     */ 
/*     */   static final boolean sendAwardAndExchangeAwardSuccess(String userid, long roleid, int activityCfgid, int sortid, int exchangeTimes, ExchangeInfo xExchangeInfo)
/*     */   {
/* 365 */     SExchangeCfg exchangeCfg = (SExchangeCfg)SExchangeCfg.getAll().get(Integer.valueOf(activityCfgid));
/* 366 */     if (exchangeCfg == null)
/*     */     {
/* 368 */       return false;
/*     */     }
/* 370 */     mzm.gsp.exchange.confbean.ExchangeAwardInfo exchangeAwardInfo = (mzm.gsp.exchange.confbean.ExchangeAwardInfo)exchangeCfg.exchange_award_info_map.get(Integer.valueOf(sortid));
/* 371 */     if (exchangeAwardInfo == null)
/*     */     {
/* 373 */       return false;
/*     */     }
/* 375 */     AwardReason awardReason = new AwardReason(LogReason.EXCHANGE_AWARD, activityCfgid);
/* 376 */     AwardModel awardModel = AwardInterface.awardFixAwardNTime(exchangeAwardInfo.award_cfg_id, exchangeTimes, userid, roleid, true, true, awardReason);
/*     */     
/* 378 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 381 */       return false;
/*     */     }
/* 383 */     xbean.ExchangeActivityInfo xExchangeActivityInfo = (xbean.ExchangeActivityInfo)xExchangeInfo.getExchange_activity_infos().get(Integer.valueOf(activityCfgid));
/* 384 */     if (xExchangeActivityInfo == null)
/*     */     {
/* 386 */       return false;
/*     */     }
/* 388 */     xbean.ExchangeAwardInfo xExchangeAwardInfo = (xbean.ExchangeAwardInfo)xExchangeActivityInfo.getExchange_award_infos().get(Integer.valueOf(sortid));
/* 389 */     if (xExchangeAwardInfo == null)
/*     */     {
/* 391 */       xExchangeAwardInfo = Pod.newExchangeAwardInfo();
/* 392 */       xExchangeActivityInfo.getExchange_award_infos().put(Integer.valueOf(sortid), xExchangeAwardInfo);
/*     */     }
/* 394 */     xExchangeAwardInfo.setExchange_times(xExchangeAwardInfo.getExchange_times() + exchangeTimes);
/* 395 */     sendExchangeAwardSuccess(roleid, activityCfgid, sortid, xExchangeAwardInfo.getExchange_times());
/* 396 */     return true;
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
/*     */   static final void sendExchangeAwardFail(long roleid, int activityCfgid, int sortid, int exchangeTimes, int res)
/*     */   {
/* 411 */     SExchangeAwardFail protocol = new SExchangeAwardFail();
/* 412 */     protocol.activity_cfg_id = activityCfgid;
/* 413 */     protocol.sort_id = sortid;
/* 414 */     protocol.exchange_times = exchangeTimes;
/* 415 */     protocol.res = res;
/* 416 */     OnlineManager.getInstance().sendAtOnce(roleid, protocol);
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
/*     */   static final void sendExchangeAwardSuccess(long roleid, int activityCfgid, int sortid, int alreadyExchangeTimes)
/*     */   {
/* 430 */     SExchangeAwardSuccess protocol = new SExchangeAwardSuccess();
/* 431 */     protocol.activity_cfg_id = activityCfgid;
/* 432 */     protocol.sort_id = sortid;
/* 433 */     protocol.already_exchange_times = alreadyExchangeTimes;
/* 434 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\main\ExchangeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */