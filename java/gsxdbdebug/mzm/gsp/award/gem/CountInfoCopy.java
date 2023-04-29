/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ 
/*    */ public class CountInfoCopy
/*    */ {
/*    */   private final int _awardId;
/*    */   
/*    */   private final long _gemKey;
/*    */   
/*    */   private final int _count;
/*    */   
/*    */   private final int _awardNum;
/*    */   
/*    */   private final long _startTime;
/*    */   
/*    */   private final boolean _isAwarded;
/*    */   private final int _curCircle;
/*    */   
/*    */   public CountInfoCopy(long gemKey, int count, int awardNum, long startTime, boolean isAward, int curCircle)
/*    */   {
/* 21 */     this._awardId = 0;
/* 22 */     this._gemKey = gemKey;
/* 23 */     this._count = count;
/* 24 */     this._awardNum = awardNum;
/* 25 */     this._startTime = startTime;
/* 26 */     this._isAwarded = isAward;
/* 27 */     this._curCircle = curCircle;
/*    */   }
/*    */   
/*    */   public int get_awardId()
/*    */   {
/* 32 */     return this._awardId;
/*    */   }
/*    */   
/*    */   public int get_count()
/*    */   {
/* 37 */     return this._count;
/*    */   }
/*    */   
/*    */   public int get_awardNum()
/*    */   {
/* 42 */     return this._awardNum;
/*    */   }
/*    */   
/*    */   public long get_startTime()
/*    */   {
/* 47 */     return this._startTime;
/*    */   }
/*    */   
/*    */   public boolean is_isAwarded()
/*    */   {
/* 52 */     return this._isAwarded;
/*    */   }
/*    */   
/*    */   public int get_curCircle()
/*    */   {
/* 57 */     return this._curCircle;
/*    */   }
/*    */   
/*    */   public long get_gemKey()
/*    */   {
/* 62 */     return this._gemKey;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\CountInfoCopy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */