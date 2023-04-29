/*     */ package mzm.gsp.qingfu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SGiftError
/*     */   extends __SGiftError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588839;
/*     */   public static final int RECEIVER_REACH_MAX = 1;
/*     */   public static final int SENDER_REACH_MAX = 2;
/*     */   public static final int P2P_REACH_MAX = 3;
/*     */   public static final int INTIMACY_LOW = 4;
/*     */   public static final int SEND_MAIL_FAIL = 5;
/*     */   public static final int MONEY_NOT_ENOUGH = 6;
/*     */   public int code;
/*     */   public int activity_id;
/*     */   public int gift_bag_cfg_id;
/*     */   public int send_available;
/*     */   public long receiver_id;
/*     */   public ReceiverGiftInfo receiver_gift_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588839;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   public SGiftError()
/*     */   {
/*  45 */     this.receiver_gift_info = new ReceiverGiftInfo();
/*     */   }
/*     */   
/*     */   public SGiftError(int _code_, int _activity_id_, int _gift_bag_cfg_id_, int _send_available_, long _receiver_id_, ReceiverGiftInfo _receiver_gift_info_) {
/*  49 */     this.code = _code_;
/*  50 */     this.activity_id = _activity_id_;
/*  51 */     this.gift_bag_cfg_id = _gift_bag_cfg_id_;
/*  52 */     this.send_available = _send_available_;
/*  53 */     this.receiver_id = _receiver_id_;
/*  54 */     this.receiver_gift_info = _receiver_gift_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     if (!this.receiver_gift_info._validator_()) return false;
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.code);
/*  64 */     _os_.marshal(this.activity_id);
/*  65 */     _os_.marshal(this.gift_bag_cfg_id);
/*  66 */     _os_.marshal(this.send_available);
/*  67 */     _os_.marshal(this.receiver_id);
/*  68 */     _os_.marshal(this.receiver_gift_info);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     this.code = _os_.unmarshal_int();
/*  74 */     this.activity_id = _os_.unmarshal_int();
/*  75 */     this.gift_bag_cfg_id = _os_.unmarshal_int();
/*  76 */     this.send_available = _os_.unmarshal_int();
/*  77 */     this.receiver_id = _os_.unmarshal_long();
/*  78 */     this.receiver_gift_info.unmarshal(_os_);
/*  79 */     if (!_validator_()) {
/*  80 */       throw new VerifyError("validator failed");
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof SGiftError)) {
/*  88 */       SGiftError _o_ = (SGiftError)_o1_;
/*  89 */       if (this.code != _o_.code) return false;
/*  90 */       if (this.activity_id != _o_.activity_id) return false;
/*  91 */       if (this.gift_bag_cfg_id != _o_.gift_bag_cfg_id) return false;
/*  92 */       if (this.send_available != _o_.send_available) return false;
/*  93 */       if (this.receiver_id != _o_.receiver_id) return false;
/*  94 */       if (!this.receiver_gift_info.equals(_o_.receiver_gift_info)) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += this.code;
/* 103 */     _h_ += this.activity_id;
/* 104 */     _h_ += this.gift_bag_cfg_id;
/* 105 */     _h_ += this.send_available;
/* 106 */     _h_ += (int)this.receiver_id;
/* 107 */     _h_ += this.receiver_gift_info.hashCode();
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append(this.code).append(",");
/* 115 */     _sb_.append(this.activity_id).append(",");
/* 116 */     _sb_.append(this.gift_bag_cfg_id).append(",");
/* 117 */     _sb_.append(this.send_available).append(",");
/* 118 */     _sb_.append(this.receiver_id).append(",");
/* 119 */     _sb_.append(this.receiver_gift_info).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGiftError _o_) {
/* 125 */     if (_o_ == this) return 0;
/* 126 */     int _c_ = 0;
/* 127 */     _c_ = this.code - _o_.code;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.activity_id - _o_.activity_id;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.gift_bag_cfg_id - _o_.gift_bag_cfg_id;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = this.send_available - _o_.send_available;
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     _c_ = Long.signum(this.receiver_id - _o_.receiver_id);
/* 136 */     if (0 != _c_) return _c_;
/* 137 */     _c_ = this.receiver_gift_info.compareTo(_o_.receiver_gift_info);
/* 138 */     if (0 != _c_) return _c_;
/* 139 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGiftError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */