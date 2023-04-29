/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncGrcExceedFriendList
/*     */   extends __SSyncGrcExceedFriendList__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600332;
/*     */   public int retcode;
/*     */   public int level_type;
/*     */   public ArrayList<GrcPassedFriendInfo> friends;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600332;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGrcExceedFriendList()
/*     */   {
/*  35 */     this.friends = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncGrcExceedFriendList(int _retcode_, int _level_type_, ArrayList<GrcPassedFriendInfo> _friends_) {
/*  39 */     this.retcode = _retcode_;
/*  40 */     this.level_type = _level_type_;
/*  41 */     this.friends = _friends_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (GrcPassedFriendInfo _v_ : this.friends)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.retcode);
/*  52 */     _os_.marshal(this.level_type);
/*  53 */     _os_.compact_uint32(this.friends.size());
/*  54 */     for (GrcPassedFriendInfo _v_ : this.friends) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     this.level_type = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       GrcPassedFriendInfo _v_ = new GrcPassedFriendInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.friends.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSyncGrcExceedFriendList)) {
/*  77 */       SSyncGrcExceedFriendList _o_ = (SSyncGrcExceedFriendList)_o1_;
/*  78 */       if (this.retcode != _o_.retcode) return false;
/*  79 */       if (this.level_type != _o_.level_type) return false;
/*  80 */       if (!this.friends.equals(_o_.friends)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.retcode;
/*  89 */     _h_ += this.level_type;
/*  90 */     _h_ += this.friends.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.retcode).append(",");
/*  98 */     _sb_.append(this.level_type).append(",");
/*  99 */     _sb_.append(this.friends).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SSyncGrcExceedFriendList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */