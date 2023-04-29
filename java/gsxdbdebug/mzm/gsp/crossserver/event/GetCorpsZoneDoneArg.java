/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class GetCorpsZoneDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final Octets context;
/*    */   private final Map<Long, Integer> data;
/*    */   
/*    */   public GetCorpsZoneDoneArg(int retcode, Octets context, Map<Long, Integer> data)
/*    */   {
/* 15 */     this.retcode = retcode;
/* 16 */     this.context = context;
/* 17 */     this.data = data;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 27 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 37 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRetcode()
/*    */   {
/* 47 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Octets getContext()
/*    */   {
/* 57 */     return this.context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Map<Long, Integer> getData()
/*    */   {
/* 67 */     return this.data;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetCorpsZoneDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */