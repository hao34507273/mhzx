/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fabao.SFabaoComposeSuccessRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.fabao.event.FabaoComplex;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ChangeItemInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Role2fabaosys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PFabaoCompose extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int fabaoid;
/*     */   private int yuanbaoNum;
/*     */   
/*     */   public PFabaoCompose(long roleid, int fabaoid, int yuanbaoNum)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.fabaoid = fabaoid;
/*  36 */     this.yuanbaoNum = yuanbaoNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  41 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*     */     {
/*  43 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/*  44 */       return false;
/*     */     }
/*  46 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  47 */       sendComplexResult(11);
/*  48 */       return false;
/*     */     }
/*  50 */     SFabaoItem sFabaoItem = SFabaoItem.get(this.fabaoid);
/*  51 */     if (sFabaoItem == null) {
/*  52 */       sendComplexResult(2);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!sFabaoItem.canCompose) {
/*  57 */       sendComplexResult(10);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (RoleInterface.getLevel(this.roleid) < SFabaoConstants.getInstance().FABAO_OPEN_LEVEL) {
/*  62 */       sendComplexResult(9);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     String useridStr = RoleInterface.getUserId(this.roleid);
/*     */     
/*  68 */     lock(User.getTable(), Arrays.asList(new String[] { useridStr }));
/*     */     
/*  70 */     lock(Role2fabaosys.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  72 */     int num = ItemInterface.getItemNumberById(this.roleid, 340600006, sFabaoItem.fragmentId);
/*  73 */     if (num < sFabaoItem.fragmentCount) {
/*  74 */       if (!sFabaoItem.canUseYuanBao) {
/*  75 */         sendComplexResult(3);
/*  76 */         return false;
/*     */       }
/*  78 */       if (this.yuanbaoNum <= 0) {
/*  79 */         sendComplexResult(3);
/*  80 */         return false;
/*     */       }
/*  82 */       int extraNum = sFabaoItem.fragmentCount - num;
/*     */       
/*  84 */       int needYuanBaoNum = CommonUtils.multiply(ItemInterface.getItemYuanBaoPrice(sFabaoItem.fragmentId), extraNum);
/*  85 */       if (needYuanBaoNum <= 0) {
/*  86 */         sendComplexResult(3);
/*  87 */         return false;
/*     */       }
/*  89 */       if (needYuanBaoNum != this.yuanbaoNum) {
/*  90 */         sendComplexResult(8);
/*  91 */         return false;
/*     */       }
/*     */       
/*  94 */       long nowNum = QingfuInterface.getBalance(useridStr, true);
/*  95 */       if (nowNum < this.yuanbaoNum) {
/*  96 */         sendComplexResult(7);
/*  97 */         return false;
/*     */       }
/*     */       
/* 100 */       CostResult costResult = QingfuInterface.costYuanbao(useridStr, this.roleid, this.yuanbaoNum, CostType.COST_BIND_FABAO_COMPLEX, new TLogArg(LogReason.FABAO_COMPLEX_COST, this.fabaoid));
/*     */       
/* 102 */       if (costResult != CostResult.Success) {
/* 103 */         sendComplexResult(7);
/* 104 */         return false;
/*     */       }
/*     */       
/* 107 */       if ((num > 0) && 
/* 108 */         (!ItemInterface.removeItemById(this.roleid, 340600006, sFabaoItem.fragmentId, num, new TLogArg(LogReason.FABAO_COMPLEX_REM))))
/*     */       {
/* 110 */         sendComplexResult(5);
/* 111 */         return false;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 117 */     else if (!ItemInterface.removeItemById(this.roleid, 340600006, sFabaoItem.fragmentId, sFabaoItem.fragmentCount, new TLogArg(LogReason.FABAO_COMPLEX_REM)))
/*     */     {
/* 119 */       sendComplexResult(5);
/* 120 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, this.fabaoid, 1, new TLogArg(LogReason.FABAO_COMPLEX_ADD));
/* 126 */     if (result.isBagFull())
/*     */     {
/* 128 */       sendComplexResult(6);
/* 129 */       return false;
/*     */     }
/* 131 */     if (!result.success())
/*     */     {
/* 133 */       sendComplexResult(4);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     TriggerEventsManger.getInstance().triggerEvent(new FabaoComplex(), new mzm.gsp.fabao.event.FabaoComplexArg(this.roleid, this.fabaoid));
/*     */     
/* 139 */     ItemOperateResult.ChangeItemInfo changeItemInfo = (ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0);
/* 140 */     BasicItem basicItem = changeItemInfo.basicItem;
/* 141 */     SFabaoComposeSuccessRes complexSuccess = new SFabaoComposeSuccessRes();
/* 142 */     complexSuccess.key = changeItemInfo.grid;
/* 143 */     ItemInterface.fillInItemInfoBean(complexSuccess.eqpinfo, basicItem.getItem());
/* 144 */     OnlineManager.getInstance().send(this.roleid, complexSuccess);
/* 145 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendComplexResult(int result)
/*     */   {
/* 155 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.fabao.SFabaoComposeRes(result));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFabaoCompose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */