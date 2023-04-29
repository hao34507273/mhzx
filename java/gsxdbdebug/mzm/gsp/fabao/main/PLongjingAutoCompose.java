/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fabao.SLongjingComposeErrorRes;
/*     */ import mzm.gsp.fabao.SLongjingComposeSucRes;
/*     */ import mzm.gsp.item.confbean.SLongJingCompose;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ 
/*     */ public class PLongjingAutoCompose extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PLongjingAutoCompose(long roleid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     lock(xtable.Bag.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  33 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  34 */       sendError(7);
/*  35 */       return false;
/*     */     }
/*  37 */     Map<Integer, Integer> itemid2Num = new HashMap();
/*     */     
/*  39 */     List<Integer> beginList = new ArrayList();
/*     */     
/*  41 */     Map<Integer, List<ComposeResult>> addItemid2Composes = new HashMap();
/*     */     
/*  43 */     for (SLongJingCompose longJingCompose : SLongJingCompose.getAll().values()) {
/*  44 */       int num = ItemInterface.getItemNumberById(this.roleid, longJingCompose.beforeLongjingid);
/*  45 */       if (num > 0) {
/*  46 */         itemid2Num.put(Integer.valueOf(longJingCompose.beforeLongjingid), Integer.valueOf(num));
/*  47 */         beginList.add(Integer.valueOf(longJingCompose.beforeLongjingid));
/*     */       }
/*     */     }
/*  50 */     for (Iterator i$ = beginList.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*  51 */       int composeItemid = itemid;
/*  52 */       while (composeItem(itemid2Num, addItemid2Composes, composeItemid) > 0) {
/*  53 */         SLongJingItem longJingItem = SLongJingItem.get(composeItemid);
/*  54 */         composeItemid = longJingItem.nextId;
/*     */       }
/*     */     }
/*     */     
/*  58 */     if (addItemid2Composes.size() <= 0) {
/*  59 */       SLongjingComposeErrorRes sLongjingComposeErrorRes = new SLongjingComposeErrorRes();
/*  60 */       sLongjingComposeErrorRes.resultcode = 1;
/*  61 */       OnlineManager.getInstance().sendAtOnce(this.roleid, sLongjingComposeErrorRes);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     SLongjingComposeSucRes sLongjingComposeSucRes = new SLongjingComposeSucRes();
/*     */     
/*  67 */     for (Map.Entry<Integer, List<ComposeResult>> entry : addItemid2Composes.entrySet()) {
/*  68 */       int itemid = ((Integer)entry.getKey()).intValue();
/*  69 */       List<ComposeResult> composeResults = (List)entry.getValue();
/*  70 */       int itemNum = composeResults.size();
/*     */       
/*  72 */       ComposeResult composeResult = (ComposeResult)composeResults.get(0);
/*  73 */       for (int i = 1; i < composeResults.size(); i++) {
/*  74 */         composeResult.addAll(((ComposeResult)composeResults.get(i)).costItemid2Num);
/*     */       }
/*  76 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleid, composeResult.costItemid2Num, new TLogArg(LogReason.FABAO_LONGJING_REM));
/*     */       
/*  78 */       if (!itemOperateResult.success()) {
/*  79 */         sendError(0);
/*  80 */         return false;
/*     */       }
/*  82 */       ItemOperateResult itemAddOperateResult = ItemInterface.addItem(this.roleid, itemid, itemNum, new TLogArg(LogReason.FABAO_LONGJING_ADD));
/*     */       
/*  84 */       if (!itemAddOperateResult.success()) {
/*  85 */         if (itemAddOperateResult.isBagFull()) {
/*  86 */           sendError(5);
/*     */         } else {
/*  88 */           sendError(0);
/*     */         }
/*  90 */         return false;
/*     */       }
/*  92 */       sLongjingComposeSucRes.itemid2num.put(Integer.valueOf(itemid), Integer.valueOf(itemNum));
/*     */     }
/*     */     
/*  95 */     OnlineManager.getInstance().send(this.roleid, sLongjingComposeSucRes);
/*     */     
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 101 */     SLongjingComposeErrorRes sLongjingComposeErrorRes = new SLongjingComposeErrorRes();
/* 102 */     sLongjingComposeErrorRes.resultcode = error;
/* 103 */     OnlineManager.getInstance().sendAtOnce(this.roleid, sLongjingComposeErrorRes);
/*     */   }
/*     */   
/*     */   private int composeItem(Map<Integer, Integer> itemid2Num, Map<Integer, List<ComposeResult>> addItemid2Composes, int itemid)
/*     */   {
/* 108 */     SLongJingItem longJingItem = SLongJingItem.get(itemid);
/* 109 */     SLongJingItem longJingNextItem = SLongJingItem.get(longJingItem.nextId);
/* 110 */     if (longJingNextItem == null) {
/* 111 */       return 0;
/*     */     }
/* 113 */     int maxLongjingLv = FabaoManager.getLongjingMaxLevel(RoleInterface.getLevel(this.roleid));
/* 114 */     if (longJingNextItem.lv > maxLongjingLv) {
/* 115 */       return 0;
/*     */     }
/* 117 */     Integer numFromBag = (Integer)itemid2Num.get(Integer.valueOf(itemid));
/* 118 */     if (numFromBag == null) {
/* 119 */       numFromBag = Integer.valueOf(0);
/*     */     }
/* 121 */     List<ComposeResult> curItemcomposeResults = (List)addItemid2Composes.get(Integer.valueOf(itemid));
/*     */     
/* 123 */     int totalComposeNum = 0;
/* 124 */     int numFromCompose = 0;
/* 125 */     if (curItemcomposeResults != null) {
/* 126 */       numFromCompose = curItemcomposeResults.size();
/*     */     }
/* 128 */     int composeNum = numFromCompose / longJingItem.complexNextCount;
/* 129 */     totalComposeNum += composeNum;
/* 130 */     if ((curItemcomposeResults != null) && (composeNum > 0)) {
/* 131 */       List<ComposeResult> composeResults2 = getAndPutComposeRet(addItemid2Composes, longJingItem.nextId);
/* 132 */       for (int i = 1; i <= composeNum; i++) {
/* 133 */         ComposeResult composeResult = new ComposeResult(null);
/* 134 */         for (int j = 1; j <= longJingItem.complexNextCount; j++) {
/* 135 */           ComposeResult tempComposeResult = (ComposeResult)curItemcomposeResults.remove(curItemcomposeResults.size() - 1);
/* 136 */           composeResult.addAll(tempComposeResult.costItemid2Num);
/*     */         }
/* 138 */         composeResults2.add(composeResult);
/*     */       }
/*     */     }
/* 141 */     int subComposeNum = numFromCompose % longJingItem.complexNextCount;
/* 142 */     int totalNum = subComposeNum + numFromBag.intValue();
/* 143 */     int bagAndSubComposeNum = totalNum / longJingItem.complexNextCount;
/* 144 */     totalComposeNum += bagAndSubComposeNum;
/* 145 */     if (bagAndSubComposeNum > 0) {
/* 146 */       List<ComposeResult> composeResults2 = getAndPutComposeRet(addItemid2Composes, longJingItem.nextId);
/* 147 */       int costNum = 0;
/* 148 */       if ((curItemcomposeResults != null) && (subComposeNum > 0)) {
/* 149 */         ComposeResult composeResult = new ComposeResult(null);
/* 150 */         Iterator<ComposeResult> iterator = curItemcomposeResults.iterator();
/* 151 */         while (iterator.hasNext()) {
/* 152 */           ComposeResult tempResult = (ComposeResult)iterator.next();
/* 153 */           composeResult.addAll(tempResult.costItemid2Num);
/* 154 */           iterator.remove();
/*     */         }
/*     */         
/* 157 */         int costItemNum = longJingItem.complexNextCount - subComposeNum;
/* 158 */         composeResult.addItem(itemid, costItemNum);
/* 159 */         composeResults2.add(composeResult);
/* 160 */         bagAndSubComposeNum--;
/* 161 */         costNum += costItemNum;
/*     */       }
/*     */       
/* 164 */       for (int i = 1; i <= bagAndSubComposeNum; i++) {
/* 165 */         ComposeResult composeResult = new ComposeResult(null);
/* 166 */         composeResult.addItem(itemid, longJingItem.complexNextCount);
/* 167 */         composeResults2.add(composeResult);
/*     */       }
/* 169 */       costNum += bagAndSubComposeNum * longJingItem.complexNextCount;
/* 170 */       costNum(itemid2Num, itemid, costNum);
/*     */     }
/*     */     
/*     */ 
/* 174 */     if ((curItemcomposeResults != null) && (curItemcomposeResults.size() <= 0)) {
/* 175 */       addItemid2Composes.remove(Integer.valueOf(itemid));
/*     */     }
/*     */     
/* 178 */     return totalComposeNum;
/*     */   }
/*     */   
/*     */   private void costNum(Map<Integer, Integer> itemid2Num, int itemid, int costNum) {
/* 182 */     Integer num = (Integer)itemid2Num.get(Integer.valueOf(itemid));
/* 183 */     num = Integer.valueOf(num.intValue() - costNum);
/* 184 */     if (num.intValue() == 0) {
/* 185 */       itemid2Num.remove(Integer.valueOf(itemid));
/*     */     } else {
/* 187 */       itemid2Num.put(Integer.valueOf(itemid), num);
/*     */     }
/*     */   }
/*     */   
/*     */   private List<ComposeResult> getAndPutComposeRet(Map<Integer, List<ComposeResult>> addItemid2Composes, int itemid)
/*     */   {
/* 193 */     List<ComposeResult> composeResults2 = (List)addItemid2Composes.get(Integer.valueOf(itemid));
/* 194 */     if (composeResults2 == null) {
/* 195 */       composeResults2 = new ArrayList();
/* 196 */       addItemid2Composes.put(Integer.valueOf(itemid), composeResults2);
/*     */     }
/* 198 */     return composeResults2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class ComposeResult
/*     */   {
/* 205 */     private Map<Integer, Integer> costItemid2Num = new HashMap();
/*     */     
/*     */     public void addAll(Map<Integer, Integer> costItemid2Num2) {
/* 208 */       for (Map.Entry<Integer, Integer> entry : costItemid2Num2.entrySet()) {
/* 209 */         addItem(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public void addItem(int itemid, int itemCount) {
/* 214 */       Integer num = (Integer)this.costItemid2Num.get(Integer.valueOf(itemid));
/* 215 */       if (num == null) {
/* 216 */         this.costItemid2Num.put(Integer.valueOf(itemid), Integer.valueOf(itemCount));
/*     */       } else {
/* 218 */         this.costItemid2Num.put(Integer.valueOf(itemid), Integer.valueOf(itemCount + num.intValue()));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongjingAutoCompose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */