/*     */ package mzm.gsp.qingfu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetGiftInfoRsp
/*     */   extends __SGetGiftInfoRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588841;
/*     */   public int activity_id;
/*     */   public int gift_bag_cfg_id;
/*     */   public int send_available;
/*     */   public HashMap<Long, ReceiverGiftInfo> receiver_gift_info_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588841;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetGiftInfoRsp()
/*     */   {
/*  36 */     this.receiver_gift_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SGetGiftInfoRsp(int _activity_id_, int _gift_bag_cfg_id_, int _send_available_, HashMap<Long, ReceiverGiftInfo> _receiver_gift_info_map_) {
/*  40 */     this.activity_id = _activity_id_;
/*  41 */     this.gift_bag_cfg_id = _gift_bag_cfg_id_;
/*  42 */     this.send_available = _send_available_;
/*  43 */     this.receiver_gift_info_map = _receiver_gift_info_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (Map.Entry<Long, ReceiverGiftInfo> _e_ : this.receiver_gift_info_map.entrySet()) {
/*  48 */       if (!((ReceiverGiftInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     _os_.marshal(this.gift_bag_cfg_id);
/*  56 */     _os_.marshal(this.send_available);
/*  57 */     _os_.compact_uint32(this.receiver_gift_info_map.size());
/*  58 */     for (Map.Entry<Long, ReceiverGiftInfo> _e_ : this.receiver_gift_info_map.entrySet()) {
/*  59 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  60 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.activity_id = _os_.unmarshal_int();
/*  67 */     this.gift_bag_cfg_id = _os_.unmarshal_int();
/*  68 */     this.send_available = _os_.unmarshal_int();
/*  69 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  71 */       long _k_ = _os_.unmarshal_long();
/*  72 */       ReceiverGiftInfo _v_ = new ReceiverGiftInfo();
/*  73 */       _v_.unmarshal(_os_);
/*  74 */       this.receiver_gift_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SGetGiftInfoRsp)) {
/*  85 */       SGetGiftInfoRsp _o_ = (SGetGiftInfoRsp)_o1_;
/*  86 */       if (this.activity_id != _o_.activity_id) return false;
/*  87 */       if (this.gift_bag_cfg_id != _o_.gift_bag_cfg_id) return false;
/*  88 */       if (this.send_available != _o_.send_available) return false;
/*  89 */       if (!this.receiver_gift_info_map.equals(_o_.receiver_gift_info_map)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.activity_id;
/*  98 */     _h_ += this.gift_bag_cfg_id;
/*  99 */     _h_ += this.send_available;
/* 100 */     _h_ += this.receiver_gift_info_map.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.activity_id).append(",");
/* 108 */     _sb_.append(this.gift_bag_cfg_id).append(",");
/* 109 */     _sb_.append(this.send_available).append(",");
/* 110 */     _sb_.append(this.receiver_gift_info_map).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetGiftInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */