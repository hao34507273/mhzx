/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import xbean.MenpaiPVP;
/*    */ 
/*    */ public class POnPvPFightStart extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if ((((PVPFightStartArg)this.arg).context instanceof MenpaiPVPFightContext))
/*    */     {
/* 14 */       MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVPIfNotExist();
/* 15 */       xMenpaiPVP.getFights().add(Long.valueOf(((PVPFightStartArg)this.arg).fightid));
/*    */       
/*    */ 
/* 18 */       MenpaiPVPManager.broadcastMatchCountDownForce(((PVPFightStartArg)this.arg).getAllRoles());
/*    */     }
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnPvPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */