/*    */ package mzm.gsp.teamplatform;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.teamplatform.match.MatchNRTimeTaskManager;
/*    */ import mzm.gsp.teamplatform.match.PCancelMatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCancelMatch
/*    */   extends __CCancelMatch__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593672;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     MatchNRTimeTaskManager.getInstance().addTask(new PCancelMatch(roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12593672;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof CCancelMatch)) {
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCancelMatch _o_) {
/* 75 */     if (_o_ == this) return 0;
/* 76 */     int _c_ = 0;
/* 77 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\CCancelMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */