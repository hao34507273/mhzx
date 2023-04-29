/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCReportJoinAndExitVoipRoomReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int voipRoomType;
/*    */   private final int action;
/*    */   
/*    */   public PCReportJoinAndExitVoipRoomReq(long roleid, int voipRoomType, int action)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.voipRoomType = voipRoomType;
/* 19 */     this.action = action;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (this.voipRoomType == 1)
/*    */     {
/*    */ 
/* 28 */       String userid = RoleInterface.getUserId(this.roleid);
/* 29 */       lock(Lockeys.get(User.getTable(), userid));
/* 30 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */       
/* 32 */       Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, true);
/*    */       
/* 34 */       if (teamid == null)
/*    */       {
/* 36 */         return false;
/*    */       }
/* 38 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(teamid, new POnClientReportJoinAndExitTeamVoipRoom(this.roleid, teamid.longValue(), this.action));
/*    */       
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCReportJoinAndExitVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */