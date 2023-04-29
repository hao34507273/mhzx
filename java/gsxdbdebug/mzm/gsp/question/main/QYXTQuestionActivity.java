/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.question.confbean.SQYXTForceAnswerQuestionIndexCfg;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionCfg;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionLvCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QYXTQuestionInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2qyxtquestion;
/*     */ 
/*     */ public class QYXTQuestionActivity implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  37 */     QYXTQuestionInfo qyxtQuestionInfo = Role2qyxtquestion.get(Long.valueOf(roleId));
/*  38 */     int countEveryDay = ActivityInterface.getActivityCfg(SQYXTQuestionConst.getInstance().ACTIVITY_ID).count;
/*  39 */     if (qyxtQuestionInfo == null)
/*     */     {
/*  41 */       qyxtQuestionInfo = xbean.Pod.newQYXTQuestionInfo();
/*  42 */       Role2qyxtquestion.insert(Long.valueOf(roleId), qyxtQuestionInfo);
/*     */     }
/*     */     else
/*     */     {
/*  46 */       int currentAnswerCount = ActivityInterface.getStoreActivityCount(userid, roleId, activityid, true);
/*  47 */       AwardReason reason = new AwardReason(LogReason.QYXT_QUESTION_AWARD);
/*  48 */       reason.setJustQuery(true);
/*  49 */       AwardModel awardModel = AwardInterface.getRoleAwardModel(SQYXTQuestionConst.getInstance().wrongAwardid, roleId, -1, reason);
/*     */       
/*  51 */       int leftCount = countEveryDay - currentAnswerCount + turn * countEveryDay;
/*  52 */       if ((awardModel != null) && (leftCount != 0))
/*     */       {
/*  54 */         int addStorageExp = leftCount * awardModel.getRoleExp() * SQYXTQuestionConst.getInstance().storageExpExchangeRate / 10000;
/*     */         
/*  56 */         StorageExpInterface.addStorageExp(roleId, addStorageExp);
/*     */       }
/*     */     }
/*     */     
/*  60 */     qyxtQuestionInfo.setRightnum(0);
/*  61 */     qyxtQuestionInfo.getQuestions().clear();
/*  62 */     qyxtQuestionInfo.getCurrent_help_roleids().clear();
/*  63 */     qyxtQuestionInfo.getSeek_help_questions().clear();
/*  64 */     List<Integer> questions = randomQyxtQuestion(roleId, qyxtQuestionInfo.getCurrent_force_answer_index(), countEveryDay);
/*     */     
/*  66 */     qyxtQuestionInfo.getQuestions().addAll(questions);
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  72 */     return new AwardReason(LogReason.QYXT_QUESTION_AWARD);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  78 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNextQuestionid(QYXTQuestionInfo xQuestionInfo, int answerNum)
/*     */   {
/* 108 */     int nextAnswerid = 0;
/* 109 */     if ((answerNum < xQuestionInfo.getQuestions().size()) && (answerNum >= 0))
/*     */     {
/* 111 */       nextAnswerid = ((Integer)xQuestionInfo.getQuestions().get(answerNum)).intValue();
/* 112 */       if (SQYXTQuestionCfg.get(nextAnswerid) == null)
/*     */       {
/* 114 */         TreeMap<Integer, SQYXTQuestionLvCfg> questionLvMap = (TreeMap)SQYXTQuestionLvCfg.getAll();
/* 115 */         List<Integer> questionCfgIdList = ((SQYXTQuestionLvCfg)questionLvMap.lastEntry().getValue()).questionCfgIdList;
/*     */         
/* 117 */         int randomIndexId = Xdb.random().nextInt(questionCfgIdList.size());
/* 118 */         nextAnswerid = ((Integer)questionCfgIdList.get(randomIndexId)).intValue();
/*     */       }
/*     */     }
/* 121 */     return nextAnswerid;
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
/*     */   private List<Integer> randomQyxtQuestion(long roleId, int currentForceIndexId, int randomQuestionNum)
/*     */   {
/* 138 */     List<Integer> idList = new ArrayList();
/* 139 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 140 */     if (currentForceIndexId < SQYXTQuestionConst.getInstance().maxForceAnswerQuestionIndex)
/*     */     {
/* 142 */       TreeMap<Integer, SQYXTForceAnswerQuestionIndexCfg> forceQuestionCfgMap = (TreeMap)SQYXTForceAnswerQuestionIndexCfg.getAll();
/* 143 */       SortedMap<Integer, SQYXTForceAnswerQuestionIndexCfg> subQuestionMap = forceQuestionCfgMap.subMap(Integer.valueOf(currentForceIndexId + 1), Integer.valueOf(SQYXTQuestionConst.getInstance().maxForceAnswerQuestionIndex + 1));
/*     */       
/*     */ 
/* 146 */       for (Map.Entry<Integer, SQYXTForceAnswerQuestionIndexCfg> entry : subQuestionMap.entrySet())
/*     */       {
/* 148 */         SQYXTForceAnswerQuestionIndexCfg questionIndexCfg = (SQYXTForceAnswerQuestionIndexCfg)entry.getValue();
/* 149 */         if (roleLevel >= questionIndexCfg.questionLv)
/*     */         {
/*     */ 
/*     */ 
/* 153 */           idList.add(Integer.valueOf(((SQYXTForceAnswerQuestionIndexCfg)entry.getValue()).cfgId));
/*     */           
/* 155 */           if (idList.size() >= randomQuestionNum) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 161 */       if (idList.size() >= randomQuestionNum)
/*     */       {
/* 163 */         return idList;
/*     */       }
/*     */     }
/*     */     
/* 167 */     TreeMap<Integer, SQYXTQuestionLvCfg> questionLvMap = (TreeMap)SQYXTQuestionLvCfg.getAll();
/* 168 */     ArrayList<Integer> questionCfgIdList = new ArrayList(((SQYXTQuestionLvCfg)questionLvMap.floorEntry(Integer.valueOf(roleLevel)).getValue()).questionCfgIdList);
/*     */     
/* 170 */     questionCfgIdList.removeAll(idList);
/*     */     
/* 172 */     CommonUtils.regionRandomByMutableArray(questionCfgIdList, randomQuestionNum - idList.size(), idList);
/*     */     
/* 174 */     return idList;
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/* 179 */     QYXTQuestionActivity qyxtQuestionActivity = new QYXTQuestionActivity();
/* 180 */     ActivityInterface.registerActivityByLogicType(29, qyxtQuestionActivity);
/* 181 */     ActivityCompensateInterface.registerCompensateHandler(29, new QYXTActivityCompensateHandler());
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
/*     */   public static int getCanGetStorageExp(long roleId, int finishCount)
/*     */   {
/* 196 */     if (finishCount < 0)
/*     */     {
/* 198 */       return 0;
/*     */     }
/*     */     
/* 201 */     int countEveryDay = ActivityInterface.getActivityCfg(SQYXTQuestionConst.getInstance().ACTIVITY_ID).count;
/* 202 */     if (finishCount >= countEveryDay)
/*     */     {
/* 204 */       return 0;
/*     */     }
/* 206 */     AwardReason reason = new AwardReason(LogReason.QYXT_QUESTION_AWARD);
/* 207 */     reason.setJustQuery(true);
/* 208 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(SQYXTQuestionConst.getInstance().wrongAwardid, roleId, -1, reason);
/*     */     
/* 210 */     if (awardModel == null)
/*     */     {
/* 212 */       return 0;
/*     */     }
/*     */     
/* 215 */     int addStorageExp = (countEveryDay - finishCount) * awardModel.getRoleExp() * SQYXTQuestionConst.getInstance().storageExpExchangeRate / 10000;
/*     */     
/*     */ 
/* 218 */     return addStorageExp;
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
/*     */   public static int getActivityCount2StorageExp(long roleId, int activityCount)
/*     */   {
/* 232 */     AwardReason reason = new AwardReason(LogReason.QYXT_QUESTION_AWARD);
/* 233 */     reason.setJustQuery(true);
/* 234 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(SQYXTQuestionConst.getInstance().wrongAwardid, roleId, -1, reason);
/*     */     
/* 236 */     if (awardModel == null)
/*     */     {
/* 238 */       return 0;
/*     */     }
/*     */     
/* 241 */     int addStorageExp = awardModel.getRoleExp() * SQYXTQuestionConst.getInstance().storageExpExchangeRate / 10000;
/*     */     
/* 243 */     return addStorageExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getQYXTActivityCfgId()
/*     */   {
/* 251 */     return SQYXTQuestionConst.getInstance().ACTIVITY_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMutexStatus(long roleId)
/*     */   {
/* 259 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleId, 86, true))
/*     */     {
/* 261 */       GameServer.logger().error(String.format("[QYXT]QYXTQuestionActivity.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 263 */       return false;
/*     */     }
/* 265 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\QYXTQuestionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */