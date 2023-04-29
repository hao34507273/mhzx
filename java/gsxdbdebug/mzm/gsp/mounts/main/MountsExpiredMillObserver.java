/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SAppearenceMountsExpired;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import xbean.AppearenceMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xbean.Role2MountsObserverInfo;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.Role2mountsobserver;
/*     */ 
/*     */ public class MountsExpiredMillObserver extends MilliObserver
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   
/*     */   public MountsExpiredMillObserver(long intervalMilliSeconds, long roleId, long mountsId)
/*     */   {
/*  22 */     super(intervalMilliSeconds);
/*  23 */     this.roleId = roleId;
/*  24 */     this.mountsId = mountsId;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  30 */     new PMountsExpried(this.roleId, this.mountsId).execute();
/*  31 */     return false;
/*     */   }
/*     */   
/*     */   private static class PMountsExpried extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final long appearanceMountsId;
/*     */     
/*     */     public PMountsExpried(long roleId, long appearanceMountsId)
/*     */     {
/*  41 */       this.roleId = roleId;
/*  42 */       this.appearanceMountsId = appearanceMountsId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  48 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  49 */       lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*  50 */       Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  51 */       if (xRole2MountsInfo == null)
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       Map<Long, MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*     */       
/*  58 */       MountsInfo xMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(this.appearanceMountsId));
/*  59 */       if (xMountsInfo == null)
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       Map<Long, AppearenceMountsInfo> xAppearenceMountsInfoMap = xRole2MountsInfo.getAppearence_mounts_info_map();
/*  65 */       AppearenceMountsInfo xAppearenceMountsInfo = (AppearenceMountsInfo)xAppearenceMountsInfoMap.get(Long.valueOf(this.appearanceMountsId));
/*  66 */       if (xAppearenceMountsInfo == null)
/*     */       {
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       if (xAppearenceMountsInfo.getEffect_time() == -1L)
/*     */       {
/*  73 */         return false;
/*     */       }
/*     */       
/*  76 */       long remainTime = xAppearenceMountsInfo.getEffect_time() - (mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() - xAppearenceMountsInfo.getStart_time());
/*     */       
/*  78 */       if (remainTime <= 0L)
/*     */       {
/*  80 */         xAppearenceMountsInfoMap.remove(Long.valueOf(this.appearanceMountsId));
/*  81 */         xMountsInfoMap.remove(Long.valueOf(this.appearanceMountsId));
/*     */       }
/*     */       else
/*     */       {
/*  85 */         return false;
/*     */       }
/*     */       
/*  88 */       Role2MountsObserverInfo xRole2MountsObserverInfo = Role2mountsobserver.get(Long.valueOf(this.roleId));
/*  89 */       if (xRole2MountsObserverInfo != null)
/*     */       {
/*  91 */         xRole2MountsObserverInfo.getObserver_map().remove(Long.valueOf(this.appearanceMountsId));
/*     */       }
/*     */       
/*  94 */       int mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*  95 */       MountsManager.triggerAppearanceMountsExpiredEvent(this.roleId, mountsCfgId, xRole2MountsInfo.getCurrent_ride_mounts_id(), this.appearanceMountsId);
/*     */       
/*     */ 
/*  98 */       SAppearenceMountsExpired sAppearenceMountsExpired = new SAppearenceMountsExpired();
/*  99 */       sAppearenceMountsExpired.mounts_id = this.appearanceMountsId;
/* 100 */       OnlineManager.getInstance().send(this.roleId, sAppearenceMountsExpired);
/*     */       
/* 102 */       GameServer.logger().info(String.format("[mounts]MountsExpiredMillObserver.processImp@role appearence mounts expired|role_id=%d|mounts_id=%d|mounts_cfg_id=%d|start_time=%d|effect_time=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.appearanceMountsId), Integer.valueOf(mountsCfgId), Long.valueOf(xAppearenceMountsInfo.getStart_time()), Long.valueOf(xAppearenceMountsInfo.getEffect_time()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 107 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\MountsExpiredMillObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */