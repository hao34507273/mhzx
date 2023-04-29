/*     */ package mzm.gsp.chinesevalentine;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChineseValentineGameInfo
/*     */   extends __SChineseValentineGameInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622086;
/*     */   public ArrayList<Long> roleidlist;
/*     */   public int roundnumber;
/*     */   public int rightcount;
/*     */   public int wrongcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12622086;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChineseValentineGameInfo()
/*     */   {
/*  36 */     this.roleidlist = new ArrayList();
/*  37 */     this.roundnumber = 1;
/*     */   }
/*     */   
/*     */   public SChineseValentineGameInfo(ArrayList<Long> _roleidlist_, int _roundnumber_, int _rightcount_, int _wrongcount_) {
/*  41 */     this.roleidlist = _roleidlist_;
/*  42 */     this.roundnumber = _roundnumber_;
/*  43 */     this.rightcount = _rightcount_;
/*  44 */     this.wrongcount = _wrongcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.roleidlist.size());
/*  53 */     for (Long _v_ : this.roleidlist) {
/*  54 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  56 */     _os_.marshal(this.roundnumber);
/*  57 */     _os_.marshal(this.rightcount);
/*  58 */     _os_.marshal(this.wrongcount);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  65 */       long _v_ = _os_.unmarshal_long();
/*  66 */       this.roleidlist.add(Long.valueOf(_v_));
/*     */     }
/*  68 */     this.roundnumber = _os_.unmarshal_int();
/*  69 */     this.rightcount = _os_.unmarshal_int();
/*  70 */     this.wrongcount = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SChineseValentineGameInfo)) {
/*  80 */       SChineseValentineGameInfo _o_ = (SChineseValentineGameInfo)_o1_;
/*  81 */       if (!this.roleidlist.equals(_o_.roleidlist)) return false;
/*  82 */       if (this.roundnumber != _o_.roundnumber) return false;
/*  83 */       if (this.rightcount != _o_.rightcount) return false;
/*  84 */       if (this.wrongcount != _o_.wrongcount) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.roleidlist.hashCode();
/*  93 */     _h_ += this.roundnumber;
/*  94 */     _h_ += this.rightcount;
/*  95 */     _h_ += this.wrongcount;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.roleidlist).append(",");
/* 103 */     _sb_.append(this.roundnumber).append(",");
/* 104 */     _sb_.append(this.rightcount).append(",");
/* 105 */     _sb_.append(this.wrongcount).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\SChineseValentineGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */