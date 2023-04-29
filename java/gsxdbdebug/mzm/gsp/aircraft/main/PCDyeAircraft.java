/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.aircraft.SAircraftNormalRes;
/*     */ import mzm.gsp.aircraft.SDyeAircraftSuccess;
/*     */ import mzm.gsp.aircraft.event.AircraftChangeReason;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChange;
/*     */ import mzm.gsp.aircraft.event.AircraftModelChangeArg;
/*     */ import mzm.gsp.feijian.confbean.FeiJianDyeBean;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianDyeColorCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ItemResultEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AircraftInfo;
/*     */ import xbean.Role2AircraftInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCDyeAircraft extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int aircraftCfgId;
/*     */   private final int dyeColorId;
/*     */   private final boolean isUseYuanBao;
/*     */   private final int clientNeedYuanBao;
/*     */   private final long clientYuanBao;
/*     */   
/*     */   public PCDyeAircraft(long roleId, int aircraftCfgId, int colorId, int isUseYuanBao, int clientNeedYuanBao, long clientYuanBao)
/*     */   {
/*  45 */     this.roleId = roleId;
/*  46 */     this.aircraftCfgId = aircraftCfgId;
/*  47 */     this.dyeColorId = colorId;
/*  48 */     this.isUseYuanBao = (isUseYuanBao == 1);
/*  49 */     this.clientNeedYuanBao = clientNeedYuanBao;
/*  50 */     this.clientYuanBao = clientYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  56 */     if (!AircraftManager.isAircraftSwitchOpen(this.roleId))
/*     */     {
/*  58 */       onFail(1);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     String userId = RoleInterface.getUserId(this.roleId);
/*  63 */     if (userId == null)
/*     */     {
/*  65 */       onFail(7);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  72 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1893, true, true))
/*     */     {
/*  74 */       onFail(22);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!AircraftManager.isRoleLevelFunctionOpen(this.roleId))
/*     */     {
/*  80 */       onFail(21);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(this.roleId, true);
/*  85 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  87 */       onFail(8);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     AircraftInfo xAircraftInfo = (AircraftInfo)xRole2AircraftInfo.getOwn_aircraft_map().get(Integer.valueOf(this.aircraftCfgId));
/*  92 */     if (xAircraftInfo == null)
/*     */     {
/*  94 */       onFail(3);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     SFeiJianDyeColorCfg sFeiJianDyeColorCfg = SFeiJianDyeColorCfg.get(this.aircraftCfgId);
/*  99 */     if (sFeiJianDyeColorCfg == null)
/*     */     {
/* 101 */       onFail(5);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     FeiJianDyeBean feiJianDyeBean = (FeiJianDyeBean)sFeiJianDyeColorCfg.fei_jian_dye_map.get(Integer.valueOf(this.dyeColorId));
/* 106 */     if (feiJianDyeBean == null)
/*     */     {
/* 108 */       onFail(5);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (xAircraftInfo.getDye_color_id() == this.dyeColorId)
/*     */     {
/* 114 */       onFail(14);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     int ownItemNum = ItemInterface.getItemNumberByType(this.roleId, 340600000, feiJianDyeBean.cost_item_type, true);
/* 119 */     int needCutItem = feiJianDyeBean.item_count;
/* 120 */     if (!this.isUseYuanBao)
/*     */     {
/* 122 */       if (ownItemNum < feiJianDyeBean.item_count)
/*     */       {
/* 124 */         onFail(15);
/* 125 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 130 */       if (ownItemNum >= feiJianDyeBean.item_count)
/*     */       {
/* 132 */         onFail(18);
/* 133 */         return false;
/*     */       }
/* 135 */       needCutItem = ownItemNum;
/*     */       
/* 137 */       long serverYuanBao = QingfuInterface.getBalance(userId, true);
/* 138 */       if (serverYuanBao != this.clientYuanBao)
/*     */       {
/* 140 */         Map<String, Object> extraMap = new HashMap();
/* 141 */         extraMap.put("server_yuan_bao", Long.valueOf(serverYuanBao));
/*     */         
/* 143 */         onFail(16, extraMap);
/* 144 */         return false;
/*     */       }
/*     */       
/* 147 */       int itemYuanBaoPrice = ItemInterface.getItemYuanBaoPrice(feiJianDyeBean.item_id);
/* 148 */       int serverNeedYuanBao = itemYuanBaoPrice * (feiJianDyeBean.item_count - ownItemNum);
/* 149 */       if (serverNeedYuanBao != this.clientNeedYuanBao)
/*     */       {
/* 151 */         Map<String, Object> extraMap = new HashMap();
/* 152 */         extraMap.put("item_yuan_bao_price", Integer.valueOf(itemYuanBaoPrice));
/* 153 */         extraMap.put("server_need_yuan_bao", Integer.valueOf(serverNeedYuanBao));
/*     */         
/* 155 */         onFail(17, extraMap);
/* 156 */         return false;
/*     */       }
/*     */       
/* 159 */       if (serverNeedYuanBao <= 0)
/*     */       {
/* 161 */         Map<String, Object> extraMap = new HashMap();
/* 162 */         extraMap.put("item_yuan_bao_price", Integer.valueOf(itemYuanBaoPrice));
/* 163 */         extraMap.put("server_need_yuan_bao", Integer.valueOf(serverNeedYuanBao));
/*     */         
/* 165 */         onFail(20, extraMap);
/* 166 */         return false;
/*     */       }
/*     */       
/* 169 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, serverNeedYuanBao, CostType.COST_BIND_FIRST_AIRCRAFT_DYE, new TLogArg(LogReason.DYE_AIRCRAFT));
/*     */       
/* 171 */       if (costResult != CostResult.Success)
/*     */       {
/* 173 */         Map<String, Object> extraMap = new HashMap();
/* 174 */         extraMap.put("item_yuan_bao_price", Integer.valueOf(itemYuanBaoPrice));
/* 175 */         extraMap.put("server_need_yuan_bao", Integer.valueOf(serverNeedYuanBao));
/* 176 */         extraMap.put("ret", Integer.valueOf(costResult.code));
/* 177 */         extraMap.put("desc", costResult.desc);
/*     */         
/* 179 */         onFail(19, extraMap);
/*     */         
/* 181 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 185 */     if (needCutItem > 0)
/*     */     {
/* 187 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemsByItemType(this.roleId, feiJianDyeBean.cost_item_type, needCutItem, new TLogArg(LogReason.DYE_AIRCRAFT, this.aircraftCfgId));
/*     */       
/* 189 */       if (!itemOperateResult.success())
/*     */       {
/* 191 */         Map<String, Object> extraMap = new HashMap();
/* 192 */         extraMap.put("ret", Integer.valueOf(itemOperateResult.getResultEnum().ret));
/* 193 */         extraMap.put("ret_msg", itemOperateResult.getResultEnum().retMsg);
/* 194 */         extraMap.put("cut_item", Integer.valueOf(needCutItem));
/*     */         
/* 196 */         onFail(13, extraMap);
/* 197 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 201 */     xAircraftInfo.setDye_color_id(this.dyeColorId);
/*     */     
/* 203 */     if (xRole2AircraftInfo.getCurrent_aircraft_cfg_id() == this.aircraftCfgId)
/*     */     {
/* 205 */       TriggerEventsManger.getInstance().triggerEvent(new AircraftModelChange(), new AircraftModelChangeArg(this.roleId, AircraftChangeReason.COLOR_CHANGE), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 211 */     tlogDyeAircraft(userId);
/*     */     
/* 213 */     SDyeAircraftSuccess sDyeAircraftSuccess = new SDyeAircraftSuccess();
/* 214 */     sDyeAircraftSuccess.aircraft_cfg_id = this.aircraftCfgId;
/* 215 */     sDyeAircraftSuccess.dye_color_id = this.dyeColorId;
/*     */     
/* 217 */     OnlineManager.getInstance().send(this.roleId, sDyeAircraftSuccess);
/*     */     
/* 219 */     StringBuilder sbLog = new StringBuilder();
/* 220 */     sbLog.append("[aircraft]PCDyeAircraft.processImp@dye aircraft success");
/* 221 */     sbLog.append("|role_id=").append(this.roleId);
/* 222 */     sbLog.append("|aircraft_cfg_id=").append(this.aircraftCfgId);
/* 223 */     sbLog.append("|color_id=").append(this.dyeColorId);
/* 224 */     sbLog.append("|client_yuan_bao=").append(this.clientYuanBao);
/* 225 */     sbLog.append("|is_use_yuan_bao=").append(this.isUseYuanBao);
/* 226 */     sbLog.append("|client_cal_yuan_bao").append(this.clientNeedYuanBao);
/*     */     
/* 228 */     GameServer.logger().info(sbLog.toString());
/*     */     
/* 230 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 235 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 240 */     StringBuilder sbLog = new StringBuilder();
/* 241 */     sbLog.append("[aircraft]PCDyeAircraft.processImp@dye aircraft failed");
/* 242 */     sbLog.append("|ret=").append(ret);
/* 243 */     sbLog.append("|role_id=").append(this.roleId);
/* 244 */     sbLog.append("|aircraft_cfg_id=").append(this.aircraftCfgId);
/* 245 */     sbLog.append("|color_id=").append(this.dyeColorId);
/* 246 */     sbLog.append("|client_yuan_bao=").append(this.clientYuanBao);
/* 247 */     sbLog.append("|is_use_yuan_bao=").append(this.isUseYuanBao);
/* 248 */     sbLog.append("|client_cal_yuan_bao").append(this.clientNeedYuanBao);
/*     */     
/* 250 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 252 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 254 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 257 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 259 */     SAircraftNormalRes sAircraftNormalRes = new SAircraftNormalRes();
/* 260 */     sAircraftNormalRes.ret = ret;
/*     */     
/* 262 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sAircraftNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void tlogDyeAircraft(String userId)
/*     */   {
/* 270 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 272 */     StringBuilder sbLog = new StringBuilder();
/* 273 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 274 */     sbLog.append(userId).append('|');
/* 275 */     sbLog.append(this.roleId).append('|');
/* 276 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 278 */     sbLog.append(this.aircraftCfgId).append('|');
/* 279 */     sbLog.append(this.dyeColorId);
/*     */     
/* 281 */     TLogManager.getInstance().addLog(this.roleId, "DyeAircraftStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\PCDyeAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */