/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCApolloEnterLargeRoomReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int roomType;
/*    */   private final long roomContextId;
/*    */   
/*    */   public PCApolloEnterLargeRoomReq(long roleid, int roomType, long roomContextId)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.roomType = roomType;
/* 15 */     this.roomContextId = roomContextId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return ApolloManager.enterApolloLargeRoom(this.roleid, this.roomType, this.roomContextId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCApolloEnterLargeRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */