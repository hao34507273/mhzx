/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionAnswerNotify;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionHelpAnswerNotfiy;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionNormalFail;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2memorycompetition;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMemoryCompetitionHelpAnswer extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long activeHelpRoleId;
/*     */   private final long seekHelpRoleId;
/*     */   private final int answerId;
/*     */   private long memoryCompetitionId;
/*     */   
/*     */   public PCMemoryCompetitionHelpAnswer(long activeHelpRoleId, long seekHelpRoleId, int answerId)
/*     */   {
/*  28 */     this.activeHelpRoleId = activeHelpRoleId;
/*  29 */     this.seekHelpRoleId = seekHelpRoleId;
/*  30 */     this.answerId = answerId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.activeHelpRoleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     String activeUserId = mzm.gsp.role.main.RoleInterface.getUserId(this.activeHelpRoleId);
/*  42 */     lock(Lockeys.get(User.getTable(), activeUserId));
/*     */     
/*     */ 
/*  45 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.activeHelpRoleId, 922, true, true))
/*     */     {
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     Long xMemoryCompetitionId = Role2memorycompetition.get(Long.valueOf(this.activeHelpRoleId));
/*  52 */     if (xMemoryCompetitionId == null)
/*     */     {
/*  54 */       onMemoryCompetitionHelpAnswerFail(1);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     this.memoryCompetitionId = xMemoryCompetitionId.longValue();
/*     */     
/*  60 */     MemoryCompetitionInfo xMemoryCompetitionInfo = xtable.Memorycompetition.get(xMemoryCompetitionId);
/*  61 */     if (xMemoryCompetitionInfo == null)
/*     */     {
/*  63 */       onMemoryCompetitionHelpAnswerFail(2);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/*  68 */     if (competitionCfg == null)
/*     */     {
/*  70 */       onMemoryCompetitionHelpAnswerFail(11);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     List<Long> xRoleIdList = xMemoryCompetitionInfo.getRole_id_list();
/*  75 */     if (!xRoleIdList.contains(Long.valueOf(this.seekHelpRoleId)))
/*     */     {
/*  77 */       Map<String, Object> extraMap = new HashMap();
/*  78 */       extraMap.put("role_id_list", xRoleIdList.toString());
/*  79 */       onMemoryCompetitionHelpAnswerFail(7);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     MemoryCompetitionQuestionObserver questionObserver = xMemoryCompetitionInfo.getRoles_current_question_observer();
/*  84 */     if (questionObserver == null)
/*     */     {
/*  86 */       onMemoryCompetitionHelpAnswerFail(3);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     boolean isAleardySeekHelp = questionObserver.isAleardySeekHelp(this.seekHelpRoleId);
/*  91 */     if (!isAleardySeekHelp)
/*     */     {
/*  93 */       onMemoryCompetitionHelpAnswerFail(12);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     boolean isAleardyAnswered = questionObserver.isAleardyAnswered(this.seekHelpRoleId);
/*  98 */     if (isAleardyAnswered)
/*     */     {
/* 100 */       onMemoryCompetitionHelpAnswerFail(5);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     boolean isAleardyBeHelped = questionObserver.isAleardyBeHelped(this.seekHelpRoleId);
/* 105 */     if (isAleardyBeHelped)
/*     */     {
/* 107 */       onMemoryCompetitionHelpAnswerFail(9);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     questionObserver.setHelpState(this.seekHelpRoleId);
/* 112 */     questionObserver.setAnswer(this.seekHelpRoleId, this.answerId);
/*     */     
/* 114 */     SMemoryCompetitionHelpAnswerNotfiy helpAnswerNotfiy = new SMemoryCompetitionHelpAnswerNotfiy();
/* 115 */     helpAnswerNotfiy.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/* 116 */     helpAnswerNotfiy.answer_id = this.answerId;
/* 117 */     helpAnswerNotfiy.active_help_role_id = this.activeHelpRoleId;
/*     */     
/* 119 */     OnlineManager.getInstance().send(this.seekHelpRoleId, helpAnswerNotfiy);
/*     */     
/*     */ 
/* 122 */     SMemoryCompetitionAnswerNotify answerNotfiy = new SMemoryCompetitionAnswerNotify();
/* 123 */     answerNotfiy.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/* 124 */     answerNotfiy.answer_id = this.answerId;
/* 125 */     answerNotfiy.team_member_role_id = this.seekHelpRoleId;
/*     */     
/*     */ 
/* 128 */     OnlineManager.getInstance().sendMulti(answerNotfiy, xRoleIdList);
/*     */     
/* 130 */     if (questionObserver.isAllAnswered())
/*     */     {
/* 132 */       MemoryCompetitionManager.onQuestionEnd(xMemoryCompetitionInfo, questionObserver, competitionCfg);
/*     */     }
/*     */     
/* 135 */     GameServer.logger().info(String.format("[memorycompetition]PCMemoryCompetitionHelpAnswer.processImp@handle competition seek help success|active_role_id=%d|seek_help_role_id=%d|answer_id=%d|memory_competition_id=%d", new Object[] { Long.valueOf(this.activeHelpRoleId), Long.valueOf(this.seekHelpRoleId), Integer.valueOf(this.answerId), Long.valueOf(this.memoryCompetitionId) }));
/*     */     
/*     */ 
/*     */ 
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   private void onMemoryCompetitionHelpAnswerFail(int ret)
/*     */   {
/* 144 */     onMemoryCompetitionHelpAnswerFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onMemoryCompetitionHelpAnswerFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 149 */     StringBuilder sbLog = new StringBuilder();
/* 150 */     sbLog.append("[memorycompetition]PCMemoryCompetitionSeekHelp.processImp@memory competition seek help failed");
/* 151 */     sbLog.append("|ret=").append(ret);
/* 152 */     sbLog.append("|active_role_id=").append(this.activeHelpRoleId);
/* 153 */     sbLog.append("|seek_help_role_id=").append(this.seekHelpRoleId);
/* 154 */     sbLog.append("|answer_id=").append(this.answerId);
/* 155 */     sbLog.append("|memory_competition_id=").append(this.memoryCompetitionId);
/*     */     
/* 157 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 159 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 161 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 164 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 166 */     SMemoryCompetitionNormalFail sMemoryCompetitionNormalFail = new SMemoryCompetitionNormalFail();
/* 167 */     sMemoryCompetitionNormalFail.result = ret;
/*     */     
/* 169 */     OnlineManager.getInstance().sendAtOnce(this.activeHelpRoleId, sMemoryCompetitionNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\PCMemoryCompetitionHelpAnswer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */