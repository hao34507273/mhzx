/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CombineGangsInfo;
/*     */ import xbean.CombiningGangsKey;
/*     */ import xbean.GangCombine;
/*     */ import xbean.GangGlobal;
/*     */ 
/*     */ public class PCombineGangApplyRep extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long applicantGangid;
/*     */   private final int reply;
/*     */   
/*     */   public PCombineGangApplyRep(long roleid, long applicantGangid, int reply)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.applicantGangid = applicantGangid;
/*  25 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*  32 */     if (gangid == null) {
/*  33 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  37 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { gangid, Long.valueOf(this.applicantGangid) }));
/*     */     
/*  39 */     xbean.Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  40 */     if (xGang == null) {
/*  41 */       GangManager.sendNormalResult(this.roleid, 111, new Object[0]);
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!GangManager.isLeader(xGang, this.roleid)) {
/*  47 */       GangManager.sendNormalResult(this.roleid, 111, new Object[0]);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     xbean.Gang xApplicantGang = GangManager.getXGang(this.applicantGangid, true);
/*  52 */     if (xApplicantGang == null) {
/*  53 */       GangManager.sendNormalResult(this.roleid, 112, new Object[0]);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     GangCombine xCombine = GangManager.getXCombine(gangid.longValue(), true);
/*  58 */     GangCombine xApplicantCombine = GangManager.getXCombine(this.applicantGangid, true);
/*  59 */     if ((xCombine == null) || (xApplicantCombine == null)) {
/*  60 */       GangManager.sendNormalResult(this.roleid, 112, new Object[0]);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     if (xApplicantCombine.getGangid() != gangid.longValue()) {
/*  66 */       GangManager.sendNormalResult(this.roleid, 112, new Object[0]);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     CombiningGangsKey cCombineKey = GangManager.getCCombineKey(gangid.longValue(), this.applicantGangid);
/*     */     
/*     */ 
/*  73 */     GangGlobal xGlobal = GangManager.getAndCreateXGlobal();
/*     */     
/*     */ 
/*  76 */     if (GangManager.isCombining(gangid.longValue(), xCombine, xGlobal)) {
/*  77 */       GangManager.sendNormalResult(this.roleid, 112, new Object[0]);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().get(cCombineKey);
/*  82 */     if (xInfo == null) {
/*  83 */       GangManager.sendNormalResult(this.roleid, 112, new Object[0]);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (xInfo.getIscombining())
/*     */     {
/*  89 */       GangManager.sendNormalResult(this.roleid, 112, new Object[0]);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     int result = -1;
/*  94 */     if (this.reply == 0)
/*     */     {
/*  96 */       xInfo.setIscombining(true);
/*  97 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  98 */       xInfo.setTimestamp(now);
/*     */       
/* 100 */       long old = xCombine.getGangid();
/*     */       
/* 102 */       xCombine.setGangid(this.applicantGangid);
/*     */       
/* 104 */       result = 0;
/*     */       
/*     */ 
/* 107 */       TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_AGREE_MAIL);
/* 108 */       GangManager.sendMail(xApplicantGang, SGangConst.getInstance().COMBINE_AGREED_MAIL, tlogArg, new String[] { xGang.getName() });
/*     */       
/*     */ 
/* 111 */       GangManager.asyncCancelApply(gangid.longValue(), old);
/*     */       
/*     */ 
/* 114 */       GangManager.asyncClearAppyList(gangid.longValue(), xCombine);
/*     */       
/*     */ 
/* 117 */       GangManager.asyncClearAppyList(this.applicantGangid, xApplicantCombine);
/*     */     }
/*     */     else
/*     */     {
/* 121 */       xGlobal.getCombine().remove(cCombineKey);
/*     */       
/* 123 */       xApplicantCombine.setGangid(-1L);
/* 124 */       xCombine.getApplicants().remove(Long.valueOf(this.applicantGangid));
/*     */       
/* 126 */       result = 1;
/*     */       
/*     */ 
/* 129 */       TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_REFUSE_MAIL);
/* 130 */       GangManager.sendMail(xApplicantGang, SGangConst.getInstance().COMBINE_REFUSED_MAIL, tlogArg, new String[] { xGang.getName() });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 135 */     GangManager.broadcastCombineGangApplyResult(this.applicantGangid, xApplicantGang, gangid.longValue(), xGang, result);
/*     */     
/*     */ 
/* 138 */     GangManager.stopApplyCombineTimer(cCombineKey);
/*     */     
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCombineGangApplyRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */