/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ 
/*    */ 
/*    */ public class PLeaveArenaMapReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PLeaveArenaMapReq(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 8, false)) {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 32 */     if ((team != null) && 
/* 33 */       (team.isNormalState(this.roleid)) && 
/* 34 */       (team.getTeamAllMembersNum() > 1)) {
/* 35 */       ArenaManager.sendNormalResult(this.roleid, 12, new String[0]);
/*    */       
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 50 */     ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(this.roleid);
/* 51 */     xScore.setParticipated(true);
/*    */     
/*    */ 
/* 54 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmp(true);
/* 55 */     return ArenaManager.checkAndLeaveActivityWorld(this.roleid, xArenaTmp);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PLeaveArenaMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */