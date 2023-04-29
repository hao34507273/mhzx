/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.partner.event.PartnerPositionChangeProcedure;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.partner.main.PartnerPositionChangeEventArg;
/*    */ import mzm.gsp.partner.main.PartnerPositionChangeEventArg.PositionChangeTye;
/*    */ import xbean.TeamMember;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ public class POnPartnerPositionChange
/*    */   extends PartnerPositionChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleid = ((PartnerPositionChangeEventArg)this.arg).roleId;
/*    */     
/* 22 */     Long teamid = Role2team.get(Long.valueOf(roleid));
/* 23 */     if (teamid == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     xbean.Team xTeam = xtable.Team.get(teamid);
/*    */     
/* 29 */     if (((TeamMember)xTeam.getMembers().get(0)).getRoleid() != roleid)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     Map<Integer, Integer> leaderPartnerMap = PartnerInterface.getFightPartnerListWithoutRole(roleid, false);
/*    */     
/* 35 */     if (!TeamManager.fillDispositionByLeaderPartners(leaderPartnerMap, xTeam))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     Procedure.execute(new PSynTeamDisposition(teamid.longValue()));
/*    */     
/* 42 */     if (((PartnerPositionChangeEventArg)this.arg).changeTye.equals(PartnerPositionChangeEventArg.PositionChangeTye.CHANGE_DEFAULT_LINEUP))
/*    */     {
/* 44 */       TeamManager.synTeamZhenFaInfo(xTeam, roleid);
/*    */     }
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnPartnerPositionChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */