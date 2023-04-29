/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionAnswerNotify;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionNormalFail;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Memorycompetition;
/*     */ import xtable.Role2memorycompetition;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMemoryCompetitionAnswer extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int answer;
/*     */   private long memoryCompetitionId;
/*     */   
/*     */   public PCMemoryCompetitionAnswer(long roleId, int answer)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.answer = answer;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.roleId))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     String userId = RoleInterface.getUserId(this.roleId);
/*  39 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  42 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 924, true, true))
/*     */     {
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     Long xMemoryCompetitionId = Role2memorycompetition.get(Long.valueOf(this.roleId));
/*  50 */     if (xMemoryCompetitionId == null)
/*     */     {
/*  52 */       onMemoryCompetitionAnswerFail(1);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     this.memoryCompetitionId = xMemoryCompetitionId.longValue();
/*     */     
/*  58 */     MemoryCompetitionInfo xMemoryCompetitionInfo = Memorycompetition.get(Long.valueOf(this.memoryCompetitionId));
/*  59 */     if (xMemoryCompetitionInfo == null)
/*     */     {
/*  61 */       onMemoryCompetitionAnswerFail(2);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     MemoryCompetitionQuestionObserver questionObserver = xMemoryCompetitionInfo.getRoles_current_question_observer();
/*  66 */     if (questionObserver == null)
/*     */     {
/*  68 */       onMemoryCompetitionAnswerFail(3);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     MemoryCompetitionQuestionObserver.QuestionAnswerState questionAnswerState = (MemoryCompetitionQuestionObserver.QuestionAnswerState)questionObserver.getRole2AnswerStateMap().get(Long.valueOf(this.roleId));
/*  73 */     if (questionAnswerState == null)
/*     */     {
/*  75 */       onMemoryCompetitionAnswerFail(3);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/*  80 */     if (competitionCfg == null)
/*     */     {
/*  82 */       onMemoryCompetitionAnswerFail(11);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     questionObserver.setAnswer(this.roleId, this.answer);
/*     */     
/*  88 */     SMemoryCompetitionAnswerNotify answerNotfiy = new SMemoryCompetitionAnswerNotify();
/*  89 */     answerNotfiy.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/*  90 */     answerNotfiy.answer_id = this.answer;
/*  91 */     answerNotfiy.team_member_role_id = this.roleId;
/*     */     
/*     */ 
/*  94 */     java.util.List<Long> xRoleIdList = xMemoryCompetitionInfo.getRole_id_list();
/*  95 */     OnlineManager.getInstance().sendMulti(answerNotfiy, xRoleIdList);
/*     */     
/*  97 */     if (questionObserver.isAllAnswered())
/*     */     {
/*  99 */       MemoryCompetitionManager.onQuestionEnd(xMemoryCompetitionInfo, questionObserver, competitionCfg);
/*     */     }
/*     */     
/* 102 */     GameServer.logger().info(String.format("[memorycompetition]handle answer memory competition failed|role_id=%d|answer_id=%d|memory_competition_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.answer), Long.valueOf(this.memoryCompetitionId) }));
/*     */     
/*     */ 
/*     */ 
/* 106 */     return true;
/*     */   }
/*     */   
/*     */   private void onMemoryCompetitionAnswerFail(int ret)
/*     */   {
/* 111 */     onMemoryCompetitionAnswerFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onMemoryCompetitionAnswerFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 116 */     StringBuilder sbLog = new StringBuilder();
/* 117 */     sbLog.append("[memorycompetition]PCMemoryCompetitionAnswer.processImp@memory competition answer failed");
/* 118 */     sbLog.append("|ret=").append(ret);
/* 119 */     sbLog.append("|role_id=").append(this.roleId);
/* 120 */     sbLog.append("|memory_competition_id=").append(this.memoryCompetitionId);
/*     */     
/* 122 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 124 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 126 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 129 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 131 */     SMemoryCompetitionNormalFail sMemoryCompetitionNormalFail = new SMemoryCompetitionNormalFail();
/* 132 */     sMemoryCompetitionNormalFail.result = ret;
/*     */     
/* 134 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMemoryCompetitionNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\PCMemoryCompetitionAnswer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */