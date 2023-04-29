/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ 
/*    */ public class PointRaceCorpsInfo
/*    */ {
/*    */   private long corpsid;
/*    */   
/*    */   private int win;
/*    */   
/*    */   private int lose;
/*    */   private int point;
/*    */   private long updateTime;
/*    */   
/*    */   public PointRaceCorpsInfo() {}
/*    */   
/*    */   public PointRaceCorpsInfo(hub.PointRaceCorpsInfo corpsInfo)
/*    */   {
/* 18 */     this.corpsid = corpsInfo.corpsid;
/* 19 */     this.win = corpsInfo.win;
/* 20 */     this.lose = corpsInfo.lose;
/* 21 */     this.point = corpsInfo.point;
/* 22 */     this.updateTime = corpsInfo.update_time;
/*    */   }
/*    */   
/*    */   public long getCorpsid()
/*    */   {
/* 27 */     return this.corpsid;
/*    */   }
/*    */   
/*    */   public void setCorpsid(long corpsid)
/*    */   {
/* 32 */     this.corpsid = corpsid;
/*    */   }
/*    */   
/*    */   public int getWin()
/*    */   {
/* 37 */     return this.win;
/*    */   }
/*    */   
/*    */   public void setWin(int win)
/*    */   {
/* 42 */     this.win = win;
/*    */   }
/*    */   
/*    */   public int getLose()
/*    */   {
/* 47 */     return this.lose;
/*    */   }
/*    */   
/*    */   public void setLose(int lose)
/*    */   {
/* 52 */     this.lose = lose;
/*    */   }
/*    */   
/*    */   public int getPoint()
/*    */   {
/* 57 */     return this.point;
/*    */   }
/*    */   
/*    */   public void setPoint(int point)
/*    */   {
/* 62 */     this.point = point;
/*    */   }
/*    */   
/*    */   public long getUpdateTime()
/*    */   {
/* 67 */     return this.updateTime;
/*    */   }
/*    */   
/*    */   public void setUpdateTime(long updateTime)
/*    */   {
/* 72 */     this.updateTime = updateTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */