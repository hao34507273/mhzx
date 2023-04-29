/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynFriendOccupation
/*    */   extends __SSynFriendOccupation__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587037;
/*    */   public long friendid;
/*    */   public int occupationid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587037;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynFriendOccupation() {}
/*    */   
/*    */ 
/*    */   public SSynFriendOccupation(long _friendid_, int _occupationid_)
/*    */   {
/* 35 */     this.friendid = _friendid_;
/* 36 */     this.occupationid = _occupationid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.friendid);
/* 45 */     _os_.marshal(this.occupationid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.friendid = _os_.unmarshal_long();
/* 51 */     this.occupationid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynFriendOccupation)) {
/* 61 */       SSynFriendOccupation _o_ = (SSynFriendOccupation)_o1_;
/* 62 */       if (this.friendid != _o_.friendid) return false;
/* 63 */       if (this.occupationid != _o_.occupationid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.friendid;
/* 72 */     _h_ += this.occupationid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.friendid).append(",");
/* 80 */     _sb_.append(this.occupationid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynFriendOccupation _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.occupationid - _o_.occupationid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynFriendOccupation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */