/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TryCloseTeamVoipRoomSession
/*    */   extends Session
/*    */ {
/*    */   private final long createrid;
/*    */   private final long teamid;
/*    */   
/*    */   public TryCloseTeamVoipRoomSession(long createrid, long teamid)
/*    */   {
/* 16 */     super(VoipRoomManager.CLOSE_VOIP_ROOM_TIMEOUT, teamid);
/* 17 */     this.createrid = createrid;
/* 18 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryCloseTeamVoipRoom(this.createrid, this.teamid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\TryCloseTeamVoipRoomSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */