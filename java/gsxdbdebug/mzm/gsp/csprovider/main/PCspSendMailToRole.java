/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ public class PCspSendMailToRole
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspSendMailToRole(DataBetweenCspAndGame dataReq)
/*    */   {
/* 16 */     super(dataReq);
/*    */   }
/*    */   
/*    */   protected int doProcess(JSONObject jso, DataBetweenCspAndGame_Re rep)
/*    */     throws Exception
/*    */   {
/* 22 */     long roleId = getTargetRoleId(jso);
/* 23 */     if ((roleId == -1L) || (!RoleInterface.isRoleExit(roleId)))
/*    */     {
/* 25 */       String logString = String.format("[gmt]PCspSendMailToRole.doProcess@role id error|qtype=%d|reqdata=%s|roleid=%d", new Object[] { Integer.valueOf(getQtype()), getJsonTextString(), Long.valueOf(roleId) });
/*    */       
/* 27 */       GameServer.logger().error(logString);
/* 28 */       return Retcode.ROLE_NOT_EXIST.value;
/*    */     }
/*    */     
/*    */ 
/* 32 */     int ret = DealMessageFromCsp.sendMailToRole(roleId, jso);
/* 33 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspSendMailToRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */