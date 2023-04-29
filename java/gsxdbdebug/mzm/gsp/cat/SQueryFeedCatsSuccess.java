/*     */ package mzm.gsp.cat;
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
/*     */ public class SQueryFeedCatsSuccess
/*     */   extends __SQueryFeedCatsSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605718;
/*     */   public long target_roleid;
/*     */   public long catid;
/*     */   public ArrayList<FeedInfo> feeds;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605718;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryFeedCatsSuccess()
/*     */   {
/*  35 */     this.feeds = new ArrayList();
/*     */   }
/*     */   
/*     */   public SQueryFeedCatsSuccess(long _target_roleid_, long _catid_, ArrayList<FeedInfo> _feeds_) {
/*  39 */     this.target_roleid = _target_roleid_;
/*  40 */     this.catid = _catid_;
/*  41 */     this.feeds = _feeds_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (FeedInfo _v_ : this.feeds)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.target_roleid);
/*  52 */     _os_.marshal(this.catid);
/*  53 */     _os_.compact_uint32(this.feeds.size());
/*  54 */     for (FeedInfo _v_ : this.feeds) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.target_roleid = _os_.unmarshal_long();
/*  62 */     this.catid = _os_.unmarshal_long();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       FeedInfo _v_ = new FeedInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.feeds.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SQueryFeedCatsSuccess)) {
/*  77 */       SQueryFeedCatsSuccess _o_ = (SQueryFeedCatsSuccess)_o1_;
/*  78 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  79 */       if (this.catid != _o_.catid) return false;
/*  80 */       if (!this.feeds.equals(_o_.feeds)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.target_roleid;
/*  89 */     _h_ += (int)this.catid;
/*  90 */     _h_ += this.feeds.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.target_roleid).append(",");
/*  98 */     _sb_.append(this.catid).append(",");
/*  99 */     _sb_.append(this.feeds).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SQueryFeedCatsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */