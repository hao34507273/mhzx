/*     */ package mzm.gsp.competition;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SWinLoseBrd
/*     */   extends __SWinLoseBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598549;
/*     */   public static final int RESULT__GIVE_UP = 1;
/*     */   public static final int RESULT__EARLY = 2;
/*     */   public static final int RESULT__TIMEOUT = 3;
/*     */   public long winner_id;
/*     */   public String winner_name;
/*     */   public long loser_id;
/*     */   public String loser_name;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12598549;
/*     */   }
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
/*     */   public SWinLoseBrd()
/*     */   {
/*  41 */     this.winner_name = "";
/*  42 */     this.loser_name = "";
/*     */   }
/*     */   
/*     */   public SWinLoseBrd(long _winner_id_, String _winner_name_, long _loser_id_, String _loser_name_, int _result_) {
/*  46 */     this.winner_id = _winner_id_;
/*  47 */     this.winner_name = _winner_name_;
/*  48 */     this.loser_id = _loser_id_;
/*  49 */     this.loser_name = _loser_name_;
/*  50 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.winner_id);
/*  59 */     _os_.marshal(this.winner_name, "UTF-16LE");
/*  60 */     _os_.marshal(this.loser_id);
/*  61 */     _os_.marshal(this.loser_name, "UTF-16LE");
/*  62 */     _os_.marshal(this.result);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.winner_id = _os_.unmarshal_long();
/*  68 */     this.winner_name = _os_.unmarshal_String("UTF-16LE");
/*  69 */     this.loser_id = _os_.unmarshal_long();
/*  70 */     this.loser_name = _os_.unmarshal_String("UTF-16LE");
/*  71 */     this.result = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SWinLoseBrd)) {
/*  81 */       SWinLoseBrd _o_ = (SWinLoseBrd)_o1_;
/*  82 */       if (this.winner_id != _o_.winner_id) return false;
/*  83 */       if (!this.winner_name.equals(_o_.winner_name)) return false;
/*  84 */       if (this.loser_id != _o_.loser_id) return false;
/*  85 */       if (!this.loser_name.equals(_o_.loser_name)) return false;
/*  86 */       if (this.result != _o_.result) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.winner_id;
/*  95 */     _h_ += this.winner_name.hashCode();
/*  96 */     _h_ += (int)this.loser_id;
/*  97 */     _h_ += this.loser_name.hashCode();
/*  98 */     _h_ += this.result;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.winner_id).append(",");
/* 106 */     _sb_.append("T").append(this.winner_name.length()).append(",");
/* 107 */     _sb_.append(this.loser_id).append(",");
/* 108 */     _sb_.append("T").append(this.loser_name.length()).append(",");
/* 109 */     _sb_.append(this.result).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SWinLoseBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */