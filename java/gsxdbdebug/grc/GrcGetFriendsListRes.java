/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class GrcGetFriendsListRes implements Marshal
/*     */ {
/*     */   public int retcode;
/*     */   public int page_index;
/*     */   public int friend_total_count;
/*     */   public ArrayList<GrcUserInfo> friends;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcGetFriendsListRes()
/*     */   {
/*  19 */     this.retcode = 9;
/*  20 */     this.friends = new ArrayList();
/*  21 */     this.reserved1 = 0;
/*  22 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcGetFriendsListRes(int _retcode_, int _page_index_, int _friend_total_count_, ArrayList<GrcUserInfo> _friends_, int _reserved1_, int _reserved2_) {
/*  26 */     this.retcode = _retcode_;
/*  27 */     this.page_index = _page_index_;
/*  28 */     this.friend_total_count = _friend_total_count_;
/*  29 */     this.friends = _friends_;
/*  30 */     this.reserved1 = _reserved1_;
/*  31 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     for (GrcUserInfo _v_ : this.friends)
/*  36 */       if (!_v_._validator_()) return false;
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.retcode);
/*  42 */     _os_.marshal(this.page_index);
/*  43 */     _os_.marshal(this.friend_total_count);
/*  44 */     _os_.compact_uint32(this.friends.size());
/*  45 */     for (GrcUserInfo _v_ : this.friends) {
/*  46 */       _os_.marshal(_v_);
/*     */     }
/*  48 */     _os_.marshal(this.reserved1);
/*  49 */     _os_.marshal(this.reserved2);
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  54 */     this.retcode = _os_.unmarshal_int();
/*  55 */     this.page_index = _os_.unmarshal_int();
/*  56 */     this.friend_total_count = _os_.unmarshal_int();
/*  57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  58 */       GrcUserInfo _v_ = new GrcUserInfo();
/*  59 */       _v_.unmarshal(_os_);
/*  60 */       this.friends.add(_v_);
/*     */     }
/*  62 */     this.reserved1 = _os_.unmarshal_int();
/*  63 */     this.reserved2 = _os_.unmarshal_int();
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof GrcGetFriendsListRes)) {
/*  70 */       GrcGetFriendsListRes _o_ = (GrcGetFriendsListRes)_o1_;
/*  71 */       if (this.retcode != _o_.retcode) return false;
/*  72 */       if (this.page_index != _o_.page_index) return false;
/*  73 */       if (this.friend_total_count != _o_.friend_total_count) return false;
/*  74 */       if (!this.friends.equals(_o_.friends)) return false;
/*  75 */       if (this.reserved1 != _o_.reserved1) return false;
/*  76 */       if (this.reserved2 != _o_.reserved2) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.retcode;
/*  85 */     _h_ += this.page_index;
/*  86 */     _h_ += this.friend_total_count;
/*  87 */     _h_ += this.friends.hashCode();
/*  88 */     _h_ += this.reserved1;
/*  89 */     _h_ += this.reserved2;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.retcode).append(",");
/*  97 */     _sb_.append(this.page_index).append(",");
/*  98 */     _sb_.append(this.friend_total_count).append(",");
/*  99 */     _sb_.append(this.friends).append(",");
/* 100 */     _sb_.append(this.reserved1).append(",");
/* 101 */     _sb_.append(this.reserved2).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetFriendsListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */