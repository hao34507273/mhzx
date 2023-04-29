/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMapCommonResult
/*     */   extends __SMapCommonResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590850;
/*     */   public static final int NOT_MY_FIGHT = 0;
/*     */   public static final int MONSTER_FIGHT_SUCCESS = 1;
/*     */   public static final int MONSTER_IN_FIGHT = 2;
/*     */   public static final int TEAM_LEADER_MUST_GANG_MEMBER = 3;
/*     */   public static final int TEAM_MEMBER_MUST_THREE_GANG_MEMBER = 4;
/*     */   public static final int CAN_NOT_FIGHT_MONSTER = 5;
/*     */   public static final int COMPETITION_MERCENARY_NOT_TIME = 7;
/*     */   public static final int COMPETITION_MERCENARY_SELF = 8;
/*     */   public static final int COMPETITION_MERCENARY_DISRELATED = 9;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590850;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int COMPETITION_MERCENARY_FINISHED = 10;
/*     */   
/*     */   public static final int FACTION_PVE_NOT_TIME = 11;
/*     */   
/*     */   public static final int FACTION_PVE_DISRELATED = 12;
/*     */   
/*     */   public static final int GATHER_SUCCESS = 101;
/*     */   
/*     */   public static final int MAPITEM_ALREADY_GATHERED = 102;
/*     */   
/*     */   public static final int BAG_FULL = 103;
/*     */   
/*     */   public static final int ERROR_DAILY_GATHER_TIMES_LIMIT = 104;
/*     */   
/*     */   public static final int ERROR_GATHER_INTERVAL = 105;
/*     */   
/*     */   public static final int DISTANCE_NOT_MATCH = 201;
/*     */   
/*     */   public static final int CAN_NOT_TRANSFER = 211;
/*     */   
/*     */   public int result;
/*     */   public SMapCommonResult() {}
/*     */   
/*     */   public SMapCommonResult(int _result_)
/*     */   {
/*  56 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.result);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.result = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SMapCommonResult)) {
/*  79 */       SMapCommonResult _o_ = (SMapCommonResult)_o1_;
/*  80 */       if (this.result != _o_.result) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.result;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.result).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMapCommonResult _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.result - _o_.result;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapCommonResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */