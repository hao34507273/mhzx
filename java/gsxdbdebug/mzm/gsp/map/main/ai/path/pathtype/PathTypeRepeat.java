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
/*    */ public class PathTypeRepeat
/*    */   implements IPathTypeStrategy
/*    */ {
/*    */   private final Path path;
/* 15 */   private int index = 0;
/* 16 */   private int dir = 1;
/*    */   
/*    */   public PathTypeRepeat(Path path)
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
/*    */   private boolean isOutOfBoundary()
/*    */   {
/* 31 */     return (this.index + this.dir < 0) || (this.index + this.dir >= this.path.getLength());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getNextIdx()
/*    */   {
/* 37 */     if (isOutOfBoundary())
/*    */     {
/* 39 */       this.dir = (-this.dir);
/*    */     }
/* 41 */     return this.index + this.dir;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCurIdx()
/*    */   {
/* 47 */     return this.index;
/*    */   }
/*    */   
/*    */ 
/*    */   public int nextIdx()
/*    */   {
/* 53 */     if (isOutOfBoundary())
/*    */     {
/* 55 */       this.dir = (-this.dir);
/*    */     }
/* 57 */     return this.index += this.dir;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\pathtype\PathTypeRepeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */