/*     */ package mzm.gsp.luckybag.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*     */ import mzm.gsp.luckybag.SBrocastLuckyBagItem;
/*     */ import mzm.gsp.luckybag.SOpenLuckyBagFailed;
/*     */ import mzm.gsp.luckybag.SyncExchangeScore;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagControllerCfg;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagNumLevelCfg;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagRefreshCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LuckyBagInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2luckybag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LuckyBagManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   static final int DELAY_SECOND = 8;
/*     */   static final int MULTI_OPEN_NUM = 10;
/*     */   
/*     */   static void init()
/*     */   {
/*  58 */     ActivityInterface.registerActivityByLogicType(60, new LuckyBagActivityHandler(), false);
/*     */     
/*     */ 
/*  61 */     ItemAccessManager.registerActivityReward(SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID, SLuckyBagCfgConsts.getInstance().BRASS_BAG_GET_AWARD_ID);
/*     */     
/*  63 */     ItemAccessManager.registerActivityReward(SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID, SLuckyBagCfgConsts.getInstance().JADE_BAG_GET_AWARD_ID);
/*     */     
/*     */ 
/*  66 */     ItemAccessManager.registerActivityReward(SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID, SLuckyBagCfgConsts.getInstance().BOX_BAG_GET_AWARD_ID);
/*     */     
/*     */ 
/*  69 */     registerMapItemGatherHandler();
/*     */   }
/*     */   
/*     */   private static void registerMapItemGatherHandler()
/*     */   {
/*  74 */     if (!MapInterface.regisMapItemGatherHandler(SLuckyBagCfgConsts.getInstance().JADE_MAP_ITEM_HANDLER_TYPE, PJadeLuckyBagGatherHandler.getInstance()))
/*     */     {
/*     */ 
/*  77 */       throw new RuntimeException(String.format("[luckybag]LuckyBagManager.regiterMapItemGatherHandler@register handler error|type=%d", new Object[] { Integer.valueOf(SLuckyBagCfgConsts.getInstance().JADE_MAP_ITEM_HANDLER_TYPE) }));
/*     */     }
/*     */     
/*     */ 
/*  81 */     if (!MapInterface.regisMapItemGatherHandler(SLuckyBagCfgConsts.getInstance().BRASS_MAP_ITEM_HANDLER_TYPE, PBrassLuckyBagGatherHandler.getInstance()))
/*     */     {
/*     */ 
/*  84 */       throw new RuntimeException(String.format("[luckybag]LuckyBagManager.regiterMapItemGatherHandler@register handler error|type=%d", new Object[] { Integer.valueOf(SLuckyBagCfgConsts.getInstance().BRASS_MAP_ITEM_HANDLER_TYPE) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  89 */     if (!MapInterface.regisMapItemGatherHandler(SLuckyBagCfgConsts.getInstance().BOX_MAP_ITEM_HANDLER_TYPE, PBoxLuckyBagGatherHandler.getInstance()))
/*     */     {
/*     */ 
/*  92 */       throw new RuntimeException(String.format("[luckybag]LuckyBagManager.regiterMapItemGatherHandler@register handler error|type=%d", new Object[] { Integer.valueOf(SLuckyBagCfgConsts.getInstance().BOX_MAP_ITEM_HANDLER_TYPE) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen()
/*     */   {
/* 100 */     if (!OpenInterface.getOpenStatus(174))
/*     */     {
/* 102 */       return false;
/*     */     }
/* 104 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid)
/*     */   {
/* 113 */     if (!OpenInterface.getOpenStatus(174))
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     if (OpenInterface.isBanPlay(roleid, 174))
/*     */     {
/* 119 */       OpenInterface.sendBanPlayMsg(roleid, 174);
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkRoleStatus(long roleid)
/*     */   {
/* 127 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 76, true))
/*     */     {
/* 129 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 131 */       return false;
/*     */     }
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/* 138 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, action, true))
/*     */     {
/* 140 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.canDoAction@status check failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 142 */       return false;
/*     */     }
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   static void initActivity(int activityCfgid, Reason reason)
/*     */   {
/* 149 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 150 */     calendar.setTimeInMillis(DateTimeUtils.getCurrTimeInMillis());
/* 151 */     int curMinute = calendar.get(12);
/* 152 */     int curHour = calendar.get(11);
/*     */     
/* 154 */     List<Integer> result = new ArrayList();
/* 155 */     boolean display = false;
/* 156 */     for (SLuckyBagRefreshCfg cfg : SLuckyBagRefreshCfg.getAll().values())
/*     */     {
/* 158 */       int commonTimeCfgid = cfg.commonTimeCfgid;
/*     */       
/* 160 */       STimeCommonCfg timeCommonCfg = STimeCommonCfg.get(commonTimeCfgid);
/* 161 */       if (timeCommonCfg.activeHour > curHour)
/*     */       {
/* 163 */         result.add(Integer.valueOf(commonTimeCfgid));
/*     */       }
/* 165 */       else if (timeCommonCfg.activeHour < curHour)
/*     */       {
/* 167 */         display = true;
/*     */ 
/*     */ 
/*     */       }
/* 171 */       else if (curMinute >= timeCommonCfg.activeMinute)
/*     */       {
/* 173 */         display = true;
/*     */       }
/*     */       else
/*     */       {
/* 177 */         result.add(Integer.valueOf(commonTimeCfgid));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 182 */     if (display)
/*     */     {
/* 184 */       displayLuckyBag(activityCfgid);
/*     */     }
/*     */     
/* 187 */     for (Integer commonTimeCfgid : result)
/*     */     {
/* 189 */       Observer refreshObserver = new RefreshObserver(commonTimeCfgid.intValue(), activityCfgid);
/* 190 */       if (!ObserverManager.getInstance().putIfAbsent(activityCfgid, commonTimeCfgid.intValue(), refreshObserver))
/*     */       {
/* 192 */         refreshObserver.stopTimer();
/*     */       }
/*     */     }
/*     */     
/* 196 */     GameServer.logger().info(String.format("[luckybag]LuckyBagManager.initActivity@init activity done|activity_cfgid=%d|reason=%s", new Object[] { Integer.valueOf(activityCfgid), reason.name() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void stopActivity(int activityCfgid, Reason reason)
/*     */   {
/* 203 */     ObserverManager.getInstance().stop(activityCfgid);
/*     */     
/* 205 */     collectAllController();
/*     */     
/* 207 */     GameServer.logger().info(String.format("[luckybag]LuckyBagManager.stopActivity@stop activity done|activity_cfgid=%d|reason=%s", new Object[] { Integer.valueOf(activityCfgid), reason.name() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void refreshLuckyBag(int activityCfgid)
/*     */   {
/* 214 */     collectAllController();
/*     */     
/* 216 */     int onlineNum = getOnlineNum();
/* 217 */     SLuckyBagNumLevelCfg luckyBagNumLevelCfg = getCurrentLuckyBagNumLevelCfg(onlineNum);
/* 218 */     if (luckyBagNumLevelCfg == null)
/*     */     {
/* 220 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.refreshLuckyBag@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */       
/* 222 */       return;
/*     */     }
/*     */     
/* 225 */     triggerAllController(luckyBagNumLevelCfg);
/* 226 */     addRefreshLuckyBagTLog(onlineNum, luckyBagNumLevelCfg);
/*     */     
/* 228 */     refreshBulletion();
/*     */     
/* 230 */     GameServer.logger().info(String.format("[luckybag]LuckyBagManager.refreshLuckyBag@refresh done|activity_cfgid=%d|brass_num=%d|jade_num=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(luckyBagNumLevelCfg.brassNum), Integer.valueOf(luckyBagNumLevelCfg.jadeNum) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void displayLuckyBag(int activityCfgid)
/*     */   {
/* 238 */     collectAllController();
/*     */     
/* 240 */     SLuckyBagNumLevelCfg luckyBagNumLevelCfg = SLuckyBagNumLevelCfg.get(SLuckyBagCfgConsts.getInstance().INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID);
/* 241 */     if (luckyBagNumLevelCfg == null)
/*     */     {
/* 243 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.displayLuckyBag@cfg is null|activity_cfgid=%d|lucky_bag_num_level_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(SLuckyBagCfgConsts.getInstance().INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID) }));
/*     */       
/*     */ 
/*     */ 
/* 247 */       return;
/*     */     }
/*     */     
/* 250 */     triggerAllController(luckyBagNumLevelCfg);
/* 251 */     addRefreshLuckyBagTLog(-1, luckyBagNumLevelCfg);
/*     */     
/* 253 */     GameServer.logger().info(String.format("[luckybag]LuckyBagManager.displayLuckyBag@display done|activity_cfgid=%d|brass_num=%d|jade_num=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(luckyBagNumLevelCfg.brassNum), Integer.valueOf(luckyBagNumLevelCfg.jadeNum) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void addRefreshLuckyBagTLog(int onlineNum, SLuckyBagNumLevelCfg luckyBagNumLevelCfg)
/*     */   {
/* 261 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 262 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 263 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 264 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 266 */     String vGameAppid = "0";
/* 267 */     int PlatID = -1;
/* 268 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 269 */     String vopenid = "0";
/*     */     
/* 271 */     StringBuffer sb = new StringBuffer();
/* 272 */     sb.append(GameSvrId).append('|');
/* 273 */     sb.append(dtEventTime).append('|');
/* 274 */     sb.append("0").append('|');
/* 275 */     sb.append(-1).append('|');
/* 276 */     sb.append(iZoneAreaID).append('|');
/* 277 */     sb.append("0").append('|');
/*     */     
/* 279 */     sb.append(onlineNum).append('|');
/* 280 */     sb.append(luckyBagNumLevelCfg.brassNum).append('|');
/* 281 */     sb.append(luckyBagNumLevelCfg.jadeNum).append('|');
/* 282 */     sb.append(luckyBagNumLevelCfg.boxNum);
/*     */     
/* 284 */     TLogManager.getInstance().addLog("RefreshLuckyBagForServer", sb.toString());
/*     */   }
/*     */   
/*     */   private static void collectAllController()
/*     */   {
/* 289 */     for (SLuckyBagControllerCfg cfg : SLuckyBagControllerCfg.getAll().values())
/*     */     {
/* 291 */       ControllerInterface.collectController(cfg.controllerCfgid);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void triggerAllController(SLuckyBagNumLevelCfg luckyBagNumLevelCfg)
/*     */   {
/* 297 */     int brassNum = luckyBagNumLevelCfg.brassNum;
/* 298 */     int jadeNum = luckyBagNumLevelCfg.jadeNum;
/* 299 */     int boxNum = luckyBagNumLevelCfg.boxNum;
/*     */     
/* 301 */     long bigWorldid = MapInterface.getBigWorldid();
/* 302 */     for (SLuckyBagControllerCfg cfg : SLuckyBagControllerCfg.getAll().values())
/*     */     {
/* 304 */       int num = 0;
/* 305 */       int type = cfg.type;
/* 306 */       if (type == 1)
/*     */       {
/* 308 */         num = brassNum;
/*     */       }
/* 310 */       else if (type == 2)
/*     */       {
/* 312 */         num = jadeNum;
/*     */       }
/* 314 */       else if (type == 3)
/*     */       {
/* 316 */         num = boxNum;
/*     */       }
/*     */       else
/*     */       {
/* 320 */         GameServer.logger().error(String.format("[luckybag]LuckyBagManager.triggerAllController@type not exist|lucky_bag_controller_cfgid=%d|type=%d", new Object[] { Integer.valueOf(cfg.id), Integer.valueOf(type) }));
/*     */         
/*     */ 
/*     */ 
/* 324 */         continue;
/*     */       }
/*     */       
/* 327 */       num = num * cfg.time / 10000;
/* 328 */       if (num > 0)
/*     */       {
/* 330 */         ControllerInterface.triggerWorldControllerWithMaxSpawnNum(bigWorldid, cfg.controllerCfgid, num);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static int getOnlineNum()
/*     */   {
/* 337 */     int from = SLuckyBagCfgConsts.getInstance().MIN_LEVEL;
/* 338 */     int to = ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL;
/*     */     
/*     */ 
/* 341 */     List<Long> roles = OnlineManager.getInstance().getOnlineRoleidList(from, to);
/* 342 */     int num = roles.size();
/* 343 */     GameServer.logger().info(String.format("[luckybag]LuckyBagManager.getOnlineNum@get success|from_level=%d|to_level=%d|online_num=%d", new Object[] { Integer.valueOf(from), Integer.valueOf(to), Integer.valueOf(num) }));
/*     */     
/*     */ 
/* 346 */     return num;
/*     */   }
/*     */   
/*     */   private static SLuckyBagNumLevelCfg getCurrentLuckyBagNumLevelCfg(int num)
/*     */   {
/* 351 */     for (SLuckyBagNumLevelCfg cfg : SLuckyBagNumLevelCfg.getAll().values())
/*     */     {
/* 353 */       if ((num >= cfg.min) && (num <= cfg.max))
/*     */       {
/* 355 */         return cfg;
/*     */       }
/*     */     }
/* 358 */     GameServer.logger().error(String.format("[luckybag]LuckyBagManager.getCurrentLuckyBagNumLevelCfg@cfg is null|online_num=%d", new Object[] { Integer.valueOf(num) }));
/*     */     
/* 360 */     return null;
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
/*     */   static boolean removeItem(long roleid, int itemCfgid, int num, LogReason logReason)
/*     */   {
/* 373 */     int count = ItemInterface.getItemNumberById(roleid, itemCfgid);
/* 374 */     if (count < num)
/*     */     {
/* 376 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.removeItem@item not enough|roleid=%d|item_cfgid=%d|num=%d|count=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(count) }));
/*     */       
/*     */ 
/*     */ 
/* 380 */       return false;
/*     */     }
/*     */     
/* 383 */     if (!ItemInterface.removeItemById(roleid, 340600000, itemCfgid, num, new TLogArg(logReason)))
/*     */     {
/* 385 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.removeItem@remove item failed|roleid=%d|item_cfgid=%d|num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num) }));
/*     */       
/*     */ 
/* 388 */       return false;
/*     */     }
/* 390 */     return true;
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
/*     */   static boolean removeItem(String userid, long roleid, long clientYuanbao, long needYuanbao, int itemCfgid, int num, LogReason logReason)
/*     */   {
/* 407 */     Map<Integer, Integer> items = new HashMap();
/* 408 */     items.put(Integer.valueOf(itemCfgid), Integer.valueOf(num));
/*     */     
/* 410 */     boolean ret = ItemInterface.removeItemsWithCutYuanbao(userid, roleid, CostType.COST_BIND_FIRST_OPEN_LUCKY_BAG, items, (int)needYuanbao, new TLogArg(logReason));
/*     */     
/* 412 */     if (!ret)
/*     */     {
/* 414 */       GameServer.logger().error(String.format("[luckybag]LuckyBagManager.removeItem@remove failed|userid=%s|roleid=%d|item_cfgid=%d|num=%d|client_yuanbao=%d|need_yuanbao=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Long.valueOf(clientYuanbao), Long.valueOf(needYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 418 */       return false;
/*     */     }
/* 420 */     return true;
/*     */   }
/*     */   
/*     */   static void worldBroadcast(long roleid, int mapItemCfgid, Map<Integer, Integer> itemMap)
/*     */   {
/* 425 */     HashMap<Integer, Integer> preciousItems = new HashMap();
/* 426 */     for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*     */     {
/* 428 */       int itemCfgId = ((Integer)entry.getKey()).intValue();
/* 429 */       if (ItemBulletinInterface.needBulletin(itemCfgId))
/*     */       {
/* 431 */         preciousItems.put(Integer.valueOf(itemCfgId), entry.getValue());
/*     */       }
/*     */     }
/* 434 */     if (!preciousItems.isEmpty())
/*     */     {
/* 436 */       SBrocastLuckyBagItem broadcast = new SBrocastLuckyBagItem();
/* 437 */       broadcast.roleid = roleid;
/* 438 */       broadcast.items = preciousItems;
/* 439 */       broadcast.map_item_cfgid = mapItemCfgid;
/*     */       try
/*     */       {
/* 442 */         broadcast.role_name.setString(RoleInterface.getName(roleid), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/* 448 */       OnlineManager.getInstance().sendAll(broadcast);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void addTlog(long roleid, int mapItemCfgid, boolean useYuanbao, long clientYuanbao, long needYuanbao, int awardCfgid, Map<Integer, Integer> awardItems, int openNum)
/*     */   {
/* 455 */     StringBuilder awardItemids = new StringBuilder();
/* 456 */     StringBuilder awardNums = new StringBuilder();
/* 457 */     for (Map.Entry<Integer, Integer> entry : awardItems.entrySet())
/*     */     {
/* 459 */       awardItemids.append(entry.getKey()).append(',');
/* 460 */       awardNums.append(entry.getValue()).append(',');
/*     */     }
/* 462 */     String items = awardItemids.substring(0, awardItemids.length() - 1).toString();
/* 463 */     String nums = awardNums.substring(0, awardNums.length() - 1).toString();
/*     */     
/* 465 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 466 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 467 */     String userid = RoleInterface.getUserId(roleid);
/* 468 */     TLogManager.getInstance().addLog(userid, "OpenLuckyBagForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Integer.valueOf(mapItemCfgid), Integer.valueOf(useYuanbao ? 1 : 0), Long.valueOf(clientYuanbao), Long.valueOf(needYuanbao), Integer.valueOf(awardCfgid), items, nums, Integer.valueOf(openNum) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void onFailed(long roleid, int retcode, LuckyBagGatherContext context, Map<String, Object> extraParams)
/*     */   {
/* 475 */     onFailed(roleid, retcode, context, extraParams, true);
/*     */   }
/*     */   
/*     */ 
/*     */   static void onFailed(long roleid, int retcode, LuckyBagGatherContext context, Map<String, Object> extraParams, boolean sendError)
/*     */   {
/* 481 */     if ((retcode < 0) && (sendError))
/*     */     {
/* 483 */       SOpenLuckyBagFailed resp = new SOpenLuckyBagFailed();
/* 484 */       resp.retcode = retcode;
/* 485 */       resp.instanceid = context.instanceid;
/* 486 */       resp.use_yuanbao = ((byte)(context.useYuanbao ? 1 : 0));
/* 487 */       resp.client_yuanbao = context.clientYuanbao;
/* 488 */       OnlineManager.getInstance().sendAtOnce(roleid, resp);
/*     */     }
/*     */     
/* 491 */     StringBuffer logBuilder = new StringBuffer();
/* 492 */     logBuilder.append("[luckybag]LuckyBagManager.onFailed@open lukcy bag failed");
/* 493 */     logBuilder.append('|').append("roleid=").append(roleid);
/* 494 */     logBuilder.append('|').append("activity_cfgid=").append(SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID);
/* 495 */     logBuilder.append('|').append("retcode=").append(retcode);
/* 496 */     logBuilder.append('|').append("use_yuanbao=").append(context.useYuanbao);
/* 497 */     logBuilder.append('|').append("client_yuanbao=").append(context.clientYuanbao);
/* 498 */     logBuilder.append('|').append("multiple=").append(context.multiple);
/*     */     
/* 500 */     if (extraParams != null)
/*     */     {
/* 502 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 504 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 508 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   static boolean gmReset(int num)
/*     */   {
/* 513 */     int online = 0;
/* 514 */     if (num == -1)
/*     */     {
/* 516 */       int from = SLuckyBagCfgConsts.getInstance().MIN_LEVEL;
/* 517 */       int to = ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL;
/*     */       
/* 519 */       List<Long> roles = OnlineManager.getInstance().getOnlineRoleidList(from, to);
/* 520 */       online = roles.size();
/*     */     }
/*     */     else
/*     */     {
/* 524 */       online = num;
/*     */     }
/*     */     
/* 527 */     SLuckyBagNumLevelCfg luckyBagNumLevelCfg = null;
/* 528 */     for (SLuckyBagNumLevelCfg cfg : SLuckyBagNumLevelCfg.getAll().values())
/*     */     {
/* 530 */       if ((online >= cfg.min) && (online <= cfg.max))
/*     */       {
/* 532 */         luckyBagNumLevelCfg = cfg;
/* 533 */         break;
/*     */       }
/*     */     }
/* 536 */     if (luckyBagNumLevelCfg == null)
/*     */     {
/* 538 */       return false;
/*     */     }
/*     */     
/* 541 */     collectAllController();
/*     */     
/* 543 */     triggerAllController(luckyBagNumLevelCfg);
/*     */     
/* 545 */     refreshBulletion();
/*     */     
/* 547 */     return true;
/*     */   }
/*     */   
/*     */   private static void refreshBulletion()
/*     */   {
/* 552 */     SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 553 */     bulletinInfo.bulletintype = 34;
/* 554 */     BulletinInterface.sendBulletin(bulletinInfo);
/*     */   }
/*     */   
/*     */   static LuckyBagInfo getAndInitLuckyBagInfo(long roleid)
/*     */   {
/* 559 */     LuckyBagInfo xLuckyBagInfo = Role2luckybag.get(Long.valueOf(roleid));
/* 560 */     if (xLuckyBagInfo == null)
/*     */     {
/* 562 */       xLuckyBagInfo = Pod.newLuckyBagInfo();
/* 563 */       Role2luckybag.insert(Long.valueOf(roleid), xLuckyBagInfo);
/*     */     }
/* 565 */     return xLuckyBagInfo;
/*     */   }
/*     */   
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 570 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 571 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 572 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 574 */     StringBuilder logStr = new StringBuilder();
/* 575 */     logStr.append(vGameIp);
/* 576 */     logStr.append("|").append(userid);
/* 577 */     logStr.append("|").append(roleid);
/* 578 */     logStr.append("|").append(roleLevel);
/*     */     
/* 580 */     for (Object colum : logColumns)
/*     */     {
/* 582 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 585 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */   static void syncLuckyBagExchangeScore(long roleid, int score)
/*     */   {
/* 590 */     SyncExchangeScore msg = new SyncExchangeScore();
/* 591 */     msg.score = score;
/* 592 */     OnlineManager.getInstance().send(roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\LuckyBagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */