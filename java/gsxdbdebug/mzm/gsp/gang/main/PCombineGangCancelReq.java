/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.CombineGangsInfo;
/*     */ import xbean.CombiningGangsKey;
/*     */ import xbean.GangCombine;
/*     */ import xbean.GangGlobal;
/*     */ 
/*     */ public class PCombineGangCancelReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetGangid;
/*     */   
/*     */   public PCombineGangCancelReq(long roleid, long targetGangid)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.targetGangid = targetGangid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*  29 */     if (gangid == null) {
/*  30 */       GangManager.sendNormalResult(this.roleid, 121, new Object[0]);
/*  31 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  35 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(gangid.longValue()), Long.valueOf(this.targetGangid) }));
/*     */     
/*     */ 
/*  38 */     xbean.Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  39 */     if (xGang == null) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!GangManager.isLeader(xGang, this.roleid)) {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     GangCombine xCombine = GangManager.getXCombine(gangid.longValue(), true);
/*  49 */     if (xCombine == null) {
/*  50 */       GangManager.sendNormalResult(this.roleid, 122, new Object[0]);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (xCombine.getGangid() != this.targetGangid) {
/*  56 */       GangManager.sendNormalResult(this.roleid, 122, new Object[0]);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     GangCombine xTargetCombine = GangManager.getXCombine(this.targetGangid, true);
/*     */     
/*  62 */     CombiningGangsKey cCombineKey = null;
/*  63 */     GangCombine xMainCombine = null;
/*  64 */     GangCombine xViceCombine = null;
/*  65 */     if (xCombine.getApplicants().contains(Long.valueOf(this.targetGangid)))
/*     */     {
/*  67 */       xMainCombine = xCombine;
/*  68 */       xViceCombine = xTargetCombine;
/*  69 */       cCombineKey = GangManager.getCCombineKey(gangid.longValue(), this.targetGangid);
/*     */     }
/*     */     else
/*     */     {
/*  73 */       xMainCombine = xTargetCombine;
/*  74 */       xViceCombine = xCombine;
/*  75 */       cCombineKey = GangManager.getCCombineKey(this.targetGangid, gangid.longValue());
/*     */     }
/*     */     
/*     */ 
/*  79 */     xbean.Gang xTargetGang = GangManager.getXGang(this.targetGangid, true);
/*     */     
/*  81 */     long mainDisplayid = xGang.getDisplayid();
/*  82 */     long viceDisplayid = -1L;
/*  83 */     if (xTargetGang != null) {
/*  84 */       viceDisplayid = xTargetGang.getDisplayid();
/*     */     }
/*     */     
/*     */ 
/*  88 */     GangGlobal xGlobal = GangManager.getAndCreateXGlobal();
/*  89 */     CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().remove(cCombineKey);
/*  90 */     if (xInfo == null) {
/*  91 */       GangManager.logError("PCombineGangCancelReq.processImp@error state, no combine info|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(cCombineKey.getFront()), Long.valueOf(mainDisplayid), Long.valueOf(cCombineKey.getBehind()), Long.valueOf(viceDisplayid) });
/*     */       
/*     */ 
/*  94 */       GangManager.sendNormalResult(this.roleid, 122, new Object[0]);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (xInfo.getIscombining())
/*     */     {
/* 100 */       boolean ret = GangManager.cancelCombine(xMainCombine, xViceCombine, cCombineKey, xGlobal);
/* 101 */       if (!ret) {
/* 102 */         GangManager.logError("PCombineGangCancelReq.processImp@cancel combine error|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(cCombineKey.getFront()), Long.valueOf(mainDisplayid), Long.valueOf(cCombineKey.getBehind()), Long.valueOf(viceDisplayid) });
/*     */         
/*     */ 
/* 105 */         return false;
/*     */       }
/*     */       
/* 108 */       TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_CANCEL_MAIL);
/* 109 */       GangManager.sendMail(xGang, SGangConst.getInstance().COMBINE_CANCEL_MAIL, tlogArg, new String[] { xGang.getName() });
/* 110 */       if (xTargetGang != null) {
/* 111 */         GangManager.sendMail(xTargetGang, SGangConst.getInstance().COMBINE_CANCEL_MAIL, tlogArg, new String[] { xGang.getName() });
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 116 */       boolean ret = GangManager.cancelCombineApply(xMainCombine, xViceCombine, cCombineKey, xGlobal);
/* 117 */       if (!ret) {
/* 118 */         GangManager.logError("PCombineGangCancelReq.processImp@cancel apply error|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(cCombineKey.getFront()), Long.valueOf(mainDisplayid), Long.valueOf(cCombineKey.getBehind()), Long.valueOf(viceDisplayid) });
/*     */         
/*     */ 
/* 121 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 126 */     GangManager.broadcastCombineGangCancel(gangid.longValue(), xGang, true, this.targetGangid, xTargetGang, true);
/*     */     
/* 128 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCombineGangCancelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */