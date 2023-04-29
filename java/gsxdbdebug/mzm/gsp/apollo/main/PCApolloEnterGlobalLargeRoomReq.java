/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCApolloEnterGlobalLargeRoomReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int roomType;
/*    */   
/*    */   public PCApolloEnterGlobalLargeRoomReq(long roleid, int roomType)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.roomType = roomType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     return ApolloManager.enterApolloGlobalRoom(this.roleid, this.roomType);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCApolloEnterGlobalLargeRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */