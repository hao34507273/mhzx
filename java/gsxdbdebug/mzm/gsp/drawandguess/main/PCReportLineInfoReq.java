/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.drawandguess.DrawLineInfo;
/*     */ import mzm.gsp.drawandguess.SNotifyDrawLineInfo;
/*     */ import mzm.gsp.drawandguess.SReportLineInfoFailRep;
/*     */ import mzm.gsp.drawandguess.SReportLineInfoSuccessRep;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DrawAndGuessInfo;
/*     */ import xtable.Drawandguess_info;
/*     */ 
/*     */ public class PCReportLineInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long sessionid;
/*     */   private final DrawLineInfo drawLineInfo;
/*     */   private int activityCfgid;
/*     */   
/*     */   public PCReportLineInfoReq(long roleId, long sessionid, DrawLineInfo drawLineInfo)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.sessionid = sessionid;
/*  29 */     this.drawLineInfo = drawLineInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.drawLineInfo == null) || (this.drawLineInfo.point_list == null) || (this.drawLineInfo.point_list.size() <= 0))
/*     */     {
/*  40 */       Map<String, Object> extras = new HashMap();
/*  41 */       extras.put("point_list", this.drawLineInfo.point_list);
/*  42 */       onFailed(-8, extras);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  49 */     Session session = Session.getSession(this.sessionid);
/*  50 */     DrawAndGuessGameSession drawAndGuessGameSession = null;
/*  51 */     if ((session instanceof DrawAndGuessGameSession))
/*     */     {
/*  53 */       drawAndGuessGameSession = (DrawAndGuessGameSession)session;
/*     */     }
/*  55 */     if (drawAndGuessGameSession == null)
/*     */     {
/*  57 */       onFailed(-7);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  65 */     Long drawandguessId = xtable.Role2drawandguess_info.get(Long.valueOf(this.roleId));
/*  66 */     if (drawandguessId == null)
/*     */     {
/*  68 */       onFailed(-9);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */     DrawAndGuessInfo drawAndGuessInfo = Drawandguess_info.get(Long.valueOf(drawAndGuessGameSession.getDrawandguessId()));
/*  77 */     if (drawAndGuessInfo == null)
/*     */     {
/*  79 */       onFailed(-1);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     if (drawAndGuessInfo.getDrawer_id() != this.roleId)
/*     */     {
/*  88 */       onFailed(-4);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  95 */     if ((drawAndGuessInfo.getContext() == null) || (!(drawAndGuessInfo.getContext() instanceof DrawAndGuessContext)))
/*     */     {
/*  97 */       onFailed(-1);
/*  98 */       return false;
/*     */     }
/* 100 */     DrawAndGuessContext drawAndGuessContext = (DrawAndGuessContext)drawAndGuessInfo.getContext();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 105 */     if (drawAndGuessGameSession.getDrawandguessId() != drawandguessId.longValue())
/*     */     {
/* 107 */       onFailed(-6);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 114 */     this.activityCfgid = drawAndGuessContext.activityCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1212, true))
/*     */     {
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 128 */     if (!DrawAndGuessManager.isFunOpen(this.roleId, this.activityCfgid))
/*     */     {
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 134 */     if (userid == null)
/*     */     {
/* 136 */       onFailed(-2);
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 143 */     int totalPointSize = drawAndGuessContext.getTotalPoint();
/* 144 */     if (totalPointSize + this.drawLineInfo.point_list.size() > 40960)
/*     */     {
/* 146 */       Map<String, Object> extras = new HashMap();
/* 147 */       extras.put("totalPointSize", Integer.valueOf(totalPointSize));
/* 148 */       onFailed(-8, extras);
/* 149 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 155 */     boolean success = drawAndGuessContext.draw(this.drawLineInfo);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 160 */     SReportLineInfoSuccessRep sReportLineInfoSuccessRep = new SReportLineInfoSuccessRep();
/* 161 */     OnlineManager.getInstance().send(this.roleId, sReportLineInfoSuccessRep);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 166 */     if (success)
/*     */     {
/* 168 */       SNotifyDrawLineInfo sNotifyDrawLineInfo = new SNotifyDrawLineInfo();
/* 169 */       sNotifyDrawLineInfo.drawlineinfo = this.drawLineInfo;
/* 170 */       OnlineManager.getInstance().sendMulti(sNotifyDrawLineInfo, DrawAndGuessManager.getFilteredMembers(drawAndGuessInfo.getAll_roleids(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 174 */     GameServer.logger().info(String.format("[drawandguess]PCReportLineInfoReq.processImp@ success|roleid=%d|activity_cfgid=%d|sessionid=%d|questionid=%d|pointSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgid), Long.valueOf(this.sessionid), Integer.valueOf(drawAndGuessInfo.getCfg_id()), Integer.valueOf(this.drawLineInfo.point_list.size()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 180 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 185 */     onFailed(retcode, null);
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
/* 196 */     SReportLineInfoFailRep rsp = new SReportLineInfoFailRep();
/* 197 */     rsp.error_code = error_code;
/* 198 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 200 */     StringBuffer logBuilder = new StringBuffer();
/* 201 */     logBuilder.append("[drawandguess]PCReportLineInfoReq.onFailed@processImp() failed");
/* 202 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 203 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 204 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 206 */     if (extraParams != null)
/*     */     {
/* 208 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 210 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 214 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PCReportLineInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */