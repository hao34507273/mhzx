/*     */ package mzm.gsp.crosscompete;
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
/*     */ public class SWinFightBrd
/*     */   extends __SWinFightBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616727;
/*     */   public String winner_leader;
/*     */   public int winner_number;
/*     */   public String loser_leader;
/*     */   public int loser_number;
/*     */   public int score;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616727;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWinFightBrd()
/*     */   {
/*  37 */     this.winner_leader = "";
/*  38 */     this.loser_leader = "";
/*     */   }
/*     */   
/*     */   public SWinFightBrd(String _winner_leader_, int _winner_number_, String _loser_leader_, int _loser_number_, int _score_) {
/*  42 */     this.winner_leader = _winner_leader_;
/*  43 */     this.winner_number = _winner_number_;
/*  44 */     this.loser_leader = _loser_leader_;
/*  45 */     this.loser_number = _loser_number_;
/*  46 */     this.score = _score_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.winner_leader, "UTF-16LE");
/*  55 */     _os_.marshal(this.winner_number);
/*  56 */     _os_.marshal(this.loser_leader, "UTF-16LE");
/*  57 */     _os_.marshal(this.loser_number);
/*  58 */     _os_.marshal(this.score);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.winner_leader = _os_.unmarshal_String("UTF-16LE");
/*  64 */     this.winner_number = _os_.unmarshal_int();
/*  65 */     this.loser_leader = _os_.unmarshal_String("UTF-16LE");
/*  66 */     this.loser_number = _os_.unmarshal_int();
/*  67 */     this.score = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SWinFightBrd)) {
/*  77 */       SWinFightBrd _o_ = (SWinFightBrd)_o1_;
/*  78 */       if (!this.winner_leader.equals(_o_.winner_leader)) return false;
/*  79 */       if (this.winner_number != _o_.winner_number) return false;
/*  80 */       if (!this.loser_leader.equals(_o_.loser_leader)) return false;
/*  81 */       if (this.loser_number != _o_.loser_number) return false;
/*  82 */       if (this.score != _o_.score) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.winner_leader.hashCode();
/*  91 */     _h_ += this.winner_number;
/*  92 */     _h_ += this.loser_leader.hashCode();
/*  93 */     _h_ += this.loser_number;
/*  94 */     _h_ += this.score;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append("T").append(this.winner_leader.length()).append(",");
/* 102 */     _sb_.append(this.winner_number).append(",");
/* 103 */     _sb_.append("T").append(this.loser_leader.length()).append(",");
/* 104 */     _sb_.append(this.loser_number).append(",");
/* 105 */     _sb_.append(this.score).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SWinFightBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */