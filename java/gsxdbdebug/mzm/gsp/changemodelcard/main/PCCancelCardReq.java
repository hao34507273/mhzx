/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.changemodelcard.SCancelCardFail;
/*    */ import mzm.gsp.changemodelcard.SCancelCardSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2ChangeModelCardInfo;
/*    */ 
/*    */ public class PCCancelCardReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCCancelCardReq(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*    */     {
/* 27 */       String logstr = String.format("[changemodelcard]PCCancelCardReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 29 */       GameServer.logger().info(logstr);
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1973, true))
/*    */     {
/* 36 */       String logstr = String.format("[changemodelcard]PCCancelCardReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 38 */       GameServer.logger().info(logstr);
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*    */     {
/* 45 */       onFail(-1);
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(this.roleId);
/* 51 */     if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*    */     {
/* 53 */       onFail(-2);
/* 54 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 58 */     ChangeModelCardManager.tryRemoveChangeModelState(this.roleId, xRole2CardInfo, ChangeModelCardManager.RemoveCardStateReason.ACTIVE_CANCEL);
/*    */     
/*    */ 
/* 61 */     onSuccess();
/*    */     
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void onSuccess()
/*    */   {
/* 72 */     SCancelCardSuccess protocol = new SCancelCardSuccess();
/* 73 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*    */     
/*    */ 
/* 76 */     String logstr = String.format("[changemodelcard]PCCancelCardReq.onSuccess@PCCancelCardReq success|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */     
/* 78 */     GameServer.logger().info(logstr);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void onFail(int errorCode)
/*    */   {
/* 89 */     SCancelCardFail protocol = new SCancelCardFail();
/* 90 */     protocol.error_code = errorCode;
/* 91 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*    */     
/*    */ 
/* 94 */     String logstr = String.format("[changemodelcard]PCCancelCardReq.onFail@PCCancelCardReq failed|errorCode=%d,roleId=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId) });
/*    */     
/* 96 */     GameServer.logger().info(logstr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCCancelCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */