/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.drawandguess.SClearLineInfoFailRep;
/*     */ import mzm.gsp.drawandguess.SClearLineInfoSuccessRep;
/*     */ import mzm.gsp.drawandguess.SNotifyClearLineInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DrawAndGuessInfo;
/*     */ import xtable.Drawandguess_info;
/*     */ import xtable.Role2drawandguess_info;
/*     */ 
/*     */ public class PCClearLineInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long sessionid;
/*     */   private int activityCfgid;
/*     */   
/*     */   public PCClearLineInfoReq(long roleId, long sessionid)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     Session session = Session.getSession(this.sessionid);
/*  35 */     DrawAndGuessGameSession drawAndGuessGameSession = null;
/*  36 */     if ((session instanceof DrawAndGuessGameSession))
/*     */     {
/*  38 */       drawAndGuessGameSession = (DrawAndGuessGameSession)session;
/*     */     }
/*  40 */     if (drawAndGuessGameSession == null)
/*     */     {
/*  42 */       onFailed(-7);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  50 */     Long drawandguessId = Role2drawandguess_info.get(Long.valueOf(this.roleId));
/*  51 */     if (drawandguessId == null)
/*     */     {
/*  53 */       onFailed(-8);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */     DrawAndGuessInfo drawAndGuessInfo = Drawandguess_info.get(Long.valueOf(drawAndGuessGameSession.getDrawandguessId()));
/*  62 */     if (drawAndGuessInfo == null)
/*     */     {
/*  64 */       onFailed(-1);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  71 */     if (drawAndGuessInfo.getDrawer_id() != this.roleId)
/*     */     {
/*  73 */       onFailed(-4);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  80 */     if ((drawAndGuessInfo.getContext() == null) || (!(drawAndGuessInfo.getContext() instanceof DrawAndGuessContext)))
/*     */     {
/*  82 */       onFailed(-1);
/*  83 */       return false;
/*     */     }
/*  85 */     DrawAndGuessContext drawAndGuessContext = (DrawAndGuessContext)drawAndGuessInfo.getContext();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  90 */     if (drawAndGuessGameSession.getDrawandguessId() != drawandguessId.longValue())
/*     */     {
/*  92 */       onFailed(-6);
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  99 */     this.activityCfgid = drawAndGuessContext.activityCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1212, true))
/*     */     {
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 113 */     if (!DrawAndGuessManager.isFunOpen(this.roleId, this.activityCfgid))
/*     */     {
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 119 */     if (userid == null)
/*     */     {
/* 121 */       onFailed(-2);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 128 */     drawAndGuessContext.clear();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 133 */     SClearLineInfoSuccessRep sClearLineInfoSuccessRep = new SClearLineInfoSuccessRep();
/* 134 */     OnlineManager.getInstance().send(this.roleId, sClearLineInfoSuccessRep);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 139 */     SNotifyClearLineInfo sNotifyClearLineInfo = new SNotifyClearLineInfo();
/* 140 */     OnlineManager.getInstance().sendMulti(sNotifyClearLineInfo, DrawAndGuessManager.getFilteredMembers(drawAndGuessInfo.getAll_roleids(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 143 */     GameServer.logger().info(String.format("[drawandguess]PCReportLineInfoReq.processImp@ success|roleid=%d|activity_cfgid=%d|sessionid=%d|questionid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgid), Long.valueOf(this.sessionid), Integer.valueOf(drawAndGuessInfo.getCfg_id()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 148 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 153 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int error_code, Map<String, Object> extraParams)
/*     */   {
/* 164 */     SClearLineInfoFailRep rsp = new SClearLineInfoFailRep();
/* 165 */     rsp.error_code = error_code;
/* 166 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 168 */     StringBuffer logBuilder = new StringBuffer();
/* 169 */     logBuilder.append("[drawandguess]PCClearLineInfoReq.onFailed@processImp() failed");
/* 170 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 171 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 172 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 174 */     if (extraParams != null)
/*     */     {
/* 176 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 178 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 182 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PCClearLineInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */