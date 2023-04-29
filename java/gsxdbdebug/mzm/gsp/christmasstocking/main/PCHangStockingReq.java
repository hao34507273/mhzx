/*     */ package mzm.gsp.christmasstocking.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*     */ import mzm.gsp.christmasstocking.SHangStockingFail;
/*     */ import mzm.gsp.christmasstocking.SHangStockingSuccess;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChristmasTreePositionInfo;
/*     */ import xbean.HangStockingHistoryInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2ChristmasStockingInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCHangStockingReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long targetRoleId;
/*     */   private final int position;
/*     */   
/*     */   public PCHangStockingReq(long roleId, long targetRoleId, int position)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.targetRoleId = targetRoleId;
/*  38 */     this.position = position;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!ChristmasStockingManager.isChristmasStockingOpen(this.roleId))
/*     */     {
/*  47 */       String logstr = String.format("[christmasstocking]PCHangStockingReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  49 */       GameServer.logger().info(logstr);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2232, true))
/*     */     {
/*  56 */       String logstr = String.format("[christmasstocking]PCGetStockingInfoReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  58 */       GameServer.logger().info(logstr);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!RoleInterface.isRoleExit(this.targetRoleId))
/*     */     {
/*  65 */       onFail(-9);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     String userId = RoleInterface.getUserId(this.roleId);
/*  71 */     if (null == userId)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     lock(Lockeys.get(User.getTable(), userId));
/*  76 */     lock(Lockeys.get(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) })));
/*     */     
/*     */ 
/*  79 */     int activityId = SChristmasStockingConsts.getInstance().ACTIVITY_ID;
/*  80 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin())
/*     */     {
/*  82 */       onFail(-1);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     if (MapInterface.getRoleWorldInstanceId(this.roleId) != mzm.gsp.homeland.main.HomelandInterface.getHomeWorldIdByRoleId(this.targetRoleId, true))
/*     */     {
/*     */ 
/*  90 */       onFail(-3);
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     if ((this.position < 1) || (this.position > SChristmasStockingConsts.getInstance().TREE_HANG_MAX_NUM))
/*     */     {
/*  97 */       onFail(-4);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     int consumeItemCfgId = SChristmasStockingConsts.getInstance().CONSUME_ITEM_ID;
/* 103 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.CHRISTMAS_STOCKING_HANG_COST);
/* 104 */     if (!ItemInterface.removeItemById(this.roleId, consumeItemCfgId, 1, logArg))
/*     */     {
/* 106 */       onFail(-6);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     Role2ChristmasStockingInfo xSelfRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(this.roleId);
/* 112 */     int selfTotalHangNum = ChristmasStockingManager.getTotalHangNum(xSelfRole2StockingInfo);
/* 113 */     if (selfTotalHangNum >= SChristmasStockingConsts.getInstance().ROLE_HANG_MAX_NUM)
/*     */     {
/* 115 */       onFail(-8);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     Integer oldNum = (Integer)xSelfRole2StockingInfo.getTargetroleid2selfhangnum().get(Long.valueOf(this.targetRoleId));
/* 121 */     if ((null != oldNum) && (oldNum.intValue() >= SChristmasStockingConsts.getInstance().ROLE_HANG_ON_ONE_TREE_MAX_NUM))
/*     */     {
/* 123 */       onFail(-7);
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 129 */     Role2ChristmasStockingInfo xTargetRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(this.targetRoleId);
/* 130 */     ChristmasStockingManager.tryOfferChristmasStockingAward(this.targetRoleId, xTargetRole2StockingInfo, true);
/* 131 */     int roleHangOnOwnTreeMaxNum = SChristmasStockingConsts.getInstance().ROLE_HANG_ON_OWN_TREE_NUM;
/* 132 */     int selfAlreadyHangForSelfNum = null == xSelfRole2StockingInfo.getTargetroleid2selfhangnum().get(Long.valueOf(this.roleId)) ? 0 : ((Integer)xSelfRole2StockingInfo.getTargetroleid2selfhangnum().get(Long.valueOf(this.roleId))).intValue();
/*     */     
/* 134 */     if (this.roleId == this.targetRoleId)
/*     */     {
/*     */ 
/* 137 */       if (selfAlreadyHangForSelfNum >= roleHangOnOwnTreeMaxNum)
/*     */       {
/* 139 */         onFail(-10);
/* 140 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 147 */       int targetRoleAlreadyHungByOthersNum = 0;
/* 148 */       for (ChristmasTreePositionInfo xTreePositionInfo : xTargetRole2StockingInfo.getChristmastreepositionindex2info().values())
/*     */       {
/* 150 */         long hangRoleId = xTreePositionInfo.getHangroleid();
/* 151 */         if ((hangRoleId != 0L) && (hangRoleId != this.targetRoleId) && (!xTreePositionInfo.getCanaward()))
/*     */         {
/* 153 */           targetRoleAlreadyHungByOthersNum++;
/*     */         }
/*     */       }
/*     */       
/* 157 */       if (targetRoleAlreadyHungByOthersNum >= SChristmasStockingConsts.getInstance().TREE_HANG_MAX_NUM - roleHangOnOwnTreeMaxNum)
/*     */       {
/* 159 */         onFail(-11);
/* 160 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 164 */       int roleHangForOthersMaxNum = SChristmasStockingConsts.getInstance().ROLE_HANG_MAX_NUM - roleHangOnOwnTreeMaxNum;
/* 165 */       if (selfTotalHangNum - selfAlreadyHangForSelfNum >= roleHangForOthersMaxNum)
/*     */       {
/* 167 */         onFail(-12);
/* 168 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 173 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 174 */     ChristmasTreePositionInfo xPositionInfo = Pod.newChristmasTreePositionInfo();
/* 175 */     xPositionInfo.setCanaward(false);
/* 176 */     xPositionInfo.setHangtime(currentTime);
/* 177 */     xPositionInfo.setHangroleid(this.roleId);
/*     */     
/* 179 */     if (null != xTargetRole2StockingInfo.getChristmastreepositionindex2info().put(Integer.valueOf(this.position), xPositionInfo))
/*     */     {
/* 181 */       onFail(-5);
/* 182 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 186 */     ChristmasStockingManager.updateMapEntityPositionState(this.targetRoleId, this.position, 2);
/*     */     
/*     */ 
/*     */ 
/* 190 */     HangStockingHistoryInfo xNewHistoryInfo = Pod.newHangStockingHistoryInfo();
/* 191 */     xNewHistoryInfo.setHangtime(currentTime);
/* 192 */     xNewHistoryInfo.setRoleid(this.roleId);
/* 193 */     xTargetRole2StockingInfo.getHangstockinghistoryinfos().add(xNewHistoryInfo);
/*     */     
/*     */ 
/* 196 */     int newNum = null == oldNum ? 1 : oldNum.intValue() + 1;
/* 197 */     xSelfRole2StockingInfo.getTargetroleid2selfhangnum().put(Long.valueOf(this.targetRoleId), Integer.valueOf(newNum));
/*     */     
/*     */ 
/* 200 */     ActivityInterface.addActivityCount(userId, this.roleId, activityId);
/*     */     
/*     */ 
/* 203 */     onSuccess(xSelfRole2StockingInfo, xNewHistoryInfo);
/*     */     
/* 205 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSuccess(Role2ChristmasStockingInfo xRole2StockingInfo, HangStockingHistoryInfo xNewHistoryInfo)
/*     */   {
/* 212 */     SHangStockingSuccess proto = new SHangStockingSuccess();
/* 213 */     proto.target_role_id = this.targetRoleId;
/* 214 */     proto.position = this.position;
/* 215 */     proto.new_history.role_id = this.roleId;
/* 216 */     proto.new_history.time = xNewHistoryInfo.getHangtime();
/*     */     try
/*     */     {
/* 219 */       proto.new_history.role_name.setString(RoleInterface.getName(this.roleId), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 224 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 227 */     String logstr = String.format("[christmasstocking]PCHangStockingReq.onSuccess@PCHangStockingReq success|roleId=%d,targetRoleId=%d,position=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Integer.valueOf(this.position) });
/*     */     
/*     */ 
/* 230 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 233 */     addPetMarkAddTLog(ChristmasStockingManager.getTotalHangNum(xRole2StockingInfo), ((Integer)xRole2StockingInfo.getTargetroleid2selfhangnum().get(Long.valueOf(this.targetRoleId))).intValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addPetMarkAddTLog(int totalHangNum, int hangNumToTargetRole)
/*     */   {
/* 245 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/* 246 */     String userid = RoleInterface.getUserId(this.roleId);
/* 247 */     int rolelevel = RoleInterface.getLevel(this.roleId);
/* 248 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(rolelevel), Long.valueOf(this.targetRoleId), Integer.valueOf(this.position), Integer.valueOf(totalHangNum), Integer.valueOf(hangNumToTargetRole) });
/*     */     
/* 250 */     TLogManager.getInstance().addLog(this.roleId, "ChristmasStockingHang", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 256 */     SHangStockingFail proto = new SHangStockingFail();
/* 257 */     proto.error_code = errorCode;
/* 258 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 261 */     String logstr = String.format("[christmasstocking]PCHangStockingReq.onFail@PCHangStockingReq failed|roleId=%d,targetRoleId=%d,position=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Integer.valueOf(this.position), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 264 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\PCHangStockingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */