/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossCompete;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PCheckCancelSignUpByVitality
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   private final int vitality;
/*    */   
/*    */   public PCheckCancelSignUpByVitality(long factionid, int vitality)
/*    */   {
/* 26 */     this.factionid = factionid;
/* 27 */     this.vitality = vitality;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (CrossCompeteManager.simplified) {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (this.vitality >= SCrossCompeteConsts.getInstance().Liveness) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/* 42 */     if (stage != 0) {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     Gang faction = GangInterface.getGang(this.factionid, false);
/*    */     
/* 49 */     long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/*    */ 
/* 53 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/* 54 */     if (xCompete == null) {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     boolean ret = CrossCompeteManager.cancelSignUp(xCompete, this.factionid, faction, activityStartTime);
/* 59 */     if (!ret) {
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_ACTIVENESS_FAIL, this.vitality);
/* 65 */     List<String> contentArgs = new ArrayList();
/* 66 */     contentArgs.add(String.valueOf(SCrossCompeteConsts.getInstance().Liveness));
/*    */     
/* 68 */     GangInterface.sendGangMail(this.factionid, SCrossCompeteConsts.getInstance().LivenessFailMail, contentArgs, null, tlogArg);
/*    */     
/*    */ 
/* 71 */     CrossCompeteManager.logInfo("PCheckCancelSignUpByVitality.processImp@cancel sign up|factionid=%d|vitality=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(this.vitality) });
/*    */     
/*    */ 
/*    */ 
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PCheckCancelSignUpByVitality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */