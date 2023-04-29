/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoBanAddFriendHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  18 */     String userid = (String)params.get(0);
/*  19 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  20 */     int time = Integer.parseInt((String)params.get(2));
/*  21 */     String reason = (String)params.get(3);
/*     */     
/*  23 */     xbean.User xUser = xtable.User.get(userid);
/*  24 */     if (null == xUser)
/*     */     {
/*  26 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  27 */       rsp.retcode = retcode;
/*  28 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  31 */       GameServer.logger().error(String.format("[gmt]AqDoBanAddFriendHandler.execute@user not found|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*  34 */       return;
/*     */     }
/*     */     
/*  37 */     if (roleid > 0L)
/*     */     {
/*  39 */       if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */       {
/*  41 */         int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  42 */         rsp.retcode = retcode;
/*  43 */         Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  44 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  46 */         GameServer.logger().error(String.format("[gmt]AqDoBanAddFriendHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*     */         
/*     */ 
/*     */ 
/*  50 */         return;
/*     */       }
/*     */     }
/*     */     
/*  54 */     if (time <= 0)
/*     */     {
/*  56 */       int retcode = Retcode.BAN_ADD_FRIEND_TIME_INVALID.value;
/*  57 */       rsp.retcode = retcode;
/*  58 */       Response response = IdipGmtUtil.getResponse(retcode, "time <= 0");
/*  59 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  61 */       GameServer.logger().error(String.format("[gmt]AqDoBanAddFriendHandler.execute@time <= 0|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     if (reason.isEmpty())
/*     */     {
/*  69 */       int retcode = Retcode.BAN_ADD_FRIEND_REASON_IS_EMPTY.value;
/*  70 */       rsp.retcode = retcode;
/*  71 */       Response response = IdipGmtUtil.getResponse(retcode, "reason is empty");
/*  72 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  74 */       GameServer.logger().error(String.format("[gmt]AqDoBanAddFriendHandler.execute@reason is empty|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*  77 */       return;
/*     */     }
/*  79 */     if (reason.length() > 300)
/*     */     {
/*  81 */       int retcode = Retcode.BAN_ADD_FRIEND_REASON_TOO_LONG.value;
/*  82 */       rsp.retcode = retcode;
/*  83 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("reason len > %d", new Object[] { Integer.valueOf(300) }));
/*     */       
/*  85 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  87 */       GameServer.logger().error(String.format("[gmt]AqDoBanAddFriendHandler.execute@reason length > MAX_BAN_ADD_FRIEND_REMINDER_LEN|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*     */ 
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     if (roleid > 0L)
/*     */     {
/*  96 */       ForbidInfoManager.forbidFriend(roleid, time, reason);
/*     */     }
/*     */     else
/*     */     {
/* 100 */       ForbidInfoManager.forbidUserFriend(userid, time, reason);
/*     */     }
/*     */     
/* 103 */     rsp.retcode = Retcode.SUCCESS.value;
/* 104 */     Response response = new Response();
/* 105 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 107 */     TLogManager.getInstance().addLog(userid, "GMTAqDoBanAddFriend", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason });
/*     */     
/* 109 */     GameServer.logger().info(String.format("[gmt]AqDoBanAddFriendHandler.execute@ban add friend success|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoBanAddFriendHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */