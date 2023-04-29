/*     */ package mzm.gsp.roledye.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.occupation.confbean.RoleDyeConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ClothColor;
/*     */ import xbean.RoleClothes;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PUseClothesColorReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int newColorId;
/*     */   
/*     */   public PUseClothesColorReq(long roleid, int id)
/*     */   {
/*  25 */     this.roleId = roleid;
/*  26 */     this.newColorId = id;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(RoleDyeConsts.getInstance().roleDyeNpcId, RoleDyeConsts.getInstance().roleDyeNpcServiceId, this.roleId))
/*     */     {
/*     */ 
/*  35 */       GameServer.logger().error(String.format("[roledye]PUseClothesColorReq.processImp@npc service is not useable|npc_id=%d|service_id=%d|role_id=%d", new Object[] { Integer.valueOf(RoleDyeConsts.getInstance().roleDyeNpcId), Integer.valueOf(RoleDyeConsts.getInstance().roleDyeNpcServiceId), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!RoleDyeManager.isRoleDyeSwitchOpen(this.roleId, "PUseClothesColorReq.processImp"))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     String userId = RoleInterface.getUserId(this.roleId);
/*  48 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  50 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 994, true, true))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     RoleClothes xRoleCothes = RoleDyeManager.getXRoleClothesIfNotExist(this.roleId);
/*  56 */     List<ClothColor> clothColors = xRoleCothes.getClothes();
/*     */     
/*  58 */     ClothColor xNewClothColor = null;
/*  59 */     ClothColor xOldClothColor = null;
/*  60 */     for (int i = clothColors.size() - 1; i >= 0; i--)
/*     */     {
/*  62 */       ClothColor xTempClothColor = (ClothColor)clothColors.get(i);
/*  63 */       if (this.newColorId == xTempClothColor.getId())
/*     */       {
/*  65 */         xNewClothColor = xTempClothColor;
/*     */       }
/*     */       
/*  68 */       if (xRoleCothes.getCurid() == xTempClothColor.getId())
/*     */       {
/*  70 */         xOldClothColor = xTempClothColor;
/*     */       }
/*     */     }
/*     */     
/*  74 */     if ((xNewClothColor == null) || (xOldClothColor == null))
/*     */     {
/*  76 */       RoleDyeManager.sendRoleDyeResult(this.roleId, 4);
/*  77 */       GameServer.logger().error(String.format("[roledye]PUseClothesColorReq.processImp@color id not exist|role_id=%d|new_color_id=%d|old_color_id=%d|new_color_null=%b|old_color_null=%b", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.newColorId), Integer.valueOf(xRoleCothes.getCurid()), Boolean.valueOf(xNewClothColor == null ? 1 : false), Boolean.valueOf(xOldClothColor == null ? 1 : false) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (xNewClothColor.getId() == xRoleCothes.getCurid())
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[roledye]PUseClothesColorReq.processImp@use the same color with wear|role_id=%d|color_id=%d|current_color_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.newColorId), Integer.valueOf(xRoleCothes.getCurid()) }));
/*     */       
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     int fashionDressCfgIdWear = FashionDressInterface.getWearFashionDress(this.roleId, true);
/*     */     
/*  96 */     int oldColorFashionDressCfgId = xOldClothColor.getFashion_dress_cfg_id();
/*  97 */     int newColorFashionDressCfgId = xNewClothColor.getFashion_dress_cfg_id();
/*     */     
/*     */ 
/* 100 */     int oldClothColorTypeId = -1;
/* 101 */     int newClothColorTypeId = -1;
/* 102 */     SFashionDressCfg sOldClothColorTypeCfg = SFashionDressCfg.get(oldColorFashionDressCfgId);
/* 103 */     SFashionDressCfg sNewClothColorTypeCfg = SFashionDressCfg.get(newColorFashionDressCfgId);
/* 104 */     if (sOldClothColorTypeCfg != null)
/*     */     {
/* 106 */       oldClothColorTypeId = sOldClothColorTypeCfg.clothesPressType;
/*     */     }
/*     */     
/* 109 */     if (sNewClothColorTypeCfg != null)
/*     */     {
/* 111 */       newClothColorTypeId = sNewClothColorTypeCfg.clothesPressType;
/*     */     }
/*     */     
/*     */ 
/* 115 */     if (newClothColorTypeId != oldClothColorTypeId)
/*     */     {
/*     */ 
/* 118 */       GameServer.logger().error(String.format("[roledye]PUseClothesColorReq.processImp@role fashion dress info is not match|role_id=%d|color_id=%d|old_color_fashion_dress_cfg_id=%d|wear_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.newColorId), Integer.valueOf(oldColorFashionDressCfgId), Integer.valueOf(fashionDressCfgIdWear) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     RoleDyeManager.setNewColorId(this.roleId, this.newColorId, xNewClothColor.getHair(), xNewClothColor.getCloth(), fashionDressCfgIdWear, xRoleCothes, true);
/*     */     
/*     */ 
/* 129 */     GameServer.logger().info(String.format("[roledye]PUseClothesColorReq.processImp@cloth color changes,model not change|role_id=%d|color_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.newColorId) }));
/*     */     
/*     */ 
/*     */ 
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\PUseClothesColorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */