/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GrcReceiveGiftArg implements Marshal
/*     */ {
/*     */   public Octets to_account;
/*     */   public long to_roleid;
/*     */   public int gift_type;
/*     */   public long serialid;
/*     */   public int max_receive_times_everyday;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcReceiveGiftArg()
/*     */   {
/*  20 */     this.to_account = new Octets();
/*  21 */     this.gift_type = 1;
/*  22 */     this.reserved1 = 0;
/*  23 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcReceiveGiftArg(Octets _to_account_, long _to_roleid_, int _gift_type_, long _serialid_, int _max_receive_times_everyday_, int _reserved1_, int _reserved2_) {
/*  27 */     this.to_account = _to_account_;
/*  28 */     this.to_roleid = _to_roleid_;
/*  29 */     this.gift_type = _gift_type_;
/*  30 */     this.serialid = _serialid_;
/*  31 */     this.max_receive_times_everyday = _max_receive_times_everyday_;
/*  32 */     this.reserved1 = _reserved1_;
/*  33 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.to_account);
/*  42 */     _os_.marshal(this.to_roleid);
/*  43 */     _os_.marshal(this.gift_type);
/*  44 */     _os_.marshal(this.serialid);
/*  45 */     _os_.marshal(this.max_receive_times_everyday);
/*  46 */     _os_.marshal(this.reserved1);
/*  47 */     _os_.marshal(this.reserved2);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  52 */     this.to_account = _os_.unmarshal_Octets();
/*  53 */     this.to_roleid = _os_.unmarshal_long();
/*  54 */     this.gift_type = _os_.unmarshal_int();
/*  55 */     this.serialid = _os_.unmarshal_long();
/*  56 */     this.max_receive_times_everyday = _os_.unmarshal_int();
/*  57 */     this.reserved1 = _os_.unmarshal_int();
/*  58 */     this.reserved2 = _os_.unmarshal_int();
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof GrcReceiveGiftArg)) {
/*  65 */       GrcReceiveGiftArg _o_ = (GrcReceiveGiftArg)_o1_;
/*  66 */       if (!this.to_account.equals(_o_.to_account)) return false;
/*  67 */       if (this.to_roleid != _o_.to_roleid) return false;
/*  68 */       if (this.gift_type != _o_.gift_type) return false;
/*  69 */       if (this.serialid != _o_.serialid) return false;
/*  70 */       if (this.max_receive_times_everyday != _o_.max_receive_times_everyday) return false;
/*  71 */       if (this.reserved1 != _o_.reserved1) return false;
/*  72 */       if (this.reserved2 != _o_.reserved2) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.to_account.hashCode();
/*  81 */     _h_ += (int)this.to_roleid;
/*  82 */     _h_ += this.gift_type;
/*  83 */     _h_ += (int)this.serialid;
/*  84 */     _h_ += this.max_receive_times_everyday;
/*  85 */     _h_ += this.reserved1;
/*  86 */     _h_ += this.reserved2;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append("B").append(this.to_account.size()).append(",");
/*  94 */     _sb_.append(this.to_roleid).append(",");
/*  95 */     _sb_.append(this.gift_type).append(",");
/*  96 */     _sb_.append(this.serialid).append(",");
/*  97 */     _sb_.append(this.max_receive_times_everyday).append(",");
/*  98 */     _sb_.append(this.reserved1).append(",");
/*  99 */     _sb_.append(this.reserved2).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceiveGiftArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */