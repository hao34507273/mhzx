/*     */ package mzm.gsp.singlebattle.gather;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.SGatherBattleItemRep;
/*     */ import mzm.gsp.singlebattle.confbean.SGatherItemCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGatherData;
/*     */ import xbean.GatherItemData;
/*     */ import xbean.RoleGatherData;
/*     */ import xtable.Battlegather;
/*     */ import xtable.Role2gatherdata;
/*     */ 
/*     */ public class PCGatherBattleItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long instanceId;
/*     */   
/*     */   public PCGatherBattleItemReq(long roleId, long instanceId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.instanceId = instanceId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     long battleId = SingleBattleInterface.getBattleId(this.roleId, false);
/*  33 */     if (battleId <= 0L)
/*     */     {
/*  35 */       GameServer.logger().error(String.format("[grab]PCGatherBattleItemReq.processImp@ not in battle!| roleId=%d|instanceId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId) }));
/*     */       
/*     */ 
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     BattleGatherData xBattleGatherData = Battlegather.get(Long.valueOf(battleId));
/*  43 */     if (xBattleGatherData == null)
/*     */     {
/*  45 */       GameServer.logger().error(String.format("[grab]PCGatherBattleItemReq.processImp@ not in battle!| roleId=%d|instanceId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     RoleGatherData xRoleGatherData = Role2gatherdata.get(Long.valueOf(this.roleId));
/*  53 */     if (xRoleGatherData == null)
/*     */     {
/*  55 */       Role2gatherdata.insert(Long.valueOf(this.roleId), xRoleGatherData = xbean.Pod.newRoleGatherData());
/*     */     }
/*  57 */     if (xRoleGatherData.getGatherinstanceid() > 0L)
/*     */     {
/*     */ 
/*  60 */       GameServer.logger().error(String.format("[grab]PCGatherBattleItemReq.processImp@ is gatherIng!| roleId=%d|instanceId=%d|battleId=%d|gatherinstanceid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId), Long.valueOf(xRoleGatherData.getGatherinstanceid()) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (!SingleBattleInterface.isMatchIngStage(battleId, true))
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[grab]PCGatherBattleItemReq.processImp@ not in match stage!| roleId=%d|instanceId=%d|battleId=%d|gatherinstanceid=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId), Long.valueOf(xRoleGatherData.getGatherinstanceid()), Integer.valueOf(SingleBattleInterface.getStage(battleId, true)) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     if (RoleStatusInterface.containsStatus(this.roleId, 1516))
/*     */     {
/*     */ 
/*  79 */       GameServer.logger().error(String.format("[grab]PCGatherBattleItemReq.processImp@ is gatherIng!| roleId=%d|instanceId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*  82 */       return false;
/*     */     }
/*  84 */     GatherItemData xGatherItemData = (GatherItemData)xBattleGatherData.getGatheritemdatas().get(Long.valueOf(this.instanceId));
/*  85 */     if (xGatherItemData == null)
/*     */     {
/*     */ 
/*  88 */       GameServer.logger().info(String.format("[grab]PCGatherBattleItemReq.processImp@ gather item not exist!|roleId=%d|instanceId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*  94 */     if (xGatherItemData.getGathering())
/*     */     {
/*     */ 
/*  97 */       GameServer.logger().info(String.format("[grab]PCGatherBattleItemReq.processImp@ item is gathering!|roleId=%d|instanceId=%d|battleId=%d|gatherItemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId), Integer.valueOf(xGatherItemData.getGathercfgid()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 102 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new mzm.gsp.singlebattle.SGatherBattleItemFail(this.instanceId, 5, xGatherItemData.getGathercfgid()));
/*     */       
/*     */ 
/*     */ 
/* 106 */       return false;
/*     */     }
/* 108 */     SGatherItemCfg gatherItemCfg = SGatherItemCfg.get(xGatherItemData.getGathercfgid());
/* 109 */     if (gatherItemCfg == null)
/*     */     {
/*     */ 
/* 112 */       GameServer.logger().info(String.format("[grab]PCGatherBattleItemReq.processImp@ gather item cfg not exist!|roleId=%d|instanceId=%d|battleId=%d|gatherItemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId), Integer.valueOf(xGatherItemData.getGathercfgid()) }));
/*     */       
/*     */ 
/*     */ 
/* 116 */       return false;
/*     */     }
/* 118 */     if (!MapInterface.isNearByMapEntity(this.roleId, mzm.gsp.map.main.scene.object.MapEntityType.MET_SINGLE_BATTLE_GATHER_ITEM, this.instanceId))
/*     */     {
/*     */ 
/* 121 */       GameServer.logger().info(String.format("[grab]PCGatherBattleItemReq.processImp@ not near gather item!|roleId=%d|instanceId=%d|battleId=%d|gatherItemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId), Integer.valueOf(xGatherItemData.getGathercfgid()) }));
/*     */       
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleId, true);
/*     */     
/* 130 */     xRoleGatherData.setGatherinstanceid(this.instanceId);
/*     */     
/* 132 */     if (!RoleStatusInterface.setStatus(this.roleId, 1516, true))
/*     */     {
/*     */ 
/* 135 */       GameServer.logger().info(String.format("[grab]PCGatherBattleItemReq.processImp@ not allow on state!|roleId=%d|instanceId=%d|battleId=%d|gatherItemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.instanceId), Long.valueOf(battleId), Integer.valueOf(xGatherItemData.getGathercfgid()) }));
/*     */       
/*     */ 
/*     */ 
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     xGatherItemData.setGathering(true);
/*     */     
/*     */ 
/* 145 */     int interval = gatherItemCfg.gatherInterval;
/* 146 */     Session_GatherFinish session = new Session_GatherFinish(interval, this.roleId, battleId, this.instanceId, xGatherItemData.getGathercfgid(), globalInfo.getPlayCfgId(4));
/*     */     
/*     */ 
/* 149 */     xRoleGatherData.setGathersessionid(session.getSessionId());
/*     */     
/*     */ 
/* 152 */     OnlineManager.getInstance().send(this.roleId, new SGatherBattleItemRep(this.instanceId, (int)(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L + interval)));
/*     */     
/*     */ 
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\PCGatherBattleItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */