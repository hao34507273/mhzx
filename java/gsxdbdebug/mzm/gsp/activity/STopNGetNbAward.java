/*     */ package mzm.gsp.activity;
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
/*     */ public class STopNGetNbAward
/*     */   extends __STopNGetNbAward__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587593;
/*     */   public long roleid;
/*     */   public int rank;
/*     */   public String rolename;
/*     */   public HashMap<Integer, Integer> items;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587593;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public STopNGetNbAward()
/*     */   {
/*  36 */     this.rolename = "";
/*  37 */     this.items = new HashMap();
/*     */   }
/*     */   
/*     */   public STopNGetNbAward(long _roleid_, int _rank_, String _rolename_, HashMap<Integer, Integer> _items_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.rank = _rank_;
/*  43 */     this.rolename = _rolename_;
/*  44 */     this.items = _items_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.rank);
/*  54 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  55 */     _os_.compact_uint32(this.items.size());
/*  56 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.roleid = _os_.unmarshal_long();
/*  65 */     this.rank = _os_.unmarshal_int();
/*  66 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof STopNGetNbAward)) {
/*  83 */       STopNGetNbAward _o_ = (STopNGetNbAward)_o1_;
/*  84 */       if (this.roleid != _o_.roleid) return false;
/*  85 */       if (this.rank != _o_.rank) return false;
/*  86 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  87 */       if (!this.items.equals(_o_.items)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.roleid;
/*  96 */     _h_ += this.rank;
/*  97 */     _h_ += this.rolename.hashCode();
/*  98 */     _h_ += this.items.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.roleid).append(",");
/* 106 */     _sb_.append(this.rank).append(",");
/* 107 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 108 */     _sb_.append(this.items).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\STopNGetNbAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */