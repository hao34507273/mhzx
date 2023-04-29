/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossCompeteRoamServersDoneArg
/*    */ {
/*    */   public final long startMillis;
/*    */   public final Map<Integer, Integer> compete2RoamServerid;
/*    */   
/*    */   public CrossCompeteRoamServersDoneArg(long startMillis, Map<Integer, Integer> compete2RoamServerid)
/*    */   {
/* 18 */     this.startMillis = startMillis;
/* 19 */     this.compete2RoamServerid = new HashMap(compete2RoamServerid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\CrossCompeteRoamServersDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */