/*     */ package mzm.gsp.partneryuanshen;
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
/*     */ 
/*     */ 
/*     */ public class CImproveWithYuanbaoReq
/*     */   extends __CImproveWithYuanbaoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621057;
/*     */   public int position;
/*     */   public long current_yuanbao;
/*     */   public int property_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12621057;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CImproveWithYuanbaoReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CImproveWithYuanbaoReq(int _position_, long _current_yuanbao_, int _property_num_)
/*     */   {
/*  40 */     this.position = _position_;
/*  41 */     this.current_yuanbao = _current_yuanbao_;
/*  42 */     this.property_num = _property_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.position);
/*  51 */     _os_.marshal(this.current_yuanbao);
/*  52 */     _os_.marshal(this.property_num);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.position = _os_.unmarshal_int();
/*  58 */     this.current_yuanbao = _os_.unmarshal_long();
/*  59 */     this.property_num = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CImproveWithYuanbaoReq)) {
/*  69 */       CImproveWithYuanbaoReq _o_ = (CImproveWithYuanbaoReq)_o1_;
/*  70 */       if (this.position != _o_.position) return false;
/*  71 */       if (this.current_yuanbao != _o_.current_yuanbao) return false;
/*  72 */       if (this.property_num != _o_.property_num) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.position;
/*  81 */     _h_ += (int)this.current_yuanbao;
/*  82 */     _h_ += this.property_num;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.position).append(",");
/*  90 */     _sb_.append(this.current_yuanbao).append(",");
/*  91 */     _sb_.append(this.property_num).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CImproveWithYuanbaoReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.position - _o_.position;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.current_yuanbao - _o_.current_yuanbao);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.property_num - _o_.property_num;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\CImproveWithYuanbaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */