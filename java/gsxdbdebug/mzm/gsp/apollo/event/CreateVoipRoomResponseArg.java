/*    */ package mzm.gsp.apollo.event;
/*    */ 
/*    */ import apollo.ApolloCreateVoipRoomRsp;
/*    */ 
/*    */ public class CreateVoipRoomResponseArg
/*    */ {
/*    */   private final ApolloCreateVoipRoomRsp rsp;
/*    */   
/*    */   public CreateVoipRoomResponseArg(ApolloCreateVoipRoomRsp rsp)
/*    */   {
/* 11 */     this.rsp = rsp;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isSucceed()
/*    */   {
/* 21 */     return this.rsp.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRetcode()
/*    */   {
/* 31 */     return this.rsp.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getUserid()
/*    */   {
/* 41 */     return this.rsp.account.getString("UTF-8");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 51 */     return this.rsp.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoomid()
/*    */   {
/* 61 */     return this.rsp.room_id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public com.goldhuman.Common.Octets getContext()
/*    */   {
/* 71 */     return this.rsp.async_data;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\event\CreateVoipRoomResponseArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */