/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.teamplatform.SLeaderCancelMatch;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MatchActivityCfg;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamLeaderChanged
/*    */   extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     return onLeaderChange(((TeamLeaderChangedArg)this.arg).oldLeader, ((TeamLeaderChangedArg)this.arg).teamid);
/*    */   }
/*    */   
/*    */ 
/*    */   static boolean onLeaderChange(long oldLeader, long teamId)
/*    */   {
/* 30 */     Procedure.execute(new PClearMembersProtectState(teamId, oldLeader));
/*    */     
/* 32 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, false);
/* 33 */     if (teamInfo != null)
/*    */     {
/* 35 */       List<Long> members = teamInfo.getTeamMemberList();
/* 36 */       OnlineManager.getInstance().sendMulti(new SLeaderCancelMatch(), members);
/*    */     }
/*    */     
/*    */ 
/* 40 */     if (!checkAndCancelMatch(oldLeader))
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean checkAndCancelMatch(long oldLeaderId)
/*    */   {
/* 55 */     MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(oldLeaderId, false);
/* 56 */     if (matchData == null)
/*    */     {
/* 58 */       return true;
/*    */     }
/* 60 */     if (!TeamMatchMananger.cancelMatch(oldLeaderId, CancelMatchType.CHANGE_LEADER_CANCEL, matchData))
/*    */     {
/* 62 */       TeamMatchMananger.logger.error(String.format("[teamMatch]POnTeamLeaderChanged.processImp@玩家更换队长时，取消匹配失败|roleId", new Object[] { Long.valueOf(oldLeaderId) }));
/*    */       
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */