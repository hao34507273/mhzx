/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.VoipRoom;
/*    */ import xtable.Team_voip_rooms;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CloseTeamVoipRoomSession
/*    */   extends Session
/*    */ {
/*    */   private final long createrid;
/*    */   private final long teamid;
/*    */   
/*    */   public CloseTeamVoipRoomSession(long createrid, long teamid)
/*    */   {
/* 19 */     super(VoipRoomManager.VOIP_ROOM_PROTECT_TIME_IN_SECOND, teamid);
/* 20 */     this.createrid = createrid;
/* 21 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     new PSetTeamVoipRoomState(this.createrid, this.teamid).execute();
/*    */   }
/*    */   
/*    */   static class PSetTeamVoipRoomState extends LogicProcedure
/*    */   {
/*    */     private final long createrid;
/*    */     private final long teamid;
/*    */     
/*    */     public PSetTeamVoipRoomState(long createrid, long teamid)
/*    */     {
/* 37 */       this.createrid = createrid;
/* 38 */       this.teamid = teamid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/* 46 */       if (xVoipRoom == null)
/*    */       {
/* 48 */         StringBuilder sb = new StringBuilder();
/* 49 */         sb.append(String.format("[teamvoiproom]PSetTeamVoipRoomState.processImp@no team voip room|teamid=%d", new Object[] { Long.valueOf(this.teamid) }));
/* 50 */         TeamVoipRoomManager.logger.error(sb.toString());
/* 51 */         return false;
/*    */       }
/* 53 */       if (xVoipRoom.getRoom_state() != 3)
/*    */       {
/* 55 */         StringBuilder sb = new StringBuilder();
/* 56 */         sb.append(String.format("[teamvoiproom]PSetTeamVoipRoomState.processImp@room state error|teamid=%d|room_state=%d", new Object[] { Long.valueOf(this.teamid), Integer.valueOf(xVoipRoom.getRoom_state()) }));
/*    */         
/*    */ 
/* 59 */         TeamVoipRoomManager.logger.error(sb.toString());
/* 60 */         return false;
/*    */       }
/* 62 */       xVoipRoom.setRoom_state(4);
/* 63 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryCloseTeamVoipRoom(this.createrid, this.teamid));
/*    */       
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\CloseTeamVoipRoomSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */