/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.apollo.SApolloJoinVoipRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCApolloJoinVoipRoomReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int voipRoomType;
/*     */   
/*     */   public PCApolloJoinVoipRoomReq(long roleid, int voipRoomType)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.voipRoomType = voipRoomType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (this.voipRoomType == 1)
/*     */     {
/*  35 */       if (!TeamVoipRoomManager.isTeamVoipRoomSwitchOpenForRole(this.roleid, true))
/*     */       {
/*     */ 
/*  38 */         onFail(201, null, false, false);
/*  39 */         return false;
/*     */       }
/*     */       
/*  42 */       if (!TeamVoipRoomManager.checkRoleStatus(this.roleid, 351))
/*     */       {
/*     */ 
/*  45 */         onFail(203, null, false, false);
/*  46 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  50 */       String userid = RoleInterface.getUserId(this.roleid);
/*  51 */       lock(Lockeys.get(User.getTable(), userid));
/*  52 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */       
/*  54 */       Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, true);
/*  55 */       if (teamid == null)
/*     */       {
/*     */ 
/*  58 */         onFail(221, null, false, true);
/*  59 */         return false;
/*     */       }
/*  61 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(teamid, new PJoinTeamVoipRoomReq(this.roleid, teamid.longValue()));
/*  62 */       StringBuilder sb = new StringBuilder();
/*  63 */       sb.append(String.format("[voiproom]PCApolloJoinVoipRoomReq.processImp@receive join team voip req|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), teamid }));
/*     */       
/*     */ 
/*  66 */       VoipRoomManager.logger.info(sb.toString());
/*  67 */       return true;
/*     */     }
/*     */     
/*  70 */     onFail(202, null, false, true);
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isError, boolean isSendProtocol)
/*     */   {
/*  76 */     StringBuilder sb = new StringBuilder();
/*  77 */     sb.append(String.format("[voiproom]PCApolloJoinVoipRoomReq.processImp@join voip room fail|roleid=%d|voip_room_type=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.voipRoomType), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  80 */     if (extraInfo != null)
/*     */     {
/*  82 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  84 */         sb.append("|").append((String)entry.getKey());
/*  85 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*  88 */     if (isError)
/*     */     {
/*  90 */       VoipRoomManager.logger.error(sb.toString());
/*     */     }
/*     */     else
/*     */     {
/*  94 */       VoipRoomManager.logger.info(sb.toString());
/*     */     }
/*  96 */     if (isSendProtocol)
/*     */     {
/*  98 */       SApolloJoinVoipRoomRsp protocol = new SApolloJoinVoipRoomRsp();
/*  99 */       protocol.retcode = res;
/* 100 */       protocol.voip_room_type = this.voipRoomType;
/* 101 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCApolloJoinVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */