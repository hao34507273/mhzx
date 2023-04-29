/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SSynVoipRoomOnlineMembers;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xbean.VoipRoomUserAccess;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class POnClientReportJoinAndExitTeamVoipRoom extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   private final int action;
/*     */   
/*     */   public POnClientReportJoinAndExitTeamVoipRoom(long roleid, long teamid, int action)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.teamid = teamid;
/*  27 */     this.action = action;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!TeamVoipRoomManager.isTeamVoipRoomSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  36 */       onFail(201, null, false);
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!TeamVoipRoomManager.checkRoleStatus(this.roleid, 352))
/*     */     {
/*     */ 
/*  43 */       onFail(203, null, false);
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  49 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  50 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  52 */     if (!VoipRoomManager.isRoleInThisVoipRoom(this.roleid, 1, this.teamid))
/*     */     {
/*     */ 
/*  55 */       onFail(222, null, false);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!TeamVoipRoomManager.isRoleInThisTeam(this.roleid, this.teamid))
/*     */     {
/*     */ 
/*  62 */       onFail(224, null, false);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     VoipRoom xVoipRoom = xtable.Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  68 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  71 */       onFail(228, null, true);
/*  72 */       return false;
/*     */     }
/*  74 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  78 */       Map<String, Object> extraInfo = new HashMap();
/*  79 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  80 */       onFail(229, extraInfo, false);
/*  81 */       return false;
/*     */     }
/*  83 */     VoipRoomUserAccess xVoipRoomUserAccess = (VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*  84 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*     */ 
/*  87 */       onFail(228, null, true);
/*  88 */       return false;
/*     */     }
/*  90 */     if ((this.action == 1) && (xVoipRoomUserAccess.getRole_state() == 2))
/*     */     {
/*     */ 
/*  93 */       xVoipRoomUserAccess.setRole_state(3);
/*  94 */       if (xVoipRoom.getRoom_state() == 3)
/*     */       {
/*  96 */         StringBuilder sb = new StringBuilder();
/*  97 */         sb.append(String.format("[teamvoiproom]POnClientReportJoinAndExitTeamVoipRoom.processImp@remove close team voip room session|teamid=%d|sessionid=%d", new Object[] { Long.valueOf(this.teamid), Long.valueOf(xVoipRoom.getClose_sessionid()) }));
/*     */         
/*     */ 
/* 100 */         TeamVoipRoomManager.logger.info(sb.toString());
/* 101 */         xVoipRoom.setRoom_state(2);
/* 102 */         Session.removeSession(xVoipRoom.getClose_sessionid(), this.teamid);
/* 103 */         xVoipRoom.setClose_sessionid(-1L);
/*     */       }
/*     */       
/* 106 */       SSynVoipRoomOnlineMembers protocol = new SSynVoipRoomOnlineMembers();
/* 107 */       protocol.voip_room_type = 1;
/* 108 */       for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */       {
/* 110 */         if (((VoipRoomUserAccess)entry.getValue()).getRole_state() == 3)
/*     */         {
/* 112 */           protocol.online_member_list.add(entry.getKey());
/*     */         }
/*     */       }
/* 115 */       OnlineManager.getInstance().sendMulti(protocol, TeamInterface.getTeamMemberList(this.teamid, true));
/*     */       
/* 117 */       StringBuilder sb = new StringBuilder();
/* 118 */       sb.append(String.format("[teamvoiproom]POnClientReportJoinAndExitTeamVoipRoom.processImp@client report join team voip room success|roleid=%d|teamid=%d|action=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(this.action) }));
/*     */       
/*     */ 
/* 121 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 122 */       return true;
/*     */     }
/* 124 */     if ((this.action == 2) && ((xVoipRoomUserAccess.getRole_state() == 2) || (xVoipRoomUserAccess.getRole_state() == 3)))
/*     */     {
/*     */ 
/* 127 */       xVoipRoomUserAccess.setRole_state(5);
/* 128 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryExitTeamVoipRoom(this.roleid, this.teamid));
/*     */       
/*     */ 
/* 131 */       boolean needStartCloseTeamVoipRoomSession = xVoipRoom.getRoom_state() == 2;
/* 132 */       SSynVoipRoomOnlineMembers protocol = new SSynVoipRoomOnlineMembers();
/* 133 */       protocol.voip_room_type = 1;
/* 134 */       for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */       {
/* 136 */         if (((VoipRoomUserAccess)entry.getValue()).getRole_state() == 3)
/*     */         {
/* 138 */           protocol.online_member_list.add(entry.getKey());
/* 139 */           needStartCloseTeamVoipRoomSession = false;
/*     */         }
/*     */       }
/* 142 */       OnlineManager.getInstance().sendMulti(protocol, TeamInterface.getTeamMemberList(this.teamid, true));
/* 143 */       if (needStartCloseTeamVoipRoomSession)
/*     */       {
/* 145 */         xVoipRoom.setRoom_state(3);
/* 146 */         xVoipRoom.setClose_sessionid(new CloseTeamVoipRoomSession(xVoipRoom.getCreater_id(), this.teamid).getSessionId());
/* 147 */         StringBuilder sb = new StringBuilder();
/* 148 */         sb.append(String.format("[teamvoiproom]POnClientReportJoinAndExitTeamVoipRoom.processImp@start close team voip room session|teamid=%d|sessionid=%d", new Object[] { Long.valueOf(this.teamid), Long.valueOf(xVoipRoom.getClose_sessionid()) }));
/*     */         
/*     */ 
/* 151 */         TeamVoipRoomManager.logger.info(sb.toString());
/*     */       }
/* 153 */       StringBuilder sb = new StringBuilder();
/* 154 */       sb.append(String.format("[teamvoiproom]POnClientReportJoinAndExitTeamVoipRoom.processImp@client report exit team voip room success|roleid=%d|teamid=%d|action=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(this.action) }));
/*     */       
/*     */ 
/* 157 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 158 */       return true;
/*     */     }
/*     */     
/* 161 */     Map<String, Object> extraInfo = new HashMap();
/* 162 */     extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/* 163 */     onFail(230, extraInfo, false);
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append(String.format("[teamvoiproom]POnClientReportJoinAndExitTeamVoipRoom.processImp@client report join and exit team voip room fail|roleid=%d|teamid=%d|action=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(this.action), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 173 */     if (extraInfo != null)
/*     */     {
/* 175 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 177 */         sb.append("|").append((String)entry.getKey());
/* 178 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 181 */     if (isError)
/*     */     {
/* 183 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 187 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnClientReportJoinAndExitTeamVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */