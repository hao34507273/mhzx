/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.event.PVEFightStartProcedure;
/*    */ import mzm.gsp.map.main.message.MMH_StartFightResult;
/*    */ 
/*    */ public class POnPVEFightStart extends PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!(((PVEFightStartArg)this.arg).context instanceof MapVisibleMonsterFightContext))
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     MapVisibleMonsterFightContext context = (MapVisibleMonsterFightContext)((PVEFightStartArg)this.arg).context;
/* 17 */     new MMH_StartFightResult(context.roleid, context.instanceId, 1, ((PVEFightStartArg)this.arg).fightid).execute();
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */