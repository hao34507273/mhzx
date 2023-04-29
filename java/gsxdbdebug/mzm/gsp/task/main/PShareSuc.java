/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.task.conParamObj.ShareParamObj;
/*    */ import mzm.gsp.task.confbean.STaskShareCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PShareSuc
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int shareId;
/*    */   private final int shareCount;
/*    */   
/*    */   public PShareSuc(long roleId, int shareId, int shareCount)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.shareId = shareId;
/* 25 */     this.shareCount = shareCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!isParameterValid())
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[task]PShareSuc.processImp@ parameter is invalid!|roleId=%d|shareId=%d|shareCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.shareId), Integer.valueOf(this.shareCount) }));
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/* 38 */     TaskInterface.updateTaskCondition(this.roleId, 20, new ShareParamObj(this.shareCount, this.shareId));
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isParameterValid()
/*    */   {
/* 44 */     if (this.shareCount <= 0)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     if (STaskShareCfg.get(this.shareId) == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PShareSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */