/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.CrossCompete;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLeaveGang
/*    */   extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/* 29 */     long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/* 32 */     if (stage == 0)
/*    */     {
/* 34 */       if (!CrossCompeteManager.simplified)
/*    */       {
/* 36 */         Gang faction = GangInterface.getGang(((LeaveGangArg)this.arg).gangId, false);
/* 37 */         if (faction != null)
/*    */         {
/*    */ 
/* 40 */           int qualifiedRoleNumber = 0;
/* 41 */           int needRoleLevel = ServerInterface.getCurrentServerLevel() - SCrossCompeteConsts.getInstance().MinusSeverLevel;
/*    */           
/* 43 */           for (Iterator i$ = faction.getMemberList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */             
/* 45 */             int level = RoleInterface.getLevel(r);
/* 46 */             if (level >= needRoleLevel) {
/* 47 */               qualifiedRoleNumber++;
/*    */             }
/*    */           }
/* 50 */           if (qualifiedRoleNumber < SCrossCompeteConsts.getInstance().PlayerNumberOfQualifiedLevel)
/*    */           {
/* 52 */             CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*    */             
/* 54 */             boolean ret = CrossCompeteManager.cancelSignUp(xCompete, ((LeaveGangArg)this.arg).gangId, faction, activityStartTime);
/*    */             
/* 56 */             if (ret)
/*    */             {
/* 58 */               TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_PLAYER_NUMBER_FAIL);
/* 59 */               List<String> contentArgs = new ArrayList();
/* 60 */               contentArgs.add(String.valueOf(SCrossCompeteConsts.getInstance().MinusSeverLevel));
/* 61 */               contentArgs.add(String.valueOf(SCrossCompeteConsts.getInstance().PlayerNumberOfQualifiedLevel));
/* 62 */               GangInterface.sendGangMail(faction.getGangId(), SCrossCompeteConsts.getInstance().PlayerNumberFailMail, contentArgs, null, tlogArg);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnLeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */