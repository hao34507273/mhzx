/*     */ package mzm.gsp.axe.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.axe.SSynAxeActivityInfo;
/*     */ import mzm.gsp.axe.SUnlockAxeActivityFail;
/*     */ import mzm.gsp.axe.confbean.SAxeAvtivityCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AxeActivityInfo;
/*     */ import xbean.UserAxeActivityInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ import xtable.User_axe_activity_infos;
/*     */ 
/*     */ public class PCUnlockAxeActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCUnlockAxeActivity(long roleid, int activityCfgid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!AxeManager.isAxeActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  41 */       onFail(-1, null);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1113, true))
/*     */     {
/*     */ 
/*  47 */       onFail(-2, null);
/*  48 */       return false;
/*     */     }
/*  50 */     SAxeAvtivityCfg cfg = SAxeAvtivityCfg.get(this.activityCfgid);
/*  51 */     if (cfg == null)
/*     */     {
/*     */ 
/*  54 */       onFail(-3, null);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  60 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  62 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  64 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  66 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  69 */       Map<String, Object> extraInfo = new HashMap();
/*  70 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  71 */       onFail(1, extraInfo);
/*  72 */       return false;
/*     */     }
/*  74 */     AxeManager.initData(userid, this.activityCfgid);
/*     */     
/*  76 */     UserAxeActivityInfo xUserAxeActivityInfo = User_axe_activity_infos.get(userid);
/*  77 */     if (xUserAxeActivityInfo == null)
/*     */     {
/*     */ 
/*  80 */       return false;
/*     */     }
/*  82 */     AxeActivityInfo xAxeActivityInfo = (AxeActivityInfo)xUserAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*  83 */     if (xAxeActivityInfo == null)
/*     */     {
/*     */ 
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  90 */     if (now - xAxeActivityInfo.getStart_timestamp() < cfg.lock_trigger_interval_in_day * 86400000L)
/*     */     {
/*     */ 
/*     */ 
/*  94 */       onFail(2, null);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     switch (cfg.unlock_cost_type)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 102 */       long yuanbao = QingfuInterface.getYuanbao(userid, true);
/* 103 */       if (yuanbao < cfg.unlock_cost_num)
/*     */       {
/*     */ 
/* 106 */         onFail(3, null);
/* 107 */         return false;
/*     */       }
/* 109 */       if (QingfuInterface.costYuanbao(userid, this.roleid, cfg.unlock_cost_num, mzm.gsp.qingfu.main.CostType.COST_AXE_ACTIVITY, new TLogArg(LogReason.AXE_UNLOCK_ACTIVITY_COST, this.activityCfgid)) != mzm.gsp.qingfu.main.CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/* 113 */         onFail(3, null);
/* 114 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     case 2: 
/* 120 */       long gold = RoleInterface.getGold(this.roleid);
/* 121 */       if (gold < cfg.unlock_cost_num)
/*     */       {
/*     */ 
/* 124 */         onFail(4, null);
/* 125 */         return false;
/*     */       }
/* 127 */       if (!RoleInterface.cutGold(this.roleid, cfg.unlock_cost_num, new TLogArg(LogReason.AXE_ATTEND_ACTIVITY_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 131 */         onFail(4, null);
/* 132 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     case 3: 
/* 138 */       long silver = RoleInterface.getSilver(this.roleid);
/* 139 */       if (silver < cfg.unlock_cost_num)
/*     */       {
/*     */ 
/* 142 */         onFail(5, null);
/* 143 */         return false;
/*     */       }
/* 145 */       if (!RoleInterface.cutSilver(this.roleid, cfg.unlock_cost_num, new TLogArg(LogReason.AXE_ATTEND_ACTIVITY_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 149 */         onFail(5, null);
/* 150 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     default: 
/* 157 */       onFail(-3, null);
/* 158 */       return false;
/*     */     }
/*     */     
/*     */     
/* 162 */     xAxeActivityInfo.setStart_timestamp(now);
/*     */     
/* 164 */     SSynAxeActivityInfo protocol = new SSynAxeActivityInfo();
/* 165 */     protocol.activity_infos.put(Integer.valueOf(this.activityCfgid), Integer.valueOf((int)(xAxeActivityInfo.getStart_timestamp() / 1000L)));
/* 166 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 168 */     StringBuilder sb = new StringBuilder();
/* 169 */     sb.append(String.format("[axe]PCUnlockAxeActivity.processImp@unlock axe activity success|roleid=%d|activity_cfg_id=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(now) }));
/*     */     
/*     */ 
/* 172 */     AxeManager.logger.info(sb.toString());
/* 173 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 178 */     StringBuilder sb = new StringBuilder();
/* 179 */     sb.append(String.format("[axe]PCUnlockAxeActivity.processImp@unlock axe activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 182 */     if (extraInfo != null)
/*     */     {
/* 184 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 186 */         sb.append("|").append((String)entry.getKey());
/* 187 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 190 */     AxeManager.logger.info(sb.toString());
/* 191 */     if (res > 0)
/*     */     {
/* 193 */       SUnlockAxeActivityFail protocol = new SUnlockAxeActivityFail();
/* 194 */       protocol.res = res;
/* 195 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\PCUnlockAxeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */