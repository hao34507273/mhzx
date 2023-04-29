/*     */ package mzm.gsp.xiaohuikuaipao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.xiaohuikuaipao.AwardInfo;
/*     */ import mzm.gsp.xiaohuikuaipao.SInnerDrawError;
/*     */ import mzm.gsp.xiaohuikuaipao.SInnerDrawRsp;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.XiaoHuiKuaiPaoInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCInnerDrawReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   
/*     */   public PCInnerDrawReq(long roleId, int activityId)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!OpenInterface.getOpenStatus(482))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1841, true))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/*  57 */     if (activityCfg == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg = XiaoHuiKuaiPaoActivityCfg.get(this.activityId);
/*  62 */     if (xiaoHuiKuaiPaoActivityCfg == null)
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  67 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  68 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  69 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*     */     
/*  71 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = XiaoHuiKuaiPaoManager.getXiaoHuiKuaiPaoInfo(this.roleId, this.activityId, xiaoHuiKuaiPaoActivityCfg);
/*     */     
/*     */ 
/*  80 */     int tLog_lastTicketCount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/*  81 */     Collection<Integer> tLog_lastHitIndexList = new ArrayList(xXiaoHuiKuaiPaoInfo.getHitindexes().size());
/*  82 */     tLog_lastHitIndexList.addAll(xXiaoHuiKuaiPaoInfo.getHitindexes());
/*     */     
/*  84 */     Collection<Integer> tLog_lastHitRandomTextTableTypeIdList = new ArrayList(xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids().size());
/*     */     
/*  86 */     tLog_lastHitRandomTextTableTypeIdList.addAll(xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids());
/*     */     
/*  88 */     SInnerDrawError innerDrawError = new SInnerDrawError();
/*  89 */     innerDrawError.activityid = this.activityId;
/*     */     
/*  91 */     if (xXiaoHuiKuaiPaoInfo.getTicketcount() < xiaoHuiKuaiPaoActivityCfg.ticketCount)
/*     */     {
/*  93 */       innerDrawError.errorcode = 1;
/*  94 */       OnlineManager.getInstance().sendAtOnce(this.roleId, innerDrawError);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(xiaoHuiKuaiPaoActivityCfg.lotteryViewCfgId);
/*     */     
/* 101 */     if (lotteryViewRandomCfg == null)
/*     */     {
/* 103 */       return false;
/*     */     }
/* 105 */     AwardPoolResultData awardPoolResultData = XiaoHuiKuaiPaoManager.getInnerDrawAwardPoolResultData(this.roleId, xXiaoHuiKuaiPaoInfo, xiaoHuiKuaiPaoActivityCfg, lotteryViewRandomCfg);
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
/* 123 */     Map<Integer, Integer> bagId2NeedGridNum = AwardPoolInterface.getBagId2LotteryNeedGrid(xiaoHuiKuaiPaoActivityCfg.lotteryViewCfgId);
/* 124 */     GameServer.logger().info(String.format("[xiaohuikuaipao]PCInnerDrawReq roleId[%d]awardTypeId[%d]maxNeedGridNum[%s]", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(awardPoolResultData.getTypeId()), bagId2NeedGridNum }));
/*     */     
/*     */ 
/* 127 */     if (AwardPoolInterface.checkGridNum(this.roleId, bagId2NeedGridNum, true, true) > 0)
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     boolean ret = LotteryManager.addLottery(this.roleId, 11, 0, awardPoolResultData, new TLogArg(mzm.gsp.tlog.LogReason.XIAO_HUI_KUAI_PAO_INNER_DRAW));
/*     */     
/* 135 */     if (!ret)
/*     */     {
/* 137 */       innerDrawError.errorcode = 3;
/* 138 */       OnlineManager.getInstance().sendAtOnce(this.roleId, innerDrawError);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     SInnerDrawRsp innerDrawRsp = new SInnerDrawRsp();
/* 143 */     innerDrawRsp.activityid = this.activityId;
/* 144 */     innerDrawRsp.hitindex = awardPoolResultData.getIndex();
/* 145 */     innerDrawRsp.innerinfo.hitindexes.addAll(xXiaoHuiKuaiPaoInfo.getHitindexes());
/* 146 */     innerDrawRsp.innerinfo.ticketcount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/* 147 */     innerDrawRsp.awardinfo.itemmap.putAll(awardPoolResultData.getItemMap());
/*     */     
/* 149 */     OnlineManager.getInstance().send(this.roleId, innerDrawRsp);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 156 */     XiaoHuiKuaiPaoTLogManager.tLogInnerDraw(this.roleId, this.activityId, innerDrawRsp.hitindex, awardPoolResultData.getTypeId(), innerDrawRsp.awardinfo.itemmap, tLog_lastTicketCount, xXiaoHuiKuaiPaoInfo.getTicketcount(), tLog_lastHitIndexList, xXiaoHuiKuaiPaoInfo.getHitindexes(), tLog_lastHitRandomTextTableTypeIdList, xXiaoHuiKuaiPaoInfo.getHitrandomtexttabletypeids());
/*     */     
/*     */ 
/*     */ 
/* 160 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PCInnerDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */