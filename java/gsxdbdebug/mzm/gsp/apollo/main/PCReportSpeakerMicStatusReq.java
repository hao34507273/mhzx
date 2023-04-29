/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCReportSpeakerMicStatusReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int roomType;
/*    */   private final byte status;
/*    */   
/*    */   public PCReportSpeakerMicStatusReq(long roleid, int roomType, byte status)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.roomType = roomType;
/* 16 */     this.status = status;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 24 */     ApolloManager.sendReportSpeakerMicStatus(userid, this.roomType, this.status);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCReportSpeakerMicStatusReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */