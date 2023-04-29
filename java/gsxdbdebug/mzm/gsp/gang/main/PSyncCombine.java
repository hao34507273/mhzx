/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gang.SSyncCombine;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.CombineGangsInfo;
/*    */ import xbean.Gang;
/*    */ import xbean.GangCombine;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ public class PSyncCombine extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangid;
/*    */   
/*    */   PSyncCombine(long roleid, long gangid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     GangCombine xComine = GangManager.getXCombine(this.gangid, false);
/* 27 */     if (xComine == null) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     SSyncCombine sync = new SSyncCombine();
/*    */     
/*    */ 
/* 34 */     Gang xTargetGang = GangManager.getXGang(xComine.getGangid(), false);
/* 35 */     if (xTargetGang != null) {
/* 36 */       GangManager.fillCombineGangBean(xComine.getGangid(), xTargetGang, sync.target_gang);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */     sync.applicants.addAll(xComine.getApplicants());
/*    */     
/* 49 */     if (xComine.getGangid() > 0L) {
/* 50 */       xbean.CombiningGangsKey cCombineKey = GangManager.getCCombineKey(this.gangid, xComine);
/*    */       
/* 52 */       GangGlobal xGlobal = GangManager.getXGlobal(false);
/*    */       
/* 54 */       CombineGangsInfo xInfo = (CombineGangsInfo)xGlobal.getCombine().get(cCombineKey);
/* 55 */       if (xInfo != null) {
/* 56 */         sync.timestamp = xInfo.getTimestamp();
/*    */       }
/*    */     }
/*    */     
/* 60 */     OnlineManager.getInstance().send(this.roleid, sync);
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSyncCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */