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
/*    */ public class PCspQueryRoleInfoByName
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspQueryRoleInfoByName(DataBetweenCspAndGame dataReq)
/*    */   {
/* 18 */     super(dataReq);
/*    */   }
/*    */   
/*    */   protected int doProcess(JSONObject jso, DataBetweenCspAndGame_Re rep)
/*    */     throws Exception
/*    */   {
/* 24 */     String rolename = jso.getString("rolename");
/* 25 */     if (rolename == null)
/*    */     {
/* 27 */       String logString = String.format("[gmt]PCspQueryRoleInfoByName.doProcess@role name error|qtype=%d|reqdata=%s", new Object[] { Integer.valueOf(getQtype()), getJsonTextString() });
/*    */       
/* 29 */       GameServer.logger().error(logString);
/* 30 */       return Retcode.ROLE_NOT_EXIST.value;
/*    */     }
/*    */     
/*    */ 
/* 34 */     long r = RoleInterface.getRoleIdByName(rolename);
/* 35 */     if (r == -1L)
/*    */     {
/* 37 */       return Retcode.ROLE_NOT_EXIST.value;
/*    */     }
/*    */     
/*    */ 
/* 41 */     String roleinfo = DealMessageFromCsp.queryRoleInfo(r);
/* 42 */     rep.repdata = Octets.wrap(roleinfo, "UTF-8");
/* 43 */     return Retcode.SUCCESS.value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspQueryRoleInfoByName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */