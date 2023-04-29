/*      */ package mzm.gsp.cat.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*      */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*      */ import mzm.gsp.cat.SBrocastExploreItem;
/*      */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*      */ import mzm.gsp.cat.confbean.SCatLevelCfg;
/*      */ import mzm.gsp.cat.confbean.SCatPartnerCfg;
/*      */ import mzm.gsp.cat.confbean.SHomelandCatCfg;
/*      */ import mzm.gsp.cat.confbean.SLevelToCatCfg;
/*      */ import mzm.gsp.cat.confbean.SRandomPartnerCfg;
/*      */ import mzm.gsp.cat.event.CatCreate;
/*      */ import mzm.gsp.cat.event.GetCatExploreAward;
/*      */ import mzm.gsp.cat.event.GetCatExploreAwardArg;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*      */ import mzm.gsp.item.confbean.SCatItemCfg;
/*      */ import mzm.gsp.item.main.BasicItem;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.item.main.ItemOperateResult;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.mail.main.SendMailRet;
/*      */ import mzm.gsp.map.main.MapCallback;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.npc.confbean.SNPCDynamicCfg;
/*      */ import mzm.gsp.npc.main.NpcInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.timer.main.Observer;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.CatBag;
/*      */ import xbean.CatExploreObserver;
/*      */ import xbean.FeedInfo;
/*      */ import xbean.Item;
/*      */ import xbean.Pod;
/*      */ import xdb.Xdb;
/*      */ import xtable.Catexploreobservers;
/*      */ import xtable.Role2catbag;
/*      */ 
/*      */ public class CatManager
/*      */ {
/*      */   static final String ENCODING = "UTF-8";
/*      */   
/*      */   static void init()
/*      */   {
/*   67 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/*   69 */       return;
/*      */     }
/*      */     
/*   72 */     new PBestPartnerInit().call();
/*      */   }
/*      */   
/*      */   static final boolean isFunOpen(long roleid)
/*      */   {
/*   77 */     if (!OpenInterface.getOpenStatus(162))
/*      */     {
/*   79 */       return false;
/*      */     }
/*   81 */     if (OpenInterface.isBanPlay(roleid, 162))
/*      */     {
/*   83 */       OpenInterface.sendBanPlayMsg(roleid, 162);
/*   84 */       return false;
/*      */     }
/*   86 */     return true;
/*      */   }
/*      */   
/*      */   static boolean checkRoleStatus(long roleid)
/*      */   {
/*   91 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 75, true))
/*      */     {
/*   93 */       GameServer.logger().error(String.format("[cat]CatManager.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*   94 */       return false;
/*      */     }
/*   96 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static xbean.CatInfo getHomelandCat(long roleid, boolean retainLock)
/*      */   {
/*  109 */     CatBag xCatBag = null;
/*  110 */     if (retainLock)
/*      */     {
/*  112 */       xCatBag = Role2catbag.get(Long.valueOf(roleid));
/*      */     }
/*      */     else
/*      */     {
/*  116 */       xCatBag = Role2catbag.select(Long.valueOf(roleid));
/*      */     }
/*      */     
/*  119 */     if (xCatBag == null)
/*      */     {
/*  121 */       return null;
/*      */     }
/*      */     
/*  124 */     Iterator<Long> xIterator = xCatBag.getItems().keySet().iterator();
/*  125 */     if (xIterator.hasNext())
/*      */     {
/*  127 */       return (xbean.CatInfo)xCatBag.getCats().get(xIterator.next());
/*      */     }
/*  129 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   static CatBag getCatBag(long roleid)
/*      */   {
/*  135 */     CatBag xCatBag = Role2catbag.get(Long.valueOf(roleid));
/*  136 */     if (xCatBag == null)
/*      */     {
/*  138 */       xCatBag = Pod.newCatBag();
/*  139 */       Role2catbag.insert(Long.valueOf(roleid), xCatBag);
/*      */     }
/*  141 */     return xCatBag;
/*      */   }
/*      */   
/*      */   static int getCatLevel(xbean.CatInfo xCatInfo)
/*      */   {
/*  146 */     SCatLevelCfg catLevelCfg = SCatLevelCfg.get(xCatInfo.getCat_level_cfgid());
/*  147 */     if (catLevelCfg == null)
/*      */     {
/*  149 */       GameServer.logger().error(String.format("[cat]CatManager.getCatLevel@cat level cfg is null|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d", new Object[] { Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  154 */       return -1;
/*      */     }
/*  156 */     int initLevel = catLevelCfg.level;
/*  157 */     int exploreNum = xCatInfo.getTotal_explore_num();
/*      */     
/*  159 */     int tmp = exploreNum;
/*  160 */     int maxCatLevel = SCatCfgConsts.getInstance().MAX_CAT_LEVEL;
/*  161 */     for (int i = initLevel; i <= maxCatLevel; i++)
/*      */     {
/*      */ 
/*  164 */       SLevelToCatCfg levelToCatCfg = SLevelToCatCfg.get(i);
/*  165 */       if (levelToCatCfg == null)
/*      */       {
/*  167 */         GameServer.logger().error(String.format("[cat]CatManager.getCatLevel@level to cat cfg is null|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d|cur_level=%d", new Object[] { Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(i) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  172 */         return -1;
/*      */       }
/*  174 */       int catLevelCfgid = levelToCatCfg.catLevelCfgid;
/*  175 */       SCatLevelCfg cfg = SCatLevelCfg.get(catLevelCfgid);
/*  176 */       if (cfg == null)
/*      */       {
/*  178 */         GameServer.logger().error(String.format("[cat]CatManager.getCatLevel@cat level cfg is null|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d|cur_cat_level_cfgid=%d", new Object[] { Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(catLevelCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  183 */         return -1;
/*      */       }
/*  185 */       int levelUpNeededNum = cfg.levelUpNeededNum;
/*  186 */       if (levelUpNeededNum == 0)
/*      */       {
/*  188 */         return i;
/*      */       }
/*  190 */       tmp -= cfg.levelUpNeededNum;
/*  191 */       if (tmp < 0)
/*      */       {
/*  193 */         return i;
/*      */       }
/*      */     }
/*  196 */     return maxCatLevel;
/*      */   }
/*      */   
/*      */   static mzm.gsp.cat.CatInfo fillCatInfo(xbean.CatInfo xCatInfo)
/*      */   {
/*  201 */     mzm.gsp.cat.CatInfo catInfo = new mzm.gsp.cat.CatInfo();
/*      */     
/*  203 */     catInfo.id = xCatInfo.getId();
/*  204 */     catInfo.item_cfgid = xCatInfo.getItem_cfgid();
/*  205 */     catInfo.explore_num = xCatInfo.getExplore_num();
/*  206 */     catInfo.total_explore_num = xCatInfo.getTotal_explore_num();
/*  207 */     catInfo.vigor = xCatInfo.getVigor();
/*  208 */     catInfo.state = ((byte)xCatInfo.getState());
/*  209 */     catInfo.is_award = ((byte)((xCatInfo.getExplored_level() != 0) || (xCatInfo.getExplored_partner_cfgid() != 0) ? 1 : 0));
/*  210 */     catInfo.explore_end_timestamp = ((int)TimeUnit.MILLISECONDS.toSeconds(xCatInfo.getExplore_endtime()));
/*  211 */     catInfo.partner_cfgid = xCatInfo.getPartner_cfgid();
/*      */     
/*      */     try
/*      */     {
/*  215 */       catInfo.name.setString(xCatInfo.getName(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  222 */     return catInfo;
/*      */   }
/*      */   
/*      */   static boolean checkState(xbean.CatInfo xCatInfo)
/*      */   {
/*  227 */     if (xCatInfo.getState() == 3)
/*      */     {
/*  229 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  230 */       long exploreEndTime = xCatInfo.getExplore_endtime();
/*  231 */       int curLevel = getCatLevel(xCatInfo);
/*  232 */       if (curLevel < 0)
/*      */       {
/*  234 */         return false;
/*      */       }
/*      */       
/*  237 */       SLevelToCatCfg levelToCatCfg = SLevelToCatCfg.get(curLevel);
/*  238 */       if (levelToCatCfg == null)
/*      */       {
/*  240 */         GameServer.logger().error(String.format("[cat]CatManager.checkState@level to cat cfg is null|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d|cur_level=%d", new Object[] { Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(curLevel) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  245 */         return false;
/*      */       }
/*  247 */       SCatLevelCfg catLevelCfg = SCatLevelCfg.get(levelToCatCfg.catLevelCfgid);
/*  248 */       if (catLevelCfg == null)
/*      */       {
/*  250 */         GameServer.logger().error(String.format("[cat]CatManager.checkState@cat level cfg is null|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d|cur_cat_level_cfgid=%d", new Object[] { Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(levelToCatCfg.catLevelCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  255 */         return false;
/*      */       }
/*      */       
/*  258 */       long restTime = TimeUnit.MINUTES.toMillis(catLevelCfg.restTime);
/*  259 */       if (exploreEndTime + restTime <= now)
/*      */       {
/*  261 */         xCatInfo.setState(1);
/*      */       }
/*      */     }
/*  264 */     return true;
/*      */   }
/*      */   
/*      */   static void exploreObserver(long roleid, long catid, long intervalSeconds)
/*      */   {
/*  269 */     ExploreObserver observer = new ExploreObserver(intervalSeconds, roleid, catid);
/*  270 */     CatExploreObserver xCatExploreObserver = Catexploreobservers.get(Long.valueOf(catid));
/*  271 */     if (xCatExploreObserver == null)
/*      */     {
/*  273 */       xCatExploreObserver = Pod.newCatExploreObserver();
/*  274 */       Catexploreobservers.insert(Long.valueOf(catid), xCatExploreObserver);
/*      */     }
/*  276 */     if (xCatExploreObserver.getObserver() != null)
/*      */     {
/*  278 */       xCatExploreObserver.getObserver().stopTimer();
/*      */     }
/*  280 */     xCatExploreObserver.setObserver(observer);
/*      */   }
/*      */   
/*      */   static boolean cancelExploreObserver(long catid)
/*      */   {
/*  285 */     CatExploreObserver xCatExploreObserver = Catexploreobservers.get(Long.valueOf(catid));
/*  286 */     if (xCatExploreObserver == null)
/*      */     {
/*  288 */       return false;
/*      */     }
/*  290 */     if (xCatExploreObserver.getObserver() != null)
/*      */     {
/*  292 */       xCatExploreObserver.getObserver().stopTimer();
/*      */     }
/*  294 */     Catexploreobservers.remove(Long.valueOf(catid));
/*  295 */     return true;
/*      */   }
/*      */   
/*      */   static int randomPartner()
/*      */   {
/*  300 */     SRandomPartnerCfg cfg = SRandomPartnerCfg.get(1);
/*  301 */     if (cfg == null)
/*      */     {
/*  303 */       GameServer.logger().error("[cat]CatManager.randomPartner@random partner cfg is null|cfgid=1");
/*  304 */       return -1;
/*      */     }
/*  306 */     int sum = cfg.randomWeightSum;
/*  307 */     Random random = Xdb.random();
/*  308 */     int num = random.nextInt(sum) + 1;
/*      */     
/*  310 */     List<Integer> partnerCfgids = cfg.partnerCfgids;
/*  311 */     int size = partnerCfgids.size();
/*  312 */     int tmp = 0;
/*  313 */     for (int i = 0; i < size; i++)
/*      */     {
/*  315 */       int catPartnerCfgid = ((Integer)partnerCfgids.get(i)).intValue();
/*  316 */       SCatPartnerCfg catPartnerCfg = SCatPartnerCfg.get(catPartnerCfgid);
/*  317 */       if (catPartnerCfg == null)
/*      */       {
/*  319 */         GameServer.logger().error(String.format("[cat]CatManager.randomPartner@cat partner cfg is null|cat_partner_cfgid=%d", new Object[] { Integer.valueOf(catPartnerCfgid) }));
/*      */         
/*      */ 
/*  322 */         return -1;
/*      */       }
/*  324 */       tmp += catPartnerCfg.random_weight;
/*  325 */       if (num <= tmp)
/*      */       {
/*  327 */         return catPartnerCfgid;
/*      */       }
/*      */     }
/*  330 */     return -1;
/*      */   }
/*      */   
/*      */   static int randomBestPartner()
/*      */   {
/*  335 */     SRandomPartnerCfg cfg = SRandomPartnerCfg.get(1);
/*  336 */     if (cfg == null)
/*      */     {
/*  338 */       GameServer.logger().error("[cat]CatManager.randomPartner@random partner cfg is null|cfgid=1");
/*  339 */       return -1;
/*      */     }
/*  341 */     int sum = cfg.weightSum;
/*  342 */     Random random = Xdb.random();
/*  343 */     int num = random.nextInt(sum) + 1;
/*      */     
/*  345 */     List<Integer> partnerCfgids = cfg.partnerCfgids;
/*  346 */     int size = partnerCfgids.size();
/*  347 */     int tmp = 0;
/*  348 */     for (int i = 0; i < size; i++)
/*      */     {
/*  350 */       int catPartnerCfgid = ((Integer)partnerCfgids.get(i)).intValue();
/*  351 */       SCatPartnerCfg catPartnerCfg = SCatPartnerCfg.get(catPartnerCfgid);
/*  352 */       if (catPartnerCfg == null)
/*      */       {
/*  354 */         GameServer.logger().error(String.format("[cat]CatManager.randomPartner@cat partner cfg is null|cat_partner_cfgid=%d", new Object[] { Integer.valueOf(catPartnerCfgid) }));
/*      */         
/*      */ 
/*  357 */         return -1;
/*      */       }
/*  359 */       tmp += catPartnerCfg.weight;
/*  360 */       if (num <= tmp)
/*      */       {
/*  362 */         return catPartnerCfgid;
/*      */       }
/*      */     }
/*  365 */     return -1;
/*      */   }
/*      */   
/*      */   static int randomCostTime(int minTime, int maxTime)
/*      */   {
/*  370 */     if (minTime == maxTime)
/*      */     {
/*  372 */       return minTime;
/*      */     }
/*      */     
/*  375 */     int n = maxTime - minTime + 1;
/*  376 */     Random random = Xdb.random();
/*  377 */     return minTime + random.nextInt(n);
/*      */   }
/*      */   
/*      */   static int useCatItem(long roleid, long uuid, BasicItem item)
/*      */   {
/*  382 */     CatBag xCatBag = getCatBag(roleid);
/*  383 */     if (xCatBag.getItems().size() >= SCatCfgConsts.getInstance().CAT_NUM_MAX)
/*      */     {
/*  385 */       return 10;
/*      */     }
/*  387 */     if (xCatBag.getItems().containsKey(Long.valueOf(uuid)))
/*      */     {
/*  389 */       return 1;
/*      */     }
/*  391 */     xCatBag.getItems().put(Long.valueOf(uuid), item.getCopyItem());
/*      */     
/*  393 */     xbean.CatInfo xCatInfo = (xbean.CatInfo)xCatBag.getCats().get(Long.valueOf(uuid));
/*  394 */     if (xCatInfo != null)
/*      */     {
/*  396 */       handleReuseCatItem(xCatInfo);
/*      */     }
/*      */     else
/*      */     {
/*  400 */       xCatInfo = buildCatInfo(uuid, item.getCfgId());
/*  401 */       if (xCatInfo == null)
/*      */       {
/*  403 */         return 1;
/*      */       }
/*  405 */       xCatBag.getCats().put(Long.valueOf(uuid), xCatInfo);
/*      */     }
/*      */     
/*      */ 
/*  409 */     CatCreate catCreateEvent = new CatCreate();
/*  410 */     TriggerEventsManger.getInstance().triggerEvent(catCreateEvent, new mzm.gsp.cat.event.CatCreateArg(roleid, uuid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */     
/*      */ 
/*      */ 
/*  414 */     String vGameIp = GameServerInfoManager.getHostIP();
/*  415 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  416 */     String userid = RoleInterface.getUserId(roleid);
/*  417 */     TLogManager.getInstance().addLog(userid, "UseCatItemForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(uuid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(xCatInfo.getVigor()), Integer.valueOf(xCatInfo.getState()) });
/*      */     
/*      */ 
/*      */ 
/*  421 */     return 0;
/*      */   }
/*      */   
/*      */   private static xbean.CatInfo buildCatInfo(long uuid, int itemCfgid)
/*      */   {
/*  426 */     SCatItemCfg catItemCfg = SCatItemCfg.get(itemCfgid);
/*  427 */     if (catItemCfg == null)
/*      */     {
/*  429 */       GameServer.logger().error(String.format("[cat]CatManager.buildCatInfo@homeland cat cfg is null|uuid=%d|item_cfgid=%d", new Object[] { Long.valueOf(uuid), Integer.valueOf(itemCfgid) }));
/*      */       
/*      */ 
/*  432 */       return null;
/*      */     }
/*      */     
/*  435 */     int homelandCatCfgid = catItemCfg.homelandCatCfgid;
/*  436 */     SHomelandCatCfg homelandCatCfg = SHomelandCatCfg.get(homelandCatCfgid);
/*  437 */     if (homelandCatCfg == null)
/*      */     {
/*  439 */       GameServer.logger().error(String.format("[cat]CatManager.buildCatInfo@homeland cat cfg is null|uuid=%d|item_cfgid=%d|homeland_cfgid=%d", new Object[] { Long.valueOf(uuid), Integer.valueOf(itemCfgid), Integer.valueOf(homelandCatCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  443 */       return null;
/*      */     }
/*      */     
/*  446 */     SLevelToCatCfg levelToCatCfg = SLevelToCatCfg.get(homelandCatCfg.level);
/*  447 */     if (levelToCatCfg == null)
/*      */     {
/*  449 */       GameServer.logger().error(String.format("[cat]CatManager.buildCatInfo@level to cat cfg is null|uuid=%d|item_cfgid=%d|homeland_cfgid=%d|level_to_cat_cfgid=%d", new Object[] { Long.valueOf(uuid), Integer.valueOf(itemCfgid), Integer.valueOf(homelandCatCfgid), Integer.valueOf(homelandCatCfg.level) }));
/*      */       
/*      */ 
/*      */ 
/*  453 */       return null;
/*      */     }
/*      */     
/*  456 */     int partnerCfgid = randomPartner();
/*  457 */     if (partnerCfgid < 0)
/*      */     {
/*  459 */       GameServer.logger().error(String.format("[cat]CatManager.buildCatInfo@random partner failed|uuid=%d|item_cfgid=%d|homeland_cfgid=%d|level_to_cat_cfgid=%d|partner_cfgid=%d", new Object[] { Long.valueOf(uuid), Integer.valueOf(itemCfgid), Integer.valueOf(homelandCatCfgid), Integer.valueOf(homelandCatCfg.level), Integer.valueOf(partnerCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  463 */       return null;
/*      */     }
/*      */     
/*  466 */     int catLevelCfgid = levelToCatCfg.catLevelCfgid;
/*  467 */     xbean.CatInfo xCatInfo = Pod.newCatInfo();
/*  468 */     xCatInfo.setCat_level_cfgid(catLevelCfgid);
/*  469 */     xCatInfo.setId(uuid);
/*  470 */     xCatInfo.setName(homelandCatCfg.catName);
/*  471 */     xCatInfo.setPartner_cfgid(partnerCfgid);
/*  472 */     xCatInfo.setState(1);
/*  473 */     xCatInfo.setItem_cfgid(catItemCfg.id);
/*  474 */     return xCatInfo;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void handleReuseCatItem(xbean.CatInfo xCatInfo)
/*      */   {
/*  480 */     long forceRecoveryTime = xCatInfo.getForce_recovery_time();
/*  481 */     if ((forceRecoveryTime != 0L) && (xCatInfo.getState() == 3))
/*      */     {
/*  483 */       long exploreEndTime = xCatInfo.getExplore_endtime();
/*  484 */       long time = DateTimeUtils.getCurrTimeInMillis() - (forceRecoveryTime - exploreEndTime);
/*      */       
/*  486 */       xCatInfo.setExplore_endtime(time);
/*  487 */       xCatInfo.setForce_recovery_time(0L);
/*      */     }
/*      */   }
/*      */   
/*      */   static int queryFeedNum(long roleid, long targetRoleid)
/*      */   {
/*  493 */     CatBag xCatBag = Role2catbag.get(Long.valueOf(roleid));
/*  494 */     if (xCatBag == null)
/*      */     {
/*  496 */       return 0;
/*      */     }
/*  498 */     FeedInfo xFeedInfo = xCatBag.getFeed_info();
/*  499 */     checkDailyFeedInfo(xFeedInfo);
/*  500 */     Integer feedNum = (Integer)xFeedInfo.getFeed_cat_records().get(Long.valueOf(targetRoleid));
/*  501 */     if (feedNum == null)
/*      */     {
/*  503 */       return 0;
/*      */     }
/*  505 */     return feedNum.intValue();
/*      */   }
/*      */   
/*      */   static void checkDailyFeedInfo(FeedInfo xFeedInfo)
/*      */   {
/*  510 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  511 */     long lastFeedTime = xFeedInfo.getFeed_timestamp();
/*  512 */     STimeCommonCfg sTimeCommonCfg = TimeCommonUtil.getCommonCfg(SCatCfgConsts.getInstance().FEED_CLEAR_TIME);
/*  513 */     if (DateTimeUtils.needDailyReset(lastFeedTime, now, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute))
/*      */     {
/*  515 */       xFeedInfo.getFeed_records().clear();
/*  516 */       xFeedInfo.setFeed_timestamp(now);
/*      */     }
/*      */   }
/*      */   
/*      */   static void checkDailyExploreNum(xbean.CatInfo xCatInfo)
/*      */   {
/*  522 */     if (xCatInfo.getExplore_num() == 0)
/*      */     {
/*  524 */       return;
/*      */     }
/*  526 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  527 */     long lastExploreTime = xCatInfo.getExplore_starttime();
/*  528 */     STimeCommonCfg sTimeCommonCfg = TimeCommonUtil.getCommonCfg(SCatCfgConsts.getInstance().FEED_CLEAR_TIME);
/*  529 */     if (DateTimeUtils.needDailyReset(lastExploreTime, now, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute))
/*      */     {
/*  531 */       xCatInfo.setExplore_num(0);
/*      */     }
/*      */   }
/*      */   
/*      */   static void displayAtHomeland(long roleid, long worldid, int mapCfgid, boolean isHomeCreateor)
/*      */   {
/*  537 */     xbean.CatInfo xCatInfo = getHomelandCat(roleid, true);
/*  538 */     if (xCatInfo == null)
/*      */     {
/*  540 */       return;
/*      */     }
/*      */     
/*      */ 
/*  544 */     if (xCatInfo.getState() == 2)
/*      */     {
/*  546 */       new PExploreCheck(roleid).execute();
/*      */     }
/*      */     
/*  549 */     addMapCatEntity(roleid, xCatInfo, worldid, mapCfgid, isHomeCreateor);
/*      */   }
/*      */   
/*      */   private static class PExploreCheck extends mzm.gsp.util.LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     
/*      */     public PExploreCheck(long roleid)
/*      */     {
/*  558 */       this.roleid = roleid;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  564 */       xbean.CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/*  565 */       if (xCatInfo == null)
/*      */       {
/*  567 */         return false;
/*      */       }
/*      */       
/*  570 */       if (xCatInfo.getState() != 2)
/*      */       {
/*  572 */         return false;
/*      */       }
/*      */       
/*  575 */       long catid = xCatInfo.getId();
/*  576 */       if (Catexploreobservers.get(Long.valueOf(catid)) != null)
/*      */       {
/*  578 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  582 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  583 */       long exploreEndTime = xCatInfo.getExplore_endtime();
/*      */       
/*      */ 
/*  586 */       long delaySeconds = TimeUnit.MILLISECONDS.toSeconds(exploreEndTime - now);
/*  587 */       if (delaySeconds < 0L)
/*      */       {
/*  589 */         delaySeconds = 0L;
/*      */       }
/*  591 */       CatManager.exploreObserver(this.roleid, catid, delaySeconds);
/*      */       
/*  593 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static void addMapCatEntity(long roleid, xbean.CatInfo xCatInfo, long worldid, int mapCfgid, boolean isHomeCreator)
/*      */   {
/*  600 */     long catid = xCatInfo.getId();
/*  601 */     int itemCfgid = xCatInfo.getItem_cfgid();
/*  602 */     int homelandCatCfgid = SCatItemCfg.get(itemCfgid).homelandCatCfgid;
/*  603 */     int npcid = getNpcId(itemCfgid);
/*      */     
/*  605 */     SpaceCoordinate spaceCoordinate = getSpaceCoordinate(npcid, mapCfgid, isHomeCreator ? LocationType.MAIN1 : LocationType.SUB1);
/*      */     
/*      */ 
/*  608 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/*  609 */     stringExtraInfoEntries.put(Integer.valueOf(200), xCatInfo.getName());
/*  610 */     stringExtraInfoEntries.put(Integer.valueOf(204), RoleInterface.getName(roleid));
/*      */     
/*  612 */     Map<Integer, Long> longExtraInfoEntries = new HashMap();
/*  613 */     longExtraInfoEntries.put(Integer.valueOf(201), Long.valueOf(roleid));
/*      */     
/*  615 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/*  616 */     intExtraInfoEntries.put(Integer.valueOf(202), Integer.valueOf(spaceCoordinate.z));
/*  617 */     if (xCatInfo.getState() == 2)
/*      */     {
/*  619 */       intExtraInfoEntries.put(Integer.valueOf(203), Integer.valueOf(2));
/*      */     }
/*      */     else
/*      */     {
/*  623 */       intExtraInfoEntries.put(Integer.valueOf(203), Integer.valueOf(1));
/*      */     }
/*      */     
/*  626 */     MapInterface.addMapEntity(MapEntityType.MGT_EXPLORE_CAT, catid, worldid, mapCfgid, spaceCoordinate.x, spaceCoordinate.y, homelandCatCfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */     
/*      */ 
/*  629 */     GameServer.logger().info(String.format("[cat]CatManager.addMapCatEntity@add cat entity into map|role_id=%d|cat_id=%d|world_id=%d|map_cfgid=%d|home_creator=%b", new Object[] { Long.valueOf(roleid), Long.valueOf(catid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Boolean.valueOf(isHomeCreator) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onHomelandNone(String userid, long roleid, xbean.CatInfo xCatInfo)
/*      */   {
/*  638 */     if (!checkState(xCatInfo))
/*      */     {
/*  640 */       GameServer.logger().error(String.format("[cat]CatManager.onHomelandNone@check state|roleid=%d|catid=%d|state=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  645 */       return;
/*      */     }
/*      */     
/*  648 */     CatBag xCatBag = getCatBag(roleid);
/*      */     
/*  650 */     checkDailyExploreNum(xCatInfo);
/*      */     
/*  652 */     int exploredLevel = 0;
/*  653 */     int exploredPartnerCfgid = 0;
/*      */     
/*  655 */     long catid = xCatInfo.getId();
/*  656 */     int state = xCatInfo.getState();
/*  657 */     if (state == 2)
/*      */     {
/*      */ 
/*  660 */       cancelExploreObserver(catid);
/*  661 */       xCatInfo.setState(1);
/*      */       
/*  663 */       xCatInfo.setExplored_level(0);
/*  664 */       xCatInfo.setExplored_partner_cfgid(0);
/*      */     }
/*  666 */     else if (state == 1)
/*      */     {
/*  668 */       exploredLevel = xCatInfo.getExplored_level();
/*  669 */       exploredPartnerCfgid = xCatInfo.getExplored_partner_cfgid();
/*  670 */       if ((exploredLevel != 0) || (exploredPartnerCfgid != 0))
/*      */       {
/*      */ 
/*  673 */         Map<Integer, Integer> items = sendExploreAward(userid, roleid, catid, exploredLevel, exploredPartnerCfgid, false);
/*      */         
/*  675 */         recordAwardItem(roleid, catid, xCatBag, items);
/*  676 */         xCatInfo.setExplored_level(0);
/*  677 */         xCatInfo.setExplored_partner_cfgid(0);
/*      */       }
/*      */     }
/*  680 */     else if (state == 3)
/*      */     {
/*  682 */       exploredLevel = xCatInfo.getExplored_level();
/*  683 */       exploredPartnerCfgid = xCatInfo.getExplored_partner_cfgid();
/*  684 */       if ((exploredLevel != 0) || (exploredPartnerCfgid != 0))
/*      */       {
/*      */ 
/*  687 */         Map<Integer, Integer> items = sendExploreAward(userid, roleid, catid, exploredLevel, exploredPartnerCfgid, false);
/*      */         
/*  689 */         recordAwardItem(roleid, catid, xCatBag, items);
/*  690 */         xCatInfo.setExplored_level(0);
/*  691 */         xCatInfo.setExplored_partner_cfgid(0);
/*      */       }
/*      */       
/*  694 */       xCatInfo.setForce_recovery_time(DateTimeUtils.getCurrTimeInMillis());
/*      */     }
/*      */     else
/*      */     {
/*  698 */       GameServer.logger().error(String.format("[cat]CatManager.onHomelandNone@state invalid|roleid=%d|catid=%d|state=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(state), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*      */       
/*      */ 
/*      */ 
/*  702 */       return;
/*      */     }
/*      */     
/*  705 */     Item xItem = (Item)xCatBag.getItems().remove(Long.valueOf(catid));
/*  706 */     if (xItem == null)
/*      */     {
/*  708 */       GameServer.logger().error(String.format("[cat]CatManager.onHomelandNone@items remove failed|roleid=%d|catid=%d|state=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(state), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*      */       
/*      */ 
/*      */ 
/*  712 */       return;
/*      */     }
/*      */     
/*  715 */     int sendType = 0;
/*  716 */     TLogArg logArg = new TLogArg(LogReason.ITEM_CAT_RECOVERY);
/*  717 */     if (ItemInterface.isBagFull(roleid, 340600000, true))
/*      */     {
/*      */ 
/*  720 */       MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*  721 */       mailAttachment.addXItem(xItem);
/*  722 */       List<String> emptyStrings = Collections.emptyList();
/*  723 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, SCatCfgConsts.getInstance().CAT_ITEM_MAIL_CFG_ID, emptyStrings, emptyStrings, mailAttachment, logArg);
/*      */       
/*  725 */       if (!ret.isOK())
/*      */       {
/*  727 */         GameServer.logger().error(String.format("[cat]CatManager.onHomelandNone@mail send cat item failed|roleid=%d|catid=%d|state=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(state), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*      */         
/*      */ 
/*      */ 
/*  731 */         return;
/*      */       }
/*  733 */       sendType = 1;
/*      */     }
/*      */     else
/*      */     {
/*  737 */       if (!ItemInterface.addItem(roleid, xItem, logArg))
/*      */       {
/*  739 */         GameServer.logger().error(String.format("[cat]CatManager.onHomelandNone@add cat item failed|roleid=%d|catid=%d|state=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(state), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*      */         
/*      */ 
/*      */ 
/*  743 */         return;
/*      */       }
/*  745 */       sendType = 2;
/*      */     }
/*      */     
/*      */ 
/*  749 */     addRecoveryCatToItemTLog(roleid, catid, xCatInfo.getCat_level_cfgid(), xCatInfo.getItem_cfgid(), xCatInfo.getTotal_explore_num(), xCatInfo.getVigor(), xCatInfo.getState(), false, exploredLevel, exploredPartnerCfgid, sendType);
/*      */     
/*      */ 
/*      */ 
/*  753 */     GameServer.logger().info(String.format("[cat]CatManager.onHomelandNone@handle done|roleid=%d|catid=%d|state=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(state) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void recordAwardItem(long roleid, long catid, CatBag xCatBag, Map<Integer, Integer> items)
/*      */   {
/*  760 */     for (Map.Entry<Integer, Integer> entry : items.entrySet())
/*      */     {
/*  762 */       Integer key = (Integer)entry.getKey();
/*  763 */       if (key.intValue() == SCatCfgConsts.getInstance().BIRD)
/*      */       {
/*  765 */         int oldNum = 0;
/*  766 */         Integer num = (Integer)xCatBag.getAward_info().get(key);
/*  767 */         if (num != null)
/*      */         {
/*  769 */           oldNum = num.intValue();
/*      */         }
/*  771 */         xCatBag.getAward_info().put(key, Integer.valueOf(((Integer)entry.getValue()).intValue() + oldNum));
/*  772 */         break;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  777 */     GetCatExploreAward event = new GetCatExploreAward();
/*  778 */     GetCatExploreAwardArg arg = new GetCatExploreAwardArg(roleid, catid, items);
/*  779 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */   }
/*      */   
/*      */   static void removeCatFromWorld(long roleid, boolean retainLock, MapCallback<Boolean> callback)
/*      */   {
/*  784 */     xbean.CatInfo xCatInfo = getHomelandCat(roleid, retainLock);
/*  785 */     if (xCatInfo == null)
/*      */     {
/*  787 */       return;
/*      */     }
/*      */     
/*  790 */     MapInterface.removeMapEntity(MapEntityType.MGT_EXPLORE_CAT, xCatInfo.getId(), callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getNpcId(int catItemCfgid)
/*      */   {
/*  801 */     SCatItemCfg catItemCfg = SCatItemCfg.get(catItemCfgid);
/*  802 */     int homelandCatCfgid = catItemCfg.homelandCatCfgid;
/*  803 */     SHomelandCatCfg homelandCatCfg = SHomelandCatCfg.get(homelandCatCfgid);
/*  804 */     return homelandCatCfg.npcid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static SpaceCoordinate getSpaceCoordinate(int npcid, int mapCfgid, LocationType locationType)
/*      */   {
/*  819 */     SpaceCoordinate result = null;
/*  820 */     for (SNPCDynamicCfg cfg : SNPCDynamicCfg.getAll().values())
/*      */     {
/*  822 */       if ((cfg.npcCfgid == npcid) && (cfg.mapCfgid == mapCfgid))
/*      */       {
/*  824 */         switch (locationType)
/*      */         {
/*      */         case MAIN1: 
/*  827 */           result = new SpaceCoordinate(cfg.mainLocation1X, cfg.mainLocation1Y, cfg.mainLocation1Z);
/*  828 */           break;
/*      */         case SUB1: 
/*  830 */           result = new SpaceCoordinate(cfg.subLocation1X, cfg.subLocation1Y, cfg.subLocation1Z);
/*  831 */           break;
/*      */         case MAIN2: 
/*  833 */           result = new SpaceCoordinate(cfg.mainLocation2X, cfg.mainLocation2Y, cfg.mainLocation2Z);
/*  834 */           break;
/*      */         case SUB2: 
/*  836 */           result = new SpaceCoordinate(cfg.subLocation2X, cfg.subLocation2Y, cfg.subLocation2Z);
/*  837 */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  844 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static Map<Integer, Integer> sendExploreAward(String userid, long roleid, long catid, int exploredLevel, int exploredPartnerCfgid, boolean active)
/*      */   {
/*  851 */     SLevelToCatCfg levelToCatCfg = SLevelToCatCfg.get(exploredLevel);
/*  852 */     if (levelToCatCfg == null)
/*      */     {
/*  854 */       GameServer.logger().error(String.format("[cat]CatManager.sendExploreAward@level to cat cfg is null|userid=%s|roleid=%d|catid=%d|explored_level=%d|explored_partner_cfgid=%d|active=%b", new Object[] { userid, Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(exploredLevel), Integer.valueOf(exploredPartnerCfgid), Boolean.valueOf(active) }));
/*      */       
/*      */ 
/*      */ 
/*  858 */       return null;
/*      */     }
/*  860 */     SCatLevelCfg catLevelCfg = SCatLevelCfg.get(levelToCatCfg.catLevelCfgid);
/*  861 */     if (catLevelCfg == null)
/*      */     {
/*  863 */       GameServer.logger().error(String.format("[cat]CatManager.sendExploreAward@cat level cfg is null|userid=%s|roleid=%d|catid=%d|explored_level=%d|explored_partner_cfgid=%d|active=%b|cat_level_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Long.valueOf(catid), Integer.valueOf(exploredLevel), Integer.valueOf(exploredPartnerCfgid), Boolean.valueOf(active), Integer.valueOf(levelToCatCfg.catLevelCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  867 */       return null;
/*      */     }
/*  869 */     int catLevelAwardid = catLevelCfg.awardid;
/*      */     
/*      */ 
/*  872 */     AwardPoolResultData catLevelResult = AwardPoolInterface.getAwardPoolData(catLevelAwardid, roleid, RoleInterface.getLevel(roleid));
/*      */     
/*  874 */     if (catLevelResult == null)
/*      */     {
/*      */ 
/*  877 */       addTLogAtOnce(userid, roleid, catid, catLevelAwardid, 0, active, 2);
/*  878 */       return null;
/*      */     }
/*      */     
/*  881 */     Map<Integer, Integer> itemMap = catLevelResult.getItemMap();
/*      */     
/*  883 */     int partnerAwardid = 0;
/*  884 */     if (exploredPartnerCfgid != 0)
/*      */     {
/*  886 */       SCatPartnerCfg catPartnerCfg = SCatPartnerCfg.get(exploredPartnerCfgid);
/*  887 */       if (catPartnerCfg == null)
/*      */       {
/*  889 */         return null;
/*      */       }
/*  891 */       partnerAwardid = catPartnerCfg.awardid;
/*  892 */       AwardPoolResultData patrnerResult = AwardPoolInterface.getAwardPoolData(partnerAwardid, roleid, RoleInterface.getLevel(roleid));
/*      */       
/*  894 */       if (patrnerResult == null)
/*      */       {
/*      */ 
/*  897 */         addTLogAtOnce(userid, roleid, catid, catLevelAwardid, partnerAwardid, active, 2);
/*  898 */         return null;
/*      */       }
/*      */       
/*  901 */       for (Map.Entry<Integer, Integer> entry : patrnerResult.getItemMap().entrySet())
/*      */       {
/*  903 */         int key = ((Integer)entry.getKey()).intValue();
/*  904 */         if (itemMap.containsKey(Integer.valueOf(key)))
/*      */         {
/*  906 */           itemMap.put(Integer.valueOf(key), Integer.valueOf(((Integer)itemMap.get(Integer.valueOf(key))).intValue() + ((Integer)entry.getValue()).intValue()));
/*      */         }
/*      */         else
/*      */         {
/*  910 */           itemMap.put(Integer.valueOf(key), entry.getValue());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  915 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(roleid, itemMap, false, new TLogArg(LogReason.CAT_EXPLORE_AWARD));
/*      */     
/*  917 */     if ((itemOperateResult.success()) || (itemOperateResult.isBagFull()))
/*      */     {
/*  919 */       StringBuilder awardItemids = new StringBuilder();
/*  920 */       StringBuilder awardNums = new StringBuilder();
/*  921 */       for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*      */       {
/*  923 */         awardItemids.append(entry.getKey()).append(',');
/*  924 */         awardNums.append(entry.getValue()).append(',');
/*      */       }
/*  926 */       String items = awardItemids.substring(0, awardItemids.length() - 1).toString();
/*  927 */       String nums = awardNums.substring(0, awardNums.length() - 1).toString();
/*      */       
/*  929 */       addTlog(userid, roleid, catid, catLevelAwardid, partnerAwardid, active, 1, items, nums);
/*      */       
/*  931 */       worldBroadcast(roleid, itemMap);
/*  932 */       return itemMap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  937 */     addTLogAtOnce(userid, roleid, catid, catLevelAwardid, partnerAwardid, active, 2);
/*  938 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void addTlog(String userid, long roleid, long catid, int catLevelAwardid, int partnerAwardid, boolean active, int status, String awartItems, String awardNums)
/*      */   {
/*  957 */     String vGameIp = GameServerInfoManager.getHostIP();
/*  958 */     int roleLevel = RoleInterface.getLevel(roleid);
/*      */     
/*  960 */     TLogManager.getInstance().addLog(userid, "CatExploreAwardForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(catid), Integer.valueOf(catLevelAwardid), Integer.valueOf(partnerAwardid), Integer.valueOf(active ? 1 : 0), Integer.valueOf(status), awartItems, awardNums });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void addTLogAtOnce(String userid, long roleid, long catid, int catLevelAwardid, int partnerAwardid, boolean active, int status)
/*      */   {
/*  979 */     String vGameIp = GameServerInfoManager.getHostIP();
/*  980 */     int roleLevel = RoleInterface.getLevel(roleid);
/*      */     
/*  982 */     TLogManager.getInstance().addLogAtOnce(userid, "CatExploreAwardForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(catid), Integer.valueOf(catLevelAwardid), Integer.valueOf(partnerAwardid), Integer.valueOf(active ? 1 : 0), Integer.valueOf(status), "", "" });
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean restStateAndSendMail(long roleid, xbean.CatInfo xCatInfo)
/*      */   {
/*  988 */     int curLevel = getCatLevel(xCatInfo);
/*  989 */     if (curLevel < 0)
/*      */     {
/*  991 */       return false;
/*      */     }
/*      */     
/*  994 */     xCatInfo.setState(3);
/*      */     
/*  996 */     if (!checkState(xCatInfo))
/*      */     {
/*  998 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1002 */     TLogArg tLogArg = new TLogArg(LogReason.SEND_MAIL_ON_EXPLORE_END);
/* 1003 */     List<String> emptyStrings = Collections.emptyList();
/* 1004 */     int mailCfgId = SCatCfgConsts.getInstance().CAT_EXPLORE_END_MAIL_CFG_ID;
/* 1005 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgId, emptyStrings, emptyStrings, null, tLogArg);
/*      */     
/* 1007 */     if (!sendMailRet.isOK())
/*      */     {
/* 1009 */       GameServer.logger().error(String.format("[cat]CatManager.restStateAndSendMail@send mail failed|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|state=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(SCatCfgConsts.getInstance().CAT_EXPLORE_END_MAIL_CFG_ID) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1014 */       return false;
/*      */     }
/* 1016 */     return true;
/*      */   }
/*      */   
/*      */   static void onCatNameChange(long catid, String name)
/*      */   {
/* 1021 */     Map<Integer, String> replaceStringExtraInfoEntries = new HashMap();
/* 1022 */     replaceStringExtraInfoEntries.put(Integer.valueOf(200), name);
/* 1023 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_EXPLORE_CAT, catid, null, null, replaceStringExtraInfoEntries, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onCatExploreEnd(long catid)
/*      */   {
/* 1029 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 1030 */     replaceIntExtraInfoEntries.put(Integer.valueOf(203), Integer.valueOf(1));
/* 1031 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_EXPLORE_CAT, catid, replaceIntExtraInfoEntries, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onSendCatToExplore(long catid)
/*      */   {
/* 1037 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 1038 */     replaceIntExtraInfoEntries.put(Integer.valueOf(203), Integer.valueOf(2));
/* 1039 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_EXPLORE_CAT, catid, replaceIntExtraInfoEntries, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean checkNpcService(long roleid, xbean.CatInfo xCatInfo)
/*      */   {
/* 1045 */     int itemCfgid = xCatInfo.getItem_cfgid();
/* 1046 */     SCatItemCfg catItemCfg = SCatItemCfg.get(itemCfgid);
/* 1047 */     if (catItemCfg == null)
/*      */     {
/* 1049 */       GameServer.logger().error(String.format("[cat]CatManager.checkNpcService@cat item cfg is null|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(itemCfgid) }));
/*      */       
/*      */ 
/*      */ 
/* 1053 */       return false;
/*      */     }
/*      */     
/* 1056 */     int homelandCatCfgid = catItemCfg.homelandCatCfgid;
/* 1057 */     SHomelandCatCfg homelandCatCfg = SHomelandCatCfg.get(homelandCatCfgid);
/* 1058 */     if (homelandCatCfg == null)
/*      */     {
/* 1060 */       GameServer.logger().error(String.format("[cat]CatManager.checkNpcService@homeland cat cfg is null|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|homelang_cat_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(itemCfgid), Integer.valueOf(homelandCatCfgid) }));
/*      */       
/*      */ 
/*      */ 
/* 1064 */       return false;
/*      */     }
/*      */     
/* 1067 */     int npcid = 0;
/* 1068 */     if (xCatInfo.getState() == 2)
/*      */     {
/* 1070 */       npcid = homelandCatCfg.explore_npcid;
/*      */     }
/*      */     else
/*      */     {
/* 1074 */       npcid = homelandCatCfg.npcid;
/*      */     }
/* 1076 */     if (!NpcInterface.checkNpcService(roleid, SCatCfgConsts.getInstance().CAT_SERVICE_ID, npcid, new CatNpcChecker(roleid, xCatInfo.getId())))
/*      */     {
/*      */ 
/* 1079 */       GameServer.logger().error(String.format("[cat]CatManager.checkNpcService@check npc service failed|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|homelang_cat_cfgid=%d|npcid=%d|service_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(itemCfgid), Integer.valueOf(homelandCatCfgid), Integer.valueOf(npcid), Integer.valueOf(SCatCfgConsts.getInstance().CAT_SERVICE_ID) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1084 */       return false;
/*      */     }
/*      */     
/* 1087 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addRecoveryCatToItemTLog(long roleid, long catid, int catLevelCfgid, int itemCfgid, int totalExploreNum, int vigor, int state, boolean active, int exploredLevel, int exploredPartnerCfgid, int sendType)
/*      */   {
/* 1121 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 1122 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 1123 */     String userid = RoleInterface.getUserId(roleid);
/* 1124 */     TLogManager.getInstance().addLog(userid, "RecoveryCatToItemForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(catid), Integer.valueOf(catLevelCfgid), Integer.valueOf(itemCfgid), Integer.valueOf(totalExploreNum), Integer.valueOf(vigor), Integer.valueOf(state), Integer.valueOf(active ? 1 : 0), Integer.valueOf(exploredLevel), Integer.valueOf(exploredPartnerCfgid), Integer.valueOf(sendType) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addSystemRecoveryCatItemTlog(long roleid, long catid, int catLevelCfgid, int itemCfgid, int totalExploreNum, int vigor, int state, int partnerCfgid)
/*      */   {
/* 1153 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 1154 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 1155 */     String userid = RoleInterface.getUserId(roleid);
/* 1156 */     TLogManager.getInstance().addLog(userid, "SystemRecoveryCatForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(catid), Integer.valueOf(catLevelCfgid), Integer.valueOf(itemCfgid), Integer.valueOf(totalExploreNum), Integer.valueOf(vigor), Integer.valueOf(state), Integer.valueOf(partnerCfgid) });
/*      */   }
/*      */   
/*      */ 
/*      */   private static void worldBroadcast(long roleid, Map<Integer, Integer> itemMap)
/*      */   {
/* 1162 */     HashMap<Integer, Integer> preciousItems = new HashMap();
/* 1163 */     for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*      */     {
/* 1165 */       int itemCfgId = ((Integer)entry.getKey()).intValue();
/* 1166 */       if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemCfgId))
/*      */       {
/* 1168 */         preciousItems.put(Integer.valueOf(itemCfgId), entry.getValue());
/*      */       }
/*      */     }
/* 1171 */     if (!preciousItems.isEmpty())
/*      */     {
/* 1173 */       SBrocastExploreItem broadcast = new SBrocastExploreItem();
/* 1174 */       broadcast.roleid = roleid;
/* 1175 */       broadcast.items = preciousItems;
/*      */       try
/*      */       {
/* 1178 */         broadcast.role_name.setString(RoleInterface.getName(roleid), "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/*      */ 
/* 1184 */       OnlineManager.getInstance().sendAll(broadcast);
/*      */     }
/*      */   }
/*      */   
/*      */   static int getAwardItemNum(long roleid, int itemCfgid, boolean holdLock)
/*      */   {
/* 1190 */     CatBag xCatBag = null;
/* 1191 */     if (holdLock)
/*      */     {
/* 1193 */       xCatBag = Role2catbag.get(Long.valueOf(roleid));
/*      */     }
/*      */     else
/*      */     {
/* 1197 */       xCatBag = Role2catbag.select(Long.valueOf(roleid));
/*      */     }
/* 1199 */     if (xCatBag == null)
/*      */     {
/* 1201 */       return 0;
/*      */     }
/*      */     
/* 1204 */     Integer num = (Integer)xCatBag.getAward_info().get(Integer.valueOf(itemCfgid));
/* 1205 */     return num == null ? 0 : num.intValue();
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\CatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */