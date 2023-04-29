/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.PlantTreeLog;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PRefreshSpecialState extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PRefreshSpecialState(long roleid, int activityCfgid)
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
/*  41 */       onFail(9, null);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  47 */       onFail(-1, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 917, true))
/*     */     {
/*     */ 
/*  53 */       onFail(-2, null);
/*  54 */       return false;
/*     */     }
/*  56 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  57 */     if (cfg == null)
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  66 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  68 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  70 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  72 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  75 */       Map<String, Object> extraInfo = new HashMap();
/*  76 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  77 */       onFail(1, extraInfo);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  82 */     if (xRolePlantTreeInfo == null)
/*     */     {
/*  84 */       onFail(-4, null);
/*  85 */       return false;
/*     */     }
/*  87 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*  88 */     if (xPlantTreeInfo == null)
/*     */     {
/*  90 */       onFail(-4, null);
/*  91 */       return false;
/*     */     }
/*  93 */     if (xPlantTreeInfo.getSpecial_state_index() > 0)
/*     */     {
/*  95 */       onFail(7, null);
/*  96 */       return false;
/*     */     }
/*  98 */     xPlantTreeInfo.setSpecial_state_index(Xdb.random().nextInt(cfg.special_state_num) + 1);
/*  99 */     xPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/*     */     
/* 101 */     OnlineRewardPointObserverManager.getInstance().stopObserver(this.roleid, this.activityCfgid);
/*     */     
/* 103 */     int curSectionid = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) <= 0 ? xPlantTreeInfo.getCurrent_section_id() + 1 : xPlantTreeInfo.getCurrent_section_id();
/*     */     
/* 105 */     List<PlantTreeLog> xPlantTreeLogs = new ArrayList();
/* 106 */     xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(5, Arrays.asList(new String[] { Integer.toString(curSectionid), Integer.toString(xPlantTreeInfo.getSpecial_state_index()) })));
/*     */     
/* 108 */     PlantTreeManager.addPlantTreeLog(xPlantTreeInfo, xPlantTreeLogs);
/*     */     
/* 110 */     OnlineManager.getInstance().sendMulti(PlantTreeManager.fillPlantTreeBasicInfo(this.roleid, this.activityCfgid, xPlantTreeInfo), PlantTreeManager.getRelatedRoleids(cfg.activity_type, this.roleid));
/*     */     
/*     */ 
/* 113 */     OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeUpdateInfo(this.roleid, this.activityCfgid, xPlantTreeInfo, xPlantTreeLogs));
/*     */     
/*     */ 
/* 116 */     StringBuilder sb = new StringBuilder();
/* 117 */     sb.append(String.format("[planttree]PRefreshSpecialState.processImp@refresh special state sussess|roleid=%d|activity_cfg_id=%d|current_section_id=%d|current_section_point=%d|special_state_index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()), xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id())), Integer.valueOf(xPlantTreeInfo.getSpecial_state_index()) }));
/*     */     
/*     */ 
/*     */ 
/* 121 */     PlantTreeManager.logger.info(sb.toString());
/* 122 */     PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.roleid, 3, xPlantTreeInfo.getCurrent_section_id(), ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue(), xPlantTreeInfo.getSpecial_state_index(), -1, -1, xPlantTreeInfo.getSpecial_state_index(), -1);
/*     */     
/*     */ 
/*     */ 
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 131 */     StringBuilder sb = new StringBuilder();
/* 132 */     sb.append(String.format("[planttree]PRefreshSpecialState.processImp@refresh special state fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 135 */     if (extraInfo != null)
/*     */     {
/* 137 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 139 */         sb.append("|").append((String)entry.getKey());
/* 140 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 143 */     PlantTreeManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PRefreshSpecialState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */