/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Queue;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.drawandguess.SAgreeOrRefuseDrawAndGuessFailRep;
/*     */ import mzm.gsp.drawandguess.SAgreeOrRefuseDrawAndGuessSuccessRep;
/*     */ import mzm.gsp.drawandguess.SNotifyAgreeOrRefuseDrawAndGuess;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2drawandguess_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAgreeOrRefuseDrawAndGuessReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int operator;
/*     */   private final long sessionid;
/*     */   private int activityCfgid;
/*     */   
/*     */   public PCAgreeOrRefuseDrawAndGuessReq(long roleId, int operator, long sessionid)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.operator = operator;
/*  35 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     Session session = Session.getSession(this.sessionid);
/*  46 */     DrawAndGuessApplyJoinSession drawAndGuessApplyJoinSession = null;
/*  47 */     if ((session instanceof DrawAndGuessApplyJoinSession))
/*     */     {
/*  49 */       drawAndGuessApplyJoinSession = (DrawAndGuessApplyJoinSession)session;
/*     */     }
/*  51 */     if (drawAndGuessApplyJoinSession == null)
/*     */     {
/*  53 */       onFailed(-8);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  60 */     if (!drawAndGuessApplyJoinSession.getUnsuerMembers().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  62 */       onFailed(-9);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  69 */     if (!drawAndGuessApplyJoinSession.getTeamMembers().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  71 */       onFailed(-7);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  78 */     this.activityCfgid = drawAndGuessApplyJoinSession.getActivityCfgid();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  83 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(this.activityCfgid);
/*  84 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/*  86 */       onFailed(-3);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1212, true))
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 102 */     if (!DrawAndGuessManager.isFunOpen(this.roleId, this.activityCfgid))
/*     */     {
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 110 */     if (DrawAndGuessManager.isInDrawAndGuess(this.roleId))
/*     */     {
/* 112 */       onFailed(-4);
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     Map<Long, String> roleidToUserid = new HashMap();
/* 121 */     List<Long> allRoles = drawAndGuessApplyJoinSession.getTeamMembers();
/* 122 */     for (Long roleid : allRoles)
/*     */     {
/* 124 */       String userid = RoleInterface.getUserId(roleid.longValue());
/* 125 */       if (userid == null)
/*     */       {
/* 127 */         onFailed(-2);
/* 128 */         return false;
/*     */       }
/* 130 */       roleidToUserid.put(roleid, userid);
/*     */     }
/* 132 */     lock(User.getTable(), roleidToUserid.values());
/* 133 */     lock(Role2drawandguess_info.getTable(), allRoles);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, allRoles, this.activityCfgid);
/*     */     
/* 142 */     if (!result.isCanJoin())
/*     */     {
/* 144 */       Map<String, Object> extras = new HashMap();
/* 145 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 146 */       onFailed(-6, extras);
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 153 */     if (this.operator == 1)
/*     */     {
/* 155 */       drawAndGuessApplyJoinSession.agree(Long.valueOf(this.roleId));
/*     */       
/* 157 */       if (drawAndGuessApplyJoinSession.getUnsuerMembers().size() <= 0)
/*     */       {
/* 159 */         Session.removeSession(this.sessionid);
/*     */         
/*     */ 
/* 162 */         Queue<Integer> qusetionQueue = DrawAndGuessManager.getQuestionIdQueue(sDrawAndGuessActivityCfg.ruleId, drawAndGuessApplyJoinSession.getTeamMembers().size());
/*     */         
/* 164 */         if (qusetionQueue.size() <= 0)
/*     */         {
/* 166 */           onFailed(-3);
/* 167 */           return false;
/*     */         }
/* 169 */         DrawAndGuessInterface.startDrawAndGuess(session.getOwerId(), drawAndGuessApplyJoinSession.getTeamMembers(), sDrawAndGuessActivityCfg.ruleId, new DrawAndGuessContext(this.activityCfgid, qusetionQueue, new HashMap()));
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 178 */       Session.removeSession(this.sessionid);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 184 */     SAgreeOrRefuseDrawAndGuessSuccessRep sAgreeOrRefuseDrawAndGuessSuccessRep = new SAgreeOrRefuseDrawAndGuessSuccessRep();
/* 185 */     OnlineManager.getInstance().send(this.roleId, sAgreeOrRefuseDrawAndGuessSuccessRep);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 190 */     SNotifyAgreeOrRefuseDrawAndGuess sNotifyAgreeOrRefuseDrawAndGuess = new SNotifyAgreeOrRefuseDrawAndGuess();
/* 191 */     sNotifyAgreeOrRefuseDrawAndGuess.member_roleid = this.roleId;
/* 192 */     sNotifyAgreeOrRefuseDrawAndGuess.operator = this.operator;
/* 193 */     OnlineManager.getInstance().sendMulti(sNotifyAgreeOrRefuseDrawAndGuess, DrawAndGuessManager.getFilteredMembers(drawAndGuessApplyJoinSession.getTeamMembers(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 196 */     GameServer.logger().info(String.format("[drawandguess]PCAgreeOrRefuseDrawAndGuessReq.processImp@ success|roleid=%d|activity_cfgid=%d|sessionid=%d|operator=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgid), Long.valueOf(this.sessionid), Integer.valueOf(this.operator) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 201 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 206 */     onFailed(retcode, null);
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
/* 217 */     SAgreeOrRefuseDrawAndGuessFailRep rsp = new SAgreeOrRefuseDrawAndGuessFailRep();
/* 218 */     rsp.error_code = error_code;
/* 219 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 221 */     StringBuffer logBuilder = new StringBuffer();
/* 222 */     logBuilder.append("[drawandguess]PCApplyJoinDrawAndGuessReq.onFailed@processImp() failed");
/* 223 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 224 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 225 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 227 */     if (extraParams != null)
/*     */     {
/* 229 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 231 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 235 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PCAgreeOrRefuseDrawAndGuessReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */