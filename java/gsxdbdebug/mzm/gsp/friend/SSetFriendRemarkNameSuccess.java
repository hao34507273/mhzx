/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSetFriendRemarkNameSuccess
/*    */   extends __SSetFriendRemarkNameSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587042;
/*    */   public long friendid;
/*    */   public Octets remarkname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587042;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSetFriendRemarkNameSuccess()
/*    */   {
/* 34 */     this.remarkname = new Octets();
/*    */   }
/*    */   
/*    */   public SSetFriendRemarkNameSuccess(long _friendid_, Octets _remarkname_) {
/* 38 */     this.friendid = _friendid_;
/* 39 */     this.remarkname = _remarkname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.friendid);
/* 48 */     _os_.marshal(this.remarkname);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.friendid = _os_.unmarshal_long();
/* 54 */     this.remarkname = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSetFriendRemarkNameSuccess)) {
/* 64 */       SSetFriendRemarkNameSuccess _o_ = (SSetFriendRemarkNameSuccess)_o1_;
/* 65 */       if (this.friendid != _o_.friendid) return false;
/* 66 */       if (!this.remarkname.equals(_o_.remarkname)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.friendid;
/* 75 */     _h_ += this.remarkname.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.friendid).append(",");
/* 83 */     _sb_.append("B").append(this.remarkname.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSetFriendRemarkNameSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */