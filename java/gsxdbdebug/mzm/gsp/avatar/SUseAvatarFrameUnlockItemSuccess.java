/*     */ package mzm.gsp.avatar;
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
/*     */ 
/*     */ 
/*     */ public class SUseAvatarFrameUnlockItemSuccess
/*     */   extends __SUseAvatarFrameUnlockItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615187;
/*     */   public int avatar_frame_id;
/*     */   public int is_new;
/*     */   public int expire_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615187;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseAvatarFrameUnlockItemSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseAvatarFrameUnlockItemSuccess(int _avatar_frame_id_, int _is_new_, int _expire_time_)
/*     */   {
/*  38 */     this.avatar_frame_id = _avatar_frame_id_;
/*  39 */     this.is_new = _is_new_;
/*  40 */     this.expire_time = _expire_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.avatar_frame_id);
/*  49 */     _os_.marshal(this.is_new);
/*  50 */     _os_.marshal(this.expire_time);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.avatar_frame_id = _os_.unmarshal_int();
/*  56 */     this.is_new = _os_.unmarshal_int();
/*  57 */     this.expire_time = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SUseAvatarFrameUnlockItemSuccess)) {
/*  67 */       SUseAvatarFrameUnlockItemSuccess _o_ = (SUseAvatarFrameUnlockItemSuccess)_o1_;
/*  68 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/*  69 */       if (this.is_new != _o_.is_new) return false;
/*  70 */       if (this.expire_time != _o_.expire_time) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.avatar_frame_id;
/*  79 */     _h_ += this.is_new;
/*  80 */     _h_ += this.expire_time;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.avatar_frame_id).append(",");
/*  88 */     _sb_.append(this.is_new).append(",");
/*  89 */     _sb_.append(this.expire_time).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseAvatarFrameUnlockItemSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.avatar_frame_id - _o_.avatar_frame_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.is_new - _o_.is_new;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.expire_time - _o_.expire_time;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\SUseAvatarFrameUnlockItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */