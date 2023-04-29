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
/*     */ 
/*     */ public class SAttendTreasureHuntSuccess
/*     */   extends __SAttendTreasureHuntSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12633098;
/*     */   public int activity_cfg_id;
/*     */   public int total;
/*     */   public int left_seconds;
/*     */   public int chapter_cfg_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12633098;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAttendTreasureHuntSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAttendTreasureHuntSuccess(int _activity_cfg_id_, int _total_, int _left_seconds_, int _chapter_cfg_id_)
/*     */   {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.total = _total_;
/*  41 */     this.left_seconds = _left_seconds_;
/*  42 */     this.chapter_cfg_id = _chapter_cfg_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activity_cfg_id);
/*  51 */     _os_.marshal(this.total);
/*  52 */     _os_.marshal(this.left_seconds);
/*  53 */     _os_.marshal(this.chapter_cfg_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  59 */     this.total = _os_.unmarshal_int();
/*  60 */     this.left_seconds = _os_.unmarshal_int();
/*  61 */     this.chapter_cfg_id = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAttendTreasureHuntSuccess)) {
/*  71 */       SAttendTreasureHuntSuccess _o_ = (SAttendTreasureHuntSuccess)_o1_;
/*  72 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  73 */       if (this.total != _o_.total) return false;
/*  74 */       if (this.left_seconds != _o_.left_seconds) return false;
/*  75 */       if (this.chapter_cfg_id != _o_.chapter_cfg_id) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.total;
/*  85 */     _h_ += this.left_seconds;
/*  86 */     _h_ += this.chapter_cfg_id;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_cfg_id).append(",");
/*  94 */     _sb_.append(this.total).append(",");
/*  95 */     _sb_.append(this.left_seconds).append(",");
/*  96 */     _sb_.append(this.chapter_cfg_id).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAttendTreasureHuntSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.total - _o_.total;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.left_seconds - _o_.left_seconds;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.chapter_cfg_id - _o_.chapter_cfg_id;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\SAttendTreasureHuntSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */