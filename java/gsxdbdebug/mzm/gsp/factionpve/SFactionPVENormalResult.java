/*     */ package mzm.gsp.factionpve;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SFactionPVENormalResult
/*     */   extends __SFactionPVENormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613633;
/*     */   public static final int ENTER_FACTIONPVE_MAP__SELF_LOW_LEVEL = 1;
/*     */   public static final int ENTER_FACTIONPVE_MAP__TEAM_LOW_LEVEL = 2;
/*     */   public static final int ENTER_FACTIONPVE_MAP__NOT_TIME = 3;
/*     */   public static final int ENTER_FACTIONPVE_MAP__DIFF_FACTION = 4;
/*     */   public static final int ENTER_FACTIONPVE_MAP__SELF_JUST_JOIN = 5;
/*     */   public static final int ENTER_FACTIONPVE_MAP__TEAM_JUST_JOIN = 6;
/*     */   public static final int ENTER_FACTIONPVE_MAP__SELF_PARTICIPATED = 7;
/*     */   public static final int ENTER_FACTIONPVE_MAP__TEAM_PARTICIPATED = 8;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12613633;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ENTER_FACTIONPVE_MAP__SELF_MAX_TIMES = 9;
/*     */   
/*     */   public static final int ENTER_FACTIONPVE_MAP__TEAM_MAX_TIMES = 10;
/*     */   
/*     */   public static final int LEAVE_FACTIONPVE_MAP__IN_TEAM = 21;
/*     */   
/*     */   public static final int LEAVE_FACTIONPVE_MAP__NOT_LEADER = 22;
/*     */   
/*     */   public static final int SET_START_TIME__ACTIVITY_TIME = 41;
/*     */   
/*     */   public static final int SET_START_TIME__LACK_MONEY = 42;
/*     */   
/*     */   public static final int SET_START_TIME__JUST_CREATE = 43;
/*     */   
/*     */   public static final int SET_START_TIME__TOO_CLOSE = 44;
/*     */   
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   public SFactionPVENormalResult()
/*     */   {
/*  49 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SFactionPVENormalResult(int _result_, ArrayList<String> _args_) {
/*  53 */     this.result = _result_;
/*  54 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.result);
/*  63 */     _os_.compact_uint32(this.args.size());
/*  64 */     for (String _v_ : this.args) {
/*  65 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.result = _os_.unmarshal_int();
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
/*  85 */     if ((_o1_ instanceof SFactionPVENormalResult)) {
/*  86 */       SFactionPVENormalResult _o_ = (SFactionPVENormalResult)_o1_;
/*  87 */       if (this.result != _o_.result) return false;
/*  88 */       if (!this.args.equals(_o_.args)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.result;
/*  97 */     _h_ += this.args.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.result).append(",");
/* 105 */     _sb_.append(this.args).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SFactionPVENormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */