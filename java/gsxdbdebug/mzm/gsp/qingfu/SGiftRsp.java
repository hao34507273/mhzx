/*     */ package mzm.gsp.qingfu;
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
/*     */ public class SGiftRsp
/*     */   extends __SGiftRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588838;
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
/*  27 */     return 12588838;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGiftRsp()
/*     */   {
/*  37 */     this.receiver_gift_info = new ReceiverGiftInfo();
/*     */   }
/*     */   
/*     */   public SGiftRsp(int _activity_id_, int _gift_bag_cfg_id_, int _send_available_, long _receiver_id_, ReceiverGiftInfo _receiver_gift_info_) {
/*  41 */     this.activity_id = _activity_id_;
/*  42 */     this.gift_bag_cfg_id = _gift_bag_cfg_id_;
/*  43 */     this.send_available = _send_available_;
/*  44 */     this.receiver_id = _receiver_id_;
/*  45 */     this.receiver_gift_info = _receiver_gift_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     if (!this.receiver_gift_info._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     _os_.marshal(this.gift_bag_cfg_id);
/*  56 */     _os_.marshal(this.send_available);
/*  57 */     _os_.marshal(this.receiver_id);
/*  58 */     _os_.marshal(this.receiver_gift_info);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activity_id = _os_.unmarshal_int();
/*  64 */     this.gift_bag_cfg_id = _os_.unmarshal_int();
/*  65 */     this.send_available = _os_.unmarshal_int();
/*  66 */     this.receiver_id = _os_.unmarshal_long();
/*  67 */     this.receiver_gift_info.unmarshal(_os_);
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SGiftRsp)) {
/*  77 */       SGiftRsp _o_ = (SGiftRsp)_o1_;
/*  78 */       if (this.activity_id != _o_.activity_id) return false;
/*  79 */       if (this.gift_bag_cfg_id != _o_.gift_bag_cfg_id) return false;
/*  80 */       if (this.send_available != _o_.send_available) return false;
/*  81 */       if (this.receiver_id != _o_.receiver_id) return false;
/*  82 */       if (!this.receiver_gift_info.equals(_o_.receiver_gift_info)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.activity_id;
/*  91 */     _h_ += this.gift_bag_cfg_id;
/*  92 */     _h_ += this.send_available;
/*  93 */     _h_ += (int)this.receiver_id;
/*  94 */     _h_ += this.receiver_gift_info.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.activity_id).append(",");
/* 102 */     _sb_.append(this.gift_bag_cfg_id).append(",");
/* 103 */     _sb_.append(this.send_available).append(",");
/* 104 */     _sb_.append(this.receiver_id).append(",");
/* 105 */     _sb_.append(this.receiver_gift_info).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGiftRsp _o_) {
/* 111 */     if (_o_ == this) return 0;
/* 112 */     int _c_ = 0;
/* 113 */     _c_ = this.activity_id - _o_.activity_id;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.gift_bag_cfg_id - _o_.gift_bag_cfg_id;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.send_available - _o_.send_available;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = Long.signum(this.receiver_id - _o_.receiver_id);
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.receiver_gift_info.compareTo(_o_.receiver_gift_info);
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGiftRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */