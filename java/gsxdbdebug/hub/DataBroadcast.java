/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class DataBroadcast extends __DataBroadcast__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 14010;
/*     */   public static final int DIRECTION_GAME_SERVER_TO_GAME_SERVER = 0;
/*     */   public static final int DIRECTION_DELIVERY_SERVER_TO_DELIVERY_SERVER = 1;
/*     */   public static final int DIRECTION_MATCH_SERVER_TO_MATCH_SERVER = 2;
/*     */   public static final int DIRECTION_GAME_SERVER_TO_DELIVERY_SERVER = 3;
/*     */   public static final int DIRECTION_DELIVERY_SERVER_TO_GAME_SERVER = 4;
/*     */   public static final int DIRECTION_GAME_SERVER_TO_MATCH_SERVER = 5;
/*     */   public static final int DIRECTION_MATCH_SERVER_TO_GAME_SERVER = 6;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     GHubBroadcastManager.getInstance().dispatch(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 14010;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int DIRECTION_DELIVERY_SERVER_TO_MATCH_SERVER = 7;
/*     */   
/*     */   public static final int DIRECTION_MATCH_SERVER_TO_DELIVERY_SERVER = 8;
/*     */   
/*     */   public byte direction;
/*     */   
/*     */   public int seq;
/*     */   
/*     */   public int src_id;
/*     */   
/*     */   public int data_type;
/*     */   
/*     */   public Octets data;
/*     */   
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   public DataBroadcast()
/*     */   {
/*  49 */     this.direction = 0;
/*  50 */     this.data = new Octets();
/*  51 */     this.reserved1 = 0;
/*  52 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataBroadcast(byte _direction_, int _seq_, int _src_id_, int _data_type_, Octets _data_, int _reserved1_, int _reserved2_) {
/*  56 */     this.direction = _direction_;
/*  57 */     this.seq = _seq_;
/*  58 */     this.src_id = _src_id_;
/*  59 */     this.data_type = _data_type_;
/*  60 */     this.data = _data_;
/*  61 */     this.reserved1 = _reserved1_;
/*  62 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  70 */     _os_.marshal(this.direction);
/*  71 */     _os_.marshal(this.seq);
/*  72 */     _os_.marshal(this.src_id);
/*  73 */     _os_.marshal(this.data_type);
/*  74 */     _os_.marshal(this.data);
/*  75 */     _os_.marshal(this.reserved1);
/*  76 */     _os_.marshal(this.reserved2);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  81 */     this.direction = _os_.unmarshal_byte();
/*  82 */     this.seq = _os_.unmarshal_int();
/*  83 */     this.src_id = _os_.unmarshal_int();
/*  84 */     this.data_type = _os_.unmarshal_int();
/*  85 */     this.data = _os_.unmarshal_Octets();
/*  86 */     this.reserved1 = _os_.unmarshal_int();
/*  87 */     this.reserved2 = _os_.unmarshal_int();
/*  88 */     if (!_validator_()) {
/*  89 */       throw new VerifyError("validator failed");
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof DataBroadcast)) {
/*  97 */       DataBroadcast _o_ = (DataBroadcast)_o1_;
/*  98 */       if (this.direction != _o_.direction) return false;
/*  99 */       if (this.seq != _o_.seq) return false;
/* 100 */       if (this.src_id != _o_.src_id) return false;
/* 101 */       if (this.data_type != _o_.data_type) return false;
/* 102 */       if (!this.data.equals(_o_.data)) return false;
/* 103 */       if (this.reserved1 != _o_.reserved1) return false;
/* 104 */       if (this.reserved2 != _o_.reserved2) return false;
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 111 */     int _h_ = 0;
/* 112 */     _h_ += this.direction;
/* 113 */     _h_ += this.seq;
/* 114 */     _h_ += this.src_id;
/* 115 */     _h_ += this.data_type;
/* 116 */     _h_ += this.data.hashCode();
/* 117 */     _h_ += this.reserved1;
/* 118 */     _h_ += this.reserved2;
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.direction).append(",");
/* 126 */     _sb_.append(this.seq).append(",");
/* 127 */     _sb_.append(this.src_id).append(",");
/* 128 */     _sb_.append(this.data_type).append(",");
/* 129 */     _sb_.append("B").append(this.data.size()).append(",");
/* 130 */     _sb_.append(this.reserved1).append(",");
/* 131 */     _sb_.append(this.reserved2).append(",");
/* 132 */     _sb_.append(")");
/* 133 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataBroadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */