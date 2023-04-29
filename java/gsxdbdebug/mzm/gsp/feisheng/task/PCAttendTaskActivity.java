/*     */ package mzm.gsp.feisheng.task;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.SAttendTaskActivityFail;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengTaskActivityCfg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCAttendTaskActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCAttendTaskActivity(long roleid, int activityCfgid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!TaskActivityManager.isFeiShengTaskActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  42 */       onFail(-1, null);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 955, true))
/*     */     {
/*     */ 
/*  48 */       onFail(-2, null);
/*  49 */       return false;
/*     */     }
/*  51 */     SFeiShengTaskActivityCfg cfg = SFeiShengTaskActivityCfg.get(this.activityCfgid);
/*  52 */     if (cfg == null)
/*     */     {
/*     */ 
/*  55 */       onFail(-3, null);
/*  56 */       return false;
/*     */     }
/*  58 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  61 */       onFail(-5, null);
/*  62 */       return false;
/*     */     }
/*  64 */     if (!NpcInterface.checkNpcService(cfg.npc_id, cfg.npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  67 */       onFail(-4, null);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  73 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  75 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
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
/*     */     
/*  88 */     if (!TaskInterface.isHaveGraphId(this.roleid, cfg.task_graph_id))
/*     */     {
/*  90 */       if (!TaskInterface.activeGraph(Long.valueOf(this.roleid), cfg.task_graph_id))
/*     */       {
/*     */ 
/*  93 */         onFail(2, null);
/*  94 */         return false;
/*     */       }
/*     */     }
/*  97 */     StringBuilder sb = new StringBuilder();
/*  98 */     sb.append(String.format("[feisheng]PCAttendTaskActivity.processImp@attend task activity success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 101 */     FeiShengManager.logger.info(sb.toString());
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 107 */     StringBuilder sb = new StringBuilder();
/* 108 */     sb.append(String.format("[feisheng]PCAttendTaskActivity.processImp@attend task activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 111 */     if (extraInfo != null)
/*     */     {
/* 113 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 115 */         sb.append("|").append((String)entry.getKey());
/* 116 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 119 */     FeiShengManager.logger.info(sb.toString());
/* 120 */     if (res > 0)
/*     */     {
/* 122 */       SAttendTaskActivityFail protocol = new SAttendTaskActivityFail();
/* 123 */       protocol.res = res;
/* 124 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\task\PCAttendTaskActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */