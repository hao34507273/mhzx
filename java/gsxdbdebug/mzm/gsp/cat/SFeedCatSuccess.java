/*    */ package mzm.gsp.cat;
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
/*    */ 
/*    */ 
/*    */ public class SFeedCatSuccess
/*    */   extends __SFeedCatSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605715;
/*    */   public long target_roleid;
/*    */   public long catid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605715;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFeedCatSuccess() {}
/*    */   
/*    */ 
/*    */   public SFeedCatSuccess(long _target_roleid_, long _catid_)
/*    */   {
/* 37 */     this.target_roleid = _target_roleid_;
/* 38 */     this.catid = _catid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.target_roleid);
/* 47 */     _os_.marshal(this.catid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.target_roleid = _os_.unmarshal_long();
/* 53 */     this.catid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SFeedCatSuccess)) {
/* 63 */       SFeedCatSuccess _o_ = (SFeedCatSuccess)_o1_;
/* 64 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 65 */       if (this.catid != _o_.catid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.target_roleid;
/* 74 */     _h_ += (int)this.catid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.target_roleid).append(",");
/* 82 */     _sb_.append(this.catid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFeedCatSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.catid - _o_.catid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SFeedCatSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */