/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import mzm.gsp.gang.SOutGangNotify;
/*     */ import mzm.gsp.gang.SSyncCancelTanHe;
/*     */ import mzm.gsp.gang.SSyncGangMiFangInfo;
/*     */ import mzm.gsp.gang.SSyncGangMiFangTrigger;
/*     */ import mzm.gsp.gang.SSyncGangQQGroupRes;
/*     */ import mzm.gsp.gang.SSyncMemberLogin;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.GangMember;
/*     */ import xbean.MiFang;
/*     */ import xbean.OutGangStatus;
/*     */ import xbean.YaoDian;
/*     */ import xdb.Procedure;
/*     */ import xtable.Gangmemory;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  23 */     GangMember xGangMember = xtable.Role2gangmember.get((Long)this.arg);
/*  24 */     if (xGangMember == null) {
/*  25 */       return true;
/*     */     }
/*     */     
/*  28 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  30 */     OutGangStatus xOutGangStatus = xtable.Role2outgang.get((Long)this.arg);
/*     */     
/*  32 */     long gangId = xGangMember.getGangid();
/*     */     
/*  34 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  35 */     if (xGang == null) {
/*  36 */       if (xOutGangStatus != null) {
/*  37 */         GangManager.sendLeaveGangWithQQGroup(((Long)this.arg).longValue(), xOutGangStatus.getGroupopenid());
/*     */       }
/*     */       
/*  40 */       if (xGangMember.getIs_in_gang()) {
/*  41 */         xGangMember.setIs_in_gang(false);
/*     */       }
/*  43 */       return true;
/*     */     }
/*     */     
/*  46 */     if ((xOutGangStatus != null) && (xOutGangStatus.getGangid() != gangId)) {
/*  47 */       GangManager.sendLeaveGangWithQQGroup(((Long)this.arg).longValue(), xOutGangStatus.getGroupopenid());
/*     */     }
/*     */     
/*     */ 
/*  51 */     GangManager.checkGangSign(((Long)this.arg).longValue(), xGangMember);
/*     */     
/*     */ 
/*  54 */     GangManager.checkAndCleanGongXun(((Long)this.arg).longValue(), xGangMember);
/*     */     
/*     */ 
/*  57 */     xbean.GangMemoryBean xGangMemoryBean = Gangmemory.get(Long.valueOf(gangId));
/*  58 */     if (xGangMemoryBean == null)
/*     */     {
/*  60 */       BuildingFactory.init(gangId, xGang);
/*  61 */       long tanheTime = xGang.getTanheendtime();
/*  62 */       if (tanheTime > 0L) {
/*  63 */         new GangTanHeObserver(gangId, tanheTime - curTime);
/*     */       }
/*     */       
/*  66 */       GangManager.onAddGang(gangId);
/*     */     }
/*     */     
/*  69 */     if (xGangMember.getIspassiveleaved()) {
/*  70 */       SOutGangNotify sOutGangNotify = new SOutGangNotify();
/*  71 */       OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), sOutGangNotify);
/*  72 */       xGangMember.setIspassiveleaved(false);
/*     */     }
/*     */     
/*  75 */     if (!GangManager.isInGang(xGang, ((Long)this.arg).longValue()))
/*     */     {
/*  77 */       if (xGangMember.getIs_in_gang()) {
/*  78 */         xGangMember.setIs_in_gang(false);
/*     */       }
/*  80 */       return true;
/*     */     }
/*  82 */     if (xGangMember.getForbiddentalkend() > curTime) {
/*  83 */       long interval = xGangMember.getForbiddentalkend() - curTime;
/*  84 */       new ForbidTalkObserver(interval, ((Long)this.arg).longValue());
/*     */     }
/*     */     
/*  87 */     if (RedeemBangGongObserver.checkUpdate(xGangMember.getNextupdateredeemtimestamp())) {
/*  88 */       xGangMember.setRedeembanggong(0L);
/*  89 */       xGangMember.setYuanbao_redeem_bang_gong(0);
/*  90 */       xGangMember.setNextupdateredeemtimestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     
/*     */ 
/*  94 */     Procedure.execute(new PSyncGangInfo(((Long)this.arg).longValue(), gangId));
/*     */     
/*     */ 
/*  97 */     GangManager.syncSelfInfo(((Long)this.arg).longValue(), xGangMember);
/*     */     
/*  99 */     if (GangConfigManager.getInstance().hasManageApplicantsRight(xGangMember.getDuty()))
/*     */     {
/* 101 */       GangManager.asyncApplicants(((Long)this.arg).longValue(), gangId);
/*     */     }
/*     */     
/* 104 */     SSyncMemberLogin sSyncMemberLogin = new SSyncMemberLogin();
/* 105 */     sSyncMemberLogin.roleid = ((Long)this.arg).longValue();
/* 106 */     GangManager.broadcast(xGang, sSyncMemberLogin);
/*     */     
/* 108 */     if ((xGang.getBangzhuid() == ((Long)this.arg).longValue()) && 
/* 109 */       (xGang.getTanheroleid() > 0L)) {
/* 110 */       GangTanHeObserver.stopTanHe(gangId);
/* 111 */       SSyncCancelTanHe sSyncCancelTanHe = new SSyncCancelTanHe();
/* 112 */       sSyncCancelTanHe.roleid = xGang.getTanheroleid();
/* 113 */       GangManager.broadcast(xGang, sSyncCancelTanHe);
/* 114 */       xGang.setTanheendtime(0L);
/* 115 */       long tanheRoleid = xGang.getTanheroleid();
/* 116 */       xGang.setTanheroleid(0L);
/*     */       
/* 118 */       Procedure.execute(new PAddTanHeFailTlog(tanheRoleid, xGang.getBangzhuid(), gangId, xGang.getDisplayid()));
/*     */     }
/*     */     
/*     */ 
/* 122 */     MiFang xMiFang = xGang.getYaodian().getMifang();
/* 123 */     if (xMiFang.getMifangcfgendtime() > DateTimeUtils.getCurrTimeInMillis()) {
/* 124 */       if ((xMiFang.getMifangcfgendtime() > xGangMember.getLasthavemifangtime()) && (xMiFang.getMifangcfgstarttime() < xGangMember.getLasthavemifangtime()))
/*     */       {
/* 126 */         if (xGangMember.getTotalmakemifangcount() == xGangMember.getMakemifangcount()) {
/* 127 */           return true;
/*     */         }
/*     */         
/* 130 */         SSyncGangMiFangInfo sSyncGangMiFangInfo = new SSyncGangMiFangInfo();
/* 131 */         GangManager.fillMiFang(xGang.getYaodian().getMifang(), xGangMember, sSyncGangMiFangInfo.mifanginfo);
/* 132 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncGangMiFangInfo);
/*     */       } else {
/* 134 */         SSyncGangMiFangTrigger sSyncGangMiFangTrigger = new SSyncGangMiFangTrigger();
/* 135 */         sSyncGangMiFangTrigger.cfgid = xMiFang.getMifangcfgid();
/* 136 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncGangMiFangTrigger);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 141 */     SSyncGangQQGroupRes syncresult = new SSyncGangQQGroupRes();
/* 142 */     syncresult.groupopenid = xGang.getGroupopenid();
/* 143 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), syncresult);
/*     */     
/*     */ 
/* 146 */     if (GangManager.isLeader(xGang, ((Long)this.arg).longValue())) {
/* 147 */       NoneRealTimeTaskManager.getInstance().addTask(new PSyncCombine(((Long)this.arg).longValue(), gangId));
/*     */     }
/*     */     
/*     */ 
/* 151 */     xbean.GangTeamInvitations xInvitations = GangManager.getXTeamInvitations(((Long)this.arg).longValue(), true);
/* 152 */     if (xInvitations != null) {
/* 153 */       GangManager.checkRemoveGangTeamInvitation(((Long)this.arg).longValue(), gangId, xInvitations);
/*     */     }
/*     */     
/*     */ 
/* 157 */     GangManager.checkSyncGangTeamApplicants(((Long)this.arg).longValue(), xGang, xGangMemoryBean);
/*     */     
/*     */ 
/* 160 */     mzm.gsp.role.main.Role role = mzm.gsp.role.main.RoleInterface.getRole(((Long)this.arg).longValue(), true);
/* 161 */     int avatarid = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(((Long)this.arg).longValue(), true);
/* 162 */     mzm.gsp.gang.cache.GangCacheManager.updateMember(gangId, role, avatarid, xGangMember);
/*     */     
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */