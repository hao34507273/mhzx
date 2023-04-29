/*     */ package mzm.gsp.floor;
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
/*     */ public class SFloorHelpTip
/*     */   extends __SFloorHelpTip__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617750;
/*     */   public int from;
/*     */   public int to;
/*     */   public int lefthelpcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617750;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SFloorHelpTip() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFloorHelpTip(int _from_, int _to_, int _lefthelpcount_)
/*     */   {
/*  38 */     this.from = _from_;
/*  39 */     this.to = _to_;
/*  40 */     this.lefthelpcount = _lefthelpcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.from);
/*  49 */     _os_.marshal(this.to);
/*  50 */     _os_.marshal(this.lefthelpcount);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.from = _os_.unmarshal_int();
/*  56 */     this.to = _os_.unmarshal_int();
/*  57 */     this.lefthelpcount = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SFloorHelpTip)) {
/*  67 */       SFloorHelpTip _o_ = (SFloorHelpTip)_o1_;
/*  68 */       if (this.from != _o_.from) return false;
/*  69 */       if (this.to != _o_.to) return false;
/*  70 */       if (this.lefthelpcount != _o_.lefthelpcount) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.from;
/*  79 */     _h_ += this.to;
/*  80 */     _h_ += this.lefthelpcount;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.from).append(",");
/*  88 */     _sb_.append(this.to).append(",");
/*  89 */     _sb_.append(this.lefthelpcount).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFloorHelpTip _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.from - _o_.from;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.to - _o_.to;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.lefthelpcount - _o_.lefthelpcount;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\SFloorHelpTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */