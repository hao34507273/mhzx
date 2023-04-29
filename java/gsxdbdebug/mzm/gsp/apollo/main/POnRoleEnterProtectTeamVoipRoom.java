/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SSynVoipRoomOnlineMembers;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xbean.VoipRoomUserAccess;
/*     */ import xtable.Team_voip_rooms;
/*     */ 
/*     */ public class POnRoleEnterProtectTeamVoipRoom extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   
/*     */   public POnRoleEnterProtectTeamVoipRoom(long roleid, long teamid)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.teamid = teamid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */     {
/*     */ 
/*  34 */       onFail(222, null, false);
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     if (!TeamVoipRoomManager.isRoleInThisTeam(this.roleid, this.teamid))
/*     */     {
/*     */ 
/*  41 */       onFail(224, null, false);
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  47 */     if (xVoipRoom == null)
/*     */     {
/*  49 */       onFail(228, null, true);
/*  50 */       return false;
/*     */     }
/*  52 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  56 */       Map<String, Object> extraInfo = new HashMap();
/*  57 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  58 */       onFail(229, extraInfo, false);
/*  59 */       return false;
/*     */     }
/*  61 */     VoipRoomUserAccess xVoipRoomUserAccess = (VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*  62 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*  64 */       onFail(228, null, true);
/*  65 */       return false;
/*     */     }
/*  67 */     if ((xVoipRoomUserAccess.getRole_state() != 2) && (xVoipRoomUserAccess.getRole_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  71 */       Map<String, Object> extraInfo = new HashMap();
/*  72 */       extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/*  73 */       onFail(230, extraInfo, false);
/*  74 */       return false;
/*     */     }
/*  76 */     xVoipRoomUserAccess.setRole_state(4);
/*     */     
/*  78 */     boolean needStartCloseTeamVoipRoomSession = xVoipRoom.getRoom_state() == 2;
/*  79 */     SSynVoipRoomOnlineMembers protocol = new SSynVoipRoomOnlineMembers();
/*  80 */     protocol.voip_room_type = 1;
/*  81 */     for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */     {
/*  83 */       if (((VoipRoomUserAccess)entry.getValue()).getRole_state() == 3)
/*     */       {
/*  85 */         protocol.online_member_list.add(entry.getKey());
/*  86 */         needStartCloseTeamVoipRoomSession = false;
/*     */       }
/*     */     }
/*  89 */     OnlineManager.getInstance().sendMulti(protocol, TeamInterface.getTeamMemberList(this.teamid, true));
/*  90 */     if (needStartCloseTeamVoipRoomSession)
/*     */     {
/*  92 */       xVoipRoom.setRoom_state(3);
/*  93 */       xVoipRoom.setClose_sessionid(new CloseTeamVoipRoomSession(xVoipRoom.getCreater_id(), this.teamid).getSessionId());
/*  94 */       StringBuilder sb = new StringBuilder();
/*  95 */       sb.append(String.format("[teamvoiproom]POnRoleEnterProtectTeamVoipRoom.processImp@start close team voip room session|teamid=%d|sessionid=%d", new Object[] { Long.valueOf(this.teamid), Long.valueOf(xVoipRoom.getClose_sessionid()) }));
/*     */       
/*     */ 
/*  98 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/* 100 */     StringBuilder sb = new StringBuilder();
/* 101 */     sb.append(String.format("[teamvoiproom]POnRoleEnterProtectTeamVoipRoom.processImp@team voip room enter protect check success|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */     
/*     */ 
/* 104 */     TeamVoipRoomManager.logger.info(sb.toString());
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/* 110 */     StringBuilder sb = new StringBuilder();
/* 111 */     sb.append(String.format("[teamvoiproom]POnRoleEnterProtectTeamVoipRoom.processImp@team voip room enter protect check fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 114 */     if (extraInfo != null)
/*     */     {
/* 116 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 118 */         sb.append("|").append((String)entry.getKey());
/* 119 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 122 */     if (isError)
/*     */     {
/* 124 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 128 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleEnterProtectTeamVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */