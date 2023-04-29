/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class Cmd_multiroleaward extends CmdBase
/*    */ {
/*    */   private long roleId;
/* 11 */   private ArrayList<Integer> itemid = new ArrayList();
/* 12 */   private ArrayList<Integer> itemCount = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 22 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 24 */     if (this.m_arguments == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return false;
/*    */     }
/* 32 */     Long targetId = null;
/* 33 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 35 */     if (targetId != null)
/*    */     {
/* 37 */       this.roleId = targetId.longValue();
/* 38 */       index++;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 44 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 47 */       if (index >= this.m_arguments.size()) {
/* 48 */         return false;
/*    */       }
/* 50 */       Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 51 */       if (I_itemid == null) {
/* 52 */         return false;
/*    */       }
/* 54 */       this.itemid.add(I_itemid);
/*    */       
/* 56 */       if (index >= this.m_arguments.size()) {
/* 57 */         return false;
/*    */       }
/* 59 */       Integer I_itemCount = parseInt((String)this.m_arguments.get(index++));
/* 60 */       if (I_itemCount == null) {
/* 61 */         return false;
/*    */       }
/* 63 */       this.itemCount.add(I_itemCount);
/*    */     }
/*    */     
/* 66 */     if (index != this.m_arguments.size()) {
/* 67 */       return false;
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 77 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 83 */     if (this.itemid.size() != this.itemCount.size()) {
/* 84 */       SGMMessageTipRes sgmMessageTipRes = new SGMMessageTipRes();
/* 85 */       sgmMessageTipRes.result = 11;
/* 86 */       OnlineManager.getInstance().send(this.roleId, sgmMessageTipRes);
/* 87 */       return;
/*    */     }
/* 89 */     for (Iterator i$ = this.itemid.iterator(); i$.hasNext();) { int item = ((Integer)i$.next()).intValue();
/* 90 */       mzm.gsp.item.confbean.SItemCfg itemCfg = mzm.gsp.item.confbean.SItemCfg.get(item);
/* 91 */       if (itemCfg == null) {
/* 92 */         SGMMessageTipRes sgmMessageTipRes = new SGMMessageTipRes();
/* 93 */         sgmMessageTipRes.result = 11;
/* 94 */         OnlineManager.getInstance().send(this.roleId, sgmMessageTipRes);
/* 95 */         return;
/*    */       }
/*    */     }
/* 98 */     mzm.gsp.Role.addRoleProcedure(this.roleId, new mzm.gsp.award.main.PGM_MultiRoleAward(this.roleId, this.itemid, this.itemCount));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_multiroleaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */