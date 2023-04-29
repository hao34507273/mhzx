/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crosscompete.main.EnterContext;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossCompeteRoamRoleDataSucceedArg
/*    */   extends RoamRoleDataSucceedArg
/*    */ {
/*    */   public final EnterContext context;
/*    */   
/*    */   public CrossCompeteRoamRoleDataSucceedArg(EnterContext context)
/*    */   {
/* 20 */     super(RoamType.CROSS_COMPETE);
/* 21 */     this.context = context;
/*    */   }
/*    */   
/*    */   public List<RoamRoleInfo> getRoamRoleInfos()
/*    */   {
/* 26 */     return new ArrayList(this.context.roamRoles);
/*    */   }
/*    */   
/*    */   public int getRoamZoneid()
/*    */   {
/* 31 */     return this.context.roamServerid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\CrossCompeteRoamRoleDataSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */