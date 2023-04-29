/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gang.main.ModBangGongResult;
/*    */ import mzm.gsp.gang.main.ModBangGongResult.ErrorResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_addbanggong
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int value;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 27 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 29 */     if (this.m_arguments == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     int index = 0;
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Long targetId = null;
/* 38 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 40 */     if (targetId != null)
/*    */     {
/* 42 */       this.roleId = targetId.longValue();
/* 43 */       index++;
/*    */     }
/*    */     
/* 46 */     if (index >= this.m_arguments.size()) {
/* 47 */       return false;
/*    */     }
/* 49 */     Integer I_value = parseInt((String)this.m_arguments.get(index++));
/* 50 */     if (I_value == null) {
/* 51 */       return false;
/*    */     }
/* 53 */     this.value = I_value.intValue();
/*    */     
/* 55 */     if (index != this.m_arguments.size()) {
/* 56 */       return false;
/*    */     }
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 67 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 73 */     ModBangGongResult modBangGongResult = GangInterface.addBangGong(this.roleId, this.value, new TLogArg(LogReason.GM_ADD));
/* 74 */     if ((!modBangGongResult.isSucceed()) && 
/* 75 */       (modBangGongResult.getRes() == ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT)) {
/* 76 */       SGangNormalResult result = new SGangNormalResult();
/* 77 */       result.result = 52;
/* 78 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addbanggong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */