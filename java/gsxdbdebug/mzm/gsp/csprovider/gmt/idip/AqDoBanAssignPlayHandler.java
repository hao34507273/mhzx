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
/*     */ public class AqDoBanAssignPlayHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   private static final int ALL_TYPE = Integer.MAX_VALUE;
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  21 */     String userid = (String)params.get(0);
/*  22 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  23 */     int banPlayTime = Integer.parseInt((String)params.get(2));
/*  24 */     String reminder = (String)params.get(3);
/*  25 */     int banType = Integer.parseInt((String)params.get(4));
/*     */     
/*  27 */     xbean.User xUser = xtable.User.get(userid);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  31 */       rsp.retcode = retcode;
/*  32 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  33 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  35 */       GameServer.logger().error(String.format("[gmt]AqDoBanAssignPlayHandler.execute@user not found|userid=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */       
/*     */ 
/*     */ 
/*  39 */       return;
/*     */     }
/*     */     
/*  42 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  44 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  45 */       rsp.retcode = retcode;
/*  46 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  47 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  49 */       GameServer.logger().error(String.format("[gmt]AqDoBanAssignPlayHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */       
/*     */ 
/*     */ 
/*  53 */       return;
/*     */     }
/*     */     
/*  56 */     if (banPlayTime <= 0)
/*     */     {
/*  58 */       int retcode = Retcode.BAN_PLAY_TIME_INVALID.value;
/*  59 */       rsp.retcode = retcode;
/*  60 */       Response response = IdipGmtUtil.getResponse(retcode, "ban play time <= 0");
/*  61 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  63 */       GameServer.logger().error(String.format("[gmt]AqDoBanAssignPlayHandler.execute@ban play time <= 0|userid=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */       
/*     */ 
/*     */ 
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     if (reminder.isEmpty())
/*     */     {
/*  72 */       int retcode = Retcode.BAN_PLAY_REASON_IS_EMPTY.value;
/*  73 */       rsp.retcode = retcode;
/*  74 */       Response response = IdipGmtUtil.getResponse(retcode, "ban reminder is empty");
/*  75 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  77 */       GameServer.logger().error(String.format("[gmt]AqDoBanAssignPlayHandler.execute@ban reminder is empty|userid=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return;
/*     */     }
/*  83 */     if (reminder.length() > 300)
/*     */     {
/*  85 */       int retcode = Retcode.BAN_PLAY_REASON_TOO_LONG.value;
/*  86 */       rsp.retcode = retcode;
/*  87 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("ban reminder length > %d", new Object[] { Integer.valueOf(300) }));
/*     */       
/*  89 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  91 */       GameServer.logger().error(String.format("[gmt]AqDoBanAssignPlayHandler.execute@reminder length > MAX_BAN_PLAY_REMINDER_LEN|userid=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */       
/*     */ 
/*     */ 
/*  95 */       return;
/*     */     }
/*     */     
/*     */ 
/*  99 */     if (((banType < 0) || (banType > 592)) && (banType != Integer.MAX_VALUE))
/*     */     {
/* 101 */       int retcode = Retcode.BAN_PLAY_TYPE_INVALID.value;
/* 102 */       rsp.retcode = retcode;
/* 103 */       Response response = IdipGmtUtil.getResponse(retcode, "play type not exist");
/* 104 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 106 */       GameServer.logger().error(String.format("[gmt]AqDoBanAssignPlayHandler.execute@play type not exist|userid=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */       
/*     */ 
/*     */ 
/* 110 */       return;
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (banType == Integer.MAX_VALUE)
/*     */     {
/* 116 */       IdipInterface.banPlayAll(roleid, banPlayTime, reminder);
/*     */     }
/*     */     else
/*     */     {
/* 120 */       IdipInterface.addBanPlay(roleid, banType, banPlayTime, reminder);
/*     */     }
/*     */     
/* 123 */     rsp.retcode = Retcode.SUCCESS.value;
/* 124 */     Response response = new Response();
/* 125 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 127 */     TLogManager.getInstance().addLog(userid, "GMTAqDoBanAssignPlay", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banPlayTime), reminder, Integer.valueOf(banType) });
/*     */     
/* 129 */     GameServer.logger().info(String.format("[gmt]AqDoBanAssignPlayHandler.execute@do ban play done|userid=%s|roleid=%d|ban_type=%d|ban_play_time=%d|reminder=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(banType), Integer.valueOf(banPlayTime), reminder }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoBanAssignPlayHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */