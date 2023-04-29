/*     */ package mzm.gsp.floor;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.award.AwardBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSweepFloorSuc
/*     */   extends __SSweepFloorSuc__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617752;
/*     */   public int activityid;
/*     */   public HashSet<Integer> floors;
/*     */   public AwardBean awardbean;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617752;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSweepFloorSuc()
/*     */   {
/*  35 */     this.floors = new HashSet();
/*  36 */     this.awardbean = new AwardBean();
/*     */   }
/*     */   
/*     */   public SSweepFloorSuc(int _activityid_, HashSet<Integer> _floors_, AwardBean _awardbean_) {
/*  40 */     this.activityid = _activityid_;
/*  41 */     this.floors = _floors_;
/*  42 */     this.awardbean = _awardbean_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     if (!this.awardbean._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.activityid);
/*  52 */     _os_.compact_uint32(this.floors.size());
/*  53 */     for (Integer _v_ : this.floors) {
/*  54 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  56 */     _os_.marshal(this.awardbean);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activityid = _os_.unmarshal_int();
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  64 */       int _v_ = _os_.unmarshal_int();
/*  65 */       this.floors.add(Integer.valueOf(_v_));
/*     */     }
/*  67 */     this.awardbean.unmarshal(_os_);
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSweepFloorSuc)) {
/*  77 */       SSweepFloorSuc _o_ = (SSweepFloorSuc)_o1_;
/*  78 */       if (this.activityid != _o_.activityid) return false;
/*  79 */       if (!this.floors.equals(_o_.floors)) return false;
/*  80 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activityid;
/*  89 */     _h_ += this.floors.hashCode();
/*  90 */     _h_ += this.awardbean.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activityid).append(",");
/*  98 */     _sb_.append(this.floors).append(",");
/*  99 */     _sb_.append(this.awardbean).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\SSweepFloorSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */