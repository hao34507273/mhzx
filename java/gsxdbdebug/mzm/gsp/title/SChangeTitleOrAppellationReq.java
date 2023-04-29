/*    */ package mzm.gsp.title;
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
/*    */ public class SChangeTitleOrAppellationReq
/*    */   extends __SChangeTitleOrAppellationReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593928;
/*    */   public int changeid;
/*    */   public int changetype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12593928;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeTitleOrAppellationReq() {}
/*    */   
/*    */ 
/*    */   public SChangeTitleOrAppellationReq(int _changeid_, int _changetype_)
/*    */   {
/* 37 */     this.changeid = _changeid_;
/* 38 */     this.changetype = _changetype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.changeid);
/* 47 */     _os_.marshal(this.changetype);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.changeid = _os_.unmarshal_int();
/* 53 */     this.changetype = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SChangeTitleOrAppellationReq)) {
/* 63 */       SChangeTitleOrAppellationReq _o_ = (SChangeTitleOrAppellationReq)_o1_;
/* 64 */       if (this.changeid != _o_.changeid) return false;
/* 65 */       if (this.changetype != _o_.changetype) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.changeid;
/* 74 */     _h_ += this.changetype;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.changeid).append(",");
/* 82 */     _sb_.append(this.changetype).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChangeTitleOrAppellationReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.changeid - _o_.changeid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.changetype - _o_.changetype;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\SChangeTitleOrAppellationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */