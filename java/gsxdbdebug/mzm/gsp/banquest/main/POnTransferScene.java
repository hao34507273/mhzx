/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import mzm.gsp.banquest.SClearBanquetInfo;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.BanquestInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2banquestinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnTransferScene
/*     */   extends PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  26 */     long newWorldId = ((MapTransferArg)this.arg).newWorldId;
/*  27 */     long oldWorldId = ((MapTransferArg)this.arg).oldWorldId;
/*  28 */     List<Long> roleIds = ((MapTransferArg)this.arg).roleList;
/*     */     
/*  30 */     long newMasterId = BanquestManager.getMasterIdBy(newWorldId);
/*  31 */     long oldMasterId = BanquestManager.getMasterIdBy(oldWorldId);
/*     */     
/*  33 */     if ((newMasterId <= 0L) && (oldMasterId <= 0L))
/*     */     {
/*     */ 
/*  36 */       return false;
/*     */     }
/*  38 */     if ((newMasterId > 0L) && (oldMasterId > 0L))
/*     */     {
/*  40 */       if (newMasterId == oldMasterId)
/*     */       {
/*     */ 
/*  43 */         return afterJoinHomeland(roleIds, newMasterId);
/*     */       }
/*     */       
/*  46 */       afterDifHomelandTF(newMasterId, oldMasterId, roleIds);
/*  47 */       return true;
/*     */     }
/*  49 */     if ((newMasterId > 0L) && (oldMasterId <= 0L))
/*     */     {
/*     */ 
/*  52 */       return afterJoinHomeland(roleIds, newMasterId);
/*     */     }
/*  54 */     if ((oldMasterId > 0L) && (newMasterId <= 0L))
/*     */     {
/*     */ 
/*  57 */       return afterLeaveHomeland(roleIds, oldMasterId);
/*     */     }
/*     */     
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   private void afterDifHomelandTF(long newMasterId, long oldMasterId, List<Long> roleIds)
/*     */   {
/*  65 */     new RDifHomelandTF(newMasterId, oldMasterId, roleIds).execute();
/*     */   }
/*     */   
/*     */   private class RDifHomelandTF extends LogicRunnable
/*     */   {
/*     */     private final long newMasterId;
/*     */     private final long oldMasterId;
/*     */     private final List<Long> roleIds;
/*     */     
/*     */     public RDifHomelandTF(long arg3, List<Long> arg5)
/*     */     {
/*  76 */       this.newMasterId = newMasterId;
/*  77 */       this.oldMasterId = oldMasterId;
/*  78 */       this.roleIds = roleIds;
/*     */     }
/*     */     
/*     */ 
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  85 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  91 */           return POnTransferScene.this.afterLeaveHomeland(POnTransferScene.RDifHomelandTF.this.roleIds, POnTransferScene.RDifHomelandTF.this.oldMasterId);
/*     */         }
/*     */         
/*     */ 
/*  95 */       }.call();
/*  96 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 102 */           return POnTransferScene.this.afterJoinHomeland(POnTransferScene.RDifHomelandTF.this.roleIds, POnTransferScene.RDifHomelandTF.this.newMasterId);
/*     */         }
/*     */       }.call();
/*     */     }
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
/*     */   private boolean afterJoinHomeland(List<Long> joinRoleIds, long masterId)
/*     */   {
/* 120 */     return BanquestManager.synBanquestInfo(joinRoleIds, masterId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean afterLeaveHomeland(List<Long> leaveRoleIds, long masterId)
/*     */   {
/* 131 */     if (masterId <= 0L)
/*     */     {
/* 133 */       return false;
/*     */     }
/* 135 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 137 */     String userId = RoleInterface.getUserId(masterId);
/* 138 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/* 140 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(masterId));
/* 141 */     if (!BanquestManager.isInBanquestTime(xBanquestInfo, curTime))
/*     */     {
/* 143 */       return false;
/*     */     }
/* 145 */     Collection<Long> guestIds = BanquestManager.getBanquestGuyIds(masterId);
/* 146 */     BanquestManager.synBanquestGuyNum(masterId, guestIds);
/*     */     
/* 148 */     OnlineManager.getInstance().sendMulti(new SClearBanquetInfo(masterId), leaveRoleIds);
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */