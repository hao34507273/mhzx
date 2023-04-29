/*     */ package mzm.gsp.chinesevalentine;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SChineseValentineJoinFailRep
/*     */   extends __SChineseValentineJoinFailRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622082;
/*     */   public static final int MEMBER_COUNT_ERROR = 1;
/*     */   public static final int MEMBER_LEVEL_NOT_ENOUGH = 2;
/*     */   public static final int ACTIVITY_CLOSED = 3;
/*     */   public static final int NPC_SERVICE_NOT_AVAILABLE = 4;
/*     */   public static final int NOT_NEARBY_NPC = 5;
/*     */   public static final int TEAM_NOT_EXIST = 6;
/*     */   public static final int IS_NOT_LEADER = 7;
/*     */   public static final int TEAM_MEMBER_STATE_ERROR = 8;
/*     */   public static final int TEAM_CHANGED = 9;
/*     */   public static final int TEAM_MEMBER_AlREADY_IN_GAME = 10;
/*     */   public int code;
/*     */   public int activityid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12622082;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChineseValentineJoinFailRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChineseValentineJoinFailRep(int _code_, int _activityid_)
/*     */   {
/*  48 */     this.code = _code_;
/*  49 */     this.activityid = _activityid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.code);
/*  58 */     _os_.marshal(this.activityid);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.code = _os_.unmarshal_int();
/*  64 */     this.activityid = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SChineseValentineJoinFailRep)) {
/*  74 */       SChineseValentineJoinFailRep _o_ = (SChineseValentineJoinFailRep)_o1_;
/*  75 */       if (this.code != _o_.code) return false;
/*  76 */       if (this.activityid != _o_.activityid) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.code;
/*  85 */     _h_ += this.activityid;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.code).append(",");
/*  93 */     _sb_.append(this.activityid).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChineseValentineJoinFailRep _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.code - _o_.code;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.activityid - _o_.activityid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\SChineseValentineJoinFailRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */