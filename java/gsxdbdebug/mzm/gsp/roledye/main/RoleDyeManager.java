/*     */ package mzm.gsp.roledye.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.event.RoleColorChangeEvent;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleInterface.DefaultColorInfo;
/*     */ import mzm.gsp.roledye.ColorIds;
/*     */ import mzm.gsp.roledye.SRoleClothesListRes;
/*     */ import mzm.gsp.roledye.SRoleDyeResult;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ClothColor;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleClothes;
/*     */ import xtable.Roleclothes;
/*     */ 
/*     */ public class RoleDyeManager
/*     */ {
/*  29 */   static final Logger logger = Logger.getLogger("roledye");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean initRoleClothes(long roleid, int hairid, int clothid, int fashionDressCfgId)
/*     */   {
/*  46 */     RoleClothes roleClothes = getXRoleClothesIfNotExist(roleid);
/*  47 */     if (roleClothes.getDefid() < 0)
/*     */     {
/*  49 */       int id = addRoleClothesColor(roleClothes, hairid, clothid, fashionDressCfgId);
/*  50 */       if (id >= 0)
/*     */       {
/*  52 */         roleClothes.setDefid(id);
/*  53 */         roleClothes.setCurid(id);
/*  54 */         return true;
/*     */       }
/*     */     }
/*     */     
/*  58 */     return false;
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
/*     */   static ColorIds getRoleCurClothes(long roleId)
/*     */   {
/*  72 */     RoleClothes roleClothes = getXRoleClothesIfNotExist(roleId);
/*  73 */     int curId = roleClothes.getCurid();
/*  74 */     for (ClothColor color : roleClothes.getClothes())
/*     */     {
/*  76 */       if (color.getId() == curId) {
/*  77 */         return new ColorIds(color.getId(), color.getHair(), color.getCloth(), color.getFashion_dress_cfg_id());
/*     */       }
/*     */     }
/*     */     
/*  81 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static ColorIds getRoleCurClothesNoLock(long roleid)
/*     */   {
/*  92 */     RoleClothes roleClothes = Roleclothes.select(Long.valueOf(roleid));
/*  93 */     int curId; if (roleClothes != null)
/*     */     {
/*  95 */       curId = roleClothes.getCurid();
/*  96 */       for (ClothColor color : roleClothes.getClothes())
/*     */       {
/*  98 */         if (color.getId() == curId) {
/*  99 */           return new ColorIds(color.getId(), color.getHair(), color.getCloth(), color.getFashion_dress_cfg_id());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 104 */     return null;
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
/*     */   static RoleClothes getXRoleClothesIfNotExist(long roleid)
/*     */   {
/* 117 */     RoleClothes roleClothes = Roleclothes.get(Long.valueOf(roleid));
/* 118 */     if (roleClothes == null)
/*     */     {
/* 120 */       roleClothes = Pod.newRoleClothes();
/* 121 */       Roleclothes.add(Long.valueOf(roleid), roleClothes);
/*     */     }
/*     */     
/* 124 */     return roleClothes;
/*     */   }
/*     */   
/*     */   static int addRoleClothesColor(RoleClothes roleClothes, int hairid, int clothid, int fashionDressCfgId)
/*     */   {
/* 129 */     ClothColor clothColor = Pod.newClothColor();
/* 130 */     int id = roleClothes.getNextid();
/* 131 */     clothColor.setHair(hairid);
/* 132 */     clothColor.setCloth(clothid);
/* 133 */     clothColor.setFashion_dress_cfg_id(fashionDressCfgId);
/* 134 */     clothColor.setId(id);
/* 135 */     roleClothes.getClothes().add(clothColor);
/* 136 */     roleClothes.setNextid(id + 1);
/*     */     
/* 138 */     return id;
/*     */   }
/*     */   
/*     */   static void sendRoleDyeResult(long roleid, int code)
/*     */   {
/* 143 */     OnlineManager.getInstance().sendAtOnce(roleid, new SRoleDyeResult(code));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setNewColorId(long roleId, int colorId, int hairId, int clothesId, int fashionDressCfgId, RoleClothes xRoleClothes, boolean isSendUseCloth)
/*     */   {
/* 155 */     int clothPressTypeId = 0;
/* 156 */     if (fashionDressCfgId == -1)
/*     */     {
/* 158 */       clothPressTypeId = -1;
/*     */     }
/*     */     else
/*     */     {
/* 162 */       SFashionDressCfg sFashionDressCfg = SFashionDressCfg.get(fashionDressCfgId);
/* 163 */       if (sFashionDressCfg != null)
/*     */       {
/* 165 */         clothPressTypeId = sFashionDressCfg.clothesPressType;
/*     */       }
/*     */     }
/*     */     
/* 169 */     xRoleClothes.getFashion_dress_cloth_map().put(Integer.valueOf(clothPressTypeId), Integer.valueOf(colorId));
/*     */     
/* 171 */     MapInterface.onRoleColorChange(roleId, hairId, clothesId);
/* 172 */     xRoleClothes.setCurid(colorId);
/* 173 */     if (isSendUseCloth)
/*     */     {
/* 175 */       OnlineManager.getInstance().send(roleId, new mzm.gsp.roledye.SUseClothesColorRes(colorId));
/*     */     }
/* 177 */     TriggerEventsManger.getInstance().triggerEvent(new RoleColorChangeEvent(), Long.valueOf(roleId));
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
/*     */   static boolean isRoleDyeSwitchOpen(long roleId, String logString)
/*     */   {
/* 192 */     if (!OpenInterface.getOpenStatus(98))
/*     */     {
/* 194 */       GameServer.logger().info(String.format("[roledye]%s@role dye system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     if (OpenInterface.isBanPlay(roleId, 98))
/*     */     {
/* 200 */       GameServer.logger().info(String.format("[roledye]%s@role dye is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/* 202 */       OpenInterface.sendBanPlayMsg(roleId, 98);
/* 203 */       return false;
/*     */     }
/*     */     
/* 206 */     return true;
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
/*     */ 
/*     */   static boolean isRoleDyeOptimizationSwitchOpen(long roleId)
/*     */   {
/* 222 */     if (!OpenInterface.getOpenStatus(549))
/*     */     {
/* 224 */       GameServer.logger().info(String.format("[roledye]@role dye optimization switch closed|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/* 225 */       return false;
/*     */     }
/*     */     
/* 228 */     if (OpenInterface.isBanPlay(roleId, 549))
/*     */     {
/* 230 */       GameServer.logger().info(String.format("[roledye]@role dye optimization is ban play|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 232 */       OpenInterface.sendBanPlayMsg(roleId, 549);
/* 233 */       return false;
/*     */     }
/*     */     
/* 236 */     return true;
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
/*     */   static void setRoleClothColor(long roleId, int newFashionDressCfgId)
/*     */   {
/* 249 */     int occupation = RoleInterface.getOccupationId(roleId);
/* 250 */     int gender = RoleInterface.getGender(roleId);
/* 251 */     setRoleClothColorChangeOccupation(roleId, newFashionDressCfgId, occupation, gender);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setRoleClothColorChangeOccupation(long roleId, int newFashionDressCfgId, int newOccuaption, int gender)
/*     */   {
/* 269 */     RoleClothes xRoleClothes = getXRoleClothesIfNotExist(roleId);
/*     */     
/* 271 */     ClothColor xClothColor = getFavorColorByFashionDressCfgId(xRoleClothes, newFashionDressCfgId);
/* 272 */     if (xClothColor == null)
/*     */     {
/* 274 */       xRoleClothes.setCurid(xRoleClothes.getDefid());
/*     */     }
/*     */     else
/*     */     {
/* 278 */       xRoleClothes.setCurid(xClothColor.getId());
/*     */     }
/*     */     
/* 281 */     ClothColor xDefClothColor = (ClothColor)xRoleClothes.getClothes().get(xRoleClothes.getDefid());
/* 282 */     if (newFashionDressCfgId == -1)
/*     */     {
/* 284 */       RoleInterface.DefaultColorInfo defaultColorInfo = RoleInterface.getRoleColorInfo(newOccuaption, gender);
/* 285 */       xDefClothColor.setCloth(defaultColorInfo.getClothColorId());
/* 286 */       xDefClothColor.setHair(defaultColorInfo.getHairColorId());
/*     */     }
/*     */     else
/*     */     {
/* 290 */       SFashionDressCfg sFashionDressCfg = SFashionDressCfg.get(newFashionDressCfgId);
/* 291 */       xDefClothColor.setCloth(sFashionDressCfg.defaultClothDyeId);
/* 292 */       xDefClothColor.setHair(sFashionDressCfg.defaultHairDyeId);
/*     */     }
/* 294 */     xDefClothColor.setFashion_dress_cfg_id(newFashionDressCfgId);
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
/*     */   static ClothColor getFavorColorByFashionDressCfgId(RoleClothes xRoleCloth, int fashionDressCfgId)
/*     */   {
/* 309 */     int clothPressTypeId = 0;
/* 310 */     if (fashionDressCfgId == -1)
/*     */     {
/* 312 */       clothPressTypeId = -1;
/*     */     }
/*     */     else
/*     */     {
/* 316 */       SFashionDressCfg sFashionDressCfg = SFashionDressCfg.get(fashionDressCfgId);
/* 317 */       if (sFashionDressCfg == null)
/*     */       {
/* 319 */         return null;
/*     */       }
/* 321 */       clothPressTypeId = sFashionDressCfg.clothesPressType;
/*     */     }
/* 323 */     Integer lastColorId = (Integer)xRoleCloth.getFashion_dress_cloth_map().get(Integer.valueOf(clothPressTypeId));
/* 324 */     if (lastColorId == null)
/*     */     {
/* 326 */       return null;
/*     */     }
/*     */     
/* 329 */     for (ClothColor color : xRoleCloth.getClothes())
/*     */     {
/* 331 */       if (color.getId() == lastColorId.intValue()) {
/* 332 */         return color;
/*     */       }
/*     */     }
/* 335 */     return null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogRoleDyeOperator(String userId, long roleId, long fashionDressCfgId, int hairId, int clothId, RoleDyeTlogEnum tLogEnum)
/*     */   {
/* 353 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 354 */     int occupationId = RoleInterface.getOccupationId(roleId);
/* 355 */     int gender = RoleInterface.getGender(roleId);
/*     */     
/* 357 */     StringBuilder sbLog = new StringBuilder();
/* 358 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 359 */     sbLog.append(userId).append('|');
/* 360 */     sbLog.append(roleId).append('|');
/* 361 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 363 */     sbLog.append(fashionDressCfgId).append('|');
/* 364 */     sbLog.append(occupationId).append('|');
/* 365 */     sbLog.append(gender).append('|');
/* 366 */     sbLog.append(hairId).append('|');
/* 367 */     sbLog.append(clothId).append('|');
/* 368 */     sbLog.append(tLogEnum.getOperator());
/*     */     
/* 370 */     TLogManager.getInstance().addLog(roleId, "RoleDyeOperator", sbLog.toString());
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
/*     */ 
/*     */   static void fillProtocolRoleCLotherListRes(long roleId, SRoleClothesListRes sRoleClothesListRes, RoleClothes xRoleClothes)
/*     */   {
/* 386 */     int wearFashionDressCfgId = FashionDressInterface.getWearFashionDress(roleId, true);
/* 387 */     fillProtocolRoleCLotherListRes(roleId, sRoleClothesListRes, xRoleClothes, wearFashionDressCfgId);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillProtocolRoleCLotherListRes(long roleId, SRoleClothesListRes sRoleClothesListRes, RoleClothes xRoleClothes, int wearFashionDressCfgId)
/*     */   {
/* 405 */     RoleClothes roleCothes = getXRoleClothesIfNotExist(roleId);
/* 406 */     List<ClothColor> clothColors = roleCothes.getClothes();
/*     */     
/* 408 */     sRoleClothesListRes.curid = roleCothes.getCurid();
/* 409 */     sRoleClothesListRes.maxcount = roleCothes.getMaxcount();
/* 410 */     for (ClothColor xClothcolor : clothColors)
/*     */     {
/* 412 */       int colorFashionDressCfgId = xClothcolor.getFashion_dress_cfg_id();
/*     */       
/* 414 */       if ((wearFashionDressCfgId == -1) && (colorFashionDressCfgId == wearFashionDressCfgId))
/*     */       {
/* 416 */         sRoleClothesListRes.clotheslist.add(new ColorIds(xClothcolor.getId(), xClothcolor.getHair(), xClothcolor.getCloth(), xClothcolor.getFashion_dress_cfg_id()));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 423 */       if (wearFashionDressCfgId != -1)
/*     */       {
/* 425 */         SFashionDressCfg sWearFashionDressCfg = SFashionDressCfg.get(wearFashionDressCfgId);
/* 426 */         SFashionDressCfg sClothFashionDressCfg = SFashionDressCfg.get(colorFashionDressCfgId);
/* 427 */         if ((sWearFashionDressCfg != null) && (sClothFashionDressCfg != null))
/*     */         {
/*     */ 
/*     */ 
/* 431 */           if (sWearFashionDressCfg.clothesPressType == sClothFashionDressCfg.clothesPressType)
/*     */           {
/* 433 */             sRoleClothesListRes.clotheslist.add(new ColorIds(xClothcolor.getId(), xClothcolor.getHair(), xClothcolor.getCloth(), xClothcolor.getFashion_dress_cfg_id()));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMutexStatus(long roleId)
/*     */   {
/* 447 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleId, 85, true))
/*     */     {
/* 449 */       GameServer.logger().error(String.format("[roledye]RoleDyeManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 451 */       return false;
/*     */     }
/* 453 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\RoleDyeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */