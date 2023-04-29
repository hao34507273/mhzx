/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ import xbean.AuAnyCheckOrderInfo;
/*     */ import xbean.CheckOrderInfo;
/*     */ import xbean.UserAuAnyCheckOrders;
/*     */ import xtable.Checkorders;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class POnGoOn extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final int auanyGSN;
/*  18 */   private int retcode = 9;
/*     */   
/*  20 */   private int gsGSN = -1;
/*     */   
/*  22 */   private int reqType = 0;
/*     */   
/*  24 */   private JSONObject checkOrderObj = null;
/*     */   
/*     */   public int getRetCode()
/*     */   {
/*  28 */     return this.retcode;
/*     */   }
/*     */   
/*     */   public int getGsGSN()
/*     */   {
/*  33 */     return this.gsGSN;
/*     */   }
/*     */   
/*     */   public int getReqType()
/*     */   {
/*  38 */     return this.reqType;
/*     */   }
/*     */   
/*     */   public JSONObject getReqdataObj()
/*     */   {
/*  43 */     return this.checkOrderObj;
/*     */   }
/*     */   
/*     */   public POnGoOn(String userid, int auanyGSN)
/*     */   {
/*  48 */     this.userid = userid;
/*  49 */     this.auanyGSN = auanyGSN;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  55 */     xbean.QingfuInfo xQingfuInfo = Qingfu.get(this.userid);
/*  56 */     if (xQingfuInfo == null)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[qingfu]POnGoOn.processImp@user qingfu info is null|userid=%s|auany_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     UserAuAnyCheckOrders xUserAuAnyCheckOrders = xtable.User2auanycheckorders.get(this.userid);
/*  65 */     if (xUserAuAnyCheckOrders == null)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[qingfu]POnGoOn.processImp@user auany check orders info is null|userid=%s|auany_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN) }));
/*     */       
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     int sn = xUserAuAnyCheckOrders.getSn();
/*  74 */     this.gsGSN = (xUserAuAnyCheckOrders.getOffset() + sn);
/*  75 */     if (this.gsGSN != this.auanyGSN)
/*     */     {
/*     */ 
/*  78 */       GameServer.logger().error(String.format("[qingfu]POnGoOn.processImp@user auany check orders check status invalid|userid=%s|auany_gsn=%d|gs_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN) }));
/*     */       
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (Onlines.getInstance().findFakePlat(this.userid))
/*     */     {
/*  87 */       GameServer.logger().info(String.format("[qingfu]POnGoOn.processImp@fake plat login|userid=%s|auany_gsn=%d|gs_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN) }));
/*     */       
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     List<AuAnyCheckOrderInfo> xAuAnyCheckOrderInfos = xUserAuAnyCheckOrders.getOrders();
/*  94 */     if (xAuAnyCheckOrderInfos.size() <= sn)
/*     */     {
/*     */ 
/*  97 */       this.retcode = 0;
/*     */       
/*  99 */       GameServer.logger().info(String.format("[qingfu]POnGoOn.processImp@not exist new order|userid=%s|auany_gsn=%d|gs_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return true;
/*     */     }
/*     */     
/* 106 */     String billno = ((AuAnyCheckOrderInfo)xAuAnyCheckOrderInfos.get(sn)).getOrderid();
/* 107 */     CheckOrderInfo xCheckOrderInfo = Checkorders.get(billno);
/* 108 */     if (xCheckOrderInfo == null)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[qingfu]POnGoOn.processImp@check order info is null|userid=%s|auany_gsn=%d|gs_gsn=%d|billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN), billno }));
/*     */       
/*     */ 
/*     */ 
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     int confirmStatus = xCheckOrderInfo.getStatus();
/* 118 */     if (confirmStatus == 8)
/*     */     {
/*     */ 
/* 121 */       GameServer.logger().error(String.format("[qingfu]POnGoOn.processImp@check order already confirmed|userid=%s|auany_gsn=%d|gs_gsn=%d|billno=%s|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN), billno, Integer.valueOf(confirmStatus) }));
/*     */       
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     this.checkOrderObj = new JSONObject();
/* 129 */     this.checkOrderObj.put("gs_gsn", this.gsGSN);
/* 130 */     this.reqType = QingfuManager.boxCheckOrderObj(this.checkOrderObj, billno, xCheckOrderInfo);
/* 131 */     if (this.reqType < 0)
/*     */     {
/* 133 */       this.checkOrderObj = null;
/*     */       
/* 135 */       GameServer.logger().error(String.format("[qingfu]POnGoOn.processImp@check order flags invalid|userid=%s|auany_gsn=%d|gs_gsn=%d|billno=%s|order_flags=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN), billno, Integer.valueOf(xCheckOrderInfo.getFlags()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     xCheckOrderInfo.setStatus(4);
/*     */     
/* 145 */     this.retcode = 0;
/*     */     
/* 147 */     GameServer.logger().info(String.format("[qingfu]POnGoOn.processImp@go on done|userid=%s|auany_gsn=%d|gs_gsn=%d|billno=%s|reqtype=%d|check_order_obj_info=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), Integer.valueOf(this.gsGSN), billno, Integer.valueOf(this.reqType), this.checkOrderObj.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 152 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnGoOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */