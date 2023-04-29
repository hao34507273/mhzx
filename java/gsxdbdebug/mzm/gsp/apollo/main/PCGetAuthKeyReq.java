/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetAuthKeyReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetAuthKeyReq(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return ApolloManager.sendGetAuthKeyReq(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCGetAuthKeyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */