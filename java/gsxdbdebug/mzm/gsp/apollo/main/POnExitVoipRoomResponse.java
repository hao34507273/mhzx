/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.apollo.event.ExitVoipRoomResponseArg;
/*    */ import mzm.gsp.apollo.event.ExitVoipRoomResponseProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnExitVoipRoomResponse
/*    */   extends ExitVoipRoomResponseProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long roleid = ((ExitVoipRoomResponseArg)this.arg).getRoleid();
/* 18 */     OctetsStream context = new OctetsStream();
/* 19 */     context.replace(((ExitVoipRoomResponseArg)this.arg).getContext());
/* 20 */     int voipRoomType = context.unmarshal_int();
/* 21 */     long ownerid = context.unmarshal_long();
/* 22 */     long sessionid = context.unmarshal_long();
/* 23 */     boolean isSucceed = ((ExitVoipRoomResponseArg)this.arg).isSucceed();
/* 24 */     int retcode = ((ExitVoipRoomResponseArg)this.arg).getRetcode();
/* 25 */     if (voipRoomType == 1)
/*    */     {
/* 27 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(ownerid), new POnExitTeamVoipRoomResponse(roleid, ownerid, isSucceed, retcode, sessionid));
/*    */       
/* 29 */       return true;
/*    */     }
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnExitVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */