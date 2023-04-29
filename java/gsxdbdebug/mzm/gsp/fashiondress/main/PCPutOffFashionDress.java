/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SPutOffFashionDressSuccess;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2fashiondress;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCPutOffFashionDress extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fashionDressCfgId;
/*     */   
/*     */   public PCPutOffFashionDress(long roleId, int fashionDressCfgId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.fashionDressCfgId = fashionDressCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCPutOffFashionDress.processImp", true, true))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCPutOffFashionDress.processImp", true))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     String userId = RoleInterface.getUserId(this.roleId);
/*  45 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 973, true, true))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     Role2FashionDressInfo xRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleId));
/*     */     
/*  54 */     if (xRole2FashionDressInfo == null)
/*     */     {
/*  56 */       GameServer.logger().error(String.format("[fashiondress]PCPutOffFashionDress.processImp@role fashion dress info is null|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     Map<Integer, FashionDressInfo> fashionDressInfoMap = xRole2FashionDressInfo.getFashion_dress_map();
/*  64 */     FashionDressInfo xFashionDressInfo = (FashionDressInfo)fashionDressInfoMap.get(Integer.valueOf(this.fashionDressCfgId));
/*  65 */     if (xFashionDressInfo == null)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[fashiondress]PCPutOffFashionDress.processImp@role fashion dress not exist,may be expired|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!SFashionDressCfg.getAll().containsKey(Integer.valueOf(this.fashionDressCfgId)))
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[fashiondress]PCPutOffFashionDress.processImp@fashion dress cfg not exist|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     int currentFashionDressCfgId = xRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id();
/*  84 */     if (currentFashionDressCfgId != this.fashionDressCfgId)
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[fashiondress]PCPutOffFashionDress.processImp@role fashion dress not on|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*  93 */     xRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/*  94 */     FashionDressInterface.changeRoleClothAndModel(this.roleId, -1);
/*     */     
/*     */ 
/*  97 */     putOffTransferOccupationFashionDress(xRole2FashionDressInfo);
/*     */     
/*  99 */     SPutOffFashionDressSuccess sPutOffFashionDressSuccess = new SPutOffFashionDressSuccess();
/* 100 */     sPutOffFashionDressSuccess.fashiondresscfgid = this.fashionDressCfgId;
/*     */     
/* 102 */     OnlineManager.getInstance().send(this.roleId, sPutOffFashionDressSuccess);
/*     */     
/* 104 */     FashionDressManager.tlogFashionDressOperator(userId, this.roleId, this.fashionDressCfgId, FashionDressTLogEnum.TAKE_OFF);
/*     */     
/* 106 */     GameServer.logger().info(String.format("[fashiondress]PCPutOffFashionDress.processImp@put off fashion dress info success|role_id=%d|fashion_dress_cfg_id=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(currentFashionDressCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 110 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void putOffTransferOccupationFashionDress(Role2FashionDressInfo xRole2FashionDressInfo)
/*     */   {
/* 121 */     Map<Integer, TransferOccupationFashionDress> xTransferOccupationFashionDressMap = xRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 122 */     if (xTransferOccupationFashionDressMap.isEmpty())
/*     */     {
/* 124 */       return;
/*     */     }
/*     */     
/* 127 */     for (TransferOccupationFashionDress xTransferOccupationFashionDress : xTransferOccupationFashionDressMap.values())
/*     */     {
/* 129 */       xTransferOccupationFashionDress.setCurrent_fashion_dress_cfg_id(-1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCPutOffFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */