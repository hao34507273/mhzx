/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ public class PCspQueryRoleInfoByUserId
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspQueryRoleInfoByUserId(DataBetweenCspAndGame dataReq)
/*    */   {
/* 17 */     super(dataReq);
/*    */   }
/*    */   
/*    */   protected int doProcess(JSONObject jso, DataBetweenCspAndGame_Re rep)
/*    */     throws Exception
/*    */   {
/* 23 */     String userid = jso.getString("account");
/* 24 */     xbean.User xUser = xtable.User.select(userid);
/* 25 */     if ((xUser == null) || (xUser.getRoleids().isEmpty()))
/*    */     {
/* 27 */       String logString = String.format("[gmt]CSProviderManager.doProcess@user name error|qtype=%d|reqdata=%s|userid=%s", new Object[] { Integer.valueOf(getQtype()), getJsonTextString(), userid });
/*    */       
/* 29 */       GameServer.logger().error(logString);
/* 30 */       return Retcode.GAME_ACCOUNT_NOT_EXIST.value;
/*    */     }
/*    */     
/*    */ 
/* 34 */     String roleListInfo = DealMessageFromCsp.queryRoleInfoList(xUser.getRoleids());
/* 35 */     rep.repdata = Octets.wrap(roleListInfo, "UTF-8");
/* 36 */     return Retcode.SUCCESS.value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspQueryRoleInfoByUserId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */