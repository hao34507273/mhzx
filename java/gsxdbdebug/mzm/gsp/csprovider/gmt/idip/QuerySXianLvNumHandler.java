/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QuerySXianLvNumHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     String userid = (String)params.get(0);
/* 20 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 22 */     xbean.User xUser = xtable.User.get(userid);
/* 23 */     if (null == xUser)
/*    */     {
/* 25 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 26 */       rsp.retcode = retcode;
/* 27 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]QuerySXianLvNumHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
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
/* 42 */       GameServer.logger().error(String.format("[gmt]QuerySXianLvNumHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 45 */       return;
/*    */     }
/*    */     
/*    */ 
/* 49 */     Set<Integer> partners = PartnerInterface.getRoleXRankPartners(roleid, 3);
/* 50 */     int num = 0;
/* 51 */     if (partners == null)
/*    */     {
/* 53 */       num = 0;
/*    */     }
/*    */     else
/*    */     {
/* 57 */       num = partners.size();
/*    */     }
/*    */     
/* 60 */     rsp.retcode = Retcode.SUCCESS.value;
/* 61 */     Response response = new Response();
/* 62 */     response.msg = String.valueOf(num);
/* 63 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 65 */     GameServer.logger().info(String.format("[gmt]QuerySXianLvNumHandler.execute@query s_xian_lv num success|userid=%s|roleid=%d|num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(num) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QuerySXianLvNumHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */