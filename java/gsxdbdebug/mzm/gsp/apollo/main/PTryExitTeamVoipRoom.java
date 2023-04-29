/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloExitVoipRoomRsp;
/*     */ import mzm.gsp.apollo.SSynVoipRoomOnlineMembers;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xbean.VoipRoomUserAccess;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2voip_room;
/*     */ import xtable.Team_voip_rooms;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PTryExitTeamVoipRoom extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   
/*     */   public PTryExitTeamVoipRoom(long roleid, long teamid)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.teamid = teamid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */     {
/*     */ 
/*  39 */       onFail(222, null, false);
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  45 */     lock(Lockeys.get(User.getTable(), userid));
/*  46 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*  49 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  50 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  53 */       onFail(228, null, true);
/*  54 */       return false;
/*     */     }
/*  56 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  60 */       Map<String, Object> extraInfo = new HashMap();
/*  61 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  62 */       onFail(229, extraInfo, false);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     VoipRoomUserAccess xVoipRoomUserAccess = (VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*  67 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*     */ 
/*  70 */       onFail(228, null, true);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     switch (xVoipRoomUserAccess.getRole_state())
/*     */     {
/*     */ 
/*     */ 
/*     */     case 1: 
/*     */     case 6: 
/*  80 */       Map<String, Object> extraInfo = new HashMap();
/*  81 */       extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/*  82 */       onFail(230, extraInfo, false);
/*  83 */       return false;
/*     */     
/*     */ 
/*     */     case 2: 
/*     */     case 3: 
/*     */     case 4: 
/*  89 */       xVoipRoomUserAccess.setTry_exit_times(0);
/*  90 */       xVoipRoomUserAccess.setRole_state(5);
/*  91 */       xVoipRoomUserAccess.setTry_exit_times(xVoipRoomUserAccess.getTry_exit_times() + 1);
/*     */       
/*  93 */       OctetsStream context = new OctetsStream();
/*  94 */       context.marshal(1);
/*  95 */       context.marshal(this.teamid);
/*  96 */       TryExitTeamVoipRoomSession session = new TryExitTeamVoipRoomSession(this.roleid, this.teamid);
/*  97 */       context.marshal(session.getSessionId());
/*  98 */       if (!ApolloInterface.sendApolloExitVoipRoom(userid, this.roleid, xVoipRoom.getRoom_id(), xVoipRoomUserAccess.getMember_id(), context))
/*     */       {
/*     */ 
/*     */ 
/* 102 */         Session.removeSession(session.getSessionId(), session.getOwerId());
/* 103 */         xVoipRoomUserAccess.setRole_state(6);
/* 104 */         xVoipRoom.getMembers().remove(Long.valueOf(this.roleid));
/* 105 */         Role2voip_room.remove(Long.valueOf(this.roleid));
/*     */         
/* 107 */         SApolloExitVoipRoomRsp protocol = new SApolloExitVoipRoomRsp();
/* 108 */         protocol.retcode = 0;
/* 109 */         protocol.voip_room_type = 1;
/* 110 */         protocol.room_id = xVoipRoom.getRoom_id();
/* 111 */         protocol.member_id = xVoipRoomUserAccess.getMember_id();
/* 112 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 114 */         StringBuilder sb = new StringBuilder();
/* 115 */         sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@send to apollo error, exit team voip room|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */         
/*     */ 
/* 118 */         TeamVoipRoomManager.logger.info(sb.toString());
/* 119 */         return true;
/*     */       }
/*     */       
/* 122 */       if (VoipRoomManager.IS_DEBUG_MODE)
/*     */       {
/* 124 */         VoipRoomTestManager.onApolloExitVoipRoomRsp(userid, this.roleid, xVoipRoom.getRoom_id(), context);
/*     */       }
/*     */       
/*     */ 
/* 128 */       boolean needStartCloseTeamVoipRoomSession = xVoipRoom.getRoom_state() == 2;
/* 129 */       SSynVoipRoomOnlineMembers protocol = new SSynVoipRoomOnlineMembers();
/* 130 */       protocol.voip_room_type = 1;
/* 131 */       for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */       {
/* 133 */         if (((VoipRoomUserAccess)entry.getValue()).getRole_state() == 3)
/*     */         {
/* 135 */           protocol.online_member_list.add(entry.getKey());
/* 136 */           needStartCloseTeamVoipRoomSession = false;
/*     */         }
/*     */       }
/* 139 */       OnlineManager.getInstance().sendMulti(protocol, protocol.online_member_list);
/* 140 */       if (needStartCloseTeamVoipRoomSession)
/*     */       {
/* 142 */         xVoipRoom.setRoom_state(3);
/* 143 */         xVoipRoom.setClose_sessionid(new CloseTeamVoipRoomSession(xVoipRoom.getCreater_id(), this.teamid).getSessionId());
/* 144 */         StringBuilder sb = new StringBuilder();
/* 145 */         sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@start close team voip room session|teamid=%d|sessionid=%d", new Object[] { Long.valueOf(this.teamid), Long.valueOf(xVoipRoom.getClose_sessionid()) }));
/*     */         
/*     */ 
/* 148 */         TeamVoipRoomManager.logger.info(sb.toString());
/*     */       }
/*     */       
/* 151 */       StringBuilder sb = new StringBuilder();
/* 152 */       sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@try exit team voip room success|roleid=%d|teamid=%d|times=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(xVoipRoomUserAccess.getTry_exit_times()) }));
/*     */       
/*     */ 
/* 155 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 156 */       return true;
/*     */     
/*     */ 
/*     */     case 5: 
/* 160 */       if (xVoipRoomUserAccess.getTry_exit_times() >= VoipRoomManager.EXIT_VOIP_ROOM_TRY_TIMES)
/*     */       {
/*     */ 
/* 163 */         xVoipRoomUserAccess.setRole_state(6);
/* 164 */         xVoipRoom.getMembers().remove(Long.valueOf(this.roleid));
/* 165 */         Role2voip_room.remove(Long.valueOf(this.roleid));
/*     */         
/* 167 */         SApolloExitVoipRoomRsp protocol = new SApolloExitVoipRoomRsp();
/* 168 */         protocol.retcode = 0;
/* 169 */         protocol.voip_room_type = 1;
/* 170 */         protocol.room_id = xVoipRoom.getRoom_id();
/* 171 */         protocol.member_id = xVoipRoomUserAccess.getMember_id();
/* 172 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 174 */         StringBuilder sb = new StringBuilder();
/* 175 */         sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@try exit team voip room to max try times|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */         
/*     */ 
/* 178 */         TeamVoipRoomManager.logger.info(sb.toString());
/* 179 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 184 */       xVoipRoomUserAccess.setTry_exit_times(xVoipRoomUserAccess.getTry_exit_times() + 1);
/* 185 */       OctetsStream context = new OctetsStream();
/* 186 */       context.marshal(1);
/* 187 */       context.marshal(this.teamid);
/* 188 */       TryExitTeamVoipRoomSession session = new TryExitTeamVoipRoomSession(this.roleid, this.teamid);
/* 189 */       context.marshal(session.getSessionId());
/* 190 */       if (!ApolloInterface.sendApolloExitVoipRoom(userid, this.roleid, xVoipRoom.getRoom_id(), xVoipRoomUserAccess.getMember_id(), context))
/*     */       {
/*     */ 
/*     */ 
/* 194 */         Session.removeSession(session.getSessionId(), session.getOwerId());
/* 195 */         xVoipRoomUserAccess.setRole_state(6);
/* 196 */         xVoipRoom.getMembers().remove(Long.valueOf(this.roleid));
/* 197 */         Role2voip_room.remove(Long.valueOf(this.roleid));
/*     */         
/* 199 */         SApolloExitVoipRoomRsp protocol = new SApolloExitVoipRoomRsp();
/* 200 */         protocol.retcode = 0;
/* 201 */         protocol.voip_room_type = 1;
/* 202 */         protocol.room_id = xVoipRoom.getRoom_id();
/* 203 */         protocol.member_id = xVoipRoomUserAccess.getMember_id();
/* 204 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 206 */         StringBuilder sb = new StringBuilder();
/* 207 */         sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@send to apollo error, exit team voip room|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */         
/*     */ 
/* 210 */         TeamVoipRoomManager.logger.info(sb.toString());
/* 211 */         return true;
/*     */       }
/*     */       
/* 214 */       if (VoipRoomManager.IS_DEBUG_MODE)
/*     */       {
/* 216 */         VoipRoomTestManager.onApolloExitVoipRoomRsp(userid, this.roleid, xVoipRoom.getRoom_id(), context);
/*     */       }
/* 218 */       StringBuilder sb = new StringBuilder();
/* 219 */       sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@try exit team voip room success|roleid=%d|teamid=%d|times=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(xVoipRoomUserAccess.getTry_exit_times()) }));
/*     */       
/*     */ 
/* 222 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 223 */       return true;
/*     */     }
/*     */     
/*     */     
/* 227 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/* 233 */     StringBuilder sb = new StringBuilder();
/* 234 */     sb.append(String.format("[teamvoiproom]PTryExitTeamVoipRoom.processImp@try exit voip room fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 237 */     if (extraInfo != null)
/*     */     {
/* 239 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 241 */         sb.append("|").append((String)entry.getKey());
/* 242 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 245 */     if (isError)
/*     */     {
/* 247 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 251 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PTryExitTeamVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */