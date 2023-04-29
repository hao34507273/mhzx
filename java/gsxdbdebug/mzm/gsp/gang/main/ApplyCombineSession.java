/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.CombineGangsInfo;
/*    */ import xbean.CombiningGangsKey;
/*    */ import xbean.Gang;
/*    */ import xbean.GangCombine;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ class ApplyCombineSession extends Session
/*    */ {
/*    */   private final long targetGangid;
/*    */   
/*    */   ApplyCombineSession(long interval, long srcGangid, long targetGangid)
/*    */   {
/* 21 */     super(interval, srcGangid);
/* 22 */     this.targetGangid = targetGangid;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     xdb.Procedure.execute(new POnApplyTimeout(getOwerId(), this.targetGangid, getSessionId()));
/*    */   }
/*    */   
/*    */   static class POnApplyTimeout extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long srcGangid;
/*    */     private final long targetGangid;
/*    */     private final long sessionid;
/*    */     
/*    */     POnApplyTimeout(long srcGangid, long targetGangid, long sessionid) {
/* 37 */       this.srcGangid = srcGangid;
/* 38 */       this.targetGangid = targetGangid;
/* 39 */       this.sessionid = sessionid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       lock(xtable.Gangcombine.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.srcGangid), Long.valueOf(this.targetGangid) }));
/*    */       
/* 47 */       GangCombine xSrcCombine = GangManager.getXCombine(this.srcGangid, true);
/* 48 */       GangCombine xTargetCombine = GangManager.getXCombine(this.targetGangid, true);
/*    */       
/* 50 */       if ((xSrcCombine == null) || (xTargetCombine == null)) {
/* 51 */         return false;
/*    */       }
/*    */       
/* 54 */       GangGlobal xGlobal = GangManager.getXGlobal(true);
/* 55 */       if (xGlobal == null) {
/* 56 */         return false;
/*    */       }
/*    */       
/* 59 */       CombiningGangsKey cKey = GangManager.getCCombineKey(this.targetGangid, this.srcGangid);
/* 60 */       CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().get(cKey);
/* 61 */       if (xInfo == null) {
/* 62 */         return false;
/*    */       }
/* 64 */       if (xInfo.getIscombining())
/*    */       {
/* 66 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 70 */       xSrcCombine.setGangid(-1L);
/*    */       
/* 72 */       xTargetCombine.getApplicants().remove(Long.valueOf(this.srcGangid));
/*    */       
/*    */ 
/* 75 */       xGlobal.getCombine().remove(cKey);
/*    */       
/*    */ 
/* 78 */       CombineSessionManager.getInstance().remove(cKey, this.sessionid);
/*    */       
/*    */ 
/* 81 */       Gang xSrcGang = GangManager.getXGang(this.srcGangid, true);
/* 82 */       Gang xTargetGang = GangManager.getXGang(this.targetGangid, true);
/* 83 */       GangManager.broadcastCombineGangApplyResult(this.srcGangid, xSrcGang, this.targetGangid, xTargetGang, 2);
/*    */       
/*    */ 
/*    */ 
/* 87 */       TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_REFUSE_MAIL);
/* 88 */       GangManager.sendMail(xSrcGang, SGangConst.getInstance().COMBINE_REFUSED_MAIL, tlogArg, new String[] { xTargetGang.getName() });
/*    */       
/*    */ 
/* 91 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\ApplyCombineSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */