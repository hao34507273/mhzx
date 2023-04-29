/*      */ package mzm.gsp.gang.main;
/*      */ 
/*      */ import hub.CrossCompeteFactionDutyMembers;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.gang.Applicant;
/*      */ import mzm.gsp.gang.CangKuInfo;
/*      */ import mzm.gsp.gang.CombineGang;
/*      */ import mzm.gsp.gang.GangInfo;
/*      */ import mzm.gsp.gang.MemberInfo;
/*      */ import mzm.gsp.gang.MiFangInfo;
/*      */ import mzm.gsp.gang.SAddApplicantBrd;
/*      */ import mzm.gsp.gang.SAddGangTeamApplicantBrd;
/*      */ import mzm.gsp.gang.SAddGangTeamMemberBrd;
/*      */ import mzm.gsp.gang.SChangeGangTeamLeaderBrd;
/*      */ import mzm.gsp.gang.SChangeGangTeamNameBrd;
/*      */ import mzm.gsp.gang.SCombineGangApplyResultBrd;
/*      */ import mzm.gsp.gang.SCreateGangTeamBrd;
/*      */ import mzm.gsp.gang.SGangCombineBrd;
/*      */ import mzm.gsp.gang.SGangNormalResult;
/*      */ import mzm.gsp.gang.SGetGangListRes;
/*      */ import mzm.gsp.gang.SJoinGangRes;
/*      */ import mzm.gsp.gang.SJoinGangTeamRefusedNotify;
/*      */ import mzm.gsp.gang.SOutGangNotify;
/*      */ import mzm.gsp.gang.SRemoveApplicantBrd;
/*      */ import mzm.gsp.gang.SRemoveGangTeamApplicantBrd;
/*      */ import mzm.gsp.gang.SRemoveGangTeamMemberBrd;
/*      */ import mzm.gsp.gang.SSetLeaveGangWithQQGroup;
/*      */ import mzm.gsp.gang.SSyncAddGangMember;
/*      */ import mzm.gsp.gang.SSyncApplicants;
/*      */ import mzm.gsp.gang.SSyncCangKuLiHeChange;
/*      */ import mzm.gsp.gang.SSyncGangDissolve;
/*      */ import mzm.gsp.gang.SSyncGangInfo;
/*      */ import mzm.gsp.gang.SSyncGangLevelDownDuty;
/*      */ import mzm.gsp.gang.SSyncGangMaintain;
/*      */ import mzm.gsp.gang.SSyncGangMapCreate;
/*      */ import mzm.gsp.gang.SSyncGangQQGroupRes;
/*      */ import mzm.gsp.gang.SSyncGangTeamApplicants;
/*      */ import mzm.gsp.gang.SSyncMemberInfoChange;
/*      */ import mzm.gsp.gang.SSyncSelfInfo;
/*      */ import mzm.gsp.gang.SSyncVitalityBrd;
/*      */ import mzm.gsp.gang.YaoCaiShopItem;
/*      */ import mzm.gsp.gang.YaoDianInfo;
/*      */ import mzm.gsp.gang.cache.GangCacheManager;
/*      */ import mzm.gsp.gang.cache.GangLRUCache;
/*      */ import mzm.gsp.gang.confbean.SDesignDutyNameCfg;
/*      */ import mzm.gsp.gang.confbean.SGangBuildDonateCfg;
/*      */ import mzm.gsp.gang.confbean.SGangCangKuCfg;
/*      */ import mzm.gsp.gang.confbean.SGangConst;
/*      */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*      */ import mzm.gsp.gang.confbean.SGangJinKuCfg;
/*      */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*      */ import mzm.gsp.gang.confbean.SGangMailCfg;
/*      */ import mzm.gsp.gang.confbean.SGangMiFangToolsCfg;
/*      */ import mzm.gsp.gang.confbean.SGangMiFangToolsCfgInfo;
/*      */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*      */ import mzm.gsp.gang.confbean.SGangYaoDianItemList;
/*      */ import mzm.gsp.gang.event.ContributionChangedArg;
/*      */ import mzm.gsp.gang.event.GangArg;
/*      */ import mzm.gsp.gang.event.GangTeamDissolvedArg;
/*      */ import mzm.gsp.gang.event.JoinGang;
/*      */ import mzm.gsp.gang.event.JoinGangTeamArg;
/*      */ import mzm.gsp.gang.event.LeaveGang;
/*      */ import mzm.gsp.gang.event.LeaveGangArg;
/*      */ import mzm.gsp.gang.event.LeaveGangArg.LeaveType;
/*      */ import mzm.gsp.gang.event.LeaveGangTeamArg;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*      */ import mzm.gsp.team.main.JoinTeamResult;
/*      */ import mzm.gsp.team.main.JoinTeamType;
/*      */ import mzm.gsp.team.main.ReturnTeamResult;
/*      */ import mzm.gsp.team.main.TeamInfo;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*      */ import mzm.gsp.yuanbao.main.CurrencyType;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.CangKu;
/*      */ import xbean.CombineGangsInfo;
/*      */ import xbean.CombiningGangsKey;
/*      */ import xbean.GangApply;
/*      */ import xbean.GangCombine;
/*      */ import xbean.GangDutyMembers;
/*      */ import xbean.GangGlobal;
/*      */ import xbean.GangMember;
/*      */ import xbean.GangMemoryBean;
/*      */ import xbean.GangTeamApplicants;
/*      */ import xbean.GangTeamInvitation;
/*      */ import xbean.GangTeamInvitations;
/*      */ import xbean.JinKu;
/*      */ import xbean.MiFang;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleApplyGang;
/*      */ import xbean.ShuYuan;
/*      */ import xbean.XiangFang;
/*      */ import xbean.YaoDian;
/*      */ import xdb.Executor;
/*      */ import xdb.Procedure;
/*      */ import xdb.TTable;
/*      */ import xdb.Xdb;
/*      */ import xdb.util.UniqName;
/*      */ import xio.Protocol;
/*      */ import xtable.Gangcombine;
/*      */ import xtable.Gangglobal;
/*      */ import xtable.Gangmemory;
/*      */ import xtable.Gangteam_invitations;
/*      */ import xtable.Role2gangmember;
/*      */ import xtable.Roleapplygang;
/*      */ 
/*      */ public class GangManager
/*      */ {
/*  141 */   static final Logger logger = Logger.getLogger(GangManager.class);
/*      */   
/*      */   static final int RATE = 10000;
/*      */   
/*      */   public static final int NAME_ILLEGAL = -1;
/*      */   
/*      */   public static final int NAME_DUPLICATE = -3;
/*      */   
/*      */   public static final int PURPOSE_ILLEGAL = -2;
/*      */   public static final int ALREADY_IN_GANG = -4;
/*      */   public static final int WAN = 10000;
/*      */   public static final long ONEKEY_TIME = 300000L;
/*  153 */   public static final Integer ONEKEY_TYPE1 = Integer.valueOf(1);
/*  154 */   public static final Integer ONEKEY_TYPE2 = Integer.valueOf(2);
/*  155 */   public static final Integer ONEKEY_TYPE3 = Integer.valueOf(3);
/*      */   
/*      */   public static final String TLOG_GANG_LEVELUP = "GangLevelup";
/*      */   
/*      */   public static final String TLOG_GANG = "Gang";
/*      */   
/*      */   public static final String TLOG_GANG_DISMISS = "GangDismiss";
/*      */   
/*      */   public static final String TLOG_GANG_COMBINE = "GangCombine";
/*      */   public static final String TLOG_GANG_KICKOUT = "GangKickOutTLog";
/*      */   public static final String TLOG_GANG_TEAM_CREATED = "GangTeamCreated";
/*      */   public static final String TLOG_JOIN_GANG_TEAM = "JoinGangTeam";
/*      */   public static final String TLOG_LEAVE_GANG_TEAM = "LeaveGangTeam";
/*      */   public static final String TLOG_KICK_GANG_TEAM_MEMBER = "KickGangTeamMember";
/*      */   public static final String TLOG_GANG_TEAM_DISSOLVED = "GangTeamDissovled";
/*      */   public static final String TLOG_GANG_CONTRIBUTION_CHANGED = "GangContributionChanged";
/*      */   
/*      */   public static void init() {}
/*      */   
/*      */   static GangGlobal getXGlobal(boolean remainLock)
/*      */   {
/*  176 */     GangGlobal xGlobal = null;
/*  177 */     if (remainLock) {
/*  178 */       xGlobal = Gangglobal.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*      */     }
/*      */     else {
/*  181 */       xGlobal = Gangglobal.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*      */     }
/*  183 */     return xGlobal;
/*      */   }
/*      */   
/*      */   static GangGlobal getAndCreateXGlobal() {
/*  187 */     GangGlobal xGlobal = Gangglobal.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  188 */     if (xGlobal == null) {
/*  189 */       xGlobal = Pod.newGangGlobal();
/*  190 */       Gangglobal.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobal);
/*      */     }
/*  192 */     return xGlobal;
/*      */   }
/*      */   
/*      */   static RoleApplyGang getAndCreateXRoleApplyGang(long roleid) {
/*  196 */     RoleApplyGang xRoleApplyGang = Roleapplygang.get(Long.valueOf(roleid));
/*  197 */     if (xRoleApplyGang == null) {
/*  198 */       xRoleApplyGang = Pod.newRoleApplyGang();
/*  199 */       Roleapplygang.insert(Long.valueOf(roleid), xRoleApplyGang);
/*      */     }
/*  201 */     return xRoleApplyGang;
/*      */   }
/*      */   
/*      */   static RoleApplyGang getXRoleApplyGang(long roleid, boolean remainLock) {
/*  205 */     RoleApplyGang xRoleApplyGang = null;
/*  206 */     if (remainLock) {
/*  207 */       xRoleApplyGang = Roleapplygang.get(Long.valueOf(roleid));
/*      */     }
/*      */     else {
/*  210 */       xRoleApplyGang = Roleapplygang.select(Long.valueOf(roleid));
/*      */     }
/*  212 */     return xRoleApplyGang;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*  217 */   private static void initGang() { new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/*  221 */         GangGlobal xGlobal = GangManager.getXGlobal(false);
/*  222 */         if ((xGlobal == null) || (xGlobal.getAllgangids().isEmpty())) {
/*  223 */           return false;
/*      */         }
/*  225 */         long curTime = DateTimeUtils.getCurrTimeInMillis();
/*      */         
/*  227 */         xdb.Lockeys.lock(xtable.Gang.getTable(), xGlobal.getAllgangids());
/*      */         
/*  229 */         Iterator<Long> iter = xGlobal.getAllgangids().iterator();
/*  230 */         while (iter.hasNext()) {
/*  231 */           Long gangid = (Long)iter.next();
/*  232 */           xbean.Gang xGang = xtable.Gang.get(gangid);
/*  233 */           if (xGang == null) {
/*  234 */             String logStr = String.format("GangManager.initGang@invalid gangid in set|gangid=%d", new Object[] { gangid });
/*      */             
/*  236 */             GangManager.logger.error(logStr);
/*  237 */             iter.remove();
/*      */           }
/*      */           else {
/*  240 */             BuildingFactory.init(gangid.longValue(), xGang);
/*  241 */             long tanheTime = xGang.getTanheendtime();
/*  242 */             if (tanheTime > 0L) {
/*  243 */               new GangTanHeObserver(gangid.longValue(), tanheTime - curTime);
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*  248 */         return true;
/*      */       }
/*      */     }.call(); }
/*      */   
/*      */   public static void postInit() {
/*  253 */     xtable.Gang.getTable().addListener(new JinKuListener(), new String[] { "value", "jinku" });
/*  254 */     xtable.Gang.getTable().addListener(new VitalityListener(), new String[] { "value", "vitality" });
/*  255 */     xtable.Gang.getTable().addListener(new GangInfoChangeListener(), new String[] { "value" });
/*  256 */     Role2gangmember.getTable().addListener(new DutyListener(), new String[] { "value", "duty" });
/*      */     
/*  258 */     Role2gangmember.getTable().addListener(new BangGongListener(), new String[] { "value", "banggong" });
/*      */     
/*  260 */     new GangDayUpdateObserver(SGangConst.getInstance().GANG_SCHEDULE_TIME_ID);
/*      */     
/*  262 */     new RedeemBangGongObserver(SGangConst.getInstance().SILVER2BANGGONG_CLEAR_TIMEID);
/*      */     
/*  264 */     YaoDianUpdateObserver.nextUpdate();
/*      */     
/*  266 */     new FuLiUpdateObserver();
/*      */     
/*  268 */     PYaoDianMiFangDurationObserver.getInstance();
/*      */     
/*  270 */     new PayObserver(SGangConst.getInstance().PAY_TIME);
/*      */     
/*  272 */     Xdb.executor().execute(new RInitCombine());
/*      */     
/*      */ 
/*  275 */     Xdb.executor().execute(new RPrintGsLogForBangzhuError());
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
/*      */   public static long createGang(long roleId, String name, String purpose)
/*      */   {
/*  289 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*      */     
/*  291 */     if (xGangMember != null) {
/*  292 */       xbean.Gang xOldGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*  293 */       if ((xOldGang != null) && (isInGang(xOldGang, roleId))) {
/*  294 */         return -4L;
/*      */       }
/*      */     } else {
/*  297 */       xGangMember = Pod.newGangMember();
/*  298 */       Role2gangmember.add(Long.valueOf(roleId), xGangMember);
/*      */     }
/*      */     
/*      */ 
/*  302 */     name = name.trim();
/*  303 */     if ((name.isEmpty()) || (name.matches("\\d+")) || (Math.ceil(CommonUtils.getUTF16Length(name) / 2.0D) > SGangConst.getInstance().GANG_NAME_MAX_LENGTH) || (!mzm.gsp.server.main.AvailableStringArgs.getInstance().isStringUsable(name))) {
/*  304 */       return -1L;
/*      */     }
/*      */     
/*  307 */     if (SensitiveInterface.isNameSensitive(name)) {
/*  308 */       return -1L;
/*      */     }
/*  310 */     if (SensitiveInterface.isContentSensitive(purpose)) {
/*  311 */       return -2L;
/*      */     }
/*      */     
/*  314 */     if (!UniqName.allocate("faction", name))
/*      */     {
/*  316 */       return -3L;
/*      */     }
/*      */     
/*  319 */     if (Math.ceil(CommonUtils.getUTF16Length(purpose) / 2.0D) > SGangConst.getInstance().GANG_PURPOSE_MAX_LENGTH) {
/*  320 */       return -2L;
/*      */     }
/*      */     
/*  323 */     long createTime = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/*  325 */     xGangMember.setDuty(SGangConst.getInstance().BANGZHU_ID);
/*  326 */     xGangMember.setJointime(createTime);
/*  327 */     xGangMember.setForbiddentalkend(0L);
/*  328 */     xGangMember.setIspassiveleaved(false);
/*  329 */     setBangGongWithTlog(roleId, xGangMember, -xGangMember.getBanggong() * SGangConst.getInstance().JOIN_GANG_BANGGONG_CALC_RATE / 10000L, new TLogArg(LogReason.GANG_CREAT_GANG_CHANGE_BANGGONG), true);
/*  330 */     xbean.Gang xGang = Pod.newGang();
/*      */     
/*  332 */     xGang.setLevel(1);
/*  333 */     xGang.setVitality(SGangConst.getInstance().GANG_LIVELY_MAX_LIMIT);
/*  334 */     xGang.getJinku().setGangmoney(SGangConst.getInstance().ORGINAL_MONEY);
/*  335 */     xGang.setPurpose(purpose);
/*  336 */     xGang.setApprenticemaxlv(SGangConst.getInstance().XUETU_MAX_LV);
/*  337 */     xGang.setBangzhuid(roleId);
/*  338 */     xGang.setCreatetime(createTime);
/*  339 */     xGang.setDesigntitlecaseid(SGangConst.getInstance().DEFAULT_DUTY_NAME_ID);
/*  340 */     xGang.setName(name);
/*  341 */     xGang.setLastrename(createTime);
/*  342 */     addMember(xGang, roleId, SGangConst.getInstance().BANGZHU_ID);
/*  343 */     xGang.setGrouproleid(0L);
/*  344 */     xGang.setGroupopenid("");
/*  345 */     Calendar calendar = Calendar.getInstance();
/*  346 */     calendar.set(14, 0);
/*  347 */     calendar.set(11, 0);
/*  348 */     calendar.set(12, 0);
/*  349 */     calendar.set(13, 0);
/*  350 */     calendar.add(5, 1);
/*  351 */     xGang.setTimestamp(calendar.getTimeInMillis());
/*      */     
/*  353 */     long gangId = xtable.Gang.insert(xGang).longValue();
/*  354 */     xGangMember.setGangid(gangId);
/*  355 */     xGangMember.setIs_in_gang(true);
/*      */     
/*      */ 
/*  358 */     GangGlobal xGlobal = getAndCreateXGlobal();
/*  359 */     xGlobal.getAllgangids().add(Long.valueOf(gangId));
/*  360 */     if (xGlobal.getNextdisplayid() > 0L) {
/*  361 */       xGang.setDisplayid(xGlobal.getNextdisplayid());
/*  362 */       xGlobal.setNextdisplayid(xGlobal.getNextdisplayid() + 1L);
/*      */     }
/*      */     
/*      */ 
/*  366 */     SGangCangKuCfg sGangCangKuCfg = SGangCangKuCfg.get(xGang.getCangku().getLevel());
/*  367 */     if (sGangCangKuCfg != null) {
/*  368 */       xGang.getCangku().setAvaliablefulinum(sGangCangKuCfg.fuLiNum);
/*  369 */       xGang.getCangku().setFulinumtotal(sGangCangKuCfg.fuLiNum);
/*  370 */       xGang.getCangku().setLastupdatefulitime(DateTimeUtils.getCurrTimeInMillis());
/*      */     }
/*      */     else {
/*  373 */       String logStr = String.format("GangManager.createGang@can not find SGangCangKuCfg|cangkulevel=%d|roleId=%d|gangid=%d", new Object[] { Integer.valueOf(xGang.getCangku().getLevel()), Long.valueOf(roleId), Long.valueOf(gangId) });
/*      */       
/*  375 */       logger.error(logStr);
/*      */     }
/*      */     
/*      */ 
/*  379 */     checkGangSign(roleId, xGangMember);
/*      */     
/*  381 */     xGangMember.setSignstr(SGangConst.getInstance().SEVER_GANG_SIGN_STR);
/*  382 */     GangMemoryBean xMemoryBean = Pod.newGangMemoryBean();
/*  383 */     long worldId = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SGangConst.getInstance().GANG_MAP) }));
/*  384 */     TeamInterface.registerJoinTeam(worldId, new mzm.gsp.team.main.JoinTeamCheckHandler()
/*      */     {
/*      */ 
/*      */       public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*      */       {
/*  389 */         ReturnTeamResult result = new ReturnTeamResult();
/*  390 */         result.setSucceed(true);
/*  391 */         return result;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */       public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*      */       {
/*  398 */         JoinTeamResult result = new JoinTeamResult();
/*  399 */         result.setSucceed(true);
/*  400 */         return result;
/*      */       }
/*      */       
/*  403 */     });
/*  404 */     TeamInterface.registerReturnTeam(worldId, new mzm.gsp.team.main.ReturnTeamCheckHandler()
/*      */     {
/*      */       public boolean canReturnTeam(long roleId)
/*      */       {
/*  408 */         return true;
/*      */       }
/*      */       
/*      */       public boolean canBeReturnTeam(TeamInfo teamInfo, long leaderId, long roleId)
/*      */       {
/*  413 */         return true;
/*      */       }
/*      */       
/*  416 */     });
/*  417 */     xMemoryBean.setGangworldid(worldId);
/*  418 */     Gangmemory.add(Long.valueOf(xGangMember.getGangid()), xMemoryBean);
/*      */     
/*      */ 
/*  421 */     syncGangInfo(roleId, gangId, xGang, xMemoryBean);
/*      */     
/*      */ 
/*  424 */     syncSelfInfo(roleId, xGangMember);
/*      */     
/*  426 */     GangArg gangArg = new GangArg();
/*  427 */     gangArg.gangId = gangId;
/*  428 */     gangArg.roleId = roleId;
/*  429 */     gangArg.extraMemberList.add(Long.valueOf(roleId));
/*  430 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.CreateGang(), gangArg);
/*      */     
/*  432 */     TriggerEventsManger.getInstance().triggerEvent(new JoinGang(), gangArg);
/*      */     
/*      */ 
/*  435 */     NoneRealTimeTaskManager.getInstance().addTask(new PClearApplyGangs(roleId));
/*      */     
/*  437 */     return gangId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void syncGangInfoList(long roleId, long lastId, int size)
/*      */   {
/*  447 */     SGetGangListRes res = new SGetGangListRes();
/*  448 */     Set<Long> treeSet = getAllGangIdSet();
/*  449 */     if (treeSet.isEmpty()) {
/*  450 */       OnlineManager.getInstance().send(roleId, res);
/*      */     }
/*  452 */     List<Long> list = new ArrayList();
/*  453 */     list.addAll(treeSet);
/*  454 */     Collections.sort(list);
/*  455 */     int st = -1;
/*  456 */     for (int i = 0; i < list.size(); i++) {
/*  457 */       if (((Long)list.get(i)).longValue() > lastId) {
/*  458 */         st = i;
/*  459 */         break;
/*      */       }
/*      */     }
/*  462 */     if (st == -1) {
/*  463 */       return;
/*      */     }
/*      */     
/*      */ 
/*  467 */     Set<Long> needIdSet = new HashSet();
/*      */     
/*  469 */     for (int i = st; i < list.size(); i++)
/*      */     {
/*  471 */       needIdSet.add(list.get(i));
/*  472 */       if (needIdSet.size() >= size) {
/*      */         break;
/*      */       }
/*      */     }
/*  476 */     for (Long gangId : needIdSet) {
/*  477 */       xbean.Gang xGang = xtable.Gang.select(gangId);
/*  478 */       if (xGang != null)
/*      */       {
/*      */ 
/*  481 */         GangInfo gangInfo = new GangInfo();
/*  482 */         gangInfo.gangid = gangId.longValue();
/*  483 */         fillGangInfo(xGang, gangInfo);
/*  484 */         res.ganglist.add(gangInfo);
/*      */       } }
/*  486 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */   static void fillGangInfo(xbean.Gang xGang, GangInfo info)
/*      */   {
/*  491 */     info.name = xGang.getName();
/*  492 */     info.level = xGang.getLevel();
/*  493 */     info.purpose = xGang.getPurpose();
/*  494 */     info.bangzhu = RoleInterface.getName(xGang.getBangzhuid());
/*  495 */     XiangFang xXiangFang = xGang.getXiangfang();
/*  496 */     info.membernum = getNormalMemberCount(xGang);
/*  497 */     info.xiangfanglevel = xXiangFang.getLevel();
/*  498 */     info.displayid = xGang.getDisplayid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long findGangInfo(GangGlobal xGlobal, String condition)
/*      */   {
/*  507 */     if ((xGlobal == null) || (condition == null)) {
/*  508 */       return -1L;
/*      */     }
/*  510 */     condition = condition.trim();
/*  511 */     if (condition.equals("")) {
/*  512 */       return -1L;
/*      */     }
/*      */     
/*  515 */     Set<Long> gangids = xGlobal.getAllgangids();
/*      */     
/*  517 */     if (condition.matches("\\d+")) {
/*  518 */       long displayid = Long.parseLong(condition);
/*      */       
/*  520 */       if (xGlobal.getNextdisplayid() <= 0L) {
/*  521 */         long gangid = displayid * 4096L + GameServerInfoManager.getLocalId();
/*  522 */         return gangid;
/*      */       }
/*      */       
/*  525 */       Iterator<Long> iter = gangids.iterator();
/*  526 */       while (iter.hasNext()) {
/*  527 */         long gangid = ((Long)iter.next()).longValue();
/*  528 */         xbean.Gang xGang = getXGang(gangid, false);
/*  529 */         if ((xGang != null) && 
/*  530 */           (xGang.getDisplayid() == displayid)) {
/*  531 */           return gangid;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  537 */     Iterator<Long> iter = gangids.iterator();
/*  538 */     while (iter.hasNext()) {
/*  539 */       long gangid = ((Long)iter.next()).longValue();
/*      */       
/*  541 */       xbean.Gang xGang = getXGang(gangid, false);
/*  542 */       if ((xGang != null) && 
/*  543 */         (xGang.getName().equals(condition))) {
/*  544 */         return gangid;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  549 */     return -1L;
/*      */   }
/*      */   
/*      */   static void syncSelfInfo(long roleid, GangMember xMember)
/*      */   {
/*  554 */     SSyncSelfInfo sync = new SSyncSelfInfo();
/*  555 */     fillSyncSelfInfo(roleid, xMember, sync);
/*  556 */     OnlineManager.getInstance().send(roleid, sync);
/*      */   }
/*      */   
/*      */   static void fillSyncSelfInfo(long roleid, GangMember xMember, SSyncSelfInfo proSync) {
/*  560 */     proSync.read_announcement_timestamp = xMember.getLastreadannouncementtimestamp();
/*  561 */     proSync.redeembanggong = ((int)xMember.getRedeembanggong());
/*  562 */     proSync.get_fuli_timestamp = xMember.getLastgetfulitime();
/*  563 */     proSync.have_mifang_timestamp = xMember.getLasthavemifangtime();
/*  564 */     proSync.sign_timestamp = xMember.getSigntime();
/*  565 */     proSync.signstr = xMember.getSignstr();
/*  566 */     proSync.yuan_bao_redeem_bang_gong = xMember.getYuanbao_redeem_bang_gong();
/*      */   }
/*      */   
/*      */   static void fillGangTeamMember(long gangTeamMemberid, xbean.GangTeamMember xMember, mzm.gsp.gang.GangTeamMember memberBean)
/*      */   {
/*  571 */     memberBean.roleid = gangTeamMemberid;
/*  572 */     memberBean.join_time = xMember.getJoin_time();
/*      */   }
/*      */   
/*      */   static void fillGangTeam(long gangTeamid, xbean.GangTeam xGangTeam, mzm.gsp.gang.GangTeam teamBean) {
/*  576 */     teamBean.teamid = gangTeamid;
/*  577 */     teamBean.name = xGangTeam.getName();
/*  578 */     teamBean.leaderid = xGangTeam.getLeader();
/*  579 */     for (Map.Entry<Long, xbean.GangTeamMember> entry : xGangTeam.getMembers().entrySet()) {
/*  580 */       long memberid = ((Long)entry.getKey()).longValue();
/*  581 */       xbean.GangTeamMember xMember = (xbean.GangTeamMember)entry.getValue();
/*      */       
/*  583 */       mzm.gsp.gang.GangTeamMember memberBean = new mzm.gsp.gang.GangTeamMember();
/*  584 */       fillGangTeamMember(memberid, xMember, memberBean);
/*  585 */       teamBean.members.add(memberBean);
/*      */     }
/*  587 */     teamBean.create_time = xGangTeam.getCreate_millis();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillSyncGangInfo(long gangid, xbean.Gang xGang, GangMemoryBean xMemoryBean, SSyncGangInfo proSync)
/*      */   {
/*  599 */     proSync.gangid = gangid;
/*  600 */     proSync.name = xGang.getName();
/*  601 */     proSync.xuetumaxlevel = xGang.getApprenticemaxlv();
/*      */     
/*  603 */     proSync.bangzhu = RoleInterface.getName(xGang.getBangzhuid());
/*  604 */     proSync.level = xGang.getLevel();
/*  605 */     proSync.money = xGang.getJinku().getGangmoney();
/*  606 */     proSync.vitality = xGang.getVitality();
/*  607 */     proSync.purpose = xGang.getPurpose();
/*  608 */     proSync.designdutynameid = xGang.getDesigntitlecaseid();
/*  609 */     proSync.createtime = ((int)TimeUnit.MILLISECONDS.toSeconds(xGang.getCreatetime()));
/*  610 */     proSync.tanheroleid = xGang.getTanheroleid();
/*  611 */     proSync.tanheendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(xGang.getTanheendtime()));
/*  612 */     proSync.buildendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(xGang.getLeveluptime()));
/*      */     
/*      */ 
/*  615 */     mzm.gsp.gang.cache.Gang gangCache = createGangCacheIfNotExist(gangid, xGang);
/*      */     
/*  617 */     gangCache.fillMemberListBean(proSync.memberlist);
/*      */     
/*  619 */     List<xbean.GangAnnouncement> announcementList = xGang.getAnnouncementhistorylist();
/*  620 */     for (xbean.GangAnnouncement xAnn : announcementList) {
/*  621 */       mzm.gsp.gang.GangAnnouncement announcement = new mzm.gsp.gang.GangAnnouncement();
/*  622 */       fillGangAnnouncement(xAnn, announcement);
/*  623 */       proSync.announcementlist.add(announcement);
/*      */     }
/*      */     
/*  626 */     XiangFang xiangFang = xGang.getXiangfang();
/*  627 */     proSync.xiangfanginfo.level = xiangFang.getLevel();
/*  628 */     proSync.xiangfanginfo.levelupendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(xiangFang.getLevelupendtime()));
/*  629 */     CangKu cangKu = xGang.getCangku();
/*  630 */     fillCangKu(cangKu, proSync.cangkuinfo);
/*  631 */     JinKu jinKu = xGang.getJinku();
/*  632 */     proSync.jinkuinfo.level = jinKu.getLevel();
/*  633 */     proSync.jinkuinfo.levelupendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(jinKu.getLevelupendtime()));
/*  634 */     YaoDian yaoDian = xGang.getYaodian();
/*  635 */     fillYaoDian(yaoDian, proSync.yaodianinfo);
/*  636 */     ShuYuan shuyuan = xGang.getShuyuan();
/*  637 */     proSync.shuyuaninfo.level = shuyuan.getLevel();
/*  638 */     proSync.shuyuaninfo.levelupendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(shuyuan.getLevelupendtime()));
/*      */     
/*  640 */     proSync.mapinstanceid = MapInterface.getSceneInstanceId(xMemoryBean.getGangworldid(), SGangConst.getInstance().GANG_MAP, false);
/*      */     
/*  642 */     proSync.fuli_timestamp = xGang.getCangku().getLastupdatefulitime();
/*  643 */     MiFang xMiFang = xGang.getYaodian().getMifang();
/*  644 */     proSync.mifang_start_time = xMiFang.getMifangcfgstarttime();
/*  645 */     proSync.mifang_end_time = xMiFang.getMifangcfgendtime();
/*  646 */     proSync.displayid = xGang.getDisplayid();
/*      */     
/*      */ 
/*  649 */     for (Map.Entry<Long, xbean.GangTeam> entry : xGang.getTeams().entrySet()) {
/*  650 */       long gangTeamid = ((Long)entry.getKey()).longValue();
/*  651 */       xbean.GangTeam xGangTeam = (xbean.GangTeam)entry.getValue();
/*      */       
/*  653 */       mzm.gsp.gang.GangTeam teamBean = new mzm.gsp.gang.GangTeam();
/*  654 */       fillGangTeam(gangTeamid, xGangTeam, teamBean);
/*  655 */       proSync.teams.add(teamBean);
/*      */     }
/*      */   }
/*      */   
/*      */   static Protocol getSyncGangInfoProtocol(long gangid, xbean.Gang xGang, GangMemoryBean xMemoryBean) {
/*  660 */     SSyncGangInfo sync = new SSyncGangInfo();
/*  661 */     fillSyncGangInfo(gangid, xGang, xMemoryBean, sync);
/*  662 */     return sync;
/*      */   }
/*      */   
/*      */   static void syncGangInfo(long roleid, long gangid, xbean.Gang xGang, GangMemoryBean xMemoryBean)
/*      */   {
/*  667 */     Protocol pro = getSyncGangInfoProtocol(gangid, xGang, xMemoryBean);
/*  668 */     OnlineManager.getInstance().send(roleid, pro);
/*      */   }
/*      */   
/*      */   static void fillGangMemberInfo(long roleId, GangMember xMember, MemberInfo memberInfo) {
/*  672 */     Role role = RoleInterface.getRole(roleId, false);
/*  673 */     int avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/*  674 */     int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*  675 */     int fightValue = RoleInterface.getRoleMFValue(roleId);
/*  676 */     fillGangMemberInfo(role, avatarid, avatarFrame, fightValue, xMember, memberInfo);
/*      */   }
/*      */   
/*      */   static void fillGangMemberInfo(Role role, int avatarid, int avatarFrame, int fightValue, GangMember xMember, MemberInfo memberInfo)
/*      */   {
/*  681 */     memberInfo.roleid = role.getId();
/*  682 */     memberInfo.name = role.getName();
/*  683 */     memberInfo.level = role.getLevel();
/*  684 */     memberInfo.gender = role.getGender();
/*  685 */     memberInfo.occupationid = role.getOccupationId();
/*  686 */     memberInfo.avatarid = avatarid;
/*  687 */     memberInfo.avatar_frame = avatarFrame;
/*  688 */     memberInfo.duty = xMember.getDuty();
/*  689 */     memberInfo.forbiddentalk = xMember.getForbiddentalkend();
/*  690 */     memberInfo.curbanggong = ((int)xMember.getBanggong());
/*  691 */     memberInfo.historybanggong = ((int)xMember.getHistorybanggong());
/*  692 */     memberInfo.weekbanggong = xMember.getWeekbanggong();
/*  693 */     memberInfo.add_banggong_time = xMember.getAddbanggong_time();
/*  694 */     memberInfo.weekitem_banggong_count = xMember.getWeekitem_banggong_count();
/*  695 */     memberInfo.item_banggong_time = xMember.getItem_banggong_time();
/*      */     
/*  697 */     if (!OnlineManager.getInstance().isOnlineOrInProtect(role.getId())) {
/*  698 */       memberInfo.offlinetime = role.getLastLogoffTime();
/*      */     }
/*      */     else {
/*  701 */       memberInfo.offlinetime = -1L;
/*      */     }
/*      */     
/*  704 */     memberInfo.jointime = xMember.getJointime();
/*  705 */     memberInfo.getlihetime = xMember.getLastgetlihetime();
/*  706 */     memberInfo.gongxun = xMember.getGongxun();
/*      */     
/*  708 */     memberInfo.fight_value = fightValue;
/*      */   }
/*      */   
/*      */   static void fillGangMemberInfo(long roleId, MemberInfo memberInfo)
/*      */   {
/*  713 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/*  714 */     fillGangMemberInfo(roleId, xGangMember, memberInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncGangMemberInfoChange(long roleid, GangMember xMember, xbean.Gang xGang)
/*      */   {
/*  725 */     SSyncMemberInfoChange sync = new SSyncMemberInfoChange();
/*  726 */     fillGangMemberInfo(roleid, xMember, sync.memberinfo);
/*  727 */     broadcast(xGang, sync);
/*      */   }
/*      */   
/*      */   static void syncGangMemberInfoChange(Role role, int avatarid, int avatarFrame, int fightValue, GangMember xMember, xbean.Gang xGang)
/*      */   {
/*  732 */     SSyncMemberInfoChange sync = new SSyncMemberInfoChange();
/*  733 */     fillGangMemberInfo(role, avatarid, avatarFrame, fightValue, xMember, sync.memberinfo);
/*  734 */     broadcast(xGang, sync);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SGangDutyCfg getDutyCfg(int dutyCfgId)
/*      */   {
/*  744 */     return SGangDutyCfg.get(dutyCfgId);
/*      */   }
/*      */   
/*      */   public static SGangDutyCfg getDutyCfg(GangMember xGangMember) {
/*  748 */     return getDutyCfg(xGangMember.getDuty());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SGangDutyCfg getDutyCfgByLevel(int dutyLevel)
/*      */   {
/*  757 */     for (SGangDutyCfg cfg : SGangDutyCfg.getAll().values()) {
/*  758 */       if (cfg.dutyLevel == dutyLevel) {
/*  759 */         return cfg;
/*      */       }
/*      */     }
/*  762 */     return null;
/*      */   }
/*      */   
/*      */   private static void discountBangGong(long roleId, GangMember xMember) {
/*  766 */     setBangGongWithTlog(roleId, xMember, -xMember.getBanggong() * SGangConst.getInstance().JOIN_GANG_BANGGONG_CALC_RATE / 10000L, new TLogArg(LogReason.GANG_JOIN_GANG_CHANGE_BANGGONG), true);
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
/*      */   static boolean addToGang(Role role, int avatarid, int avatarFrame, int fightValue, GangMember xMember, long gangid, xbean.Gang xGang, long ratifier)
/*      */   {
/*  783 */     long roleid = role.getId();
/*  784 */     int roleLevel = role.getLevel();
/*      */     
/*  786 */     int duty = SGangConst.getInstance().XUETU_ID;
/*  787 */     if (roleLevel < xGang.getApprenticemaxlv())
/*      */     {
/*  789 */       if (isGangXueTuFull(xGang))
/*      */       {
/*  791 */         if (!isGangNormalFull(xGang)) {
/*  792 */           duty = SGangConst.getInstance().BANGZHONG_ID;
/*      */         }
/*      */         else {
/*  795 */           sendNormalResult(ratifier, 5, new Object[0]);
/*  796 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     else {
/*  801 */       duty = SGangConst.getInstance().BANGZHONG_ID;
/*  802 */       if (isGangNormalFull(xGang)) {
/*  803 */         sendNormalResult(ratifier, 6, new Object[0]);
/*  804 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  809 */     if (xMember == null) {
/*  810 */       xMember = Pod.newGangMember();
/*  811 */       Role2gangmember.insert(Long.valueOf(roleid), xMember);
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*  816 */     else if (xMember.getGangid() != gangid) {
/*  817 */       discountBangGong(roleid, xMember);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  822 */     joinGang(role, xMember, gangid, xGang, duty);
/*      */     
/*      */ 
/*  825 */     xMember.setJointime(DateTimeUtils.getCurrTimeInMillis());
/*      */     
/*  827 */     String gandName = xGang.getName();
/*      */     
/*      */ 
/*  830 */     NoneRealTimeTaskManager.getInstance().addTask(new PSyncGangInfo(roleid, gangid));
/*      */     
/*  832 */     syncSelfInfo(roleid, xMember);
/*      */     
/*      */ 
/*  835 */     sendMail(roleid, SGangConst.getInstance().JOIN_MAIL_ID, new TLogArg(LogReason.GANG_ADDTO_GANG_MAIL, SGangConst.getInstance().JOIN_MAIL_ID), new String[] { gandName });
/*      */     
/*      */ 
/*  838 */     SJoinGangRes res = new SJoinGangRes();
/*  839 */     res.gangname = gandName;
/*  840 */     OnlineManager.getInstance().send(roleid, res);
/*      */     
/*      */ 
/*  843 */     SSyncAddGangMember sSyncAddGangMember = new SSyncAddGangMember();
/*  844 */     fillGangMemberInfo(role, avatarid, avatarFrame, fightValue, xMember, sSyncAddGangMember.memberinfo);
/*  845 */     OnlineManager.getInstance().sendMulti(sSyncAddGangMember, getMembers(xGang));
/*      */     
/*      */ 
/*  848 */     GangArg gangArg = new GangArg();
/*  849 */     gangArg.gangId = gangid;
/*  850 */     gangArg.roleId = roleid;
/*  851 */     gangArg.extraMemberList.add(Long.valueOf(roleid));
/*  852 */     TriggerEventsManger.getInstance().triggerEvent(new JoinGang(), gangArg);
/*      */     
/*      */ 
/*  855 */     StringBuilder tLogStr = new StringBuilder();
/*  856 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(role.getUserId()).append("|").append(roleid).append("|").append(roleLevel).append("|").append(gangid).append("|").append(xGang.getDisplayid()).append("|").append(GangActionLogEnum.JIONIN);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  863 */     TLogManager.getInstance().addLog(roleid, "Gang", tLogStr.toString());
/*      */     
/*      */ 
/*  866 */     if (isGangXueTuFull(xGang)) {
/*  867 */       NoneRealTimeTaskManager.getInstance().addTask(new RCheckPromoteXueTu(gangid));
/*      */     }
/*      */     
/*      */ 
/*  871 */     GangCacheManager.addMember(gangid, role, avatarid, avatarFrame, fightValue, xMember);
/*      */     
/*  873 */     return true;
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
/*      */   static void joinGang(Role role, GangMember xMember, long gangid, xbean.Gang xGang, int duty)
/*      */   {
/*  888 */     long roleid = role.getId();
/*  889 */     xMember.setDuty(duty);
/*  890 */     xMember.setForbiddentalkend(0L);
/*  891 */     xMember.setIspassiveleaved(false);
/*      */     
/*  893 */     checkGangSign(roleid, xMember);
/*      */     
/*  895 */     xMember.setSignstr(SGangConst.getInstance().SEVER_GANG_SIGN_STR);
/*      */     
/*      */ 
/*  898 */     ForbidTalkObserver.stopObserver(roleid);
/*      */     
/*  900 */     xMember.setGangid(gangid);
/*  901 */     xMember.setIs_in_gang(true);
/*      */     
/*  903 */     addMember(xGang, roleid, duty);
/*      */     
/*      */ 
/*  906 */     syncGangQQGroup(roleid, xGang);
/*      */     
/*      */ 
/*  909 */     NoneRealTimeTaskManager.getInstance().addTask(new PClearApplyGangs(roleid));
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean promoteXueTu(Role role, GangMember xMember, long gangid, xbean.Gang xGang)
/*      */   {
/*  915 */     if (xMember.getDuty() != SGangConst.getInstance().XUETU_ID) {
/*  916 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  920 */     if (isGangNormalFull(xGang)) {
/*  921 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  925 */     changeDutyRelation(role.getId(), xMember, gangid, xGang, SGangConst.getInstance().BANGZHONG_ID, GangSystemChangeDutyActionLogEnum.XUETU_AUTO_BANGZHONG.value, 0);
/*      */     
/*  927 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean moveBetweenGangs(Role role, int avatarid, int avatarFrame, int fightValue, GangMember xMember, long srcGangid, xbean.Gang xSrcGang, GangMemoryBean xSrcGangMemory, long dstGangid, xbean.Gang xDstGang)
/*      */   {
/*  934 */     long roleid = role.getId();
/*  935 */     if (!removeMember(srcGangid, xSrcGang, xSrcGangMemory, roleid, xMember, false))
/*      */     {
/*  937 */       return false;
/*      */     }
/*      */     
/*  940 */     if (isGangNormalFull(xDstGang))
/*      */     {
/*  942 */       return false;
/*      */     }
/*      */     
/*  945 */     joinGang(role, xMember, dstGangid, xDstGang, SGangConst.getInstance().BANGZHONG_ID);
/*      */     
/*      */ 
/*  948 */     GangCacheManager.addMember(dstGangid, role, avatarid, avatarFrame, fightValue, xMember);
/*      */     
/*      */ 
/*  951 */     syncGangMemberInfoChange(roleid, xMember, xDstGang);
/*      */     
/*      */ 
/*  954 */     return true;
/*      */   }
/*      */   
/*      */   public static void sendMail(long roleId, int mailCfgId, TLogArg tLogArg, String... arg)
/*      */   {
/*  959 */     List<String> argList = new ArrayList();
/*  960 */     for (String a : arg) {
/*  961 */       argList.add(a);
/*      */     }
/*  963 */     MailInterface.asynBuildAndSendMail(roleId, mailCfgId, null, argList, null, tLogArg);
/*      */   }
/*      */   
/*      */   public static void sendMail(xbean.Gang xGang, int mailCfgId, final TLogArg tLogArg, String... arg) {
/*  967 */     final SGangMailCfg sGangMailCfg = SGangMailCfg.get(mailCfgId);
/*  968 */     final List<String> argList = new ArrayList();
/*  969 */     for (String a : arg) {
/*  970 */       argList.add(a);
/*      */     }
/*  972 */     List<Long> allMemList = new ArrayList(getMembers(xGang));
/*      */     
/*  974 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/*  978 */         for (Long roleId : this.val$allMemList) {
/*  979 */           Integer duty = Role2gangmember.selectDuty(roleId);
/*  980 */           if (duty != null)
/*      */           {
/*      */ 
/*  983 */             SGangDutyCfg dutyCfg = GangManager.getDutyCfg(duty.intValue());
/*  984 */             if ((sGangMailCfg.dutyMinLevel <= dutyCfg.dutyLevel) && (sGangMailCfg.dutyMaxLevel >= dutyCfg.dutyLevel))
/*      */             {
/*      */ 
/*  987 */               MailInterface.asynBuildAndSendMail(roleId.longValue(), sGangMailCfg.mailId, null, argList, null, tLogArg); }
/*      */           } }
/*  989 */         return true;
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
/*      */   static void onAddGang(long gangId)
/*      */   {
/* 1002 */     new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/* 1006 */         GangGlobal xGlobal = GangManager.getAndCreateXGlobal();
/* 1007 */         return xGlobal.getAllgangids().add(Long.valueOf(this.val$gangId));
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onRemoveGang(long gangId)
/*      */   {
/* 1021 */     new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/* 1025 */         GangGlobal xGlobal = GangManager.getXGlobal(true);
/* 1026 */         if (xGlobal == null) {
/* 1027 */           return false;
/*      */         }
/* 1029 */         return xGlobal.getAllgangids().remove(Long.valueOf(this.val$gangId));
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */ 
/*      */   static Set<Long> findNotFullGang()
/*      */   {
/* 1037 */     Set<Long> idSet = new HashSet();
/* 1038 */     List<Long> gangList = new ArrayList();
/* 1039 */     Set<Long> treeSet = getAllGangIdSet();
/* 1040 */     for (Long gangId : treeSet) {
/* 1041 */       xbean.Gang xGang = xtable.Gang.select(gangId);
/* 1042 */       if (xGang != null)
/*      */       {
/*      */ 
/* 1045 */         if (!isGangNormalFull(xGang))
/* 1046 */           gangList.add(gangId);
/*      */       }
/*      */     }
/* 1049 */     int limit = SGangConst.getInstance().APPLY_NUM_LIMIT;
/* 1050 */     if (gangList.size() <= limit) {
/* 1051 */       idSet.addAll(gangList);
/*      */     }
/*      */     else {
/* 1054 */       while (idSet.size() < limit)
/*      */       {
/* 1056 */         int random = Xdb.random().nextInt(gangList.size());
/* 1057 */         idSet.add(gangList.remove(random));
/*      */       }
/*      */     }
/* 1060 */     return idSet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean checkChangeDuty(xbean.Gang xGang, int oldDutyId, int newDutyId)
/*      */   {
/* 1071 */     if ((newDutyId == SGangConst.getInstance().BANGZHONG_ID) && (oldDutyId != SGangConst.getInstance().XUETU_ID) && (newDutyId != oldDutyId)) {
/* 1072 */       return true;
/*      */     }
/* 1074 */     if ((oldDutyId == SGangConst.getInstance().XUETU_ID) && 
/* 1075 */       (isGangNormalFull(xGang))) {
/* 1076 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1080 */     if (isDutyMemberFull(xGang, newDutyId)) {
/* 1081 */       return false;
/*      */     }
/* 1083 */     return true;
/*      */   }
/*      */   
/*      */   public static void fillGangAnnouncement(xbean.GangAnnouncement xGangAnnouncement, mzm.gsp.gang.GangAnnouncement gangAnnouncement)
/*      */   {
/* 1088 */     gangAnnouncement.publishtime = xGangAnnouncement.getModifytime();
/* 1089 */     gangAnnouncement.publisher = RoleInterface.getName(xGangAnnouncement.getModifierid());
/* 1090 */     gangAnnouncement.announcement = xGangAnnouncement.getAnnouncement();
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
/*      */   public static SGangMiFangToolsCfgInfo randomMiFangCfg(int yaoDianLevel)
/*      */   {
/* 1106 */     SGangMiFangToolsCfg sGangMiFangToolsCfg = SGangMiFangToolsCfg.get(yaoDianLevel);
/* 1107 */     if (sGangMiFangToolsCfg == null) {
/* 1108 */       return null;
/*      */     }
/* 1110 */     Map<Integer, SGangMiFangToolsCfgInfo> cfgList = sGangMiFangToolsCfg.mifangInfo;
/* 1111 */     if (cfgList == null) {
/* 1112 */       return null;
/*      */     }
/* 1114 */     int totalWeight = 0;
/* 1115 */     for (SGangMiFangToolsCfgInfo tmp : cfgList.values()) {
/* 1116 */       totalWeight += tmp.weight;
/*      */     }
/* 1118 */     int prop = Xdb.random().nextInt(totalWeight);
/* 1119 */     int tempWeight = 0;
/* 1120 */     for (SGangMiFangToolsCfgInfo cfg : cfgList.values()) {
/* 1121 */       tempWeight += cfg.weight;
/* 1122 */       if (tempWeight > prop) {
/* 1123 */         return cfg;
/*      */       }
/*      */     }
/* 1126 */     return null;
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
/*      */   public static int getDiffDay(long begin, long end)
/*      */   {
/* 1152 */     return DateTimeUtils.diffDays(end, begin);
/*      */   }
/*      */   
/*      */   public static int getDiffDays(long beginMillis) {
/* 1156 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1157 */     return DateTimeUtils.diffDays(nowMillis, beginMillis);
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
/*      */   public static Set<Long> getAllGangIdSet()
/*      */   {
/* 1174 */     GangGlobal xGlobal = getXGlobal(false);
/* 1175 */     if (xGlobal == null) {
/* 1176 */       return new HashSet();
/*      */     }
/* 1178 */     return xGlobal.getAllgangids();
/*      */   }
/*      */   
/*      */ 
/*      */   static void systemClearMember(long gangId, xbean.Gang xGang)
/*      */   {
/* 1184 */     if (xGang == null) {
/* 1185 */       return;
/*      */     }
/* 1187 */     for (Iterator i$ = getMembers(xGang).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 1188 */       NoneRealTimeTaskManager.getInstance().addTask(new PSystemClearGangMember(roleId, gangId));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void calcLively(xbean.Gang xGang) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void mainTainDayUpdate(long gangId, xbean.Gang xGang)
/*      */   {
/* 1205 */     if (xGang == null) {
/* 1206 */       return;
/*      */     }
/* 1208 */     xGang.setPublishtime(0);
/* 1209 */     xGang.setForbiddentalkcount(0);
/*      */     
/* 1211 */     AbsGangBuilding gangBuilding = BuildingFactory.createGangBuilding(gangId, xGang, 4);
/* 1212 */     AbsGangBuilding xiangFang = BuildingFactory.createGangBuilding(gangId, xGang, 0);
/* 1213 */     AbsGangBuilding jinKu = BuildingFactory.createGangBuilding(gangId, xGang, 2);
/* 1214 */     AbsGangBuilding cangKu = BuildingFactory.createGangBuilding(gangId, xGang, 1);
/* 1215 */     AbsGangBuilding yaoDian = BuildingFactory.createGangBuilding(gangId, xGang, 3);
/* 1216 */     AbsGangBuilding shuYuan = BuildingFactory.createGangBuilding(gangId, xGang, 5);
/*      */     
/* 1218 */     int totalCostMoney = gangBuilding.getMaintainMoney() + xiangFang.getMaintainMoney() + jinKu.getMaintainMoney() + cangKu.getMaintainMoney() + yaoDian.getMaintainMoney() + shuYuan.getMaintainMoney();
/*      */     
/* 1220 */     SSyncGangMaintain sSyncGangMaintain = new SSyncGangMaintain();
/* 1221 */     sSyncGangMaintain.costmoney = totalCostMoney;
/* 1222 */     broadcast(xGang, sSyncGangMaintain);
/*      */     
/* 1224 */     JinKu xJinKu = xGang.getJinku();
/* 1225 */     int newMoney = xJinKu.getGangmoney() - totalCostMoney;
/* 1226 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(xGang.getLevel());
/* 1227 */     xJinKu.setGangmoney(Math.max(newMoney, 0));
/* 1228 */     if (newMoney < 0) {
/* 1229 */       int oldLv = gangBuilding.getLevel();
/* 1230 */       gangBuilding.onGanglevelDown();
/*      */       
/* 1232 */       xiangFang.onGanglevelDown();
/* 1233 */       jinKu.onGanglevelDown();
/* 1234 */       cangKu.onGanglevelDown();
/* 1235 */       yaoDian.onGanglevelDown();
/* 1236 */       shuYuan.onGanglevelDown();
/*      */       
/* 1238 */       if (oldLv == gangBuilding.getLevel()) {
/* 1239 */         return;
/*      */       }
/* 1241 */       SSyncGangLevelDownDuty sSyncGangLevelDownDuty = new SSyncGangLevelDownDuty();
/* 1242 */       sSyncGangLevelDownDuty.building2level.put(Integer.valueOf(gangBuilding.buildingType), Integer.valueOf(gangBuilding.getLevel()));
/* 1243 */       sSyncGangLevelDownDuty.building2level.put(Integer.valueOf(xiangFang.buildingType), Integer.valueOf(xiangFang.getLevel()));
/* 1244 */       sSyncGangLevelDownDuty.building2level.put(Integer.valueOf(jinKu.buildingType), Integer.valueOf(jinKu.getLevel()));
/* 1245 */       sSyncGangLevelDownDuty.building2level.put(Integer.valueOf(yaoDian.buildingType), Integer.valueOf(yaoDian.getLevel()));
/* 1246 */       sSyncGangLevelDownDuty.building2level.put(Integer.valueOf(cangKu.buildingType), Integer.valueOf(cangKu.getLevel()));
/* 1247 */       sSyncGangLevelDownDuty.building2level.put(Integer.valueOf(shuYuan.buildingType), Integer.valueOf(shuYuan.getLevel()));
/* 1248 */       broadcast(xGang, sSyncGangLevelDownDuty);
/* 1249 */       return;
/*      */     }
/*      */     
/* 1252 */     if ((newMoney >= sGangLevelCfg.maintainCostMoneyPerDay) && (newMoney <= sGangLevelCfg.maintainCostMoneyPerDay)) {
/* 1253 */       sendMail(xGang, SGangConst.getInstance().NO_MORE_MONEY_WARN_MAIL_ID, new TLogArg(LogReason.GANG_MAINTIAN_NEXTTIME_MAIL, SGangConst.getInstance().NO_MORE_MONEY_WARN_MAIL_ID), new String[0]);
/*      */     }
/*      */     
/* 1256 */     logInfo("GangManager.mainTainDayUpdate@gang dayupdate maintian |bangzhuid=%d|gangid=%d", new Object[] { Long.valueOf(xGang.getBangzhuid()), Long.valueOf(gangId) });
/*      */   }
/*      */   
/*      */ 
/*      */   public static Map<Integer, String> getDutyNameByLevel(xbean.Gang xGang, int... levels)
/*      */   {
/* 1262 */     Map<Integer, String> nameMap = new HashMap();
/* 1263 */     SDesignDutyNameCfg sDesignDutyNameCfg = SDesignDutyNameCfg.get(xGang.getDesigntitlecaseid());
/* 1264 */     for (int level : levels) {
/* 1265 */       String name = (String)sDesignDutyNameCfg.dutyNameList.get(level - 1);
/* 1266 */       nameMap.put(Integer.valueOf(level), name);
/*      */     }
/* 1268 */     return nameMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int donateForBuilding(int donateLv, long roleId)
/*      */   {
/* 1280 */     SGangBuildDonateCfg sGangBuildDonateCfg = SGangBuildDonateCfg.get(donateLv);
/* 1281 */     if (sGangBuildDonateCfg == null) {
/* 1282 */       return -1;
/*      */     }
/* 1284 */     int donateMoney = sGangBuildDonateCfg.donateSilver;
/* 1285 */     int removeInterval = sGangBuildDonateCfg.removeLevelUpM;
/* 1286 */     int addBangGong = sGangBuildDonateCfg.redeemBangGong;
/*      */     
/* 1288 */     if (!RoleInterface.cutSilver(roleId, donateMoney, new TLogArg(LogReason.GANG_LEVEL_UP_DONATE_SILVER_REM))) {
/* 1289 */       return -1;
/*      */     }
/* 1291 */     GangInterface.addBangGong(roleId, addBangGong, new TLogArg(LogReason.GANG_BANGGONG_SILVER_ADD));
/* 1292 */     return removeInterval;
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
/*      */   static void fillYaoDian(YaoDian xYaoDian, YaoDianInfo yaoDianInfo)
/*      */   {
/* 1337 */     for (Map.Entry<Integer, Integer> yaoCai : xYaoDian.getYaocaimap().entrySet()) {
/* 1338 */       YaoCaiShopItem shopItem = new YaoCaiShopItem();
/* 1339 */       shopItem.itemid = ((Integer)yaoCai.getKey()).intValue();
/* 1340 */       shopItem.itemnum = ((Integer)yaoCai.getValue()).intValue();
/* 1341 */       yaoDianInfo.shopitemlist.add(shopItem);
/*      */     }
/* 1343 */     yaoDianInfo.level = xYaoDian.getLevel();
/* 1344 */     yaoDianInfo.levelupendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(xYaoDian.getLevelupendtime()));
/*      */   }
/*      */   
/*      */   static void fillCangKu(CangKu xCangKu, CangKuInfo cangKuInfo) {
/* 1348 */     cangKuInfo.avaliablefuli = xCangKu.getAvaliablefulinum();
/* 1349 */     cangKuInfo.totalfuli = xCangKu.getFulinumtotal();
/* 1350 */     cangKuInfo.avaliablelihe = xCangKu.getLihenum();
/* 1351 */     cangKuInfo.level = xCangKu.getLevel();
/* 1352 */     cangKuInfo.levelupendtime = ((int)TimeUnit.MILLISECONDS.toSeconds(xCangKu.getLevelupendtime()));
/*      */   }
/*      */   
/*      */   static void fillMiFang(MiFang xMiFang, GangMember xMember, MiFangInfo miFangInfo) {
/* 1356 */     miFangInfo.cfgid = xMiFang.getMifangcfgid();
/* 1357 */     miFangInfo.endtime = xMiFang.getMifangcfgendtime();
/* 1358 */     miFangInfo.itemlist.addAll(xMiFang.getMifangyaocailist());
/* 1359 */     miFangInfo.usecount = xMember.getMakemifangcount();
/* 1360 */     miFangInfo.totalcount = xMember.getTotalmakemifangcount();
/*      */   }
/*      */   
/*      */   static boolean isInMiFangDurationTime(long time, MiFang xMiFang) {
/* 1364 */     return (xMiFang.getMifangcfgstarttime() < time) && (time < xMiFang.getMifangcfgendtime());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void forceTransfer2GangMap(long roleid, GangMemoryBean xGangMemory, xbean.Gang xGang)
/*      */   {
/* 1375 */     long worldId = xGangMemory.getGangworldid();
/* 1376 */     int sceneId = MapInterface.getSceneInstanceId(worldId, SGangConst.getInstance().GANG_MAP, false);
/* 1377 */     if (sceneId == 0) {
/* 1378 */       sceneId = MapInterface.getSceneInstanceId(worldId, SGangConst.getInstance().GANG_MAP, true);
/* 1379 */       SSyncGangMapCreate sSyncGangMapCreate = new SSyncGangMapCreate();
/* 1380 */       sSyncGangMapCreate.sceneid = sceneId;
/* 1381 */       broadcast(xGang, sSyncGangMapCreate);
/*      */     }
/* 1383 */     MapInterface.forceTransferToScene(roleid, worldId, SGangConst.getInstance().GANG_MAP, null);
/*      */   }
/*      */   
/*      */   static void gotoGangMap(long roleId, GangMemoryBean xGangMemoryBean, xbean.Gang xGang)
/*      */   {
/* 1388 */     long worldId = xGangMemoryBean.getGangworldid();
/* 1389 */     int sceneId = MapInterface.getSceneInstanceId(worldId, SGangConst.getInstance().GANG_MAP, false);
/* 1390 */     if (sceneId == 0) {
/* 1391 */       sceneId = MapInterface.getSceneInstanceId(worldId, SGangConst.getInstance().GANG_MAP, true);
/* 1392 */       SSyncGangMapCreate sSyncGangMapCreate = new SSyncGangMapCreate();
/* 1393 */       sSyncGangMapCreate.sceneid = sceneId;
/* 1394 */       broadcast(xGang, sSyncGangMapCreate);
/*      */     }
/* 1396 */     MapInterface.transferToScene(roleId, worldId, SGangConst.getInstance().GANG_MAP);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean gotoGangMap(long roleId, boolean isRetainLock)
/*      */   {
/*      */     GangMember xGangMember;
/*      */     
/*      */     GangMember xGangMember;
/*      */     
/* 1407 */     if (isRetainLock) {
/* 1408 */       xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*      */     } else {
/* 1410 */       xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/*      */     }
/* 1412 */     if (xGangMember == null) {
/* 1413 */       return false;
/*      */     }
/*      */     xbean.Gang xGang;
/*      */     xbean.Gang xGang;
/* 1417 */     if (isRetainLock) {
/* 1418 */       xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*      */     } else {
/* 1420 */       xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/*      */     }
/* 1422 */     if (xGang == null) {
/* 1423 */       return false;
/*      */     }
/* 1425 */     if (!isInGang(xGang, roleId))
/* 1426 */       return false;
/*      */     GangMemoryBean xGangMemoryBean;
/*      */     GangMemoryBean xGangMemoryBean;
/* 1429 */     if (isRetainLock) {
/* 1430 */       xGangMemoryBean = Gangmemory.get(Long.valueOf(xGangMember.getGangid()));
/*      */     } else {
/* 1432 */       xGangMemoryBean = Gangmemory.select(Long.valueOf(xGangMember.getGangid()));
/*      */     }
/* 1434 */     gotoGangMap(roleId, xGangMemoryBean, xGang);
/* 1435 */     return true;
/*      */   }
/*      */   
/*      */   public static void sendMail(xbean.Gang xGang, int mailCfgId, final List<String> contentArgList, final List<String> titleArgList, final TLogArg arg) {
/* 1439 */     final SGangMailCfg sGangMailCfg = SGangMailCfg.get(mailCfgId);
/* 1440 */     List<Long> allMemList = new ArrayList(getMembers(xGang));
/*      */     
/* 1442 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/* 1446 */         for (Long roleId : this.val$allMemList) {
/* 1447 */           int duty = Role2gangmember.selectDuty(roleId).intValue();
/* 1448 */           SGangDutyCfg dutyCfg = GangManager.getDutyCfg(duty);
/* 1449 */           if ((sGangMailCfg.dutyMinLevel <= dutyCfg.dutyLevel) && (sGangMailCfg.dutyMaxLevel >= dutyCfg.dutyLevel))
/*      */           {
/*      */ 
/* 1452 */             MailInterface.asynBuildAndSendMail(roleId.longValue(), sGangMailCfg.mailId, titleArgList, contentArgList, arg); }
/*      */         }
/* 1454 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   static void addGangLiHe(xbean.Gang xGang, int addNum)
/*      */   {
/* 1461 */     CangKu xCangKu = xGang.getCangku();
/* 1462 */     SGangCangKuCfg cfg = SGangCangKuCfg.get(xCangKu.getLevel());
/* 1463 */     if (cfg == null) {
/* 1464 */       if (logger.isDebugEnabled()) {
/* 1465 */         logger.debug("addGangLiHe error : SGangCangKuCfg is null!");
/*      */       }
/* 1467 */       return;
/*      */     }
/* 1469 */     int totalLiHe = Math.min(addNum + xCangKu.getLihenum(), cfg.gridSize);
/* 1470 */     xCangKu.setLihenum(totalLiHe);
/* 1471 */     SSyncCangKuLiHeChange cangKuLiHeChange = new SSyncCangKuLiHeChange();
/* 1472 */     cangKuLiHeChange.lihenum = totalLiHe;
/* 1473 */     broadcast(xGang, cangKuLiHeChange);
/*      */   }
/*      */   
/*      */   static void addGangMoney(xbean.Gang xGang, int gangMoney)
/*      */   {
/* 1478 */     JinKu xJinKu = xGang.getJinku();
/* 1479 */     int newValue = xJinKu.getGangmoney() + gangMoney;
/* 1480 */     SGangJinKuCfg sGangJinKuCfg = SGangJinKuCfg.get(xJinKu.getLevel());
/* 1481 */     if (sGangJinKuCfg == null) {
/* 1482 */       if (logger.isDebugEnabled()) {
/* 1483 */         logger.debug("addGangMoney error : sGangJinKuCfg is null!");
/*      */       }
/* 1485 */       return;
/*      */     }
/* 1487 */     if (newValue > sGangJinKuCfg.gangMoneyLimit) {
/* 1488 */       newValue = sGangJinKuCfg.gangMoneyLimit;
/*      */     }
/* 1490 */     xJinKu.setGangmoney(newValue);
/*      */     
/* 1492 */     addPeriodMoney(xGang, gangMoney);
/*      */   }
/*      */   
/*      */   private static void addPeriodMoney(xbean.Gang xGang, int add) {
/* 1496 */     if (add <= 0) {
/* 1497 */       return;
/*      */     }
/* 1499 */     int old = xGang.getPeriodmoney();
/* 1500 */     int addMax = Integer.MAX_VALUE - old;
/* 1501 */     if (add > addMax) {
/* 1502 */       add = addMax;
/*      */     }
/* 1504 */     xGang.setPeriodmoney(old + add);
/*      */   }
/*      */   
/*      */   static boolean costGangMoney(xbean.Gang xGang, int gangMoney)
/*      */   {
/* 1509 */     JinKu xJinKu = xGang.getJinku();
/* 1510 */     if (xJinKu == null) {
/* 1511 */       return false;
/*      */     }
/* 1513 */     int newValue = xJinKu.getGangmoney() - gangMoney;
/* 1514 */     if (newValue < 0) {
/* 1515 */       return false;
/*      */     }
/* 1517 */     xJinKu.setGangmoney(newValue);
/* 1518 */     return true;
/*      */   }
/*      */   
/*      */   static int getGangMoney(xbean.Gang xGang) {
/* 1522 */     JinKu xJinKu = xGang.getJinku();
/* 1523 */     if (xJinKu == null) {
/* 1524 */       return -1;
/*      */     }
/* 1526 */     return xJinKu.getGangmoney();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isSellGangYaoDianItem(long roleId, int itemid)
/*      */   {
/* 1536 */     for (Map.Entry<Integer, SGangYaoDianItemList> sEntry : SGangYaoDianItemList.getAll().entrySet()) {
/* 1537 */       if (((SGangYaoDianItemList)sEntry.getValue()).itemIdList.contains(Integer.valueOf(itemid))) {
/* 1538 */         return true;
/*      */       }
/*      */     }
/* 1541 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBangGongMax()
/*      */   {
/* 1550 */     return AwardInterface.getMoneyOwnMax(4);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static ModBangGongResult setBangGongModSucRes(ModBangGongResult result, long addValue)
/*      */   {
/* 1560 */     result.setbSucceed(true);
/* 1561 */     result.setModValue(addValue);
/* 1562 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static ModBangGongResult setBangGongModErrRes(ModBangGongResult result, ModBangGongResult.ErrorResult res)
/*      */   {
/* 1572 */     result.setbSucceed(false);
/* 1573 */     result.setRes(res);
/* 1574 */     return result;
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
/*      */   static ModBangGongResult addBangGongInAll(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*      */   {
/* 1587 */     GangMember xMember = Role2gangmember.get(Long.valueOf(roleId));
/* 1588 */     return addBangGongInAll(roleId, xMember, addValue, arg, withinMax);
/*      */   }
/*      */   
/*      */   static ModBangGongResult addBangGongInAll(long roleId, GangMember xMember, long addValue, TLogArg arg, boolean withinMax)
/*      */   {
/* 1593 */     ModBangGongResult result = new ModBangGongResult();
/* 1594 */     if (addValue < 0L) {
/* 1595 */       result.setbSucceed(false);
/* 1596 */       result.setRes(ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_SIGN);
/* 1597 */       return result;
/*      */     }
/* 1599 */     if (addValue == 0L) {
/* 1600 */       return setBangGongModSucRes(result, 0L);
/*      */     }
/*      */     
/* 1603 */     if ((xMember == null) || (!xMember.getIs_in_gang())) {
/* 1604 */       return setBangGongModErrRes(result, ModBangGongResult.ErrorResult.ERROR_BANGGONG_NOT_IN_GANG);
/*      */     }
/*      */     
/* 1607 */     long gold = xMember.getBanggong();
/* 1608 */     if (Long.MAX_VALUE - gold < addValue) {
/* 1609 */       return setBangGongModErrRes(result, ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT);
/*      */     }
/*      */     
/*      */ 
/* 1613 */     long goldMax = getBangGongMax();
/* 1614 */     long diffValue = goldMax - gold;
/* 1615 */     if (withinMax) {
/* 1616 */       if (diffValue < addValue)
/*      */       {
/* 1618 */         return setBangGongModErrRes(result, ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT);
/*      */       }
/*      */     } else {
/* 1621 */       if (diffValue <= 0L) {
/* 1622 */         AwardInterface.sendNormalRet(roleId, 25, false, new String[] { AwardInterface.getMoneyNameBy(4) });
/*      */         
/*      */ 
/* 1625 */         return setBangGongModSucRes(result, 0L);
/*      */       }
/* 1627 */       if (diffValue < addValue) {
/* 1628 */         addValue = diffValue;
/*      */       }
/*      */     }
/*      */     
/* 1632 */     setBangGongWithTlog(roleId, xMember, addValue, arg, false);
/* 1633 */     return setBangGongModSucRes(result, addValue);
/*      */   }
/*      */   
/*      */   static void addItemBangGongCount(long roleid, GangMember xMember, int count)
/*      */   {
/* 1638 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1639 */     if (!DateTimeUtils.isInSameWeek(nowMillis, xMember.getItem_banggong_time())) {
/* 1640 */       xMember.setWeekitem_banggong_count(0);
/*      */     }
/* 1642 */     xMember.setWeekitem_banggong_count(xMember.getWeekitem_banggong_count() + count);
/*      */     
/*      */ 
/* 1645 */     GangCacheManager.changeMemberWeekItemContributeCount(xMember.getGangid(), roleid, xMember.getWeekitem_banggong_count(), xMember.getItem_banggong_time());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static ModBangGongResult addBangGongByItem(long roleid, GangMember xMember, int addValue, int itemCount, TLogArg tlogArg)
/*      */   {
/* 1653 */     ModBangGongResult result = addBangGongInAll(roleid, xMember, addValue, tlogArg, true);
/* 1654 */     if (result.isSucceed()) {
/* 1655 */       addItemBangGongCount(roleid, xMember, itemCount);
/*      */     }
/* 1657 */     return result;
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
/*      */   public static ModBangGongResult cutBangGongInAll(long roleId, long cutValue, TLogArg arg, boolean withinZero)
/*      */   {
/* 1671 */     ModBangGongResult result = new ModBangGongResult();
/* 1672 */     if (cutValue < 0L) {
/* 1673 */       result.setbSucceed(false);
/* 1674 */       result.setRes(ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_SIGN);
/* 1675 */       return result;
/*      */     }
/* 1677 */     if (cutValue == 0L) {
/* 1678 */       return setBangGongModSucRes(result, 0L);
/*      */     }
/*      */     
/* 1681 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 1682 */     if ((xGangMember == null) || (!xGangMember.getIs_in_gang())) {
/* 1683 */       return setBangGongModErrRes(result, ModBangGongResult.ErrorResult.ERROR_BANGGONG_NOT_IN_GANG);
/*      */     }
/*      */     
/* 1686 */     long curBangGong = xGangMember.getBanggong();
/* 1687 */     if (curBangGong > Long.MAX_VALUE) {
/* 1688 */       return setBangGongModErrRes(result, ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT);
/*      */     }
/*      */     
/* 1691 */     if (withinZero) {
/* 1692 */       if (curBangGong >= cutValue) {
/* 1693 */         AwardInterface.sendNormalRet(roleId, 25, false, new String[] { AwardInterface.getMoneyNameBy(4) });
/*      */         
/*      */ 
/* 1696 */         return setBangGongModSucRes(result, 0L);
/*      */       }
/* 1698 */       cutValue = curBangGong;
/*      */ 
/*      */     }
/* 1701 */     else if (curBangGong < cutValue) {
/* 1702 */       return setBangGongModErrRes(result, ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_LOW_LIMIT);
/*      */     }
/*      */     
/*      */ 
/* 1706 */     setBangGongWithTlog(roleId, xGangMember, -cutValue, arg, false);
/*      */     
/* 1708 */     return setBangGongModSucRes(result, cutValue);
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
/*      */   static void setBangGongWithTlog(long roleId, GangMember xGangMember, long addValue, TLogArg arg, boolean isClearHistoryBangGong)
/*      */   {
/* 1721 */     long oldBangGong = xGangMember.getBanggong();
/* 1722 */     long oldHistoryBangGong = xGangMember.getHistorybanggong();
/*      */     
/* 1724 */     xGangMember.setBanggong(xGangMember.getBanggong() + addValue);
/*      */     
/*      */ 
/* 1727 */     String userId = RoleInterface.getUserId(roleId);
/* 1728 */     int level = RoleInterface.getLevel(roleId);
/*      */     
/* 1730 */     CurrencyLogUtil.tLogCurrency(userId, roleId, CurrencyType.CURRENCY_GANG, (int)addValue, xGangMember.getBanggong(), arg);
/* 1731 */     CurrencyLogUtil.tlogMoneyFlow(userId, roleId, CurrencyType.CURRENCY_GANG, (int)addValue, xGangMember.getBanggong(), arg);
/*      */     
/* 1733 */     if (isClearHistoryBangGong) {
/* 1734 */       xGangMember.setHistorybanggong(0L);
/*      */ 
/*      */ 
/*      */     }
/* 1738 */     else if (addValue > 0L) {
/* 1739 */       xGangMember.setHistorybanggong(xGangMember.getHistorybanggong() + addValue);
/* 1740 */       addWeekBangGong(roleId, xGangMember, (int)addValue);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1745 */     tlogGangContributionChanged(userId, roleId, level, oldBangGong, xGangMember.getBanggong(), oldHistoryBangGong, xGangMember.getHistorybanggong(), arg);
/*      */     
/*      */ 
/*      */ 
/* 1749 */     GangCacheManager.changeMemberContribute(xGangMember.getGangid(), roleId, (int)xGangMember.getBanggong(), (int)xGangMember.getHistorybanggong());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1754 */     ContributionChangedArg contributionChangedArg = new ContributionChangedArg(roleId, oldBangGong, oldHistoryBangGong, xGangMember.getBanggong(), xGangMember.getHistorybanggong());
/*      */     
/*      */ 
/* 1757 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.ContributionChanged(), contributionChangedArg);
/*      */   }
/*      */   
/*      */   private static void addWeekBangGong(long roleid, GangMember xMember, int addValue)
/*      */   {
/* 1762 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/* 1764 */     if (!DateTimeUtils.isInSameWeek(nowMillis, xMember.getAddbanggong_time())) {
/* 1765 */       xMember.setWeekbanggong(0);
/*      */     }
/* 1767 */     xMember.setWeekbanggong(xMember.getWeekbanggong() + addValue);
/* 1768 */     xMember.setAddbanggong_time(nowMillis);
/*      */     
/*      */ 
/* 1771 */     GangCacheManager.changeMemberWeekContribute(xMember.getGangid(), roleid, xMember.getWeekbanggong(), nowMillis);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getCanGangSign(long roleId, GangMember xGangMember)
/*      */   {
/* 1781 */     int sign = checkGangSign(roleId, xGangMember);
/* 1782 */     if (sign == 0)
/* 1783 */       return true;
/* 1784 */     if (sign == 1)
/*      */     {
/* 1786 */       return false;
/*      */     }
/* 1788 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int checkGangSign(long roleId, GangMember xGangMember)
/*      */   {
/* 1796 */     if (xGangMember == null) {
/* 1797 */       return 0;
/*      */     }
/* 1799 */     if (xGangMember.getIssign() == 1) {
/* 1800 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1801 */       if ((!mzm.gsp.util.DateTimeManager.isInSameDay(xGangMember.getSigntime(), curTime)) && (curTime > xGangMember.getSigntime())) {
/* 1802 */         xGangMember.setIssign(0);
/* 1803 */         xGangMember.setSigntime(0L);
/* 1804 */         return 0;
/*      */       }
/*      */     }
/* 1807 */     return xGangMember.getIssign();
/*      */   }
/*      */   
/*      */   static Set<Long> getMembers(xbean.Gang xGang)
/*      */   {
/* 1812 */     Set<Long> members = new HashSet();
/* 1813 */     if (xGang != null) {
/* 1814 */       for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 1815 */         members.addAll(xMembers.getMembers());
/*      */       }
/*      */     }
/* 1818 */     return members;
/*      */   }
/*      */   
/*      */   static void broadcast(xbean.Gang xGang, Protocol p) {
/* 1822 */     OnlineManager.getInstance().sendMulti(p, getMembers(xGang));
/*      */   }
/*      */   
/*      */   static boolean isInGang(xbean.Gang xGang, long roleid) {
/* 1826 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 1827 */       if (xMembers.getMembers().contains(Long.valueOf(roleid))) {
/* 1828 */         return true;
/*      */       }
/*      */     }
/* 1831 */     return false;
/*      */   }
/*      */   
/*      */   static boolean isInGang(xbean.Gang xGang, long roleid, int duty) {
/* 1835 */     GangDutyMembers xMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(duty));
/* 1836 */     if (xMembers == null) {
/* 1837 */       return false;
/*      */     }
/* 1839 */     return xMembers.getMembers().contains(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   static int getMemberSize(xbean.Gang xGang)
/*      */   {
/* 1844 */     int size = 0;
/* 1845 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 1846 */       size += xMembers.getMembers().size();
/*      */     }
/* 1848 */     return size;
/*      */   }
/*      */   
/*      */   static void addMember(xbean.Gang xGang, long roleid, int duty) {
/* 1852 */     GangDutyMembers xMembers = getAndCreateDutyMembers(xGang, duty);
/* 1853 */     xMembers.getMembers().add(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   static boolean removeMember(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, long roleid, GangMember xMember, boolean bLeaveGangTeam)
/*      */   {
/* 1858 */     GangDutyMembers xMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(xMember.getDuty()));
/* 1859 */     if (xMembers == null) {
/* 1860 */       return false;
/*      */     }
/* 1862 */     boolean ret = xMembers.getMembers().remove(Long.valueOf(roleid));
/*      */     
/* 1864 */     if (ret)
/*      */     {
/* 1866 */       GangCacheManager.removeMember(gangid, roleid);
/* 1867 */       if (bLeaveGangTeam) {
/* 1868 */         xMember.setIs_in_gang(false);
/*      */         
/* 1870 */         removeGangTeamMemberByLeaveGang(gangid, xGang, xGangMemory, roleid);
/*      */       }
/*      */     }
/*      */     
/* 1874 */     return ret;
/*      */   }
/*      */   
/*      */   static void clearMembers(xbean.Gang xGang) {
/* 1878 */     xGang.getDuty2members().clear();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillApplicantBean(GangApply xApply, Applicant applicant)
/*      */   {
/* 1887 */     applicant.roleid = xApply.getRoleid();
/* 1888 */     Role role = RoleInterface.getRole(xApply.getRoleid(), false);
/* 1889 */     if (role == null) {
/* 1890 */       return;
/*      */     }
/* 1892 */     applicant.name = role.getName();
/* 1893 */     applicant.level = role.getLevel();
/* 1894 */     applicant.occupationid = role.getOccupationId();
/* 1895 */     applicant.gender = role.getGender();
/*      */     
/* 1897 */     applicant.avatarid = AvatarInterface.getCurrentAvatar(xApply.getRoleid());
/* 1898 */     applicant.avatar_frame = AvatarFrameInterface.getCurrentAvatarFrameId(xApply.getRoleid(), false);
/* 1899 */     applicant.time = xApply.getTimestamp();
/* 1900 */     if (xApply.getInviterid() > 0L) {
/* 1901 */       applicant.invitername = RoleInterface.getName(xApply.getInviterid());
/*      */     }
/*      */   }
/*      */   
/*      */   static Applicant getApplicantBean(GangApply xApply) {
/* 1906 */     Applicant applicant = new Applicant();
/* 1907 */     fillApplicantBean(xApply, applicant);
/* 1908 */     return applicant;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncApplicants(GangMemoryBean xGangMemory, long roleid)
/*      */   {
/* 1918 */     SSyncApplicants sync = new SSyncApplicants();
/* 1919 */     for (GangApply xApply : xGangMemory.getApplylist()) {
/* 1920 */       sync.applicants.add(getApplicantBean(xApply));
/*      */     }
/* 1922 */     OnlineManager.getInstance().send(roleid, sync);
/*      */   }
/*      */   
/*      */   static void asyncApplicants(long roleid, long gangid) {
/* 1926 */     Procedure.execute(new PSyncApplicants(roleid, gangid));
/*      */   }
/*      */   
/*      */   static boolean hasAppliedGang(RoleApplyGang xApplyGang, long gangid)
/*      */   {
/* 1931 */     return xApplyGang.getGangs().contains(Long.valueOf(gangid));
/*      */   }
/*      */   
/*      */   static boolean addApplicantAndBroadcast(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, long roleid, long inviter)
/*      */   {
/* 1936 */     for (GangApply xGangApply : xGangMemory.getApplylist()) {
/* 1937 */       if (xGangApply.getRoleid() == roleid) {
/* 1938 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1942 */     GangApply xApply = Pod.newGangApply();
/* 1943 */     xApply.setRoleid(roleid);
/* 1944 */     xApply.setInviterid(inviter);
/* 1945 */     xApply.setTimestamp(DateTimeUtils.getCurrTimeInMillis());
/* 1946 */     xGangMemory.getApplylist().add(xApply);
/*      */     
/* 1948 */     new ApplyObserver(gangid, roleid);
/* 1949 */     if (xGangMemory.getApplylist().size() > SGangConst.getInstance().GANG_APPLY_LIST_NUM_LIMIT) {
/* 1950 */       GangApply xOldApply = (GangApply)xGangMemory.getApplylist().remove(0);
/* 1951 */       ApplyObserver.removeObserver(gangid, xOldApply.getRoleid());
/*      */       
/* 1953 */       SRemoveApplicantBrd removeBrd = new SRemoveApplicantBrd();
/* 1954 */       removeBrd.roleid = xOldApply.getRoleid();
/* 1955 */       notifyApplicantChange(xGang, removeBrd);
/*      */     }
/*      */     
/* 1958 */     SAddApplicantBrd addBrd = new SAddApplicantBrd();
/* 1959 */     fillApplicantBean(xApply, addBrd.applicant);
/* 1960 */     notifyApplicantChange(xGang, addBrd);
/*      */     
/* 1962 */     return true;
/*      */   }
/*      */   
/*      */   static boolean addApplyGang(RoleApplyGang xApplyGang, long gangid) {
/* 1966 */     if (xApplyGang == null) {
/* 1967 */       return false;
/*      */     }
/* 1969 */     return xApplyGang.getGangs().add(Long.valueOf(gangid));
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean addApplyRelationAndBroadcast(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, long roleid, RoleApplyGang xApplyGang, long inviter)
/*      */   {
/* 1975 */     boolean ret = addApplicantAndBroadcast(gangid, xGang, xGangMemory, roleid, inviter);
/* 1976 */     if (ret) {
/* 1977 */       addApplyGang(xApplyGang, gangid);
/*      */     }
/* 1979 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean removeApplicant(GangMemoryBean xMemory, long roleid)
/*      */   {
/* 1985 */     boolean ret = false;
/* 1986 */     if (xMemory != null) {
/* 1987 */       Iterator<GangApply> iter = xMemory.getApplylist().iterator();
/* 1988 */       while (iter.hasNext()) {
/* 1989 */         GangApply xApply = (GangApply)iter.next();
/* 1990 */         if (xApply.getRoleid() == roleid) {
/* 1991 */           ret = true;
/* 1992 */           iter.remove();
/* 1993 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1998 */     return ret;
/*      */   }
/*      */   
/*      */   static boolean removeApplicantAndBroadcast(xbean.Gang xGang, GangMemoryBean xMemory, long roleid) {
/* 2002 */     boolean ret = removeApplicant(xMemory, roleid);
/* 2003 */     if (ret) {
/* 2004 */       SRemoveApplicantBrd removeBrd = new SRemoveApplicantBrd();
/* 2005 */       removeBrd.roleid = roleid;
/* 2006 */       notifyApplicantChange(xGang, removeBrd);
/*      */     }
/* 2008 */     return ret;
/*      */   }
/*      */   
/*      */   static boolean removeApplyGang(long roleid, RoleApplyGang xRoleApplyGang, long gangid) {
/* 2012 */     boolean ret = false;
/* 2013 */     if (xRoleApplyGang != null) {
/* 2014 */       ret = xRoleApplyGang.getGangs().remove(Long.valueOf(gangid));
/* 2015 */       if (xRoleApplyGang.getGangs().isEmpty()) {
/* 2016 */         Roleapplygang.remove(Long.valueOf(roleid));
/*      */       }
/*      */     }
/* 2019 */     return ret;
/*      */   }
/*      */   
/*      */   static boolean removeApplyRelationAndBroadcast(long roleid, RoleApplyGang xRoleApplyGang, long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory)
/*      */   {
/* 2024 */     boolean ret = removeApplicantAndBroadcast(xGang, xGangMemory, roleid);
/* 2025 */     removeApplyGang(roleid, xRoleApplyGang, gangid);
/* 2026 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void notifyApplicantChange(xbean.Gang xGang, Protocol protocol)
/*      */   {
/* 2036 */     Set<Integer> duties = GangConfigManager.getInstance().getManageApplicantsDuties();
/* 2037 */     Set<Long> managers = new HashSet();
/* 2038 */     for (Iterator i$ = duties.iterator(); i$.hasNext();) { int duty = ((Integer)i$.next()).intValue();
/* 2039 */       GangDutyMembers xMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(duty));
/* 2040 */       if (xMembers != null) {
/* 2041 */         managers.addAll(xMembers.getMembers());
/*      */       }
/*      */     }
/* 2044 */     OnlineManager.getInstance().sendMulti(protocol, managers);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBangZhuId(long roleId)
/*      */   {
/* 2054 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 2055 */     if (xGangMember == null) {
/* 2056 */       return -1L;
/*      */     }
/* 2058 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/* 2059 */     if (xGang == null) {
/* 2060 */       return -1L;
/*      */     }
/* 2062 */     return xGang.getBangzhuid();
/*      */   }
/*      */   
/*      */   static int getDutyMemberCount(xbean.Gang xGang, int duty)
/*      */   {
/* 2067 */     GangDutyMembers xMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(duty));
/* 2068 */     if (xMembers == null) {
/* 2069 */       return 0;
/*      */     }
/*      */     
/* 2072 */     return xMembers.getMembers().size();
/*      */   }
/*      */   
/*      */   static void changeDuty(xbean.Gang xGang, long roleid, int oldDuty, int newDuty)
/*      */   {
/* 2077 */     GangDutyMembers xOldMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(oldDuty));
/* 2078 */     xOldMembers.getMembers().remove(Long.valueOf(roleid));
/* 2079 */     GangDutyMembers xNewMembers = getAndCreateDutyMembers(xGang, newDuty);
/* 2080 */     xNewMembers.getMembers().add(Long.valueOf(roleid));
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
/*      */   static void changeDutyRelation(long roleid, GangMember xMember, long gangid, xbean.Gang xGang, int newDuty, long operator, int operatorDutyId)
/*      */   {
/* 2094 */     int oldDuty = xMember.getDuty();
/* 2095 */     changeDuty(xGang, roleid, oldDuty, newDuty);
/* 2096 */     xMember.setDuty(newDuty);
/*      */     
/*      */ 
/* 2099 */     SSyncMemberInfoChange sSyncMemberInfoChange = new SSyncMemberInfoChange();
/* 2100 */     fillGangMemberInfo(roleid, xMember, sSyncMemberInfoChange.memberinfo);
/* 2101 */     broadcast(xGang, sSyncMemberInfoChange);
/*      */     
/*      */ 
/* 2104 */     StringBuilder tLogStr = new StringBuilder();
/* 2105 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleid)).append("|").append(roleid).append("|").append(operatorDutyId).append("|").append(xMember.getGangid()).append("|").append(operator).append("|").append(oldDuty).append("|").append(newDuty).append("|").append(xGang.getDisplayid());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2114 */     TLogManager.getInstance().addLog(roleid, "GangChangeDuty", tLogStr.toString());
/*      */     
/*      */ 
/* 2117 */     GangCacheManager.changeMemberDuty(gangid, roleid, newDuty);
/*      */   }
/*      */   
/*      */   static GangDutyMembers getAndCreateDutyMembers(xbean.Gang xGang, int duty) {
/* 2121 */     GangDutyMembers xMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(duty));
/* 2122 */     if (xMembers == null) {
/* 2123 */       xMembers = Pod.newGangDutyMembers();
/* 2124 */       xGang.getDuty2members().put(Integer.valueOf(duty), xMembers);
/*      */     }
/* 2126 */     return xMembers;
/*      */   }
/*      */   
/*      */   static int getNormalMemberCount(xbean.Gang xGang) {
/* 2130 */     Set<Integer> normalDuties = GangConfigManager.getInstance().getNormalDuties();
/* 2131 */     int count = 0;
/* 2132 */     for (Iterator i$ = normalDuties.iterator(); i$.hasNext();) { int duty = ((Integer)i$.next()).intValue();
/* 2133 */       count += getDutyMemberCount(xGang, duty);
/*      */     }
/* 2135 */     return count;
/*      */   }
/*      */   
/*      */   static int getNormalMemberCapacity(xbean.Gang xGang) {
/* 2139 */     int normalCapacity = GangConfigManager.getInstance().getNormalMemberCapacity(xGang.getXiangfang().getLevel());
/* 2140 */     return normalCapacity;
/*      */   }
/*      */   
/*      */   static int getXueTuCount(xbean.Gang xGang) {
/* 2144 */     return getDutyMemberCount(xGang, SGangConst.getInstance().XUETU_ID);
/*      */   }
/*      */   
/*      */   static int getTotalMemberCount(xbean.Gang xGang) {
/* 2148 */     int count = 0;
/* 2149 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 2150 */       count += xMembers.getMembers().size();
/*      */     }
/* 2152 */     return count;
/*      */   }
/*      */   
/*      */   static boolean isGangFull(xbean.Gang xGang) {
/* 2156 */     int capacity = getNormalMemberCapacity(xGang);
/* 2157 */     int memberCount = getTotalMemberCount(xGang);
/* 2158 */     return memberCount >= capacity;
/*      */   }
/*      */   
/*      */   static boolean isGangNormalFull(xbean.Gang xGang) {
/* 2162 */     int normalCapacity = GangConfigManager.getInstance().getNormalMemberCapacity(xGang.getXiangfang().getLevel());
/* 2163 */     int normalCount = getNormalMemberCount(xGang);
/* 2164 */     return normalCount >= normalCapacity;
/*      */   }
/*      */   
/*      */   static boolean isGangXueTuFull(xbean.Gang xGang) {
/* 2168 */     int xueTuCapacity = GangConfigManager.getInstance().getXueTuCapacity(xGang.getXiangfang().getLevel());
/* 2169 */     int xueTuCount = getXueTuCount(xGang);
/* 2170 */     return xueTuCount >= xueTuCapacity;
/*      */   }
/*      */   
/*      */   static boolean isDutyMemberFull(xbean.Gang xGang, int duty) {
/* 2174 */     int dutyCapacity = GangConfigManager.getInstance().getDutyCapacity(xGang.getXiangfang().getLevel(), duty);
/* 2175 */     int dutyCount = getDutyMemberCount(xGang, duty);
/* 2176 */     return dutyCount >= dutyCapacity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addGongXun(long gangid, xbean.Gang xGang, long roleId, GangMember xMember, int addValue)
/*      */   {
/* 2187 */     if ((xGang == null) || (xMember == null)) {
/* 2188 */       return false;
/*      */     }
/* 2190 */     if (!isInGang(xGang, roleId)) {
/* 2191 */       return false;
/*      */     }
/*      */     
/* 2194 */     if (addValue <= 0) {
/* 2195 */       return false;
/*      */     }
/*      */     
/* 2198 */     int old = xMember.getGongxun();
/* 2199 */     if (!DateTimeUtils.isInThisWeek(xMember.getGongxun_timestamp()))
/*      */     {
/* 2201 */       old = 0;
/*      */     }
/*      */     
/* 2204 */     int max = Integer.MAX_VALUE - old;
/* 2205 */     addValue = Math.min(max, addValue);
/* 2206 */     int newGongXun = old + addValue;
/* 2207 */     xMember.setGongxun(newGongXun);
/*      */     
/* 2209 */     xMember.setGongxun_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*      */     
/*      */ 
/* 2212 */     broadcastMemberGongXun(xGang, roleId, xMember.getGongxun());
/*      */     
/*      */ 
/* 2215 */     GangCacheManager.setMemberGongXun(gangid, roleId, newGongXun);
/*      */     
/* 2217 */     return true;
/*      */   }
/*      */   
/*      */   static void checkAndCleanGongXun(long roleid, GangMember xMember)
/*      */   {
/* 2222 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 2223 */     if (!DateTimeUtils.isInSameWeek(now, xMember.getGongxun_timestamp()))
/*      */     {
/* 2225 */       xMember.setGongxun(0);
/* 2226 */       xMember.setGongxun_timestamp(now);
/*      */       
/*      */ 
/* 2229 */       GangCacheManager.setMemberGongXun(xMember.getGangid(), roleid, 0);
/*      */     }
/*      */   }
/*      */   
/*      */   static void broadcastMemberGongXun(xbean.Gang xGang, long roleid, int gongXun)
/*      */   {
/* 2235 */     mzm.gsp.gang.SSyncMemberGongXunBrd brd = new mzm.gsp.gang.SSyncMemberGongXunBrd();
/* 2236 */     brd.memberid = roleid;
/* 2237 */     brd.gongxun = gongXun;
/* 2238 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillCombineGangBean(long gangid, xbean.Gang xGang, CombineGang gangBean)
/*      */   {
/* 2248 */     gangBean.gangid = gangid;
/* 2249 */     gangBean.name = xGang.getName();
/* 2250 */     gangBean.level = xGang.getLevel();
/* 2251 */     gangBean.normal_num = getNormalMemberCount(xGang);
/* 2252 */     gangBean.normal_capacity = getNormalMemberCapacity(xGang);
/* 2253 */     gangBean.vitality = xGang.getVitality();
/* 2254 */     gangBean.purpose = xGang.getPurpose();
/* 2255 */     long leaderid = xGang.getBangzhuid();
/* 2256 */     gangBean.leader_id = leaderid;
/* 2257 */     Role role = RoleInterface.getRole(leaderid, false);
/* 2258 */     gangBean.leader_name = role.getName();
/* 2259 */     gangBean.leader_level = role.getLevel();
/* 2260 */     gangBean.leader_menpai = role.getOccupationId();
/* 2261 */     gangBean.leader_gender = role.getGender();
/* 2262 */     gangBean.leader_avatarid = AvatarInterface.getCurrentAvatar(leaderid, false);
/* 2263 */     gangBean.leader_avatar_frame = AvatarFrameInterface.getCurrentAvatarFrameId(leaderid, false);
/* 2264 */     gangBean.displayid = xGang.getDisplayid();
/*      */   }
/*      */   
/*      */   static CombineGang getCombineGangBean(long gangid, xbean.Gang xGang) {
/* 2268 */     CombineGang gangBean = new CombineGang();
/* 2269 */     fillCombineGangBean(gangid, xGang, gangBean);
/* 2270 */     return gangBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCombineValidCount(xbean.Gang xGang)
/*      */   {
/* 2281 */     int count = 0;
/* 2282 */     for (Map.Entry<Integer, GangDutyMembers> entry : xGang.getDuty2members().entrySet()) {
/* 2283 */       int duty = ((Integer)entry.getKey()).intValue();
/* 2284 */       GangDutyMembers xMembers = (GangDutyMembers)entry.getValue();
/*      */       
/* 2286 */       if (duty != SGangConst.getInstance().XUETU_ID)
/*      */       {
/*      */ 
/* 2289 */         if (duty != SGangConst.getInstance().BANGZHONG_ID) {
/* 2290 */           count += xMembers.getMembers().size();
/*      */         }
/*      */         else {
/* 2293 */           for (i$ = xMembers.getMembers().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 2294 */             if (filterCombineMember(r))
/* 2295 */               count++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2301 */     return count;
/*      */   }
/*      */   
/*      */   static LinkedList<Long> getCombineValidMembers(xbean.Gang xGang)
/*      */   {
/* 2306 */     LinkedList<Long> members = new LinkedList();
/*      */     
/* 2308 */     for (Map.Entry<Integer, GangDutyMembers> entry : xGang.getDuty2members().entrySet()) {
/* 2309 */       int duty = ((Integer)entry.getKey()).intValue();
/* 2310 */       GangDutyMembers xMembers = (GangDutyMembers)entry.getValue();
/*      */       
/* 2312 */       if (duty != SGangConst.getInstance().XUETU_ID)
/*      */       {
/*      */ 
/* 2315 */         if (duty != SGangConst.getInstance().BANGZHONG_ID) {
/* 2316 */           members.addAll(xMembers.getMembers());
/*      */         }
/*      */         else {
/* 2319 */           for (i$ = xMembers.getMembers().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 2320 */             if (filterCombineMember(r))
/* 2321 */               members.add(Long.valueOf(r));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2327 */     return members;
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
/*      */   static int fillCombineMembers(xbean.Gang xGang, LinkedList<Long> validMembers, LinkedList<Long> invalidMembers, boolean isXuetuValid)
/*      */   {
/* 2342 */     int normalCount = 0;
/* 2343 */     for (Map.Entry<Integer, GangDutyMembers> entry : xGang.getDuty2members().entrySet()) {
/* 2344 */       int duty = ((Integer)entry.getKey()).intValue();
/* 2345 */       GangDutyMembers xMembers = (GangDutyMembers)entry.getValue();
/*      */       
/* 2347 */       if (duty == SGangConst.getInstance().XUETU_ID) {
/* 2348 */         if (isXuetuValid) {
/* 2349 */           validMembers.addAll(xMembers.getMembers());
/*      */         }
/*      */         else {
/* 2352 */           invalidMembers.addAll(xMembers.getMembers());
/*      */         }
/*      */       }
/* 2355 */       else if (duty != SGangConst.getInstance().BANGZHONG_ID) {
/* 2356 */         validMembers.addAll(xMembers.getMembers());
/* 2357 */         normalCount += xMembers.getMembers().size();
/*      */       }
/*      */       else {
/* 2360 */         for (i$ = xMembers.getMembers().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 2361 */           if (filterCombineMember(r)) {
/* 2362 */             validMembers.add(Long.valueOf(r));
/* 2363 */             normalCount++;
/*      */           }
/*      */           else {
/* 2366 */             invalidMembers.add(Long.valueOf(r));
/*      */           }
/*      */         }
/*      */       } }
/*      */     Iterator i$;
/* 2371 */     return normalCount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean filterCombineMember(long roleid)
/*      */   {
/* 2383 */     if (OnlineManager.getInstance().isOnline(roleid)) {
/* 2384 */       return true;
/*      */     }
/* 2386 */     long offlineTimestamp = RoleInterface.getLastLogoffTime(roleid);
/* 2387 */     long onlineTimestamp = RoleInterface.getLastLoginTime(roleid);
/* 2388 */     long last = Math.max(offlineTimestamp, onlineTimestamp);
/* 2389 */     int offlineDays = DateTimeUtils.diffDays(DateTimeUtils.getCurrTimeInMillis(), last);
/* 2390 */     if (offlineDays < SGangConst.getInstance().COMBINE_CLEAN_OFFLINE_DAYS) {
/* 2391 */       return true;
/*      */     }
/* 2393 */     return false;
/*      */   }
/*      */   
/*      */   static boolean checkCombineVitality(xbean.Gang xGang) {
/* 2397 */     return checkCombineVitality(xGang.getVitality());
/*      */   }
/*      */   
/*      */   static boolean checkCombineVitality(int vitality) {
/* 2401 */     return vitality <= SGangConst.getInstance().COMBINE_VITALITY;
/*      */   }
/*      */   
/*      */   static boolean checkGangCanCombine(long gangid, xbean.Gang xGang, GangCombine xCombine, GangGlobal xGlobal)
/*      */   {
/* 2406 */     if (!checkCombineVitality(xGang)) {
/* 2407 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 2411 */     if (isCombining(gangid, xCombine, xGlobal)) {
/* 2412 */       return false;
/*      */     }
/*      */     
/* 2415 */     return true;
/*      */   }
/*      */   
/*      */   static boolean canCombine(long mainGangid, xbean.Gang xMainGang, GangCombine xMainCombine, long viceGangid, xbean.Gang xViceGang, GangCombine xViceCombine, GangGlobal xGlobal)
/*      */   {
/* 2420 */     if (!checkGangCanCombine(mainGangid, xMainGang, xMainCombine, xGlobal)) {
/* 2421 */       return false;
/*      */     }
/* 2423 */     if (!checkGangCanCombine(viceGangid, xViceGang, xViceCombine, xGlobal)) {
/* 2424 */       return false;
/*      */     }
/* 2426 */     if (!checkCombineGangsMemberCount(xMainGang, xViceGang)) {
/* 2427 */       return false;
/*      */     }
/* 2429 */     return true;
/*      */   }
/*      */   
/*      */   static boolean checkCombineGangsMemberCount(xbean.Gang xMainGang, xbean.Gang xViceGang)
/*      */   {
/* 2434 */     int applyCount = getCombineValidCount(xViceGang);
/* 2435 */     int targetCount = getCombineValidCount(xMainGang);
/* 2436 */     int targetCapacity = getNormalMemberCapacity(xMainGang);
/*      */     
/* 2438 */     return applyCount + targetCount <= targetCapacity;
/*      */   }
/*      */   
/*      */   static Long getGangidByRole(long roleid) {
/* 2442 */     Long gangid = Role2gangmember.selectGangid(Long.valueOf(roleid));
/* 2443 */     return gangid;
/*      */   }
/*      */   
/*      */   static xbean.Gang getXGang(long gangid, boolean remainLock)
/*      */   {
/* 2448 */     xbean.Gang xGang = null;
/* 2449 */     if (remainLock) {
/* 2450 */       xGang = xtable.Gang.get(Long.valueOf(gangid));
/*      */     }
/*      */     else {
/* 2453 */       xGang = xtable.Gang.select(Long.valueOf(gangid));
/*      */     }
/* 2455 */     return xGang;
/*      */   }
/*      */   
/*      */   static GangMemoryBean getXGangMemory(long gangid, boolean remainLock) {
/* 2459 */     GangMemoryBean xGangMemory = null;
/* 2460 */     if (remainLock) {
/* 2461 */       xGangMemory = Gangmemory.get(Long.valueOf(gangid));
/*      */     }
/*      */     else {
/* 2464 */       xGangMemory = Gangmemory.select(Long.valueOf(gangid));
/*      */     }
/* 2466 */     return xGangMemory;
/*      */   }
/*      */   
/*      */   static GangMemoryBean getAndCreateXGangMemory(long gangid) {
/* 2470 */     GangMemoryBean xGangMemory = Gangmemory.get(Long.valueOf(gangid));
/* 2471 */     if (xGangMemory == null) {
/* 2472 */       xGangMemory = Pod.newGangMemoryBean();
/* 2473 */       Gangmemory.insert(Long.valueOf(gangid), xGangMemory);
/*      */     }
/* 2475 */     return xGangMemory;
/*      */   }
/*      */   
/*      */   static xbean.Gang getXGangByRoleid(long roleid, boolean remainLock) {
/* 2479 */     Long gangid = getGangidByRole(roleid);
/* 2480 */     if (gangid == null) {
/* 2481 */       return null;
/*      */     }
/* 2483 */     xbean.Gang xGang = getXGang(gangid.longValue(), remainLock);
/* 2484 */     if (xGang == null) {
/* 2485 */       return null;
/*      */     }
/* 2487 */     if (isInGang(xGang, roleid)) {
/* 2488 */       return xGang;
/*      */     }
/*      */     
/* 2491 */     return null;
/*      */   }
/*      */   
/*      */   static GangMember getXGangMember(long roleid, boolean remainLock)
/*      */   {
/* 2496 */     GangMember xMember = null;
/* 2497 */     if (remainLock) {
/* 2498 */       xMember = Role2gangmember.get(Long.valueOf(roleid));
/*      */     }
/*      */     else {
/* 2501 */       xMember = Role2gangmember.select(Long.valueOf(roleid));
/*      */     }
/* 2503 */     return xMember;
/*      */   }
/*      */   
/*      */   static GangCombine getXCombine(long gangid, boolean remainLock)
/*      */   {
/* 2508 */     GangCombine xCombine = null;
/* 2509 */     if (remainLock) {
/* 2510 */       xCombine = Gangcombine.get(Long.valueOf(gangid));
/*      */     }
/*      */     else {
/* 2513 */       xCombine = Gangcombine.select(Long.valueOf(gangid));
/*      */     }
/* 2515 */     return xCombine;
/*      */   }
/*      */   
/*      */   static GangCombine getAndCreateXCombine(long gangid) {
/* 2519 */     GangCombine xCombine = Gangcombine.get(Long.valueOf(gangid));
/* 2520 */     if (xCombine == null) {
/* 2521 */       xCombine = Pod.newGangCombine();
/* 2522 */       Gangcombine.insert(Long.valueOf(gangid), xCombine);
/*      */     }
/* 2524 */     return xCombine;
/*      */   }
/*      */   
/*      */   static boolean isLeader(xbean.Gang xGang, long roleid)
/*      */   {
/* 2529 */     if (xGang == null) {
/* 2530 */       return false;
/*      */     }
/* 2532 */     return xGang.getBangzhuid() == roleid;
/*      */   }
/*      */   
/*      */   static long getLeaderid(xbean.Gang xGang) {
/* 2536 */     if (xGang == null) {
/* 2537 */       return -1L;
/*      */     }
/* 2539 */     return xGang.getBangzhuid();
/*      */   }
/*      */   
/*      */   static boolean isCombiningOrApplyCombine(GangCombine xCombine)
/*      */   {
/* 2544 */     if (xCombine == null) {
/* 2545 */       return false;
/*      */     }
/* 2547 */     return xCombine.getGangid() > 0L;
/*      */   }
/*      */   
/*      */   static boolean isCombining(long gangid, GangCombine xCombine, GangGlobal xGlobal) {
/* 2551 */     if ((xCombine == null) || (xGlobal == null) || (xCombine.getGangid() <= 0L)) {
/* 2552 */       return false;
/*      */     }
/* 2554 */     if (xCombine.getApplicants().contains(Long.valueOf(xCombine.getGangid())))
/*      */     {
/* 2556 */       return true;
/*      */     }
/*      */     
/* 2559 */     CombiningGangsKey cCombineKey = getCCombineKey(xCombine.getGangid(), gangid);
/* 2560 */     CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().get(cCombineKey);
/* 2561 */     if (xInfo == null) {
/* 2562 */       return false;
/*      */     }
/* 2564 */     return xInfo.getIscombining();
/*      */   }
/*      */   
/*      */   static boolean hasCombineApplicant(GangCombine xCombine, long applyGangid)
/*      */   {
/* 2569 */     return xCombine.getApplicants().contains(Long.valueOf(applyGangid));
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean applyCombine(long srcGangid, GangCombine xSrcCombine, long targetGangid, GangCombine xTargetCombine, GangGlobal xGlobal)
/*      */   {
/* 2575 */     if ((xSrcCombine == null) || (xTargetCombine == null) || (xGlobal == null)) {
/* 2576 */       return false;
/*      */     }
/*      */     
/* 2579 */     if (xSrcCombine.getGangid() > 0L) {
/* 2580 */       return false;
/*      */     }
/*      */     
/* 2583 */     xSrcCombine.setGangid(targetGangid);
/* 2584 */     xTargetCombine.getApplicants().add(Long.valueOf(srcGangid));
/*      */     
/* 2586 */     CombiningGangsKey cCombineKey = getCCombineKey(targetGangid, srcGangid);
/* 2587 */     CombineGangsInfo xInfo = Pod.newCombineGangsInfo();
/* 2588 */     xInfo.setIscombining(false);
/* 2589 */     xInfo.setTimestamp(DateTimeUtils.getCurrTimeInMillis() + TimeUnit.HOURS.toMillis(SGangConst.getInstance().COMBINE_APPLY_HOURS));
/*      */     
/* 2591 */     xGlobal.getCombine().put(cCombineKey, xInfo);
/*      */     
/*      */ 
/* 2594 */     startApplyCombineSession(cCombineKey, (int)TimeUnit.SECONDS.convert(SGangConst.getInstance().COMBINE_APPLY_HOURS, TimeUnit.HOURS));
/*      */     
/*      */ 
/* 2597 */     return true;
/*      */   }
/*      */   
/*      */   static void startApplyCombineSession(CombiningGangsKey cCombineKey, int seconds) {
/* 2601 */     ApplyCombineSession session = new ApplyCombineSession(seconds, cCombineKey.getBehind(), cCombineKey.getFront());
/* 2602 */     CombineSessionManager.getInstance().put(cCombineKey, session.getSessionId());
/*      */   }
/*      */   
/*      */   static CombiningGangsKey getCCombineKey(long mainGangid, long viceGangid)
/*      */   {
/* 2607 */     if ((mainGangid < 0L) || (viceGangid < 0L)) {
/* 2608 */       return null;
/*      */     }
/* 2610 */     return new CombiningGangsKey(mainGangid, viceGangid);
/*      */   }
/*      */   
/*      */   static CombiningGangsKey getCCombineKey(long gangid, GangCombine xCombine)
/*      */   {
/* 2615 */     if (xCombine == null) {
/* 2616 */       return null;
/*      */     }
/* 2618 */     if (xCombine.getGangid() < 0L) {
/* 2619 */       return null;
/*      */     }
/* 2621 */     CombiningGangsKey cCombineKey = null;
/* 2622 */     if (xCombine.getApplicants().contains(Long.valueOf(xCombine.getGangid())))
/*      */     {
/* 2624 */       cCombineKey = getCCombineKey(gangid, xCombine.getGangid());
/*      */     }
/*      */     else {
/* 2627 */       cCombineKey = getCCombineKey(xCombine.getGangid(), gangid);
/*      */     }
/* 2629 */     return cCombineKey;
/*      */   }
/*      */   
/*      */ 
/*      */   static CombineGangsInfo getXCombineGangsInfo(GangGlobal xGlobal, long mainGangid, long viceGangid)
/*      */   {
/* 2635 */     CombiningGangsKey cCombineKey = getCCombineKey(mainGangid, viceGangid);
/* 2636 */     return getXCombineGangsInfo(xGlobal, cCombineKey);
/*      */   }
/*      */   
/*      */   static CombineGangsInfo getXCombineGangsInfo(GangGlobal xGlobal, CombiningGangsKey cCombineKey) {
/* 2640 */     if (cCombineKey == null) {
/* 2641 */       return null;
/*      */     }
/* 2643 */     CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().get(cCombineKey);
/* 2644 */     return xInfo;
/*      */   }
/*      */   
/*      */   private static SGangNormalResult getNormalResult(int result, Object... args)
/*      */   {
/* 2649 */     SGangNormalResult p = new SGangNormalResult();
/* 2650 */     p.result = result;
/* 2651 */     for (Object arg : args) {
/* 2652 */       p.args.add(arg.toString());
/*      */     }
/* 2654 */     return p;
/*      */   }
/*      */   
/*      */   static void sendNormalResult(long roleid, int result, Object... args) {
/* 2658 */     SGangNormalResult p = getNormalResult(result, args);
/* 2659 */     p.result = result;
/* 2660 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*      */   }
/*      */   
/*      */   public static boolean isDebugLogEnabled() {
/* 2664 */     return logger.isDebugEnabled();
/*      */   }
/*      */   
/*      */   public static void logDebug(String format, Object... args) {
/* 2668 */     logger.debug(String.format(format, args));
/*      */   }
/*      */   
/*      */   public static void logInfo(String format, Object... args) {
/* 2672 */     logger.info(String.format(format, args));
/*      */   }
/*      */   
/*      */   public static void logWarn(String format, Object... args) {
/* 2676 */     logger.warn(String.format(format, args));
/*      */   }
/*      */   
/*      */   public static void logError(String format, Object... args) {
/* 2680 */     logger.error(String.format(format, args));
/*      */   }
/*      */   
/*      */   static void broadcastCombineGangApplyResult(long srcGangid, long targetGangid, int result, Collection<Long> roles) {
/* 2684 */     SCombineGangApplyResultBrd brd = new SCombineGangApplyResultBrd();
/* 2685 */     brd.srcid = srcGangid;
/* 2686 */     brd.targetid = targetGangid;
/* 2687 */     brd.result = result;
/* 2688 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*      */   }
/*      */   
/*      */   static void broadcastCombineGangApplyResult(long srcGangid, xbean.Gang xSrcGang, long targetGangid, xbean.Gang xTargetGang, int result)
/*      */   {
/* 2693 */     List<Long> roles = new ArrayList(2);
/* 2694 */     if (xSrcGang != null) {
/* 2695 */       roles.add(Long.valueOf(getLeaderid(xSrcGang)));
/*      */     }
/* 2697 */     if (xTargetGang != null) {
/* 2698 */       roles.add(Long.valueOf(getLeaderid(xTargetGang)));
/*      */     }
/* 2700 */     broadcastCombineGangApplyResult(srcGangid, targetGangid, result, roles);
/*      */   }
/*      */   
/*      */   static void stopApplyCombineTimer(CombiningGangsKey cCombineKey) {
/* 2704 */     Long sessionid = CombineSessionManager.getInstance().remove(cCombineKey);
/* 2705 */     if (sessionid != null) {
/* 2706 */       Session session = Session.getSession(sessionid.longValue());
/* 2707 */       if (session != null) {
/* 2708 */         session.stopTimer();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void broadcastCombineGangCancel(long srcGangid, long targetGangid, Collection<Long> roles) {
/* 2714 */     mzm.gsp.gang.SCombineGangCancelBrd brd = new mzm.gsp.gang.SCombineGangCancelBrd();
/* 2715 */     brd.srcid = srcGangid;
/* 2716 */     brd.targetid = targetGangid;
/* 2717 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*      */   }
/*      */   
/*      */   static void broadcastCombineGangCancel(long srcGangid, xbean.Gang xSrcGang, boolean notifySrcGang, long targetGangid, xbean.Gang xTargetGang, boolean notifyTargetGang)
/*      */   {
/* 2722 */     List<Long> roles = new ArrayList(2);
/* 2723 */     if ((notifySrcGang) && (xSrcGang != null)) {
/* 2724 */       roles.add(Long.valueOf(getLeaderid(xSrcGang)));
/*      */     }
/* 2726 */     if ((notifyTargetGang) && (xTargetGang != null)) {
/* 2727 */       roles.add(Long.valueOf(getLeaderid(xTargetGang)));
/*      */     }
/* 2729 */     broadcastCombineGangCancel(srcGangid, targetGangid, roles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void increaseActiveMemberNumber(xbean.Gang xGang)
/*      */   {
/* 2737 */     xGang.setJuanzhongnum(xGang.getJuanzhongnum() + 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void clearActiveMemberNumber(xbean.Gang xGang)
/*      */   {
/* 2745 */     xGang.setJuanzhongnum(0);
/*      */   }
/*      */   
/*      */   static int getActiveMemberNumber(xbean.Gang xGang) {
/* 2749 */     return xGang.getJuanzhongnum();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setVitalityAndBroadcast(xbean.Gang xGang, int vitality)
/*      */   {
/* 2758 */     xGang.setVitality(vitality);
/* 2759 */     SSyncVitalityBrd brd = new SSyncVitalityBrd();
/* 2760 */     brd.vitality = vitality;
/* 2761 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int addVitality(long gangid, xbean.Gang xGang, int add)
/*      */   {
/* 2771 */     int oldVitality = xGang.getVitality();
/* 2772 */     int newVitality = oldVitality + add;
/* 2773 */     if (newVitality < 0) {
/* 2774 */       newVitality = 0;
/*      */     }
/* 2776 */     else if (newVitality > SGangConst.getInstance().GANG_LIVELY_MAX_LIMIT) {
/* 2777 */       newVitality = SGangConst.getInstance().GANG_LIVELY_MAX_LIMIT;
/*      */     }
/* 2779 */     setVitalityAndBroadcast(xGang, newVitality);
/*      */     
/*      */ 
/* 2782 */     if ((checkCombineVitality(newVitality)) && (!checkCombineVitality(oldVitality)))
/*      */     {
/*      */ 
/* 2785 */       TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_CAN_MAIL);
/* 2786 */       sendMail(xGang, SGangConst.getInstance().CAN_COMBINE_MAIL, tlogArg, new String[] { xGang.getName() });
/*      */     }
/*      */     
/*      */ 
/* 2790 */     triggerVitalityChangedEvent(gangid, oldVitality, newVitality);
/*      */     
/* 2792 */     return newVitality;
/*      */   }
/*      */   
/*      */   static void triggerVitalityChangedEvent(long factionid, int oldVitality, int newVitality) {
/* 2796 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangVitalityChanged(), new mzm.gsp.gang.event.GangVitalityChangedArg(factionid, oldVitality, newVitality));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void updateVitalityAndClearActiveMemberNumber(long gangid, xbean.Gang xGang)
/*      */   {
/* 2807 */     int activeNumber = getActiveMemberNumber(xGang);
/* 2808 */     clearActiveMemberNumber(xGang);
/* 2809 */     int addVitality = GangConfigManager.getInstance().getAddGangVitalityByActiveNumber(activeNumber);
/* 2810 */     addVitality(gangid, xGang, addVitality);
/*      */   }
/*      */   
/*      */   static boolean cancelCombine(GangCombine xMainCombine, GangCombine xViceCombine, CombiningGangsKey cCombineKey, GangGlobal xGlobal)
/*      */   {
/* 2815 */     long mainGangid = cCombineKey.getFront();
/* 2816 */     long viceGangid = cCombineKey.getBehind();
/* 2817 */     if (xMainCombine.getGangid() != viceGangid) {
/* 2818 */       return false;
/*      */     }
/* 2820 */     xMainCombine.setGangid(-1L);
/* 2821 */     xMainCombine.getApplicants().remove(Long.valueOf(viceGangid));
/* 2822 */     xViceCombine.setGangid(-1L);
/* 2823 */     xGlobal.getCombine().remove(cCombineKey);
/*      */     
/* 2825 */     return true;
/*      */   }
/*      */   
/*      */   static boolean cancelCombineApply(GangCombine xMainCombine, GangCombine xViceCombine, CombiningGangsKey cCombineKey, GangGlobal xGlobal)
/*      */   {
/* 2830 */     long mainGangid = cCombineKey.getFront();
/* 2831 */     long viceGangid = cCombineKey.getBehind();
/*      */     
/*      */ 
/* 2834 */     if (xMainCombine.getGangid() == viceGangid) {
/* 2835 */       return false;
/*      */     }
/* 2837 */     xMainCombine.getApplicants().remove(Long.valueOf(viceGangid));
/* 2838 */     if (xViceCombine.getGangid() == mainGangid) {
/* 2839 */       xViceCombine.setGangid(-1L);
/*      */     }
/* 2841 */     xGlobal.getCombine().remove(cCombineKey);
/*      */     
/* 2843 */     stopApplyCombineTimer(cCombineKey);
/*      */     
/* 2845 */     return true;
/*      */   }
/*      */   
/*      */   static boolean cancelCombineOrApply(GangCombine xMainCombine, GangCombine xViceCombine, CombiningGangsKey cCombineKey, GangGlobal xGlobal)
/*      */   {
/* 2850 */     long mainGangid = cCombineKey.getFront();
/* 2851 */     long viceGangid = cCombineKey.getBehind();
/*      */     
/* 2853 */     if (xMainCombine != null) {
/* 2854 */       if (xMainCombine.getGangid() > 0L) {
/* 2855 */         xMainCombine.setGangid(-1L);
/*      */       }
/* 2857 */       xMainCombine.getApplicants().remove(Long.valueOf(viceGangid));
/*      */     }
/*      */     
/* 2860 */     if ((xViceCombine != null) && 
/* 2861 */       (xViceCombine.getGangid() == mainGangid)) {
/* 2862 */       xViceCombine.setGangid(-1L);
/*      */     }
/*      */     
/*      */ 
/* 2866 */     CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().remove(cCombineKey);
/*      */     
/* 2868 */     if (xInfo != null) {
/* 2869 */       if (!xInfo.getIscombining())
/*      */       {
/* 2871 */         stopApplyCombineTimer(cCombineKey);
/*      */       }
/*      */       
/* 2874 */       return true;
/*      */     }
/*      */     
/* 2877 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncGangQQGroup(long roleid, xbean.Gang xGang)
/*      */   {
/* 2888 */     SSyncGangQQGroupRes syncresult = new SSyncGangQQGroupRes();
/* 2889 */     syncresult.groupopenid = xGang.getGroupopenid();
/* 2890 */     OnlineManager.getInstance().send(roleid, syncresult);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendLeaveGangWithQQGroup(long roleid, String groupOpenId)
/*      */   {
/* 2899 */     SSetLeaveGangWithQQGroup pro = new SSetLeaveGangWithQQGroup();
/* 2900 */     pro.groupopenid = groupOpenId;
/* 2901 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*      */   }
/*      */   
/*      */   static ArrayList<Long> getApplicants(GangMemoryBean xGangMemory)
/*      */   {
/* 2906 */     ArrayList<Long> applicants = new ArrayList();
/* 2907 */     if (xGangMemory != null) {
/* 2908 */       for (GangApply xApply : xGangMemory.getApplylist()) {
/* 2909 */         applicants.add(Long.valueOf(xApply.getRoleid()));
/*      */       }
/*      */     }
/* 2912 */     return applicants;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean deleteGang(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, GangGlobal xGlobal)
/*      */   {
/* 2918 */     boolean ret = xtable.Gang.remove(Long.valueOf(gangid));
/* 2919 */     if (!ret) {
/* 2920 */       return false;
/*      */     }
/*      */     
/* 2923 */     if (xGang.getTanheroleid() > 0L) {
/* 2924 */       GangTanHeObserver.stopTanHe(gangid);
/*      */     }
/* 2926 */     ApplyObserver.removeObserver(gangid);
/* 2927 */     MiFangObserver.stopObserver(gangid);
/* 2928 */     Gangmemory.remove(Long.valueOf(gangid));
/*      */     
/*      */ 
/* 2931 */     Set<Long> members = getMembers(xGang);
/* 2932 */     for (Long r : members) {
/* 2933 */       ForbidTalkObserver.stopObserver(r.longValue());
/*      */     }
/*      */     
/*      */ 
/* 2937 */     UniqName.release("faction", xGang.getName());
/*      */     
/*      */ 
/* 2940 */     if (xGlobal != null) {
/* 2941 */       xGlobal.getAllgangids().remove(Long.valueOf(gangid));
/*      */     }
/*      */     
/*      */ 
/* 2945 */     List<Long> applicants = getApplicants(xGangMemory);
/* 2946 */     asyncClearJoinApplicants(gangid, applicants);
/*      */     
/* 2948 */     long gangWorldId = xGangMemory.getGangworldid();
/*      */     
/* 2950 */     MapInterface.destroyWorld(gangWorldId);
/*      */     
/*      */ 
/* 2953 */     TeamInterface.unRegisterJoinTeam(gangWorldId);
/*      */     
/*      */ 
/* 2956 */     Gangmemory.remove(Long.valueOf(gangid));
/*      */     
/*      */ 
/* 2959 */     GangLRUCache.getInstance().removeGang(gangid);
/*      */     
/*      */ 
/* 2962 */     if (xGang.getGrouproleid() > 0L) {
/* 2963 */       sendLeaveGangWithQQGroup(xGang.getGrouproleid(), xGang.getGroupopenid());
/*      */     }
/*      */     
/*      */ 
/* 2967 */     NoneRealTimeTaskManager.getInstance().addTask(new RSetGangMemberPassiveLeaveStateByDissolve(members));
/*      */     
/*      */ 
/* 2970 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean dissolveGang(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, GangGlobal xGlobal)
/*      */   {
/* 2980 */     boolean ret = deleteGang(gangid, xGang, xGangMemory, xGlobal);
/*      */     
/* 2982 */     if (ret) {
/* 2983 */       Set<Long> members = getMembers(xGang);
/*      */       
/*      */ 
/* 2986 */       GangArg gangArg = new GangArg();
/* 2987 */       gangArg.gangId = gangid;
/* 2988 */       gangArg.roleId = xGang.getBangzhuid();
/* 2989 */       gangArg.extraMemberList.addAll(members);
/* 2990 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangDissolve(), gangArg);
/*      */       
/*      */ 
/* 2993 */       if (members != null) {
/* 2994 */         SSyncGangDissolve syncDissolve = new SSyncGangDissolve();
/* 2995 */         OnlineManager.getInstance().sendMulti(syncDissolve, members);
/*      */       }
/*      */       
/*      */ 
/* 2999 */       sendMail(xGang, SGangConst.getInstance().GANG_DISSOLVE_MAIL_ID, new TLogArg(LogReason.GANG_DISSOLVE_MAIL, SGangConst.getInstance().GANG_DISSOLVE_MAIL_ID), new String[] { xGang.getName() });
/*      */       
/*      */ 
/* 3002 */       asyncClearCombineByDissolve(gangid);
/*      */     }
/*      */     
/* 3005 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean dissolveGangAndTlog(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, GangGlobal xGlobal, String leaderUserid, int leaderLevel)
/*      */   {
/* 3011 */     long leaderRoleid = getLeaderid(xGang);
/* 3012 */     int gangMeberSize = getMemberSize(xGang);
/* 3013 */     boolean ret = dissolveGang(gangid, xGang, xGangMemory, xGlobal);
/* 3014 */     if (ret) {
/* 3015 */       addGangDismissTlog(gangid, leaderRoleid, leaderUserid, leaderLevel, gangMeberSize, GangDismissActionLogEnum.ACTIVIE_DISMISS, xGang.getDisplayid());
/*      */     }
/* 3017 */     return ret;
/*      */   }
/*      */   
/*      */   static void triggerLeaveGangEvent(long roleid, long gangid, LeaveGangArg.LeaveType leaveType)
/*      */   {
/* 3022 */     LeaveGangArg leaveArg = new LeaveGangArg(gangid, roleid, leaveType);
/* 3023 */     TriggerEventsManger.getInstance().triggerEvent(new LeaveGang(), leaveArg);
/*      */   }
/*      */   
/*      */   static void triggerLeaveGangEvent(Collection<Long> roles, long gangid, LeaveGangArg.LeaveType leaveType) {
/* 3027 */     LeaveGangArg leaveArg = new LeaveGangArg(gangid, roles, leaveType);
/* 3028 */     TriggerEventsManger.getInstance().triggerEvent(new LeaveGang(), leaveArg);
/*      */   }
/*      */   
/*      */   static void asyncClearJoinApplicants(long gangid, Collection<Long> applicants) {
/* 3032 */     NoneRealTimeTaskManager.getInstance().addTask(new RClearJoinApplicants(gangid, applicants));
/*      */   }
/*      */   
/*      */   static void asyncClearAppyList(long gangid, GangCombine xCombine)
/*      */   {
/* 3037 */     List<Long> removeApplicants = new ArrayList();
/* 3038 */     for (Iterator i$ = xCombine.getApplicants().iterator(); i$.hasNext();) { long applicantid = ((Long)i$.next()).longValue();
/* 3039 */       if (applicantid != xCombine.getGangid()) {
/* 3040 */         removeApplicants.add(Long.valueOf(applicantid));
/*      */       }
/*      */     }
/* 3043 */     if (!removeApplicants.isEmpty()) {
/* 3044 */       NoneRealTimeTaskManager.getInstance().addTask(new RClearCombineApplyList(gangid, removeApplicants));
/*      */     }
/*      */   }
/*      */   
/*      */   static void asyncCancelApply(long gangid, long targetGangid) {
/* 3049 */     NoneRealTimeTaskManager.getInstance().addTask(new PCancelCombineApply(targetGangid, gangid, false));
/*      */   }
/*      */   
/*      */ 
/*      */   static void broadcastCombine(long mainGangid, String mainGangName, long viceGangid, String viceGangName, boolean inMainGang, Collection<Long> roles, int result)
/*      */   {
/* 3055 */     SGangCombineBrd brd = new SGangCombineBrd();
/* 3056 */     brd.main_id = mainGangid;
/* 3057 */     brd.main_name = mainGangName;
/* 3058 */     brd.vice_id = viceGangid;
/* 3059 */     brd.vice_name = viceGangName;
/* 3060 */     if (inMainGang) {
/* 3061 */       brd.come_from = 0;
/*      */     }
/*      */     else {
/* 3064 */       brd.come_from = 1;
/*      */     }
/* 3066 */     brd.result = result;
/* 3067 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*      */   }
/*      */   
/*      */   static void notifyKickByCombine(long roleid, long gangid) {
/* 3071 */     mzm.gsp.gang.SKickByCombineNotify notify = new mzm.gsp.gang.SKickByCombineNotify();
/* 3072 */     notify.gangid = gangid;
/* 3073 */     OnlineManager.getInstance().send(roleid, notify);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeXCombine(long gangid, GangCombine xCombine) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void asyncClearCombineByDissolve(long gangid)
/*      */   {
/* 3086 */     Xdb.executor().execute(new RClearCombineByDissolve(gangid));
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
/*      */   static void addGangDismissTlog(long gangId, long roleId, String userId, int roleLevel, int gangMemberNum, GangDismissActionLogEnum gangDismissActionLogEnum, long gangDisplayId)
/*      */   {
/* 3100 */     StringBuilder tLogStr = new StringBuilder();
/* 3101 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(roleId).append("|").append(roleLevel).append("|").append(gangId).append("|").append(gangMemberNum).append("|").append(gangDismissActionLogEnum.value).append("|").append(gangDisplayId);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 3109 */     TLogManager.getInstance().addLog(roleId, "GangDismiss", tLogStr.toString());
/*      */   }
/*      */   
/*      */   static boolean isGangNew(xbean.Gang xGang) {
/* 3113 */     return getDiffDay(xGang.getCreatetime(), DateTimeUtils.getCurrTimeInMillis()) < SGangConst.getInstance().NEW_GANG_PROTECT_TIME_D;
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
/*      */   static mzm.gsp.gang.cache.Gang createGangCacheIfNotExist(long gangid, xbean.Gang xGang)
/*      */   {
/* 3127 */     mzm.gsp.gang.cache.Gang gangCache = GangLRUCache.getInstance().getGang(gangid);
/* 3128 */     if ((gangCache == null) && 
/* 3129 */       (xGang != null)) {
/* 3130 */       gangCache = new mzm.gsp.gang.cache.Gang();
/* 3131 */       for (Iterator i$ = getMembers(xGang).iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*      */         
/* 3133 */         GangMember xMember = getXGangMember(memberid, false);
/* 3134 */         Role role = RoleInterface.getRole(memberid, false);
/* 3135 */         int avatarid = AvatarInterface.getCurrentAvatar(memberid, false);
/* 3136 */         int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(memberid, false);
/* 3137 */         int fightValue = RoleInterface.getRoleMFValue(memberid);
/* 3138 */         if ((xMember != null) && (role != null))
/*      */         {
/*      */ 
/*      */ 
/* 3142 */           mzm.gsp.gang.cache.Member memberCache = GangCacheManager.newMemberCache(role, avatarid, avatarFrame, fightValue, xMember);
/*      */           
/* 3144 */           gangCache.addMember(memberid, memberCache);
/*      */         } }
/* 3146 */       GangLRUCache.getInstance().addGang(gangid, gangCache);
/*      */     }
/*      */     
/*      */ 
/* 3150 */     return gangCache;
/*      */   }
/*      */   
/*      */   static boolean isSuitableForAutoApply(xbean.Gang xGang, GangCombine xCombine)
/*      */   {
/* 3155 */     if (isGangFull(xGang)) {
/* 3156 */       return false;
/*      */     }
/* 3158 */     if (isCombiningOrApplyCombine(xCombine)) {
/* 3159 */       return false;
/*      */     }
/* 3161 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void refreshApplyJoinGangManager(long nowMillis)
/*      */   {
/* 3171 */     Map<Long, mzm.gsp.gang.cache.Gang> cacheGangs = GangLRUCache.getInstance().getGangs();
/*      */     
/* 3173 */     ArrayList<Integer> weights = GangConfigManager.getInstance().getApplyOldGangWeights();
/* 3174 */     weights.add(Integer.valueOf(SGangConst.getInstance().applyNewWeight));
/* 3175 */     ArrayList<ArrayList<Long>> weightGangs = new ArrayList();
/*      */     
/* 3177 */     for (int i = 0; i < weights.size(); i++) {
/* 3178 */       ArrayList<Long> gangs = new ArrayList();
/* 3179 */       weightGangs.add(gangs);
/*      */     }
/*      */     
/* 3182 */     int newGangIndex = weights.size() - 1;
/*      */     
/* 3184 */     for (Map.Entry<Long, mzm.gsp.gang.cache.Gang> entry : cacheGangs.entrySet()) {
/* 3185 */       long gangid = ((Long)entry.getKey()).longValue();
/* 3186 */       mzm.gsp.gang.cache.Gang gangCache = (mzm.gsp.gang.cache.Gang)entry.getValue();
/* 3187 */       xbean.Gang xGang = getXGang(gangid, false);
/* 3188 */       GangCombine xCombine = getXCombine(gangid, false);
/* 3189 */       if (xGang != null)
/*      */       {
/*      */ 
/*      */ 
/* 3193 */         if (!isSuitableForAutoApply(xGang, xCombine)) {
/* 3194 */           if (isDebugLogEnabled()) {
/* 3195 */             logDebug("GangManager.refreshApplyJoinGangManager@not suitable for auto apply|gangid=%d", new Object[] { Long.valueOf(gangid) });
/*      */           }
/*      */           
/*      */ 
/*      */         }
/* 3200 */         else if (isGangNew(xGang))
/*      */         {
/* 3202 */           List<Long> gangs = (List)weightGangs.get(newGangIndex);
/* 3203 */           gangs.add(Long.valueOf(gangid));
/* 3204 */           if (isDebugLogEnabled()) {
/* 3205 */             logDebug("GangManager.refreshApplyJoinGangManager@add new gang|gangid=%d", new Object[] { Long.valueOf(gangid) });
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 3210 */           int onlineCount = gangCache.getOnlineCount();
/*      */           
/* 3212 */           int oldIndex = GangConfigManager.getInstance().getApplyOldGangIndex(onlineCount);
/* 3213 */           if (oldIndex < 0) {
/* 3214 */             if (isDebugLogEnabled()) {
/* 3215 */               logDebug("GangManager.refreshApplyJoinGangManager@add old gang error, wrong index|gangid=%d|online_count=%d|old_index=%d", new Object[] { Long.valueOf(gangid), Integer.valueOf(onlineCount), Integer.valueOf(oldIndex) });
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 3220 */             List<Long> gangs = (List)weightGangs.get(oldIndex);
/* 3221 */             gangs.add(Long.valueOf(gangid));
/* 3222 */             if (isDebugLogEnabled()) {
/* 3223 */               logDebug("GangManager.refreshApplyJoinGangManager@add old gang|gangid=%d|online_count=%d|old_index=%d", new Object[] { Long.valueOf(gangid), Integer.valueOf(onlineCount), Integer.valueOf(oldIndex) });
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 3229 */     mzm.gsp.gang.cache.ApplyJoinGangManager.setInstance(weightGangs, weights, nowMillis);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static BanggongOperateEnum resultExchangeToOperateEnum(ModBangGongResult result)
/*      */   {
/* 3239 */     if (result.isSucceed()) {
/* 3240 */       return BanggongOperateEnum.SUCCESS;
/*      */     }
/*      */     
/* 3243 */     switch (result.getRes()) {
/*      */     case ERROR_BANGGONG_NOT_IN_GANG: 
/* 3245 */       return BanggongOperateEnum.NO_GANG;
/*      */     case ERROR_BANGGONG_GANG_ERROR: 
/* 3247 */       return BanggongOperateEnum.GANG_ERROR;
/*      */     case ERROR_BANGGONG_NUM_SIGN: 
/* 3249 */       return BanggongOperateEnum.NUM_ERROR;
/*      */     case ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT: 
/* 3251 */       return BanggongOperateEnum.NUM_NOT_ENOUGH;
/*      */     case ERROR_BANGGONG_NUM_HAS_REACH_LOW_LIMIT: 
/* 3253 */       return BanggongOperateEnum.NUM_NOT_ENOUGH;
/*      */     }
/* 3255 */     return BanggongOperateEnum.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void passiveLeaveGangHandle(GangMember xGangMember, long roleId)
/*      */   {
/* 3265 */     if (xGangMember.getIspassiveleaved()) {
/* 3266 */       SOutGangNotify sOutGangNotify = new SOutGangNotify();
/* 3267 */       OnlineManager.getInstance().sendAtOnce(roleId, sOutGangNotify);
/* 3268 */       xGangMember.setIspassiveleaved(false);
/*      */     } else {
/* 3270 */       xGangMember.setIspassiveleaved(true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerChangeDutyEvent(long gangid, Set<Long> roleIds)
/*      */   {
/* 3280 */     GangArg gangArg = new GangArg();
/* 3281 */     gangArg.gangId = gangid;
/* 3282 */     gangArg.extraMemberList.addAll(roleIds);
/* 3283 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.DutyChange(), gangArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerChangeDutyEvent(long gangid, Long roleId)
/*      */   {
/* 3292 */     Set<Long> roleIds = new HashSet();
/* 3293 */     roleIds.add(roleId);
/* 3294 */     triggerChangeDutyEvent(gangid, roleIds);
/*      */   }
/*      */   
/*      */   static int getOnlineCount(xbean.Gang xGang) {
/* 3298 */     int onlineCount = 0;
/* 3299 */     for (Iterator i$ = getMembers(xGang).iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 3300 */       if (OnlineManager.getInstance().isOnline(memberid)) {
/* 3301 */         onlineCount++;
/*      */       }
/*      */     }
/* 3304 */     return onlineCount;
/*      */   }
/*      */   
/*      */   static int getMemberDuty(xbean.Gang xGang, long roleid) {
/* 3308 */     if (xGang == null) {
/* 3309 */       return -1;
/*      */     }
/* 3311 */     Iterator<Map.Entry<Integer, GangDutyMembers>> iter = xGang.getDuty2members().entrySet().iterator();
/*      */     
/* 3313 */     while (iter.hasNext()) {
/* 3314 */       Map.Entry<Integer, GangDutyMembers> entry = (Map.Entry)iter.next();
/* 3315 */       int dutyid = ((Integer)entry.getKey()).intValue();
/* 3316 */       GangDutyMembers xMembers = (GangDutyMembers)entry.getValue();
/* 3317 */       if (xMembers.getMembers().contains(Long.valueOf(roleid))) {
/* 3318 */         return dutyid;
/*      */       }
/*      */     }
/* 3321 */     return -1;
/*      */   }
/*      */   
/*      */   static void fillCrossCompeteFactionDutyMembersList(xbean.Gang xGang, List<CrossCompeteFactionDutyMembers> dutyMembersList)
/*      */   {
/* 3326 */     if ((xGang == null) || (dutyMembersList == null)) {
/* 3327 */       return;
/*      */     }
/*      */     
/* 3330 */     Iterator<Map.Entry<Integer, GangDutyMembers>> iter = xGang.getDuty2members().entrySet().iterator();
/*      */     
/* 3332 */     while (iter.hasNext()) {
/* 3333 */       Map.Entry<Integer, GangDutyMembers> entry = (Map.Entry)iter.next();
/* 3334 */       int dutyid = ((Integer)entry.getKey()).intValue();
/* 3335 */       GangDutyMembers xMembers = (GangDutyMembers)entry.getValue();
/*      */       
/* 3337 */       CrossCompeteFactionDutyMembers dutyMembersBean = new CrossCompeteFactionDutyMembers();
/* 3338 */       dutyMembersBean.dutyid = dutyid;
/* 3339 */       dutyMembersBean.members.addAll(xMembers.getMembers());
/* 3340 */       dutyMembersList.add(dutyMembersBean);
/*      */     }
/*      */   }
/*      */   
/*      */   static long getGangTeamid(xbean.Gang xGang, long roleid) {
/* 3345 */     if (xGang == null) {
/* 3346 */       return -1L;
/*      */     }
/* 3348 */     Long gangTeamid = (Long)xGang.getMember2teamid().get(Long.valueOf(roleid));
/* 3349 */     if (gangTeamid == null) {
/* 3350 */       return -1L;
/*      */     }
/* 3352 */     return gangTeamid.longValue();
/*      */   }
/*      */   
/*      */   private static long generateGangTeamid(xbean.Gang xGang) {
/* 3356 */     xGang.setNext_teamid(xGang.getNext_teamid() + 1L);
/* 3357 */     return xGang.getNext_teamid();
/*      */   }
/*      */   
/*      */   static long createGangTeam(long gangid, xbean.Gang xGang, long roleid, String name, long nowMillis) {
/* 3361 */     if (!isInGang(xGang, roleid)) {
/* 3362 */       return -1L;
/*      */     }
/* 3364 */     long gangTeamid = getGangTeamid(xGang, roleid);
/* 3365 */     if (gangTeamid > 0L) {
/* 3366 */       return -2L;
/*      */     }
/*      */     
/* 3369 */     gangTeamid = generateGangTeamid(xGang);
/* 3370 */     xbean.GangTeam xGangTeam = Pod.newGangTeam();
/* 3371 */     xGangTeam.setLeader(roleid);
/* 3372 */     xGang.getTeams().put(Long.valueOf(gangTeamid), xGangTeam);
/*      */     
/* 3374 */     xGangTeam.setName(name);
/* 3375 */     xGangTeam.setCreate_millis(nowMillis);
/*      */     
/* 3377 */     addMember2GangTeam(roleid, gangTeamid, xGangTeam, xGang, nowMillis, false);
/*      */     
/* 3379 */     broadcastCreateGangTeam(xGang, gangTeamid, xGangTeam);
/*      */     
/*      */ 
/* 3382 */     triggerGangTeamCreatedEvent(gangid, roleid, gangTeamid);
/*      */     
/* 3384 */     return gangTeamid;
/*      */   }
/*      */   
/*      */   static xbean.GangTeam getXGangTeamByRoleid(xbean.Gang xGang, long roleid) {
/* 3388 */     Long gangTeamid = (Long)xGang.getMember2teamid().get(Long.valueOf(roleid));
/* 3389 */     if (gangTeamid == null) {
/* 3390 */       return null;
/*      */     }
/* 3392 */     return (xbean.GangTeam)xGang.getTeams().get(gangTeamid);
/*      */   }
/*      */   
/*      */   static void addMember2GangTeam(long roleid, long gangTeamid, xbean.GangTeam xGangTeam, xbean.Gang xGang, long nowMillis, boolean bSend)
/*      */   {
/* 3397 */     xbean.GangTeamMember xMember = Pod.newGangTeamMember();
/* 3398 */     xMember.setJoin_time(nowMillis);
/*      */     
/* 3400 */     xGangTeam.getMembers().put(Long.valueOf(roleid), xMember);
/* 3401 */     xGang.getMember2teamid().put(Long.valueOf(roleid), Long.valueOf(gangTeamid));
/* 3402 */     if (bSend) {
/* 3403 */       broadcastAddGangTeamMemberBrd(xGang, gangTeamid, roleid, xMember);
/*      */     }
/*      */   }
/*      */   
/*      */   static void broadcastCreateGangTeam(xbean.Gang xGang, long gangTeamid, xbean.GangTeam xGangTeam) {
/* 3408 */     SCreateGangTeamBrd brd = new SCreateGangTeamBrd();
/* 3409 */     fillGangTeam(gangTeamid, xGangTeam, brd.team);
/* 3410 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */   static void joinGangTeamAndBroadcast(String userid, long roleid, int roleLevel, long gangTeamid, xbean.GangTeam xGangTeam, long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, long nowMillis)
/*      */   {
/* 3415 */     addMember2GangTeam(roleid, gangTeamid, xGangTeam, xGang, nowMillis, true);
/*      */     
/* 3417 */     removeApplicantOfAllGangTeamsAndBrd(xGang, xGangMemory, roleid);
/*      */     
/* 3419 */     Gangteam_invitations.remove(Long.valueOf(roleid));
/*      */     
/* 3421 */     triggerJoinGangTeamEvent(gangid, roleid, gangTeamid, xGangTeam.getMembers().keySet());
/*      */     
/* 3423 */     tlogJoinGangTeam(userid, roleid, roleLevel, gangid, xGang.getDisplayid(), gangTeamid);
/*      */     
/* 3425 */     Procedure.execute(new PJoinGangTeamMail(xGangTeam.getName(), roleid, getGangTeamMemberListBySortedJoinTime(xGangTeam)));
/*      */   }
/*      */   
/*      */ 
/*      */   static void broadcastAddGangTeamMemberBrd(xbean.Gang xGang, long gangTeamid, long newMemberid, xbean.GangTeamMember xGangTeamMember)
/*      */   {
/* 3431 */     SAddGangTeamMemberBrd brd = new SAddGangTeamMemberBrd();
/* 3432 */     brd.teamid = gangTeamid;
/* 3433 */     fillGangTeamMember(newMemberid, xGangTeamMember, brd.new_member);
/* 3434 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */   static GangTeamApplicants getAndCreateXGangTeamApplicants(GangMemoryBean xGangMemory, long gangTeamid)
/*      */   {
/* 3439 */     GangTeamApplicants xApplicants = (GangTeamApplicants)xGangMemory.getTeamapplicants().get(Long.valueOf(gangTeamid));
/* 3440 */     if (xApplicants == null) {
/* 3441 */       xApplicants = Pod.newGangTeamApplicants();
/* 3442 */       xGangMemory.getTeamapplicants().put(Long.valueOf(gangTeamid), xApplicants);
/*      */     }
/* 3444 */     return xApplicants;
/*      */   }
/*      */   
/*      */   static boolean isGangTeamLeader(xbean.GangTeam xGangTeam, long roleid) {
/* 3448 */     if (xGangTeam == null) {
/* 3449 */       return false;
/*      */     }
/* 3451 */     return xGangTeam.getLeader() == roleid;
/*      */   }
/*      */   
/*      */   static void broadcastChangeGangTeamName(xbean.Gang xGang, long gangTeamid, String newName) {
/* 3455 */     SChangeGangTeamNameBrd brd = new SChangeGangTeamNameBrd();
/* 3456 */     brd.teamid = gangTeamid;
/* 3457 */     brd.name = newName;
/* 3458 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */   static boolean addGangTeamApplicantAndBroadcast(GangMemoryBean xGangMemory, long gangTeamid, xbean.GangTeam xGangTeam, long applicantid)
/*      */   {
/* 3463 */     GangTeamApplicants xApplicants = getAndCreateXGangTeamApplicants(xGangMemory, gangTeamid);
/* 3464 */     boolean ret = addGangTeamApplicant(xApplicants, applicantid);
/* 3465 */     if (ret) {
/* 3466 */       broadcastAddGangTeamApplicant(xGangTeam, applicantid);
/*      */     }
/* 3468 */     return ret;
/*      */   }
/*      */   
/*      */   private static boolean addGangTeamApplicant(GangTeamApplicants xApplicants, long applicantid) {
/* 3472 */     if (xApplicants.getApplicants().contains(Long.valueOf(applicantid))) {
/* 3473 */       return false;
/*      */     }
/* 3475 */     xApplicants.getApplicants().add(Long.valueOf(applicantid));
/* 3476 */     return true;
/*      */   }
/*      */   
/*      */   private static void broadcastAddGangTeamApplicant(xbean.GangTeam xGangTeam, long applicantid) {
/* 3480 */     SAddGangTeamApplicantBrd brd = new SAddGangTeamApplicantBrd();
/* 3481 */     brd.applicantid = applicantid;
/* 3482 */     OnlineManager.getInstance().send(xGangTeam.getLeader(), brd);
/*      */   }
/*      */   
/*      */   static boolean isGangTeamFull(xbean.GangTeam xGangTeam) {
/* 3486 */     return xGangTeam.getMembers().size() >= TeamInterface.getTeamCapacity();
/*      */   }
/*      */   
/*      */   static boolean removeGangTeamApplicantAndBroadcast(GangMemoryBean xGangMemory, long gangTeamid, xbean.GangTeam xGangTeam, long applicantid)
/*      */   {
/* 3491 */     GangTeamApplicants xApplicants = (GangTeamApplicants)xGangMemory.getTeamapplicants().get(Long.valueOf(gangTeamid));
/* 3492 */     if (xApplicants == null) {
/* 3493 */       return false;
/*      */     }
/* 3495 */     boolean ret = removeGangTeamApplicant(xApplicants, applicantid);
/* 3496 */     if (ret) {
/* 3497 */       broadcastRemoveGangTeamApplicant(xGangTeam, applicantid);
/*      */     }
/*      */     
/* 3500 */     return ret;
/*      */   }
/*      */   
/*      */   private static boolean removeGangTeamApplicant(GangTeamApplicants xApplicants, long applicantid) {
/* 3504 */     return xApplicants.getApplicants().remove(Long.valueOf(applicantid));
/*      */   }
/*      */   
/*      */   private static void broadcastRemoveGangTeamApplicant(xbean.GangTeam xGangTeam, long applicantid) {
/* 3508 */     SRemoveGangTeamApplicantBrd brd = new SRemoveGangTeamApplicantBrd();
/* 3509 */     brd.applicantid = applicantid;
/* 3510 */     OnlineManager.getInstance().send(xGangTeam.getLeader(), brd);
/*      */   }
/*      */   
/*      */   static void removeApplicantOfAllGangTeamsAndBrd(xbean.Gang xGang, GangMemoryBean xGangMemory, long applicantid) {
/* 3514 */     Iterator<Map.Entry<Long, xbean.GangTeam>> iter = xGang.getTeams().entrySet().iterator();
/* 3515 */     while (iter.hasNext()) {
/* 3516 */       Map.Entry<Long, xbean.GangTeam> entry = (Map.Entry)iter.next();
/* 3517 */       long gangTeamid = ((Long)entry.getKey()).longValue();
/* 3518 */       xbean.GangTeam xGangTeam = (xbean.GangTeam)entry.getValue();
/*      */       
/* 3520 */       removeGangTeamApplicantAndBroadcast(xGangMemory, gangTeamid, xGangTeam, applicantid);
/*      */     }
/*      */   }
/*      */   
/*      */   static void notifyJoinGangTeamRefused(long leaderid, long applicantid) {
/* 3525 */     SJoinGangTeamRefusedNotify notify = new SJoinGangTeamRefusedNotify();
/* 3526 */     notify.leaderid = leaderid;
/* 3527 */     OnlineManager.getInstance().send(applicantid, notify);
/*      */   }
/*      */   
/*      */   static GangTeamInvitations getAndCreateXTeamInvitations(long roleid) {
/* 3531 */     GangTeamInvitations xInvitations = Gangteam_invitations.get(Long.valueOf(roleid));
/* 3532 */     if (xInvitations == null) {
/* 3533 */       xInvitations = Pod.newGangTeamInvitations();
/* 3534 */       Gangteam_invitations.insert(Long.valueOf(roleid), xInvitations);
/*      */     }
/* 3536 */     return xInvitations;
/*      */   }
/*      */   
/*      */   static GangTeamInvitations getXTeamInvitations(long roleid, boolean remainLock) {
/* 3540 */     GangTeamInvitations xInvitations = null;
/* 3541 */     if (remainLock) {
/* 3542 */       xInvitations = Gangteam_invitations.get(Long.valueOf(roleid));
/*      */     }
/*      */     else {
/* 3545 */       xInvitations = Gangteam_invitations.select(Long.valueOf(roleid));
/*      */     }
/* 3547 */     return xInvitations;
/*      */   }
/*      */   
/*      */   static boolean addGangTeamInvitation(GangTeamInvitations xInvitations, long inviter, long gangTeamid)
/*      */   {
/* 3552 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 3553 */     GangTeamInvitation xInvitation = (GangTeamInvitation)xInvitations.getInvitations().get(Long.valueOf(inviter));
/* 3554 */     if (xInvitation != null) {
/* 3555 */       if ((xInvitation.getGang_teamid() == gangTeamid) && (nowMillis < xInvitation.getEnd_millis())) {
/* 3556 */         return false;
/*      */       }
/*      */     }
/*      */     else {
/* 3560 */       xInvitation = Pod.newGangTeamInvitation();
/* 3561 */       xInvitations.getInvitations().put(Long.valueOf(inviter), xInvitation);
/*      */     }
/* 3563 */     xInvitation.setGang_teamid(gangTeamid);
/* 3564 */     xInvitation.setEnd_millis(nowMillis + TimeUnit.SECONDS.toMillis(SGangTeamConst.getInstance().GangTeamInviteSeconds));
/*      */     
/*      */ 
/* 3567 */     return true;
/*      */   }
/*      */   
/*      */   static void checkRemoveGangTeamInvitation(long roleid, long gangid, GangTeamInvitations xInvitations) {
/* 3571 */     if (xInvitations == null) {
/* 3572 */       return;
/*      */     }
/* 3574 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 3575 */     Iterator<Map.Entry<Long, GangTeamInvitation>> iter = xInvitations.getInvitations().entrySet().iterator();
/* 3576 */     while (iter.hasNext()) {
/* 3577 */       Map.Entry<Long, GangTeamInvitation> entry = (Map.Entry)iter.next();
/* 3578 */       long inviter = ((Long)entry.getKey()).longValue();
/* 3579 */       GangTeamInvitation xInvitation = (GangTeamInvitation)entry.getValue();
/*      */       
/* 3581 */       if (nowMillis >= xInvitation.getEnd_millis()) {
/* 3582 */         iter.remove();
/*      */       }
/*      */       
/* 3585 */       logInfo("GangManager.checkRemoveGangTeamInvitation@remove invitation|invitee=%d|gangid=%d|inviter=%d|gang_teamid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(gangid), Long.valueOf(inviter), Long.valueOf(xInvitation.getGang_teamid()) });
/*      */     }
/*      */   }
/*      */   
/*      */   static void checkSyncGangTeamApplicants(long roleid, xbean.Gang xGang, GangMemoryBean xGangMemory)
/*      */   {
/* 3591 */     Long gangTeamid = (Long)xGang.getMember2teamid().get(Long.valueOf(roleid));
/* 3592 */     if (gangTeamid == null) {
/* 3593 */       return;
/*      */     }
/* 3595 */     xbean.GangTeam xGangTeam = (xbean.GangTeam)xGang.getTeams().get(gangTeamid);
/* 3596 */     if (xGangTeam == null) {
/* 3597 */       return;
/*      */     }
/* 3599 */     if (!isGangTeamLeader(xGangTeam, roleid)) {
/* 3600 */       return;
/*      */     }
/* 3602 */     syncGangTeamApplicants(roleid, gangTeamid.longValue(), xGangMemory);
/*      */   }
/*      */   
/*      */   static void syncGangTeamApplicants(long roleid, long gangTeamid, GangMemoryBean xGangMemory) {
/* 3606 */     GangTeamApplicants xApplicants = (GangTeamApplicants)xGangMemory.getTeamapplicants().get(Long.valueOf(gangTeamid));
/* 3607 */     if (xApplicants == null) {
/* 3608 */       return;
/*      */     }
/* 3610 */     if (!xApplicants.getApplicants().isEmpty()) {
/* 3611 */       SSyncGangTeamApplicants sync = new SSyncGangTeamApplicants();
/* 3612 */       sync.applicants.addAll(xApplicants.getApplicants());
/* 3613 */       OnlineManager.getInstance().send(roleid, sync);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean removeGangTeamInvitation(GangTeamInvitations xInvitations, long inviter, long gangTeamid) {
/* 3618 */     GangTeamInvitation xInvitation = (GangTeamInvitation)xInvitations.getInvitations().get(Long.valueOf(inviter));
/* 3619 */     if (xInvitation == null) {
/* 3620 */       return false;
/*      */     }
/* 3622 */     if (xInvitation.getGang_teamid() != gangTeamid) {
/* 3623 */       return false;
/*      */     }
/* 3625 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 3626 */     if (now > xInvitation.getEnd_millis()) {
/* 3627 */       return false;
/*      */     }
/* 3629 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isInGangTeam(xbean.GangTeam xGangTeam, long roleid) {
/* 3633 */     if (xGangTeam == null) {
/* 3634 */       return false;
/*      */     }
/* 3636 */     return xGangTeam.getMembers().containsKey(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   static void changeGangTeamLeaderAndBroadcast(xbean.Gang xGang, long gangTeamid, xbean.GangTeam xGangTeam, long newLeaderid) {
/* 3640 */     if ((xGang == null) || (xGangTeam == null)) {
/* 3641 */       return;
/*      */     }
/* 3643 */     xGangTeam.setLeader(newLeaderid);
/*      */     
/* 3645 */     broadcastChangeGangTeamLeader(xGang, gangTeamid, newLeaderid);
/*      */   }
/*      */   
/*      */   private static void broadcastChangeGangTeamLeader(xbean.Gang xGang, long gangTeamid, long newLeaderid) {
/* 3649 */     SChangeGangTeamLeaderBrd brd = new SChangeGangTeamLeaderBrd();
/* 3650 */     brd.gang_teamid = gangTeamid;
/* 3651 */     brd.new_leader = newLeaderid;
/* 3652 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */   static boolean removeGangTeamMemberAndBroadcast(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, long gangTeamid, xbean.GangTeam xGangTeam, long memberid)
/*      */   {
/* 3657 */     if ((xGang == null) || (xGangTeam == null)) {
/* 3658 */       return false;
/*      */     }
/* 3660 */     xbean.GangTeamMember xMember = (xbean.GangTeamMember)xGangTeam.getMembers().remove(Long.valueOf(memberid));
/* 3661 */     if (xMember == null) {
/* 3662 */       return false;
/*      */     }
/*      */     
/* 3665 */     if (xGangTeam.getMembers().isEmpty())
/*      */     {
/* 3667 */       xGang.getTeams().remove(Long.valueOf(gangTeamid));
/*      */       
/* 3669 */       if (xGangMemory != null) {
/* 3670 */         xGangMemory.getTeamapplicants().clear();
/*      */       }
/*      */       
/* 3673 */       triggerGangTeamDissolvedEvent(gangid, gangTeamid, Arrays.asList(new Long[] { Long.valueOf(memberid) }));
/*      */     }
/*      */     else {
/* 3676 */       if (memberid == xGangTeam.getLeader())
/*      */       {
/* 3678 */         long newLeaderid = getFirstJoinGangTeamMemberid(xGangTeam);
/* 3679 */         changeGangTeamLeaderAndBroadcast(xGang, gangTeamid, xGangTeam, newLeaderid);
/*      */       }
/*      */       
/* 3682 */       triggerLeaveGangTeamEvent(gangid, memberid, gangTeamid, xGangTeam.getMembers().keySet());
/*      */     }
/*      */     
/* 3685 */     broadcastRemoveGangTeamMember(xGang, gangTeamid, memberid);
/*      */     
/* 3687 */     return true;
/*      */   }
/*      */   
/*      */   private static long getFirstJoinGangTeamMemberid(xbean.GangTeam xGangTeam) {
/* 3691 */     long firstMemberid = -1L;
/* 3692 */     long firstJoinTime = -1L;
/*      */     
/* 3694 */     Iterator<Map.Entry<Long, xbean.GangTeamMember>> iter = xGangTeam.getMembers().entrySet().iterator();
/*      */     
/* 3696 */     while (iter.hasNext()) {
/* 3697 */       Map.Entry<Long, xbean.GangTeamMember> entry = (Map.Entry)iter.next();
/* 3698 */       long memberid = ((Long)entry.getKey()).longValue();
/* 3699 */       xbean.GangTeamMember xMember = (xbean.GangTeamMember)entry.getValue();
/*      */       
/* 3701 */       if (firstMemberid < 0L) {
/* 3702 */         firstMemberid = memberid;
/* 3703 */         firstJoinTime = xMember.getJoin_time();
/*      */ 
/*      */       }
/* 3706 */       else if (xMember.getJoin_time() < firstJoinTime) {
/* 3707 */         firstMemberid = memberid;
/* 3708 */         firstJoinTime = xMember.getJoin_time();
/*      */       }
/*      */     }
/*      */     
/* 3712 */     return firstMemberid;
/*      */   }
/*      */   
/*      */   private static void broadcastRemoveGangTeamMember(xbean.Gang xGang, long gangTeamid, long memberid)
/*      */   {
/* 3717 */     SRemoveGangTeamMemberBrd brd = new SRemoveGangTeamMemberBrd();
/* 3718 */     brd.teamid = gangTeamid;
/* 3719 */     brd.memberid = memberid;
/* 3720 */     broadcast(xGang, brd);
/*      */   }
/*      */   
/*      */   static void removeGangTeamMemberByLeaveGang(long gangid, xbean.Gang xGang, GangMemoryBean xGangMemory, long roleid)
/*      */   {
/* 3725 */     if (xGang == null) {
/* 3726 */       return;
/*      */     }
/*      */     
/* 3729 */     removeApplicantOfAllGangTeamsAndBrd(xGang, xGangMemory, roleid);
/*      */     
/* 3731 */     Long gangTeamid = (Long)xGang.getMember2teamid().remove(Long.valueOf(roleid));
/* 3732 */     if (gangTeamid == null) {
/* 3733 */       return;
/*      */     }
/*      */     
/* 3736 */     xbean.GangTeam xGangTeam = (xbean.GangTeam)xGang.getTeams().get(gangTeamid);
/* 3737 */     if (xGangTeam == null) {
/* 3738 */       return;
/*      */     }
/*      */     
/* 3741 */     boolean bLeader = isGangTeamLeader(xGangTeam, roleid);
/* 3742 */     removeGangTeamMemberAndBroadcast(gangid, xGang, xGangMemory, gangTeamid.longValue(), xGangTeam, roleid);
/*      */     
/* 3744 */     if ((!xGangTeam.getMembers().isEmpty()) && 
/* 3745 */       (bLeader))
/*      */     {
/*      */ 
/* 3748 */       Procedure.execute(new PChangeLeaderByLeaveGangTeamMail(roleid, xGangTeam.getLeader(), xGangTeam.getMembers().keySet()));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 3755 */     TLogArg tLogArg = new TLogArg(LogReason.GANG_TEAM_LEAVE_BY_LEAVE_GANG_MAIL);
/* 3756 */     List<String> contentArgs = new ArrayList();
/* 3757 */     contentArgs.add(xGangTeam.getName());
/* 3758 */     MailInterface.asynBuildAndSendMail(roleid, SGangTeamConst.getInstance().LeaveTeamByLeaveGangMail, null, contentArgs, tLogArg);
/*      */   }
/*      */   
/*      */ 
/*      */   static long moveGangTeamBetweenGangs(long viceGangTeamid, long viceGangid, xbean.Gang xViceGang, long mainGangid, xbean.Gang xMainGang)
/*      */   {
/* 3764 */     xbean.GangTeam xGangTeam = (xbean.GangTeam)xViceGang.getTeams().remove(Long.valueOf(viceGangTeamid));
/* 3765 */     if (xGangTeam == null) {
/* 3766 */       logError("GangManager.moveGangTeamBetweenGangs@gang team null|vice_teamied=%d|vice_gangid=%d|main_gangid=%d", new Object[] { Long.valueOf(viceGangTeamid), Long.valueOf(viceGangid), Long.valueOf(mainGangid) });
/*      */       
/*      */ 
/* 3769 */       return -1L;
/*      */     }
/*      */     
/* 3772 */     long mainGangTeamid = generateGangTeamid(xMainGang);
/* 3773 */     xMainGang.getTeams().put(Long.valueOf(mainGangTeamid), xGangTeam);
/* 3774 */     for (Iterator i$ = xGangTeam.getMembers().keySet().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 3775 */       xViceGang.getMember2teamid().remove(Long.valueOf(memberid));
/* 3776 */       xMainGang.getMember2teamid().put(Long.valueOf(memberid), Long.valueOf(mainGangTeamid));
/*      */     }
/*      */     
/* 3779 */     return mainGangTeamid;
/*      */   }
/*      */   
/*      */   static List<Long> getGangTeamMemberListBySortedJoinTime(xbean.GangTeam xGangTeam) {
/* 3783 */     List<Long> memberList = new ArrayList();
/*      */     
/* 3785 */     memberList.add(Long.valueOf(xGangTeam.getLeader()));
/*      */     
/* 3787 */     List<GangTeamMember> sortedMembers = new ArrayList();
/* 3788 */     Iterator<Map.Entry<Long, xbean.GangTeamMember>> iter = xGangTeam.getMembers().entrySet().iterator();
/* 3789 */     while (iter.hasNext()) {
/* 3790 */       Map.Entry<Long, xbean.GangTeamMember> entry = (Map.Entry)iter.next();
/* 3791 */       long memberid = ((Long)entry.getKey()).longValue();
/* 3792 */       xbean.GangTeamMember xMember = (xbean.GangTeamMember)entry.getValue();
/* 3793 */       GangTeamMember member = new GangTeamMember(memberid, xMember.getJoin_time());
/* 3794 */       sortedMembers.add(member);
/*      */     }
/*      */     
/* 3797 */     Collections.sort(sortedMembers);
/* 3798 */     for (GangTeamMember member : sortedMembers) {
/* 3799 */       if (member.memberid != xGangTeam.getLeader())
/*      */       {
/*      */ 
/* 3802 */         memberList.add(Long.valueOf(member.memberid));
/*      */       }
/*      */     }
/* 3805 */     return memberList;
/*      */   }
/*      */   
/*      */   static void triggerGangTeamCreatedEvent(long gangid, long roleid, long gangTeamid) {
/* 3809 */     mzm.gsp.gang.event.GangTeamCreatedArg createdArg = new mzm.gsp.gang.event.GangTeamCreatedArg(gangid, roleid, gangTeamid);
/* 3810 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangTeamCreated(), createdArg);
/*      */   }
/*      */   
/*      */   static void triggerJoinGangTeamEvent(long gangid, long newMemberid, long gangTeamid, Collection<Long> members) {
/* 3814 */     JoinGangTeamArg joinArg = new JoinGangTeamArg(gangid, newMemberid, gangTeamid, members);
/* 3815 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.JoinGangTeam(), joinArg);
/*      */   }
/*      */   
/*      */   static void triggerLeaveGangTeamEvent(long gangid, long roleid, long gangTeamid, Collection<Long> members) {
/* 3819 */     LeaveGangTeamArg leaveArg = new LeaveGangTeamArg(gangid, roleid, gangTeamid, members);
/* 3820 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.LeaveGangTeam(), leaveArg);
/*      */   }
/*      */   
/*      */   static void triggerGangTeamDissolvedEvent(long gangid, long gangTeamid, Collection<Long> members) {
/* 3824 */     GangTeamDissolvedArg dissolvedArg = new GangTeamDissolvedArg(gangid, gangTeamid, members);
/* 3825 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangTeamDissolved(), dissolvedArg);
/*      */   }
/*      */   
/*      */   static void tlogGangTeamCreated(String userid, long roleid, int roleLevel, long gangid, long gangDisplayid, long gangTeamid, String gangTeamName)
/*      */   {
/* 3830 */     TLogManager.getInstance().addLog(userid, "GangTeamCreated", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(gangid), Long.valueOf(gangDisplayid), Long.valueOf(gangTeamid), gangTeamName });
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogJoinGangTeam(String userid, long roleid, int roleLevel, long gangid, long gangDisplayid, long gangTeamid)
/*      */   {
/* 3836 */     TLogManager.getInstance().addLog(userid, "JoinGangTeam", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(gangid), Long.valueOf(gangDisplayid), Long.valueOf(gangTeamid) });
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogLeaveGangTeam(String userid, long roleid, int roleLevel, long gangid, long gangDisplayid, long gangTeamid)
/*      */   {
/* 3842 */     TLogManager.getInstance().addLog(userid, "LeaveGangTeam", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(gangid), Long.valueOf(gangDisplayid), Long.valueOf(gangTeamid) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogKickGangTeamMember(String leaderUserid, long leaderid, int leaderLevel, String kickedUserid, long kickedMemberid, int kickedMemberLevel, long gangid, long gangDisplayid, long gangTeamid)
/*      */   {
/* 3849 */     TLogManager.getInstance().addLog(leaderUserid, "KickGangTeamMember", new Object[] { GameServerInfoManager.getHostIP(), leaderUserid, Long.valueOf(leaderid), Integer.valueOf(leaderLevel), kickedUserid, Long.valueOf(kickedMemberid), Integer.valueOf(kickedMemberLevel), Long.valueOf(gangid), Long.valueOf(gangDisplayid), Long.valueOf(gangTeamid) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogGangTeamDissolved(String userid, long roleid, int roleLevel, long gangid, long gangDisplayid, long gangTeamid)
/*      */   {
/* 3856 */     TLogManager.getInstance().addLog(userid, "GangTeamDissovled", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(gangid), Long.valueOf(gangDisplayid), Long.valueOf(gangTeamid) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogGangContributionChanged(String userid, long roleid, int roleLevel, long oldBangGong, long newBangGong, long oldHistoryBangGong, long newHistoryBangGong, TLogArg tLogArg)
/*      */   {
/* 3863 */     TLogManager.getInstance().addLog(userid, "GangContributionChanged", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(oldBangGong), Long.valueOf(newBangGong), Long.valueOf(oldHistoryBangGong), Long.valueOf(newHistoryBangGong), Integer.valueOf(tLogArg.getLogReason().value), Integer.valueOf(tLogArg.getSubReason()) });
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */