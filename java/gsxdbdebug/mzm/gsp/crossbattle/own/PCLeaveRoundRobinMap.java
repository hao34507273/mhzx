/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.SLeaveRoundRobinMapFail;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCLeaveRoundRobinMap
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCLeaveRoundRobinMap(long roleid, int activityCfgid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  39 */     if (cfg == null)
/*     */     {
/*     */ 
/*  42 */       onFail(-3, null);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!NpcInterface.checkNpcService(cfg.round_robin_out_npc_id, cfg.round_robin_out_npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  48 */       onFail(-4, null);
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  54 */     Iterator i$; if (teamInfo == null)
/*     */     {
/*     */ 
/*  57 */       lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleid) }));
/*     */       
/*  59 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  60 */       RoleStatusInterface.unsetStatus(this.roleid, 1305);
/*  61 */       CrossBattleOwnManager.unsetRoundRobinTitle(this.roleid);
/*     */     }
/*     */     else
/*     */     {
/*  65 */       List<Long> roleids = teamInfo.getTeamMemberList();
/*  66 */       List<String> userids = new ArrayList();
/*  67 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long lockRoleid = ((Long)i$.next()).longValue();
/*     */         
/*  69 */         userids.add(RoleInterface.getUserId(lockRoleid));
/*     */       }
/*     */       
/*  72 */       lock(User.getTable(), userids);
/*     */       
/*  74 */       lock(Basic.getTable(), roleids);
/*  75 */       RoleStatusInterface.unsetStatus(roleids, 1305);
/*  76 */       for (i$ = roleids.iterator(); i$.hasNext();) { long teamMemberid = ((Long)i$.next()).longValue();
/*     */         
/*  78 */         CrossBattleOwnManager.unsetRoundRobinTitle(teamMemberid);
/*     */       }
/*     */     }
/*     */     
/*  82 */     MapInterface.forceTransferToScene(this.roleid, MapInterface.getBigWorldid(), cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */     
/*     */ 
/*  85 */     StringBuilder sb = new StringBuilder();
/*  86 */     sb.append(String.format("[crossbattle_own]PCLeaveRoundRobinMap.processImp@leave round robin map success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/*  89 */     CrossBattleOwnManager.logger.info(sb.toString());
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  95 */     StringBuilder sb = new StringBuilder();
/*  96 */     sb.append(String.format("[crossbattle_own]PCLeaveRoundRobinMap.processImp@leave round robin map fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  99 */     if (extraInfo != null)
/*     */     {
/* 101 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 103 */         sb.append("|").append((String)entry.getKey());
/* 104 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 107 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 108 */     if (res > 0)
/*     */     {
/* 110 */       SLeaveRoundRobinMapFail protocol = new SLeaveRoundRobinMapFail();
/* 111 */       protocol.res = res;
/* 112 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCLeaveRoundRobinMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */