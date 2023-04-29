/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.aircraft.SAircraftNormalRes;
/*     */ import mzm.gsp.aircraft.SUseAircraftItemSuccess;
/*     */ import mzm.gsp.aircraft.event.AircraftPropertyChange;
/*     */ import mzm.gsp.aircraft.event.AircraftPropertyChangeArg;
/*     */ import mzm.gsp.aircraft.event.UnlockAircraft;
/*     */ import mzm.gsp.aircraft.event.UnlockAircraftArg;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.item.confbean.SAirCraftItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AircraftInfo;
/*     */ import xbean.Role2AircraftInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseAircraftItem extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long itemUuid;
/*     */   
/*     */   public PCUseAircraftItem(long roleId, long itemUuid)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.itemUuid = itemUuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!AircraftManager.isAircraftSwitchOpen(this.roleId))
/*     */     {
/*  45 */       onFail(1);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userId = RoleInterface.getUserId(this.roleId);
/*  50 */     if (userId == null)
/*     */     {
/*  52 */       onFail(7);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  59 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1894, true, true))
/*     */     {
/*  61 */       onFail(22);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!AircraftManager.isRoleLevelFunctionOpen(this.roleId))
/*     */     {
/*  67 */       onFail(21);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.itemUuid);
/*  73 */     if (basicItem == null)
/*     */     {
/*  75 */       onFail(6);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     int itemCfgId = basicItem.getCfgId();
/*  80 */     SAirCraftItem sItemCfg = SAirCraftItem.get(itemCfgId);
/*  81 */     if (sItemCfg == null)
/*     */     {
/*  83 */       onFail(12);
/*  84 */       return false;
/*     */     }
/*  86 */     int airCraftId = sItemCfg.aircraftid;
/*     */     
/*  88 */     SFeiJianCfg sFeiJianCfg = SFeiJianCfg.get(airCraftId);
/*  89 */     if (sFeiJianCfg == null)
/*     */     {
/*  91 */       onFail(2);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getAndInitAircraftInfo(this.roleId);
/*  96 */     Map<Integer, AircraftInfo> xAircraftInfoMap = xRole2AircraftInfo.getOwn_aircraft_map();
/*     */     
/*  98 */     if (xAircraftInfoMap.containsKey(Integer.valueOf(airCraftId)))
/*     */     {
/* 100 */       onFail(4);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     boolean removeResult = ItemInterface.removeItemByUuid(this.roleId, this.itemUuid, 1, new TLogArg(mzm.gsp.tlog.LogReason.UNLOCK_NEW_AIRCRAFT, itemCfgId));
/*     */     
/* 106 */     if (!removeResult)
/*     */     {
/* 108 */       onFail(13);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     xAircraftInfoMap.put(Integer.valueOf(airCraftId), xbean.Pod.newAircraftInfo());
/*     */     
/* 114 */     tlogUnlockAircraft(userId, airCraftId);
/*     */     
/* 116 */     TriggerEventsManger.getInstance().triggerEvent(new UnlockAircraft(), new UnlockAircraftArg(this.roleId, airCraftId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 119 */     if (!sFeiJianCfg.proList.isEmpty())
/*     */     {
/* 121 */       TriggerEventsManger.getInstance().triggerEvent(new AircraftPropertyChange(), new AircraftPropertyChangeArg(this.roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 125 */     SUseAircraftItemSuccess sUseAircraftItemSuccess = new SUseAircraftItemSuccess();
/* 126 */     sUseAircraftItemSuccess.add_aircraft_cfg_id = airCraftId;
/*     */     
/* 128 */     OnlineManager.getInstance().send(this.roleId, sUseAircraftItemSuccess);
/*     */     
/* 130 */     StringBuilder sBuilder = new StringBuilder();
/* 131 */     sBuilder.append("[aircraft]PCUseAircraftItem.processImp@unlock aircraft success");
/* 132 */     sBuilder.append("|role_id=").append(this.roleId);
/* 133 */     sBuilder.append("|item_uuid=").append(this.itemUuid);
/* 134 */     sBuilder.append("|aircraft_id=").append(airCraftId);
/*     */     
/* 136 */     GameServer.logger().info(sBuilder.toString());
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 142 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 147 */     StringBuilder sbLog = new StringBuilder();
/* 148 */     sbLog.append("[aircraft]PCUseAircraftItem.processImp@use aircraft item failed");
/* 149 */     sbLog.append("|ret=").append(ret);
/* 150 */     sbLog.append("|role_id=").append(this.roleId);
/* 151 */     sbLog.append("|item_uuid=").append(this.itemUuid);
/*     */     
/* 153 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 155 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 157 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 160 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 162 */     SAircraftNormalRes sAircraftNormalRes = new SAircraftNormalRes();
/* 163 */     sAircraftNormalRes.ret = ret;
/*     */     
/* 165 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sAircraftNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void tlogUnlockAircraft(String userId, int aircraftCfgId)
/*     */   {
/* 173 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 175 */     StringBuilder sbLog = new StringBuilder();
/* 176 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 177 */     sbLog.append(userId).append('|');
/* 178 */     sbLog.append(this.roleId).append('|');
/* 179 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 181 */     sbLog.append(aircraftCfgId);
/*     */     
/* 183 */     TLogManager.getInstance().addLog(this.roleId, "UnlockAircraftStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\PCUseAircraftItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */