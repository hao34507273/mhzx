/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloJoinVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xbean.VoipRoomUserAccess;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Team_voip_rooms;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PTryJoinTeamVoipRoom extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long teamid;
/*     */   
/*     */   public PTryJoinTeamVoipRoom(long roleid, long teamid)
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
/*  43 */     String userid = RoleInterface.getUserId(this.roleid);
/*  44 */     lock(Lockeys.get(User.getTable(), userid));
/*  45 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  47 */     if (VoipRoomManager.isRoleInVoipRoom(this.roleid))
/*     */     {
/*     */ 
/*  50 */       onFail(226, null, false, true);
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
/*     */ 
/*  66 */       onFail(228, null, true, false);
/*  67 */       return false;
/*     */     }
/*  69 */     if ((xVoipRoom.getRoom_state() != 2) && (xVoipRoom.getRoom_state() != 3))
/*     */     {
/*     */ 
/*     */ 
/*  73 */       Map<String, Object> extraInfo = new HashMap();
/*  74 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  75 */       onFail(229, extraInfo, false, true);
/*  76 */       return false;
/*     */     }
/*  78 */     VoipRoomUserAccess xVoipRoomUserAccess = (VoipRoomUserAccess)xVoipRoom.getMembers().get(Long.valueOf(this.roleid));
/*  79 */     if (xVoipRoomUserAccess == null)
/*     */     {
/*  81 */       xVoipRoomUserAccess = xbean.Pod.newVoipRoomUserAccess();
/*  82 */       xVoipRoomUserAccess.setOpen_id(new Octets());
/*  83 */       xVoipRoom.getMembers().put(Long.valueOf(this.roleid), xVoipRoomUserAccess);
/*     */     }
/*  85 */     if (xVoipRoomUserAccess.getRole_state() != 6)
/*     */     {
/*     */ 
/*  88 */       Map<String, Object> extraInfo = new HashMap();
/*  89 */       extraInfo.put("role_state", Integer.valueOf(xVoipRoomUserAccess.getRole_state()));
/*  90 */       onFail(230, extraInfo, false, true);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     xVoipRoomUserAccess.getOpen_id().clear();
/*  95 */     xVoipRoomUserAccess.setMember_id(0);
/*  96 */     xVoipRoomUserAccess.setRoom_key(0L);
/*  97 */     xVoipRoomUserAccess.setExtra_data(0L);
/*  98 */     xVoipRoomUserAccess.getAccess_ip_list().clear();
/*  99 */     xVoipRoomUserAccess.setTry_exit_times(0);
/*     */     
/* 101 */     xVoipRoomUserAccess.setRole_state(1);
/* 102 */     OctetsStream context = new OctetsStream();
/* 103 */     context.marshal(1);
/* 104 */     context.marshal(this.teamid);
/* 105 */     if (!ApolloInterface.sendApolloJoinVoipRoom(userid, this.roleid, xVoipRoom.getRoom_id(), context))
/*     */     {
/* 107 */       onFail(232, null, false, true);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     if (VoipRoomManager.IS_DEBUG_MODE)
/*     */     {
/* 113 */       VoipRoomTestManager.onApolloJoinVoipRoomRsp(userid, this.roleid, xVoipRoom.getRoom_id(), context);
/*     */     }
/*     */     
/* 116 */     StringBuilder sb = new StringBuilder();
/* 117 */     sb.append(String.format("[teamvoiproom]PTryJoinTeamVoipRoom.processImp@try join team voip room success|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid) }));
/*     */     
/*     */ 
/* 120 */     TeamVoipRoomManager.logger.info(sb.toString());
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError, boolean isSendProtocol)
/*     */   {
/* 126 */     StringBuilder sb = new StringBuilder();
/* 127 */     sb.append(String.format("[teamvoiproom]PTryJoinTeamVoipRoom.processImp@try join team voip room fail|roleid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 130 */     if (extraInfo != null)
/*     */     {
/* 132 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 134 */         sb.append("|").append((String)entry.getKey());
/* 135 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 138 */     if (isError)
/*     */     {
/* 140 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 144 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/* 146 */     if (isSendProtocol)
/*     */     {
/* 148 */       SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/* 149 */       protocol.retcode = res;
/* 150 */       protocol.voip_room_type = 1;
/* 151 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PTryJoinTeamVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */