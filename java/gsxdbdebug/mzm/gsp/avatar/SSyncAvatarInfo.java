/*     */ package mzm.gsp.avatar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncAvatarInfo
/*     */   extends __SSyncAvatarInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615170;
/*     */   public int current_avatar;
/*     */   public int active_avatar;
/*     */   public LinkedList<AvatarInfo> unlocked_avatars;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615170;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncAvatarInfo()
/*     */   {
/*  35 */     this.unlocked_avatars = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSyncAvatarInfo(int _current_avatar_, int _active_avatar_, LinkedList<AvatarInfo> _unlocked_avatars_) {
/*  39 */     this.current_avatar = _current_avatar_;
/*  40 */     this.active_avatar = _active_avatar_;
/*  41 */     this.unlocked_avatars = _unlocked_avatars_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (AvatarInfo _v_ : this.unlocked_avatars)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.current_avatar);
/*  52 */     _os_.marshal(this.active_avatar);
/*  53 */     _os_.compact_uint32(this.unlocked_avatars.size());
/*  54 */     for (AvatarInfo _v_ : this.unlocked_avatars) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.current_avatar = _os_.unmarshal_int();
/*  62 */     this.active_avatar = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       AvatarInfo _v_ = new AvatarInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.unlocked_avatars.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSyncAvatarInfo)) {
/*  77 */       SSyncAvatarInfo _o_ = (SSyncAvatarInfo)_o1_;
/*  78 */       if (this.current_avatar != _o_.current_avatar) return false;
/*  79 */       if (this.active_avatar != _o_.active_avatar) return false;
/*  80 */       if (!this.unlocked_avatars.equals(_o_.unlocked_avatars)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.current_avatar;
/*  89 */     _h_ += this.active_avatar;
/*  90 */     _h_ += this.unlocked_avatars.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.current_avatar).append(",");
/*  98 */     _sb_.append(this.active_avatar).append(",");
/*  99 */     _sb_.append(this.unlocked_avatars).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\SSyncAvatarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */