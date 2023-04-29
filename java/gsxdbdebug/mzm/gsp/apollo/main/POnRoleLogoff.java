/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((Long)this.arg).longValue();
/* 11 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 13 */     ApolloManager.onRoleLogoff(roleid, userid, false);
/*    */     
/* 15 */     ApolloManager.sendReportSpeakerMicStatus(userid, -1, (byte)0);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */