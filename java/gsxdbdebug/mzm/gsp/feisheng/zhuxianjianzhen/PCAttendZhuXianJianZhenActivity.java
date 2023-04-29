/*     */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.SAttendZhuXianJianZhenActivityFail;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendZhuXianJianZhenActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCAttendZhuXianJianZhenActivity(long roleid, int activityCfgid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ZhuXianJianZhenActivityManager.isFeiShengZhuXianJianZhenActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  42 */       onFail(-1, null);
/*  43 */       return false;
/*     */     }
/*  45 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(this.activityCfgid);
/*  46 */     if (cfg == null)
/*     */     {
/*     */ 
/*  49 */       onFail(-3, null);
/*  50 */       return false;
/*     */     }
/*  52 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  55 */       onFail(-5, null);
/*  56 */       return false;
/*     */     }
/*  58 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(cfg.npc_id, cfg.npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  61 */       onFail(-4, null);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  67 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  69 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  71 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  73 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  76 */       Map<String, Object> extraInfo = new HashMap();
/*  77 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  78 */       onFail(1, extraInfo);
/*  79 */       return false;
/*     */     }
/*  81 */     if (TeamInterface.isRoleInTeam(this.roleid, true))
/*     */     {
/*     */ 
/*  84 */       onFail(4, null);
/*  85 */       return false;
/*     */     }
/*  87 */     if (RoleStatusInterface.containsStatus(this.roleid, 959))
/*     */     {
/*     */ 
/*  90 */       onFail(-2, null);
/*  91 */       return false;
/*     */     }
/*  93 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  94 */     RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(this.roleid));
/*  95 */     if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*  97 */       xRoleFeiShengZhuXianJianZhenInfo = Pod.newRoleFeiShengZhuXianJianZhenInfo();
/*  98 */       Role_fei_sheng_zhu_xian_jian_zhen_infos.insert(Long.valueOf(this.roleid), xRoleFeiShengZhuXianJianZhenInfo);
/*     */     }
/* 100 */     FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/* 102 */     if (xFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/* 104 */       xFeiShengZhuXianJianZhenInfo = Pod.newFeiShengZhuXianJianZhenInfo();
/* 105 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 106 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/* 107 */       xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().put(Integer.valueOf(this.activityCfgid), xFeiShengZhuXianJianZhenInfo);
/*     */     }
/*     */     
/* 110 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 112 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 113 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 115 */     if (xFeiShengZhuXianJianZhenInfo.getDaily_try_times() >= cfg.daily_try_max_times)
/*     */     {
/*     */ 
/* 118 */       onFail(2, null);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (!RoleStatusInterface.setStatus(this.roleid, 959, true))
/*     */     {
/*     */ 
/* 125 */       onFail(-2, null);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     ZhuXianJianZhenActivityManager.onCollectItemStageStart(this.roleid, this.activityCfgid, xFeiShengZhuXianJianZhenInfo);
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 135 */     StringBuilder sb = new StringBuilder();
/* 136 */     sb.append(String.format("[feisheng]PCAttendZhuXianJianZhenActivity.processImp@attend zhu xian jian zhen activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 139 */     if (extraInfo != null)
/*     */     {
/* 141 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 143 */         sb.append("|").append((String)entry.getKey());
/* 144 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 147 */     FeiShengManager.logger.info(sb.toString());
/* 148 */     if (res > 0)
/*     */     {
/* 150 */       SAttendZhuXianJianZhenActivityFail protocol = new SAttendZhuXianJianZhenActivityFail();
/* 151 */       protocol.res = res;
/* 152 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\PCAttendZhuXianJianZhenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */