/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SUnRideMountsSuccess;
/*     */ import mzm.gsp.mounts.event.MountsRolePropertyChangeArg;
/*     */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCUnRideMounts extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCUnRideMounts(long roleId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCUnRideMounts.processImp"))
/*     */     {
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     if (!MountsManager.isLevelOpen(this.roleId, "PCUnRideMounts.processImp"))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  39 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  41 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1048, true, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  47 */     if (xRole2MountsInfo == null)
/*     */     {
/*  49 */       onUnRideMountsFail(2);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     long nowRideMountsId = xRole2MountsInfo.getCurrent_ride_mounts_id();
/*  54 */     if (nowRideMountsId == 0L)
/*     */     {
/*  56 */       onUnRideMountsFail(11);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(nowRideMountsId));
/*  61 */     if (xMountsInfo == null)
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[mounts]PCUnRideMounts.processImp@handle un ride mounts success|role_id=%d|mounts_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(nowRideMountsId) }));
/*     */       
/*     */ 
/*  66 */       onUnRideMountsFail(4);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     xRole2MountsInfo.setCurrent_ride_mounts_id(0L);
/*  71 */     SUnRideMountsSuccess sUnRideMountsSuccess = new SUnRideMountsSuccess();
/*  72 */     sUnRideMountsSuccess.mounts_id = nowRideMountsId;
/*     */     
/*  74 */     OnlineManager.getInstance().send(this.roleId, sUnRideMountsSuccess);
/*     */     
/*     */ 
/*  77 */     MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(this.roleId, 0, -1, -1, 1));
/*     */     
/*     */ 
/*     */ 
/*  81 */     if (xRole2MountsInfo.getAppearence_mounts_info_map().containsKey(Long.valueOf(nowRideMountsId)))
/*     */     {
/*  83 */       MountsManager.triggerMountsRolePropertyChangeEvent(new MountsRolePropertyChangeArg(this.roleId));
/*     */     }
/*  85 */     MountsManager.tlogMountsRide(userId, this.roleId, nowRideMountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), 0);
/*     */     
/*     */ 
/*     */ 
/*  89 */     MultiRoleMountsManager.onRoleUnrideMounts(this.roleId, 0);
/*     */     
/*  91 */     GameServer.logger().info(String.format("[mounts]PCUnRideMounts.processImp@handle un ride mounts success|role_id=%d|old_ride_mounts_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(nowRideMountsId) }));
/*     */     
/*     */ 
/*     */ 
/*  95 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onUnRideMountsFail(int ret)
/*     */   {
/* 106 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 107 */     sMountsNormalFail.result = ret;
/* 108 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */     
/* 110 */     GameServer.logger().error(String.format("[mounts]PCUnRideMounts.processImp@handle un ride mounts success|ret=%d|role_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCUnRideMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */