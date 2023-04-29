/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.apollo.event.CloseVoipRoomResponseArg;
/*    */ import mzm.gsp.apollo.event.CloseVoipRoomResponseProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnCloseVoipRoomResponse
/*    */   extends CloseVoipRoomResponseProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long createrid = ((CloseVoipRoomResponseArg)this.arg).getRoleid();
/* 18 */     OctetsStream context = new OctetsStream();
/* 19 */     context.replace(((CloseVoipRoomResponseArg)this.arg).getContext());
/* 20 */     int voipRoomType = context.unmarshal_int();
/* 21 */     long ownerid = context.unmarshal_long();
/* 22 */     long sessionid = context.unmarshal_long();
/* 23 */     boolean isSucceed = ((CloseVoipRoomResponseArg)this.arg).isSucceed();
/* 24 */     int retcode = ((CloseVoipRoomResponseArg)this.arg).getRetcode();
/*    */     
/* 26 */     if (voipRoomType == 1)
/*    */     {
/* 28 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(ownerid), new POnCloseTeamVoipRoomResponse(createrid, ownerid, isSucceed, retcode, sessionid));
/*    */       
/* 30 */       return true;
/*    */     }
/* 32 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnCloseVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */