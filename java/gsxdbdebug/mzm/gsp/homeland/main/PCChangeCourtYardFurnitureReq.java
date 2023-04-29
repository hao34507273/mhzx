/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.SChangeCourtYardFurnitureSuccess;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PCChangeCourtYardFurnitureReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int furnitureCfgId;
/*     */   private final long furnitureUuid;
/*     */   private int pos;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCChangeCourtYardFurnitureReq(long roleId, int furnitureCfgId, long furnitureUuid)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.furnitureCfgId = furnitureCfgId;
/*  29 */     this.furnitureUuid = furnitureUuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!CourtYardManager.isCourtLevelUpSwitchOpenForRole(this.roleId))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  46 */     if (homeInfoWrapper == null)
/*     */     {
/*  48 */       onChangeCourtYardFurnitureReqFail(23);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  53 */     if (userid == null)
/*     */     {
/*  55 */       onChangeCourtYardFurnitureReqFail(25);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     SFurnitureItem sFurnitureItem = SFurnitureItem.get(this.furnitureCfgId);
/*  60 */     if (sFurnitureItem == null)
/*     */     {
/*  62 */       onChangeCourtYardFurnitureReqFail(25);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     this.pos = sFurnitureItem.pos;
/*  67 */     if ((this.pos != 11) && (this.pos != 13) && (this.pos != 12))
/*     */     {
/*     */ 
/*  70 */       Map<String, Object> extraMap = new HashMap();
/*  71 */       extraMap.put("pos", Integer.valueOf(this.pos));
/*     */       
/*  73 */       onChangeCourtYardFurnitureReqFail(36);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  78 */     this.partnerRoleId = (isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId());
/*     */     
/*  80 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  81 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  83 */       Map<String, Object> extraMap = new HashMap();
/*  84 */       extraMap.put("home_wrold_id", Long.valueOf(homeWorleId));
/*     */       
/*  86 */       onChangeCourtYardFurnitureReqFail(26, extraMap);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (!changePlayFurniture(userid, homeInfoWrapper, isOwner, this.partnerRoleId))
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   private boolean changePlayFurniture(String userid, HomeInfoWrapper homeInfoWrapper, boolean isOwner, long partnerRoleId)
/*     */   {
/*  99 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 100 */     int xCourtYardLevel = xHomeInfo.getCourtyardlevel();
/* 101 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xCourtYardLevel);
/* 102 */     if (sCourtyardCfg == null)
/*     */     {
/* 104 */       Map<String, Object> extraMap = new HashMap();
/* 105 */       extraMap.put("court_yard_level", Integer.valueOf(xCourtYardLevel));
/*     */       
/* 107 */       onChangeCourtYardFurnitureReqFail(28, extraMap);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     HomeOperate xHomeOperate = xtable.Role2homeoperate.get(Long.valueOf(this.roleId));
/* 112 */     if (xHomeOperate == null)
/*     */     {
/* 114 */       onChangeCourtYardFurnitureReqFail(23);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(this.furnitureCfgId));
/* 119 */     if (xFurnitureUuIds == null)
/*     */     {
/* 121 */       onChangeCourtYardFurnitureReqFail(34);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     if (!xFurnitureUuIds.getUuids().contains(Long.valueOf(this.furnitureUuid)))
/*     */     {
/* 127 */       onChangeCourtYardFurnitureReqFail(33);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     xFurnitureUuIds.getUuids().remove(Long.valueOf(this.furnitureUuid));
/*     */     
/* 133 */     if (xFurnitureUuIds.getUuids().isEmpty())
/*     */     {
/* 135 */       xHomeOperate.getOwnfurnitures().remove(Integer.valueOf(this.furnitureCfgId));
/*     */     }
/*     */     
/* 138 */     int oldBeautiful = CourtYardManager.getBeautiful(homeInfoWrapper.getxHomeInfo());
/*     */     
/* 140 */     FurnitureInfo xOldWallFurnitureInfo = CourtYardManager.returnSpecialFurtinureToRole(homeInfoWrapper, this.pos);
/*     */     
/* 142 */     if (xOldWallFurnitureInfo == null)
/*     */     {
/* 144 */       onChangeCourtYardFurnitureReqFail(37);
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     long oldFurnitureUuid = CourtYardManager.getSpecialFurnitureUuid(xHomeInfo, this.pos);
/*     */     
/* 150 */     CourtYardManager.changeCourtYardSpecialFurniture(homeInfoWrapper.getxHomeInfo(), isOwner, this.furnitureCfgId, this.furnitureUuid, this.pos);
/*     */     
/*     */ 
/* 153 */     int newBeautiful = CourtYardManager.computeFurnitureBeautiful(homeInfoWrapper.getxHomeInfo());
/*     */     
/* 155 */     int changeBeautiful = newBeautiful - oldBeautiful;
/*     */     
/* 157 */     SChangeCourtYardFurnitureSuccess changeSuccess = new SChangeCourtYardFurnitureSuccess();
/* 158 */     changeSuccess.furniture_cfg_id = this.furnitureCfgId;
/* 159 */     changeSuccess.furniture_uuid = this.furnitureUuid;
/* 160 */     changeSuccess.change_beautiful_value = changeBeautiful;
/* 161 */     changeSuccess.furniture_pos = this.pos;
/* 162 */     changeSuccess.unfurniture_uuid = oldFurnitureUuid;
/* 163 */     changeSuccess.unfurniture_cfg_id = xOldWallFurnitureInfo.getFurnitureid();
/*     */     
/* 165 */     OnlineManager.getInstance().send(this.roleId, changeSuccess);
/* 166 */     CourtYardManager.sendSSynBeautifulRes(this.roleId, newBeautiful);
/* 167 */     if (partnerRoleId != -1L)
/*     */     {
/* 169 */       CourtYardManager.sendSSynBeautifulRes(this.partnerRoleId, newBeautiful);
/*     */     }
/*     */     
/*     */ 
/* 173 */     CourtYardManager.removeSpecialFurnitureMapEntity(oldFurnitureUuid, this.pos);
/*     */     
/* 175 */     CourtYardManager.addSpecialFurnitureMapEntity(homeInfoWrapper.getHomeWorldId(), this.furnitureCfgId, this.furnitureUuid, sCourtyardCfg.mapId, this.pos);
/*     */     
/*     */ 
/* 178 */     CourtYardManager.changeCourtYardBeautifulIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*     */     
/* 180 */     int rolelevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/*     */     
/* 182 */     HomelandManager.tlogDisplayfurniture(userid, this.roleId, rolelevel, changeBeautiful, homeInfoWrapper.getxHomeInfo(), xHomeOperate, isOwner, partnerRoleId, oldBeautiful, newBeautiful, homeInfoWrapper.getOwnerRoleId(), this.furnitureCfgId, this.furnitureUuid, 2);
/*     */     
/*     */ 
/*     */ 
/* 186 */     StringBuilder sb = new StringBuilder();
/* 187 */     sb.append("[home]PCChangeCourtYardFurnitureReq.processImp@change court yard special furniture success");
/* 188 */     sb.append("|role_id=").append(this.roleId);
/* 189 */     sb.append("|furniture_cfg_id=").append(this.furnitureCfgId);
/* 190 */     sb.append("|furniture_uuid=").append(this.furnitureUuid);
/* 191 */     sb.append("|pos=").append(this.pos);
/* 192 */     sb.append("|un_furniture_cfg_id=").append(xOldWallFurnitureInfo.getFurnitureid());
/* 193 */     sb.append("|un_furniture_uuid=").append(oldFurnitureUuid);
/* 194 */     sb.append("|change_beautiful=").append(changeBeautiful);
/* 195 */     sb.append("|old_beautiful=").append(oldBeautiful);
/* 196 */     sb.append("|new_beautiful=").append(newBeautiful);
/*     */     
/* 198 */     GameServer.logger().info(sb.toString());
/*     */     
/* 200 */     return true;
/*     */   }
/*     */   
/*     */   private void onChangeCourtYardFurnitureReqFail(int ret)
/*     */   {
/* 205 */     onChangeCourtYardFurnitureReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onChangeCourtYardFurnitureReqFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 210 */     StringBuilder sb = new StringBuilder();
/* 211 */     sb.append("[home]PCChangeCourtYardFurnitureReq.processImp@change court yard furniture fail");
/* 212 */     sb.append("|role_id=").append(this.roleId);
/* 213 */     sb.append("|furniture_cfg_id=").append(this.furnitureCfgId);
/* 214 */     sb.append("|furniture_uuid=").append(this.furnitureUuid);
/* 215 */     sb.append("|pos=").append(this.pos);
/* 216 */     sb.append("|partner_role_id=").append(this.partnerRoleId);
/* 217 */     sb.append("|ret=").append(ret);
/*     */     
/* 219 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 221 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 223 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 227 */     GameServer.logger().error(sb.toString());
/*     */     
/* 229 */     mzm.gsp.homeland.SCommonResultRes sCommonResultRes = new mzm.gsp.homeland.SCommonResultRes();
/* 230 */     sCommonResultRes.res = ret;
/*     */     
/* 232 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PCChangeCourtYardFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */