/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SInviteJoinGroupFail
/*    */   extends __SInviteJoinGroupFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605215;
/*    */   public static final int GROUP_NOT_EXIST = 1;
/*    */   public static final int INVITER_NOT_IN_GROUP = 2;
/*    */   public static final int GROUP_MEMBER_FULL = 3;
/*    */   public static final int INVITEE_LEVEL_NOT_ENOUGH = 4;
/*    */   public static final int INVITEE_IN_GROUP = 5;
/*    */   public static final int INVITEE_JOIN_GROUP_TO_LIMIT = 6;
/*    */   public static final int INVITER_AND_INVITEE_ARENOT_FRIENDS = 7;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605215;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SInviteJoinGroupFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SInviteJoinGroupFail(int _res_)
/*    */   {
/* 44 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.res);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.res = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SInviteJoinGroupFail)) {
/* 67 */       SInviteJoinGroupFail _o_ = (SInviteJoinGroupFail)_o1_;
/* 68 */       if (this.res != _o_.res) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.res;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.res).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SInviteJoinGroupFail _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.res - _o_.res;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SInviteJoinGroupFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */