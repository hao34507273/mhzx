/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SRideMountsSuccess;
/*     */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCRideMounts extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   
/*     */   public PCRideMounts(long roleId, long mountsId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*  23 */     this.mountsId = mountsId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCRideMounts.processImp"))
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     if (!MountsManager.isLevelOpen(this.roleId, "PCRideMounts.processImp"))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  40 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1046, true, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  48 */     if (xRole2MountsInfo == null)
/*     */     {
/*  50 */       onMountsRideFail(2);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     boolean isCanSetStatus = RoleStatusInterface.checkCanSetStatus(this.roleId, 3, true);
/*  55 */     if (!isCanSetStatus)
/*     */     {
/*  57 */       onMountsRideFail(67);
/*  58 */       return false;
/*     */     }
/*  60 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/*  61 */     if (xMountsInfo == null)
/*     */     {
/*  63 */       onMountsRideFail(4);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long nowRideMountsId = xRole2MountsInfo.getCurrent_ride_mounts_id();
/*  68 */     if (nowRideMountsId == this.mountsId)
/*     */     {
/*  70 */       onMountsRideFail(22);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     xRole2MountsInfo.setCurrent_ride_mounts_id(this.mountsId);
/*  75 */     SRideMountsSuccess sRideMountsSuccess = new SRideMountsSuccess();
/*  76 */     sRideMountsSuccess.mounts_id = this.mountsId;
/*     */     
/*  78 */     OnlineManager.getInstance().send(this.roleId, sRideMountsSuccess);
/*     */     
/*  80 */     MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(this.roleId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getCurrent_ornament_rank(), xMountsInfo.getMounts_dye_color_id(), 1));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  85 */     MountsManager.tlogMountsRide(userId, this.roleId, this.mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), 1);
/*     */     
/*     */ 
/*     */ 
/*  89 */     MultiRoleMountsManager.onRoleRideMounts(this.roleId, xMountsInfo.getMounts_cfg_id());
/*     */     
/*  91 */     GameServer.logger().info(String.format("[mounts]PCRideMounts.processImp@handle ride mounts success|role_id=%d|choose_mounts_id=%d|old_ride_mounts_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Long.valueOf(nowRideMountsId) }));
/*     */     
/*     */ 
/*     */ 
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   private void onMountsRideFail(int ret)
/*     */   {
/* 100 */     GameServer.logger().error(String.format("[mounts]PCRideMounts.processImp@role mounts info is null|ret=%d|role_id=%d|mounts_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.mountsId) }));
/*     */     
/*     */ 
/* 103 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 104 */     sMountsNormalFail.result = ret;
/*     */     
/* 106 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCRideMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */