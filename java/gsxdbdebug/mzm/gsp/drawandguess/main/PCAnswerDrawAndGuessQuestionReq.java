/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.drawandguess.AnswerInfo;
/*     */ import mzm.gsp.drawandguess.SAnswerDrawAndGuessQuestionFailRep;
/*     */ import mzm.gsp.drawandguess.SAnswerDrawAndGuessQuestionSuccessRep;
/*     */ import mzm.gsp.drawandguess.SNotifyDrawAndGuessAnswer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DrawAndGuessInfo;
/*     */ import xtable.Drawandguess_info;
/*     */ import xtable.Role2drawandguess_info;
/*     */ 
/*     */ public class PCAnswerDrawAndGuessQuestionReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*  22 */   private static final String[] replaceStar = { "", "*", "**", "***", "****", "*****", "******", "*******", "********", "*********", "**********" };
/*     */   
/*     */   private final long roleId;
/*     */   
/*     */   private final String answer;
/*     */   private final long sessionid;
/*     */   private int activityCfgid;
/*     */   
/*     */   public PCAnswerDrawAndGuessQuestionReq(long roleId, String answer, long sessionid)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.answer = (answer == null ? "" : answer);
/*  34 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     Session session = Session.getSession(this.sessionid);
/*  45 */     DrawAndGuessGameSession drawAndGuessGameSession = null;
/*  46 */     if ((session instanceof DrawAndGuessGameSession))
/*     */     {
/*  48 */       drawAndGuessGameSession = (DrawAndGuessGameSession)session;
/*     */     }
/*  50 */     if (drawAndGuessGameSession == null)
/*     */     {
/*  52 */       onFailed(-7);
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  60 */     Long drawandguessId = Role2drawandguess_info.get(Long.valueOf(this.roleId));
/*  61 */     if (drawandguessId == null)
/*     */     {
/*  63 */       onFailed(-9);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */     DrawAndGuessInfo drawAndGuessInfo = Drawandguess_info.get(Long.valueOf(drawAndGuessGameSession.getDrawandguessId()));
/*  72 */     if (drawAndGuessInfo == null)
/*     */     {
/*  74 */       onFailed(-1);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  81 */     if (!DrawAndGuessManager.checkAndSetAnswerInterval(this.roleId, 1, drawAndGuessInfo)) {
/*  82 */       onFailed(-11);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  89 */     if (("".equals(this.answer)) || (this.answer.length() > 40))
/*     */     {
/*  91 */       Map<String, Object> extras = new HashMap();
/*  92 */       extras.put("answer", this.answer);
/*  93 */       onFailed(-8, extras);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 100 */     if (drawAndGuessInfo.getDrawer_id() == this.roleId)
/*     */     {
/* 102 */       onFailed(-4);
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 109 */     if ((drawAndGuessInfo.getContext() == null) || (!(drawAndGuessInfo.getContext() instanceof DrawAndGuessContext)))
/*     */     {
/* 111 */       onFailed(-1);
/* 112 */       return false;
/*     */     }
/* 114 */     DrawAndGuessContext drawAndGuessContext = (DrawAndGuessContext)drawAndGuessInfo.getContext();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 119 */     if (drawAndGuessGameSession.getDrawandguessId() != drawandguessId.longValue())
/*     */     {
/* 121 */       onFailed(-6);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 128 */     this.activityCfgid = drawAndGuessContext.activityCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 134 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1212, true))
/*     */     {
/* 136 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 142 */     if (!DrawAndGuessManager.isFunOpen(this.roleId, this.activityCfgid))
/*     */     {
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     String userid = RoleInterface.getUserId(this.roleId);
/* 148 */     if (userid == null)
/*     */     {
/* 150 */       onFailed(-2);
/* 151 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 157 */     int answerResult = DrawAndGuessManager.getAnswerResult(drawAndGuessInfo.getCfg_id(), this.answer);
/*     */     AnswerInfo answerInfo;
/* 159 */     if (answerResult == 1)
/*     */     {
/* 161 */       AnswerInfo answerInfo = new AnswerInfo(this.roleId, "", answerResult);
/*     */       
/* 163 */       if (!drawAndGuessInfo.getSuc_roleids().contains(Long.valueOf(this.roleId)))
/*     */       {
/* 165 */         drawAndGuessInfo.getSuc_roleids().add(Long.valueOf(this.roleId));
/* 166 */         drawAndGuessContext.answer(answerInfo);
/*     */       }
/*     */       else
/*     */       {
/* 170 */         onFailed(-10);
/* 171 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 176 */       String rightAnswer = DrawAndGuessManager.getAnswer(drawAndGuessInfo.getCfg_id());
/* 177 */       String replaceAnswer = this.answer.replaceAll(rightAnswer, replaceStar[rightAnswer.length()]);
/* 178 */       answerInfo = new AnswerInfo(this.roleId, replaceAnswer, answerResult);
/* 179 */       drawAndGuessContext.answer(answerInfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 185 */     SAnswerDrawAndGuessQuestionSuccessRep sAnswerDrawAndGuessQuestionSuccessRep = new SAnswerDrawAndGuessQuestionSuccessRep();
/* 186 */     sAnswerDrawAndGuessQuestionSuccessRep.result = answerResult;
/* 187 */     OnlineManager.getInstance().send(this.roleId, sAnswerDrawAndGuessQuestionSuccessRep);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 192 */     SNotifyDrawAndGuessAnswer sNotifyDrawAndGuessAnswer = new SNotifyDrawAndGuessAnswer();
/* 193 */     AnswerInfo answerinfo = answerInfo;
/* 194 */     sNotifyDrawAndGuessAnswer.answerinfo = answerinfo;
/* 195 */     OnlineManager.getInstance().sendMulti(sNotifyDrawAndGuessAnswer, DrawAndGuessManager.getFilteredMembers(drawAndGuessInfo.getAll_roleids(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 198 */     GameServer.logger().info(String.format("[drawandguess]PCAnswerDrawAndGuessQuestionReq.processImp@ success|roleid=%d|activity_cfgid=%d|sessionid=%d|questionid=%d|answer=%s|answerResult=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgid), Long.valueOf(this.sessionid), Integer.valueOf(drawAndGuessInfo.getCfg_id()), this.answer, Integer.valueOf(answerResult) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */     if ((answerResult == 1) && 
/* 206 */       (drawAndGuessInfo.getSuc_roleids().size() == drawAndGuessInfo.getAll_roleids().size() - 1)) {
/* 207 */       Session.removeSession(this.sessionid);
/* 208 */       new PGameFinished(drawandguessId.longValue(), drawAndGuessInfo.getAll_roleids()).execute();
/*     */     }
/*     */     
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 216 */     onFailed(retcode, null);
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
/* 227 */     SAnswerDrawAndGuessQuestionFailRep rsp = new SAnswerDrawAndGuessQuestionFailRep();
/* 228 */     rsp.error_code = error_code;
/* 229 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 231 */     StringBuffer logBuilder = new StringBuffer();
/* 232 */     logBuilder.append("[drawandguess]PCAnswerDrawAndGuessQuestionReq.onFailed@processImp() failed");
/* 233 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 234 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 235 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 237 */     if (extraParams != null)
/*     */     {
/* 239 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 241 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 245 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PCAnswerDrawAndGuessQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */