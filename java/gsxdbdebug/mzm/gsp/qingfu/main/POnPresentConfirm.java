/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuAnyCheckOrderInfo;
/*     */ import xbean.QingfuInfo;
/*     */ import xbean.UserAuAnyCheckOrders;
/*     */ 
/*     */ public class POnPresentConfirm extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final int auanyGSN;
/*     */   private final String billno;
/*     */   private final long auanyTotalConfirmPresent;
/*     */   private final long auanyTotalConfirmPresentBind;
/*  17 */   private int retcode = 9;
/*  18 */   private int gsGSN = -1;
/*     */   
/*     */   public int getRetCode()
/*     */   {
/*  22 */     return this.retcode;
/*     */   }
/*     */   
/*     */   public int getGsGSN()
/*     */   {
/*  27 */     return this.gsGSN;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnPresentConfirm(String userid, int auanyGSN, String billno, long auanyTotalConfirmPresent, long auanyTotalConfirmPresentBind)
/*     */   {
/*  33 */     this.userid = userid;
/*  34 */     this.auanyGSN = auanyGSN;
/*  35 */     this.billno = billno;
/*  36 */     this.auanyTotalConfirmPresent = auanyTotalConfirmPresent;
/*  37 */     this.auanyTotalConfirmPresentBind = auanyTotalConfirmPresentBind;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     QingfuInfo xQingfuInfo = xtable.Qingfu.get(this.userid);
/*  44 */     if (xQingfuInfo == null)
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@user qingfu info is null|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     UserAuAnyCheckOrders xUserAuAnyCheckOrders = xtable.User2auanycheckorders.get(this.userid);
/*  55 */     if (xUserAuAnyCheckOrders == null)
/*     */     {
/*  57 */       GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders info is null|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     int sn = xUserAuAnyCheckOrders.getSn();
/*  66 */     this.gsGSN = (xUserAuAnyCheckOrders.getOffset() + sn);
/*  67 */     if (this.gsGSN != this.auanyGSN)
/*     */     {
/*  69 */       this.retcode = 20;
/*     */       
/*  71 */       GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders gsn not match|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     List<AuAnyCheckOrderInfo> xAuAnyCheckOrderInfos = xUserAuAnyCheckOrders.getOrders();
/*  80 */     int xAuAnyCheckOrderInfosSize = xAuAnyCheckOrderInfos.size();
/*  81 */     if (xAuAnyCheckOrderInfosSize <= sn)
/*     */     {
/*  83 */       GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders sn invalid|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     AuAnyCheckOrderInfo xAuAnyCheckOrderInfoOfCurSN = (AuAnyCheckOrderInfo)xAuAnyCheckOrderInfos.get(sn);
/*  92 */     String gsBillno = xAuAnyCheckOrderInfoOfCurSN.getOrderid();
/*  93 */     if (!gsBillno.equals(this.billno))
/*     */     {
/*  95 */       boolean canSwapBillno = false;
/*  96 */       for (int i = sn + 1; i < xAuAnyCheckOrderInfosSize; i++)
/*     */       {
/*  98 */         AuAnyCheckOrderInfo xAuAnyCheckOrderInfo = (AuAnyCheckOrderInfo)xAuAnyCheckOrderInfos.get(i);
/*  99 */         if (xAuAnyCheckOrderInfo.getOrderid().equals(this.billno))
/*     */         {
/* 101 */           canSwapBillno = true;
/* 102 */           xAuAnyCheckOrderInfo.setOrderid(gsBillno);
/* 103 */           xAuAnyCheckOrderInfoOfCurSN.setOrderid(this.billno);
/* 104 */           break;
/*     */         }
/*     */       }
/* 107 */       if (canSwapBillno)
/*     */       {
/* 109 */         GameServer.logger().warn(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders billno not match, but fix by swap billno|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */         gsBillno = this.billno;
/*     */       }
/*     */       else
/*     */       {
/* 119 */         GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders billno not match|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 124 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 128 */     xbean.CheckOrderInfo xCheckOrderInfo = xtable.Checkorders.get(this.billno);
/* 129 */     if (xCheckOrderInfo == null)
/*     */     {
/* 131 */       GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@check order info is null|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     int confirmStatus = xCheckOrderInfo.getStatus();
/* 140 */     if (confirmStatus == 8)
/*     */     {
/*     */ 
/* 143 */       GameServer.logger().warn(String.format("[qingfu]POnPresentConfirm.processImp@check order already confirmed|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno, Integer.valueOf(confirmStatus) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 148 */       return true;
/*     */     }
/*     */     
/* 151 */     int checkStatus = xUserAuAnyCheckOrders.getCheck_status();
/* 152 */     boolean confirmingOrder = confirmStatus == 4;
/* 153 */     boolean waitOrder = confirmStatus == 1;
/* 154 */     if ((!confirmingOrder) && (!waitOrder))
/*     */     {
/* 156 */       GameServer.logger().error(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders check status invalid, or check order confirm status invalid|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s|check_status=%d|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno, Integer.valueOf(checkStatus), Integer.valueOf(confirmStatus) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     if (waitOrder)
/*     */     {
/* 166 */       GameServer.logger().warn(String.format("[qingfu]POnPresentConfirm.processImp@user auany check orders check status maybe doing, and check order confirm status maybe confirming|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s|check_status=%d|confirm_status=%d", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno, Integer.valueOf(checkStatus), Integer.valueOf(confirmStatus) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 173 */     if (this.auanyTotalConfirmPresent > 0L)
/*     */     {
/* 175 */       long totalConfirmPresent = xQingfuInfo.getTotal_confirm_present();
/* 176 */       long present = this.auanyTotalConfirmPresent - totalConfirmPresent;
/* 177 */       if (present > 0L)
/*     */       {
/* 179 */         xQingfuInfo.setTotal_confirm_present(this.auanyTotalConfirmPresent);
/*     */       }
/*     */     }
/*     */     
/* 183 */     if (this.auanyTotalConfirmPresentBind > 0L)
/*     */     {
/* 185 */       long totalConfirmPresentBind = xQingfuInfo.getTotal_confirm_present_bind();
/* 186 */       long presentBind = this.auanyTotalConfirmPresentBind - totalConfirmPresentBind;
/* 187 */       if (presentBind > 0L)
/*     */       {
/* 189 */         xQingfuInfo.setTotal_confirm_present_bind(this.auanyTotalConfirmPresentBind);
/*     */       }
/*     */     }
/*     */     
/* 193 */     xUserAuAnyCheckOrders.setSn(sn + 1);
/* 194 */     xCheckOrderInfo.setStatus(8);
/*     */     
/* 196 */     this.retcode = 0;
/*     */     
/* 198 */     GameServer.logger().info(String.format("[qingfu]POnPresentConfirm.processImp@order present confirm done|userid=%s|auany_gsn=%d|billno=%s|auany_total_confirm_present=%d|auany_total_confirm_present_bind=%d|gs_gsn=%d|sn=%d|gs_billno=%s", new Object[] { this.userid, Integer.valueOf(this.auanyGSN), this.billno, Long.valueOf(this.auanyTotalConfirmPresent), Long.valueOf(this.auanyTotalConfirmPresentBind), Integer.valueOf(this.gsGSN), Integer.valueOf(sn), gsBillno }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 204 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnPresentConfirm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */