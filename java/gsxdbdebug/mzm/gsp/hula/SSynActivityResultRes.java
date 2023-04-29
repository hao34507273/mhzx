/*     */ package mzm.gsp.hula;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynActivityResultRes
/*     */   extends __SSynActivityResultRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12608781;
/*     */   public int point;
/*     */   public HashMap<Integer, Integer> delete_monsterid_2_count;
/*     */   public HashMap<Integer, Integer> delete_type_2_count;
/*     */   public HashMap<Integer, Integer> kill_monsterid_2_count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12608781;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynActivityResultRes()
/*     */   {
/*  36 */     this.delete_monsterid_2_count = new HashMap();
/*  37 */     this.delete_type_2_count = new HashMap();
/*  38 */     this.kill_monsterid_2_count = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynActivityResultRes(int _point_, HashMap<Integer, Integer> _delete_monsterid_2_count_, HashMap<Integer, Integer> _delete_type_2_count_, HashMap<Integer, Integer> _kill_monsterid_2_count_) {
/*  42 */     this.point = _point_;
/*  43 */     this.delete_monsterid_2_count = _delete_monsterid_2_count_;
/*  44 */     this.delete_type_2_count = _delete_type_2_count_;
/*  45 */     this.kill_monsterid_2_count = _kill_monsterid_2_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.point);
/*  54 */     _os_.compact_uint32(this.delete_monsterid_2_count.size());
/*  55 */     for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  59 */     _os_.compact_uint32(this.delete_type_2_count.size());
/*  60 */     for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet()) {
/*  61 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  62 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  64 */     _os_.compact_uint32(this.kill_monsterid_2_count.size());
/*  65 */     for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet()) {
/*  66 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  67 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     this.point = _os_.unmarshal_int();
/*  74 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  76 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  78 */       int _v_ = _os_.unmarshal_int();
/*  79 */       this.delete_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  85 */       int _v_ = _os_.unmarshal_int();
/*  86 */       this.delete_type_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  92 */       int _v_ = _os_.unmarshal_int();
/*  93 */       this.kill_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  95 */     if (!_validator_()) {
/*  96 */       throw new VerifyError("validator failed");
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 102 */     if (_o1_ == this) return true;
/* 103 */     if ((_o1_ instanceof SSynActivityResultRes)) {
/* 104 */       SSynActivityResultRes _o_ = (SSynActivityResultRes)_o1_;
/* 105 */       if (this.point != _o_.point) return false;
/* 106 */       if (!this.delete_monsterid_2_count.equals(_o_.delete_monsterid_2_count)) return false;
/* 107 */       if (!this.delete_type_2_count.equals(_o_.delete_type_2_count)) return false;
/* 108 */       if (!this.kill_monsterid_2_count.equals(_o_.kill_monsterid_2_count)) return false;
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 115 */     int _h_ = 0;
/* 116 */     _h_ += this.point;
/* 117 */     _h_ += this.delete_monsterid_2_count.hashCode();
/* 118 */     _h_ += this.delete_type_2_count.hashCode();
/* 119 */     _h_ += this.kill_monsterid_2_count.hashCode();
/* 120 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder _sb_ = new StringBuilder();
/* 125 */     _sb_.append("(");
/* 126 */     _sb_.append(this.point).append(",");
/* 127 */     _sb_.append(this.delete_monsterid_2_count).append(",");
/* 128 */     _sb_.append(this.delete_type_2_count).append(",");
/* 129 */     _sb_.append(this.kill_monsterid_2_count).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\SSynActivityResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */