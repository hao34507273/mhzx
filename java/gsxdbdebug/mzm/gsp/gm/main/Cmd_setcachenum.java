/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.market.search.PGM_SetCacheNum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setcachenum
/*    */   extends CmdBase
/*    */ {
/*    */   private int itemCacheNum;
/*    */   private int petCacheNum;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_itemCacheNum = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_itemCacheNum == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.itemCacheNum = I_itemCacheNum.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_petCacheNum = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_petCacheNum == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.petCacheNum = I_petCacheNum.intValue();
/*    */     
/* 42 */     if (index != this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 61 */     new PGM_SetCacheNum(this.itemCacheNum, this.petCacheNum).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setcachenum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */