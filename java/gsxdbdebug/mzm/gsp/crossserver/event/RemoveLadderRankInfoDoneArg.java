/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RemoveLadderRankInfoDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final long rankid;
/*    */   private final long roleid;
/*    */   private final Octets context;
/*    */   
/*    */   public RemoveLadderRankInfoDoneArg(int retcode, long rankid, long roleid, Octets context)
/*    */   {
/* 18 */     this.retcode = retcode;
/* 19 */     this.rankid = rankid;
/* 20 */     this.roleid = roleid;
/* 21 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isSucceed()
/*    */   {
/* 31 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isTimeout()
/*    */   {
/* 41 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRetCode()
/*    */   {
/* 51 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRankid()
/*    */   {
/* 61 */     return this.rankid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 71 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Octets getContext()
/*    */   {
/* 81 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemoveLadderRankInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */