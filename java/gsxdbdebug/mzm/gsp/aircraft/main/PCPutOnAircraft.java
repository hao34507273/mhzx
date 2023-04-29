/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.aircraft.SAircraftNormalRes;
/*     */ import mzm.gsp.aircraft.SPutOnAircraftSuccess;
/*     */ import mzm.gsp.aircraft.event.AircraftChangeReason;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChange;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AircraftInfo;
/*     */ import xbean.Role2AircraftInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCPutOnAircraft extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int aircraftCfgId;
/*     */   
/*     */   public PCPutOnAircraft(long roleId, int aircraftCfgId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.aircraftCfgId = aircraftCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!AircraftManager.isAircraftSwitchOpen(this.roleId))
/*     */     {
/*  38 */       onFail(1);
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     String userId = RoleInterface.getUserId(this.roleId);
/*  43 */     if (userId == null)
/*     */     {
/*  45 */       onFail(7);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  52 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1891, true, true))
/*     */     {
/*  54 */       onFail(22);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!AircraftManager.isRoleLevelFunctionOpen(this.roleId))
/*     */     {
/*  60 */       onFail(21);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(this.roleId, true);
/*  66 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  68 */       onFail(7);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int oldAircraftCfgId = xRole2AircraftInfo.getCurrent_aircraft_cfg_id();
/*  73 */     if (this.aircraftCfgId == oldAircraftCfgId)
/*     */     {
/*  75 */       onFail(10);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     Map<Integer, AircraftInfo> xAircraftInfoMap = xRole2AircraftInfo.getOwn_aircraft_map();
/*  80 */     if (!xAircraftInfoMap.containsKey(Integer.valueOf(this.aircraftCfgId)))
/*     */     {
/*  82 */       onFail(3);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     xRole2AircraftInfo.setCurrent_aircraft_cfg_id(this.aircraftCfgId);
/*     */     
/*     */ 
/*  89 */     tlogChangeAircraft(userId, oldAircraftCfgId);
/*     */     
/*  91 */     TriggerEventsManger.getInstance().triggerEvent(new AircraftModelChange(), new mzm.gsp.aircraft.event.AircraftModelChangeArg(this.roleId, AircraftChangeReason.PUT_ON), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*  95 */     SPutOnAircraftSuccess sPutOnAircraftSuccess = new SPutOnAircraftSuccess();
/*  96 */     sPutOnAircraftSuccess.aircraft_cfg_id = this.aircraftCfgId;
/*     */     
/*  98 */     OnlineManager.getInstance().send(this.roleId, sPutOnAircraftSuccess);
/*     */     
/* 100 */     StringBuilder sBuilder = new StringBuilder();
/* 101 */     sBuilder.append("[aircraft]PCPutOnAircraft.processImp@put on new aircraft");
/* 102 */     sBuilder.append("|role_id=").append(this.roleId);
/* 103 */     sBuilder.append("|aircraft_cfg_id=").append(this.aircraftCfgId);
/* 104 */     sBuilder.append("|old_aircraft_cfg_id=").append(oldAircraftCfgId);
/*     */     
/* 106 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 113 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 118 */     StringBuilder sbLog = new StringBuilder();
/* 119 */     sbLog.append("[aircraft]PCPutOnAircraft.processImp@put on aircraft failed");
/* 120 */     sbLog.append("|ret=").append(ret);
/* 121 */     sbLog.append("|role_id=").append(this.roleId);
/* 122 */     sbLog.append("|aircraft_cfg_id=").append(this.aircraftCfgId);
/* 123 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 125 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 127 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 130 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 132 */     SAircraftNormalRes sAircraftNormalRes = new SAircraftNormalRes();
/* 133 */     sAircraftNormalRes.ret = ret;
/*     */     
/* 135 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sAircraftNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void tlogChangeAircraft(String userId, int oldAircraftCfgId)
/*     */   {
/* 143 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 145 */     StringBuilder sbLog = new StringBuilder();
/* 146 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 147 */     sbLog.append(userId).append('|');
/* 148 */     sbLog.append(this.roleId).append('|');
/* 149 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 151 */     sbLog.append(oldAircraftCfgId).append('|');
/* 152 */     sbLog.append(this.aircraftCfgId);
/*     */     
/* 154 */     TLogManager.getInstance().addLog(this.roleId, "ChangeAircraftStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\PCPutOnAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */