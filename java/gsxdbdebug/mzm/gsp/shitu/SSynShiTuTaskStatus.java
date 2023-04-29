/*     */ package mzm.gsp.shitu;
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
/*     */ public class SSynShiTuTaskStatus
/*     */   extends __SSynShiTuTaskStatus__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601641;
/*     */   public long role_id;
/*     */   public int graph_id;
/*     */   public int task_id;
/*     */   public int task_state;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601641;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynShiTuTaskStatus() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynShiTuTaskStatus(long _role_id_, int _graph_id_, int _task_id_, int _task_state_)
/*     */   {
/*  39 */     this.role_id = _role_id_;
/*  40 */     this.graph_id = _graph_id_;
/*  41 */     this.task_id = _task_id_;
/*  42 */     this.task_state = _task_state_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.role_id);
/*  51 */     _os_.marshal(this.graph_id);
/*  52 */     _os_.marshal(this.task_id);
/*  53 */     _os_.marshal(this.task_state);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.role_id = _os_.unmarshal_long();
/*  59 */     this.graph_id = _os_.unmarshal_int();
/*  60 */     this.task_id = _os_.unmarshal_int();
/*  61 */     this.task_state = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSynShiTuTaskStatus)) {
/*  71 */       SSynShiTuTaskStatus _o_ = (SSynShiTuTaskStatus)_o1_;
/*  72 */       if (this.role_id != _o_.role_id) return false;
/*  73 */       if (this.graph_id != _o_.graph_id) return false;
/*  74 */       if (this.task_id != _o_.task_id) return false;
/*  75 */       if (this.task_state != _o_.task_state) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.role_id;
/*  84 */     _h_ += this.graph_id;
/*  85 */     _h_ += this.task_id;
/*  86 */     _h_ += this.task_state;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.role_id).append(",");
/*  94 */     _sb_.append(this.graph_id).append(",");
/*  95 */     _sb_.append(this.task_id).append(",");
/*  96 */     _sb_.append(this.task_state).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynShiTuTaskStatus _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.graph_id - _o_.graph_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.task_id - _o_.task_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.task_state - _o_.task_state;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SSynShiTuTaskStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */