/*     */ package mzm.gsp.coupledaily;
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
/*     */ public class SGetCoupleDailyInfo
/*     */   extends __SGetCoupleDailyInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602380;
/*     */   public ArrayList<Integer> tasklist;
/*     */   public ArrayList<Integer> finishtasklist;
/*     */   public int isaward;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602380;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCoupleDailyInfo()
/*     */   {
/*  35 */     this.tasklist = new ArrayList();
/*  36 */     this.finishtasklist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetCoupleDailyInfo(ArrayList<Integer> _tasklist_, ArrayList<Integer> _finishtasklist_, int _isaward_) {
/*  40 */     this.tasklist = _tasklist_;
/*  41 */     this.finishtasklist = _finishtasklist_;
/*  42 */     this.isaward = _isaward_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.compact_uint32(this.tasklist.size());
/*  51 */     for (Integer _v_ : this.tasklist) {
/*  52 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  54 */     _os_.compact_uint32(this.finishtasklist.size());
/*  55 */     for (Integer _v_ : this.finishtasklist) {
/*  56 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  58 */     _os_.marshal(this.isaward);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  65 */       int _v_ = _os_.unmarshal_int();
/*  66 */       this.tasklist.add(Integer.valueOf(_v_));
/*     */     }
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.finishtasklist.add(Integer.valueOf(_v_));
/*     */     }
/*  73 */     this.isaward = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SGetCoupleDailyInfo)) {
/*  83 */       SGetCoupleDailyInfo _o_ = (SGetCoupleDailyInfo)_o1_;
/*  84 */       if (!this.tasklist.equals(_o_.tasklist)) return false;
/*  85 */       if (!this.finishtasklist.equals(_o_.finishtasklist)) return false;
/*  86 */       if (this.isaward != _o_.isaward) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.tasklist.hashCode();
/*  95 */     _h_ += this.finishtasklist.hashCode();
/*  96 */     _h_ += this.isaward;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.tasklist).append(",");
/* 104 */     _sb_.append(this.finishtasklist).append(",");
/* 105 */     _sb_.append(this.isaward).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\SGetCoupleDailyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */