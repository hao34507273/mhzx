/*      */ package mzm.gsp.crossbattle.point;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import hub.DataTransferReq;
/*      */ import hub.ExchangeDataHandlerInfo;
/*      */ import hub.GHubHelper;
/*      */ import hub.HubCorpsCVCInfo;
/*      */ import hub.PointRaceCorpsBaseInfo;
/*      */ import hub.PointRaceDataBackReq;
/*      */ import hub.PointRaceUserDataBack;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*      */ import mzm.gsp.crossbattle.CorpsPointRaceData;
/*      */ import mzm.gsp.crossbattle.GetCorpsZoneContext;
/*      */ import mzm.gsp.crossbattle.GetCorpsZoneReq;
/*      */ import mzm.gsp.crossbattle.PointRaceRankData;
/*      */ import mzm.gsp.crossbattle.RemovePointRaceContext;
/*      */ import mzm.gsp.crossbattle.RemovePointRaceReq;
/*      */ import mzm.gsp.crossbattle.ReportCorpsPointRaceReq;
/*      */ import mzm.gsp.crossbattle.SGetPointRaceRankLocalSuccess;
/*      */ import mzm.gsp.crossbattle.SPointRaceReadyFail;
/*      */ import mzm.gsp.crossbattle.SStageBroadcast;
/*      */ import mzm.gsp.crossbattle.SZoneDrawLotsFail;
/*      */ import mzm.gsp.crossbattle.SZoneDrawLotsSuccess;
/*      */ import mzm.gsp.crossbattle.SyncNextMatchCountDown;
/*      */ import mzm.gsp.crossbattle.SyncPointRaceCorpsid;
/*      */ import mzm.gsp.crossbattle.SyncPointRaceTitle;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*      */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*      */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*      */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*      */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*      */ import mzm.gsp.fight.main.FightInterface;
/*      */ import mzm.gsp.fight.main.FightReason;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.CrossbattleDrawLots;
/*      */ import xbean.CrossbattlePoint;
/*      */ import xbean.CrossbattlePointRaceInfo;
/*      */ import xbean.DrawLotsZoneInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.PointPVPInfo;
/*      */ import xdb.Xdb;
/*      */ import xtable.Crossbattledrawlots;
/*      */ import xtable.Crossbattlepoint;
/*      */ import xtable.Crossbattlepointpvp;
/*      */ import xtable.Role2pointracecontextid;
/*      */ 
/*      */ public class CrossBattlePointManager
/*      */ {
/*      */   private static final int MAX_SECOND = 120;
/*   76 */   static int TEAM_SIZE = 5;
/*      */   static final String ENCODING = "UTF-8";
/*      */   
/*      */   static void setTeamSize(int size)
/*      */   {
/*   81 */     TEAM_SIZE = size;
/*      */   }
/*      */   
/*      */   static boolean canDoAction(long roleid, int action)
/*      */   {
/*   86 */     return RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*      */   }
/*      */   
/*      */   static boolean isFunOpen(long roleid, int activitySwitch, int funSwitch)
/*      */   {
/*   91 */     if (!OpenInterface.getOpenStatus(activitySwitch))
/*      */     {
/*   93 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.isFunOpen@activity not open|activity_switch=%d", new Object[] { Integer.valueOf(activitySwitch) }));
/*      */       
/*      */ 
/*   96 */       return false;
/*      */     }
/*   98 */     if (OpenInterface.isBanPlay(roleid, activitySwitch))
/*      */     {
/*  100 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */       
/*  102 */       OpenInterface.sendBanPlayMsg(roleid, activitySwitch);
/*  103 */       return false;
/*      */     }
/*  105 */     if (!OpenInterface.getOpenStatus(funSwitch))
/*      */     {
/*  107 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.isFunOpen@fun not open|fun=%d", new Object[] { Integer.valueOf(funSwitch) }));
/*      */       
/*  109 */       return false;
/*      */     }
/*  111 */     if (OpenInterface.isBanPlay(roleid, funSwitch))
/*      */     {
/*  113 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.isFunOpen@ban play|roleid=%d|fun=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(funSwitch) }));
/*      */       
/*      */ 
/*  116 */       OpenInterface.sendBanPlayMsg(roleid, funSwitch);
/*  117 */       return false;
/*      */     }
/*  119 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isFunOpen(int activitySwitch, int funSwitch)
/*      */   {
/*  124 */     if (!OpenInterface.getOpenStatus(activitySwitch))
/*      */     {
/*  126 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.isFunOpen@activity not open|activity_switch=%d", new Object[] { Integer.valueOf(activitySwitch) }));
/*      */       
/*      */ 
/*  129 */       return false;
/*      */     }
/*  131 */     if (!OpenInterface.getOpenStatus(funSwitch))
/*      */     {
/*  133 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.isFunOpen@fun not open|fun=%d", new Object[] { Integer.valueOf(funSwitch) }));
/*      */       
/*  135 */       return false;
/*      */     }
/*  137 */     return true;
/*      */   }
/*      */   
/*      */   static int random()
/*      */   {
/*  142 */     Random random = Xdb.random();
/*  143 */     return random.nextInt(120);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void onZoneDivideStart(int activityCfgid, boolean startAgain)
/*      */   {
/*  150 */     SCrossBattleDrawLotsCfg crossBattleDrawLotsCfg = SCrossBattleDrawLotsCfg.get(activityCfgid);
/*  151 */     if (crossBattleDrawLotsCfg == null)
/*      */     {
/*  153 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onZoneDivideStart@cross battle draw lots cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  157 */       return;
/*      */     }
/*      */     
/*  160 */     int timePointCfgid = crossBattleDrawLotsCfg.drawLotsTimePoint;
/*  161 */     STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  162 */     if (timePointCommonCfg == null)
/*      */     {
/*  164 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onZoneDivideStart@time point cfg is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(timePointCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  168 */       return;
/*      */     }
/*      */     
/*  171 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  172 */     long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg);
/*  173 */     long drawLotsDelay = startTime - now;
/*      */     
/*  175 */     if ((drawLotsDelay > 0L) || (!startAgain))
/*      */     {
/*  177 */       reportFightValue(activityCfgid, startAgain);
/*      */     }
/*      */     
/*  180 */     if (drawLotsDelay < 0L)
/*      */     {
/*  182 */       drawLotsDelay = 0L;
/*      */     }
/*  184 */     new DrawLotsStartObserver(TimeUnit.MILLISECONDS.toSeconds(drawLotsDelay), activityCfgid);
/*      */   }
/*      */   
/*      */   static void reportFightValue(int activityCfgid, boolean startAgain)
/*      */   {
/*  189 */     int delay = random();
/*  190 */     new ReportCorpsFightValueObserver(delay, activityCfgid);
/*      */   }
/*      */   
/*      */   static CrossbattleDrawLots getAndInitCrossbattleDrawLots(int activityCfgid)
/*      */   {
/*  195 */     long key = GameServerInfoManager.toGlobalId(activityCfgid);
/*  196 */     CrossbattleDrawLots xCrossbattleDrawLots = Crossbattledrawlots.get(Long.valueOf(key));
/*  197 */     if (xCrossbattleDrawLots == null)
/*      */     {
/*  199 */       xCrossbattleDrawLots = Pod.newCrossbattleDrawLots();
/*  200 */       Crossbattledrawlots.insert(Long.valueOf(key), xCrossbattleDrawLots);
/*      */     }
/*  202 */     return xCrossbattleDrawLots;
/*      */   }
/*      */   
/*      */   static void onDrawLotsStart(int activityCfgid)
/*      */   {
/*  207 */     SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(activityCfgid);
/*  208 */     if (cfg == null)
/*      */     {
/*  210 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onDrawLotsStart@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  213 */       return;
/*      */     }
/*      */     
/*      */ 
/*  217 */     List<Long> corpsids = CrossBattleOwnInterface.getAllCrossBattleOwnPromotionCorpsids(activityCfgid, true);
/*  218 */     if (corpsids.isEmpty())
/*      */     {
/*  220 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onDrawLotsStart@corps empty|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  223 */       return;
/*      */     }
/*      */     
/*      */ 
/*  227 */     sendDrawLotsMail(activityCfgid, corpsids, cfg.drawLotsMailCfgid);
/*      */     
/*  229 */     startGetCorpsZonesObserver(activityCfgid);
/*      */     
/*      */ 
/*  232 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  233 */     long endTime = getDrawLotsEndTime(activityCfgid);
/*  234 */     long delay = endTime - now;
/*  235 */     if (delay < 0L)
/*      */     {
/*  237 */       delay = 0L;
/*      */     }
/*  239 */     new DrawLotsEndObserver(TimeUnit.MILLISECONDS.toSeconds(delay), activityCfgid);
/*      */   }
/*      */   
/*      */   static long getDrawLotsEndTime(int activityCfgid)
/*      */   {
/*  244 */     SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(activityCfgid);
/*  245 */     if (cfg == null)
/*      */     {
/*  247 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.getDrawLotsEndTime@cfg is null|draw_lots_cfg=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  250 */       return -1L;
/*      */     }
/*  252 */     int drawLotsTimePoint = cfg.drawLotsTimePoint;
/*  253 */     STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(drawLotsTimePoint);
/*  254 */     if (timePointCommonCfg == null)
/*      */     {
/*  256 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.getDrawLotsEndTime@time point cfg is null|draw_lots_time_point=%d", new Object[] { Integer.valueOf(drawLotsTimePoint) }));
/*      */       
/*      */ 
/*      */ 
/*  260 */       return -1L;
/*      */     }
/*      */     
/*      */ 
/*  264 */     long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg);
/*  265 */     return startTime + TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/*      */   }
/*      */   
/*      */   static void sendDrawLotsMail(int activityCfgid, List<Long> corpsids, int mailCfgid)
/*      */   {
/*  270 */     CrossbattleDrawLots xCrossbattleDrawLots = getAndInitCrossbattleDrawLots(activityCfgid);
/*  271 */     for (Long corpsid : corpsids)
/*      */     {
/*  273 */       DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(corpsid);
/*  274 */       if ((xDrawLotsZoneInfo == null) || (xDrawLotsZoneInfo.getMailed() != 1))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  279 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PDrawLotsMail(corpsid.longValue(), activityCfgid, mailCfgid));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void startGetCorpsZonesObserver(int activityCfgid)
/*      */   {
/*  286 */     int delay = random();
/*  287 */     new GetCorpsZonesObserver(delay, activityCfgid);
/*      */   }
/*      */   
/*      */   static Map<Long, Integer> getCorpsZone(int activityCfgid)
/*      */   {
/*  292 */     long key = GameServerInfoManager.toGlobalId(activityCfgid);
/*  293 */     CrossbattleDrawLots xCrossbattleDrawLots = Crossbattledrawlots.get(Long.valueOf(key));
/*  294 */     if (xCrossbattleDrawLots == null)
/*      */     {
/*  296 */       return Collections.emptyMap();
/*      */     }
/*  298 */     if (xCrossbattleDrawLots.getCorps().isEmpty())
/*      */     {
/*  300 */       return Collections.emptyMap();
/*      */     }
/*  302 */     Map<Long, Integer> result = new HashMap();
/*  303 */     for (Map.Entry<Long, DrawLotsZoneInfo> xEntry : xCrossbattleDrawLots.getCorps().entrySet())
/*      */     {
/*  305 */       DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xEntry.getValue();
/*  306 */       if (xDrawLotsZoneInfo.getZone() > 0)
/*      */       {
/*      */ 
/*      */ 
/*  310 */         result.put(xEntry.getKey(), Integer.valueOf(xDrawLotsZoneInfo.getZone())); }
/*      */     }
/*  312 */     return result;
/*      */   }
/*      */   
/*      */   static int getCorpsZone(int activityCfgid, long corpsid)
/*      */   {
/*  317 */     return getCorpsZone(activityCfgid, corpsid, true);
/*      */   }
/*      */   
/*      */   static int getCorpsZone(int activityCfgid, long corpsid, boolean isHoldLock)
/*      */   {
/*  322 */     long key = GameServerInfoManager.toGlobalId(activityCfgid);
/*      */     CrossbattleDrawLots xCrossbattleDrawLots;
/*  324 */     CrossbattleDrawLots xCrossbattleDrawLots; if (isHoldLock)
/*      */     {
/*  326 */       xCrossbattleDrawLots = Crossbattledrawlots.get(Long.valueOf(key));
/*      */     }
/*      */     else
/*      */     {
/*  330 */       xCrossbattleDrawLots = Crossbattledrawlots.select(Long.valueOf(key));
/*      */     }
/*  332 */     if (xCrossbattleDrawLots == null)
/*      */     {
/*  334 */       return -1;
/*      */     }
/*  336 */     DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(Long.valueOf(corpsid));
/*  337 */     if (xDrawLotsZoneInfo == null)
/*      */     {
/*  339 */       return -1;
/*      */     }
/*  341 */     return xDrawLotsZoneInfo.getZone();
/*      */   }
/*      */   
/*      */   static int getCorpsZoneIfActive(int activityCfgid, long corpsid, boolean isHoldLock)
/*      */   {
/*  346 */     long key = GameServerInfoManager.toGlobalId(activityCfgid);
/*      */     CrossbattleDrawLots xCrossbattleDrawLots;
/*  348 */     CrossbattleDrawLots xCrossbattleDrawLots; if (isHoldLock)
/*      */     {
/*  350 */       xCrossbattleDrawLots = Crossbattledrawlots.get(Long.valueOf(key));
/*      */     }
/*      */     else
/*      */     {
/*  354 */       xCrossbattleDrawLots = Crossbattledrawlots.select(Long.valueOf(key));
/*      */     }
/*  356 */     if (xCrossbattleDrawLots == null)
/*      */     {
/*  358 */       return -1;
/*      */     }
/*  360 */     DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(Long.valueOf(corpsid));
/*  361 */     if (xDrawLotsZoneInfo == null)
/*      */     {
/*  363 */       return -1;
/*      */     }
/*  365 */     if (xDrawLotsZoneInfo.getActive() == 0)
/*      */     {
/*  367 */       return -1;
/*      */     }
/*  369 */     return xDrawLotsZoneInfo.getZone();
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
/*      */   static boolean getCorpsZones(long roleid, long corpsid, int activityCfgid, List<Long> corpsids)
/*      */   {
/*  383 */     GetCorpsZoneReq req = new GetCorpsZoneReq();
/*  384 */     req.activity_cfgid = activityCfgid;
/*  385 */     req.corpsids.addAll(corpsids);
/*      */     
/*  387 */     GetCorpsZoneContext context = new GetCorpsZoneContext();
/*  388 */     context.count = 1;
/*  389 */     context.roleid = roleid;
/*  390 */     context.corpsid = corpsid;
/*  391 */     OctetsStream contextOs = new OctetsStream();
/*  392 */     contextOs.marshal(context);
/*  393 */     req.context = contextOs;
/*      */     
/*  395 */     OctetsStream reqOs = new OctetsStream();
/*  396 */     reqOs.marshal(req);
/*      */     
/*      */ 
/*  399 */     return CrossServerInterface.asyncGetCorpsZone(reqOs);
/*      */   }
/*      */   
/*      */   static void onGetCorpsZoneDone(long roleid, long corpsid, int activityCfgid, Map<Long, Integer> data)
/*      */   {
/*  404 */     if ((data == null) || (data.isEmpty()))
/*      */     {
/*  406 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onCorpsZone@date empty|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  409 */       if (roleid > 0L)
/*      */       {
/*  411 */         SZoneDrawLotsFail msg = new SZoneDrawLotsFail();
/*  412 */         msg.retcode = -4;
/*  413 */         msg.activity_cfgid = activityCfgid;
/*  414 */         OnlineManager.getInstance().send(roleid, msg);
/*      */       }
/*  416 */       return;
/*      */     }
/*      */     
/*  419 */     CrossbattleDrawLots xCrossbattleDrawLots = getAndInitCrossbattleDrawLots(activityCfgid);
/*  420 */     for (Map.Entry<Long, Integer> entry : data.entrySet())
/*      */     {
/*  422 */       Long corpsKey = (Long)entry.getKey();
/*  423 */       DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(corpsKey);
/*  424 */       if (xDrawLotsZoneInfo == null)
/*      */       {
/*  426 */         xDrawLotsZoneInfo = Pod.newDrawLotsZoneInfo();
/*  427 */         xCrossbattleDrawLots.getCorps().put(corpsKey, xDrawLotsZoneInfo);
/*      */       }
/*  429 */       xDrawLotsZoneInfo.setZone(((Integer)entry.getValue()).intValue());
/*      */     }
/*      */     
/*  432 */     if (roleid > 0L)
/*      */     {
/*      */ 
/*  435 */       SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(activityCfgid);
/*  436 */       if (cfg == null)
/*      */       {
/*  438 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onCorpsZone@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */         
/*      */ 
/*  441 */         return;
/*      */       }
/*      */       
/*      */ 
/*  445 */       DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(Long.valueOf(corpsid));
/*  446 */       if ((xDrawLotsZoneInfo == null) || (xDrawLotsZoneInfo.getZone() <= 0))
/*      */       {
/*  448 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onCorpsZone@zone invalid|activity_cfgid=%d|roleid=%d|corpsid=%d", new Object[] { Integer.valueOf(activityCfgid), Long.valueOf(roleid), Long.valueOf(corpsid) }));
/*      */         
/*      */ 
/*      */ 
/*  452 */         return;
/*      */       }
/*      */       
/*  455 */       int zone = xDrawLotsZoneInfo.getZone();
/*  456 */       xDrawLotsZoneInfo.setActive(1);
/*      */       
/*      */ 
/*  459 */       asyncZoneCorpsMail(activityCfgid, corpsid, zone);
/*      */       
/*      */ 
/*  462 */       SZoneDrawLotsSuccess msg = new SZoneDrawLotsSuccess();
/*  463 */       msg.activity_cfgid = activityCfgid;
/*  464 */       msg.zone = zone;
/*  465 */       OnlineManager.getInstance().send(roleid, msg);
/*      */     }
/*  467 */     else if (roleid == -1L)
/*      */     {
/*      */ 
/*  470 */       checkSendZoneMail(activityCfgid);
/*      */     }
/*      */   }
/*      */   
/*      */   static void checkSendZoneMail(int activityCfgid)
/*      */   {
/*  476 */     SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(activityCfgid);
/*  477 */     if (cfg == null)
/*      */     {
/*  479 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.checkSendZoneMail@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  482 */       return;
/*      */     }
/*      */     
/*      */ 
/*  486 */     List<Long> corpsids = CrossBattleOwnInterface.getAllCrossBattleOwnPromotionCorpsids(activityCfgid, true);
/*  487 */     if (corpsids.isEmpty())
/*      */     {
/*  489 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.checkSendZoneMail@corps empty|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  492 */       return;
/*      */     }
/*      */     
/*  495 */     CrossbattleDrawLots xCrossbattleDrawLots = getAndInitCrossbattleDrawLots(activityCfgid);
/*  496 */     for (Long corpsid : corpsids)
/*      */     {
/*  498 */       DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(corpsid);
/*  499 */       if (xDrawLotsZoneInfo == null)
/*      */       {
/*  501 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.CrossBattlePointManager@data empty|activity_cfgid=%d|corpsid=%d", new Object[] { Integer.valueOf(activityCfgid), corpsid }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  508 */       else if (xDrawLotsZoneInfo.getActive() != 1)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  513 */         int zone = xDrawLotsZoneInfo.getZone();
/*  514 */         if (zone <= 0)
/*      */         {
/*  516 */           GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.CrossBattlePointManager@data invalid|activity_cfgid=%d|corpsid=%d", new Object[] { Integer.valueOf(activityCfgid), corpsid }));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*  522 */           xDrawLotsZoneInfo.setActive(1);
/*      */           
/*      */ 
/*  525 */           asyncZoneCorpsMail(activityCfgid, corpsid.longValue(), zone);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void asyncZoneCorpsMail(int activityCfgid, long corpsid, int zone) {
/*  532 */     new PZoneCorpsMail(activityCfgid, corpsid, zone).execute();
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
/*      */   static boolean reportCorpsFightValue(int activityCfgid, int zoneNum, boolean force, Map<Long, Float> corpsFightValues)
/*      */   {
/*  546 */     return CrossServerInterface.reportCorpsFightValue(activityCfgid, zoneNum, force, corpsFightValues);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static CrossbattlePoint getAndInitCrossBattlePoint(int activityCfgid)
/*      */   {
/*  553 */     long key = GameServerInfoManager.toGlobalId(activityCfgid);
/*  554 */     CrossbattlePoint xCrossbattlePoint = Crossbattlepoint.get(Long.valueOf(key));
/*  555 */     if (xCrossbattlePoint == null)
/*      */     {
/*  557 */       xCrossbattlePoint = Pod.newCrossbattlePoint();
/*  558 */       Crossbattlepoint.insert(Long.valueOf(key), xCrossbattlePoint);
/*      */     }
/*  560 */     return xCrossbattlePoint;
/*      */   }
/*      */   
/*      */   static CrossbattlePoint getCrossbattlePoint(int activityCfgid, boolean isHoldLock)
/*      */   {
/*  565 */     long key = GameServerInfoManager.toGlobalId(activityCfgid);
/*  566 */     if (isHoldLock)
/*      */     {
/*  568 */       return Crossbattlepoint.get(Long.valueOf(key));
/*      */     }
/*      */     
/*      */ 
/*  572 */     return Crossbattlepoint.select(Long.valueOf(key));
/*      */   }
/*      */   
/*      */ 
/*      */   static CrossbattlePointRaceInfo getAndInitCrossbattlePointRaceInfo(int activityCfgid, int timePointCfgid)
/*      */   {
/*  578 */     CrossbattlePoint xCrossbattlePoint = getAndInitCrossBattlePoint(activityCfgid);
/*  579 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/*  580 */     if (xCrossbattlePointRaceInfo == null)
/*      */     {
/*  582 */       xCrossbattlePointRaceInfo = Pod.newCrossbattlePointRaceInfo();
/*  583 */       xCrossbattlePointRaceInfo.setTime_point_cfgid(timePointCfgid);
/*  584 */       xCrossbattlePoint.getPoint_races().put(Integer.valueOf(timePointCfgid), xCrossbattlePointRaceInfo);
/*      */     }
/*  586 */     return xCrossbattlePointRaceInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static CrossbattlePointRaceInfo initCrossBattlePointRaceInfo(int activityCfgid, int timePointCfgid)
/*      */   {
/*  593 */     CrossbattlePoint xCrossbattlePoint = getAndInitCrossBattlePoint(activityCfgid);
/*  594 */     xCrossbattlePoint.setTime_point_cfgid(timePointCfgid);
/*  595 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/*  596 */     if (xCrossbattlePointRaceInfo == null)
/*      */     {
/*  598 */       xCrossbattlePointRaceInfo = Pod.newCrossbattlePointRaceInfo();
/*  599 */       xCrossbattlePointRaceInfo.setTime_point_cfgid(timePointCfgid);
/*  600 */       xCrossbattlePoint.getPoint_races().put(Integer.valueOf(timePointCfgid), xCrossbattlePointRaceInfo);
/*      */     }
/*  602 */     return xCrossbattlePointRaceInfo;
/*      */   }
/*      */   
/*      */ 
/*      */   static CrossbattlePointRaceInfo getCrossbattlePointRaceInfo(int activityCfgid, int timePointCfgid, boolean isHoldLock)
/*      */   {
/*  608 */     CrossbattlePoint xCrossbattlePoint = getCrossbattlePoint(activityCfgid, isHoldLock);
/*  609 */     if (xCrossbattlePoint == null)
/*      */     {
/*  611 */       return null;
/*      */     }
/*  613 */     return (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/*      */   }
/*      */   
/*      */   static void onPointRaceStageStart(int activityCfgid)
/*      */   {
/*  618 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(activityCfgid);
/*  619 */     if (cfg == null)
/*      */     {
/*  621 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onPointRaceStageStart@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  625 */       return;
/*      */     }
/*      */     
/*  628 */     List<TimePointInfo> timePointInfos = cfg.timePoints;
/*  629 */     if (timePointInfos.isEmpty())
/*      */     {
/*  631 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onPointRaceStageStart@time point is empty|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  635 */       return;
/*      */     }
/*      */     
/*  638 */     Map<Long, Integer> corpsZones = getCorpsZone(activityCfgid);
/*  639 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/*      */ 
/*      */ 
/*  643 */     int firstTimePoint = ((TimePointInfo)timePointInfos.get(0)).timePoint;
/*  644 */     for (Long corpsid : corpsZones.keySet())
/*      */     {
/*  646 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PPointRacePrepareMail(activityCfgid, corpsid.longValue(), firstTimePoint));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  653 */     CrossbattlePoint xCrossbattlePoint = getAndInitCrossBattlePoint(activityCfgid);
/*  654 */     long lastTime = TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/*  655 */     long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*      */     
/*  657 */     for (TimePointInfo timePointInfo : cfg.timePoints)
/*      */     {
/*  659 */       int timePointCfgid = timePointInfo.timePoint;
/*  660 */       STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  661 */       if (timePointCommonCfg == null)
/*      */       {
/*  663 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onPointRaceStageStart@time point cfg is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(timePointCfgid) }));
/*      */ 
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*      */ 
/*  671 */         long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg) - prepareTime;
/*  672 */         if (startTime > now)
/*      */         {
/*  674 */           new PointRaceObserver(TimeUnit.MILLISECONDS.toSeconds(startTime - now) + 1L, activityCfgid, timePointCfgid);
/*      */         }
/*      */         else
/*      */         {
/*  678 */           CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/*      */           
/*  680 */           long delay = getDelay(now, startTime, lastTime);
/*  681 */           if (xCrossbattlePointRaceInfo == null)
/*      */           {
/*  683 */             initCrossBattlePointRaceInfo(activityCfgid, timePointCfgid);
/*  684 */             if (delay <= 0L)
/*      */             {
/*  686 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PPointRaceCheck(activityCfgid, timePointCfgid, false));
/*      */ 
/*      */             }
/*      */             else
/*      */             {
/*  691 */               new PointRaceEndLocalObserver(TimeUnit.MILLISECONDS.toSeconds(delay) + 1L, activityCfgid, timePointCfgid);
/*      */             }
/*      */             
/*      */ 
/*      */           }
/*  696 */           else if (delay > 0L)
/*      */           {
/*      */ 
/*  699 */             new PointRaceEndLocalObserver(TimeUnit.MILLISECONDS.toSeconds(delay) + 1L, activityCfgid, timePointCfgid);
/*      */ 
/*      */ 
/*      */           }
/*  703 */           else if (xCrossbattlePointRaceInfo.getBackup_zones().isEmpty())
/*      */           {
/*      */ 
/*  706 */             CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PPointRaceCheck(activityCfgid, timePointCfgid, false));
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/*  712 */             int backupTimePointCfgid = timePointInfo.backupTimePoint;
/*  713 */             STimePointCommonCfg backupimePointCommonCfg = STimePointCommonCfg.get(backupTimePointCfgid);
/*  714 */             if (backupimePointCommonCfg == null)
/*      */             {
/*  716 */               GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onPointRaceStageStart@time point cfg is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(backupTimePointCfgid) }));
/*      */ 
/*      */ 
/*      */             }
/*      */             else
/*      */             {
/*      */ 
/*  723 */               long backupStartTime = TimeCommonUtil.getTimePoint(backupimePointCommonCfg) - prepareTime;
/*  724 */               long startDelay; Iterator i$; if (backupStartTime > now)
/*      */               {
/*      */ 
/*  727 */                 startDelay = TimeUnit.MILLISECONDS.toSeconds(backupStartTime - now);
/*  728 */                 for (i$ = xCrossbattlePointRaceInfo.getBackup_zones().iterator(); i$.hasNext();) { int zone = ((Integer)i$.next()).intValue();
/*      */                   
/*  730 */                   new PointRaceBackupObserver(startDelay, activityCfgid, zone, timePointCfgid, backupTimePointCfgid);
/*      */                 }
/*      */               }
/*      */               else
/*      */               {
/*  735 */                 long backupDelay = getDelay(now, backupStartTime, lastTime);
/*  736 */                 if (backupDelay <= 0L)
/*      */                 {
/*  738 */                   CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PPointRaceCheck(activityCfgid, timePointCfgid, false));
/*      */ 
/*      */                 }
/*      */                 else
/*      */                 {
/*  743 */                   new PointRaceEndLocalObserver(TimeUnit.MILLISECONDS.toSeconds(backupDelay) + 1L, activityCfgid, timePointCfgid);
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static long getStartTime(SCrossBattlePointCfg cfg, CrossbattlePointRaceInfo xCrossbattlePointRaceInfo, int zone) {
/*  754 */     long lastTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*  755 */     int timePointCfgid = xCrossbattlePointRaceInfo.getTime_point_cfgid();
/*  756 */     if (!xCrossbattlePointRaceInfo.getBackup_zones().contains(Integer.valueOf(zone)))
/*      */     {
/*  758 */       STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  759 */       if (timePointCommonCfg == null)
/*      */       {
/*  761 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.getStartTime@time point cfg is null|time_point_cfgid=%d", new Object[] { Integer.valueOf(timePointCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*  765 */         return -1L;
/*      */       }
/*  767 */       return TimeCommonUtil.getTimePoint(timePointCommonCfg) - lastTime;
/*      */     }
/*      */     
/*      */ 
/*  771 */     TimePointInfo targetTimePointInfo = null;
/*  772 */     for (TimePointInfo timePointInfo : cfg.timePoints)
/*      */     {
/*  774 */       if (timePointInfo.timePoint == timePointCfgid)
/*      */       {
/*  776 */         targetTimePointInfo = timePointInfo;
/*  777 */         break;
/*      */       }
/*      */     }
/*  780 */     if (targetTimePointInfo == null)
/*      */     {
/*  782 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.getStartTime@time point info not found|time_point_cfgid=%d", new Object[] { Integer.valueOf(timePointCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  786 */       return -1L;
/*      */     }
/*      */     
/*  789 */     int backupTimePointCfgid = targetTimePointInfo.backupTimePoint;
/*  790 */     STimePointCommonCfg backupTimePointCommonCfg = STimePointCommonCfg.get(backupTimePointCfgid);
/*  791 */     if (backupTimePointCommonCfg == null)
/*      */     {
/*  793 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.getStartTime@backup time point cfg is null|time_point_cfgid=%d", new Object[] { Integer.valueOf(backupTimePointCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  797 */       return -1L;
/*      */     }
/*  799 */     return TimeCommonUtil.getTimePoint(backupTimePointCommonCfg) - lastTime;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getCurIndex(SCrossBattlePointCfg cfg, CrossbattlePoint xCrossbattlePoint, int zone)
/*      */   {
/*  805 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  806 */     long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*  807 */     long lastTime = TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/*  808 */     int index = 0;
/*  809 */     for (TimePointInfo timePointInfo : cfg.timePoints)
/*      */     {
/*  811 */       index++;
/*  812 */       int timePointCfgid = timePointInfo.timePoint;
/*  813 */       CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/*      */       
/*  815 */       if (xCrossbattlePointRaceInfo == null)
/*      */       {
/*  817 */         return index;
/*      */       }
/*  819 */       if (xCrossbattlePointRaceInfo.getBackup_zones().contains(Integer.valueOf(zone)))
/*      */       {
/*      */ 
/*  822 */         int backupTimePointCfgid = timePointInfo.backupTimePoint;
/*  823 */         STimePointCommonCfg backTimePointCommonCfg = STimePointCommonCfg.get(backupTimePointCfgid);
/*  824 */         long backupStartTime = TimeCommonUtil.getTimePoint(backTimePointCommonCfg) - prepareTime;
/*  825 */         if (backupStartTime + lastTime > now)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  830 */           return index;
/*      */         }
/*      */       }
/*      */       else {
/*  834 */         STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  835 */         long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg) - prepareTime;
/*  836 */         if (startTime + lastTime > now)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  841 */           return index; }
/*      */       }
/*      */     }
/*  844 */     return 0;
/*      */   }
/*      */   
/*      */   static void onGetZonePointRace(int activityCfgid, int zone, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*      */   {
/*  849 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new POnGetZonePointRace(activityCfgid, zone, corpsPointRaceInfos));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetZonePointRaceDataDone(long roleid, int activityCfgid, int zone, int from, int to, int index, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*      */   {
/*  857 */     QueryPointRaceInfo queryPointRaceInfo = new QueryPointRaceInfo(activityCfgid, zone, index);
/*  858 */     PointRaceRankLocal.getInstance().putChart(queryPointRaceInfo, corpsPointRaceInfos);
/*      */     
/*  860 */     SGetPointRaceRankLocalSuccess rsp = new SGetPointRaceRankLocalSuccess();
/*  861 */     int chartSize = corpsPointRaceInfos.size();
/*  862 */     if (from <= chartSize)
/*      */     {
/*  864 */       int toIndex = to;
/*  865 */       if (to > chartSize)
/*      */       {
/*  867 */         toIndex = chartSize;
/*      */       }
/*  869 */       List<CorpsPointRaceInfo> chartObjs = corpsPointRaceInfos.subList(from - 1, toIndex);
/*  870 */       List<PointRaceRankData> datas = transToPointRaceRankDatas(chartObjs, from);
/*  871 */       rsp.point_race_ranks.addAll(datas);
/*      */     }
/*  873 */     rsp.activity_cfgid = activityCfgid;
/*  874 */     rsp.zone = zone;
/*  875 */     rsp.time_point_cfgid = index;
/*  876 */     rsp.from = from;
/*  877 */     rsp.to = to;
/*  878 */     OnlineManager.getInstance().send(roleid, rsp);
/*      */     
/*  880 */     GameServer.logger().info(String.format("[crossbattlepoint]PCGetPointRaceRankLocal.onGetZonePointRaceDataDone@get data from chart|activity_cfgid=%d|zone=%d|time_point_index=%d|from=%d|to=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(index), Integer.valueOf(from), Integer.valueOf(to) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<PointRaceRankData> transToPointRaceRankDatas(List<CorpsPointRaceInfo> chartObjs, int from)
/*      */   {
/*  888 */     if ((chartObjs == null) || (chartObjs.isEmpty()))
/*      */     {
/*  890 */       return Collections.emptyList();
/*      */     }
/*  892 */     List<PointRaceRankData> result = new ArrayList();
/*  893 */     for (int i = 0; i < chartObjs.size(); i++)
/*      */     {
/*  895 */       CorpsPointRaceInfo chartObj = (CorpsPointRaceInfo)chartObjs.get(i);
/*  896 */       PointRaceRankData data = new PointRaceRankData();
/*      */       try
/*      */       {
/*  899 */         data.corps_name.setString(chartObj.getCorpsName(), "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/*      */ 
/*  905 */       data.icon = chartObj.getIcon();
/*  906 */       data.point = chartObj.getPoint();
/*  907 */       data.rank = (from + i);
/*  908 */       data.zoneid = chartObj.getZoneid();
/*  909 */       result.add(data);
/*      */     }
/*  911 */     return result;
/*      */   }
/*      */   
/*      */   static BackupResult pointRaceBackup(int activityCfgid, int zone, int index)
/*      */   {
/*  916 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(activityCfgid);
/*  917 */     if (cfg == null)
/*      */     {
/*  919 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.pointRaceBackup@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*  922 */       return BackupResult.CfgNotFound;
/*      */     }
/*      */     
/*  925 */     List<TimePointInfo> timePointInfos = cfg.timePoints;
/*  926 */     if (timePointInfos.isEmpty())
/*      */     {
/*  928 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.pointRaceBackup@time point is empty|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  932 */       return BackupResult.CfgNotFound;
/*      */     }
/*      */     
/*  935 */     if ((index < 1) || (index > timePointInfos.size()))
/*      */     {
/*  937 */       return BackupResult.ParamInvalid;
/*      */     }
/*      */     
/*  940 */     TimePointInfo timePointInfo = (TimePointInfo)timePointInfos.get(index - 1);
/*  941 */     int timePointCfgid = timePointInfo.timePoint;
/*  942 */     int backupTimePointCfgid = timePointInfo.backupTimePoint;
/*      */     
/*  944 */     STimePointCommonCfg backupTimePointCommonCfg = STimePointCommonCfg.get(backupTimePointCfgid);
/*  945 */     if (backupTimePointCommonCfg == null)
/*      */     {
/*  947 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.pointRaceBackup@backup time point cfg is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(backupTimePointCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  951 */       return BackupResult.CfgNotFound;
/*      */     }
/*      */     
/*  954 */     STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  955 */     if (timePointCommonCfg == null)
/*      */     {
/*  957 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.pointRaceBackup@time point cfg is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(timePointCfgid) }));
/*      */       
/*      */ 
/*      */ 
/*  961 */       return BackupResult.CfgNotFound;
/*      */     }
/*      */     
/*  964 */     long lastTime = TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/*  965 */     long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*      */     
/*      */ 
/*  968 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  969 */     long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg) - prepareTime;
/*  970 */     if (startTime + lastTime >= now)
/*      */     {
/*  972 */       return BackupResult.CurPointRaceNotEnd;
/*      */     }
/*      */     
/*      */ 
/*  976 */     long backupStartTime = TimeCommonUtil.getTimePoint(backupTimePointCommonCfg) - prepareTime;
/*  977 */     if (backupStartTime < now)
/*      */     {
/*  979 */       return BackupResult.DateExpire;
/*      */     }
/*      */     
/*  982 */     Map<Long, Integer> corpsZones = getCorpsZone(activityCfgid);
/*  983 */     if (corpsZones.isEmpty())
/*      */     {
/*  985 */       return BackupResult.Success;
/*      */     }
/*      */     
/*  988 */     List<Long> corpsids = new ArrayList();
/*  989 */     for (Map.Entry<Long, Integer> entry : corpsZones.entrySet())
/*      */     {
/*  991 */       Long corpsid = (Long)entry.getKey();
/*  992 */       if (((Integer)entry.getValue()).intValue() == zone)
/*      */       {
/*  994 */         corpsids.add(corpsid);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  999 */     CrossbattlePoint xCrossbattlePoint = getAndInitCrossBattlePoint(activityCfgid);
/* 1000 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/* 1001 */     if (xCrossbattlePointRaceInfo != null)
/*      */     {
/* 1003 */       if (xCrossbattlePointRaceInfo.getBackup_zones().contains(Integer.valueOf(zone)))
/*      */       {
/* 1005 */         return BackupResult.AlreadyBackup;
/*      */       }
/*      */       
/* 1008 */       for (Long corpsid : corpsids)
/*      */       {
/* 1010 */         xCrossbattlePointRaceInfo.getCorps().remove(corpsid);
/*      */         
/* 1012 */         xCrossbattlePoint.getCorps_result().remove(corpsid);
/*      */       }
/* 1014 */       xCrossbattlePointRaceInfo.getBackup_zones().add(Integer.valueOf(zone));
/*      */     }
/*      */     else
/*      */     {
/* 1018 */       xCrossbattlePointRaceInfo = initCrossBattlePointRaceInfo(activityCfgid, timePointCfgid);
/* 1019 */       xCrossbattlePointRaceInfo.getBackup_zones().add(Integer.valueOf(zone));
/*      */     }
/*      */     
/* 1022 */     int fighNum = mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface.getKnockOutStageFightNum(activityCfgid, 1, 1);
/* 1023 */     if (fighNum == -1)
/*      */     {
/* 1025 */       return BackupResult.CfgNotFound;
/*      */     }
/*      */     
/* 1028 */     if (!removePointRace(activityCfgid, zone, timePointCfgid, corpsids, fighNum))
/*      */     {
/* 1030 */       return BackupResult.OtherException;
/*      */     }
/*      */     
/*      */ 
/* 1034 */     for (Long corpsid : corpsids)
/*      */     {
/* 1036 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PPointRaceBackupMail(activityCfgid, corpsid.longValue(), index));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1041 */     new PointRaceBackupObserver(TimeUnit.MILLISECONDS.toSeconds(backupStartTime - now), activityCfgid, zone, timePointCfgid, backupTimePointCfgid);
/*      */     
/*      */ 
/* 1044 */     return BackupResult.Success;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean removePointRace(int activityCfgid, int zone, int timePointCfgid, List<Long> corpsids, int fightNum)
/*      */   {
/* 1050 */     if ((corpsids == null) || (corpsids.isEmpty()))
/*      */     {
/* 1052 */       return true;
/*      */     }
/*      */     
/* 1055 */     RemovePointRaceContext context = new RemovePointRaceContext();
/* 1056 */     context.oper_type = 1;
/*      */     
/* 1058 */     RemovePointRaceReq req = new RemovePointRaceReq();
/* 1059 */     req.corpsids.addAll(corpsids);
/* 1060 */     req.fight_num = fightNum;
/*      */     
/* 1062 */     OctetsStream reqOs = new OctetsStream();
/* 1063 */     req.marshal(reqOs);
/* 1064 */     context.content = reqOs;
/*      */     
/* 1066 */     OctetsStream contextOs = new OctetsStream();
/* 1067 */     contextOs.marshal(context);
/*      */     
/* 1069 */     return CrossServerInterface.asyncRemovePointRace(activityCfgid, zone, timePointCfgid, contextOs);
/*      */   }
/*      */   
/*      */   static void pointRaceResultTLog(long corpsid, String corpsName, int rank)
/*      */   {
/* 1074 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 1075 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 1076 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 1077 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*      */     
/* 1079 */     String vGameAppid = "0";
/* 1080 */     int PlatID = -1;
/* 1081 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 1082 */     String vopenid = "0";
/*      */     
/* 1084 */     StringBuffer sb = new StringBuffer();
/* 1085 */     sb.append(GameSvrId).append('|');
/* 1086 */     sb.append(dtEventTime).append('|');
/* 1087 */     sb.append("0").append('|');
/* 1088 */     sb.append(-1).append('|');
/* 1089 */     sb.append(iZoneAreaID).append('|');
/* 1090 */     sb.append("0").append('|');
/*      */     
/* 1092 */     sb.append(corpsid).append('|');
/* 1093 */     sb.append(corpsName).append('|');
/* 1094 */     sb.append(rank);
/*      */     
/* 1096 */     TLogManager.getInstance().addLog("PointRaceResultForServer", sb.toString());
/*      */   }
/*      */   
/*      */   static long startPointRace(PointRaceInfo pointRaceInfo, List<PointRaceCorpsBaseInfo> corpsBaseInfos)
/*      */   {
/* 1101 */     int activityCfgid = pointRaceInfo.getActivityCfgid();
/* 1102 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(activityCfgid);
/* 1103 */     if (cfg == null)
/*      */     {
/* 1105 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.starPointRace@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/* 1108 */       return -1L;
/*      */     }
/*      */     
/* 1111 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1112 */     long startTime = pointRaceInfo.getStartTime();
/* 1113 */     long endDelay = getDelay(now, startTime, TimeUnit.MINUTES.toMillis(cfg.durationInMinute));
/* 1114 */     if (endDelay <= 0L)
/*      */     {
/* 1116 */       return -1L;
/*      */     }
/*      */     
/* 1119 */     int mapCfgid = cfg.remoteMapCfgid;
/* 1120 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(mapCfgid) }));
/*      */     
/* 1122 */     int zone = pointRaceInfo.getZone();
/* 1123 */     int timePointCfgid = pointRaceInfo.getTimePointCfgid();
/* 1124 */     int index = pointRaceInfo.getIndex();
/* 1125 */     byte backup = pointRaceInfo.getBackup();
/* 1126 */     initPointRaceInfo(worldid, activityCfgid, zone, timePointCfgid, startTime);
/* 1127 */     PointRaceZoneManager zoneManager = new PointRaceZoneManager(worldid, activityCfgid, zone, timePointCfgid, startTime, index, backup);
/*      */     
/* 1129 */     PointRaceManager.getInstance().putZoneManager(worldid, zoneManager);
/*      */     
/* 1131 */     for (PointRaceCorpsBaseInfo corpsBaseInfo : corpsBaseInfos)
/*      */     {
/* 1133 */       String name = corpsBaseInfo.name.getString("UTF-8");
/* 1134 */       Map<Long, CorpsCVCInfo> corpsFights = new HashMap();
/* 1135 */       for (Map.Entry<Long, HubCorpsCVCInfo> entry : corpsBaseInfo.cvc_infos.entrySet())
/*      */       {
/* 1137 */         HubCorpsCVCInfo hubCorpsCVCInfo = (HubCorpsCVCInfo)entry.getValue();
/* 1138 */         CorpsCVCInfo corpsCVCInfo = new CorpsCVCInfo(hubCorpsCVCInfo.win, hubCorpsCVCInfo.lose);
/* 1139 */         corpsFights.put(entry.getKey(), corpsCVCInfo);
/*      */       }
/*      */       
/* 1142 */       PointRaceCorpsPreInfo preInfo = new PointRaceCorpsPreInfo(corpsBaseInfo.zoneid, name, corpsBaseInfo.icon, corpsBaseInfo.win, corpsBaseInfo.lose, corpsBaseInfo.point, corpsBaseInfo.update_time, corpsFights);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1147 */       int zoneid = corpsBaseInfo.zoneid;
/* 1148 */       zoneManager.put(corpsBaseInfo.corpsid, zoneid, preInfo);
/*      */     }
/*      */     
/*      */ 
/* 1152 */     long matchDelay = getDelay(now, startTime, TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute));
/*      */     
/* 1154 */     MatchObserver matchObserver = new MatchObserver(TimeUnit.MILLISECONDS.toSeconds(matchDelay) + 1L, worldid, cfg.matchIntervalSecond);
/*      */     
/* 1156 */     zoneManager.setMatchObserver(matchObserver);
/*      */     
/*      */ 
/* 1159 */     long cvcReportDelay = TimeUnit.MILLISECONDS.toSeconds(matchDelay) + random();
/* 1160 */     ReportCVCObserver cvcObserver = new ReportCVCObserver(cvcReportDelay, worldid);
/* 1161 */     zoneManager.setCVCObserver(cvcObserver);
/*      */     
/*      */ 
/* 1164 */     long cancelMatchDelay = getDelay(now, startTime, TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute + cfg.matchDurationInMinute));
/*      */     
/* 1166 */     new CancelMatchObserver(TimeUnit.MILLISECONDS.toSeconds(cancelMatchDelay), worldid);
/*      */     
/*      */ 
/* 1169 */     new PointRaceEndObserver(TimeUnit.MILLISECONDS.toSeconds(endDelay), worldid);
/*      */     
/* 1171 */     return worldid;
/*      */   }
/*      */   
/*      */ 
/*      */   static void onCrossServerFail(List<Long> roleids, int code, int activityCfgid)
/*      */   {
/* 1177 */     RoleStatusInterface.unsetStatus(roleids, 1441);
/* 1178 */     RoleStatusInterface.unsetStatus(roleids, 41);
/* 1179 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1181 */       Role2pointracecontextid.remove(Long.valueOf(roleid));
/*      */     }
/*      */     
/* 1184 */     SPointRaceReadyFail resp = new SPointRaceReadyFail();
/* 1185 */     resp.retcode = code;
/* 1186 */     resp.activity_cfgid = activityCfgid;
/* 1187 */     OnlineManager.getInstance().sendMulti(resp, roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   static void initPointRaceInfo(long worldid, int activityCfgid, int zone, int timePointCfgid, long startTime)
/*      */   {
/* 1193 */     PointPVPInfo xPointPVPInfo = Crossbattlepointpvp.get(Long.valueOf(worldid));
/* 1194 */     if (xPointPVPInfo == null)
/*      */     {
/* 1196 */       xPointPVPInfo = Pod.newPointPVPInfo();
/* 1197 */       Crossbattlepointpvp.insert(Long.valueOf(worldid), xPointPVPInfo);
/*      */     }
/* 1199 */     xPointPVPInfo.setActivity_cfgid(activityCfgid);
/* 1200 */     xPointPVPInfo.setZone(zone);
/* 1201 */     xPointPVPInfo.setTime_point_cfgid(timePointCfgid);
/* 1202 */     xPointPVPInfo.setStart_time(startTime);
/* 1203 */     xPointPVPInfo.getFights().clear();
/* 1204 */     xPointPVPInfo.setFinish(false);
/*      */   }
/*      */   
/*      */ 
/*      */   static void syncPointRaceStage(long roleid, int zone, int index, byte backup, int stage, long countDown)
/*      */   {
/* 1210 */     SStageBroadcast msg = new SStageBroadcast();
/* 1211 */     msg.zone = zone;
/* 1212 */     msg.index = index;
/* 1213 */     msg.backup = backup;
/* 1214 */     msg.stage = stage;
/* 1215 */     msg.countdown = ((int)TimeUnit.MILLISECONDS.toSeconds(countDown));
/* 1216 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */ 
/*      */   static void syncPointRaceStage(Collection<Long> roleids, int zone, int index, byte backup, int stage, long countDown)
/*      */   {
/* 1222 */     SStageBroadcast msg = new SStageBroadcast();
/* 1223 */     msg.zone = zone;
/* 1224 */     msg.index = index;
/* 1225 */     msg.backup = backup;
/* 1226 */     msg.stage = stage;
/* 1227 */     msg.countdown = ((int)TimeUnit.MILLISECONDS.toSeconds(countDown));
/* 1228 */     OnlineManager.getInstance().sendMulti(msg, roleids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncPointRaceCorpsid(long roleid, long corpsid)
/*      */   {
/* 1239 */     SyncPointRaceCorpsid msg = new SyncPointRaceCorpsid();
/* 1240 */     msg.corps_id = corpsid;
/* 1241 */     OnlineManager.getInstance().send(roleid, msg);
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
/*      */   static void setPointRaceTitle(long roleid, long corpsid, String corpsName, int corpsDuty, int badgeid)
/*      */   {
/* 1255 */     SyncPointRaceTitle protocol = new SyncPointRaceTitle();
/* 1256 */     protocol.corps_id = corpsid;
/*      */     try
/*      */     {
/* 1259 */       protocol.corps_name.setString(corpsName, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1265 */     protocol.corps_duty = corpsDuty;
/* 1266 */     protocol.corps_badge_id = badgeid;
/* 1267 */     MapInterface.setModelProtocol(roleid, protocol);
/* 1268 */     GameServer.logger().info(String.format("[crossbattlepoint]CrossBattlePointManager.setPointRaceTitle@set point race title|roleid=%d|corpsid=%d|corps_name=%s|corps_duty=%d|badgeid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(corpsid), corpsName, Integer.valueOf(corpsDuty), Integer.valueOf(badgeid) }));
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
/*      */   static void unsetPointRaceTitle(long roleid)
/*      */   {
/* 1281 */     MapInterface.unSetModelProtocol(roleid, 12617069);
/* 1282 */     GameServer.logger().info(String.format("[crossbattlepoint]CrossBattlePointManager.unsetPointRaceTitle@unset point race title|roleid=%d", new Object[] { Long.valueOf(roleid) }));
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
/*      */   static boolean updatePointRaceCorps(int activityCfgid, int timePointCfgid, PointRaceCorpsInfo corpsInfo)
/*      */   {
/* 1299 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = getCrossbattlePointRaceInfo(activityCfgid, timePointCfgid, true);
/*      */     
/* 1301 */     if (xCrossbattlePointRaceInfo == null)
/*      */     {
/* 1303 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.updatePointRaceCorps@xbean point race is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(timePointCfgid) }));
/*      */       
/*      */ 
/*      */ 
/* 1307 */       return false;
/*      */     }
/*      */     
/* 1310 */     long corpsid = corpsInfo.getCorpsid();
/* 1311 */     List<Long> corpsids = CrossBattleOwnInterface.getAllCrossBattleOwnPromotionCorpsids(activityCfgid, true);
/* 1312 */     if (!corpsids.contains(Long.valueOf(corpsid)))
/*      */     {
/* 1314 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.updatePointRaceCorps@corpsid not promotion|activity_cfgid=%d|corpsid=%d|corps_ids=%s", new Object[] { Integer.valueOf(activityCfgid), Long.valueOf(corpsid), corpsids.toString() }));
/*      */       
/*      */ 
/*      */ 
/* 1318 */       return false;
/*      */     }
/*      */     
/* 1321 */     int zone = getCorpsZone(activityCfgid, corpsid);
/* 1322 */     if (zone <= 0)
/*      */     {
/* 1324 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.updatePointRaceCorps@corpsid zone error|activityCfgid=%d|corpsid=%d", new Object[] { Integer.valueOf(activityCfgid), Long.valueOf(corpsid) }));
/*      */       
/*      */ 
/*      */ 
/* 1328 */       return false;
/*      */     }
/*      */     
/* 1331 */     xbean.PointRaceInfo xPointRaceInfo = (xbean.PointRaceInfo)xCrossbattlePointRaceInfo.getCorps().get(Long.valueOf(corpsid));
/* 1332 */     if (xPointRaceInfo == null)
/*      */     {
/* 1334 */       xPointRaceInfo = Pod.newPointRaceInfo();
/* 1335 */       xCrossbattlePointRaceInfo.getCorps().put(Long.valueOf(corpsid), xPointRaceInfo);
/*      */     }
/*      */     
/* 1338 */     int win = corpsInfo.getWin();
/* 1339 */     int lose = corpsInfo.getLose();
/* 1340 */     int point = corpsInfo.getPoint();
/* 1341 */     long updateTime = corpsInfo.getUpdateTime();
/*      */     
/* 1343 */     if (xPointRaceInfo.getUpdate_time() >= updateTime)
/*      */     {
/* 1345 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.updatePointRaceCorps@update time invalid|corpsid=%d|win=%d|lose=%d|point=%d|update_time=%d|local_update_time=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(win), Integer.valueOf(lose), Integer.valueOf(point), Long.valueOf(updateTime), Long.valueOf(xPointRaceInfo.getUpdate_time()) }));
/*      */       
/*      */ 
/*      */ 
/* 1349 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1353 */     xPointRaceInfo.setWin(win);
/* 1354 */     xPointRaceInfo.setLose(lose);
/* 1355 */     xPointRaceInfo.setPoint(point);
/* 1356 */     xPointRaceInfo.setUpdate_time(updateTime);
/* 1357 */     xPointRaceInfo.setReported(false);
/*      */     
/*      */ 
/* 1360 */     if (!reportCorpsPointRace(activityCfgid, corpsid, timePointCfgid, new CorpsPointRaceData(win, lose, point, updateTime)))
/*      */     {
/*      */ 
/* 1363 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.updatePointRaceCorps@report corps point race fail|corpsid=%d|win=%d|lose=%d|point=%d|update_time=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(win), Integer.valueOf(lose), Integer.valueOf(point), Long.valueOf(updateTime) }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1369 */     GameServer.logger().info(String.format("[crossbattlepoint]CrossBattlePointManager.updatePointRaceCorps@update success|corpsid=%d|win=%d|lose=%d|point=%d|update_time=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(win), Integer.valueOf(lose), Integer.valueOf(point), Long.valueOf(updateTime) }));
/*      */     
/*      */ 
/*      */ 
/* 1373 */     return true;
/*      */   }
/*      */   
/*      */   static long getDelay(long curTime, long startTime, long durationTime)
/*      */   {
/* 1378 */     long delay = startTime + durationTime - curTime;
/* 1379 */     return delay < 0L ? 0L : delay;
/*      */   }
/*      */   
/*      */   static void match(long worldid)
/*      */   {
/* 1384 */     PointPVPInfo xPointPVPInfo = Crossbattlepointpvp.get(Long.valueOf(worldid));
/* 1385 */     if (xPointPVPInfo == null)
/*      */     {
/* 1387 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.match@point pvp info is null|worldid=%d", new Object[] { Long.valueOf(worldid) }));
/*      */       
/* 1389 */       return;
/*      */     }
/*      */     
/* 1392 */     int activityCfgid = xPointPVPInfo.getActivity_cfgid();
/* 1393 */     int zone = xPointPVPInfo.getZone();
/* 1394 */     if (xPointPVPInfo.getFinish())
/*      */     {
/* 1396 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.match@point race ended|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*      */       
/*      */ 
/* 1399 */       return;
/*      */     }
/*      */     
/* 1402 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/* 1403 */     if (zoneManager == null)
/*      */     {
/* 1405 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.match@zone manager is null|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*      */       
/*      */ 
/*      */ 
/* 1409 */       return;
/*      */     }
/*      */     
/* 1412 */     int countDown = zoneManager.getMatchInterval();
/* 1413 */     Set<Long> fightCorpsids = new java.util.HashSet(xPointPVPInfo.getFights());
/* 1414 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/* 1415 */     List<MatchObj> matchObjs = corpsManager.getMatchObjs(fightCorpsids);
/* 1416 */     Collections.sort(matchObjs);
/*      */     
/* 1418 */     while (!matchObjs.isEmpty())
/*      */     {
/* 1420 */       Iterator<MatchObj> objIter = matchObjs.iterator();
/* 1421 */       MatchObj obj = (MatchObj)objIter.next();
/* 1422 */       objIter.remove();
/*      */       
/* 1424 */       int alternativeIndex = -1;
/* 1425 */       int alternativeTimes = -1;
/* 1426 */       int i = 0;
/*      */       
/* 1428 */       while (objIter.hasNext())
/*      */       {
/* 1430 */         MatchObj opponentObj = (MatchObj)objIter.next();
/* 1431 */         Integer times = (Integer)obj.corpsFightInfos.get(Long.valueOf(opponentObj.corpsid));
/* 1432 */         if (times == null)
/*      */         {
/* 1434 */           alternativeIndex = i;
/* 1435 */           break;
/*      */         }
/*      */         
/*      */ 
/* 1439 */         if (alternativeTimes < 0)
/*      */         {
/* 1441 */           alternativeIndex = i;
/* 1442 */           alternativeTimes = times.intValue();
/*      */ 
/*      */ 
/*      */         }
/* 1446 */         else if (times.intValue() < alternativeTimes)
/*      */         {
/* 1448 */           alternativeIndex = i;
/* 1449 */           alternativeTimes = times.intValue();
/*      */         }
/*      */         
/*      */ 
/* 1453 */         i++;
/*      */       }
/*      */       
/* 1456 */       if (alternativeIndex >= 0)
/*      */       {
/*      */ 
/* 1459 */         MatchObj opponentObj = (MatchObj)matchObjs.remove(alternativeIndex);
/*      */         
/*      */ 
/* 1462 */         xPointPVPInfo.getFights().add(Long.valueOf(obj.corpsid));
/* 1463 */         xPointPVPInfo.getFights().add(Long.valueOf(opponentObj.corpsid));
/*      */         
/*      */ 
/* 1466 */         PointRaceFightContext context = new PointRaceFightContext(worldid, obj.corpsid, opponentObj.corpsid);
/* 1467 */         FightInterface.startPVPFightWithTeamDisposition(obj.roleids, opponentObj.roleids, context, 20, FightReason.CROSS_BATTLE_POINT);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 1473 */         sendNextMatchCountDown(obj.roleids, countDown);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static void sendNextMatchCountDown(List<Long> roleids, int countDown)
/*      */   {
/* 1480 */     SyncNextMatchCountDown msg = new SyncNextMatchCountDown();
/* 1481 */     msg.countdown = countDown;
/* 1482 */     OnlineManager.getInstance().sendMulti(msg, roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillPointRaceChartObjs(List<PointRaceRankData> datas, int fromRank, List<PointRaceChartObj> chartObjs)
/*      */   {
/* 1488 */     String encode = "UTF-8";
/* 1489 */     int i = 0;
/* 1490 */     for (PointRaceChartObj chartObj : chartObjs)
/*      */     {
/* 1492 */       PointRaceRankData data = new PointRaceRankData();
/*      */       try
/*      */       {
/* 1495 */         data.corps_name.setString(chartObj.corpsName, "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/* 1500 */       data.zoneid = chartObj.zoneid;
/* 1501 */       data.icon = chartObj.icon;
/* 1502 */       data.point = chartObj.point;
/* 1503 */       data.rank = (fromRank + i++);
/* 1504 */       datas.add(data);
/*      */     }
/*      */   }
/*      */   
/*      */   static RolePointRaceMarkingInfo createRolePointRaceMarkingInfo(long roleid)
/*      */   {
/* 1510 */     return new RolePointRaceMarkingInfo(RoleInterface.getUserId(roleid), roleid);
/*      */   }
/*      */   
/*      */   static boolean returnOriginalServer(long worldid, long corpsid)
/*      */   {
/* 1515 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/* 1516 */     if (zoneManager == null)
/*      */     {
/* 1518 */       GameServer.logger().error("[crossbattlepoint]CrossBattlePointManager.returnOriginalServer@zone manager is null");
/* 1519 */       return false;
/*      */     }
/*      */     
/* 1522 */     int activityCfgid = zoneManager.activityCfgid;
/* 1523 */     int zone = zoneManager.zone;
/* 1524 */     int timePointCfgid = zoneManager.timePointCfgid;
/* 1525 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/* 1526 */     int delay = zoneManager.crossBattlePointCfg.endFightCountDown;
/*      */     
/* 1528 */     List<Long> roleids = corpsManager.getRoleids(corpsid);
/* 1529 */     if ((roleids == null) || (roleids.isEmpty()))
/*      */     {
/* 1531 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceEnd.processImp@roleids invalid|corpsid=%d", new Object[] { Long.valueOf(corpsid) }));
/*      */       
/* 1533 */       return false;
/*      */     }
/*      */     
/* 1536 */     PointRaceCorpsCurInfo curInfo = corpsManager.getCorpsCurInfo(corpsid);
/* 1537 */     if (curInfo == null)
/*      */     {
/* 1539 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceEnd.processImp@cur info is null|corpsid=%d", new Object[] { Long.valueOf(corpsid) }));
/*      */       
/* 1541 */       return false;
/*      */     }
/*      */     
/* 1544 */     PointRaceCorpsInfo corpsInfo = new PointRaceCorpsInfo();
/* 1545 */     corpsInfo.setCorpsid(corpsid);
/* 1546 */     corpsInfo.setLose(curInfo.lose);
/* 1547 */     corpsInfo.setWin(curInfo.win);
/* 1548 */     corpsInfo.setPoint(curInfo.point);
/* 1549 */     corpsInfo.setUpdateTime(curInfo.updateTime);
/*      */     
/* 1551 */     int pvps = corpsManager.getPvpFight(corpsid);
/*      */     
/*      */ 
/* 1554 */     corpsManager.remove(corpsid);
/*      */     
/*      */ 
/* 1557 */     syncPointRaceStage(roleids, zone, zoneManager.index, zoneManager.backup, 3, TimeUnit.SECONDS.toMillis(zoneManager.getReturnOriginalCountDown()));
/*      */     
/*      */ 
/* 1560 */     new PointRaceReturnOriginalObserver(delay, curInfo.zoneid, roleids, activityCfgid, timePointCfgid, corpsInfo, pvps);
/* 1561 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean doReturnOriginalServer(int zoneid, List<Long> roleids, int activityCfgid, int timePointCfgid, PointRaceCorpsInfo corpsInfo, int pvps)
/*      */   {
/* 1567 */     PointRaceDataBackReq pointRaceDataBackReq = new PointRaceDataBackReq();
/* 1568 */     pointRaceDataBackReq.activity_cfgid = activityCfgid;
/* 1569 */     pointRaceDataBackReq.time_point_cfgid = timePointCfgid;
/* 1570 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1572 */       String userid = RoleInterface.getUserId(roleid);
/* 1573 */       PointRaceUserDataBack userDataBack = new PointRaceUserDataBack();
/* 1574 */       userDataBack.roleid = roleid;
/*      */       try
/*      */       {
/* 1577 */         userDataBack.userid.setString(userid, "UTF-8");
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/* 1581 */         GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.returnOriginalServer@transfor data error", new Object[0]), e);
/*      */       }
/*      */       
/* 1584 */       Octets tokenOctets = mzm.gsp.online.main.LoginManager.getRoamToken(userid);
/* 1585 */       if (tokenOctets != null)
/*      */       {
/* 1587 */         userDataBack.user_token = tokenOctets;
/*      */       }
/*      */       
/* 1590 */       ExchangeDataHandlerInfo handlerInfo = new ExchangeDataHandlerInfo();
/* 1591 */       if (mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager.boxData(userid, roleid, handlerInfo))
/*      */       {
/* 1593 */         userDataBack.exchange_data_handler_info.add(handlerInfo);
/*      */       }
/*      */       
/* 1596 */       pointRaceDataBackReq.user_back_datas.add(userDataBack);
/*      */     }
/*      */     
/*      */ 
/* 1600 */     pointRaceDataBackReq.corps_info.corpsid = corpsInfo.getCorpsid();
/* 1601 */     pointRaceDataBackReq.corps_info.lose = corpsInfo.getLose();
/* 1602 */     pointRaceDataBackReq.corps_info.point = corpsInfo.getPoint();
/* 1603 */     pointRaceDataBackReq.corps_info.update_time = corpsInfo.getUpdateTime();
/* 1604 */     pointRaceDataBackReq.corps_info.win = corpsInfo.getWin();
/*      */     
/* 1606 */     pointRaceDataBackReq.pvp_fight = pvps;
/*      */     
/* 1608 */     DataTransferReq req = new DataTransferReq();
/* 1609 */     req.direction = 0;
/* 1610 */     req.data_type = 307;
/* 1611 */     req.src_id = GameServerInfoManager.getZoneId();
/* 1612 */     req.dst_id = zoneid;
/* 1613 */     OctetsStream os = new OctetsStream();
/* 1614 */     os.marshal(pointRaceDataBackReq);
/* 1615 */     req.data = os;
/*      */     
/* 1617 */     if (!GHubHelper.sendDataTransferReq(req, true, 5))
/*      */     {
/* 1619 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.returnOriginalServer@can not transfor data|des=%s", new Object[] { pointRaceDataBackReq.toString() }));
/*      */       
/*      */ 
/*      */ 
/* 1623 */       return false;
/*      */     }
/* 1625 */     GameServer.logger().info(String.format("[crossbattlepoint]CrossBattlePointManager.returnOriginalServer@send msg succeed|des=%s", new Object[] { pointRaceDataBackReq.toString() }));
/*      */     
/*      */ 
/* 1628 */     return true;
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
/*      */   static boolean reportCorpsPointRace(int activityCfgid, long corpsid, int timePointCfgid, CorpsPointRaceData data)
/*      */   {
/* 1642 */     ReportCorpsPointRaceReq req = new ReportCorpsPointRaceReq();
/* 1643 */     req.activity_cfgid = activityCfgid;
/* 1644 */     req.corpsid = corpsid;
/* 1645 */     req.time_point_cfgid = timePointCfgid;
/* 1646 */     req.data = data;
/*      */     
/* 1648 */     OctetsStream reqOs = new OctetsStream();
/* 1649 */     reqOs.marshal(req);
/*      */     
/*      */ 
/* 1652 */     return CrossServerInterface.asyncReportCorpsPointRace(reqOs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void reportPointRaceCorpsCVC(long worldid)
/*      */   {
/* 1663 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/* 1664 */     if (zoneManager == null)
/*      */     {
/* 1666 */       return;
/*      */     }
/*      */     
/* 1669 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1670 */     long lastTime = zoneManager.getAndSetCheckCVCTime(now);
/*      */     
/* 1672 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/* 1673 */     Map<Long, PointRaceCorpsFightInfo> corpsFightInfos = corpsManager.getCorpsFightInfos(lastTime, now);
/* 1674 */     if (corpsFightInfos.isEmpty())
/*      */     {
/* 1676 */       return;
/*      */     }
/*      */     
/* 1679 */     Map<Long, Map<Long, HubCorpsCVCInfo>> cvcData = new HashMap();
/* 1680 */     for (Map.Entry<Long, PointRaceCorpsFightInfo> entry : corpsFightInfos.entrySet())
/*      */     {
/* 1682 */       PointRaceCorpsFightInfo value = (PointRaceCorpsFightInfo)entry.getValue();
/* 1683 */       if (!value.corpsFights.isEmpty())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1688 */         Map<Long, HubCorpsCVCInfo> cvcs = new HashMap();
/* 1689 */         for (Map.Entry<Long, CorpsCVCInfo> corpsCvcEntry : value.corpsFights.entrySet())
/*      */         {
/* 1691 */           CorpsCVCInfo cvcInfo = (CorpsCVCInfo)corpsCvcEntry.getValue();
/* 1692 */           HubCorpsCVCInfo hubCorpsCVCInfo = new HubCorpsCVCInfo(cvcInfo.win, cvcInfo.lose);
/* 1693 */           cvcs.put(corpsCvcEntry.getKey(), hubCorpsCVCInfo);
/*      */         }
/* 1695 */         cvcData.put(entry.getKey(), cvcs);
/*      */       }
/*      */     }
/* 1698 */     if (cvcData.isEmpty())
/*      */     {
/* 1700 */       return;
/*      */     }
/*      */     
/* 1703 */     int activityCfgid = zoneManager.activityCfgid;
/* 1704 */     int timePointCfgid = zoneManager.timePointCfgid;
/* 1705 */     int zone = zoneManager.zone;
/* 1706 */     CrossServerInterface.reportPointRaceCorpsCVC(activityCfgid, zone, timePointCfgid, cvcData);
/*      */   }
/*      */   
/*      */   static boolean notifyPointRaceEnd(int activityCfgid, int zone, int timePointCfgid)
/*      */   {
/* 1711 */     return CrossServerInterface.notifyPointRaceEnd(activityCfgid, zone, timePointCfgid);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\CrossBattlePointManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */