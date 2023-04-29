/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.VoipRoom;
/*    */ import xtable.Team_voip_rooms;
/*    */ 
/*    */ public class POnTeamDissolve
/*    */   extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long teamid = ((TeamDissolveArg)this.arg).teamid;
/*    */     
/* 17 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(teamid));
/* 18 */     if (xVoipRoom == null)
/*    */     {
/* 20 */       StringBuilder sb = new StringBuilder();
/* 21 */       sb.append(String.format("[teamvoiproom]POnTeamDissolve.processImp@no team voip room|teamid=%d", new Object[] { Long.valueOf(teamid) }));
/* 22 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 23 */       return false;
/*    */     }
/* 25 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*    */     {
/*    */ 
/* 28 */       StringBuilder sb = new StringBuilder();
/* 29 */       sb.append(String.format("[teamvoiproom]POnTeamDissolve.processImp@team voip room state error|teamid=%d|room_state=%d", new Object[] { Long.valueOf(teamid), Integer.valueOf(xVoipRoom.getRoom_state()) }));
/*    */       
/*    */ 
/* 32 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 33 */       return false;
/*    */     }
/* 35 */     if (xVoipRoom.getRoom_state() == 3)
/*    */     {
/* 37 */       StringBuilder sb = new StringBuilder();
/* 38 */       sb.append(String.format("[teamvoiproom]POnTeamDissolve.processImp@remove close team voip room session|teamid=%d|sessionid=%d", new Object[] { Long.valueOf(teamid), Long.valueOf(xVoipRoom.getClose_sessionid()) }));
/*    */       
/*    */ 
/* 41 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 42 */       Session.removeSession(xVoipRoom.getClose_sessionid(), teamid);
/* 43 */       xVoipRoom.setClose_sessionid(-1L);
/*    */     }
/* 45 */     xVoipRoom.setRoom_state(4);
/* 46 */     TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(teamid), new PTryCloseTeamVoipRoom(xVoipRoom.getCreater_id(), teamid));
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */