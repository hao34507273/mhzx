/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ public class GenerateGoodsItem
/*    */   extends OutFightEffect
/*    */   implements ActionEffect
/*    */ {
/*    */   private static final int BASE_RATE = 10000;
/*    */   private int goodsId;
/*    */   private int goodsnum;
/*    */   private int prop;
/*    */   
/*    */   public GenerateGoodsItem(int goodsId, int goodsnum, int prop, int limit)
/*    */   {
/* 25 */     this.goodsId = goodsId;
/* 26 */     this.goodsnum = goodsnum;
/* 27 */     this.prop = prop;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target) {
/* 31 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target) {
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public boolean cast(IOutFightObject role)
/*    */   {
/* 40 */     if ((role instanceof RoleOutFightObj)) {
/* 41 */       long roleId = ((RoleOutFightObj)role).getId();
/* 42 */       if ((this.prop == 0) || (Xdb.random().nextInt(10000) <= this.prop)) {
/* 43 */         ItemOperateResult result = ItemInterface.addItem(roleId, this.goodsId, this.goodsnum, new TLogArg(LogReason.EFFECT_GENERATE_ADD, this.goodsId));
/* 44 */         return !result.isBagFull();
/*    */       }
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public int getItemId() {
/* 51 */     return this.goodsId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\GenerateGoodsItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */