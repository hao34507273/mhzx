/*     */ package mzm.gsp.singlebattle.grab;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.singlebattle.SBeginGrapPositionBro;
/*     */ import mzm.gsp.singlebattle.buff.SingleBattleBuffInterface;
/*     */ import mzm.gsp.singlebattle.confbean.SPositionInfoCfg;
/*     */ import mzm.gsp.singlebattle.main.RoleBattleBaseInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGrabData;
/*     */ import xbean.GrabPositionData;
/*     */ import xbean.RoleGrabData;
/*     */ import xbean.RoleGrabSessions;
/*     */ import xtable.Grabposition;
/*     */ import xtable.Role2rolegrabdata;
/*     */ 
/*     */ public class PCGrapPositionReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int positionId;
/*     */   
/*     */   public PCGrapPositionReq(long roleId, int positionId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.positionId = positionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     long battleId = SingleBattleInterface.getBattleId(this.roleId, false);
/*  38 */     if (battleId <= 0L)
/*     */     {
/*  40 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ not in battle!| roleId=%d|positionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/*  48 */     if (xBattleGrabData == null)
/*     */     {
/*  50 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ no grab position data! | roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     RoleBattleBaseInfo roleBaseInfo = SingleBattleInterface.getRoleBattleBaseInfo(this.roleId, true);
/*  58 */     if (roleBaseInfo == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ get base info, not in battle!| roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*  66 */     RoleGrabData xRoleGrabData = Role2rolegrabdata.get(Long.valueOf(this.roleId));
/*  67 */     if (xRoleGrabData == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ no grab role data!| roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*  75 */     GrabPositionData xGrabPositionData = (GrabPositionData)xBattleGrabData.getPositiondatas().get(Integer.valueOf(this.positionId));
/*     */     
/*  77 */     if (xGrabPositionData == null)
/*     */     {
/*  79 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ xGrabPositionData is null!|roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     SPositionInfoCfg positionInfoCfg = SPositionInfoCfg.get(this.positionId);
/*  87 */     if (positionInfoCfg == null)
/*     */     {
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (!canGrab(battleId, roleBaseInfo, xGrabPositionData))
/*     */     {
/*  95 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.processImp@ can not grab!|roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     xRoleGrabData.setGrabpositionid(this.positionId);
/* 103 */     xGrabPositionData.setGrabingroleid(this.roleId);
/*     */     
/* 105 */     RoleStatusInterface.setStatus(this.roleId, 1514, true);
/*     */     
/* 107 */     long endTime = startGrabSession(battleId, xRoleGrabData, positionInfoCfg);
/*     */     
/* 109 */     GrabPositionManager.setPositionState(battleId, xGrabPositionData, 2, this.positionId);
/*     */     
/* 111 */     SingleBattleInterface.battleBro(battleId, new SBeginGrapPositionBro(this.positionId, this.roleId, (int)(endTime / 1000L)), false);
/*     */     
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canGrab(long battleId, RoleBattleBaseInfo roleBaseInfo, GrabPositionData xGrabPositionData)
/*     */   {
/* 127 */     if (!MapInterface.isNearByMapEntity(this.roleId, MapEntityType.MET_SINGLE_BATTLE_POSITION, xGrabPositionData.getInstanceid()))
/*     */     {
/* 129 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.canGrab@ not near by positon!| roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/* 132 */       return false;
/*     */     }
/* 134 */     if (roleBaseInfo.getBattleId() != battleId)
/*     */     {
/* 136 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.canGrab@ not in same battle!| roleId=%d|positionId=%d|battleId=%d|nowBattleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId), Long.valueOf(roleBaseInfo.getBattleId()) }));
/*     */       
/*     */ 
/*     */ 
/* 140 */       return false;
/*     */     }
/* 142 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1514, true))
/*     */     {
/* 144 */       GameServer.logger().info(String.format("[grab]PCGrapPositionReq.canGrab@ state forbid! | roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     if (!SingleBattleInterface.isMatchIngStage(battleId, true))
/*     */     {
/* 152 */       GameServer.logger().info(String.format("[grab]PCGrapPositionReq.canGrab@ not in match! | roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     if (MapInterface.isInMoveState(this.roleId))
/*     */     {
/* 160 */       GameServer.logger().info(String.format("[grab]PCGrapPositionReq.canGrab@ moving! | roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     if (xGrabPositionData.getState() != 1)
/*     */     {
/* 168 */       GameServer.logger().error(String.format("[grab]PCGrapPositionReq.canGrab@ not in can grab state!|roleId=%d|positionId=%d|battleId=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId), Integer.valueOf(xGrabPositionData.getState()) }));
/*     */       
/*     */ 
/*     */ 
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     if (xGrabPositionData.getCampid() == roleBaseInfo.getCampId())
/*     */     {
/* 177 */       GameServer.logger().info(String.format("[grab]PCGrapPositionReq.canGrab@ already grabed! | roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.positionId), Long.valueOf(battleId) }));
/*     */       
/*     */ 
/* 180 */       return false;
/*     */     }
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long startGrabSession(long battleId, RoleGrabData xRoleGrabData, SPositionInfoCfg positionInfoCfg)
/*     */   {
/* 195 */     int grabInterval = getGrabInterval(positionInfoCfg);
/* 196 */     int protectInterval = positionInfoCfg.positionProtectInterval;
/*     */     
/*     */ 
/* 199 */     long grabSessionId = new SessionGrabPosition(grabInterval, this.roleId, battleId, this.positionId, protectInterval).getSessionId();
/* 200 */     xRoleGrabData.getSessiondata().setGrabsessionid(grabSessionId);
/*     */     
/* 202 */     return DateTimeUtils.getCurrTimeInMillis() + grabInterval * 1000;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getGrabInterval(SPositionInfoCfg positionInfoCfg)
/*     */   {
/* 213 */     int buffInterval = SingleBattleBuffInterface.getOccupyCostTime(this.roleId);
/* 214 */     return buffInterval > 0 ? buffInterval : positionInfoCfg.positionGrabInterval;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\PCGrapPositionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */