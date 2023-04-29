/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.aircraft.SSyncAircraftInfo;
/*     */ import mzm.gsp.aircraft.event.AircraftPropertyChangeArg;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.item.confbean.SAirCraftItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Role2AircraftInfo;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     long roleId = ((Long)this.arg).longValue();
/*  27 */     int aircraftItemCfgId = ItemInterface.getEquipedAirCraftItemId(roleId, true);
/*  28 */     if (aircraftItemCfgId > 0)
/*     */     {
/*  30 */       SAirCraftItem sAirCraftItem = SAirCraftItem.get(aircraftItemCfgId);
/*  31 */       if (sAirCraftItem != null)
/*     */       {
/*  33 */         int aircraftCfgId = sAirCraftItem.aircraftid;
/*  34 */         SFeiJianCfg sFeiJianCfg = SFeiJianCfg.get(aircraftCfgId);
/*  35 */         if (sFeiJianCfg != null)
/*     */         {
/*  37 */           Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getAndInitAircraftInfo(roleId);
/*     */           
/*  39 */           Map<Integer, xbean.AircraftInfo> xAircraftInfoMap = xRole2AircraftInfo.getOwn_aircraft_map();
/*     */           
/*  41 */           if ((xRole2AircraftInfo.getCurrent_aircraft_cfg_id() <= 0) && (!xAircraftInfoMap.containsKey(Integer.valueOf(aircraftCfgId))))
/*     */           {
/*  43 */             xRole2AircraftInfo.setCurrent_aircraft_cfg_id(aircraftCfgId);
/*  44 */             xAircraftInfoMap.put(Integer.valueOf(aircraftCfgId), xbean.Pod.newAircraftInfo());
/*     */             
/*  46 */             RoleEquipBag roleEquipBag = ItemInterface.getRoleEquipBag(roleId);
/*  47 */             roleEquipBag.removeByGrid(8);
/*     */             
/*  49 */             tlogAircraftMove(roleId, aircraftCfgId, aircraftItemCfgId);
/*     */             
/*  51 */             if (!sFeiJianCfg.proList.isEmpty())
/*     */             {
/*  53 */               TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.aircraft.event.AircraftPropertyChange(), new AircraftPropertyChangeArg(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  61 */     SSyncAircraftInfo sSyncAircraftInfo = new SSyncAircraftInfo();
/*     */     
/*  63 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(roleId, true);
/*  64 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  66 */       OnlineManager.getInstance().send(roleId, sSyncAircraftInfo);
/*  67 */       return true;
/*     */     }
/*     */     
/*  70 */     sSyncAircraftInfo.current_aircraft_cfg_id = xRole2AircraftInfo.getCurrent_aircraft_cfg_id();
/*  71 */     for (Map.Entry<Integer, xbean.AircraftInfo> entry : xRole2AircraftInfo.getOwn_aircraft_map().entrySet())
/*     */     {
/*  73 */       mzm.gsp.aircraft.AircraftInfo aircraftInfo = new mzm.gsp.aircraft.AircraftInfo();
/*  74 */       aircraftInfo.dye_color_id = ((xbean.AircraftInfo)entry.getValue()).getDye_color_id();
/*     */       
/*  76 */       sSyncAircraftInfo.own_aircraft_map.put(entry.getKey(), aircraftInfo);
/*     */     }
/*  78 */     OnlineManager.getInstance().send(roleId, sSyncAircraftInfo);
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogAircraftMove(long roleId, int aircraftCfgId, int aircraftItemCfgId)
/*     */   {
/*  88 */     String userId = RoleInterface.getUserId(roleId);
/*  89 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/*  91 */     StringBuilder sbLog = new StringBuilder();
/*  92 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  93 */     sbLog.append(userId).append('|');
/*  94 */     sbLog.append(roleId).append('|');
/*  95 */     sbLog.append(roleLevel).append('|');
/*     */     
/*  97 */     sbLog.append(aircraftCfgId).append('|');
/*  98 */     sbLog.append(aircraftItemCfgId);
/*     */     
/* 100 */     TLogManager.getInstance().addLog(roleId, "AircraftMoveStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */