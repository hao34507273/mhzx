/*     */ package mzm.gsp.friendscircle;
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
/*     */ public class STreadFriendsCircleSuccess
/*     */   extends __STreadFriendsCircleSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625410;
/*     */   public byte is_trigger_box;
/*     */   public long be_trod_role_id;
/*     */   public int popularity_week_value;
/*     */   public int popularity_total_value;
/*     */   public int add_popularity_total_value;
/*     */   public byte is_auto_tread;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625410;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public STreadFriendsCircleSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public STreadFriendsCircleSuccess(byte _is_trigger_box_, long _be_trod_role_id_, int _popularity_week_value_, int _popularity_total_value_, int _add_popularity_total_value_, byte _is_auto_tread_)
/*     */   {
/*  41 */     this.is_trigger_box = _is_trigger_box_;
/*  42 */     this.be_trod_role_id = _be_trod_role_id_;
/*  43 */     this.popularity_week_value = _popularity_week_value_;
/*  44 */     this.popularity_total_value = _popularity_total_value_;
/*  45 */     this.add_popularity_total_value = _add_popularity_total_value_;
/*  46 */     this.is_auto_tread = _is_auto_tread_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.is_trigger_box);
/*  55 */     _os_.marshal(this.be_trod_role_id);
/*  56 */     _os_.marshal(this.popularity_week_value);
/*  57 */     _os_.marshal(this.popularity_total_value);
/*  58 */     _os_.marshal(this.add_popularity_total_value);
/*  59 */     _os_.marshal(this.is_auto_tread);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.is_trigger_box = _os_.unmarshal_byte();
/*  65 */     this.be_trod_role_id = _os_.unmarshal_long();
/*  66 */     this.popularity_week_value = _os_.unmarshal_int();
/*  67 */     this.popularity_total_value = _os_.unmarshal_int();
/*  68 */     this.add_popularity_total_value = _os_.unmarshal_int();
/*  69 */     this.is_auto_tread = _os_.unmarshal_byte();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof STreadFriendsCircleSuccess)) {
/*  79 */       STreadFriendsCircleSuccess _o_ = (STreadFriendsCircleSuccess)_o1_;
/*  80 */       if (this.is_trigger_box != _o_.is_trigger_box) return false;
/*  81 */       if (this.be_trod_role_id != _o_.be_trod_role_id) return false;
/*  82 */       if (this.popularity_week_value != _o_.popularity_week_value) return false;
/*  83 */       if (this.popularity_total_value != _o_.popularity_total_value) return false;
/*  84 */       if (this.add_popularity_total_value != _o_.add_popularity_total_value) return false;
/*  85 */       if (this.is_auto_tread != _o_.is_auto_tread) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.is_trigger_box;
/*  94 */     _h_ += (int)this.be_trod_role_id;
/*  95 */     _h_ += this.popularity_week_value;
/*  96 */     _h_ += this.popularity_total_value;
/*  97 */     _h_ += this.add_popularity_total_value;
/*  98 */     _h_ += this.is_auto_tread;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.is_trigger_box).append(",");
/* 106 */     _sb_.append(this.be_trod_role_id).append(",");
/* 107 */     _sb_.append(this.popularity_week_value).append(",");
/* 108 */     _sb_.append(this.popularity_total_value).append(",");
/* 109 */     _sb_.append(this.add_popularity_total_value).append(",");
/* 110 */     _sb_.append(this.is_auto_tread).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STreadFriendsCircleSuccess _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.is_trigger_box - _o_.is_trigger_box;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = Long.signum(this.be_trod_role_id - _o_.be_trod_role_id);
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.popularity_week_value - _o_.popularity_week_value;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.popularity_total_value - _o_.popularity_total_value;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.add_popularity_total_value - _o_.add_popularity_total_value;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.is_auto_tread - _o_.is_auto_tread;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\STreadFriendsCircleSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */