/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.SResUseTurntableItemLottery;
/*     */ import mzm.gsp.item.SResUseTurntableTypeLottery;
/*     */ import mzm.gsp.item.confbean.SLotteryItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ public class Pgm_Lottery extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int itemid;
/*     */   
/*     */   public Pgm_Lottery(long roleid, int itemid)
/*     */   {
/*  22 */     this.roleid = roleid;
/*  23 */     this.itemid = itemid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     SLotteryItem item = SLotteryItem.get(this.itemid);
/*     */     
/*  31 */     SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(item.randomTextId);
/*     */     
/*  33 */     if (lotteryViewRandomCfg == null) {
/*  34 */       int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*     */       
/*  36 */       AwardPoolResultData result = AwardPoolInterface.getAwardPoolData(item.randomTextId, this.roleid, roleLevel);
/*     */       
/*     */ 
/*  39 */       if (result != null)
/*     */       {
/*  41 */         SResUseTurntableItemLottery res = new SResUseTurntableItemLottery();
/*  42 */         res.finalindex = (result.getPrepareSubPoolIds().indexOf(result.getFinalSubPoolIds().get(0)) + 1);
/*     */         
/*  44 */         res.lotteryitemid = item.id;
/*  45 */         res.itemids.addAll(AwardPoolInterface.getItemId2NumMap(result.getPrepareSubPoolIds()));
/*     */         
/*  47 */         OnlineManager.getInstance().send(this.roleid, res);
/*     */         
/*  49 */         return true;
/*     */       }
/*     */     }
/*     */     else {
/*  53 */       AwardPoolResultData result = AwardPoolInterface.getLotteryResultData(this.roleid, lotteryViewRandomCfg.id);
/*     */       
/*  55 */       if (result == null) {
/*  56 */         return false;
/*     */       }
/*     */       
/*  59 */       SResUseTurntableTypeLottery res = new SResUseTurntableTypeLottery();
/*  60 */       res.finalindex = (result.getIndex() + 1);
/*  61 */       res.lotteryitemid = item.id;
/*  62 */       if (result.getItemMap().size() > 0) {
/*  63 */         res.itemid = ((Integer)result.getItemMap().keySet().iterator().next()).intValue();
/*  64 */         res.itemnum = ((Integer)result.getItemMap().get(Integer.valueOf(res.itemid))).intValue();
/*     */       }
/*  66 */       if (result.getGold() > 0) {
/*  67 */         res.moneytype = 2;
/*  68 */         res.moneynum = result.getGold();
/*     */       }
/*  70 */       if (result.getSilver() > 0) {
/*  71 */         res.moneytype = 3;
/*  72 */         res.moneynum = result.getSilver();
/*     */       }
/*  74 */       if (result.getGang() > 0) {
/*  75 */         res.moneytype = 4;
/*  76 */         res.moneynum = result.getGang();
/*     */       }
/*     */       
/*  79 */       if (result.getPetExp() > 0)
/*     */       {
/*  81 */         res.exptype = 2;
/*  82 */         res.expnum = result.getPetExp();
/*     */       }
/*  84 */       if (result.getRoleExp() > 0) {
/*  85 */         res.exptype = 1;
/*  86 */         res.expnum = result.getRoleExp();
/*     */       }
/*     */       
/*  89 */       if (result.getXiuLianExp() > 0) {
/*  90 */         res.exptype = 3;
/*  91 */         res.expnum = result.getXiuLianExp();
/*     */       }
/*     */       
/*  94 */       OnlineManager.getInstance().send(this.roleid, res);
/*     */       
/*     */ 
/*  97 */       return true;
/*     */     }
/*     */     
/* 100 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\Pgm_Lottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */