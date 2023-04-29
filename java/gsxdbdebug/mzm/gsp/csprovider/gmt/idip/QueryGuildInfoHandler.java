/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import idip.QueryGuildInfoRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QueryGuildInfoHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     String userid = (String)params.get(0);
/* 21 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 23 */     xbean.User xUser = xtable.User.get(userid);
/* 24 */     if (null == xUser)
/*    */     {
/* 26 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]QueryGuildInfoHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 38 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 39 */       rsp.retcode = retcode;
/* 40 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 41 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 43 */       GameServer.logger().error(String.format("[gmt]QueryGuildInfoHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     Gang gang = GangInterface.getGangByRoleId(roleid, true);
/* 50 */     QueryGuildInfoRsp queryGuildInfoRsp = new QueryGuildInfoRsp();
/* 51 */     if (gang != null)
/*    */     {
/* 53 */       long gangid = gang.getGangId();
/* 54 */       queryGuildInfoRsp.GuildId = String.valueOf(gang.getGangId());
/* 55 */       queryGuildInfoRsp.GuildId32 = 0;
/* 56 */       queryGuildInfoRsp.GuildName = gang.getName();
/* 57 */       long bangZhuRoleid = gang.getBangZhuId();
/* 58 */       queryGuildInfoRsp.LeaderName = RoleInterface.getName(bangZhuRoleid);
/* 59 */       queryGuildInfoRsp.LeaderRoleId = String.valueOf(bangZhuRoleid);
/* 60 */       queryGuildInfoRsp.Rank = 0;
/* 61 */       queryGuildInfoRsp.Level = gang.getLevel();
/* 62 */       queryGuildInfoRsp.EnableCnt = GangInterface.getGangMaxNum(gangid);
/*    */       
/* 64 */       queryGuildInfoRsp.CurMemberCnt = gang.getMemberSize();
/* 65 */       String announcement = GangInterface.getGangAnnouncement(gangid);
/* 66 */       if ((announcement != null) && (!announcement.isEmpty()))
/*    */       {
/* 68 */         queryGuildInfoRsp.Content = announcement;
/*    */       }
/* 70 */       String gangDecla = GangInterface.getGangPurpose(gangid);
/* 71 */       if ((gangDecla != null) && (!gangDecla.isEmpty()))
/*    */       {
/* 73 */         queryGuildInfoRsp.GuildDecla = gangDecla;
/*    */       }
/* 75 */       queryGuildInfoRsp.Money = GangInterface.getGangMoney(gangid);
/*    */     }
/*    */     else
/*    */     {
/* 79 */       queryGuildInfoRsp.GuildId = String.valueOf(0);
/*    */     }
/*    */     
/* 82 */     rsp.retcode = Retcode.SUCCESS.value;
/* 83 */     Response response = new Response();
/* 84 */     response.data = queryGuildInfoRsp;
/* 85 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 87 */     GameServer.logger().info(String.format("[gmt]QueryGuildInfoHandler.execute@query guild info success|userid=%s|roleid=%d|gangid=%s", new Object[] { userid, Long.valueOf(roleid), queryGuildInfoRsp.GuildId }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryGuildInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */