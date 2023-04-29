/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GrcSendGiftArg implements Marshal
/*     */ {
/*     */   public Octets from_account;
/*     */   public Octets to_openid;
/*     */   public int gift_type;
/*     */   public int gift_count;
/*     */   public int max_send_times_everyday;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcSendGiftArg()
/*     */   {
/*  20 */     this.from_account = new Octets();
/*  21 */     this.to_openid = new Octets();
/*  22 */     this.gift_type = 1;
/*  23 */     this.reserved1 = 0;
/*  24 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcSendGiftArg(Octets _from_account_, Octets _to_openid_, int _gift_type_, int _gift_count_, int _max_send_times_everyday_, int _reserved1_, int _reserved2_) {
/*  28 */     this.from_account = _from_account_;
/*  29 */     this.to_openid = _to_openid_;
/*  30 */     this.gift_type = _gift_type_;
/*  31 */     this.gift_count = _gift_count_;
/*  32 */     this.max_send_times_everyday = _max_send_times_everyday_;
/*  33 */     this.reserved1 = _reserved1_;
/*  34 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.from_account);
/*  43 */     _os_.marshal(this.to_openid);
/*  44 */     _os_.marshal(this.gift_type);
/*  45 */     _os_.marshal(this.gift_count);
/*  46 */     _os_.marshal(this.max_send_times_everyday);
/*  47 */     _os_.marshal(this.reserved1);
/*  48 */     _os_.marshal(this.reserved2);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.from_account = _os_.unmarshal_Octets();
/*  54 */     this.to_openid = _os_.unmarshal_Octets();
/*  55 */     this.gift_type = _os_.unmarshal_int();
/*  56 */     this.gift_count = _os_.unmarshal_int();
/*  57 */     this.max_send_times_everyday = _os_.unmarshal_int();
/*  58 */     this.reserved1 = _os_.unmarshal_int();
/*  59 */     this.reserved2 = _os_.unmarshal_int();
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof GrcSendGiftArg)) {
/*  66 */       GrcSendGiftArg _o_ = (GrcSendGiftArg)_o1_;
/*  67 */       if (!this.from_account.equals(_o_.from_account)) return false;
/*  68 */       if (!this.to_openid.equals(_o_.to_openid)) return false;
/*  69 */       if (this.gift_type != _o_.gift_type) return false;
/*  70 */       if (this.gift_count != _o_.gift_count) return false;
/*  71 */       if (this.max_send_times_everyday != _o_.max_send_times_everyday) return false;
/*  72 */       if (this.reserved1 != _o_.reserved1) return false;
/*  73 */       if (this.reserved2 != _o_.reserved2) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.from_account.hashCode();
/*  82 */     _h_ += this.to_openid.hashCode();
/*  83 */     _h_ += this.gift_type;
/*  84 */     _h_ += this.gift_count;
/*  85 */     _h_ += this.max_send_times_everyday;
/*  86 */     _h_ += this.reserved1;
/*  87 */     _h_ += this.reserved2;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append("B").append(this.from_account.size()).append(",");
/*  95 */     _sb_.append("B").append(this.to_openid.size()).append(",");
/*  96 */     _sb_.append(this.gift_type).append(",");
/*  97 */     _sb_.append(this.gift_count).append(",");
/*  98 */     _sb_.append(this.max_send_times_everyday).append(",");
/*  99 */     _sb_.append(this.reserved1).append(",");
/* 100 */     _sb_.append(this.reserved2).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcSendGiftArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */