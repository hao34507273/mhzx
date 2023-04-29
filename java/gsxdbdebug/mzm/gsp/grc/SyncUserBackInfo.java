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
/*     */ public class SyncUserBackInfo
/*     */   extends __SyncUserBackInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600371;
/*     */   public int first;
/*     */   public int back_time;
/*     */   public ArrayList<FriendRecallInfo> recall_friends;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600371;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SyncUserBackInfo()
/*     */   {
/*  35 */     this.recall_friends = new ArrayList();
/*     */   }
/*     */   
/*     */   public SyncUserBackInfo(int _first_, int _back_time_, ArrayList<FriendRecallInfo> _recall_friends_) {
/*  39 */     this.first = _first_;
/*  40 */     this.back_time = _back_time_;
/*  41 */     this.recall_friends = _recall_friends_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (FriendRecallInfo _v_ : this.recall_friends)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.first);
/*  52 */     _os_.marshal(this.back_time);
/*  53 */     _os_.compact_uint32(this.recall_friends.size());
/*  54 */     for (FriendRecallInfo _v_ : this.recall_friends) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.first = _os_.unmarshal_int();
/*  62 */     this.back_time = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       FriendRecallInfo _v_ = new FriendRecallInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.recall_friends.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SyncUserBackInfo)) {
/*  77 */       SyncUserBackInfo _o_ = (SyncUserBackInfo)_o1_;
/*  78 */       if (this.first != _o_.first) return false;
/*  79 */       if (this.back_time != _o_.back_time) return false;
/*  80 */       if (!this.recall_friends.equals(_o_.recall_friends)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.first;
/*  89 */     _h_ += this.back_time;
/*  90 */     _h_ += this.recall_friends.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.first).append(",");
/*  98 */     _sb_.append(this.back_time).append(",");
/*  99 */     _sb_.append(this.recall_friends).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SyncUserBackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */