/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.CKickOutMemberReq;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SKickOutMemberRes;
/*     */ import mzm.gsp.gang.SSyncKickOutMember;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.gang.event.LeaveGangArg.LeaveType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.GangMember;
/*     */ import xbean.GangMemoryBean;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class PKickOutMemberReq
/*     */   extends GangProcedure<CKickOutMemberReq>
/*     */ {
/*     */   public PKickOutMemberReq(CKickOutMemberReq protocol)
/*     */   {
/*  28 */     super(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean doProcess(long roleId, CKickOutMemberReq protocol)
/*     */   {
/*  34 */     lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(protocol.targetid) }));
/*  35 */     if (!RoleStatusInterface.checkCanSetStatus(protocol.targetid, roleId, 20, true)) {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     GangMember xManager = Role2gangmember.get(Long.valueOf(roleId));
/*  40 */     GangMember xtarget = Role2gangmember.get(Long.valueOf(protocol.targetid));
/*  41 */     if (xManager.getGangid() != xtarget.getGangid()) {
/*  42 */       return false;
/*     */     }
/*  44 */     long gangId = xManager.getGangid();
/*     */     
/*  46 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  47 */     if (xGang == null) {
/*  48 */       return false;
/*     */     }
/*  50 */     GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangId, true);
/*     */     
/*  52 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  53 */       return false;
/*     */     }
/*  55 */     if (!GangManager.isInGang(xGang, protocol.targetid)) {
/*  56 */       return false;
/*     */     }
/*  58 */     SGangDutyCfg ManagerDuty = GangManager.getDutyCfg(xManager);
/*  59 */     SGangDutyCfg targetDuty = GangManager.getDutyCfg(xtarget);
/*  60 */     if (!ManagerDuty.isCanKick) {
/*  61 */       return false;
/*     */     }
/*  63 */     if (targetDuty.dutyLevel <= ManagerDuty.dutyLevel) {
/*  64 */       return false;
/*     */     }
/*  66 */     long lastLogoffTime = RoleInterface.getLastLogoffTime(protocol.targetid);
/*  67 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  68 */     int costVigor = targetDuty.kickNeedVigor;
/*  69 */     if ((!OnlineManager.getInstance().isOnline(roleId)) && (getDiffDay(lastLogoffTime, curTime) < SGangConst.getInstance().KICK_NO_COST_OFFLINE_TIME_D))
/*     */     {
/*  71 */       costVigor = 0;
/*  72 */     } else if ((getDiffDay(xtarget.getJointime(), curTime) < SGangConst.getInstance().KICK_NO_COST_JOIN_TIME_D) && (xtarget.getHistorybanggong() < SGangConst.getInstance().KICK_NO_COST_BANGGONG_LIMIT))
/*     */     {
/*  74 */       costVigor = 0;
/*     */     }
/*  76 */     TLogArg logArg = new TLogArg(LogReason.GANG_KICK_MEMBER_REM);
/*     */     
/*  78 */     if (!RoleInterface.cutVigor(roleId, costVigor, logArg)) {
/*  79 */       SGangNormalResult sGangNormalResult = new SGangNormalResult();
/*  80 */       sGangNormalResult.result = 24;
/*  81 */       OnlineManager.getInstance().sendAtOnce(roleId, sGangNormalResult);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     GangManager.sendMail(protocol.targetid, SGangConst.getInstance().KICK_OUT_MAIL_ID, new TLogArg(LogReason.GANG_KICKOUTGANG_MAIL, SGangConst.getInstance().KICK_OUT_MAIL_ID), new String[] { RoleInterface.getName(roleId), xGang.getName() });
/*     */     
/*  87 */     SSyncKickOutMember sSyncKickOutMember = new SSyncKickOutMember();
/*  88 */     sSyncKickOutMember.roleid = protocol.targetid;
/*  89 */     sSyncKickOutMember.managerid = roleId;
/*  90 */     GangManager.broadcast(xGang, sSyncKickOutMember);
/*  91 */     GangManager.removeMember(gangId, xGang, xGangMemory, protocol.targetid, xtarget, true);
/*     */     
/*  93 */     SKickOutMemberRes res = new SKickOutMemberRes();
/*  94 */     res.costvigor = costVigor;
/*  95 */     OnlineManager.getInstance().send(roleId, res);
/*     */     
/*  97 */     GangManager.triggerLeaveGangEvent(protocol.targetid, gangId, LeaveGangArg.LeaveType.KickedOutByLeader);
/*     */     
/*  99 */     StringBuilder tLogStr = new StringBuilder();
/*     */     
/* 101 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(protocol.targetid)).append("|").append(protocol.targetid).append("|").append(xtarget.getDuty()).append("|").append(gangId).append("|").append(xGang.getDisplayid()).append("|").append(roleId).append("|").append(xManager.getDuty());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 109 */     TLogManager.getInstance().addLog(protocol.targetid, "GangKickOutTLog", tLogStr.toString());
/*     */     
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   private int getDiffDay(long begin, long end) {
/* 115 */     return GangManager.getDiffDay(begin, end);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PKickOutMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */