/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightStartFailArg;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import xbean.HulaMonsterInfo;
/*    */ import xbean.HulaWorldInfo;
/*    */ 
/*    */ public class POnPVEFightStartFail extends mzm.gsp.fight.event.PVEFightStartFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     FightContext fightContext = ((PVEFightStartFailArg)this.arg).context;
/* 13 */     if (!(fightContext instanceof HulaFightContext))
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     HulaFightContext hulaFightContext = (HulaFightContext)fightContext;
/* 18 */     hulaFightContext.getSeq();
/* 19 */     hulaFightContext.getWorldid();
/* 20 */     long worldid = hulaFightContext.getWorldid();
/* 21 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(worldid);
/* 22 */     HulaWorldInfo xHulaWorldInfo = xtable.Hulaworld.get(Long.valueOf(key));
/* 23 */     if (xHulaWorldInfo == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     for (HulaMonsterInfo xHulaMonsterInfo : xHulaWorldInfo.getMonsters())
/*    */     {
/* 29 */       if ((xHulaMonsterInfo.getSeq() == hulaFightContext.getSeq()) && (xHulaMonsterInfo.getState() == 4))
/*    */       {
/*    */ 
/* 32 */         xHulaMonsterInfo.setState(1);
/* 33 */         String log = String.format("[hula]POnPVEFightStartFail.processImp@start fight fail,restore monster state|roleid=%d|seq=%d|modelId=%d|worldid=%d", new Object[] { Long.valueOf(hulaFightContext.getRoleid()), Integer.valueOf(hulaFightContext.getSeq()), Integer.valueOf(hulaFightContext.getModelId()), Long.valueOf(hulaFightContext.getWorldid()) });
/*    */         
/*    */ 
/*    */ 
/* 37 */         HulaManager.logger.info(log);
/*    */         
/* 39 */         return true;
/*    */       }
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnPVEFightStartFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */