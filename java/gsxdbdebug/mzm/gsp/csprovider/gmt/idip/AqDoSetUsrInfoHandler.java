/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.IdipInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoSetUsrInfoHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  18 */     String userid = (String)params.get(0);
/*  19 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  20 */     int time = Integer.parseInt((String)params.get(2));
/*  21 */     String content = (String)params.get(3);
/*  22 */     int type = Integer.parseInt((String)params.get(4));
/*     */     
/*  24 */     xbean.User xUser = xtable.User.get(userid);
/*  25 */     if (null == xUser)
/*     */     {
/*  27 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  28 */       rsp.retcode = retcode;
/*  29 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  30 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  32 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@user not found|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/*  36 */       return;
/*     */     }
/*     */     
/*  39 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  41 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  42 */       rsp.retcode = retcode;
/*  43 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  44 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  46 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/*  50 */       return;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (type != 1)
/*     */     {
/*  56 */       int retcode = Retcode.SET_USR_INFO_TYPE_INVALID.value;
/*  57 */       rsp.retcode = retcode;
/*  58 */       Response response = IdipGmtUtil.getResponse(retcode, "type not exist");
/*  59 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  61 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@type not exist|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return;
/*     */     }
/*     */     
/*     */ 
/*  69 */     if (time <= 0)
/*     */     {
/*  71 */       int retcode = Retcode.SET_USR_INFO_TIME_INVALID.value;
/*  72 */       rsp.retcode = retcode;
/*  73 */       Response response = IdipGmtUtil.getResponse(retcode, "time <= 0");
/*  74 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  76 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@time <= 0|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       return;
/*     */     }
/*     */     
/*     */ 
/*  84 */     if (content.isEmpty())
/*     */     {
/*  86 */       int retcode = Retcode.SET_USR_INFO_CONTENT_EMPTY.value;
/*  87 */       rsp.retcode = retcode;
/*  88 */       Response response = IdipGmtUtil.getResponse(retcode, "content is empty");
/*  89 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  91 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@content is empty|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/*  95 */       return;
/*     */     }
/*  97 */     if (content.length() > 256)
/*     */     {
/*  99 */       int retcode = Retcode.SET_USR_INFO_CONTENT_TOO_LONG.value;
/* 100 */       rsp.retcode = retcode;
/* 101 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("content length > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/* 103 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 105 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@content length > MAX_SET_USR_INFO_CONTENT_LEN|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/* 109 */       return;
/*     */     }
/*     */     
/*     */ 
/* 113 */     int result = RoleInterface.changeRoleName4Idip(roleid, content);
/* 114 */     if (result != 0)
/*     */     {
/*     */ 
/* 117 */       switch (result)
/*     */       {
/*     */       case -1: 
/* 120 */         rsp.retcode = Retcode.SET_USR_INFO_NAME_INVALID.value;
/* 121 */         rsp.repdata.setString("content_name invalid");
/* 122 */         break;
/*     */       case -2: 
/* 124 */         rsp.retcode = Retcode.SET_USR_INFO_NAME_SENSITIVE.value;
/* 125 */         rsp.repdata.setString("content_name sensitive");
/* 126 */         break;
/*     */       case -3: 
/* 128 */         rsp.retcode = Retcode.SET_USR_INFO_NAME_REPEAT.value;
/* 129 */         rsp.repdata.setString("content_name repeat");
/* 130 */         break;
/*     */       default: 
/* 132 */         rsp.retcode = Retcode.SET_USR_INFO_NAME_FAILED.value;
/* 133 */         rsp.repdata.setString("change role name failed");
/*     */       }
/*     */       
/*     */       
/* 137 */       GameServer.logger().error(String.format("[gmt]AqDoSetUsrInfoHandler.execute@do lock role info failed|ret=%d|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { Integer.valueOf(result), userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */       
/*     */ 
/*     */ 
/* 141 */       return;
/*     */     }
/*     */     
/*     */ 
/* 145 */     IdipInterface.addLockRoleInfo(roleid, type, time, content);
/*     */     
/* 147 */     rsp.retcode = Retcode.SUCCESS.value;
/* 148 */     Response response = new Response();
/* 149 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 151 */     TLogManager.getInstance().addLog(userid, "GMTAqDoSetUsrInfo", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) });
/*     */     
/* 153 */     GameServer.logger().info(String.format("[gmt]AqDoSetUsrInfoHandler.execute@do lock role info done|userid=%s|roleid=%d|type=%d|content=%s|time=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), content, Integer.valueOf(time) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoSetUsrInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */