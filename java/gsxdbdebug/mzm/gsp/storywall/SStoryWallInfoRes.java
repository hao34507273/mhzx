/*     */ package mzm.gsp.storywall;
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
/*     */ 
/*     */ public class SStoryWallInfoRes
/*     */   extends __SStoryWallInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606469;
/*     */   public ArrayList<Integer> storyids;
/*     */   public ArrayList<Integer> readstoryids;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606469;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SStoryWallInfoRes()
/*     */   {
/*  34 */     this.storyids = new ArrayList();
/*  35 */     this.readstoryids = new ArrayList();
/*     */   }
/*     */   
/*     */   public SStoryWallInfoRes(ArrayList<Integer> _storyids_, ArrayList<Integer> _readstoryids_) {
/*  39 */     this.storyids = _storyids_;
/*  40 */     this.readstoryids = _readstoryids_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.storyids.size());
/*  49 */     for (Integer _v_ : this.storyids) {
/*  50 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  52 */     _os_.compact_uint32(this.readstoryids.size());
/*  53 */     for (Integer _v_ : this.readstoryids) {
/*  54 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  62 */       int _v_ = _os_.unmarshal_int();
/*  63 */       this.storyids.add(Integer.valueOf(_v_));
/*     */     }
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.readstoryids.add(Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SStoryWallInfoRes)) {
/*  79 */       SStoryWallInfoRes _o_ = (SStoryWallInfoRes)_o1_;
/*  80 */       if (!this.storyids.equals(_o_.storyids)) return false;
/*  81 */       if (!this.readstoryids.equals(_o_.readstoryids)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.storyids.hashCode();
/*  90 */     _h_ += this.readstoryids.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.storyids).append(",");
/*  98 */     _sb_.append(this.readstoryids).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storywall\SStoryWallInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */