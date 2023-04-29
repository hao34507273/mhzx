/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.apollo.event.CreateVoipRoomResponseArg;
/*    */ import mzm.gsp.apollo.event.CreateVoipRoomResponseProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnCreateVoipRoomResponse
/*    */   extends CreateVoipRoomResponseProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     long createrid = ((CreateVoipRoomResponseArg)this.arg).getRoleid();
/* 17 */     OctetsStream context = new OctetsStream();
/* 18 */     context.replace(((CreateVoipRoomResponseArg)this.arg).getContext());
/* 19 */     int voipRoomType = context.unmarshal_int();
/* 20 */     long ownerid = context.unmarshal_long();
/* 21 */     boolean isSucceed = ((CreateVoipRoomResponseArg)this.arg).isSucceed();
/* 22 */     int retcode = ((CreateVoipRoomResponseArg)this.arg).getRetcode();
/* 23 */     long roomid = ((CreateVoipRoomResponseArg)this.arg).getRoomid();
/*    */     
/* 25 */     if (voipRoomType == 1)
/*    */     {
/* 27 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(ownerid), new POnCreateTeamVoipRoomResponse(createrid, ownerid, isSucceed, retcode, roomid));
/*    */       
/* 29 */       return true;
/*    */     }
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnCreateVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */