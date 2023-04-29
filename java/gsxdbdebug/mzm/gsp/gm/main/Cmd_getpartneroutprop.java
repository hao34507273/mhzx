/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*    */ import mzm.gsp.role.main.PropertyManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_getpartneroutprop
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int partnerId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 26 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 28 */     if (this.m_arguments == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     int index = 0;
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Long targetId = null;
/* 37 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 39 */     if (targetId != null)
/*    */     {
/* 41 */       this.roleId = targetId.longValue();
/* 42 */       index++;
/*    */     }
/*    */     
/* 45 */     if (index >= this.m_arguments.size()) {
/* 46 */       return false;
/*    */     }
/* 48 */     Integer I_partnerId = parseInt((String)this.m_arguments.get(index++));
/* 49 */     if (I_partnerId == null) {
/* 50 */       return false;
/*    */     }
/* 52 */     this.partnerId = I_partnerId.intValue();
/*    */     
/* 54 */     if (index != this.m_arguments.size()) {
/* 55 */       return false;
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 73 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 79 */         PartnerOutFightObj partner = PartnerInterface.getPartnerOutFightObjById(Cmd_getpartneroutprop.this.roleId, Cmd_getpartneroutprop.this.partnerId);
/* 80 */         if (partner == null)
/*    */         {
/* 82 */           GmManager.getInstance().sendResultToGM(Cmd_getpartneroutprop.this.roleId, String.format("not own this partner! partnerId=%d", new Object[] { Integer.valueOf(Cmd_getpartneroutprop.this.partnerId) }));
/* 83 */           return false;
/*    */         }
/* 85 */         Map<Integer, Integer> props = partner.getFinalPropertyMap();
/* 86 */         GmManager.getInstance().sendResultToGM(Cmd_getpartneroutprop.this.roleId, PropertyManager.getPropCHNInfo(props));
/* 87 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getpartneroutprop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */