/*     */ package mzm.gsp.bubblegame;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.bubblegame.main.PReportBubbleGameResult;
/*     */ 
/*     */ public class CReportBubbleGameResult
/*     */   extends __CReportBubbleGameResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12610052;
/*     */   public static final int RIGHT = 0;
/*     */   public static final int WRONG = 1;
/*     */   public int game_id;
/*     */   public int turn_index;
/*     */   public int result;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PReportBubbleGameResult(roleid, this.game_id, this.turn_index, this.result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12610052;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReportBubbleGameResult() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReportBubbleGameResult(int _game_id_, int _turn_index_, int _result_)
/*     */   {
/*  45 */     this.game_id = _game_id_;
/*  46 */     this.turn_index = _turn_index_;
/*  47 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.game_id);
/*  56 */     _os_.marshal(this.turn_index);
/*  57 */     _os_.marshal(this.result);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.game_id = _os_.unmarshal_int();
/*  63 */     this.turn_index = _os_.unmarshal_int();
/*  64 */     this.result = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CReportBubbleGameResult)) {
/*  74 */       CReportBubbleGameResult _o_ = (CReportBubbleGameResult)_o1_;
/*  75 */       if (this.game_id != _o_.game_id) return false;
/*  76 */       if (this.turn_index != _o_.turn_index) return false;
/*  77 */       if (this.result != _o_.result) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.game_id;
/*  86 */     _h_ += this.turn_index;
/*  87 */     _h_ += this.result;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.game_id).append(",");
/*  95 */     _sb_.append(this.turn_index).append(",");
/*  96 */     _sb_.append(this.result).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReportBubbleGameResult _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.game_id - _o_.game_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.turn_index - _o_.turn_index;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.result - _o_.result;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\CReportBubbleGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */