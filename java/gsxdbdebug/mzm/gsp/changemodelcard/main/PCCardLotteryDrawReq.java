/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.changemodelcard.CardItemInfo;
/*     */ import mzm.gsp.changemodelcard.SCardLotteryDrawFail;
/*     */ import mzm.gsp.changemodelcard.SCardLotteryDrawSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class PCCardLotteryDrawReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int lotteryCount;
/*     */   
/*     */   public PCCardLotteryDrawReq(long roleId, int lotteryCount)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.lotteryCount = lotteryCount;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  45 */       String logstr = String.format("[changemodelcard]PCCardLotteryDrawReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       GameServer.logger().info(logstr);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1978, true))
/*     */     {
/*  54 */       String logstr = String.format("[changemodelcard]PCCardLotteryDrawReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  56 */       GameServer.logger().info(logstr);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */     int needScore;
/*     */     
/*  62 */     if (this.lotteryCount == 1)
/*     */     {
/*  64 */       needScore = SChangeModelCardConsts.getInstance().LOTTERY_COST;
/*     */     } else { int needScore;
/*  66 */       if (this.lotteryCount == 10)
/*     */       {
/*  68 */         needScore = SChangeModelCardConsts.getInstance().TEN_LOTTERY_COST;
/*     */       }
/*     */       else
/*     */       {
/*  72 */         onFail(-2);
/*  73 */         return false;
/*     */       }
/*     */     }
/*     */     int needScore;
/*  77 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  79 */       onFail(-1);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     TLogArg costLogArg = new TLogArg(LogReason.CHANGE_MODEL_CARD_LOTTERY_COST);
/*  85 */     JifenOperateResult res = MallInterface.cutJifen(this.roleId, needScore, 10, costLogArg);
/*     */     
/*  87 */     if (!res.isSuccess())
/*     */     {
/*  89 */       onFail(-3);
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     int lotteryPoolTypeId = SChangeModelCardConsts.getInstance().LOTTERY_AWARD_POOL_TYPE_ID;
/*  95 */     Map<Integer, Integer> bagId2NeedGridNum = AwardPoolInterface.getBagId2MaxNeedGridNum(lotteryPoolTypeId);
/*  96 */     if (AwardPoolInterface.checkGridNum(this.roleId, bagId2NeedGridNum, this.lotteryCount, true, true) > 0)
/*     */     {
/*     */ 
/*  99 */       String logstr = String.format("[changemodelcard]PCCardLotteryDrawReq.onSuccess@PCCardLotteryDrawReq failed, grid not enough|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/* 102 */       GameServer.logger().info(logstr);
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     List<AwardPoolResultData> resultDatas = new LinkedList();
/* 108 */     for (int i = 0; i < this.lotteryCount; i++)
/*     */     {
/* 110 */       AwardPoolResultData resultData = AwardPoolInterface.getAwardPoolData(lotteryPoolTypeId, this.roleId, RoleInterface.getLevel(this.roleId));
/*     */       
/*     */ 
/* 113 */       resultDatas.add(resultData);
/*     */     }
/*     */     
/*     */ 
/* 117 */     int delayTime = SChangeModelCardConsts.getInstance().LOTTERY_ANIMATION_DURATION;
/* 118 */     boolean ret = LotteryManager.addLottery(this.roleId, 13, 0, resultDatas, new TLogArg(LogReason.CHANGE_MODEL_CARD_LOTTERY_AWARD), delayTime);
/*     */     
/* 120 */     if (!ret)
/*     */     {
/* 122 */       onFail(-5);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     onSuccess(resultDatas);
/*     */     
/* 129 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(List<AwardPoolResultData> resultDatas)
/*     */   {
/* 138 */     SCardLotteryDrawSuccess protocol = new SCardLotteryDrawSuccess();
/* 139 */     for (AwardPoolResultData resultData : resultDatas)
/*     */     {
/* 141 */       for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet())
/*     */       {
/* 143 */         protocol.new_card_item_infos.add(new CardItemInfo(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()));
/*     */       }
/*     */     }
/* 146 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 149 */     long newScore = MallInterface.getJifen(this.roleId, 10);
/* 150 */     String logstr = String.format("[changemodelcard]PCCardLotteryDrawReq.onSuccess@PCCardLotteryDrawReq success|roleId=%d,lotteryCount=%d,newScore=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lotteryCount), Long.valueOf(newScore) });
/*     */     
/*     */ 
/* 153 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 156 */     ChangeModelCardTLogManager.addChangeModelCardLotteryTlog(this.roleId, this.lotteryCount, newScore, protocol.new_card_item_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 168 */     SCardLotteryDrawFail proto = new SCardLotteryDrawFail();
/* 169 */     proto.error_code = errorCode;
/* 170 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 173 */     String logstr = String.format("[changemodelcard]PCCardLotteryDrawReq.onFail@PCCardLotteryDrawReq failed|errorCode=%d,roleId=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId) });
/*     */     
/*     */ 
/* 176 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCCardLotteryDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */