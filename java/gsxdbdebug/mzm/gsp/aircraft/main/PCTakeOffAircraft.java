/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.aircraft.SAircraftNormalRes;
/*     */ import mzm.gsp.aircraft.STakeOffAircraftSuccess;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChange;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2AircraftInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCTakeOffAircraft extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCTakeOffAircraft(long roleId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!AircraftManager.isAircraftSwitchOpen(this.roleId))
/*     */     {
/*  34 */       onFail(1);
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     String userId = RoleInterface.getUserId(this.roleId);
/*  39 */     if (userId == null)
/*     */     {
/*  41 */       onFail(7);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  48 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1892, true, true))
/*     */     {
/*  50 */       onFail(22);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!AircraftManager.isRoleLevelFunctionOpen(this.roleId))
/*     */     {
/*  56 */       onFail(21);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(this.roleId, true);
/*  61 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  63 */       onFail(8);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (xRole2AircraftInfo.getCurrent_aircraft_cfg_id() < 0)
/*     */     {
/*  69 */       onFail(9);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     int oldAircraftCfgId = xRole2AircraftInfo.getCurrent_aircraft_cfg_id();
/*     */     
/*  75 */     xRole2AircraftInfo.setCurrent_aircraft_cfg_id(0);
/*     */     
/*  77 */     TriggerEventsManger.getInstance().triggerEvent(new AircraftModelChange(), new AircraftModelChangeArg(this.roleId, mzm.gsp.aircraft.event.AircraftChangeReason.TAKE_OFF), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*  81 */     STakeOffAircraftSuccess sTakeOffAircraftSuccess = new STakeOffAircraftSuccess();
/*     */     
/*  83 */     OnlineManager.getInstance().send(this.roleId, sTakeOffAircraftSuccess);
/*     */     
/*  85 */     StringBuilder sBuilder = new StringBuilder();
/*  86 */     sBuilder.append("[aircraft]PCTakeOffAircraft.processImp@take off aircraft success");
/*  87 */     sBuilder.append("|role_id=").append(this.roleId);
/*  88 */     sBuilder.append("|old_aircraft_cfg_id=").append(oldAircraftCfgId);
/*     */     
/*  90 */     GameServer.logger().info(sBuilder.toString());
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/*  96 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 101 */     StringBuilder sbLog = new StringBuilder();
/* 102 */     sbLog.append("[aircraft]PCTakeOffAircraft.processImp@take off aircraft failed");
/* 103 */     sbLog.append("|ret=").append(ret);
/* 104 */     sbLog.append("|role_id=").append(this.roleId);
/* 105 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 107 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 109 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 112 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 114 */     SAircraftNormalRes sAircraftNormalRes = new SAircraftNormalRes();
/* 115 */     sAircraftNormalRes.ret = ret;
/*     */     
/* 117 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sAircraftNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\PCTakeOffAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */