/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.Item2Count;
/*     */ import mzm.gsp.question.SAnswerQYXTQuestionRes;
/*     */ import mzm.gsp.question.SQYXTExtraAwardRes;
/*     */ import mzm.gsp.question.confbean.SQYXTForceAnswerQuestionCfg;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionCfg;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*     */ import mzm.gsp.question.event.RoleAnswerOneQYXTQuestion;
/*     */ import mzm.gsp.question.session.CheckAnswerResultEnum;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QYXTQuestionInfo;
/*     */ import xtable.Role2qyxtquestion;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCAnswerQYXTQuestion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int questionCfgId;
/*     */   private final int answeridx;
/*     */   private final long sessionId;
/*     */   
/*     */   public PCCAnswerQYXTQuestion(long roleId, int questionCfgId, int answerIdx, long sessionId)
/*     */   {
/*  44 */     this.roleId = roleId;
/*  45 */     this.questionCfgId = questionCfgId;
/*  46 */     this.answeridx = answerIdx;
/*  47 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if (!QYXTQuestionActivity.checkMutexStatus(this.roleId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userid = RoleInterface.getUserId(this.roleId);
/*  59 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  60 */     List<Long> roleids = Arrays.asList(new Long[] { Long.valueOf(this.roleId) });
/*  61 */     lock(Role2qyxtquestion.getTable(), roleids);
/*  62 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID);
/*     */     
/*  64 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  66 */       GameServer.logger().info(String.format("[QYXT]PCCAnswerQYXTQuestion.processImp@can not answer question|roleid=%d|reasonid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     QYXTQuestionInfo xQyxtQuestionInfo = Role2qyxtquestion.get(Long.valueOf(this.roleId));
/*  72 */     if (xQyxtQuestionInfo == null)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[QYXT]PCCAnswerQYXTQuestion.processImp@qustionInfo is null|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  76 */       return false;
/*     */     }
/*  78 */     if (!xQyxtQuestionInfo.getQuestions().contains(Integer.valueOf(this.questionCfgId)))
/*     */     {
/*  80 */       GameServer.logger().info(String.format("[QYXT]PCCAnswerQYXTQuestion.processImp@qustion id is wrong|roleid=%d|questionid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId) }));
/*     */       
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     ActivityInterface.addActivityCount(userid, this.roleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID);
/*     */     
/*     */ 
/*  90 */     int awardid = 0;
/*  91 */     CheckAnswerResultEnum result = QuestionSessionInterface.checkAnswer(this.sessionId, this.roleId, QuestionTypeEnum.QYXT, this.questionCfgId, 0, this.answeridx);
/*     */     
/*  93 */     if ((result == CheckAnswerResultEnum.INVALID_SESSION_ID) || (result == CheckAnswerResultEnum.ARG_NOT_MATCH))
/*     */     {
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (result == CheckAnswerResultEnum.RIGHT)
/*     */     {
/* 100 */       xQyxtQuestionInfo.setRightnum(xQyxtQuestionInfo.getRightnum() + 1);
/* 101 */       awardid = SQYXTQuestionConst.getInstance().rightAwardid;
/*     */     }
/*     */     else
/*     */     {
/* 105 */       awardid = SQYXTQuestionConst.getInstance().wrongAwardid;
/*     */     }
/*     */     
/* 108 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(awardid, userid, this.roleId, false, true, new mzm.gsp.award.main.AwardReason(LogReason.QYXT_QUESTION_AWARD));
/*     */     
/* 110 */     if (awardModel == null)
/*     */     {
/* 112 */       String logStr = String.format("[QYXT]PCCAnswerQYXTQuestion.processImp@award qyxt question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(awardid) });
/*     */       
/*     */ 
/* 115 */       GameServer.logger().error(logStr);
/*     */     }
/*     */     
/* 118 */     int answerNum = ActivityInterface.getActivityCount(userid, this.roleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID, true);
/*     */     
/* 120 */     int nextQuestionCfgId = QYXTQuestionActivity.getNextQuestionid(xQyxtQuestionInfo, answerNum);
/*     */     
/* 122 */     if (ActivityInterface.isToMaxCount(userid, this.roleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID))
/*     */     {
/*     */ 
/* 125 */       if (xQyxtQuestionInfo.getRightnum() >= SQYXTQuestionConst.getInstance().extraAwardNum)
/*     */       {
/* 127 */         if (!mzm.gsp.idip.main.IdipManager.isZeroProfit(this.roleId))
/*     */         {
/* 129 */           AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(SQYXTQuestionConst.getInstance().extraAwardId, this.roleId, RoleInterface.getLevel(this.roleId));
/*     */           
/* 131 */           ArrayList<Item2Count> item2Counts = new ArrayList();
/* 132 */           for (Map.Entry<Integer, Integer> entry : awardPoolResultData.getItemMap().entrySet())
/*     */           {
/* 134 */             Item2Count item2Count = new Item2Count();
/* 135 */             item2Count.itemid = ((Integer)entry.getKey()).intValue();
/* 136 */             item2Count.itemcount = ((Integer)entry.getValue()).intValue();
/* 137 */             item2Counts.add(item2Count);
/*     */           }
/* 139 */           int itemSize = item2Counts.size();
/* 140 */           if (itemSize > 0)
/*     */           {
/*     */ 
/* 143 */             int index = xdb.Xdb.random().nextInt(itemSize);
/* 144 */             Item2Count item2Count = (Item2Count)item2Counts.remove(index);
/* 145 */             item2Counts.add(0, item2Count);
/* 146 */             awardPoolResultData.getItemId2NumList().clear();
/* 147 */             awardPoolResultData.getItemMap().clear();
/* 148 */             awardPoolResultData.getItemMap().put(Integer.valueOf(item2Count.itemid), Integer.valueOf(item2Count.itemcount));
/* 149 */             List<Integer> numbers = new ArrayList();
/* 150 */             numbers.add(Integer.valueOf(item2Count.itemcount));
/* 151 */             awardPoolResultData.getItemId2NumList().put(Integer.valueOf(item2Count.itemid), numbers);
/*     */             
/* 153 */             SQYXTExtraAwardRes sQYXTExtraAwardRes = new SQYXTExtraAwardRes();
/* 154 */             sQYXTExtraAwardRes.item2countlist = item2Counts;
/* 155 */             OnlineManager.getInstance().send(this.roleId, sQYXTExtraAwardRes);
/*     */             
/* 157 */             mzm.gsp.item.main.LotteryManager.addLottery(this.roleId, 4, 0, awardPoolResultData, new TLogArg(LogReason.QYXT_EXTRA_AWARD));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 166 */     SQYXTForceAnswerQuestionCfg sqyxtForceAnswerQuestionCfg = (SQYXTForceAnswerQuestionCfg)SQYXTForceAnswerQuestionCfg.getAllSelf().get(Integer.valueOf(this.questionCfgId));
/*     */     
/*     */ 
/* 169 */     if ((xQyxtQuestionInfo.getCurrent_force_answer_index() < SQYXTQuestionConst.getInstance().maxForceAnswerQuestionIndex) && (sqyxtForceAnswerQuestionCfg != null))
/*     */     {
/*     */ 
/* 172 */       xQyxtQuestionInfo.setCurrent_force_answer_index(sqyxtForceAnswerQuestionCfg.indexId);
/*     */     }
/* 174 */     xQyxtQuestionInfo.getCurrent_help_roleids().clear();
/*     */     
/* 176 */     SAnswerQYXTQuestionRes answerQYXTQuestionRes = new SAnswerQYXTQuestionRes();
/* 177 */     answerQYXTQuestionRes.newquestionid = nextQuestionCfgId;
/* 178 */     answerQYXTQuestionRes.rightanswer = xQyxtQuestionInfo.getRightnum();
/* 179 */     if (nextQuestionCfgId != 0)
/*     */     {
/* 181 */       SQYXTQuestionCfg sqyxtQuestionCfg = SQYXTQuestionCfg.get(nextQuestionCfgId);
/* 182 */       if (sqyxtQuestionCfg == null)
/*     */       {
/* 184 */         return false;
/*     */       }
/* 186 */       long nextQuestionSessionId = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.QYXT, nextQuestionCfgId, 0, sqyxtQuestionCfg.answerNum, 1);
/*     */       
/* 188 */       answerQYXTQuestionRes.session_id = nextQuestionSessionId;
/* 189 */       answerQYXTQuestionRes.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(nextQuestionSessionId));
/*     */     }
/*     */     
/*     */ 
/* 193 */     TriggerEventsManger.getInstance().triggerEvent(new RoleAnswerOneQYXTQuestion(), new mzm.gsp.question.event.RoleAnswerOneQYXTQuestionArg(this.roleId, answerNum), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/* 197 */     OnlineManager.getInstance().send(this.roleId, answerQYXTQuestionRes);
/*     */     
/* 199 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PCCAnswerQYXTQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */