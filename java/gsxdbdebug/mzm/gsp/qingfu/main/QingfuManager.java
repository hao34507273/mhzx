/*      */ package mzm.gsp.qingfu.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import gnet.GDeliveryManager;
/*      */ import gnet.link.Onlines;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.RunnableScheduledFuture;
/*      */ import java.util.concurrent.ScheduledFuture;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.qingfu.SApplyOrderIDRep;
/*      */ import mzm.gsp.qingfu.SDelFailureOrderRep;
/*      */ import mzm.gsp.qingfu.SSyncCashInfo;
/*      */ import mzm.gsp.qingfu.confbean.SChannelToProductsCfg;
/*      */ import mzm.gsp.qingfu.confbean.SPlatServiceInfo;
/*      */ import mzm.gsp.qingfu.confbean.SQingfuCfg;
/*      */ import mzm.gsp.qingfu.event.CostYuanbaoArg;
/*      */ import mzm.gsp.qingfu.event.PresentYuanbaoArg;
/*      */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*      */ import mzm.gsp.qingfu.event.TssChanged;
/*      */ import mzm.gsp.qingfu.event.TssChangedArg;
/*      */ import mzm.gsp.role.main.UserOneByOneManager;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*      */ import mzm.gsp.yuanbao.main.CurrencyType;
/*      */ import openau.ApplyOrderIdArg;
/*      */ import openau.ApplyOrderIdRes;
/*      */ import openau.DataBetweenAuanyAndOthersRep;
/*      */ import openau.DataBetweenAuanyAndOthersReq;
/*      */ import openau.DelFailureOrderArg;
/*      */ import openau.DelFailureOrderRes;
/*      */ import org.apache.log4j.Logger;
/*      */ import org.json.JSONArray;
/*      */ import org.json.JSONObject;
/*      */ import xbean.AuAnyCheckOrderInfo;
/*      */ import xbean.CheckOrderInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.Properties;
/*      */ import xbean.QingfuInfo;
/*      */ import xbean.TssSumInfo;
/*      */ import xbean.UserAuAnyCheckOrders;
/*      */ import xdb.Xdb;
/*      */ import xtable.Checkorders;
/*      */ import xtable.Qingfu;
/*      */ import xtable.User2auanycheckorders;
/*      */ 
/*      */ class QingfuManager
/*      */ {
/*      */   static final String ENCODING = "UTF-8";
/*   62 */   static final AtomicInteger seqGenerator = new AtomicInteger();
/*   63 */   static final DelayHandleContext delayHandleContext = new DelayHandleContext();
/*      */   
/*   65 */   static long magicNum = 0L;
/*   66 */   static boolean isMidasMode = true;
/*      */   
/*   68 */   protected static final Map<String, RunnableScheduledFuture<?>> futures = xdb.util.Misc.newConcurrentMap();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean canDoAction(long roleid, int aciton)
/*      */   {
/*   81 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, aciton, true);
/*      */   }
/*      */   
/*      */   protected static final void removeFuture(String userid)
/*      */   {
/*   86 */     removeFuture(userid, false);
/*      */   }
/*      */   
/*      */   protected static final void removeFuture(String userid, boolean mayInterruptIfRunning)
/*      */   {
/*   91 */     ScheduledFuture<?> oldFuture = (ScheduledFuture)futures.remove(userid);
/*   92 */     if (oldFuture != null)
/*      */     {
/*   94 */       oldFuture.cancel(mayInterruptIfRunning);
/*      */     }
/*      */   }
/*      */   
/*      */   protected static final void putFuture(String userid, RunnableScheduledFuture<?> future)
/*      */   {
/*  100 */     RunnableScheduledFuture<?> oldFuture = (RunnableScheduledFuture)futures.put(userid, future);
/*  101 */     if ((oldFuture != null) && (oldFuture.isPeriodic()))
/*      */     {
/*  103 */       oldFuture.cancel(true);
/*      */     }
/*      */   }
/*      */   
/*      */   static void init(Map<String, String> envs)
/*      */   {
/*  109 */     isMidasMode = "midas".equals(envs.get("mode"));
/*  110 */     String modeValue = System.getProperty("com.zulong.mhzx.auany_mode");
/*  111 */     if (modeValue != null)
/*      */     {
/*  113 */       isMidasMode = "midas".equals(modeValue);
/*      */     }
/*  115 */     if (isMidasMode)
/*      */     {
/*  117 */       magicNum = Xdb.random().nextInt(2097151) << 42 | DateTimeUtils.getCurrTimeInMillis();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void postInit() {}
/*      */   
/*      */ 
/*      */   static int getCfgIdByProductId(String payPlatId, String productId)
/*      */   {
/*  127 */     Integer channelid = (Integer)QingfuArgs.getInstance().channels.get(payPlatId);
/*  128 */     if (channelid == null)
/*      */     {
/*  130 */       return -1;
/*      */     }
/*      */     
/*      */ 
/*  134 */     if (channelid.intValue() == 8)
/*      */     {
/*      */ 
/*  137 */       int realChannelid = 65544;
/*  138 */       SChannelToProductsCfg cfg = SChannelToProductsCfg.get(65544);
/*  139 */       Integer cfgId = (Integer)cfg.products.get(productId);
/*  140 */       if (cfgId != null)
/*      */       {
/*  142 */         return cfgId.intValue();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  147 */       int realChannelid = 131080;
/*  148 */       SChannelToProductsCfg cfg = SChannelToProductsCfg.get(131080);
/*  149 */       Integer cfgId = (Integer)cfg.products.get(productId);
/*  150 */       if (cfgId != null)
/*      */       {
/*  152 */         return cfgId.intValue();
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/*  158 */       SChannelToProductsCfg cfg = SChannelToProductsCfg.get(channelid.intValue());
/*  159 */       Integer cfgId = (Integer)cfg.products.get(productId);
/*  160 */       if (cfgId != null)
/*      */       {
/*  162 */         return cfgId.intValue();
/*      */       }
/*      */     }
/*      */     
/*  166 */     return -1;
/*      */   }
/*      */   
/*      */   static void onApplyOrderAck(ApplyOrderIdArg arg, ApplyOrderIdRes res)
/*      */   {
/*      */     try
/*      */     {
/*  173 */       OctetsStream os = new OctetsStream(arg.serverext);
/*  174 */       long roleId = os.unmarshal_long();
/*  175 */       int cfgId = os.unmarshal_int();
/*      */       
/*  177 */       SApplyOrderIDRep rep = new SApplyOrderIDRep();
/*  178 */       rep.retcode = res.retcode;
/*  179 */       rep.cfgid = cfgId;
/*  180 */       rep.gameorderid = res.orderid;
/*  181 */       rep.ordercallbackurl = res.callbackurl;
/*  182 */       rep.ext = res.ext;
/*  183 */       OnlineManager.getInstance().send(roleId, rep);
/*      */       
/*  185 */       GameServer.logger().info(String.format("[qingfu]QingfuManager.onApplyOrderAck@apply order id ack|retcode=%d|roleid=%d|cfgid=%d|product_amount=%d|game_order_id=%s|order_callback_url=%s", new Object[] { Integer.valueOf(res.retcode), Long.valueOf(roleId), Integer.valueOf(cfgId), Integer.valueOf(arg.productamount), res.orderid.getString("UTF-8"), res.callbackurl.getString("UTF-8") }));
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */ 
/*      */ 
/*  193 */       GameServer.logger().error("[qingfu]QingfuManager.onApplyOrderAck@apply order id error", e);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onApplyOrderTimeout(ApplyOrderIdArg arg)
/*      */   {
/*      */     try
/*      */     {
/*  201 */       OctetsStream os = new OctetsStream(arg.serverext);
/*  202 */       long roleId = os.unmarshal_long();
/*  203 */       int cfgId = os.unmarshal_int();
/*      */       
/*  205 */       SApplyOrderIDRep rep = new SApplyOrderIDRep();
/*  206 */       rep.retcode = 8;
/*  207 */       rep.cfgid = cfgId;
/*  208 */       OnlineManager.getInstance().send(roleId, rep);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  212 */       GameServer.logger().error("[qingfu]QingfuManager.onApplyOrderTimeout@apply order id error", e);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onDelFailtureOrderAck(DelFailureOrderArg arg, DelFailureOrderRes res)
/*      */   {
/*      */     try
/*      */     {
/*  220 */       OctetsStream os = new OctetsStream(arg.reserved2);
/*  221 */       long roleId = os.unmarshal_long();
/*      */       
/*  223 */       SDelFailureOrderRep rep = new SDelFailureOrderRep();
/*  224 */       rep.retcode = res.retcode;
/*  225 */       rep.gameorderid = arg.orderid;
/*  226 */       OnlineManager.getInstance().send(roleId, rep);
/*      */       
/*  228 */       GameServer.logger().info(String.format("[qingfu]QingfuManager.onDelFailtureOrderAck@del failure order ack|retcode=%d|roleid=%d|game_order_id=%s", new Object[] { Integer.valueOf(res.retcode), Long.valueOf(roleId), arg.orderid.getString("UTF-8") }));
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */ 
/*  235 */       GameServer.logger().error("[qingfu]QingfuManager.onDelFailtureOrderAck@del failure order error", e);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onDelFailtureOrderTimeout(DelFailureOrderArg arg)
/*      */   {
/*      */     try
/*      */     {
/*  243 */       OctetsStream os = new OctetsStream(arg.reserved2);
/*  244 */       long roleId = os.unmarshal_long();
/*      */       
/*  246 */       SDelFailureOrderRep rep = new SDelFailureOrderRep();
/*  247 */       rep.retcode = 8;
/*  248 */       rep.gameorderid = arg.orderid;
/*  249 */       OnlineManager.getInstance().send(roleId, rep);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  253 */       GameServer.logger().error("[qingfu]QingfuManager.onDelFailtureOrderTimeout@del failure order error", e);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onDataBetweenAuanyAndOthersReq(DataBetweenAuanyAndOthersReq req)
/*      */   {
/*  259 */     if (req.direction != 1)
/*      */     {
/*  261 */       return;
/*      */     }
/*      */     
/*  264 */     String userid = req.account.getString("UTF-8");
/*  265 */     String strReqdata = req.reqdata.getString("UTF-8");
/*  266 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/*  268 */       GameServer.logger().debug(String.format("[qingfu]QingfuManager.onDataBetweenAuanyAndOthersReq@request info|full_user_identity=%s|direction=%d|req_type=%d|req_data=%s", new Object[] { userid, Byte.valueOf(req.direction), Integer.valueOf(req.reqtype), strReqdata }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  274 */     if (!isMidasMode)
/*      */     {
/*  276 */       return;
/*      */     }
/*      */     
/*  279 */     if (req.reqtype == DataBetweenAuanyAndOthersReqType.REQ_GET_BALANCE_CONFIRM.reqType)
/*      */     {
/*      */ 
/*  282 */       JSONObject notifyObj = new JSONObject(strReqdata);
/*  283 */       int auanyGSN = notifyObj.getInt("auany_gsn");
/*  284 */       long aunayTotalCash = notifyObj.getLong("total_cash");
/*  285 */       long auanySaveAmt = notifyObj.getLong("save_amt");
/*  286 */       JSONArray aunayTssList = notifyObj.has("tss_list") ? notifyObj.getJSONArray("tss_list") : null;
/*  287 */       POnGetBalanceConfirm proc = new POnGetBalanceConfirm(userid, aunayTotalCash, auanySaveAmt, aunayTssList);
/*  288 */       proc.call();
/*  289 */       DataBetweenAuanyAndOthersRep rep = new DataBetweenAuanyAndOthersRep();
/*  290 */       rep.direction = req.direction;
/*  291 */       rep.account = req.account;
/*  292 */       rep.zoneid = req.zoneid;
/*  293 */       rep.reqtype = req.reqtype;
/*  294 */       rep.retcode = proc.getRetCode();
/*  295 */       JSONObject repdataObj = new JSONObject();
/*  296 */       repdataObj.put("auany_gsn", auanyGSN);
/*  297 */       repdataObj.put("gs_gsn", proc.getGsGSN());
/*  298 */       repdataObj.put("appid", getAuanyAppId(userid));
/*  299 */       rep.repdata = Octets.wrap(repdataObj.toString(), "UTF-8");
/*      */       
/*  301 */       GDeliveryManager.getInstance().send(rep);
/*      */     }
/*  303 */     else if (req.reqtype == DataBetweenAuanyAndOthersReqType.REQ_COST_CONFIRM.reqType)
/*      */     {
/*      */ 
/*  306 */       JSONObject notifyObj = new JSONObject(strReqdata);
/*  307 */       int auanyGSN = notifyObj.getInt("auany_gsn");
/*  308 */       String billno = notifyObj.getString("billno");
/*  309 */       long auanyTotalCash = notifyObj.getLong("total_cash");
/*  310 */       long auanyTotalConfirmCost = notifyObj.getLong("total_confirm_cost");
/*  311 */       long auanyTotalConfirmCostBind = notifyObj.getLong("total_confirm_cost_bind");
/*  312 */       POnCostConfirm proc = new POnCostConfirm(userid, auanyGSN, billno, auanyTotalCash, auanyTotalConfirmCost, auanyTotalConfirmCostBind);
/*      */       
/*  314 */       proc.call();
/*  315 */       DataBetweenAuanyAndOthersRep rep = new DataBetweenAuanyAndOthersRep();
/*  316 */       rep.direction = req.direction;
/*  317 */       rep.account = req.account;
/*  318 */       rep.zoneid = req.zoneid;
/*  319 */       rep.reqtype = req.reqtype;
/*  320 */       rep.retcode = proc.getRetCode();
/*  321 */       JSONObject repdataObj = new JSONObject();
/*  322 */       repdataObj.put("appid", getAuanyAppId(userid));
/*  323 */       repdataObj.put("auany_gsn", auanyGSN);
/*  324 */       repdataObj.put("gs_gsn", proc.getGsGSN());
/*  325 */       repdataObj.put("billno", billno);
/*  326 */       rep.repdata = Octets.wrap(repdataObj.toString(), "UTF-8");
/*      */       
/*  328 */       GDeliveryManager.getInstance().send(rep);
/*      */     }
/*  330 */     else if (req.reqtype == DataBetweenAuanyAndOthersReqType.REQ_PRESENT_CONFIRM.reqType)
/*      */     {
/*      */ 
/*  333 */       JSONObject notifyObj = new JSONObject(strReqdata);
/*  334 */       int auanyGSN = notifyObj.getInt("auany_gsn");
/*  335 */       String billno = notifyObj.getString("billno");
/*  336 */       long auanyTotalConfirmPresent = notifyObj.getLong("total_confirm_present");
/*  337 */       long auanyTotalConfirmPresentBind = notifyObj.getLong("total_confirm_present_bind");
/*  338 */       POnPresentConfirm proc = new POnPresentConfirm(userid, auanyGSN, billno, auanyTotalConfirmPresent, auanyTotalConfirmPresentBind);
/*      */       
/*  340 */       proc.call();
/*  341 */       DataBetweenAuanyAndOthersRep rep = new DataBetweenAuanyAndOthersRep();
/*  342 */       rep.direction = req.direction;
/*  343 */       rep.account = req.account;
/*  344 */       rep.zoneid = req.zoneid;
/*  345 */       rep.reqtype = req.reqtype;
/*  346 */       rep.retcode = proc.getRetCode();
/*  347 */       JSONObject repdataObj = new JSONObject();
/*  348 */       repdataObj.put("appid", getAuanyAppId(userid));
/*  349 */       repdataObj.put("auany_gsn", auanyGSN);
/*  350 */       repdataObj.put("gs_gsn", proc.getGsGSN());
/*  351 */       repdataObj.put("billno", billno);
/*  352 */       rep.repdata = Octets.wrap(repdataObj.toString(), "UTF-8");
/*      */       
/*  354 */       GDeliveryManager.getInstance().send(rep);
/*      */     }
/*  356 */     else if (req.reqtype == DataBetweenAuanyAndOthersReqType.REQ_GO_ON.reqType)
/*      */     {
/*      */ 
/*  359 */       JSONObject notifyObj = new JSONObject(strReqdata);
/*  360 */       int auanyGSN = notifyObj.getInt("auany_gsn");
/*  361 */       POnGoOn proc = new POnGoOn(userid, auanyGSN);
/*  362 */       proc.call();
/*      */       
/*  364 */       if ((proc.getRetCode() != 0) || (proc.getReqdataObj() == null))
/*      */       {
/*  366 */         DataBetweenAuanyAndOthersRep rep = new DataBetweenAuanyAndOthersRep();
/*  367 */         rep.direction = req.direction;
/*  368 */         rep.account = req.account;
/*  369 */         rep.zoneid = req.zoneid;
/*  370 */         rep.reqtype = req.reqtype;
/*  371 */         rep.retcode = proc.getRetCode();
/*  372 */         JSONObject repdataObj = new JSONObject();
/*  373 */         repdataObj.put("appid", getAuanyAppId(userid));
/*  374 */         repdataObj.put("auany_gsn", auanyGSN);
/*  375 */         repdataObj.put("gs_gsn", proc.getGsGSN());
/*  376 */         rep.repdata = Octets.wrap(repdataObj.toString(), "UTF-8");
/*      */         
/*  378 */         GDeliveryManager.getInstance().send(rep);
/*      */       }
/*      */       else
/*      */       {
/*  382 */         DataBetweenAuanyAndOthersReq checkOrderReq = new DataBetweenAuanyAndOthersReq();
/*  383 */         checkOrderReq.direction = 3;
/*  384 */         checkOrderReq.account = req.account;
/*  385 */         checkOrderReq.zoneid = req.zoneid;
/*  386 */         checkOrderReq.reqtype = proc.getReqType();
/*  387 */         JSONObject reqdataObj = proc.getReqdataObj();
/*  388 */         reqdataObj.put("auany_gsn", auanyGSN);
/*  389 */         reqdataObj.put("appid", getAuanyAppId(userid));
/*  390 */         checkOrderReq.reqdata = Octets.wrap(reqdataObj.toString(), "UTF-8");
/*      */         
/*  392 */         notifyAuany(userid, checkOrderReq);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void onDataBetweenAuanyAndOthersRep(DataBetweenAuanyAndOthersRep rep)
/*      */   {
/*  399 */     if (rep.direction != 3)
/*      */     {
/*  401 */       return;
/*      */     }
/*      */     
/*  404 */     String userid = rep.account.getString("UTF-8");
/*  405 */     String strRepdata = rep.repdata.getString("UTF-8");
/*      */     
/*      */ 
/*  408 */     GameServer.logger().info(String.format("[qingfu]QingfuManager.onDataBetweenAuanyAndOthersRep@response info|retcode=%d|full_user_identity=%s|direction=%d|req_type=%d|req_data=%s|rep_data=%s", new Object[] { Integer.valueOf(rep.retcode), userid, Byte.valueOf(rep.direction), Integer.valueOf(rep.reqtype), rep.reqdata.getString("UTF-8"), strRepdata }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  414 */     removeFuture(userid);
/*      */     
/*  416 */     if (!isMidasMode)
/*      */     {
/*  418 */       return;
/*      */     }
/*      */     
/*  421 */     if (rep.reqtype == DataBetweenAuanyAndOthersReqType.REQ_TRY_CHECK_NEXT_ORDER.reqType)
/*      */     {
/*  423 */       if (rep.retcode != 0)
/*      */       {
/*  425 */         return;
/*      */       }
/*      */       
/*      */ 
/*  429 */       JSONObject repdataObj = new JSONObject(strRepdata);
/*  430 */       int auanyGSN = repdataObj.getInt("auany_gsn");
/*  431 */       POnGoOn proc = new POnGoOn(userid, auanyGSN);
/*  432 */       proc.call();
/*  433 */       if (proc.getRetCode() != 0)
/*      */       {
/*  435 */         return;
/*      */       }
/*      */       
/*  438 */       JSONObject reqdataObj = proc.getReqdataObj();
/*  439 */       if (reqdataObj == null)
/*      */       {
/*  441 */         return;
/*      */       }
/*      */       
/*  444 */       DataBetweenAuanyAndOthersReq checkOrderReq = new DataBetweenAuanyAndOthersReq();
/*  445 */       checkOrderReq.direction = 3;
/*  446 */       checkOrderReq.account = rep.account;
/*  447 */       checkOrderReq.zoneid = rep.zoneid;
/*  448 */       checkOrderReq.reqtype = proc.getReqType();
/*  449 */       reqdataObj.put("auany_gsn", auanyGSN);
/*  450 */       reqdataObj.put("appid", getAuanyAppId(userid));
/*  451 */       checkOrderReq.reqdata = Octets.wrap(reqdataObj.toString(), "UTF-8");
/*      */       
/*  453 */       notifyAuany(userid, checkOrderReq);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getSaveAmt(String userid, boolean isHoldLock)
/*      */   {
/*  469 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  470 */     if (xQingfuInfo == null)
/*      */     {
/*  472 */       return -1L;
/*      */     }
/*      */     
/*  475 */     return getSaveAmt(xQingfuInfo);
/*      */   }
/*      */   
/*      */   static long getSaveAmt(QingfuInfo xQingfuInfo)
/*      */   {
/*  480 */     return xQingfuInfo.getSave_amt() + xQingfuInfo.getInner_save_amt();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static PresentInnerSaveAmtResult presentInnerSaveAmt(String userid, int value)
/*      */   {
/*  494 */     if (value <= 0)
/*      */     {
/*  496 */       return PresentInnerSaveAmtResult.ParamInvalid;
/*      */     }
/*  498 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  499 */     if (xQingfuInfo == null)
/*      */     {
/*  501 */       return PresentInnerSaveAmtResult.UserNotExist;
/*      */     }
/*      */     
/*  504 */     long oldInnerSaveAmt = xQingfuInfo.getInner_save_amt();
/*  505 */     long innerSaveAmt = oldInnerSaveAmt + value;
/*  506 */     if (innerSaveAmt <= oldInnerSaveAmt)
/*      */     {
/*  508 */       return PresentInnerSaveAmtResult.ParamInvalid;
/*      */     }
/*      */     
/*  511 */     xQingfuInfo.setInner_save_amt(innerSaveAmt);
/*      */     
/*      */ 
/*  514 */     SSyncCashInfo core = new SSyncCashInfo();
/*  515 */     long totalSaveAmt = getSaveAmt(xQingfuInfo);
/*  516 */     core.infos.put(Integer.valueOf(1), Long.valueOf(totalSaveAmt));
/*      */     
/*  518 */     long oldTotalSaveAmt = xQingfuInfo.getSave_amt() + oldInnerSaveAmt;
/*  519 */     SaveAmtChangedArg arg = new SaveAmtChangedArg(userid, oldTotalSaveAmt, totalSaveAmt);
/*  520 */     mzm.gsp.qingfu.event.SaveAmtChanged event = new mzm.gsp.qingfu.event.SaveAmtChanged();
/*  521 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, UserOneByOneManager.getInstance().getTaskOneByOne(userid));
/*      */     
/*  523 */     OnlineManager.getInstance().send(userid, core);
/*      */     
/*  525 */     return PresentInnerSaveAmtResult.Success;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBalance(String userid, boolean isHoldLock)
/*      */   {
/*  540 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  541 */     if (xQingfuInfo == null)
/*      */     {
/*  543 */       return -1L;
/*      */     }
/*      */     
/*  546 */     long remain = xQingfuInfo.getTotal_cash() + xQingfuInfo.getTotal_present() - xQingfuInfo.getTotal_cost();
/*  547 */     long remainBind = xQingfuInfo.getTotal_present_bind() - xQingfuInfo.getTotal_cost_bind();
/*  548 */     return remain + remainBind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getYuanbao(String userid, boolean isHoldLock)
/*      */   {
/*  563 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  564 */     if (xQingfuInfo == null)
/*      */     {
/*  566 */       return -1L;
/*      */     }
/*      */     
/*  569 */     return getYuanbao(xQingfuInfo);
/*      */   }
/*      */   
/*      */   static long getYuanbao(QingfuInfo xQingfuInfo)
/*      */   {
/*  574 */     return xQingfuInfo.getTotal_cash() + xQingfuInfo.getTotal_present() - xQingfuInfo.getTotal_cost();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBindYuanbao(String userid, boolean isHoldLock)
/*      */   {
/*  589 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  590 */     if (xQingfuInfo == null)
/*      */     {
/*  592 */       return -1L;
/*      */     }
/*      */     
/*  595 */     return getBindYuanbao(xQingfuInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBindYuanbao(QingfuInfo xQingfuInfo)
/*      */   {
/*  606 */     return xQingfuInfo.getTotal_present_bind() - xQingfuInfo.getTotal_cost_bind();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTotalCash(String userid, boolean isHoldLock)
/*      */   {
/*  621 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  622 */     if (xQingfuInfo == null)
/*      */     {
/*  624 */       return -1L;
/*      */     }
/*      */     
/*  627 */     return xQingfuInfo.getTotal_cash();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTotalPresent(String userid, boolean isHoldLock)
/*      */   {
/*  642 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  643 */     if (xQingfuInfo == null)
/*      */     {
/*  645 */       return -1L;
/*      */     }
/*      */     
/*  648 */     return xQingfuInfo.getTotal_present();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTotalPresentBind(String userid, boolean isHoldLock)
/*      */   {
/*  663 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  664 */     if (xQingfuInfo == null)
/*      */     {
/*  666 */       return -1L;
/*      */     }
/*      */     
/*  669 */     return xQingfuInfo.getTotal_present_bind();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTotalCost(String userid, boolean isHoldLock)
/*      */   {
/*  684 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  685 */     if (xQingfuInfo == null)
/*      */     {
/*  687 */       return -1L;
/*      */     }
/*      */     
/*  690 */     return xQingfuInfo.getTotal_cost();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTotalCostBind(String userid, boolean isHoldLock)
/*      */   {
/*  705 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/*  706 */     if (xQingfuInfo == null)
/*      */     {
/*  708 */       return -1L;
/*      */     }
/*      */     
/*  711 */     return xQingfuInfo.getTotal_cost_bind();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static CostResult costYuanbao(String userid, long roleid, int costValue, CostType costType, TLogArg tLogArg)
/*      */   {
/*  727 */     if (costValue <= 0)
/*      */     {
/*  729 */       return CostResult.ParamInvalid;
/*      */     }
/*      */     
/*  732 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/*  734 */       return CostResult.RoamServerBan;
/*      */     }
/*      */     
/*  737 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  738 */     if (xQingfuInfo == null)
/*      */     {
/*  740 */       return CostResult.UserNotFound;
/*      */     }
/*      */     
/*  743 */     int cost = 0;
/*  744 */     int costBind = 0;
/*      */     
/*  746 */     long totalCash = xQingfuInfo.getTotal_cash();
/*  747 */     long totalCost = xQingfuInfo.getTotal_cost();
/*  748 */     long totalCostBind = xQingfuInfo.getTotal_cost_bind();
/*  749 */     long totalPresent = xQingfuInfo.getTotal_present();
/*  750 */     long totalPresentBind = xQingfuInfo.getTotal_present_bind();
/*  751 */     long remain = totalCash + totalPresent - totalCost;
/*  752 */     if (costType.bindFirst)
/*      */     {
/*  754 */       long remainBind = totalPresentBind - totalCostBind;
/*  755 */       if (remain + remainBind < costValue)
/*      */       {
/*  757 */         return CostResult.BalanceNotEnough;
/*      */       }
/*      */       
/*  760 */       if (costValue > remainBind)
/*      */       {
/*  762 */         cost = (int)(costValue - remainBind);
/*  763 */         costBind = (int)remainBind;
/*      */       }
/*      */       else
/*      */       {
/*  767 */         costBind = costValue;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  772 */       if (remain < costValue)
/*      */       {
/*  774 */         return CostResult.BalanceNotEnough;
/*      */       }
/*      */       
/*  777 */       cost = costValue;
/*      */     }
/*      */     
/*  780 */     if (cost > 0)
/*      */     {
/*  782 */       xQingfuInfo.setTotal_cost(totalCost + cost);
/*      */       
/*      */ 
/*  785 */       int rechargeTimes = xQingfuInfo.getRecharge_times();
/*  786 */       if ((rechargeTimes > 0) && (xQingfuInfo.getStatis_recharge_first_consume_status() == 0))
/*      */       {
/*      */ 
/*  789 */         xQingfuInfo.setStatis_recharge_first_consume_status(1);
/*      */         
/*  791 */         addStatisRechargeFirstConsumeReasonTLog(userid, roleid, rechargeTimes, tLogArg.logReason.value, tLogArg.subReason);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  796 */     if (costBind > 0)
/*      */     {
/*  798 */       xQingfuInfo.setTotal_cost_bind(totalCostBind + costBind);
/*      */     }
/*      */     
/*  801 */     String billno = null;
/*  802 */     if (isMidasMode)
/*      */     {
/*  804 */       CheckOrderInfo xCheckOrderInfo = Pod.newCheckOrderInfo();
/*  805 */       xCheckOrderInfo.setFlags(1);
/*  806 */       xCheckOrderInfo.setStatus(1);
/*  807 */       xCheckOrderInfo.setUserid(userid);
/*  808 */       if (cost > 0)
/*      */       {
/*  810 */         xCheckOrderInfo.setCost(cost);
/*      */       }
/*  812 */       if (costBind > 0)
/*      */       {
/*  814 */         xCheckOrderInfo.setCost_bind(costBind);
/*      */       }
/*  816 */       int zoneid = CommonUtils.getZoneId(userid);
/*  817 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  818 */       billno = makeBillNO(zoneid, currTime);
/*  819 */       Checkorders.insert(billno, xCheckOrderInfo);
/*      */       
/*  821 */       addAuanyCheckOrder(userid, billno);
/*      */     }
/*      */     
/*      */ 
/*  825 */     SSyncCashInfo core = new SSyncCashInfo();
/*  826 */     if (cost > 0)
/*      */     {
/*  828 */       core.infos.put(Integer.valueOf(3), Long.valueOf(xQingfuInfo.getTotal_cost()));
/*      */       
/*  830 */       addCurrencyLog(userid, roleid, CurrencyType.CURRENCY_BUYYUANBAO, -cost, getYuanbao(xQingfuInfo), tLogArg);
/*      */     }
/*  832 */     if (costBind > 0)
/*      */     {
/*  834 */       core.infos.put(Integer.valueOf(4), Long.valueOf(xQingfuInfo.getTotal_cost_bind()));
/*      */       
/*  836 */       addCurrencyLog(userid, roleid, CurrencyType.CURRENCY_AWARDYUANBAO, -costBind, getBindYuanbao(xQingfuInfo), tLogArg);
/*      */     }
/*  838 */     OnlineManager.getInstance().send(roleid, core);
/*      */     
/*  840 */     CostYuanbaoArg arg = new CostYuanbaoArg(userid, roleid, billno, totalCost, cost, totalCostBind, costBind);
/*  841 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.qingfu.event.CostYuanbao(), arg, UserOneByOneManager.getInstance().getTaskOneByOne(userid));
/*      */     
/*      */ 
/*  844 */     return CostResult.Success;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static PresentResult presentYuanbao(String userid, long roleid, int presentValue, PresentType presentType, TLogArg tLogArg)
/*      */   {
/*  860 */     if (presentValue <= 0)
/*      */     {
/*  862 */       return PresentResult.ParamInvalid;
/*      */     }
/*      */     
/*  865 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/*  867 */       return PresentResult.RoamServerBan;
/*      */     }
/*      */     
/*  870 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  871 */     if (xQingfuInfo == null)
/*      */     {
/*  873 */       xQingfuInfo = Pod.newQingfuInfo();
/*  874 */       if (isMidasMode)
/*      */       {
/*  876 */         xQingfuInfo.setAppid(getAuanyAppId(userid));
/*      */       }
/*  878 */       Qingfu.add(userid, xQingfuInfo);
/*      */     }
/*      */     
/*  881 */     long totalPresent = xQingfuInfo.getTotal_present();
/*  882 */     long totalPresentBind = xQingfuInfo.getTotal_present_bind();
/*  883 */     int present = 0;
/*  884 */     int presentBind = 0;
/*  885 */     if (presentType.bind)
/*      */     {
/*  887 */       presentBind = presentValue;
/*  888 */       xQingfuInfo.setTotal_present_bind(totalPresentBind + presentValue);
/*      */     }
/*      */     else
/*      */     {
/*  892 */       present = presentValue;
/*  893 */       xQingfuInfo.setTotal_present(totalPresent + presentValue);
/*      */     }
/*      */     
/*  896 */     String billno = null;
/*  897 */     if (isMidasMode)
/*      */     {
/*  899 */       CheckOrderInfo xCheckOrderInfo = Pod.newCheckOrderInfo();
/*  900 */       xCheckOrderInfo.setFlags(2);
/*  901 */       xCheckOrderInfo.setStatus(1);
/*  902 */       xCheckOrderInfo.setUserid(userid);
/*  903 */       if (present > 0)
/*      */       {
/*  905 */         xCheckOrderInfo.setPresent(present);
/*      */       }
/*  907 */       if (presentBind > 0)
/*      */       {
/*  909 */         xCheckOrderInfo.setPresent_bind(presentBind);
/*      */       }
/*  911 */       int zoneid = CommonUtils.getZoneId(userid);
/*  912 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  913 */       billno = makeBillNO(zoneid, currTime);
/*  914 */       Checkorders.insert(billno, xCheckOrderInfo);
/*      */       
/*  916 */       addAuanyCheckOrder(userid, billno);
/*      */     }
/*      */     
/*      */ 
/*  920 */     SSyncCashInfo core = new SSyncCashInfo();
/*  921 */     if (present > 0)
/*      */     {
/*  923 */       core.infos.put(Integer.valueOf(5), Long.valueOf(xQingfuInfo.getTotal_present()));
/*      */       
/*  925 */       addCurrencyLog(userid, roleid, CurrencyType.CURRENCY_BUYYUANBAO, present, getYuanbao(xQingfuInfo), tLogArg);
/*      */     }
/*  927 */     if (presentBind > 0)
/*      */     {
/*  929 */       core.infos.put(Integer.valueOf(6), Long.valueOf(xQingfuInfo.getTotal_present_bind()));
/*      */       
/*  931 */       addCurrencyLog(userid, roleid, CurrencyType.CURRENCY_AWARDYUANBAO, presentBind, getBindYuanbao(xQingfuInfo), tLogArg);
/*      */     }
/*      */     
/*  934 */     OnlineManager.getInstance().send(roleid, core);
/*      */     
/*  936 */     PresentYuanbaoArg arg = new PresentYuanbaoArg(userid, roleid, billno, totalPresent, present, totalPresentBind, presentBind);
/*      */     
/*  938 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.qingfu.event.PresentYuanbao(), arg, UserOneByOneManager.getInstance().getTaskOneByOne(userid));
/*      */     
/*      */ 
/*  941 */     return PresentResult.Success;
/*      */   }
/*      */   
/*      */   static void initUserAuanyCheckOrdersBean(UserAuAnyCheckOrders xUserAuAnyCheckOrders)
/*      */   {
/*  946 */     xUserAuAnyCheckOrders.setCheck_status(1);
/*  947 */     xUserAuAnyCheckOrders.setMagic_num(magicNum);
/*  948 */     xUserAuAnyCheckOrders.setOffset(0);
/*  949 */     xUserAuAnyCheckOrders.setSn(0);
/*      */   }
/*      */   
/*      */   static UserAuAnyCheckOrders addAuanyCheckOrder(String userid, String billno)
/*      */   {
/*  954 */     UserAuAnyCheckOrders xUserAuAnyCheckOrders = User2auanycheckorders.get(userid);
/*  955 */     if (xUserAuAnyCheckOrders == null)
/*      */     {
/*  957 */       xUserAuAnyCheckOrders = Pod.newUserAuAnyCheckOrders();
/*  958 */       initUserAuanyCheckOrdersBean(xUserAuAnyCheckOrders);
/*  959 */       User2auanycheckorders.add(userid, xUserAuAnyCheckOrders);
/*      */     }
/*      */     
/*  962 */     AuAnyCheckOrderInfo xAnyCheckOrderInfo = Pod.newAuAnyCheckOrderInfo();
/*  963 */     xAnyCheckOrderInfo.setOrderid(billno);
/*  964 */     xUserAuAnyCheckOrders.getOrders().add(xAnyCheckOrderInfo);
/*      */     
/*  966 */     return xUserAuAnyCheckOrders;
/*      */   }
/*      */   
/*      */   static int boxCheckOrderObj(JSONObject checkOrderObj, String billno, CheckOrderInfo xCheckOrderInfo)
/*      */   {
/*  971 */     if (xCheckOrderInfo.getFlags() == 1)
/*      */     {
/*  973 */       checkOrderObj.put("billno", billno);
/*  974 */       checkOrderObj.put("cost", xCheckOrderInfo.getCost());
/*  975 */       checkOrderObj.put("cost_bind", xCheckOrderInfo.getCost_bind());
/*      */       
/*  977 */       return DataBetweenAuanyAndOthersReqType.REQ_COST.reqType;
/*      */     }
/*  979 */     if (xCheckOrderInfo.getFlags() == 2)
/*      */     {
/*  981 */       checkOrderObj.put("billno", billno);
/*  982 */       checkOrderObj.put("present", xCheckOrderInfo.getPresent());
/*  983 */       checkOrderObj.put("present_bind", xCheckOrderInfo.getPresent_bind());
/*      */       
/*  985 */       return DataBetweenAuanyAndOthersReqType.REQ_PRESENT.reqType;
/*      */     }
/*      */     
/*  988 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean sendTryCheckNextOrderReq(String userid, String billno, UserAuAnyCheckOrders xUserAuAnyCheckOrders, CheckOrderInfo xCheckOrderInfo)
/*      */   {
/*  994 */     if (Onlines.getInstance().findFakePlat(userid))
/*      */     {
/*  996 */       return true;
/*      */     }
/*      */     
/*  999 */     DataBetweenAuanyAndOthersReq tryCheckNextOrderReq = new DataBetweenAuanyAndOthersReq();
/* 1000 */     tryCheckNextOrderReq.direction = 3;
/* 1001 */     tryCheckNextOrderReq.account = Octets.wrap(userid, "UTF-8");
/* 1002 */     tryCheckNextOrderReq.zoneid = CommonUtils.getZoneId(userid);
/* 1003 */     tryCheckNextOrderReq.reqtype = DataBetweenAuanyAndOthersReqType.REQ_TRY_CHECK_NEXT_ORDER.reqType;
/* 1004 */     JSONObject reqdataObj = new JSONObject();
/* 1005 */     int gsGSN = xUserAuAnyCheckOrders.getOffset() + xUserAuAnyCheckOrders.getSn();
/* 1006 */     reqdataObj.put("gs_gsn", gsGSN);
/* 1007 */     reqdataObj.put("appid", getAuanyAppId(userid));
/* 1008 */     tryCheckNextOrderReq.reqdata = Octets.wrap(reqdataObj.toString(), "UTF-8");
/*      */     
/*      */ 
/* 1011 */     notifyAuany(userid, tryCheckNextOrderReq);
/*      */     
/* 1013 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean tryGoOn(String userid, String billno, UserAuAnyCheckOrders xUserAuAnyCheckOrders, CheckOrderInfo xCheckOrderInfo)
/*      */   {
/* 1019 */     int gsGSN = xUserAuAnyCheckOrders.getOffset() + xUserAuAnyCheckOrders.getSn();
/* 1020 */     JSONObject checkOrderObj = new JSONObject();
/* 1021 */     checkOrderObj.put("gs_gsn", gsGSN);
/*      */     
/* 1023 */     int reqType = boxCheckOrderObj(checkOrderObj, billno, xCheckOrderInfo);
/* 1024 */     if (reqType < 0)
/*      */     {
/* 1026 */       GameServer.logger().error(String.format("[qingfu]QingfuManager.tryGoOn@check order flags invalid|userid=%s|gs_gsn=%d|billno=%s|order_flags=%d", new Object[] { userid, Integer.valueOf(gsGSN), billno, Integer.valueOf(xCheckOrderInfo.getFlags()) }));
/*      */       
/*      */ 
/*      */ 
/* 1030 */       return false;
/*      */     }
/*      */     
/* 1033 */     xCheckOrderInfo.setStatus(4);
/*      */     
/* 1035 */     DataBetweenAuanyAndOthersReq checkOrderReq = new DataBetweenAuanyAndOthersReq();
/* 1036 */     checkOrderReq.direction = 3;
/* 1037 */     checkOrderReq.account = Octets.wrap(userid, "UTF-8");
/* 1038 */     checkOrderReq.zoneid = CommonUtils.getZoneId(userid);
/* 1039 */     checkOrderReq.reqtype = reqType;
/* 1040 */     JSONObject reqdataObj = checkOrderObj;
/* 1041 */     reqdataObj.put("appid", getAuanyAppId(userid));
/* 1042 */     checkOrderReq.reqdata = Octets.wrap(reqdataObj.toString(), "UTF-8");
/*      */     
/*      */ 
/* 1045 */     notifyAuany(userid, checkOrderReq);
/*      */     
/* 1047 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static String makeBillNO(int zoneid, long currTime)
/*      */   {
/* 1059 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 1060 */     calendar.setTimeInMillis(currTime);
/* 1061 */     int year = calendar.get(1) % 100;
/* 1062 */     int month = calendar.get(2) + 1;
/* 1063 */     int day = calendar.get(5);
/* 1064 */     int hour = calendar.get(11);
/* 1065 */     int minute = calendar.get(12);
/* 1066 */     int second = calendar.get(13);
/*      */     
/* 1068 */     int seq = seqGenerator.incrementAndGet();
/*      */     
/* 1070 */     return String.format("%05d_%02d%02d%02d%02d%02d%02d_%08x", new Object[] { Integer.valueOf(zoneid), Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(second), Integer.valueOf(seq) });
/*      */   }
/*      */   
/*      */   static void notifyAuany(String fullUID, DataBetweenAuanyAndOthersReq core)
/*      */   {
/* 1075 */     RNotifyAuany notifier = new RNotifyAuany();
/* 1076 */     notifier.fullUID = fullUID;
/* 1077 */     notifier.core = core;
/* 1078 */     Xdb.executor().execute(notifier);
/*      */   }
/*      */   
/*      */   static int getCfgIdByServiceid(String userid, int serviceid)
/*      */   {
/* 1083 */     String channel = CommonUtils.getPlatName(userid);
/* 1084 */     Integer channelid = (Integer)QingfuArgs.getInstance().channels.get(channel);
/* 1085 */     if (channelid == null)
/*      */     {
/* 1087 */       return -1;
/*      */     }
/*      */     
/* 1090 */     int realChannelid = 0;
/* 1091 */     if (channelid.intValue() == 8)
/*      */     {
/* 1093 */       String gameAppId = Onlines.getInstance().findGameAppid(userid);
/* 1094 */       if ((gameAppId == null) || (gameAppId.isEmpty()))
/*      */       {
/* 1096 */         return -1;
/*      */       }
/* 1098 */       if (gameAppId.equals("twzx"))
/*      */       {
/* 1100 */         realChannelid = 65544;
/*      */       }
/* 1102 */       else if (gameAppId.equals("hkzx"))
/*      */       {
/* 1104 */         realChannelid = 131080;
/*      */       }
/*      */       else
/*      */       {
/* 1108 */         return -1;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1113 */       realChannelid = channelid.intValue();
/*      */     }
/* 1115 */     SChannelToProductsCfg cfg = SChannelToProductsCfg.get(realChannelid);
/* 1116 */     if (cfg == null)
/*      */     {
/* 1118 */       return -1;
/*      */     }
/*      */     
/* 1121 */     int platid = Onlines.getInstance().findPlatid(userid);
/* 1122 */     if (isMidasMode)
/*      */     {
/* 1124 */       if (platid == 1)
/*      */       {
/* 1126 */         platid = 2;
/*      */       }
/* 1128 */       else if (platid == 0)
/*      */       {
/* 1130 */         platid = 1;
/*      */       }
/*      */       else
/*      */       {
/* 1134 */         platid = 0;
/*      */       }
/*      */       
/*      */ 
/*      */     }
/* 1139 */     else if (platid == 3)
/*      */     {
/* 1141 */       platid = 2;
/*      */     }
/* 1143 */     else if (platid == 2)
/*      */     {
/* 1145 */       platid = 1;
/*      */     }
/*      */     else
/*      */     {
/* 1149 */       platid = 0;
/*      */     }
/*      */     
/*      */ 
/* 1153 */     SPlatServiceInfo platServiceInfo = (SPlatServiceInfo)cfg.platServiceInfos.get(Integer.valueOf(platid));
/* 1154 */     if (platServiceInfo == null)
/*      */     {
/* 1156 */       return -1;
/*      */     }
/* 1158 */     Integer cfgId = (Integer)platServiceInfo.services.get(Integer.valueOf(serviceid));
/* 1159 */     return cfgId == null ? -1 : cfgId.intValue();
/*      */   }
/*      */   
/*      */   static String getAuanyAppId(String userid)
/*      */   {
/* 1164 */     int platid = Onlines.getInstance().findPlatid(userid);
/* 1165 */     if ((platid < 0) || (platid == 100))
/*      */     {
/* 1167 */       return "1";
/*      */     }
/*      */     
/* 1170 */     StringBuffer sbAuanyAppId = new StringBuffer();
/* 1171 */     if (userid.startsWith("G_"))
/*      */     {
/* 1173 */       sbAuanyAppId.append("G_");
/*      */     }
/* 1175 */     if (isMidasMode)
/*      */     {
/* 1177 */       if (platid == 0)
/*      */       {
/* 1179 */         sbAuanyAppId.append("ios");
/*      */       }
/*      */       else
/*      */       {
/* 1183 */         sbAuanyAppId.append("android");
/*      */       }
/*      */       
/*      */ 
/*      */     }
/* 1188 */     else if (platid == 2)
/*      */     {
/* 1190 */       sbAuanyAppId.append("ios");
/*      */     }
/*      */     else
/*      */     {
/* 1194 */       sbAuanyAppId.append("android");
/*      */     }
/*      */     
/* 1197 */     sbAuanyAppId.append("_").append(CommonUtils.getPlatName(userid));
/*      */     
/* 1199 */     return sbAuanyAppId.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addCurrencyLog(String userId, long roleId, CurrencyType type, long changeNum, long leftNum, TLogArg arg)
/*      */   {
/* 1215 */     CurrencyLogUtil.logCurrency(userId, roleId, type, (int)changeNum, leftNum, arg);
/* 1216 */     CurrencyLogUtil.tLogCurrency(userId, roleId, type, (int)changeNum, leftNum, arg);
/* 1217 */     CurrencyLogUtil.tlogMoneyFlow(userId, roleId, type, (int)changeNum, leftNum, arg);
/*      */   }
/*      */   
/*      */   static Long getSuitableRoleId(String userid)
/*      */   {
/* 1222 */     Long roleid = Onlines.getInstance().getRoleid(userid);
/* 1223 */     if (roleid != null)
/*      */     {
/* 1225 */       return roleid;
/*      */     }
/* 1227 */     return xtable.User.selectLast_login_roleid(userid);
/*      */   }
/*      */   
/*      */   static void addRechargeLog(String userid, long cash, long leftYuanbao)
/*      */   {
/* 1232 */     Long roleid = getSuitableRoleId(userid);
/* 1233 */     if (roleid != null)
/*      */     {
/* 1235 */       addCurrencyLog(userid, roleid.longValue(), CurrencyType.CURRENCY_BUYYUANBAO, cash, leftYuanbao, new TLogArg(LogReason.RECHARGE_ADD));
/*      */     }
/*      */   }
/*      */   
/*      */   static void calcTSS(String userid, JSONArray tssList, QingfuInfo xQingfuInfo)
/*      */     throws Exception
/*      */   {
/* 1242 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/* 1244 */       GameServer.logger().debug(String.format("QingfuManager.calcTSS@enter calc tss|userid=%s|tss_list=%s|db_tss_list=%s", new Object[] { userid, tssList.toString(), xQingfuInfo.getTss_list() }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1249 */     int tssListSize = tssList.length();
/* 1250 */     if (tssListSize == 0)
/*      */     {
/* 1252 */       return;
/*      */     }
/*      */     
/* 1255 */     String strTssList = tssList.toString();
/* 1256 */     String xTsslist = xQingfuInfo.getTss_list();
/* 1257 */     if (xTsslist.equals(strTssList))
/*      */     {
/* 1259 */       return;
/*      */     }
/*      */     
/* 1262 */     TssChangedArg arg = new TssChangedArg(userid);
/* 1263 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 1264 */     Map<String, TssSumInfo> xTssSumMap = xQingfuInfo.getTss_sum_map();
/* 1265 */     for (int i = 0; i < tssListSize; i++)
/*      */     {
/* 1267 */       JSONObject jsonTssInfo = tssList.getJSONObject(i);
/* 1268 */       String serviceid = jsonTssInfo.getString("inner_productid");
/* 1269 */       long firstBuyTime = sdf.parse(jsonTssInfo.getString("first_buy_time")).getTime();
/* 1270 */       long beginTime = sdf.parse(jsonTssInfo.getString("begintime")).getTime();
/* 1271 */       long endTime = sdf.parse(jsonTssInfo.getString("endtime")).getTime();
/* 1272 */       long grandTotalOpenDays = jsonTssInfo.getLong("grandtotal_opendays");
/* 1273 */       long grandTotalPresentDays = jsonTssInfo.getLong("grandtotal_presentdays");
/* 1274 */       String paychan = jsonTssInfo.getString("paychan");
/* 1275 */       String paysubchan = jsonTssInfo.getString("paysubchan");
/* 1276 */       String autopaychan = jsonTssInfo.getString("autopaychan");
/* 1277 */       String autopaysubchan = jsonTssInfo.getString("autopaysubchan");
/*      */       
/* 1279 */       long oldGrandtotalOpendays = 0L;
/* 1280 */       TssSumInfo xTssSumInfo = (TssSumInfo)xTssSumMap.get(serviceid);
/* 1281 */       if (xTssSumInfo == null)
/*      */       {
/* 1283 */         xTssSumInfo = Pod.newTssSumInfo();
/* 1284 */         xTssSumInfo.setFirst_buy_time(firstBuyTime);
/* 1285 */         xTssSumInfo.setBegin_time(beginTime);
/* 1286 */         xTssSumInfo.setEnd_time(endTime);
/* 1287 */         xTssSumInfo.setGrandtotal_opendays(grandTotalOpenDays);
/* 1288 */         xTssSumInfo.setGrandtotal_presentdays(grandTotalPresentDays);
/* 1289 */         xTssSumInfo.setPaychan(paychan);
/* 1290 */         xTssSumInfo.setPaysubchan(paysubchan);
/* 1291 */         xTssSumInfo.setAutopaychan(autopaychan);
/* 1292 */         xTssSumInfo.setAutopaysubchan(autopaysubchan);
/* 1293 */         xTssSumMap.put(serviceid, xTssSumInfo);
/*      */       }
/*      */       else
/*      */       {
/* 1297 */         oldGrandtotalOpendays = xTssSumInfo.getGrandtotal_opendays();
/* 1298 */         if (oldGrandtotalOpendays >= grandTotalOpenDays) {
/*      */           continue;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/* 1304 */         xTssSumInfo.setBegin_time(beginTime);
/* 1305 */         xTssSumInfo.setEnd_time(endTime);
/* 1306 */         xTssSumInfo.setGrandtotal_opendays(grandTotalOpenDays);
/* 1307 */         xTssSumInfo.setGrandtotal_presentdays(grandTotalPresentDays);
/* 1308 */         xTssSumInfo.setPaychan(paychan);
/* 1309 */         xTssSumInfo.setPaysubchan(paysubchan);
/* 1310 */         xTssSumInfo.setAutopaychan(autopaychan);
/* 1311 */         xTssSumInfo.setAutopaysubchan(autopaysubchan);
/*      */       }
/*      */       
/*      */ 
/* 1315 */       mzm.gsp.qingfu.event.TssChangedArg.TssChangedInfo changedInfo = new mzm.gsp.qingfu.event.TssChangedArg.TssChangedInfo(oldGrandtotalOpendays, grandTotalOpenDays, beginTime, endTime);
/* 1316 */       arg.changedInfos.put(serviceid, changedInfo);
/*      */     }
/*      */     
/* 1319 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/* 1321 */       GameServer.logger().debug(String.format("QingfuManager.calcTSS@dump tss changed info|userid=%s|tss_list=%s|db_tss_list=%s|changed_infos=%s", new Object[] { userid, strTssList, xTsslist, arg.changedInfos.toString() }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1327 */     if (arg.changedInfos.size() > 0)
/*      */     {
/* 1329 */       TssChanged event = new TssChanged();
/* 1330 */       TriggerEventsManger.getInstance().triggerEvent(event, arg, UserOneByOneManager.getInstance().getTaskOneByOne(userid));
/*      */     }
/*      */     
/*      */ 
/* 1334 */     xQingfuInfo.setTss_list(strTssList);
/*      */   }
/*      */   
/*      */   static long getTssBuyTimes(String userid, int serviceid, boolean isHoldLock)
/*      */   {
/* 1339 */     QingfuInfo xQingfuInfo = isHoldLock ? Qingfu.get(userid) : Qingfu.select(userid);
/* 1340 */     if (xQingfuInfo == null)
/*      */     {
/* 1342 */       return -1L;
/*      */     }
/*      */     
/* 1345 */     return getTssBuyTimes(userid, xQingfuInfo, serviceid);
/*      */   }
/*      */   
/*      */   static long getTssBuyTimes(String userid, QingfuInfo xQingfuInfo, int serviceid)
/*      */   {
/* 1350 */     int cfgid = getCfgIdByServiceid(userid, serviceid);
/* 1351 */     if (cfgid == -1)
/*      */     {
/* 1353 */       return 0L;
/*      */     }
/*      */     
/* 1356 */     SQingfuCfg cfg = SQingfuCfg.get(cfgid);
/* 1357 */     if (cfg == null)
/*      */     {
/* 1359 */       return 0L;
/*      */     }
/*      */     
/* 1362 */     TssSumInfo xTssSumInfo = (TssSumInfo)xQingfuInfo.getTss_sum_map().get(String.valueOf(cfg.productServiceId));
/* 1363 */     if (xTssSumInfo == null)
/*      */     {
/* 1365 */       return 0L;
/*      */     }
/*      */     
/* 1368 */     return xTssSumInfo.getGrandtotal_opendays() / cfg.productServiceDurationDays;
/*      */   }
/*      */   
/*      */   static long getTssBuyTimes(String userid, long grandtotalOpendays, int serviceid)
/*      */   {
/* 1373 */     int cfgid = getCfgIdByServiceid(userid, serviceid);
/* 1374 */     if (cfgid == -1)
/*      */     {
/* 1376 */       return 0L;
/*      */     }
/*      */     
/* 1379 */     SQingfuCfg cfg = SQingfuCfg.get(cfgid);
/* 1380 */     if (cfg == null)
/*      */     {
/* 1382 */       return 0L;
/*      */     }
/*      */     
/* 1385 */     return grandtotalOpendays / cfg.productServiceDurationDays;
/*      */   }
/*      */   
/*      */   static SQingfuCfg getQingfuCfg(String userid, int serviceid)
/*      */   {
/* 1390 */     int cfgid = getCfgIdByServiceid(userid, serviceid);
/* 1391 */     if (cfgid == -1)
/*      */     {
/* 1393 */       return null;
/*      */     }
/*      */     
/* 1396 */     return SQingfuCfg.get(cfgid);
/*      */   }
/*      */   
/*      */   static TssSumInfo getTssInfo(String userid, QingfuInfo xQingfuInfo, int serviceid)
/*      */   {
/* 1401 */     int cfgid = getCfgIdByServiceid(userid, serviceid);
/* 1402 */     if (cfgid == -1)
/*      */     {
/* 1404 */       return null;
/*      */     }
/*      */     
/* 1407 */     SQingfuCfg cfg = SQingfuCfg.get(cfgid);
/* 1408 */     if (cfg == null)
/*      */     {
/* 1410 */       return null;
/*      */     }
/*      */     
/* 1413 */     return (TssSumInfo)xQingfuInfo.getTss_sum_map().get(String.valueOf(cfg.productServiceId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static final void addStatisRechargeFirstConsumeReasonTLog(String userid, long roleid, int times, int consumeReason, int subReason)
/*      */   {
/* 1433 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 1434 */     StringBuilder sbLog = new StringBuilder();
/* 1435 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|').append(userid).append('|').append(roleid).append('|').append(roleLevel).append('|');
/*      */     
/* 1437 */     sbLog.append(times).append('|').append(consumeReason).append('|').append(subReason);
/* 1438 */     TLogManager.getInstance().addLog(roleid, "StatisRechargeFirstConsumeReasonForServer", sbLog.toString());
/*      */   }
/*      */   
/*      */   static final boolean checkAndSetSendRechargeTimesTipMailNo(long roleid, int no)
/*      */   {
/* 1443 */     Properties xProperties = xtable.Role2properties.get(Long.valueOf(roleid));
/* 1444 */     if (xProperties == null)
/*      */     {
/* 1446 */       return false;
/*      */     }
/*      */     
/* 1449 */     if (xProperties.getSend_recharge_times_tip_mail_no() >= no)
/*      */     {
/* 1451 */       return false;
/*      */     }
/*      */     
/* 1454 */     xProperties.setSend_recharge_times_tip_mail_no(no);
/*      */     
/* 1456 */     return true;
/*      */   }
/*      */   
/*      */   static final void boxSSyncCashInfo(QingfuInfo xQingfuInfo, SSyncCashInfo core)
/*      */   {
/* 1461 */     long saveAmt = getSaveAmt(xQingfuInfo);
/* 1462 */     if (saveAmt > 0L)
/*      */     {
/* 1464 */       core.infos.put(Integer.valueOf(1), Long.valueOf(saveAmt));
/*      */     }
/* 1466 */     long totalCash = xQingfuInfo.getTotal_cash();
/* 1467 */     if (totalCash > 0L)
/*      */     {
/* 1469 */       core.infos.put(Integer.valueOf(2), Long.valueOf(totalCash));
/*      */     }
/* 1471 */     long totalCost = xQingfuInfo.getTotal_cost();
/* 1472 */     if (totalCost > 0L)
/*      */     {
/* 1474 */       core.infos.put(Integer.valueOf(3), Long.valueOf(totalCost));
/*      */     }
/* 1476 */     long totalCostBind = xQingfuInfo.getTotal_cost_bind();
/* 1477 */     if (totalCostBind > 0L)
/*      */     {
/* 1479 */       core.infos.put(Integer.valueOf(4), Long.valueOf(totalCostBind));
/*      */     }
/* 1481 */     long totalPresent = xQingfuInfo.getTotal_present();
/* 1482 */     if (totalPresent > 0L)
/*      */     {
/* 1484 */       core.infos.put(Integer.valueOf(5), Long.valueOf(totalPresent));
/*      */     }
/* 1486 */     long totalPresentBind = xQingfuInfo.getTotal_present_bind();
/* 1487 */     if (totalPresentBind > 0L)
/*      */     {
/* 1489 */       core.infos.put(Integer.valueOf(6), Long.valueOf(totalPresentBind));
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\QingfuManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */