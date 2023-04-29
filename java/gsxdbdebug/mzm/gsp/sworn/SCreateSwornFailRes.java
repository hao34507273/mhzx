/*     */ package mzm.gsp.sworn;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCreateSwornFailRes
/*     */   extends __SCreateSwornFailRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597769;
/*     */   public static final int ERROR_UNKNOWN = 0;
/*     */   public static final int ERROR_CREATE_TEAM = 1;
/*     */   public static final int ERROR_PLAYERSWORN = 2;
/*     */   public static final int ERROR_CREATE_PLAYERCOUNT = 3;
/*     */   public static final int ERROR_CREATE_NOTFRIEND = 4;
/*     */   public static final int ERROR_CREATE_FRIENDVALUE = 5;
/*     */   public static final int ERROR_CREATE_NOTAGREE = 6;
/*     */   public static final int ERROR_CREATE_NOTAGREENAME = 7;
/*     */   public static final int ERROR_CREATE_SILVER = 8;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597769;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ERROR_CREATE_OVERTIME = 9;
/*     */   
/*     */   public static final int ERROR_CREATE_TEAMCHANGE = 10;
/*     */   
/*     */   public static final int ERROR_CREATE_TEAMLEADER = 11;
/*     */   
/*     */   public static final int ERROR_CREATE_OVERLAP = 12;
/*     */   
/*     */   public static final int ERROR_CREATE_PLAYERLEVEL = 13;
/*     */   
/*     */   public static final int ERROR_NAME_OVERLAP = 14;
/*     */   
/*     */   public static final int ERROR_TEAM_MEMBER_STATUS = 15;
/*     */   
/*     */   public int resultcode;
/*     */   
/*     */   public String name1;
/*     */   
/*     */   public String name2;
/*     */   public SCreateSwornFailRes()
/*     */   {
/*  52 */     this.name1 = "";
/*  53 */     this.name2 = "";
/*     */   }
/*     */   
/*     */   public SCreateSwornFailRes(int _resultcode_, String _name1_, String _name2_) {
/*  57 */     this.resultcode = _resultcode_;
/*  58 */     this.name1 = _name1_;
/*  59 */     this.name2 = _name2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.resultcode);
/*  68 */     _os_.marshal(this.name1, "UTF-16LE");
/*  69 */     _os_.marshal(this.name2, "UTF-16LE");
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.resultcode = _os_.unmarshal_int();
/*  75 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  76 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SCreateSwornFailRes)) {
/*  86 */       SCreateSwornFailRes _o_ = (SCreateSwornFailRes)_o1_;
/*  87 */       if (this.resultcode != _o_.resultcode) return false;
/*  88 */       if (!this.name1.equals(_o_.name1)) return false;
/*  89 */       if (!this.name2.equals(_o_.name2)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.resultcode;
/*  98 */     _h_ += this.name1.hashCode();
/*  99 */     _h_ += this.name2.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.resultcode).append(",");
/* 107 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 108 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SCreateSwornFailRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */