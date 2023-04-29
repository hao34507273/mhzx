/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.apollo.SSynVoipRoomOnlineMembers;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.VoipRoom;
/*    */ import xbean.VoipRoomUserAccess;
/*    */ import xtable.Team_voip_rooms;
/*    */ 
/*    */ public class POnJoinTeam extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((JoinTeamArg)this.arg).getNewGuyRoleId();
/* 20 */     long teamid = ((JoinTeamArg)this.arg).teamid;
/*    */     
/*    */ 
/* 23 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(teamid));
/* 24 */     if (xVoipRoom == null)
/*    */     {
/* 26 */       StringBuilder sb = new StringBuilder();
/* 27 */       sb.append(String.format("[teamvoiproom]POnJoinTeam.processImp@no team voip room|roleid=%d|teamid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid) }));
/*    */       
/* 29 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 30 */       return false;
/*    */     }
/* 32 */     SSynVoipRoomOnlineMembers protocol = new SSynVoipRoomOnlineMembers();
/* 33 */     protocol.voip_room_type = 1;
/* 34 */     for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*    */     {
/* 36 */       if (((VoipRoomUserAccess)entry.getValue()).getRole_state() == 3)
/*    */       {
/* 38 */         protocol.online_member_list.add(entry.getKey());
/*    */       }
/*    */     }
/* 41 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 43 */     StringBuilder sb = new StringBuilder();
/* 44 */     sb.append(String.format("[teamvoiproom]POnJoinTeam.processImp@syn team voip room info success|roleid=%d|teamid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid) }));
/*    */     
/* 46 */     TeamVoipRoomManager.logger.info(sb.toString());
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */