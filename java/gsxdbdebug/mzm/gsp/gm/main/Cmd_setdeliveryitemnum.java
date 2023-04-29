/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gratefuldelivery.main.RGMSetDeliveryItemNum;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setdeliveryitemnum
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int activityId;
/*    */   private int min;
/*    */   private int max;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 23 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 25 */     if (this.m_arguments == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     int index = 0;
/*    */     
/* 30 */     if (index >= this.m_arguments.size()) {
/* 31 */       return false;
/*    */     }
/* 33 */     Long targetId = null;
/* 34 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 36 */     if (targetId != null)
/*    */     {
/* 38 */       this.roleId = targetId.longValue();
/* 39 */       index++;
/*    */     }
/*    */     
/* 42 */     if (index >= this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 46 */     if (I_activityId == null) {
/* 47 */       return false;
/*    */     }
/* 49 */     this.activityId = I_activityId.intValue();
/*    */     
/* 51 */     if (index >= this.m_arguments.size()) {
/* 52 */       return false;
/*    */     }
/* 54 */     Integer I_min = parseInt((String)this.m_arguments.get(index++));
/* 55 */     if (I_min == null) {
/* 56 */       return false;
/*    */     }
/* 58 */     this.min = I_min.intValue();
/*    */     
/* 60 */     if (index >= this.m_arguments.size()) {
/* 61 */       return false;
/*    */     }
/* 63 */     Integer I_max = parseInt((String)this.m_arguments.get(index++));
/* 64 */     if (I_max == null) {
/* 65 */       return false;
/*    */     }
/* 67 */     this.max = I_max.intValue();
/*    */     
/* 69 */     if (index != this.m_arguments.size()) {
/* 70 */       return false;
/*    */     }
/* 72 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 81 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 88 */     new RGMSetDeliveryItemNum(this.roleId, this.activityId, this.min, this.max).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setdeliveryitemnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */