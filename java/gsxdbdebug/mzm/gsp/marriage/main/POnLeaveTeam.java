/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import xtable.Role2buff;
/*    */ 
/*    */ public class POnLeaveTeam extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((LeaveTeamArg)this.arg).roleid;
/* 15 */     if (((LeaveTeamArg)this.arg).status == 0) {
/* 16 */       Long marriagaId = xtable.Role2marriage.select(Long.valueOf(roleid));
/* 17 */       if (marriagaId == null) {
/* 18 */         return false;
/*    */       }
/* 20 */       xbean.Marriage xMarriage = xtable.Marriage.select(marriagaId);
/* 21 */       long otherRoleid = xMarriage.getRoleida();
/* 22 */       if (roleid == otherRoleid) {
/* 23 */         otherRoleid = xMarriage.getRoleidb();
/*    */       }
/* 25 */       List<Long> normalRoleList = mzm.gsp.team.main.TeamInterface.getTeamMemberList(((LeaveTeamArg)this.arg).teamid, false);
/* 26 */       if (normalRoleList.contains(Long.valueOf(otherRoleid)))
/*    */       {
/* 28 */         lock(Role2buff.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(otherRoleid) }));
/* 29 */         BuffInterface.uninstallBuf(roleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/* 30 */         BuffInterface.uninstallBuf(otherRoleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/*    */       }
/*    */     }
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */