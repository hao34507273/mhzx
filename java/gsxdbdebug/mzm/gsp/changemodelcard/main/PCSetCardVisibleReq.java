/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SSetCardVisibleFail;
/*     */ import mzm.gsp.changemodelcard.SSetCardVisibleSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ 
/*     */ public class PCSetCardVisibleReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCSetCardVisibleReq(long roleId)
/*     */   {
/*  17 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  24 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  26 */       String logstr = String.format("[changemodelcard]PCSetCardVisibleReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  28 */       GameServer.logger().info(logstr);
/*  29 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  33 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1974, true))
/*     */     {
/*  35 */       String logstr = String.format("[changemodelcard]PCSetCardVisibleReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  37 */       GameServer.logger().info(logstr);
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  44 */       onFail(-1);
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(this.roleId);
/*  50 */     if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*     */     {
/*  52 */       onFail(-2);
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     if (xRole2CardInfo.getVisible())
/*     */     {
/*  59 */       onFail(-3);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     xRole2CardInfo.setVisible(true);
/*  65 */     ChangeModelCardManager.triggerVisibleChangeEvent(this.roleId, xRole2CardInfo);
/*     */     
/*     */ 
/*  68 */     onSuccess();
/*     */     
/*  70 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess()
/*     */   {
/*  76 */     SSetCardVisibleSuccess protocol = new SSetCardVisibleSuccess();
/*  77 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/*  80 */     String logstr = String.format("[changemodelcard]PCSetCardVisibleReq.onSuccess@PCSetCardVisibleReq success|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */     
/*  82 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/*  93 */     SSetCardVisibleFail protocol = new SSetCardVisibleFail();
/*  94 */     protocol.error_code = errorCode;
/*  95 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */     
/*     */ 
/*  98 */     String logstr = String.format("[changemodelcard]PCSetCardVisibleReq.onFail@PCSetCardVisibleReq failed|errorCode=%d,roleId=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId) });
/*     */     
/*     */ 
/* 101 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCSetCardVisibleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */