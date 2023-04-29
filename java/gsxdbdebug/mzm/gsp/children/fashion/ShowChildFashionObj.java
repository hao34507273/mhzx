/*    */ package mzm.gsp.children.fashion;
/*    */ 
/*    */ 
/*    */ public class ShowChildFashionObj
/*    */ {
/*    */   private final long childid;
/*    */   
/*    */   private final int showPhase;
/*    */   
/*    */   private final int fashionCfgid;
/*    */   
/*    */   public ShowChildFashionObj(long childid, int showPhase, int fashionCfgid)
/*    */   {
/* 14 */     this.childid = childid;
/* 15 */     this.showPhase = showPhase;
/* 16 */     this.fashionCfgid = fashionCfgid;
/*    */   }
/*    */   
/*    */   public long getChildid()
/*    */   {
/* 21 */     return this.childid;
/*    */   }
/*    */   
/*    */   public int getShowPhase()
/*    */   {
/* 26 */     return this.showPhase;
/*    */   }
/*    */   
/*    */   public int getFashionCfgid()
/*    */   {
/* 31 */     return this.fashionCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\ShowChildFashionObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */