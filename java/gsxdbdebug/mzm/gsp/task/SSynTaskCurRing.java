/*     */ package mzm.gsp.task;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynTaskCurRing
/*     */   extends __SSynTaskCurRing__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592138;
/*     */   public static final int FINISH_TASK = 1;
/*     */   public static final int GIVEUP_TASK = 2;
/*     */   public static final int COPY_LEADER_TASK = 3;
/*     */   public static final int ACTIVITY_TASK_INIT = 4;
/*     */   public int graphid;
/*     */   public int totalring;
/*     */   public int curring;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12592138;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynTaskCurRing() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynTaskCurRing(int _graphid_, int _totalring_, int _curring_, int _reason_)
/*     */   {
/*  42 */     this.graphid = _graphid_;
/*  43 */     this.totalring = _totalring_;
/*  44 */     this.curring = _curring_;
/*  45 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.graphid);
/*  54 */     _os_.marshal(this.totalring);
/*  55 */     _os_.marshal(this.curring);
/*  56 */     _os_.marshal(this.reason);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.graphid = _os_.unmarshal_int();
/*  62 */     this.totalring = _os_.unmarshal_int();
/*  63 */     this.curring = _os_.unmarshal_int();
/*  64 */     this.reason = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SSynTaskCurRing)) {
/*  74 */       SSynTaskCurRing _o_ = (SSynTaskCurRing)_o1_;
/*  75 */       if (this.graphid != _o_.graphid) return false;
/*  76 */       if (this.totalring != _o_.totalring) return false;
/*  77 */       if (this.curring != _o_.curring) return false;
/*  78 */       if (this.reason != _o_.reason) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.graphid;
/*  87 */     _h_ += this.totalring;
/*  88 */     _h_ += this.curring;
/*  89 */     _h_ += this.reason;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.graphid).append(",");
/*  97 */     _sb_.append(this.totalring).append(",");
/*  98 */     _sb_.append(this.curring).append(",");
/*  99 */     _sb_.append(this.reason).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynTaskCurRing _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.graphid - _o_.graphid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.totalring - _o_.totalring;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.curring - _o_.curring;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.reason - _o_.reason;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\SSynTaskCurRing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */