/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.mounts.main.PGM_RemoveMounts;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_removemounts
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int mountsCfgId;
/*    */   private long mountsId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Long targetId = null;
/* 31 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 33 */     if (targetId != null)
/*    */     {
/* 35 */       this.roleId = targetId.longValue();
/* 36 */       index++;
/*    */     }
/*    */     
/* 39 */     if (index >= this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Integer I_mountsCfgId = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_mountsCfgId == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.mountsCfgId = I_mountsCfgId.intValue();
/*    */     
/* 48 */     if (index >= this.m_arguments.size()) {
/* 49 */       return false;
/*    */     }
/* 51 */     Long L_mountsId = parseLong((String)this.m_arguments.get(index++));
/* 52 */     if (L_mountsId == null)
/* 53 */       return false;
/* 54 */     this.mountsId = L_mountsId.longValue();
/*    */     
/* 56 */     if (index != this.m_arguments.size()) {
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 75 */     new PGM_RemoveMounts(this.m_gmRole.getRoleid(), this.roleId, this.mountsId, this.mountsCfgId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_removemounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */