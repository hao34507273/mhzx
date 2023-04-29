/*     */ package mzm.gsp.activitycompensate.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activitycompensate.SGetAwardRes;
/*     */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateCfg;
/*     */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.guaji.main.GuajiInterface;
/*     */ import mzm.gsp.guaji.main.SwitchType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ActivityCompensate;
/*     */ import xbean.ActivityCompensates;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetAwardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityid;
/*     */   private final int getType;
/*     */   private final int leftTimes;
/*     */   private final int useDoublePoint;
/*     */   
/*     */   public PGetAwardReq(long roleid, int activityid, int getType, int leftTimes, int useDoublePoint)
/*     */   {
/*  45 */     this.roleid = roleid;
/*  46 */     this.activityid = activityid;
/*  47 */     this.getType = getType;
/*  48 */     this.leftTimes = leftTimes;
/*  49 */     this.useDoublePoint = useDoublePoint;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  55 */     if (!OpenInterface.getOpenStatus(544)) {
/*  56 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@not open|roleid=%d|activityid=%d|get_type=%d|left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes) });
/*     */       
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 2061, true))
/*     */     {
/*  65 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@mutex status|roleid=%d|activityid=%d|get_type=%d|left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes) });
/*     */       
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     SActivityCompensateCfg compensateCfg = SActivityCompensateCfg.get(this.activityid);
/*  72 */     if (compensateCfg == null) {
/*  73 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@compensate cfg null|roleid=%d|activityid=%d|get_type=%d|left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes) });
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*  78 */     if (this.leftTimes <= 0) {
/*  79 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@invalid left times|roleid=%d|activityid=%d|get_type=%d|left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes) });
/*     */       
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     if (!ActivityCompensateManager.isActivitySwitchOpen(this.activityid)) {
/*  87 */       ActivityCompensateManager.sendNormalResult(this.roleid, 5);
/*     */       
/*  89 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@activity switch closed|roleid=%d|activityid=%d|get_type=%d|left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes) });
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  97 */     int level = RoleInterface.getLevel(this.roleid);
/*  98 */     if (level < SActivityCompensateConsts.getInstance().NeedLevel) {
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/* 105 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/* 107 */     ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(this.roleid);
/*     */     
/*     */ 
/* 110 */     ActivityCompensate xCompensate = ActivityCompensateManager.createXCompensateIfNotExist(xCompensates, this.activityid);
/*     */     
/*     */ 
/* 113 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 114 */     int realLeftTimes = ActivityCompensateManager.checkAndRefreshOneAwardTimes(this.roleid, xCompensate, this.activityid, nowMillis);
/* 115 */     if (this.leftTimes != realLeftTimes) {
/* 116 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@left times not match|roleid=%d|activityid=%d|get_type=%d|client_left_times=%d|server_left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes), Integer.valueOf(realLeftTimes) });
/*     */       
/*     */ 
/* 119 */       ActivityCompensateManager.sendNormalResult(this.roleid, 1);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     int awardid = -1;
/* 124 */     int modifyId = -1;
/* 125 */     TLogArg tLogArg = new TLogArg(LogReason.ACTIVITY_COMPENSATE_GET_ONCE, this.activityid);
/* 126 */     if (this.getType == 0) {
/* 127 */       awardid = compensateCfg.freeAward;
/* 128 */       modifyId = SActivityCompensateConsts.getInstance().FreeAwardModifyid;
/*     */     }
/* 130 */     else if (this.getType == 1) {
/* 131 */       if (!RoleInterface.cutGold(this.roleid, compensateCfg.gold, tLogArg)) {
/* 132 */         ActivityCompensateManager.sendNormalResult(this.roleid, 2);
/* 133 */         return false;
/*     */       }
/* 135 */       awardid = compensateCfg.goldAward;
/* 136 */       modifyId = SActivityCompensateConsts.getInstance().GoldAwardModifyid;
/*     */     }
/* 138 */     else if (this.getType == 2) {
/* 139 */       CostResult costResult = QingfuInterface.costYuanbao(userid, this.roleid, compensateCfg.yuanbao, CostType.COST_ACTIVITY_COMPENSATE_GET_ONCE, tLogArg);
/*     */       
/* 141 */       if (!costResult.equals(CostResult.Success)) {
/* 142 */         ActivityCompensateManager.logError("PGetAwardReq.processImp@cost yuanbao failed|roleid=%d|activityid=%d|get_type=%d|left_times=%d|code=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes), Integer.valueOf(costResult.code) });
/*     */         
/*     */ 
/* 145 */         ActivityCompensateManager.sendNormalResult(this.roleid, 3);
/* 146 */         return false;
/*     */       }
/* 148 */       awardid = compensateCfg.yuanbaoAward;
/* 149 */       modifyId = SActivityCompensateConsts.getInstance().YuanBaoAwardModifyid;
/*     */     }
/*     */     else {
/* 152 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@invalid get type|roleid=%d|activityid=%d|get_type=%d|left_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes) });
/*     */       
/*     */ 
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     if (awardid < 0) {
/* 159 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@invalid awardid|roleid=%d|activityid=%d|get_type=%d|left_times=%d|awardid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes), Integer.valueOf(awardid) });
/*     */       
/*     */ 
/* 162 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 166 */     Iterator<Map.Entry<Long, Integer>> xIter = xCompensate.getStart_time2get_times().entrySet().iterator();
/* 167 */     Map.Entry<Long, Integer> xFirstEntry = (Map.Entry)xIter.next();
/* 168 */     long firstTime = ((Long)xFirstEntry.getKey()).longValue();
/* 169 */     int updateLeftTimes = ((Integer)xFirstEntry.getValue()).intValue() - 1;
/* 170 */     if (updateLeftTimes <= 0) {
/* 171 */       xIter.remove();
/*     */     }
/*     */     else {
/* 174 */       xFirstEntry.setValue(Integer.valueOf(updateLeftTimes));
/*     */     }
/*     */     
/*     */ 
/* 178 */     if ((this.useDoublePoint == 1) && 
/* 179 */       (this.activityid == SActivityCompensateConsts.getInstance().ZhenYaoActivityid))
/*     */     {
/* 181 */       boolean bCostDoublePoint = GuajiInterface.costDoublePointFromBothPool(this.roleid, SwitchType.ZhenYao, SActivityCompensateConsts.getInstance().ZhenYaoDoublePointCost, tLogArg);
/*     */       
/* 183 */       if (bCostDoublePoint) {
/* 184 */         if (this.getType == 0) {
/* 185 */           awardid = SActivityCompensateConsts.getInstance().ZhenYaoDoublePointFreeAward;
/*     */         }
/* 187 */         else if (this.getType == 1) {
/* 188 */           awardid = SActivityCompensateConsts.getInstance().ZhenYaoDoublePointGoldAward;
/*     */         }
/* 190 */         else if (this.getType == 2) {
/* 191 */           awardid = SActivityCompensateConsts.getInstance().ZhenYaoDoublePointYuanbaoAward;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 198 */     AwardReason awardReason = new AwardReason(LogReason.ACTIVITY_COMPENSATE_GET_ONCE, this.activityid);
/* 199 */     AwardModel awardModel = AwardInterface.awardAtTime(awardid, firstTime, userid, this.roleid, modifyId, false, true, awardReason);
/*     */     
/* 201 */     String fristDateStr = ActivityCompensateManager.getDateStr(firstTime);
/* 202 */     if (awardModel == null) {
/* 203 */       ActivityCompensateManager.logError("PGetAwardReq.processImp@award model null|roleid=%d|activityid=%d|get_type=%d|left_times=%d|awardid=%d|award_time=%d|award_date=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(this.leftTimes), Integer.valueOf(awardid), Long.valueOf(firstTime), fristDateStr });
/*     */       
/*     */ 
/* 206 */       return false;
/*     */     }
/*     */     
/* 209 */     SGetAwardRes res = new SGetAwardRes();
/* 210 */     res.activityid = this.activityid;
/* 211 */     res.left_times = (realLeftTimes - 1);
/* 212 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 214 */     ActivityCompensateManager.logInfo("PGetAwardReq.processImp@succeed|roleid=%d|activityid=%d|get_type=%d|awardid=%d|award_time=%d|award_date=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(this.getType), Integer.valueOf(awardid), Long.valueOf(firstTime), fristDateStr });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 219 */     ActivityCompensateManager.tlogGetAward(userid, this.roleid, level, this.activityid, this.getType, 1);
/*     */     
/* 221 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\PGetAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */