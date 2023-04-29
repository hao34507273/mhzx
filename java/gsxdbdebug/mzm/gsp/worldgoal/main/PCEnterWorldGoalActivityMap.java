/*     */ package mzm.gsp.worldgoal.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.worldgoal.SEnterWorldGoalActivityMapFail;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WorldGoal;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ import xtable.Worldgoals;
/*     */ 
/*     */ public class PCEnterWorldGoalActivityMap extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int enterActivityMapNPCid;
/*     */   
/*     */   public PCEnterWorldGoalActivityMap(long roleid, int activityCfgid, int enterActivityMapNPCid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*  33 */     this.enterActivityMapNPCid = enterActivityMapNPCid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!WorldGoalManager.isWorldGoalSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  42 */       WorldGoalManager.logger.info(String.format("[worldgoal]PCEnterWorldGoalActivityMap.processImp@module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  44 */       return false;
/*     */     }
/*  46 */     if (!WorldGoalManager.checkRoleStatus(this.roleid))
/*     */     {
/*     */ 
/*  49 */       WorldGoalManager.logger.info(String.format("[worldgoal]PCEnterWorldGoalActivityMap.processImp@role status error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!SWorldGoalCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*  59 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(this.activityCfgid);
/*  60 */     if ((cfg.enter_activity_map_npc_id > 0) && (cfg.enter_activity_map_npc_id != this.enterActivityMapNPCid))
/*     */     {
/*     */ 
/*  63 */       return false;
/*     */     }
/*  65 */     if ((cfg.enter_activity_map_npc_id > 0) && (!NpcInterface.checkNpcService(cfg.enter_activity_map_npc_id, cfg.enter_activity_map_service_id, this.roleid)))
/*     */     {
/*     */ 
/*     */ 
/*  69 */       onFail(2, null);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  75 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  77 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*  80 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  82 */     if ((!activityJoinResult.isCanJoin()) && (!activityJoinResult.isActivityJoinCountMax()))
/*     */     {
/*     */ 
/*  85 */       Map<String, Object> extraInfo = new HashMap();
/*  86 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  87 */       onFail(1, extraInfo);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  92 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/*  93 */     if (xWorldGoal == null)
/*     */     {
/*     */ 
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (cfg.enter_activity_map_transfer_map_cfg_id <= 0)
/*     */     {
/*     */ 
/* 102 */       onFail(3, null);
/* 103 */       return false;
/*     */     }
/* 105 */     MapInterface.forceTransferToScene(this.roleid, xWorldGoal.getWorld_id(), cfg.enter_activity_map_transfer_map_cfg_id, cfg.enter_activity_map_transfer_x, cfg.enter_activity_map_transfer_y);
/*     */     
/*     */ 
/* 108 */     StringBuilder sb = new StringBuilder();
/* 109 */     sb.append(String.format("[worldgoal]PCEnterWorldGoalActivityMap.processImp@enter activity map success|roleid=%d|activity_cfg_id=%d|enter_activity_map_npc_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.enterActivityMapNPCid) }));
/*     */     
/*     */ 
/* 112 */     WorldGoalManager.logger.info(sb.toString());
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 118 */     StringBuilder sb = new StringBuilder();
/* 119 */     sb.append(String.format("[worldgoal]PCEnterWorldGoalActivityMap.processImp@enter activity map fail|roleid=%d|activity_cfg_id=%d|enter_activity_map_npc_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.enterActivityMapNPCid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 122 */     if (extraInfo != null)
/*     */     {
/* 124 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 126 */         sb.append("|").append((String)entry.getKey());
/* 127 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 130 */     WorldGoalManager.logger.info(sb.toString());
/*     */     
/* 132 */     SEnterWorldGoalActivityMapFail protocol = new SEnterWorldGoalActivityMapFail();
/* 133 */     protocol.activity_cfg_id = this.activityCfgid;
/* 134 */     protocol.res = res;
/* 135 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PCEnterWorldGoalActivityMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */