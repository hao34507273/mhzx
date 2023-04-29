/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.marriage.main.PCSendGiftToFriend;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSendGiftToFriend
/*    */   extends __CSendGiftToFriend__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599809;
/*    */   public long roleid;
/*    */   public int giftid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long operatorRoleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(operatorRoleid, new PCSendGiftToFriend(operatorRoleid, this.roleid, this.giftid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12599809;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSendGiftToFriend() {}
/*    */   
/*    */ 
/*    */   public CSendGiftToFriend(long _roleid_, int _giftid_)
/*    */   {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.giftid = _giftid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     _os_.marshal(this.giftid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.roleid = _os_.unmarshal_long();
/* 54 */     this.giftid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CSendGiftToFriend)) {
/* 64 */       CSendGiftToFriend _o_ = (CSendGiftToFriend)_o1_;
/* 65 */       if (this.roleid != _o_.roleid) return false;
/* 66 */       if (this.giftid != _o_.giftid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     _h_ += this.giftid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append(this.giftid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSendGiftToFriend _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.giftid - _o_.giftid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\CSendGiftToFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */