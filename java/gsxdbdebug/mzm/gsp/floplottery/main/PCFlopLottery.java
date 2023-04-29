/*     */ package mzm.gsp.floplottery.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.awardpool.confbean.FlopLotteryAwardPool;
/*     */ import mzm.gsp.awardpool.confbean.SFlopLotteryMainCfg;
/*     */ import mzm.gsp.awardpool.confbean.TFlopLotteryAwardPoolCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.floplottery.FlopLotteryResult;
/*     */ import mzm.gsp.floplottery.RewardItem;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FlopLotteryAwardPoolResult;
/*     */ import xbean.FlopLotteryEntry;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2floplotteryentry;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCFlopLottery extends LogicProcedure
/*     */ {
/*     */   final long uid;
/*     */   final int index;
/*     */   final int flopcount;
/*     */   final long roleId;
/*     */   
/*     */   public PCFlopLottery(long uid, int index, int flopcount, long roleId)
/*     */   {
/*  41 */     this.uid = uid;
/*  42 */     this.index = index;
/*  43 */     this.flopcount = flopcount;
/*  44 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     String errorLogHead = "[floplottery]PCFlopLottery@processImp ";
/*  52 */     String errorLogTail = String.format("|roleid=%d|uid=%d|index=%d|flopcount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uid), Integer.valueOf(this.index), Integer.valueOf(this.flopcount) });
/*     */     
/*  54 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*     */ 
/*  57 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  60 */     FlopLotteryEntry xFlopLotteryEntry = Role2floplotteryentry.get(Long.valueOf(this.roleId));
/*  61 */     if (xFlopLotteryEntry == null)
/*     */     {
/*  63 */       String errorLog = "xFlopLotteryEntry not exist";
/*  64 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*     */ 
/*  68 */     SFlopLotteryMainCfg flopLotteryMainCfg = SFlopLotteryMainCfg.get(xFlopLotteryEntry.getFloplotterymaincfgid());
/*  69 */     if (flopLotteryMainCfg == null)
/*     */     {
/*  71 */       String errorLog = "floplotterymaincfgid error";
/*  72 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*  74 */     if (!OpenInterface.getOpenStatus(flopLotteryMainCfg.switchId))
/*     */     {
/*  76 */       String errorLog = "switch closed";
/*  77 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*     */ 
/*  81 */     if (xFlopLotteryEntry.getUid() != this.uid)
/*     */     {
/*  83 */       String errorLog = "uid error";
/*  84 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*  87 */     List<FlopLotteryAwardPoolResult> xFlopLotteryAwardPoolResultList = xFlopLotteryEntry.getFloplotteryawardpoolresultlist();
/*  88 */     TFlopLotteryAwardPoolCfg flopLotteryAwardPoolCfg = TFlopLotteryAwardPoolCfg.get(flopLotteryMainCfg.typeId);
/*     */     
/*     */ 
/*  91 */     int xFlopCount = xFlopLotteryAwardPoolResultList.size();
/*  92 */     if (this.flopcount <= xFlopCount)
/*     */     {
/*  94 */       return false;
/*     */     }
/*  96 */     if (this.flopcount != xFlopCount + 1)
/*     */     {
/*  98 */       String errorLog = "flopcount error";
/*  99 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*     */ 
/* 103 */     for (FlopLotteryAwardPoolResult xFlopLotteryAwardPoolResult : xFlopLotteryAwardPoolResultList)
/*     */     {
/* 105 */       if (xFlopLotteryAwardPoolResult.getIndex() == this.index)
/*     */       {
/* 107 */         String errorLog = "index error:duplicate";
/* 108 */         return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */       }
/*     */     }
/*     */     
/* 112 */     FlopLotteryAwardPool flopLotteryAwardPool = (FlopLotteryAwardPool)flopLotteryAwardPoolCfg.flopLotteryAwardPools.get(this.flopcount - 1);
/* 113 */     if (flopLotteryAwardPool.moneyCount > 0)
/*     */     {
/*     */ 
/* 116 */       Boolean moneyResult = checkMoneyForRole(errorLogHead, errorLogTail, userId, flopLotteryAwardPool);
/* 117 */       if (!moneyResult.booleanValue()) {
/* 118 */         return false;
/*     */       }
/*     */       
/* 121 */       moneyResult = Boolean.valueOf(FlopLotteryManager.cutMoney(userId, this.roleId, LogReason.FLOP_LOTTERY_COST, flopLotteryAwardPool.id, flopLotteryAwardPool.moneyType, flopLotteryAwardPool.moneyCount, CostType.COST_BIND_FIRST_FLOP_LOTTERY));
/*     */       
/* 123 */       if (!moneyResult.booleanValue()) {
/* 124 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 128 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.randomAwardPoolForRole(this.roleId, flopLotteryAwardPool.awardPoolSumId);
/*     */     
/* 130 */     if (awardPoolResultData == null)
/*     */     {
/* 132 */       return false;
/*     */     }
/* 134 */     int isCondDone = xFlopLotteryEntry.getIsconddone();
/* 135 */     if (awardPoolResultData.getItemMap().containsKey(Integer.valueOf(flopLotteryMainCfg.condItemId)))
/*     */     {
/* 137 */       isCondDone = 0;
/*     */     }
/*     */     
/*     */ 
/* 141 */     if ((flopLotteryAwardPoolCfg.flopLotteryAwardPools.size() == this.flopcount) && (isCondDone == 1))
/*     */     {
/*     */ 
/* 144 */       awardPoolResultData = AwardPoolInterface.randomAwardPoolForRole(this.roleId, flopLotteryMainCfg.minAwardPoolSumId);
/*     */     }
/* 146 */     if (awardPoolResultData == null)
/*     */     {
/* 148 */       return false;
/*     */     }
/* 150 */     AwardPoolInterface.doAward(userId, this.roleId, awardPoolResultData, new TLogArg(LogReason.FLOP_LOTTERY_AWARD));
/*     */     
/*     */ 
/* 153 */     ArrayList<RewardItem> awardIdList = new ArrayList();
/* 154 */     fillResult(awardPoolResultData, awardIdList);
/*     */     
/*     */ 
/* 157 */     boolean sendRes = OnlineManager.getInstance().send(this.roleId, new mzm.gsp.floplottery.SFlopLotteryResult(this.uid, new FlopLotteryResult(this.index, awardIdList)));
/*     */     
/* 159 */     if (!sendRes)
/*     */     {
/* 161 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 165 */     FlopLotteryHandlerInterface flopLotteryHandler = xFlopLotteryEntry.getFloplotteryhandler();
/* 166 */     if (flopLotteryHandler != null)
/*     */     {
/* 168 */       if (!flopLotteryHandler.handle(this.roleId))
/*     */       {
/* 170 */         String errorLog = "handle error";
/* 171 */         return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, 3);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 176 */     if (xFlopLotteryAwardPoolResultList.size() == flopLotteryAwardPoolCfg.flopLotteryAwardPools.size() - 1)
/*     */     {
/* 178 */       Role2floplotteryentry.delete(Long.valueOf(this.roleId));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 183 */       FlopLotteryAwardPoolResult xFlopLotteryAwardPoolResult = xbean.Pod.newFlopLotteryAwardPoolResult();
/* 184 */       xFlopLotteryAwardPoolResult.setIndex(this.index);
/* 185 */       xFlopLotteryAwardPoolResult.getResultlist().addAll(awardIdList);
/* 186 */       xFlopLotteryAwardPoolResultList.add(xFlopLotteryAwardPoolResult);
/* 187 */       xFlopLotteryEntry.setIsconddone(isCondDone);
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private Boolean checkMoneyForRole(String errorLogHead, String errorLogTail, String userId, FlopLotteryAwardPool flopLotteryAwardPool)
/*     */   {
/*     */     long roleMoneyCount;
/*     */     
/* 197 */     switch (flopLotteryAwardPool.moneyType)
/*     */     {
/*     */     case 3: 
/* 200 */       roleMoneyCount = RoleInterface.getSilver(this.roleId);
/* 201 */       break;
/*     */     case 2: 
/* 203 */       roleMoneyCount = RoleInterface.getGold(this.roleId);
/* 204 */       break;
/*     */     case 5: 
/* 206 */       roleMoneyCount = RoleInterface.getGoldIngot(this.roleId);
/* 207 */       break;
/*     */     case 1: 
/* 209 */       roleMoneyCount = QingfuInterface.getBalance(userId, true);
/* 210 */       break;
/*     */     case 4: 
/* 212 */       roleMoneyCount = GangInterface.getBangGong(this.roleId);
/* 213 */       break;
/*     */     default: 
/* 215 */       return Boolean.valueOf(false);
/*     */     }
/*     */     
/* 218 */     if (roleMoneyCount < flopLotteryAwardPool.moneyCount)
/*     */     {
/* 220 */       String errorLog = "money not enough";
/* 221 */       return Boolean.valueOf(FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, 2));
/*     */     }
/*     */     
/* 224 */     return Boolean.valueOf(true);
/*     */   }
/*     */   
/*     */   private void fillResult(AwardPoolResultData resultData, ArrayList<RewardItem> awardIdList)
/*     */   {
/* 229 */     if (resultData.getControllerId() > 0)
/*     */     {
/* 231 */       ControllerInterface.triggerController(resultData.getControllerId());
/*     */       
/* 233 */       List<Integer> mapList = ControllerInterface.getControllerMapList(resultData.getControllerId());
/* 234 */       if (mapList.size() == 0)
/*     */       {
/* 236 */         mapList.add(Integer.valueOf(MapInterface.getRoleMapId(this.roleId)));
/*     */       }
/* 238 */       RewardItem reward = new RewardItem();
/* 239 */       reward.rewardtype = 7;
/* 240 */       reward.parammap.put(Integer.valueOf(5), Integer.valueOf(resultData.getControllerId()));
/* 241 */       reward.parammap.put(Integer.valueOf(4), mapList.get(0));
/* 242 */       awardIdList.add(reward);
/*     */     }
/* 244 */     else if (resultData.getRoleExp() > 0)
/*     */     {
/* 246 */       RewardItem reward = new RewardItem();
/* 247 */       reward.rewardtype = 1;
/* 248 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getRoleExp()));
/* 249 */       awardIdList.add(reward);
/*     */     }
/* 251 */     else if (resultData.getPetExp() > 0)
/*     */     {
/* 253 */       RewardItem reward = new RewardItem();
/* 254 */       reward.rewardtype = 2;
/* 255 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getPetExp()));
/* 256 */       awardIdList.add(reward);
/*     */     }
/* 258 */     else if (resultData.getXiuLianExp() > 0)
/*     */     {
/* 260 */       RewardItem reward = new RewardItem();
/* 261 */       reward.rewardtype = 3;
/* 262 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getXiuLianExp()));
/* 263 */       awardIdList.add(reward);
/*     */     }
/* 265 */     else if (resultData.getSilver() > 0)
/*     */     {
/* 267 */       RewardItem reward = new RewardItem();
/* 268 */       reward.rewardtype = 4;
/* 269 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getSilver()));
/* 270 */       awardIdList.add(reward);
/*     */     }
/* 272 */     else if (resultData.getGold() > 0)
/*     */     {
/* 274 */       RewardItem reward = new RewardItem();
/* 275 */       reward.rewardtype = 5;
/* 276 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGold()));
/* 277 */       awardIdList.add(reward);
/*     */     }
/* 279 */     else if (resultData.getGang() > 0)
/*     */     {
/* 281 */       RewardItem reward = new RewardItem();
/* 282 */       reward.rewardtype = 6;
/* 283 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGang()));
/* 284 */       awardIdList.add(reward);
/*     */     }
/* 286 */     else if (!resultData.getItemMap().isEmpty())
/*     */     {
/* 288 */       for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet())
/*     */       {
/* 290 */         RewardItem reward = new RewardItem();
/* 291 */         reward.rewardtype = 0;
/* 292 */         reward.parammap.put(Integer.valueOf(0), entry.getKey());
/* 293 */         reward.parammap.put(Integer.valueOf(1), entry.getValue());
/* 294 */         awardIdList.add(reward);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\main\PCFlopLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */