/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.SAnswerWordQuestionRes;
/*     */ import mzm.gsp.question.SSyncAllWordQuestionOver;
/*     */ import mzm.gsp.question.SSyncWordQuestionInfo;
/*     */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*     */ import mzm.gsp.question.confbean.SQuestionLv2QuestionItemId;
/*     */ import mzm.gsp.question.confbean.SWordQuestionLevelCfg;
/*     */ import mzm.gsp.question.event.FinishWordQuestion;
/*     */ import mzm.gsp.question.event.WordQuestionArg;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleWordQuestionInfo;
/*     */ import xbean.WordQuestionInfo;
/*     */ import xtable.Role2wordquestion;
/*     */ import xtable.Wordquestion;
/*     */ 
/*     */ class WordQuestionManager
/*     */ {
/*  35 */   private static WordQuestionManager instance = new WordQuestionManager();
/*     */   
/*  37 */   static Logger logger = null;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final int WAN = 10000;
/*     */   
/*     */ 
/*     */ 
/*     */   public static WordQuestionManager getInstance()
/*     */   {
/*  47 */     return instance;
/*     */   }
/*     */   
/*     */   void init()
/*     */   {
/*  52 */     logger = Logger.getLogger(WordQuestionManager.class);
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
/*     */   void startQuestion(final List<Long> roleIdList, final int questionLevelCfgId, final int questionType, final Object attachObject)
/*     */   {
/*  65 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  70 */         SQuestionLv2QuestionItemId questionLv2QuestionItemId = SQuestionLv2QuestionItemId.get(questionType);
/*  71 */         if (questionLv2QuestionItemId == null)
/*     */         {
/*  73 */           String logStr = String.format("[wordquestion]WordQuestionManager.startQuestion@ SQuestionLv2QuestionItemId is null|questionLv=%d|roleids=%s", new Object[] { Integer.valueOf(questionType), roleIdList.toString() });
/*     */           
/*     */ 
/*  76 */           WordQuestionManager.logger.error(logStr);
/*  77 */           return false;
/*     */         }
/*     */         
/*  80 */         List<Integer> questionList = questionLv2QuestionItemId.questionIds;
/*  81 */         if ((questionList == null) || (questionList.isEmpty()))
/*     */         {
/*  83 */           String logStr = String.format("[wordquestion]WordQuestionManager.startQuestion@ question list is empty|questionLv=%d|roleids=%s", new Object[] { Integer.valueOf(questionType), roleIdList.toString() });
/*     */           
/*     */ 
/*  86 */           WordQuestionManager.logger.error(logStr);
/*  87 */           return false;
/*     */         }
/*     */         
/*  90 */         SWordQuestionLevelCfg cfg = SWordQuestionLevelCfg.get(questionLevelCfgId);
/*  91 */         if (cfg == null)
/*     */         {
/*  93 */           String logStr = String.format("[wordquestion]WordQuestionManager.startQuestion@ SWordQuestionLevelCfg is null|questionLv=%d|roleids=%s|questionLevelCfgId=%d", new Object[] { Integer.valueOf(questionType), roleIdList.toString(), Integer.valueOf(questionLevelCfgId) });
/*     */           
/*     */ 
/*  96 */           WordQuestionManager.logger.error(logStr);
/*  97 */           return false;
/*     */         }
/*     */         
/* 100 */         lock(Role2wordquestion.getTable(), roleIdList);
/* 101 */         WordQuestionInfo xWordQuestionInfo = Pod.newWordQuestionInfo();
/* 102 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 104 */           Long wordQuestionId = Role2wordquestion.get(Long.valueOf(roleId));
/* 105 */           if (wordQuestionId != null)
/*     */           {
/*     */ 
/* 108 */             String logStr = String.format("[wordquestion]WordQuestionManager.startQuestion@Role is already in word question|roleid=%d|questionLv=%d|roleids=%s|questionLevelCfgId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(questionType), roleIdList.toString(), Integer.valueOf(questionLevelCfgId) });
/*     */             
/*     */ 
/* 111 */             WordQuestionManager.logger.error(logStr);
/*     */             
/* 113 */             return false;
/*     */           }
/* 115 */           RoleWordQuestionInfo xInfo = Pod.newRoleWordQuestionInfo();
/* 116 */           CommonUtils.regionRandom(questionList, cfg.everyoneQuestionNum, xInfo.getQuestionidlist());
/* 117 */           xInfo.setCuridx(0);
/* 118 */           xInfo.setRightnum(0);
/* 119 */           xWordQuestionInfo.getRolequestionmap().put(Long.valueOf(roleId), xInfo);
/*     */         }
/* 121 */         xWordQuestionInfo.setLevelcfgid(cfg.id);
/* 122 */         xWordQuestionInfo.setAttachobject(attachObject);
/* 123 */         long worldId = Wordquestion.insert(xWordQuestionInfo).longValue();
/* 124 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 126 */           Role2wordquestion.add(Long.valueOf(roleId), Long.valueOf(worldId));
/* 127 */           RoleWordQuestionInfo xRoleWordQuestionInfo = (RoleWordQuestionInfo)xWordQuestionInfo.getRolequestionmap().get(Long.valueOf(roleId));
/* 128 */           WordQuestionManager.this.syncWorldQuestionInfo(roleId, xRoleWordQuestionInfo, cfg.id);
/* 129 */           WordQuestionItemSession session = new WordQuestionItemSession(cfg.everyQuestionIntervalSec, roleId, xRoleWordQuestionInfo.getCuridx());
/*     */           
/* 131 */           xRoleWordQuestionInfo.setSessionid(session.getSessionId());
/*     */         }
/* 133 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void stopQuestion(long roleId, boolean issuccess)
/*     */   {
/* 145 */     Long wordId = Role2wordquestion.get(Long.valueOf(roleId));
/* 146 */     if (wordId == null)
/*     */     {
/* 148 */       return;
/*     */     }
/*     */     
/* 151 */     NoneRealTimeTaskManager.getInstance().addTask(new StopRoleQuestionPro(issuccess, wordId.longValue()));
/*     */   }
/*     */   
/*     */   private static class StopRoleQuestionPro extends LogicProcedure
/*     */   {
/*     */     private final boolean issuccess;
/*     */     private final long wordId;
/*     */     
/*     */     public StopRoleQuestionPro(boolean issuccess, long wordId)
/*     */     {
/* 161 */       this.issuccess = issuccess;
/* 162 */       this.wordId = wordId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 168 */       WordQuestionInfo xWord = Wordquestion.get(Long.valueOf(this.wordId));
/* 169 */       for (Map.Entry<Long, RoleWordQuestionInfo> entry : xWord.getRolequestionmap().entrySet())
/*     */       {
/* 171 */         RoleWordQuestionInfo roleWordQuestionInfo = (RoleWordQuestionInfo)entry.getValue();
/* 172 */         if (this.issuccess)
/*     */         {
/* 174 */           roleWordQuestionInfo.setRightnum(roleWordQuestionInfo.getQuestionidlist().size());
/*     */         }
/*     */         else
/*     */         {
/* 178 */           roleWordQuestionInfo.setRightnum(0);
/*     */         }
/*     */         
/* 181 */         WordQuestionItemSession session = (WordQuestionItemSession)WordQuestionItemSession.getSession(roleWordQuestionInfo.getSessionid());
/* 182 */         if (session != null)
/*     */         {
/* 184 */           session.stopTimer();
/*     */         }
/*     */       }
/*     */       
/* 188 */       WordQuestionManager.getInstance().allEnd(this.wordId, xWord);
/* 189 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void syncWorldQuestionInfo(long roleId, RoleWordQuestionInfo xRoleWordQuestionInfo, int levelCfgId)
/*     */   {
/* 195 */     int idx = xRoleWordQuestionInfo.getCuridx();
/* 196 */     SSyncWordQuestionInfo sSyncWordQuestionInfo = new SSyncWordQuestionInfo();
/* 197 */     if ((0 <= idx) && (idx < xRoleWordQuestionInfo.getQuestionidlist().size()))
/*     */     {
/* 199 */       sSyncWordQuestionInfo.curquestionid = ((Integer)xRoleWordQuestionInfo.getQuestionidlist().get(idx)).intValue();
/*     */     }
/*     */     
/* 202 */     sSyncWordQuestionInfo.rightnum = xRoleWordQuestionInfo.getRightnum();
/* 203 */     sSyncWordQuestionInfo.levelcfgid = levelCfgId;
/* 204 */     sSyncWordQuestionInfo.wrongnum = (idx - xRoleWordQuestionInfo.getRightnum());
/* 205 */     long sessionId = xRoleWordQuestionInfo.getSessionid();
/* 206 */     WordQuestionItemSession session = (WordQuestionItemSession)Session.getSession(sessionId);
/* 207 */     if (session != null)
/*     */     {
/* 209 */       sSyncWordQuestionInfo.endtime = session.getEndTime();
/*     */     }
/*     */     else
/*     */     {
/* 213 */       SWordQuestionLevelCfg cfg = SWordQuestionLevelCfg.get(levelCfgId);
/* 214 */       sSyncWordQuestionInfo.endtime = ((int)(TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()) + cfg.everyQuestionIntervalSec));
/*     */     }
/* 216 */     if (sSyncWordQuestionInfo.curquestionid >= 0)
/*     */     {
/* 218 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(sSyncWordQuestionInfo.curquestionid);
/* 219 */       if (cfg != null)
/*     */       {
/* 221 */         long sessionid = QuestionSessionInterface.createQuestionSession(roleId, QuestionTypeEnum.WORD, sSyncWordQuestionInfo.curquestionid, 0, cfg.answer_num, 1);
/*     */         
/* 223 */         sSyncWordQuestionInfo.sessionid = sessionid;
/* 224 */         sSyncWordQuestionInfo.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */       }
/*     */     }
/* 227 */     OnlineManager.getInstance().send(roleId, sSyncWordQuestionInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void syncAnswerInfo(long roleId, WordQuestionInfo xWordInfo, int isRight)
/*     */   {
/* 239 */     RoleWordQuestionInfo xRoleWordInfo = (RoleWordQuestionInfo)xWordInfo.getRolequestionmap().get(Long.valueOf(roleId));
/* 240 */     SAnswerWordQuestionRes res = new SAnswerWordQuestionRes();
/* 241 */     res.isright = isRight;
/* 242 */     int idx = xRoleWordInfo.getCuridx();
/* 243 */     res.nextquestionid = -1;
/* 244 */     if (idx < xRoleWordInfo.getQuestionidlist().size())
/*     */     {
/* 246 */       res.nextquestionid = ((Integer)xRoleWordInfo.getQuestionidlist().get(idx)).intValue();
/* 247 */       SWordQuestionLevelCfg cfg = SWordQuestionLevelCfg.get(xWordInfo.getLevelcfgid());
/* 248 */       WordQuestionItemSession session = new WordQuestionItemSession(cfg.everyQuestionIntervalSec, roleId, xRoleWordInfo.getCuridx());
/*     */       
/* 250 */       xRoleWordInfo.setSessionid(session.getSessionId());
/*     */     }
/* 252 */     if (res.nextquestionid >= 0)
/*     */     {
/* 254 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.nextquestionid);
/* 255 */       if (cfg != null)
/*     */       {
/* 257 */         long sessionid = QuestionSessionInterface.createQuestionSession(roleId, QuestionTypeEnum.WORD, res.nextquestionid, 0, cfg.answer_num, 1);
/*     */         
/* 259 */         res.sessionid = sessionid;
/* 260 */         res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */       }
/*     */     }
/* 263 */     OnlineManager.getInstance().send(roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void doRight(long roleId) {}
/*     */   
/*     */ 
/*     */ 
/*     */   void doWrong(long roleId) {}
/*     */   
/*     */ 
/*     */ 
/*     */   void detectedIsEnd(long wordId, WordQuestionInfo xWordInfo)
/*     */   {
/* 278 */     for (Map.Entry<Long, RoleWordQuestionInfo> entry : xWordInfo.getRolequestionmap().entrySet())
/*     */     {
/* 280 */       RoleWordQuestionInfo xRoleInfo = (RoleWordQuestionInfo)entry.getValue();
/* 281 */       if (xRoleInfo.getQuestionidlist().size() > xRoleInfo.getCuridx())
/*     */       {
/* 283 */         return;
/*     */       }
/*     */     }
/* 286 */     allEnd(wordId, xWordInfo);
/*     */   }
/*     */   
/*     */   void allEnd(long wordId, WordQuestionInfo xWordInfo)
/*     */   {
/* 291 */     List<Long> allRoleList = new ArrayList();
/* 292 */     SWordQuestionLevelCfg cfg = SWordQuestionLevelCfg.get(xWordInfo.getLevelcfgid());
/* 293 */     allRoleList.addAll(xWordInfo.getRolequestionmap().keySet());
/* 294 */     int totalRightNum = 0;
/* 295 */     boolean isSingleAllPass = true;
/* 296 */     Map<Long, Integer> rightMap = new HashMap();
/* 297 */     for (Map.Entry<Long, RoleWordQuestionInfo> entry : xWordInfo.getRolequestionmap().entrySet())
/*     */     {
/* 299 */       totalRightNum += ((RoleWordQuestionInfo)entry.getValue()).getRightnum();
/* 300 */       rightMap.put(entry.getKey(), Integer.valueOf(((RoleWordQuestionInfo)entry.getValue()).getRightnum()));
/* 301 */       if ((cfg.oneRoleRightProp != 0) && (((RoleWordQuestionInfo)entry.getValue()).getRightnum() * 10000 / cfg.everyoneQuestionNum < cfg.oneRoleRightProp))
/*     */       {
/*     */ 
/* 304 */         isSingleAllPass = false;
/*     */       }
/*     */     }
/* 307 */     if (cfg.allRoleRightProp > 0)
/*     */     {
/* 309 */       if (totalRightNum * 10000 / (allRoleList.size() * cfg.everyoneQuestionNum) < cfg.allRoleRightProp)
/*     */       {
/* 311 */         isSingleAllPass = false;
/*     */       }
/*     */     }
/* 314 */     WordQuestionArg arg = new WordQuestionArg();
/* 315 */     arg.roleList.addAll(allRoleList);
/* 316 */     arg.isPass = isSingleAllPass;
/* 317 */     arg.rightNumMap = rightMap;
/* 318 */     arg.questionNum = cfg.everyoneQuestionNum;
/* 319 */     arg.attachObject = xWordInfo.getAttachobject();
/* 320 */     TriggerEventsManger.getInstance().triggerEvent(new FinishWordQuestion(), arg);
/* 321 */     NoneRealTimeTaskManager.getInstance().addTask(new RoleWordQuestionEndPro(wordId, allRoleList));
/*     */   }
/*     */   
/*     */   private static class RoleWordQuestionEndPro extends LogicProcedure
/*     */   {
/*     */     private final long wordId;
/* 327 */     private List<Long> allRoleList = null;
/*     */     
/*     */     public RoleWordQuestionEndPro(long wordId, List<Long> allRoleList)
/*     */     {
/* 331 */       this.wordId = wordId;
/* 332 */       this.allRoleList = allRoleList;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 338 */       lock(Role2wordquestion.getTable(), this.allRoleList);
/* 339 */       for (Iterator i$ = this.allRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 341 */         Role2wordquestion.remove(Long.valueOf(roleId));
/*     */       }
/* 343 */       Wordquestion.remove(Long.valueOf(this.wordId));
/* 344 */       OnlineManager.getInstance().sendMulti(new SSyncAllWordQuestionOver(), this.allRoleList);
/* 345 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\WordQuestionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */