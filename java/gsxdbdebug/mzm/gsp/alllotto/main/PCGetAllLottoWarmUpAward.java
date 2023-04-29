/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.alllotto.SGetAllLottoWarmUpAwardFail;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoConsts;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoWarmUpInfo;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleAllLottoActivityInfo;
/*     */ import xbean.RoleAllLottoInfo;
/*     */ import xbean.RoleAllLottoWarmUpInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_all_lotto_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAllLottoWarmUpAward extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int warmUpTurn;
/*     */   
/*     */   public PCGetAllLottoWarmUpAward(long roleid, int activityCfgid, int warmUpTurn)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.activityCfgid = activityCfgid;
/*  40 */     this.warmUpTurn = warmUpTurn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/*  47 */     if (cfg == null)
/*     */     {
/*     */ 
/*  50 */       onFail(-3, null);
/*  51 */       return false;
/*     */     }
/*  53 */     SAllLottoWarmUpInfo warmUpInfo = (SAllLottoWarmUpInfo)cfg.warm_up_infos.get(Integer.valueOf(this.warmUpTurn));
/*  54 */     if (warmUpInfo == null)
/*     */     {
/*     */ 
/*  57 */       onFail(-3, null);
/*  58 */       return false;
/*     */     }
/*  60 */     if (!AllLottoManager.isAllLottoSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  63 */       onFail(-1, null);
/*  64 */       return false;
/*     */     }
/*  66 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 2031, true))
/*     */     {
/*     */ 
/*  69 */       onFail(-2, null);
/*  70 */       return false;
/*     */     }
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  74 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  76 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  77 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  79 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  82 */       Map<String, Object> extraInfo = new HashMap();
/*  83 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  84 */       onFail(1, extraInfo);
/*  85 */       return false;
/*     */     }
/*  87 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/*  88 */     if ((currTimeInMillis < warmUpInfo.timestamp * 1000L) || (currTimeInMillis >= (warmUpInfo.timestamp + SAllLottoConsts.getInstance().WARM_UP_AWARD_VAILD_DURATION_IN_SECOND + SAllLottoConsts.getInstance().WARM_UP_AWARD_PROTECT_DURATION_IN_SECOND) * 1000L))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  93 */       onFail(2, null);
/*  94 */       return false;
/*     */     }
/*  96 */     RoleAllLottoInfo xRoleAllLottoInfo = Role_all_lotto_infos.get(Long.valueOf(this.roleid));
/*  97 */     if (xRoleAllLottoInfo == null)
/*     */     {
/*  99 */       xRoleAllLottoInfo = Pod.newRoleAllLottoInfo();
/* 100 */       Role_all_lotto_infos.insert(Long.valueOf(this.roleid), xRoleAllLottoInfo);
/*     */     }
/* 102 */     RoleAllLottoActivityInfo xRoleAllLottoActivityInfo = (RoleAllLottoActivityInfo)xRoleAllLottoInfo.getActivity_infos().get(Integer.valueOf(this.activityCfgid));
/* 103 */     if (xRoleAllLottoActivityInfo == null)
/*     */     {
/* 105 */       xRoleAllLottoActivityInfo = Pod.newRoleAllLottoActivityInfo();
/* 106 */       xRoleAllLottoInfo.getActivity_infos().put(Integer.valueOf(this.activityCfgid), xRoleAllLottoActivityInfo);
/*     */     }
/* 108 */     RoleAllLottoWarmUpInfo xRoleAllLottoWarmUpInfo = (RoleAllLottoWarmUpInfo)xRoleAllLottoActivityInfo.getWarm_up_infos().get(Integer.valueOf(this.warmUpTurn));
/* 109 */     if (xRoleAllLottoWarmUpInfo == null)
/*     */     {
/* 111 */       xRoleAllLottoWarmUpInfo = Pod.newRoleAllLottoWarmUpInfo();
/* 112 */       xRoleAllLottoActivityInfo.getWarm_up_infos().put(Integer.valueOf(this.warmUpTurn), xRoleAllLottoWarmUpInfo);
/*     */     }
/* 114 */     if (xRoleAllLottoWarmUpInfo.getAwarded())
/*     */     {
/*     */ 
/* 117 */       onFail(3, null);
/* 118 */       return false;
/*     */     }
/* 120 */     xRoleAllLottoWarmUpInfo.setAwarded(true);
/* 121 */     if (warmUpInfo.warm_up_fix_award_id > 0)
/*     */     {
/* 123 */       AwardReason awardReason = new AwardReason(LogReason.ALL_LOTTO_WARM_UP_AWARD, this.activityCfgid);
/* 124 */       mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(warmUpInfo.warm_up_fix_award_id, userid, this.roleid, false, true, awardReason);
/*     */       
/* 126 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 129 */         onFail(4, null);
/* 130 */         return false;
/*     */       }
/*     */     }
/* 133 */     GameServer.logger().info(String.format("[alllotto]PCGetAllLottoWarmUpAward.processImp@get all lotto warm up award success|roleid=%d|activity_cfg_id=%d|warm_up_turn=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.warmUpTurn) }));
/*     */     
/*     */ 
/*     */ 
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 142 */     StringBuilder sb = new StringBuilder();
/* 143 */     sb.append(String.format("[alllotto]PCGetAllLottoWarmUpAward.processImp@get all lotto warm up award fail|roleid=%d|activity_cfg_id=%d|warm_up_turn=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.warmUpTurn), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 146 */     if (extraInfo != null)
/*     */     {
/* 148 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 150 */         sb.append("|").append((String)entry.getKey());
/* 151 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 154 */     GameServer.logger().info(sb.toString());
/* 155 */     if (res > 0)
/*     */     {
/* 157 */       SGetAllLottoWarmUpAwardFail protocol = new SGetAllLottoWarmUpAwardFail();
/* 158 */       protocol.res = res;
/* 159 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\PCGetAllLottoWarmUpAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */