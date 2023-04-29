/*     */ package mzm.gsp.paynewyear.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.paynewyear.SPayNewYearNormalFail;
/*     */ import mzm.gsp.paynewyear.SPayNewYearSuccess;
/*     */ import mzm.gsp.paynewyear.SReceivePayNewYear;
/*     */ import mzm.gsp.paynewyear.confbean.SPayNewYearConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCPayNewYear extends LogicProcedure
/*     */ {
/*     */   private final long activeRoleId;
/*     */   private final long passiveRoleId;
/*     */   
/*     */   public PCPayNewYear(long activeRoleId, long passiveRoleId)
/*     */   {
/*  35 */     this.activeRoleId = activeRoleId;
/*  36 */     this.passiveRoleId = passiveRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.activeRoleId, 491, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!PayNewYearManager.isPayNewYearSwitchOpen(this.activeRoleId))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (this.activeRoleId == this.passiveRoleId)
/*     */     {
/*  54 */       onPayNewYearFailed(3);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String passiveUserId = RoleInterface.getUserId(this.passiveRoleId);
/*  59 */     String activeUserId = RoleInterface.getUserId(this.activeRoleId);
/*  60 */     if ((passiveUserId == null) || (activeUserId == null))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     lock(User.getTable(), Arrays.asList(new String[] { passiveUserId, activeUserId }));
/*  66 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/*  68 */     int roleLevel = RoleInterface.getLevel(this.activeRoleId);
/*  69 */     int paiedRoleLevel = RoleInterface.getLevel(this.passiveRoleId);
/*     */     
/*  71 */     int payNewYearActivityCfgId = SPayNewYearConsts.getInstance().pay_new_year_activity_cfg_id;
/*  72 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(activeUserId, this.activeRoleId, payNewYearActivityCfgId);
/*     */     
/*  74 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  76 */       Map<String, Object> extraMap = new HashMap();
/*  77 */       extraMap.put("reason_value", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/*  79 */       onPayNewYearFailed(1, extraMap);
/*     */       
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     boolean isCanPayNewYear = LotteryManager.canAdd(this.activeRoleId, 7);
/*  85 */     if (!isCanPayNewYear)
/*     */     {
/*  87 */       onPayNewYearFailed(2);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     ActivityInterface.addActivityCount(activeUserId, this.activeRoleId, payNewYearActivityCfgId);
/*     */     
/*  93 */     int activityJoinCount = ActivityInterface.getActivityCount(activeUserId, this.activeRoleId, payNewYearActivityCfgId, true);
/*     */     
/*     */ 
/*  96 */     SPayNewYearSuccess sPayNewYearSuccess = new SPayNewYearSuccess();
/*  97 */     sPayNewYearSuccess.role_name.setString(RoleInterface.getName(this.passiveRoleId), "UTF-8");
/*  98 */     sPayNewYearSuccess.aleardy_pay_new_year_times = activityJoinCount;
/*     */     
/* 100 */     if (activityJoinCount <= SPayNewYearConsts.getInstance().pay_new_year_award_times_every_day)
/*     */     {
/* 102 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(SPayNewYearConsts.getInstance().pay_new_year_award_class_id, this.activeRoleId, RoleInterface.getLevel(this.activeRoleId));
/*     */       
/*     */ 
/*     */ 
/* 106 */       for (Map.Entry<Integer, Integer> entry : awardPoolResultData.getItemMap().entrySet())
/*     */       {
/* 108 */         sPayNewYearSuccess.award_item_map.put(entry.getKey(), entry.getValue());
/*     */       }
/*     */       
/* 111 */       LotteryManager.addLottery(this.activeRoleId, 7, 0, awardPoolResultData, new TLogArg(LogReason.PAY_NEW_YEAR_AWARD), SPayNewYearConsts.getInstance().pay_new_year_delay_award_seconds);
/*     */     }
/*     */     
/*     */ 
/* 115 */     OnlineManager.getInstance().send(this.activeRoleId, sPayNewYearSuccess);
/*     */     
/* 117 */     SReceivePayNewYear sReceivePayNewYear = new SReceivePayNewYear();
/* 118 */     sReceivePayNewYear.role_id = this.activeRoleId;
/* 119 */     sReceivePayNewYear.role_name.setString(RoleInterface.getName(this.activeRoleId), "UTF-8");
/*     */     
/* 121 */     OnlineManager.getInstance().send(this.passiveRoleId, sReceivePayNewYear);
/*     */     
/* 123 */     PayNewYearManager.tlogPayNewYearTimes(activeUserId, this.activeRoleId, roleLevel, passiveUserId, this.passiveRoleId, paiedRoleLevel, activityJoinCount);
/*     */     
/*     */ 
/* 126 */     GameServer.logger().info(String.format("[paynewyear]PCPayNewYear.processImp@handle pay new year success|active_role_id=%d|passive_role_id=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private void onPayNewYearFailed(int ret)
/*     */   {
/* 135 */     onPayNewYearFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onPayNewYearFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 140 */     SPayNewYearNormalFail sPayNewYearNormalFail = new SPayNewYearNormalFail();
/* 141 */     sPayNewYearNormalFail.result = ret;
/*     */     
/* 143 */     StringBuilder sbLog = new StringBuilder();
/* 144 */     sbLog.append("[paynewyear]PCPayNewYear.processImp@buy lucky star failed");
/* 145 */     sbLog.append("|ret=").append(ret);
/*     */     
/* 147 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 149 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 151 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 154 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 156 */     OnlineManager.getInstance().sendAtOnce(this.activeRoleId, sPayNewYearNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paynewyear\main\PCPayNewYear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */