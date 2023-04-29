/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.gang.main.BanggongOperateEnum;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.JifenOperateEnum;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleExpUpdateRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.VigorOperResult;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpOperResult;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class AqDoUpdateOtherCashHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   private static final int GANG_CONTRIBUTION = 7;
/*     */   private static final int ALL = 99;
/*  32 */   private static final Map<Integer, Integer> currencyTypeMap = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  36 */     currencyTypeMap.put(Integer.valueOf(1), Integer.valueOf(5));
/*  37 */     currencyTypeMap.put(Integer.valueOf(2), Integer.valueOf(13));
/*  38 */     currencyTypeMap.put(Integer.valueOf(3), Integer.valueOf(8));
/*  39 */     currencyTypeMap.put(Integer.valueOf(4), Integer.valueOf(9));
/*  40 */     currencyTypeMap.put(Integer.valueOf(5), Integer.valueOf(11));
/*  41 */     currencyTypeMap.put(Integer.valueOf(6), Integer.valueOf(12));
/*  42 */     currencyTypeMap.put(Integer.valueOf(7), Integer.valueOf(7));
/*  43 */     currencyTypeMap.put(Integer.valueOf(99), Integer.valueOf(99));
/*     */   }
/*     */   
/*     */   private OperateResult doUpdate(long roleId, int type, int value)
/*     */   {
/*  48 */     OperateResult result = null;
/*  49 */     switch (type)
/*     */     {
/*     */     case 1: 
/*  52 */       result = doUpdateRoleExp(roleId, value);
/*  53 */       break;
/*     */     case 2: 
/*  55 */       result = doUpdateStoreExp(roleId, value);
/*  56 */       break;
/*     */     case 3: 
/*  58 */       result = doUpdateCompetitivePoint(roleId, value);
/*  59 */       break;
/*     */     case 4: 
/*  61 */       result = doUpdateChivalrous(roleId, value);
/*  62 */       break;
/*     */     case 5: 
/*  64 */       result = doUpdateReputation(roleId, value);
/*  65 */       break;
/*     */     case 6: 
/*  67 */       result = doUpdateVigor(roleId, value);
/*  68 */       break;
/*     */     case 7: 
/*  70 */       result = doUpdateGangContribution(roleId, value);
/*  71 */       break;
/*     */     case 99: 
/*  73 */       result = doUpdateAll(roleId, value);
/*     */     }
/*     */     
/*  76 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private OperateResult doUpdateAll(long roleId, int value)
/*     */   {
/*  82 */     OperateResult result = null;
/*     */     
/*     */ 
/*  85 */     result = doUpdateRoleExp(roleId, value);
/*  86 */     if (!result.success)
/*     */     {
/*  88 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  92 */     result = doUpdateStoreExp(roleId, value);
/*  93 */     if (!result.success)
/*     */     {
/*  95 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  99 */     result = doUpdateCompetitivePoint(roleId, value);
/* 100 */     if (!result.success)
/*     */     {
/* 102 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 106 */     result = doUpdateChivalrous(roleId, value);
/* 107 */     if (!result.success)
/*     */     {
/* 109 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 113 */     result = doUpdateReputation(roleId, value);
/* 114 */     if (!result.success)
/*     */     {
/* 116 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 120 */     result = doUpdateVigor(roleId, value);
/* 121 */     if (!result.success)
/*     */     {
/* 123 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 127 */     result = doUpdateGangContribution(roleId, value);
/* 128 */     if (!result.success)
/*     */     {
/* 130 */       return result;
/*     */     }
/*     */     
/* 133 */     result.success = true;
/* 134 */     result.beginValue = 0;
/* 135 */     result.endValue = 0;
/* 136 */     result.ret = 0;
/* 137 */     result.retMsg = "OK";
/* 138 */     return result;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateGangContribution(long roleId, int value)
/*     */   {
/* 143 */     int beginValue = (int)GangInterface.getBangGong(roleId);
/*     */     
/* 145 */     BanggongOperateEnum result = null;
/* 146 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_OTHER_CASH);
/* 147 */     if (value >= 0)
/*     */     {
/* 149 */       result = GangInterface.addBangGongForAqIdip(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 153 */       result = GangInterface.cutBangGongForAqIdip(roleId, -value, tLogArg);
/*     */     }
/* 155 */     int endValue = (int)GangInterface.getBangGong(roleId);
/*     */     
/* 157 */     OperateResult operateResult = new OperateResult(null);
/* 158 */     operateResult.ret = result.ret;
/* 159 */     operateResult.retMsg = result.retMsg;
/* 160 */     if ((result != BanggongOperateEnum.SUCCESS) && (result != BanggongOperateEnum.ERROR_CLEAR_FOR_AQIDIP))
/*     */     {
/* 162 */       operateResult.success = false;
/* 163 */       operateResult.reason = "update gang contribution failed";
/* 164 */       return operateResult;
/*     */     }
/* 166 */     operateResult.beginValue = beginValue;
/* 167 */     operateResult.endValue = endValue;
/* 168 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateVigor(long roleId, int value)
/*     */   {
/* 173 */     Role role = RoleInterface.getRole(roleId, true);
/* 174 */     int beginValue = role.getVigor();
/*     */     
/* 176 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_OTHER_CASH);
/* 177 */     VigorOperResult result = null;
/* 178 */     if (value >= 0)
/*     */     {
/* 180 */       result = RoleInterface.addVigorByAqIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 184 */       result = RoleInterface.cutVigorByAqIDIP(roleId, -value, tLogArg);
/*     */     }
/* 186 */     int endValue = role.getVigor();
/*     */     
/* 188 */     OperateResult operateResult = new OperateResult(null);
/* 189 */     operateResult.ret = result.ret;
/* 190 */     operateResult.retMsg = result.retMsg;
/* 191 */     if ((result != VigorOperResult.SUCCESS) && (result != VigorOperResult.VIGOR_CLEAR_FOR_AQIDIP))
/*     */     {
/* 193 */       operateResult.success = false;
/* 194 */       operateResult.reason = "update vigor failed";
/* 195 */       return operateResult;
/*     */     }
/* 197 */     operateResult.beginValue = beginValue;
/* 198 */     operateResult.endValue = endValue;
/* 199 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateReputation(long roleId, int value)
/*     */   {
/* 204 */     int beginValue = (int)MallInterface.getJifen(roleId, 4);
/* 205 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_OTHER_CASH);
/* 206 */     JifenOperateEnum result = null;
/* 207 */     if (value >= 0)
/*     */     {
/* 209 */       result = MallInterface.addJifenForAqIdip(roleId, value, 4, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 213 */       result = MallInterface.cutJifenForAqIdip(roleId, -value, 4, tLogArg);
/*     */     }
/* 215 */     int endValue = (int)MallInterface.getJifen(roleId, 4);
/*     */     
/* 217 */     OperateResult operateResult = new OperateResult(null);
/* 218 */     operateResult.ret = result.ret;
/* 219 */     operateResult.retMsg = result.retMsg;
/* 220 */     if ((result != JifenOperateEnum.SUCCESS) && (result != JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/* 222 */       operateResult.success = false;
/* 223 */       operateResult.reason = "update reputation failed";
/* 224 */       return operateResult;
/*     */     }
/* 226 */     operateResult.beginValue = beginValue;
/* 227 */     operateResult.endValue = endValue;
/* 228 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateChivalrous(long roleId, int value)
/*     */   {
/* 233 */     int beginValue = (int)MallInterface.getJifen(roleId, 1);
/* 234 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_OTHER_CASH);
/* 235 */     JifenOperateEnum result = null;
/* 236 */     if (value >= 0)
/*     */     {
/* 238 */       result = MallInterface.addJifenForAqIdip(roleId, value, 1, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 242 */       result = MallInterface.cutJifenForAqIdip(roleId, -value, 1, tLogArg);
/*     */     }
/* 244 */     int endValue = (int)MallInterface.getJifen(roleId, 1);
/*     */     
/* 246 */     OperateResult operateResult = new OperateResult(null);
/* 247 */     operateResult.ret = result.ret;
/* 248 */     operateResult.retMsg = result.retMsg;
/* 249 */     if ((result != JifenOperateEnum.SUCCESS) && (result != JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/* 251 */       operateResult.success = false;
/* 252 */       operateResult.reason = "update chivalrous failed";
/* 253 */       return operateResult;
/*     */     }
/* 255 */     operateResult.beginValue = beginValue;
/* 256 */     operateResult.endValue = endValue;
/* 257 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateCompetitivePoint(long roleId, int value)
/*     */   {
/* 262 */     JifenOperateEnum result = null;
/* 263 */     int beginValue = (int)MallInterface.getJifen(roleId, 2);
/* 264 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_OTHER_CASH);
/* 265 */     if (value >= 0)
/*     */     {
/* 267 */       result = MallInterface.addJifenForAqIdip(roleId, value, 2, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 271 */       result = MallInterface.cutJifenForAqIdip(roleId, -value, 2, tLogArg);
/*     */     }
/* 273 */     int endValue = (int)MallInterface.getJifen(roleId, 2);
/*     */     
/* 275 */     OperateResult operateResult = new OperateResult(null);
/* 276 */     operateResult.ret = result.ret;
/* 277 */     operateResult.retMsg = result.retMsg;
/* 278 */     if ((result != JifenOperateEnum.SUCCESS) && (result != JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/* 280 */       operateResult.success = false;
/* 281 */       operateResult.reason = "update competitive point failed";
/* 282 */       return operateResult;
/*     */     }
/* 284 */     operateResult.beginValue = beginValue;
/* 285 */     operateResult.endValue = endValue;
/* 286 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateStoreExp(long roleId, int value)
/*     */   {
/* 291 */     StorageExpOperResult result = null;
/*     */     
/* 293 */     int beginValue = (int)StorageExpInterface.getCurCanUseStorageExp(roleId);
/* 294 */     if (value >= 0)
/*     */     {
/* 296 */       result = StorageExpInterface.addStorageForAqIdip(roleId, value);
/*     */     }
/*     */     else
/*     */     {
/* 300 */       result = StorageExpInterface.cutStorageExpForAqIdip(roleId, -value);
/*     */     }
/* 302 */     int endValue = (int)StorageExpInterface.getCurCanUseStorageExp(roleId);
/*     */     
/* 304 */     OperateResult operateResult = new OperateResult(null);
/* 305 */     operateResult.ret = result.ret;
/* 306 */     operateResult.retMsg = result.retMsg;
/* 307 */     if ((result != StorageExpOperResult.SUCCESS) && (result != StorageExpOperResult.STORAGEEXP_CLEAR_FOR_AQIDIP))
/*     */     {
/* 309 */       operateResult.success = false;
/* 310 */       operateResult.reason = "update storeExp failed";
/* 311 */       return operateResult;
/*     */     }
/* 313 */     operateResult.beginValue = beginValue;
/* 314 */     operateResult.endValue = endValue;
/* 315 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateRoleExp(long roleId, int value)
/*     */   {
/* 320 */     Role role = RoleInterface.getRole(roleId, true);
/* 321 */     int beginValue = role.getExp();
/* 322 */     RoleExpUpdateRet result = null;
/* 323 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_UPDATE_OTHER_CASH);
/* 324 */     if (value >= 0)
/*     */     {
/* 326 */       result = role.addExpForAqIdip(value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 330 */       result = role.cutExpForAqIdip(-value, tLogArg);
/*     */     }
/* 332 */     int endValue = role.getExp();
/*     */     
/* 334 */     OperateResult operateResult = new OperateResult(null);
/* 335 */     operateResult.ret = result.ret;
/* 336 */     operateResult.retMsg = result.retMsg;
/* 337 */     if ((result != RoleExpUpdateRet.SUCCESS) && (result != RoleExpUpdateRet.EXP_NUM_CLEAR_AQIDIP_ERROR) && (result != RoleExpUpdateRet.ROLE_LEVEL_HAS_REACH_TOP_LIMIT_ERROR))
/*     */     {
/*     */ 
/* 340 */       operateResult.success = false;
/* 341 */       operateResult.reason = "update exp failed";
/* 342 */       return operateResult;
/*     */     }
/* 344 */     operateResult.beginValue = beginValue;
/* 345 */     operateResult.endValue = endValue;
/* 346 */     return operateResult;
/*     */   }
/*     */   
/*     */   private final class OperateResult
/*     */   {
/* 351 */     public boolean success = true;
/*     */     public int ret;
/*     */     public String retMsg;
/*     */     public String reason;
/*     */     public int beginValue;
/*     */     public int endValue;
/*     */     
/*     */     private OperateResult() {}
/*     */   }
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception {
/* 362 */     String userid = (String)params.get(0);
/* 363 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/* 364 */     int type = Integer.parseInt((String)params.get(2));
/* 365 */     int value = Integer.parseInt((String)params.get(3));
/*     */     
/* 367 */     xbean.User xUser = xtable.User.get(userid);
/* 368 */     if (null == xUser)
/*     */     {
/* 370 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 371 */       rsp.retcode = retcode;
/* 372 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 373 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 375 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateOtherCashHandler.execute@user not found|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 379 */       return;
/*     */     }
/*     */     
/* 382 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/* 384 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 385 */       rsp.retcode = retcode;
/* 386 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 387 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 389 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateOtherCashHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 393 */       return;
/*     */     }
/*     */     
/* 396 */     Integer currencyType = (Integer)currencyTypeMap.get(Integer.valueOf(type));
/* 397 */     if (currencyType == null)
/*     */     {
/* 399 */       int retcode = Retcode.AQ_UPDATE_OTHER_CASH_TYPE_INVALID.value;
/* 400 */       rsp.retcode = retcode;
/* 401 */       Response response = IdipGmtUtil.getResponse(retcode, "cash type not exist");
/* 402 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 404 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateOtherCashHandler.execute@cash type not exist|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 408 */       return;
/*     */     }
/*     */     
/* 411 */     if (value == 0)
/*     */     {
/* 413 */       int retcode = Retcode.AQ_UPDATE_OTHER_CASH_VALUE_INVALID.value;
/* 414 */       rsp.retcode = retcode;
/* 415 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/* 416 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 418 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateOtherCashHandler.execute@value == 0|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/* 421 */       return;
/*     */     }
/*     */     
/* 424 */     OperateResult result = doUpdate(roleid, type, value);
/* 425 */     if (!result.success)
/*     */     {
/* 427 */       int retcode = Retcode.AQ_UPDATE_OTHER_CASH_FAILED.value;
/* 428 */       rsp.retcode = retcode;
/* 429 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/* 430 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 432 */       GameServer.logger().error(String.format("[gmt]AqDoUpdateOtherCashHandler.execute@%s|ret=%d|ret_msg=%s|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { result.reason, Integer.valueOf(result.ret), result.retMsg, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 436 */       return;
/*     */     }
/*     */     
/* 439 */     rsp.retcode = Retcode.SUCCESS.value;
/* 440 */     Response response = new Response();
/* 441 */     response.msg = result.retMsg;
/* 442 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 444 */     TLogManager.getInstance().addLog(userid, "GMTAqDoUpdateOtherCash", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Integer.valueOf(result.beginValue), Integer.valueOf(result.endValue) });
/*     */     
/*     */ 
/* 447 */     GameServer.logger().info(String.format("[gmt]AqDoUpdateOtherCashHandler.execute@update other cash success|userid=%s|roleid=%d|type=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value), Integer.valueOf(result.beginValue), Integer.valueOf(result.endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoUpdateOtherCashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */