/*    */ package mzm.gsp.homeland.mysteryvisitor;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!MysteryVisitorManager.postInitFlag)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (((OpenChangeComplexArg)this.arg).getType() != 336)
/*    */     {
/* 29 */       return false; }
/*    */     Iterator i$;
/* 31 */     Iterator i$; if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 33 */       if (!ActivityInterface.isActivityOpen(MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID))
/*    */       {
/* 35 */         return false;
/*    */       }
/* 37 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 39 */         MysteryVisitorTaskOneByOne.getInstance().add(new PTrySetMysteryVisitor(roleid));
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 44 */       if (!ActivityInterface.isActivityOpen(MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID))
/*    */       {
/* 46 */         return false;
/*    */       }
/* 48 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 50 */         MysteryVisitorTaskOneByOne.getInstance().add(new PClearMysteryVisitor(roleid));
/*    */       }
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */