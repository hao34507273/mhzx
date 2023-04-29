/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.SSyncCashInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuAnyCheckOrderInfo;
/*     */ import xbean.CheckOrderInfo;
/*     */ import xbean.QingfuInfo;
/*     */ import xbean.UserAuAnyCheckOrders;
/*     */ 
/*     */ public class POnCostConfirm extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final int auanyGSN;
/*     */   private final String billno;
/*     */   private final long auanyTotalCash;
/*     */   private final long auanyTotalConfirmCost;
/*     */   private final long auanyTotalConfirmCostBind;
/*  20 */   private int retcode = 9;
/*     */   
/*  22 */   private int gsGSN = -1;
/*     */   
/*     */   public int getRetCode()
/*     */   {
/*  26 */     return this.retcode;
/*     */   }
/*     */   
/*     */   public int getGsGSN()
/*     */   {
/*  31 */     return this.gsGSN;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnCostConfirm(String userid, int auanyGSN, String billno, long auanyTotalCash, long auanyTotalConfirmCost, long auanyTotalConfirmCostBind)
/*     */   {
/*  37 */     this.userid = userid;
/*  38 */     this.auanyGSN = auanyGSN;
/*  39 */     this.billno = billno;
/*  40 */     this.auanyTotalCash = auanyTotalCash;
/*  41 */     this.auanyTotalConfirmCost = auanyTotalConfirmCost;
/*  42 */     this.auanyTotalConfirmCostBind = auanyTotalConfirmCostBind;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     QingfuInfo xQingfuInfo = xtable.Qingfu.get(this.userid);
/*  49 */     if (xQingfuInfo == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@user qingfu info is null|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     UserAuAnyCheckOrders xUserAuAnyCheckOrders = xtable.User2auanycheckorders.get(this.userid);
/*  60 */     if (xUserAuAnyCheckOrders == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders info is null|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     int sn = xUserAuAnyCheckOrders.getSn();
/*  71 */     this.gsGSN = (xUserAuAnyCheckOrders.getOffset() + sn);
/*  72 */     if (this.gsGSN != this.auanyGSN)
/*     */     {
/*  74 */       this.retcode = 20;
/*     */       
/*  76 */       GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders gsn not match|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     List<AuAnyCheckOrderInfo> xAuAnyCheckOrderInfos = xUserAuAnyCheckOrders.getOrders();
/*  85 */     int xAuAnyCheckOrderInfosSize = xAuAnyCheckOrderInfos.size();
/*  86 */     if (xAuAnyCheckOrderInfosSize <= sn)
/*     */     {
/*  88 */       GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders sn invalid|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     AuAnyCheckOrderInfo xAuAnyCheckOrderInfoOfCurSN = (AuAnyCheckOrderInfo)xAuAnyCheckOrderInfos.get(sn);
/*  97 */     String gsBillno = xAuAnyCheckOrderInfoOfCurSN.getOrderid();
/*  98 */     if (!gsBillno.equals(this.billno))
/*     */     {
/* 100 */       boolean canSwapBillno = false;
/* 101 */       for (int i = sn + 1; i < xAuAnyCheckOrderInfosSize; i++)
/*     */       {
/* 103 */         AuAnyCheckOrderInfo xAuAnyCheckOrderInfo = (AuAnyCheckOrderInfo)xAuAnyCheckOrderInfos.get(i);
/* 104 */         if (xAuAnyCheckOrderInfo.getOrderid().equals(this.billno))
/*     */         {
/* 106 */           canSwapBillno = true;
/* 107 */           xAuAnyCheckOrderInfo.setOrderid(gsBillno);
/* 108 */           xAuAnyCheckOrderInfoOfCurSN.setOrderid(this.billno);
/* 109 */           break;
/*     */         }
/*     */       }
/* 112 */       if (canSwapBillno)
/*     */       {
/* 114 */         GameServer.logger().warn(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders billno not match, but fix by swap billno|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */         gsBillno = this.billno;
/*     */       }
/*     */       else
/*     */       {
/* 124 */         GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders billno not match|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 129 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 133 */     CheckOrderInfo xCheckOrderInfo = xtable.Checkorders.get(this.billno);
/* 134 */     if (xCheckOrderInfo == null)
/*     */     {
/* 136 */       GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@check order info is null|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     int confirmStatus = xCheckOrderInfo.getStatus();
/* 145 */     if (confirmStatus == 8)
/*     */     {
/*     */ 
/* 148 */       GameServer.logger().warn(String.format("[qingfu]POnCostConfirm.processImp@check order already confirmed|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno, Integer.valueOf(confirmStatus) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 153 */       return true;
/*     */     }
/*     */     
/* 156 */     int checkStatus = xUserAuAnyCheckOrders.getCheck_status();
/* 157 */     boolean confirmingOrder = confirmStatus == 4;
/* 158 */     boolean waitOrder = confirmStatus == 1;
/* 159 */     if ((!confirmingOrder) && (!waitOrder))
/*     */     {
/* 161 */       GameServer.logger().error(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders check status invalid, or check order confirm status invalid|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s|check_status=%d|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno, Integer.valueOf(checkStatus), Integer.valueOf(confirmStatus) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     if (waitOrder)
/*     */     {
/* 171 */       GameServer.logger().warn(String.format("[qingfu]POnCostConfirm.processImp@user auany check orders check status maybe doing, and check order confirm status maybe confirming|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s|check_status=%d|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno, Integer.valueOf(checkStatus), Integer.valueOf(confirmStatus) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 179 */     if (this.auanyTotalCash > 0L)
/*     */     {
/* 181 */       long totalCash = xQingfuInfo.getTotal_cash();
/* 182 */       long cash = this.auanyTotalCash - totalCash;
/* 183 */       if (cash > 0L)
/*     */       {
/* 185 */         xQingfuInfo.setTotal_cash(this.auanyTotalCash);
/*     */         
/*     */ 
/* 188 */         QingfuManager.addRechargeLog(this.userid, cash, QingfuManager.getYuanbao(xQingfuInfo));
/*     */         
/*     */ 
/* 191 */         SSyncCashInfo core = new SSyncCashInfo();
/* 192 */         core.infos.put(Integer.valueOf(2), Long.valueOf(this.auanyTotalCash));
/* 193 */         mzm.gsp.online.main.OnlineManager.getInstance().send(this.userid, core);
/*     */       }
/*     */     }
/*     */     
/* 197 */     if (this.auanyTotalConfirmCost > 0L)
/*     */     {
/* 199 */       long totalConfirmCost = xQingfuInfo.getTotal_confirm_cost();
/* 200 */       long cost = this.auanyTotalConfirmCost - totalConfirmCost;
/* 201 */       if (cost > 0L)
/*     */       {
/* 203 */         xQingfuInfo.setTotal_confirm_cost(this.auanyTotalConfirmCost);
/*     */       }
/*     */     }
/*     */     
/* 207 */     if (this.auanyTotalConfirmCostBind > 0L)
/*     */     {
/* 209 */       long totalConfirmCostBind = xQingfuInfo.getTotal_confirm_cost_bind();
/* 210 */       long costBind = this.auanyTotalConfirmCostBind - totalConfirmCostBind;
/* 211 */       if (costBind > 0L)
/*     */       {
/* 213 */         xQingfuInfo.setTotal_confirm_cost_bind(this.auanyTotalConfirmCostBind);
/*     */       }
/*     */     }
/*     */     
/* 217 */     xUserAuAnyCheckOrders.setSn(sn + 1);
/* 218 */     xCheckOrderInfo.setStatus(8);
/*     */     
/* 220 */     this.retcode = 0;
/*     */     
/* 222 */     GameServer.logger().info(String.format("[qingfu]POnCostConfirm.processImp@cost confirm done|userid=%s|auany_gsn=%d|billno=%s|auany_total_cash=%d|auany_total_confirm_cost=%d|auany_total_confirm_cost_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanyTotalConfirmCost), Long.valueOf(this.auanyTotalConfirmCostBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnCostConfirm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */