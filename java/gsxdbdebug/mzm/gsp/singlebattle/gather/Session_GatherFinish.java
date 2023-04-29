/*     */ package mzm.gsp.singlebattle.gather;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.SGatherBattleItemFail;
/*     */ import mzm.gsp.singlebattle.SGatherItemSuc;
/*     */ import mzm.gsp.singlebattle.confbean.SBattleGatherPlayCfg;
/*     */ import mzm.gsp.singlebattle.confbean.SGatherItemCfg;
/*     */ import mzm.gsp.singlebattle.event.GatherBattleItemSuc;
/*     */ import mzm.gsp.singlebattle.main.RoleBattleBaseInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGatherData;
/*     */ import xbean.GatherItemData;
/*     */ import xbean.RoleGatherData;
/*     */ import xtable.Battlegather;
/*     */ 
/*     */ public class Session_GatherFinish extends Session
/*     */ {
/*     */   private final long battleId;
/*     */   private final long roleId;
/*     */   private final long instanceId;
/*     */   private final int gatherItemCfgId;
/*     */   private final int playCfgId;
/*     */   private final long orgSessionId;
/*     */   
/*     */   public Session_GatherFinish(long interval, long roleId, long battleId, long instanceId, int gatherItemCfgId, int playCfgId)
/*     */   {
/*  34 */     super(interval, roleId);
/*  35 */     this.roleId = roleId;
/*  36 */     this.battleId = battleId;
/*  37 */     this.instanceId = instanceId;
/*  38 */     this.gatherItemCfgId = gatherItemCfgId;
/*  39 */     this.playCfgId = playCfgId;
/*     */     
/*  41 */     this.orgSessionId = getSessionId();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  47 */     new GatherFinish(null).execute();
/*     */   }
/*     */   
/*     */   private class GatherFinish
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private GatherFinish() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  57 */       BattleGatherData xBattleGatherData = Battlegather.get(Long.valueOf(Session_GatherFinish.this.battleId));
/*  58 */       if (xBattleGatherData == null)
/*     */       {
/*  60 */         GameServer.logger().error(String.format("[battlegather]GatherFinish.processImp@ xBattleGatherData is null!| roleId=%d|instanceId=%d|battleId=%d", new Object[] { Long.valueOf(Session_GatherFinish.this.roleId), Long.valueOf(Session_GatherFinish.this.instanceId), Long.valueOf(Session_GatherFinish.this.battleId) }));
/*     */         
/*     */ 
/*     */ 
/*  64 */         return false;
/*     */       }
/*     */       
/*  67 */       RoleGatherData xRoleGatherData = xtable.Role2gatherdata.get(Long.valueOf(Session_GatherFinish.this.roleId));
/*  68 */       if (xRoleGatherData == null)
/*     */       {
/*  70 */         GameServer.logger().error(String.format("[battlegather]GatherFinish.processImp@ role not in battle!| roleId=%d|instanceId=%d|battleId=%d", new Object[] { Long.valueOf(Session_GatherFinish.this.roleId), Long.valueOf(Session_GatherFinish.this.instanceId), Long.valueOf(Session_GatherFinish.this.battleId) }));
/*     */         
/*     */ 
/*     */ 
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       if (xRoleGatherData.getGathersessionid() != Session_GatherFinish.this.orgSessionId)
/*     */       {
/*     */ 
/*  80 */         GameServer.logger().error(String.format("[battlegather]GatherFinish.processImp@ session err!| roleId=%d|instanceId=%d|battleId=%d|sessionId=%d|orgSessionId=%d", new Object[] { Long.valueOf(Session_GatherFinish.this.roleId), Long.valueOf(Session_GatherFinish.this.instanceId), Long.valueOf(Session_GatherFinish.this.battleId), Long.valueOf(xRoleGatherData.getGathersessionid()), Long.valueOf(Session_GatherFinish.this.orgSessionId) }));
/*     */         
/*     */ 
/*     */ 
/*  84 */         return false;
/*     */       }
/*  86 */       GatherItemData xGatherItemData = (GatherItemData)xBattleGatherData.getGatheritemdatas().get(Long.valueOf(Session_GatherFinish.this.instanceId));
/*  87 */       if (xGatherItemData != null)
/*     */       {
/*     */ 
/*     */ 
/*  91 */         MapInterface.removeMapEntity(MapEntityType.MET_SINGLE_BATTLE_GATHER_ITEM, Session_GatherFinish.this.instanceId, new MapCallBack_RemoveMapEntity(Session_GatherFinish.this.battleId, Session_GatherFinish.this.instanceId, xGatherItemData.getGathercfgid(), MapCallBack_RemoveMapEntity.RemoveGatherItemReason.GATHERED));
/*     */         
/*     */ 
/*     */ 
/*  95 */         xBattleGatherData.getGatheritemdatas().remove(Long.valueOf(Session_GatherFinish.this.instanceId));
/*     */         
/*  97 */         addSourceAndPoint(xRoleGatherData);
/*     */         
/*  99 */         OnlineManager.getInstance().send(Session_GatherFinish.this.roleId, new SGatherItemSuc(Session_GatherFinish.this.instanceId, xGatherItemData.getGathercfgid()));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 104 */         OnlineManager.getInstance().send(Session_GatherFinish.this.roleId, new SGatherBattleItemFail(Session_GatherFinish.this.instanceId, 4, Session_GatherFinish.this.gatherItemCfgId));
/*     */       }
/*     */       
/*     */ 
/* 108 */       xRoleGatherData.setGatherinstanceid(0L);
/* 109 */       xRoleGatherData.setGathersessionid(0L);
/*     */       
/* 111 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(Session_GatherFinish.this.roleId, 1516);
/*     */       
/* 113 */       return true;
/*     */     }
/*     */     
/*     */     private void addSourceAndPoint(RoleGatherData xRoleGatherData)
/*     */     {
/* 118 */       RoleBattleBaseInfo roleBaseInfo = SingleBattleInterface.getRoleBattleBaseInfo(Session_GatherFinish.this.roleId, true);
/* 119 */       if (roleBaseInfo == null)
/*     */       {
/* 121 */         return;
/*     */       }
/* 123 */       SBattleGatherPlayCfg playCfg = SBattleGatherPlayCfg.get(Session_GatherFinish.this.playCfgId);
/* 124 */       if (playCfg == null)
/*     */       {
/* 126 */         return;
/*     */       }
/* 128 */       int sourcePerPoint = playCfg.sourcePerPoint;
/* 129 */       SGatherItemCfg gatherItemCfg = SGatherItemCfg.get(Session_GatherFinish.this.gatherItemCfgId);
/* 130 */       if (gatherItemCfg == null)
/*     */       {
/* 132 */         return;
/*     */       }
/*     */       
/* 135 */       int totalSource = xRoleGatherData.getTotalsource() + gatherItemCfg.source;
/*     */       
/* 137 */       int orgPoint = xRoleGatherData.getPoint();
/*     */       
/* 139 */       int totalPoint = totalSource / sourcePerPoint;
/*     */       
/*     */ 
/* 142 */       xRoleGatherData.setTotalsource(totalSource);
/*     */       
/* 144 */       SingleBattleInterface.addCampSource(Session_GatherFinish.this.battleId, roleBaseInfo.getCampId(), gatherItemCfg.source);
/*     */       
/* 146 */       int addPoint = totalPoint - orgPoint;
/* 147 */       if (addPoint > 0)
/*     */       {
/*     */ 
/* 150 */         xRoleGatherData.setPoint(totalPoint);
/*     */         
/* 152 */         SingleBattleInterface.addRolePoint(Session_GatherFinish.this.battleId, roleBaseInfo.getCampId(), Session_GatherFinish.this.roleId, addPoint);
/*     */       }
/*     */       
/* 155 */       xRoleGatherData.setTotalcount(xRoleGatherData.getTotalcount() + 1);
/*     */       
/* 157 */       SingleBattleInterface.battleCampBro(Session_GatherFinish.this.battleId, roleBaseInfo.getCampId(), new mzm.gsp.singlebattle.SGatherItemSucCampBro(Session_GatherFinish.this.roleId, Session_GatherFinish.this.gatherItemCfgId), false);
/*     */       
/*     */ 
/*     */ 
/* 161 */       TriggerEventsManger.getInstance().triggerEvent(new GatherBattleItemSuc(), new EventArg_GatherSuc(Session_GatherFinish.this.roleId, totalSource, totalPoint, Session_GatherFinish.this.instanceId, Session_GatherFinish.this.gatherItemCfgId, gatherItemCfg.source, addPoint));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\Session_GatherFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */