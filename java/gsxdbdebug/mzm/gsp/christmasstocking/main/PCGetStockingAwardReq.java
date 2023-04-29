/*     */ package mzm.gsp.christmasstocking.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.christmasstocking.SGetStockingAwardFail;
/*     */ import mzm.gsp.christmasstocking.SGetStockingAwardSuccess;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChristmasTreePositionInfo;
/*     */ import xbean.Role2ChristmasStockingInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetStockingAwardReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int position;
/*     */   
/*     */   public PCGetStockingAwardReq(long roleId, int position)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.position = position;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!ChristmasStockingManager.isChristmasStockingOpen(this.roleId))
/*     */     {
/*  46 */       String logstr = String.format("[christmasstocking]PCGetStockingAwardReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  48 */       GameServer.logger().info(logstr);
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2233, true))
/*     */     {
/*  55 */       String logstr = String.format("[christmasstocking]PCGetStockingAwardReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  57 */       GameServer.logger().info(logstr);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     if ((this.position < 1) || (this.position > SChristmasStockingConsts.getInstance().TREE_HANG_MAX_NUM))
/*     */     {
/*  64 */       onFail(-4);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     String userId = RoleInterface.getUserId(this.roleId);
/*  70 */     if (null == userId)
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     lock(Lockeys.get(User.getTable(), userId));
/*  75 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  78 */     int activityId = SChristmasStockingConsts.getInstance().ACTIVITY_ID;
/*  79 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId);
/*  80 */     if ((!joinResult.isCanJoin()) && (!joinResult.isActivityNotOpen()) && (!joinResult.isActivityJoinCountMax()))
/*     */     {
/*     */ 
/*  83 */       onFail(-1);
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (!ChristmasStockingManager.isActivityOpenOrNeedRetain())
/*     */     {
/*  90 */       onFail(-1);
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     if (!HomelandInterface.isAtHome(this.roleId, true))
/*     */     {
/*  97 */       onFail(-2);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     Role2ChristmasStockingInfo xRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(this.roleId);
/* 103 */     ChristmasStockingManager.tryOfferChristmasStockingAward(this.roleId, xRole2StockingInfo, true);
/*     */     
/*     */ 
/* 106 */     ChristmasTreePositionInfo xPositionInfo = (ChristmasTreePositionInfo)xRole2StockingInfo.getChristmastreepositionindex2info().get(Integer.valueOf(this.position));
/*     */     
/* 108 */     if ((null == xPositionInfo) || (!xPositionInfo.getCanaward()))
/*     */     {
/* 110 */       onFail(-4);
/* 111 */       return false;
/*     */     }
/* 113 */     xRole2StockingInfo.getChristmastreepositionindex2info().remove(Integer.valueOf(this.position));
/*     */     
/*     */ 
/* 116 */     int awardId = SChristmasStockingConsts.getInstance().AWARD_ID;
/* 117 */     AwardModel awardModel = AwardInterface.award(awardId, userId, this.roleId, true, true, new AwardReason(LogReason.CHRISTMAS_STOCKING_AWARD));
/*     */     
/* 119 */     if (null == awardModel)
/*     */     {
/* 121 */       String logstr = String.format("[christmasstocking]PCGetStockingAwardReq.processImp@offer award fail|roleId=%d,awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(awardId) });
/*     */       
/*     */ 
/* 124 */       GameServer.logger().info(logstr);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     ChristmasStockingManager.updateMapEntityPositionState(this.roleId, this.position, 1);
/*     */     
/*     */ 
/*     */ 
/* 133 */     onSuccess(awardId, awardModel.getItemMap());
/*     */     
/* 135 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(int awardId, Map<Integer, Integer> itemMap)
/*     */   {
/* 141 */     SGetStockingAwardSuccess proto = new SGetStockingAwardSuccess();
/* 142 */     proto.position = this.position;
/* 143 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 146 */     for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*     */     {
/* 148 */       ChristmasStockingManager.sendAwardBulletin(this.roleId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */     }
/*     */     
/*     */ 
/* 152 */     String logstr = String.format("[christmasstocking]PCGetStockingAwardReq.onSuccess@PCGetStockingAwardReq success|roleId=%d,position=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position) });
/*     */     
/*     */ 
/* 155 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 158 */     addPetMarkAddTLog(awardId);
/*     */   }
/*     */   
/*     */   private void addPetMarkAddTLog(int awardId)
/*     */   {
/* 163 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 164 */     String userid = RoleInterface.getUserId(this.roleId);
/* 165 */     int rolelevel = RoleInterface.getLevel(this.roleId);
/* 166 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(rolelevel), Integer.valueOf(this.position), Integer.valueOf(awardId) });
/*     */     
/* 168 */     TLogManager.getInstance().addLog(this.roleId, "ChristmasStockingGetAward", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 174 */     SGetStockingAwardFail proto = new SGetStockingAwardFail();
/* 175 */     proto.error_code = errorCode;
/* 176 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 179 */     String logstr = String.format("[christmasstocking]PCGetStockingAwardReq.onFail@PCGetStockingAwardReq failed|roleId=%d,position=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 182 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\PCGetStockingAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */