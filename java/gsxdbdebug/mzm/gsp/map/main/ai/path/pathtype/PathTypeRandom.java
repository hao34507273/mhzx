/*    */ package mzm.gsp.map.main.ai.path.pathtype;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.map.main.ai.path.IPathTypeStrategy;
/*    */ import mzm.gsp.map.main.ai.path.Path;
/*    */ import mzm.gsp.map.main.ai.path.PathNode;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ public class PathTypeRandom
/*    */   implements IPathTypeStrategy
/*    */ {
/*    */   private Path path;
/* 14 */   private CircleQueue circleQueue = new CircleQueue();
/*    */   
/*    */   public PathTypeRandom(Path path)
/*    */   {
/* 18 */     this.path = path;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isEnd()
/*    */   {
/* 24 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getNextIdx()
/*    */   {
/* 30 */     return this.circleQueue.getNextPos(Xdb.random().nextInt(this.path.getLength()));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCurIdx()
/*    */   {
/* 36 */     return this.circleQueue.getCurPos();
/*    */   }
/*    */   
/*    */ 
/*    */   public int nextIdx()
/*    */   {
/* 42 */     return this.circleQueue.goNext();
/*    */   }
/*    */   
/*    */ 
/*    */   class CircleQueue
/*    */   {
/* 48 */     private int curPos = 0;
/* 49 */     private int nextPos = 0;
/*    */     
/*    */     CircleQueue() {}
/*    */     
/* 53 */     public int getNextPos(int forwardElement) { if (this.nextPos != this.curPos)
/*    */       {
/* 55 */         return this.nextPos;
/*    */       }
/* 57 */       int length = PathTypeRandom.this.path.getLength();
/* 58 */       if (length <= 0)
/*    */       {
/* 60 */         return -1;
/*    */       }
/* 62 */       if (forwardElement <= 0)
/*    */       {
/* 64 */         forwardElement = 1;
/*    */       }
/* 66 */       this.nextPos = (this.curPos + forwardElement);
/* 67 */       while (this.nextPos >= length)
/*    */       {
/* 69 */         this.nextPos -= length;
/*    */       }
/* 71 */       PathNode pn = PathTypeRandom.this.path.get(this.nextPos);
/* 72 */       pn.setStayTime(Xdb.random().nextInt(3) + 3);
/* 73 */       return this.nextPos;
/*    */     }
/*    */     
/*    */     public int goNext()
/*    */     {
/* 78 */       if (this.curPos == this.nextPos)
/*    */       {
/* 80 */         getNextPos(Xdb.random().nextInt(PathTypeRandom.this.path.getLength()));
/*    */       }
/* 82 */       this.curPos = this.nextPos;
/* 83 */       return this.curPos;
/*    */     }
/*    */     
/*    */     public int getCurPos()
/*    */     {
/* 88 */       return this.curPos;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\pathtype\PathTypeRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */