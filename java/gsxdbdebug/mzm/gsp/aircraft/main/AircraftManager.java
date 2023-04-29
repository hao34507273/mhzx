/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.aircraft.event.AircraftChangeReason;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChange;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChangeArg;
/*     */ import mzm.gsp.aircraft.event.AircraftPropertyChange;
/*     */ import mzm.gsp.aircraft.event.AircraftPropertyChangeArg;
/*     */ import mzm.gsp.couple.main.PCLeaveRideReq;
/*     */ import mzm.gsp.feijian.confbean.SFeJianConsts;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.PLand;
/*     */ import mzm.gsp.map.main.scene.PositionWithCfgid;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2AircraftInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2aircraft;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AircraftManager
/*     */ {
/*     */   static Role2AircraftInfo getAndInitAircraftInfo(long roleId)
/*     */   {
/*  48 */     Role2AircraftInfo xRole2AircraftInfo = Role2aircraft.get(Long.valueOf(roleId));
/*  49 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  51 */       xRole2AircraftInfo = Pod.newRole2AircraftInfo();
/*  52 */       Role2aircraft.add(Long.valueOf(roleId), xRole2AircraftInfo);
/*     */     }
/*     */     
/*  55 */     return xRole2AircraftInfo;
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
/*     */ 
/*     */   static Role2AircraftInfo getRole2AircraftInfo(long roleId, boolean isRemainRolelock)
/*     */   {
/*  70 */     Role2AircraftInfo xRole2AircraftInfo = null;
/*  71 */     if (isRemainRolelock)
/*     */     {
/*  73 */       xRole2AircraftInfo = Role2aircraft.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  77 */       xRole2AircraftInfo = Role2aircraft.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  80 */     return xRole2AircraftInfo;
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
/*     */   static List<Integer> getOwnAircraftCfgIdList(long roleId, boolean isRemainRolelock)
/*     */   {
/*  93 */     Role2AircraftInfo xRole2AircraftInfo = getRole2AircraftInfo(roleId, isRemainRolelock);
/*  94 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  96 */       return null;
/*     */     }
/*     */     
/*  99 */     List<Integer> ownAircraftCfgIdList = new ArrayList();
/* 100 */     ownAircraftCfgIdList.addAll(xRole2AircraftInfo.getOwn_aircraft_map().keySet());
/*     */     
/* 102 */     return ownAircraftCfgIdList;
/*     */   }
/*     */   
/*     */   static boolean isAircraftSwitchOpen(long roleId)
/*     */   {
/* 107 */     if (!OpenInterface.getOpenStatus(509))
/*     */     {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (OpenInterface.isBanPlay(roleId, 509))
/*     */     {
/* 114 */       OpenInterface.sendBanPlayMsg(roleId, 509);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isRoleLevelFunctionOpen(long roleId)
/*     */   {
/* 123 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 125 */     if (roleLevel < SFeJianConsts.getInstance().fei_jian_open_level)
/*     */     {
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     return true;
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
/*     */   static int removeAircraft(long roleId, int aircraftCfgId)
/*     */   {
/* 144 */     SFeiJianCfg cfg = SFeiJianCfg.get(aircraftCfgId);
/* 145 */     if (cfg == null)
/*     */     {
/* 147 */       GameServer.logger().error(String.format("[aircraft]AircraftManager.removeAircraft@aircraft cfg not exist|roleid=%d|aircraft_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(aircraftCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 151 */       return 64095;
/*     */     }
/*     */     
/* 154 */     String userId = RoleInterface.getUserId(roleId);
/* 155 */     if (userId == null)
/*     */     {
/* 157 */       GameServer.logger().error(String.format("[aircraft]AircraftManager.removeAircraft@aircraft role data not exist|roleid=%d|aircraft_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(aircraftCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 161 */       return 64094;
/*     */     }
/*     */     
/* 164 */     Lockeys.get(User.getTable(), userId);
/*     */     
/* 166 */     Role2AircraftInfo xRole2AircraftInfo = Role2aircraft.get(Long.valueOf(roleId));
/* 167 */     if (xRole2AircraftInfo == null)
/*     */     {
/* 169 */       GameServer.logger().error(String.format("[aircraft]AircraftManager.removeAircraft@role aircraft data not exist|roleid=%d|aircraft_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(aircraftCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 173 */       return 64096;
/*     */     }
/*     */     
/* 176 */     if (xRole2AircraftInfo.getOwn_aircraft_map().remove(Integer.valueOf(aircraftCfgId)) == null)
/*     */     {
/* 178 */       GameServer.logger().error(String.format("[aircraft]AircraftManager.removeAircraft@role not own the aircraft|roleid=%d|aircraft_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(aircraftCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 182 */       return 64096;
/*     */     }
/*     */     
/* 185 */     if (xRole2AircraftInfo.getCurrent_aircraft_cfg_id() == aircraftCfgId)
/*     */     {
/* 187 */       if (RoleStatusInterface.containsStatus(roleId, 25, true))
/*     */       {
/* 189 */         NoneRealTimeTaskManager.getInstance().addTask(new PCLeaveRideReq(roleId));
/* 190 */         NoneRealTimeTaskManager.getInstance().addTask(new PLandOnRemoveAircraft(roleId));
/*     */       }
/*     */       
/* 193 */       if (RoleStatusInterface.containsStatus(roleId, 2, true))
/*     */       {
/* 195 */         NoneRealTimeTaskManager.getInstance().addTask(new PLandOnRemoveAircraft(roleId));
/*     */       }
/*     */       
/* 198 */       xRole2AircraftInfo.setCurrent_aircraft_cfg_id(0);
/*     */       
/* 200 */       tlogRemoveAircraft(userId, roleId, aircraftCfgId);
/*     */       
/* 202 */       TriggerEventsManger.getInstance().triggerEvent(new AircraftModelChange(), new AircraftModelChangeArg(roleId, AircraftChangeReason.TAKE_OFF), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 207 */     if (!cfg.proList.isEmpty())
/*     */     {
/* 209 */       TriggerEventsManger.getInstance().triggerEvent(new AircraftPropertyChange(), new AircraftPropertyChangeArg(roleId));
/*     */     }
/*     */     
/* 212 */     GameServer.logger().info(String.format("[aircraft]AircraftManager.removeAircraft@remove the aircraft success|roleid=%d|aircraft_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(aircraftCfgId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 217 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 222 */         OnlineManager.getInstance().forceReconnect(this.val$roleId);
/* 223 */         return true;
/*     */       }
/*     */       
/* 226 */     });
/* 227 */     return 0;
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
/*     */ 
/*     */   static void tlogRemoveAircraft(String userId, long roleId, int aircraftCfgId)
/*     */   {
/* 242 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 244 */     StringBuilder sbLog = new StringBuilder();
/* 245 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 246 */     sbLog.append(userId).append('|');
/* 247 */     sbLog.append(roleId).append('|');
/* 248 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 250 */     sbLog.append(aircraftCfgId);
/*     */     
/* 252 */     TLogManager.getInstance().addLog(roleId, "AircraftDelete", sbLog.toString());
/*     */   }
/*     */   
/*     */   private static class PLandOnRemoveAircraft extends LogicProcedure implements MapCallback<Map<Long, PositionWithCfgid>>
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PLandOnRemoveAircraft(long roleId)
/*     */     {
/* 261 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isCallInProcedure()
/*     */     {
/* 267 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean onResult(Map<Long, PositionWithCfgid> result)
/*     */     {
/* 273 */       Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 274 */       if (teamId == null)
/*     */       {
/* 276 */         land(result);
/*     */       }
/*     */       else
/*     */       {
/* 280 */         long teamRoleId = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/* 281 */         if (teamRoleId == this.roleId)
/*     */         {
/* 283 */           land(result);
/*     */         }
/*     */       }
/*     */       
/* 287 */       return true;
/*     */     }
/*     */     
/*     */     private void land(Map<Long, PositionWithCfgid> result)
/*     */     {
/* 292 */       PositionWithCfgid positionWithCfgid = (PositionWithCfgid)result.get(Long.valueOf(this.roleId));
/* 293 */       if (positionWithCfgid == null)
/*     */       {
/* 295 */         return;
/*     */       }
/*     */       
/* 298 */       new PLand(this.roleId, positionWithCfgid.getX(), positionWithCfgid.getY()).execute();
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 304 */       MapInterface.getRolePosition(this.roleId, this);
/*     */       
/* 306 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\AircraftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */