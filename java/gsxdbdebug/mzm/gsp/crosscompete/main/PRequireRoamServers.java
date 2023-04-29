/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ 
/*    */ 
/*    */ 
/*    */ class PRequireRoamServers
/*    */   extends LogicProcedure
/*    */ {
/*    */   private boolean firstTime;
/*    */   private RequireRoamServersObserver observer;
/*    */   
/*    */   PRequireRoamServers(boolean firstTime, RequireRoamServersObserver observer)
/*    */   {
/* 23 */     this.firstTime = firstTime;
/* 24 */     this.observer = observer;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/* 31 */     long startTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/* 34 */     if (this.firstTime) {
/* 35 */       if ((stage < 4) || (stage >= 7))
/*    */       {
/* 37 */         if (this.observer != null) {
/* 38 */           this.observer.stopTimer();
/*    */         }
/* 40 */         return false;
/*    */       }
/*    */       
/*    */     }
/* 44 */     else if ((stage < 9) || (stage >= 12))
/*    */     {
/* 46 */       if (this.observer != null) {
/* 47 */         this.observer.stopTimer();
/*    */       }
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 54 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 55 */     if (xCompete == null) {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     List<Integer> competes = new ArrayList();
/*    */     
/* 61 */     for (CrossCompeteAgainst xAgainst : xCompete.getAgainsts().values()) {
/* 62 */       if ((xAgainst.getRoam_serverid() < 0) && 
/*    */       
/*    */ 
/* 65 */         (CrossCompeteConfigManager.isInFirstCompeteTime(xAgainst.getCompete_index()) == this.firstTime))
/*    */       {
/*    */ 
/* 68 */         competes.add(Integer.valueOf(xAgainst.getCompete_index()));
/*    */       }
/*    */     }
/* 71 */     if (!competes.isEmpty()) {
/* 72 */       boolean ret = CrossServerInterface.requireCrossCompeteRoamServers(startTime, competes);
/* 73 */       CrossCompeteManager.logInfo("PRequireRoamServers.processImp@require roam servers|is_frist_time=%b|competes=%s|ret=%b", new Object[] { Boolean.valueOf(this.firstTime), competes, Boolean.valueOf(ret) });
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 78 */       if (this.observer != null) {
/* 79 */         this.observer.stopTimer();
/*    */       }
/* 81 */       CrossCompeteManager.logInfo("PRequireRoamServers.processImp@no need to require roam servers", new Object[0]);
/*    */     }
/*    */     
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PRequireRoamServers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */