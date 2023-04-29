/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.IdipInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoBanJoinRankHandler implements IdipHandler
/*     */ {
/*  17 */   private final int MIN_TYPE = 0;
/*  18 */   private final int MAX_TYPE = 25;
/*     */   
/*     */   private static final int ALL = 99;
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  25 */     String userid = (String)params.get(0);
/*  26 */     long roleid = Long.parseLong((String)params.get(1));
/*  27 */     int time = Integer.parseInt((String)params.get(2));
/*  28 */     String tip = (String)params.get(3);
/*  29 */     int type = Integer.parseInt((String)params.get(4));
/*  30 */     int isZeroRank = Integer.parseInt((String)params.get(5));
/*     */     
/*  32 */     xbean.User xUser = xtable.User.get(userid);
/*  33 */     if (null == xUser)
/*     */     {
/*  35 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  36 */       rsp.retcode = retcode;
/*  37 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  38 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  40 */       GameServer.logger().error(String.format("[gmt]AqDoBanJoinRankHandler.execute@user not found|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/*  44 */       return;
/*     */     }
/*     */     
/*  47 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  49 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  50 */       rsp.retcode = retcode;
/*  51 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  52 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  54 */       GameServer.logger().error(String.format("[gmt]AqDoBanJoinRankHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/*  58 */       return;
/*     */     }
/*     */     
/*     */ 
/*  62 */     if ((type != 99) && ((type < 0) || (type > 25)))
/*     */     {
/*  64 */       int retcode = Retcode.AQ_DO_BAN_JOIN_RANK_TYPE_INVALID.value;
/*  65 */       rsp.retcode = retcode;
/*  66 */       Response response = IdipGmtUtil.getResponse(retcode, "rank type not exist");
/*  67 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  69 */       GameServer.logger().error(String.format("[gmt]AqDoBanJoinRankHandler.execute@rank type not exit|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/*  73 */       return;
/*     */     }
/*     */     
/*  76 */     if (tip.isEmpty())
/*     */     {
/*  78 */       int retcode = Retcode.AQ_DO_BAN_JOIN_RANK_REASON_EMPTY.value;
/*  79 */       rsp.retcode = retcode;
/*  80 */       Response response = IdipGmtUtil.getResponse(retcode, "tip is empty");
/*  81 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  83 */       GameServer.logger().error(String.format("[gmt]AqDoBanJoinRankHandler.execute@tip is empty|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/*  87 */       return;
/*     */     }
/*     */     
/*  90 */     if (tip.length() > 256)
/*     */     {
/*  92 */       int retcode = Retcode.AQ_DO_BAN_JOIN_RANK_REASON_TOO_LONG.value;
/*  93 */       rsp.retcode = retcode;
/*  94 */       Response response = IdipGmtUtil.getResponse(retcode, "tip len > MAX_BAN_JOIN_RANK_TIP_LEN");
/*  95 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  97 */       GameServer.logger().error(String.format("[gmt]AqDoBanJoinRankHandler.execute@tip length > MAX_BAN_JOIN_RANK_TIP_LEN|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/* 101 */       return;
/*     */     }
/*     */     
/* 104 */     if (time <= 0)
/*     */     {
/* 106 */       int retcode = Retcode.AQ_DO_BAN_JOIN_RANK_TIME_INVALID.value;
/* 107 */       rsp.retcode = retcode;
/* 108 */       Response response = IdipGmtUtil.getResponse(retcode, "time <= 0");
/* 109 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 111 */       GameServer.logger().error(String.format("[gmt]AqDoBanJoinRankHandler.execute@time <= 0|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/* 115 */       return;
/*     */     }
/*     */     
/* 118 */     boolean result = true;
/* 119 */     if (type == 99)
/*     */     {
/* 121 */       IdipInterface.banRankAll(roleid, time, tip);
/* 122 */       result = RankInterface.removeRoleidInAllRankForIDIP(roleid, isZeroRank == 1);
/*     */     }
/*     */     else
/*     */     {
/* 126 */       IdipInterface.addBanRank(roleid, type, time, tip);
/* 127 */       result = RankInterface.removeRoleidInRankForIDIP(roleid, type, isZeroRank == 1);
/*     */     }
/*     */     
/* 130 */     TLogManager.getInstance().addLog(userid, "GMTAqDoBanJoinRank", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), tip, Integer.valueOf(type), Integer.valueOf(isZeroRank) });
/*     */     
/* 132 */     if (!result)
/*     */     {
/* 134 */       int retcode = Retcode.SUCCESS.value;
/* 135 */       rsp.retcode = retcode;
/* 136 */       Response response = IdipGmtUtil.getResponse(retcode, "not in rank");
/* 137 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 139 */       GameServer.logger().info(String.format("[gmt]AqDoBanJoinRankHandler.execute@role not in rank|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */       
/*     */ 
/*     */ 
/* 143 */       return;
/*     */     }
/*     */     
/* 146 */     rsp.retcode = Retcode.SUCCESS.value;
/* 147 */     Response response = new Response();
/* 148 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 150 */     GameServer.logger().info(String.format("[gmt]AqDoBanJoinRankHandler.execute@ban join rank done|userid=%s|roleid=%d|type=%d|time=%d|tip=%s|is_zero_rank=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(time), tip, Integer.valueOf(isZeroRank) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoBanJoinRankHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */