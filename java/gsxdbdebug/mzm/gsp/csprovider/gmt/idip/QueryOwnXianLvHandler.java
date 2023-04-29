/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QueryOwnXianLvHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 17 */     String userid = (String)params.get(0);
/* 18 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/* 19 */     int partnerCfgid = Integer.parseInt((String)params.get(2));
/*    */     
/* 21 */     xbean.User xUser = xtable.User.get(userid);
/* 22 */     if (null == xUser)
/*    */     {
/* 24 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 25 */       rsp.retcode = retcode;
/* 26 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().error(String.format("[gmt]QueryOwnXianLvHandler.execute@user not found|userid=%s|roleid=%d|partner_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(partnerCfgid) }));
/*    */       
/*    */ 
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 37 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 38 */       rsp.retcode = retcode;
/* 39 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 40 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 42 */       GameServer.logger().error(String.format("[gmt]QueryOwnXianLvHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|partner_cfgid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(partnerCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     boolean own = PartnerInterface.ownPartner(roleid, partnerCfgid);
/* 50 */     Response response = new Response();
/* 51 */     if (own)
/*    */     {
/* 53 */       response.msg = "ok";
/*    */     }
/*    */     else
/*    */     {
/* 57 */       response.msg = "no one";
/*    */     }
/*    */     
/* 60 */     rsp.retcode = Retcode.SUCCESS.value;
/* 61 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 63 */     GameServer.logger().info(String.format("[gmt]QueryOwnXianLvHandler.execute@query own xian_lv success|userid=%s|roleid=%d|partner_cfgid=%d|own=%b", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(partnerCfgid), Boolean.valueOf(own) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryOwnXianLvHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */