/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.award.MultiRoleAwardBean;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2multiroleaward;
/*    */ 
/*    */ public class PGM_MultiRoleAward extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private List<Integer> itemids;
/*    */   private List<Integer> itemcounts;
/*    */   
/*    */   public PGM_MultiRoleAward(long roleid, List<Integer> itemids, List<Integer> itemcounts)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.itemids = itemids;
/* 22 */     this.itemcounts = itemcounts;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     List<Long> normalRoleList = TeamInterface.getNormalRoleList(this.roleid);
/* 29 */     if (normalRoleList.size() <= 0)
/*    */     {
/* 31 */       normalRoleList.add(Long.valueOf(this.roleid));
/*    */     }
/* 33 */     lock(Role2multiroleaward.getTable(), normalRoleList);
/* 34 */     List<MultiRoleAwardBean> multiRoleAwardBeans = new ArrayList();
/* 35 */     for (int i = 0; (i < this.itemids.size()) && (i < this.itemcounts.size()); i++)
/*    */     {
/* 37 */       int itemid = ((Integer)this.itemids.get(i)).intValue();
/* 38 */       int itemCount = ((Integer)this.itemcounts.get(i)).intValue();
/* 39 */       MultiRoleAwardBean awardBean = new MultiRoleAwardBean();
/* 40 */       awardBean.id = itemid;
/* 41 */       awardBean.count = itemCount;
/* 42 */       multiRoleAwardBeans.add(awardBean);
/*    */     }
/* 44 */     RoleAwardManager.awardMultiRoleSelectAward(normalRoleList, null, multiRoleAwardBeans, null, new TLogArg(LogReason.GM_ADD));
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGM_MultiRoleAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */