/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg;
/*    */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg.ChangeZhenFaIdType;
/*    */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdProcedure;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ public class POnChangePartnerZhenFaId
/*    */   extends ChangePartnerZhenFaIdProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!((ChangePartnerZhenFaIdArg)this.arg).type.equals(ChangePartnerZhenFaIdArg.ChangeZhenFaIdType.PARTNER))
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     long roleid = ((ChangePartnerZhenFaIdArg)this.arg).roleId;
/*    */     
/* 23 */     Long teamid = Role2team.select(Long.valueOf(roleid));
/* 24 */     if (teamid == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*    */     
/* 30 */     if (((TeamMember)xTeam.getMembers().get(0)).getRoleid() != roleid)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     TeamManager.synTeamZhenFaInfo(xTeam, roleid);
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnChangePartnerZhenFaId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */