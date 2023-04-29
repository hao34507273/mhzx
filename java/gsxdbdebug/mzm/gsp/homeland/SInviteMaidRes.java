/*    */ package mzm.gsp.homeland;
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
/*    */ public class SInviteMaidRes
/*    */   extends __SInviteMaidRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605456;
/*    */   public long maiduuid;
/*    */   public MaidInfo maidinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605456;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SInviteMaidRes()
/*    */   {
/* 32 */     this.maidinfo = new MaidInfo();
/*    */   }
/*    */   
/*    */   public SInviteMaidRes(long _maiduuid_, MaidInfo _maidinfo_) {
/* 36 */     this.maiduuid = _maiduuid_;
/* 37 */     this.maidinfo = _maidinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.maidinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.maiduuid);
/* 47 */     _os_.marshal(this.maidinfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.maiduuid = _os_.unmarshal_long();
/* 53 */     this.maidinfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SInviteMaidRes)) {
/* 63 */       SInviteMaidRes _o_ = (SInviteMaidRes)_o1_;
/* 64 */       if (this.maiduuid != _o_.maiduuid) return false;
/* 65 */       if (!this.maidinfo.equals(_o_.maidinfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.maiduuid;
/* 74 */     _h_ += this.maidinfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.maiduuid).append(",");
/* 82 */     _sb_.append(this.maidinfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SInviteMaidRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */