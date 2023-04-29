/*     */ package mzm.gsp.makeup;
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
/*     */ public class SMakeUpTurnOver
/*     */   extends __SMakeUpTurnOver__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625924;
/*     */   public int activityid;
/*     */   public int turn;
/*     */   public int rightnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625924;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SMakeUpTurnOver() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMakeUpTurnOver(int _activityid_, int _turn_, int _rightnum_)
/*     */   {
/*  38 */     this.activityid = _activityid_;
/*  39 */     this.turn = _turn_;
/*  40 */     this.rightnum = _rightnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activityid);
/*  49 */     _os_.marshal(this.turn);
/*  50 */     _os_.marshal(this.rightnum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activityid = _os_.unmarshal_int();
/*  56 */     this.turn = _os_.unmarshal_int();
/*  57 */     this.rightnum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SMakeUpTurnOver)) {
/*  67 */       SMakeUpTurnOver _o_ = (SMakeUpTurnOver)_o1_;
/*  68 */       if (this.activityid != _o_.activityid) return false;
/*  69 */       if (this.turn != _o_.turn) return false;
/*  70 */       if (this.rightnum != _o_.rightnum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activityid;
/*  79 */     _h_ += this.turn;
/*  80 */     _h_ += this.rightnum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activityid).append(",");
/*  88 */     _sb_.append(this.turn).append(",");
/*  89 */     _sb_.append(this.rightnum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMakeUpTurnOver _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activityid - _o_.activityid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.turn - _o_.turn;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.rightnum - _o_.rightnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\SMakeUpTurnOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */