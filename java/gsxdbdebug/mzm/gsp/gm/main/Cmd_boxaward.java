/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.instance.main.BoxAwardManager;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ public class Cmd_boxaward extends CmdBase
/*    */ {
/*    */   private long roleId;
/* 15 */   private ArrayList<Integer> itemids = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 25 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 27 */     if (this.m_arguments == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     int index = 0;
/*    */     
/* 32 */     if (index >= this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     Long targetId = null;
/* 36 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 38 */     if (targetId != null)
/*    */     {
/* 40 */       this.roleId = targetId.longValue();
/* 41 */       index++;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 47 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 50 */       if (index >= this.m_arguments.size()) {
/* 51 */         return false;
/*    */       }
/* 53 */       Integer I_itemids = parseInt((String)this.m_arguments.get(index++));
/* 54 */       if (I_itemids == null) {
/* 55 */         return false;
/*    */       }
/* 57 */       this.itemids.add(I_itemids);
/*    */     }
/*    */     
/* 60 */     if (index != this.m_arguments.size()) {
/* 61 */       return false;
/*    */     }
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 71 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 77 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 82 */         Long teamid = TeamInterface.getTeamidByRoleid(Cmd_boxaward.this.roleId, false);
/* 83 */         List<Long> allRoleList = new ArrayList();
/* 84 */         if (teamid != null)
/*    */         {
/* 86 */           allRoleList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*    */         } else {
/* 88 */           allRoleList.add(Long.valueOf(Cmd_boxaward.this.roleId));
/*    */         }
/* 90 */         for (Iterator i$ = Cmd_boxaward.this.itemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/* 91 */           if (SItemCfg.get(itemid) == null) {
/* 92 */             return false;
/*    */           }
/*    */         }
/*    */         
/* 96 */         lock(xtable.Role2properties.getTable(), allRoleList);
/* 97 */         BoxAwardManager.getInstance().awardItems(allRoleList, Cmd_boxaward.this.itemids, null);
/* 98 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_boxaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */