/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SSyncCashInfo;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChanged;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*     */ import mzm.gsp.role.main.UserOneByOneManager;
/*     */ import org.json.JSONArray;
/*     */ import xbean.Pod;
/*     */ import xbean.QingfuInfo;
/*     */ import xbean.UserAuAnyCheckOrders;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class POnGetBalanceConfirm extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final long auanyTotalCash;
/*     */   private final long auanySaveAmt;
/*     */   private final JSONArray auanyTssList;
/*  22 */   private int retcode = 9;
/*  23 */   private int gsGSN = -1;
/*     */   
/*     */   public int getRetCode()
/*     */   {
/*  27 */     return this.retcode;
/*     */   }
/*     */   
/*     */   public int getGsGSN()
/*     */   {
/*  32 */     return this.gsGSN;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnGetBalanceConfirm(String userid, long auanyTotalCash, long auanySaveAmt, JSONArray auanyTssList)
/*     */   {
/*  38 */     this.userid = userid;
/*  39 */     this.auanyTotalCash = auanyTotalCash;
/*  40 */     this.auanySaveAmt = auanySaveAmt;
/*  41 */     this.auanyTssList = auanyTssList;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     QingfuInfo xQingfuInfo = Qingfu.get(this.userid);
/*  48 */     if (xQingfuInfo == null)
/*     */     {
/*  50 */       xQingfuInfo = Pod.newQingfuInfo();
/*  51 */       Qingfu.add(this.userid, xQingfuInfo);
/*     */     }
/*     */     
/*     */ 
/*  55 */     SSyncCashInfo core = new SSyncCashInfo();
/*     */     
/*  57 */     if (this.auanyTotalCash > 0L)
/*     */     {
/*  59 */       long totalCash = xQingfuInfo.getTotal_cash();
/*  60 */       long cash = this.auanyTotalCash - totalCash;
/*  61 */       if (cash > 0L)
/*     */       {
/*  63 */         xQingfuInfo.setTotal_cash(this.auanyTotalCash);
/*     */         
/*  65 */         core.infos.put(Integer.valueOf(2), Long.valueOf(this.auanyTotalCash));
/*     */         
/*     */ 
/*  68 */         QingfuManager.addRechargeLog(this.userid, cash, QingfuManager.getYuanbao(xQingfuInfo));
/*     */       }
/*     */     }
/*     */     
/*  72 */     if (this.auanySaveAmt > 0L)
/*     */     {
/*  74 */       long saveAmt = xQingfuInfo.getSave_amt();
/*  75 */       long amt = this.auanySaveAmt - saveAmt;
/*  76 */       if (amt > 0L)
/*     */       {
/*  78 */         xQingfuInfo.setSave_amt(this.auanySaveAmt);
/*     */         
/*     */ 
/*  81 */         xQingfuInfo.setRecharge_times(xQingfuInfo.getRecharge_times() + 1);
/*     */         
/*  83 */         xQingfuInfo.setStatis_recharge_first_consume_status(0);
/*     */         
/*  85 */         long totalSaveAmt = QingfuManager.getSaveAmt(xQingfuInfo);
/*  86 */         core.infos.put(Integer.valueOf(1), Long.valueOf(totalSaveAmt));
/*     */         
/*  88 */         long oldTotalSaveAmt = saveAmt + xQingfuInfo.getInner_save_amt();
/*  89 */         SaveAmtChangedArg arg = new SaveAmtChangedArg(this.userid, oldTotalSaveAmt, totalSaveAmt);
/*  90 */         SaveAmtChanged event = new SaveAmtChanged();
/*  91 */         TriggerEventsManger.getInstance().triggerEvent(event, arg, UserOneByOneManager.getInstance().getTaskOneByOne(this.userid));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (this.auanyTssList != null)
/*     */     {
/*     */ 
/*  99 */       QingfuManager.calcTSS(this.userid, this.auanyTssList, xQingfuInfo);
/*     */     }
/*     */     
/* 102 */     UserAuAnyCheckOrders xUserAuAnyCheckOrders = xtable.User2auanycheckorders.get(this.userid);
/* 103 */     if (xUserAuAnyCheckOrders == null)
/*     */     {
/* 105 */       xUserAuAnyCheckOrders = Pod.newUserAuAnyCheckOrders();
/* 106 */       QingfuManager.initUserAuanyCheckOrdersBean(xUserAuAnyCheckOrders);
/* 107 */       xtable.User2auanycheckorders.add(this.userid, xUserAuAnyCheckOrders);
/*     */     }
/*     */     
/* 110 */     this.gsGSN = (xUserAuAnyCheckOrders.getOffset() + xUserAuAnyCheckOrders.getSn());
/* 111 */     this.retcode = 0;
/*     */     
/* 113 */     OnlineManager.getInstance().send(this.userid, core);
/*     */     
/* 115 */     mzm.gsp.GameServer.logger().info(String.format("[qingfu]POnGetBalanceConfirm.processImp@get balance confirm done|userid=%s|auany_total_cash=%d|auany_save_amt=%d|auany_tss_list=%s", new Object[] { this.userid, Long.valueOf(this.auanyTotalCash), Long.valueOf(this.auanySaveAmt), this.auanyTssList.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnGetBalanceConfirm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */