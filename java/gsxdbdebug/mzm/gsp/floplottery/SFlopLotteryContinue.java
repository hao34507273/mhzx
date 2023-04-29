/*     */ package mzm.gsp.floplottery;
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
/*     */ 
/*     */ public class SFlopLotteryContinue
/*     */   extends __SFlopLotteryContinue__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618502;
/*     */   public long uid;
/*     */   public int floplotterymaincfgid;
/*     */   public ArrayList<FlopLotteryResult> floplotteryresultlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618502;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFlopLotteryContinue()
/*     */   {
/*  35 */     this.floplotteryresultlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SFlopLotteryContinue(long _uid_, int _floplotterymaincfgid_, ArrayList<FlopLotteryResult> _floplotteryresultlist_) {
/*  39 */     this.uid = _uid_;
/*  40 */     this.floplotterymaincfgid = _floplotterymaincfgid_;
/*  41 */     this.floplotteryresultlist = _floplotteryresultlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (FlopLotteryResult _v_ : this.floplotteryresultlist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.uid);
/*  52 */     _os_.marshal(this.floplotterymaincfgid);
/*  53 */     _os_.compact_uint32(this.floplotteryresultlist.size());
/*  54 */     for (FlopLotteryResult _v_ : this.floplotteryresultlist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.uid = _os_.unmarshal_long();
/*  62 */     this.floplotterymaincfgid = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       FlopLotteryResult _v_ = new FlopLotteryResult();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.floplotteryresultlist.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SFlopLotteryContinue)) {
/*  77 */       SFlopLotteryContinue _o_ = (SFlopLotteryContinue)_o1_;
/*  78 */       if (this.uid != _o_.uid) return false;
/*  79 */       if (this.floplotterymaincfgid != _o_.floplotterymaincfgid) return false;
/*  80 */       if (!this.floplotteryresultlist.equals(_o_.floplotteryresultlist)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.uid;
/*  89 */     _h_ += this.floplotterymaincfgid;
/*  90 */     _h_ += this.floplotteryresultlist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.uid).append(",");
/*  98 */     _sb_.append(this.floplotterymaincfgid).append(",");
/*  99 */     _sb_.append(this.floplotteryresultlist).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\SFlopLotteryContinue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */