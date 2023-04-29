/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.QueryUsrInfoRsp;
/*     */ import idip.SUsrInfo;
/*     */ import idip.core.Utils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
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
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryUsrInfoHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  27 */     String userid = (String)params.get(0);
/*  28 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*     */     
/*  30 */     xbean.User xUser = xtable.User.select(userid);
/*  31 */     if (null == xUser)
/*     */     {
/*  33 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  34 */       rsp.retcode = retcode;
/*  35 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  36 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  38 */       GameServer.logger().error(String.format("[gmt]QueryUsrInfoHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*     */       
/*  40 */       return;
/*     */     }
/*     */     
/*     */ 
/*  44 */     List<Long> xRoleIdsList = xUser.getRoleids();
/*  45 */     if ((roleid > 0L) && ((!xRoleIdsList.contains(Long.valueOf(roleid))) || (!RoleInterface.isRoleExist(roleid, false))))
/*     */     {
/*  47 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  48 */       rsp.retcode = retcode;
/*  49 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  50 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  52 */       GameServer.logger().error(String.format("[gmt]QueryUsrInfoHandler.execute@role not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     QueryUsrInfoRsp queryUsrInfoRsp = new QueryUsrInfoRsp();
/*  59 */     if (roleid > 0L)
/*     */     {
/*  61 */       Role role = RoleInterface.getRole(roleid, false);
/*  62 */       SUsrInfo roleInfo = new SUsrInfo();
/*  63 */       fillRoleInfo(roleid, role, roleInfo);
/*     */       
/*  65 */       queryUsrInfoRsp.UsrInfoList_count = 1;
/*  66 */       queryUsrInfoRsp.UsrInfoList.add(roleInfo);
/*     */     }
/*     */     else
/*     */     {
/*  70 */       for (Iterator i$ = xRoleIdsList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  72 */         if (RoleInterface.isRoleExist(roleId, false))
/*     */         {
/*     */ 
/*     */ 
/*  76 */           Role role = RoleInterface.getRole(roleId, false);
/*  77 */           SUsrInfo roleInfo = new SUsrInfo();
/*  78 */           fillRoleInfo(roleId, role, roleInfo);
/*  79 */           queryUsrInfoRsp.UsrInfoList.add(roleInfo);
/*     */         } }
/*  81 */       queryUsrInfoRsp.UsrInfoList_count = queryUsrInfoRsp.UsrInfoList.size();
/*     */     }
/*     */     
/*  84 */     rsp.retcode = Retcode.SUCCESS.value;
/*  85 */     Response response = new Response();
/*  86 */     response.data = queryUsrInfoRsp;
/*  87 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/*  89 */     GameServer.logger().info(String.format("[gmt]QueryUsrInfoHandler.execute@query role info success|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*     */   }
/*     */   
/*     */   private void fillRoleInfo(long roleId, Role role, SUsrInfo roleInfo)
/*     */     throws Exception
/*     */   {
/*  95 */     String userId = role.getUserId();
/*  96 */     roleInfo.RoleId = String.valueOf(roleId);
/*  97 */     roleInfo.RoleName = role.getName();
/*  98 */     roleInfo.CashNum = ((int)QingfuInterface.getBalance(userId, false));
/*  99 */     roleInfo.MoneyNum = ((int)role.getGold());
/* 100 */     roleInfo.SilverNum = ((int)role.getSilver());
/* 101 */     roleInfo.Exp = role.getExp();
/* 102 */     roleInfo.Level = role.getLevel();
/* 103 */     roleInfo.SchoolName = RoleInterface.getOccupationName(role.getOccupationId());
/* 104 */     Gang gang = GangInterface.getGangByRoleId(roleId, false);
/* 105 */     roleInfo.GangName = (gang == null ? "" : gang.getName());
/* 106 */     roleInfo.HisContribution = ((int)MallInterface.getJifen(roleId, 3));
/* 107 */     roleInfo.Chivalrous = ((int)MallInterface.getJifen(roleId, 1));
/* 108 */     roleInfo.Reputation = ((int)MallInterface.getJifen(roleId, 4));
/* 109 */     roleInfo.CompetitivePoint = ((int)MallInterface.getJifen(roleId, 2));
/* 110 */     roleInfo.GangContribution = ((int)GangInterface.getBangGong(roleId));
/* 111 */     roleInfo.Fight = role.getFightValue();
/* 112 */     roleInfo.RegisterTime = Utils.formatTimestamp(role.getCreateTime());
/* 113 */     roleInfo.TotalLoginTime = 0;
/* 114 */     roleInfo.LastLogoutTime = Utils.formatTimestamp(role.getLastLogoffTime());
/* 115 */     roleInfo.IsOnline = (OnlineManager.getInstance().isOnline(roleId) ? 1 : 0);
/* 116 */     roleInfo.RechargeCashNum = ((int)QingfuInterface.getYuanbao(userId, false));
/* 117 */     roleInfo.BoundCashNum = ((int)QingfuInterface.getBindYuanbao(userId, false));
/* 118 */     roleInfo.UserID = userId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryUsrInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */