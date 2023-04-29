/*    */ package mzm.gsp.partner;
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
/*    */ public class SChangeZhenFaReq
/*    */   extends __SChangeZhenFaReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588035;
/*    */   public int lineupnum;
/*    */   public int zhenfaid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588035;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeZhenFaReq() {}
/*    */   
/*    */ 
/*    */   public SChangeZhenFaReq(int _lineupnum_, int _zhenfaid_)
/*    */   {
/* 37 */     this.lineupnum = _lineupnum_;
/* 38 */     this.zhenfaid = _zhenfaid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.lineupnum);
/* 47 */     _os_.marshal(this.zhenfaid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.lineupnum = _os_.unmarshal_int();
/* 53 */     this.zhenfaid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SChangeZhenFaReq)) {
/* 63 */       SChangeZhenFaReq _o_ = (SChangeZhenFaReq)_o1_;
/* 64 */       if (this.lineupnum != _o_.lineupnum) return false;
/* 65 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.lineupnum;
/* 74 */     _h_ += this.zhenfaid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.lineupnum).append(",");
/* 82 */     _sb_.append(this.zhenfaid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChangeZhenFaReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.lineupnum - _o_.lineupnum;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.zhenfaid - _o_.zhenfaid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SChangeZhenFaReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */