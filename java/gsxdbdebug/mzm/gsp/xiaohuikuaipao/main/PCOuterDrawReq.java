/*     */ package mzm.gsp.xiaohuikuaipao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.xiaohuikuaipao.AwardInfo;
/*     */ import mzm.gsp.xiaohuikuaipao.SOuterDrawError;
/*     */ import mzm.gsp.xiaohuikuaipao.SOuterDrawRsp;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.STXiaoHuiKuaiPaoGridCfg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.STXiaoHuiKuaiPaoGridWeightCfg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.SXiaoHuiKuaiPaoGridInfo;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.SXiaoHuiKuaiPaoGridWeightInfo;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.TXiaoHuiKuaiPaoInnerTicketCfg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoInnerTicketInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.XiaoHuiKuaiPaoInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCOuterDrawReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int count;
/*     */   final byte isUseYuanBao;
/*     */   final long clientYuanBao;
/*     */   final long needYuanBao;
/*     */   
/*     */   public PCOuterDrawReq(long roleId, int activityId, int count, byte isUseYuanBao, long clientYuanBao, long needYuanBao)
/*     */   {
/*  47 */     this.roleId = roleId;
/*  48 */     this.activityId = activityId;
/*  49 */     this.count = count;
/*  50 */     this.isUseYuanBao = isUseYuanBao;
/*  51 */     this.clientYuanBao = clientYuanBao;
/*  52 */     this.needYuanBao = needYuanBao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  59 */     if (!OpenInterface.getOpenStatus(482))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1843, true))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     if ((this.count != 1) && (this.count != 10))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if ((this.isUseYuanBao != 1) && (this.isUseYuanBao != 0))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/*  80 */     if (activityCfg == null)
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg = XiaoHuiKuaiPaoActivityCfg.get(this.activityId);
/*  85 */     if (xiaoHuiKuaiPaoActivityCfg == null)
/*     */     {
/*  87 */       return false;
/*     */     }
/*  89 */     String userId = RoleInterface.getUserId(this.roleId);
/*  90 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  91 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  92 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*     */     
/*  94 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     long serverYuanBao = QingfuInterface.getBalance(userId, true);
/* 101 */     if (serverYuanBao != this.clientYuanBao)
/*     */     {
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     SOuterDrawError outerDrawError = new SOuterDrawError();
/*     */     
/*     */ 
/* 109 */     Map<Integer, Integer> maxGridNeededForPoolTypeIds = XiaoHuiKuaiPaoManager.getMaxGridNeededForPoolTypeIds(this.roleId, this.activityId);
/*     */     
/* 111 */     GameServer.logger().info(String.format("[xiaohuikuaipao]PCOuterDrawReq.processImp    maxGridNeededForPoolTypeIds: %s", new Object[] { maxGridNeededForPoolTypeIds }));
/*     */     
/* 113 */     if (maxGridNeededForPoolTypeIds.isEmpty())
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     if (AwardPoolInterface.checkGridNum(this.roleId, maxGridNeededForPoolTypeIds, this.count, true, true) > 0)
/*     */     {
/* 119 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 124 */     int totalItemNeed = this.count * xiaoHuiKuaiPaoActivityCfg.itemCount;
/* 125 */     MainSubItemYuanBaoInfo mainSubItemYuanBaoInfo = XiaoHuiKuaiPaoManager.cutMainSubItemWithYuanBaoSupply(userId, this.roleId, xiaoHuiKuaiPaoActivityCfg.mainItemId, xiaoHuiKuaiPaoActivityCfg.subItemId, totalItemNeed);
/*     */     
/* 127 */     if (!mainSubItemYuanBaoInfo.isSuccess)
/*     */     {
/* 129 */       outerDrawError.errorcode = (mainSubItemYuanBaoInfo.isYuanBaoNotEnough ? 1 : 0);
/* 130 */       outerDrawError.errorcode = (mainSubItemYuanBaoInfo.isItemNotEnough ? 2 : 0);
/* 131 */       OnlineManager.getInstance().sendAtOnce(this.roleId, outerDrawError);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     if (((this.isUseYuanBao == 1) && (mainSubItemYuanBaoInfo.yuanBaoToCost == 0)) || ((this.isUseYuanBao == 0) && (mainSubItemYuanBaoInfo.yuanBaoToCost != 0)) || (mainSubItemYuanBaoInfo.yuanBaoToCost != this.needYuanBao))
/*     */     {
/*     */ 
/* 138 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 142 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = XiaoHuiKuaiPaoManager.getXiaoHuiKuaiPaoInfo(this.roleId, this.activityId, xiaoHuiKuaiPaoActivityCfg);
/*     */     
/*     */ 
/* 145 */     int tLog_lastIndex = xXiaoHuiKuaiPaoInfo.getIndex();
/* 146 */     int tLog_lastAccumulateTurnCount = xXiaoHuiKuaiPaoInfo.getAccumulateturncount();
/* 147 */     int tLog_lastTicketCount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/*     */     
/* 149 */     STXiaoHuiKuaiPaoGridCfg xiaoHuiKuaiPaoGridCfg = STXiaoHuiKuaiPaoGridCfg.get(this.activityId);
/* 150 */     if (xiaoHuiKuaiPaoGridCfg == null)
/*     */     {
/* 152 */       return false;
/*     */     }
/* 154 */     STXiaoHuiKuaiPaoGridWeightCfg xiaoHuiKuaiPaoGridWeightCfg = STXiaoHuiKuaiPaoGridWeightCfg.get(this.activityId);
/* 155 */     if (xiaoHuiKuaiPaoGridWeightCfg == null)
/*     */     {
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     TXiaoHuiKuaiPaoInnerTicketCfg xiaoHuiKuaiPaoInnerTicketCfg = TXiaoHuiKuaiPaoInnerTicketCfg.get(this.activityId);
/* 161 */     if (xiaoHuiKuaiPaoInnerTicketCfg == null)
/*     */     {
/* 163 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 167 */     int totalGridCount = xiaoHuiKuaiPaoGridCfg.index2gridInfo.size() + 1;
/*     */     
/* 169 */     int maxStepCount = xiaoHuiKuaiPaoGridWeightCfg.index2gridWeightInfo.size();
/*     */     
/* 171 */     SXiaoHuiKuaiPaoGridInfo xiaoHuiKuaiPaoGridInfo = null;
/*     */     
/* 173 */     int currentGridIndex = xXiaoHuiKuaiPaoInfo.getIndex();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 183 */     int stepTotalCount = 0;
/*     */     
/* 185 */     int circleTotalCount = 0;
/*     */     
/*     */ 
/* 188 */     List<SXiaoHuiKuaiPaoGridInfo> hitGridInfoList = new ArrayList(this.count);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 193 */     int useItemDrawCount = this.count - mainSubItemYuanBaoInfo.yuanBaoSupplyItemCount / xiaoHuiKuaiPaoActivityCfg.itemCount;
/*     */     
/*     */ 
/*     */ 
/* 197 */     SOuterDrawRsp outerDrawRsp = new SOuterDrawRsp();
/* 198 */     for (int j = 1; j <= this.count; j++)
/*     */     {
/* 200 */       boolean isUseYuanBao = j > useItemDrawCount;
/* 201 */       int initGridIndex = currentGridIndex;
/* 202 */       boolean isHit = false;
/*     */       
/* 204 */       int stepCount = 0;
/* 205 */       int circleCount = 0;
/* 206 */       for (int i = 1; i <= maxStepCount; i++)
/*     */       {
/* 208 */         stepCount++;
/* 209 */         currentGridIndex = (currentGridIndex + 1) % totalGridCount;
/* 210 */         if (currentGridIndex == 0)
/*     */         {
/* 212 */           currentGridIndex = 1;
/* 213 */           circleCount++;
/*     */         }
/*     */         
/* 216 */         xiaoHuiKuaiPaoGridInfo = (SXiaoHuiKuaiPaoGridInfo)xiaoHuiKuaiPaoGridCfg.index2gridInfo.get(Integer.valueOf(currentGridIndex));
/*     */         
/* 218 */         if (xiaoHuiKuaiPaoGridInfo.hitRate != 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 223 */           if (Xdb.random().nextInt(10000) < getCorrectedHitRate(xiaoHuiKuaiPaoGridInfo, xiaoHuiKuaiPaoActivityCfg))
/*     */           {
/* 225 */             isHit = true;
/* 226 */             break;
/*     */           } }
/*     */       }
/* 229 */       if (isHit)
/*     */       {
/* 231 */         GameServer.logger().info(String.format("[xiaohuikuaipao]PCOuterDrawReq.processImp:hit index=%d", new Object[] { Integer.valueOf(xiaoHuiKuaiPaoGridInfo.index) }));
/*     */         
/*     */ 
/* 234 */         hitGridInfoList.add(xiaoHuiKuaiPaoGridInfo);
/* 235 */         stepTotalCount += stepCount;
/* 236 */         outerDrawRsp.stepcountlist.add(Integer.valueOf(stepCount));
/* 237 */         circleTotalCount += circleCount;
/*     */         
/* 239 */         AwardPoolInterface.addWeightCorrectCount(this.roleId, xiaoHuiKuaiPaoActivityCfg.weightCorrectTypeCfgId);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 244 */         currentGridIndex = initGridIndex;
/* 245 */         int totalWeight = 0;
/* 246 */         for (int i = 1; i <= maxStepCount; i++)
/*     */         {
/* 248 */           currentGridIndex = (currentGridIndex + 1) % totalGridCount;
/* 249 */           if (currentGridIndex == 0)
/*     */           {
/* 251 */             currentGridIndex = 1;
/*     */           }
/*     */           
/* 254 */           xiaoHuiKuaiPaoGridInfo = (SXiaoHuiKuaiPaoGridInfo)xiaoHuiKuaiPaoGridCfg.index2gridInfo.get(Integer.valueOf(currentGridIndex));
/*     */           
/* 256 */           if (xiaoHuiKuaiPaoGridInfo.hitRate == 0)
/*     */           {
/*     */ 
/*     */ 
/* 260 */             if (isUseYuanBao)
/*     */             {
/* 262 */               totalWeight += ((SXiaoHuiKuaiPaoGridWeightInfo)xiaoHuiKuaiPaoGridWeightCfg.index2gridWeightInfo.get(Integer.valueOf(i))).yuanBaoWeight;
/*     */             }
/*     */             else
/*     */             {
/* 266 */               totalWeight += ((SXiaoHuiKuaiPaoGridWeightInfo)xiaoHuiKuaiPaoGridWeightCfg.index2gridWeightInfo.get(Integer.valueOf(i))).itemWeight;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 271 */         stepCount = 0;
/* 272 */         circleCount = 0;
/* 273 */         currentGridIndex = initGridIndex;
/* 274 */         int random = Xdb.random().nextInt(totalWeight);
/* 275 */         int localWeightSum = 0;
/* 276 */         for (int i = 1; i <= maxStepCount; i++)
/*     */         {
/* 278 */           stepCount++;
/* 279 */           currentGridIndex = (currentGridIndex + 1) % totalGridCount;
/* 280 */           if (currentGridIndex == 0)
/*     */           {
/* 282 */             currentGridIndex = 1;
/* 283 */             circleCount++;
/*     */           }
/*     */           
/* 286 */           xiaoHuiKuaiPaoGridInfo = (SXiaoHuiKuaiPaoGridInfo)xiaoHuiKuaiPaoGridCfg.index2gridInfo.get(Integer.valueOf(currentGridIndex));
/*     */           
/* 288 */           if (xiaoHuiKuaiPaoGridInfo.hitRate == 0)
/*     */           {
/*     */ 
/*     */ 
/* 292 */             if (isUseYuanBao)
/*     */             {
/* 294 */               localWeightSum += ((SXiaoHuiKuaiPaoGridWeightInfo)xiaoHuiKuaiPaoGridWeightCfg.index2gridWeightInfo.get(Integer.valueOf(i))).yuanBaoWeight;
/*     */             }
/*     */             else
/*     */             {
/* 298 */               localWeightSum += ((SXiaoHuiKuaiPaoGridWeightInfo)xiaoHuiKuaiPaoGridWeightCfg.index2gridWeightInfo.get(Integer.valueOf(i))).itemWeight;
/*     */             }
/* 300 */             if (random < localWeightSum)
/*     */             {
/* 302 */               isHit = true;
/* 303 */               break;
/*     */             }
/*     */           }
/*     */         }
/* 307 */         GameServer.logger().info(String.format("[xiaohuikuaipao]PCOuterDrawReq.processImp:hit index=%d", new Object[] { Integer.valueOf(xiaoHuiKuaiPaoGridInfo.index) }));
/*     */         
/*     */ 
/* 310 */         hitGridInfoList.add(xiaoHuiKuaiPaoGridInfo);
/* 311 */         stepTotalCount += stepCount;
/* 312 */         outerDrawRsp.stepcountlist.add(Integer.valueOf(stepCount));
/* 313 */         circleTotalCount += circleCount;
/*     */         
/* 315 */         AwardPoolInterface.addWeightCorrectCount(this.roleId, xiaoHuiKuaiPaoActivityCfg.weightCorrectTypeCfgId);
/*     */       }
/*     */     }
/*     */     
/* 319 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*     */ 
/* 322 */     Map<Integer, Integer> itemId2count = new HashMap();
/*     */     
/* 324 */     for (SXiaoHuiKuaiPaoGridInfo gridInfo : hitGridInfoList)
/*     */     {
/* 326 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(gridInfo.poolTypeId, this.roleId, roleLevel);
/* 327 */       if (awardPoolResultData == null)
/*     */       {
/* 329 */         return false;
/*     */       }
/* 331 */       for (Map.Entry<Integer, Integer> entry : awardPoolResultData.getItemMap().entrySet()) { int itemCount;
/*     */         int itemCount;
/* 333 */         if (itemId2count.containsKey(entry.getKey()))
/*     */         {
/* 335 */           itemCount = ((Integer)itemId2count.get(entry.getKey())).intValue();
/*     */         }
/*     */         else
/*     */         {
/* 339 */           itemCount = 0;
/*     */         }
/* 341 */         itemId2count.put(entry.getKey(), Integer.valueOf(itemCount + ((Integer)entry.getValue()).intValue()));
/*     */       }
/* 343 */       AwardInfo awardInfo = new AwardInfo();
/* 344 */       awardInfo.itemmap.putAll(awardPoolResultData.getItemMap());
/* 345 */       outerDrawRsp.awardinfolist.add(awardInfo);
/*     */     }
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
/* 365 */     boolean ret = mzm.gsp.item.main.LotteryManager.addLottery(this.roleId, 12, 0, itemId2count, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.XIAO_HUI_KUAI_PAO_OUTER_DRAW));
/*     */     
/* 367 */     if (!ret)
/*     */     {
/* 369 */       outerDrawError.errorcode = 4;
/* 370 */       OnlineManager.getInstance().sendAtOnce(this.roleId, outerDrawError);
/* 371 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 375 */     int lastAccumulateTurnCount = xXiaoHuiKuaiPaoInfo.getAccumulateturncount();
/* 376 */     int currentAccumulateTurnCount = lastAccumulateTurnCount + circleTotalCount;
/* 377 */     int currentTicketCount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/* 378 */     Integer nextLevelTurnCount = (Integer)xiaoHuiKuaiPaoInnerTicketCfg.accTurnCount2innerTicketInfo.higherKey(Integer.valueOf(lastAccumulateTurnCount));
/*     */     
/* 380 */     while ((nextLevelTurnCount != null) && (nextLevelTurnCount.intValue() <= currentAccumulateTurnCount))
/*     */     {
/* 382 */       currentTicketCount += ((XiaoHuiKuaiPaoInnerTicketInfo)xiaoHuiKuaiPaoInnerTicketCfg.accTurnCount2innerTicketInfo.get(nextLevelTurnCount)).ticketCount;
/* 383 */       nextLevelTurnCount = (Integer)xiaoHuiKuaiPaoInnerTicketCfg.accTurnCount2innerTicketInfo.higherKey(nextLevelTurnCount);
/*     */     }
/* 385 */     xXiaoHuiKuaiPaoInfo.setAccumulateturncount(currentAccumulateTurnCount);
/* 386 */     xXiaoHuiKuaiPaoInfo.setIndex(currentGridIndex);
/* 387 */     xXiaoHuiKuaiPaoInfo.setTicketcount(currentTicketCount);
/*     */     
/*     */ 
/* 390 */     outerDrawRsp.activityid = this.activityId;
/* 391 */     outerDrawRsp.outerinfo.ticketcount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/* 392 */     outerDrawRsp.outerinfo.index = xXiaoHuiKuaiPaoInfo.getIndex();
/* 393 */     outerDrawRsp.outerinfo.accumulateturncount = xXiaoHuiKuaiPaoInfo.getAccumulateturncount();
/* 394 */     OnlineManager.getInstance().send(this.roleId, outerDrawRsp);
/*     */     
/*     */ 
/* 397 */     XiaoHuiKuaiPaoTLogManager.tLogOuterDraw(this.roleId, this.activityId, mainSubItemYuanBaoInfo.yuanBaoToCost, mainSubItemYuanBaoInfo.itemId2countToCost, itemId2count, this.count, stepTotalCount, tLog_lastIndex, xXiaoHuiKuaiPaoInfo.getIndex(), tLog_lastAccumulateTurnCount, xXiaoHuiKuaiPaoInfo.getAccumulateturncount(), tLog_lastTicketCount, xXiaoHuiKuaiPaoInfo.getTicketcount());
/*     */     
/*     */ 
/*     */ 
/* 401 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private int getCorrectedHitRate(SXiaoHuiKuaiPaoGridInfo xiaoHuiKuaiPaoGridInfo, XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg)
/*     */   {
/* 407 */     int correctedWeight = AwardPoolInterface.getCorrectedWeight(this.roleId, xiaoHuiKuaiPaoActivityCfg.weightCorrectTypeCfgId, xiaoHuiKuaiPaoGridInfo.weightCorrectCfgId);
/*     */     
/* 409 */     if (correctedWeight == -1)
/*     */     {
/* 411 */       return xiaoHuiKuaiPaoGridInfo.hitRate;
/*     */     }
/* 413 */     return correctedWeight;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PCOuterDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */