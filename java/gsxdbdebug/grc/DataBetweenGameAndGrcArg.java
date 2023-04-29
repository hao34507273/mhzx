/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class DataBetweenGameAndGrcArg implements Marshal
/*     */ {
/*     */   public Octets openid;
/*     */   public Octets channel;
/*     */   public int qtype;
/*     */   public byte data_direction;
/*     */   public Octets info;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public DataBetweenGameAndGrcArg()
/*     */   {
/*  20 */     this.openid = new Octets();
/*  21 */     this.channel = new Octets();
/*  22 */     this.info = new Octets();
/*  23 */     this.reserved1 = 0;
/*  24 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataBetweenGameAndGrcArg(Octets _openid_, Octets _channel_, int _qtype_, byte _data_direction_, Octets _info_, int _reserved1_, int _reserved2_) {
/*  28 */     this.openid = _openid_;
/*  29 */     this.channel = _channel_;
/*  30 */     this.qtype = _qtype_;
/*  31 */     this.data_direction = _data_direction_;
/*  32 */     this.info = _info_;
/*  33 */     this.reserved1 = _reserved1_;
/*  34 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.openid);
/*  43 */     _os_.marshal(this.channel);
/*  44 */     _os_.marshal(this.qtype);
/*  45 */     _os_.marshal(this.data_direction);
/*  46 */     _os_.marshal(this.info);
/*  47 */     _os_.marshal(this.reserved1);
/*  48 */     _os_.marshal(this.reserved2);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.openid = _os_.unmarshal_Octets();
/*  54 */     this.channel = _os_.unmarshal_Octets();
/*  55 */     this.qtype = _os_.unmarshal_int();
/*  56 */     this.data_direction = _os_.unmarshal_byte();
/*  57 */     this.info = _os_.unmarshal_Octets();
/*  58 */     this.reserved1 = _os_.unmarshal_int();
/*  59 */     this.reserved2 = _os_.unmarshal_int();
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof DataBetweenGameAndGrcArg)) {
/*  66 */       DataBetweenGameAndGrcArg _o_ = (DataBetweenGameAndGrcArg)_o1_;
/*  67 */       if (!this.openid.equals(_o_.openid)) return false;
/*  68 */       if (!this.channel.equals(_o_.channel)) return false;
/*  69 */       if (this.qtype != _o_.qtype) return false;
/*  70 */       if (this.data_direction != _o_.data_direction) return false;
/*  71 */       if (!this.info.equals(_o_.info)) return false;
/*  72 */       if (this.reserved1 != _o_.reserved1) return false;
/*  73 */       if (this.reserved2 != _o_.reserved2) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.openid.hashCode();
/*  82 */     _h_ += this.channel.hashCode();
/*  83 */     _h_ += this.qtype;
/*  84 */     _h_ += this.data_direction;
/*  85 */     _h_ += this.info.hashCode();
/*  86 */     _h_ += this.reserved1;
/*  87 */     _h_ += this.reserved2;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append("B").append(this.openid.size()).append(",");
/*  95 */     _sb_.append("B").append(this.channel.size()).append(",");
/*  96 */     _sb_.append(this.qtype).append(",");
/*  97 */     _sb_.append(this.data_direction).append(",");
/*  98 */     _sb_.append("B").append(this.info.size()).append(",");
/*  99 */     _sb_.append(this.reserved1).append(",");
/* 100 */     _sb_.append(this.reserved2).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\DataBetweenGameAndGrcArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */