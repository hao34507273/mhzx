/*      */ package mzm.gsp.gang.main;
/*      */ 
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.gang.SSyncCangKuLiHeChange;
/*      */ import mzm.gsp.gang.confbean.SGangCangKuCfg;
/*      */ import mzm.gsp.gang.confbean.SGangConst;
/*      */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*      */ import mzm.gsp.gang.confbean.SGangShuyuanCfg;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.role.RoleInfo;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import xbean.CangKu;
/*      */ import xbean.GangAnnouncement;
/*      */ import xbean.GangCombine;
/*      */ import xbean.GangMember;
/*      */ import xbean.GangMemoryBean;
/*      */ import xtable.Gangmemory;
/*      */ import xtable.Role2gangmember;
/*      */ 
/*      */ public class GangInterface
/*      */ {
/*      */   public static long getGangId(long roleId)
/*      */   {
/*   28 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*   29 */     if (xMember == null) {
/*   30 */       return 0L;
/*      */     }
/*   32 */     long gangId = xMember.getGangid();
/*   33 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*   34 */     if (xGang == null) {
/*   35 */       return 0L;
/*      */     }
/*   37 */     if (!GangManager.isInGang(xGang, roleId)) {
/*   38 */       return 0L;
/*      */     }
/*   40 */     return gangId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillRoleGangInfo(long roleId, RoleInfo roleInfo)
/*      */   {
/*   50 */     roleInfo.gangid = -1L;
/*   51 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*   52 */     if (xMember == null) {
/*   53 */       return;
/*      */     }
/*   55 */     long gangId = xMember.getGangid();
/*   56 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*   57 */     if (xGang == null) {
/*   58 */       return;
/*      */     }
/*   60 */     if (!GangManager.isInGang(xGang, roleId)) {
/*   61 */       return;
/*      */     }
/*   63 */     roleInfo.gangid = gangId;
/*   64 */     roleInfo.gangname = xGang.getName();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isForbiddenTalk(long roleId)
/*      */   {
/*   74 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*   75 */     if (xGangMember == null) {
/*   76 */       return false;
/*      */     }
/*   78 */     return xGangMember.getForbiddentalkend() > mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Long> getGangMemberList(long gangId)
/*      */   {
/*   88 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*   89 */     if (xGang != null) {
/*   90 */       return GangManager.getMembers(xGang);
/*      */     }
/*   92 */     return new java.util.HashSet();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangDuty(long roleId)
/*      */   {
/*  102 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  103 */     if (xMember == null) {
/*  104 */       return -1;
/*      */     }
/*  106 */     long gangId = xMember.getGangid();
/*  107 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  108 */     if (xGang == null) {
/*  109 */       return -1;
/*      */     }
/*  111 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  112 */       return -1;
/*      */     }
/*  114 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xMember);
/*  115 */     return dutyCfg.dutyLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean cutBangGong(long roleId, int bangGong, TLogArg arg)
/*      */   {
/*  125 */     ModBangGongResult result = GangManager.cutBangGongInAll(roleId, bangGong, arg, false);
/*  126 */     return result.isSucceed();
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
/*      */   public static ModBangGongResult addBangGong(long roleId, long addValue, TLogArg arg)
/*      */   {
/*  149 */     return GangManager.addBangGongInAll(roleId, addValue, arg, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ModBangGongResult addBangGongWithinMax(long roleId, long addValue, TLogArg arg)
/*      */   {
/*  161 */     return GangManager.addBangGongInAll(roleId, addValue, arg, true);
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
/*      */   public static ModBangGongResult addBangGongByItem(long roleid, int addValue, int itemCount, TLogArg tlogArg)
/*      */   {
/*  177 */     GangMember xMember = GangManager.getXGangMember(roleid, true);
/*  178 */     return GangManager.addBangGongByItem(roleid, xMember, addValue, itemCount, tlogArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addItemBangGongCount(long roleid, int itemCount)
/*      */   {
/*  189 */     GangMember xMember = GangManager.getXGangMember(roleid, true);
/*  190 */     if (xMember != null) {
/*  191 */       GangManager.addItemBangGongCount(roleid, xMember, itemCount);
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
/*      */   public static BanggongOperateEnum addBangGongForIdip(long roleId, int bangGong, TLogArg logArg)
/*      */   {
/*  204 */     ModBangGongResult result = GangManager.addBangGongInAll(roleId, bangGong, logArg, false);
/*  205 */     return GangManager.resultExchangeToOperateEnum(result);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static BanggongOperateEnum addBangGongForAqIdip(long roleId, int bangGong, TLogArg logArg)
/*      */   {
/*  216 */     return addBangGongForIdip(roleId, bangGong, logArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static BanggongOperateEnum cutBangGongForIdip(long roleId, int bangGong, TLogArg arg)
/*      */   {
/*  226 */     ModBangGongResult result = GangManager.cutBangGongInAll(roleId, bangGong, arg, false);
/*  227 */     return GangManager.resultExchangeToOperateEnum(result);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static BanggongOperateEnum cutBangGongForAqIdip(long roleId, int bangGong, TLogArg arg)
/*      */   {
/*  239 */     ModBangGongResult result = GangManager.cutBangGongInAll(roleId, bangGong, arg, true);
/*  240 */     return GangManager.resultExchangeToOperateEnum(result);
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
/*      */   public static boolean addGangMoney(long gangId, int gangMoney)
/*      */   {
/*  253 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  254 */     if (xGang == null) {
/*  255 */       return false;
/*      */     }
/*  257 */     if (gangMoney < 0) {
/*  258 */       return false;
/*      */     }
/*  260 */     GangManager.addGangMoney(xGang, gangMoney);
/*  261 */     return true;
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
/*      */   public static boolean costGangMoney(long gangId, int gangMoney)
/*      */   {
/*  274 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  275 */     if (xGang == null) {
/*  276 */       return false;
/*      */     }
/*  278 */     if (gangMoney < 0) {
/*  279 */       return false;
/*      */     }
/*  281 */     return GangManager.costGangMoney(xGang, gangMoney);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangMoney(long gangId)
/*      */   {
/*  293 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  294 */     if (xGang == null) {
/*  295 */       return -1;
/*      */     }
/*  297 */     return GangManager.getGangMoney(xGang);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangTitleid(long gangId)
/*      */   {
/*  307 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  308 */     if (xGang == null) {
/*  309 */       return -1;
/*      */     }
/*  311 */     return xGang.getDesigntitlecaseid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Long> getAllGangIdSet()
/*      */   {
/*  320 */     return GangManager.getAllGangIdSet();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangMapId(long gangId)
/*      */   {
/*  328 */     GangMemoryBean xMemoryBean = Gangmemory.select(Long.valueOf(gangId));
/*  329 */     if (xMemoryBean == null) return 0;
/*  330 */     return MapInterface.getSceneInstanceId(xMemoryBean.getGangworldid(), SGangConst.getInstance().GANG_MAP, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangCfgId()
/*      */   {
/*  338 */     return SGangConst.getInstance().GANG_MAP;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isBangZhu(long roleId, long gangId)
/*      */   {
/*  348 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  349 */     if (xGang == null) {
/*  350 */       return false;
/*      */     }
/*  352 */     if (xGang.getBangzhuid() == roleId) {
/*  353 */       return true;
/*      */     }
/*  355 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isBangZhu(long roleId)
/*      */   {
/*  364 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  365 */     if (xMember == null) {
/*  366 */       return false;
/*      */     }
/*  368 */     long gangId = xMember.getGangid();
/*  369 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  370 */     if (xGang == null) {
/*  371 */       return false;
/*      */     }
/*  373 */     if (xGang.getBangzhuid() == roleId) {
/*  374 */       return true;
/*      */     }
/*  376 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isGangMember(long roleId, long gangId) {
/*  380 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  381 */     if (xGang == null) {
/*  382 */       return false;
/*      */     }
/*  384 */     if (GangManager.isInGang(xGang, roleId)) {
/*  385 */       return true;
/*      */     }
/*  387 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getGangDutyName(long roleId)
/*      */   {
/*  397 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/*  398 */     if (xGangMember == null) {
/*  399 */       return null;
/*      */     }
/*  401 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/*  402 */     if (xGang == null) {
/*  403 */       return null;
/*      */     }
/*  405 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  406 */       return null;
/*      */     }
/*  408 */     int dutyLevel = SGangDutyCfg.get(xGangMember.getDuty()).dutyLevel;
/*  409 */     java.util.Map<Integer, String> dutyMap = GangManager.getDutyNameByLevel(xGang, new int[] { dutyLevel });
/*  410 */     return (String)dutyMap.get(Integer.valueOf(dutyLevel));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getGangName(long roleId)
/*      */   {
/*  420 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*  421 */     if (xGangMember == null) {
/*  422 */       return null;
/*      */     }
/*  424 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*  425 */     if (xGang == null) {
/*  426 */       return null;
/*      */     }
/*  428 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  429 */       return null;
/*      */     }
/*  431 */     return xGang.getName();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String getGangName(long roleId, boolean retainLock)
/*      */   {
/*      */     GangMember xGangMember;
/*      */     
/*      */     GangMember xGangMember;
/*      */     
/*  442 */     if (retainLock) {
/*  443 */       xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*      */     } else {
/*  445 */       xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  448 */     if (xGangMember == null) {
/*  449 */       return null;
/*      */     }
/*      */     xbean.Gang xGang;
/*      */     xbean.Gang xGang;
/*  453 */     if (retainLock) {
/*  454 */       xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*      */     } else {
/*  456 */       xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/*      */     }
/*      */     
/*  459 */     if (xGang == null) {
/*  460 */       return null;
/*      */     }
/*  462 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  463 */       return null;
/*      */     }
/*  465 */     return xGang.getName();
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
/*      */   public static void brocastInGang(xio.Protocol protocol, long gangId)
/*      */   {
/*  478 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  479 */     if (xGang == null) {
/*  480 */       return;
/*      */     }
/*  482 */     GangManager.broadcast(xGang, protocol);
/*      */   }
/*      */   
/*      */   public static int getGangMapCfgId() {
/*  486 */     return SGangConst.getInstance().GANG_MAP;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static Gang getGang(long gangId, boolean retainLock)
/*      */   {
/*      */     xbean.Gang xGang;
/*      */     
/*      */ 
/*      */     xbean.Gang xGang;
/*      */     
/*      */ 
/*  499 */     if (retainLock) {
/*  500 */       xGang = xtable.Gang.get(Long.valueOf(gangId));
/*      */     } else {
/*  502 */       xGang = xtable.Gang.select(Long.valueOf(gangId));
/*      */     }
/*  504 */     if (xGang == null) return null;
/*  505 */     return new Gang(gangId, 4, xGang);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getGangWorldId(long gangId)
/*      */   {
/*  514 */     Long worldid = Gangmemory.selectGangworldid(Long.valueOf(gangId));
/*  515 */     if (worldid == null) {
/*  516 */       return -1L;
/*      */     }
/*  518 */     return worldid.longValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static Gang getGangByRoleId(long roleId, boolean isRetainLock)
/*      */   {
/*      */     GangMember xMember;
/*      */     
/*      */ 
/*      */     GangMember xMember;
/*      */     
/*      */ 
/*  531 */     if (isRetainLock) {
/*  532 */       xMember = Role2gangmember.get(Long.valueOf(roleId));
/*      */     } else {
/*  534 */       xMember = Role2gangmember.select(Long.valueOf(roleId));
/*      */     }
/*  536 */     if (xMember == null) {
/*  537 */       return null;
/*      */     }
/*      */     
/*  540 */     long gangId = xMember.getGangid();
/*  541 */     xbean.Gang xGang; xbean.Gang xGang; if (isRetainLock) {
/*  542 */       xGang = xtable.Gang.get(Long.valueOf(gangId));
/*      */     } else {
/*  544 */       xGang = xtable.Gang.select(Long.valueOf(gangId));
/*      */     }
/*  546 */     if (xGang == null) {
/*  547 */       return null;
/*      */     }
/*  549 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  550 */       return null;
/*      */     }
/*  552 */     return new Gang(gangId, 4, xGang);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void transferToGangMapAsyc(long roleId)
/*      */   {
/*  560 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception {
/*  563 */         return GangManager.gotoGangMap(this.val$roleId, true);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void transferToGangMapAsyc(long roleId, long gangId)
/*      */   {
/*  574 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception {
/*  577 */         return GangInterface.transferToGangMap(this.val$roleId, this.val$gangId);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transferToGangMap(long roleId, long gangId)
/*      */   {
/*  589 */     GangMemoryBean xMemoryBean = Gangmemory.select(Long.valueOf(gangId));
/*  590 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  591 */     if ((xMemoryBean == null) || (xGang == null)) {
/*  592 */       return false;
/*      */     }
/*  594 */     GangManager.gotoGangMap(roleId, xMemoryBean, xGang);
/*  595 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transferToGangMap(long roleId, boolean isRetainLock)
/*      */   {
/*  605 */     return GangManager.gotoGangMap(roleId, isRetainLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void forceTransferToGangMap(long roleid, long gangid)
/*      */   {
/*  615 */     GangMemoryBean xMemoryBean = Gangmemory.select(Long.valueOf(gangid));
/*  616 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangid));
/*  617 */     if ((xMemoryBean == null) || (xGang == null)) {
/*  618 */       return;
/*      */     }
/*  620 */     GangManager.forceTransfer2GangMap(roleid, xMemoryBean, xGang);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isInOneGang(List<Long> roleIdList)
/*      */   {
/*  631 */     long gangId = -1L;
/*  632 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*  633 */       GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  634 */       if (xMember == null) return false;
/*  635 */       if (gangId == -1L) {
/*  636 */         gangId = xMember.getGangid();
/*      */ 
/*      */       }
/*  639 */       else if (gangId != xMember.getGangid()) {
/*  640 */         return false;
/*      */       }
/*      */     }
/*  643 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  644 */     if (xGang == null) {
/*  645 */       return false;
/*      */     }
/*  647 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  648 */       if (!GangManager.isInGang(xGang, roleid)) {
/*  649 */         return false;
/*      */       }
/*      */     }
/*  652 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean addGongXun(long roleId, int addGongXun)
/*      */   {
/*  662 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*  663 */     if (xGangMember == null) {
/*  664 */       return false;
/*      */     }
/*  666 */     long gangid = xGangMember.getGangid();
/*  667 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*  668 */     return GangManager.addGongXun(gangid, xGang, roleId, xGangMember, addGongXun);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addGongXunAsyc(long roleId, int addGongXun)
/*      */   {
/*  678 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception {
/*  681 */         GangInterface.addGongXun(this.val$roleId, this.val$addGongXun);
/*  682 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addLiHe(long gangId, int addNum)
/*      */   {
/*  694 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  695 */     if (xGang == null) {
/*  696 */       return;
/*      */     }
/*  698 */     GangManager.addGangLiHe(xGang, addNum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addLiHeByRole(long roleId, int addNum)
/*      */   {
/*  708 */     GangMember xMember = Role2gangmember.get(Long.valueOf(roleId));
/*  709 */     if (xMember == null) return;
/*  710 */     long gangId = xMember.getGangid();
/*  711 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  712 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/*  713 */       return;
/*      */     }
/*  715 */     CangKu xCangKu = xGang.getCangku();
/*  716 */     SGangCangKuCfg cfg = SGangCangKuCfg.get(xCangKu.getLevel());
/*  717 */     int totalLiHe = Math.min(addNum + xCangKu.getLihenum(), cfg.gridSize);
/*  718 */     xCangKu.setLihenum(totalLiHe);
/*  719 */     SSyncCangKuLiHeChange cangKuLiHeChange = new SSyncCangKuLiHeChange();
/*  720 */     cangKuLiHeChange.lihenum = totalLiHe;
/*  721 */     GangManager.broadcast(xGang, cangKuLiHeChange);
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
/*      */   public static void sendGangMail(long gangId, int gangMailCfgId, final List<String> contentArgList, final List<String> titleArgList, final TLogArg arg)
/*      */   {
/*  736 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception {
/*  739 */         xbean.Gang xGang = xtable.Gang.select(Long.valueOf(this.val$gangId));
/*  740 */         GangManager.sendMail(xGang, contentArgList, titleArgList, arg, this.val$arg);
/*  741 */         return true;
/*      */       }
/*      */     });
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
/*      */   public static void sendGangMailSync(long gangid, int gangMailCfgid, List<String> contentArgList, List<String> titleArgList, TLogArg tlogArg)
/*      */   {
/*  760 */     new RGangMail(gangid, gangMailCfgid, contentArgList, titleArgList, tlogArg).run();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSellGangYaoDianItem(long roleId, int itemid)
/*      */   {
/*  771 */     return GangManager.isSellGangYaoDianItem(roleId, itemid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void allGoToGangAsyc(List<Long> roleList, long gangId)
/*      */   {
/*  780 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception {
/*  783 */         GangMemoryBean xMemoryBean = Gangmemory.select(Long.valueOf(this.val$gangId));
/*  784 */         long worldId = xMemoryBean.getGangworldid();
/*  785 */         MapInterface.transferAllRole(this.val$roleList, worldId, SGangConst.getInstance().GANG_MAP);
/*  786 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getCreateGangTime(long gangId)
/*      */   {
/*  799 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  800 */     return xGang.getCreatetime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasGang(long roleId)
/*      */   {
/*  810 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  811 */     if (xMember == null) return false;
/*  812 */     long gangId = xMember.getGangid();
/*  813 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  814 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/*  815 */       return false;
/*      */     }
/*  817 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isNormalMember(long roleId)
/*      */   {
/*  827 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  828 */     if (xMember == null) {
/*  829 */       return false;
/*      */     }
/*  831 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xMember.getGangid()));
/*  832 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/*  833 */       return false;
/*      */     }
/*  835 */     return xMember.getDuty() != SGangConst.getInstance().XUETU_ID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getJoinTime(long roleId)
/*      */   {
/*  846 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  847 */     if (xMember == null) {
/*  848 */       return -1L;
/*      */     }
/*  850 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xMember.getGangid()));
/*  851 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/*  852 */       return -1L;
/*      */     }
/*  854 */     return xMember.getJointime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getGangNameByGangId(long gangId)
/*      */   {
/*  864 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  865 */     if (xGang == null) {
/*  866 */       return null;
/*      */     }
/*  868 */     return xGang.getName();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getBangGong(long roleId)
/*      */   {
/*  878 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  879 */     if (xMember == null) {
/*  880 */       return 0L;
/*      */     }
/*  882 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xMember.getGangid()));
/*  883 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/*  884 */       return 0L;
/*      */     }
/*  886 */     return xMember.getBanggong();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getHistoryBangGong(long roleid)
/*      */   {
/*  896 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleid));
/*  897 */     if (xMember == null) {
/*  898 */       return 0L;
/*      */     }
/*  900 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xMember.getGangid()));
/*  901 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleid))) {
/*  902 */       return 0L;
/*      */     }
/*  904 */     return xMember.getHistorybanggong();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangSkillLevelMaxLimit(long roleId)
/*      */   {
/*  913 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/*  914 */     if (xMember == null) {
/*  915 */       return 0;
/*      */     }
/*  917 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xMember.getGangid()));
/*  918 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/*  919 */       return 0;
/*      */     }
/*      */     
/*  922 */     SGangShuyuanCfg sGangShuyuanCfg = SGangShuyuanCfg.get(xGang.getShuyuan().getLevel());
/*  923 */     if (null != sGangShuyuanCfg) {
/*  924 */       return sGangShuyuanCfg.maxSkillLevel;
/*      */     }
/*  926 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangChengWeiId()
/*      */   {
/*  936 */     return SGangConst.getInstance().GANG_CHENGWEI_ID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getCanGangSign(long roleId, GangMember xGangMember)
/*      */   {
/*  946 */     return GangManager.getCanGangSign(roleId, xGangMember);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getBangZhuId(long roleId)
/*      */   {
/*  956 */     return GangManager.getBangZhuId(roleId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getQQGroupId(long gangId)
/*      */   {
/*  965 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  966 */     if (xGang == null) {
/*  967 */       return "";
/*      */     }
/*  969 */     return xGang.getGroupopenid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGangMaxNum(long gangId)
/*      */   {
/*  979 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  980 */     if (xGang == null) {
/*  981 */       return -1;
/*      */     }
/*  983 */     int xiangFangLevel = xGang.getXiangfang().getLevel();
/*  984 */     return GangConfigManager.getInstance().getNormalMemberCapacity(xiangFangLevel) + GangConfigManager.getInstance().getXueTuCapacity(xiangFangLevel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getGangAnnouncement(long gangId)
/*      */   {
/*  994 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  995 */     if (xGang == null) {
/*  996 */       return "";
/*      */     }
/*  998 */     List<GangAnnouncement> gangAnnouncements = xGang.getAnnouncementhistorylist();
/*  999 */     if ((gangAnnouncements == null) || (gangAnnouncements.size() == 0)) {
/* 1000 */       return "";
/*      */     }
/* 1002 */     GangAnnouncement announcement = (GangAnnouncement)gangAnnouncements.get(gangAnnouncements.size() - 1);
/* 1003 */     if (announcement == null) {
/* 1004 */       return "";
/*      */     }
/* 1006 */     return announcement.getAnnouncement();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getGangPurpose(long gangId)
/*      */   {
/* 1016 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/* 1017 */     if (xGang == null) {
/* 1018 */       return "";
/*      */     }
/* 1020 */     return xGang.getPurpose();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getDisplayid(long gangid)
/*      */   {
/* 1032 */     return gangid / 4096L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean canActivePVE(long roleid)
/*      */   {
/* 1043 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleid));
/* 1044 */     if (xMember == null) {
/* 1045 */       return false;
/*      */     }
/* 1047 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(xMember.getDuty());
/* 1048 */     if (dutyCfg == null) {
/* 1049 */       return false;
/*      */     }
/* 1051 */     return dutyCfg.canActivatePVE;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean canSignUpCrossCompete(long roleid)
/*      */   {
/* 1062 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleid));
/* 1063 */     if (xMember == null) {
/* 1064 */       return false;
/*      */     }
/* 1066 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(xMember.getDuty());
/* 1067 */     if (dutyCfg == null) {
/* 1068 */       return false;
/*      */     }
/* 1070 */     return dutyCfg.canSignUpCrossCompete;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isViceGangInCombining(long factionid)
/*      */   {
/* 1081 */     GangCombine xCombine = GangManager.getXCombine(factionid, false);
/* 1082 */     if (xCombine == null) {
/* 1083 */       return false;
/*      */     }
/* 1085 */     if (xCombine.getGangid() <= 0L) {
/* 1086 */       return false;
/*      */     }
/* 1088 */     if (xCombine.getApplicants().contains(Long.valueOf(xCombine.getGangid()))) {
/* 1089 */       return false;
/*      */     }
/* 1091 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getDutyLevelByDutyid(int dutyid)
/*      */   {
/* 1100 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(dutyid);
/* 1101 */     if (dutyCfg == null) {
/* 1102 */       return -1;
/*      */     }
/* 1104 */     return dutyCfg.dutyLevel;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */