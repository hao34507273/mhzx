/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.OpItem;
/*    */ 
/*    */ class Operator_UseItem extends FighterAIOperator {
/*    */   private int fid;
/*    */   private int itemcfgid;
/*    */   private int tfid;
/*    */   
/* 10 */   Operator_UseItem(int fid, int itemcfgid, int tfid) { super(true);
/* 11 */     this.fid = fid;
/* 12 */     this.itemcfgid = itemcfgid;
/* 13 */     this.tfid = tfid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 18 */     if (fight.hasFightCmd(this.fid)) {
/* 19 */       return;
/*    */     }
/* 21 */     OpItem opItem = new OpItem();
/* 22 */     opItem.item_cfgid = this.itemcfgid;
/* 23 */     opItem.main_target = this.tfid;
/*    */     
/* 25 */     fight.addFightCmd(this.fid, 1, opItem);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_UseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */