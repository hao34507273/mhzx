/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCGetGrcFriendsCountAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetGrcFriendsCountAward
/*    */   extends __CGetGrcFriendsCountAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600330;
/*    */   public int award_serial_no;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGetGrcFriendsCountAward(roleId, this.award_serial_no));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12600330;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetGrcFriendsCountAward()
/*    */   {
/* 38 */     this.award_serial_no = 0;
/*    */   }
/*    */   
/*    */   public CGetGrcFriendsCountAward(int _award_serial_no_) {
/* 42 */     this.award_serial_no = _award_serial_no_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.award_serial_no);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.award_serial_no = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGetGrcFriendsCountAward)) {
/* 65 */       CGetGrcFriendsCountAward _o_ = (CGetGrcFriendsCountAward)_o1_;
/* 66 */       if (this.award_serial_no != _o_.award_serial_no) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.award_serial_no;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.award_serial_no).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetGrcFriendsCountAward _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.award_serial_no - _o_.award_serial_no;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CGetGrcFriendsCountAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */