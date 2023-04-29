/*     */ package mzm.gsp.makeup.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SMakeUpActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.SMakeUpOptionCfg;
/*     */ import mzm.gsp.activity4.confbean.STMakeUpQuestionCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.makeup.SAnswerMakeUpRep;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.FactionMakeUpRecord;
/*     */ import xbean.GlobalMakeUpInfo;
/*     */ import xbean.MakeUpRecord;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAnswerMakeUpQuestion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final int optionId;
/*     */   private int answerOptionId;
/*     */   String userId;
/*     */   
/*     */   public PCAnswerMakeUpQuestion(long roleId, int activityId, int optionId)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.activityId = activityId;
/*  44 */     this.optionId = optionId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     MapInterface.getRolePosition(this.roleId, new MapCallback()
/*     */     {
/*     */ 
/*     */       public boolean isCallInProcedure()
/*     */       {
/*     */ 
/*  59 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */       public boolean onResult(Map<Long, Position> result)
/*     */       {
/*  65 */         return PCAnswerMakeUpQuestion.this.answerQuestion((Position)result.get(Long.valueOf(PCAnswerMakeUpQuestion.this.roleId)));
/*     */       }
/*  67 */     });
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   private boolean answerQuestion(Position curPos)
/*     */   {
/*  73 */     SMakeUpActivityCfg cfg = SMakeUpActivityCfg.get(this.activityId);
/*  74 */     if (cfg == null)
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */     {
/*  81 */       return false;
/*     */     }
/*  83 */     if (!ActivityInterface.isActivityOpen(this.activityId))
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     SMakeUpOptionCfg optionCfg = SMakeUpOptionCfg.get(this.optionId);
/*  88 */     if (optionCfg == null)
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (!isInActivityZone(curPos, cfg))
/*     */     {
/*  95 */       return false;
/*     */     }
/*  97 */     this.userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  99 */     lock(User.getTable(), Arrays.asList(new String[] { this.userId }));
/*     */     
/* 101 */     MakeUpRecord xMakeUpRecord = MakeUpManager.getXMakeUpRecordIfAbsent(this.roleId, this.activityId);
/* 102 */     long factionId = GangInterface.getGangId(this.roleId);
/* 103 */     if (factionId <= 0L)
/*     */     {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     FactionMakeUpRecord xFactionMakeUpRecord = MakeUpManager.getFactionActivityInfo(factionId, this.activityId);
/* 109 */     if (xFactionMakeUpRecord == null)
/*     */     {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     GlobalMakeUpInfo xGlobalMakeupInfo = MakeUpManager.getGlobalMakeupInfo(this.activityId);
/* 115 */     if (xGlobalMakeupInfo == null)
/*     */     {
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(this.userId, this.roleId, this.activityId);
/* 121 */     if (!res.isCanJoin())
/*     */     {
/* 123 */       MakeUpManager.loggerError("PCAnswerMakeUpQuestion.processImp@ can not join activity!|roleId=%d|activityId=%d|resCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) });
/*     */       
/*     */ 
/* 126 */       return false;
/*     */     }
/* 128 */     if (!canAnswer(xMakeUpRecord, factionId, xFactionMakeUpRecord, xGlobalMakeupInfo))
/*     */     {
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if (!checkOption(cfg, this.userId, xFactionMakeUpRecord))
/*     */     {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if (!recordRoleAnswer(xMakeUpRecord, factionId, xFactionMakeUpRecord, xGlobalMakeupInfo))
/*     */     {
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     BuffInterface.installBuff(this.roleId, optionCfg.changeBuffId);
/*     */     
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isInActivityZone(Position curPos, SMakeUpActivityCfg cfg)
/*     */   {
/* 150 */     int x = curPos.getX();
/* 151 */     int y = curPos.getY();
/*     */     
/* 153 */     int doubleR = (int)(Math.pow(x - cfg.positionX, 2.0D) + Math.pow(y - cfg.positionY, 2.0D));
/* 154 */     if (doubleR <= Math.pow(cfg.radius, 2.0D))
/*     */     {
/* 156 */       return true;
/*     */     }
/* 158 */     MakeUpManager.loggerError("PCAnswerMakeUpQuestion.isInActivityZone@ not in activity zone!|roleId=%d|activityId=%d|x=%d|y=%d|cfgx=%d|cfgy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(cfg.positionX), Integer.valueOf(cfg.positionY) });
/*     */     
/*     */ 
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   private boolean checkOption(SMakeUpActivityCfg cfg, String userId, FactionMakeUpRecord xFactionMakeUpRecord)
/*     */   {
/* 166 */     this.answerOptionId = getAnswerOptionId(xFactionMakeUpRecord);
/* 167 */     if (this.answerOptionId != this.optionId)
/*     */     {
/* 169 */       if (!afterAnswerWrong(cfg, userId))
/*     */       {
/* 171 */         return false;
/*     */       }
/* 173 */       return true;
/*     */     }
/* 175 */     if (!afterAnswerRight(cfg, userId, xFactionMakeUpRecord))
/*     */     {
/* 177 */       return false;
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canAnswer(MakeUpRecord xMakeUpRecord, long factionId, FactionMakeUpRecord xFactionMakeUpRecord, GlobalMakeUpInfo xGlobalMakeupInfo)
/*     */   {
/* 185 */     if (!xGlobalMakeupInfo.getQuetioning())
/*     */     {
/* 187 */       MakeUpManager.loggerError("PCAnswerMakeUpQuestion.canAnswer@ not in question time!|roleId=%d|activityId=%d|fationId=%d|questionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(xFactionMakeUpRecord.getQuestionid()) });
/*     */       
/*     */ 
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     if (xMakeUpRecord.getTurn2optionid().get(Integer.valueOf(xGlobalMakeupInfo.getTurn())) != null)
/*     */     {
/*     */ 
/* 196 */       MakeUpManager.loggerError("PCAnswerMakeUpQuestion.canAnswer@ already answered!|roleId=%d|questionId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xFactionMakeUpRecord.getQuestionid()), Integer.valueOf(this.activityId) });
/*     */       
/*     */ 
/* 199 */       return false;
/*     */     }
/* 201 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean afterAnswerWrong(SMakeUpActivityCfg cfg, String userId)
/*     */   {
/* 207 */     OnlineManager.getInstance().send(this.roleId, new SAnswerMakeUpRep(this.activityId, this.optionId, 2));
/*     */     
/* 209 */     AwardModel awardModel = AwardInterface.award(cfg.wrongAwardId, userId, this.roleId, false, true, new AwardReason(LogReason.MAKE_UP_WRONG_AWARD, this.activityId));
/*     */     
/* 211 */     if (awardModel == null)
/*     */     {
/* 213 */       MakeUpManager.loggerError("PCAnswerMakeUpQuestion.afterAnswerWrong@ award err!|roleId=%d|awardId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.wrongAwardId), Integer.valueOf(this.activityId) });
/*     */       
/* 215 */       return false;
/*     */     }
/* 217 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean afterAnswerRight(SMakeUpActivityCfg cfg, String userId, FactionMakeUpRecord xFactionMakeUpRecord)
/*     */   {
/* 223 */     OnlineManager.getInstance().send(this.roleId, new SAnswerMakeUpRep(this.activityId, this.optionId, 1));
/*     */     
/* 225 */     AwardModel awardModel = AwardInterface.award(cfg.rightAwardId, userId, this.roleId, false, true, new AwardReason(LogReason.MAKE_UP_RIGHT_AWARD, this.activityId));
/*     */     
/* 227 */     if (awardModel == null)
/*     */     {
/* 229 */       MakeUpManager.loggerError("PCAnswerMakeUpQuestion.afterAnswerRight@ award err!|roleId=%d|awardId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.rightAwardId), Integer.valueOf(this.activityId) });
/*     */       
/* 231 */       return false;
/*     */     }
/*     */     
/* 234 */     xFactionMakeUpRecord.setRightnum(xFactionMakeUpRecord.getRightnum() + 1);
/* 235 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean recordRoleAnswer(MakeUpRecord xMakeUpRecord, long factionId, FactionMakeUpRecord xFactionMakeUpRecord, GlobalMakeUpInfo xGlobalMakeupInfo)
/*     */   {
/* 241 */     if (xFactionMakeUpRecord.getJoinroleids().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 243 */       MakeUpManager.loggerError("PCAnswerMakeUpQuestion.processImp@ already joined this question!|roleId=%d|activityId=%d|fationId=%d|questionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(xFactionMakeUpRecord.getQuestionid()) });
/*     */       
/*     */ 
/* 246 */       return false;
/*     */     }
/*     */     
/* 249 */     xFactionMakeUpRecord.getJoinroleids().add(Long.valueOf(this.roleId));
/*     */     
/* 251 */     xMakeUpRecord.getTurn2optionid().put(Integer.valueOf(xGlobalMakeupInfo.getTurn()), Integer.valueOf(this.optionId));
/*     */     
/* 253 */     tlogMakeUp(this.userId, this.roleId, this.activityId, xFactionMakeUpRecord.getCurturn(), xFactionMakeUpRecord.getQuestionid(), factionId, this.optionId, this.answerOptionId);
/*     */     
/* 255 */     return true;
/*     */   }
/*     */   
/*     */   private int getAnswerOptionId(FactionMakeUpRecord xFactionMakeUpRecord)
/*     */   {
/* 260 */     STMakeUpQuestionCfg questionCfg = STMakeUpQuestionCfg.get(this.activityId);
/* 261 */     if (questionCfg == null)
/*     */     {
/* 263 */       return -1;
/*     */     }
/* 265 */     Integer answerOptionId = (Integer)questionCfg.questionInfos.get(Integer.valueOf(xFactionMakeUpRecord.getQuestionid()));
/* 266 */     return answerOptionId == null ? -1 : answerOptionId.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogMakeUp(String userId, long roleId, int activityId, int turn, int questionId, long factionId, int optionId, int rightOptionId)
/*     */   {
/* 276 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 277 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 279 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(turn), Integer.valueOf(questionId), Long.valueOf(factionId), Integer.valueOf(optionId), Integer.valueOf(rightOptionId) };
/*     */     
/*     */ 
/* 282 */     TLogManager.getInstance().addLog(roleId, "MakeUp", colums);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\PCAnswerMakeUpQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */