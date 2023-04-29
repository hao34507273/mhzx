/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.LotteryPetMarkItemInfo;
/*     */ import mzm.gsp.petmark.SPetMarkLotteryDrawFail;
/*     */ import mzm.gsp.petmark.SPetMarkLotteryDrawSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class PCPetMarkLotteryDrawReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int lotteryType;
/*     */   private final int lotteryNum;
/*     */   
/*     */   public PCPetMarkLotteryDrawReq(long roleId, int lotteryType, int lotteryNum)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.lotteryType = lotteryType;
/*  38 */     this.lotteryNum = lotteryNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  48 */       String logstr = String.format("[petmark]PCPetMarkLotteryDrawReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  50 */       GameServer.logger().info(logstr);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2140, true))
/*     */     {
/*  57 */       String logstr = String.format("[petmark]PCPetMarkLotteryDrawReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  59 */       GameServer.logger().info(logstr);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  66 */       onFail(-1);
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     if ((this.lotteryNum != 1) && (this.lotteryNum != 10))
/*     */     {
/*  73 */       onFail(-2);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     int costTokenNum;
/*     */     
/*     */ 
/*  82 */     if (this.lotteryType == 1)
/*     */     {
/*  84 */       int costTokenType = 15;
/*  85 */       int lotteryPoolTypeId = SPetMarkConstants.getInstance().LOTTERY_AWARD_POOL_TYPE_ID1;
/*  86 */       int lotteryDelayTime = SPetMarkConstants.getInstance().LOTTERY_ANIMATION_DURATION1;
/*  87 */       int costTokenNum; if (this.lotteryNum == 1)
/*     */       {
/*  89 */         costTokenNum = SPetMarkConstants.getInstance().LOTTERY_COST1;
/*     */       }
/*     */       else
/*     */       {
/*  93 */         costTokenNum = SPetMarkConstants.getInstance().TEN_LOTTERY_COST1; }
/*     */     } else {
/*     */       int costTokenNum;
/*  96 */       if (this.lotteryType == 2)
/*     */       {
/*  98 */         int costTokenType = 16;
/*  99 */         int lotteryPoolTypeId = SPetMarkConstants.getInstance().LOTTERY_AWARD_POOL_TYPE_ID2;
/* 100 */         int lotteryDelayTime = SPetMarkConstants.getInstance().LOTTERY_ANIMATION_DURATION2;
/* 101 */         int costTokenNum; if (this.lotteryNum == 1)
/*     */         {
/* 103 */           costTokenNum = SPetMarkConstants.getInstance().LOTTERY_COST2;
/*     */         }
/*     */         else
/*     */         {
/* 107 */           costTokenNum = SPetMarkConstants.getInstance().TEN_LOTTERY_COST2;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 112 */         onFail(-2);
/* 113 */         return false; } }
/*     */     int lotteryDelayTime;
/*     */     int lotteryPoolTypeId;
/*     */     int costTokenNum;
/* 117 */     int costTokenType; TLogArg costLogArg = new TLogArg(LogReason.PET_MARK_LOTTERY_COST);
/* 118 */     JifenOperateResult res = MallInterface.cutJifen(this.roleId, costTokenNum, costTokenType, costLogArg);
/* 119 */     if (!res.isSuccess())
/*     */     {
/* 121 */       onFail(-3);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     Map<Integer, Integer> bagId2NeedGridNum = AwardPoolInterface.getBagId2MaxNeedGridNum(lotteryPoolTypeId);
/* 127 */     if (AwardPoolInterface.checkGridNum(this.roleId, bagId2NeedGridNum, this.lotteryNum, true, true) > 0)
/*     */     {
/*     */ 
/* 130 */       String logstr = String.format("[changemodelcard]PCPetMarkLotteryDrawReq.processImp@PCPetMarkLotteryDrawReq failed, grid not enough|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/* 133 */       GameServer.logger().info(logstr);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     List<AwardPoolResultData> resultDatas = new LinkedList();
/* 139 */     for (int i = 0; i < this.lotteryNum; i++)
/*     */     {
/* 141 */       AwardPoolResultData resultData = AwardPoolInterface.getAwardPoolData(lotteryPoolTypeId, this.roleId, RoleInterface.getLevel(this.roleId));
/*     */       
/*     */ 
/* 144 */       resultDatas.add(resultData);
/*     */     }
/*     */     
/*     */ 
/* 148 */     boolean ret = LotteryManager.addLottery(this.roleId, 14, 0, resultDatas, new TLogArg(LogReason.PET_MARK_LOTTERY_ADD), lotteryDelayTime);
/*     */     
/* 150 */     if (!ret)
/*     */     {
/* 152 */       onFail(-5);
/* 153 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 157 */     onSuccess(MallInterface.getJifen(this.roleId, costTokenType), resultDatas);
/*     */     
/* 159 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(long newToken, List<AwardPoolResultData> resultDatas)
/*     */   {
/* 165 */     SPetMarkLotteryDrawSuccess proto = new SPetMarkLotteryDrawSuccess();
/* 166 */     proto.lottery_type = this.lotteryType;
/* 167 */     for (AwardPoolResultData resultData : resultDatas)
/*     */     {
/* 169 */       for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet())
/*     */       {
/* 171 */         LotteryPetMarkItemInfo itemInfo = new LotteryPetMarkItemInfo();
/* 172 */         itemInfo.item_cfg_id = ((Integer)entry.getKey()).intValue();
/* 173 */         itemInfo.count = ((Integer)entry.getValue()).intValue();
/* 174 */         proto.new_pet_mark_item_infos.add(itemInfo);
/*     */       }
/*     */     }
/* 177 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 180 */     String logstr = String.format("[petmark]PCPetMarkLotteryDrawReq.onSuccess@PCPetMarkLotteryDrawReq success|roleId=%d,lotteryType=%d,lotteryNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lotteryType), Integer.valueOf(this.lotteryNum) });
/*     */     
/*     */ 
/* 183 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 186 */     PetMarkTLogManager.addPetMarkLotteryTLog(this.roleId, this.lotteryType, this.lotteryNum, (int)newToken, proto.new_pet_mark_item_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 193 */     SPetMarkLotteryDrawFail proto = new SPetMarkLotteryDrawFail();
/* 194 */     proto.error_code = errorCode;
/* 195 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 198 */     String logstr = String.format("[petmark]PCPetMarkLotteryDrawReq.onFail@PCPetMarkLotteryDrawReq failed|roleId=%d,lotteryType=%d,lotteryNum=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lotteryType), Integer.valueOf(this.lotteryNum), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 201 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkLotteryDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */