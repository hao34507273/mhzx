/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ 
/*    */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     List<Long> roleids = new ArrayList();
/* 12 */     if (((PVPFightEndArg)this.arg).activeRoleList != null)
/*    */     {
/* 14 */       roleids.addAll(((PVPFightEndArg)this.arg).activeRoleList);
/*    */     }
/* 16 */     if (((PVPFightEndArg)this.arg).passiveRoleList != null)
/*    */     {
/* 18 */       roleids.addAll(((PVPFightEndArg)this.arg).passiveRoleList);
/*    */     }
/*    */     
/* 21 */     return AddictionManager.onFightEnd(roleids);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */