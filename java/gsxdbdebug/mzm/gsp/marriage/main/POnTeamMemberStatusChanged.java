/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Role2buff;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if ((((TeamMemberStatusChangedArg)this.arg).status != 0) && (((TeamMemberStatusChangedArg)this.arg).oldStatus != 0))
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     Long marriagaId = xtable.Role2marriage.select(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid));
/* 19 */     if (marriagaId == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     xbean.Marriage xMarriage = xtable.Marriage.select(marriagaId);
/* 23 */     long otherRoleid = xMarriage.getRoleida();
/* 24 */     if (((TeamMemberStatusChangedArg)this.arg).roleid == otherRoleid) {
/* 25 */       otherRoleid = xMarriage.getRoleidb();
/*    */     }
/* 27 */     if (((TeamMemberStatusChangedArg)this.arg).status == 0)
/*    */     {
/* 29 */       List<Long> normalRoleList = TeamInterface.getNormalRoleList(((TeamMemberStatusChangedArg)this.arg).roleid);
/* 30 */       if (normalRoleList.contains(Long.valueOf(otherRoleid)))
/*    */       {
/* 32 */         lock(Role2buff.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid), Long.valueOf(otherRoleid) }));
/* 33 */         BuffInterface.installBuff(((TeamMemberStatusChangedArg)this.arg).roleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/* 34 */         BuffInterface.installBuff(otherRoleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/*    */       }
/*    */     }
/* 37 */     if (((TeamMemberStatusChangedArg)this.arg).oldStatus == 0) {
/* 38 */       List<Long> normalRoleList = TeamInterface.getNormalRoleList(((TeamMemberStatusChangedArg)this.arg).roleid);
/* 39 */       if (normalRoleList.contains(Long.valueOf(otherRoleid)))
/*    */       {
/* 41 */         lock(Role2buff.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid), Long.valueOf(otherRoleid) }));
/* 42 */         BuffInterface.uninstallBuf(((TeamMemberStatusChangedArg)this.arg).roleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/* 43 */         BuffInterface.uninstallBuf(otherRoleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/*    */       }
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */