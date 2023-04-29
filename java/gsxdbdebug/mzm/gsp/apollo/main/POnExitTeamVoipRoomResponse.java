/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloExitVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
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
/*     */ public class POnExitTeamVoipRoomResponse extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   private final boolean isSucceed;
/*     */   private final int retcode;
/*     */   private final long sessionid;
/*     */   
/*     */   public POnExitTeamVoipRoomResponse(long roleid, long teamid, boolean isSucceed, int retcode, long sessionid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.teamid = teamid;
/*  31 */     this.isSucceed = isSucceed;
/*  32 */     this.retcode = retcode;
/*  33 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     Session.removeSession(this.sessionid, this.teamid);
/*     */     
/*  42 */     if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */     {
/*     */ 
/*  45 */       onFail(222, null, false);
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     String userid = RoleInterface.getUserId(this.roleid);
/*  51 */     lock(Lockeys.get(User.getTable(), userid));
/*  52 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  54 */     if (!VoipRoomManager.isRoleInThisVoipRoom(this.roleid, 1, this.teamid))
/*     */     {
/*     */ 
/*  57 */       onFail(222, null, false);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*     */     
/*  64 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  67 */       onFail(228, null, true);
/*  68 */       return false;
/*     */     }
/*  70 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  74 */       Map<String, Object> extraInfo = new HashMap();
/*  75 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  76 */       onFail(229, extraInfo, false);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     VoipRoomUserAccess xVoipRoomUserAccess = (VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*     */     
/*  82 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*     */ 
/*  85 */       onFail(228, null, true);
/*  86 */       return false;
/*     */     }
/*  88 */     if (xVoipRoomUserAccess.getRole_state() != 5)
/*     */     {
/*     */ 
/*  91 */       Map<String, Object> extraInfo = new HashMap();
/*  92 */       extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/*  93 */       onFail(230, extraInfo, false);
/*  94 */       return false;
/*     */     }
/*  96 */     if (this.isSucceed)
/*     */     {
/*  98 */       xVoipRoomUserAccess.setRole_state(6);
/*  99 */       xVoipRoom.getMembers().remove(Long.valueOf(this.roleid));
/* 100 */       Role2voip_room.remove(Long.valueOf(this.roleid));
/*     */       
/* 102 */       SApolloExitVoipRoomRsp protocol = new SApolloExitVoipRoomRsp();
/* 103 */       protocol.retcode = 0;
/* 104 */       protocol.voip_room_type = 1;
/* 105 */       protocol.room_id = xVoipRoom.getRoom_id();
/* 106 */       protocol.member_id = xVoipRoomUserAccess.getMember_id();
/* 107 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 109 */       StringBuilder sb = new StringBuilder();
/* 110 */       sb.append(String.format("[teamvoiproom]POnExitTeamVoipRoomResponse.processImp@exit team voip room success|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */       
/*     */ 
/* 113 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 114 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 118 */     onFail(this.retcode, null, false);
/*     */     
/* 120 */     TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryExitTeamVoipRoom(this.roleid, this.teamid));
/*     */     
/* 122 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/* 128 */     StringBuilder sb = new StringBuilder();
/* 129 */     sb.append(String.format("[teamvoiproom]POnExitTeamVoipRoomResponse.processImp@exit voip room fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 132 */     if (extraInfo != null)
/*     */     {
/* 134 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 136 */         sb.append("|").append((String)entry.getKey());
/* 137 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 140 */     if (isError)
/*     */     {
/* 142 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 146 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnExitTeamVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */