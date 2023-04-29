/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ 
/*    */ public class IdGenerator
/*    */ {
/*    */   private final AtomicInteger id;
/*    */   private final int step;
/*    */   
/*    */   public IdGenerator()
/*    */   {
/* 12 */     this.id = new AtomicInteger(-1);
/* 13 */     this.step = -1;
/*    */   }
/*    */   
/*    */   public IdGenerator(int initialValue, int step)
/*    */   {
/* 18 */     this.id = new AtomicInteger(initialValue);
/* 19 */     this.step = step;
/*    */   }
/*    */   
/*    */   public int nextId()
/*    */   {
/* 24 */     return this.id.getAndAdd(this.step);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\IdGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */