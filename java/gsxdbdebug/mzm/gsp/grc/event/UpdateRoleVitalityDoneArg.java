/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.grc.main.RoleVitalityInfo;
/*    */ 
/*    */ 
/*    */ public class UpdateRoleVitalityDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final RoleVitalityInfo vitalityInfo;
/*    */   public final Octets context;
/*    */   
/*    */   public UpdateRoleVitalityDoneArg(int retcode, String openid, RoleVitalityInfo vitalityInfo, Octets context)
/*    */   {
/* 16 */     this.retcode = retcode;
/* 17 */     this.openid = openid;
/* 18 */     this.vitalityInfo = vitalityInfo;
/* 19 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\UpdateRoleVitalityDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */