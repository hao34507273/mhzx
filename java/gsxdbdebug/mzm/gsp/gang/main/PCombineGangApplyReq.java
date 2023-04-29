/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteInterface;
/*     */ import mzm.gsp.gang.SCombineGangApplyRes;
/*     */ import mzm.gsp.gang.SCombineGangApplyTrs;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GangCombine;
/*     */ import xbean.GangGlobal;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ public class PCombineGangApplyReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetGangid;
/*     */   
/*     */   public PCombineGangApplyReq(long roleid, long targetGangid)
/*     */   {
/*  22 */     this.roleid = roleid;
/*  23 */     this.targetGangid = targetGangid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*     */     
/*  30 */     if (gangid == null) {
/*  31 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  35 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  38 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(gangid.longValue()), Long.valueOf(this.targetGangid) }));
/*     */     
/*  40 */     xbean.Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  41 */     xbean.Gang xTargetGang = GangManager.getXGang(this.targetGangid, true);
/*     */     
/*  43 */     if (xGang == null) {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     if (!GangManager.isLeader(xGang, this.roleid)) {
/*  49 */       GangManager.sendNormalResult(this.roleid, 101, new Object[0]);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (xTargetGang == null) {
/*  54 */       GangManager.sendNormalResult(this.roleid, 102, new Object[0]);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long mainDisplayid = xTargetGang.getDisplayid();
/*  59 */     long viceDisplayid = xGang.getDisplayid();
/*     */     
/*  61 */     GangCombine xCombine = GangManager.getAndCreateXCombine(gangid.longValue());
/*  62 */     GangCombine xTargetCombine = GangManager.getAndCreateXCombine(this.targetGangid);
/*     */     
/*     */ 
/*  65 */     GangGlobal xGlobal = GangManager.getAndCreateXGlobal();
/*     */     
/*     */ 
/*  68 */     if (GangManager.isCombiningOrApplyCombine(xCombine)) {
/*  69 */       GangManager.sendNormalResult(this.roleid, 103, new Object[0]);
/*     */       
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     if (GangManager.hasCombineApplicant(xCombine, this.targetGangid)) {
/*  76 */       GangManager.sendNormalResult(this.roleid, 104, new Object[0]);
/*     */       
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (CrossCompeteInterface.hasSignedUp(gangid.longValue())) {
/*  83 */       GangManager.sendNormalResult(this.roleid, 105, new Object[0]);
/*     */       
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     GangManager.applyCombine(gangid.longValue(), xCombine, this.targetGangid, xTargetCombine, xGlobal);
/*     */     
/*     */ 
/*  92 */     GangManager.logInfo("PCombineGangApplyReq.processImp@apply combine|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(this.targetGangid), Long.valueOf(mainDisplayid), gangid, Long.valueOf(viceDisplayid) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     SCombineGangApplyRes res = new SCombineGangApplyRes();
/*  98 */     res.targetid = this.targetGangid;
/*  99 */     res.target_name = xTargetGang.getName();
/* 100 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/*     */ 
/* 103 */     SCombineGangApplyTrs trs = new SCombineGangApplyTrs();
/* 104 */     GangManager.fillCombineGangBean(gangid.longValue(), xGang, trs.applicant);
/* 105 */     OnlineManager.getInstance().send(xTargetGang.getBangzhuid(), trs);
/*     */     
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCombineGangApplyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */