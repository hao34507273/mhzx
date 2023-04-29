/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TryExitTeamVoipRoomSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleid;
/*    */   private final long teamid;
/*    */   
/*    */   public TryExitTeamVoipRoomSession(long roleid, long teamid)
/*    */   {
/* 16 */     super(VoipRoomManager.EXIT_VOIP_ROOM_TIMEOUT, teamid);
/* 17 */     this.roleid = roleid;
/* 18 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryExitTeamVoipRoom(this.roleid, this.teamid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\TryExitTeamVoipRoomSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */