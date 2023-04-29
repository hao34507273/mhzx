/*    */ package mzm.gsp.map.main.ai.path;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Path
/*    */ {
/*  8 */   private long startTime = -1L;
/*  9 */   private List<PathNode> _nodePath = new ArrayList();
/*    */   
/*    */   public void add(PathNode pn)
/*    */   {
/* 13 */     this._nodePath.add(pn);
/*    */   }
/*    */   
/*    */   public PathNode get(int index)
/*    */   {
/* 18 */     return (PathNode)this._nodePath.get(index);
/*    */   }
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 23 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public int getLength()
/*    */   {
/* 28 */     return this._nodePath.size();
/*    */   }
/*    */   
/*    */   public void setStartTime(long startTime)
/*    */   {
/* 33 */     this.startTime = startTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\Path.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */