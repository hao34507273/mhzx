/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloJoinVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoipRoom;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Team_voip_rooms;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnCreateTeamVoipRoomResponse extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long createrid;
/*     */   private final long teamid;
/*     */   private final boolean isSucceed;
/*     */   private final int retcode;
/*     */   private final long roomid;
/*     */   
/*     */   public POnCreateTeamVoipRoomResponse(long createrid, long teamid, boolean isSucceed, int retcode, long roomid)
/*     */   {
/*  28 */     this.createrid = createrid;
/*  29 */     this.teamid = teamid;
/*  30 */     this.isSucceed = isSucceed;
/*  31 */     this.retcode = retcode;
/*  32 */     this.roomid = roomid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     String userid = RoleInterface.getUserId(this.createrid);
/*  40 */     lock(Lockeys.get(User.getTable(), userid));
/*  41 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.createrid)));
/*     */     
/*     */ 
/*  44 */     VoipRoom xVoipRoom = Team_voip_rooms.get(Long.valueOf(this.teamid));
/*  45 */     if (xVoipRoom == null)
/*     */     {
/*     */ 
/*  48 */       onFail(228, null, true, false, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (xVoipRoom.getRoom_state() != 1)
/*     */     {
/*     */ 
/*  54 */       Map<String, Object> extraInfo = new HashMap();
/*  55 */       extraInfo.put("room_state", Integer.valueOf(xVoipRoom.getRoom_state()));
/*  56 */       onFail(229, extraInfo, true, false, null);
/*  57 */       return false;
/*     */     }
/*  59 */     if (((Long)xVoipRoom.getPending_list().get(0)).longValue() != this.createrid)
/*     */     {
/*     */ 
/*  62 */       Map<String, Object> extraInfo = new HashMap();
/*  63 */       extraInfo.put("createrid_in_db", xVoipRoom.getPending_list().get(0));
/*  64 */       onFail(231, extraInfo, true, false, null);
/*  65 */       return false;
/*     */     }
/*  67 */     if (this.isSucceed)
/*     */     {
/*  69 */       if (TeamVoipRoomManager.isTeamDissolved(this.teamid))
/*     */       {
/*     */ 
/*  72 */         onFail(222, null, false, true, xVoipRoom.getPending_list());
/*  73 */         xVoipRoom.setRoom_state(4);
/*  74 */         xVoipRoom.getPending_list().clear();
/*  75 */         TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryCloseTeamVoipRoom(this.createrid, this.teamid));
/*     */         
/*  77 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  82 */       for (Iterator i$ = xVoipRoom.getPending_list().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  84 */         TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(this.teamid), new PTryJoinTeamVoipRoom(roleid, this.teamid));
/*     */       }
/*     */       
/*  87 */       xVoipRoom.setRoom_state(3);
/*  88 */       xVoipRoom.setRoom_id(this.roomid);
/*  89 */       xVoipRoom.setCreater_id(this.createrid);
/*  90 */       xVoipRoom.getPending_list().clear();
/*  91 */       xVoipRoom.setClose_sessionid(new CloseTeamVoipRoomSession(this.createrid, this.teamid).getSessionId());
/*  92 */       StringBuilder sb = new StringBuilder();
/*  93 */       sb.append(String.format("[teamvoiproom]POnCreateTeamVoipRoomResponse.processImp@start close team voip room session|teamid=%d|sessionid=%d", new Object[] { Long.valueOf(this.teamid), Long.valueOf(xVoipRoom.getClose_sessionid()) }));
/*     */       
/*     */ 
/*  96 */       TeamVoipRoomManager.logger.info(sb.toString());
/*  97 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 103 */     onFail(this.retcode, null, false, true, xVoipRoom.getPending_list());
/* 104 */     xVoipRoom.setRoom_state(5);
/* 105 */     xVoipRoom.getPending_list().clear();
/* 106 */     Team_voip_rooms.remove(Long.valueOf(this.teamid));
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError, boolean isSendProtocol, List<Long> receivers)
/*     */   {
/* 114 */     StringBuilder sb = new StringBuilder();
/* 115 */     sb.append(String.format("[teamvoiproom]POnCreateTeamVoipRoomResponse.processImp@create team voip room fail|createrid=%d|teamid=%d|res=%d", new Object[] { Long.valueOf(this.createrid), Long.valueOf(this.teamid), Integer.valueOf(res) }));
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
/* 134 */     if ((isSendProtocol) && (receivers != null))
/*     */     {
/* 136 */       SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/* 137 */       protocol.retcode = res;
/* 138 */       protocol.voip_room_type = 1;
/* 139 */       OnlineManager.getInstance().sendMulti(protocol, receivers);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnCreateTeamVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */