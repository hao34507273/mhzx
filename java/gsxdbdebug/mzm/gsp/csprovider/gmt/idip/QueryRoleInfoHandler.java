/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.QueryRoleInfoRsp;
/*     */ import idip.core.Utils;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryRoleInfoHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  27 */     long roleid = Long.parseLong((String)params.get(0));
/*  28 */     String roleNo = (String)params.get(1);
/*  29 */     String roleName = (String)params.get(2);
/*     */     
/*  31 */     long targetRoleid = -1L;
/*  32 */     if (roleid > 0L)
/*     */     {
/*  34 */       if (!RoleInterface.isRoleExist(roleid, false))
/*     */       {
/*  36 */         int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  37 */         rsp.retcode = retcode;
/*  38 */         Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  39 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  41 */         GameServer.logger().error(String.format("[gmt]QueryRoleInfoHandler.execute@role not found|name=%s|role_no=%s|roleid=%d", new Object[] { roleName, roleNo, Long.valueOf(roleid) }));
/*     */         
/*     */ 
/*  44 */         return;
/*     */       }
/*  46 */       targetRoleid = roleid;
/*     */     }
/*     */     
/*  49 */     if (targetRoleid == -1L)
/*     */     {
/*  51 */       if (roleNo.length() > 0)
/*     */       {
/*  53 */         targetRoleid = CommonUtils.roleNoToID(roleNo);
/*     */       }
/*     */     }
/*     */     
/*  57 */     if (targetRoleid == -1L)
/*     */     {
/*  59 */       if ((roleName != null) && (!roleName.isEmpty()))
/*     */       {
/*  61 */         targetRoleid = RoleInterface.getRoleIdByName(roleName);
/*     */       }
/*     */     }
/*     */     
/*  65 */     if ((targetRoleid == -1L) || (!RoleInterface.isRoleExist(targetRoleid, false)))
/*     */     {
/*  67 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  68 */       rsp.retcode = retcode;
/*  69 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  70 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  72 */       GameServer.logger().error(String.format("[gmt]QueryRoleInfoHandler.execute@role not found|name=%s|role_no=%s|roleid=%d", new Object[] { roleName, roleNo, Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*  75 */       return;
/*     */     }
/*     */     
/*  78 */     QueryRoleInfoRsp queryRoleInfoRsp = new QueryRoleInfoRsp();
/*  79 */     Role role = RoleInterface.getRole(targetRoleid, false);
/*  80 */     String userId = role.getUserId();
/*  81 */     queryRoleInfoRsp.UserID = userId;
/*  82 */     queryRoleInfoRsp.RoleName = role.getName();
/*  83 */     queryRoleInfoRsp.CashNum = ((int)QingfuInterface.getBalance(userId, false));
/*  84 */     queryRoleInfoRsp.MoneyNum = ((int)role.getGold());
/*  85 */     queryRoleInfoRsp.SilverNum = ((int)role.getSilver());
/*  86 */     queryRoleInfoRsp.Exp = role.getExp();
/*  87 */     queryRoleInfoRsp.Level = role.getLevel();
/*  88 */     queryRoleInfoRsp.SchoolName = RoleInterface.getOccupationName(role.getOccupationId());
/*  89 */     Gang gang = GangInterface.getGangByRoleId(targetRoleid, false);
/*  90 */     queryRoleInfoRsp.GangName = (gang == null ? "" : gang.getName());
/*  91 */     queryRoleInfoRsp.HisContribution = ((int)MallInterface.getJifen(targetRoleid, 3));
/*  92 */     queryRoleInfoRsp.Chivalrous = ((int)MallInterface.getJifen(targetRoleid, 1));
/*  93 */     queryRoleInfoRsp.Reputation = ((int)MallInterface.getJifen(targetRoleid, 4));
/*  94 */     queryRoleInfoRsp.CompetitivePoint = ((int)MallInterface.getJifen(targetRoleid, 2));
/*  95 */     queryRoleInfoRsp.GangContribution = ((int)GangInterface.getBangGong(targetRoleid));
/*  96 */     queryRoleInfoRsp.Fight = role.getFightValue();
/*  97 */     queryRoleInfoRsp.RegisterTime = Utils.formatTimestamp(role.getCreateTime());
/*  98 */     queryRoleInfoRsp.TotalLoginTime = 0;
/*  99 */     queryRoleInfoRsp.LastLogoutTime = Utils.formatTimestamp(role.getLastLogoffTime());
/* 100 */     queryRoleInfoRsp.IsOnline = (OnlineManager.getInstance().isOnline(targetRoleid) ? 1 : 0);
/* 101 */     queryRoleInfoRsp.RechargeCashNum = ((int)QingfuInterface.getYuanbao(userId, false));
/* 102 */     queryRoleInfoRsp.BoundCashNum = ((int)QingfuInterface.getBindYuanbao(userId, false));
/*     */     
/* 104 */     rsp.retcode = Retcode.SUCCESS.value;
/* 105 */     Response response = new Response();
/* 106 */     response.data = queryRoleInfoRsp;
/* 107 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 109 */     GameServer.logger().info(String.format("[gmt]QueryRoleInfoHandler.execute@query role info success|name=%s|role_no=%s|roleid=%d", new Object[] { roleName, roleNo, Long.valueOf(roleid) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryRoleInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */