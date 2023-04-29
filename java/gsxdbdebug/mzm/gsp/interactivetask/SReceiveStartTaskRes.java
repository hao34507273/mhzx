/*     */ package mzm.gsp.interactivetask;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SReceiveStartTaskRes
/*     */   extends __SReceiveStartTaskRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12610318;
/*     */   public int result;
/*     */   public int typeid;
/*     */   public int graphid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12610318;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SReceiveStartTaskRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SReceiveStartTaskRes(int _result_, int _typeid_, int _graphid_)
/*     */   {
/*  38 */     this.result = _result_;
/*  39 */     this.typeid = _typeid_;
/*  40 */     this.graphid = _graphid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.result);
/*  49 */     _os_.marshal(this.typeid);
/*  50 */     _os_.marshal(this.graphid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.result = _os_.unmarshal_int();
/*  56 */     this.typeid = _os_.unmarshal_int();
/*  57 */     this.graphid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SReceiveStartTaskRes)) {
/*  67 */       SReceiveStartTaskRes _o_ = (SReceiveStartTaskRes)_o1_;
/*  68 */       if (this.result != _o_.result) return false;
/*  69 */       if (this.typeid != _o_.typeid) return false;
/*  70 */       if (this.graphid != _o_.graphid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.result;
/*  79 */     _h_ += this.typeid;
/*  80 */     _h_ += this.graphid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.result).append(",");
/*  88 */     _sb_.append(this.typeid).append(",");
/*  89 */     _sb_.append(this.graphid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SReceiveStartTaskRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.result - _o_.result;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.typeid - _o_.typeid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.graphid - _o_.graphid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\SReceiveStartTaskRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */