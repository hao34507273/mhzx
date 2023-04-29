/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightStartFailArg;
/*    */ import mzm.gsp.map.main.message.MMH_StartFightResult;
/*    */ 
/*    */ public class POnPVEFightStartFail extends mzm.gsp.fight.event.PVEFightStartFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (!(((PVEFightStartFailArg)this.arg).context instanceof MapVisibleMonsterFightContext))
/*    */     {
/* 12 */       return false;
/*    */     }
/*    */     
/* 15 */     MapVisibleMonsterFightContext context = (MapVisibleMonsterFightContext)((PVEFightStartFailArg)this.arg).context;
/* 16 */     new MMH_StartFightResult(context.roleid, context.instanceId, -1).execute();
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPVEFightStartFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */