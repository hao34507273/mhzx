/*     */ package mzm.gsp.bounty;
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
/*     */ public class SSynBTaskStatus
/*     */   extends __SSynBTaskStatus__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584197;
/*     */   public int graphid;
/*     */   public int taskid;
/*     */   public int taskstate;
/*     */   public int bountycount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584197;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBTaskStatus() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynBTaskStatus(int _graphid_, int _taskid_, int _taskstate_, int _bountycount_)
/*     */   {
/*  39 */     this.graphid = _graphid_;
/*  40 */     this.taskid = _taskid_;
/*  41 */     this.taskstate = _taskstate_;
/*  42 */     this.bountycount = _bountycount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.graphid);
/*  51 */     _os_.marshal(this.taskid);
/*  52 */     _os_.marshal(this.taskstate);
/*  53 */     _os_.marshal(this.bountycount);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.graphid = _os_.unmarshal_int();
/*  59 */     this.taskid = _os_.unmarshal_int();
/*  60 */     this.taskstate = _os_.unmarshal_int();
/*  61 */     this.bountycount = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSynBTaskStatus)) {
/*  71 */       SSynBTaskStatus _o_ = (SSynBTaskStatus)_o1_;
/*  72 */       if (this.graphid != _o_.graphid) return false;
/*  73 */       if (this.taskid != _o_.taskid) return false;
/*  74 */       if (this.taskstate != _o_.taskstate) return false;
/*  75 */       if (this.bountycount != _o_.bountycount) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.graphid;
/*  84 */     _h_ += this.taskid;
/*  85 */     _h_ += this.taskstate;
/*  86 */     _h_ += this.bountycount;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.graphid).append(",");
/*  94 */     _sb_.append(this.taskid).append(",");
/*  95 */     _sb_.append(this.taskstate).append(",");
/*  96 */     _sb_.append(this.bountycount).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynBTaskStatus _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.graphid - _o_.graphid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.taskid - _o_.taskid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.taskstate - _o_.taskstate;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.bountycount - _o_.bountycount;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\SSynBTaskStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */