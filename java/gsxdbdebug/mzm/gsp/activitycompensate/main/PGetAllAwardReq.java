/*     */ package mzm.gsp.activitycompensate.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.activitycompensate.SGetAllAwardRes;
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
/*     */ public class PGetAllAwardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int getType;
/*     */   private final int useDoublePoint;
/*     */   
/*     */   public PGetAllAwardReq(long roleid, int getType, int useDoublePoint)
/*     */   {
/*  46 */     this.roleid = roleid;
/*  47 */     this.getType = getType;
/*  48 */     this.useDoublePoint = useDoublePoint;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if (!OpenInterface.getOpenStatus(544)) {
/*  55 */       ActivityCompensateManager.logError("PGetAllAwardReq.processImp@not open|roleid=%d|get_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.getType) });
/*     */       
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 2061, true))
/*     */     {
/*  64 */       ActivityCompensateManager.logError("PGetAllAwardReq.processImp@mutex status|roleid=%d|get_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.getType) });
/*     */       
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if ((this.getType != 0) && (this.getType != 1) && (this.getType != 2))
/*     */     {
/*     */ 
/*  73 */       ActivityCompensateManager.logError("PGetAllAwardReq.processImp@invalid get type|roleid=%d|get_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.getType) });
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  81 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*  82 */     if (roleLevel < SActivityCompensateConsts.getInstance().NeedLevel) {
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  89 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  91 */     ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(this.roleid);
/*     */     
/*     */ 
/*  94 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*  95 */     Map<Integer, Integer> activity2AwardTimes = ActivityCompensateManager.checkAndRefreshAllAwardTimes(this.roleid, xCompensates, nowMillis);
/*     */     
/*     */ 
/*  98 */     if (activity2AwardTimes.isEmpty()) {
/*  99 */       ActivityCompensateManager.sendNormalResult(this.roleid, 23);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     Map<Integer, Integer> activityid2Awardid = new HashMap();
/* 104 */     int costValue = 0;
/*     */     
/* 106 */     for (Map.Entry<Integer, Integer> entry : activity2AwardTimes.entrySet()) {
/* 107 */       int activityid = ((Integer)entry.getKey()).intValue();
/* 108 */       int times = ((Integer)entry.getValue()).intValue();
/*     */       
/* 110 */       SActivityCompensateCfg compensateCfg = SActivityCompensateCfg.get(activityid);
/* 111 */       if (this.getType == 0) {
/* 112 */         activityid2Awardid.put(Integer.valueOf(activityid), Integer.valueOf(compensateCfg.freeAward));
/*     */       }
/* 114 */       else if (this.getType == 1) {
/* 115 */         activityid2Awardid.put(Integer.valueOf(activityid), Integer.valueOf(compensateCfg.goldAward));
/* 116 */         costValue += compensateCfg.gold * times;
/*     */       }
/* 118 */       else if (this.getType == 2) {
/* 119 */         activityid2Awardid.put(Integer.valueOf(activityid), Integer.valueOf(compensateCfg.yuanbaoAward));
/* 120 */         costValue += compensateCfg.yuanbao * times;
/*     */       }
/*     */       else {
/* 123 */         ActivityCompensateManager.logError("PGetAllAwardReq.processImp@invalid get type|roleid=%d|get_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.getType) });
/*     */         
/*     */ 
/* 126 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 130 */     TLogArg tLogArg = new TLogArg(LogReason.ACTIVITY_COMPENSATE_GET_ALL, this.getType);
/* 131 */     int modifyId = -1;
/*     */     
/* 133 */     if (this.getType == 0) {
/* 134 */       modifyId = SActivityCompensateConsts.getInstance().FreeAwardModifyid;
/*     */     }
/* 136 */     else if (this.getType == 1)
/*     */     {
/* 138 */       if (!RoleInterface.cutGold(this.roleid, costValue, tLogArg)) {
/* 139 */         ActivityCompensateManager.sendNormalResult(this.roleid, 2);
/* 140 */         return false;
/*     */       }
/* 142 */       modifyId = SActivityCompensateConsts.getInstance().GoldAwardModifyid;
/*     */     }
/* 144 */     else if (this.getType == 2) {
/* 145 */       CostResult costResult = QingfuInterface.costYuanbao(userid, this.roleid, costValue, CostType.COST_ACTIVITY_COMPENSATE_GET_ALL, tLogArg);
/*     */       
/* 147 */       if (!costResult.equals(CostResult.Success)) {
/* 148 */         ActivityCompensateManager.logError("PGetAllAwardReq.processImp@cost yuanbao failed|roleid=%d|get_type=%d|need_yuanbao=%d|code=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.getType), Integer.valueOf(costValue), Integer.valueOf(costResult.code) });
/*     */         
/*     */ 
/* 151 */         ActivityCompensateManager.sendNormalResult(this.roleid, 3);
/* 152 */         return false;
/*     */       }
/* 154 */       modifyId = SActivityCompensateConsts.getInstance().YuanBaoAwardModifyid;
/*     */     }
/*     */     
/*     */ 
/* 158 */     long limitLatestTime = ActivityCompensateManager.getLimitLatestCompensateTime(nowMillis);
/* 159 */     Iterator<Map.Entry<Integer, ActivityCompensate>> xCompensateIter = xCompensates.getCompensates().entrySet().iterator();
/*     */     
/* 161 */     while (xCompensateIter.hasNext()) {
/* 162 */       Map.Entry<Integer, ActivityCompensate> xCompensateEntry = (Map.Entry)xCompensateIter.next();
/* 163 */       int activityid = ((Integer)xCompensateEntry.getKey()).intValue();
/* 164 */       ActivityCompensate xCompensate = (ActivityCompensate)xCompensateEntry.getValue();
/* 165 */       Integer awardid = (Integer)activityid2Awardid.get(Integer.valueOf(activityid));
/* 166 */       if (awardid != null)
/*     */       {
/*     */ 
/* 169 */         Map<Long, Integer> time2GetTimes = new TreeMap();
/*     */         
/* 171 */         int doublePointAwardid = -1;
/* 172 */         Map<Long, Integer> doublePointTime2GetTimes = new TreeMap();
/* 173 */         if ((this.useDoublePoint == 1) && (activityid == SActivityCompensateConsts.getInstance().ZhenYaoActivityid))
/*     */         {
/* 175 */           if (this.getType == 0) {
/* 176 */             doublePointAwardid = SActivityCompensateConsts.getInstance().ZhenYaoDoublePointFreeAward;
/*     */           }
/* 178 */           else if (this.getType == 1) {
/* 179 */             doublePointAwardid = SActivityCompensateConsts.getInstance().ZhenYaoDoublePointGoldAward;
/*     */           }
/* 181 */           else if (this.getType == 2) {
/* 182 */             doublePointAwardid = SActivityCompensateConsts.getInstance().ZhenYaoDoublePointYuanbaoAward;
/*     */           }
/*     */         }
/*     */         
/* 186 */         Iterator<Map.Entry<Long, Integer>> xIter = xCompensate.getStart_time2get_times().entrySet().iterator();
/*     */         
/*     */ 
/* 189 */         int totalTimes = 0;
/* 190 */         while (xIter.hasNext()) {
/* 191 */           Map.Entry<Long, Integer> xEntry = (Map.Entry)xIter.next();
/* 192 */           long startTime = ((Long)xEntry.getKey()).longValue();
/* 193 */           int awardTimes = ((Integer)xEntry.getValue()).intValue();
/*     */           
/*     */ 
/* 196 */           if (startTime < limitLatestTime)
/*     */           {
/*     */ 
/*     */ 
/* 200 */             if (awardTimes > 0) {
/* 201 */               totalTimes += awardTimes;
/* 202 */               if (doublePointAwardid > 0) {
/* 203 */                 int doublePointAwardTimes = 0;
/* 204 */                 for (int i = 0; i < awardTimes; i++)
/*     */                 {
/* 206 */                   boolean costDoublePoint = GuajiInterface.costDoublePointFromBothPool(this.roleid, SwitchType.ZhenYao, SActivityCompensateConsts.getInstance().ZhenYaoDoublePointCost, tLogArg);
/*     */                   
/* 208 */                   if (!costDoublePoint) break;
/* 209 */                   doublePointAwardTimes += 1;
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 215 */                 if (doublePointAwardTimes > 0) {
/* 216 */                   doublePointTime2GetTimes.put(Long.valueOf(startTime), Integer.valueOf(doublePointAwardTimes));
/* 217 */                   awardTimes -= doublePointAwardTimes;
/*     */                 }
/*     */               }
/* 220 */               if (awardTimes > 0) {
/* 221 */                 time2GetTimes.put(Long.valueOf(startTime), Integer.valueOf(awardTimes));
/*     */               }
/*     */             }
/*     */             
/* 225 */             xIter.remove();
/*     */           }
/*     */         }
/*     */         
/* 229 */         AwardReason awardReason = new AwardReason(LogReason.ACTIVITY_COMPENSATE_GET_ALL, activityid);
/* 230 */         AwardModel awardModel = AwardInterface.awardAtTime(awardid.intValue(), time2GetTimes, userid, this.roleid, modifyId, false, true, awardReason);
/*     */         
/* 232 */         if (awardModel == null) {
/* 233 */           ActivityCompensateManager.logError("PGetAllAwardReq.processImp@award model null|roleid=%d|activityid=%d|get_type=%d|awardid=%d|time2get_times=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityid), Integer.valueOf(this.getType), awardid, time2GetTimes.toString() });
/*     */           
/*     */ 
/* 236 */           return false;
/*     */         }
/*     */         
/* 239 */         if (!doublePointTime2GetTimes.isEmpty()) {
/* 240 */           AwardModel doublePointAwardModel = AwardInterface.awardAtTime(doublePointAwardid, doublePointTime2GetTimes, userid, this.roleid, modifyId, false, true, awardReason);
/*     */           
/* 242 */           if (doublePointAwardModel == null) {
/* 243 */             ActivityCompensateManager.logError("PGetAllAwardReq.processImp@double point award model null|roleid=%d|activityid=%d|get_type=%d|awardid=%d|time2get_times=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityid), Integer.valueOf(this.getType), Integer.valueOf(doublePointAwardid), doublePointTime2GetTimes.toString() });
/*     */             
/*     */ 
/* 246 */             return false;
/*     */           }
/*     */         }
/* 249 */         ActivityCompensateManager.logInfo("PGetAllAwardReq.processImp@get activity award|roleid=%d|activityid=%d|get_type=%d|awardid=%d|time2get_times=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityid), Integer.valueOf(this.getType), awardid, time2GetTimes.toString() });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 254 */         ActivityCompensateManager.tlogGetAward(userid, this.roleid, roleLevel, activityid, this.getType, totalTimes);
/*     */       }
/*     */     }
/* 257 */     SGetAllAwardRes res = new SGetAllAwardRes();
/* 258 */     res.get_type = this.getType;
/* 259 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 261 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\PGetAllAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */