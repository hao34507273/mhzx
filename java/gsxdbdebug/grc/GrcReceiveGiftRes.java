/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class GrcReceiveGiftRes
/*     */   implements Marshal, Comparable<GrcReceiveGiftRes>
/*     */ {
/*     */   public int retcode;
/*     */   public int gift_count;
/*     */   public int receive_times;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcReceiveGiftRes()
/*     */   {
/*  18 */     this.retcode = 9;
/*  19 */     this.reserved1 = 0;
/*  20 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcReceiveGiftRes(int _retcode_, int _gift_count_, int _receive_times_, int _reserved1_, int _reserved2_) {
/*  24 */     this.retcode = _retcode_;
/*  25 */     this.gift_count = _gift_count_;
/*  26 */     this.receive_times = _receive_times_;
/*  27 */     this.reserved1 = _reserved1_;
/*  28 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  36 */     _os_.marshal(this.retcode);
/*  37 */     _os_.marshal(this.gift_count);
/*  38 */     _os_.marshal(this.receive_times);
/*  39 */     _os_.marshal(this.reserved1);
/*  40 */     _os_.marshal(this.reserved2);
/*  41 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  45 */     this.retcode = _os_.unmarshal_int();
/*  46 */     this.gift_count = _os_.unmarshal_int();
/*  47 */     this.receive_times = _os_.unmarshal_int();
/*  48 */     this.reserved1 = _os_.unmarshal_int();
/*  49 */     this.reserved2 = _os_.unmarshal_int();
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  54 */     if (_o1_ == this) return true;
/*  55 */     if ((_o1_ instanceof GrcReceiveGiftRes)) {
/*  56 */       GrcReceiveGiftRes _o_ = (GrcReceiveGiftRes)_o1_;
/*  57 */       if (this.retcode != _o_.retcode) return false;
/*  58 */       if (this.gift_count != _o_.gift_count) return false;
/*  59 */       if (this.receive_times != _o_.receive_times) return false;
/*  60 */       if (this.reserved1 != _o_.reserved1) return false;
/*  61 */       if (this.reserved2 != _o_.reserved2) return false;
/*  62 */       return true;
/*     */     }
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  68 */     int _h_ = 0;
/*  69 */     _h_ += this.retcode;
/*  70 */     _h_ += this.gift_count;
/*  71 */     _h_ += this.receive_times;
/*  72 */     _h_ += this.reserved1;
/*  73 */     _h_ += this.reserved2;
/*  74 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  78 */     StringBuilder _sb_ = new StringBuilder();
/*  79 */     _sb_.append("(");
/*  80 */     _sb_.append(this.retcode).append(",");
/*  81 */     _sb_.append(this.gift_count).append(",");
/*  82 */     _sb_.append(this.receive_times).append(",");
/*  83 */     _sb_.append(this.reserved1).append(",");
/*  84 */     _sb_.append(this.reserved2).append(",");
/*  85 */     _sb_.append(")");
/*  86 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(GrcReceiveGiftRes _o_) {
/*  90 */     if (_o_ == this) return 0;
/*  91 */     int _c_ = 0;
/*  92 */     _c_ = this.retcode - _o_.retcode;
/*  93 */     if (0 != _c_) return _c_;
/*  94 */     _c_ = this.gift_count - _o_.gift_count;
/*  95 */     if (0 != _c_) return _c_;
/*  96 */     _c_ = this.receive_times - _o_.receive_times;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.reserved1 - _o_.reserved1;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.reserved2 - _o_.reserved2;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceiveGiftRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */