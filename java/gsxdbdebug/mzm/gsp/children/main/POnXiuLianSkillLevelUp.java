/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*    */ import xbean.ChildInfo;
/*    */ import xtable.Children;
/*    */ 
/*    */ public class POnXiuLianSkillLevelUp extends mzm.gsp.xiulian.event.XiuLianSkillLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Set<Long> allChildids = new java.util.HashSet();
/*    */     
/* 15 */     xbean.Role2ChildrenInfo xRole2ChildrenInfo = xtable.Role2children.get(Long.valueOf(((XiuLianSkillArg)this.arg).roleId));
/* 16 */     if (xRole2ChildrenInfo != null) {
/* 17 */       allChildids.addAll(xRole2ChildrenInfo.getChild_bag_id_list());
/*    */     }
/* 19 */     xbean.ChildrenOutFightBeans xChildrenOutFightBeans = xtable.Role2childoutfightbean.get(Long.valueOf(((XiuLianSkillArg)this.arg).roleId));
/* 20 */     if (xChildrenOutFightBeans != null) {
/* 21 */       allChildids.addAll(xChildrenOutFightBeans.getOutfigthchilds().keySet());
/*    */     }
/*    */     
/* 24 */     lock(Children.getTable(), allChildids);
/* 25 */     for (Iterator i$ = allChildids.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/* 26 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childid));
/* 27 */       if (xChildInfo != null)
/*    */       {
/*    */ 
/* 30 */         long ownRoleid = xChildInfo.getOwn_role_id();
/* 31 */         if ((ownRoleid == ((XiuLianSkillArg)this.arg).roleId) && 
/*    */         
/*    */ 
/* 34 */           (xChildInfo.getChild_period() == 2))
/*    */         {
/*    */ 
/* 37 */           ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(((XiuLianSkillArg)this.arg).roleId, childid, xChildInfo);
/*    */           
/* 39 */           childrenOutFightObj.updatePassiveSkill();
/* 40 */           childrenOutFightObj.synPropertyChange(((XiuLianSkillArg)this.arg).roleId);
/*    */         } } }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnXiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */