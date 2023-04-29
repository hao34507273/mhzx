/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolMainTable;
/*     */ import mzm.gsp.awardpool.confbean.SControllerPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SExpPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SMoneyPoolSub;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.question.RewardItem;
/*     */ import mzm.gsp.question.SSyncExtraReward;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionConst;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionItemCfg;
/*     */ import mzm.gsp.question.session.CheckAnswerResultEnum;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EveryDayQuestionManager
/*     */ {
/*  48 */   static int WAN = 10000;
/*  49 */   private static EveryDayQuestionManager instance = new EveryDayQuestionManager();
/*  50 */   Logger logger = null;
/*     */   
/*     */   private EveryDayQuestionManager()
/*     */   {
/*  54 */     this.logger = Logger.getLogger("everydayquestion");
/*     */   }
/*     */   
/*     */ 
/*     */   public static EveryDayQuestionManager getInstance()
/*     */   {
/*  60 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public void init()
/*     */   {
/*  66 */     SEveryDayQuestionConst everyDayQuestionConst = getEveryDayQuestionConst();
/*     */     try
/*     */     {
/*  69 */       ActivityInterface.registerActivityByLogicType(9, new EveryDayQuestionActivityInit());
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  74 */       throw new RuntimeException(e);
/*     */     }
/*  76 */     ActivityCompensateInterface.registerCompensateHandler(9, new EveryDayQuestionActivityCompensateHandler());
/*     */     
/*  78 */     ItemAccessManager.registerActivityReward(everyDayQuestionConst.activityId, everyDayQuestionConst.singleReward);
/*  79 */     ItemAccessManager.registerActivityReward(everyDayQuestionConst.activityId, everyDayQuestionConst.doubleReward);
/*  80 */     ItemAccessManager.registerActivityReward(everyDayQuestionConst.activityId, everyDayQuestionConst.tribleReward);
/*     */   }
/*     */   
/*     */   private SEveryDayQuestionConst getEveryDayQuestionConst()
/*     */   {
/*  85 */     SEveryDayQuestionConst everyDayQuestionConst = (SEveryDayQuestionConst)SEveryDayQuestionConst.getAll().values().iterator().next();
/*  86 */     return everyDayQuestionConst;
/*     */   }
/*     */   
/*     */   public int getUseHelpLimit()
/*     */   {
/*  91 */     return getEveryDayQuestionConst().callHelpLimit;
/*     */   }
/*     */   
/*     */   public boolean isRightRateCanGetExtraReward(int rightNum)
/*     */   {
/*  96 */     return rightNum > getEveryDayQuestionConst().extraRewardNeedAnswerNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isActivityStart()
/*     */   {
/* 106 */     return ActivityInterface.isActivityOpen(getEveryDayQuestionConst().activityId);
/*     */   }
/*     */   
/*     */   public int getActivityId()
/*     */   {
/* 111 */     return getEveryDayQuestionConst().activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> randomQuestion()
/*     */   {
/* 117 */     List<Integer> list = new ArrayList(getEveryDayQuestionConst().answerNumLimit);
/*     */     
/* 119 */     List<Integer> questionIdlist = new ArrayList(SEveryDayQuestionItemCfg.getAll().keySet());
/* 120 */     Collections.shuffle(questionIdlist);
/* 121 */     for (Iterator i$ = questionIdlist.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/* 123 */       list.add(Integer.valueOf(id));
/* 124 */       if (list.size() == getEveryDayQuestionConst().answerNumLimit) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 131 */     return list;
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
/*     */   @Deprecated
/*     */   public boolean checkAnswer(int questionid, int answerIdx, int pageIdx)
/*     */   {
/* 150 */     SEveryDayQuestionItemCfg questionItemCfg = SEveryDayQuestionItemCfg.get(questionid);
/* 151 */     if (answerIdx - pageIdx * SEveryDayQuestionConsts.getInstance().ANSWER_SIZE != 0)
/*     */     {
/* 153 */       return false;
/*     */     }
/* 155 */     return questionItemCfg.answerList.size() > answerIdx;
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
/*     */   public CheckAnswerResultEnum checkAnswer(long sessionid, long roleid, int questionid, int pageIndex, int answerIndex)
/*     */   {
/* 177 */     return QuestionSessionInterface.checkAnswer(sessionid, roleid, QuestionTypeEnum.ZHUXIANQIYUAN, questionid, pageIndex, answerIndex);
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
/*     */   public boolean isAllAnswered(int questionId, int pageIdx)
/*     */   {
/* 190 */     SEveryDayQuestionItemCfg questionItemCfg = SEveryDayQuestionItemCfg.get(questionId);
/* 191 */     if (questionItemCfg.answerList.size() / SEveryDayQuestionConsts.getInstance().ANSWER_SIZE == pageIdx + 1)
/*     */     {
/* 193 */       return true;
/*     */     }
/* 195 */     return false;
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
/*     */   public AwardModel awardRightAnswer(String userid, long roleId, int answerSize)
/*     */   {
/* 208 */     AwardModel model = null;
/* 209 */     switch (answerSize)
/*     */     {
/*     */     case 1: 
/* 212 */       model = AwardInterface.getRoleAwardModel(getEveryDayQuestionConst().singleReward, roleId, 0, new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD, getEveryDayQuestionConst().singleReward));
/*     */       
/* 214 */       break;
/*     */     case 2: 
/* 216 */       model = AwardInterface.getRoleAwardModel(getEveryDayQuestionConst().doubleReward, roleId, 0, new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD, getEveryDayQuestionConst().doubleReward));
/*     */       
/* 218 */       break;
/*     */     case 3: 
/* 220 */       model = AwardInterface.getRoleAwardModel(getEveryDayQuestionConst().tribleReward, roleId, 0, new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD, getEveryDayQuestionConst().tribleReward));
/*     */       
/* 222 */       break;
/*     */     default: 
/* 224 */       String logstr = String.format("[everydayquestion]EveryDayQuestionManager.awardRightAnswer@award right answer error|userid=%s|roleid=%d|answersize=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(answerSize) });
/*     */       
/*     */ 
/* 227 */       this.logger.error(logstr);
/* 228 */       return model;
/*     */     }
/*     */     
/* 231 */     StorageExpInterface.award(userid, roleId, model, new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD));
/* 232 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AwardModel awardWrongAnswer(String userId, long roleId)
/*     */   {
/* 243 */     AwardModel model = AwardInterface.getRoleAwardModel(getEveryDayQuestionConst().wrongReward, roleId, 0, new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD, getEveryDayQuestionConst().wrongReward));
/*     */     
/* 245 */     StorageExpInterface.award(userId, roleId, model, new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD));
/* 246 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int awardExtraReward(String userid, long roleId)
/*     */   {
/* 258 */     if (getEveryDayQuestionConst().extraRewardPoolId == 0)
/*     */     {
/* 260 */       return 0;
/*     */     }
/* 262 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 263 */     SAwardPoolMainTable poolId = AwardPoolInterface.getAwardPoolSumIdByLevel(getEveryDayQuestionConst().extraRewardPoolId, rolelevel);
/*     */     
/* 265 */     if (poolId == null)
/*     */     {
/* 267 */       String logstr = String.format("[everydayquestion]EveryDayQuestionManager.awardExtraReward@SAwardPoolMainTable null|userid=%s|roleid=%d|rolelevel=%d|extraRewardPoolId=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(getEveryDayQuestionConst().extraRewardPoolId) });
/*     */       
/*     */ 
/* 270 */       this.logger.error(logstr);
/* 271 */       return 0;
/*     */     }
/* 273 */     AwardPoolResultData resultData = AwardPoolInterface.randomAwardPoolForRole(roleId, poolId.buffEffectIds, poolId.awardPoolSumId);
/*     */     
/* 275 */     if (resultData == null)
/*     */     {
/* 277 */       String logstr = String.format("[everydayquestion]EveryDayQuestionManager.awardExtraReward@AwardPoolResultData null|userid=%s|roleid=%d|rolelevel=%d|extraRewardPoolId=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(getEveryDayQuestionConst().extraRewardPoolId) });
/*     */       
/*     */ 
/* 280 */       this.logger.error(logstr);
/* 281 */       return 0;
/*     */     }
/* 283 */     List<Integer> awardIdList = resultData.getPrepareSubPoolIds();
/* 284 */     List<Integer> resultList = resultData.getFinalSubPoolIds();
/* 285 */     if ((resultList.size() > 1) || (resultList.isEmpty()))
/*     */     {
/* 287 */       String logstr = String.format("[everydayquestion]EveryDayQuestionManager.awardExtraReward@award extra reward error|userid=%s|roleid=%d|rolelevel=%d|poolId=%d|resultsize=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(poolId.awardPoolSumId), Integer.valueOf(resultList.size()) });
/*     */       
/*     */ 
/* 290 */       this.logger.error(logstr);
/* 291 */       return 0;
/*     */     }
/*     */     
/* 294 */     SSyncExtraReward syncExtraReward = new SSyncExtraReward();
/*     */     
/* 296 */     AwardPoolInterface.doAward(userid, roleId, resultData, new TLogArg(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD));
/*     */     
/* 298 */     RewardItem rewardItem = new RewardItem();
/* 299 */     fillFinalResult(resultData, rewardItem);
/* 300 */     syncExtraReward.awardlist.add(rewardItem);
/* 301 */     awardIdList.remove(resultList.get(0));
/* 302 */     fillPrepareResult(awardIdList, syncExtraReward.awardlist);
/*     */     
/* 304 */     OnlineManager.getInstance().sendAtOnce(roleId, syncExtraReward);
/* 305 */     return ((Integer)resultList.get(0)).intValue();
/*     */   }
/*     */   
/*     */   private boolean fillFinalResult(AwardPoolResultData resultData, RewardItem reward)
/*     */   {
/* 310 */     if (resultData.getControllerId() > 0)
/*     */     {
/* 312 */       reward.rewardtype = 7;
/* 313 */       reward.parammap.put(Integer.valueOf(4), Integer.valueOf(resultData.getControllerId()));
/*     */     }
/* 315 */     else if (resultData.getRoleExp() > 0)
/*     */     {
/* 317 */       reward.rewardtype = 1;
/* 318 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getRoleExp()));
/*     */     }
/* 320 */     else if (resultData.getPetExp() > 0)
/*     */     {
/* 322 */       reward.rewardtype = 2;
/* 323 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getPetExp()));
/*     */     }
/* 325 */     else if (resultData.getXiuLianExp() > 0)
/*     */     {
/* 327 */       reward.rewardtype = 3;
/* 328 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getXiuLianExp()));
/*     */     }
/* 330 */     else if (resultData.getSilver() > 0)
/*     */     {
/* 332 */       reward.rewardtype = 4;
/* 333 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getSilver()));
/*     */     }
/* 335 */     else if (resultData.getGold() > 0)
/*     */     {
/* 337 */       reward.rewardtype = 5;
/* 338 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGold()));
/*     */     }
/* 340 */     else if (resultData.getGang() > 0)
/*     */     {
/* 342 */       reward.rewardtype = 6;
/* 343 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGang()));
/*     */     }
/* 345 */     else if (!resultData.getItemMap().isEmpty())
/*     */     {
/* 347 */       reward.rewardtype = 0;
/* 348 */       for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet())
/*     */       {
/* 350 */         reward.parammap.put(Integer.valueOf(0), entry.getKey());
/* 351 */         reward.parammap.put(Integer.valueOf(1), entry.getValue());
/*     */       }
/*     */     }
/* 354 */     return true;
/*     */   }
/*     */   
/*     */   private void fillPrepareResult(List<Integer> prepareAwardList, List<RewardItem> rewardItems)
/*     */   {
/* 359 */     for (Iterator i$ = prepareAwardList.iterator(); i$.hasNext();) { int awardSubId = ((Integer)i$.next()).intValue();
/*     */       
/* 361 */       RewardItem ri = new RewardItem();
/* 362 */       if (AwardPoolInterface.isSItemPoolSub(awardSubId))
/*     */       {
/* 364 */         SItemPoolSub sItemPoolSub = SItemPoolSub.get(awardSubId);
/* 365 */         ri.rewardtype = 0;
/* 366 */         ri.parammap.put(Integer.valueOf(0), Integer.valueOf(sItemPoolSub.itemId));
/* 367 */         ri.parammap.put(Integer.valueOf(1), Integer.valueOf(sItemPoolSub.itemNum));
/*     */       }
/* 369 */       else if (AwardPoolInterface.isSControllerPoolSub(awardSubId))
/*     */       {
/* 371 */         SControllerPoolSub controllerPoolSub = SControllerPoolSub.get(awardSubId);
/* 372 */         ri.rewardtype = 7;
/* 373 */         ri.parammap.put(Integer.valueOf(4), Integer.valueOf(controllerPoolSub.controllerId));
/*     */       }
/* 375 */       else if (AwardPoolInterface.isSExpPoolSub(awardSubId))
/*     */       {
/* 377 */         SExpPoolSub expPoolSub = SExpPoolSub.get(awardSubId);
/* 378 */         switch (expPoolSub.expType)
/*     */         {
/*     */         case 2: 
/* 381 */           ri.rewardtype = 2;
/* 382 */           break;
/*     */         case 1: 
/* 384 */           ri.rewardtype = 1;
/* 385 */           break;
/*     */         case 3: 
/* 387 */           ri.rewardtype = 3;
/*     */         }
/*     */         
/* 390 */         int expNum = CommonUtils.random(expPoolSub.minExpNum, expPoolSub.maxExpNum);
/* 391 */         ri.parammap.put(Integer.valueOf(2), Integer.valueOf(expNum));
/*     */       }
/* 393 */       else if (AwardPoolInterface.isSMoneyPoolSub(awardSubId))
/*     */       {
/* 395 */         SMoneyPoolSub sMoneyPoolSub = SMoneyPoolSub.get(awardSubId);
/* 396 */         switch (sMoneyPoolSub.moneyType)
/*     */         {
/*     */         case 2: 
/* 399 */           ri.rewardtype = 5;
/* 400 */           break;
/*     */         case 3: 
/* 402 */           ri.rewardtype = 4;
/* 403 */           break;
/*     */         case 4: 
/* 405 */           ri.rewardtype = 6;
/* 406 */           break;
/*     */         case 1: 
/* 408 */           ri.rewardtype = 8;
/*     */         }
/*     */         
/*     */         
/* 412 */         int rewardMoney = CommonUtils.random(sMoneyPoolSub.minMoneyNum, sMoneyPoolSub.maxMoneyNum);
/* 413 */         ri.parammap.put(Integer.valueOf(3), Integer.valueOf(rewardMoney));
/*     */       }
/* 415 */       else if (AwardPoolInterface.isSReplaceMoneyTypeSub(awardSubId))
/*     */       {
/* 417 */         String logstr = String.format("[everydayquestion]EveryDayQuestionManager.fillPrepareResult@everyday question no support replace money", new Object[0]);
/* 418 */         this.logger.error(logstr);
/*     */       }
/* 420 */       rewardItems.add(ri);
/*     */     }
/*     */   }
/*     */   
/*     */   int getWrongAwardId()
/*     */   {
/* 426 */     return getEveryDayQuestionConst().wrongReward;
/*     */   }
/*     */   
/*     */   int getQuestionSize()
/*     */   {
/* 431 */     return getEveryDayQuestionConst().answerNumLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isZhuxianQiYuanSwitchOpenForRole(long roleid)
/*     */   {
/* 442 */     if (!OpenInterface.getOpenStatus(32))
/*     */     {
/* 444 */       return false;
/*     */     }
/* 446 */     if (OpenInterface.isBanPlay(roleid, 32))
/*     */     {
/* 448 */       OpenInterface.sendBanPlayMsg(roleid, 32);
/* 449 */       return false;
/*     */     }
/* 451 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   int getRestExp(long roleid, int finishCount)
/*     */   {
/* 457 */     if (finishCount < 0)
/*     */     {
/* 459 */       return 0;
/*     */     }
/* 461 */     int daySize = getInstance().getQuestionSize();
/* 462 */     if (finishCount > daySize)
/*     */     {
/* 464 */       return 0;
/*     */     }
/* 466 */     int exp = getExpByRing(roleid, false);
/* 467 */     int addexp = exp * (daySize - finishCount);
/*     */     
/* 469 */     return addexp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getExpByRing(long roleid, boolean isRight)
/*     */   {
/* 481 */     int rewardid = getEveryDayQuestionConst().wrongReward;
/* 482 */     if (isRight)
/*     */     {
/* 484 */       rewardid = getEveryDayQuestionConst().singleReward;
/*     */     }
/*     */     else
/*     */     {
/* 488 */       rewardid = getEveryDayQuestionConst().wrongReward;
/*     */     }
/* 490 */     AwardReason reason = new AwardReason(LogReason.EVERY_DAY_QUESTION_STORAGE_ADD, rewardid);
/* 491 */     reason.setJustQuery(true);
/* 492 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(rewardid, roleid, -1, reason);
/* 493 */     if (awardModel == null)
/*     */     {
/* 495 */       return 0;
/*     */     }
/* 497 */     return awardModel.getRoleExp();
/*     */   }
/*     */   
/*     */   float getRate()
/*     */   {
/* 502 */     return SEveryDayQuestionConsts.getInstance().RETURN_BACK_EXP_CHANGE_RATE / WAN;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\EveryDayQuestionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */