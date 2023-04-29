/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.AqQueryUsrInfoRsp;
/*     */ import idip.QUERY_USR_INFO_LIST;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqQueryUsrInfoHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  25 */     String userid = (String)params.get(0);
/*  26 */     long targetRoleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*     */     
/*  28 */     xbean.User xUser = xtable.User.get(userid);
/*  29 */     if (null == xUser)
/*     */     {
/*  31 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  32 */       rsp.retcode = retcode;
/*  33 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  34 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  36 */       GameServer.logger().error(String.format("[gmt]AqQueryUsrInfoHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(targetRoleid) }));
/*     */       
/*  38 */       return;
/*     */     }
/*     */     
/*  41 */     List<Long> xRoleIdsList = xUser.getRoleids();
/*  42 */     if ((targetRoleid > 0L) && ((!xRoleIdsList.contains(Long.valueOf(targetRoleid))) || (!RoleInterface.isRoleExist(targetRoleid, false))))
/*     */     {
/*  44 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  45 */       rsp.retcode = retcode;
/*  46 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  47 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  49 */       GameServer.logger().error(String.format("[gmt]AqQueryUsrInfoHandler.execute@role not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(targetRoleid) }));
/*     */       
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     AqQueryUsrInfoRsp aqQueryUsrInfoRsp = new AqQueryUsrInfoRsp();
/*  55 */     if (targetRoleid <= 0L)
/*     */     {
/*  57 */       for (Iterator i$ = xRoleIdsList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  59 */         if (RoleInterface.isRoleExist(roleId, false))
/*     */         {
/*     */ 
/*     */ 
/*  63 */           Role role = RoleInterface.getRole(roleId, false);
/*  64 */           QUERY_USR_INFO_LIST roleInfo = new QUERY_USR_INFO_LIST();
/*  65 */           fillRoleInfo(roleId, role, roleInfo);
/*     */           
/*  67 */           aqQueryUsrInfoRsp.OpenidList.add(roleInfo);
/*     */         } }
/*  69 */       aqQueryUsrInfoRsp.OpenidList_count = aqQueryUsrInfoRsp.OpenidList.size();
/*     */     }
/*     */     else
/*     */     {
/*  73 */       Role role = RoleInterface.getRole(targetRoleid, false);
/*  74 */       QUERY_USR_INFO_LIST roleInfo = new QUERY_USR_INFO_LIST();
/*  75 */       fillRoleInfo(targetRoleid, role, roleInfo);
/*     */       
/*  77 */       aqQueryUsrInfoRsp.OpenidList.add(roleInfo);
/*  78 */       aqQueryUsrInfoRsp.OpenidList_count = 1;
/*     */     }
/*     */     
/*  81 */     rsp.retcode = Retcode.SUCCESS.value;
/*  82 */     Response response = new Response();
/*  83 */     response.data = aqQueryUsrInfoRsp;
/*  84 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/*  86 */     GameServer.logger().info(String.format("[gmt]AqQueryUsrInfoHandler.execute@query usr info success|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(targetRoleid) }));
/*     */   }
/*     */   
/*     */ 
/*     */   private void fillRoleInfo(long roleId, Role role, QUERY_USR_INFO_LIST roleInfo)
/*     */     throws Exception
/*     */   {
/*  93 */     roleInfo.RoleName = role.getName();
/*  94 */     roleInfo.Level = role.getLevel();
/*  95 */     roleInfo.GangId = ((int)GangInterface.getGangId(roleId));
/*  96 */     roleInfo.Exp = role.getExp();
/*  97 */     roleInfo.StoreExp = ((int)StorageExpInterface.getCurCanUseStorageExp(roleId));
/*     */     
/*  99 */     roleInfo.Cash = ((int)QingfuInterface.getBalance(role.getUserId(), false));
/* 100 */     roleInfo.Money = ((int)role.getGold());
/* 101 */     roleInfo.Silver = ((int)role.getSilver());
/*     */     
/* 103 */     roleInfo.Fight = role.getFightValue();
/*     */     
/* 105 */     roleInfo.CompetitivePoint = ((int)MallInterface.getJifen(roleId, 2));
/* 106 */     roleInfo.Chivalrous = ((int)MallInterface.getJifen(roleId, 1));
/* 107 */     roleInfo.Reputation = ((int)MallInterface.getJifen(roleId, 4));
/*     */     
/* 109 */     roleInfo.Vitality = RoleInterface.getVigor(roleId);
/*     */     
/* 111 */     roleInfo.GangContribute = ((int)GangInterface.getBangGong(roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqQueryUsrInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */