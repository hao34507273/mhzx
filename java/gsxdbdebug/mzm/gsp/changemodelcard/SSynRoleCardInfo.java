/*     */ package mzm.gsp.changemodelcard;
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
/*     */ public class SSynRoleCardInfo
/*     */   extends __SSynRoleCardInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624416;
/*     */   public int current_card_cfg_id;
/*     */   public int current_card_level;
/*     */   public int fight_count;
/*     */   public long start_time;
/*     */   public int overlay_count;
/*     */   public byte visible;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12624416;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoleCardInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoleCardInfo(int _current_card_cfg_id_, int _current_card_level_, int _fight_count_, long _start_time_, int _overlay_count_, byte _visible_)
/*     */   {
/*  41 */     this.current_card_cfg_id = _current_card_cfg_id_;
/*  42 */     this.current_card_level = _current_card_level_;
/*  43 */     this.fight_count = _fight_count_;
/*  44 */     this.start_time = _start_time_;
/*  45 */     this.overlay_count = _overlay_count_;
/*  46 */     this.visible = _visible_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.current_card_cfg_id);
/*  55 */     _os_.marshal(this.current_card_level);
/*  56 */     _os_.marshal(this.fight_count);
/*  57 */     _os_.marshal(this.start_time);
/*  58 */     _os_.marshal(this.overlay_count);
/*  59 */     _os_.marshal(this.visible);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.current_card_cfg_id = _os_.unmarshal_int();
/*  65 */     this.current_card_level = _os_.unmarshal_int();
/*  66 */     this.fight_count = _os_.unmarshal_int();
/*  67 */     this.start_time = _os_.unmarshal_long();
/*  68 */     this.overlay_count = _os_.unmarshal_int();
/*  69 */     this.visible = _os_.unmarshal_byte();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SSynRoleCardInfo)) {
/*  79 */       SSynRoleCardInfo _o_ = (SSynRoleCardInfo)_o1_;
/*  80 */       if (this.current_card_cfg_id != _o_.current_card_cfg_id) return false;
/*  81 */       if (this.current_card_level != _o_.current_card_level) return false;
/*  82 */       if (this.fight_count != _o_.fight_count) return false;
/*  83 */       if (this.start_time != _o_.start_time) return false;
/*  84 */       if (this.overlay_count != _o_.overlay_count) return false;
/*  85 */       if (this.visible != _o_.visible) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.current_card_cfg_id;
/*  94 */     _h_ += this.current_card_level;
/*  95 */     _h_ += this.fight_count;
/*  96 */     _h_ += (int)this.start_time;
/*  97 */     _h_ += this.overlay_count;
/*  98 */     _h_ += this.visible;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.current_card_cfg_id).append(",");
/* 106 */     _sb_.append(this.current_card_level).append(",");
/* 107 */     _sb_.append(this.fight_count).append(",");
/* 108 */     _sb_.append(this.start_time).append(",");
/* 109 */     _sb_.append(this.overlay_count).append(",");
/* 110 */     _sb_.append(this.visible).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynRoleCardInfo _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.current_card_cfg_id - _o_.current_card_cfg_id;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.current_card_level - _o_.current_card_level;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.fight_count - _o_.fight_count;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = Long.signum(this.start_time - _o_.start_time);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.overlay_count - _o_.overlay_count;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.visible - _o_.visible;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SSynRoleCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */