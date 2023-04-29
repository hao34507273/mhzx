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
/*    */ public class PCspModifyRoleItemNum
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspModifyRoleItemNum(DataBetweenCspAndGame dataReq)
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
/* 25 */       String logString = String.format("[gmt]PCspModifyRoleItemNum.doProcess@role id error|qtype=%d|reqdata=%s|roleid=%d", new Object[] { Integer.valueOf(getQtype()), getJsonTextString(), Long.valueOf(roleId) });
/*    */       
/*    */ 
/* 28 */       GameServer.logger().error(logString);
/* 29 */       return Retcode.ROLE_NOT_EXIST.value;
/*    */     }
/*    */     
/*    */ 
/* 33 */     return DealMessageFromCsp.modifyItemNum(jso);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspModifyRoleItemNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */