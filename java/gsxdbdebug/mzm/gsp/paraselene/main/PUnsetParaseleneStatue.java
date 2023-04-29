/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Paraselene;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ public class PUnsetParaseleneStatue extends LogicProcedure
/*    */ {
/* 14 */   private List<Long> roleList = new ArrayList();
/*    */   
/*    */   PUnsetParaseleneStatue(List<Long> roleList)
/*    */   {
/* 18 */     this.roleList.addAll(roleList);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     Lockeys.lock(xtable.Role2properties.getTable(), this.roleList);
/* 25 */     RoleStatusInterface.unsetStatus(this.roleList, 12);
/* 26 */     for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/* 28 */       Paraselene paraselene = Role2paraselene.get(Long.valueOf(r));
/* 29 */       if (paraselene != null)
/*    */       {
/*    */ 
/* 32 */         paraselene.setRecentlayer(0);
/*    */       }
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PUnsetParaseleneStatue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */