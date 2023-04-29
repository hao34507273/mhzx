/*     */ package mzm.gsp.sworn;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SAddNewMemberRes extends __SAddNewMemberRes__ {
/*     */   public static final int PROTOCOL_TYPE = 12597802;
/*     */   public static final int SUCCESS = 0;
/*     */   public static final int ERROR_UNKNOWN = 1;
/*     */   public static final int ERROR_MAX_SWORN_MEMBER = 2;
/*     */   public static final int ERROR_SILVER_NOT_ENOUGH = 3;
/*     */   public static final int ERROR_NOT_TEAM = 4;
/*     */   public static final int ERROR_NOT_TEAM_LEADER = 5;
/*     */   public static final int ERROR_TEAM_COUNT = 6;
/*     */   public static final int ERROR_LEADER_NO_SWORN = 7;
/*     */   public static final int ERROR_MEMBER_SWORN = 8;
/*     */   public static final int ERROR_MEMBER_FRIEND = 9;
/*     */   public static final int ERROR_MEMBER_FRIEND_VALUE = 10;
/*     */   public static final int ERROR_MEMBER_LEVEL = 11;
/*     */   public static final int ERROR_VOTEING = 12;
/*     */   public static final int ERROR_VOTE_NOT_AGREE = 13;
/*     */   public int resultcode;
/*     */   public java.util.ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12597802;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAddNewMemberRes()
/*     */   {
/*  49 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SAddNewMemberRes(int _resultcode_, java.util.ArrayList<String> _args_) {
/*  53 */     this.resultcode = _resultcode_;
/*  54 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.resultcode);
/*  63 */     _os_.compact_uint32(this.args.size());
/*  64 */     for (String _v_ : this.args) {
/*  65 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  71 */     this.resultcode = _os_.unmarshal_int();
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  74 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  75 */       this.args.add(_v_);
/*     */     }
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SAddNewMemberRes)) {
/*  86 */       SAddNewMemberRes _o_ = (SAddNewMemberRes)_o1_;
/*  87 */       if (this.resultcode != _o_.resultcode) return false;
/*  88 */       if (!this.args.equals(_o_.args)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.resultcode;
/*  97 */     _h_ += this.args.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.resultcode).append(",");
/* 105 */     _sb_.append(this.args).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SAddNewMemberRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */