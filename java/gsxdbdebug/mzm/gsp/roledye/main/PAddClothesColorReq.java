/*     */ package mzm.gsp.roledye.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressDyeTypeCfg;
/*     */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.occupation.confbean.RoleDyeConsts;
/*     */ import mzm.gsp.occupation.confbean.SRoleClothesColor;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.roledye.ColorIds;
/*     */ import mzm.gsp.roledye.SAddClothesColorRes;
/*     */ import mzm.gsp.roledye.SRoleDyeResult;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ClothColor;
/*     */ import xbean.RoleClothes;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAddClothesColorReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int hairid;
/*     */   private final int clothid;
/*     */   private final int fashionDressCfgId;
/*     */   private final Map<Integer, Integer> hair_itemcfgid2useyuanbao;
/*     */   private final Map<Integer, Integer> cloth_itemcfgid2useyuanbao;
/*     */   
/*     */   public PAddClothesColorReq(long roleid, int hairid, int clothid, int fashionDressCfgId, Map<Integer, Integer> hair_itemcfgid2useyuanbao, Map<Integer, Integer> cloth_itemcfgid2useyuanbao)
/*     */   {
/*  49 */     this.roleId = roleid;
/*  50 */     this.hairid = hairid;
/*  51 */     this.clothid = clothid;
/*  52 */     this.fashionDressCfgId = fashionDressCfgId;
/*  53 */     this.hair_itemcfgid2useyuanbao = hair_itemcfgid2useyuanbao;
/*  54 */     this.cloth_itemcfgid2useyuanbao = cloth_itemcfgid2useyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  60 */     if ((this.hairid <= 0) && (this.clothid <= 0))
/*     */     {
/*  62 */       return false;
/*     */     }
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
/*  76 */     if (!RoleDyeManager.isRoleDyeSwitchOpen(this.roleId, "PAddClothesColorReq.processImp"))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (((this.hair_itemcfgid2useyuanbao.size() > 0) || (this.cloth_itemcfgid2useyuanbao.size() > 0)) && (!RoleDyeManager.isRoleDyeOptimizationSwitchOpen(this.roleId)))
/*     */     {
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     String userId = RoleInterface.getUserId(this.roleId);
/*  88 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  90 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 991, true, true))
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     int currentFashionDressCfgId = FashionDressInterface.getWearFashionDress(this.roleId, true);
/*  96 */     if (currentFashionDressCfgId != this.fashionDressCfgId)
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@fashion dress cfg id not on|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     SFashionDressCfg sFashionDressCfg = SFashionDressCfg.get(this.fashionDressCfgId);
/* 107 */     if ((this.fashionDressCfgId != -1) && (sFashionDressCfg == null))
/*     */     {
/* 109 */       GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@fashion dress cfg id not exist|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     Role roleInfo = RoleInterface.getRole(this.roleId, true);
/* 118 */     int menpai = roleInfo.getOccupationId();
/* 119 */     int gender = roleInfo.getGender();
/*     */     
/* 121 */     RoleClothes xRoleClothes = RoleDyeManager.getXRoleClothesIfNotExist(this.roleId);
/*     */     
/* 123 */     int addClothColorTypeId = -1;
/* 124 */     if (sFashionDressCfg != null)
/*     */     {
/* 126 */       addClothColorTypeId = sFashionDressCfg.clothesPressType;
/*     */     }
/* 128 */     int size = 0;
/*     */     
/* 130 */     for (ClothColor color : xRoleClothes.getClothes())
/*     */     {
/* 132 */       int colorFashionDressCfgId = color.getFashion_dress_cfg_id();
/*     */       
/* 134 */       int colorClothColorTypeId = -1;
/* 135 */       SFashionDressCfg sColorClothColorTypeCfg = SFashionDressCfg.get(colorFashionDressCfgId);
/* 136 */       if (sColorClothColorTypeCfg != null)
/*     */       {
/* 138 */         colorClothColorTypeId = sColorClothColorTypeCfg.clothesPressType;
/*     */       }
/*     */       
/* 141 */       if (colorClothColorTypeId == addClothColorTypeId)
/*     */       {
/* 143 */         size++;
/*     */       }
/*     */       
/* 146 */       if ((color.getHair() == this.hairid) && (color.getCloth() == this.clothid) && (addClothColorTypeId == colorClothColorTypeId))
/*     */       {
/* 148 */         onAddClothesColorReqFail(8);
/* 149 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 153 */     if (size >= RoleDyeConsts.getInstance().maxRoleDyePlanNum)
/*     */     {
/*     */ 
/* 156 */       RoleDyeManager.sendRoleDyeResult(this.roleId, 5);
/* 157 */       return false;
/*     */     }
/* 159 */     ColorIds curColorid = RoleDyeManager.getRoleCurClothesNoLock(this.roleId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 165 */     SRoleClothesColor hairCfg = SRoleClothesColor.get(this.hairid);
/*     */     
/* 167 */     boolean isFashionDress = this.fashionDressCfgId != -1;
/* 168 */     TLogArg logArg = isFashionDress ? new TLogArg(LogReason.FASHION_DRESS_ROLEDYE_ADD_REM) : new TLogArg(LogReason.ROLEDYE_ADD_REM);
/*     */     
/*     */ 
/* 171 */     boolean isTransferFashionDress = (isFashionDress) && (sFashionDressCfg.fashionShowType == 2);
/*     */     
/* 173 */     if ((!isTransferFashionDress) || (sFashionDressCfg.defaultHairDyeId > 0))
/*     */     {
/* 175 */       if (hairCfg == null)
/*     */       {
/* 177 */         Map<String, Object> extraMap = new HashMap();
/* 178 */         extraMap.put("role_men_pai", Integer.valueOf(menpai));
/* 179 */         extraMap.put("role_gender", Integer.valueOf(gender));
/* 180 */         extraMap.put("hair_cfg", "");
/*     */         
/* 182 */         onAddClothesColorReqFail(6, extraMap);
/*     */         
/* 184 */         RoleDyeManager.sendRoleDyeResult(this.roleId, 6);
/*     */         
/* 186 */         return false;
/*     */       }
/*     */       
/* 189 */       if ((hairCfg.part != 1) || ((hairCfg.menpai != menpai) && (hairCfg.menpai != 0)) || ((hairCfg.gender != gender) && (hairCfg.gender != 0)))
/*     */       {
/*     */ 
/* 192 */         Map<String, Object> extraMap = new HashMap();
/* 193 */         extraMap.put("hair_cfg_men_pai", Integer.valueOf(hairCfg.menpai));
/* 194 */         extraMap.put("role_men_pai", Integer.valueOf(menpai));
/* 195 */         extraMap.put("hair_cfg_gender", Integer.valueOf(hairCfg.gender));
/* 196 */         extraMap.put("role_gender", Integer.valueOf(gender));
/* 197 */         extraMap.put("hair_cfg_part", Integer.valueOf(hairCfg.part));
/*     */         
/* 199 */         onAddClothesColorReqFail(6, extraMap);
/*     */         
/* 201 */         RoleDyeManager.sendRoleDyeResult(this.roleId, 6);
/* 202 */         return false;
/*     */       }
/*     */       
/* 205 */       int hairCfgFashionDressType = hairCfg.fashionDressTypeId;
/* 206 */       if (hairCfgFashionDressType > 0)
/*     */       {
/* 208 */         SFashionDressDyeTypeCfg sHairFashionDressTypeCfg = SFashionDressDyeTypeCfg.get(hairCfgFashionDressType);
/* 209 */         if (sHairFashionDressTypeCfg == null)
/*     */         {
/* 211 */           GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@hair fashion dress type not exist|role_id=%d|hair_id|cloth_id=%d|fashion_dress_cfg_id=%d|fashion_dress_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(hairCfgFashionDressType) }));
/*     */           
/*     */ 
/*     */ 
/* 215 */           return false;
/*     */         }
/* 217 */         List<Integer> hairFashionDressType2CfgIdList = sHairFashionDressTypeCfg.fashionDressCfgIdList;
/* 218 */         if (!hairFashionDressType2CfgIdList.contains(Integer.valueOf(this.fashionDressCfgId)))
/*     */         {
/* 220 */           GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@hair fashion dress type not contains the fashion dress cfg id|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d|fashion_dress_type=%d|fashion_dresscfg_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(hairCfgFashionDressType), hairFashionDressType2CfgIdList.toString() }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 225 */           return false;
/*     */         }
/*     */         
/* 228 */         if ((isFashionDress) && (sFashionDressCfg.fashionDressDyeType != hairCfgFashionDressType))
/*     */         {
/* 230 */           GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@hair fashion dress type not equal fashtion dress dye type|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d|fashion_dress_type=%d|fashion_dress_dye_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(hairCfgFashionDressType), Integer.valueOf(sFashionDressCfg.fashionDressDyeType) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 235 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 239 */       if ((curColorid == null) || (curColorid.hairid != this.hairid))
/*     */       {
/* 241 */         if (hairCfg.itemcount1 > 0)
/*     */         {
/* 243 */           Integer itemCutYuanbaoNum = (Integer)this.hair_itemcfgid2useyuanbao.get(Integer.valueOf(hairCfg.itemid1));
/* 244 */           if ((itemCutYuanbaoNum != null) && (itemCutYuanbaoNum.intValue() > 0))
/*     */           {
/* 246 */             Map<Integer, Integer> itemid2num = new HashMap();
/* 247 */             itemid2num.put(Integer.valueOf(hairCfg.itemid1), Integer.valueOf(hairCfg.itemcount1));
/* 248 */             if (!ItemInterface.removeItemsWithCutYuanbao(userId, this.roleId, CostType.COST_BIND_FIRST_ROLE_MODLE_DYE, itemid2num, itemCutYuanbaoNum.intValue(), logArg))
/*     */             {
/*     */ 
/* 251 */               RoleDyeManager.sendRoleDyeResult(this.roleId, 9);
/* 252 */               return false;
/*     */             }
/*     */           }
/* 255 */           else if (!ItemInterface.removeItemsWithBindFirst(this.roleId, hairCfg.itemid1, hairCfg.itemcount1, logArg).success())
/*     */           {
/* 257 */             RoleDyeManager.sendRoleDyeResult(this.roleId, 7);
/* 258 */             return false;
/*     */           }
/*     */         }
/* 261 */         if (hairCfg.itemcount2 > 0)
/*     */         {
/* 263 */           Integer itemCutYuanbaoNum = (Integer)this.hair_itemcfgid2useyuanbao.get(Integer.valueOf(hairCfg.itemid2));
/* 264 */           if ((itemCutYuanbaoNum != null) && (itemCutYuanbaoNum.intValue() > 0))
/*     */           {
/* 266 */             Map<Integer, Integer> itemid2num = new HashMap();
/* 267 */             itemid2num.put(Integer.valueOf(hairCfg.itemid2), Integer.valueOf(hairCfg.itemcount2));
/* 268 */             if (!ItemInterface.removeItemsWithCutYuanbao(userId, this.roleId, CostType.COST_BIND_FIRST_ROLE_MODLE_DYE, itemid2num, itemCutYuanbaoNum.intValue(), logArg))
/*     */             {
/*     */ 
/* 271 */               RoleDyeManager.sendRoleDyeResult(this.roleId, 9);
/* 272 */               return false;
/*     */             }
/*     */           }
/* 275 */           else if (!ItemInterface.removeItemsWithBindFirst(this.roleId, hairCfg.itemid2, hairCfg.itemcount2, logArg).success())
/*     */           {
/* 277 */             RoleDyeManager.sendRoleDyeResult(this.roleId, 7);
/* 278 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 284 */     SRoleClothesColor clothCfg = SRoleClothesColor.get(this.clothid);
/*     */     
/* 286 */     if (clothCfg == null)
/*     */     {
/* 288 */       Map<String, Object> extraMap = new HashMap();
/* 289 */       extraMap.put("role_men_pai", Integer.valueOf(menpai));
/* 290 */       extraMap.put("role_gender", Integer.valueOf(gender));
/* 291 */       extraMap.put("cloth_cfg", "");
/*     */       
/* 293 */       onAddClothesColorReqFail(6, extraMap);
/*     */       
/* 295 */       RoleDyeManager.sendRoleDyeResult(this.roleId, 6);
/*     */       
/* 297 */       return false;
/*     */     }
/*     */     
/* 300 */     if ((clothCfg.part != 2) || ((clothCfg.menpai != menpai) && (clothCfg.menpai != 0)) || ((clothCfg.gender != gender) && (clothCfg.gender != 0)))
/*     */     {
/*     */ 
/*     */ 
/* 304 */       Map<String, Object> extraMap = new HashMap();
/* 305 */       extraMap.put("cloth_cfg_men_pai", Integer.valueOf(clothCfg.menpai));
/* 306 */       extraMap.put("role_men_pai", Integer.valueOf(menpai));
/* 307 */       extraMap.put("cloth_cfg_gender", Integer.valueOf(clothCfg.gender));
/* 308 */       extraMap.put("role_gender", Integer.valueOf(gender));
/* 309 */       extraMap.put("cloth_cfg_part", Integer.valueOf(clothCfg.part));
/*     */       
/* 311 */       onAddClothesColorReqFail(6, extraMap);
/*     */       
/* 313 */       RoleDyeManager.sendRoleDyeResult(this.roleId, 6);
/* 314 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 318 */     int clothCfgFashionDressType = clothCfg.fashionDressTypeId;
/* 319 */     if (clothCfgFashionDressType > 0)
/*     */     {
/* 321 */       SFashionDressDyeTypeCfg sClothFashionDressTypeCfg = SFashionDressDyeTypeCfg.get(clothCfgFashionDressType);
/* 322 */       if (sClothFashionDressTypeCfg == null)
/*     */       {
/* 324 */         GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@fashion dress type not exist|role_id=%d|hair_id|cloth_id=%d|fashion_dress_cfg_id=%d|fashion_dress_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(clothCfgFashionDressType) }));
/*     */         
/*     */ 
/*     */ 
/* 328 */         return false;
/*     */       }
/* 330 */       List<Integer> clothFashionDressType2CfgIdList = sClothFashionDressTypeCfg.fashionDressCfgIdList;
/* 331 */       if (!clothFashionDressType2CfgIdList.contains(Integer.valueOf(this.fashionDressCfgId)))
/*     */       {
/* 333 */         GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@fashion dress type not contains the fashion dress cfg id|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d|fashion_dress_type=%d|fashion_dresscfg_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(clothCfgFashionDressType), clothFashionDressType2CfgIdList.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 338 */         return false;
/*     */       }
/*     */       
/* 341 */       if ((isFashionDress) && (sFashionDressCfg.fashionDressDyeType != clothCfgFashionDressType))
/*     */       {
/* 343 */         GameServer.logger().error(String.format("[roledye]PAddClothesColorReq.processImp@fashion dress type not equal with cloth|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d|fashion_dress_type=%d|fashion_dress_dye_type=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(clothCfgFashionDressType), Integer.valueOf(sFashionDressCfg.fashionDressDyeType) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 348 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 352 */     if ((curColorid == null) || (curColorid.clothid != this.clothid))
/*     */     {
/* 354 */       if (clothCfg.itemcount1 > 0)
/*     */       {
/* 356 */         Integer itemCutYuanbaoNum = (Integer)this.cloth_itemcfgid2useyuanbao.get(Integer.valueOf(clothCfg.itemid1));
/* 357 */         if ((itemCutYuanbaoNum != null) && (itemCutYuanbaoNum.intValue() > 0))
/*     */         {
/* 359 */           Map<Integer, Integer> itemid2num = new HashMap();
/* 360 */           itemid2num.put(Integer.valueOf(clothCfg.itemid1), Integer.valueOf(clothCfg.itemcount1));
/* 361 */           if (!ItemInterface.removeItemsWithCutYuanbao(userId, this.roleId, CostType.COST_BIND_FIRST_ROLE_MODLE_DYE, itemid2num, itemCutYuanbaoNum.intValue(), logArg))
/*     */           {
/*     */ 
/* 364 */             RoleDyeManager.sendRoleDyeResult(this.roleId, 9);
/* 365 */             return false;
/*     */           }
/*     */         }
/* 368 */         else if (!ItemInterface.removeItemsWithBindFirst(this.roleId, clothCfg.itemid1, clothCfg.itemcount1, logArg).success())
/*     */         {
/* 370 */           onAddClothesColorReqFail(7);
/* 371 */           return false;
/*     */         }
/*     */       }
/* 374 */       if (clothCfg.itemcount2 > 0)
/*     */       {
/* 376 */         Integer itemCutYuanbaoNum = (Integer)this.cloth_itemcfgid2useyuanbao.get(Integer.valueOf(clothCfg.itemid2));
/* 377 */         if ((itemCutYuanbaoNum != null) && (itemCutYuanbaoNum.intValue() > 0))
/*     */         {
/* 379 */           Map<Integer, Integer> itemid2num = new HashMap();
/* 380 */           itemid2num.put(Integer.valueOf(clothCfg.itemid2), Integer.valueOf(clothCfg.itemcount2));
/* 381 */           if (!ItemInterface.removeItemsWithCutYuanbao(userId, this.roleId, CostType.COST_BIND_FIRST_ROLE_MODLE_DYE, itemid2num, itemCutYuanbaoNum.intValue(), logArg))
/*     */           {
/*     */ 
/* 384 */             RoleDyeManager.sendRoleDyeResult(this.roleId, 9);
/* 385 */             return false;
/*     */           }
/*     */         }
/* 388 */         else if (!ItemInterface.removeItemsWithBindFirst(this.roleId, clothCfg.itemid2, clothCfg.itemcount2, logArg).success())
/*     */         {
/* 390 */           onAddClothesColorReqFail(7);
/* 391 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 396 */     int newColorId = RoleDyeManager.addRoleClothesColor(xRoleClothes, this.hairid, this.clothid, this.fashionDressCfgId);
/*     */     
/* 398 */     if (newColorId < 0)
/*     */     {
/* 400 */       Map<String, Object> extraMap = new HashMap();
/* 401 */       extraMap.put("new_color_id", Integer.valueOf(newColorId));
/*     */       
/* 403 */       onAddClothesColorReqFail(0, extraMap);
/* 404 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 408 */     RoleDyeManager.setNewColorId(this.roleId, newColorId, this.hairid, this.clothid, this.fashionDressCfgId, xRoleClothes, false);
/*     */     
/* 410 */     OnlineManager.getInstance().send(this.roleId, new SAddClothesColorRes(newColorId, this.hairid, this.clothid, this.fashionDressCfgId));
/*     */     
/*     */ 
/* 413 */     RoleDyeManager.tlogRoleDyeOperator(userId, this.roleId, this.fashionDressCfgId, this.hairid, this.clothid, RoleDyeTlogEnum.ADD);
/*     */     
/* 415 */     GameServer.logger().info(String.format("[roledye]PAddClothesColorReq.processImp@add new color success|role_id=%d|hair_id=%d|cloth_id=%d|fashion_dress_cfg_id=%d|hair_itemcfgid2useyuanbao=%s|cloth_itemcfgid2useyuanbao=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.hairid), Integer.valueOf(this.clothid), Integer.valueOf(this.fashionDressCfgId), this.hair_itemcfgid2useyuanbao, this.cloth_itemcfgid2useyuanbao }));
/*     */     
/*     */ 
/*     */ 
/* 419 */     return true;
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
/*     */   private void onAddClothesColorReqFail(int ret)
/*     */   {
/* 432 */     onAddClothesColorReqFail(ret, null);
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
/*     */   private void onAddClothesColorReqFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 445 */     StringBuilder sbLog = new StringBuilder();
/* 446 */     sbLog.append("[roledye]PAddClothesColorReq.processImp@add clothes color failed");
/* 447 */     sbLog.append("|ret=").append(ret);
/* 448 */     sbLog.append("|role_id=").append(this.roleId);
/* 449 */     sbLog.append("|fashion_dress_cfg_id=").append(this.fashionDressCfgId);
/* 450 */     sbLog.append("|hair_id=").append(this.hairid);
/* 451 */     sbLog.append("|cloth_id=").append(this.clothid);
/* 452 */     sbLog.append("|hair_itemcfgid2useyuanbao=").append(this.hair_itemcfgid2useyuanbao);
/* 453 */     sbLog.append("|cloth_itemcfgid2useyuanbao=").append(this.cloth_itemcfgid2useyuanbao);
/*     */     
/* 455 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 457 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 459 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 462 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 464 */     SRoleDyeResult sRoleDyeResult = new SRoleDyeResult();
/* 465 */     sRoleDyeResult.resultcode = ret;
/*     */     
/* 467 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sRoleDyeResult);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\PAddClothesColorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */