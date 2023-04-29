/*    */ package mzm.gsp.map.main.ai.path.pathtype;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.path.IPathTypeStrategy;
/*    */ import mzm.gsp.map.main.ai.path.Path;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathTypeCircle
/*    */   implements IPathTypeStrategy
/*    */ {
/*    */   private final Path path;
/* 16 */   private int index = 0;
/*    */   
/*    */   public PathTypeCircle(Path path)
/*    */   {
/* 20 */     this.path = path;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isEnd()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getNextIdx()
/*    */   {
/* 32 */     if (this.index + 1 >= this.path.getLength())
/*    */     {
/* 34 */       this.index = 0;
/*    */     }
/* 36 */     return this.index + 1;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCurIdx()
/*    */   {
/* 42 */     return this.index;
/*    */   }
/*    */   
/*    */ 
/*    */   public int nextIdx()
/*    */   {
/* 48 */     if (this.index + 1 >= this.path.getLength())
/*    */     {
/* 50 */       this.index = 0;
/* 51 */       return this.index;
/*    */     }
/* 53 */     return ++this.index;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\pathtype\PathTypeCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */