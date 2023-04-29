/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRenewalFashionError
/*    */   extends __SRenewalFashionError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609435;
/*    */   public static final int ITEM_NOT_EXIST = 1;
/*    */   public static final int FASHION_NOT_EXIST = 2;
/*    */   public static final int TYPE_NOT_MATCH = 3;
/*    */   public static final int NEVER_EXPIRE = 4;
/*    */   public int errorcode;
/*    */   public int fashioncfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12609435;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRenewalFashionError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRenewalFashionError(int _errorcode_, int _fashioncfgid_)
/*    */   {
/* 40 */     this.errorcode = _errorcode_;
/* 41 */     this.fashioncfgid = _fashioncfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.errorcode);
/* 50 */     _os_.marshal(this.fashioncfgid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.errorcode = _os_.unmarshal_int();
/* 56 */     this.fashioncfgid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SRenewalFashionError)) {
/* 66 */       SRenewalFashionError _o_ = (SRenewalFashionError)_o1_;
/* 67 */       if (this.errorcode != _o_.errorcode) return false;
/* 68 */       if (this.fashioncfgid != _o_.fashioncfgid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.errorcode;
/* 77 */     _h_ += this.fashioncfgid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.errorcode).append(",");
/* 85 */     _sb_.append(this.fashioncfgid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRenewalFashionError _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.errorcode - _o_.errorcode;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.fashioncfgid - _o_.fashioncfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SRenewalFashionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */