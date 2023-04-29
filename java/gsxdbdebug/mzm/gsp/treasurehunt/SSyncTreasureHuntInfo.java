/*     */ package mzm.gsp.treasurehunt;
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
/*     */ public class SSyncTreasureHuntInfo
/*     */   extends __SSyncTreasureHuntInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12633093;
/*     */   public int activity_cfg_id;
/*     */   public int process;
/*     */   public int total;
/*     */   public int left_seconds;
/*     */   public int chapter_cfg_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12633093;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncTreasureHuntInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncTreasureHuntInfo(int _activity_cfg_id_, int _process_, int _total_, int _left_seconds_, int _chapter_cfg_id_)
/*     */   {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.process = _process_;
/*  42 */     this.total = _total_;
/*  43 */     this.left_seconds = _left_seconds_;
/*  44 */     this.chapter_cfg_id = _chapter_cfg_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.process);
/*  54 */     _os_.marshal(this.total);
/*  55 */     _os_.marshal(this.left_seconds);
/*  56 */     _os_.marshal(this.chapter_cfg_id);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.process = _os_.unmarshal_int();
/*  63 */     this.total = _os_.unmarshal_int();
/*  64 */     this.left_seconds = _os_.unmarshal_int();
/*  65 */     this.chapter_cfg_id = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSyncTreasureHuntInfo)) {
/*  75 */       SSyncTreasureHuntInfo _o_ = (SSyncTreasureHuntInfo)_o1_;
/*  76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  77 */       if (this.process != _o_.process) return false;
/*  78 */       if (this.total != _o_.total) return false;
/*  79 */       if (this.left_seconds != _o_.left_seconds) return false;
/*  80 */       if (this.chapter_cfg_id != _o_.chapter_cfg_id) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_cfg_id;
/*  89 */     _h_ += this.process;
/*  90 */     _h_ += this.total;
/*  91 */     _h_ += this.left_seconds;
/*  92 */     _h_ += this.chapter_cfg_id;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.process).append(",");
/* 101 */     _sb_.append(this.total).append(",");
/* 102 */     _sb_.append(this.left_seconds).append(",");
/* 103 */     _sb_.append(this.chapter_cfg_id).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncTreasureHuntInfo _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.process - _o_.process;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.total - _o_.total;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.left_seconds - _o_.left_seconds;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.chapter_cfg_id - _o_.chapter_cfg_id;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\SSyncTreasureHuntInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */