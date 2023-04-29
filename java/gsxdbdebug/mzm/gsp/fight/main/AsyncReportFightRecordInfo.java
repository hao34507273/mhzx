/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AsyncReportFightRecordInfo
/*    */ {
/*    */   public final long recordid;
/*    */   public final int dataType;
/*    */   public final Octets data;
/*    */   public final Octets context;
/*    */   
/*    */   public AsyncReportFightRecordInfo(long recordid, int dataType, Octets data, Octets context)
/*    */   {
/* 18 */     this.recordid = recordid;
/* 19 */     this.dataType = dataType;
/* 20 */     this.data = data;
/* 21 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\AsyncReportFightRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */