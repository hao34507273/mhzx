/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ public class GenRoamTokenFailArg
/*    */ {
/*    */   private final RoamType roamType;
/*    */   
/*    */   public GenRoamTokenFailArg(RoamType roamType)
/*    */   {
/* 11 */     this.roamType = roamType;
/*    */   }
/*    */   
/*    */   public RoamType getRoamType()
/*    */   {
/* 16 */     return this.roamType;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GenRoamTokenFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */