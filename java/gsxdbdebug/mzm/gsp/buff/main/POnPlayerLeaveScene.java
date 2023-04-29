/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.confbean.STBuffCfg;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import xbean.RoleBuff;
/*    */ import xbean.RoleBuffList;
/*    */ import xtable.Role2buff;
/*    */ 
/*    */ public class POnPlayerLeaveScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if ((((MapTransferArg)this.arg).newWorldId == ((MapTransferArg)this.arg).oldWorldId) && (((MapTransferArg)this.arg).oldMapCfgId == ((MapTransferArg)this.arg).newMapCfgId))
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     lock(Role2buff.getTable(), ((MapTransferArg)this.arg).roleList);
/* 22 */     for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 24 */       detectedRemove(roleId);
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   private void detectedRemove(long roleId)
/*    */   {
/* 31 */     List<RoleBuffList> xAllBuffs = BuffManager.getRoleAllBuffs(roleId, true);
/* 32 */     if (xAllBuffs == null)
/*    */     {
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     List<Integer> buffCfgids = new ArrayList();
/* 38 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*    */     {
/* 40 */       Iterator<RoleBuff> xIt = xRoleBuffList.getBuffmap().values().iterator();
/* 41 */       while (xIt.hasNext())
/*    */       {
/* 43 */         RoleBuff xRoleBuff = (RoleBuff)xIt.next();
/* 44 */         int buffCfgid = xRoleBuff.getId();
/* 45 */         STBuffCfg cfg = STBuffCfg.get(buffCfgid);
/* 46 */         if (cfg != null)
/*    */         {
/*    */ 
/* 49 */           if (cfg.mapEffect == 2)
/*    */           {
/* 51 */             buffCfgids.add(Integer.valueOf(buffCfgid));
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 56 */     if (buffCfgids.isEmpty())
/*    */     {
/* 58 */       return;
/*    */     }
/*    */     
/* 61 */     for (Iterator i$ = buffCfgids.iterator(); i$.hasNext();) { int buffCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 63 */       BuffManager.uninstallBuff(roleId, buffCfgid);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnPlayerLeaveScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */