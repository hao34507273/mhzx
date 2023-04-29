/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.yzdd.main.PChangeChannel;
/*    */ import mzm.gsp.yzdd.main.YzddFightContext;
/*    */ import mzm.gsp.yzdd.main.YzddManager;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ public class POnPVPFightEnd
/*    */   extends PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     lock(Basic.getTable(), ((PVPFightEndArg)this.arg).getAllRoles());
/* 21 */     for (Long l : ((PVPFightEndArg)this.arg).getAllRoles()) {
/* 22 */       long roleId = l.longValue();
/* 23 */       ChangeModelCardManager.consumePVPFightCount(roleId, 1);
/*    */     }
/* 25 */     if ((((PVPFightEndArg)this.arg).context instanceof YzddFightContext))
/*    */     {
/*    */ 
/* 28 */       for (Long roleId : ((PVPFightEndArg)this.arg).getLoserList()) {
/* 29 */         YzddManager.getInstance().LoseTransMap(roleId.longValue());
/*    */       }
/* 31 */       long worldid = YzddManager.getInstance().getWorldId().longValue();
/* 32 */       int mapId = MapInterface.getRoleMapId(((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue());
/* 33 */       List<Long> roleIds = MapInterface.getRoleList(worldid, mapId);
/* 34 */       for (Long rid : roleIds) {
/* 35 */         Procedure.execute(new PChangeChannel(rid.longValue(), (int)worldid));
/*    */       }
/*    */       
/* 38 */       YzddManager.getInstance().RemoveFight(((PVPFightEndArg)this.arg).fightid);
/*    */       
/* 40 */       YzddManager.getInstance().CheckActivityEnd();
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */