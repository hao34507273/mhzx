/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CombiningGangsKey;
/*    */ import xbean.GangCombine;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ class RClearCombineByDissolve extends LogicRunnable
/*    */ {
/*    */   private final long gangid;
/*    */   
/*    */   RClearCombineByDissolve(long gangid)
/*    */   {
/* 21 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 27 */     GangCombine xCombine = GangManager.getXCombine(this.gangid, false);
/*    */     
/* 29 */     if (xCombine == null) {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (xCombine.getGangid() > 0L) {
/* 34 */       if (xCombine.getApplicants().contains(Long.valueOf(xCombine.getGangid()))) {
/* 35 */         new PCancelCombineOrApply(this.gangid, xCombine.getGangid(), true).call();
/*    */       }
/*    */       else {
/* 38 */         new PCancelCombineOrApply(xCombine.getGangid(), this.gangid, false).call();
/*    */       }
/*    */     }
/*    */     
/* 42 */     for (Iterator i$ = xCombine.getApplicants().iterator(); i$.hasNext();) { long applicantid = ((Long)i$.next()).longValue();
/* 43 */       if (applicantid != xCombine.getGangid())
/*    */       {
/*    */ 
/* 46 */         new PCancelCombineOrApply(this.gangid, applicantid, true).call();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PCancelCombineOrApply extends LogicProcedure
/*    */   {
/*    */     private final long mainGangid;
/*    */     private final long viceGangid;
/*    */     private final boolean isMainGang;
/*    */     
/*    */     PCancelCombineOrApply(long mainGangid, long viceGangid, boolean isMainGang)
/*    */     {
/* 59 */       this.mainGangid = mainGangid;
/* 60 */       this.viceGangid = viceGangid;
/* 61 */       this.isMainGang = isMainGang;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 67 */       lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.mainGangid), Long.valueOf(this.viceGangid) }));
/*    */       
/* 69 */       GangCombine xMainCombine = GangManager.getXCombine(this.mainGangid, true);
/* 70 */       GangCombine xViceCombine = GangManager.getXCombine(this.viceGangid, true);
/*    */       
/*    */ 
/* 73 */       GangGlobal xGlobal = GangManager.getXGlobal(true);
/* 74 */       CombiningGangsKey cCombineKey = GangManager.getCCombineKey(this.mainGangid, this.viceGangid);
/*    */       
/* 76 */       boolean ret = GangManager.cancelCombineOrApply(xMainCombine, xViceCombine, cCombineKey, xGlobal);
/*    */       
/* 78 */       if (ret)
/*    */       {
/* 80 */         xbean.Gang xNotifyGang = null;
/* 81 */         if (this.isMainGang) {
/* 82 */           xNotifyGang = GangManager.getXGang(this.viceGangid, true);
/*    */         }
/*    */         else {
/* 85 */           xNotifyGang = GangManager.getXGang(this.mainGangid, true);
/*    */         }
/*    */         
/* 88 */         if (xNotifyGang != null)
/*    */         {
/* 90 */           GangManager.broadcastCombineGangCancel(this.viceGangid, this.mainGangid, Arrays.asList(new Long[] { Long.valueOf(xNotifyGang.getBangzhuid()) }));
/*    */           
/*    */ 
/* 93 */           TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_FAIL_BY_DISSOLVE_MAIL);
/* 94 */           GangManager.sendMail(xNotifyGang, SGangConst.getInstance().COMBINE_FAIL_BY_DISSOLVE_MAIL, tlogArg, new String[0]);
/*    */         }
/*    */       }
/*    */       
/* 98 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RClearCombineByDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */