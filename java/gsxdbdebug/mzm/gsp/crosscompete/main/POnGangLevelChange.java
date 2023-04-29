/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.gang.event.GangLevelChangeArg;
/*    */ import mzm.gsp.gang.event.GangLevelChangeProcedure;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.CrossCompete;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangLevelChange
/*    */   extends GangLevelChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/* 25 */     long startTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/* 28 */     if ((stage == 0) && 
/* 29 */       (((GangLevelChangeArg)this.arg).oldLevel >= SCrossCompeteConsts.getInstance().Scale) && (((GangLevelChangeArg)this.arg).newLevel < SCrossCompeteConsts.getInstance().Scale))
/*    */     {
/*    */ 
/* 32 */       Gang faction = GangInterface.getGang(((GangLevelChangeArg)this.arg).gangId, true);
/*    */       
/* 34 */       CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*    */       
/* 36 */       CrossCompeteManager.cancelSignUp(xCompete, ((GangLevelChangeArg)this.arg).gangId, faction, startTime);
/*    */       
/*    */ 
/* 39 */       TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_LEVEL_FAIL);
/* 40 */       List<String> contentArgs = new ArrayList();
/* 41 */       contentArgs.add(String.valueOf(SCrossCompeteConsts.getInstance().Scale));
/* 42 */       GangInterface.sendGangMail(faction.getGangId(), SCrossCompeteConsts.getInstance().ScaleFailMail, contentArgs, null, tlogArg);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnGangLevelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */