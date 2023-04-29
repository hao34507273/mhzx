/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionMappingCfg;
/*     */ import mzm.gsp.memorycompetition.QuestionInfo;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionNormalFail;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionQuestionStart;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionRoundCal;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionStart;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionIntervalObserverArg;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionPrepareEvent;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionQuestionEventArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xbean.MemoryQuestion;
/*     */ import xbean.Pod;
/*     */ import xbean.RolesMemoryQuestion;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class MemoryCompetitionManager
/*     */ {
/*     */   public static boolean isRomanticDanceFunOpen(long roleid)
/*     */   {
/*  39 */     if (!OpenInterface.getOpenStatus(231))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (OpenInterface.isBanPlay(roleid, 231))
/*     */     {
/*  45 */       OpenInterface.sendBanPlayMsg(roleid, 231);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isMemoryCompetitionFunOpen(long roleid)
/*     */   {
/*  54 */     if (!OpenInterface.getOpenStatus(230))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (OpenInterface.isBanPlay(roleid, 230))
/*     */     {
/*  61 */       OpenInterface.sendBanPlayMsg(roleid, 230);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean startMemoryCompetitinGame(int activityCfgId, List<Long> roleIdList, int memoryCompetitionCfgId, int aleardyAnswerCount, boolean isNeedNotifyAfterEveryQuesion)
/*     */   {
/*  88 */     SMemoryCompetitionCfg sMemoryCompetitionCfg = SMemoryCompetitionCfg.get(memoryCompetitionCfgId);
/*  89 */     if (sMemoryCompetitionCfg == null)
/*     */     {
/*  91 */       GameServer.logger().error(String.format("[memorycompetition]MemoryCompetitionManager.startMemoryCompetitinGame@memory competition cfg not exist|role_id_list=%s|memory_competition_cfg_id=%d", new Object[] { roleIdList.toString(), Integer.valueOf(memoryCompetitionCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  95 */       notifyMemoryCompetitionFail(roleIdList, 11);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     int mappingTypeId = sMemoryCompetitionCfg.mapping_type_id;
/* 100 */     MemoryCompetitionInfo xMemoryCompetitionInfo = Pod.newMemoryCompetitionInfo();
/* 101 */     xMemoryCompetitionInfo.setMemory_competition_cfg_id(memoryCompetitionCfgId);
/* 102 */     xMemoryCompetitionInfo.setActivity_cfg_id(activityCfgId);
/* 103 */     xMemoryCompetitionInfo.getRole_id_list().addAll(roleIdList);
/* 104 */     xMemoryCompetitionInfo.setIs_need_notify_after_every_question(isNeedNotifyAfterEveryQuesion);
/* 105 */     SMemoryCompetitionMappingCfg sMemoryCompetitionMappingCfg = SMemoryCompetitionMappingCfg.get(mappingTypeId);
/* 106 */     if (sMemoryCompetitionMappingCfg == null)
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[memorycompetition]MemoryCompetitionManager.startMemoryCompetitinGame@mapping type cfg not exist|role_id_list=%s|memory_competition_cfg_id=%d", new Object[] { roleIdList.toString(), Integer.valueOf(memoryCompetitionCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 113 */       notifyMemoryCompetitionFail(roleIdList, 15);
/*     */       
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     boolean randomResult = getRandomQuestionMapping(sMemoryCompetitionCfg.mapping_num, sMemoryCompetitionMappingCfg.mapping_value_list, xMemoryCompetitionInfo.getMapping());
/*     */     
/* 120 */     if (!randomResult)
/*     */     {
/* 122 */       GameServer.logger().error(String.format("[memorycompetition]MemoryCompetitionManager.startMemoryCompetitinGame@random question fail|role_id_list=%s|memory_competition_cfg_id=%d", new Object[] { roleIdList.toString(), Integer.valueOf(memoryCompetitionCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 127 */       notifyMemoryCompetitionFail(roleIdList, 16);
/*     */       
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     long memoryCompetitionId = xtable.Memorycompetition.insert(xMemoryCompetitionInfo).longValue();
/* 133 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 135 */       xtable.Role2memorycompetition.add(Long.valueOf(roleId), Long.valueOf(memoryCompetitionId));
/*     */     }
/*     */     
/* 138 */     SMemoryCompetitionStart sMemoryCompetitionStart = new SMemoryCompetitionStart();
/* 139 */     sMemoryCompetitionStart.activity_cfg_id = activityCfgId;
/* 140 */     sMemoryCompetitionStart.memory_competition_cfg_id = memoryCompetitionCfgId;
/* 141 */     sMemoryCompetitionStart.left_seconds = sMemoryCompetitionCfg.mapping_answer_show_seconds;
/*     */     
/*     */ 
/* 144 */     Map<Integer, Integer> competitionStarMap = sMemoryCompetitionStart.mapping_date;
/* 145 */     for (Map.Entry<Integer, Integer> entry : xMemoryCompetitionInfo.getMapping().entrySet())
/*     */     {
/* 147 */       if ((!competitionStarMap.containsKey(entry.getKey())) && (!competitionStarMap.containsValue(entry.getKey())))
/*     */       {
/*     */ 
/*     */ 
/* 151 */         competitionStarMap.put(entry.getKey(), entry.getValue());
/*     */       }
/*     */     }
/* 154 */     OnlineManager.getInstance().sendMulti(sMemoryCompetitionStart, roleIdList);
/*     */     
/*     */ 
/* 157 */     MemoryCompetitionPrepareEvent competitionPrepareEvent = new MemoryCompetitionPrepareEvent();
/*     */     
/* 159 */     mzm.gsp.memorycompetition.event.MemoryCompetitionPrepareEventArg competitionPrepareEventArg = new mzm.gsp.memorycompetition.event.MemoryCompetitionPrepareEventArg(sMemoryCompetitionCfg.mapping_answer_show_seconds, DateTimeUtils.getCurrTimeInMillis(), memoryCompetitionId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 164 */     TriggerEventsManger.getInstance().triggerEvent(competitionPrepareEvent, competitionPrepareEventArg);
/*     */     
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   private static void notifyMemoryCompetitionFail(List<Long> roleIdList, int ret)
/*     */   {
/* 171 */     SMemoryCompetitionNormalFail sMemoryCompetitionNormalFail = new SMemoryCompetitionNormalFail();
/* 172 */     sMemoryCompetitionNormalFail.result = ret;
/* 173 */     OnlineManager.getInstance().sendMultiAtOnce(sMemoryCompetitionNormalFail, roleIdList);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean getRandomQuestionMapping(int mappingNum, List<Integer> optionList, Map<Integer, Integer> mappingMap)
/*     */   {
/* 191 */     if (optionList.size() < mappingNum * 2)
/*     */     {
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     List<Integer> copyOptionList = new ArrayList(optionList);
/*     */     
/* 198 */     for (int index = 0; index < mappingNum; index++)
/*     */     {
/* 200 */       int size = copyOptionList.size();
/*     */       
/* 202 */       int randomKey = Xdb.random().nextInt(size);
/* 203 */       Integer mappingKey = (Integer)copyOptionList.get(randomKey);
/* 204 */       copyOptionList.remove(randomKey);
/*     */       
/*     */ 
/* 207 */       int randomValue = Xdb.random().nextInt(size - 1);
/* 208 */       Integer mappingValue = (Integer)copyOptionList.get(randomValue);
/* 209 */       copyOptionList.remove(randomValue);
/*     */       
/* 211 */       mappingMap.put(mappingKey, mappingValue);
/* 212 */       mappingMap.put(mappingValue, mappingKey);
/*     */     }
/*     */     
/* 215 */     return true;
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
/*     */ 
/*     */ 
/*     */   static void startQuestion(long memoryCompetitionId, MemoryCompetitionInfo xMemoryCompetitionInfo, SMemoryCompetitionCfg competitionCfg)
/*     */   {
/* 232 */     xMemoryCompetitionInfo.setCurrent_round_num(xMemoryCompetitionInfo.getCurrent_round_num() + 1);
/*     */     
/* 234 */     Map<Integer, Integer> xMemoryCompetitionMaping = xMemoryCompetitionInfo.getMapping();
/*     */     
/* 236 */     List<Integer> questionKeyList = new ArrayList(xMemoryCompetitionMaping.keySet());
/*     */     
/* 238 */     int questionTotalSize = questionKeyList.size();
/*     */     
/*     */ 
/* 241 */     HashMap<Long, QuestionInfo> rolesQuestionMap = new HashMap();
/*     */     
/* 243 */     Map<Long, MemoryCompetitionQuestionObserver.QuestionAnswerState> role2AnswerStateMap = new HashMap();
/*     */     
/* 245 */     for (Iterator i$ = xMemoryCompetitionInfo.getRole_id_list().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 247 */       int random = Xdb.random().nextInt(questionTotalSize);
/*     */       
/* 249 */       QuestionInfo questionInfo = new QuestionInfo();
/* 250 */       questionInfo.question_id = ((Integer)questionKeyList.get(random)).intValue();
/*     */       
/* 252 */       Integer answer = (Integer)xMemoryCompetitionMaping.get(Integer.valueOf(questionInfo.question_id));
/* 253 */       questionInfo.option_list.add(answer);
/*     */       
/* 255 */       List<Integer> randomList = new ArrayList(questionKeyList);
/* 256 */       randomList.remove(answer);
/*     */       
/* 258 */       List<Integer> optionList = randomList(randomList, competitionCfg.question_option_num - 1);
/*     */       
/* 260 */       if (optionList != null)
/*     */       {
/*     */ 
/*     */ 
/* 264 */         questionInfo.option_list.addAll(optionList);
/* 265 */         Collections.shuffle(questionInfo.option_list);
/*     */         
/* 267 */         rolesQuestionMap.put(Long.valueOf(roleId), questionInfo);
/*     */         
/* 269 */         role2AnswerStateMap.put(Long.valueOf(roleId), new MemoryCompetitionQuestionObserver.QuestionAnswerState(questionInfo.question_id, questionInfo.option_list, MemoryCompetitionQuestionObserver.NOT_ANSWER));
/*     */       }
/*     */     }
/*     */     
/* 273 */     HashMap<Long, Integer> rolesRightNumMap = new HashMap();
/* 274 */     for (Iterator i$ = xMemoryCompetitionInfo.getRole_id_list().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 276 */       RolesMemoryQuestion xRolesMemoryQuestion = (RolesMemoryQuestion)xMemoryCompetitionInfo.getRoles_answered_question_map().get(Long.valueOf(roleId));
/*     */       
/* 278 */       int rightNum = 0;
/*     */       
/* 280 */       if (xRolesMemoryQuestion != null)
/*     */       {
/* 282 */         for (MemoryQuestion xMemoryQuestion : xRolesMemoryQuestion.getQuestion_list())
/*     */         {
/* 284 */           if (xMemoryQuestion.getAnswer_result())
/*     */           {
/* 286 */             rightNum++;
/*     */           }
/*     */         }
/*     */       }
/* 290 */       rolesRightNumMap.put(Long.valueOf(roleId), Integer.valueOf(rightNum));
/*     */     }
/*     */     
/* 293 */     for (Iterator i$ = xMemoryCompetitionInfo.getRole_id_list().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 295 */       SMemoryCompetitionQuestionStart questionStart = new SMemoryCompetitionQuestionStart();
/* 296 */       questionStart.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/* 297 */       questionStart.left_seconds = competitionCfg.question_answer_seconds;
/*     */       
/* 299 */       Integer hasUseSeekHelpTimes = (Integer)xMemoryCompetitionInfo.getRoles_seek_help_times_map().get(Long.valueOf(roleId));
/* 300 */       if (hasUseSeekHelpTimes == null)
/*     */       {
/* 302 */         questionStart.left_seek_help_times = competitionCfg.seek_help_times;
/*     */       }
/*     */       else
/*     */       {
/* 306 */         questionStart.left_seek_help_times = (competitionCfg.seek_help_times - hasUseSeekHelpTimes.intValue());
/*     */       }
/*     */       
/* 309 */       questionStart.memory_competition_cfg_id = xMemoryCompetitionInfo.getMemory_competition_cfg_id();
/* 310 */       questionStart.score = xMemoryCompetitionInfo.getCurrent_score();
/* 311 */       questionStart.now_round_num = xMemoryCompetitionInfo.getCurrent_round_num();
/* 312 */       questionStart.total_round_num = competitionCfg.question_num;
/* 313 */       questionStart.roles_question_map = rolesQuestionMap;
/* 314 */       questionStart.roles_right_num_map = rolesRightNumMap;
/* 315 */       OnlineManager.getInstance().send(roleId, questionStart);
/*     */     }
/*     */     
/*     */ 
/* 319 */     MemoryCompetitionQuestionEventArg questionEventArg = new MemoryCompetitionQuestionEventArg(competitionCfg.question_answer_seconds, memoryCompetitionId, DateTimeUtils.getCurrTimeInMillis(), role2AnswerStateMap);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 325 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.memorycompetition.event.MemoryCompetitionQuestionEvent(), questionEventArg);
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
/*     */   private static List<Integer> randomList(List<Integer> sourceList, int count)
/*     */   {
/* 340 */     int size = sourceList.size();
/* 341 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 343 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 346 */     if (size == count)
/*     */     {
/* 348 */       return new ArrayList(sourceList);
/*     */     }
/*     */     
/* 351 */     Random random = Xdb.random();
/* 352 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 354 */       Collections.swap(sourceList, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 357 */     return new ArrayList(sourceList.subList(size - count, size));
/*     */   }
/*     */   
/*     */ 
/*     */   static void onQuestionEnd(MemoryCompetitionInfo xMemoryCompetitionInfo, MemoryCompetitionQuestionObserver questionObserver, SMemoryCompetitionCfg competitionCfg)
/*     */   {
/* 363 */     Map<Long, RolesMemoryQuestion> xRolesMemoryQuestionMap = xMemoryCompetitionInfo.getRoles_answered_question_map();
/*     */     
/* 365 */     Map<Integer, Integer> mapping = xMemoryCompetitionInfo.getMapping();
/*     */     
/* 367 */     SMemoryCompetitionRoundCal roundCal = new SMemoryCompetitionRoundCal();
/*     */     
/* 369 */     roundCal.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/* 370 */     for (Map.Entry<Long, MemoryCompetitionQuestionObserver.QuestionAnswerState> entry : questionObserver.getRole2AnswerStateMap().entrySet())
/*     */     {
/* 372 */       long roleId = ((Long)entry.getKey()).longValue();
/* 373 */       MemoryCompetitionQuestionObserver.QuestionAnswerState questionAnswerState = (MemoryCompetitionQuestionObserver.QuestionAnswerState)entry.getValue();
/*     */       
/* 375 */       RolesMemoryQuestion xRolesMemoryQuestion = (RolesMemoryQuestion)xRolesMemoryQuestionMap.get(Long.valueOf(roleId));
/* 376 */       if (xRolesMemoryQuestion == null)
/*     */       {
/* 378 */         xRolesMemoryQuestion = Pod.newRolesMemoryQuestion();
/* 379 */         xRolesMemoryQuestionMap.put(Long.valueOf(roleId), xRolesMemoryQuestion);
/*     */       }
/*     */       
/* 382 */       MemoryQuestion xMemoryQuestion = Pod.newMemoryQuestion();
/*     */       
/* 384 */       Integer answer = (Integer)mapping.get(Integer.valueOf(questionAnswerState.getQuestionId()));
/* 385 */       boolean answerResult = (answer != null) && (answer.intValue() == questionAnswerState.getAnswerId());
/* 386 */       if (!answerResult)
/*     */       {
/* 388 */         roundCal.answer_result_map.put(Long.valueOf(roleId), Integer.valueOf(0));
/* 389 */         xMemoryCompetitionInfo.setCurrent_score(xMemoryCompetitionInfo.getCurrent_score() + competitionCfg.wrong_answer_score);
/*     */         
/* 391 */         xMemoryQuestion.setAnswer_result(false);
/*     */       }
/*     */       else
/*     */       {
/* 395 */         roundCal.answer_result_map.put(Long.valueOf(roleId), Integer.valueOf(1));
/* 396 */         xMemoryCompetitionInfo.setCurrent_score(xMemoryCompetitionInfo.getCurrent_score() + competitionCfg.right_answer_score);
/*     */         
/* 398 */         xMemoryQuestion.setAnswer_result(true);
/*     */       }
/*     */       
/* 401 */       if (questionAnswerState.getAnswerTime() == MemoryCompetitionQuestionObserver.NOT_ANSWER)
/*     */       {
/* 403 */         xMemoryQuestion.setAnswer_time(DateTimeUtils.getCurrTimeInMillis() - questionObserver.getBeginTime());
/* 404 */         SMemoryCompetitionNormalFail sMemoryCompetitionNormalFail = new SMemoryCompetitionNormalFail();
/* 405 */         sMemoryCompetitionNormalFail.result = 14;
/*     */         
/* 407 */         OnlineManager.getInstance().send(roleId, sMemoryCompetitionNormalFail);
/*     */       }
/*     */       else
/*     */       {
/* 411 */         xMemoryQuestion.setAnswer_time(questionAnswerState.getAnswerTime() - questionObserver.getBeginTime());
/*     */       }
/* 413 */       xMemoryQuestion.setQuestion_id(questionAnswerState.getQuestionId());
/* 414 */       xMemoryQuestion.setAnswer_id(questionAnswerState.getAnswerId());
/*     */       
/* 416 */       xRolesMemoryQuestion.getQuestion_list().add(xMemoryQuestion);
/*     */     }
/*     */     
/* 419 */     xMemoryCompetitionInfo.setRoles_current_question_observer(null);
/* 420 */     OnlineManager.getInstance().sendMulti(roundCal, xMemoryCompetitionInfo.getRole_id_list());
/*     */     
/*     */ 
/* 423 */     MemoryCompetitionIntervalObserverArg observerArg = new MemoryCompetitionIntervalObserverArg(competitionCfg.question_interval, questionObserver.getMemoryCompetitionId());
/*     */     
/*     */ 
/* 426 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.memorycompetition.event.MemoryCompetitionIntervalObserverEvent(), observerArg);
/*     */   }
/*     */   
/*     */   public static void tlogAttendRomantciDance(long roleId, long partnerRoleId, int hardRank)
/*     */   {
/* 431 */     String userId = RoleInterface.getUserId(roleId);
/* 432 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*     */     
/* 434 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 435 */     long partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*     */     
/* 437 */     StringBuilder sbLog = new StringBuilder();
/* 438 */     sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 439 */     sbLog.append(userId).append('|');
/* 440 */     sbLog.append(roleId).append('|');
/* 441 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 443 */     sbLog.append(partnerUserId).append('|');
/* 444 */     sbLog.append(partnerRoleId).append('|');
/* 445 */     sbLog.append(partnerRoleLevel).append('|');
/* 446 */     sbLog.append(hardRank);
/*     */     
/* 448 */     TLogManager.getInstance().addLog(roleId, "RomanticDanceJoinStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */   public static void tlogRomantciDanceScore(long roleId, long partnerRoleId, int score)
/*     */   {
/* 453 */     String userId = RoleInterface.getUserId(roleId);
/* 454 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*     */     
/* 456 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 457 */     long partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*     */     
/* 459 */     StringBuilder sbLog = new StringBuilder();
/* 460 */     sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 461 */     sbLog.append(userId).append('|');
/* 462 */     sbLog.append(roleId).append('|');
/* 463 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 465 */     sbLog.append(partnerUserId).append('|');
/* 466 */     sbLog.append(partnerRoleId).append('|');
/* 467 */     sbLog.append(partnerRoleLevel).append('|');
/* 468 */     sbLog.append(score);
/*     */     
/* 470 */     TLogManager.getInstance().addLog(roleId, "RomanticDanceScoreStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\MemoryCompetitionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */