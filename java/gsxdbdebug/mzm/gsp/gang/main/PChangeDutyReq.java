/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SSyncChangeDuty;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GangMember;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class PChangeDutyReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long targetid;
/*     */   private int duty;
/*     */   
/*     */   public PChangeDutyReq(long roleId, long targetid, int duty)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.targetid = targetid;
/*  29 */     this.duty = duty;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetid) }));
/*  36 */     GangMember xManager = Role2gangmember.get(Long.valueOf(this.roleId));
/*  37 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.targetid));
/*  38 */     if (xGangMember.getGangid() != xManager.getGangid()) {
/*  39 */       return false;
/*     */     }
/*  41 */     long gangId = xManager.getGangid();
/*     */     
/*  43 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  44 */     if (xGang == null) {
/*  45 */       return false;
/*     */     }
/*  47 */     if ((!GangManager.isInGang(xGang, this.roleId)) || (!GangManager.isInGang(xGang, this.targetid))) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (this.roleId == this.targetid) {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (this.duty == SGangConst.getInstance().XUETU_ID) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if ((xManager.getDuty() == this.duty) && (this.duty == SGangConst.getInstance().BANGZHU_ID) && (xGang.getBangzhuid() == this.roleId)) {
/*  61 */       boolean ret = changeBangZhu(gangId, this.roleId, xManager, this.targetid, xGangMember, xGang);
/*  62 */       if (ret)
/*     */       {
/*  64 */         SSyncChangeDuty sSyncChangeDuty = new SSyncChangeDuty();
/*  65 */         sSyncChangeDuty.duty = this.duty;
/*  66 */         sSyncChangeDuty.targetid = this.targetid;
/*  67 */         sSyncChangeDuty.managerid = this.roleId;
/*  68 */         GangManager.broadcast(xGang, sSyncChangeDuty);
/*     */         
/*     */ 
/*  71 */         GangManager.asyncApplicants(this.targetid, gangId);
/*  72 */         return true;
/*     */       }
/*     */     }
/*  75 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xManager);
/*  76 */     if (!dutyCfg.isCanAssignDuty) {
/*  77 */       return false;
/*     */     }
/*  79 */     SGangDutyCfg assignDutyCfg = GangManager.getDutyCfg(this.duty);
/*  80 */     if (assignDutyCfg == null) {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (dutyCfg.dutyLevel >= assignDutyCfg.dutyLevel) {
/*  85 */       return false;
/*     */     }
/*  87 */     SGangDutyCfg targetDutyCfg = GangManager.getDutyCfg(xGangMember);
/*  88 */     if (dutyCfg.dutyLevel >= targetDutyCfg.dutyLevel) {
/*  89 */       return false;
/*     */     }
/*  91 */     if (!GangManager.checkChangeDuty(xGang, xGangMember.getDuty(), assignDutyCfg.id)) {
/*  92 */       SGangNormalResult sResult = new SGangNormalResult();
/*  93 */       sResult.result = 55;
/*  94 */       OnlineManager.getInstance().send(this.roleId, sResult);
/*  95 */       return false;
/*     */     }
/*  97 */     int operatorDuty = xManager.getDuty();
/*     */     
/*  99 */     GangManager.changeDutyRelation(this.targetid, xGangMember, gangId, xGang, assignDutyCfg.id, this.roleId, operatorDuty);
/*     */     
/* 101 */     Map<Integer, String> nameMap = GangManager.getDutyNameByLevel(xGang, new int[] { assignDutyCfg.dutyLevel, targetDutyCfg.dutyLevel });
/* 102 */     GangManager.sendMail(this.targetid, SGangConst.getInstance().CHANGE_DUTY_MAIL_ID, new TLogArg(LogReason.GANG_DUTY_CHANGE_MAIL, SGangConst.getInstance().CHANGE_DUTY_MAIL_ID), new String[] { (String)nameMap.get(Integer.valueOf(targetDutyCfg.dutyLevel)), (String)nameMap.get(Integer.valueOf(assignDutyCfg.dutyLevel)) });
/*     */     
/* 104 */     SSyncChangeDuty sSyncChangeDuty = new SSyncChangeDuty();
/* 105 */     sSyncChangeDuty.duty = this.duty;
/* 106 */     sSyncChangeDuty.targetid = this.targetid;
/* 107 */     sSyncChangeDuty.managerid = this.roleId;
/* 108 */     GangManager.broadcast(xGang, sSyncChangeDuty);
/*     */     
/* 110 */     SGangNormalResult sGangNormalResult = new SGangNormalResult();
/* 111 */     sGangNormalResult.result = 25;
/* 112 */     OnlineManager.getInstance().send(this.roleId, sGangNormalResult);
/*     */     
/* 114 */     if (assignDutyCfg.isCanMgeApplyList)
/*     */     {
/* 116 */       GangManager.asyncApplicants(this.targetid, gangId);
/*     */     }
/*     */     
/* 119 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean changeBangZhu(long gangid, long oldBangZhuId, GangMember xOldBangZhu, long newBangZhuId, GangMember xNewBangZhu, xbean.Gang xGang)
/*     */   {
/* 129 */     if (xNewBangZhu.getDuty() == SGangConst.getInstance().XUETU_ID) {
/* 130 */       return false;
/*     */     }
/* 132 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 134 */     if (GangManager.getDiffDay(xNewBangZhu.getJointime(), curTime) < SGangConst.getInstance().BE_LEADER_JOIN_LEAST_DAY) {
/* 135 */       SGangNormalResult sGangNormalResult = new SGangNormalResult();
/* 136 */       sGangNormalResult.result = 27;
/* 137 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGangNormalResult);
/* 138 */       return false;
/*     */     }
/* 140 */     int oldBangzhuDuty = xOldBangZhu.getDuty();
/*     */     
/* 142 */     GangManager.changeDutyRelation(oldBangZhuId, xOldBangZhu, gangid, xGang, SGangConst.getInstance().BANGZHONG_ID, oldBangZhuId, oldBangzhuDuty);
/*     */     
/* 144 */     GangManager.changeDutyRelation(newBangZhuId, xNewBangZhu, gangid, xGang, SGangConst.getInstance().BANGZHU_ID, oldBangZhuId, oldBangzhuDuty);
/*     */     
/* 146 */     xGang.setBangzhuid(this.targetid);
/*     */     
/* 148 */     if (xGang.getTanheroleid() > 0L) {
/* 149 */       xGang.setTanheendtime(0L);
/* 150 */       xGang.setTanheroleid(0L);
/* 151 */       GangTanHeObserver.stopTanHe(gangid);
/*     */     }
/*     */     
/* 154 */     GangManager.sendMail(xGang, SGangConst.getInstance().CHANG_BANGZHU_MAIL_ID, new TLogArg(LogReason.GANG_MAILTO_OLD_BANGZHU_MAIL, SGangConst.getInstance().CHANG_BANGZHU_MAIL_ID), new String[] { RoleInterface.getName(this.targetid), xGang.getName() });
/* 155 */     SGangDutyCfg bangZhuCfg = GangManager.getDutyCfg(SGangConst.getInstance().BANGZHU_ID);
/* 156 */     SGangDutyCfg bangZhongCfg = GangManager.getDutyCfg(SGangConst.getInstance().BANGZHONG_ID);
/* 157 */     Map<Integer, String> dutyNameMap = GangManager.getDutyNameByLevel(xGang, new int[] { bangZhuCfg.dutyLevel, bangZhongCfg.dutyLevel });
/* 158 */     GangManager.sendMail(this.roleId, SGangConst.getInstance().CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID, new TLogArg(LogReason.GANG_MAILTO_OLD_BANGZHU_MAIL, SGangConst.getInstance().CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID), new String[] { (String)dutyNameMap.get(Integer.valueOf(bangZhuCfg.dutyLevel)), (String)dutyNameMap.get(Integer.valueOf(bangZhongCfg.dutyLevel)) });
/*     */     
/* 160 */     SGangNormalResult sGangNormalResult = new SGangNormalResult();
/* 161 */     sGangNormalResult.result = 26;
/* 162 */     OnlineManager.getInstance().send(this.roleId, sGangNormalResult);
/*     */     
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PChangeDutyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */