/*     */ package mzm.gsp.competition;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SCompetitionNormalResult extends __SCompetitionNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598532;
/*     */   public static final int ENTER_COMPETITION_MAP__SELF_NO_ACTION_POINT = 1;
/*     */   public static final int ENTER_COMPETITION_MAP__OTHER_NO_ACTION_POINT = 2;
/*     */   public static final int ENTER_COMPETITION_MAP__SELF_PARTICIPATED = 3;
/*     */   public static final int ENTER_COMPETITION_MAP__OTHER_PARTICIPATED = 4;
/*     */   public static final int ENTER_COMPETITION_MAP__DIFF_FACTION = 5;
/*     */   public static final int ENTER_COMPETITION_MAP__TEAM_STATUS = 6;
/*     */   public static final int ENTER_COMPETITION_MAP__SELF_NOT_NORMAL_MEMBER = 7;
/*     */   public static final int ENTER_COMPETITION_MAP__TEAM_NOT_NORMAL_MEMBER = 8;
/*     */   public static final int ENTER_COMPETITION_MAP__SELF_JUST_JOIN = 9;
/*     */   public static final int ENTER_COMPETITION_MAP__TEAM_JUST_JOIN = 10;
/*     */   public static final int ENTER_COMPETITION_MAP__NOT_ACTIVITY_TIME = 11;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12598532;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ENTER_COMPETITION_MAP__END = 12;
/*     */   
/*     */   public static final int ENTER_COMPETITION_MAP__NO_ENTER = 13;
/*     */   
/*     */   public static final int ATTACK__SELF_LACK_ACTION_POINT = 21;
/*     */   
/*     */   public static final int ATTACK__OHTER_LACK_ACTION_POINT = 22;
/*     */   
/*     */   public static final int ATTACK__FRIEND_PROTECTED = 23;
/*     */   
/*     */   public static final int ATTACK__ENEMY_PROTECTED = 24;
/*     */   
/*     */   public static final int ATTACK__FRIEND_IN_FIGHT = 25;
/*     */   
/*     */   public static final int ATTACK__ENEMY_IN_FIGHT = 26;
/*     */   
/*     */   public static final int LEAVE_COMPETITION_MAP__NO_ACTION_POINT = 31;
/*     */   
/*     */   public static final int LEAVE_COMPETITION_MAP__IN_TEAM = 32;
/*     */   
/*     */   public int result;
/*     */   
/*     */   public ArrayList<String> args;
/*     */   public SCompetitionNormalResult()
/*     */   {
/*  54 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SCompetitionNormalResult(int _result_, ArrayList<String> _args_) {
/*  58 */     this.result = _result_;
/*  59 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.result);
/*  68 */     _os_.compact_uint32(this.args.size());
/*  69 */     for (String _v_ : this.args) {
/*  70 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  76 */     this.result = _os_.unmarshal_int();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  79 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  80 */       this.args.add(_v_);
/*     */     }
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SCompetitionNormalResult)) {
/*  91 */       SCompetitionNormalResult _o_ = (SCompetitionNormalResult)_o1_;
/*  92 */       if (this.result != _o_.result) return false;
/*  93 */       if (!this.args.equals(_o_.args)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.result;
/* 102 */     _h_ += this.args.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.result).append(",");
/* 110 */     _sb_.append(this.args).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SCompetitionNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */