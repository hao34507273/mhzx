/*    */ package mzm.gsp.item;
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
/*    */ public class SExtendBagRes
/*    */   extends __SExtendBagRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584722;
/*    */   public int bagid;
/*    */   public int capcity;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584722;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SExtendBagRes() {}
/*    */   
/*    */ 
/*    */   public SExtendBagRes(int _bagid_, int _capcity_)
/*    */   {
/* 35 */     this.bagid = _bagid_;
/* 36 */     this.capcity = _capcity_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.bagid);
/* 45 */     _os_.marshal(this.capcity);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.bagid = _os_.unmarshal_int();
/* 51 */     this.capcity = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SExtendBagRes)) {
/* 61 */       SExtendBagRes _o_ = (SExtendBagRes)_o1_;
/* 62 */       if (this.bagid != _o_.bagid) return false;
/* 63 */       if (this.capcity != _o_.capcity) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.bagid;
/* 72 */     _h_ += this.capcity;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.bagid).append(",");
/* 80 */     _sb_.append(this.capcity).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SExtendBagRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.bagid - _o_.bagid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.capcity - _o_.capcity;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SExtendBagRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */