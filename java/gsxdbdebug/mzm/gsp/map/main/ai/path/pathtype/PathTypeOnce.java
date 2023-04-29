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
/*    */ public class PathTypeOnce
/*    */   implements IPathTypeStrategy
/*    */ {
/*    */   private final Path path;
/*    */   private int index;
/*    */   
/*    */   public PathTypeOnce(Path path)
/*    */   {
/* 19 */     this.path = path;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNextIdx()
/*    */   {
/* 28 */     return this.index + 1;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isEnd()
/*    */   {
/* 34 */     return this.index + 1 >= this.path.getLength();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCurIdx()
/*    */   {
/* 40 */     return this.index;
/*    */   }
/*    */   
/*    */ 
/*    */   public int nextIdx()
/*    */   {
/* 46 */     return ++this.index;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\pathtype\PathTypeOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */