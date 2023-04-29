/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SUseRevengeItemTransferFail;
/*     */ import mzm.gsp.pk.SUseRevengeItemTransferSuccess;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ public class PUseRevengeItemTransfer
/*     */   extends LogicProcedure implements MapCallback<Boolean>
/*     */ {
/*     */   private final long roleId;
/*     */   private long targetRoleId;
/*     */   
/*     */   public PUseRevengeItemTransfer(long roleId)
/*     */   {
/*  24 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (PKManager.isNotEnable()) {
/*  31 */       return false;
/*     */     }
/*  33 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1628, true)) {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  38 */     if ((teamInfo != null) && (teamInfo.getLeaderId() != this.roleId) && (RoleStatusInterface.containsStatus(this.roleId, 6)))
/*     */     {
/*     */ 
/*  41 */       PKLogManager.error(String.format("PUseRevengeItem.processImp()@team member cannot use revenge item|roleId=%d|teamid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(teamInfo.getTeamId()) }));
/*     */       
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     RevengeItemTransferContext context = RevengeItemTransferContext.getContext(this.roleId);
/*  48 */     if (context == null)
/*     */     {
/*  50 */       notifyFail(1);
/*  51 */       PKLogManager.error(String.format("PUseRevengeItemTransfer.processImp()@no context|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  52 */       return false;
/*     */     }
/*  54 */     this.targetRoleId = context.targetRoleId;
/*     */     
/*     */ 
/*  57 */     long worldId = MapInterface.getBigWorldid();
/*  58 */     MapInterface.transferToScene(this.roleId, worldId, context.mapId, context.posX, context.posY, context.channelId, this);
/*  59 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Boolean result)
/*     */   {
/*  71 */     if (result.booleanValue())
/*     */     {
/*  73 */       notifySuccess();
/*  74 */       PKLogManager.info(String.format("RevengeItemTransferCallback.onResult()@done|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/*  76 */       PKLogManager.tlogRevengeItemTransferToTarget(this.roleId, this.targetRoleId);
/*  77 */       return true;
/*     */     }
/*     */     
/*  80 */     PKLogManager.error(String.format("RevengeItemTransferCallback.onResult()@transfer fail|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */     
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   private void notifySuccess()
/*     */   {
/*     */     try
/*     */     {
/*  89 */       SUseRevengeItemTransferSuccess sUseRevengeItemTransferSuccess = new SUseRevengeItemTransferSuccess();
/*  90 */       sUseRevengeItemTransferSuccess.target_role_id = this.targetRoleId;
/*  91 */       sUseRevengeItemTransferSuccess.target_role_name.setString(RoleInterface.getName(this.targetRoleId), "UTF-8");
/*  92 */       OnlineManager.getInstance().send(this.roleId, sUseRevengeItemTransferSuccess);
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/*  96 */       PKLogManager.error("RevengeItemTransferCallback.notifySuccess()@unsupported encoding exception");
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 102 */     SUseRevengeItemTransferFail sUseRevengeItemTransferFail = new SUseRevengeItemTransferFail();
/* 103 */     sUseRevengeItemTransferFail.retcode = retcode;
/* 104 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sUseRevengeItemTransferFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PUseRevengeItemTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */