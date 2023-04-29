/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AsyncGetFightRecordInfo
/*    */ {
/*    */   public final long recordid;
/*    */   public final int dataType;
/*    */   public final Octets context;
/*    */   
/*    */   public AsyncGetFightRecordInfo(long recordid, int dataType, Octets context)
/*    */   {
/* 17 */     this.recordid = recordid;
/* 18 */     this.dataType = dataType;
/* 19 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\AsyncGetFightRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */