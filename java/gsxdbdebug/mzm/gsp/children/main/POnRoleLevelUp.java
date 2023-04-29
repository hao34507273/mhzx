/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.children.SSynChildrenLevelRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.ChildInfo;
/*    */ import xbean.ChildrenOutFightBeans;
/*    */ import xbean.Role2ChildrenInfo;
/*    */ import xtable.Children;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     Set<Long> allChildids = new java.util.HashSet();
/*    */     
/* 19 */     Role2ChildrenInfo xRole2ChildrenInfo = xtable.Role2children.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 20 */     if (xRole2ChildrenInfo != null)
/*    */     {
/* 22 */       allChildids.addAll(xRole2ChildrenInfo.getChild_bag_id_list());
/*    */     }
/* 24 */     ChildrenOutFightBeans xChildrenOutFightBeans = xtable.Role2childoutfightbean.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 25 */     if (xChildrenOutFightBeans != null)
/*    */     {
/* 27 */       allChildids.addAll(xChildrenOutFightBeans.getOutfigthchilds().keySet());
/*    */     }
/*    */     
/* 30 */     lock(Children.getTable(), allChildids);
/* 31 */     for (Iterator i$ = allChildids.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*    */       
/* 33 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childid));
/* 34 */       if (xChildInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 38 */         long ownRoleid = xChildInfo.getOwn_role_id();
/* 39 */         if ((ownRoleid == ((RoleLevelUpArg)this.arg).roleId) && 
/*    */         
/*    */ 
/*    */ 
/* 43 */           (xChildInfo.getChild_period() == 2))
/*    */         {
/*    */ 
/*    */ 
/* 47 */           ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(((RoleLevelUpArg)this.arg).roleId, childid, xChildInfo);
/*    */           
/* 49 */           childrenOutFightObj.onLevelUp();
/* 50 */           childrenOutFightObj.synPotentialPoint(((RoleLevelUpArg)this.arg).roleId);
/* 51 */           childrenOutFightObj.synPropertyChange(((RoleLevelUpArg)this.arg).roleId);
/* 52 */           SSynChildrenLevelRes synChildrenLevelRes = new SSynChildrenLevelRes();
/* 53 */           synChildrenLevelRes.childrenid = childid;
/* 54 */           synChildrenLevelRes.level = mzm.gsp.role.main.RoleInterface.getLevel(((RoleLevelUpArg)this.arg).roleId);
/* 55 */           OnlineManager.getInstance().send(((RoleLevelUpArg)this.arg).roleId, synChildrenLevelRes);
/*    */         } } }
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */