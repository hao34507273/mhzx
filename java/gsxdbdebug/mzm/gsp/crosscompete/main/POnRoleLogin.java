/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.roam.PRoamRoleLogin;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteSignUp;
/*    */ import xbean.FactionCrossCompete;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 24 */     if (GameServerInfoManager.isRoamServer()) {
/* 25 */       return new PRoamRoleLogin(roleid).call();
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 33 */     RoleStatusInterface.unsetStatus(roleid, 1501);
/*    */     
/*    */ 
/* 36 */     long contextid = TeamBackContextManager.getInstance().getContextidByRoleid(roleid);
/* 37 */     if (contextid >= 0L) {
/* 38 */       if (CrossCompeteManager.isLoggerDebugEnabled()) {
/* 39 */         CrossCompeteManager.logDebug("POnRoleLogin.process@has team context|roleid=%d|contextid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(contextid) });
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 44 */       RoleStatusInterface.unsetStatus(roleid, 1501);
/*    */       
/* 46 */       Executor.getInstance().execute(new RLoginByTeamBack(roleid, contextid));
/*    */     }
/*    */     
/*    */ 
/* 50 */     Gang faction = GangInterface.getGangByRoleId(roleid, false);
/* 51 */     if (faction == null) {
/* 52 */       return true;
/*    */     }
/* 54 */     long factionid = faction.getGangId();
/*    */     
/* 56 */     long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/* 59 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/*    */ 
/* 63 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 64 */     if ((stage == 0) || (stage == 1)) {
/* 65 */       if (xCompete != null) {
/* 66 */         CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)xCompete.getSignup_factions().get(Long.valueOf(factionid));
/* 67 */         if ((xSignUp != null) && (xSignUp.getTime() > activityStartTime)) {
/* 68 */           CrossCompeteManager.syncSignUp(roleid);
/*    */         }
/*    */       }
/*    */     }
/* 72 */     else if ((stage > 1) && 
/* 73 */       (xCompete != null))
/*    */     {
/* 75 */       FactionCrossCompete xFaction = CrossCompeteManager.getXFactionCrossCompete(factionid, false);
/*    */       
/* 77 */       if (xFaction != null) {
/* 78 */         long opponent = xFaction.getOpponent();
/* 79 */         CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, factionid, opponent);
/*    */         
/* 81 */         if (xAgainst != null) {
/* 82 */           CrossCompeteManager.syncMatch(roleid, xAgainst.getCompete_index());
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */