/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoMaskChatHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  19 */     String userid = (String)params.get(0);
/*  20 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  21 */     int time = Integer.parseInt((String)params.get(2));
/*  22 */     String reason = (String)params.get(3);
/*  23 */     boolean clear = Integer.parseInt((String)params.get(4)) == 1;
/*     */     
/*  25 */     xbean.User xUser = xtable.User.get(userid);
/*  26 */     if (null == xUser)
/*     */     {
/*  28 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  29 */       rsp.retcode = retcode;
/*  30 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  31 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  33 */       GameServer.logger().error(String.format("[gmt]AqDoMaskChatHandler.execute@user not found|userid=%s|roleid=%d|reason=%s|time=%d|clear=%b", new Object[] { userid, Long.valueOf(roleid), reason, Integer.valueOf(time), Boolean.valueOf(clear) }));
/*     */       
/*     */ 
/*     */ 
/*  37 */       return;
/*     */     }
/*     */     
/*  40 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  42 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  43 */       rsp.retcode = retcode;
/*  44 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  45 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  47 */       GameServer.logger().error(String.format("[gmt]AqDoMaskChatHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|reason=%s|time=%d|clear=%b", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), reason, Integer.valueOf(time), Boolean.valueOf(clear) }));
/*     */       
/*     */ 
/*     */ 
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     if (time <= 0)
/*     */     {
/*  56 */       int retcode = Retcode.MASK_CHAT_TIME_INVALID.value;
/*  57 */       rsp.retcode = retcode;
/*  58 */       Response response = IdipGmtUtil.getResponse(retcode, "time <= 0");
/*  59 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  61 */       GameServer.logger().error(String.format("[gmt]AqDoMaskChatHandler.execute@time <= 0|userid=%s|roleid=%d|reason=%s|time=%d|clear=%b", new Object[] { userid, Long.valueOf(roleid), reason, Integer.valueOf(time), Boolean.valueOf(clear) }));
/*     */       
/*     */ 
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     if (reason.isEmpty())
/*     */     {
/*  69 */       int retcode = Retcode.MASK_CHAT_REASON_IS_EMPTY.value;
/*  70 */       rsp.retcode = retcode;
/*  71 */       Response response = IdipGmtUtil.getResponse(retcode, "reason is empty");
/*  72 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  74 */       GameServer.logger().error(String.format("[gmt]AqDoMaskChatHandler.execute@reason is empty|userid=%s|roleid=%d|reason=%s|time=%d|clear=%b", new Object[] { userid, Long.valueOf(roleid), reason, Integer.valueOf(time), Boolean.valueOf(clear) }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return;
/*     */     }
/*  80 */     if (reason.length() > 256)
/*     */     {
/*  82 */       int retcode = Retcode.MASK_CHAT_REASON_TOO_LONG.value;
/*  83 */       rsp.retcode = retcode;
/*  84 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("reason length > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/*  86 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  88 */       GameServer.logger().error(String.format("[gmt]AqDoMaskChatHandler.execute@reason length > MAX_MASKR_EASON_LEN|userid=%s|roleid=%d|reason=%s|time=%d|clear=%b", new Object[] { userid, Long.valueOf(roleid), reason, Integer.valueOf(time), Boolean.valueOf(clear) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     ForbidInfoManager.forbidTalk(roleid, time, reason);
/*  96 */     if (clear)
/*     */     {
/*     */ 
/*  99 */       IdipManager.sendClearSayToAll(roleid);
/*     */     }
/*     */     
/* 102 */     rsp.retcode = Retcode.SUCCESS.value;
/* 103 */     Response response = new Response();
/* 104 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 106 */     TLogManager.getInstance().addLog(userid, "GMTAqDoMaskChat", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason, Integer.valueOf(clear ? 1 : 0) });
/*     */     
/* 108 */     GameServer.logger().info(String.format("[gmt]MashChatHandler.execute@mask chat success|userid=%s|roleid=%d|reason=%s|time=%d|clear=%b", new Object[] { userid, Long.valueOf(roleid), reason, Integer.valueOf(time), Boolean.valueOf(clear) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoMaskChatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */