/*     */ package mzm.gsp.mibao;
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
/*     */ public class SGetMiBaoInfo
/*     */   extends __SGetMiBaoInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603393;
/*     */   public int current_lucky_value;
/*     */   public int current_score;
/*     */   public int current_mibao_index_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603393;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetMiBaoInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetMiBaoInfo(int _current_lucky_value_, int _current_score_, int _current_mibao_index_id_)
/*     */   {
/*  38 */     this.current_lucky_value = _current_lucky_value_;
/*  39 */     this.current_score = _current_score_;
/*  40 */     this.current_mibao_index_id = _current_mibao_index_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.current_lucky_value);
/*  49 */     _os_.marshal(this.current_score);
/*  50 */     _os_.marshal(this.current_mibao_index_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.current_lucky_value = _os_.unmarshal_int();
/*  56 */     this.current_score = _os_.unmarshal_int();
/*  57 */     this.current_mibao_index_id = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetMiBaoInfo)) {
/*  67 */       SGetMiBaoInfo _o_ = (SGetMiBaoInfo)_o1_;
/*  68 */       if (this.current_lucky_value != _o_.current_lucky_value) return false;
/*  69 */       if (this.current_score != _o_.current_score) return false;
/*  70 */       if (this.current_mibao_index_id != _o_.current_mibao_index_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.current_lucky_value;
/*  79 */     _h_ += this.current_score;
/*  80 */     _h_ += this.current_mibao_index_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.current_lucky_value).append(",");
/*  88 */     _sb_.append(this.current_score).append(",");
/*  89 */     _sb_.append(this.current_mibao_index_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetMiBaoInfo _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.current_lucky_value - _o_.current_lucky_value;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.current_score - _o_.current_score;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.current_mibao_index_id - _o_.current_mibao_index_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\SGetMiBaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */