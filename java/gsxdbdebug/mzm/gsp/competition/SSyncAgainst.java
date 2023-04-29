/*     */ package mzm.gsp.competition;
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
/*     */ public class SSyncAgainst
/*     */   extends __SSyncAgainst__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598534;
/*     */   public CompeteFaction self_faction;
/*     */   public String self_name;
/*     */   public CompeteFaction opponent_faction;
/*     */   public String opponent_name;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12598534;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncAgainst()
/*     */   {
/*  36 */     this.self_faction = new CompeteFaction();
/*  37 */     this.self_name = "";
/*  38 */     this.opponent_faction = new CompeteFaction();
/*  39 */     this.opponent_name = "";
/*     */   }
/*     */   
/*     */   public SSyncAgainst(CompeteFaction _self_faction_, String _self_name_, CompeteFaction _opponent_faction_, String _opponent_name_) {
/*  43 */     this.self_faction = _self_faction_;
/*  44 */     this.self_name = _self_name_;
/*  45 */     this.opponent_faction = _opponent_faction_;
/*  46 */     this.opponent_name = _opponent_name_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.self_faction._validator_()) return false;
/*  51 */     if (!this.opponent_faction._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.self_faction);
/*  57 */     _os_.marshal(this.self_name, "UTF-16LE");
/*  58 */     _os_.marshal(this.opponent_faction);
/*  59 */     _os_.marshal(this.opponent_name, "UTF-16LE");
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.self_faction.unmarshal(_os_);
/*  65 */     this.self_name = _os_.unmarshal_String("UTF-16LE");
/*  66 */     this.opponent_faction.unmarshal(_os_);
/*  67 */     this.opponent_name = _os_.unmarshal_String("UTF-16LE");
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSyncAgainst)) {
/*  77 */       SSyncAgainst _o_ = (SSyncAgainst)_o1_;
/*  78 */       if (!this.self_faction.equals(_o_.self_faction)) return false;
/*  79 */       if (!this.self_name.equals(_o_.self_name)) return false;
/*  80 */       if (!this.opponent_faction.equals(_o_.opponent_faction)) return false;
/*  81 */       if (!this.opponent_name.equals(_o_.opponent_name)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.self_faction.hashCode();
/*  90 */     _h_ += this.self_name.hashCode();
/*  91 */     _h_ += this.opponent_faction.hashCode();
/*  92 */     _h_ += this.opponent_name.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.self_faction).append(",");
/* 100 */     _sb_.append("T").append(this.self_name.length()).append(",");
/* 101 */     _sb_.append(this.opponent_faction).append(",");
/* 102 */     _sb_.append("T").append(this.opponent_name.length()).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SSyncAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */