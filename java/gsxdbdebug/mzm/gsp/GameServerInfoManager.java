/*     */ package mzm.gsp;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GameServerInfo;
/*     */ import xdb.TTable;
/*     */ import xdb.util.UniqNameConf;
/*     */ import xtable.Gamesrv;
/*     */ 
/*     */ public class GameServerInfoManager
/*     */ {
/*  17 */   public static int LOCAL_ID_BITS = 12;
/*  18 */   public static int ZONEID_MASK = 4095;
/*     */   
/*  20 */   private static boolean roamServer = false;
/*     */   
/*  22 */   private static String hostname = "localhost";
/*  23 */   private static String hostIp = "127.0.0.1";
/*  24 */   private static Integer guestServerid = Integer.valueOf(4001);
/*  25 */   private static int gameid = 0;
/*     */   
/*  27 */   private static List<Long> localids = null;
/*  28 */   private static long localID = 0L;
/*     */   
/*  30 */   private static List<Integer> zoneids = null;
/*  31 */   private static volatile int zoneId = 0;
/*  32 */   private static volatile int dbVersion = 0;
/*     */   
/*  34 */   private static final DisableProtocolInfo disableProtocolInfo = new DisableProtocolInfo();
/*  35 */   private static final OpenServerTimestampInfo openServerTimestampInfo = new OpenServerTimestampInfo();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getHostname()
/*     */   {
/*  44 */     return hostname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getHostIP()
/*     */   {
/*  54 */     return hostIp;
/*     */   }
/*     */   
/*     */   public static Integer getGuestServerid()
/*     */   {
/*  59 */     return guestServerid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isRoamServer()
/*     */   {
/*  69 */     return roamServer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getZoneIds()
/*     */   {
/*  79 */     if ((zoneids == null) || (zoneids.isEmpty()))
/*     */     {
/*  81 */       throw new RuntimeException("zoneids not loaded");
/*     */     }
/*     */     
/*  84 */     return zoneids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isValidZone(int zoneid)
/*     */   {
/*  95 */     if ((zoneids == null) || (zoneids.isEmpty()))
/*     */     {
/*  97 */       throw new RuntimeException("zoneids not loaded");
/*     */     }
/*     */     
/* 100 */     return zoneids.indexOf(Integer.valueOf(zoneid)) != -1;
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
/*     */   public static int getZoneidFromRoleid(long roleid)
/*     */   {
/* 113 */     return (int)(roleid & ZONEID_MASK);
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
/*     */   public static int getZoneidFromGangid(long gangid)
/*     */   {
/* 126 */     return (int)(gangid & ZONEID_MASK);
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
/*     */   public static boolean isRoleInOwnServer(long roleid)
/*     */   {
/* 139 */     return isValidZone(getZoneidFromRoleid(roleid));
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
/*     */   public static int getZoneidFromUserid(String userid)
/*     */   {
/* 152 */     return CommonUtils.getZoneId(userid);
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
/*     */   public static boolean isUserInOwnServer(String userid)
/*     */   {
/* 165 */     int zoneid = getZoneidFromUserid(userid);
/* 166 */     return isValidZone(zoneid);
/*     */   }
/*     */   
/*     */   public static boolean canLoginSourceServer(String userid)
/*     */   {
/* 171 */     if ((!isRoamServer()) && (!isUserInOwnServer(userid)))
/*     */     {
/* 173 */       GameServer.logger().error(String.format("[gamesrv]GameServerInfoManager.canLoginSourceServer@userid cannot login this server!|useid=%s|zoneids=%s", new Object[] { userid, getZoneIds() }));
/*     */       
/*     */ 
/*     */ 
/* 177 */       return false;
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getGameid()
/*     */   {
/* 189 */     if (gameid == 0)
/*     */     {
/* 191 */       throw new RuntimeException("gameid not loaded");
/*     */     }
/*     */     
/* 194 */     return gameid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZoneId()
/*     */   {
/* 204 */     if (zoneId == 0)
/*     */     {
/* 206 */       throw new RuntimeException("zoneid not loaded");
/*     */     }
/*     */     
/* 209 */     return zoneId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLocalId()
/*     */   {
/* 219 */     if (localID == 0L)
/*     */     {
/* 221 */       throw new RuntimeException("local id not loaded");
/*     */     }
/*     */     
/* 224 */     return localID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long toGlobalId(long id)
/*     */   {
/* 236 */     if (localID == 0L)
/*     */     {
/* 238 */       throw new RuntimeException("local id not loaded");
/*     */     }
/*     */     
/* 241 */     return (id << LOCAL_ID_BITS) + localID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long toLocalId(long globalId)
/*     */   {
/* 252 */     return globalId >> LOCAL_ID_BITS;
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
/*     */   public static long toGlobalId(long id, long zoneid)
/*     */   {
/* 266 */     return (id << LOCAL_ID_BITS) + zoneid;
/*     */   }
/*     */   
/*     */   public static int getDbVersion()
/*     */   {
/* 271 */     if (dbVersion == 0)
/*     */     {
/* 273 */       throw new RuntimeException("db version not loaded");
/*     */     }
/*     */     
/* 276 */     return dbVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getOpenServerTimestamp()
/*     */   {
/* 286 */     return openServerTimestampInfo.getOpenServerTimestamp();
/*     */   }
/*     */   
/*     */   public static void onRoleCreate()
/*     */   {
/* 291 */     openServerTimestampInfo.onRoleCreate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addDisableProtocol(int protid)
/*     */   {
/* 303 */     return disableProtocolInfo.addDisableProtocol(protid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean removeDisableProtocol(int protid)
/*     */   {
/* 315 */     return disableProtocolInfo.removeDisableProtocol(protid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean containsDisableProtocol(int protid)
/*     */   {
/* 327 */     return disableProtocolInfo.containsDisableProtocol(protid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setTimeOffset(long timeOffset)
/*     */   {
/* 339 */     GameServerInfo xGameServerInfo = Gamesrv.get(Long.valueOf(localID));
/* 340 */     if (xGameServerInfo == null)
/*     */     {
/* 342 */       return false;
/*     */     }
/*     */     
/* 345 */     if (xGameServerInfo.getTime_offset() > timeOffset)
/*     */     {
/* 347 */       return false;
/*     */     }
/*     */     
/* 350 */     xGameServerInfo.setTime_offset(timeOffset);
/*     */     
/* 352 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean setDateForGM(String dateValue, long gmRoleid)
/*     */   {
/* 357 */     if (System.getProperty("com.zulong.mhzx.changetimeon") == null)
/*     */     {
/* 359 */       if (gmRoleid > 0L)
/*     */       {
/* 361 */         GmManager.getInstance().sendResultToGM(gmRoleid, String.format("服务器没有开启调时间权限!", new Object[0]));
/*     */       }
/*     */       
/* 364 */       return false;
/*     */     }
/*     */     
/* 367 */     if ((dateValue.isEmpty()) || (dateValue.length() != 14))
/*     */     {
/* 369 */       if (gmRoleid > 0L)
/*     */       {
/* 371 */         GmManager.getInstance().sendResultToGM(gmRoleid, "date format error(yyyymmddhhMMss).");
/*     */       }
/*     */       
/* 374 */       return false;
/*     */     }
/*     */     
/* 377 */     if (!DateTimeUtils.setDate(dateValue))
/*     */     {
/* 379 */       if (gmRoleid > 0L)
/*     */       {
/* 381 */         GmManager.getInstance().sendResultToGM(gmRoleid, "set date failed.");
/*     */       }
/*     */       
/* 384 */       return false;
/*     */     }
/*     */     
/* 387 */     if (gmRoleid > 0L)
/*     */     {
/* 389 */       GmManager.getInstance().sendResultToGM(gmRoleid, "set date success.");
/*     */     }
/*     */     
/*     */ 
/* 393 */     mzm.gsp.online.SSendServerTime sendServerTime = new mzm.gsp.online.SSendServerTime();
/* 394 */     sendServerTime.servertime = (DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 395 */     sendServerTime.raw_offset = DateTimeUtils.RAW_OFFSET_SEC;
/* 396 */     sendServerTime.serveropentime = (getOpenServerTimestamp() / 1000L);
/* 397 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAll(sendServerTime);
/*     */     
/* 399 */     new mzm.gsp.timer.main.Observer(1L)
/*     */     {
/* 401 */       private int counter = 0;
/*     */       
/*     */ 
/*     */       public boolean update()
/*     */       {
/* 406 */         GmManager.getInstance().sendResultToAll("update datetime success, please restart game.");
/*     */         
/* 408 */         if (++this.counter > 30)
/*     */         {
/* 410 */           return false;
/*     */         }
/*     */         
/* 413 */         return true;
/*     */       }
/*     */       
/* 416 */     };
/* 417 */     return true;
/*     */   }
/*     */   
/*     */   static void onGameServerStart() throws Exception
/*     */   {
/* 422 */     if (System.getProperty("com.zulong.mhzx.roam_server") != null)
/*     */     {
/* 424 */       roamServer = true;
/*     */     }
/*     */     
/* 427 */     String value = System.getProperty("com.zulong.mhzx.guest_serverid");
/* 428 */     if ((value != null) && (!value.isEmpty()))
/*     */     {
/*     */       try
/*     */       {
/* 432 */         guestServerid = Integer.valueOf(Integer.parseInt(value));
/*     */       }
/*     */       catch (NumberFormatException e) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 439 */     value = System.getProperty("com.zulong.mhzx.gameid");
/* 440 */     if ((value != null) && (!value.isEmpty()))
/*     */     {
/*     */       try
/*     */       {
/* 444 */         gameid = Integer.parseInt(value);
/*     */       }
/*     */       catch (NumberFormatException e) {}
/*     */     }
/*     */     
/*     */ 
/* 450 */     if (gameid == 0)
/*     */     {
/* 452 */       gameid = 205;
/*     */     }
/*     */     
/* 455 */     if (isRoamServer())
/*     */     {
/* 457 */       xtable.Role2properties.getTable().banAutoKey();
/* 458 */       xtable.Children.getTable().banAutoKey();
/*     */     }
/*     */     
/* 461 */     hostname = CommonUtils.getHostName();
/* 462 */     hostIp = CommonUtils.getHostIp();
/*     */     
/* 464 */     UniqNameConf uniqNameConf = xdb.Xdb.getInstance().getConf().getUniqNameConf();
/* 465 */     localID = uniqNameConf.getLocalId();
/*     */     
/* 467 */     List<Long> tmpLocalids = new ArrayList();
/* 468 */     for (Integer id : uniqNameConf.getLocalIds())
/*     */     {
/* 470 */       tmpLocalids.add(Long.valueOf(id.longValue()));
/*     */     }
/* 472 */     localids = java.util.Collections.unmodifiableList(tmpLocalids);
/*     */     
/* 474 */     if (new POnGameServerStart(null).call())
/*     */     {
/* 476 */       gnet.GdeliveryHelper.regisGameServer();
/*     */     }
/*     */     else
/*     */     {
/* 480 */       throw new RuntimeException("load game server info failed");
/*     */     }
/*     */   }
/*     */   
/*     */   static void onGameServerStop()
/*     */   {
/* 486 */     new POnGameServerStop(null).call();
/*     */   }
/*     */   
/*     */   private static class POnGameServerStart
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 494 */       boolean isContainsRecords = Gamesrv.getTable().containsRecords();
/*     */       
/* 496 */       GameServerInfo xGameServerInfo = Gamesrv.get(Long.valueOf(GameServerInfoManager.localID));
/* 497 */       if (xGameServerInfo == null)
/*     */       {
/* 499 */         if (isContainsRecords)
/*     */         {
/* 501 */           GameServer.logger().fatal(String.format("[gamesrv]GameServerInfoManager.POnGameServerStart.processImp@localid error|localid=%d", new Object[] { Long.valueOf(GameServerInfoManager.localID) }));
/*     */           
/*     */ 
/*     */ 
/* 505 */           return false;
/*     */         }
/*     */         
/* 508 */         xGameServerInfo = xbean.Pod.newGameServerInfo();
/* 509 */         xGameServerInfo.setDb_version(1);
/* 510 */         xGameServerInfo.getZoneids().add(String.valueOf(GameServer.getZoneid()));
/* 511 */         Gamesrv.add(Long.valueOf(GameServerInfoManager.localID), xGameServerInfo);
/*     */       }
/*     */       
/*     */ 
/* 515 */       List<Integer> tmpZoneids = new ArrayList();
/* 516 */       List<String> xZoneids = xGameServerInfo.getZoneids();
/* 517 */       int len = xZoneids.size();
/* 518 */       for (int i = 0; i < len; i++)
/*     */       {
/* 520 */         tmpZoneids.add(Integer.valueOf((String)xZoneids.get(i)));
/*     */       }
/* 522 */       GameServerInfoManager.access$302(java.util.Collections.unmodifiableList(tmpZoneids));
/*     */       
/*     */ 
/* 525 */       GameServerInfoManager.access$402(((Integer)GameServerInfoManager.zoneids.get(0)).intValue());
/* 526 */       GameServerInfoManager.access$502(xGameServerInfo.getDb_version());
/*     */       
/*     */ 
/*     */ 
/* 530 */       Set<Long> tmpLocalids = new java.util.HashSet(GameServerInfoManager.localids);
/* 531 */       if (tmpLocalids.size() != GameServerInfoManager.localids.size())
/*     */       {
/* 533 */         GameServer.logger().fatal(String.format("[gamesrv]GameServerInfoManager.POnGameServerStart.processImp@localid duplicate|tmp_localids=%s|localids=%s", new Object[] { tmpLocalids, GameServerInfoManager.localids }));
/*     */         
/*     */ 
/*     */ 
/* 537 */         return false;
/*     */       }
/*     */       
/* 540 */       Set<Long> tmpZoneids = new java.util.HashSet();
/* 541 */       for (Integer tmpZoneid : GameServerInfoManager.zoneids)
/*     */       {
/* 543 */         tmpZoneids.add(Long.valueOf(tmpZoneid.longValue()));
/*     */       }
/* 545 */       if (tmpZoneids.size() != GameServerInfoManager.zoneids.size())
/*     */       {
/* 547 */         GameServer.logger().fatal(String.format("[gamesrv]GameServerInfoManager.POnGameServerStart.processImp@zoneid duplicate|tmp_zoneids=%s|zoneids=%s", new Object[] { tmpZoneids, GameServerInfoManager.zoneids }));
/*     */         
/*     */ 
/*     */ 
/* 551 */         return false;
/*     */       }
/*     */       
/* 554 */       if ((tmpLocalids.size() != tmpZoneids.size()) || (!tmpLocalids.containsAll(tmpZoneids)))
/*     */       {
/* 556 */         GameServer.logger().fatal(String.format("[gamesrv]GameServerInfoManager.POnGameServerStart.processImp@zoneids and localids not match|localids=%s|zoneids=%s", new Object[] { GameServerInfoManager.localids, GameServerInfoManager.zoneids }));
/*     */         
/*     */ 
/*     */ 
/* 560 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 565 */       if (GameServerInfoManager.zoneId != GameServerInfoManager.localID)
/*     */       {
/* 567 */         GameServer.logger().fatal(String.format("[gamesrv]GameServerInfoManager.POnGameServerStart.processImp@zoneid and localid not match|zoneid=%d|localid=%d", new Object[] { Integer.valueOf(GameServerInfoManager.zoneId), Long.valueOf(GameServerInfoManager.localID) }));
/*     */         
/*     */ 
/*     */ 
/* 571 */         return false;
/*     */       }
/*     */       
/* 574 */       DateTimeUtils.setTimeOffset(xGameServerInfo.getTime_offset());
/*     */       
/* 576 */       GameServerInfoManager.openServerTimestampInfo.setOpenServerTimestamp(xGameServerInfo.getOpen_server_timestamp());
/*     */       
/* 578 */       String gsxdbJarMd5 = System.getProperty("com.zulong.mhzx.gsxdb.jar.md5");
/* 579 */       if (gsxdbJarMd5 == null)
/*     */       {
/* 581 */         gsxdbJarMd5 = "lcl";
/*     */       }
/* 583 */       if (gsxdbJarMd5.equals(xGameServerInfo.getGsxdb_jar_md5()))
/*     */       {
/* 585 */         GameServerInfoManager.disableProtocolInfo.initOnGameServerStart(xGameServerInfo.getDisable_protocol_info().getProtocols());
/*     */       }
/*     */       else
/*     */       {
/* 589 */         xGameServerInfo.setGsxdb_jar_md5(gsxdbJarMd5);
/* 590 */         xGameServerInfo.getDisable_protocol_info().getProtocols().clear();
/*     */       }
/*     */       
/* 593 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class POnGameServerStop
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 602 */       GameServerInfo xGameServerInfo = Gamesrv.get(Long.valueOf(GameServerInfoManager.localID));
/* 603 */       if (xGameServerInfo == null)
/*     */       {
/* 605 */         return false;
/*     */       }
/*     */       
/* 608 */       xGameServerInfo.setDb_version(xGameServerInfo.getDb_version() + 1);
/* 609 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\GameServerInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */