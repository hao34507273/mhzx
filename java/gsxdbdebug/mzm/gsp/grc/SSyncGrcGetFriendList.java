/*     */ package mzm.gsp.grc;
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
/*     */ public class SSyncGrcGetFriendList
/*     */   extends __SSyncGrcGetFriendList__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600327;
/*     */   public int total_friend_count;
/*     */   public int page_index;
/*     */   public LinkedList<GrcFriendInfo> friends;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600327;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGrcGetFriendList()
/*     */   {
/*  35 */     this.friends = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSyncGrcGetFriendList(int _total_friend_count_, int _page_index_, LinkedList<GrcFriendInfo> _friends_) {
/*  39 */     this.total_friend_count = _total_friend_count_;
/*  40 */     this.page_index = _page_index_;
/*  41 */     this.friends = _friends_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (GrcFriendInfo _v_ : this.friends)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.total_friend_count);
/*  52 */     _os_.marshal(this.page_index);
/*  53 */     _os_.compact_uint32(this.friends.size());
/*  54 */     for (GrcFriendInfo _v_ : this.friends) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.total_friend_count = _os_.unmarshal_int();
/*  62 */     this.page_index = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       GrcFriendInfo _v_ = new GrcFriendInfo();
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
/*  76 */     if ((_o1_ instanceof SSyncGrcGetFriendList)) {
/*  77 */       SSyncGrcGetFriendList _o_ = (SSyncGrcGetFriendList)_o1_;
/*  78 */       if (this.total_friend_count != _o_.total_friend_count) return false;
/*  79 */       if (this.page_index != _o_.page_index) return false;
/*  80 */       if (!this.friends.equals(_o_.friends)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.total_friend_count;
/*  89 */     _h_ += this.page_index;
/*  90 */     _h_ += this.friends.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.total_friend_count).append(",");
/*  98 */     _sb_.append(this.page_index).append(",");
/*  99 */     _sb_.append(this.friends).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SSyncGrcGetFriendList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */