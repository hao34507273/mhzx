/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCGetRecallFriendsCountAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRecallFriendsCountAward
/*    */   extends __CGetRecallFriendsCountAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600355;
/*    */   public int award_serial_no;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCGetRecallFriendsCountAward(roleId, this.award_serial_no));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12600355;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRecallFriendsCountAward()
/*    */   {
/* 39 */     this.award_serial_no = 0;
/*    */   }
/*    */   
/*    */   public CGetRecallFriendsCountAward(int _award_serial_no_) {
/* 43 */     this.award_serial_no = _award_serial_no_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.award_serial_no);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.award_serial_no = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CGetRecallFriendsCountAward)) {
/* 66 */       CGetRecallFriendsCountAward _o_ = (CGetRecallFriendsCountAward)_o1_;
/* 67 */       if (this.award_serial_no != _o_.award_serial_no) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.award_serial_no;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.award_serial_no).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRecallFriendsCountAward _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.award_serial_no - _o_.award_serial_no;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CGetRecallFriendsCountAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */