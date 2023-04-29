/*     */ package mzm.gsp.chess.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.ChessActivityConsts;
/*     */ import mzm.gsp.chess.SJoinChessFailRep;
/*     */ import mzm.gsp.chess.SJoinChessSuccessRep;
/*     */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCJoinChessReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   
/*     */   public PCJoinChessReq(long roleId, int activityId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  40 */     if (this.activityId != ChessActivityConsts.getInstance().ACTIVITY_ID)
/*     */     {
/*  42 */       String logstr = String.format("[chess]PCJoinChessReq.processImp@activityId not match|activityId=%d,roleId=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  45 */       ChessActivityManager.logger.error(logstr);
/*  46 */       onFail(-3, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!OpenInterface.getOpenStatus(396))
/*     */     {
/*  53 */       String logstr = String.format("[chess]PCJoinChessReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  54 */       ChessActivityManager.logger.error(logstr);
/*  55 */       onFail(-3, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  61 */     if (null == teamId)
/*     */     {
/*  63 */       onFail(-6, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  64 */       return false;
/*     */     }
/*  66 */     List<Long> roleIds = TeamInterface.getNormalRoleList(this.roleId);
/*  67 */     Map<Long, String> roleId2Userid = new HashMap();
/*  68 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  70 */       String userId = RoleInterface.getUserId(tmpRoleId);
/*  71 */       if (null == userId)
/*     */       {
/*  73 */         String logstr = String.format("[chess]PCJoinChessReq.processImp@userId not exist|roleId=%d", new Object[] { Long.valueOf(tmpRoleId) });
/*  74 */         ChessActivityManager.logger.error(logstr);
/*  75 */         return false;
/*     */       }
/*  77 */       roleId2Userid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*     */ 
/*  81 */     lock(User.getTable(), roleId2Userid.values());
/*  82 */     lock(Basic.getTable(), roleIds);
/*     */     
/*     */ 
/*  85 */     if (ChessActivityManager.isAnyBaned(roleIds))
/*     */     {
/*  87 */       String logstr = String.format("[chess]PCJoinChessReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  88 */       ChessActivityManager.logger.error(logstr);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     if (!RoleStatusInterface.checkCansetStatus(roleIds, 1561, true, true))
/*     */     {
/*  95 */       String logstr = String.format("[chess]PCJoinChessReq.processImp@status error|npcId=%s", new Object[] { roleIds });
/*  96 */       ChessActivityManager.logger.error(logstr);
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 102 */     if (null == teamInfo)
/*     */     {
/* 104 */       onFail(-6, roleIds);
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/* 111 */       onFail(-7, roleIds);
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     if (!teamInfo.isAllTeamMemberNormal())
/*     */     {
/* 118 */       onFail(-8, roleIds);
/* 119 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 123 */     int normalMembersNum = teamInfo.getTeamNormalMembersNum();
/* 124 */     if ((normalMembersNum != roleIds.size()) || (normalMembersNum != 2))
/*     */     {
/* 126 */       onFail(-1, roleIds);
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     int npcId = ChessActivityConsts.getInstance().NPC_ID;
/* 132 */     int serviceId = ChessActivityConsts.getInstance().SERVICE_ID;
/* 133 */     if (!NpcInterface.checkNpcService(npcId, serviceId, this.roleId))
/*     */     {
/* 135 */       onFail(-4, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 136 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 140 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2Userid, roleIds, this.activityId);
/*     */     
/* 142 */     if (!joinResult.isCanJoin())
/*     */     {
/* 144 */       if (joinResult.isActivityNotOpen())
/*     */       {
/* 146 */         onFail(-3, roleIds);
/*     */       }
/* 148 */       if (joinResult.isRoleLevelWrong())
/*     */       {
/* 150 */         onFail(-2, roleIds);
/*     */       }
/* 152 */       if (joinResult.isPerSonCountWrong())
/*     */       {
/* 154 */         onFail(-1, roleIds);
/*     */       }
/* 156 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 160 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 162 */       if (ChessGameInterface.isInChessGame(Long.valueOf(tmpRoleId)))
/*     */       {
/* 164 */         onFail(-10, roleIds);
/* 165 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 170 */     int chessGameId = ChessActivityConsts.getInstance().GAME_ID;
/* 171 */     ChessActivityConfirmContext context = new ChessActivityConfirmContext(this.activityId, chessGameId);
/* 172 */     TeamConfirmInterface.startTeamConfirm(teamId.longValue(), 2, context);
/*     */     
/*     */ 
/* 175 */     onSuccess(roleIds);
/*     */     
/* 177 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(List<Long> roleIds)
/*     */   {
/* 188 */     sendJoinChessSuccessToClient();
/*     */     
/* 190 */     String logstr = String.format("[chess]PCJoinChessReq.processImp@PCJoinChessReq success|leader=%d,roleIds=%s", new Object[] { Long.valueOf(this.roleId), roleIds });
/*     */     
/* 192 */     ChessActivityManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendJoinChessSuccessToClient()
/*     */   {
/* 198 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SJoinChessSuccessRep(this.activityId));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode, List<Long> roleIds)
/*     */   {
/* 204 */     sendJoinChessFailToClient(errorCode);
/*     */     
/* 206 */     String logstr = String.format("[chess]PCJoinChessReq.processImp@PCJoinChessReq fail|leader=%d,roleIds=%s,errorCode=%d", new Object[] { Long.valueOf(this.roleId), roleIds, Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 209 */     ChessActivityManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendJoinChessFailToClient(int errorCode)
/*     */   {
/* 214 */     SJoinChessFailRep sJoinChessFailRep = new SJoinChessFailRep();
/* 215 */     sJoinChessFailRep.error_code = errorCode;
/* 216 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sJoinChessFailRep);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\PCJoinChessReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */