/*    */ package mzm.gsp.open.event;
/*    */ 
/*    */ public class OpenChangeComplexArg
/*    */ {
/*  5 */   private boolean open = false;
/*  6 */   private int openType = 0;
/*    */   
/*    */   public OpenChangeComplexArg(int _type, boolean _open) {
/*  9 */     this.open = _open;
/* 10 */     this.openType = _type;
/*    */   }
/*    */   
/*    */   public boolean isOpen() {
/* 14 */     return this.open;
/*    */   }
/*    */   
/*    */   public int getType() {
/* 18 */     return this.openType;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\event\OpenChangeComplexArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */