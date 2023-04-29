/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.HulaInfo;
/*    */ import xbean.HulaWorldInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Hulaworld;
/*    */ 
/*    */ public class PDeleteDoudou extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long worldId;
/*    */   private final int turn;
/*    */   
/*    */   public PDeleteDoudou(long worldId, int turn)
/*    */   {
/* 20 */     this.worldId = worldId;
/* 21 */     this.turn = turn;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     long key = GameServerInfoManager.toGlobalId(this.worldId);
/* 29 */     Set<Long> roles = Hulaworld.selectRoleids(Long.valueOf(key));
/* 30 */     if ((roles == null) || (roles.isEmpty()))
/*    */     {
/* 32 */       String log = String.format("[hula]PDeleteDoudou.processImp@roles is null|worldid=%d|turn=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.turn) });
/* 33 */       HulaManager.logger.info(log);
/* 34 */       return false;
/*    */     }
/* 36 */     Map<Long, String> roleid2userid = new java.util.HashMap();
/* 37 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       roleid2userid.put(Long.valueOf(roleid), mzm.gsp.role.main.RoleInterface.getUserId(roleid));
/*    */     }
/* 41 */     Lockeys.lock(xtable.User.getTable(), roleid2userid.values());
/* 42 */     Lockeys.lock(xtable.Role2properties.getTable(), roles);
/* 43 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/* 44 */     if (xHulaWorldInfo == null)
/*    */     {
/* 46 */       String log = String.format("[hula]PDeleteDoudou.processImp@xHulaWorldInfo is null|worldid=%d|turn=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.turn) });
/*    */       
/* 48 */       HulaManager.logger.info(log);
/* 49 */       return false;
/*    */     }
/* 51 */     HulaManager.broadCastSSynDeleteStageRes(this.turn, roles);
/* 52 */     String beforeMonsterids = HulaManager.getMonsterString(xHulaWorldInfo);
/* 53 */     DeleteDoudouResult result = HulaManager.deleteDoudou(xHulaWorldInfo);
/* 54 */     Map<Long, HulaInfo> roleid2XHulaInfo = HulaManager.getXRoleid2HulaInfo(roles);
/* 55 */     HulaManager.addPoint(roleid2XHulaInfo, result.getPoint(), -1, result.getDelete_type_2_count(), result.getDelete_monsterid_2_count(), false);
/*    */     
/*    */ 
/* 58 */     if (HulaManager.isLastTurn(this.turn))
/*    */     {
/* 60 */       long roleid = ((Long)roles.iterator().next()).longValue();
/* 61 */       HulaManager.brodcastSSynActivityResultRes(roles, (HulaInfo)roleid2XHulaInfo.get(Long.valueOf(roleid)));
/*    */     }
/* 63 */     String teamMateString = HulaManager.getTeammateString(roles);
/* 64 */     String afterMonsterids = HulaManager.getMonsterString(xHulaWorldInfo);
/* 65 */     String deleteTypeString = HulaManager.getDeleteTypeString(result.getDelete_type_2_count());
/* 66 */     for (Iterator i$ = roleid2XHulaInfo.keySet().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/* 68 */       int totalpoint = ((HulaInfo)roleid2XHulaInfo.get(Long.valueOf(r))).getPoint();
/* 69 */       HulaManager.tlogHulaturnend(r, teamMateString, this.turn, beforeMonsterids, afterMonsterids, totalpoint, deleteTypeString, result.getPoint());
/*    */     }
/*    */     
/* 72 */     HulaManager.offerTurnAward(roleid2XHulaInfo, this.turn);
/* 73 */     String log = String.format("[hula]PDeleteDoudou.processImp@delete monster seq|roleids=%s|turn=%d|beforemonsterseq=%s|aftermonsterseq=%s|deletetypestring=%s", new Object[] { teamMateString, Integer.valueOf(this.turn), beforeMonsterids, afterMonsterids, deleteTypeString });
/*    */     
/*    */ 
/* 76 */     HulaManager.logger.info(log);
/*    */     
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PDeleteDoudou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */