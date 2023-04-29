/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PInitActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PInitActivity(long roleid, int activityCfgid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!OnlineManager.getInstance().isOnline(this.roleid))
/*     */     {
/*     */ 
/*  37 */       onFail(9, null);
/*  38 */       return false;
/*     */     }
/*  40 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  43 */       onFail(-1, null);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       onFail(-3, null);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  57 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  59 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  61 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  63 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  66 */       Map<String, Object> extraInfo = new HashMap();
/*  67 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  68 */       onFail(1, extraInfo);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  73 */     if (xRolePlantTreeInfo == null)
/*     */     {
/*  75 */       onFail(-4, null);
/*  76 */       return false;
/*     */     }
/*  78 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*  79 */     if (xPlantTreeInfo == null)
/*     */     {
/*  81 */       onFail(-4, null);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if ((xPlantTreeInfo.getSpecial_state_refresh_sessionid() > 0L) && (Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) != null) && ((Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) instanceof SpecialStateRefreshSession)))
/*     */     {
/*     */ 
/*     */ 
/*  89 */       Session.removeSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid(), this.roleid);
/*     */     }
/*  91 */     xPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/*  92 */     if (xPlantTreeInfo.getSpecial_state_index() <= 0)
/*     */     {
/*  94 */       xPlantTreeInfo.setSpecial_state_refresh_sessionid(new SpecialStateRefreshSession(cfg.special_state_refresh_interval * 60L, this.roleid, this.activityCfgid).getSessionId());
/*     */     }
/*     */     
/*     */ 
/*  98 */     if ((xPlantTreeInfo.getSpecial_state_index() <= 0) && (PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) > 0))
/*     */     {
/*     */ 
/* 101 */       OnlineRewardPointObserverManager.getInstance().startObserver(this.roleid, this.activityCfgid);
/*     */     }
/*     */     
/* 104 */     StringBuilder sb = new StringBuilder();
/* 105 */     sb.append(String.format("[planttree]PInitActivity.processImp@init activity success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/* 107 */     PlantTreeManager.logger.info(sb.toString());
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 113 */     if (PlantTreeManager.logger.isDebugEnabled())
/*     */     {
/* 115 */       StringBuilder sb = new StringBuilder();
/* 116 */       sb.append(String.format("[planttree]PInitActivity.processImp@init activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */       
/*     */ 
/* 119 */       if (extraInfo != null)
/*     */       {
/* 121 */         for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */         {
/* 123 */           sb.append("|").append((String)entry.getKey());
/* 124 */           sb.append("=").append(entry.getValue().toString());
/*     */         }
/*     */       }
/* 127 */       PlantTreeManager.logger.debug(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PInitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */