/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.drawandguess.SSynDrawAndGuessNoReward;
/*     */ import mzm.gsp.drawandguess.SSynDrawAndGuessQuestionInfo;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessQuestionCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessRuleCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SLibid2QuestionsCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DrawAndGuessInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Drawandguess_info;
/*     */ import xtable.Role2drawandguess_info;
/*     */ 
/*     */ public class DrawAndGuessManager
/*     */ {
/*  34 */   static final Logger logger = Logger.getLogger("drawandguess");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen(int activityId)
/*     */   {
/*  44 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(activityId);
/*  45 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!OpenInterface.getOpenStatus(sDrawAndGuessActivityCfg.openCfgid))
/*     */     {
/*  51 */       GameServer.logger().error("[drawandguess]DrawAndGuessManager.isFunOpen@fun not open");
/*  52 */       return false;
/*     */     }
/*  54 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen(long roleid, int activityId)
/*     */   {
/*  66 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(activityId);
/*  67 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/*  69 */       return false;
/*     */     }
/*  71 */     if (!OpenInterface.getOpenStatus(sDrawAndGuessActivityCfg.openCfgid))
/*     */     {
/*  73 */       GameServer.logger().error("[drawandguess]DrawAndGuessManager.isFunOpen@fun not open");
/*  74 */       return false;
/*     */     }
/*  76 */     if (OpenInterface.isBanPlay(roleid, sDrawAndGuessActivityCfg.openCfgid))
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[drawandguess]DrawAndGuessManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  79 */       OpenInterface.sendBanPlayMsg(roleid, sDrawAndGuessActivityCfg.openCfgid);
/*  80 */       return false;
/*     */     }
/*  82 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNpcController(int activityCfgid)
/*     */   {
/*  93 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(activityCfgid);
/*  94 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/*  96 */       GameServer.logger().error(String.format("[drawandguess]DrawAndGuessManager.getNpcController@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */       
/*     */ 
/*  99 */       return -1;
/*     */     }
/* 101 */     SNpc npc = mzm.gsp.npc.main.NpcInterface.getNpc(sDrawAndGuessActivityCfg.npcCfgid);
/* 102 */     if (npc == null)
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[drawandguess]DrawAndGuessManager.getNpcController@npc cfg is null|activity_cfgid=%d|npc_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(sDrawAndGuessActivityCfg.npcCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 108 */       return -1;
/*     */     }
/* 110 */     return npc.controllerId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onOpenChange(int activityCfgid, boolean open)
/*     */   {
/* 121 */     if (!ActivityInterface.isActivityOpen(activityCfgid))
/*     */     {
/* 123 */       return;
/*     */     }
/*     */     
/* 126 */     int controller = getNpcController(activityCfgid);
/* 127 */     if (controller <= 0)
/*     */     {
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     if (open)
/*     */     {
/* 134 */       ControllerInterface.triggerController(controller);
/*     */     }
/*     */     else
/*     */     {
/* 138 */       ControllerInterface.collectController(controller);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInDrawAndGuess(long roleid)
/*     */   {
/* 151 */     return Role2drawandguess_info.select(Long.valueOf(roleid)) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Long> getFilteredMembers(List<Long> members, Long unImport)
/*     */   {
/* 163 */     List<Long> copyMembers = new ArrayList(members);
/* 164 */     copyMembers.remove(unImport);
/* 165 */     return copyMembers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Queue<Integer> getQuestionIdQueue(int ruleId, int size)
/*     */   {
/* 177 */     Queue<Integer> qusetionQueue = new ConcurrentLinkedQueue();
/*     */     
/* 179 */     SDrawAndGuessRuleCfg sDrawAndGuessRuleCfg = SDrawAndGuessRuleCfg.get(ruleId);
/* 180 */     if (sDrawAndGuessRuleCfg != null)
/*     */     {
/* 182 */       SLibid2QuestionsCfg sLibid2QuestionsCfg = SLibid2QuestionsCfg.get(sDrawAndGuessRuleCfg.questionLibId);
/* 183 */       if (sLibid2QuestionsCfg != null)
/*     */       {
/* 185 */         List<Integer> questionIds = new ArrayList(sLibid2QuestionsCfg.questions);
/* 186 */         if (questionIds.size() < size)
/*     */         {
/* 188 */           return qusetionQueue;
/*     */         }
/* 190 */         java.util.Collections.shuffle(questionIds);
/* 191 */         for (int i = 0; i < size; i++)
/*     */         {
/* 193 */           qusetionQueue.offer(questionIds.get(i));
/*     */         }
/*     */       }
/*     */     }
/* 197 */     return qusetionQueue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void filterJinFenMap(SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg, Map<Long, Integer> jifenMap)
/*     */   {
/* 208 */     SSynDrawAndGuessNoReward sSynDrawAndGuessNoReward = new SSynDrawAndGuessNoReward();
/*     */     
/* 210 */     Iterator<Map.Entry<Long, Integer>> it = jifenMap.entrySet().iterator();
/*     */     
/*     */ 
/* 213 */     while (it.hasNext()) {
/* 214 */       Map.Entry<Long, Integer> entry = (Map.Entry)it.next();
/* 215 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(((Long)entry.getKey()).longValue());
/* 216 */       int count = ActivityInterface.getActivityCount(userid, ((Long)entry.getKey()).longValue(), sDrawAndGuessActivityCfg.activityCfgid, true);
/* 217 */       if (count >= sDrawAndGuessActivityCfg.maxRewardTimes)
/*     */       {
/* 219 */         it.remove();
/* 220 */         OnlineManager.getInstance().send(((Long)entry.getKey()).longValue(), sSynDrawAndGuessNoReward);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startDrawAndGuess(final long drawerId, List<Long> memberIds, final int ruleCfgid, final IDrawAndGuessContext context)
/*     */   {
/* 237 */     SDrawAndGuessRuleCfg sDrawAndGuessRuleCfg = SDrawAndGuessRuleCfg.get(ruleCfgid);
/* 238 */     if (sDrawAndGuessRuleCfg == null)
/*     */     {
/* 240 */       String logstr = String.format("[drawandguess]DrawAndGuessManager.startDrawAndGuess@ruleCfgid error!|ruleCfgid=%d|drawerId=%d|memberId=%s", new Object[] { Integer.valueOf(ruleCfgid), Long.valueOf(drawerId), memberIds.toString() });
/*     */       
/*     */ 
/* 243 */       logger.error(logstr);
/* 244 */       return;
/*     */     }
/* 246 */     final long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 248 */     final long delay = TimeUnit.SECONDS.toMillis(1L);
/* 249 */     long countdown = TimeUnit.SECONDS.toMillis(sDrawAndGuessRuleCfg.drawCountdownTime);
/* 250 */     final long limittime = TimeUnit.SECONDS.toMillis(sDrawAndGuessRuleCfg.roundContinueTime);
/*     */     
/* 252 */     int questionId = context.getQuestionCfgid();
/* 253 */     if (SDrawAndGuessQuestionCfg.get(questionId) == null)
/*     */     {
/* 255 */       String logstr = String.format("[drawandguess]DrawAndGuessManager.startDrawAndGuess@questionId error!|questionId=%d|drawerId=%d|memberId=%s", new Object[] { Integer.valueOf(questionId), Long.valueOf(drawerId), memberIds.toString() });
/*     */       
/*     */ 
/* 258 */       logger.error(logstr);
/* 259 */       return;
/*     */     }
/* 261 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 267 */         Lockeys.lock(Role2drawandguess_info.getTable(), this.val$memberIds);
/* 268 */         if ((this.val$memberIds == null) || (this.val$memberIds.size() == 0))
/*     */         {
/* 270 */           return false;
/*     */         }
/* 272 */         for (Iterator i$ = this.val$memberIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/* 275 */           if (DrawAndGuessManager.isInDrawAndGuess(roleid))
/*     */           {
/* 277 */             String logstr = String.format("[drawandguess]DrawAndGuessManager.startDrawAndGuess@role already in drawandguess state!|ruleCfgid=%d|roleid=%d", new Object[] { Integer.valueOf(ruleCfgid), Long.valueOf(roleid) });
/*     */             
/*     */ 
/* 280 */             DrawAndGuessManager.logger.info(logstr);
/* 281 */             return false;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 286 */         DrawAndGuessInfo drawAndGuessInfo = xbean.Pod.newDrawAndGuessInfo();
/* 287 */         drawAndGuessInfo.setContext(context);
/* 288 */         drawAndGuessInfo.setStart_time(now);
/* 289 */         drawAndGuessInfo.setCfg_id(drawerId);
/* 290 */         drawAndGuessInfo.setDrawer_id(limittime);
/* 291 */         drawAndGuessInfo.getAll_roleids().addAll(this.val$memberIds);
/* 292 */         long drawandguessId = Drawandguess_info.insert(drawAndGuessInfo).longValue();
/*     */         
/* 294 */         long sessionId = new DrawAndGuessGameSession(TimeUnit.MILLISECONDS.toSeconds(delay + this.val$countdown + this.val$delay), drawandguessId, this.val$memberIds).getSessionId();
/*     */         
/* 296 */         drawAndGuessInfo.setSession_id(sessionId);
/*     */         
/* 298 */         for (Iterator i$ = this.val$memberIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 300 */           Role2drawandguess_info.insert(Long.valueOf(roleid), Long.valueOf(drawandguessId));
/*     */         }
/*     */         
/* 303 */         SSynDrawAndGuessQuestionInfo res = new SSynDrawAndGuessQuestionInfo();
/* 304 */         res.drawerid = limittime;
/* 305 */         res.roleid_list.addAll(this.val$memberIds);
/* 306 */         res.questioncfgid = drawerId;
/* 307 */         res.timestamp = TimeUnit.MILLISECONDS.toSeconds(now);
/* 308 */         res.sessionid = sessionId;
/* 309 */         res.sendtype = 1;
/* 310 */         Map<Long, Integer> jifenInfo = context.getJifenInfo();
/* 311 */         if (jifenInfo != null)
/*     */         {
/* 313 */           for (Map.Entry<Long, Integer> entry : jifenInfo.entrySet())
/*     */           {
/* 315 */             res.jifen_list.add(new mzm.gsp.drawandguess.RoleGetJifenInfo(((Long)entry.getKey()).longValue(), ((Integer)entry.getValue()).intValue()));
/*     */           }
/*     */         }
/* 318 */         OnlineManager.getInstance().sendMulti(res, this.val$memberIds);
/*     */         
/*     */ 
/* 321 */         RoleStatusInterface.setStatus(this.val$memberIds, 1211, false);
/*     */         
/*     */ 
/* 324 */         DrawAndGuessTLogManager.tlogDrawAndGuessStarted(drawandguessId, limittime, drawerId, ruleCfgid, this.val$memberIds);
/* 325 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeAllDrawAndGuessRoles(List<Long> roleids)
/*     */   {
/* 338 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 341 */       RoleStatusInterface.unsetStatus(r, 1211);
/* 342 */       Role2drawandguess_info.remove(Long.valueOf(r));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static String getAnswer(int questionCfgId)
/*     */   {
/* 354 */     SDrawAndGuessQuestionCfg sDrawAndGuessQuestionCfg = SDrawAndGuessQuestionCfg.get(questionCfgId);
/* 355 */     if (sDrawAndGuessQuestionCfg == null)
/*     */     {
/* 357 */       String logstr = String.format("[drawandguess]DrawAndGuessManager.getAnswer@questionId error!|questionCfgId=%d", new Object[] { Integer.valueOf(questionCfgId) });
/*     */       
/* 359 */       logger.error(logstr);
/* 360 */       return "";
/*     */     }
/* 362 */     return sDrawAndGuessQuestionCfg.answer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAnswerResult(int questionCfgId, String answer)
/*     */   {
/* 374 */     SDrawAndGuessQuestionCfg sDrawAndGuessQuestionCfg = SDrawAndGuessQuestionCfg.get(questionCfgId);
/* 375 */     if (sDrawAndGuessQuestionCfg == null)
/*     */     {
/* 377 */       String logstr = String.format("[drawandguess]DrawAndGuessManager.getAnswerResult@questionId error!|questionCfgId=%d|answer=%s", new Object[] { Integer.valueOf(questionCfgId), answer });
/*     */       
/*     */ 
/* 380 */       logger.error(logstr);
/* 381 */       return 0;
/*     */     }
/* 383 */     if (answer.equals(sDrawAndGuessQuestionCfg.answer))
/*     */     {
/* 385 */       return 1;
/*     */     }
/*     */     
/*     */ 
/* 389 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkAndSetAnswerInterval(long roleId, int interval, DrawAndGuessInfo drawAndGuessInfo)
/*     */   {
/* 404 */     Long lastAnswerTime = (Long)drawAndGuessInfo.getRoleids2answer_time().get(Long.valueOf(roleId));
/* 405 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 406 */     if ((lastAnswerTime != null) && (TimeUnit.MILLISECONDS.toSeconds(currTime - lastAnswerTime.longValue()) < interval))
/*     */     {
/* 408 */       return false;
/*     */     }
/* 410 */     drawAndGuessInfo.getRoleids2answer_time().put(Long.valueOf(roleId), Long.valueOf(currTime));
/* 411 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */