/*     */ package mzm.gsp.flowerparade;
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
/*     */ public class SFlowerParadeJoinFailedRep
/*     */   extends __SFlowerParadeJoinFailedRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625674;
/*     */   public static final int PARADE_NOT_START = 1;
/*     */   public static final int NOT_TEAM_LEADER = 2;
/*     */   public int code;
/*     */   public int activityid;
/*     */   public long nextstarttimesec;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625674;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFlowerParadeJoinFailedRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFlowerParadeJoinFailedRep(int _code_, int _activityid_, long _nextstarttimesec_)
/*     */   {
/*  41 */     this.code = _code_;
/*  42 */     this.activityid = _activityid_;
/*  43 */     this.nextstarttimesec = _nextstarttimesec_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.code);
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.nextstarttimesec);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.code = _os_.unmarshal_int();
/*  59 */     this.activityid = _os_.unmarshal_int();
/*  60 */     this.nextstarttimesec = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof SFlowerParadeJoinFailedRep)) {
/*  70 */       SFlowerParadeJoinFailedRep _o_ = (SFlowerParadeJoinFailedRep)_o1_;
/*  71 */       if (this.code != _o_.code) return false;
/*  72 */       if (this.activityid != _o_.activityid) return false;
/*  73 */       if (this.nextstarttimesec != _o_.nextstarttimesec) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.code;
/*  82 */     _h_ += this.activityid;
/*  83 */     _h_ += (int)this.nextstarttimesec;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.code).append(",");
/*  91 */     _sb_.append(this.activityid).append(",");
/*  92 */     _sb_.append(this.nextstarttimesec).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFlowerParadeJoinFailedRep _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.code - _o_.code;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.activityid - _o_.activityid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.nextstarttimesec - _o_.nextstarttimesec);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\SFlowerParadeJoinFailedRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */