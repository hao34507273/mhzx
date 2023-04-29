/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.fashiondress.confbean.ExtraInfo;
/*    */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressCfg;
/*    */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressPropCfg;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeArg;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeProcedure;
/*    */ import xbean.Role2FashionDressInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnThemeFashionDressPropertyChange extends ThemeFashionDressPropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(((ThemeFashionDressPropertyChangeArg)this.arg).roleId);
/*    */     
/* 26 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((ThemeFashionDressPropertyChangeArg)this.arg).roleId) }));
/*    */     
/* 30 */     Role2FashionDressInfo xRole2FashionDressInfo = xtable.Role2fashiondress.get(Long.valueOf(((ThemeFashionDressPropertyChangeArg)this.arg).roleId));
/* 31 */     if (xRole2FashionDressInfo == null)
/*    */     {
/*    */ 
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     List<Integer> currBuffCfgids = new ArrayList();
/* 38 */     if (FashionDressManager.isThemeFashionDressSwitchOpenForRole(((ThemeFashionDressPropertyChangeArg)this.arg).roleId))
/*    */     {
/* 40 */       for (SThemeFashionDressCfg cfg : SThemeFashionDressCfg.getAll().values())
/*    */       {
/* 42 */         int unlockNum = 0;
/* 43 */         for (Iterator i$ = cfg.unlock_theme_fashion_dress_type_list.iterator(); i$.hasNext();) { int typeid = ((Integer)i$.next()).intValue();
/*    */           
/* 45 */           if (xRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set().contains(Integer.valueOf(typeid)))
/*    */           {
/* 47 */             unlockNum++;
/*    */           }
/*    */         }
/* 50 */         SThemeFashionDressPropCfg propCfg = SThemeFashionDressPropCfg.get(cfg.id);
/* 51 */         if (propCfg != null)
/*    */         {
/*    */ 
/*    */ 
/* 55 */           Map.Entry<Integer, ExtraInfo> entry = propCfg.extra_infos.floorEntry(Integer.valueOf(unlockNum));
/* 56 */           if (entry != null)
/*    */           {
/*    */ 
/*    */ 
/* 60 */             for (i$ = ((ExtraInfo)entry.getValue()).buff_list.iterator(); i$.hasNext();) { int buffCfgid = ((Integer)i$.next()).intValue();
/*    */               
/* 62 */               if (!currBuffCfgids.contains(Integer.valueOf(buffCfgid)))
/*    */               {
/* 64 */                 currBuffCfgids.add(Integer.valueOf(buffCfgid)); }
/*    */             } }
/*    */         }
/*    */       }
/*    */     }
/*    */     Iterator i$;
/* 70 */     List<Integer> preBuffCfgids = BuffInterface.contains(((ThemeFashionDressPropertyChangeArg)this.arg).roleId, FashionDressCfgManager.getAllThemeFashionDressBuffCfgid(), true);
/*    */     
/*    */ 
/* 73 */     List<Integer> addBuffCfgids = new ArrayList();
/* 74 */     addBuffCfgids.addAll(currBuffCfgids);
/* 75 */     addBuffCfgids.removeAll(preBuffCfgids);
/*    */     
/* 77 */     List<Integer> deleteBuffCfgids = new ArrayList();
/* 78 */     deleteBuffCfgids.addAll(preBuffCfgids);
/* 79 */     deleteBuffCfgids.removeAll(currBuffCfgids);
/*    */     
/* 81 */     for (Iterator i$ = deleteBuffCfgids.iterator(); i$.hasNext();) { int buffCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 83 */       BuffInterface.uninstallBuf(((ThemeFashionDressPropertyChangeArg)this.arg).roleId, buffCfgid);
/*    */     }
/*    */     
/* 86 */     for (Iterator i$ = addBuffCfgids.iterator(); i$.hasNext();) { int buffCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 88 */       BuffInterface.installBuff(((ThemeFashionDressPropertyChangeArg)this.arg).roleId, buffCfgid);
/*    */     }
/*    */     
/* 91 */     GameServer.logger().info(String.format("[fashiondress]POnThemeFashionDressPropertyChange.processImp@theme fashion dress property change process success|roleid=%d|pre_buff_cfg_ids=%s|curr_buff_cfg_ids=%s|add_buff_cfg_ids=%s|delete_buff_cfg_ids=%s", new Object[] { Long.valueOf(((ThemeFashionDressPropertyChangeArg)this.arg).roleId), preBuffCfgids.toString(), currBuffCfgids.toString(), addBuffCfgids.toString(), deleteBuffCfgids.toString() }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\POnThemeFashionDressPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */