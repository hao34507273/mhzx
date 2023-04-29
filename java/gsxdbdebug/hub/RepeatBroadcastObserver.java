/*     */ package hub;
/*     */ 
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import xdb.Executor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RepeatBroadcastObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final int times;
/*     */   private final DataBroadcast broadcast;
/*     */   
/*     */   public RepeatBroadcastObserver(DataBroadcast broadcast)
/*     */   {
/* 160 */     this(1, broadcast);
/*     */   }
/*     */   
/*     */   private RepeatBroadcastObserver(int times, DataBroadcast broadcast)
/*     */   {
/* 165 */     super(times <= 1 ? 1000L : 2000L);
/*     */     
/* 167 */     this.times = times;
/* 168 */     this.broadcast = broadcast;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 174 */     Executor.getInstance().execute(new RDataBroadcast(this.broadcast));
/*     */     
/* 176 */     if (this.times < 2)
/*     */     {
/* 178 */       new RepeatBroadcastObserver(this.times + 1, this.broadcast);
/*     */     }
/*     */     
/* 181 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RepeatBroadcastObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */