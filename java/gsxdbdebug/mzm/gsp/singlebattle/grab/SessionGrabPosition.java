/*     */ package mzm.gsp.singlebattle.grab;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.singlebattle.SGrapPositionSucBro;
/*     */ import mzm.gsp.singlebattle.confbean.SPositionInfoCfg;
/*     */ import mzm.gsp.singlebattle.event.GrabPositionSuc;
/*     */ import mzm.gsp.singlebattle.main.RoleBattleBaseInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGrabData;
/*     */ import xbean.GrabPositionData;
/*     */ import xbean.GrabPositionSessions;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGrabData;
/*     */ import xbean.RoleGrabPositionData;
/*     */ import xbean.RoleGrabSessions;
/*     */ import xtable.Grabposition;
/*     */ import xtable.Role2rolegrabdata;
/*     */ 
/*     */ public class SessionGrabPosition extends Session
/*     */ {
/*     */   private final long battleId;
/*     */   private final int positionId;
/*     */   private final int protectInterval;
/*     */   private final long roleId;
/*     */   private final long orgSessionId;
/*     */   
/*     */   public SessionGrabPosition(long interval, long roleId, long battleId, int positionId, int protectInterval)
/*     */   {
/*  41 */     super(interval, roleId);
/*  42 */     this.roleId = roleId;
/*  43 */     this.battleId = battleId;
/*  44 */     this.positionId = positionId;
/*  45 */     this.protectInterval = protectInterval;
/*     */     
/*  47 */     this.orgSessionId = getSessionId();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  53 */     new FinishGrab(null).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class FinishGrab
/*     */     extends LogicProcedure
/*     */   {
/*     */     private FinishGrab() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  71 */       BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(SessionGrabPosition.this.battleId));
/*  72 */       if (xBattleGrabData == null)
/*     */       {
/*  74 */         GameServer.logger().error(String.format("[grab]AfterGrabSuc.processImp@ no grab position data! | roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(SessionGrabPosition.this.roleId), Integer.valueOf(SessionGrabPosition.this.positionId), Long.valueOf(SessionGrabPosition.this.battleId) }));
/*     */         
/*     */ 
/*     */ 
/*  78 */         return false;
/*     */       }
/*     */       
/*  81 */       RoleBattleBaseInfo roleBaseInfo = SingleBattleInterface.getRoleBattleBaseInfo(SessionGrabPosition.this.roleId, true);
/*  82 */       if (roleBaseInfo == null)
/*     */       {
/*  84 */         GameServer.logger().error(String.format("[grab]AfterGrabSuc.processImp@ get base info, not in battle!| roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(SessionGrabPosition.this.roleId), Integer.valueOf(SessionGrabPosition.this.positionId), Long.valueOf(SessionGrabPosition.this.battleId) }));
/*     */         
/*     */ 
/*     */ 
/*  88 */         return false;
/*     */       }
/*  90 */       RoleGrabData xRoleGrabData = Role2rolegrabdata.get(Long.valueOf(SessionGrabPosition.this.roleId));
/*  91 */       if (xRoleGrabData == null)
/*     */       {
/*  93 */         GameServer.logger().error(String.format("[grab]AfterGrabSuc.processImp@ no grab role data!| roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(SessionGrabPosition.this.roleId), Integer.valueOf(SessionGrabPosition.this.positionId), Long.valueOf(SessionGrabPosition.this.battleId) }));
/*     */         
/*     */ 
/*  96 */         return false;
/*     */       }
/*  98 */       if (roleBaseInfo.getBattleId() != SessionGrabPosition.this.battleId)
/*     */       {
/* 100 */         GameServer.logger().error(String.format("[grab]AfterGrabSuc.processImp@ not in same battle!| roleId=%d|positionId=%d|battleId=%d|nowBattleId=%d", new Object[] { Long.valueOf(SessionGrabPosition.this.roleId), Integer.valueOf(SessionGrabPosition.this.positionId), Long.valueOf(SessionGrabPosition.this.battleId), Long.valueOf(roleBaseInfo.getBattleId()) }));
/*     */         
/*     */ 
/*     */ 
/* 104 */         return false;
/*     */       }
/*     */       
/* 107 */       if (xRoleGrabData.getSessiondata().getGrabsessionid() != SessionGrabPosition.this.orgSessionId)
/*     */       {
/* 109 */         GameServer.logger().error(String.format("[grab]AfterGrabSuc.processImp@ session illegal!| roleId=%d|positionId=%d|battleId=%d", new Object[] { Long.valueOf(SessionGrabPosition.this.roleId), Integer.valueOf(SessionGrabPosition.this.positionId), Long.valueOf(SessionGrabPosition.this.battleId) }));
/*     */         
/*     */ 
/* 112 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 116 */       SPositionInfoCfg positionInfoCfg = SPositionInfoCfg.get(SessionGrabPosition.this.positionId);
/* 117 */       if (positionInfoCfg == null)
/*     */       {
/* 119 */         return false;
/*     */       }
/* 121 */       GrabPositionData xGrabPositionData = (GrabPositionData)xBattleGrabData.getPositiondatas().get(Integer.valueOf(SessionGrabPosition.this.positionId));
/*     */       
/* 123 */       if (xGrabPositionData == null)
/*     */       {
/*     */ 
/* 126 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 130 */       xRoleGrabData.getSessiondata().setGrabsessionid(0L);
/*     */       
/* 132 */       xGrabPositionData.setGrabingroleid(0L);
/*     */       
/* 134 */       xRoleGrabData.setGrabpositionid(0);
/*     */       
/* 136 */       RoleStatusInterface.unsetStatus(SessionGrabPosition.this.roleId, 1514);
/*     */       
/* 138 */       afterGrabSuc(roleBaseInfo, xRoleGrabData, xGrabPositionData);
/* 139 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void afterGrabSuc(RoleBattleBaseInfo roleBaseInfo, RoleGrabData xRoleGrabData, GrabPositionData xGrabPositionData)
/*     */     {
/* 145 */       if (!SingleBattleInterface.isMatchIngStage(SessionGrabPosition.this.battleId, true))
/*     */       {
/*     */ 
/* 148 */         GrabPositionManager.setPositionState(SessionGrabPosition.this.battleId, xGrabPositionData, roleBaseInfo.getCampId(), 1, SessionGrabPosition.this.positionId);
/*     */         
/* 150 */         return;
/*     */       }
/*     */       
/* 153 */       GrabSucRecord record = doRecord(xRoleGrabData, xGrabPositionData);
/*     */       
/* 155 */       GrabPositionManager.setPositionState(SessionGrabPosition.this.battleId, xGrabPositionData, roleBaseInfo.getCampId(), 3, SessionGrabPosition.this.positionId);
/*     */       
/*     */ 
/* 158 */       xGrabPositionData.getSessiondata().setProtectsessionid(new SessionProtectPosition(SessionGrabPosition.this.protectInterval, SessionGrabPosition.this.battleId, SessionGrabPosition.this.positionId).getSessionId());
/*     */       
/*     */ 
/* 161 */       SingleBattleInterface.battleBro(SessionGrabPosition.this.battleId, new SGrapPositionSucBro(SessionGrabPosition.this.positionId, SessionGrabPosition.this.roleId), false);
/*     */       
/*     */ 
/* 164 */       final int campId = roleBaseInfo.getCampId();
/* 165 */       Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 166 */       intExtraInfoEntries.put(Integer.valueOf(1300), Integer.valueOf(campId));
/* 167 */       MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_SINGLE_BATTLE_POSITION, xGrabPositionData.getInstanceid(), intExtraInfoEntries, null, null, null, new MapCallback()
/*     */       {
/*     */ 
/*     */ 
/*     */         public boolean onResult(Boolean result)
/*     */         {
/*     */ 
/*     */ 
/* 175 */           GameServer.logger().info(String.format("[singleBattle]AfterGrabSuc.processImp@ change map entity|battleId=%d|position=%d|campId=%d|res=%s", new Object[] { Long.valueOf(SessionGrabPosition.this.battleId), Integer.valueOf(SessionGrabPosition.this.positionId), Integer.valueOf(campId), result }));
/*     */           
/*     */ 
/*     */ 
/* 179 */           return true;
/*     */         }
/*     */         
/*     */ 
/*     */         public boolean isCallInProcedure()
/*     */         {
/* 185 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 189 */       });
/* 190 */       TriggerEventsManger.getInstance().triggerEvent(new GrabPositionSuc(), new EventArg_GrabPositionSuc(SessionGrabPosition.this.roleId, SessionGrabPosition.this.positionId, record.isPositionFirstGrabed()));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private GrabSucRecord doRecord(RoleGrabData xRoleGrabData, GrabPositionData xGrabPositionData)
/*     */     {
/* 202 */       GrabSucRecord record = new GrabSucRecord(null);
/*     */       
/* 204 */       addRoleGrabData(xRoleGrabData);
/*     */       
/* 206 */       addPostionGrabData(xGrabPositionData, record);
/* 207 */       return record;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void addPostionGrabData(GrabPositionData xGrabPositionData, GrabSucRecord record)
/*     */     {
/* 217 */       RoleGrabPositionData xRoleGrabPositionData = (RoleGrabPositionData)xGrabPositionData.getRole2grabdata().get(Long.valueOf(SessionGrabPosition.this.roleId));
/* 218 */       if (xRoleGrabPositionData == null)
/*     */       {
/* 220 */         xGrabPositionData.getRole2grabdata().put(Long.valueOf(SessionGrabPosition.this.roleId), xRoleGrabPositionData = Pod.newRoleGrabPositionData());
/*     */       }
/* 222 */       xRoleGrabPositionData.getGrabtime().add(Long.valueOf(DateTimeUtils.getCurrTimeInMillis()));
/* 223 */       if (xGrabPositionData.getFirstgrabroleid() > 0L)
/*     */       {
/* 225 */         return;
/*     */       }
/*     */       
/* 228 */       xGrabPositionData.setFirstgrabroleid(SessionGrabPosition.this.roleId);
/* 229 */       xGrabPositionData.setFirstgrabtime(DateTimeUtils.getCurrTimeInMillis());
/*     */       
/* 231 */       record.setPositionFirstGrabed(true);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private class GrabSucRecord
/*     */     {
/*     */       private boolean isPositionFirstGrabed;
/*     */       
/*     */ 
/*     */       private GrabSucRecord() {}
/*     */       
/*     */ 
/*     */       public boolean isPositionFirstGrabed()
/*     */       {
/* 246 */         return this.isPositionFirstGrabed;
/*     */       }
/*     */       
/*     */       public void setPositionFirstGrabed(boolean isPositionFirstGrabed)
/*     */       {
/* 251 */         this.isPositionFirstGrabed = isPositionFirstGrabed;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void addRoleGrabData(RoleGrabData xRoleGrabData)
/*     */     {
/* 263 */       Integer count = (Integer)xRoleGrabData.getOwnpositions().get(Integer.valueOf(SessionGrabPosition.this.positionId));
/* 264 */       if (count == null)
/*     */       {
/* 266 */         count = Integer.valueOf(0);
/*     */       }
/* 268 */       xRoleGrabData.getOwnpositions().put(Integer.valueOf(SessionGrabPosition.this.positionId), Integer.valueOf(count.intValue() + 1));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\SessionGrabPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */