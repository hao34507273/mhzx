/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PGM_AddFriendPoint;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ public class Cmd_addclose
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int point;
/*    */   private String friendName;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 18 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     Long targetId = null;
/* 29 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 31 */     if (targetId != null)
/*    */     {
/* 33 */       this.roleId = targetId.longValue();
/* 34 */       index++;
/*    */     }
/*    */     
/* 37 */     if (index >= this.m_arguments.size()) {
/* 38 */       return false;
/*    */     }
/* 40 */     Integer I_point = parseInt((String)this.m_arguments.get(index++));
/* 41 */     if (I_point == null) {
/* 42 */       return false;
/*    */     }
/* 44 */     this.point = I_point.intValue();
/*    */     
/* 46 */     if (index >= this.m_arguments.size()) {
/* 47 */       return false;
/*    */     }
/* 49 */     this.friendName = ((String)this.m_arguments.get(index++));
/* 50 */     if (index != this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 67 */     Role.addRoleProcedure(this.roleId, new PGM_AddFriendPoint(this.roleId, this.friendName, this.point));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addclose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */