/*     */ package mzm.gsp.activity;
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
/*     */ public class SSyncLegendTime
/*     */   extends __SSyncLegendTime__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587526;
/*     */   public int graphid;
/*     */   public int taskid;
/*     */   public long endtime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587526;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncLegendTime() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncLegendTime(int _graphid_, int _taskid_, long _endtime_)
/*     */   {
/*  38 */     this.graphid = _graphid_;
/*  39 */     this.taskid = _taskid_;
/*  40 */     this.endtime = _endtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.graphid);
/*  49 */     _os_.marshal(this.taskid);
/*  50 */     _os_.marshal(this.endtime);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.graphid = _os_.unmarshal_int();
/*  56 */     this.taskid = _os_.unmarshal_int();
/*  57 */     this.endtime = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncLegendTime)) {
/*  67 */       SSyncLegendTime _o_ = (SSyncLegendTime)_o1_;
/*  68 */       if (this.graphid != _o_.graphid) return false;
/*  69 */       if (this.taskid != _o_.taskid) return false;
/*  70 */       if (this.endtime != _o_.endtime) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.graphid;
/*  79 */     _h_ += this.taskid;
/*  80 */     _h_ += (int)this.endtime;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.graphid).append(",");
/*  88 */     _sb_.append(this.taskid).append(",");
/*  89 */     _sb_.append(this.endtime).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncLegendTime _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.graphid - _o_.graphid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.taskid - _o_.taskid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.endtime - _o_.endtime);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSyncLegendTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */