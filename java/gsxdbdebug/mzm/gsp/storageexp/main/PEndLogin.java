/*    */ package mzm.gsp.storageexp.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.StorageExp;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2storageexp;
/*    */ 
/*    */ public class PEndLogin
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PEndLogin(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 28 */     StorageStateCache.getInstance().setState(this.roleId, StorageStateCache.STATE_NORMAL);
/*    */     
/* 30 */     new SynStorageExp().call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   class SynStorageExp
/*    */     extends LogicProcedure
/*    */   {
/*    */     SynStorageExp() {}
/*    */     
/*    */ 
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(PEndLogin.this.roleId) }));
/* 46 */       StorageExp xStorageExp = Role2storageexp.get(Long.valueOf(PEndLogin.this.roleId));
/* 47 */       if (xStorageExp == null)
/*    */       {
/* 49 */         xStorageExp = Pod.newStorageExp();
/* 50 */         xStorageExp.setLastupdate(DateTimeUtils.getCurrTimeInMillis());
/* 51 */         Role2storageexp.add(Long.valueOf(PEndLogin.this.roleId), xStorageExp);
/*    */       }
/*    */       
/* 54 */       StorageExpManager.update(PEndLogin.this.roleId, xStorageExp);
/* 55 */       if (GameServer.logger().isDebugEnabled())
/*    */       {
/* 57 */         GameServer.logger().debug("[storageExp]SynStorageExp.processImp@ login finished!");
/*    */       }
/* 59 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\PEndLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */