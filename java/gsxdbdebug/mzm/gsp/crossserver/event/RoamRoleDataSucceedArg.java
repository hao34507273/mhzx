/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ public abstract class RoamRoleDataSucceedArg
/*    */ {
/*    */   private final RoamType roamType;
/*    */   
/*    */   public RoamRoleDataSucceedArg(RoamType roamType)
/*    */   {
/* 14 */     this.roamType = roamType;
/*    */   }
/*    */   
/*    */   public RoamType getRoamType()
/*    */   {
/* 19 */     return this.roamType;
/*    */   }
/*    */   
/*    */   public abstract int getRoamZoneid();
/*    */   
/*    */   public abstract List<RoamRoleInfo> getRoamRoleInfos();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RoamRoleDataSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */