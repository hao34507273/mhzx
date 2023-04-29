/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloJoinVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xtable.Team_voip_rooms;
/*     */ 
/*     */ public class POnRoleLoginTeamVoipRoom extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   
/*     */   public POnRoleLoginTeamVoipRoom(long roleid, long teamid)
/*     */   {
/*  22 */     this.roleid = roleid;
/*  23 */     this.teamid = teamid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (!TeamVoipRoomManager.isTeamVoipRoomSwitchOpenForRole(this.roleid, false))
/*     */     {
/*     */ 
/*  32 */       onFail(201, null, false);
/*  33 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  37 */     if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */     {
/*     */ 
/*  40 */       onFail(222, null, false);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!TeamVoipRoomManager.isRoleInThisTeam(this.roleid, this.teamid))
/*     */     {
/*     */ 
/*  47 */       onFail(224, null, false);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  53 */     if (xVoipRoom == null)
/*     */     {
/*  55 */       onFail(228, null, true);
/*  56 */       return false;
/*     */     }
/*  58 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  62 */       Map<String, Object> extraInfo = new HashMap();
/*  63 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  64 */       onFail(229, extraInfo, false);
/*  65 */       return false;
/*     */     }
/*  67 */     xbean.VoipRoomUserAccess xVoipRoomUserAccess = (xbean.VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*  68 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*  70 */       onFail(228, null, true);
/*  71 */       return false;
/*     */     }
/*  73 */     if (xVoipRoomUserAccess.getRole_state() != 4)
/*     */     {
/*     */ 
/*  76 */       Map<String, Object> extraInfo = new HashMap();
/*  77 */       extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/*  78 */       onFail(230, extraInfo, false);
/*  79 */       return false;
/*     */     }
/*  81 */     xVoipRoomUserAccess.setRole_state(2);
/*     */     
/*  83 */     SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/*  84 */     protocol.retcode = 0;
/*  85 */     protocol.voip_room_type = 1;
/*  86 */     protocol.room_id = xVoipRoom.getRoom_id();
/*  87 */     protocol.user_access.open_id.replace(xVoipRoomUserAccess.getOpen_id());
/*  88 */     protocol.user_access.member_id = xVoipRoomUserAccess.getMember_id();
/*  89 */     protocol.user_access.room_key = xVoipRoomUserAccess.getRoom_key();
/*  90 */     protocol.user_access.extra_data = xVoipRoomUserAccess.getExtra_data();
/*  91 */     protocol.user_access.access_ip_list.addAll(xVoipRoomUserAccess.getAccess_ip_list());
/*  92 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*  93 */     StringBuilder sb = new StringBuilder();
/*  94 */     sb.append(String.format("[teamvoiproom]POnRoleLoginTeamVoipRoom.processImp@team voip room login check success|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */     
/*     */ 
/*  97 */     TeamVoipRoomManager.logger.info(sb.toString());
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/* 103 */     StringBuilder sb = new StringBuilder();
/* 104 */     sb.append(String.format("[teamvoiproom]POnRoleLoginTeamVoipRoom.processImp@team voip room login check fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 107 */     if (extraInfo != null)
/*     */     {
/* 109 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 111 */         sb.append("|").append((String)entry.getKey());
/* 112 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 115 */     if (isError)
/*     */     {
/* 117 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 121 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleLoginTeamVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */