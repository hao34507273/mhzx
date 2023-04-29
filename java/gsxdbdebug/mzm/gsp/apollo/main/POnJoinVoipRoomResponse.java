/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.apollo.event.JoinVoipRoomResponseArg;
/*    */ import mzm.gsp.apollo.event.JoinVoipRoomResponseProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnJoinVoipRoomResponse
/*    */   extends JoinVoipRoomResponseProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleid = ((JoinVoipRoomResponseArg)this.arg).getRoleid();
/* 21 */     OctetsStream context = new OctetsStream();
/* 22 */     context.replace(((JoinVoipRoomResponseArg)this.arg).getContext());
/* 23 */     int voipRoomType = context.unmarshal_int();
/* 24 */     long ownerid = context.unmarshal_long();
/* 25 */     boolean isSucceed = ((JoinVoipRoomResponseArg)this.arg).isSucceed();
/* 26 */     int retcode = ((JoinVoipRoomResponseArg)this.arg).getRetcode();
/* 27 */     long roomid = ((JoinVoipRoomResponseArg)this.arg).getRoomid();
/* 28 */     Octets openid = ((JoinVoipRoomResponseArg)this.arg).getOpenidOctets();
/* 29 */     int memberid = ((JoinVoipRoomResponseArg)this.arg).getMemberid();
/* 30 */     long roomKey = ((JoinVoipRoomResponseArg)this.arg).getRoomKey();
/* 31 */     long extraData = ((JoinVoipRoomResponseArg)this.arg).getExtraData();
/* 32 */     List<Octets> accessIPList = ((JoinVoipRoomResponseArg)this.arg).getAccessIPOctetsList();
/*    */     
/* 34 */     if (voipRoomType == 1)
/*    */     {
/* 36 */       TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(ownerid), new POnJoinTeamVoipRoomResponse(roleid, ownerid, isSucceed, retcode, roomid, openid, memberid, roomKey, extraData, accessIPList));
/*    */       
/*    */ 
/*    */ 
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnJoinVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */