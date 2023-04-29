/*     */ package mzm.gsp.task;
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
/*     */ public class STaskTalk
/*     */   extends __STaskTalk__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592136;
/*     */   public int taskid;
/*     */   public int graphid;
/*     */   public int talktype;
/*     */   public int talkindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12592136;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public STaskTalk() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public STaskTalk(int _taskid_, int _graphid_, int _talktype_, int _talkindex_)
/*     */   {
/*  37 */     this.taskid = _taskid_;
/*  38 */     this.graphid = _graphid_;
/*  39 */     this.talktype = _talktype_;
/*  40 */     this.talkindex = _talkindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.taskid);
/*  49 */     _os_.marshal(this.graphid);
/*  50 */     _os_.marshal(this.talktype);
/*  51 */     _os_.marshal(this.talkindex);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.taskid = _os_.unmarshal_int();
/*  57 */     this.graphid = _os_.unmarshal_int();
/*  58 */     this.talktype = _os_.unmarshal_int();
/*  59 */     this.talkindex = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof STaskTalk)) {
/*  69 */       STaskTalk _o_ = (STaskTalk)_o1_;
/*  70 */       if (this.taskid != _o_.taskid) return false;
/*  71 */       if (this.graphid != _o_.graphid) return false;
/*  72 */       if (this.talktype != _o_.talktype) return false;
/*  73 */       if (this.talkindex != _o_.talkindex) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.taskid;
/*  82 */     _h_ += this.graphid;
/*  83 */     _h_ += this.talktype;
/*  84 */     _h_ += this.talkindex;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.taskid).append(",");
/*  92 */     _sb_.append(this.graphid).append(",");
/*  93 */     _sb_.append(this.talktype).append(",");
/*  94 */     _sb_.append(this.talkindex).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STaskTalk _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.taskid - _o_.taskid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.graphid - _o_.graphid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.talktype - _o_.talktype;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.talkindex - _o_.talkindex;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\STaskTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */