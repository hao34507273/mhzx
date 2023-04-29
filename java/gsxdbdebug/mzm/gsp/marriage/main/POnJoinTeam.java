/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ 
/*    */ public class POnJoinTeam extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((JoinTeamArg)this.arg).member.roleid;
/* 15 */     if (((JoinTeamArg)this.arg).member.status == 0) {
/* 16 */       Long marriagaId = xtable.Role2marriage.select(Long.valueOf(roleid));
/* 17 */       if (marriagaId == null) {
/* 18 */         return false;
/*    */       }
/* 20 */       xbean.Marriage xMarriage = xtable.Marriage.select(marriagaId);
/* 21 */       long otherRoleid = xMarriage.getRoleida();
/* 22 */       if (roleid == otherRoleid) {
/* 23 */         otherRoleid = xMarriage.getRoleidb();
/*    */       }
/* 25 */       List<Long> normalRoleList = mzm.gsp.team.main.TeamInterface.getNormalRoleList(roleid);
/* 26 */       if (normalRoleList.contains(Long.valueOf(otherRoleid)))
/*    */       {
/* 28 */         lock(xtable.Role2buff.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(otherRoleid) }));
/* 29 */         BuffInterface.installBuff(roleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/* 30 */         BuffInterface.installBuff(otherRoleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/*    */       }
/*    */     }
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */