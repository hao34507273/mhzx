/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.IdipInterface;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoRelievePunishHandler
/*     */   implements IdipHandler
/*     */ {
/*  18 */   private final int RANK_MIN_TYPE = 0;
/*  19 */   private final int RANK_MAX_TYPE = 25;
/*     */   
/*     */   private static final int RANK_ALL = 99;
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  26 */     String userid = (String)params.get(0);
/*  27 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  28 */     int relieveBanPlay = Integer.parseInt((String)params.get(2));
/*  29 */     int relievePlayType = Integer.parseInt((String)params.get(3));
/*  30 */     int relieveBanJoinRank = Integer.parseInt((String)params.get(4));
/*  31 */     int relieveRankType = Integer.parseInt((String)params.get(5));
/*  32 */     int relieveMaskChat = Integer.parseInt((String)params.get(6));
/*  33 */     int relieveLockUsrInfo = Integer.parseInt((String)params.get(7));
/*  34 */     int relieveZeroProfit = Integer.parseInt((String)params.get(8));
/*     */     
/*  36 */     xbean.User xUser = xtable.User.get(userid);
/*  37 */     if (null == xUser)
/*     */     {
/*  39 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  40 */       rsp.retcode = retcode;
/*  41 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  44 */       GameServer.logger().error(String.format("[gmt]AqDoRelievePunishHandler.execute@user not found|userid=%s|roleid=%d|relieve_ban_play=%d|relieve_play_type=%d|relieve_ban_join_rank=%d|relieve_ban_rank_type=%d|relieve_mask_chat=%d|relieve_lock_usr_info=%d|relieve_zero_rrofit=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(relieveBanPlay), Integer.valueOf(relievePlayType), Integer.valueOf(relieveBanJoinRank), Integer.valueOf(relieveRankType), Integer.valueOf(relieveMaskChat), Integer.valueOf(relieveLockUsrInfo), Integer.valueOf(relieveZeroProfit) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return;
/*     */     }
/*     */     
/*  52 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  54 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  55 */       rsp.retcode = retcode;
/*  56 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  57 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  59 */       GameServer.logger().error(String.format("[gmt]AqDoRelievePunishHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|relieve_ban_play=%d|relieve_play_type=%d|relieve_ban_join_rank=%d|relieve_ban_rank_type=%d|relieve_mask_chat=%d|relieve_lock_usr_info=%d|relieve_zero_rrofit=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(relieveBanPlay), Integer.valueOf(relievePlayType), Integer.valueOf(relieveBanJoinRank), Integer.valueOf(relieveRankType), Integer.valueOf(relieveMaskChat), Integer.valueOf(relieveLockUsrInfo), Integer.valueOf(relieveZeroProfit) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return;
/*     */     }
/*     */     
/*     */ 
/*  68 */     if (relieveBanPlay == 1)
/*     */     {
/*  70 */       if (relievePlayType == Integer.MAX_VALUE)
/*     */       {
/*  72 */         IdipInterface.removeBanPlayAll(roleid);
/*     */       }
/*  74 */       else if ((relievePlayType >= 0) && (relievePlayType <= 592))
/*     */       {
/*  76 */         IdipInterface.removeBanPlay(roleid, relievePlayType);
/*     */       }
/*     */       else
/*     */       {
/*  80 */         int retcode = Retcode.AQ_DO_RELIEVE_PUNISH_PLAY_TYPE_INVALID.value;
/*  81 */         rsp.retcode = retcode;
/*  82 */         Response response = IdipGmtUtil.getResponse(retcode, "play type invalid");
/*  83 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  85 */         GameServer.logger().error(String.format("[gmt]AqDoRelievePunishHandler.execute@play type invalid|userid=%s|roleid=%d|relieve_ban_play=%d|relieve_play_type=%d|relieve_ban_join_rank=%d|relieve_ban_rank_type=%d|relieve_mask_chat=%d|relieve_lock_usr_info=%d|relieve_zero_rrofit=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(relieveBanPlay), Integer.valueOf(relievePlayType), Integer.valueOf(relieveBanJoinRank), Integer.valueOf(relieveRankType), Integer.valueOf(relieveMaskChat), Integer.valueOf(relieveLockUsrInfo), Integer.valueOf(relieveZeroProfit) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  90 */         return;
/*     */       }
/*     */     }
/*     */     
/*  94 */     if (relieveBanJoinRank == 1)
/*     */     {
/*  96 */       if ((relieveRankType >= 0) && (relieveRankType <= 25))
/*     */       {
/*  98 */         IdipInterface.removeBanRank(roleid, relieveRankType);
/*     */       }
/* 100 */       else if (relieveRankType == 99)
/*     */       {
/* 102 */         IdipInterface.removeBanRankAll(roleid);
/*     */       }
/*     */       else
/*     */       {
/* 106 */         int retcode = Retcode.AQ_DO_RELIEVE_PUNISH_RANK_TYPE_INVALID.value;
/* 107 */         rsp.retcode = retcode;
/* 108 */         Response response = IdipGmtUtil.getResponse(retcode, "rank type invalid");
/* 109 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 111 */         GameServer.logger().error(String.format("[gmt]AqDoRelievePunishHandler.execute@rank type invalid|userid=%s|roleid=%d|relieve_ban_play=%d|relieve_play_type=%d|relieve_ban_join_rank=%d|relieve_ban_rank_type=%d|relieve_mask_chat=%d|relieve_lock_usr_info=%d|relieve_zero_rrofit=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(relieveBanPlay), Integer.valueOf(relievePlayType), Integer.valueOf(relieveBanJoinRank), Integer.valueOf(relieveRankType), Integer.valueOf(relieveMaskChat), Integer.valueOf(relieveLockUsrInfo), Integer.valueOf(relieveZeroProfit) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 116 */         return;
/*     */       }
/*     */     }
/*     */     
/* 120 */     if (relieveMaskChat == 1)
/*     */     {
/* 122 */       ForbidInfoManager.unforbidTalk(roleid);
/*     */     }
/*     */     
/* 125 */     if (relieveLockUsrInfo == 1)
/*     */     {
/* 127 */       IdipInterface.removeLockRoleInfo(roleid, 1);
/*     */     }
/*     */     
/* 130 */     if (relieveZeroProfit == 1)
/*     */     {
/* 132 */       IdipInterface.relieveZeroProfit(roleid);
/*     */     }
/*     */     
/* 135 */     rsp.retcode = Retcode.SUCCESS.value;
/* 136 */     Response response = new Response();
/* 137 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 139 */     TLogManager.getInstance().addLog(userid, "GMTAqDoRelievePunish", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(relieveBanPlay), Integer.valueOf(relievePlayType), Integer.valueOf(relieveBanJoinRank), Integer.valueOf(relieveRankType), Integer.valueOf(relieveMaskChat), Integer.valueOf(relieveLockUsrInfo), Integer.valueOf(relieveZeroProfit) });
/*     */     
/*     */ 
/* 142 */     GameServer.logger().info(String.format("[gmt]AqDoRelievePunishHandler.execute@do relieve punish done|userid=%s|roleid=%d|relieve_ban_play=%d|relieve_play_type=%d|relieve_ban_join_rank=%d|relieve_ban_rank_type=%d|relieve_mask_chat=%d|relieve_lock_usr_info=%d|relieve_zero_rrofit=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(relieveBanPlay), Integer.valueOf(relievePlayType), Integer.valueOf(relieveBanJoinRank), Integer.valueOf(relieveRankType), Integer.valueOf(relieveMaskChat), Integer.valueOf(relieveLockUsrInfo), Integer.valueOf(relieveZeroProfit) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoRelievePunishHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */