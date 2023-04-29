/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.SCheckTeamMemberNum;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class PCheckTeamMemberNumReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long roleBeCheckedId;
/*    */   
/*    */   public PCheckTeamMemberNumReq(long roleId, long roleBeCheckedId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.roleBeCheckedId = roleBeCheckedId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     SCheckTeamMemberNum sCheckTeamMemberNum = new SCheckTeamMemberNum();
/* 25 */     sCheckTeamMemberNum.rolebecheckedid = this.roleBeCheckedId;
/*    */     
/* 27 */     Long teamid = Role2team.get(Long.valueOf(this.roleBeCheckedId));
/* 28 */     if (teamid == null)
/*    */     {
/* 30 */       sCheckTeamMemberNum.teammembernum = 0;
/* 31 */       sCheckTeamMemberNum.team = 0L;
/*    */     }
/*    */     else
/*    */     {
/* 35 */       xbean.Team xTeam = xtable.Team.get(teamid);
/* 36 */       sCheckTeamMemberNum.teammembernum = xTeam.getMembers().size();
/* 37 */       sCheckTeamMemberNum.team = teamid.longValue();
/*    */     }
/* 39 */     OnlineManager.getInstance().send(this.roleId, sCheckTeamMemberNum);
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PCheckTeamMemberNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */