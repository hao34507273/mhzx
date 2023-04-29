/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import mzm.gsp.paraselene.event.JigsawContext;
/*    */ 
/*    */ public class ParaseleneJigsawContext
/*    */   implements JigsawContext
/*    */ {
/*    */   private int layer;
/*    */   
/*    */   ParaseleneJigsawContext(int layer)
/*    */   {
/* 12 */     this.layer = layer;
/*    */   }
/*    */   
/*    */   public int getLayer()
/*    */   {
/* 17 */     return this.layer;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneJigsawContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */