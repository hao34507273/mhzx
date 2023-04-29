/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import idip.SSocial;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.main.ShiTuInterface;
/*    */ import mzm.gsp.sworn.main.SwornInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QueryRoleSocialHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 21 */     String userid = (String)params.get(0);
/* 22 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 24 */     xbean.User xUser = xtable.User.get(userid);
/* 25 */     if (null == xUser)
/*    */     {
/* 27 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 28 */       rsp.retcode = retcode;
/* 29 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 30 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 32 */       GameServer.logger().error(String.format("[gmt]QueryRoleSocialHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 39 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 40 */       rsp.retcode = retcode;
/* 41 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 44 */       GameServer.logger().error(String.format("[gmt]QueryRoleSocialHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     SSocial social = new SSocial();
/*    */     
/* 52 */     social.IsSworn = ((byte)(SwornInterface.isRoleSworn(roleid) ? 1 : 0));
/*    */     
/* 54 */     social.IsMarry = ((byte)(MarriageInterface.isMarried(roleid) ? 1 : 0));
/*    */     
/* 56 */     social.IsMaster = ((byte)(ShiTuInterface.isExistShiTuRelation(roleid, false) ? 1 : 0));
/*    */     
/* 58 */     rsp.retcode = Retcode.SUCCESS.value;
/* 59 */     Response response = new Response();
/* 60 */     response.data = social;
/* 61 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 63 */     GameServer.logger().info(String.format("[gmt]QueryRoleSocialHandler.execute@query role social success|userid=%s|roleid=%d|sworn=%d|marry=%d|master=%d", new Object[] { userid, Long.valueOf(roleid), Byte.valueOf(social.IsSworn), Byte.valueOf(social.IsMarry), Byte.valueOf(social.IsMaster) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryRoleSocialHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */