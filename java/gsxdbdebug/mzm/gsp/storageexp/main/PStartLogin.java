/*    */ package mzm.gsp.storageexp.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStartLogin
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PStartLogin(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 30 */     StorageStateCache.getInstance().setState(this.roleId, StorageStateCache.STATE_ONLINE);
/* 31 */     if (GameServer.logger().isDebugEnabled())
/*    */     {
/* 33 */       GameServer.logger().debug("[storageExp]SynStorageExp.processImp@ login begin!");
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\PStartLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */