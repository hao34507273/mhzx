/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCGetRecallFriendSignAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRecallFriendSignAward
/*    */   extends __CGetRecallFriendSignAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600364;
/*    */   public int sign_day;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCGetRecallFriendSignAward(roleId, this.sign_day));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12600364;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRecallFriendSignAward() {}
/*    */   
/*    */ 
/*    */   public CGetRecallFriendSignAward(int _sign_day_)
/*    */   {
/* 42 */     this.sign_day = _sign_day_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.sign_day);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.sign_day = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGetRecallFriendSignAward)) {
/* 65 */       CGetRecallFriendSignAward _o_ = (CGetRecallFriendSignAward)_o1_;
/* 66 */       if (this.sign_day != _o_.sign_day) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.sign_day;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.sign_day).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRecallFriendSignAward _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.sign_day - _o_.sign_day;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CGetRecallFriendSignAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */