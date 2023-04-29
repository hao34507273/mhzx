/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.PlantTreeLog;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnlineRewardPoint extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public POnlineRewardPoint(long roleid, int activityCfgid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!OnlineManager.getInstance().isOnline(this.roleid))
/*     */     {
/*     */ 
/*  41 */       onFail(9, null, true);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  47 */       onFail(-1, null, true);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 916, true))
/*     */     {
/*     */ 
/*     */ 
/*  54 */       onFail(-2, null, true);
/*  55 */       return false;
/*     */     }
/*  57 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  58 */     if (cfg == null)
/*     */     {
/*     */ 
/*  61 */       onFail(-3, null, true);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userid = RoleInterface.getUserId(this.roleid);
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
/*  78 */       onFail(1, extraInfo, true);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  83 */     if (xRolePlantTreeInfo == null)
/*     */     {
/*     */ 
/*  86 */       onFail(-4, null, true);
/*  87 */       return false;
/*     */     }
/*  89 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*  90 */     if (xPlantTreeInfo == null)
/*     */     {
/*     */ 
/*  93 */       onFail(-4, null, true);
/*  94 */       return false;
/*     */     }
/*  96 */     if (xPlantTreeInfo.getSpecial_state_index() > 0)
/*     */     {
/*     */ 
/*  99 */       Map<String, Object> extraInfo = new HashMap();
/* 100 */       extraInfo.put("special_state", Integer.valueOf(xPlantTreeInfo.getSpecial_state_index()));
/* 101 */       onFail(7, extraInfo, true);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 106 */     if (DateTimeUtils.needDailyReset(xPlantTreeInfo.getOnline_reward_point_timestamp(), now, 0))
/*     */     {
/* 108 */       xPlantTreeInfo.setOnline_reward_point(0);
/* 109 */       xPlantTreeInfo.setOnline_reward_point_timestamp(now);
/*     */     }
/* 111 */     if (xPlantTreeInfo.getOnline_reward_point() >= cfg.online_reward_max_point)
/*     */     {
/*     */ 
/* 114 */       onFail(8, null, false);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     int activityNeedPoint = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo);
/* 119 */     if (activityNeedPoint <= 0)
/*     */     {
/*     */ 
/* 122 */       onFail(3, null, true);
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     xPlantTreeInfo.setOnline_reward_point(xPlantTreeInfo.getOnline_reward_point() + 1);
/* 127 */     xPlantTreeInfo.setOnline_reward_point_timestamp(now);
/*     */     
/* 129 */     int preSectionid = xPlantTreeInfo.getCurrent_section_id();
/* 130 */     int realAddPoint = Math.min(1, activityNeedPoint);
/* 131 */     PlantTreeManager.addActivityPoint(this.activityCfgid, xPlantTreeInfo, realAddPoint);
/* 132 */     int curSectionid = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) <= 0 ? xPlantTreeInfo.getCurrent_section_id() + 1 : xPlantTreeInfo.getCurrent_section_id();
/*     */     
/* 134 */     if (curSectionid == cfg.section_num + 1)
/*     */     {
/*     */ 
/* 137 */       OnlineRewardPointObserverManager.getInstance().stopObserver(this.roleid, this.activityCfgid);
/*     */     }
/*     */     
/* 140 */     List<PlantTreeLog> xPlantTreeLogs = new ArrayList();
/* 141 */     xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(1, Arrays.asList(new String[] { Integer.toString(preSectionid), "1" })));
/*     */     
/* 143 */     for (int i = preSectionid; i < curSectionid; i++)
/*     */     {
/* 145 */       xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(4, Arrays.asList(new String[] { Integer.toString(i) })));
/*     */     }
/*     */     
/* 148 */     PlantTreeManager.addPlantTreeLog(xPlantTreeInfo, xPlantTreeLogs);
/*     */     
/* 150 */     OnlineManager.getInstance().sendMulti(PlantTreeManager.fillPlantTreeBasicInfo(this.roleid, this.activityCfgid, xPlantTreeInfo), PlantTreeManager.getRelatedRoleids(cfg.activity_type, this.roleid));
/*     */     
/*     */ 
/* 153 */     OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeUpdateInfo(this.roleid, this.activityCfgid, xPlantTreeInfo, xPlantTreeLogs));
/*     */     
/*     */ 
/* 156 */     StringBuilder sb = new StringBuilder();
/* 157 */     sb.append(String.format("[planttree]POnlineRewardPoint.processImp@online reward point success|roleid=%d|activity_cfg_id=%d|current_section_id=%d|current_section_point=%d|special_state_index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()), xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id())), Integer.valueOf(xPlantTreeInfo.getSpecial_state_index()) }));
/*     */     
/*     */ 
/*     */ 
/* 161 */     PlantTreeManager.logger.info(sb.toString());
/* 162 */     PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.roleid, 1, xPlantTreeInfo.getCurrent_section_id(), ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue(), xPlantTreeInfo.getSpecial_state_index(), 1, -1, -1, -1);
/*     */     
/*     */ 
/*     */ 
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean needStopObserver)
/*     */   {
/* 171 */     StringBuilder sb = new StringBuilder();
/* 172 */     sb.append(String.format("[planttree]POnlineRewardPoint.processImp@online reward point fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 175 */     if (extraInfo != null)
/*     */     {
/* 177 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 179 */         sb.append("|").append((String)entry.getKey());
/* 180 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 183 */     PlantTreeManager.logger.info(sb.toString());
/* 184 */     if (needStopObserver)
/*     */     {
/*     */ 
/* 187 */       OnlineRewardPointObserverManager.getInstance().stopObserver(this.roleid, this.activityCfgid);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\POnlineRewardPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */