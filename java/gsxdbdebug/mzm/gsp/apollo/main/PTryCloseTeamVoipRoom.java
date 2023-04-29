/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xbean.VoipRoomUserAccess;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Team_voip_rooms;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PTryCloseTeamVoipRoom extends LogicProcedure
/*     */ {
/*     */   private final long createrid;
/*     */   private final long teamid;
/*     */   
/*     */   public PTryCloseTeamVoipRoom(long createrid, long teamid)
/*     */   {
/*  25 */     this.createrid = createrid;
/*  26 */     this.teamid = teamid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     String userid = RoleInterface.getUserId(this.createrid);
/*  34 */     lock(Lockeys.get(User.getTable(), userid));
/*  35 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.createrid)));
/*     */     
/*     */ 
/*  38 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  39 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  42 */       onFail(228, null, true);
/*  43 */       return false;
/*     */     }
/*  45 */     if (xVoipRoom.getRoom_state() != 4)
/*     */     {
/*     */ 
/*  48 */       Map<String, Object> extraInfo = new HashMap();
/*  49 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  50 */       onFail(229, extraInfo, true);
/*  51 */       return false;
/*     */     }
/*  53 */     if (xVoipRoom.getTry_close_times() >= VoipRoomManager.CLOSE_VOIP_ROOM_TRY_TIMES)
/*     */     {
/*     */ 
/*  56 */       xVoipRoom.setRoom_state(5);
/*  57 */       for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */       {
/*  59 */         TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PClearRoleTeamVoipRoomInfo(((Long)entry.getKey()).longValue(), this.teamid, xVoipRoom.getRoom_id(), ((VoipRoomUserAccess)entry.getValue()).getMember_id(), true));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  64 */       Team_voip_rooms.remove(Long.valueOf(this.teamid));
/*  65 */       StringBuilder sb = new StringBuilder();
/*  66 */       sb.append(String.format("[teamvoiproom]PTryCloseTeamVoipRoom.processImp@try close team voip room to max try times|createrid=%d|teamid=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid) }));
/*     */       
/*     */ 
/*  69 */       TeamVoipRoomManager.logger.info(sb.toString());
/*  70 */       return true;
/*     */     }
/*  72 */     xVoipRoom.setTry_close_times(xVoipRoom.getTry_close_times() + 1);
/*  73 */     OctetsStream context = new OctetsStream();
/*  74 */     context.marshal(1);
/*  75 */     context.marshal(this.teamid);
/*  76 */     TryCloseTeamVoipRoomSession session = new TryCloseTeamVoipRoomSession(this.createrid, this.teamid);
/*  77 */     context.marshal(session.getSessionId());
/*  78 */     if (!ApolloInterface.sendApolloCloseVoipRoom(userid, this.createrid, xVoipRoom.getRoom_id(), context))
/*     */     {
/*     */ 
/*  81 */       Session.removeSession(session.getSessionId(), session.getOwerId());
/*  82 */       xVoipRoom.setRoom_state(5);
/*  83 */       for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */       {
/*  85 */         TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PClearRoleTeamVoipRoomInfo(((Long)entry.getKey()).longValue(), this.teamid, xVoipRoom.getRoom_id(), ((VoipRoomUserAccess)entry.getValue()).getMember_id(), true));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  90 */       Team_voip_rooms.remove(Long.valueOf(this.teamid));
/*  91 */       StringBuilder sb = new StringBuilder();
/*  92 */       sb.append(String.format("[teamvoiproom]PTryCloseTeamVoipRoom.processImp@send to apollo error, close team voip room|createrid=%d|teamid=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid) }));
/*     */       
/*     */ 
/*  95 */       TeamVoipRoomManager.logger.info(sb.toString());
/*  96 */       return true;
/*     */     }
/*     */     
/*  99 */     if (VoipRoomManager.IS_DEBUG_MODE)
/*     */     {
/* 101 */       VoipRoomTestManager.onApolloCloseVoipRoomRsp(userid, this.createrid, xVoipRoom.getRoom_id(), context);
/*     */     }
/*     */     
/* 104 */     StringBuilder sb = new StringBuilder();
/* 105 */     sb.append(String.format("[teamvoiproom]PTryCloseTeamVoipRoom.processImp@try close voip room success|createrid=%d|teamid=%d|times=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid), Integer.valueOf(xVoipRoom.getTry_close_times()) }));
/*     */     
/*     */ 
/* 108 */     TeamVoipRoomManager.logger.info(sb.toString());
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/* 114 */     StringBuilder sb = new StringBuilder();
/* 115 */     sb.append(String.format("[teamvoiproom]PTryCloseTeamVoipRoom.processImp@try close voip room fail|createrid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 118 */     if (extraInfo != null)
/*     */     {
/* 120 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 122 */         sb.append("|").append((String)entry.getKey());
/* 123 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 126 */     if (isError)
/*     */     {
/* 128 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 132 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PTryCloseTeamVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */