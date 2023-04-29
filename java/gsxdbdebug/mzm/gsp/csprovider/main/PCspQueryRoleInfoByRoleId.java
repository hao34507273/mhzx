/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCspQueryRoleInfoByRoleId
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspQueryRoleInfoByRoleId(DataBetweenCspAndGame dataReq)
/*    */   {
/* 18 */     super(dataReq);
/*    */   }
/*    */   
/*    */   protected int doProcess(JSONObject jso, DataBetweenCspAndGame_Re rep)
/*    */     throws Exception
/*    */   {
/* 24 */     long roleId = getTargetRoleId(jso);
/* 25 */     if ((roleId == -1L) || (!RoleInterface.isRoleExit(roleId)))
/*    */     {
/* 27 */       String logString = String.format("[gmt]PCspQueryRoleInfoById.doProcess@role id error|qtype=%d|reqdata=%s|roleid=%d", new Object[] { Integer.valueOf(getQtype()), getJsonTextString(), Long.valueOf(roleId) });
/*    */       
/*    */ 
/* 30 */       GameServer.logger().error(logString);
/* 31 */       return Retcode.ROLE_NOT_EXIST.value;
/*    */     }
/*    */     
/*    */ 
/* 35 */     String roleinfo = DealMessageFromCsp.queryRoleInfo(roleId);
/*    */     
/* 37 */     rep.repdata = Octets.wrap(roleinfo, "UTF-8");
/* 38 */     return Retcode.SUCCESS.value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspQueryRoleInfoByRoleId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */