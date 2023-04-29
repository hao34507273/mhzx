/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.role.main.MoneyOperResult;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoUpdateMoneyHandler implements IdipHandler
/*     */ {
/*     */   private static final int GOLD = 0;
/*     */   private static final int SILVER = 1;
/*     */   private static final int GOLDINGOT = 2;
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  25 */     String userid = (String)params.get(0);
/*  26 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  27 */     int type = Integer.parseInt((String)params.get(2));
/*  28 */     int value = Integer.parseInt((String)params.get(3));
/*     */     
/*  30 */     xbean.User xUser = xtable.User.get(userid);
/*  31 */     if (null == xUser)
/*     */     {
/*  33 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  34 */       rsp.retcode = retcode;
/*  35 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  36 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  38 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateMoneyHandler.execute@user not found|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  41 */       return;
/*     */     }
/*     */     
/*  44 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  46 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  47 */       rsp.retcode = retcode;
/*  48 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  49 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  51 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateMoneyHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     if ((type != 0) && (type != 1) && (type != 2))
/*     */     {
/*  60 */       int retcode = Retcode.AQ_UPDATE_MONEY_TYPE_INVALID.value;
/*  61 */       rsp.retcode = retcode;
/*  62 */       Response response = IdipGmtUtil.getResponse(retcode, "money type not exist");
/*  63 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  65 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateMoneyHandler.execute@money type not exist|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     if (value == 0)
/*     */     {
/*  74 */       int retcode = Retcode.AQ_UPDATE_MONEY_VALUE_INVALID.value;
/*  75 */       rsp.retcode = retcode;
/*  76 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  77 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  79 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateMoneyHandler.execute@value equals 0|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  82 */       return;
/*     */     }
/*     */     
/*  85 */     Role role = RoleInterface.getRole(roleid, true);
/*  86 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_MONEY);
/*  87 */     long beginValue = 0L;
/*  88 */     long endValue = 0L;
/*  89 */     MoneyOperResult result = null;
/*  90 */     if (value >= 0)
/*     */     {
/*  92 */       switch (type)
/*     */       {
/*     */       case 0: 
/*  95 */         beginValue = role.getGold();
/*  96 */         result = RoleInterface.addGoldByAqIDIP(roleid, value, tLogArg);
/*  97 */         endValue = role.getGold();
/*  98 */         break;
/*     */       case 1: 
/* 100 */         beginValue = role.getSilver();
/* 101 */         result = RoleInterface.addSilverByAqIDIP(roleid, value, tLogArg);
/* 102 */         endValue = role.getSilver();
/* 103 */         break;
/*     */       case 2: 
/* 105 */         beginValue = (int)role.getGoldIngot();
/* 106 */         result = RoleInterface.addGoldIngotByAqIDIP(roleid, value, tLogArg);
/* 107 */         endValue = (int)role.getGoldIngot();
/* 108 */         break;
/*     */       
/*     */ 
/*     */ 
/*     */       }
/*     */       
/*     */     } else {
/* 115 */       switch (type)
/*     */       {
/*     */       case 0: 
/* 118 */         beginValue = (int)role.getGold();
/* 119 */         result = RoleInterface.cutGoldByAqIDIP(roleid, -value, tLogArg);
/* 120 */         endValue = (int)role.getGold();
/* 121 */         break;
/*     */       case 1: 
/* 123 */         beginValue = (int)role.getSilver();
/* 124 */         result = RoleInterface.cutSilverByAqIDIP(roleid, -value, tLogArg);
/* 125 */         endValue = (int)role.getSilver();
/* 126 */         break;
/*     */       case 2: 
/* 128 */         beginValue = (int)role.getGoldIngot();
/* 129 */         result = RoleInterface.cutGoldIngotByAqIDIP(roleid, -value, tLogArg);
/* 130 */         endValue = (int)role.getGoldIngot();
/* 131 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */     
/*     */ 
/* 137 */     if ((result != MoneyOperResult.SUCCESS) && (result != MoneyOperResult.MONEY_NUM_REACH_MAX_FOR_AQIDIP) && (result != MoneyOperResult.MONEY_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/*     */ 
/* 140 */       int retcode = Retcode.AQ_UPDATE_MONEY_FAILED.value;
/* 141 */       rsp.retcode = retcode;
/* 142 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/* 143 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 145 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateMoneyHandler.execute@update money failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     rsp.retcode = Retcode.SUCCESS.value;
/* 153 */     Response response = new Response();
/* 154 */     response.msg = result.retMsg;
/* 155 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 157 */     TLogManager.getInstance().addLog(userid, "GMTAqDoUpdateMoney", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Long.valueOf(beginValue), Long.valueOf(endValue) });
/*     */     
/* 159 */     GameServer.logger().info(String.format("[gmt]AqDoUpdateMoneyHandler.execute@update money success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|type=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Long.valueOf(beginValue), Long.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoUpdateMoneyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */