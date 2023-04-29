/*     */ package mzm.gsp.ballbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SNotifyKillEvent
/*     */   extends __SNotifyKillEvent__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12629266;
/*     */   public long killer_role_id;
/*     */   public int killer_avatar_id;
/*     */   public int killer_avatar_frame_id;
/*     */   public long killed_role_id;
/*     */   public int killed_avatar_id;
/*     */   public int killed_avatar_frame_id;
/*     */   public int position_x;
/*     */   public int position_y;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12629266;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyKillEvent() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyKillEvent(long _killer_role_id_, int _killer_avatar_id_, int _killer_avatar_frame_id_, long _killed_role_id_, int _killed_avatar_id_, int _killed_avatar_frame_id_, int _position_x_, int _position_y_)
/*     */   {
/*  43 */     this.killer_role_id = _killer_role_id_;
/*  44 */     this.killer_avatar_id = _killer_avatar_id_;
/*  45 */     this.killer_avatar_frame_id = _killer_avatar_frame_id_;
/*  46 */     this.killed_role_id = _killed_role_id_;
/*  47 */     this.killed_avatar_id = _killed_avatar_id_;
/*  48 */     this.killed_avatar_frame_id = _killed_avatar_frame_id_;
/*  49 */     this.position_x = _position_x_;
/*  50 */     this.position_y = _position_y_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.killer_role_id);
/*  59 */     _os_.marshal(this.killer_avatar_id);
/*  60 */     _os_.marshal(this.killer_avatar_frame_id);
/*  61 */     _os_.marshal(this.killed_role_id);
/*  62 */     _os_.marshal(this.killed_avatar_id);
/*  63 */     _os_.marshal(this.killed_avatar_frame_id);
/*  64 */     _os_.marshal(this.position_x);
/*  65 */     _os_.marshal(this.position_y);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.killer_role_id = _os_.unmarshal_long();
/*  71 */     this.killer_avatar_id = _os_.unmarshal_int();
/*  72 */     this.killer_avatar_frame_id = _os_.unmarshal_int();
/*  73 */     this.killed_role_id = _os_.unmarshal_long();
/*  74 */     this.killed_avatar_id = _os_.unmarshal_int();
/*  75 */     this.killed_avatar_frame_id = _os_.unmarshal_int();
/*  76 */     this.position_x = _os_.unmarshal_int();
/*  77 */     this.position_y = _os_.unmarshal_int();
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SNotifyKillEvent)) {
/*  87 */       SNotifyKillEvent _o_ = (SNotifyKillEvent)_o1_;
/*  88 */       if (this.killer_role_id != _o_.killer_role_id) return false;
/*  89 */       if (this.killer_avatar_id != _o_.killer_avatar_id) return false;
/*  90 */       if (this.killer_avatar_frame_id != _o_.killer_avatar_frame_id) return false;
/*  91 */       if (this.killed_role_id != _o_.killed_role_id) return false;
/*  92 */       if (this.killed_avatar_id != _o_.killed_avatar_id) return false;
/*  93 */       if (this.killed_avatar_frame_id != _o_.killed_avatar_frame_id) return false;
/*  94 */       if (this.position_x != _o_.position_x) return false;
/*  95 */       if (this.position_y != _o_.position_y) return false;
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 102 */     int _h_ = 0;
/* 103 */     _h_ += (int)this.killer_role_id;
/* 104 */     _h_ += this.killer_avatar_id;
/* 105 */     _h_ += this.killer_avatar_frame_id;
/* 106 */     _h_ += (int)this.killed_role_id;
/* 107 */     _h_ += this.killed_avatar_id;
/* 108 */     _h_ += this.killed_avatar_frame_id;
/* 109 */     _h_ += this.position_x;
/* 110 */     _h_ += this.position_y;
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.killer_role_id).append(",");
/* 118 */     _sb_.append(this.killer_avatar_id).append(",");
/* 119 */     _sb_.append(this.killer_avatar_frame_id).append(",");
/* 120 */     _sb_.append(this.killed_role_id).append(",");
/* 121 */     _sb_.append(this.killed_avatar_id).append(",");
/* 122 */     _sb_.append(this.killed_avatar_frame_id).append(",");
/* 123 */     _sb_.append(this.position_x).append(",");
/* 124 */     _sb_.append(this.position_y).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SNotifyKillEvent _o_) {
/* 130 */     if (_o_ == this) return 0;
/* 131 */     int _c_ = 0;
/* 132 */     _c_ = Long.signum(this.killer_role_id - _o_.killer_role_id);
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     _c_ = this.killer_avatar_id - _o_.killer_avatar_id;
/* 135 */     if (0 != _c_) return _c_;
/* 136 */     _c_ = this.killer_avatar_frame_id - _o_.killer_avatar_frame_id;
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     _c_ = Long.signum(this.killed_role_id - _o_.killed_role_id);
/* 139 */     if (0 != _c_) return _c_;
/* 140 */     _c_ = this.killed_avatar_id - _o_.killed_avatar_id;
/* 141 */     if (0 != _c_) return _c_;
/* 142 */     _c_ = this.killed_avatar_frame_id - _o_.killed_avatar_frame_id;
/* 143 */     if (0 != _c_) return _c_;
/* 144 */     _c_ = this.position_x - _o_.position_x;
/* 145 */     if (0 != _c_) return _c_;
/* 146 */     _c_ = this.position_y - _o_.position_y;
/* 147 */     if (0 != _c_) return _c_;
/* 148 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\SNotifyKillEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */