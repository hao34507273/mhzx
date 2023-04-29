/*    */ package mzm.gsp.map.main.scene;
/*    */ 
/*    */ public class ScriptTimerCounter
/*    */ {
/*    */   private int id;
/*    */   private int interval;
/*    */   private int countLimit;
/*    */   private int steps;
/*    */   private int count;
/*    */   
/*    */   public ScriptTimerCounter(int id, int interval, int count)
/*    */   {
/* 13 */     this.id = id;
/* 14 */     this.interval = interval;
/* 15 */     this.countLimit = count;
/* 16 */     this.steps = 1;
/* 17 */     this.count = 0;
/*    */   }
/*    */   
/*    */   public int getId()
/*    */   {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public int getInterval()
/*    */   {
/* 27 */     return this.interval;
/*    */   }
/*    */   
/*    */   public int getCount()
/*    */   {
/* 32 */     return this.countLimit;
/*    */   }
/*    */   
/*    */   public boolean isTrigger()
/*    */   {
/* 37 */     return this.steps == this.interval;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 42 */     this.steps += 1;
/* 43 */     if (this.steps > this.interval)
/*    */     {
/* 45 */       this.steps = 1;
/* 46 */       this.count += 1;
/*    */     }
/* 48 */     return this.count < this.countLimit;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\ScriptTimerCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */