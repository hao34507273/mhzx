/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloJoinVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleVoipRoom;
/*     */ import xbean.VoipRoom;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2voip_room;
/*     */ import xtable.Team_voip_rooms;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnJoinTeamVoipRoomResponse extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   private final boolean isSucceed;
/*     */   private final int retcode;
/*     */   private final long roomid;
/*     */   private final Octets openid;
/*     */   private final int memberid;
/*     */   private final long roomKey;
/*     */   private final long extraData;
/*     */   private final List<Octets> accessIPList;
/*     */   
/*     */   public POnJoinTeamVoipRoomResponse(long roleid, long teamid, boolean isSucceed, int retcode, long roomid, Octets openid, int memberid, long roomKey, long extraData, List<Octets> accessIPList)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.teamid = teamid;
/*  40 */     this.isSucceed = isSucceed;
/*  41 */     this.retcode = retcode;
/*  42 */     this.roomid = roomid;
/*  43 */     this.openid = openid;
/*  44 */     this.memberid = memberid;
/*  45 */     this.roomKey = roomKey;
/*  46 */     this.extraData = extraData;
/*  47 */     this.accessIPList = accessIPList;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */     {
/*     */ 
/*  57 */       onFail(222, null, false, true);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     String userid = RoleInterface.getUserId(this.roleid);
/*  63 */     lock(Lockeys.get(User.getTable(), userid));
/*  64 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  66 */     if (VoipRoomManager.isRoleInVoipRoom(this.roleid))
/*     */     {
/*     */ 
/*  69 */       onFail(226, null, false, true);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!TeamVoipRoomManager.isRoleInThisTeam(this.roleid, this.teamid))
/*     */     {
/*     */ 
/*  76 */       onFail(224, null, false, true);
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  82 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  85 */       onFail(228, null, true, false);
/*  86 */       return false;
/*     */     }
/*  88 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  92 */       Map<String, Object> extraInfo = new HashMap();
/*  93 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  94 */       onFail(229, extraInfo, false, false);
/*  95 */       return false;
/*     */     }
/*  97 */     if (xVoipRoom.getRoom_id() != this.roomid)
/*     */     {
/*     */ 
/* 100 */       Map<String, Object> extraInfo = new HashMap();
/* 101 */       extraInfo.put("roomid_in_db", Long.valueOf(xVoipRoom.getRoom_id()));
/* 102 */       onFail(231, extraInfo, false, false);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     xbean.VoipRoomUserAccess xVoipRoomUserAccess = (xbean.VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/* 107 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*     */ 
/* 110 */       onFail(228, null, false, false);
/* 111 */       return false;
/*     */     }
/* 113 */     if (xVoipRoomUserAccess.getRole_state() != 1)
/*     */     {
/*     */ 
/* 116 */       Map<String, Object> extraInfo = new HashMap();
/* 117 */       extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/* 118 */       onFail(230, extraInfo, true, false);
/* 119 */       return false;
/*     */     }
/* 121 */     if (this.isSucceed)
/*     */     {
/*     */ 
/* 124 */       xVoipRoomUserAccess.setRole_state(2);
/* 125 */       xVoipRoomUserAccess.getOpen_id().replace(this.openid);
/* 126 */       xVoipRoomUserAccess.setMember_id(this.memberid);
/* 127 */       xVoipRoomUserAccess.setRoom_key(this.roomKey);
/* 128 */       xVoipRoomUserAccess.setExtra_data(this.extraData);
/* 129 */       if (this.accessIPList == null)
/*     */       {
/*     */ 
/* 132 */         return false;
/*     */       }
/* 134 */       xVoipRoomUserAccess.getAccess_ip_list().addAll(this.accessIPList);
/*     */       
/* 136 */       RoleVoipRoom xRoleVoipRoom = Role2voip_room.get(Long.valueOf(this.roleid));
/* 137 */       if (xRoleVoipRoom == null)
/*     */       {
/* 139 */         xRoleVoipRoom = Pod.newRoleVoipRoom();
/* 140 */         Role2voip_room.insert(Long.valueOf(this.roleid), xRoleVoipRoom);
/*     */       }
/* 142 */       xRoleVoipRoom.setVoip_room_type(1);
/* 143 */       xRoleVoipRoom.setOwner_id(this.teamid);
/*     */       
/* 145 */       SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/* 146 */       protocol.retcode = 0;
/* 147 */       protocol.voip_room_type = 1;
/* 148 */       protocol.room_id = xVoipRoom.getRoom_id();
/* 149 */       protocol.user_access.open_id.replace(xVoipRoomUserAccess.getOpen_id());
/* 150 */       protocol.user_access.member_id = xVoipRoomUserAccess.getMember_id();
/* 151 */       protocol.user_access.room_key = xVoipRoomUserAccess.getRoom_key();
/* 152 */       protocol.user_access.extra_data = xVoipRoomUserAccess.getExtra_data();
/* 153 */       protocol.user_access.access_ip_list.addAll(xVoipRoomUserAccess.getAccess_ip_list());
/* 154 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 156 */       StringBuilder sb = new StringBuilder();
/* 157 */       sb.append(String.format("[voiproom]POnJoinTeamVoipRoomResponse.processImp@join team voip room success|roleid=%d|teamid=%d|", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */       
/*     */ 
/* 160 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 161 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 165 */     xVoipRoomUserAccess.setRole_state(6);
/* 166 */     xVoipRoom.getMembers().remove(Long.valueOf(this.roleid));
/* 167 */     onFail(this.retcode, null, false, true);
/* 168 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError, boolean isSendProtocol)
/*     */   {
/* 174 */     StringBuilder sb = new StringBuilder();
/* 175 */     sb.append(String.format("[teamvoiproom]POnJoinTeamVoipRoomResponse.processImp@join team voip room fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 178 */     if (extraInfo != null)
/*     */     {
/* 180 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 182 */         sb.append("|").append((String)entry.getKey());
/* 183 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 186 */     if (isError)
/*     */     {
/* 188 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 192 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/* 194 */     if (isSendProtocol)
/*     */     {
/* 196 */       SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/* 197 */       protocol.retcode = res;
/* 198 */       protocol.voip_room_type = 1;
/* 199 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnJoinTeamVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */