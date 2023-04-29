/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoUpdateCashHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  27 */     String userid = (String)params.get(0);
/*  28 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  29 */     int type = Integer.parseInt((String)params.get(2));
/*  30 */     int value = Integer.parseInt((String)params.get(3));
/*  31 */     boolean kick = Integer.parseInt((String)params.get(4)) == 1;
/*     */     
/*  33 */     xbean.User xUser = xtable.User.get(userid);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  37 */       rsp.retcode = retcode;
/*  38 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  39 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  41 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateCashHandler.execute@user not found|userid=%s|roleid=%d|type=%d|value=%d|kick=%b", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Boolean.valueOf(kick) }));
/*     */       
/*     */ 
/*     */ 
/*  45 */       return;
/*     */     }
/*     */     
/*  48 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  50 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  51 */       rsp.retcode = retcode;
/*  52 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  53 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  55 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateCashHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|type=%d|value=%d|kick=%b", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Boolean.valueOf(kick) }));
/*     */       
/*     */ 
/*     */ 
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     if (value == 0)
/*     */     {
/*  64 */       int retcode = Retcode.AQ_UPDATE_CASH_VALUE_INVALID.value;
/*  65 */       rsp.retcode = retcode;
/*  66 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  67 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  69 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateCashHandler.execute@value == 0|userid=%s|roleid=%d|type=%d|value=%d|kick=%b", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Boolean.valueOf(kick) }));
/*     */       
/*     */ 
/*  72 */       return;
/*     */     }
/*     */     
/*  75 */     boolean isBind = type == 0;
/*  76 */     int beginValue = (int)(isBind ? QingfuInterface.getBindYuanbao(userid, true) : QingfuInterface.getYuanbao(userid, true));
/*     */     
/*     */ 
/*  79 */     int retcode = 0;
/*  80 */     String retMsg = null;
/*  81 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_CASH);
/*  82 */     if (value >= 0)
/*     */     {
/*  84 */       PresentType presentType = isBind ? PresentType.PRESENT_BIND_AQGMT : PresentType.PRESENT_AQGMT;
/*  85 */       PresentResult result = QingfuInterface.presentYuanbao(userid, roleid, value, presentType, tLogArg);
/*  86 */       if (result != PresentResult.Success)
/*     */       {
/*  88 */         rsp.retcode = Retcode.AQ_UPDATE_CASH_PRESENT_FAILED.value;
/*  89 */         Response response = IdipGmtUtil.getResponse(rsp.retcode, result.desc);
/*  90 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  92 */         GameServer.logger().error(String.format("[gmt]AqDoUpdateCashHandler.execute@update yuan bao failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|type=%d|value=%d|kick=%b", new Object[] { Integer.valueOf(result.code), result.desc, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Boolean.valueOf(kick) }));
/*     */         
/*     */ 
/*     */ 
/*  96 */         return;
/*     */       }
/*  98 */       retcode = result.code;
/*  99 */       retMsg = result.desc;
/*     */     }
/*     */     else
/*     */     {
/* 103 */       CostType costType = isBind ? CostType.COST_BIND_FIRST_AQGMT : CostType.COST_AQGMT;
/* 104 */       CostResult result = CostResult.Success;
/* 105 */       if (beginValue != 0)
/*     */       {
/* 107 */         if (beginValue < -value)
/*     */         {
/* 109 */           result = QingfuInterface.costYuanbao(userid, roleid, beginValue, costType, tLogArg);
/* 110 */           if (result == CostResult.Success)
/*     */           {
/* 112 */             result = isBind ? CostResult.BindYuanBaoClearForAqIdip : CostResult.YuanBaoClearForAqIdip;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 117 */           result = QingfuInterface.costYuanbao(userid, roleid, -value, costType, tLogArg);
/*     */         }
/*     */       }
/*     */       
/* 121 */       if ((result != CostResult.Success) && (result != CostResult.BindYuanBaoClearForAqIdip) && (result != CostResult.YuanBaoClearForAqIdip))
/*     */       {
/*     */ 
/* 124 */         rsp.retcode = Retcode.AQ_UPDATE_CASH_COST_FAILED.value;
/* 125 */         Response response = IdipGmtUtil.getResponse(rsp.retcode, result.desc);
/* 126 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 128 */         GameServer.logger().error(String.format("[gmt]AqDoUpdateCashHandler.execute@update yuan bao failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|type=%d|value=%d|kick=%b", new Object[] { Integer.valueOf(result.code), result.desc, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Boolean.valueOf(kick) }));
/*     */         
/*     */ 
/*     */ 
/* 132 */         return;
/*     */       }
/* 134 */       retcode = result.code;
/* 135 */       retMsg = result.desc;
/*     */     }
/*     */     
/* 138 */     if (kick)
/*     */     {
/* 140 */       Onlines.getInstance().kick(Long.valueOf(roleid), 2052);
/*     */     }
/*     */     
/* 143 */     int endValue = (int)(isBind ? QingfuInterface.getBindYuanbao(userid, true) : QingfuInterface.getYuanbao(userid, true));
/*     */     
/*     */ 
/* 146 */     rsp.retcode = Retcode.SUCCESS.value;
/* 147 */     Response response = new Response();
/* 148 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 150 */     TLogManager.getInstance().addLog(userid, "GMTAqDoUpdateCash", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Integer.valueOf(kick ? 1 : 0), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/*     */ 
/* 153 */     GameServer.logger().info(String.format("[gmt]AqDoUpdateCashHandler.execute@update yuan bao success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|type=%d|value=%d|kick=%b|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(retcode), retMsg, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Boolean.valueOf(kick), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoUpdateCashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */