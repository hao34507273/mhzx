/*     */ package mzm.gsp.changemodelcard;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynCardInfo
/*     */   extends __SSynCardInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624394;
/*     */   public HashMap<Long, CardInfo> card_info_map;
/*     */   public int current_card_cfg_id;
/*     */   public int current_card_level;
/*     */   public byte visible;
/*     */   public int fight_count;
/*     */   public long start_time;
/*     */   public int overlay_count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12624394;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynCardInfo()
/*     */   {
/*  39 */     this.card_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynCardInfo(HashMap<Long, CardInfo> _card_info_map_, int _current_card_cfg_id_, int _current_card_level_, byte _visible_, int _fight_count_, long _start_time_, int _overlay_count_) {
/*  43 */     this.card_info_map = _card_info_map_;
/*  44 */     this.current_card_cfg_id = _current_card_cfg_id_;
/*  45 */     this.current_card_level = _current_card_level_;
/*  46 */     this.visible = _visible_;
/*  47 */     this.fight_count = _fight_count_;
/*  48 */     this.start_time = _start_time_;
/*  49 */     this.overlay_count = _overlay_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     for (Map.Entry<Long, CardInfo> _e_ : this.card_info_map.entrySet()) {
/*  54 */       if (!((CardInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.compact_uint32(this.card_info_map.size());
/*  61 */     for (Map.Entry<Long, CardInfo> _e_ : this.card_info_map.entrySet()) {
/*  62 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  63 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  65 */     _os_.marshal(this.current_card_cfg_id);
/*  66 */     _os_.marshal(this.current_card_level);
/*  67 */     _os_.marshal(this.visible);
/*  68 */     _os_.marshal(this.fight_count);
/*  69 */     _os_.marshal(this.start_time);
/*  70 */     _os_.marshal(this.overlay_count);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       long _k_ = _os_.unmarshal_long();
/*  78 */       CardInfo _v_ = new CardInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.card_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  82 */     this.current_card_cfg_id = _os_.unmarshal_int();
/*  83 */     this.current_card_level = _os_.unmarshal_int();
/*  84 */     this.visible = _os_.unmarshal_byte();
/*  85 */     this.fight_count = _os_.unmarshal_int();
/*  86 */     this.start_time = _os_.unmarshal_long();
/*  87 */     this.overlay_count = _os_.unmarshal_int();
/*  88 */     if (!_validator_()) {
/*  89 */       throw new VerifyError("validator failed");
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof SSynCardInfo)) {
/*  97 */       SSynCardInfo _o_ = (SSynCardInfo)_o1_;
/*  98 */       if (!this.card_info_map.equals(_o_.card_info_map)) return false;
/*  99 */       if (this.current_card_cfg_id != _o_.current_card_cfg_id) return false;
/* 100 */       if (this.current_card_level != _o_.current_card_level) return false;
/* 101 */       if (this.visible != _o_.visible) return false;
/* 102 */       if (this.fight_count != _o_.fight_count) return false;
/* 103 */       if (this.start_time != _o_.start_time) return false;
/* 104 */       if (this.overlay_count != _o_.overlay_count) return false;
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 111 */     int _h_ = 0;
/* 112 */     _h_ += this.card_info_map.hashCode();
/* 113 */     _h_ += this.current_card_cfg_id;
/* 114 */     _h_ += this.current_card_level;
/* 115 */     _h_ += this.visible;
/* 116 */     _h_ += this.fight_count;
/* 117 */     _h_ += (int)this.start_time;
/* 118 */     _h_ += this.overlay_count;
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.card_info_map).append(",");
/* 126 */     _sb_.append(this.current_card_cfg_id).append(",");
/* 127 */     _sb_.append(this.current_card_level).append(",");
/* 128 */     _sb_.append(this.visible).append(",");
/* 129 */     _sb_.append(this.fight_count).append(",");
/* 130 */     _sb_.append(this.start_time).append(",");
/* 131 */     _sb_.append(this.overlay_count).append(",");
/* 132 */     _sb_.append(")");
/* 133 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SSynCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */