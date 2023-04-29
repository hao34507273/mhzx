/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloJoinVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleVoipRoom;
/*     */ import xbean.VoipRoom;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2voip_room;
/*     */ import xtable.Team_voip_rooms;
/*     */ 
/*     */ public class PJoinTeamVoipRoomReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   
/*     */   public PJoinTeamVoipRoomReq(long roleid, long teamid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.teamid = teamid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */     {
/*     */ 
/*  38 */       onFail(222, null, false, true);
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  44 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  45 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  47 */     if (VoipRoomManager.isRoleInOtherVoipRoom(this.roleid, 1, this.teamid))
/*     */     {
/*     */ 
/*  50 */       onFail(223, null, false, true);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!TeamVoipRoomManager.isRoleInThisTeam(this.roleid, this.teamid))
/*     */     {
/*     */ 
/*  57 */       onFail(224, null, false, true);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  63 */     if (xVoipRoom == null)
/*     */     {
/*  65 */       xVoipRoom = Pod.newVoipRoom();
/*  66 */       Team_voip_rooms.insert(Long.valueOf(this.teamid), xVoipRoom);
/*     */     }
/*     */     
/*  69 */     switch (xVoipRoom.getRoom_state())
/*     */     {
/*     */ 
/*     */ 
/*     */     case 1: 
/*  74 */       if (xVoipRoom.getPending_list().contains(Long.valueOf(this.roleid)))
/*     */       {
/*     */ 
/*  77 */         Map<String, Object> extraInfo = new HashMap();
/*  78 */         extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  79 */         onFail(225, extraInfo, false, true);
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       xVoipRoom.getPending_list().add(Long.valueOf(this.roleid));
/*  84 */       return true;
/*     */     
/*     */ 
/*     */ 
/*     */     case 2: 
/*     */     case 3: 
/*  90 */       xbean.VoipRoomUserAccess xVoipRoomUserAccess = (xbean.VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*  91 */       if (xVoipRoomUserAccess == null)
/*     */       {
/*  93 */         xVoipRoomUserAccess = Pod.newVoipRoomUserAccess();
/*  94 */         xVoipRoomUserAccess.setOpen_id(new Octets());
/*  95 */         xVoipRoom.getMembers().put(Long.valueOf(this.roleid), xVoipRoomUserAccess);
/*     */       }
/*  97 */       switch (xVoipRoomUserAccess.getRole_state())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */       case 1: 
/* 103 */         Map<String, Object> extraInfo = new HashMap();
/* 104 */         extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/* 105 */         extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/* 106 */         onFail(225, extraInfo, false, true);
/* 107 */         return false;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       case 2: 
/*     */       case 3: 
/* 114 */         SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/* 115 */         protocol.retcode = 0;
/* 116 */         protocol.voip_room_type = 1;
/* 117 */         protocol.room_id = xVoipRoom.getRoom_id();
/* 118 */         protocol.user_access.open_id.replace(xVoipRoomUserAccess.getOpen_id());
/* 119 */         protocol.user_access.member_id = xVoipRoomUserAccess.getMember_id();
/* 120 */         protocol.user_access.room_key = xVoipRoomUserAccess.getRoom_key();
/* 121 */         protocol.user_access.extra_data = xVoipRoomUserAccess.getExtra_data();
/* 122 */         protocol.user_access.access_ip_list.addAll(xVoipRoomUserAccess.getAccess_ip_list());
/* 123 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 125 */         RoleVoipRoom xRoleVoipRoom = Role2voip_room.get(Long.valueOf(this.roleid));
/* 126 */         if (xRoleVoipRoom == null)
/*     */         {
/* 128 */           xRoleVoipRoom = Pod.newRoleVoipRoom();
/* 129 */           Role2voip_room.insert(Long.valueOf(this.roleid), xRoleVoipRoom);
/*     */         }
/* 131 */         xRoleVoipRoom.setVoip_room_type(1);
/* 132 */         xRoleVoipRoom.setOwner_id(this.teamid);
/*     */         
/* 134 */         StringBuilder sb = new StringBuilder();
/* 135 */         sb.append(String.format("[teamvoiproom]PJoinTeamVoipRoomReq.processImp@join team voip room success|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */         
/*     */ 
/* 138 */         TeamVoipRoomManager.logger.info(sb.toString());
/* 139 */         return true;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       case 4: 
/*     */       case 5: 
/* 146 */         Map<String, Object> extraInfo = new HashMap();
/* 147 */         extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/* 148 */         onFail(230, extraInfo, false, true);
/* 149 */         return false;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       case 6: 
/* 155 */         xVoipRoomUserAccess.getOpen_id().clear();
/* 156 */         xVoipRoomUserAccess.setMember_id(0);
/* 157 */         xVoipRoomUserAccess.setRoom_key(0L);
/* 158 */         xVoipRoomUserAccess.setExtra_data(0L);
/* 159 */         xVoipRoomUserAccess.getAccess_ip_list().clear();
/* 160 */         xVoipRoomUserAccess.setTry_exit_times(0);
/*     */         
/* 162 */         xVoipRoomUserAccess.setRole_state(1);
/* 163 */         OctetsStream context = new OctetsStream();
/* 164 */         context.marshal(1);
/* 165 */         context.marshal(this.teamid);
/* 166 */         if (!ApolloInterface.sendApolloJoinVoipRoom(userid, this.roleid, xVoipRoom.getRoom_id(), context))
/*     */         {
/* 168 */           onFail(232, null, false, true);
/* 169 */           return false;
/*     */         }
/*     */         
/* 172 */         if (VoipRoomManager.IS_DEBUG_MODE)
/*     */         {
/* 174 */           VoipRoomTestManager.onApolloJoinVoipRoomRsp(userid, this.roleid, xVoipRoom.getRoom_id(), context);
/*     */         }
/* 176 */         StringBuilder sb = new StringBuilder();
/* 177 */         sb.append(String.format("[teamvoiproom]PJoinTeamVoipRoomReq.processImp@send join team voip room|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */         
/*     */ 
/* 180 */         TeamVoipRoomManager.logger.info(sb.toString());
/* 181 */         return true;
/*     */       }
/*     */       
/*     */       
/*     */ 
/* 186 */       return false;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case 4: 
/* 194 */       Map<String, Object> extraInfo = new HashMap();
/* 195 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/* 196 */       onFail(229, extraInfo, false, true);
/* 197 */       return false;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case 5: 
/* 203 */       xVoipRoom.setRoom_id(-1L);
/* 204 */       xVoipRoom.getMembers().clear();
/* 205 */       xVoipRoom.getPending_list().clear();
/* 206 */       xVoipRoom.setCreater_id(-1L);
/* 207 */       xVoipRoom.setClose_sessionid(-1L);
/* 208 */       xVoipRoom.setTry_close_times(0);
/*     */       
/* 210 */       xVoipRoom.setRoom_state(1);
/* 211 */       xVoipRoom.getPending_list().add(Long.valueOf(this.roleid));
/* 212 */       OctetsStream context = new OctetsStream();
/* 213 */       context.marshal(1);
/* 214 */       context.marshal(this.teamid);
/* 215 */       if (!ApolloInterface.sendApolloCreateVoipRoom(userid, this.roleid, context))
/*     */       {
/* 217 */         onFail(232, null, false, true);
/* 218 */         return false;
/*     */       }
/*     */       
/* 221 */       if (VoipRoomManager.IS_DEBUG_MODE)
/*     */       {
/* 223 */         VoipRoomTestManager.onApolloCreateVoipRoomRsp(userid, this.roleid, context);
/*     */       }
/* 225 */       return true;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 230 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError, boolean isSendProtocol)
/*     */   {
/* 237 */     StringBuilder sb = new StringBuilder();
/* 238 */     sb.append(String.format("[teamvoiproom]PJoinTeamVoipRoomReq.processImp@join team voip room fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 241 */     if (extraInfo != null)
/*     */     {
/* 243 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 245 */         sb.append("|").append((String)entry.getKey());
/* 246 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 249 */     if (isError)
/*     */     {
/* 251 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 255 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/* 257 */     if (isSendProtocol)
/*     */     {
/* 259 */       SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/* 260 */       protocol.retcode = res;
/* 261 */       protocol.voip_room_type = 1;
/* 262 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PJoinTeamVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */