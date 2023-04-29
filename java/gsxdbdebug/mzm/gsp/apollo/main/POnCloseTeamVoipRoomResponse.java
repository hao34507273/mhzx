/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xbean.VoipRoomUserAccess;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Team_voip_rooms;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnCloseTeamVoipRoomResponse extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long createrid;
/*     */   private final long teamid;
/*     */   private final boolean isSucceed;
/*     */   private final int retcode;
/*     */   private final long sessionid;
/*     */   
/*     */   public POnCloseTeamVoipRoomResponse(long createrid, long teamid, boolean isSucceed, int retcode, long sessionid)
/*     */   {
/*  26 */     this.createrid = createrid;
/*  27 */     this.teamid = teamid;
/*  28 */     this.isSucceed = isSucceed;
/*  29 */     this.retcode = retcode;
/*  30 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     Session.removeSession(this.sessionid, this.teamid);
/*     */     
/*  39 */     String userid = RoleInterface.getUserId(this.createrid);
/*  40 */     lock(Lockeys.get(User.getTable(), userid));
/*  41 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.createrid)));
/*     */     
/*     */ 
/*  44 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  45 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  48 */       onFail(228, null, true);
/*  49 */       return false;
/*     */     }
/*  51 */     if (xVoipRoom.getRoom_state() != 4)
/*     */     {
/*     */ 
/*  54 */       Map<String, Object> extraInfo = new HashMap();
/*  55 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  56 */       onFail(229, extraInfo, true);
/*  57 */       return false;
/*     */     }
/*  59 */     if (this.isSucceed)
/*     */     {
/*  61 */       xVoipRoom.setRoom_state(5);
/*  62 */       for (Map.Entry<Long, VoipRoomUserAccess> entry : xVoipRoom.getMembers().entrySet())
/*     */       {
/*  64 */         TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PClearRoleTeamVoipRoomInfo(((Long)entry.getKey()).longValue(), this.teamid, xVoipRoom.getRoom_id(), ((VoipRoomUserAccess)entry.getValue()).getMember_id(), true));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  69 */       Team_voip_rooms.remove(Long.valueOf(this.teamid));
/*  70 */       StringBuilder sb = new StringBuilder();
/*  71 */       sb.append(String.format("[teamvoiproom]POnCloseTeamVoipRoomResponse.processImp@close voip room success|createrid=%d|teamid=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid) }));
/*     */       
/*     */ 
/*  74 */       TeamVoipRoomManager.logger.info(sb.toString());
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     onFail(this.retcode, null, false);
/*     */     
/*  81 */     TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryCloseTeamVoipRoom(this.createrid, this.teamid));
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError)
/*     */   {
/*  89 */     StringBuilder sb = new StringBuilder();
/*  90 */     sb.append(String.format("[teamvoiproom]POnCloseTeamVoipRoomResponse.processImp@close voip room fail|createrid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  93 */     if (extraInfo != null)
/*     */     {
/*  95 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  97 */         sb.append("|").append((String)entry.getKey());
/*  98 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 101 */     if (isError)
/*     */     {
/* 103 */       TeamVoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/* 107 */       TeamVoipRoomManager.logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnCloseTeamVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */