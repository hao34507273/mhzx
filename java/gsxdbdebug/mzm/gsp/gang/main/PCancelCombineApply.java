/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.CombiningGangsKey;
/*    */ import xbean.GangCombine;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ class PCancelCombineApply extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long mainGangid;
/*    */   private final long viceGangid;
/*    */   private final boolean mailViceGang;
/*    */   
/*    */   PCancelCombineApply(long mainGangid, long viceGangid, boolean mailViceGang)
/*    */   {
/* 17 */     this.mainGangid = mainGangid;
/* 18 */     this.viceGangid = viceGangid;
/* 19 */     this.mailViceGang = mailViceGang;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     lock(xtable.Gang.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.mainGangid), Long.valueOf(this.viceGangid) }));
/*    */     
/* 27 */     GangCombine xMainCombine = GangManager.getXCombine(this.mainGangid, true);
/* 28 */     GangCombine xViceCombine = GangManager.getXCombine(this.viceGangid, true);
/*    */     
/* 30 */     if ((xMainCombine == null) || (xViceCombine == null)) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     GangGlobal xGlobal = GangManager.getXGlobal(true);
/*    */     
/* 36 */     CombiningGangsKey cCombineKey = GangManager.getCCombineKey(this.mainGangid, this.viceGangid);
/* 37 */     boolean ret = GangManager.cancelCombineApply(xMainCombine, xViceCombine, cCombineKey, xGlobal);
/*    */     
/* 39 */     xbean.Gang xMainGang = GangManager.getXGang(this.mainGangid, true);
/* 40 */     xbean.Gang xViceGang = GangManager.getXGang(this.viceGangid, true);
/*    */     
/* 42 */     long mainDisplayid = -1L;
/* 43 */     long viceDisplayid = -1L;
/*    */     
/* 45 */     if (xMainGang != null) {
/* 46 */       mainDisplayid = xMainGang.getDisplayid();
/*    */     }
/* 48 */     if (xViceGang != null) {
/* 49 */       viceDisplayid = xViceGang.getDisplayid();
/*    */     }
/*    */     
/* 52 */     if (ret)
/*    */     {
/* 54 */       GangManager.broadcastCombineGangCancel(this.viceGangid, xViceGang, true, this.mainGangid, xMainGang, true);
/*    */       
/*    */ 
/* 57 */       if (this.mailViceGang)
/*    */       {
/* 59 */         TLogArg tlogArg = new TLogArg(mzm.gsp.tlog.LogReason.GANG_COMBINE_REFUSE_MAIL);
/* 60 */         GangManager.sendMail(xViceGang, SGangConst.getInstance().COMBINE_REFUSED_MAIL, tlogArg, new String[] { xMainGang.getName() });
/*    */       }
/*    */       
/*    */ 
/* 64 */       CombineSessionManager.getInstance().remove(cCombineKey);
/*    */       
/* 66 */       GangManager.logInfo("PCancelCombineApply.processImp@cancel combine apply succeed|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(this.mainGangid), Long.valueOf(mainDisplayid), Long.valueOf(this.viceGangid), Long.valueOf(viceDisplayid) });
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 71 */       GangManager.logError("PCancelCombineApply.processImp@cancel combine apply failed|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(this.mainGangid), Long.valueOf(mainDisplayid), Long.valueOf(this.viceGangid), Long.valueOf(viceDisplayid) });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCancelCombineApply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */