/*     */ package mzm.gsp.singlebattle.resourcepoint;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.SSynAddResourceSum;
/*     */ import mzm.gsp.singlebattle.SSynResourcePointInfo;
/*     */ import mzm.gsp.singlebattle.SSynResourcePointUpdateInfo;
/*     */ import mzm.gsp.singlebattle.confbean.SResourcePointCfg;
/*     */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.ResourcePoint;
/*     */ import xbean.RoleResourcePointInfo;
/*     */ import xtable.Resource_points;
/*     */ 
/*     */ public class ResourcePointPlayTypeHandler implements EachPlayTypeHandler
/*     */ {
/*     */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*     */   {
/*  25 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*     */   {
/*  31 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onBattleEnd(long battleId, int playCfgId)
/*     */   {
/*  37 */     Resource_points.remove(Long.valueOf(battleId));
/*  38 */     GameServer.logger().info(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onBattleEnd@remove data|battleid=%d|play_cfg_id=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onBattleStart(long battleId, int playCfgId)
/*     */   {
/*  46 */     ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(battleId));
/*  47 */     if (xResourcePoint != null)
/*     */     {
/*  49 */       xResourcePoint.getRole_resource_point_infos().clear();
/*  50 */       GameServer.logger().error(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onBattleStart@data already exist|battleid=%d|play_cfg_id=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  57 */       xResourcePoint = Pod.newResourcePoint();
/*  58 */       Resource_points.insert(Long.valueOf(battleId), xResourcePoint);
/*  59 */       GameServer.logger().info(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onBattleStart@battle start process|battleid=%d|play_cfg_id=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onMatchEnd(long battleId, int playCfgId)
/*     */   {
/*  69 */     AddResourceObserverManager.getInstance().stopObserver(battleId);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId)
/*     */   {
/*  75 */     SResourcePointCfg cfg = SResourcePointCfg.get(playCfgId);
/*  76 */     if (cfg == null)
/*     */     {
/*     */ 
/*  79 */       return;
/*     */     }
/*     */     
/*  82 */     ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(battleId));
/*  83 */     if (xResourcePoint == null)
/*     */     {
/*  85 */       xResourcePoint = Pod.newResourcePoint();
/*  86 */       Resource_points.insert(Long.valueOf(battleId), xResourcePoint);
/*  87 */       GameServer.logger().error(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onBattleStart@data do not exist|battleid=%d|play_cfg_id=%d|roleid=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  92 */     RoleResourcePointInfo xRoleResourcePointInfo = (RoleResourcePointInfo)xResourcePoint.getRole_resource_point_infos().get(Long.valueOf(roleId));
/*  93 */     if (xRoleResourcePointInfo != null)
/*     */     {
/*  95 */       xRoleResourcePointInfo.setResource_point(cfg.initial_resource_point);
/*  96 */       xRoleResourcePointInfo.setAdd_resource_sum(0);
/*  97 */       xRoleResourcePointInfo.setIs_in_field(true);
/*  98 */       GameServer.logger().error(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onRoleJoinBattle@data already exist|battleid=%d|play_cfg_id=%d|roleid=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId) }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 105 */       xRoleResourcePointInfo = Pod.newRoleResourcePointInfo();
/* 106 */       xResourcePoint.getRole_resource_point_infos().put(Long.valueOf(roleId), xRoleResourcePointInfo);
/* 107 */       xRoleResourcePointInfo.setResource_point(cfg.initial_resource_point);
/* 108 */       GameServer.logger().info(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onRoleJoinBattle@role join battle process|battleid=%d|play_cfg_id=%d|roleid=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 114 */     SSynResourcePointInfo sSynResourcePointInfo = new SSynResourcePointInfo();
/* 115 */     for (Map.Entry<Long, RoleResourcePointInfo> entry : xResourcePoint.getRole_resource_point_infos().entrySet())
/*     */     {
/* 117 */       sSynResourcePointInfo.resource_point_infos.put(entry.getKey(), Integer.valueOf(((RoleResourcePointInfo)entry.getValue()).getResource_point()));
/*     */     }
/* 119 */     OnlineManager.getInstance().send(roleId, sSynResourcePointInfo);
/*     */     
/* 121 */     SSynResourcePointUpdateInfo sSynResourcePointUpdateInfo = new SSynResourcePointUpdateInfo();
/* 122 */     sSynResourcePointUpdateInfo.reason = 0;
/* 123 */     sSynResourcePointUpdateInfo.resource_point_update_infos.put(Long.valueOf(roleId), Integer.valueOf(cfg.initial_resource_point));
/* 124 */     SingleBattleInterface.battleBro(battleId, sSynResourcePointUpdateInfo, false);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*     */   {
/* 130 */     ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(battleId));
/* 131 */     if (xResourcePoint == null)
/*     */     {
/*     */ 
/* 134 */       return;
/*     */     }
/* 136 */     RoleResourcePointInfo xRoleResourcePointInfo = (RoleResourcePointInfo)xResourcePoint.getRole_resource_point_infos().get(Long.valueOf(roleId));
/* 137 */     if (xRoleResourcePointInfo == null)
/*     */     {
/*     */ 
/* 140 */       return;
/*     */     }
/* 142 */     xRoleResourcePointInfo.setIs_in_field(false);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onStartClean(long battleId, int playCfgId)
/*     */   {
/* 148 */     ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(battleId));
/* 149 */     if (xResourcePoint == null)
/*     */     {
/*     */ 
/* 152 */       GameServer.logger().error(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onStartClean@data do not exist|battleid=%d|play_cfg_id=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 156 */       return;
/*     */     }
/* 158 */     SSynAddResourceSum protocol = new SSynAddResourceSum();
/* 159 */     for (Map.Entry<Long, RoleResourcePointInfo> entry : xResourcePoint.getRole_resource_point_infos().entrySet())
/*     */     {
/* 161 */       protocol.add_resource_sums.put(entry.getKey(), Integer.valueOf(((RoleResourcePointInfo)entry.getValue()).getAdd_resource_sum()));
/*     */     }
/* 163 */     SingleBattleInterface.battleBro(battleId, protocol, false);
/* 164 */     GameServer.logger().info(String.format("[resourcepoint]ResourcePointPlayTypeHandler.onStartClean@start clean process|battleid=%d|play_cfg_id=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onMatchStart(long battleId, int playCfgId)
/*     */   {
/* 173 */     AddResourceObserverManager.getInstance().startObserver(battleId, playCfgId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\resourcepoint\ResourcePointPlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */