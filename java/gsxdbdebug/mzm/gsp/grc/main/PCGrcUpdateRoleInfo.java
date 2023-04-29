/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGrcUpdateRoleInfo extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGrcUpdateRoleInfo(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!GrcManager.canDoAction(this.roleId, 302))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     boolean result = GrcManager.updateGrcInfo(this.roleId);
/*    */     
/* 26 */     GameServer.logger().info(String.format("[grc]PCGrcUpdateRoleInfo.processImp@update grc info done|roleid=%d|result=%b", new Object[] { Long.valueOf(this.roleId), Boolean.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGrcUpdateRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */