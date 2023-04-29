/*     */ package mzm.gsp.grc;
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
/*     */ public class SSyncRecallFriendsCountAwardInfo
/*     */   extends __SSyncRecallFriendsCountAwardInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600362;
/*     */   public int award_serial_no;
/*     */   public int recall_friends_count;
/*     */   public int today_recall_friends_count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600362;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRecallFriendsCountAwardInfo()
/*     */   {
/*  35 */     this.award_serial_no = 0;
/*     */   }
/*     */   
/*     */   public SSyncRecallFriendsCountAwardInfo(int _award_serial_no_, int _recall_friends_count_, int _today_recall_friends_count_) {
/*  39 */     this.award_serial_no = _award_serial_no_;
/*  40 */     this.recall_friends_count = _recall_friends_count_;
/*  41 */     this.today_recall_friends_count = _today_recall_friends_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.award_serial_no);
/*  50 */     _os_.marshal(this.recall_friends_count);
/*  51 */     _os_.marshal(this.today_recall_friends_count);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.award_serial_no = _os_.unmarshal_int();
/*  57 */     this.recall_friends_count = _os_.unmarshal_int();
/*  58 */     this.today_recall_friends_count = _os_.unmarshal_int();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof SSyncRecallFriendsCountAwardInfo)) {
/*  68 */       SSyncRecallFriendsCountAwardInfo _o_ = (SSyncRecallFriendsCountAwardInfo)_o1_;
/*  69 */       if (this.award_serial_no != _o_.award_serial_no) return false;
/*  70 */       if (this.recall_friends_count != _o_.recall_friends_count) return false;
/*  71 */       if (this.today_recall_friends_count != _o_.today_recall_friends_count) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.award_serial_no;
/*  80 */     _h_ += this.recall_friends_count;
/*  81 */     _h_ += this.today_recall_friends_count;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.award_serial_no).append(",");
/*  89 */     _sb_.append(this.recall_friends_count).append(",");
/*  90 */     _sb_.append(this.today_recall_friends_count).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncRecallFriendsCountAwardInfo _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.award_serial_no - _o_.award_serial_no;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.recall_friends_count - _o_.recall_friends_count;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.today_recall_friends_count - _o_.today_recall_friends_count;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SSyncRecallFriendsCountAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */