/*     */ package mzm.gsp.ladder;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SRoleLadderInfoRes
/*     */   extends __SRoleLadderInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607264;
/*     */   public int stage;
/*     */   public int matchscore;
/*     */   public int wincount;
/*     */   public int losecount;
/*     */   public HashSet<Integer> stageawards;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607264;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRoleLadderInfoRes()
/*     */   {
/*  37 */     this.stageawards = new HashSet();
/*     */   }
/*     */   
/*     */   public SRoleLadderInfoRes(int _stage_, int _matchscore_, int _wincount_, int _losecount_, HashSet<Integer> _stageawards_) {
/*  41 */     this.stage = _stage_;
/*  42 */     this.matchscore = _matchscore_;
/*  43 */     this.wincount = _wincount_;
/*  44 */     this.losecount = _losecount_;
/*  45 */     this.stageawards = _stageawards_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.stage);
/*  54 */     _os_.marshal(this.matchscore);
/*  55 */     _os_.marshal(this.wincount);
/*  56 */     _os_.marshal(this.losecount);
/*  57 */     _os_.compact_uint32(this.stageawards.size());
/*  58 */     for (Integer _v_ : this.stageawards) {
/*  59 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.stage = _os_.unmarshal_int();
/*  66 */     this.matchscore = _os_.unmarshal_int();
/*  67 */     this.wincount = _os_.unmarshal_int();
/*  68 */     this.losecount = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.stageawards.add(Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SRoleLadderInfoRes)) {
/*  83 */       SRoleLadderInfoRes _o_ = (SRoleLadderInfoRes)_o1_;
/*  84 */       if (this.stage != _o_.stage) return false;
/*  85 */       if (this.matchscore != _o_.matchscore) return false;
/*  86 */       if (this.wincount != _o_.wincount) return false;
/*  87 */       if (this.losecount != _o_.losecount) return false;
/*  88 */       if (!this.stageawards.equals(_o_.stageawards)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.stage;
/*  97 */     _h_ += this.matchscore;
/*  98 */     _h_ += this.wincount;
/*  99 */     _h_ += this.losecount;
/* 100 */     _h_ += this.stageawards.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.stage).append(",");
/* 108 */     _sb_.append(this.matchscore).append(",");
/* 109 */     _sb_.append(this.wincount).append(",");
/* 110 */     _sb_.append(this.losecount).append(",");
/* 111 */     _sb_.append(this.stageawards).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SRoleLadderInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */