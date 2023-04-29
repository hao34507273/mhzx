/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.drawandguess.DrawLineInfo;
/*     */ import mzm.gsp.drawandguess.PointInfo;
/*     */ import mzm.gsp.drawandguess.SAppendLineInfoFailRep;
/*     */ import mzm.gsp.drawandguess.SAppendLineInfoSuccessRep;
/*     */ import mzm.gsp.drawandguess.SNotifyAppendLineInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DrawAndGuessInfo;
/*     */ import xtable.Drawandguess_info;
/*     */ 
/*     */ public class PCAppendLineInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long sessionid;
/*     */   private final int line_id;
/*     */   private final ArrayList<PointInfo> point_list;
/*     */   private int activityCfgid;
/*     */   
/*     */   public PCAppendLineInfoReq(long roleId, long sessionid, int line_id, ArrayList<PointInfo> point_list)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.sessionid = sessionid;
/*  31 */     this.line_id = line_id;
/*  32 */     this.point_list = point_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if ((this.point_list == null) || (this.point_list.size() <= 0))
/*     */     {
/*  43 */       Map<String, Object> extras = new HashMap();
/*  44 */       extras.put("point_list", this.point_list);
/*  45 */       onFailed(-8, extras);
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  52 */     Session session = Session.getSession(this.sessionid);
/*  53 */     DrawAndGuessGameSession drawAndGuessGameSession = null;
/*  54 */     if ((session instanceof DrawAndGuessGameSession))
/*     */     {
/*  56 */       drawAndGuessGameSession = (DrawAndGuessGameSession)session;
/*     */     }
/*  58 */     if (drawAndGuessGameSession == null)
/*     */     {
/*  60 */       onFailed(-7);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */     Long drawandguessId = xtable.Role2drawandguess_info.get(Long.valueOf(this.roleId));
/*  69 */     if (drawandguessId == null)
/*     */     {
/*  71 */       onFailed(-9);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  79 */     DrawAndGuessInfo drawAndGuessInfo = Drawandguess_info.get(Long.valueOf(drawAndGuessGameSession.getDrawandguessId()));
/*  80 */     if (drawAndGuessInfo == null)
/*     */     {
/*  82 */       onFailed(-1);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  89 */     if (drawAndGuessInfo.getDrawer_id() != this.roleId)
/*     */     {
/*  91 */       onFailed(-4);
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  98 */     if ((drawAndGuessInfo.getContext() == null) || (!(drawAndGuessInfo.getContext() instanceof DrawAndGuessContext)))
/*     */     {
/* 100 */       onFailed(-1);
/* 101 */       return false;
/*     */     }
/* 103 */     DrawAndGuessContext drawAndGuessContext = (DrawAndGuessContext)drawAndGuessInfo.getContext();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     if (drawAndGuessGameSession.getDrawandguessId() != drawandguessId.longValue())
/*     */     {
/* 110 */       onFailed(-6);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 117 */     this.activityCfgid = drawAndGuessContext.activityCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1212, true))
/*     */     {
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 131 */     if (!DrawAndGuessManager.isFunOpen(this.roleId, this.activityCfgid))
/*     */     {
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 137 */     if (userid == null)
/*     */     {
/* 139 */       onFailed(-2);
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 146 */     int totalPointSize = drawAndGuessContext.getTotalPoint();
/* 147 */     if (totalPointSize + this.point_list.size() > 40960)
/*     */     {
/* 149 */       Map<String, Object> extras = new HashMap();
/* 150 */       extras.put("totalPointSize", Integer.valueOf(totalPointSize));
/* 151 */       onFailed(-8, extras);
/* 152 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 158 */     DrawLineInfo appendLineInfo = new DrawLineInfo(this.line_id, -1, (byte)-1, (byte)-1, this.point_list);
/*     */     
/* 160 */     boolean success = drawAndGuessContext.draw(appendLineInfo);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 165 */     SAppendLineInfoSuccessRep sAppendLineInfoSuccessRep = new SAppendLineInfoSuccessRep();
/* 166 */     OnlineManager.getInstance().send(this.roleId, sAppendLineInfoSuccessRep);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 171 */     if (success)
/*     */     {
/* 173 */       SNotifyAppendLineInfo sNotifyAppendLineInfo = new SNotifyAppendLineInfo();
/* 174 */       sNotifyAppendLineInfo.line_id = this.line_id;
/* 175 */       sNotifyAppendLineInfo.action_id = appendLineInfo.action_id;
/* 176 */       sNotifyAppendLineInfo.point_list.addAll(this.point_list);
/* 177 */       OnlineManager.getInstance().sendMulti(sNotifyAppendLineInfo, DrawAndGuessManager.getFilteredMembers(drawAndGuessInfo.getAll_roleids(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 181 */     GameServer.logger().info(String.format("[drawandguess]PCAppendLineInfoReq.processImp@ success|roleid=%d|activity_cfgid=%d|sessionid=%d|questionid=%d|pointSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgid), Long.valueOf(this.sessionid), Integer.valueOf(drawAndGuessInfo.getCfg_id()), Integer.valueOf(this.point_list.size()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 186 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 191 */     onFailed(retcode, null);
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
/* 202 */     SAppendLineInfoFailRep rsp = new SAppendLineInfoFailRep();
/* 203 */     rsp.error_code = error_code;
/* 204 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 206 */     StringBuffer logBuilder = new StringBuffer();
/* 207 */     logBuilder.append("[drawandguess]PCAppendLineInfoReq.onFailed@processImp() failed");
/* 208 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 209 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 210 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 212 */     if (extraParams != null)
/*     */     {
/* 214 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 216 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 220 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PCAppendLineInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */