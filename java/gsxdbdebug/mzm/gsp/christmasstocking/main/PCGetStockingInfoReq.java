/*     */ package mzm.gsp.christmasstocking.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*     */ import mzm.gsp.christmasstocking.HangStockingHistory;
/*     */ import mzm.gsp.christmasstocking.SGetStockingInfoFail;
/*     */ import mzm.gsp.christmasstocking.SGetStockingInfoSuccess;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChristmasTreePositionInfo;
/*     */ import xbean.HangStockingHistoryInfo;
/*     */ import xbean.Role2ChristmasStockingInfo;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class PCGetStockingInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final long targetRoleId;
/*     */   
/*     */   public PCGetStockingInfoReq(long roleId, long targetRoleId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.targetRoleId = targetRoleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ChristmasStockingManager.isChristmasStockingOpen(this.roleId))
/*     */     {
/*  41 */       String logstr = String.format("[christmasstocking]PCGetStockingInfoReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  43 */       GameServer.logger().info(logstr);
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2231, true))
/*     */     {
/*  50 */       String logstr = String.format("[christmasstocking]PCGetStockingInfoReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  52 */       GameServer.logger().info(logstr);
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     if (!RoleInterface.isRoleExit(this.targetRoleId))
/*     */     {
/*  59 */       onFail(-4);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     Collection<HangStockingHistory> historys = getHistorys(this.targetRoleId);
/*     */     
/*     */ 
/*  67 */     String userId = RoleInterface.getUserId(this.roleId);
/*  68 */     if (null == userId)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*  73 */     lock(Lockeys.get(xtable.Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) })));
/*     */     
/*     */ 
/*  76 */     int activityId = SChristmasStockingConsts.getInstance().ACTIVITY_ID;
/*  77 */     ActivityJoinResult joinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId);
/*  78 */     if ((!joinResult.isCanJoin()) && (!joinResult.isActivityNotOpen()) && (!joinResult.isActivityJoinCountMax()))
/*     */     {
/*  80 */       onFail(-1);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     if (!ChristmasStockingManager.isActivityOpenOrNeedRetain())
/*     */     {
/*  87 */       onFail(-1);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if (MapInterface.getRoleWorldInstanceId(this.roleId) != mzm.gsp.homeland.main.HomelandInterface.getHomeWorldIdByRoleId(this.targetRoleId, true))
/*     */     {
/*     */ 
/*  95 */       onFail(-3);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     Role2ChristmasStockingInfo xTargetRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(this.targetRoleId);
/* 101 */     ChristmasStockingManager.tryOfferChristmasStockingAward(this.targetRoleId, xTargetRole2StockingInfo, true);
/*     */     
/*     */ 
/* 104 */     Role2ChristmasStockingInfo xSelfRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(this.roleId);
/* 105 */     onSuccess(xSelfRole2StockingInfo, xTargetRole2StockingInfo, historys);
/*     */     
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSuccess(Role2ChristmasStockingInfo xSelfRole2StockingInfo, Role2ChristmasStockingInfo xTargetRole2StockingInfo, Collection<HangStockingHistory> historys)
/*     */   {
/* 114 */     SGetStockingInfoSuccess proto = new SGetStockingInfoSuccess();
/* 115 */     proto.target_role_id = this.targetRoleId;
/*     */     try
/*     */     {
/* 118 */       proto.target_role_name.setString(RoleInterface.getName(this.targetRoleId), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 123 */     Integer selfHangNum = (Integer)xSelfRole2StockingInfo.getTargetroleid2selfhangnum().get(Long.valueOf(this.targetRoleId));
/* 124 */     proto.self_hang_num = (null == selfHangNum ? 0 : selfHangNum.intValue());
/* 125 */     for (int i = 1; i <= SChristmasStockingConsts.getInstance().TREE_HANG_MAX_NUM; i++)
/*     */     {
/*     */ 
/* 128 */       ChristmasTreePositionInfo xTreePositionInfo = (ChristmasTreePositionInfo)xTargetRole2StockingInfo.getChristmastreepositionindex2info().get(Integer.valueOf(i));
/*     */       int state;
/* 130 */       int state; if (null == xTreePositionInfo)
/*     */       {
/* 132 */         state = 1;
/*     */       } else { int state;
/* 134 */         if (xTreePositionInfo.getCanaward())
/*     */         {
/* 136 */           state = 3;
/*     */         }
/*     */         else
/*     */         {
/* 140 */           state = 2; }
/*     */       }
/* 142 */       proto.position_state.put(Integer.valueOf(i), Integer.valueOf(state));
/*     */     }
/* 144 */     proto.historys.addAll(historys);
/*     */     
/* 146 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 149 */     String logstr = String.format("[christmasstocking]PCGetStockingInfoReq.onSuccess@PCGetStockingInfoReq success|roleId=%d,targetRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) });
/*     */     
/*     */ 
/* 152 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Collection<HangStockingHistory> getHistorys(long roleId)
/*     */   {
/* 163 */     Role2ChristmasStockingInfo xRole2StockingInfo = xtable.Role2christmasstockinginfo.select(Long.valueOf(roleId));
/* 164 */     Collection<HangStockingHistory> result = new java.util.LinkedList();
/* 165 */     if (null == xRole2StockingInfo)
/*     */     {
/* 167 */       return result;
/*     */     }
/* 169 */     for (HangStockingHistoryInfo xHistoryInfo : xRole2StockingInfo.getHangstockinghistoryinfos())
/*     */     {
/* 171 */       HangStockingHistory history = new HangStockingHistory();
/* 172 */       history.role_id = xHistoryInfo.getRoleid();
/* 173 */       history.time = xHistoryInfo.getHangtime();
/*     */       try
/*     */       {
/* 176 */         history.role_name.setString(RoleInterface.getName(xHistoryInfo.getRoleid()), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/* 181 */       result.add(history);
/*     */     }
/* 183 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 189 */     SGetStockingInfoFail proto = new SGetStockingInfoFail();
/* 190 */     proto.error_code = errorCode;
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 194 */     String logstr = String.format("[christmasstocking]PCGetStockingInfoReq.onFail@PCGetStockingInfoReq failed|roleId=%d,targetRoleId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 197 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\PCGetStockingInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */