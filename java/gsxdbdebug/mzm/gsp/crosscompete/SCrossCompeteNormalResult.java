/*     */ package mzm.gsp.crosscompete;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SCrossCompeteNormalResult
/*     */   extends __SCrossCompeteNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616721;
/*     */   public static final int SIGN_UP__NO_RIGHT = 1;
/*     */   public static final int SIGN_UP__LEVEL = 2;
/*     */   public static final int SIGN_UP__CREATE = 3;
/*     */   public static final int SIGN_UP__VITALITY = 4;
/*     */   public static final int SIGN_UP__QUALIFIED_MEMBER_COUNT = 5;
/*     */   public static final int SIGN_UP__COMBINE = 6;
/*     */   public static final int SIGN_UP__STAGE = 7;
/*     */   public static final int SIGN_UP__ALREADY = 8;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12616721;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__NO_FACTION = 11;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__NOT_MATCH = 12;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__TEAM_TMP_LEAVE = 13;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__NOT_ALL_NORMAL = 14;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__DIFF_FACTION = 15;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__TEAM_STATUS = 16;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__SELF_NOT_NORMAL_MEMBER = 17;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__TEAM_NOT_NORMAL_MEMBER = 18;
/*     */   
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__SELF_JUST_JOIN = 19;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__TEAM_JUST_JOIN = 20;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__NOT_ACTIVITY_TIME = 21;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__END = 22;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__NO_ENTER = 23;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__CONNECT_ROAM = 24;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__SELF_LEVEL = 25;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP__MEMBER_LEVEL = 26;
/*     */   public static final int ATTACK__SELF_LACK_ACTION_POINT = 31;
/*     */   public static final int ATTACK__OHTER_LACK_ACTION_POINT = 32;
/*     */   public static final int ATTACK__FRIEND_PROTECTED = 33;
/*     */   public static final int ATTACK__ENEMY_PROTECTED = 34;
/*     */   public static final int ATTACK__FRIEND_IN_FIGHT = 35;
/*     */   public static final int ATTACK__ENEMY_IN_FIGHT = 36;
/*     */   public static final int LEAVE_CROSS_COMPETE_MAP__NO_ACTION_POINT = 41;
/*     */   public static final int LEAVE_CROSS_COMPETE_MAP__IN_TEAM = 42;
/*     */   public static final int LEAVE_CROSS_COMPETE_MAP__NOT_LEADER = 43;
/*     */   public static final int LEAVE_CROSS_COMPETE_MAP__NOT_ALL_NORMAL = 44;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   public SCrossCompeteNormalResult()
/*     */   {
/*  67 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SCrossCompeteNormalResult(int _result_, ArrayList<String> _args_) {
/*  71 */     this.result = _result_;
/*  72 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  80 */     _os_.marshal(this.result);
/*  81 */     _os_.compact_uint32(this.args.size());
/*  82 */     for (String _v_ : this.args) {
/*  83 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  89 */     this.result = _os_.unmarshal_int();
/*  90 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  92 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  93 */       this.args.add(_v_);
/*     */     }
/*  95 */     if (!_validator_()) {
/*  96 */       throw new VerifyError("validator failed");
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 102 */     if (_o1_ == this) return true;
/* 103 */     if ((_o1_ instanceof SCrossCompeteNormalResult)) {
/* 104 */       SCrossCompeteNormalResult _o_ = (SCrossCompeteNormalResult)_o1_;
/* 105 */       if (this.result != _o_.result) return false;
/* 106 */       if (!this.args.equals(_o_.args)) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += this.result;
/* 115 */     _h_ += this.args.hashCode();
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.result).append(",");
/* 123 */     _sb_.append(this.args).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SCrossCompeteNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */