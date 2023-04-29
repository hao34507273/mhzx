/*      */ package mzm.gsp.title.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.title.SChangeAppellationArgs;
/*      */ import mzm.gsp.title.SChangePropertyReq;
/*      */ import mzm.gsp.title.SGetNewTitleOrAppellation;
/*      */ import mzm.gsp.title.SInitTitleOrAppellation;
/*      */ import mzm.gsp.title.SRemoveTitleOrAppellation;
/*      */ import mzm.gsp.title.confbean.Property2value;
/*      */ import mzm.gsp.title.confbean.SAppellationCfg;
/*      */ import mzm.gsp.title.confbean.STitleCfg;
/*      */ import mzm.gsp.title.event.AppellationPropertyChange;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Pod;
/*      */ import xbean.TitleAppellation;
/*      */ import xbean.TitleSessionInfo;
/*      */ import xdb.Procedure;
/*      */ import xtable.Role2titleappellation;
/*      */ import xtable.Role2titlesession;
/*      */ 
/*      */ 
/*      */ public class TitleManager
/*      */ {
/*   40 */   static Logger logger = Logger.getLogger("TitleManager");
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
/*      */   static boolean onRoleLogin(long roleId)
/*      */   {
/*   53 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*   54 */     if (xTitleAppellation == null)
/*      */     {
/*   56 */       return false;
/*      */     }
/*   58 */     checkAppellation(roleId, xTitleAppellation);
/*      */     
/*   60 */     SInitTitleOrAppellation sInitTitleOrAppellation = new SInitTitleOrAppellation();
/*   61 */     if (xTitleAppellation.getAppellations().size() > 0)
/*      */     {
/*   63 */       for (xbean.AppellationInfo xAppellationInfo : xTitleAppellation.getAppellations().values())
/*      */       {
/*   65 */         pSingleAppLogin(roleId, sInitTitleOrAppellation, xAppellationInfo);
/*      */       }
/*      */     }
/*   68 */     if (xTitleAppellation.getOwntitle().size() > 0)
/*      */     {
/*   70 */       for (xbean.TitleInfo xTitleInfo : xTitleAppellation.getOwntitle())
/*      */       {
/*   72 */         mzm.gsp.title.TitleInfo titleInfo = new mzm.gsp.title.TitleInfo();
/*   73 */         titleInfo.titleid = xTitleInfo.getTitleid();
/*   74 */         titleInfo.timeout = xTitleInfo.getTimeout();
/*      */         
/*   76 */         sInitTitleOrAppellation.owntitle.add(titleInfo);
/*      */         
/*   78 */         if (titleInfo.timeout > 0L)
/*      */         {
/*   80 */           if (titleInfo.timeout <= DateTimeUtils.getCurrTimeInMillis())
/*      */           {
/*   82 */             NoneRealTimeTaskManager.getInstance().addTask(new PRemoveTitle(roleId, titleInfo.titleid));
/*      */           }
/*      */           else
/*      */           {
/*   86 */             long intervalSec = (titleInfo.timeout - DateTimeUtils.getCurrTimeInMillis()) / 1000L;
/*   87 */             TitleOwnSession.addTitleSession(intervalSec, roleId, titleInfo.titleid);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*   93 */     sInitTitleOrAppellation.activeappellation = xTitleAppellation.getActiveappellation();
/*   94 */     sInitTitleOrAppellation.activetitle = xTitleAppellation.getActivetitle();
/*   95 */     sInitTitleOrAppellation.pro2appellationid = xTitleAppellation.getPro2appellationid();
/*      */     
/*      */ 
/*   98 */     int nowOccupation = RoleInterface.getOccupationId(roleId);
/*      */     
/*  100 */     for (Iterator<mzm.gsp.title.AppellationInfo> iterator = sInitTitleOrAppellation.ownappellation.iterator(); iterator.hasNext();)
/*      */     {
/*  102 */       mzm.gsp.title.AppellationInfo appellationInfo = (mzm.gsp.title.AppellationInfo)iterator.next();
/*  103 */       int appellationCfgId = appellationInfo.appellationid;
/*  104 */       SAppellationCfg sAppellationCfg = SAppellationCfg.get(appellationCfgId);
/*  105 */       if (sAppellationCfg != null)
/*      */       {
/*      */ 
/*      */ 
/*  109 */         int appellationOccupation = sAppellationCfg.occupation;
/*  110 */         if ((appellationOccupation != 0) && (appellationOccupation != nowOccupation))
/*      */         {
/*  112 */           iterator.remove();
/*      */         }
/*      */       }
/*      */     }
/*  116 */     OnlineManager.getInstance().send(roleId, sInitTitleOrAppellation);
/*      */     
/*      */ 
/*  119 */     Procedure.execute(new PCheckFactionAppellationArgs(roleId));
/*  120 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkAppellation(long roleId, TitleAppellation xTitleAppellation)
/*      */   {
/*  131 */     int proAppId = xTitleAppellation.getPro2appellationid();
/*  132 */     if (proAppId == 0)
/*      */     {
/*  134 */       return;
/*      */     }
/*  136 */     if (xTitleAppellation.getAppellations().keySet().contains(Integer.valueOf(proAppId)))
/*      */     {
/*  138 */       return;
/*      */     }
/*  140 */     changeProAppId(roleId, 0, xTitleAppellation);
/*  141 */     GameServer.logger().info(String.format("[title]TitleManager.checkProAppellation@ reset pro appellation!|roleId=%d|errAppId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(proAppId) }));
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
/*      */   private static void pSingleAppLogin(long roleId, SInitTitleOrAppellation sInitTitleOrAppellation, xbean.AppellationInfo xAppellationInfo)
/*      */   {
/*  156 */     mzm.gsp.title.AppellationInfo appellationInfo = new mzm.gsp.title.AppellationInfo();
/*  157 */     fillAppellationInfoBean(roleId, xAppellationInfo, appellationInfo);
/*      */     
/*  159 */     sInitTitleOrAppellation.ownappellation.add(appellationInfo);
/*  160 */     if (appellationInfo.timeout > 0L)
/*      */     {
/*  162 */       if (appellationInfo.timeout <= DateTimeUtils.getCurrTimeInMillis())
/*      */       {
/*  164 */         NoneRealTimeTaskManager.getInstance().addTask(new PRemoveAppellation(roleId, appellationInfo.appellationid));
/*      */       }
/*      */       else
/*      */       {
/*  168 */         long intervalSec = (appellationInfo.timeout - DateTimeUtils.getCurrTimeInMillis()) / 1000L;
/*  169 */         AppellationOwnSession.addAppSession(intervalSec, roleId, appellationInfo.appellationid);
/*      */       }
/*      */     }
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
/*      */   static void fillAppellationInfoBeanImpl(long roleId, mzm.gsp.title.AppellationInfo appellationinfo)
/*      */   {
/*  184 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*  185 */     if (xTitleAppellation == null)
/*      */     {
/*  187 */       return;
/*      */     }
/*  189 */     int activeAppId = xTitleAppellation.getActiveappellation();
/*  190 */     if (activeAppId <= 0)
/*      */     {
/*  192 */       return;
/*      */     }
/*  194 */     fillAppellationInfoBeanById(roleId, xTitleAppellation, activeAppId, appellationinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillAppellationInfoBeanById(long roleId, TitleAppellation xTitleAppellation, int appId, mzm.gsp.title.AppellationInfo appellationinfo)
/*      */   {
/*  206 */     if (xTitleAppellation == null)
/*      */     {
/*  208 */       return;
/*      */     }
/*  210 */     xbean.AppellationInfo xAppInfo = getXAppellationInfoById(xTitleAppellation, appId);
/*  211 */     if (xAppInfo == null)
/*      */     {
/*  213 */       return;
/*      */     }
/*  215 */     fillAppellationInfoBean(roleId, xAppInfo, appellationinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static xbean.AppellationInfo getXAppellationInfoById(TitleAppellation xTitleAppellation, int appellationId)
/*      */   {
/*  227 */     if (xTitleAppellation == null)
/*      */     {
/*  229 */       return null;
/*      */     }
/*      */     
/*  232 */     return (xbean.AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(appellationId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean fillAppellationInfoBean(long roleId, xbean.AppellationInfo xAppellationInfo, mzm.gsp.title.AppellationInfo appellationInfo)
/*      */   {
/*  244 */     int appellationid = xAppellationInfo.getAppellationid();
/*  245 */     appellationInfo.appellationid = appellationid;
/*  246 */     appellationInfo.timeout = xAppellationInfo.getTimeout();
/*  247 */     if (xAppellationInfo.getAppargs().size() > 0)
/*      */     {
/*  249 */       appellationInfo.appargs.addAll(xAppellationInfo.getAppargs());
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  255 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getDiyAppType(long roleId, int appellationid)
/*      */   {
/*  267 */     SAppellationCfg appCfg = SAppellationCfg.get(appellationid);
/*  268 */     if (appCfg == null)
/*      */     {
/*  270 */       logger.error(String.format("TitleManager.fillAppellationInfoBean@玩家xdb中有此称谓id，但配置中没有!|roleId = %d|appellationId = %d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationid) }));
/*      */       
/*  272 */       return -1;
/*      */     }
/*  274 */     int type = appCfg.diyAppType;
/*  275 */     return type;
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
/*      */   static boolean fillGangArgs(long roleId, mzm.gsp.title.AppellationInfo appellationInfo, int appellationid)
/*      */   {
/*  288 */     String gangName = GangInterface.getGangName(roleId, false);
/*  289 */     if ((gangName == null) || (gangName.equals("")))
/*      */     {
/*  291 */       if (logger.isDebugEnabled())
/*      */       {
/*  293 */         logger.debug(String.format("TitleManager.fillAppellationInfoBean@玩家xdb中有帮派称谓id，但取不到帮派名字!|roleId = %d|appellationId = %d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationid) }));
/*      */       }
/*      */       
/*      */ 
/*  297 */       return false;
/*      */     }
/*  299 */     String rankName = GangInterface.getGangDutyName(roleId);
/*  300 */     if ((rankName == null) || (rankName.equals("")))
/*      */     {
/*  302 */       if (logger.isDebugEnabled())
/*      */       {
/*  304 */         logger.debug(String.format("TitleManager.fillAppellationInfoBean@玩家xdb中有帮派称谓id，但取不到帮派职位!|roleId = %d|appellationId = %d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationid) }));
/*      */       }
/*      */       
/*      */ 
/*  308 */       return false;
/*      */     }
/*  310 */     appellationInfo.appargs.add(gangName);
/*  311 */     appellationInfo.appargs.add(rankName);
/*  312 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onRoleLogoff(long roleId)
/*      */   {
/*  323 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*  324 */     if (xTitleAppellation == null)
/*      */     {
/*  326 */       return false;
/*      */     }
/*  328 */     rmRoleAllSession(roleId);
/*  329 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addNewAppellation(long roleId, int appellationId, List<String> args, boolean needWear)
/*      */   {
/*  341 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*  342 */     if (xTitleAppellation == null)
/*      */     {
/*  344 */       xTitleAppellation = Pod.newTitleAppellation();
/*  345 */       Role2titleappellation.add(Long.valueOf(roleId), xTitleAppellation);
/*      */     }
/*      */     
/*  348 */     int activeAppellationId = xTitleAppellation.getActiveappellation();
/*      */     
/*  350 */     boolean findAppellation = isHaveAppellationId(appellationId, xTitleAppellation);
/*  351 */     if (findAppellation)
/*      */     {
/*  353 */       xTitleAppellation.getAppellations().remove(Integer.valueOf(appellationId));
/*  354 */       rmAppellationNotice(roleId, appellationId);
/*      */     }
/*      */     
/*      */ 
/*  358 */     long outDate = checkAndAddAppellationSession(roleId, appellationId);
/*  359 */     if (outDate < 0L)
/*      */     {
/*  361 */       GameServer.logger().info(String.format("[title]TitleManager.addNewAppellation@ appellationId time out!|roleId=%d|id=%d|needWear=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId), String.valueOf(needWear) }));
/*      */       
/*      */ 
/*  364 */       return false;
/*      */     }
/*  366 */     xbean.AppellationInfo xAppellationInfo = Pod.newAppellationInfo();
/*  367 */     xAppellationInfo.setTimeout(outDate);
/*  368 */     xAppellationInfo.setAppellationid(appellationId);
/*  369 */     fillXArgs(args, xAppellationInfo);
/*      */     
/*  371 */     xTitleAppellation.getAppellations().put(Integer.valueOf(appellationId), xAppellationInfo);
/*      */     
/*  373 */     synClientNewApp(roleId, appellationId, outDate, xAppellationInfo);
/*      */     
/*  375 */     if (((findAppellation) && (appellationId == activeAppellationId)) || (activeAppellationId == 0) || (needWear))
/*      */     {
/*  377 */       NoneRealTimeTaskManager.getInstance().addTask(new PChangeTitleOrAppellationReq(roleId, appellationId, 0));
/*      */     }
/*      */     
/*  380 */     GameServer.logger().info(String.format("[title]TitleManager.addNewAppellation@add new app!|roleId=%d|appId=%d|needWear=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId), String.valueOf(needWear) }));
/*      */     
/*      */ 
/*  383 */     return true;
/*      */   }
/*      */   
/*      */   private static void fillXArgs(List<String> args, xbean.AppellationInfo xAppellationInfo)
/*      */   {
/*  388 */     if ((args != null) && (args.size() > 0))
/*      */     {
/*  390 */       for (String arg : args)
/*      */       {
/*  392 */         if (arg == "")
/*      */         {
/*  394 */           arg = " ";
/*      */         }
/*  396 */         xAppellationInfo.getAppargs().add(arg);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static void synClientNewApp(long roleId, int appellationId, long outDate, xbean.AppellationInfo xAppellationInfo)
/*      */   {
/*  403 */     SGetNewTitleOrAppellation sGetNewTitleOrAppellation = new SGetNewTitleOrAppellation();
/*  404 */     sGetNewTitleOrAppellation.changetype = 0;
/*  405 */     sGetNewTitleOrAppellation.changeid = appellationId;
/*  406 */     sGetNewTitleOrAppellation.timeout = outDate;
/*  407 */     sGetNewTitleOrAppellation.appargs.addAll(xAppellationInfo.getAppargs());
/*      */     
/*  409 */     OnlineManager.getInstance().send(roleId, sGetNewTitleOrAppellation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getXDiyType(int type)
/*      */   {
/*  418 */     switch (type)
/*      */     {
/*      */ 
/*      */     case 0: 
/*  422 */       return 0;
/*      */     
/*      */     case 2: 
/*  425 */       return 2;
/*      */     
/*      */     case 1: 
/*  428 */       return 1;
/*      */     
/*      */     case 3: 
/*  431 */       return 3;
/*      */     
/*      */     case 4: 
/*  434 */       return 4;
/*      */     }
/*      */     
/*      */     
/*      */ 
/*  439 */     return -1;
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
/*      */   static boolean isRoleHaveAppellationId(long roleId, int appId)
/*      */   {
/*  454 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*  455 */     if (xTitleAppellation == null)
/*      */     {
/*  457 */       return false;
/*      */     }
/*      */     
/*  460 */     return isHaveAppellationId(appId, xTitleAppellation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isHaveAppellationId(int appellationId, TitleAppellation xTitleAppellation)
/*      */   {
/*  470 */     return xTitleAppellation.getAppellations().get(Integer.valueOf(appellationId)) != null;
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
/*      */   static List<Integer> getNotOwnAppIds(long roleId, List<Integer> appIds)
/*      */   {
/*  484 */     List<Integer> notOwnAppIds = new ArrayList();
/*  485 */     if ((appIds == null) || (appIds.size() == 0))
/*      */     {
/*  487 */       return notOwnAppIds;
/*      */     }
/*  489 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*  490 */     if (xTitleAppellation == null)
/*      */     {
/*  492 */       return appIds;
/*      */     }
/*  494 */     Set<Integer> ownAppIds = xTitleAppellation.getAppellations().keySet();
/*  495 */     for (Iterator i$ = appIds.iterator(); i$.hasNext();) { int appid = ((Integer)i$.next()).intValue();
/*      */       
/*  497 */       if (!ownAppIds.contains(Integer.valueOf(appid)))
/*      */       {
/*      */ 
/*      */ 
/*  501 */         notOwnAppIds.add(Integer.valueOf(appid)); }
/*      */     }
/*  503 */     return notOwnAppIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Integer> getPropertyMap(int appellationId)
/*      */   {
/*  514 */     if (appellationId <= 0)
/*      */     {
/*  516 */       return new HashMap();
/*      */     }
/*  518 */     SAppellationCfg sAppellationCfg = SAppellationCfg.get(appellationId);
/*  519 */     Map<Integer, Integer> propertyMap = new HashMap();
/*  520 */     for (Property2value property2value : sAppellationCfg.property2valueList)
/*      */     {
/*  522 */       if (property2value.property != 0)
/*      */       {
/*  524 */         propertyMap.put(Integer.valueOf(property2value.property), Integer.valueOf(property2value.value));
/*      */       }
/*      */     }
/*  527 */     return propertyMap;
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
/*      */   private static long checkAndAddAppellationSession(long roleId, int appellationId)
/*      */   {
/*  540 */     long interval = 0L;
/*  541 */     long outDate = 0L;
/*  542 */     if (SAppellationCfg.get(appellationId) == null)
/*      */     {
/*  544 */       return -1L;
/*      */     }
/*  546 */     if (SAppellationCfg.get(appellationId).appellationLimit > 0)
/*      */     {
/*  548 */       interval = TimeUnit.HOURS.toSeconds(SAppellationCfg.get(appellationId).appellationLimit);
/*  549 */       outDate = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.HOURS.toMillis(SAppellationCfg.get(appellationId).appellationLimit);
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*  554 */     else if (SAppellationCfg.get(appellationId).appellationOutTime > 0)
/*      */     {
/*  556 */       outDate = TimeCommonUtil.getLimitTimeEnd(SAppellationCfg.get(appellationId).appellationOutTime);
/*  557 */       interval = (outDate - DateTimeUtils.getCurrTimeInMillis()) / 1000L;
/*      */     }
/*      */     
/*  560 */     if (interval > 0L)
/*      */     {
/*  562 */       AppellationOwnSession.addAppSession(interval, roleId, appellationId);
/*      */     }
/*  564 */     return outDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addNewTitle(long roleId, int titleId)
/*      */   {
/*  576 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*  577 */     if (xTitleAppellation == null)
/*      */     {
/*  579 */       xTitleAppellation = Pod.newTitleAppellation();
/*  580 */       Role2titleappellation.add(Long.valueOf(roleId), xTitleAppellation);
/*      */     }
/*  582 */     boolean findTitle = false;
/*  583 */     for (xbean.TitleInfo xTitleInfo : xTitleAppellation.getOwntitle())
/*      */     {
/*  585 */       if (xTitleInfo.getTitleid() == titleId)
/*      */       {
/*  587 */         findTitle = true;
/*  588 */         break;
/*      */       }
/*      */     }
/*  591 */     if (findTitle)
/*      */     {
/*  593 */       rmTitleFromDB(xTitleAppellation, titleId);
/*  594 */       rmTitleNotice(roleId, titleId);
/*      */     }
/*  596 */     long outDate = checkAndAddTitleSession(roleId, titleId);
/*  597 */     if (outDate < 0L)
/*      */     {
/*  599 */       GameServer.logger().error(String.format("[title]TitleManager.addNewTitle@ get outData err!|roleId=%d|titleId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(titleId) }));
/*      */       
/*  601 */       return false;
/*      */     }
/*  603 */     xbean.TitleInfo xTitleInfo = Pod.newTitleInfo();
/*  604 */     xTitleInfo.setTimeout(outDate);
/*  605 */     xTitleInfo.setTitleid(titleId);
/*  606 */     xTitleAppellation.getOwntitle().add(xTitleInfo);
/*      */     
/*  608 */     addNewTitleNotice(roleId, titleId, outDate);
/*      */     
/*  610 */     if ((xTitleAppellation.getActivetitle() == 0) || (xTitleAppellation.getActivetitle() == titleId))
/*      */     {
/*  612 */       NoneRealTimeTaskManager.getInstance().addTask(new PChangeTitleOrAppellationReq(roleId, titleId, 1));
/*      */     }
/*      */     
/*  615 */     GameServer.logger().info(String.format("[title]TitleManager.addNewTitle@ role add new title!|roleId=%d|titleId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(titleId) }));
/*      */     
/*  617 */     return true;
/*      */   }
/*      */   
/*      */   private static void addNewTitleNotice(long roleId, int titleId, long outDate)
/*      */   {
/*  622 */     SGetNewTitleOrAppellation sGetNewTitleOrAppellation = new SGetNewTitleOrAppellation();
/*  623 */     sGetNewTitleOrAppellation.changetype = 1;
/*  624 */     sGetNewTitleOrAppellation.changeid = titleId;
/*  625 */     sGetNewTitleOrAppellation.timeout = outDate;
/*      */     
/*  627 */     OnlineManager.getInstance().send(roleId, sGetNewTitleOrAppellation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean rmTitleFromDB(TitleAppellation xTitleAppellation, int titleId)
/*      */   {
/*  639 */     boolean findTitle = false;
/*  640 */     Iterator<xbean.TitleInfo> it = xTitleAppellation.getOwntitle().iterator();
/*  641 */     while (it.hasNext())
/*      */     {
/*  643 */       xbean.TitleInfo xTitleInfo = (xbean.TitleInfo)it.next();
/*  644 */       if (xTitleInfo.getTitleid() == titleId)
/*      */       {
/*  646 */         findTitle = true;
/*  647 */         it.remove();
/*  648 */         break;
/*      */       }
/*      */     }
/*  651 */     return findTitle;
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
/*      */   private static long checkAndAddTitleSession(long roleId, int titleId)
/*      */   {
/*  664 */     long interval = 0L;
/*  665 */     long outDate = 0L;
/*  666 */     if (STitleCfg.get(titleId) == null)
/*      */     {
/*  668 */       GameServer.logger().error(String.format("[title]TitleManager.checkAndAddTitleSession@ STitleCfg is null!|roleId=%d|titleId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(titleId) }));
/*      */       
/*      */ 
/*  671 */       return -1L;
/*      */     }
/*  673 */     if (STitleCfg.get(titleId).titleLimit > 0)
/*      */     {
/*  675 */       interval = TimeUnit.HOURS.toSeconds(STitleCfg.get(titleId).titleLimit);
/*  676 */       outDate = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.HOURS.toMillis(STitleCfg.get(titleId).titleLimit);
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*  681 */     else if (STitleCfg.get(titleId).titleOutTime > 0)
/*      */     {
/*  683 */       outDate = TimeCommonUtil.getLimitTimeEnd(STitleCfg.get(titleId).titleOutTime);
/*  684 */       interval = (outDate - DateTimeUtils.getCurrTimeInMillis()) / 1000L;
/*      */     }
/*      */     
/*  687 */     if (interval > 0L)
/*      */     {
/*  689 */       TitleOwnSession.addTitleSession(interval, roleId, titleId);
/*      */     }
/*  691 */     return outDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ActiveInfo getActiveTitilIdImpl(long roleId)
/*      */   {
/*  700 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*  701 */     ActiveInfo activeInfo = new ActiveInfo();
/*  702 */     if (xTitleAppellation == null)
/*      */     {
/*  704 */       return activeInfo;
/*      */     }
/*  706 */     activeInfo.setActiveId(xTitleAppellation.getActivetitle());
/*  707 */     return activeInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ActiveInfo getActiveAppellationInfoImpl(long roleId)
/*      */   {
/*  716 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*  717 */     ActiveInfo activeInfo = new ActiveInfo();
/*  718 */     if (xTitleAppellation == null)
/*      */     {
/*  720 */       return activeInfo;
/*      */     }
/*  722 */     int appId = xTitleAppellation.getActiveappellation();
/*  723 */     if (appId <= 0)
/*      */     {
/*  725 */       return activeInfo;
/*      */     }
/*  727 */     String name = getAppString(appId, xTitleAppellation);
/*  728 */     if ((name == null) || (name.equals("")))
/*      */     {
/*  730 */       GameServer.logger().error(String.format("[title]TitleManager.getActiveAppellationInfoImpl@ exist active app, but not have it' data!|roleId=%d|activeAppId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appId) }));
/*      */       
/*      */ 
/*      */ 
/*  734 */       return activeInfo;
/*      */     }
/*  736 */     activeInfo.setActiveId(appId);
/*  737 */     activeInfo.setName(name);
/*  738 */     return activeInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static String getAppString(long roleId, int appellationId)
/*      */   {
/*  750 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*  751 */     if (xTitleAppellation == null)
/*      */     {
/*  753 */       return "";
/*      */     }
/*      */     
/*  756 */     return getAppString(appellationId, xTitleAppellation);
/*      */   }
/*      */   
/*      */   static String getAppString(int appellationId, TitleAppellation xTitleAppellation)
/*      */   {
/*  761 */     xbean.AppellationInfo xApp = (xbean.AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(appellationId));
/*      */     
/*  763 */     if (xApp == null)
/*      */     {
/*  765 */       return "";
/*      */     }
/*      */     
/*  768 */     SAppellationCfg sAppellationCfg = SAppellationCfg.get(appellationId);
/*  769 */     if (sAppellationCfg == null)
/*      */     {
/*  771 */       return "";
/*      */     }
/*  773 */     String tempString = sAppellationCfg.appellationName;
/*      */     
/*  775 */     List<String> argStrings = xApp.getAppargs();
/*  776 */     if ((argStrings == null) || (argStrings.size() == 0))
/*      */     {
/*  778 */       return tempString;
/*      */     }
/*      */     
/*  781 */     Object[] args = argStrings.toArray();
/*  782 */     return String.format(tempString, args);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static List<String> getAppArgs(long roleId, int appellationId, boolean remainLock)
/*      */   {
/*      */     TitleAppellation xTitleAppellation;
/*      */     
/*      */ 
/*      */     TitleAppellation xTitleAppellation;
/*      */     
/*      */ 
/*  795 */     if (remainLock)
/*      */     {
/*  797 */       xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  801 */       xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  804 */     if (xTitleAppellation == null)
/*      */     {
/*  806 */       return new ArrayList();
/*      */     }
/*      */     
/*  809 */     return getAppArgs(appellationId, xTitleAppellation);
/*      */   }
/*      */   
/*      */   static List<String> getAppArgs(int appellationId, TitleAppellation xTitleAppellation)
/*      */   {
/*  814 */     xbean.AppellationInfo xApp = (xbean.AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(appellationId));
/*      */     
/*  816 */     if (xApp == null)
/*      */     {
/*  818 */       return new ArrayList();
/*      */     }
/*      */     
/*  821 */     SAppellationCfg sAppellationCfg = SAppellationCfg.get(appellationId);
/*  822 */     if (sAppellationCfg == null)
/*      */     {
/*  824 */       return new ArrayList();
/*      */     }
/*      */     
/*  827 */     List<String> argStrings = xApp.getAppargs();
/*  828 */     if ((argStrings == null) || (argStrings.size() == 0))
/*      */     {
/*  830 */       return new ArrayList();
/*      */     }
/*  832 */     return new ArrayList(argStrings);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean pRmAppellantionImpl(long roleId, int appellationId)
/*      */   {
/*  844 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*  845 */     return pRmAppellantionImpl(roleId, appellationId, xTitleAppellation);
/*      */   }
/*      */   
/*      */   static boolean pRmAppellantionImpl(long roleId, int appellationId, TitleAppellation xTitleAppellation)
/*      */   {
/*  850 */     return rmAppellantionImpl(roleId, appellationId, xTitleAppellation) == TitleOptionResult.SUCCESS;
/*      */   }
/*      */   
/*      */   static TitleOptionResult rmAppellantion(long roleId, int appellationId)
/*      */   {
/*  855 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*  856 */     return rmAppellantionImpl(roleId, appellationId, xTitleAppellation);
/*      */   }
/*      */   
/*      */   static TitleOptionResult rmAppellantionImpl(long roleId, int appellationId, TitleAppellation xTitleAppellation)
/*      */   {
/*  861 */     if (xTitleAppellation == null)
/*      */     {
/*  863 */       return TitleOptionResult.NOT_OWN_ERROR;
/*      */     }
/*      */     
/*  866 */     if (xTitleAppellation.getAppellations().remove(Integer.valueOf(appellationId)) == null)
/*      */     {
/*  868 */       GameServer.logger().error(String.format("[title]TitleManager.pRmAppellantionImpl@ not own this id!|roleId=%d|appId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId) }));
/*      */       
/*      */ 
/*  871 */       return TitleOptionResult.NOT_OWN_ERROR;
/*      */     }
/*      */     
/*  874 */     if (xTitleAppellation.getActiveappellation() == appellationId)
/*      */     {
/*  876 */       new PChangeTitleOrAppellationReq(roleId, 0, 0).call();
/*      */     }
/*      */     
/*  879 */     if (xTitleAppellation.getPro2appellationid() == appellationId)
/*      */     {
/*  881 */       changeProAppId(roleId, 0, xTitleAppellation);
/*      */     }
/*      */     
/*  884 */     TitleSessionInfo xInfo = Role2titlesession.get(Long.valueOf(roleId));
/*  885 */     if (xInfo != null)
/*      */     {
/*  887 */       rmAppSession(appellationId, xInfo);
/*      */     }
/*  889 */     rmAppellationNotice(roleId, appellationId);
/*  890 */     GameServer.logger().info(String.format("[title]TitleManager.pRmAppellantionImpl@rm appellationId!|roleId=%d|appellationId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId) }));
/*      */     
/*      */ 
/*      */ 
/*  894 */     return TitleOptionResult.SUCCESS;
/*      */   }
/*      */   
/*      */   static void rmAppellationNotice(long roleId, int appellationId)
/*      */   {
/*  899 */     SRemoveTitleOrAppellation sRemoveTitleOrAppellation = new SRemoveTitleOrAppellation();
/*  900 */     sRemoveTitleOrAppellation.changetype = 0;
/*  901 */     sRemoveTitleOrAppellation.changeid = appellationId;
/*      */     
/*  903 */     OnlineManager.getInstance().send(roleId, sRemoveTitleOrAppellation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmTitleNotice(long roleId, int titleId)
/*      */   {
/*  914 */     SRemoveTitleOrAppellation sRemoveTitleOrAppellation = new SRemoveTitleOrAppellation();
/*  915 */     sRemoveTitleOrAppellation.changetype = 1;
/*  916 */     sRemoveTitleOrAppellation.changeid = titleId;
/*      */     
/*  918 */     OnlineManager.getInstance().send(roleId, sRemoveTitleOrAppellation);
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
/*      */   static boolean rpAppArgs(long roleId, int appellationId, List<String> args)
/*      */   {
/*  931 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(roleId));
/*  932 */     if (xTitleAppellation == null)
/*      */     {
/*  934 */       return false;
/*      */     }
/*  936 */     xbean.AppellationInfo xAppInfo = (xbean.AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(appellationId));
/*      */     
/*  938 */     if (xAppInfo == null)
/*      */     {
/*  940 */       logger.error(String.format("TitleManager.rpAppArgs@not own appId!|roleId=%d|appellation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId) }));
/*  941 */       return false;
/*      */     }
/*  943 */     if (!changeAppArgs(roleId, appellationId, args, xAppInfo))
/*      */     {
/*  945 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  949 */     if (xTitleAppellation.getActiveappellation() == appellationId)
/*      */     {
/*  951 */       NoneRealTimeTaskManager.getInstance().addTask(new PChangeTitleOrAppellationReq(roleId, appellationId, 0));
/*      */     }
/*      */     
/*  954 */     GameServer.logger().info(String.format("[title]TitleManager.rpAppArgs@ replace appellation args|roleId=%d|appellationId=%d|args=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId), args == null ? "" : args.toString() }));
/*      */     
/*      */ 
/*  957 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean changeAppArgs(long roleId, int appellationId, List<String> args, xbean.AppellationInfo xAppInfo)
/*      */   {
/*  962 */     boolean isNeedChange = needChangeArgs(args, xAppInfo);
/*  963 */     if (!isNeedChange)
/*      */     {
/*  965 */       GameServer.logger().info(String.format("[title]TitleManager.changeAppArgs@ no need change args!|roleId=%d|appellationId=%d|args=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(appellationId), args == null ? "" : args.toString() }));
/*      */       
/*      */ 
/*  968 */       return false;
/*      */     }
/*  970 */     xAppInfo.getAppargs().clear();
/*  971 */     xAppInfo.getAppargs().addAll(args);
/*      */     
/*  973 */     SChangeAppellationArgs sChangeAppellationArgs = new SChangeAppellationArgs();
/*  974 */     sChangeAppellationArgs.appargs.addAll(args);
/*  975 */     sChangeAppellationArgs.changeid = appellationId;
/*      */     
/*  977 */     OnlineManager.getInstance().send(roleId, sChangeAppellationArgs);
/*  978 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean needChangeArgs(List<String> args, xbean.AppellationInfo xAppInfo)
/*      */   {
/*  990 */     List<String> oldArgs = xAppInfo.getAppargs();
/*  991 */     for (int i = 0; i < oldArgs.size(); i++)
/*      */     {
/*  993 */       String oldArg = (String)oldArgs.get(i);
/*  994 */       String newArg = (String)args.get(i);
/*  995 */       if (!oldArg.equals(newArg))
/*      */       {
/*  997 */         return true;
/*      */       }
/*      */     }
/* 1000 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getGangAppId()
/*      */   {
/* 1010 */     return GangInterface.getGangChengWeiId();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void changeProAppId(long roleId, int appellationid, TitleAppellation xTitleAppellation)
/*      */   {
/* 1022 */     xTitleAppellation.setPro2appellationid(appellationid);
/*      */     
/* 1024 */     afterChangeProApp(roleId, xTitleAppellation.getPro2appellationid());
/*      */   }
/*      */   
/*      */ 
/*      */   private static void afterChangeProApp(long roleId, int proAppId)
/*      */   {
/* 1030 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new AppellationPropertyChange(), new AppellationPropertyChangeArg(roleId));
/*      */     
/*      */ 
/* 1033 */     SChangePropertyReq sChangePropertyReq = new SChangePropertyReq();
/* 1034 */     sChangePropertyReq.appellationid = proAppId;
/*      */     
/* 1036 */     OnlineManager.getInstance().send(roleId, sChangePropertyReq);
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
/*      */   static TitleSessionInfo getTitleSessionXInfoIfAbsence(long roleId)
/*      */   {
/* 1050 */     TitleSessionInfo xInfo = Role2titlesession.get(Long.valueOf(roleId));
/* 1051 */     if (xInfo == null)
/*      */     {
/* 1053 */       xInfo = Pod.newTitleSessionInfo();
/* 1054 */       Role2titlesession.insert(Long.valueOf(roleId), xInfo);
/*      */     }
/* 1056 */     return xInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmAppSession(int appellationId, TitleSessionInfo xInfo)
/*      */   {
/* 1067 */     Long sessionId = (Long)xInfo.getAppsession().get(Integer.valueOf(appellationId));
/* 1068 */     if (sessionId == null)
/*      */     {
/* 1070 */       return;
/*      */     }
/* 1072 */     Session session = Session.getSession(sessionId.longValue());
/* 1073 */     if ((session != null) && ((session instanceof AppellationOwnSession)))
/*      */     {
/* 1075 */       Session.removeSession(sessionId.longValue());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmTitleSession(int titleId, TitleSessionInfo xInfo)
/*      */   {
/* 1087 */     Long sessionId = (Long)xInfo.getTitlesession().get(Integer.valueOf(titleId));
/* 1088 */     if (sessionId == null)
/*      */     {
/* 1090 */       return;
/*      */     }
/* 1092 */     Session session = Session.getSession(sessionId.longValue());
/* 1093 */     if ((session != null) && ((session instanceof TitleOwnSession)))
/*      */     {
/* 1095 */       Session.removeSession(sessionId.longValue());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmRoleAllSession(long roleId)
/*      */   {
/* 1108 */     TitleSessionInfo xInfo = Role2titlesession.get(Long.valueOf(roleId));
/* 1109 */     if (xInfo == null)
/*      */     {
/* 1111 */       return;
/*      */     }
/* 1113 */     for (Iterator i$ = xInfo.getAppsession().values().iterator(); i$.hasNext();) { long sessionId = ((Long)i$.next()).longValue();
/*      */       
/* 1115 */       Session session = Session.getSession(sessionId);
/* 1116 */       if ((session != null) && ((session instanceof AppellationOwnSession)))
/*      */       {
/* 1118 */         Session.removeSession(sessionId);
/*      */       }
/*      */     }
/* 1121 */     for (Iterator i$ = xInfo.getTitlesession().values().iterator(); i$.hasNext();) { long sessionId = ((Long)i$.next()).longValue();
/*      */       
/* 1123 */       Session session = Session.getSession(sessionId);
/* 1124 */       if ((session != null) && ((session instanceof TitleOwnSession)))
/*      */       {
/* 1126 */         Session.removeSession(sessionId);
/*      */       }
/*      */     }
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
/*      */   static boolean checkAppellationOccupation(String logStr, long roleId, int appellationCfgId)
/*      */   {
/* 1145 */     int nowOccupation = RoleInterface.getOccupationId(roleId);
/*      */     
/* 1147 */     SAppellationCfg sAppellationCfg = SAppellationCfg.get(appellationCfgId);
/* 1148 */     if (sAppellationCfg == null)
/*      */     {
/* 1150 */       logger.error(String.format("[title]%s@appellation cfg not found!|role_id=%d|appellation_cfg_id=%d", new Object[] { logStr, Long.valueOf(roleId), Integer.valueOf(appellationCfgId) }));
/*      */       
/* 1152 */       return false;
/*      */     }
/*      */     
/* 1155 */     int appellationOccupation = sAppellationCfg.occupation;
/* 1156 */     if ((appellationOccupation != 0) && (nowOccupation != appellationOccupation))
/*      */     {
/* 1158 */       logger.error(String.format("[title]%s@appellation occupation not match!|role_id=%d|appellation_cfg_id=%d|appellation_cfg_occupation=%d|role_occupation=%d", new Object[] { logStr, Long.valueOf(roleId), Integer.valueOf(appellationCfgId), Integer.valueOf(appellationOccupation), Integer.valueOf(nowOccupation) }));
/*      */       
/*      */ 
/* 1161 */       return false;
/*      */     }
/*      */     
/* 1164 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\TitleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */