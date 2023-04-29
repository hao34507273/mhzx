/*     */ package mzm.gsp.factiontask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.SFinishGangTaskeNotice;
/*     */ import mzm.gsp.activity.SGangeTaskNormalResult;
/*     */ import mzm.gsp.activity.confbean.FactionTaskConsts;
/*     */ import mzm.gsp.activity.confbean.SGangTaskModifyCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.task.main.ActiveAcceptTaskManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FTaskInfo;
/*     */ import xtable.Role2factiontaskinfo;
/*     */ 
/*     */ public class GangTaskManager
/*     */ {
/*  29 */   private static FactionTaskConsts consts = ;
/*     */   
/*  31 */   private static Map<Integer, Integer> ringNum2CfgId = new HashMap();
/*     */   
/*     */   static int getCanJoinLevel() {
/*  34 */     return consts.CAN_JOIN_LEVEL;
/*     */   }
/*     */   
/*     */   static int getGangTaskGraph() {
/*  38 */     return consts.TASK_GRAPH_ID;
/*     */   }
/*     */   
/*     */   static int getGangTaskNpcId() {
/*  42 */     return consts.NPC_ID;
/*     */   }
/*     */   
/*     */   static int getGangTaskActivityId() {
/*  46 */     return consts.ACTIVITYID;
/*     */   }
/*     */   
/*     */   static int getPerfectRingNum() {
/*  50 */     return consts.PERFECT_NUM;
/*     */   }
/*     */   
/*     */   static int getCanJoinNum() {
/*  54 */     return consts.NUM_UP;
/*     */   }
/*     */   
/*     */   static int getAwardModifyId(int ringNum) {
/*  58 */     Integer cfgid = (Integer)ringNum2CfgId.get(Integer.valueOf(ringNum));
/*  59 */     if (cfgid == null) {
/*  60 */       return -1;
/*     */     }
/*  62 */     SGangTaskModifyCfg cfg = SGangTaskModifyCfg.get(cfgid.intValue());
/*  63 */     if (cfg == null) {
/*  64 */       return -1;
/*     */     }
/*  66 */     return cfg.modifyId;
/*     */   }
/*     */   
/*     */   static int getAwardId() {
/*  70 */     return consts.AWARD_ID;
/*     */   }
/*     */   
/*     */   static int getExAwardId() {
/*  74 */     return consts.PER_AWARD_ID;
/*     */   }
/*     */   
/*     */   static int getOpenEnum() {
/*  78 */     return -1;
/*     */   }
/*     */   
/*     */   static void init() {
/*  82 */     ActivityInterface.registerActivityByLogicType(25, new PGangTaskInit());
/*     */     
/*  84 */     ActiveAcceptTaskManager.getInstance().regHandler(getGangTaskGraph(), GangTaskHandler.getInstance());
/*     */     
/*  86 */     for (SGangTaskModifyCfg cfg : SGangTaskModifyCfg.getAll().values()) {
/*  87 */       Integer cfgId = (Integer)ringNum2CfgId.get(Integer.valueOf(cfg.ringNum));
/*  88 */       if (cfgId != null) {
/*  89 */         throw new RuntimeException(String.format("环数对应模板id重复！@ringNum=%d", new Object[] { Integer.valueOf(cfg.ringNum) }));
/*     */       }
/*  91 */       ringNum2CfgId.put(Integer.valueOf(cfg.ringNum), Integer.valueOf(cfg.id));
/*     */     }
/*     */   }
/*     */   
/*     */   static void check()
/*     */   {
/*  97 */     if (!AwardInterface.hasAwardId(getAwardId())) {
/*  98 */       throw new RuntimeException(String.format("帮派任务常量表:奖励id不存在！@awardId=%d", new Object[] { Integer.valueOf(getAwardId()) }));
/*     */     }
/* 100 */     if (!AwardInterface.hasAwardId(getExAwardId())) {
/* 101 */       throw new RuntimeException(String.format("帮派任务常量表:奖励id不存在！@awardId=%d", new Object[] { Integer.valueOf(getExAwardId()) }));
/*     */     }
/* 103 */     if (!TaskInterface.isHaveGraphId(getGangTaskGraph())) {
/* 104 */       throw new RuntimeException(String.format("帮派任务常量表:任务图id不存在！@graphId=%d", new Object[] { Integer.valueOf(getGangTaskGraph()) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleInGang(long roleId)
/*     */   {
/* 115 */     return GangInterface.getGangId(roleId) >= 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean canJoinActivity(Map<Long, String> roleidToUserid, long roleId)
/*     */   {
/* 122 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(roleId) }), getGangTaskActivityId());
/* 123 */     if (!res.isCanJoin()) {
/* 124 */       GameServer.logger().error(String.format("[factionTask]GangTaskManager.canJoinActivity@ forbid join activity!|roleId=%d|resCode=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(res.getReasonValue()) }));
/* 125 */       return false;
/*     */     }
/* 127 */     int ringNum = ActivityInterface.getActivityCount((String)roleidToUserid.get(Long.valueOf(roleId)), roleId, getGangTaskActivityId(), false);
/* 128 */     if (ringNum >= getCanJoinNum()) {
/* 129 */       sendNormalResult(roleId, 2, new String[0]);
/* 130 */       return false;
/*     */     }
/* 132 */     return true;
/*     */   }
/*     */   
/*     */   static boolean giveAward(long roleId, String userId, int ringNum, boolean isOpen) {
/* 136 */     if (!isOpen)
/*     */     {
/* 138 */       return true;
/*     */     }
/*     */     
/* 141 */     if (!giveNorAward(roleId, userId, ringNum)) {
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     if (!giveExAward(roleId, userId, ringNum)) {
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean giveNorAward(long roleId, String userId, int ringNum)
/*     */   {
/* 159 */     int modifyId = getAwardModifyId(ringNum);
/* 160 */     if (modifyId <= 0) {
/* 161 */       return false;
/*     */     }
/* 163 */     AwardReason reason = new AwardReason(LogReason.GANG_TASK_AWARD_ADD);
/* 164 */     AwardModel am = AwardInterface.award(getAwardId(), userId, roleId, modifyId, false, true, reason);
/* 165 */     if (am == null) {
/* 166 */       return false;
/*     */     }
/* 168 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean giveExAward(long roleId, String userId, int ringNum)
/*     */   {
/* 179 */     if (ringNum != getPerfectRingNum()) {
/* 180 */       return true;
/*     */     }
/* 182 */     AwardReason reason = new AwardReason(LogReason.GANG_TASK_AWARD_ADD);
/* 183 */     AwardModel exAm = AwardInterface.award(getExAwardId(), userId, roleId, false, false, reason);
/* 184 */     if (exAm == null) {
/* 185 */       GameServer.logger().error(String.format("[FactionTask]GangTaskManager.giveAward@get perfect award fail!|roleId=%d|roleLevel=%d|ringNum=%d|awardId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(mzm.gsp.role.main.RoleInterface.getLevel(roleId)), Integer.valueOf(ringNum), Integer.valueOf(getExAwardId()) }));
/*     */       
/*     */ 
/*     */ 
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     SFinishGangTaskeNotice notice = new SFinishGangTaskeNotice();
/* 193 */     AwardInterface.fillAwardBean(notice.targetawardbean, exAm);
/* 194 */     OnlineManager.getInstance().send(roleId, notice);
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   static boolean cancelPerfect(long roleId) {
/* 199 */     FTaskInfo xFTaskInfo = Role2factiontaskinfo.get(Long.valueOf(roleId));
/* 200 */     if (xFTaskInfo == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     xFTaskInfo.setIsperfect(false);
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isPerfect(long roleId) {
/* 208 */     FTaskInfo xFTaskInfo = Role2factiontaskinfo.get(Long.valueOf(roleId));
/* 209 */     if (xFTaskInfo == null) {
/* 210 */       return false;
/*     */     }
/* 212 */     return xFTaskInfo.getIsperfect();
/*     */   }
/*     */   
/*     */   static boolean initPerFect(long roleId) {
/* 216 */     FTaskInfo xFTaskInfo = Role2factiontaskinfo.get(Long.valueOf(roleId));
/* 217 */     if (xFTaskInfo == null) {
/* 218 */       return false;
/*     */     }
/* 220 */     xFTaskInfo.setIsperfect(true);
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result, String... args) {
/* 225 */     SGangeTaskNormalResult pro = new SGangeTaskNormalResult();
/* 226 */     pro.result = result;
/* 227 */     for (String arg : args) {
/* 228 */       pro.args.add(arg);
/*     */     }
/* 230 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFactionTaskOpen(long roleId)
/*     */   {
/* 238 */     if (!OpenInterface.getOpenStatus(18)) {
/* 239 */       OpenInterface.sendCloseProtocol(roleId, 18, null);
/* 240 */       return false;
/*     */     }
/* 242 */     if (OpenInterface.isBanPlay(roleId, 18)) {
/* 243 */       OpenInterface.sendBanPlayMsg(roleId, 18);
/* 244 */       return false;
/*     */     }
/* 246 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\GangTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */