/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChange;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Role2FashionDressInfo;
/*    */ import xtable.Role2fashiondress;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 24 */     if (!FashionDressManager.postInitFlag)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 30 */       return;
/*    */     }
/* 32 */     if ((((OpenChangeComplexArg)this.arg).getType() != 328) && (((OpenChangeComplexArg)this.arg).getType() != 464)) {
/*    */       return;
/*    */     }
/*    */     
/*    */     Iterator i$;
/* 37 */     if (((OpenChangeComplexArg)this.arg).getType() == 328)
/*    */     {
/* 39 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 41 */         NoneRealTimeTaskManager.getInstance().addTask(new POnOpenChange(roleid, true));
/*    */       } }
/*    */     Iterator i$;
/* 44 */     if ((((OpenChangeComplexArg)this.arg).getType() == 464) && (OpenInterface.getOpenStatus(328)))
/*    */     {
/*    */ 
/* 47 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 49 */         NoneRealTimeTaskManager.getInstance().addTask(new POnOpenChange(roleid, false));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   class POnOpenChange extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final boolean needTriggerEvent;
/*    */     
/*    */     POnOpenChange(long roleid, boolean needTriggerEvent)
/*    */     {
/* 61 */       this.roleid = roleid;
/* 62 */       this.needTriggerEvent = needTriggerEvent;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 68 */       Role2FashionDressInfo xRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleid));
/* 69 */       if (xRole2FashionDressInfo == null)
/*    */       {
/* 71 */         return false;
/*    */       }
/* 73 */       if (this.needTriggerEvent)
/*    */       {
/* 75 */         TriggerEventsManger.getInstance().triggerEvent(new ThemeFashionDressPropertyChange(), new ThemeFashionDressPropertyChangeArg(this.roleid, xRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 82 */       FashionDressManager.refreshTimeLimitedThemeFashionDressBuff(this.roleid);
/* 83 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */