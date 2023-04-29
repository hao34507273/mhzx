/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCPopup extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int type;
/*    */   
/*    */   public PCPopup(long roleid, int type)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.type = type;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     GameServer.logger().info(String.format("[addiction]PCPopup.processImp@pupup done|roleid=%d|type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.type) }));
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\PCPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */