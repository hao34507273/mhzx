/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class GangInfo
/*     */   implements Marshal
/*     */ {
/*     */   public long gangid;
/*     */   public String name;
/*     */   public int level;
/*     */   public String bangzhu;
/*     */   public String purpose;
/*     */   public int membernum;
/*     */   public int xiangfanglevel;
/*     */   public long displayid;
/*     */   
/*     */   public GangInfo()
/*     */   {
/*  21 */     this.name = "";
/*  22 */     this.bangzhu = "";
/*  23 */     this.purpose = "";
/*  24 */     this.displayid = 0L;
/*     */   }
/*     */   
/*     */   public GangInfo(long _gangid_, String _name_, int _level_, String _bangzhu_, String _purpose_, int _membernum_, int _xiangfanglevel_, long _displayid_) {
/*  28 */     this.gangid = _gangid_;
/*  29 */     this.name = _name_;
/*  30 */     this.level = _level_;
/*  31 */     this.bangzhu = _bangzhu_;
/*  32 */     this.purpose = _purpose_;
/*  33 */     this.membernum = _membernum_;
/*  34 */     this.xiangfanglevel = _xiangfanglevel_;
/*  35 */     this.displayid = _displayid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.gangid);
/*  44 */     _os_.marshal(this.name, "UTF-16LE");
/*  45 */     _os_.marshal(this.level);
/*  46 */     _os_.marshal(this.bangzhu, "UTF-16LE");
/*  47 */     _os_.marshal(this.purpose, "UTF-16LE");
/*  48 */     _os_.marshal(this.membernum);
/*  49 */     _os_.marshal(this.xiangfanglevel);
/*  50 */     _os_.marshal(this.displayid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.gangid = _os_.unmarshal_long();
/*  56 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  57 */     this.level = _os_.unmarshal_int();
/*  58 */     this.bangzhu = _os_.unmarshal_String("UTF-16LE");
/*  59 */     this.purpose = _os_.unmarshal_String("UTF-16LE");
/*  60 */     this.membernum = _os_.unmarshal_int();
/*  61 */     this.xiangfanglevel = _os_.unmarshal_int();
/*  62 */     this.displayid = _os_.unmarshal_long();
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof GangInfo)) {
/*  69 */       GangInfo _o_ = (GangInfo)_o1_;
/*  70 */       if (this.gangid != _o_.gangid) return false;
/*  71 */       if (!this.name.equals(_o_.name)) return false;
/*  72 */       if (this.level != _o_.level) return false;
/*  73 */       if (!this.bangzhu.equals(_o_.bangzhu)) return false;
/*  74 */       if (!this.purpose.equals(_o_.purpose)) return false;
/*  75 */       if (this.membernum != _o_.membernum) return false;
/*  76 */       if (this.xiangfanglevel != _o_.xiangfanglevel) return false;
/*  77 */       if (this.displayid != _o_.displayid) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.gangid;
/*  86 */     _h_ += this.name.hashCode();
/*  87 */     _h_ += this.level;
/*  88 */     _h_ += this.bangzhu.hashCode();
/*  89 */     _h_ += this.purpose.hashCode();
/*  90 */     _h_ += this.membernum;
/*  91 */     _h_ += this.xiangfanglevel;
/*  92 */     _h_ += (int)this.displayid;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.gangid).append(",");
/* 100 */     _sb_.append("T").append(this.name.length()).append(",");
/* 101 */     _sb_.append(this.level).append(",");
/* 102 */     _sb_.append("T").append(this.bangzhu.length()).append(",");
/* 103 */     _sb_.append("T").append(this.purpose.length()).append(",");
/* 104 */     _sb_.append(this.membernum).append(",");
/* 105 */     _sb_.append(this.xiangfanglevel).append(",");
/* 106 */     _sb_.append(this.displayid).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\GangInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */