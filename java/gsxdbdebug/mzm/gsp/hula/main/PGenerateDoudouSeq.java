/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.HulaWorldInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Hulaworld;
/*    */ 
/*    */ public class PGenerateDoudouSeq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long worldId;
/*    */   private final int turn;
/*    */   
/*    */   public PGenerateDoudouSeq(long worldId, int turn)
/*    */   {
/* 19 */     this.worldId = worldId;
/* 20 */     this.turn = turn;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     long key = GameServerInfoManager.toGlobalId(this.worldId);
/* 27 */     Set<Long> roles = Hulaworld.selectRoleids(Long.valueOf(key));
/* 28 */     if ((roles == null) || (roles.isEmpty()))
/*    */     {
/* 30 */       String log = String.format("[hula]PGenerateDoudouSeq.processImp@roles is null|worldid=%d|turn=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.turn) });
/* 31 */       HulaManager.logger.warn(log);
/* 32 */       return false;
/*    */     }
/* 34 */     Lockeys.lock(xtable.Role2properties.getTable(), roles);
/*    */     
/* 36 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/* 37 */     if (xHulaWorldInfo == null)
/*    */     {
/* 39 */       String log = String.format("[hula]PGenerateDoudouSeq.processImp@xHulaWorldInfo is null|worldid=%d|turn=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.turn) });
/*    */       
/* 41 */       HulaManager.logger.warn(log);
/* 42 */       return false;
/*    */     }
/* 44 */     Map<Long, xbean.HulaInfo> roleid2XHulaInfo = HulaManager.getXRoleid2HulaInfo(roles);
/* 45 */     int cutSize = HulaManager.generateDouboeSeq(this.turn, xHulaWorldInfo, roleid2XHulaInfo);
/* 46 */     HulaManager.addPoint(roleid2XHulaInfo, -cutSize * SHulaCfgConsts.getInstance().CUT_POINT, -1, null, null, true);
/* 47 */     String log = String.format("[hula]PGenerateDoudouSeq.processImp@generate dou dou success|worldid=%d|turn=%d|cutSize=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.turn), Integer.valueOf(cutSize) });
/*    */     
/*    */ 
/* 50 */     HulaManager.logger.info(log);
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PGenerateDoudouSeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */